package com.stepos.framework.chooser;

/* loaded from: classes.dex */
public final class StepOSUserHandleExt {
    public static final int PARALLEL_SPACE_USER_ID = 999;

    private StepOSUserHandleExt() {
    }

    public static boolean isMultiOpenUserId(int userId) {
        return 999 == userId;
    }
}
