package com.obric.autogui.common.api.platform.computercontrol;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CCSessionRequestResult {

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class Failed extends CCSessionRequestResult {
        private final Integer errorCode;
        private final CCSessionFailureReason reason;
        private final Throwable throwable;

        public static /* synthetic */ Failed copy$default(Failed r0, CCSessionFailureReason r1, Integer r2, Throwable r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.reason;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.errorCode;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.throwable;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final CCSessionFailureReason component1() {
            return this.reason;
        }

        public final Integer component2() {
            return this.errorCode;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final Failed copy(CCSessionFailureReason r1, Integer r2, Throwable r3) {
            o.e(r1, "reason");
            return new Failed(r1, r2, r3);
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
            if (o.a(this.errorCode, r6.errorCode) == true) goto L15;
            return false;
        L15:
            if (o.a(this.throwable, r6.throwable) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.reason.hashCode() * 31;
            Integer r1 = this.errorCode;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Throwable r5 = this.throwable;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Failed(reason=" + this.reason + ", errorCode=" + this.errorCode + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ Failed(CCSessionFailureReason r2, Integer r3, Throwable r4, int r5, h r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r2, r3, r4);
        }

        public final CCSessionFailureReason getReason() {
            return this.reason;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public Failed(CCSessionFailureReason r2, Integer r3, Throwable r4) {
            o.e(r2, "reason");
            super(null);
            this.reason = r2;
            this.errorCode = r3;
            this.throwable = r4;
        }
    }

    /* JADX INFO: compiled from: ComputerControlModels.kt */
    public static final class Success extends CCSessionRequestResult {
        private final CCSessionAccessor session;

        public static /* synthetic */ Success copy$default(Success r1, CCSessionAccessor r2, int r3, Object r4) {
            CCSessionAccessor r5 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L6;
            r5 = r1.session;
        L6:
            return r1.copy(r5);
        }

        public final CCSessionAccessor component1() {
            return this.session;
        }

        public final Success copy(CCSessionAccessor r2) {
            CCSessionAccessor r1 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r2, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            o.e(r1, SensitiveType.SESSION);
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
            if (o.a(this.session, r6.session) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.session.hashCode();
        }

        public String toString() {
            return "Success(session=" + this.session + ')';
        }

        public final CCSessionAccessor getSession() {
            return this.session;
        }

        public Success(CCSessionAccessor r3) {
            CCSessionAccessor r4 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
            o.e(r4, SensitiveType.SESSION);
            super(null);
            this.session = r4;
        }
    }

    public /* synthetic */ CCSessionRequestResult(h r1) {
        this();
    }

    private CCSessionRequestResult() {
    }
}
