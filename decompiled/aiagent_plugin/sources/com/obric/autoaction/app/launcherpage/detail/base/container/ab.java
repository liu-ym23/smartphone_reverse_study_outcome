package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DetailViewContainerManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f23297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autoaction.app.launcherpage.detail.base.a f23298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<z<?>> f23299c;

    public ab(ViewGroup r2, com.obric.autoaction.app.launcherpage.detail.base.a r3) {
        d.h.b.o.e(r2, "container");
        d.h.b.o.e(r3, "context");
        this.f23297a = r2;
        this.f23298b = r3;
        this.f23299c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    private final LinearLayout.LayoutParams a(z<?> r4) {
        ViewGroup.LayoutParams r3 = r4.e().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayout.LayoutParams.class) == false) goto L6;
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
    L13:
        if (r4.d() <= 0) goto L15;
        r5.topMargin = d.i.a.a(TypedValue.applyDimension(1, r4.d(), Resources.getSystem().getDisplayMetrics()));
    L15:
        return r5;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L9;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L8:
        r5 = r0;
        goto L13
    L9:
        if (r3 != null) goto L11;
        r5 = new LinearLayout.LayoutParams(-1, -2);
        goto L13
    L11:
        r0 = new LinearLayout.LayoutParams(r3);
        goto L8
    }

    public final void a() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f23299c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((z) ZeusTransformUtils.preCheckCast(r0.next(), z.class, "com.obric.aiagent.plugin")).c(this.f23298b);
        goto L4
    }

    public final void b() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f23299c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((z) ZeusTransformUtils.preCheckCast(r0.next(), z.class, "com.obric.aiagent.plugin")).d(this.f23298b);
        goto L4
    }

    public final void c() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f23299c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((z) ZeusTransformUtils.preCheckCast(r0.next(), z.class, "com.obric.aiagent.plugin")).h();
        goto L4
    L6:
        this.f23299c.clear();
        this.f23297a.removeAllViews();
    }

    public final void a(z<?>... r8) {
        d.h.b.o.e(r8, "newViewContainers");
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        z<?> r2 = r8[r1];
        ((Collection) ZeusTransformUtils.preCheckCast(this.f23299c, Collection.class, "com.obric.aiagent.plugin")).add(r2);
        r2.b(this.f23297a);
        this.f23297a.addView(r2.e(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(a(r2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1 = r1 + 1;
        goto L3
    }
}
