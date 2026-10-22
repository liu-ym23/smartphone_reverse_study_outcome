package ch.qos.logback.core.joran.spi;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public enum ConsoleTarget {
    SystemOut("System.out", new OutputStream() { // from class: ch.qos.logback.core.joran.spi.ConsoleTarget.1
        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            System.out.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i4) throws IOException {
            System.out.write(i4);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            System.out.write(bArr, i4, i5);
        }
    }),
    SystemErr("System.err", new OutputStream() { // from class: ch.qos.logback.core.joran.spi.ConsoleTarget.2
        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            System.err.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i4) throws IOException {
            System.err.write(i4);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.err.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            System.err.write(bArr, i4, i5);
        }
    });

    private final String name;
    private final OutputStream stream;

    ConsoleTarget(String str, OutputStream outputStream) {
        this.name = str;
        this.stream = outputStream;
    }

    public static ConsoleTarget findByName(String str) {
        for (ConsoleTarget consoleTarget : values()) {
            if (consoleTarget.name.equalsIgnoreCase(str)) {
                return consoleTarget;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public OutputStream getStream() {
        return this.stream;
    }
}
