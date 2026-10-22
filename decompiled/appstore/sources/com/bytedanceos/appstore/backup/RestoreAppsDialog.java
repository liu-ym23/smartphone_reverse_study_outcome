package com.bytedanceos.appstore.backup;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.bytedanceos.appstore.ui.MainActivity;
import com.bytedanceos.appstore.utils.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.ConfirmDialog;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class RestoreAppsDialog extends Activity implements CommonConfirmDialog.DialogOnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f8280a = "data_transfer_success";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8281b = "mobile_data";

    static {
    }

    public RestoreAppsDialog() {
    }

    public final void a(int r10) {
        if (a.n(this, r10) == false) goto L5;
        a.E(this, r10);
        return;
    L5:
        t8.a.a(c8.a.m(r10, 0));
    }

    public final boolean b() {
        long r10 = getIntent().getLongExtra("start_time", 0);     // Catch: Exception -> L5
    L8:
        if (r10 >= 0) goto L10;
    L14:
        j.a("timeout:" + r10);
        return true;
    L10:
        if ((System.currentTimeMillis() - r10) > 1000) goto L14;
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r10 = 0;
        goto L8
    }

    public final void c(int r10) {
        ConfirmDialog r11 = ConfirmDialog.newInstance(r10, true, null);
        if (r10 != 17) goto L5;
        String r12 = f8280a;
    L6:
        r11.show(getFragmentManager(), r12);
        j.a("show dailog:" + r12);
        return;
    L5:
        r12 = f8281b;
        goto L6
    }

    @Override // com.bytedanceos.common.ui.CommonConfirmDialog.DialogOnClickListener
    public void onButtonClick(int r10, int r11, boolean r12, Bundle r13) {
        if (r11 == (-2)) goto L12;
        if (r11 != (-1)) goto L7;
        a(133);
        finish();
        return;
    L7:
        if (r11 == 4) goto L9;
        j.a("finish dialog:" + r10);
        return;
    L9:
        b0.n().I("back_info", null, this);
        j.a("cancel restore apps");
        finish();
        return;
    L12:
        if (r10 != 17) goto L15;
        c(18);
        return;
    L15:
        a(134);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        BaseApplication.u("RestoreAppsActivity", false);
        if (r10 == null) goto L5;
    L8:
        setContentView(new RelativeLayout(this));
        c(17);
        return;
    L5:
        if (b() == false) goto L8;
        startActivity(new Intent(this, MainActivity.class));
        finish();
        j.a("time out,then jump to AppStoreActivity");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.u("RestoreAppsActivity", true);
    }
}
