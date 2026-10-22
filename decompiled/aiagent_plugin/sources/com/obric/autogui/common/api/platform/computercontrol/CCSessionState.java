package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CCSessionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CCSessionState {

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class Active extends CCSessionState {
        public static final Active INSTANCE = null;

        static {
            INSTANCE = new Active();
        }

        private Active() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class Blocked extends CCSessionState {
        private final String packageName;
        private final int reason;

        public static /* synthetic */ Blocked copy$default(Blocked r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.reason;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.packageName;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.reason;
        }

        public final String component2() {
            return this.packageName;
        }

        public final Blocked copy(int r1, String r2) {
            return new Blocked(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Blocked.class) == true) goto L8;
            return false;
        L8:
            Blocked r6 = (Blocked) ZeusTransformUtils.preCheckCast(r5, Blocked.class, "com.obric.aiagent.plugin");
            if (this.reason == r6.reason) goto L12;
            return false;
        L12:
            if (o.a(this.packageName, r6.packageName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.reason) * 31;
            String r1 = this.packageName;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Blocked(reason=" + this.reason + ", packageName=" + this.packageName + ')';
        }

        public final int getReason() {
            return this.reason;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public Blocked(int r2, String r3) {
            super(null);
            this.reason = r2;
            this.packageName = r3;
        }
    }

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class Closed extends CCSessionState {
        private final Integer reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Closed() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Closed copy$default(Closed r0, Integer r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.reason;
        L6:
            return r0.copy(r1);
        }

        public final Integer component1() {
            return this.reason;
        }

        public final Closed copy(Integer r1) {
            return new Closed(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Closed.class) == true) goto L8;
            return false;
        L8:
            Closed r6 = (Closed) ZeusTransformUtils.preCheckCast(r5, Closed.class, "com.obric.aiagent.plugin");
            if (o.a(this.reason, r6.reason) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.reason;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Closed(reason=" + this.reason + ')';
        }

        public /* synthetic */ Closed(Integer r1, int r2, h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }

        public final Integer getReason() {
            return this.reason;
        }

        public Closed(Integer r2) {
            super(null);
            this.reason = r2;
        }
    }

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class Created extends CCSessionState {
        public static final Created INSTANCE = null;

        static {
            INSTANCE = new Created();
        }

        private Created() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class CreationFailed extends CCSessionState {
        private final int errorCode;

        public static /* synthetic */ CreationFailed copy$default(CreationFailed r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.errorCode;
        L6:
            return r0.copy(r1);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final CreationFailed copy(int r1) {
            return new CreationFailed(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, CreationFailed.class) == true) goto L8;
            return false;
        L8:
            CreationFailed r6 = (CreationFailed) ZeusTransformUtils.preCheckCast(r5, CreationFailed.class, "com.obric.aiagent.plugin");
            if (this.errorCode == r6.errorCode) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.errorCode);
        }

        public String toString() {
            return "CreationFailed(errorCode=" + this.errorCode + ')';
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public CreationFailed(int r2) {
            super(null);
            this.errorCode = r2;
        }
    }

    /* JADX INFO: compiled from: CCSessionState.kt */
    public static final class Requesting extends CCSessionState {
        public static final Requesting INSTANCE = null;

        static {
            INSTANCE = new Requesting();
        }

        private Requesting() {
            super(null);
        }
    }

    public /* synthetic */ CCSessionState(h r1) {
        this();
    }

    private CCSessionState() {
    }
}
