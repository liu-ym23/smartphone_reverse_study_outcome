package com.android.contacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.GlobalProxyLancet;
import com.obric.privacyhook.BaseService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SendShortcutService extends BaseService {
    private static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String CREATE_SHORTCUT_ACTION = "create_shortcut_action";
    public static final String CREATE_SHORTCUT_EXTRA = "create_shortcut_extra";
    private static final int MAX_SHORTCUT_COUNT = 20;
    private static final int MSG_CREATE_SHORTCUT = 1001;
    private static final String TAG = "SendShortcutService";
    private Handler mHandler;
    private int mSentCount;
    private List<Uri> mUris;

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    public SendShortcutService() {
        this.mUris = new ArrayList();
        this.mSentCount = 0;
        this.mHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ int access$000(SendShortcutService r0) {
        return r0.mSentCount;
    }

    static /* synthetic */ List access$100(SendShortcutService r0) {
        return r0.mUris;
    }

    private void createNextShortcut() {
        if (ContactsUtils.isFeaturePhoneMode() == false) goto L5;
        ContactsApplication.showToast(ContactsUtils.getFeaturePhoneModeHintId(), 1);
        stopSelf();
        return;
    L5:
        this.mHandler.removeMessages(1001);
        Handler r0 = this.mHandler;
        if (this.mSentCount != 0) goto L8;
        long r2 = 0;
    L9:
        r0.sendEmptyMessageDelayed(1001, r2);
        return;
    L8:
        r2 = 150;
        goto L9
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BootstrapService.startForeground(this);
        startService(new Intent(this, BootstrapService.class));
    }

    public void setLauncherShortcutData(List<Uri> r4) {
        if (ContactsUtils.DEBUG == false) goto L9;
        StringBuilder r0 = new StringBuilder("Total uri counts: ");
        if (r4 != null) goto L7;
        Integer r1 = null;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r0.append(r1).toString());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Uris: " + r4);
        goto L9
    L7:
        r1 = Integer.valueOf(r4.size());
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isEmpty() == false) goto L13;
        return;
    L13:
        if (r4.size() > 20) goto L15;
        this.mUris.addAll(r4);
    L16:
        createNextShortcut();
        return;
    L15:
        this.mUris.addAll(r4.subList(0, 20));
        goto L16
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    @Override // com.obric.privacyhook.BaseService
    protected void handleAuthorizedAction(Intent r3) {
        if (r3 != null) goto L4;
    L9:
        stopSelf();
        return;
    L4:
        if (CREATE_SHORTCUT_ACTION.equals(r3.getAction()) == false) goto L9;
        ArrayList r4 = r3.getParcelableArrayListExtra(CREATE_SHORTCUT_EXTRA);
        if (r4.isEmpty() == true) goto L9;
        setLauncherShortcutData(r4);
    }
}
