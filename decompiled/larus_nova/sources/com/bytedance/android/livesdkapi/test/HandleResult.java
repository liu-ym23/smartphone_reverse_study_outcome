package com.bytedance.android.livesdkapi.test;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/test/HandleResult;", "", "success", "", "message", "", "error", "", "(ZLjava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HandleResult {
    public static final Companion Companion = null;
    private final Throwable error;
    private final String message;
    private final boolean success;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/test/HandleResult$Companion;", "", "()V", "error", "Lcom/bytedance/android/livesdkapi/test/HandleResult;", "message", "", "", "success", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final HandleResult error(Throwable r100) {
            return new HandleResult(false, null, r100);
        }

        @JvmStatic
        public final HandleResult success(String r100) {
            return new HandleResult(true, r100, null, 4, null);
        }

        @JvmStatic
        public final HandleResult error(String r100, Throwable r101) {
            return new HandleResult(false, r100, r101);
        }

        public static /* synthetic */ HandleResult error$default(Companion r100, Throwable r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.error(r101);
        }

        public static /* synthetic */ HandleResult success$default(Companion r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.success(r101);
        }

        public static /* synthetic */ HandleResult error$default(Companion r100, String r101, Throwable r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.error(r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ HandleResult copy$default(HandleResult r100, boolean r101, String r102, Throwable r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.error;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @JvmStatic
    public static final HandleResult error(String r100, Throwable r101) {
        return Companion.error(r100, r101);
    }

    @JvmStatic
    public static final HandleResult error(Throwable r100) {
        return Companion.error(r100);
    }

    @JvmStatic
    public static final HandleResult success(String r100) {
        return Companion.success(r100);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final Throwable component3() {
        return this.error;
    }

    public final HandleResult copy(boolean r100, String r101, Throwable r102) {
        return new HandleResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HandleResult) == false) goto L12;
        HandleResult r101 = (HandleResult) r100;
        if (this.success == r101.success) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.error, r101.error) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.success;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.message;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Throwable r107 = this.error;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "HandleResult(success=" + this.success + ", message=" + this.message + ", error=" + this.error + ")";
    }

    public final Throwable getError() {
        return this.error;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public HandleResult(boolean r100, String r101, Throwable r102) {
        this.success = r100;
        this.message = r101;
        this.error = r102;
    }

    public /* synthetic */ HandleResult(boolean r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
