package com.android.server.policy;

import android.app.TaskInfo;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PermissionPolicyInternal {

    public interface OnInitializedCallback {
        void onInitialized(int r1);
    }

    public abstract boolean checkStartActivity(Intent r1, int r2, String r3);

    public abstract boolean isInitialized(int r1);

    public abstract boolean isIntentToPermissionDialog(Intent r1);

    public abstract void setOnInitializedCallback(OnInitializedCallback r1);

    public abstract boolean shouldShowNotificationDialogForTask(TaskInfo r1, String r2, String r3, Intent r4, String r5);

    public abstract void showNotificationPromptIfNeeded(String r1, int r2, int r3);

    public PermissionPolicyInternal() {
    }
}
