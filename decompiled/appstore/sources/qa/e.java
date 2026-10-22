package qa;

import android.R;
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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedanceos.common.toolbox.i;
import com.obric.appstore.autoupdate.MaxScrollView;
import com.obric.appstore.autoupdate.R$id;
import com.obric.appstore.autoupdate.R$layout;
import com.obric.appstore.autoupdate.R$string;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.alert.h;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static char[] f23600i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f23601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f23602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f23607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OAlertDialog f23608h;

    static {
        f23600i = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public e(Context r10, Bundle r11) {
        this.f23602b = null;
        this.f23603c = 0;
        this.f23604d = null;
        this.f23605e = false;
        this.f23606f = false;
        this.f23601a = r10;
        this.f23602b = r11.getString("auto_update_pkg");
        this.f23603c = r11.getInt("auto_update_model");
        this.f23607g = r11;
        this.f23606f = r11.getBoolean("auto_update_file_exist");
        q(r10);
    }

    public static /* synthetic */ void a(e r10, DialogInterface r11, int r12) {
        r10.l(r11, r12);
    }

    public static /* synthetic */ void b(e r10, DialogInterface r11, int r12) {
        r10.j(r11, r12);
    }

    public static /* synthetic */ Unit c(e r10, FrameLayout r11) {
        return r10.i(r11);
    }

    public static /* synthetic */ void d(e r10, DialogInterface r11, int r12) {
        r10.k(r11, r12);
    }

    public final void e() {
        OAlertDialog r10 = this.f23608h;     // Catch: Exception -> L6
        if (r10 == null) goto L9;
        r10.dismiss();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public final View f() {
        View r10 = LayoutInflater.from(this.f23601a).inflate(R$layout.obric_auto_update_2, null);
        ((MaxScrollView) r10.findViewById(R$id.scrollView)).setMaxHeight(tc.f.i(500));
        TextView r11 = (TextView) r10.findViewById(R$id.app_update_log);
        String r12 = this.f23607g.getString("auto_update_log");
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r11.setText(r12);
    L6:
        TextView r13 = (TextView) r10.findViewById(R$id.app_update_tip);
        if (this.f23606f == false) goto L9;
        r13.setText(this.f23601a.getString(R$string.auto_install_tips));
    L10:
        return r10;
    L9:
        r13.setText(g());
        goto L10
    L5:
        i.a("FindNewVersionDialog", "no updateLog");
        goto L6
    }

    public final String g() {
        NetworkInfo r10 = ((ConnectivityManager) this.f23601a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r10 != null) goto L5;
        i.a("FindNewVersionDialog", "networkInfo is null");
    L10:
        long r11 = this.f23607g.getLong("auto_update_size");
        String r12 = Formatter.formatFileSize(this.f23601a, r11);
        if (this.f23605e == false) goto L19;
        if (this.f23603c != 2) goto L17;
        return this.f23601a.getString(R$string.auto_update_tip_mobile_force, new Object[]{r12});
    L17:
        return this.f23601a.getString(R$string.auto_update_tip_mobile, new Object[]{r12});
    L19:
        if (this.f23603c != 2) goto L23;
        return this.f23601a.getString(R$string.auto_update_tip_wifi_force, new Object[]{r12});
    L23:
        return this.f23601a.getString(R$string.auto_update_tip_wifi, new Object[]{r12});
    L5:
        if (r10.getType() != 0) goto L7;
        boolean r13 = true;
    L8:
        this.f23605e = r13;
        goto L10
    L7:
        r13 = false;
        goto L8
    }

    public final String h() {
        return this.f23607g.getString("auto_update_version_name");
    }

    public final /* synthetic */ Unit i(FrameLayout r10) {
        r10.addView(f());
        return null;
    }

    public final /* synthetic */ void j(DialogInterface r10, int r11) {
        p();
    }

    public final /* synthetic */ void k(DialogInterface r10, int r11) {
        o();
    }

    public final /* synthetic */ void l(DialogInterface r10, int r11) {
        n();
    }

    public final androidx.core.util.c m() {
        Drawable r10 = null;
        PackageManager r11 = this.f23601a.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L7
        ApplicationInfo r12 = r11.getApplicationInfo(this.f23602b, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r12 != null) goto L9;
        i.a("FindNewVersionDialog", "ApplicationInfo is null.");     // Catch: PackageManager.NameNotFoundException -> L7
        return null;
    L9:
        String r13 = r12.loadLabel(r11).toString();     // Catch: PackageManager.NameNotFoundException -> L7
        if (r13 != null) goto L23;
        i.a("FindNewVersionDialog", "getLogoDrawable:name is null");     // Catch: PackageManager.NameNotFoundException -> L7
        r13 = null;
    L23:
        Drawable r14 = r12.loadIcon(r11);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r14 == null) goto L17;
        r10 = r14;
    L22:
        return new androidx.core.util.c(r13, r10);
    L17:
        i.a("FindNewVersionDialog", "getLogoDrawable:drawable is null");     // Catch: PackageManager.NameNotFoundException -> L19
    L19:
        e = e;
    L20:
        i.a("FindNewVersionDialog", "getLogoDrawable:" + e.getMessage());
    L7:
        e = e;
        r13 = null;
        goto L20
    }

    public final void n() {
        int r10 = this.f23607g.getInt("auto_update_version_code");
        f.e().c(this.f23601a, this.f23602b, r10);
        e();
    }

    public final void o() {
        if (this.f23603c != 2) goto L5;
        Process.killProcess(Process.myPid());
    L6:
        e();
        return;
    L5:
        f.e().c(this.f23601a, this.f23602b, -1);
        goto L6
    }

    public final void p() {
        if (this.f23606f == false) goto L7;
        f.e().f(this.f23601a, this.f23604d, this.f23607g);
        e();
        return;
    L7:
        if (this.f23603c != 2) goto L9;
        new g(this.f23601a, this.f23602b, this.f23603c).o(300);
    L9:
        f.e().j(this.f23601a, this.f23604d, this.f23605e, this.f23607g);
        e();
    }

    public final void q(Context r10) {
        androidx.core.util.c r11 = m();
        if (r11 == null) goto L14;
        Object r12 = r11.f2646a;
        if (r12 == null) goto L14;
        if (r11.f2647b == null) goto L14;
        this.f23604d = (String) r12;
        OAlertDialogBuilder r13 = new OAlertDialogBuilder(r10).r((Drawable) r11.f2647b).s(tc.f.i(56), tc.f.i(56)).O(this.f23601a.getString(R$string.auto_update_title) + " " + h(), false).p(new h(new a(this))).G(R$string.auto_update_ok, new b(this)).C(r(), new c(this));
        if (s() == false) goto L12;
        r13.u(R$string.obric_auto_update_ignore, new d(this));
    L12:
        OAlertDialog r14 = r13.q();
        this.f23608h = r14;
        r14.setCanceledOnTouchOutside(true);
        this.f23608h.setCancelable(false);
        i.a("FindNewVersionDialog", "onCreate:" + this.f23602b + "|" + this.f23603c);
        return;
    L14:
        i.b("FindNewVersionDialog", "loadLableAndIcon:pair is null. appPkgName = " + this.f23602b);
    }

    public final int r() {
        if (this.f23603c != 2) goto L7;
        return R.string.cancel;
    L7:
        return R$string.auto_update_cancel;
    }

    public final boolean s() {
        if (this.f23606f == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f23603c == 2) goto L7;
        return true;
    }

    public void t() {
    L5:
        e = move-exception;
        i.c("FindNewVersionDialog", "show: ", e);
        return;
    L3:
        if ((this.f23601a instanceof Activity) == true) goto L7;
        this.f23608h.getWindow().setType(2038);     // Catch: Exception -> L5
    L7:
        this.f23608h.show();     // Catch: Exception -> L5
    }
}
