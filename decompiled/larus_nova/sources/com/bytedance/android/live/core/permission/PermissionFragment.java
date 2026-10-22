package com.bytedance.android.live.core.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import m60.i;
import o60.d;
import p60.c;
import p60.e;

/* JADX INFO: loaded from: classes45.dex */
public class PermissionFragment extends Fragment {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f65109c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat<b> f65110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArrayCompat<b> f65111b;

    public class a implements o60.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f65112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PermissionFragment f65113b;

        @Override // o60.b
        public final void cancel() {
            this.f65112a.c();
        }

        @Override // o60.b
        public final void execute() {
            PermissionFragment r100 = this.f65113b;
            b r101 = this.f65112a;
            int r102 = PermissionFragment.f65109c;
            r100.getClass();
            int r103 = (m60.a.a(r101.f65115b) & (-65536)) >>> 16;
            Activity r104 = r100.getActivity();     // Catch: Exception -> L8
            Activity r105 = r100.getActivity();     // Catch: Exception -> L8
            Map<String, c> r106 = e.f527862b;     // Catch: Exception -> L8
            e r107 = e.a.f527864a;     // Catch: Exception -> L8
            if (PermissionFragment.e(r104, r107.a(r105)) == false) goto L6;
            r100.startActivityForResult(r107.a(r100.getActivity()), r103);     // Catch: Exception -> L8
            r100.f65111b.put(r103, r101);     // Catch: Exception -> L8
        L11:
        L9:
            this.f65112a.b();
            return;
        L6:
            r100.d(r101, r103);     // Catch: Exception -> L8
        L8:
            r100.d(r101, r103);
            goto L9
        }

        public a(PermissionFragment r100, b r101) {
            this.f65113b = r100;
            this.f65112a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cert f65114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f65115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f65116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o60.e f65117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d f65118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final o60.a f65119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final o60.a f65120g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Runnable f65121h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Runnable f65122i;

        public final void a() {
            this.f65121h.run();
            m60.d r100 = m60.d.a.f512255a;
            String[] r101 = this.f65116c;
            r100.getClass();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            Iterator<o60.c> r104 = r100.a(r101[r103]).iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r104.next().a();
            goto L6
        L8:
            r103 = r103 + 1;
            goto L3
        }

        public final void b() {
            d r100 = this.f65118e;
            if (r100 == null) goto L5;
            r100.a();
        L5:
            m60.d r101 = m60.d.a.f512255a;
            String[] r102 = this.f65116c;
            r101.getClass();
            int r103 = r102.length;
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L12;
            Iterator<o60.c> r105 = r101.a(r102[r104]).iterator();
        L9:
            if (r105.hasNext() == false) goto L11;
            r105.next().d();
            goto L9
        L11:
            r104 = r104 + 1;
            goto L6
        }

        public final void c() {
            this.f65117d.onPermissionDenied(this.f65115b);
            m60.d r100 = m60.d.a.f512255a;
            String[] r101 = this.f65116c;
            r100.getClass();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            Iterator<o60.c> r104 = r100.a(r101[r103]).iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            r104.next().onPermissionDenied();
            goto L6
        L8:
            r103 = r103 + 1;
            goto L3
        }

        public final void d(boolean r100) {
            this.f65117d.onPermissionGrant(this.f65115b);
            m60.d r101 = m60.d.a.f512255a;
            String[] r102 = this.f65115b;
            r101.getClass();
            int r103 = r102.length;
            int r104 = 0;
            int r105 = 0;
        L3:
            if (r105 >= r103) goto L9;
            Iterator<o60.c> r106 = r101.a(r102[r105]).iterator();
        L6:
            if (r106.hasNext() == false) goto L8;
            r106.next().c();
            goto L6
        L8:
            r105 = r105 + 1;
            goto L3
        L9:
            if (r100 == false) goto L17;
            this.f65122i.run();
            m60.d r107 = m60.d.a.f512255a;
            String[] r108 = this.f65116c;
            r107.getClass();
            int r109 = r108.length;
        L11:
            if (r104 >= r109) goto L22;
            Iterator<o60.c> r110 = r107.a(r108[r104]).iterator();
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

        public b(String[] r100, Runnable r101, o60.e r102, d r103, i.c r104, Runnable r105, o60.a r106, Cert r107) {
            this.f65115b = r100;
            this.f65121h = r101;
            this.f65122i = r105;
            this.f65117d = r102;
            this.f65118e = r103;
            this.f65119f = r104;
            this.f65120g = r106;
            this.f65116c = new String[0];
            this.f65114a = r107;
        }
    }

    public PermissionFragment() {
        this.f65110a = new SparseArrayCompat();
        this.f65111b = new SparseArrayCompat();
    }

    public static String a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("android.permission.CAMERA", "91100930");
        r101.put("android.permission.RECORD_AUDIO", "1019459842");
        r101.put("audio_camera", "1026219778");
        return (String) r101.get(r100);
    }

