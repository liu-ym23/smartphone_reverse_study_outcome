package com.google.common.io;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Files {
    private static final TreeTraverser<File> FILE_TREE_TRAVERSER = null;
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    private static final class FileByteSink extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        /* synthetic */ FileByteSink(File r1, FileWriteMode[] r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // com.google.common.io.ByteSink
        public /* bridge */ /* synthetic */ OutputStream openStream() throws IOException {
            return openStream();
        }

        private FileByteSink(File r1, FileWriteMode... r2) {
            this.file = (File) Preconditions.checkNotNull(r1);
            this.modes = ImmutableSet.copyOf(r2);
        }

        @Override // com.google.common.io.ByteSink
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.file + ", " + this.modes + ")";
        }
    }

    private static final class FileByteSource extends ByteSource {
        private final File file;

        /* synthetic */ FileByteSource(File r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.io.ByteSource
        public /* bridge */ /* synthetic */ InputStream openStream() throws IOException {
            return openStream();
        }

        private FileByteSource(File r1) {
            this.file = (File) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            if (this.file.isFile() == false) goto L7;
            return this.file.length();
        L7:
            throw new FileNotFoundException(this.file.toString());
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            Closer r0 = Closer.create();
            FileInputStream r3 = (FileInputStream) r0.register(openStream());     // Catch: Throwable -> L6
            byte[] r4 = Files.readFile(r3, r3.getChannel().size());     // Catch: Throwable -> L6
            r0.close();
            return r4;
        L6:
            th = move-exception;
        L9:
            th = move-exception;
            r0.close();
            throw th;
        L8:
            throw r0.rethrow(th);     // Catch: Throwable -> L9
        }

        public String toString() {
            return "Files.asByteSource(" + this.file + ")";
        }
    }

    private static abstract enum FilePredicate extends Enum<FilePredicate> implements Predicate<File> {
        private static final /* synthetic */ FilePredicate[] $VALUES = null;
        public static final FilePredicate IS_DIRECTORY = null;
        public static final FilePredicate IS_FILE = null;

        private FilePredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ FilePredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static FilePredicate valueOf(String r1) {
            return (FilePredicate) Enum.valueOf(FilePredicate.class, r1);
        }

        public static FilePredicate[] values() {
            return (FilePredicate[]) $VALUES.clone();
        }

        static {
            final String r1 = "IS_DIRECTORY";
            final int r2 = 0;
            FilePredicate r0 = new AnonymousClass1(r1, r2);
            IS_DIRECTORY = r0;
            final String r3 = "IS_FILE";
            final int r4 = 1;
            FilePredicate r5 = new AnonymousClass2(r3, r4);
            IS_FILE = r5;
            $VALUES = new FilePredicate[]{r0, r5};
        }
    }

    private Files() {
    }

    public static BufferedReader newReader(File r3, Charset r4) throws FileNotFoundException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return new BufferedReader(new InputStreamReader(new FileInputStream(r3), r4));
    }

    public static BufferedWriter newWriter(File r3, Charset r4) throws FileNotFoundException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r3), r4));
    }

    public static ByteSource asByteSource(File r2) {
        return new FileByteSource(r2, null);
    }

    static byte[] readFile(InputStream r2, long r3) throws IOException {
        if (r3 > 2147483647L) goto L10;
        if (r3 != 0) goto L8;
        return ByteStreams.toByteArray(r2);
    L8:
        return ByteStreams.toByteArray(r2, (int) r3);
    L10:
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + r3 + " bytes");
    }

    public static ByteSink asByteSink(File r2, FileWriteMode... r3) {
        return new FileByteSink(r2, r3, null);
    }

    public static CharSource asCharSource(File r0, Charset r1) {
        return asByteSource(r0).asCharSource(r1);
    }

    public static CharSink asCharSink(File r0, Charset r1, FileWriteMode... r2) {
        return asByteSink(r0, r2).asCharSink(r1);
    }

    private static FileWriteMode[] modes(boolean r2) {
        if (r2 == false) goto L6;
        return new FileWriteMode[]{FileWriteMode.APPEND};
    L6:
        return new FileWriteMode[0];
    }

    public static byte[] toByteArray(File r0) throws IOException {
        return asByteSource(r0).read();
    }

    public static String toString(File r0, Charset r1) throws IOException {
        return asCharSource(r0, r1).read();
    }

    public static void write(byte[] r1, File r2) throws IOException {
        asByteSink(r2, new FileWriteMode[0]).write(r1);
    }

    public static void copy(File r0, OutputStream r1) throws IOException {
        asByteSource(r0).copyTo(r1);
    }

    public static void copy(File r4, File r5) throws IOException {
        Preconditions.checkArgument(!r4.equals(r5), "Source %s and destination %s must be different", new Object[]{r4, r5});
        asByteSource(r4).copyTo(asByteSink(r5, new FileWriteMode[0]));
    }

    public static void write(CharSequence r1, File r2, Charset r3) throws IOException {
        asCharSink(r2, r3, new FileWriteMode[0]).write(r1);
    }

    public static void append(CharSequence r1, File r2, Charset r3) throws IOException {
        write(r1, r2, r3, true);
    }

    private static void write(CharSequence r0, File r1, Charset r2, boolean r3) throws IOException {
        asCharSink(r1, r2, modes(r3)).write(r0);
    }

    public static void copy(File r0, Charset r1, Appendable r2) throws IOException {
        asCharSource(r0, r1).copyTo(r2);
    }

    public static boolean equal(File r7, File r8) throws IOException {
        Preconditions.checkNotNull(r7);
        Preconditions.checkNotNull(r8);
        if (r7 != r8) goto L5;
        return true;
    L5:
        if (r7.equals(r8) == true) goto L19;
        long r0 = r7.length();
        long r2 = r8.length();
        if (r0 == 0) goto L16;
        if (r2 == 0) goto L16;
        if (r0 == r2) goto L16;
        return false;
    L16:
        return asByteSource(r7).contentEquals(asByteSource(r8));
    L19:
        return true;
    }

    public static File createTempDir() {
        File r0 = new File(System.getProperty("java.io.tmpdir"));
        String r1 = System.currentTimeMillis() + "-";
        int r2 = 0;
    L4:
        if (r2 >= 10000) goto L10;
        File r3 = new File(r0, r1 + r2);
        if (r3.mkdir() == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return r3;
    L10:
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + r1 + "0 to " + r1 + "9999)");
    }

    public static void touch(File r3) throws IOException {
        Preconditions.checkNotNull(r3);
        if (r3.createNewFile() == false) goto L5;
        return;
    L5:
        if (r3.setLastModified(System.currentTimeMillis()) == false) goto L8;
        return;
    L8:
        throw new IOException("Unable to update modification time of " + r3);
    }

    public static void createParentDirs(File r3) throws IOException {
        Preconditions.checkNotNull(r3);
        File r0 = r3.getCanonicalFile().getParentFile();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.mkdirs();
        if (r0.isDirectory() == false) goto L9;
        return;
    L9:
        throw new IOException("Unable to create parent directories of " + r3);
    }

    public static void move(File r4, File r5) throws IOException {
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        Preconditions.checkArgument(!r4.equals(r5), "Source %s and destination %s must be different", new Object[]{r4, r5});
        if (r4.renameTo(r5) == true) goto L12;
        copy(r4, r5);
        if (r4.delete() == false) goto L7;
        return;
    L7:
        if (r5.delete() == true) goto L11;
        throw new IOException("Unable to delete " + r5);
    L11:
        throw new IOException("Unable to delete " + r4);
    }

    public static String readFirstLine(File r0, Charset r1) throws IOException {
        return asCharSource(r0, r1).readFirstLine();
    }

    public static List<String> readLines(File r1, Charset r2) throws IOException {
        return (List) readLines(r1, r2, new AnonymousClass1());
    }

    public static <T> T readLines(File r0, Charset r1, LineProcessor<T> r2) throws IOException {
        return (T) asCharSource(r0, r1).readLines(r2);
    }

    public static <T> T readBytes(File r0, ByteProcessor<T> r1) throws IOException {
        return (T) asByteSource(r0).read(r1);
    }

    public static HashCode hash(File r0, HashFunction r1) throws IOException {
        return asByteSource(r0).hash(r1);
    }

    public static MappedByteBuffer map(File r1) throws IOException {
        Preconditions.checkNotNull(r1);
        return map(r1, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File r2, FileChannel.MapMode r3) throws IOException {
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        if (r2.exists() == false) goto L7;
        return map(r2, r3, r2.length());
    L7:
        throw new FileNotFoundException(r2.toString());
    }

    public static MappedByteBuffer map(File r3, FileChannel.MapMode r4, long r5) throws FileNotFoundException, IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Closer r0 = Closer.create();
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L12:
        throw r0.rethrow(th);     // Catch: Throwable -> L13
    L4:
        if (r4 != FileChannel.MapMode.READ_ONLY) goto L6;
        String r2 = "r";
    L7:
        MappedByteBuffer r6 = map((RandomAccessFile) r0.register(new RandomAccessFile(r3, r2)), r4, r5);     // Catch: Throwable -> L10
        r0.close();
        return r6;
    L6:
        r2 = "rw";
        goto L7
    }

    private static MappedByteBuffer map(RandomAccessFile r7, FileChannel.MapMode r8, long r9) throws IOException {
        Closer r0 = Closer.create();
        MappedByteBuffer r10 = ((FileChannel) r0.register(r7.getChannel())).map(r8, 0, r9);     // Catch: Throwable -> L6
        r0.close();
        return r10;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public static String simplifyPath(String r7) {
        Preconditions.checkNotNull(r7);
        if (r7.length() != 0) goto L5;
        return LibrarianImpl.Constants.DOT;
    L5:
        Iterable<String> r2 = Splitter.on('/').omitEmptyStrings().split(r7);
        ArrayList r3 = new ArrayList();
        Iterator<String> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L20;
        String r5 = r4.next();
        if (r5.equals(LibrarianImpl.Constants.DOT) == true) goto L7;
        if (r5.equals("..") == true) goto L14;
        r3.add(r5);
        goto L7
    L14:
        if (r3.size() <= 0) goto L18;
        if (((String) r3.get(r3.size() - 1)).equals("..") == true) goto L18;
        r3.remove(r3.size() - 1);
    L18:
        r3.add("..");
        goto L7
    L20:
        String r6 = Joiner.on('/').join(r3);
        if (r7.charAt(0) != '/') goto L24;
        r6 = LibrarianImpl.Constants.SEPARATOR + r6;
    L24:
        if (r6.startsWith("/../") == false) goto L27;
        r6 = r6.substring(3);
        goto L24
    L27:
        if (r6.equals("/..") == false) goto L30;
        return LibrarianImpl.Constants.SEPARATOR;
    L30:
        if ("".equals(r6) == false) goto L33;
        return LibrarianImpl.Constants.DOT;
    L33:
        return r6;
    }

    public static String getFileExtension(String r2) {
        Preconditions.checkNotNull(r2);
        String r3 = new File(r2).getName();
        int r0 = r3.lastIndexOf(46);
        if (r0 != (-1)) goto L6;
        return "";
    L6:
        return r3.substring(r0 + 1);
    }

    public static String getNameWithoutExtension(String r2) {
        Preconditions.checkNotNull(r2);
        String r3 = new File(r2).getName();
        int r0 = r3.lastIndexOf(46);
        if (r0 != (-1)) goto L6;
        return r3;
    L6:
        return r3.substring(0, r0);
    }

    public static TreeTraverser<File> fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    static {
        FILE_TREE_TRAVERSER = new AnonymousClass2();
    }

    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }
}
