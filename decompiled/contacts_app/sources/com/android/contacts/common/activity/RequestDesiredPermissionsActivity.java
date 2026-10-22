package com.android.contacts.common.activity;

import android.app.Activity;
import android.os.Bundle;
import com.android.contacts.common.util.PermissionsUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class RequestDesiredPermissionsActivity extends RequestPermissionsActivityBase {
    private static final String[] DESIRED_PERMISSIONS = null;

    public void com_android_contacts_common_activity_RequestDesiredPermissionsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_activity_RequestDesiredPermissionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public RequestDesiredPermissionsActivity() {
    }

    static {
        DESIRED_PERMISSIONS = new String[]{PermissionsUtil.LOCATION, "android.permission.READ_CALENDAR"};
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getRequiredPermissions() {
        return DESIRED_PERMISSIONS;
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getDesiredPermissions() {
        return DESIRED_PERMISSIONS;
    }

    public static boolean startPermissionActivity(Activity r3) {
        Bundle r0 = r3.getIntent().getExtras();
        if (r0 == null) goto L8;
        if (r0.getBoolean("started_permissions_activity", false) == false) goto L8;
        return false;
    L8:
        return startPermissionActivity(r3, DESIRED_PERMISSIONS, RequestDesiredPermissionsActivity.class);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int r1, String[] r2, int[] r3) {
        this.mPreviousActivityIntent.setFlags(65536);
        startActivity(this.mPreviousActivityIntent);
        overridePendingTransition(0, 0);
        finish();
        overridePendingTransition(0, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_activity_RequestDesiredPermissionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestDesiredPermissionsActivity r1) {
        r1.com_android_contacts_common_activity_RequestDesiredPermissionsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
