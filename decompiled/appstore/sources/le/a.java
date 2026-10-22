package le;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import bg.h;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.j0;
import kotlin.collections.k0;
import kotlin.coroutines.Continuation;
import kotlin.d;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f21946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableStateFlow f21947c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlow f21948d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final CompletableDeferred f21949e = null;

    static {
        f21945a = new a();
        MutableStateFlow r10 = f1.a(k0.h());
        f21947c = r10;
        f21948d = kotlinx.coroutines.flow.c.b(r10);
        f21949e = u.b(null, 1, null);
    }

    public a() {
    }

    public static final void c(Context r10) {
        q.g(r10, "context");
        f21946b = r10;
        MutableStateFlow r11 = f21947c;
        PackageManager r12 = r10.getPackageManager();
        if (r12 == null) goto L10;
        List<PackageInfo> r13 = r12.getInstalledPackages(0);
        if (r13 == null) goto L10;
        Map r14 = new LinkedHashMap(h.d(j0.e(kotlin.collections.u.r(r13, 10)), 16));
        Iterator<T> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L11;
        PackageInfo r16 = (PackageInfo) r15.next();
        String r17 = r16.packageName;
        q.f(r17, "packageName");
        Pair r18 = d.a(r17, new c(r17, r16.getLongVersionCode()));
        r14.put(r18.getFirst(), r18.getSecond());
    L11:
        r11.setValue(r14);
        f21949e.complete(Unit.f21064a);
        j.o("[AppStatus][InstalledPkgs] loadPkgs, size=" + ((Map) f21947c.getValue()).size());
        return;
    L10:
        r14 = k0.h();
        goto L11
    }

    public static final void d(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j.o("[AppStatus][InstalledPkgs] onPackageAdded, pkg=" + r10);
        Context r11 = f21946b;
        Object r12 = null;
        if (r11 == null) goto L5;
        PackageManager r13 = r11.getPackageManager();
    L6:
        if (r13 != null) goto L20;
        return;
    L20:
        Result.a r14 = Result.Companion;     // Catch: Throwable -> L10
        Object r15 = Result.m35constructorimpl(r13.getPackageInfo(r10, 0));     // Catch: Throwable -> L10
    L13:
        if (Result.m41isFailureimpl(r15) == true) goto L16;
        r12 = r15;
    L16:
        PackageInfo r16 = (PackageInfo) r12;
        if (r16 == null) goto L22;
        MutableStateFlow r17 = f21947c;
        r17.setValue(k0.n((Map) r17.getValue(), d.a(r10, new c(r10, r16.getLongVersionCode()))));
        Unit r18 = Unit.f21064a;
        j.p("[AppStatus][InstalledPkgs] getPackageInfo err, pkg=" + r10);
        return;
    L22:
        return;
    L10:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public static final void e(String r10) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        j.o("[AppStatus][InstalledPkgs] onPackageRemoved, pkg=" + r10);
        MutableStateFlow r11 = f21947c;
        r11.setValue(k0.k((Map) r11.getValue(), r10));
    }

    public final Object a(Continuation r10) {
        Object r11 = f21949e.await(r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final StateFlow b() {
        return f21948d;
    }
}
