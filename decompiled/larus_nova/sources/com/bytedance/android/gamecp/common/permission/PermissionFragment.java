package com.bytedance.android.gamecp.common.permission;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;
import com.bytedance.android.gamecp.common.utils.u;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import ru.j;
import ru.l;
import uu.d;
import vu.e;

/* JADX INFO: loaded from: classes44.dex */
public class PermissionFragment extends Fragment {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f56712c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat<b> f56713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArrayCompat<b> f56714b;

    public class a implements uu.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f56715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PermissionFragment f56716b;

        @Override // uu.b
        public final void cancel() {
            this.f56715a.b();
        }

        @Override // uu.b
        public final void execute() {
            PermissionFragment r100 = this.f56716b;
            b r101 = this.f56715a;
            int r102 = PermissionFragment.f56712c;
            r100.getClass();
            String[] r103 = r101.f56718b;
            int r104 = 0;
            if (r103 == null) goto L13;
            int r105 = r103.length;
            int r106 = 1;
            int r107 = 0;
        L6:
            if (r107 >= r105) goto L12;
            String r108 = r103[r107];
            if (r108 != null) goto L10;
            int r109 = 0;
        L11:
            r106 = ((r106 << 5) - r106) ^ r109;
            r107 = r107 + 1;
            goto L6
        L10:
            r109 = r108.hashCode();
            goto L11
        L12:
            r104 = r106;
        L13:
            int r110 = ((-65536) & r104) >>> 16;
            Activity r111 = r100.getActivity();     // Catch: Exception -> L19
            Activity r112 = r100.getActivity();     // Catch: Exception -> L19
            Map<String, vu.c> r113 = e.f557316b;     // Catch: Exception -> L19
            e r114 = e.a.f557318a;     // Catch: Exception -> L19
            if (PermissionFragment.d(r111, r114.a(r112)) == false) goto L17;
            r100.startActivityForResult(r114.a(r100.getActivity()), r110);     // Catch: Exception -> L19
            r100.f56714b.put(r110, r101);     // Catch: Exception -> L19
        L22:
        L20:
            this.f56715a.getClass();
            return;
        L17:
            r100.c(r101, r110);     // Catch: Exception -> L19
        L19:
            r100.c(r101, r110);
            goto L20
        }

        public a(PermissionFragment r100, b r101) {
            this.f56716b = r100;
            this.f56715a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cert f56717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f56718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f56719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f56720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final uu.a f56721e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final uu.a f56722f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Runnable f56723g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Runnable f56724h;

        public final void a() {
            this.f56723g.run();
            ru.d r100 = ru.d.a.f539223a;
            String[] r101 = this.f56719c;
            r100.getClass();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            Iterator<uu.c> r104 = r100.a(r101[r103]).iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r104.next().a();
            goto L6
        L8:
            r103 = r103 + 1;
            goto L3
        }

        public final void b() {
            this.f56720d.onPermissionDenied(this.f56718b);
            ru.d r100 = ru.d.a.f539223a;
            String[] r101 = this.f56719c;
            r100.getClass();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            Iterator<uu.c> r104 = r100.a(r101[r103]).iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r104.next().onPermissionDenied();
            goto L6
        L8:
            r103 = r103 + 1;
            goto L3
        }

        public final void c(boolean r100) {
            this.f56720d.onPermissionGrant(this.f56718b);
            ru.d r101 = ru.d.a.f539223a;
            String[] r102 = this.f56718b;
            r101.getClass();
            int r103 = r102.length;
            int r104 = 0;
            int r105 = 0;
        L3:
            if (r105 >= r103) goto L9;
            Iterator<uu.c> r106 = r101.a(r102[r105]).iterator();
        L6:
            if (r106.hasNext() == false) goto L8;
            r106.next().c();
            goto L6
        L8:
            r105 = r105 + 1;
            goto L3
        L9:
            if (r100 == false) goto L17;
            this.f56724h.run();
            ru.d r107 = ru.d.a.f539223a;
            String[] r108 = this.f56719c;
            r107.getClass();
            int r109 = r108.length;
        L11:
            if (r104 >= r109) goto L22;
            Iterator<uu.c> r110 = r107.a(r108[r104]).iterator();
        L14:
            if (r110.hasNext() == false) goto L16;
            r110.next().b();
            goto L14
        L16:
            r104 = r104 + 1;
            goto L11
        L22:
            return;
        }

        public b(String[] r100, l r101, d r102, j.c r103, l r104, uu.a r105, Cert r106) {
            this.f56718b = r100;
            this.f56723g = r101;
            this.f56724h = r104;
            this.f56720d = r102;
            this.f56721e = r103;
            this.f56722f = r105;
            this.f56719c = new String[0];
            this.f56717a = r106;
        }
    }

    public PermissionFragment() {
        this.f56713a = new SparseArrayCompat();
        this.f56714b = new SparseArrayCompat();
    }

    public static PermissionFragment a(Activity r100) {
        FragmentManager r101 = r100.getFragmentManager();
        PermissionFragment r102 = (PermissionFragment) r101.findFragmentByTag("PermissionFragment");
        if (r102 != null) goto L6;
        PermissionFragment r103 = new PermissionFragment();
        r101.beginTransaction().add(r103, "PermissionFragment").commitAllowingStateLoss();
        r101.executePendingTransactions();
        return r103;
    L6:
        return r102;
    }

