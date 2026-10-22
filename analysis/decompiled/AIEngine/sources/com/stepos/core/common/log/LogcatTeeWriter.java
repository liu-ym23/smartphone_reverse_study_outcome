package com.stepos.core.common.log;

import android.util.Log;
import java.io.PrintWriter;
import java.io.Writer;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class LogcatTeeWriter extends PrintWriter {
    private final StringBuilder line;
    private final String tag;
    private final PrintWriter target;

    public /* synthetic */ LogcatTeeWriter(PrintWriter printWriter, String str, int i10, e eVar) {
        this(printWriter, (i10 & 2) != 0 ? "AIEngineDump" : str);
    }

    private final void feed(String str) {
        this.target.write(str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\n') {
                flushLine();
            } else if (cCharAt != '\r') {
                this.line.append(cCharAt);
            }
        }
    }

    private final void flushLine() {
        Log.i(this.tag, this.line.toString());
        this.line.setLength(0);
    }

    @Override // java.io.PrintWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        this.target.flush();
    }

    public final void flushRemaining() {
        if (this.line.length() > 0) {
            flushLine();
        }
        this.target.flush();
    }

    @Override // java.io.PrintWriter
    public void println() {
        this.target.println();
        flushLine();
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int i10) {
        feed(String.valueOf((char) i10));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String s8) {
        g.f(s8, "s");
        feed(s8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogcatTeeWriter(PrintWriter target, String tag) {
        super((Writer) target, false);
        g.f(target, "target");
        g.f(tag, "tag");
        this.target = target;
        this.tag = tag;
        this.line = new StringBuilder();
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String s8, int i10, int i11) {
        g.f(s8, "s");
        String strSubstring = s8.substring(i10, i11 + i10);
        g.e(strSubstring, "substring(...)");
        feed(strSubstring);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cbuf) {
        g.f(cbuf, "cbuf");
        feed(new String(cbuf));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cbuf, int i10, int i11) {
        g.f(cbuf, "cbuf");
        feed(new String(cbuf, i10, i11));
    }
}
