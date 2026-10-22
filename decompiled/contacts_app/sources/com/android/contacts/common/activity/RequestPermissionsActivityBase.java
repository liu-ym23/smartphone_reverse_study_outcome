package com.android.contacts.common.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.contacts.common.model.AccountTypeManager;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestPermissionsActivityBase extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    protected static final String EXTRA_IS_CALLER_SELF = "is_caller_self";
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    public static final String PREVIOUS_ACTIVITY_INTENT = "previous_intent";
    protected static final String STARTED_PERMISSIONS_ACTIVITY = "started_permissions_activity";
    protected boolean mIsCallerSelf;
    protected Intent mPreviousActivityIntent;

    protected abstract String[] getDesiredPermissions();

    protected abstract String[] getRequiredPermissions();

    public RequestPermissionsActivityBase() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mPreviousActivityIntent = (Intent) getIntent().getExtras().get(PREVIOUS_ACTIVITY_INTENT);
        this.mIsCallerSelf = getIntent().getBooleanExtra(EXTRA_IS_CALLER_SELF, false);
        if (r4 != null) goto L6;
        requestPermissions();
        return;
    }

    protected static boolean startPermissionActivity(Activity r1, String[] r2, Class<?> r3) {
        return startPermissionActivity(r1, r2, false, r3);
    }

    protected static boolean startPermissionActivity(Activity r2, String[] r3, boolean r4, Class<?> r5) {
        if (hasPermissions(r2, r3) == true) goto L6;
        Intent r6 = new Intent(r2, r5);
        r2.getIntent().putExtra(STARTED_PERMISSIONS_ACTIVITY, true);
        r6.putExtra(PREVIOUS_ACTIVITY_INTENT, r2.getIntent());
        r6.putExtra(EXTRA_IS_CALLER_SELF, r4);
        r2.startActivity(r6);
        r2.finish();
        return true;
    L6:
        AccountTypeManager.getInstance(r2);
        return false;
    }

    protected boolean isAllGranted(String[] r4, int[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L11;
        if (r5[r1] == 0) goto L10;
        if (isPermissionRequired(r4[r1]) == false) goto L10;
        return false;
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        return true;
    }

    private boolean isPermissionRequired(String r1) {
        return Arrays.asList(getRequiredPermissions()).contains(r1);
    }

    private void requestPermissions() {
        Trace.beginSection("requestPermissions");
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L16
        String[] r1 = getDesiredPermissions();     // Catch: Throwable -> L16
        int r2 = r1.length;     // Catch: Throwable -> L16
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L10;
        String r4 = r1[r3];     // Catch: Throwable -> L16
        if (checkSelfPermission(r4) == 0) goto L8;
        r0.add(r4);     // Catch: Throwable -> L16
    L8:
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L4
    L10:
        if (r0.size() == 0) goto L15;
        ActivityCompat.requestPermissions(this, (String[]) r0.toArray(new String[r0.size()]), 1);     // Catch: Throwable -> L16
        Trace.endSection();
        return;
    L15:
        throw new RuntimeException("Request permission activity was called even though all permissions are satisfied.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkSelfPermission(String r1) {
        return ContextCompat.checkSelfPermission(this, r1);
    }

    protected static boolean hasPermissions(Context r4, String[] r5) {
        Trace.beginSection("hasPermission");
        int r0 = r5.length;     // Catch: Throwable -> L12
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L10;
        if (ContextCompat.checkSelfPermission(r4, r5[r2]) != 0) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        Trace.endSection();
        return false;
    L10:
        Trace.endSection();
        return true;
    L12:
        th = move-exception;
        Trace.endSection();
        throw th;
    }
}