    public static Intent b(Context r100) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100.getPackageName()));
    }

    public final void f(b r100) {
        a r101 = new a(this, r100);
        Activity r102 = getActivity();
        uu.a r103 = r100.f56722f;
        if (r103 == null) goto L6;
        r103.a(r102, r101, r100.f56718b);
        return;
    }

    public void requestPermissions(b r100) {
        if (r100.f56719c.length != 0) goto L6;
        r100.c(false);
        return;
    L6:
        r100.a();
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Map<String, vu.c> r101 = e.f557316b;
        if (e.a.f557318a.b() == true) goto L13;
        c r102 = new c(this, r100);
        Activity r103 = getActivity();
        r100.f56721e.a(r103, r102, r100.f56718b);
        return;
    L13:
        f(r100);
    }

    public static boolean d(Context r100, Intent r101) {
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);
        if (r102 == null) goto L16;
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L16;
        if (r103.name.toLowerCase(Locale.getDefault()).contains("resolver") == true) goto L16;
        String r104 = r102.activityInfo.permission;
        if (TextUtils.isEmpty(r104) == false) goto L12;
        return true;
    L12:
        if (r100.checkCallingOrSelfPermission(r104) == 0) goto L17;
        return false;
    L17:
        return true;
    L16:
        return false;
    }

    public final void c(b r100, int r101) {
    L8:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f56714b.put(r101, r100);     // Catch: Exception -> L10
    L11:
        return;
    L4:
        if (d(getActivity(), b(getActivity())) == false) goto L7;
        startActivityForResult(b(getActivity()), r101);     // Catch: Exception -> L8
        this.f56714b.put(r101, r100);     // Catch: Exception -> L8
        goto L15
    L7:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f56714b.put(r101, r100);     // Catch: Exception -> L10
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        b r103 = this.f56714b.get(r100);
        this.f56714b.remove(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (ru.c.c(getActivity(), r103.f56718b) == false) goto L9;
        r103.c(true);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        boolean r111 = false;
        Object[] r112 = {Integer.valueOf(r210), r211, r212};
        f06.b r113 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(102612);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r213 = r104;
        int r214 = r103;
        f06.a[] r215 = r102;
        f06.d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r112, "void", r113);     // Catch: Exception -> L49
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L49
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        b r107 = this.f56713a.get(r210);
        this.f56713a.remove(r210);
        if (r107 == null) goto L57;
        Activity r108 = getActivity();
        Map<String, Integer> r109 = ru.c.f539221a;
        if (r212.length == 0) goto L35;
        int r114 = r212.length;
        int r115 = 0;
    L26:
        if (r115 >= r114) goto L31;
        if (r212[r115] != 0) goto L35;
        r115 = r115 + 1;
        goto L26
    L31:
        Map<String, vu.c> r116 = e.f557316b;
        if (e.a.f557318a.b() == false) goto L34;
        r111 = ru.c.c(r108, r211);
        goto L35
    L34:
        r111 = true;
    L35:
        if (r111 == false) goto L38;
        r107.c(true);
        return;
    L38:
        if (ru.c.d(getActivity(), r211) == false) goto L40;
        r107.b();
        return;
    L40:
        Activity r117 = getActivity();
        Activity r118 = getActivity();
        Map<String, vu.c> r119 = e.f557316b;
        if (d(r117, e.a.f557318a.a(r118)) == false) goto L43;
    L47:
        r107.f56719c = ru.c.b(getActivity(), r107.f56718b);
        f(r107);
        return;
    L43:
        if (d(getActivity(), b(getActivity())) == true) goto L47;
        Activity r120 = getActivity();
        getActivity();
        if (d(r120, new Intent("android.settings.APPLICATION_SETTINGS")) == true) goto L47;
        r107.b();
        return;
    L57:
        return;
    L14:
        r104 = r213 + 1;
        r103 = r214;
        r102 = r215;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void e(Activity r110, d r111, l r112, j.c r113, uu.a r114, l r115, Cert r116, String... r117) {
        b r118 = new b(r117, r112, r111, r113, r115, r114, r116);
        r118.f56719c = ru.c.b(r110, r117);
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_REQUEST.getValue().booleanValue() == false) goto L30;
        Application r100 = u.f57306a;
        if (r100 == null) goto L12;
        String r101 = r100.getPackageName();
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (r101.startsWith("com.bytedance.android.gamecp") == false) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L30;
        if (LiveInfraSettingKeys.LIVE_SHOW_NEVER_ASK_DIALOG.getValue().booleanValue() == false) goto L26;
        if (Build.VERSION.SDK_INT < 23) goto L20;
        Map<String, vu.c> r103 = e.f557316b;
        if (e.a.f557318a.b() == false) goto L26;
    L20:
        yr.b.b(4, "PermissionFragment", "requestPermissions use old PermissionFragment instead of ezpermission");
        PermissionFragment r104 = a(r110);
        if (r118.f56719c.length != 0) goto L24;
        r118.c(false);
        return;
    L24:
        r118.a();
        r104.f(r118);
        return;
    L26:
        if (("requestPermissions use ezpermission, cert=" + r116) != null) goto L28;
        String r105 = "null";
    L29:
        yr.b.b(4, "PermissionFragment", r105);
        com.bytedance.android.gamecp.host_api.a.b().getHostAction().requestPermissions(r110, new com.bytedance.android.gamecp.common.permission.b(r118, r110, r117, r114), r116, r117);
        return;
    L28:
        r105 = r116.certToken();
    L12:
        r102 = false;
    L30:
        yr.b.b(4, "PermissionFragment", "requestPermissions use old PermissionFragment");
        a(r110).requestPermissions(r118);
    }
}
