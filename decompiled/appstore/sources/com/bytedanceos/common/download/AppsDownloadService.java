package com.bytedanceos.common.download;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes2.dex */
public class AppsDownloadService extends IntentService {
    public AppsDownloadService() {
        super("com.bytedanceos.appstore.AppsDownloadService");
    }

    public final void a(Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        AppInfo r11 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r11 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r11.appPackageName) == true) goto L26;
        r11.mAllowMobile = r10.getBooleanExtra("mobile", false);
        j.n("[AppStatus][AppsDownloadService] downloadApp info.mallowMobile: " + r11.mAllowMobile + ", info,isAutoDownload: " + r11.isAutoDownload + " packageName: " + r11.appPackageName);
        if (r11.isAutoDownload == true) goto L12;
    L23:
        b.l().g(r11);
        return;
    L12:
        if (r11.mIsPushReservation == false) goto L18;
        if (e.u0() == true) goto L18;
        j.n("[AutoUpdate][AppStatus] stop reserve auto download:" + r11.appPackageName);
        return;
    L18:
        if (r11.mIsPushReservation == true) goto L23;
        if (e.l0() == true) goto L23;
        j.n("[AutoUpdate][AppStatus] stop auto download:" + r11.appPackageName);
        return;
    }

    @Override // android.app.IntentService, android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r10) {
        j.n("[AppStatus][AppsDownloadService] Receiver Intent:" + r10);
        byte r11 = 0;
        BaseApplication.u("AppsDownloadService", false);
        if (r10 != null) goto L5;
    L82:
        BaseApplication.u("AppsDownloadService", true);
        return;
    L5:
        if (TextUtils.isEmpty(r10.getAction()) == true) goto L82;
        String r12 = r10.getAction();
        r12.hashCode();
        switch(r12.hashCode()) {
            case -1660760437: goto L66;
            case -1655058423: goto L62;
            case -1652133970: goto L58;
            case -837480341: goto L54;
            case -722050840: goto L50;
            case -719126387: goto L46;
            case -537949627: goto L42;
            case -536344197: goto L38;
            case -533419744: goto L34;
            case -191885675: goto L30;
            case 364538872: goto L26;
            case 491412459: goto L22;
            case 629603933: goto L18;
            case 1082682991: goto L14;
            case 1085607444: goto L10;
            default: goto L8;
        };
    L8:
        r11 = -1;
    L68:
        switch(r11) {
            case 0: goto L81;
            case 1: goto L80;
            case 2: goto L80;
            case 3: goto L80;
            case 4: goto L79;
            case 5: goto L79;
            case 6: goto L78;
            case 7: goto L77;
            case 8: goto L76;
            case 9: goto L75;
            case 10: goto L74;
            case 11: goto L73;
            case 12: goto L72;
            case 13: goto L71;
            case 14: goto L70;
            default: goto L82;
        };
    L70:
        b.l().o(r10);
        goto L82
    L71:
        b.l().n(r10);
        goto L82
    L72:
        b.l().b();
        goto L82
    L73:
        b.l().i(r10);
        goto L82
    L74:
        b.l().a(r10);
        goto L82
    L75:
        b.l().h();
        goto L82
    L76:
        b.l().d(r10);
        goto L82
    L77:
        b.l().c(r10);
        goto L82
    L78:
        b.l().p();
        goto L82
    L79:
        b.l().t(r10);
        goto L82
    L80:
        a(r10);
        goto L82
    L81:
        b.l().e(r10);
        goto L82
    L10:
        if (r12.equals("appstore.intent.pause.other") == false) goto L84;
        r11 = Ascii.SO;
        goto L68
    L84:
        r11 = -1;
        goto L68
    L14:
        if (r12.equals("appstore.intent.pause.local") == false) goto L85;
        r11 = Ascii.CR;
        goto L68
    L85:
        r11 = -1;
        goto L68
    L18:
        if (r12.equals("appstore.intent.cancel.gms") == false) goto L86;
        r11 = Ascii.FF;
        goto L68
    L86:
        r11 = -1;
        goto L68
    L22:
        if (r12.equals("appstore.intent.download.update") == false) goto L87;
        r11 = Ascii.VT;
        goto L68
    L87:
        r11 = -1;
        goto L68
    L26:
        if (r12.equals("appstore.intent.cancel.auto.update") == false) goto L88;
        r11 = 10;
        goto L68
    L88:
        r11 = -1;
        goto L68
    L30:
        if (r12.equals("appstore.intent.download.next") == false) goto L89;
        r11 = 9;
        goto L68
    L89:
        r11 = -1;
        goto L68
    L34:
        if (r12.equals("appstore.intent.cancel.other") == false) goto L90;
        r11 = 8;
        goto L68
    L90:
        r11 = -1;
        goto L68
    L38:
        if (r12.equals("appstore.intent.cancel.local") == false) goto L91;
        r11 = 7;
        goto L68
    L91:
        r11 = -1;
        goto L68
    L42:
        if (r12.equals("appstore.intent.pause.update") == false) goto L92;
        r11 = 6;
        goto L68
    L92:
        r11 = -1;
        goto L68
    L46:
        if (r12.equals("appstore.intent.continue.other") == false) goto L93;
        r11 = 5;
        goto L68
    L93:
        r11 = -1;
        goto L68
    L50:
        if (r12.equals("appstore.intent.continue.local") == false) goto L94;
        r11 = 4;
        goto L68
    L94:
        r11 = -1;
        goto L68
    L54:
        if (r12.equals("appstore.intent.download.gms") == false) goto L95;
        r11 = 3;
        goto L68
    L95:
        r11 = -1;
        goto L68
    L58:
        if (r12.equals("appstore.intent.download.other") == false) goto L96;
        r11 = 2;
        goto L68
    L96:
        r11 = -1;
        goto L68
    L62:
        if (r12.equals("appstore.intent.download.local") == false) goto L97;
        r11 = 1;
        goto L68
    L97:
        r11 = -1;
        goto L68
    L66:
        if (r12.equals("appstore.intent.cancel.selected") == true) goto L68;
        r11 = -1;
        goto L68
    }
}
