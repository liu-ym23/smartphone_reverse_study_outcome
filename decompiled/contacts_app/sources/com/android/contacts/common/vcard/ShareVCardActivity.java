package com.android.contacts.common.vcard;

import android.content.ComponentName;
import android.os.IBinder;
import androidx.core.content.FileProvider;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ShareVCardActivity extends ExportVCardActivity {
    private static final String LOG_TAG = "VCardShare";
    private final long A_DAY_IN_MILLIS;
    private final String EXPORT_FILE_PREFIX;

    public void com_android_contacts_common_vcard_ShareVCardActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_vcard_ShareVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ShareVCardActivity() {
        this.EXPORT_FILE_PREFIX = "vcards_";
        this.A_DAY_IN_MILLIS = 86400000;
    }

    @Override // com.android.contacts.common.vcard.ExportVCardActivity, android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName r3, IBinder r4) {
        monitor-enter(this);
        this.mConnected = true;     // Catch: Throwable -> L14
        this.mService = ((VCardService.MyBinder) r4).getService();     // Catch: Throwable -> L14
        clearExportFiles();     // Catch: Throwable -> L14
        File r5 = getLocalFile();     // Catch: Throwable -> L14
        r5.createNewFile();     // Catch: IOException -> L10 Throwable -> L14
        this.mService.handleExportRequest(new ExportRequest(FileProvider.getUriForFile(this, getString(R.string.contacts_file_provider_authority), r5)), new NotificationImportExportListener(this));     // Catch: Throwable -> L14
        unbindAndFinish();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to create .vcf file, because: " + e);     // Catch: Throwable -> L14
        unbindAndFinish();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void clearExportFiles() {
        File[] r7 = getCacheDir().listFiles();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        File r2 = r7[r1];
        long r3 = System.currentTimeMillis() - r2.lastModified();
        if (r2.getName().startsWith("vcards_") == false) goto L9;
        if (r3 <= 86400000) goto L9;
        r2.delete();
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private File getLocalFile() {
        return new File(getCacheDir(), "vcards_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()).toString() + ".vcf");
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_vcard_ShareVCardActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ShareVCardActivity r1) {
        r1.com_android_contacts_common_vcard_ShareVCardActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
