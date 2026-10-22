package com.obric.appstore.autoupdate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.util.e;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.b;
import com.obric.oui.dialog.alert.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FindNewVersionDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String TAG = "FindNewVersionDialog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static char[] f22451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f22452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f22455e;
    private boolean f;
    private boolean g;
    private Bundle h;
    private OAlertDialog i;

    /* JADX INFO: renamed from: lambda$69r732Do_V_l-McL2TtiO89GbmA, reason: not valid java name */
    public static /* synthetic */ x m407lambda$69r732Do_V_lMcL2TtiO89GbmA(a r0, FrameLayout r1) {
        return r0.a(r1);
    }

    public static /* synthetic */ void lambda$FDcAmpFzGjVATBU0rJtll0pqRC8(a r0, DialogInterface r1, int r2) {
        r0.c(r1, r2);
    }

    public static /* synthetic */ void lambda$GrjoeTmji3QrWbKEMaTIjWDSSE8(a r0, DialogInterface r1, int r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void lambda$_M8ig_bjYbBpE3q_jD9ysGZVrco(a r0, DialogInterface r1, int r2) {
        r0.a(r1, r2);
    }

    public a(Context r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f22452b = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        this.f22453c = null;
        this.f22454d = 0;
        this.f22455e = null;
        this.f = false;
        this.g = false;
        this.f22452b = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f22453c = r5.getString("auto_update_pkg");
        this.f22454d = r5.getInt("auto_update_model");
        this.h = r5;
        this.g = r5.getBoolean("auto_update_file_exist");
        a(r6);
    }

    private void a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        e<String, Drawable> r0 = k();
        if (r0 != null) goto L5;
    L14:
        a(TAG, "loadLableAndIcon:pair is null. appPkgName = " + this.f22453c);
        return;
    L5:
        if (r0.f1371a == null) goto L14;
        if (r0.f1372b == null) goto L14;
        this.f22455e = (String) ZeusTransformUtils.preCheckCast(r0.f1371a, String.class, "com.obric.aiagent.plugin");
        b r12 = new b(r11).a((Drawable) ZeusTransformUtils.preCheckCast(r0.f1372b, Drawable.class, "com.obric.aiagent.plugin")).a(g.a(56), g.a(56)).a(this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_update_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_title")) + " " + c(), false).a(new c(new $$Lambda$a$69r732Do_V_lMcL2TtiO89GbmA(this))).b(ZeusTransformUtils.mapRes(R.string.auto_update_ok, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_ok"), new $$Lambda$a$FDcAmpFzGjVATBU0rJtll0pqRC8(this)).a(f(), new $$Lambda$a$GrjoeTmji3QrWbKEMaTIjWDSSE8(this));
        if (h() == false) goto L12;
        r12.c(ZeusTransformUtils.mapRes(R.string.obric_auto_update_ignore, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_auto_update_ignore"), new $$Lambda$a$_M8ig_bjYbBpE3q_jD9ysGZVrco(this));
    L12:
        OAlertDialog r13 = r12.a();
        this.i = r13;
        r13.setCanceledOnTouchOutside(true);
        this.i.setCancelable(false);
        b(TAG, "onCreate:" + this.f22453c + "|" + this.f22454d);
    }

    private /* synthetic */ x a(FrameLayout r1) {
        r1.addView(b());
        return null;
    }

    private /* synthetic */ void c(DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        d();
    }

    private /* synthetic */ void b(DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        e();
    }

    private /* synthetic */ void a(DialogInterface r2, int r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin");
        g();
    }

    private View b() {
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from(this.f22452b), ZeusTransformUtils.mapRes(R.layout.obric_auto_update_2, "layout", "obric_auto_update_2"), null, "com.obric.aiagent.plugin");
        ((MaxScrollView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.scrollView, DbHelper.COL_ID, "scrollView")), MaxScrollView.class, "com.obric.aiagent.plugin")).setMaxHeight(g.a(500));
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.app_update_log, DbHelper.COL_ID, "app_update_log")), TextView.class, "com.obric.aiagent.plugin");
        String r4 = this.h.getString("auto_update_log");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r1.setText(r4);
    L6:
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.app_update_tip, DbHelper.COL_ID, "app_update_tip")), TextView.class, "com.obric.aiagent.plugin");
        if (this.g == false) goto L9;
        r2.setText(this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_install_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_install_tips")));
    L10:
        return r0;
    L9:
        r2.setText(j());
        goto L10
    L5:
        b(TAG, "no updateLog");
        goto L6
    }

    private String c() {
        return this.h.getString("auto_update_version_name");
    }

    private void d() {
        if (this.g == false) goto L7;
        ObricAutoUpdateUtils.a().a(this.f22452b, this.f22455e, this.h);
        i();
        return;
    L7:
        if (this.f22454d != 2) goto L9;
        new UpdateProgressDialog(this.f22452b, this.f22453c, this.f22454d).a(300);
    L9:
        ObricAutoUpdateUtils.a().a(this.f22452b, this.f22455e, this.f, this.h);
        i();
    }

    private void e() {
        if (this.f22454d != 2) goto L5;
        Process.killProcess(Process.myPid());
    L6:
        i();
        return;
    L5:
        ObricAutoUpdateUtils.a().a(this.f22452b, this.f22453c, -1);
        goto L6
    }

    private int f() {
        if (this.f22454d != 2) goto L7;
        return android.R.string.cancel;
    L7:
        return ZeusTransformUtils.mapRes(R.string.auto_update_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_cancel");
    }

    private void g() {
        int r0 = this.h.getInt("auto_update_version_code");
        ObricAutoUpdateUtils.a().a(this.f22452b, this.f22453c, r0);
        i();
    }

    private boolean h() {
        if (this.g == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f22454d == 2) goto L7;
        return true;
    }

    private void i() {
        OAlertDialog r0 = this.i;     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    private String j() {
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(this.f22452b.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();
        if (r0 != null) goto L5;
        b(TAG, "networkInfo is null");
    L10:
        String r1 = Formatter.formatFileSize(this.f22452b, this.h.getLong("auto_update_size"));
        if (this.f == false) goto L19;
        if (this.f22454d != 2) goto L17;
        return this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_update_tip_mobile_force, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_tip_mobile_force"), new Object[]{r1});
    L17:
        return this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_update_tip_mobile, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_tip_mobile"), new Object[]{r1});
    L19:
        if (this.f22454d != 2) goto L23;
        return this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_update_tip_wifi_force, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_tip_wifi_force"), new Object[]{r1});
    L23:
        return this.f22452b.getString(ZeusTransformUtils.mapRes(R.string.auto_update_tip_wifi, WsChannelMultiProcessSharedProvider.STRING_TYPE, "auto_update_tip_wifi"), new Object[]{r1});
    L5:
        if (r0.getType() != 0) goto L7;
        boolean r2 = true;
    L8:
        this.f = r2;
        goto L10
    L7:
        r2 = false;
        goto L8
    }

    private e<String, Drawable> k() {
        Drawable r1 = null;
        PackageManager r2 = this.f22452b.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L19
        ApplicationInfo r5 = r2.getApplicationInfo(this.f22453c, 0);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r5 != null) goto L7;
        b(TAG, "ApplicationInfo is null.");     // Catch: PackageManager.NameNotFoundException -> L19
        return null;
    L7:
        String r3 = r5.loadLabel(r2).toString();     // Catch: PackageManager.NameNotFoundException -> L19
        if (r3 != null) goto L25;
        b(TAG, "getLogoDrawable:name is null");     // Catch: PackageManager.NameNotFoundException -> L19
        r3 = null;
    L25:
        Drawable r6 = r5.loadIcon(r2);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r6 == null) goto L15;
        r1 = r6;
    L23:
        return new e(r3, r1);
    L15:
        b(TAG, "getLogoDrawable:drawable is null");     // Catch: PackageManager.NameNotFoundException -> L17
    L17:
        e = e;
    L21:
        b(TAG, "getLogoDrawable:" + e.getMessage());
    L19:
        e = e;
        r3 = null;
        goto L21
    }

    public void a() {
    L7:
        e = move-exception;
        a(TAG, "show: ", e);
        return;
    L3:
        if (ZeusTransformUtils.instanceOf(this.f22452b, Activity.class) == true) goto L5;
        this.i.getWindow().setType(2038);     // Catch: Exception -> L7
    L5:
        this.i.show();     // Catch: Exception -> L7
    }

    static {
        f22451a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