    public static PermissionFragment b(Activity r100) {
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

    public static Intent c(Context r100) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100.getPackageName()));
    }

    public final void g(b r100) {
        a r101 = new a(this, r100);
        Activity r102 = getActivity();
        r100.f65120g.a(r102, r101, r100.f65115b);
    }

    public void requestPermissions(b r100) {
        if (r100.f65116c.length != 0) goto L6;
        r100.d(false);
        return;
    L6:
        r100.a();
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Map<String, c> r101 = e.f527862b;
        if (e.a.f527864a.b() == true) goto L13;
        com.bytedance.android.live.core.permission.b r102 = new com.bytedance.android.live.core.permission.b(this, r100);
        Activity r103 = getActivity();
        r100.f65119f.a(r103, r102, r100.f65115b);
        return;
    L13:
        g(r100);
    }

    public static boolean e(Context r100, Intent r101) {
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);
        if (r102 == null) goto L16;
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L16;
        if (r103.name.toLowerCase().contains("resolver") == true) goto L16;
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

    public final void d(b r100, int r101) {
    L8:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f65111b.put(r101, r100);     // Catch: Exception -> L10
    L11:
        return;
    L4:
        if (e(getActivity(), c(getActivity())) == false) goto L7;
        startActivityForResult(c(getActivity()), r101);     // Catch: Exception -> L8
        this.f65111b.put(r101, r100);     // Catch: Exception -> L8
        goto L15
    L7:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f65111b.put(r101, r100);     // Catch: Exception -> L10
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        b r103 = this.f65111b.get(r100);
        this.f65111b.remove(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (m60.c.d(getActivity(), r103.f65115b) == false) goto L9;
        r103.d(true);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        f06.b r112 = new f06.b();
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
        f06.d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L37
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L37
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        b r107 = this.f65110a.get(r210);
        this.f65110a.remove(r210);
        if (r107 != null) goto L23;
        return;
    L23:
        if (m60.c.f(getActivity(), r211, r212) == false) goto L26;
        r107.d(true);
        return;
    L26:
        if (m60.c.e(getActivity(), r211) == false) goto L28;
        r107.c();
        return;
    L28:
        Activity r108 = getActivity();
        Activity r109 = getActivity();
        Map<String, c> r113 = e.f527862b;
        if (e(r108, e.a.f527864a.a(r109)) == false) goto L31;
    L35:
        r107.f65116c = m60.c.a(getActivity(), r107.f65115b);
        g(r107);
        return;
    L31:
        if (e(getActivity(), c(getActivity())) == true) goto L35;
        Activity r114 = getActivity();
        getActivity();
        if (e(r114, new Intent("android.settings.APPLICATION_SETTINGS")) == true) goto L35;
        r107.c();
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

    public static void f(Activity r110, o60.e r111, d r112, Runnable r113, i.c r114, o60.a r115, Runnable r116, Cert r210, String... r211) {
        b r117 = new b(r211, r113, r111, r112, r114, r116, r115, r210);
        r117.f65116c = m60.c.a(r110, r211);
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_REQUEST.getValue().booleanValue() == true) goto L5;
    L22:
        ALogger.i("PermissionFragment", "requestPermissions use old PermissionFragment");
        b(r110).requestPermissions(r117);
        return;
    L5:
        if (jc1.a.c() == true) goto L22;
        if (LiveInfraSettingKeys.LIVE_SHOW_NEVER_ASK_DIALOG.getValue().booleanValue() == false) goto L18;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Map<String, c> r100 = e.f527862b;
        if (e.a.f527864a.b() == false) goto L18;
    L12:
        ALogger.i("PermissionFragment", "requestPermissions use old PermissionFragment instead of ezpermission");
        PermissionFragment r101 = b(r110);
        if (r117.f65116c.length != 0) goto L16;
        r117.d(false);
        return;
    L16:
        r117.a();
        r101.g(r117);
        return;
    L18:
        if (("requestPermissions use ezpermission, cert=" + r210) != null) goto L20;
        String r102 = "null";
    L21:
        ALogger.i("PermissionFragment", r102);
        ((IMiddlewareHostAction) k.f(IMiddlewareHostAction.class)).requestPermissions(r110, new com.bytedance.android.live.core.permission.a(r117, r110, r211, r115), r210, r211);
        return;
    L20:
        r102 = r210.certToken();
        goto L21
    }
}
