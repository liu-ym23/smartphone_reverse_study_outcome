package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CCDataResult<T> {

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class Failed extends CCDataResult {
        private final CCActionFailureReason reason;
        private final Throwable throwable;

        public static /* synthetic */ Failed copy$default(Failed r0, CCActionFailureReason r1, Throwable r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.reason;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.throwable;
        L9:
            return r0.copy(r1, r2);
        }

        public final CCActionFailureReason component1() {
            return this.reason;
        }

        public final Throwable component2() {
            return this.throwable;
        }

        public final Failed copy(CCActionFailureReason r1, Throwable r2) {
            o.e(r1, "reason");
            return new Failed(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Failed.class) == true) goto L8;
            return false;
        L8:
            Failed r6 = (Failed) ZeusTransformUtils.preCheckCast(r5, Failed.class, "com.obric.aiagent.plugin");
            if (this.reason == r6.reason) goto L12;
            return false;
        L12:
            if (o.a(this.throwable, r6.throwable) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.reason.hashCode() * 31;
            Throwable r1 = this.throwable;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Failed(reason=" + this.reason + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ Failed(CCActionFailureReason r1, Throwable r2, int r3, h r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }

        public final CCActionFailureReason getReason() {
            return this.reason;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public Failed(CCActionFailureReason r2, Throwable r3) {
            o.e(r2, "reason");
            super(null);
            this.reason = r2;
            this.throwable = r3;
        }
    }

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class Success<T> extends CCDataResult<T> {
        private final T data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success r0, Object r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T r1) {
            return new Success(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Success.class) == true) goto L8;
            return false;
        L8:
            Success r6 = (Success) ZeusTransformUtils.preCheckCast(r5, Success.class, "com.obric.aiagent.plugin");
            if (o.a(this.data, r6.data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ')';
        }

        public final T getData() {
            return this.data;
        }

        public Success(T r2) {
            super(null);
            this.data = r2;
        }
    }

    public /* synthetic */ CCDataResult(h r1) {
        this();
    }

    private CCDataResult() {
    }
}
