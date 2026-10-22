package com.obric.autogui.common.api.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: BizStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum BizStatus extends Enum<BizStatus> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ BizStatus[] $VALUES = null;
    public static final BizStatus IDLE = null;
    public static final BizStatus OPERATING = null;
    public static final BizStatus PAUSED = null;
    public static final BizStatus PREPARING = null;
    public static final BizStatus QUEUEING = null;
    public static final BizStatus TERMINATED = null;
    public static final BizStatus USER_INTERRUPTED = null;

    /* JADX INFO: compiled from: BizStatus.kt */
    public static final class StatusChangedReason {
        public static final StatusChangedReason INSTANCE = null;
        public static final int NORMAL = 0;
        public static final int OPERATING_NORMAL = 1400;
        public static final int OPERATING_RESUME_FROM_CALL_USER = 1402;
        public static final int OPERATING_RESUME_FROM_CLARFIY = 1401;
        public static final int OPERATING_RESUME_FROM_MANUAL_OPERATING = 1404;
        public static final int OPERATING_RESUME_FROM_USER_ADDITION = 1403;
        public static final int OPERATING_RESUME_FROM_USER_INTERRUPTED = 1405;
        public static final int PAUSED__ENTERED_CALL_USER = 1200;
        public static final int PAUSED__STARTED_MANUAL_OPERATING = 1203;
        public static final int PAUSED__STARTED_USER_ADDITION = 1201;
        public static final int PAUSED__STARTED_USER_CLARIFY = 1202;
        public static final int QUEUEING__EXEC_NOT_LOGGED_IN = 1301;
        public static final int QUEUEING__EXEC_NO_NETWORK = 1300;
        public static final int TERMINATED__INTERNAL_ERROR = 1100;
        public static final int TERMINATED__OTHER_REASON = 1102;
        public static final int TERMINATED__USER_REQUESTED = 1101;

        static {
            INSTANCE = new StatusChangedReason();
        }

        private StatusChangedReason() {
        }
    }

    /* JADX INFO: compiled from: BizStatus.kt */
    public static final class StatusChangedReasonStruct {
        public static final Companion Companion = null;
        private static final StatusChangedReasonStruct DEFAULT = null;
        private final Map<String, Object> extra;
        private final String msg;
        private final Object obj;
        private final int reason;

        /* JADX INFO: compiled from: BizStatus.kt */
        public static final class Companion {
            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }

            public final StatusChangedReasonStruct getDEFAULT() {
                return StatusChangedReasonStruct.access$getDEFAULT$cp();
            }
        }

        public StatusChangedReasonStruct() {
            this(0, null, null, null, 15, null);
        }

        public static /* synthetic */ StatusChangedReasonStruct copy$default(StatusChangedReasonStruct r1, int r2, String r3, Object r4, Map r5, int r6, Object r7) {
            Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = r1.reason;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = r1.msg;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = r1.obj;
        L12:
            if ((r6 & 8) == 0) goto L15;
            r8 = r1.extra;
        L15:
            return r1.copy(r2, r3, r4, r8);
        }

        public final int component1() {
            return this.reason;
        }

        public final String component2() {
            return this.msg;
        }

        public final Object component3() {
            return this.obj;
        }

        public final Map<String, Object> component4() {
            return this.extra;
        }

        public final StatusChangedReasonStruct copy(int r2, String r3, Object r4, Map<String, ? extends Object> r5) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            o.e(r1, "extra");
            return new StatusChangedReasonStruct(r2, r3, r4, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, StatusChangedReasonStruct.class) == true) goto L8;
            return false;
        L8:
            StatusChangedReasonStruct r6 = (StatusChangedReasonStruct) ZeusTransformUtils.preCheckCast(r5, StatusChangedReasonStruct.class, "com.obric.aiagent.plugin");
            if (this.reason == r6.reason) goto L12;
            return false;
        L12:
            if (o.a(this.msg, r6.msg) == true) goto L15;
            return false;
        L15:
            if (o.a(this.obj, r6.obj) == true) goto L18;
            return false;
        L18:
            if (o.a(this.extra, r6.extra) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.reason) * 31;
            String r1 = this.msg;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Object r5 = this.obj;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((r4 + r2) * 31) + this.extra.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StatusChangedReasonStruct(reason=" + this.reason + ", msg=" + this.msg + ", obj=" + this.obj + ", extra=" + this.extra + ')';
        }

        public StatusChangedReasonStruct(int r3, String r4, Object r5, Map<String, ? extends Object> r6) {
            Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            o.e(r7, "extra");
            this.reason = r3;
            this.msg = r4;
            this.obj = r5;
            this.extra = r7;
        }

        public static final /* synthetic */ StatusChangedReasonStruct access$getDEFAULT$cp() {
            return DEFAULT;
        }

        public final int getReason() {
            return this.reason;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final Object getObj() {
            return this.obj;
        }

        public /* synthetic */ StatusChangedReasonStruct(int r2, String r3, Object r4, Map r5, int r6, h r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r8 = ao.b();
        L14:
            this(r2, r3, r4, r8);
        }

        public final Map<String, Object> getExtra() {
            return this.extra;
        }

        static {
            Companion = new Companion(null);
            DEFAULT = new StatusChangedReasonStruct(0, null, null, null, 15, null);
        }
    }

    private static final /* synthetic */ BizStatus[] $values() {
        return new BizStatus[]{TERMINATED, IDLE, QUEUEING, PREPARING, OPERATING, PAUSED, USER_INTERRUPTED};
    }

    public static a<BizStatus> getEntries() {
        return $ENTRIES;
    }

    private BizStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        TERMINATED = new BizStatus("TERMINATED", 0);
        IDLE = new BizStatus("IDLE", 1);
        QUEUEING = new BizStatus("QUEUEING", 2);
        PREPARING = new BizStatus("PREPARING", 3);
        OPERATING = new BizStatus("OPERATING", 4);
        PAUSED = new BizStatus("PAUSED", 5);
        USER_INTERRUPTED = new BizStatus("USER_INTERRUPTED", 6);
        BizStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static BizStatus valueOf(String r2) {
        return (BizStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(BizStatus.class, r2), BizStatus.class, "com.obric.aiagent.plugin");
    }

    public static BizStatus[] values() {
        return (BizStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BizStatus[].class, "com.obric.aiagent.plugin");
    }
}
