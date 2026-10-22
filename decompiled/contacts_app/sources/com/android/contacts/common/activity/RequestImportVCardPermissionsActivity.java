package com.android.contacts.common.activity;

import android.app.Activity;
import com.android.contacts.common.util.PermissionsUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class RequestImportVCardPermissionsActivity extends RequestPermissionsActivity {
    private static final String[] REQUIRED_PERMISSIONS = null;

    public void com_android_contacts_common_activity_RequestImportVCardPermissionsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_activity_RequestImportVCardPermissionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public RequestImportVCardPermissionsActivity() {
    }

    static {
        REQUIRED_PERMISSIONS = new String[]{PermissionsUtil.CONTACTS, "android.permission.READ_EXTERNAL_STORAGE"};
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivity, com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getRequiredPermissions() {
        return REQUIRED_PERMISSIONS;
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivity, com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getDesiredPermissions() {
        return REQUIRED_PERMISSIONS;
    }

    public static boolean startPermissionActivity(Activity r2, boolean r3) {
        return startPermissionActivity(r2, REQUIRED_PERMISSIONS, r3, RequestImportVCardPermissionsActivity.class);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_activity_RequestImportVCardPermissionsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RequestImportVCardPermissionsActivity r1) {
        r1.com_android_contacts_common_activity_RequestImportVCardPermissionsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
