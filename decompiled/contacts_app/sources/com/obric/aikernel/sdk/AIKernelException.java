package com.obric.aikernel.sdk;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AIKernelException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\b\u0007\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "cause", "", "papayaCode", "(ILjava/lang/String;Ljava/lang/Throwable;I)V", "getCode", "()I", "getPapayaCode", "toString", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelException extends RuntimeException {
    public static final Companion Companion = null;
    private final int code;
    private final int papayaCode;

    /* JADX INFO: compiled from: AIKernelException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/sdk/AIKernelException$Companion;", "", "()V", "getException", "", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Throwable getException(Object r8) {
            Throwable r7 = Result.m806exceptionOrNullimpl(r8);
            if (r7 == null) goto L5;
            return r7;
        L5:
            return new AIKernelException(108, "call failed but no exception set.", null, 0, 12, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ AIKernelException(int r2, String r3, Throwable r4, int r5, int r6, DefaultConstructorMarker r7) {
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
        StringBuilder r0 = new StringBuilder("[").append(this.code).append('|').append(this.papayaCode).append("] [").append(getMessage()).append("]:\n ");
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
