package com.blankj.utilcode.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import com.blankj.utilcode.util.UtilsTransActivity;
import com.blankj.utilcode.util.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PermissionUtils {

    /* renamed from: h, reason: collision with root package name */
    public static PermissionUtils f19172h;

    /* renamed from: i, reason: collision with root package name */
    public static b f19173i;

    /* renamed from: j, reason: collision with root package name */
    public static b f19174j;

    /* renamed from: a, reason: collision with root package name */
    public String[] f19175a;

    /* renamed from: b, reason: collision with root package name */
    public b f19176b;

    /* renamed from: c, reason: collision with root package name */
    public Set<String> f19177c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f19178d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f19179e;

    /* renamed from: f, reason: collision with root package name */
    public List<String> f19180f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f19181g;

    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public static int f19182a = -1;

        /* renamed from: b, reason: collision with root package name */
        public static PermissionActivityImpl f19183b = new PermissionActivityImpl();

        public class a implements p.b<Intent> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f19184a;

            public a(int i10) {
                this.f19184a = i10;
            }

            @Override // com.blankj.utilcode.util.p.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f19184a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ UtilsTransActivity f19185a;

            public b(UtilsTransActivity utilsTransActivity) {
                this.f19185a = utilsTransActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19185a.requestPermissions((String[]) PermissionUtils.f19172h.f19178d.toArray(new String[0]), 1);
            }
        }

        public static void n(int i10) {
            UtilsTransActivity.s(new a(i10), f19183b);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean a(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void b(UtilsTransActivity utilsTransActivity, int i10, int i11, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void d(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    f19182a = 2;
                    PermissionUtils.D(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    f19182a = 3;
                    PermissionUtils.B(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.f19172h == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f19172h.f19178d == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.f19172h.f19178d.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.i(PermissionUtils.f19172h);
                PermissionUtils.j(PermissionUtils.f19172h);
                m(utilsTransActivity);
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void e(UtilsTransActivity utilsTransActivity) {
            int i10 = f19182a;
            if (i10 != -1) {
                l(i10);
                f19182a = -1;
            }
            super.e(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void g(UtilsTransActivity utilsTransActivity, int i10, String[] strArr, int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.f19172h == null || PermissionUtils.f19172h.f19178d == null) {
                return;
            }
            PermissionUtils.f19172h.w(utilsTransActivity);
        }

        public final void l(int i10) {
            if (i10 == 2) {
                if (PermissionUtils.f19173i == null) {
                    return;
                }
                if (PermissionUtils.u()) {
                    PermissionUtils.f19173i.a();
                } else {
                    PermissionUtils.f19173i.b();
                }
                b unused = PermissionUtils.f19173i = null;
                return;
            }
            if (i10 != 3 || PermissionUtils.f19174j == null) {
                return;
            }
            if (PermissionUtils.t()) {
                PermissionUtils.f19174j.a();
            } else {
                PermissionUtils.f19174j.b();
            }
            b unused2 = PermissionUtils.f19174j = null;
        }

        public final void m(UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f19172h.A(utilsTransActivity, new b(utilsTransActivity))) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f19172h.f19178d.toArray(new String[0]), 1);
        }
    }

    public interface a {
    }

    public interface b {
        void a();

        void b();
    }

    public interface c {
    }

    public PermissionUtils(String... strArr) {
        this.f19175a = strArr;
        f19172h = this;
    }

    @TargetApi(23)
    public static void B(Activity activity, int i10) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + p.a().getPackageName()));
        if (r.r(intent)) {
            activity.startActivityForResult(intent, i10);
        } else {
            v();
        }
    }

    @TargetApi(23)
    public static void D(Activity activity, int i10) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + p.a().getPackageName()));
        if (r.r(intent)) {
            activity.startActivityForResult(intent, i10);
        } else {
            v();
        }
    }

    public static /* synthetic */ c i(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static /* synthetic */ a j(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List<String> n() {
        return o(p.a().getPackageName());
    }

    public static List<String> o(String str) {
        try {
            String[] strArr = p.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.EMPTY_LIST : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    public static Pair<List<String>, List<String>> q(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> listN = n();
        for (String str : strArr) {
            boolean z10 = false;
            for (String str2 : W1.a.a(str)) {
                if (listN.contains(str2)) {
                    arrayList.add(str2);
                    z10 = true;
                }
            }
            if (!z10) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    public static boolean r(String str) {
        return androidx.core.content.a.a(p.a(), str) == 0;
    }

    public static boolean s(String... strArr) {
        Pair<List<String>, List<String>> pairQ = q(strArr);
        if (!((List) pairQ.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) pairQ.first).iterator();
        while (it.hasNext()) {
            if (!r((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean t() {
        return Settings.canDrawOverlays(p.a());
    }

    public static boolean u() {
        return Settings.System.canWrite(p.a());
    }

    public static void v() {
        Intent intentI = r.i(p.a().getPackageName(), true);
        if (r.r(intentI)) {
            p.a().startActivity(intentI);
        }
    }

    public static PermissionUtils x(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public final boolean A(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    public final void C() {
        PermissionActivityImpl.n(1);
    }

    public PermissionUtils m(b bVar) {
        this.f19176b = bVar;
        return this;
    }

    public final void p(Activity activity) {
        for (String str : this.f19178d) {
            if (r(str)) {
                this.f19179e.add(str);
            } else {
                this.f19180f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f19181g.add(str);
                }
            }
        }
    }

    public final void w(Activity activity) {
        p(activity);
        z();
    }

    public void y() {
        String[] strArr = this.f19175a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.f19177c = new LinkedHashSet();
        this.f19178d = new ArrayList();
        this.f19179e = new ArrayList();
        this.f19180f = new ArrayList();
        this.f19181g = new ArrayList();
        Pair<List<String>, List<String>> pairQ = q(this.f19175a);
        this.f19177c.addAll((Collection) pairQ.first);
        this.f19180f.addAll((Collection) pairQ.second);
        for (String str : this.f19177c) {
            if (r(str)) {
                this.f19179e.add(str);
            } else {
                this.f19178d.add(str);
            }
        }
        if (this.f19178d.isEmpty()) {
            z();
        } else {
            C();
        }
    }

    public final void z() {
        if (this.f19176b != null) {
            if (this.f19180f.isEmpty()) {
                this.f19176b.a();
            } else {
                this.f19176b.b();
            }
            this.f19176b = null;
        }
    }
}
