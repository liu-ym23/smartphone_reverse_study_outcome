package com.obric.autogui.common.api.platform.packages;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StartActivityResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StartActivityResult {
    public static final Companion Companion = null;
    private static final StartActivityResult OK = null;
    private final Status status;

    /* JADX INFO: compiled from: StartActivityResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final StartActivityResult getOK() {
            return StartActivityResult.access$getOK$cp();
        }
    }

    /* JADX INFO: compiled from: StartActivityResult.kt */
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ApiFailed = null;
        public static final Status NotSupported = null;
        public static final Status Ok = null;
        public static final Status SpaceNotFound = null;
        public static final Status TargetNotFound = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Ok, SpaceNotFound, NotSupported, TargetNotFound, ApiFailed};
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Ok = new Status("Ok", 0);
            SpaceNotFound = new Status("SpaceNotFound", 1);
            NotSupported = new Status("NotSupported", 2);
            TargetNotFound = new Status("TargetNotFound", 3);
            ApiFailed = new Status("ApiFailed", 4);
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

    public static /* synthetic */ StartActivityResult copy$default(StartActivityResult r0, Status r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        return r0.copy(r1);
    }

    public final Status component1() {
        return this.status;
    }

    public final StartActivityResult copy(Status r1) {
        o.e(r1, "status");
        return new StartActivityResult(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, StartActivityResult.class) == true) goto L8;
        return false;
    L8:
        StartActivityResult r6 = (StartActivityResult) ZeusTransformUtils.preCheckCast(r5, StartActivityResult.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "StartActivityResult(status=" + this.status + ')';
    }

    public StartActivityResult(Status r2) {
        o.e(r2, "status");
        this.status = r2;
    }

    public static final /* synthetic */ StartActivityResult access$getOK$cp() {
        return OK;
    }

    public final Status getStatus() {
        return this.status;
    }

    static {
        Companion = new Companion(null);
        OK = new StartActivityResult(Status.Ok);
    }

    public final boolean getOk() {
        if (this.status != Status.Ok) goto L5;
        return true;
    L5:
        return false;
    }
}
