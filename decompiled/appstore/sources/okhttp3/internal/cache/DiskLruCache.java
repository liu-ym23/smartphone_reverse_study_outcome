package okhttp3.internal.cache;

import fg.j;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes4.dex */
public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = null;
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable;
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    int redundantOpCount;
    private long size;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        final boolean[] written;

        public Editor(DiskLruCache r10, Entry r11) {
            this.this$0 = r10;
            this.entry = r11;
            if (r11.readable == false) goto L5;
            boolean[] r12 = null;
        L6:
            this.written = r12;
            return;
        L5:
            r12 = new boolean[r10.valueCount];
            goto L6
        }

        public void abort() throws IOException {
            DiskLruCache r10 = this.this$0;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L15;
            if (this.entry.currentEditor != this) goto L11;
            this.this$0.completeEdit(this, false);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L15:
            throw new IllegalStateException();     // Catch: Throwable -> L9
        }

        public void abortUnlessCommitted() {
            DiskLruCache r10 = this.this$0;
            monitor-enter(r10);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.done == false) goto L7;
        L12:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            if (this.entry.currentEditor != this) goto L12;
            this.this$0.completeEdit(this, false);     // Catch: Throwable -> L10 IOException -> L16
            goto L12
        }

        public void commit() throws IOException {
            DiskLruCache r10 = this.this$0;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L15;
            if (this.entry.currentEditor != this) goto L11;
            this.this$0.completeEdit(this, true);     // Catch: Throwable -> L9
        L11:
            this.done = true;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L15:
            throw new IllegalStateException();     // Catch: Throwable -> L9
        }

        public void detach() {
            if (this.entry.currentEditor != this) goto L16;
            int r10 = 0;
        L5:
            DiskLruCache r11 = this.this$0;
            if (r10 >= r11.valueCount) goto L9;
            r11.fileSystem.delete(this.entry.dirtyFiles[r10]);     // Catch: IOException -> L11
        L8:
            r10 = r10 + 1;
            goto L5
        L9:
            this.entry.currentEditor = null;
            return;
        }

        public Sink newSink(int r10) {
            DiskLruCache r11 = this.this$0;
            monitor-enter(r11);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L25;
            Entry r12 = this.entry;     // Catch: Throwable -> L11
            if (r12.currentEditor == this) goto L14;
            Sink r13 = j.b();     // Catch: Throwable -> L11
            monitor-exit(r11);     // Catch: Throwable -> L11
            return r13;
        L14:
            if (r12.readable == true) goto L16;
            this.written[r10] = true;     // Catch: Throwable -> L11
        L16:
            File r14 = r12.dirtyFiles[r10];     // Catch: Throwable -> L11
            final Sink r15 = this.this$0.fileSystem.sink(r14);     // Catch: Throwable -> L11 FileNotFoundException -> L21
            FaultHidingSink r16 = new AnonymousClass1(this, r15);     // Catch: Throwable -> L11
            monitor-exit(r11);     // Catch: Throwable -> L11
            return r16;
        L23:
            return j.b();
        L25:
            throw new IllegalStateException();     // Catch: Throwable -> L11
        }

        public Source newSource(int r10) {
            DiskLruCache r11 = this.this$0;
            monitor-enter(r11);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.done == true) goto L21;
            Entry r12 = this.entry;     // Catch: Throwable -> L14
            if (r12.readable == true) goto L9;
        L18:
            monitor-exit(r11);     // Catch: Throwable -> L14
            return null;
        L9:
            if (r12.currentEditor != this) goto L18;
            Source r13 = this.this$0.fileSystem.source(r12.cleanFiles[r10]);     // Catch: Throwable -> L14 FileNotFoundException -> L16
            monitor-exit(r11);     // Catch: Throwable -> L14
            return r13;
        L17:
            return null;
        L21:
            throw new IllegalStateException();     // Catch: Throwable -> L14
        }
    }

    public final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache r10, String r11) {
            this.this$0 = r10;
            this.key = r11;
            int r12 = r10.valueCount;
            this.lengths = new long[r12];
            this.cleanFiles = new File[r12];
            this.dirtyFiles = new File[r12];
            StringBuilder r13 = new StringBuilder(r11);
            r13.append('.');
            int r14 = r13.length();
            int r15 = 0;
        L4:
            if (r15 >= r10.valueCount) goto L6;
            r13.append(r15);
            this.cleanFiles[r15] = new File(r10.directory, r13.toString());
            r13.append(".tmp");
            this.dirtyFiles[r15] = new File(r10.directory, r13.toString());
            r13.setLength(r14);
            r15 = r15 + 1;
            goto L4
        }

        private IOException invalidLengths(String[] r10) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r10));
        }

        public void setLengths(String[] r10) throws IOException {
            if (r10.length != this.this$0.valueCount) goto L13;
            int r11 = 0;
        L14:
            if (r11 >= r10.length) goto L9;
            this.lengths[r11] = Long.parseLong(r10[r11]);     // Catch: NumberFormatException -> L10
            r11 = r11 + 1;
            goto L14
        L9:
            return;
        L11:
            throw invalidLengths(r10);
        L13:
            throw invalidLengths(r10);
        }

        public Snapshot snapshot() {
            if (Thread.holdsLock(this.this$0) == false) goto L19;
            Source[] r10 = new Source[this.this$0.valueCount];
            long[] r11 = (long[]) this.lengths.clone();
            int r12 = 0;
            int r13 = 0;
        L24:
            DiskLruCache r14 = this.this$0;     // Catch: FileNotFoundException -> L20
            if (r13 >= r14.valueCount) goto L8;
            r10[r13] = r14.fileSystem.source(this.cleanFiles[r13]);     // Catch: FileNotFoundException -> L20
            r13 = r13 + 1;     // Catch: FileNotFoundException -> L20
            goto L24
        L8:
            return new Snapshot(r14, this.key, this.sequenceNumber, r10, r11);
        L10:
            DiskLruCache r15 = this.this$0;
            if (r12 >= r15.valueCount) goto L22;
            Source r16 = r10[r12];
            if (r16 == null) goto L22;
            Util.closeQuietly(r16);
            r12 = r12 + 1;
        L22:
            r15.removeEntry(this);     // Catch: IOException -> L21
            return null;
        L27:
            return null;
        L19:
            throw new AssertionError();
        }

        public void writeLengths(BufferedSink r10) throws IOException {
            long[] r11 = this.lengths;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            long r14 = r11[r13];
            r10.writeByte(32).writeDecimalLong(r14);
            r13 = r13 + 1;
            goto L3
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;
        final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache r10, String r11, long r12, Source[] r13, long[] r14) {
            this.this$0 = r10;
            this.key = r11;
            this.sequenceNumber = r12;
            this.sources = r13;
            this.lengths = r14;
        }

        public static /* synthetic */ String access$000(Snapshot r10) {
            return r10.key;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Source[] r10 = this.sources;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            Util.closeQuietly(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        @Nullable
        public Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int r10) {
            return this.lengths[r10];
        }

        public Source getSource(int r10) {
            return this.sources[r10];
        }

        public String key() {
            return this.key;
        }
    }

    static {
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    public DiskLruCache(FileSystem r10, File r11, int r12, int r13, long r14, Executor r15) {
        this.size = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.cleanupRunnable = new AnonymousClass1(this);
        this.fileSystem = r10;
        this.directory = r11;
        this.appVersion = r12;
        this.journalFile = new File(r11, JOURNAL_FILE);
        this.journalFileTmp = new File(r11, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r11, JOURNAL_FILE_BACKUP);
        this.valueCount = r13;
        this.maxSize = r14;
        this.executor = r15;
    }

    private synchronized void checkNotClosed() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (isClosed() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new IllegalStateException("cache is closed");     // Catch: Throwable -> L9
    }

    public static DiskLruCache create(FileSystem r10, File r11, int r12, int r13, long r14) {
        if (r14 <= 0) goto L10;
        if (r13 <= 0) goto L8;
        return new DiskLruCache(r10, r11, r12, r13, r14, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
    L8:
        throw new IllegalArgumentException("valueCount <= 0");
    L10:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        final Sink r10 = this.fileSystem.appendingSink(this.journalFile);
        return j.c(new AnonymousClass2(this, r10));
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> r10 = this.lruEntries.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        Entry r11 = r10.next();
        int r12 = 0;
        if (r11.currentEditor == null) goto L8;
        r11.currentEditor = null;
    L12:
        if (r12 >= this.valueCount) goto L14;
        this.fileSystem.delete(r11.cleanFiles[r12]);
        this.fileSystem.delete(r11.dirtyFiles[r12]);
        r12 = r12 + 1;
        goto L12
    L14:
        r10.remove();
    L8:
        if (r12 >= this.valueCount) goto L4;
        this.size += r11.lengths[r12];
        r12 = r12 + 1;
        goto L8
    }

    private void readJournal() throws IOException {
        BufferedSource r10 = j.d(this.fileSystem.source(this.journalFile));
        String r11 = r10.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r12 = r10.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r13 = r10.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r14 = r10.readUtf8LineStrict();     // Catch: Throwable -> L16
        String r15 = r10.readUtf8LineStrict();     // Catch: Throwable -> L16
        if (MAGIC.equals(r11) == false) goto L25;
        if ("1".equals(r12) == false) goto L25;
        if (Integer.toString(this.appVersion).equals(r13) == false) goto L25;
        if (Integer.toString(this.valueCount).equals(r14) == false) goto L25;
        if ("".equals(r15) == false) goto L25;
        int r16 = 0;
    L28:
        readJournalLine(r10.readUtf8LineStrict());     // Catch: Throwable -> L16 EOFException -> L18
        r16 = r16 + 1;
        goto L28
    L18:
        this.redundantOpCount = r16 - this.lruEntries.size();     // Catch: Throwable -> L16
        if (r10.exhausted() == true) goto L21;
        rebuildJournal();     // Catch: Throwable -> L16
    L22:
        Util.closeQuietly(r10);
        return;
    L21:
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L16
    L25:
        throw new IOException("unexpected journal header: [" + r11 + ", " + r12 + ", " + r14 + ", " + r15 + "]");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Util.closeQuietly(r10);
        throw th;
    }

    private void readJournalLine(String r10) throws IOException {
        int r11 = r10.indexOf(32);
        if (r11 == (-1)) goto L36;
        int r12 = r11 + 1;
        int r13 = r10.indexOf(32, r12);
        if (r13 != (-1)) goto L12;
        String r14 = r10.substring(r12);
        if (r11 == 6) goto L9;
    L13:
        Entry r15 = this.lruEntries.get(r14);
        if (r15 != null) goto L17;
        r15 = new Entry(this, r14);
        this.lruEntries.put(r14, r15);
    L17:
        if (r13 == (-1)) goto L22;
        if (r11 != 5) goto L22;
        if (r10.startsWith(CLEAN) == false) goto L22;
        String[] r16 = r10.substring(r13 + 1).split(" ");
        r15.readable = true;
        r15.currentEditor = null;
        r15.setLengths(r16);
        return;
    L22:
        if (r13 != (-1)) goto L27;
        if (r11 != 5) goto L27;
        if (r10.startsWith(DIRTY) == false) goto L27;
        r15.currentEditor = new Editor(this, r15);
        return;
    L27:
        if (r13 != (-1)) goto L34;
        if (r11 != 4) goto L34;
        if (r10.startsWith(READ) == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: " + r10);
    L9:
        if (r10.startsWith(REMOVE) == false) goto L13;
        this.lruEntries.remove(r14);
        return;
    L12:
        r14 = r10.substring(r12, r13);
        goto L13
    L36:
        throw new IOException("unexpected journal line: " + r10);
    }

    private void validateKey(String r10) {
        if (LEGAL_KEY_PATTERN.matcher(r10).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r10 + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L6;
    L19:
        this.closed = true;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if (this.closed == true) goto L19;
        Entry[] r10 = (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);     // Catch: Throwable -> L13
        int r11 = r10.length;     // Catch: Throwable -> L13
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L16;
        Editor r13 = r10[r12].currentEditor;     // Catch: Throwable -> L13
        if (r13 == null) goto L15;
        r13.abort();     // Catch: Throwable -> L13
    L15:
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L9
    L16:
        trimToSize();     // Catch: Throwable -> L13
        this.journalWriter.close();     // Catch: Throwable -> L13
        this.journalWriter = null;     // Catch: Throwable -> L13
        this.closed = true;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public synchronized void completeEdit(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Entry r12 = r10.entry;     // Catch: Throwable -> L19
        if (r12.currentEditor != r10) goto L47;
        int r13 = 0;
        if (r11 == false) goto L25;
        if (r12.readable == true) goto L25;
        int r14 = 0;
    L11:
        if (r14 >= this.valueCount) goto L25;
        if (r10.written[r14] == false) goto L22;
        if (this.fileSystem.exists(r12.dirtyFiles[r14]) == false) goto L16;
        r14 = r14 + 1;
        goto L11
    L16:
        r10.abort();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L22:
        r10.abort();     // Catch: Throwable -> L19
        throw new IllegalStateException("Newly created entry didn't create value for index " + r14);     // Catch: Throwable -> L19
    L25:
        if (r13 >= this.valueCount) goto L33;
        File r15 = r12.dirtyFiles[r13];     // Catch: Throwable -> L19
        if (r11 == true) goto L29;
        this.fileSystem.delete(r15);     // Catch: Throwable -> L19
    L32:
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L25
    L29:
        if (this.fileSystem.exists(r15) == false) goto L32;
        File r16 = r12.cleanFiles[r13];     // Catch: Throwable -> L19
        this.fileSystem.rename(r15, r16);     // Catch: Throwable -> L19
        long r17 = r12.lengths[r13];     // Catch: Throwable -> L19
        long r18 = this.fileSystem.size(r16);     // Catch: Throwable -> L19
        r12.lengths[r13] = r18;     // Catch: Throwable -> L19
        this.size = (this.size - r17) + r18;     // Catch: Throwable -> L19
        goto L32
    L33:
        this.redundantOpCount++;     // Catch: Throwable -> L19
        r12.currentEditor = null;     // Catch: Throwable -> L19
        if ((r12.readable | r11) == false) goto L38;
        r12.readable = true;     // Catch: Throwable -> L19
        this.journalWriter.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L19
        this.journalWriter.writeUtf8(r12.key);     // Catch: Throwable -> L19
        r12.writeLengths(this.journalWriter);     // Catch: Throwable -> L19
        this.journalWriter.writeByte(10);     // Catch: Throwable -> L19
        if (r11 == false) goto L39;
        long r19 = this.nextSequenceNumber;     // Catch: Throwable -> L19
        this.nextSequenceNumber = 1 + r19;     // Catch: Throwable -> L19
        r12.sequenceNumber = r19;     // Catch: Throwable -> L19
    L39:
        this.journalWriter.flush();     // Catch: Throwable -> L19
        if (this.size <= this.maxSize) goto L42;
    L43:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L19
    L44:
        monitor-exit(this);
        return;
    L42:
        if (journalRebuildRequired() == false) goto L44;
    L38:
        this.lruEntries.remove(r12.key);     // Catch: Throwable -> L19
        this.journalWriter.writeUtf8(REMOVE).writeByte(32);     // Catch: Throwable -> L19
        this.journalWriter.writeUtf8(r12.key);     // Catch: Throwable -> L19
        this.journalWriter.writeByte(10);     // Catch: Throwable -> L19
        goto L39
    L47:
        throw new IllegalStateException();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @Nullable
    public Editor edit(String r10) throws IOException {
        return edit(r10, -1);
    }

    public synchronized void evictAll() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        Entry[] r10 = (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);     // Catch: Throwable -> L6
        int r11 = r10.length;     // Catch: Throwable -> L6
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L8;
        removeEntry(r10[r12]);     // Catch: Throwable -> L6
        r12 = r12 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        checkNotClosed();     // Catch: Throwable -> L10
        trimToSize();     // Catch: Throwable -> L10
        this.journalWriter.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized Snapshot get(String r10) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L16
        checkNotClosed();     // Catch: Throwable -> L16
        validateKey(r10);     // Catch: Throwable -> L16
        Entry r11 = this.lruEntries.get(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L6;
    L20:
        monitor-exit(this);
        return null;
    L6:
        if (r11.readable == false) goto L20;
        Snapshot r12 = r11.snapshot();     // Catch: Throwable -> L16
        if (r12 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.redundantOpCount++;     // Catch: Throwable -> L16
        this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(r10).writeByte(10);     // Catch: Throwable -> L16
        if (journalRebuildRequired() == false) goto L18;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L16
    L18:
        monitor-exit(this);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        monitor-enter(this);
        long r10 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void initialize() throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.initialized == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.fileSystem.exists(this.journalFileBackup) == false) goto L17;
        if (this.fileSystem.exists(this.journalFile) == false) goto L14;
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L12
        goto L17
    L14:
        this.fileSystem.rename(this.journalFileBackup, this.journalFile);     // Catch: Throwable -> L12
    L17:
        if (this.fileSystem.exists(this.journalFile) == true) goto L35;
    L29:
        rebuildJournal();     // Catch: Throwable -> L12
        this.initialized = true;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L35:
        readJournal();     // Catch: Throwable -> L12 IOException -> L21
        processJournal();     // Catch: Throwable -> L12 IOException -> L21
        this.initialized = true;     // Catch: Throwable -> L12 IOException -> L21
        monitor-exit(this);
        return;
    L21:
        e = move-exception;
        Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);     // Catch: Throwable -> L12
        delete();     // Catch: Throwable -> L26
        this.closed = false;     // Catch: Throwable -> L12
        goto L29
    L26:
        th = move-exception;
        this.closed = false;     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    }

    public synchronized boolean isClosed() {
        monitor-enter(this);
        boolean r10 = this.closed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean journalRebuildRequired() {
        int r10 = this.redundantOpCount;
        if (r10 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r10 < this.lruEntries.size()) goto L7;
        return true;
    }

    public synchronized void rebuildJournal() throws IOException {
        monitor-enter(this);
        BufferedSink r10 = this.journalWriter;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L6
    L8:
        BufferedSink r11 = j.c(this.fileSystem.sink(this.journalFileTmp));     // Catch: Throwable -> L6
        r11.writeUtf8(MAGIC).writeByte(10);     // Catch: Throwable -> L15
        r11.writeUtf8("1").writeByte(10);     // Catch: Throwable -> L15
        r11.writeDecimalLong(this.appVersion).writeByte(10);     // Catch: Throwable -> L15
        r11.writeDecimalLong(this.valueCount).writeByte(10);     // Catch: Throwable -> L15
        r11.writeByte(10);     // Catch: Throwable -> L15
        Iterator<Entry> r12 = this.lruEntries.values().iterator();     // Catch: Throwable -> L15
    L10:
        if (r12.hasNext() == false) goto L19;
        Entry r13 = r12.next();     // Catch: Throwable -> L15
        if (r13.currentEditor != null) goto L14;
        r11.writeUtf8(CLEAN).writeByte(32);     // Catch: Throwable -> L15
        r11.writeUtf8(r13.key);     // Catch: Throwable -> L15
        r13.writeLengths(r11);     // Catch: Throwable -> L15
        r11.writeByte(10);     // Catch: Throwable -> L15
        goto L10
    L14:
        r11.writeUtf8(DIRTY).writeByte(32);     // Catch: Throwable -> L15
        r11.writeUtf8(r13.key);     // Catch: Throwable -> L15
        r11.writeByte(10);     // Catch: Throwable -> L15
        goto L10
    L19:
        r11.close();     // Catch: Throwable -> L6
        if (this.fileSystem.exists(this.journalFile) == false) goto L22;
        this.fileSystem.rename(this.journalFile, this.journalFileBackup);     // Catch: Throwable -> L6
    L22:
        this.fileSystem.rename(this.journalFileTmp, this.journalFile);     // Catch: Throwable -> L6
        this.fileSystem.delete(this.journalFileBackup);     // Catch: Throwable -> L6
        this.journalWriter = newJournalWriter();     // Catch: Throwable -> L6
        this.hasJournalErrors = false;     // Catch: Throwable -> L6
        this.mostRecentRebuildFailed = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean remove(String r10) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L14
        checkNotClosed();     // Catch: Throwable -> L14
        validateKey(r10);     // Catch: Throwable -> L14
        Entry r11 = this.lruEntries.get(r10);     // Catch: Throwable -> L14
        if (r11 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r12 = removeEntry(r11);     // Catch: Throwable -> L14
        if (r12 == true) goto L11;
    L16:
        monitor-exit(this);
        return r12;
    L11:
        if (this.size > this.maxSize) goto L16;
        this.mostRecentTrimFailed = false;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public boolean removeEntry(Entry r10) throws IOException {
        Editor r11 = r10.currentEditor;
        if (r11 == null) goto L5;
        r11.detach();
    L5:
        int r12 = 0;
    L7:
        if (r12 >= this.valueCount) goto L9;
        this.fileSystem.delete(r10.cleanFiles[r12]);
        long r13 = this.size;
        long[] r14 = r10.lengths;
        this.size = r13 - r14[r12];
        r14[r12] = 0;
        r12 = r12 + 1;
        goto L7
    L9:
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(r10.key).writeByte(10);
        this.lruEntries.remove(r10.key);
        if (journalRebuildRequired() == false) goto L12;
        this.executor.execute(this.cleanupRunnable);
    L12:
        return true;
    }

    public synchronized void setMaxSize(long r10) {
        monitor-enter(this);
        this.maxSize = r10;     // Catch: Throwable -> L7
        if (this.initialized == false) goto L9;
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized long size() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        long r10 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L6
        Iterator<Snapshot> r10 = new AnonymousClass3(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L5;
        removeEntry(this.lruEntries.values().iterator().next());
        goto L3
    L5:
        this.mostRecentTrimFailed = false;
    }

    public synchronized Editor edit(String r10, long r11) throws IOException {
        monitor-enter(this);
        initialize();     // Catch: Throwable -> L10
        checkNotClosed();     // Catch: Throwable -> L10
        validateKey(r10);     // Catch: Throwable -> L10
        Entry r12 = this.lruEntries.get(r10);     // Catch: Throwable -> L10
        if (r11 == (-1)) goto L14;
        if (r12 != null) goto L8;
    L12:
        monitor-exit(this);
        return null;
    L8:
        if (r12.sequenceNumber != r11) goto L12;
    L14:
        if (r12 == null) goto L20;
        if (r12.currentEditor == null) goto L20;
        monitor-exit(this);
        return null;
    L20:
        if (this.mostRecentTrimFailed == false) goto L22;
    L33:
        this.executor.execute(this.cleanupRunnable);     // Catch: Throwable -> L10
        monitor-exit(this);
        return null;
    L22:
        if (this.mostRecentRebuildFailed == true) goto L33;
        this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(r10).writeByte(10);     // Catch: Throwable -> L10
        this.journalWriter.flush();     // Catch: Throwable -> L10
        if (this.hasJournalErrors == false) goto L28;
        monitor-exit(this);
        return null;
    L28:
        if (r12 != null) goto L30;
        r12 = new Entry(this, r10);     // Catch: Throwable -> L10
        this.lruEntries.put(r10, r12);     // Catch: Throwable -> L10
    L30:
        Editor r13 = new Editor(this, r12);     // Catch: Throwable -> L10
        r12.currentEditor = r13;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r13;
    L10:
        th = move-exception;
        throw th;
    }
}
