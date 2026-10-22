package com.bytedance.android.shopping.store.router;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements uk3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f185859a;

    public c(Context r100) {
        this.f185859a = r100;
    }

    @Override // uk3.b
    public final void a(Object r100, Activity r101) {
        int r102 = wk3.a.f560094a;
        StringBuilder r103 = new StringBuilder("shopScreenAdapt After:target=");
        Float r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.getClass().getSimpleName();
    L6:
        r103.append(r105);
        r103.append(",density=");
        if (r101 == null) goto L13;
        Resources r106 = r101.getResources();
        if (r106 == null) goto L13;
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());
        if (r107 == null) goto L13;
        Float r108 = Float.valueOf(r107.density);
    L14:
        r103.append(r108);
        r103.append(",system.density=");
        Resources r109 = Resources.getSystem();
        r103.append(WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density);
        r103.append(",application.density=");
        Resources r110 = ((Application) this.f185859a).getResources();
        if (r110 == null) goto L19;
        DisplayMetrics r111 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics());
        if (r111 == null) goto L19;
        r104 = Float.valueOf(r111.density);
    L19:
        r103.append(r104);
        wk3.a.a(r103.toString());
        return;
    L13:
        r108 = null;
        goto L14
    L5:
        r105 = null;
        goto L6
    }

    @Override // uk3.b
    public final void b(Object r100, Activity r101) {
        int r102 = wk3.a.f560094a;
        StringBuilder r103 = new StringBuilder("shopScreenAdapt Before:target=");
        DisplayMetrics r104 = null;
        if (r100 == null) goto L5;
        String r105 = r100.getClass().getSimpleName();
    L6:
        r103.append(r105);
        r103.append(",density=");
        if (r101 == null) goto L13;
        Resources r106 = r101.getResources();
        if (r106 == null) goto L13;
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());
        if (r107 == null) goto L13;
        Float r108 = Float.valueOf(r107.density);
    L14:
        r103.append(r108);
        r103.append(",system.density=");
        Resources r109 = Resources.getSystem();
        r103.append(WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density);
        r103.append(",application.density=");
        Resources r110 = ((Application) this.f185859a).getResources();
        if (r110 == null) goto L19;
        DisplayMetrics r111 = WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics());
        if (r111 == null) goto L19;
        Float r112 = Float.valueOf(r111.density);
    L20:
        r103.append(r112);
        r103.append(",hashcode=");
        Resources r113 = ((Application) this.f185859a).getResources();
        if (r113 == null) goto L23;
        r104 = WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics());
    L23:
        if (r104 == null) goto L25;
        int r114 = r104.hashCode();
    L26:
        r103.append(r114);
        wk3.a.a(r103.toString());
        return;
    L25:
        r114 = 0;
    L19:
        r112 = null;
    L13:
        r108 = null;
        goto L14
    L5:
        r105 = null;
        goto L6
    }
}
