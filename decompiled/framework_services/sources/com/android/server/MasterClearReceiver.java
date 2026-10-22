package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.am.ProcessList;
import com.android.server.utils.Slogf;

/* JADX INFO: loaded from: classes.dex */
public class MasterClearReceiver extends BroadcastReceiver {
    private static final String TAG = "MasterClear";
    private boolean mShowWipeProgress;
    private boolean mWipeEsims;
    private boolean mWipeExternalStorage;

    private class WipeDataTask extends AsyncTask<Void, Void, Void> {
        private final Thread mChainedTask;
        private final Context mContext;
        private final ProgressDialog mProgressDialog;
        final /* synthetic */ MasterClearReceiver this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public WipeDataTask(MasterClearReceiver r2, Context context, Thread chainedTask) {
            this.this$0 = r2;
            this.mContext = context;
            this.mChainedTask = chainedTask;
            if (MasterClearReceiver.m263$$Nest$fgetmShowWipeProgress(r2) == false) goto L5;
            ProgressDialog r3 = new ProgressDialog(context, R.style.Widget.Holo.Light.TimePicker);
        L6:
            this.mProgressDialog = r3;
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (this.mProgressDialog == null) goto L6;
            this.mProgressDialog.setIndeterminate(true);
            this.mProgressDialog.getWindow().setType(2003);
            this.mProgressDialog.setMessage(this.mContext.getText(R.string.share));
            this.mProgressDialog.show();
            return;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... params) {
            Slog.w(MasterClearReceiver.TAG, "Wiping adoptable disks");
            if (MasterClearReceiver.m265$$Nest$fgetmWipeExternalStorage(this.this$0) == false) goto L7;
            StorageManager sm = (StorageManager) this.mContext.getSystemService("storage");
            sm.wipeAdoptableDisks();
            return null;
        L7:
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void result) {
            if (this.mProgressDialog != null) goto L5;
        L7:
            this.mChainedTask.start();
            return;
        L5:
            if (this.mProgressDialog.isShowing() == false) goto L7;
            this.mProgressDialog.dismiss();
            goto L7
        }
    }

