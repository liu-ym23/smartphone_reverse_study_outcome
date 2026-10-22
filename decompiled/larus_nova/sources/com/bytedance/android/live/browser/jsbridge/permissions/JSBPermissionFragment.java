package com.bytedance.android.live.browser.jsbridge.permissions;

import android.app.Fragment;
import android.os.Build;
import androidx.collection.SparseArrayCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import java.util.ArrayList;
import m60.c;
import n60.e;

/* JADX INFO: loaded from: classes45.dex */
public class JSBPermissionFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat<a> f63761a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f63762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f63763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h30.a f63764c;

        public a(String[] r100, h30.a r101) {
            this.f63762a = r100;
            this.f63764c = r101;
            this.f63763b = new String[0];
        }
    }

    public JSBPermissionFragment() {
        this.f63761a = new SparseArrayCompat();
    }

    public void requestPermissions(h30.a r100, String... r101) {
        a r102 = new a(r101, r100);
        if (getActivity() != null) goto L5;
        return;
    L5:
        String[] r103 = c.a(getActivity(), r101);
        if (r103.length != 0) goto L9;
        r100.onPermissionGrant(r101);
        return;
    L9:
        r102.f63763b = r103;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        int r104 = m60.a.a(r101) & 65535;
        this.f63761a.put(r104, r102);
        requestPermissions(r102.f63763b, r104);
        return;
    L12:
        if (getActivity() != null) goto L15;
        return;
    L15:
        if (e.a.f518098a.b(getActivity(), r101) == false) goto L17;
        r100.onPermissionGrant(r101);
        return;
    L17:
        r100.onPermissionDenied(r101);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        b r112 = new b();
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
        int r113 = r104;
        int r213 = r103;
        f06.a[] r214 = r102;
        d r106 = r105.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L34
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L34
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        a r107 = this.f63761a.get(r210);
        this.f63761a.remove(r210);
        if (r107 == null) goto L44;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        if (c.f(getActivity(), r211, r212) == false) goto L28;
        r107.f63764c.onPermissionGrant(r107.f63762a);     // Catch: Exception -> L25
    L35:
        return;
    L28:
        if (c.e(getActivity(), r211) == false) goto L30;
        r107.f63764c.a(r107.f63762a);     // Catch: Exception -> L25
        goto L35
    L30:
        r107.f63764c.onPermissionDenied(r107.f63762a);     // Catch: Exception -> L25
        goto L35
    L44:
        return;
    L14:
        r104 = r113 + 1;
        r103 = r213;
        r102 = r214;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }
}
