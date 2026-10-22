package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<c, View> f138332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f138333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f138334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f138335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f138336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UILayout f138337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WindowLayoutType f138338g;

    public final void b() {
        Iterator r100 = ((LinkedHashMap) this.f138332a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a((c) ((Map.Entry) r100.next()).getKey());
        goto L4
    }

    public q() {
        this.f138332a = new LinkedHashMap();
        this.f138337f = UILayout.Normal;
        this.f138338g = WindowLayoutType.Normal;
    }

    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "iComponent");
        View r101 = (View) ((LinkedHashMap) this.f138332a).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = true;
        if (this.f138333b == false) goto L8;
        boolean r103 = r100.c();
    L10:
        if (r103 == true) goto L12;
    L35:
        boolean r104 = false;
    L37:
        if (r101.getVisibility() == 0) goto L40;
        r102 = false;
    L40:
        if (r102 == r104) goto L43;
        UtilityKotlinExtentionsKt.z(r101, r104);
        r100.h(r104);
        return;
    L43:
        return;
    L12:
        if (this.f138334c == false) goto L14;
        boolean r105 = r100.d();
    L15:
        if (r105 == false) goto L35;
        if (this.f138333b == true) goto L19;
        boolean r106 = r100.f();
    L20:
        if (r106 == false) goto L35;
        if (r100.i(this.f138335d) == false) goto L35;
        if (this.f138336e == true) goto L26;
        boolean r107 = r100.e();
    L27:
        if (r107 == false) goto L35;
        if (r100.a(this.f138337f) == false) goto L35;
        if (r100.g(this.f138338g) == false) goto L35;
        if (r100.b() == false) goto L35;
        r104 = true;
        goto L37
    L26:
        r107 = true;
        goto L27
    L19:
        r106 = true;
        goto L20
    L14:
        r105 = true;
        goto L15
    L8:
        r103 = true;
        goto L10
    }

    public final void c(p r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        View r101 = r100.f138322c;
        Intrinsics.checkNotNullParameter(r100, "iComponent");
        this.f138332a.put(r100, r101);
        r100.f138320a = this;
        a(r100);
    }
}
