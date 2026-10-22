package com.android.server.appfunctions;

import android.os.UserHandle;
import com.android.internal.infra.AndroidFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public interface CallerValidator {
    public static final int CAN_EXECUTE_APP_FUNCTIONS_ALLOWED_HAS_PERMISSION = 2;
    public static final int CAN_EXECUTE_APP_FUNCTIONS_ALLOWED_SAME_PACKAGE = 1;
    public static final int CAN_EXECUTE_APP_FUNCTIONS_DENIED = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CanExecuteAppFunctionResult {
    }

    String validateCallingPackage(String r1);

    AndroidFuture<Integer> verifyCallerCanExecuteAppFunction(int r1, int r2, UserHandle r3, String r4, String r5, String r6);

    boolean verifyEnterprisePolicyIsAllowed(UserHandle r1, UserHandle r2);

    UserHandle verifyTargetUserHandle(UserHandle r1, String r2);
}
