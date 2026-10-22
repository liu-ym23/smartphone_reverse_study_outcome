package com.bumptech.glide.disklrucache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable;
    private final File directory;
    final ThreadPoolExecutor executorService;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    public static final class DiskLruCacheThreadFactory implements ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable r10) {
            monitor-enter(this);
            Thread r11 = new Thread(r10, "glide-disk-lru-cache-thread");     // Catch: Throwable -> L6
            r11.setPriority(1);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r11;
        L6:
            th = move-exception;
            throw th;
        }

        public /* synthetic */ DiskLruCacheThreadFactory(AnonymousClass1 r10) {
            this();
        }
    }

    public final class Editor {
        private boolean committed;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public /* synthetic */ Editor(DiskLruCache r10, Entry r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public static /* synthetic */ Entry access$1500(Editor r10) {
            return r10.entry;
        }

        public static /* synthetic */ boolean[] access$1600(Editor r10) {
            return r10.written;
        }

        private InputStream newInputStream(int r10) throws IOException {
            DiskLruCache r11 = this.this$0;
            monitor-enter(r11);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$800(this.entry) != this) goto L18;
            if (Entry.access$700(this.entry) == true) goto L21;
            monitor-exit(r11);     // Catch: Throwable -> L10
            return null;
        L21:
            FileInputStream r12 = new FileInputStream(this.entry.getCleanFile(r10));     // Catch: Throwable -> L10 FileNotFoundException -> L15
            monitor-exit(r11);     // Catch: Throwable -> L10
            return r12;
        L16:
            return null;
        L18:
            throw new IllegalStateException();     // Catch: Throwable -> L10
        }

        public void abort() throws IOException {
            DiskLruCache.access$2100(this.this$0, this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed == true) goto L9;
            abort();     // Catch: IOException -> L6
            return;
        L10:
            return;
        }

        public void commit() throws IOException {
            DiskLruCache.access$2100(this.this$0, this, true);
            this.committed = true;
        }

        public File getFile(int r10) throws IOException {
            DiskLruCache r11 = this.this$0;
            monitor-enter(r11);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (Entry.access$800(this.entry) != this) goto L17;
            if (Entry.access$700(this.entry) == true) goto L11;
            this.written[r10] = true;     // Catch: Throwable -> L9
        L11:
            File r12 = this.entry.getDirtyFile(r10);     // Catch: Throwable -> L9
            if (DiskLruCache.access$2000(this.this$0).exists() == true) goto L14;
            DiskLruCache.access$2000(this.this$0).mkdirs();     // Catch: Throwable -> L9
        L14:
            monitor-exit(r11);     // Catch: Throwable -> L9
            return r12;
        L17:
            throw new IllegalStateException();     // Catch: Throwable -> L9
        }

        public String getString(int r10) throws IOException {
            InputStream r11 = newInputStream(r10);
            if (r11 != null) goto L7;
            return null;
        L7:
            return DiskLruCache.access$1800(r11);
        }

        public void set(int r10, String r11) throws IOException {
            OutputStreamWriter r12 = null;
            OutputStreamWriter r13 = new OutputStreamWriter(new FileOutputStream(getFile(r10)), Util.UTF_8);     // Catch: Throwable -> L9
            r13.write(r11);     // Catch: Throwable -> L7
            Util.closeQuietly(r13);
            return;
        L7:
            th = th;
            r12 = r13;
        L10:
            Util.closeQuietly(r12);
            throw th;
        L9:
            th = th;
            goto L10
        }

        private Editor(DiskLruCache r10, Entry r11) {
            this.this$0 = r10;
            this.entry = r11;
            if (Entry.access$700(r11) == false) goto L5;
            boolean[] r12 = null;
        L6:
            this.written = r12;
            return;
        L5:
            r12 = new boolean[DiskLruCache.access$1900(r10)];
            goto L6
        }
    }

    public final class Entry {
        File[] cleanFiles;
        private Editor currentEditor;
        File[] dirtyFiles;
        private final String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public /* synthetic */ Entry(DiskLruCache r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public static /* synthetic */ long[] access$1100(Entry r10) {
            return r10.lengths;
        }

        public static /* synthetic */ String access$1200(Entry r10) {
            return r10.key;
        }

        public static /* synthetic */ long access$1300(Entry r10) {
            return r10.sequenceNumber;
        }

        public static /* synthetic */ long access$1302(Entry r10, long r11) {
            r10.sequenceNumber = r11;
            return r11;
        }

        public static /* synthetic */ boolean access$700(Entry r10) {
            return r10.readable;
        }

        public static /* synthetic */ boolean access$702(Entry r10, boolean r11) {
            r10.readable = r11;
            return r11;
        }

        public static /* synthetic */ Editor access$800(Entry r10) {
            return r10.currentEditor;
        }

        public static /* synthetic */ Editor access$802(Entry r10, Editor r11) {
            r10.currentEditor = r11;
            return r11;
        }

        public static /* synthetic */ void access$900(Entry r10, String[] r11) throws IOException {
            r10.setLengths(r11);
        }

        private IOException invalidLengths(String[] r10) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r10));
        }

        private void setLengths(String[] r10) throws IOException {
            if (r10.length != DiskLruCache.access$1900(this.this$0)) goto L13;
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

        public File getCleanFile(int r10) {
            return this.cleanFiles[r10];
        }

        public File getDirtyFile(int r10) {
            return this.dirtyFiles[r10];
        }

        public String getLengths() throws IOException {
            StringBuilder r10 = new StringBuilder();
            long[] r11 = this.lengths;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L6;
            long r14 = r11[r13];
            r10.append(TokenParser.SP);
            r10.append(r14);
            r13 = r13 + 1;
            goto L3
        L6:
            return r10.toString();
        }

        private Entry(DiskLruCache r10, String r11) {
            this.this$0 = r10;
            this.key = r11;
            this.lengths = new long[DiskLruCache.access$1900(r10)];
            this.cleanFiles = new File[DiskLruCache.access$1900(r10)];
            this.dirtyFiles = new File[DiskLruCache.access$1900(r10)];
            StringBuilder r12 = new StringBuilder(r11);
            r12.append('.');
            int r13 = r12.length();
            int r14 = 0;
        L4:
            if (r14 >= DiskLruCache.access$1900(r10)) goto L6;
            r12.append(r14);
            this.cleanFiles[r14] = new File(DiskLruCache.access$2000(r10), r12.toString());
            r12.append(".tmp");
            this.dirtyFiles[r14] = new File(DiskLruCache.access$2000(r10), r12.toString());
            r12.setLength(r13);
            r14 = r14 + 1;
            goto L4
        }
    }

    public final class Value {
        private final File[] files;
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public /* synthetic */ Value(DiskLruCache r10, String r11, long r12, File[] r13, long[] r14, AnonymousClass1 r15) {
            this(r10, r11, r12, r13, r14);
        }

        public Editor edit() throws IOException {
            return DiskLruCache.access$1700(this.this$0, this.key, this.sequenceNumber);
        }

        public File getFile(int r10) {
            return this.files[r10];
        }

        public long getLength(int r10) {
            return this.lengths[r10];
        }

        public String getString(int r10) throws IOException {
            return DiskLruCache.access$1800(new FileInputStream(this.files[r10]));
        }

        private Value(DiskLruCache r10, String r11, long r12, File[] r13, long[] r14) {
            this.this$0 = r10;
            this.key = r11;
            this.sequenceNumber = r12;
            this.files = r13;
            this.lengths = r14;
        }
    }

    private DiskLruCache(File r17, int r18, int r19, long r20) {
        this.size = 0;
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.nextSequenceNumber = 0;
        this.executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DiskLruCacheThreadFactory(null));
        this.cleanupCallable = new AnonymousClass1(this);
        this.directory = r17;
        this.appVersion = r18;
        this.journalFile = new File(r17, JOURNAL_FILE);
        this.journalFileTmp = new File(r17, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(r17, JOURNAL_FILE_BACKUP);
        this.valueCount = r19;
        this.maxSize = r20;
    }

    public static /* synthetic */ Writer access$100(DiskLruCache r10) {
        return r10.journalWriter;
    }

    public static /* synthetic */ Editor access$1700(DiskLruCache r10, String r11, long r12) throws IOException {
        return r10.edit(r11, r12);
    }

    public static /* synthetic */ String access$1800(InputStream r10) throws IOException {
        return inputStreamToString(r10);
    }

    public static /* synthetic */ int access$1900(DiskLruCache r10) {
        return r10.valueCount;
    }

    public static /* synthetic */ void access$200(DiskLruCache r10) throws IOException {
        r10.trimToSize();
    }

    public static /* synthetic */ File access$2000(DiskLruCache r10) {
        return r10.directory;
    }

    public static /* synthetic */ void access$2100(DiskLruCache r10, Editor r11, boolean r12) throws IOException {
        r10.completeEdit(r11, r12);
    }

    public static /* synthetic */ boolean access$300(DiskLruCache r10) {
        return r10.journalRebuildRequired();
    }

    public static /* synthetic */ void access$400(DiskLruCache r10) throws IOException {
        r10.rebuildJournal();
    }

    public static /* synthetic */ int access$502(DiskLruCache r10, int r11) {
        r10.redundantOpCount = r11;
        return r11;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private synchronized void completeEdit(Editor r10, boolean r11) throws IOException {
        monitor-enter(this);
        Entry r12 = Editor.access$1500(r10);     // Catch: Throwable -> L19
        if (Entry.access$800(r12) != r10) goto L47;
        int r13 = 0;
        if (r11 == false) goto L25;
        if (Entry.access$700(r12) == true) goto L25;
        int r14 = 0;
    L11:
        if (r14 >= this.valueCount) goto L25;
        if (Editor.access$1600(r10)[r14] == false) goto L22;
        if (r12.getDirtyFile(r14).exists() == false) goto L16;
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
        File r15 = r12.getDirtyFile(r13);     // Catch: Throwable -> L19
        if (r11 == true) goto L29;
        deleteIfExists(r15);     // Catch: Throwable -> L19
    L32:
        r13 = r13 + 1;     // Catch: Throwable -> L19
        goto L25
    L29:
        if (r15.exists() == false) goto L32;
        File r16 = r12.getCleanFile(r13);     // Catch: Throwable -> L19
        r15.renameTo(r16);     // Catch: Throwable -> L19
        long r17 = Entry.access$1100(r12)[r13];     // Catch: Throwable -> L19
        long r18 = r16.length();     // Catch: Throwable -> L19
        Entry.access$1100(r12)[r13] = r18;     // Catch: Throwable -> L19
        this.size = (this.size - r17) + r18;     // Catch: Throwable -> L19
        goto L32
    L33:
        this.redundantOpCount++;     // Catch: Throwable -> L19
        Entry.access$802(r12, null);     // Catch: Throwable -> L19
        if ((Entry.access$700(r12) | r11) == false) goto L38;
        Entry.access$702(r12, true);     // Catch: Throwable -> L19
        this.journalWriter.append(CLEAN);     // Catch: Throwable -> L19
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L19
        this.journalWriter.append(Entry.access$1200(r12));     // Catch: Throwable -> L19
        this.journalWriter.append(r12.getLengths());     // Catch: Throwable -> L19
        this.journalWriter.append('\n');     // Catch: Throwable -> L19
        if (r11 == false) goto L39;
        long r19 = this.nextSequenceNumber;     // Catch: Throwable -> L19
        this.nextSequenceNumber = 1 + r19;     // Catch: Throwable -> L19
        Entry.access$1302(r12, r19);     // Catch: Throwable -> L19
    L39:
        this.journalWriter.flush();     // Catch: Throwable -> L19
        if (this.size <= this.maxSize) goto L42;
    L43:
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L19
    L44:
        monitor-exit(this);
        return;
    L42:
        if (journalRebuildRequired() == false) goto L44;
    L38:
        this.lruEntries.remove(Entry.access$1200(r12));     // Catch: Throwable -> L19
        this.journalWriter.append(REMOVE);     // Catch: Throwable -> L19
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L19
        this.journalWriter.append(Entry.access$1200(r12));     // Catch: Throwable -> L19
        this.journalWriter.append('\n');     // Catch: Throwable -> L19
        goto L39
    L47:
        throw new IllegalStateException();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private static void deleteIfExists(File r10) throws IOException {
        if (r10.exists() == true) goto L5;
        return;
    L5:
        if (r10.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static String inputStreamToString(InputStream r10) throws IOException {
        return Util.readFully(new InputStreamReader(r10, Util.UTF_8));
    }

    private boolean journalRebuildRequired() {
        int r10 = this.redundantOpCount;
        if (r10 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r10 < this.lruEntries.size()) goto L7;
        return true;
    }

    public static DiskLruCache open(File r10, int r11, int r12, long r13) throws IOException {
        if (r13 <= 0) goto L22;
        if (r12 <= 0) goto L20;
        File r14 = new File(r10, JOURNAL_FILE_BACKUP);
        if (r14.exists() == false) goto L11;
        File r15 = new File(r10, JOURNAL_FILE);
        if (r15.exists() == false) goto L10;
        r14.delete();
        goto L11
    L10:
        renameTo(r14, r15, false);
    L11:
        DiskLruCache r16 = new DiskLruCache(r10, r11, r12, r13);
        if (r16.journalFile.exists() == true) goto L23;
    L17:
        r10.mkdirs();
        DiskLruCache r17 = new DiskLruCache(r10, r11, r12, r13);
        r17.rebuildJournal();
        return r17;
    L23:
        r16.readJournal();     // Catch: IOException -> L15
        r16.processJournal();     // Catch: IOException -> L15
        return r16;
    L15:
        e = move-exception;
        System.out.println("DiskLruCache " + r10 + " is corrupt: " + e.getMessage() + ", removing");
        r16.delete();
        goto L17
    L20:
        throw new IllegalArgumentException("valueCount <= 0");
    L22:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> r10 = this.lruEntries.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        Entry r11 = r10.next();
        int r12 = 0;
        if (Entry.access$800(r11) == null) goto L8;
        Entry.access$802(r11, null);
    L12:
        if (r12 >= this.valueCount) goto L14;
        deleteIfExists(r11.getCleanFile(r12));
        deleteIfExists(r11.getDirtyFile(r12));
        r12 = r12 + 1;
        goto L12
    L14:
        r10.remove();
    L8:
        if (r12 >= this.valueCount) goto L4;
        this.size += Entry.access$1100(r11)[r12];
        r12 = r12 + 1;
        goto L8
    }

    private void readJournal() throws IOException {
        StrictLineReader r10 = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        String r11 = r10.readLine();     // Catch: Throwable -> L16
        String r12 = r10.readLine();     // Catch: Throwable -> L16
        String r13 = r10.readLine();     // Catch: Throwable -> L16
        String r14 = r10.readLine();     // Catch: Throwable -> L16
        String r15 = r10.readLine();     // Catch: Throwable -> L16
        if (MAGIC.equals(r11) == false) goto L25;
        if ("1".equals(r12) == false) goto L25;
        if (Integer.toString(this.appVersion).equals(r13) == false) goto L25;
        if (Integer.toString(this.valueCount).equals(r14) == false) goto L25;
        if ("".equals(r15) == false) goto L25;
        int r16 = 0;
    L28:
        readJournalLine(r10.readLine());     // Catch: Throwable -> L16 EOFException -> L18
        r16 = r16 + 1;
        goto L28
    L18:
        this.redundantOpCount = r16 - this.lruEntries.size();     // Catch: Throwable -> L16
        if (r10.hasUnterminatedLine() == false) goto L21;
        rebuildJournal();     // Catch: Throwable -> L16
    L22:
        Util.closeQuietly(r10);
        return;
    L21:
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L16
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
        AnonymousClass1 r16 = null;
        if (r15 != null) goto L17;
        r15 = new Entry(this, r14, r16);
        this.lruEntries.put(r14, r15);
    L17:
        if (r13 == (-1)) goto L22;
        if (r11 != 5) goto L22;
        if (r10.startsWith(CLEAN) == false) goto L22;
        String[] r17 = r10.substring(r13 + 1).split(" ");
        Entry.access$702(r15, true);
        Entry.access$802(r15, null);
        Entry.access$900(r15, r17);
        return;
    L22:
        if (r13 != (-1)) goto L27;
        if (r11 != 5) goto L27;
        if (r10.startsWith(DIRTY) == false) goto L27;
        Entry.access$802(r15, new Editor(this, r15, r16));
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

    private synchronized void rebuildJournal() throws IOException {
        monitor-enter(this);
        Writer r10 = this.journalWriter;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.close();     // Catch: Throwable -> L6
    L8:
        BufferedWriter r11 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));     // Catch: Throwable -> L6
        r11.write(MAGIC);     // Catch: Throwable -> L15
        r11.write("\n");     // Catch: Throwable -> L15
        r11.write("1");     // Catch: Throwable -> L15
        r11.write("\n");     // Catch: Throwable -> L15
        r11.write(Integer.toString(this.appVersion));     // Catch: Throwable -> L15
        r11.write("\n");     // Catch: Throwable -> L15
        r11.write(Integer.toString(this.valueCount));     // Catch: Throwable -> L15
        r11.write("\n");     // Catch: Throwable -> L15
        r11.write("\n");     // Catch: Throwable -> L15
        Iterator<Entry> r12 = this.lruEntries.values().iterator();     // Catch: Throwable -> L15
    L10:
        if (r12.hasNext() == false) goto L19;
        Entry r13 = r12.next();     // Catch: Throwable -> L15
        if (Entry.access$800(r13) != null) goto L14;
        r11.write("CLEAN " + Entry.access$1200(r13) + r13.getLengths() + '\n');     // Catch: Throwable -> L15
        goto L10
    L14:
        r11.write("DIRTY " + Entry.access$1200(r13) + '\n');     // Catch: Throwable -> L15
        goto L10
    L19:
        r11.close();     // Catch: Throwable -> L6
        if (this.journalFile.exists() == false) goto L22;
        renameTo(this.journalFile, this.journalFileBackup, true);     // Catch: Throwable -> L6
    L22:
        renameTo(this.journalFileTmp, this.journalFile, false);     // Catch: Throwable -> L6
        this.journalFileBackup.delete();     // Catch: Throwable -> L6
        this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));     // Catch: Throwable -> L6
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

    private static void renameTo(File r10, File r11, boolean r12) throws IOException {
        if (r12 == false) goto L5;
        deleteIfExists(r11);
    L5:
        if (r10.renameTo(r11) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private void trimToSize() throws IOException {
    L3:
        if (this.size <= this.maxSize) goto L5;
        remove(this.lruEntries.entrySet().iterator().next().getKey());
        goto L3
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.journalWriter != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r10 = new ArrayList(this.lruEntries.values()).iterator();     // Catch: Throwable -> L13
    L9:
        if (r10.hasNext() == false) goto L15;
        Entry r11 = (Entry) r10.next();     // Catch: Throwable -> L13
        if (Entry.access$800(r11) == null) goto L9;
        Entry.access$800(r11).abort();     // Catch: Throwable -> L13
        goto L9
    L15:
        trimToSize();     // Catch: Throwable -> L13
        this.journalWriter.close();     // Catch: Throwable -> L13
        this.journalWriter = null;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public void delete() throws IOException {
        close();
        Util.deleteContents(this.directory);
    }

    public Editor edit(String r10) throws IOException {
        return edit(r10, -1);
    }

    public synchronized void flush() throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L6
        trimToSize();     // Catch: Throwable -> L6
        this.journalWriter.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Value get(String r10) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L19
        Entry r11 = this.lruEntries.get(r10);     // Catch: Throwable -> L19
        if (r11 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (Entry.access$700(r11) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        File[] r12 = r11.cleanFiles;     // Catch: Throwable -> L19
        int r13 = r12.length;     // Catch: Throwable -> L19
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L21;
        if (r12[r14].exists() == false) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        monitor-exit(this);
        return null;
    L21:
        this.redundantOpCount++;     // Catch: Throwable -> L19
        this.journalWriter.append(READ);     // Catch: Throwable -> L19
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L19
        this.journalWriter.append(r10);     // Catch: Throwable -> L19
        this.journalWriter.append('\n');     // Catch: Throwable -> L19
        if (journalRebuildRequired() == false) goto L24;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L19
    L24:
        Value r15 = new Value(this, r10, Entry.access$1300(r11), r11.cleanFiles, Entry.access$1100(r11), null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r15;
    L19:
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

    public synchronized boolean isClosed() {
        monitor-enter(this);
        if (this.journalWriter != null) goto L6;
        boolean r10 = true;
    L7:
        monitor-exit(this);
        return r10;
    L6:
        r10 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean remove(String r10) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L17
        Entry r11 = this.lruEntries.get(r10);     // Catch: Throwable -> L17
        int r12 = 0;
        if (r11 != null) goto L6;
    L25:
        monitor-exit(this);
        return false;
    L6:
        if (Entry.access$800(r11) != null) goto L25;
    L9:
        if (r12 >= this.valueCount) goto L20;
        File r13 = r11.getCleanFile(r12);     // Catch: Throwable -> L17
        if (r13.exists() == false) goto L19;
        if (r13.delete() == true) goto L19;
        throw new IOException("failed to delete " + r13);     // Catch: Throwable -> L17
    L19:
        this.size -= Entry.access$1100(r11)[r12];     // Catch: Throwable -> L17
        Entry.access$1100(r11)[r12] = 0;     // Catch: Throwable -> L17
        r12 = r12 + 1;     // Catch: Throwable -> L17
        goto L9
    L20:
        this.redundantOpCount++;     // Catch: Throwable -> L17
        this.journalWriter.append(REMOVE);     // Catch: Throwable -> L17
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L17
        this.journalWriter.append(r10);     // Catch: Throwable -> L17
        this.journalWriter.append('\n');     // Catch: Throwable -> L17
        this.lruEntries.remove(r10);     // Catch: Throwable -> L17
        if (journalRebuildRequired() == false) goto L23;
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L17
    L23:
        monitor-exit(this);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void setMaxSize(long r10) {
        monitor-enter(this);
        this.maxSize = r10;     // Catch: Throwable -> L6
        this.executorService.submit(this.cleanupCallable);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long size() {
        monitor-enter(this);
        long r10 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized Editor edit(String r10, long r11) throws IOException {
        monitor-enter(this);
        checkNotClosed();     // Catch: Throwable -> L10
        Entry r12 = this.lruEntries.get(r10);     // Catch: Throwable -> L10
        AnonymousClass1 r13 = null;
        if (r11 == (-1)) goto L14;
        if (r12 != null) goto L8;
    L12:
        monitor-exit(this);
        return null;
    L8:
        if (Entry.access$1300(r12) != r11) goto L12;
    L14:
        if (r12 != null) goto L17;
        r12 = new Entry(this, r10, r13);     // Catch: Throwable -> L10
        this.lruEntries.put(r10, r12);     // Catch: Throwable -> L10
    L20:
        Editor r14 = new Editor(this, r12, r13);     // Catch: Throwable -> L10
        Entry.access$802(r12, r14);     // Catch: Throwable -> L10
        this.journalWriter.append(DIRTY);     // Catch: Throwable -> L10
        this.journalWriter.append(TokenParser.SP);     // Catch: Throwable -> L10
        this.journalWriter.append(r10);     // Catch: Throwable -> L10
        this.journalWriter.append('\n');     // Catch: Throwable -> L10
        this.journalWriter.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r14;
    L17:
        if (Entry.access$800(r12) == null) goto L20;
        monitor-exit(this);
        return null;
    L10:
        th = move-exception;
        throw th;
    }
}
