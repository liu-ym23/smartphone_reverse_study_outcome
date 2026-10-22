package com.obric.android.agilelogger.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class StackTraceUtils {

    private static class LengthLimitStringWriter extends StringWriter {
        private static final int MAX_STACK_TRACE_STRING_LEN = 4000;
        private boolean mIgnore;
        private int mLength;

        public LengthLimitStringWriter() {
            this.mLength = 0;
            this.mIgnore = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public void write(String r4, int r5, int r6) {
            if (this.mIgnore == false) goto L5;
            return;
        L5:
            int r0 = this.mLength;
            if ((r0 + r6) <= MAX_STACK_TRACE_STRING_LEN) goto L9;
            this.mIgnore = true;
            return;
        L9:
            this.mLength = r0 + r6;
            super.write(r4, r5, r6);
        }
    }

    public StackTraceUtils() {
    }

    public static String getStackTraceString(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Throwable r0 = r2;
    L6:
        if (r0 == null) goto L12;
        if ((r0 instanceof UnknownHostException) == true) goto L9;
        r0 = r0.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        LengthLimitStringWriter r1 = new LengthLimitStringWriter();
        PrintWriter r3 = new PrintWriter(r1);
        r2.printStackTrace(r3);     // Catch: Throwable -> L16
    L14:
        r3.flush();
        return r1.toString();
    }
}
