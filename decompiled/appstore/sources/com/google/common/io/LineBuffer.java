package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
abstract class LineBuffer {
    private StringBuilder line;
    private boolean sawReturn;

    public LineBuffer() {
        this.line = new StringBuilder();
    }

    @CanIgnoreReturnValue
    private boolean finishLine(boolean r10) throws IOException {
        if (this.sawReturn == false) goto L7;
        if (r10 == false) goto L6;
        String r11 = "\r\n";
    L10:
        handleLine(this.line.toString(), r11);
        this.line = new StringBuilder();
        this.sawReturn = false;
        return r10;
    L6:
        r11 = "\r";
        goto L10
    L7:
        if (r10 == false) goto L9;
        r11 = "\n";
        goto L10
    L9:
        r11 = "";
        goto L10
    }

    public void add(char[] r10, int r11, int r12) throws IOException {
        if (this.sawReturn == false) goto L12;
        if (r12 <= 0) goto L12;
        if (r10[r11] != '\n') goto L8;
        boolean r13 = true;
    L10:
        if (finishLine(r13) == false) goto L12;
        int r14 = r11 + 1;
    L13:
        int r15 = r11 + r12;
        int r16 = r14;
    L14:
        if (r14 >= r15) goto L32;
        char r17 = r10[r14];
        if (r17 != '\n') goto L18;
        this.line.append(r10, r16, r14 - r16);
        finishLine(true);
    L29:
        r16 = r14 + 1;
    L31:
        r14 = r14 + 1;
        goto L14
    L18:
        if (r17 != '\r') goto L31;
        this.line.append(r10, r16, r14 - r16);
        this.sawReturn = true;
        int r18 = r14 + 1;
        if (r18 >= r15) goto L29;
        if (r10[r18] != '\n') goto L25;
        boolean r19 = true;
    L27:
        if (finishLine(r19) == false) goto L29;
        r14 = r18;
        goto L29
    L25:
        r19 = false;
        goto L27
    L32:
        this.line.append(r10, r16, r15 - r16);
        return;
    L8:
        r13 = false;
    L12:
        r14 = r11;
        goto L13
    }

    public void finish() throws IOException {
        if (this.sawReturn == false) goto L5;
    L6:
        finishLine(false);
        return;
    L5:
        if (this.line.length() > 0) goto L6;
    }

    public abstract void handleLine(String r10, String r11) throws IOException;
}
