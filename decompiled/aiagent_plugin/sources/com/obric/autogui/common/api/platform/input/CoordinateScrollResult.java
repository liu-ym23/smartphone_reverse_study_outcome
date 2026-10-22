package com.obric.autogui.common.api.platform.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: CoordinateScrollResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CoordinateScrollResult {
    public static final Companion Companion = null;
    private final Integer rawCode;
    private final Status status;

    /* JADX INFO: compiled from: CoordinateScrollResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        public final CoordinateScrollResult fromFrameworkCode(int r2) {
            switch(r2) {
                case -5: goto L13;
                case -4: goto L12;
                case -3: goto L11;
                case -2: goto L10;
                case -1: goto L9;
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L5;
                case 4: goto L4;
                default: goto L3;
            };
        L3:
            Status r1 = Status.UNKNOWN;
        L15:
            return new CoordinateScrollResult(r1, Integer.valueOf(r2));
        L4:
            r1 = Status.FALLBACK_REQUIRED;
            goto L15
        L5:
            r1 = Status.SUCCESS_NATIVE_NO_TAIL_INJECTION;
            goto L15
        L6:
            r1 = Status.SUCCESS_ACCESSIBILITY;
            goto L15
        L7:
            r1 = Status.SUCCESS_NATIVE_VIEW;
            goto L15
        L8:
            r1 = Status.FALLBACK_REQUIRED;
            goto L15
        L9:
            r1 = Status.INVALID_ARGUMENT;
            goto L15
        L10:
            r1 = Status.PERMISSION_DENIED;
            goto L15
        L11:
            r1 = Status.TARGET_NOT_FOUND;
            goto L15
        L12:
            r1 = Status.REMOTE_ERROR;
            goto L15
        L13:
            r1 = Status.TIMEOUT;
            goto L15
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CoordinateScrollResult unsupported() {
            return new CoordinateScrollResult(Status.UNSUPPORTED, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CoordinateScrollResult permissionDenied() {
            return new CoordinateScrollResult(Status.PERMISSION_DENIED, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CoordinateScrollResult remoteError() {
            return new CoordinateScrollResult(Status.REMOTE_ERROR, null, 2, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CoordinateScrollResult unknown() {
            return new CoordinateScrollResult(Status.UNKNOWN, null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: CoordinateScrollResult.kt */
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status FALLBACK_REQUIRED = null;
        public static final Status INVALID_ARGUMENT = null;
        public static final Status PERMISSION_DENIED = null;
        public static final Status REMOTE_ERROR = null;
        public static final Status SUCCESS_ACCESSIBILITY = null;
        public static final Status SUCCESS_NATIVE_NO_TAIL_INJECTION = null;
        public static final Status SUCCESS_NATIVE_VIEW = null;
        public static final Status TARGET_NOT_FOUND = null;
        public static final Status TIMEOUT = null;
        public static final Status UNKNOWN = null;
        public static final Status UNSUPPORTED = null;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS_NATIVE_VIEW, SUCCESS_NATIVE_NO_TAIL_INJECTION, SUCCESS_ACCESSIBILITY, FALLBACK_REQUIRED, INVALID_ARGUMENT, PERMISSION_DENIED, TARGET_NOT_FOUND, REMOTE_ERROR, TIMEOUT, UNSUPPORTED, UNKNOWN};
        }

        public static a<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        static {
            SUCCESS_NATIVE_VIEW = new Status("SUCCESS_NATIVE_VIEW", 0);
            SUCCESS_NATIVE_NO_TAIL_INJECTION = new Status("SUCCESS_NATIVE_NO_TAIL_INJECTION", 1);
            SUCCESS_ACCESSIBILITY = new Status("SUCCESS_ACCESSIBILITY", 2);
            FALLBACK_REQUIRED = new Status("FALLBACK_REQUIRED", 3);
            INVALID_ARGUMENT = new Status("INVALID_ARGUMENT", 4);
            PERMISSION_DENIED = new Status("PERMISSION_DENIED", 5);
            TARGET_NOT_FOUND = new Status("TARGET_NOT_FOUND", 6);
            REMOTE_ERROR = new Status("REMOTE_ERROR", 7);
            TIMEOUT = new Status("TIMEOUT", 8);
            UNSUPPORTED = new Status("UNSUPPORTED", 9);
            UNKNOWN = new Status("UNKNOWN", 10);
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

    /* JADX INFO: compiled from: CoordinateScrollResult.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Status.values().length];
            r0[Status.FALLBACK_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[Status.INVALID_ARGUMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[Status.PERMISSION_DENIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[Status.TARGET_NOT_FOUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[Status.UNSUPPORTED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[Status.SUCCESS_NATIVE_VIEW.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[Status.SUCCESS_NATIVE_NO_TAIL_INJECTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[Status.SUCCESS_ACCESSIBILITY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[Status.REMOTE_ERROR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[Status.TIMEOUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[Status.UNKNOWN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ CoordinateScrollResult copy$default(CoordinateScrollResult r0, Status r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.rawCode;
    L9:
        return r0.copy(r1, r2);
    }

    public final Status component1() {
        return this.status;
    }

    public final Integer component2() {
        return this.rawCode;
    }

    public final CoordinateScrollResult copy(Status r1, Integer r2) {
        o.e(r1, "status");
        return new CoordinateScrollResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CoordinateScrollResult.class) == true) goto L8;
        return false;
    L8:
        CoordinateScrollResult r6 = (CoordinateScrollResult) ZeusTransformUtils.preCheckCast(r5, CoordinateScrollResult.class, "com.obric.aiagent.plugin");
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (o.a(this.rawCode, r6.rawCode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.status.hashCode() * 31;
        Integer r1 = this.rawCode;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CoordinateScrollResult(status=" + this.status + ", rawCode=" + this.rawCode + ')';
    }

    public CoordinateScrollResult(Status r2, Integer r3) {
        o.e(r2, "status");
        this.status = r2;
        this.rawCode = r3;
    }

    public /* synthetic */ CoordinateScrollResult(Status r1, Integer r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Integer getRawCode() {
        return this.rawCode;
    }

    public final boolean isSuccess() {
        if (this.status != Status.SUCCESS_NATIVE_VIEW) goto L5;
    L10:
        return true;
    L5:
        if (this.status == Status.SUCCESS_NATIVE_NO_TAIL_INJECTION) goto L10;
        if (this.status == Status.SUCCESS_ACCESSIBILITY) goto L10;
        return false;
    }

    public final boolean getShouldFallbackToTouch() {
        Status r1 = this.status;
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new k();
    }
}
