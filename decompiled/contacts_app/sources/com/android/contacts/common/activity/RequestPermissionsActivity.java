package com.android.contacts.common.activity;

import android.app.Activity;
import android.widget.Toast;
import com.android.contacts.common.R;
import com.android.contacts.common.util.PermissionsUtil;

/* JADX INFO: loaded from: classes.dex */
public class RequestPermissionsActivity extends RequestPermissionsActivityBase {
    private static final String[] REQUIRED_PERMISSIONS = null;

    public RequestPermissionsActivity() {
    }

    static {
        REQUIRED_PERMISSIONS = new String[]{PermissionsUtil.CONTACTS, "android.permission.READ_CALL_LOG"};
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getRequiredPermissions() {
        return REQUIRED_PERMISSIONS;
    }

    @Override // com.android.contacts.common.activity.RequestPermissionsActivityBase
    protected String[] getDesiredPermissions() {
        return new String[]{PermissionsUtil.LOCATION, PermissionsUtil.CONTACTS, "android.permission.READ_CALL_LOG", "android.permission.READ_CALENDAR", "android.permission.READ_SMS"};
    }

    public static boolean startPermissionActivity(Activity r2) {
        return startPermissionActivity(r2, REQUIRED_PERMISSIONS, RequestPermissionsActivity.class);
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        if (r3 != null) goto L5;
    L13:
        Toast.makeText(this, R.string.missing_required_permission, 0).show();
        finish();
        return;
    L5:
        if (r3.length <= 0) goto L13;
        if (isAllGranted(r3, r4) == false) goto L13;
        this.mPreviousActivityIntent.setFlags(65536);
        if (this.mIsCallerSelf == false) goto L11;
        startActivityForResult(this.mPreviousActivityIntent, 0);
    L12:
        finish();
        overridePendingTransition(0, 0);
        return;
    L11:
        startActivity(this.mPreviousActivityIntent);
        goto L12
    }
}
