package com.obric.autogui.common.api.space.handusing;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.o;

/* JADX INFO: compiled from: HandUsingConfigResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HandUsingConfigResult {
    private final Status status;

    /* JADX INFO: compiled from: HandUsingConfigResult.kt */
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ApiError = null;
        public static final Status NoActiveSpace = null;
        public static final Status NotSupported = null;
        public static final Status Success = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Success, ApiError, NotSupported, NoActiveSpace};
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Success = new Status("Success", 0);
            ApiError = new Status("ApiError", 1);
            NotSupported = new Status("NotSupported", 2);
            NoActiveSpace = new Status("NoActiveSpace", 3);
            Status[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.aiagent.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ HandUsingConfigResult copy$default(HandUsingConfigResult r0, Status r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        return r0.copy(r1);
    }

    public final Status component1() {
        return this.status;
    }

    public final HandUsingConfigResult copy(Status r1) {
        o.e(r1, "status");
        return new HandUsingConfigResult(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HandUsingConfigResult.class) == true) goto L8;
        return false;
    L8:
        HandUsingConfigResult r6 = (HandUsingConfigResult) ZeusTransformUtils.preCheckCast(r5, HandUsingConfigResult.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "HandUsingConfigResult(status=" + this.status + ')';
    }

    public HandUsingConfigResult(Status r2) {
        o.e(r2, "status");
        this.status = r2;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final boolean isSuccess() {
        if (this.status != Status.Success) goto L5;
        return true;
    L5:
        return false;
    }
}
