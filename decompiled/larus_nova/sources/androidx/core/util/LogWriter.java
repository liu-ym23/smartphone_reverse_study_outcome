package androidx.core.util;

import java.io.Writer;

/* JADX INFO: loaded from: classes17.dex */
public class LogWriter extends Writer {
    private StringBuilder mBuilder;
    private final String mTag;

    private void flushBuilder() {
        if (this.mBuilder.length() <= 0) goto L6;
        this.mBuilder.toString();
        StringBuilder r100 = this.mBuilder;
        r100.delete(0, r100.length());
        return;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        flushBuilder();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        flushBuilder();
    }

    public LogWriter(String r100) {
        this.mBuilder = new StringBuilder(128);
        this.mTag = r100;
    }

    @Override // java.io.Writer
    public void write(char[] r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        char r104 = r100[r101 + r103];
        if (r104 != '\n') goto L7;
        flushBuilder();
    L8:
        r103 = r103 + 1;
        goto L3
    L7:
        this.mBuilder.append(r104);
        goto L8
    }
}
