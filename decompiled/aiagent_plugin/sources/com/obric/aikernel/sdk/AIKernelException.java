package com.obric.aikernel.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;

/* JADX INFO: compiled from: AIKernelException.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKernelException extends RuntimeException {
    public static final Companion Companion = null;
    private final int code;
    private final int papayaCode;

    /* JADX INFO: compiled from: AIKernelException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final Throwable getException(Object r8) {
            Throwable r7 = n.c(r8);
            if (r7 != null) goto L6;
            String r2 = "call failed but no exception set.";
            return (Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, r2, null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin");
        L6:
            return r7;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ AIKernelException(int r2, String r3, Throwable r4, int r5, int r6, h r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public final int getCode() {
        return this.code;
    }

    public final int getPapayaCode() {
        return this.papayaCode;
    }

    public AIKernelException(int r1, String r2, Throwable r3, int r4) {
        super(r2, r3);
        this.code = r1;
        this.papayaCode = r4;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r0 = new StringBuilder().append('[').append(this.code).append('|').append(this.papayaCode).append("] [").append(getMessage()).append("]:\n ");
        Throwable r2 = getCause();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = null;
        goto L7
    }
}
