package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class Okio {
    static final Logger logger = null;

    static {
        logger = Logger.getLogger(Okio.class.getName());
    }

    private Okio() {
    }

    public static BufferedSource buffer(Source r1) {
        return new RealBufferedSource(r1);
    }

    public static BufferedSink buffer(Sink r1) {
        return new RealBufferedSink(r1);
    }

    public static Sink sink(OutputStream r1) {
        return sink(r1, new Timeout());
    }

    private static Sink sink(final OutputStream r1, final Timeout r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        return new AnonymousClass1(r2, r1);
    L7:
        throw new IllegalArgumentException("timeout == null");
    L9:
        throw new IllegalArgumentException("out == null");
    }

    public static Sink sink(Socket r1) throws IOException {
        if (r1 == null) goto L10;
        if (r1.getOutputStream() == null) goto L8;
        AsyncTimeout r0 = timeout(r1);
        return r0.sink(sink(r1.getOutputStream(), r0));
    L8:
        throw new IOException("socket's output stream == null");
    L10:
        throw new IllegalArgumentException("socket == null");
    }

    public static Source source(InputStream r1) {
        return source(r1, new Timeout());
    }

    private static Source source(final InputStream r1, final Timeout r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L7;
        return new AnonymousClass2(r2, r1);
    L7:
        throw new IllegalArgumentException("timeout == null");
    L9:
        throw new IllegalArgumentException("in == null");
    }

    public static Source source(File r1) throws FileNotFoundException {
        if (r1 == null) goto L6;
        return source(new FileInputStream(r1));
    L6:
        throw new IllegalArgumentException("file == null");
    }

    public static Source source(Path r0, OpenOption... r1) throws IOException {
        if (r0 == null) goto L6;
        return source(Files.newInputStream(r0, r1));
    L6:
        throw new IllegalArgumentException("path == null");
    }

    public static Sink sink(File r1) throws FileNotFoundException {
        if (r1 == null) goto L6;
        return sink(new FileOutputStream(r1));
    L6:
        throw new IllegalArgumentException("file == null");
    }

    public static Sink appendingSink(File r2) throws FileNotFoundException {
        if (r2 == null) goto L6;
        return sink(new FileOutputStream(r2, true));
    L6:
        throw new IllegalArgumentException("file == null");
    }

    public static Sink sink(Path r0, OpenOption... r1) throws IOException {
        if (r0 == null) goto L6;
        return sink(Files.newOutputStream(r0, r1));
    L6:
        throw new IllegalArgumentException("path == null");
    }

    public static Sink blackhole() {
        return new AnonymousClass3();
    }

    public static Source source(Socket r1) throws IOException {
        if (r1 == null) goto L10;
        if (r1.getInputStream() == null) goto L8;
        AsyncTimeout r0 = timeout(r1);
        return r0.source(source(r1.getInputStream(), r0));
    L8:
        throw new IOException("socket's input stream == null");
    L10:
        throw new IllegalArgumentException("socket == null");
    }

    private static AsyncTimeout timeout(final Socket r1) {
        return new AnonymousClass4(r1);
    }

    static boolean isAndroidGetsocknameError(AssertionError r1) {
        if (r1.getCause() != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.getMessage() == null) goto L9;
        if (r1.getMessage().contains("getsockname failed") == false) goto L9;
        return true;
    }
}
