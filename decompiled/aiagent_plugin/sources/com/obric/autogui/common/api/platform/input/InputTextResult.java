package com.obric.autogui.common.api.platform.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: InputTextResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InputTextResult {
    public static final Companion Companion = null;
    private static final InputTextResult OK = null;
    private final Status status;

    /* JADX INFO: compiled from: InputTextResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final InputTextResult getOK() {
            return InputTextResult.access$getOK$cp();
        }
    }

    /* JADX INFO: compiled from: InputTextResult.kt */
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status ApiFailed = null;
        public static final Status NotSupported = null;
        public static final Status Ok = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{Ok, NotSupported, ApiFailed};
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Ok = new Status("Ok", 0);
            NotSupported = new Status("NotSupported", 1);
            ApiFailed = new Status("ApiFailed", 2);
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

    public static /* synthetic */ InputTextResult copy$default(InputTextResult r0, Status r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        return r0.copy(r1);
    }

    public final Status component1() {
        return this.status;
    }

    public final InputTextResult copy(Status r1) {
        o.e(r1, "status");
        return new InputTextResult(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputTextResult.class) == true) goto L8;
        return false;
    L8:
        InputTextResult r6 = (InputTextResult) ZeusTransformUtils.preCheckCast(r5, InputTextResult.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    public String toString() {
        return "InputTextResult(status=" + this.status + ')';
    }

    public InputTextResult(Status r2) {
        o.e(r2, "status");
        this.status = r2;
    }

    public static final /* synthetic */ InputTextResult access$getOK$cp() {
        return OK;
    }

    public final Status getStatus() {
        return this.status;
    }

    static {
        Companion = new Companion(null);
        OK = new InputTextResult(Status.Ok);
    }

    public final boolean isOk() {
        if (this.status != Status.Ok) goto L5;
        return true;
    L5:
        return false;
    }
}
