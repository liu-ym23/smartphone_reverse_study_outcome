package com.bytedance.android.live.browser.jsbridge.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Locale;
import java.util.Map;
import m60.c;
import p60.e;

/* JADX INFO: loaded from: classes45.dex */
public class JSBOpenSettingFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat<a> f63758a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f63759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h30.a f63760b;

        public a(String[] r100, h30.a r101) {
            this.f63759a = r100;
            this.f63760b = r101;
        }
    }

    public JSBOpenSettingFragment() {
        this.f63758a = new SparseArrayCompat();
    }

    public static Intent a(Context r100) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100.getPackageName()));
    }

    public static boolean c(Context r100, Intent r101) {
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);
        if (r102 == null) goto L18;
        ActivityInfo r103 = r102.activityInfo;
        if (r103 == null) goto L18;
        String r104 = r103.name;
        if (r104 != null) goto L9;
    L11:
        String r105 = r102.activityInfo.permission;
        if (TextUtils.isEmpty(r105) == false) goto L14;
        return true;
    L14:
        if (r100.checkCallingOrSelfPermission(r105) == 0) goto L19;
        return false;
    L19:
        return true;
    L9:
        if (r104.toLowerCase(Locale.getDefault()).contains("resolver") == false) goto L11;
    L18:
        return false;
    }

    public final void b(a r100, int r101) {
    L8:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f63758a.put(r101, r100);     // Catch: Exception -> L10
    L11:
        return;
    L4:
        if (c(getActivity(), a(getActivity())) == false) goto L7;
        startActivityForResult(a(getActivity()), r101);     // Catch: Exception -> L8
        this.f63758a.put(r101, r100);     // Catch: Exception -> L8
        goto L15
    L7:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r101);     // Catch: Exception -> L10
        this.f63758a.put(r101, r100);     // Catch: Exception -> L10
    }

    public final void d(h30.a r100, String... r101) {
        a r102 = new a(r101, r100);
        if (c.a(getActivity(), r101).length != 0) goto L7;
        r100.onPermissionGrant(r101);
        return;
    L7:
        if (getActivity() != null) goto L9;
        return;
    L9:
        Activity r103 = getActivity();
        Activity r104 = getActivity();
        Map<String, p60.c> r105 = e.f527862b;
        e r106 = e.a.f527864a;
        if (c(r103, r106.a(r104)) == false) goto L12;
    L17:
        int r107 = (m60.a.a(r101) & (-65536)) >>> 16;
    L23:
        b(r102, r107);
        return;
    L19:
        if (c(getActivity(), r106.a(getActivity())) == false) goto L21;
        startActivityForResult(r106.a(getActivity()), r107);     // Catch: Exception -> L23
        this.f63758a.put(r107, r102);     // Catch: Exception -> L23
    L25:
        return;
    L21:
        b(r102, r107);     // Catch: Exception -> L23
        goto L25
    L12:
        if (c(getActivity(), a(getActivity())) == true) goto L17;
        Activity r108 = getActivity();
        getActivity();
        if (c(r108, new Intent("android.settings.APPLICATION_SETTINGS")) == true) goto L17;
        r100.onPermissionDenied(r101);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        a r103 = this.f63758a.get(r100);
        this.f63758a.remove(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L25;
        String[] r104 = r103.f63759a;
        if (r104 == null) goto L17;
        if (r104.length != 1) goto L17;
        if ("notification".equals(r104[0]) == false) goto L17;
        int r105 = c30.c.f22265a;
        if (c30.c.b(getActivity()) == false) goto L15;
        r103.f63760b.onPermissionGrant(r103.f63759a);
        return;
    L15:
        r103.f63760b.a(r103.f63759a);
        return;
    L17:
        if (c.d(getActivity(), r103.f63759a) == false) goto L20;
        r103.f63760b.onPermissionGrant(r103.f63759a);
        return;
    L20:
        if (c.e(getActivity(), r103.f63759a) == false) goto L22;
        r103.f63760b.a(r103.f63759a);
        return;
    L22:
        r103.f63760b.onPermissionDenied(r103.f63759a);
        return;
    }
}