    public static /* synthetic */ Boolean $r8$lambda$9aOuDFYkRzbvHURhmziKxJ1Ffd8(MasterClearReceiver r0, Context r1, int r2, String r3) {
        return r0.lambda$onReceive$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ogrxNN6r3QFokS_K50SX-VPKHAE, reason: not valid java name */
    public static /* synthetic */ String m262$r8$lambda$ogrxNN6r3QFokS_K50SXVPKHAE(Context r0) {
        return lambda$getWorkProfileDeletedTitle$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShowWipeProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m263$$Nest$fgetmShowWipeProgress(MasterClearReceiver r0) {
        return r0.mShowWipeProgress;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWipeEsims, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m264$$Nest$fgetmWipeEsims(MasterClearReceiver r0) {
        return r0.mWipeEsims;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWipeExternalStorage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m265$$Nest$fgetmWipeExternalStorage(MasterClearReceiver r0) {
        return r0.mWipeExternalStorage;
    }

    public MasterClearReceiver() {
        this.mShowWipeProgress = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE") == false) goto L9;
        if ("google.com".equals(intent.getStringExtra("from")) == true) goto L9;
        Slog.w(TAG, "Ignoring master clear request -- not from trusted server.");
        return;
    L9:
        if ("android.intent.action.MASTER_CLEAR".equals(intent.getAction()) == false) goto L12;
        Slog.w(TAG, "The request uses the deprecated Intent#ACTION_MASTER_CLEAR, Intent#ACTION_FACTORY_RESET should be used instead.");
    L12:
        if (intent.hasExtra("android.intent.extra.FORCE_MASTER_CLEAR") == false) goto L14;
        Slog.w(TAG, "The request uses the deprecated Intent#EXTRA_FORCE_MASTER_CLEAR, Intent#EXTRA_FORCE_FACTORY_RESET should be used instead.");
    L14:
        String factoryResetPackage = context.getString(R.string.config_pdp_reject_service_not_subscribed);
        if ("android.intent.action.FACTORY_RESET".equals(intent.getAction()) == true) goto L17;
    L20:
        final String reason = intent.getStringExtra("android.intent.extra.REASON");
        this.mShowWipeProgress = intent.getBooleanExtra("android.intent.extra.SHOW_WIPE_PROGRESS", true);
        final boolean shutdown = intent.getBooleanExtra("shutdown", false);
        this.mWipeExternalStorage = intent.getBooleanExtra("android.intent.extra.WIPE_EXTERNAL_STORAGE", false);
        this.mWipeEsims = intent.getBooleanExtra("com.android.internal.intent.extra.WIPE_ESIMS", false);
        if (intent.getBooleanExtra("android.intent.extra.FORCE_MASTER_CLEAR", false) == false) goto L23;
    L26:
        final boolean forceWipe = true;
    L27:
        final boolean keepMemtagMode = intent.getBooleanExtra("keep_memtag_mode", false);
        final int sendingUserId = getSendingUserId();
        if (sendingUserId != 0) goto L30;
    L35:
        Slog.w(TAG, "!!! FACTORY RESET !!!");
        final String r6 = "Reboot";
        Thread thr = new AnonymousClass1(this, r6, shutdown, reason, forceWipe, keepMemtagMode, context);
        if (this.mWipeExternalStorage == false) goto L38;
        Slog.i(TAG, "Wiping external storage on async task");
        new WipeDataTask(this, context, thr).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    L38:
        Slog.i(TAG, "NOT wiping external storage; starting thread " + thr.getName());
        thr.start();
        return;
    L30:
        if (UserManager.isHeadlessSystemUserMode() == true) goto L35;
        Slogf.w(TAG, "ACTION_FACTORY_RESET received on a non-system user %d, WIPING THE USER!!", new Object[]{Integer.valueOf(sendingUserId)});
        if (((Boolean) Binder.withCleanCallingIdentity(new MasterClearReceiver$$ExternalSyntheticLambda0(this, context, sendingUserId, reason))).booleanValue() == true) goto L40;
        Slogf.e(TAG, "Failed to wipe user %d", new Object[]{Integer.valueOf(sendingUserId)});
        return;
    L40:
        return;
    L23:
        if (intent.getBooleanExtra("android.intent.extra.FORCE_FACTORY_RESET", false) == true) goto L26;
        forceWipe = false;
        goto L27
    L17:
        if (TextUtils.isEmpty(factoryResetPackage) == true) goto L20;
        Slog.i(TAG, "Re-directing intent to " + factoryResetPackage);
        intent.setPackage(factoryResetPackage).setComponent(null);
        context.sendBroadcastAsUser(intent, UserHandle.SYSTEM);
    }

    private /* synthetic */ Boolean lambda$onReceive$0(Context context, int sendingUserId, String reason) throws Exception {
        return Boolean.valueOf(wipeUser(context, sendingUserId, reason));
    }

    private boolean wipeUser(Context context, int userId, String wipeReason) {
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        int result = userManager.removeUserWhenPossible(UserHandle.of(userId), false);
        if (UserManager.isRemoveResultSuccessful(result) == true) goto L7;
        Slogf.e(TAG, "Can't remove user %d", new Object[]{Integer.valueOf(userId)});
        return false;
    L7:
        if (getCurrentForegroundUserId() != userId) goto L17;
        if (ActivityManager.getService().switchUser(0) == true) goto L17;
        Slogf.w(TAG, "Can't switch from current user %d, user will get removed when it is stopped.", new Object[]{Integer.valueOf(userId)});     // Catch: RemoteException -> L12
    L15:
        Slogf.w(TAG, "Can't switch from current user %d, user will get removed when it is stopped.", new Object[]{Integer.valueOf(userId)});
    L17:
        if (userManager.isManagedProfile(userId) == false) goto L23;
        sendWipeProfileNotification(context, wipeReason);
        return true;
    L23:
        return true;
    }

    private void sendWipeProfileNotification(Context context, String wipeReason) {
        Notification notification = new Notification.Builder(context, "DEVICE_ADMIN_ALERTS").setSmallIcon(R.drawable.stat_sys_warning).setContentTitle(getWorkProfileDeletedTitle(context)).setContentText(wipeReason).setColor(context.getColor(R.color.system_notification_accent_color)).setStyle(new Notification.BigTextStyle().bigText(wipeReason)).build();
        ((NotificationManager) context.getSystemService(NotificationManager.class)).notify(1001, notification);
    }

    private String getWorkProfileDeletedTitle(final Context context) {
        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(DevicePolicyManager.class);
        return dpm.getResources().getString("Core.WORK_PROFILE_DELETED_TITLE", new MasterClearReceiver$$ExternalSyntheticLambda1(context));
    }

    private static /* synthetic */ String lambda$getWorkProfileDeletedTitle$1(Context context) {
        return context.getString(17042438);
    }

    private int getCurrentForegroundUserId() {
        return ActivityManager.getCurrentUser();
    L4:
        e = move-exception;
        Slogf.e(TAG, "Can't get current user", e);
        return ProcessList.INVALID_ADJ;
    }
}
