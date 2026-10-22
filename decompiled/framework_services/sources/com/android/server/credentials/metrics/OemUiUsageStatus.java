package com.android.server.credentials.metrics;

import android.credentials.selection.IntentCreationResult;

/* JADX INFO: loaded from: classes.dex */
public final enum OemUiUsageStatus extends Enum<OemUiUsageStatus> {
    private static final /* synthetic */ OemUiUsageStatus[] $VALUES = null;
    public static final OemUiUsageStatus FAILURE_NOT_SPECIFIED = null;
    public static final OemUiUsageStatus FAILURE_SPECIFIED_BUT_NOT_ENABLED = null;
    public static final OemUiUsageStatus FAILURE_SPECIFIED_BUT_NOT_FOUND = null;
    public static final OemUiUsageStatus SUCCESS = null;
    public static final OemUiUsageStatus UNKNOWN = null;
    private final int mLoggingInt;

    /* JADX INFO: renamed from: com.android.server.credentials.metrics.OemUiUsageStatus$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus = null;

        static {
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus = new int[IntentCreationResult.OemUiUsageStatus.values().length];
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[IntentCreationResult.OemUiUsageStatus.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L27:
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[IntentCreationResult.OemUiUsageStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L21:
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[IntentCreationResult.OemUiUsageStatus.OEM_UI_CONFIG_NOT_SPECIFIED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L19:
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[IntentCreationResult.OemUiUsageStatus.OEM_UI_CONFIG_SPECIFIED_BUT_NOT_FOUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[IntentCreationResult.OemUiUsageStatus.OEM_UI_CONFIG_SPECIFIED_FOUND_BUT_NOT_ENABLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private static /* synthetic */ OemUiUsageStatus[] $values() {
        return new OemUiUsageStatus[]{UNKNOWN, SUCCESS, FAILURE_NOT_SPECIFIED, FAILURE_SPECIFIED_BUT_NOT_FOUND, FAILURE_SPECIFIED_BUT_NOT_ENABLED};
    }

    public static OemUiUsageStatus valueOf(String name) {
        return (OemUiUsageStatus) Enum.valueOf(OemUiUsageStatus.class, name);
    }

    public static OemUiUsageStatus[] values() {
        return (OemUiUsageStatus[]) $VALUES.clone();
    }

    static {
        UNKNOWN = new OemUiUsageStatus("UNKNOWN", 0, 0);
        SUCCESS = new OemUiUsageStatus("SUCCESS", 1, 1);
        FAILURE_NOT_SPECIFIED = new OemUiUsageStatus("FAILURE_NOT_SPECIFIED", 2, 2);
        FAILURE_SPECIFIED_BUT_NOT_FOUND = new OemUiUsageStatus("FAILURE_SPECIFIED_BUT_NOT_FOUND", 3, 3);
        FAILURE_SPECIFIED_BUT_NOT_ENABLED = new OemUiUsageStatus("FAILURE_SPECIFIED_BUT_NOT_ENABLED", 4, 4);
        $VALUES = $values();
    }

    private OemUiUsageStatus(String r1, int r2, int loggingInt) {
        super(r1, r2);
        this.mLoggingInt = loggingInt;
    }

    public int getLoggingInt() {
        return this.mLoggingInt;
    }

    public static OemUiUsageStatus createFrom(IntentCreationResult.OemUiUsageStatus from) {
        switch(AnonymousClass1.$SwitchMap$android$credentials$selection$IntentCreationResult$OemUiUsageStatus[from.ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            default: goto L5;
        };
    L5:
        return UNKNOWN;
    L7:
        return FAILURE_SPECIFIED_BUT_NOT_ENABLED;
    L9:
        return FAILURE_SPECIFIED_BUT_NOT_FOUND;
    L11:
        return FAILURE_NOT_SPECIFIED;
    L13:
        return SUCCESS;
    L15:
        return UNKNOWN;
    }
}
