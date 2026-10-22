package com.google.common.io;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class Files {
    private static final SuccessorsFunction<File> FILE_TREE = null;
    private static final TreeTraverser<File> FILE_TREE_TRAVERSER = null;
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    public static final class FileByteSink extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        public /* synthetic */ FileByteSink(File r10, FileWriteMode[] r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.io.ByteSink
        public /* bridge */ /* synthetic */ OutputStream openStream() throws IOException {
            return openStream();
        }

        public String toString() {
            return "Files.asByteSink(" + this.file + ", " + this.modes + ")";
        }

        private FileByteSink(File r10, FileWriteMode... r11) {
            this.file = (File) Preconditions.checkNotNull(r10);
            this.modes = ImmutableSet.copyOf(r11);
        }

        @Override // com.google.common.io.ByteSink
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }
    }

    public static final class FileByteSource extends ByteSource {
        private final File file;

        public /* synthetic */ FileByteSource(File r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.io.ByteSource
        public /* bridge */ /* synthetic */ InputStream openStream() throws IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            Closer r10 = Closer.create();
            FileInputStream r11 = (FileInputStream) r10.register(openStream());     // Catch: Throwable -> L6
            byte[] r12 = ByteStreams.toByteArray(r11, r11.getChannel().size());     // Catch: Throwable -> L6
            r10.close();
            return r12;
        L6:
            th = move-exception;
        L9:
            th = move-exception;
            r10.close();
            throw th;
        L8:
            throw r10.rethrow(th);     // Catch: Throwable -> L9
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            if (this.file.isFile() == false) goto L7;
            return this.file.length();
        L7:
            throw new FileNotFoundException(this.file.toString());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            if (this.file.isFile() == false) goto L7;
            return Optional.of(Long.valueOf(this.file.length()));
        L7:
            return Optional.absent();
        }

        public String toString() {
            return "Files.asByteSource(" + this.file + ")";
        }

        private FileByteSource(File r10) {
            this.file = (File) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.io.ByteSource
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }
    }

    public static abstract enum FilePredicate extends Enum<FilePredicate> implements Predicate<File> {
        private static final /* synthetic */ FilePredicate[] $VALUES = null;
        public static final FilePredicate IS_DIRECTORY = null;
        public static final FilePredicate IS_FILE = null;

        static {
            final String r10 = "IS_DIRECTORY";
            final int r11 = 0;
            FilePredicate r12 = new AnonymousClass1(r10, r11);
            IS_DIRECTORY = r12;
            final String r13 = "IS_FILE";
            final int r14 = 1;
            FilePredicate r15 = new AnonymousClass2(r13, r14);
            IS_FILE = r15;
            $VALUES = new FilePredicate[]{r12, r15};
        }

        private FilePredicate(String r10, int r11) {
            super(r10, r11);
        }

        public static FilePredicate valueOf(String r10) {
            return (FilePredicate) Enum.valueOf(FilePredicate.class, r10);
        }

        public static FilePredicate[] values() {
            return (FilePredicate[]) $VALUES.clone();
        }

        public /* synthetic */ FilePredicate(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    static {
        FILE_TREE_TRAVERSER = new AnonymousClass2();
        FILE_TREE = new AnonymousClass3();
    }

    private Files() {
    }

    public static /* synthetic */ Iterable access$200(File r10) {
        return fileTreeChildren(r10);
    }

    @Beta
    @Deprecated
    public static void append(CharSequence r10, File r11, Charset r12) throws IOException {
        asCharSink(r11, r12, new FileWriteMode[]{FileWriteMode.APPEND}).write(r10);
    }

    public static ByteSink asByteSink(File r10, FileWriteMode... r11) {
        return new FileByteSink(r10, r11, null);
    }

    public static ByteSource asByteSource(File r10) {
        return new FileByteSource(r10, null);
    }

    public static CharSink asCharSink(File r10, Charset r11, FileWriteMode... r12) {
        return asByteSink(r10, r12).asCharSink(r11);
    }

    public static CharSource asCharSource(File r10, Charset r11) {
        return asByteSource(r10).asCharSource(r11);
    }

    @Beta
    public static void copy(File r10, OutputStream r11) throws IOException {
        asByteSource(r10).copyTo(r11);
    }

    @Beta
    public static void createParentDirs(File r10) throws IOException {
        Preconditions.checkNotNull(r10);
        File r11 = r10.getCanonicalFile().getParentFile();
        if (r11 != null) goto L5;
        return;
    L5:
        r11.mkdirs();
        if (r11.isDirectory() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to create parent directories of " + r10);
    }

    @Beta
    public static File createTempDir() {
        File r10 = new File(System.getProperty("java.io.tmpdir"));
        String r11 = System.currentTimeMillis() + "-";
        int r12 = 0;
    L4:
        if (r12 >= 10000) goto L10;
        File r13 = new File(r10, r11 + r12);
        if (r13.mkdir() == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r13;
    L10:
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + r11 + "0 to " + r11 + HijrahDate.MAX_VALUE_OF_ERA + ')');
    }

    @Beta
    public static boolean equal(File r10, File r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        if (r10 != r11) goto L5;
        return true;
    L5:
        if (r10.equals(r11) == true) goto L19;
        long r12 = r10.length();
        long r13 = r11.length();
        if (r12 == 0) goto L16;
        if (r13 == 0) goto L16;
        if (r12 == r13) goto L16;
        return false;
    L16:
        return asByteSource(r10).contentEquals(asByteSource(r11));
    L19:
        return true;
    }

    @Beta
    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    private static Iterable<File> fileTreeChildren(File r10) {
        if (r10.isDirectory() == false) goto L9;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L9;
        return Collections.unmodifiableList(Arrays.asList(r11));
    L9:
        return Collections.emptyList();
    }

    @Deprecated
    public static TreeTraverser<File> fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    @Beta
    public static String getFileExtension(String r10) {
        Preconditions.checkNotNull(r10);
        String r11 = new File(r10).getName();
        int r12 = r11.lastIndexOf(46);
        if (r12 != (-1)) goto L6;
        return "";
    L6:
        return r11.substring(r12 + 1);
    }

    @Beta
    public static String getNameWithoutExtension(String r10) {
        Preconditions.checkNotNull(r10);
        String r11 = new File(r10).getName();
        int r12 = r11.lastIndexOf(46);
        if (r12 != (-1)) goto L6;
        return r11;
    L6:
        return r11.substring(0, r12);
    }

    @Beta
    @Deprecated
    public static HashCode hash(File r10, HashFunction r11) throws IOException {
        return asByteSource(r10).hash(r11);
    }

    @Beta
    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    @Beta
    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }

    @Beta
    public static MappedByteBuffer map(File r10) throws IOException {
        Preconditions.checkNotNull(r10);
        return map(r10, FileChannel.MapMode.READ_ONLY);
    }

    private static MappedByteBuffer mapInternal(File r10, FileChannel.MapMode r11, long r12) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Closer r13 = Closer.create();
    L6:
        th = move-exception;
    L17:
        th = move-exception;
        r13.close();
        throw th;
    L16:
        throw r13.rethrow(th);     // Catch: Throwable -> L17
    L4:
        if (r11 != FileChannel.MapMode.READ_ONLY) goto L8;
        String r14 = "r";
    L9:
        FileChannel r15 = (FileChannel) r13.register(((RandomAccessFile) r13.register(new RandomAccessFile(r10, r14))).getChannel());     // Catch: Throwable -> L6
        if (r12 != (-1)) goto L12;
        r12 = r15.size();     // Catch: Throwable -> L6
    L12:
        MappedByteBuffer r16 = r15.map(r11, 0, r12);     // Catch: Throwable -> L6
        r13.close();
        return r16;
    L8:
        r14 = "rw";
        goto L9
    }

    @Beta
    public static void move(File r10, File r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkArgument(!r10.equals(r11), "Source %s and destination %s must be different", r10, r11);
        if (r10.renameTo(r11) == true) goto L12;
        copy(r10, r11);
        if (r10.delete() == false) goto L7;
        return;
    L7:
        if (r11.delete() == true) goto L11;
        throw new IOException("Unable to delete " + r11);
    L11:
        throw new IOException("Unable to delete " + r10);
    }

    @Beta
    public static BufferedReader newReader(File r10, Charset r11) throws FileNotFoundException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new BufferedReader(new InputStreamReader(new FileInputStream(r10), r11));
    }

    @Beta
    public static BufferedWriter newWriter(File r10, Charset r11) throws FileNotFoundException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r10), r11));
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T readBytes(File r10, ByteProcessor<T> r11) throws IOException {
        return (T) asByteSource(r10).read(r11);
    }

    @Beta
    @Deprecated
    public static String readFirstLine(File r10, Charset r11) throws IOException {
        return asCharSource(r10, r11).readFirstLine();
    }

    @Beta
    public static List<String> readLines(File r10, Charset r11) throws IOException {
        return (List) asCharSource(r10, r11).readLines(new AnonymousClass1());
    }

    @Beta
    public static String simplifyPath(String r10) {
        Preconditions.checkNotNull(r10);
        if (r10.length() != 0) goto L5;
        return LibrarianImpl.Constants.DOT;
    L5:
        Iterable<String> r11 = Splitter.on('/').omitEmptyStrings().split(r10);
        ArrayList r12 = new ArrayList();
        Iterator<String> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L19;
        String r14 = r13.next();
        r14.hashCode();
        if (r14.equals(LibrarianImpl.Constants.DOT) == true) goto L7;
        if (r14.equals("..") == false) goto L12;
        if (r12.size() <= 0) goto L18;
        if (((String) r12.get(r12.size() - 1)).equals("..") == true) goto L18;
        r12.remove(r12.size() - 1);
    L18:
        r12.add("..");
        goto L7
    L12:
        r12.add(r14);
        goto L7
    L19:
        String r15 = Joiner.on('/').join(r12);
        if (r10.charAt(0) != '/') goto L23;
        r15 = LibrarianImpl.Constants.SEPARATOR + r15;
    L23:
        if (r15.startsWith("/../") == false) goto L26;
        r15 = r15.substring(3);
        goto L23
    L26:
        if (r15.equals("/..") == false) goto L29;
        return LibrarianImpl.Constants.SEPARATOR;
    L29:
        if ("".equals(r15) == false) goto L32;
        return LibrarianImpl.Constants.DOT;
    L32:
        return r15;
    }

    @Beta
    public static byte[] toByteArray(File r10) throws IOException {
        return asByteSource(r10).read();
    }

    @Beta
    @Deprecated
    public static String toString(File r10, Charset r11) throws IOException {
        return asCharSource(r10, r11).read();
    }

    @Beta
    public static void touch(File r10) throws IOException {
        Preconditions.checkNotNull(r10);
        if (r10.createNewFile() == false) goto L5;
        return;
    L5:
        if (r10.setLastModified(System.currentTimeMillis()) == false) goto L8;
        return;
    L8:
        throw new IOException("Unable to update modification time of " + r10);
    }

    @Beta
    public static void write(byte[] r10, File r11) throws IOException {
        asByteSink(r11, new FileWriteMode[0]).write(r10);
    }

    @Beta
    public static void copy(File r10, File r11) throws IOException {
        Preconditions.checkArgument(!r10.equals(r11), "Source %s and destination %s must be different", r10, r11);
        asByteSource(r10).copyTo(asByteSink(r11, new FileWriteMode[0]));
    }

    @Beta
    @Deprecated
    public static void write(CharSequence r10, File r11, Charset r12) throws IOException {
        asCharSink(r11, r12, new FileWriteMode[0]).write(r10);
    }

    @Beta
    public static MappedByteBuffer map(File r10, FileChannel.MapMode r11) throws IOException {
        return mapInternal(r10, r11, -1);
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T readLines(File r10, Charset r11, LineProcessor<T> r12) throws IOException {
        return (T) asCharSource(r10, r11).readLines(r12);
    }

    @Beta
    @Deprecated
    public static void copy(File r10, Charset r11, Appendable r12) throws IOException {
        asCharSource(r10, r11).copyTo(r12);
    }

    @Beta
    public static MappedByteBuffer map(File r10, FileChannel.MapMode r11, long r12) throws IOException {
        if (r12 < 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "size (%s) may not be negative", r12);
        return mapInternal(r10, r11, r12);
    L5:
        r13 = false;
        goto L6
    }
}
