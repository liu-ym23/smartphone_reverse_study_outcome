package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: PowerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f<T extends h> extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f24443a;
    private d<T> s;

    public abstract View a(ViewGroup r1);

    public void a(T r2, List<? extends Object> r3) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "item");
        d.h.b.o.e(r4, "payloads");
    }

    public void c() {
    }

    private f(View r1) {
        super(r1);
    }

    public f() {
        this((View) ZeusTransformUtils.preCheckCast(new Space((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), View.class, "com.obric.aiagent.plugin"));
    }

    public final T a() {
        return this.f24443a;
    }

    public final void b(T r3) {
        this.f24443a = (T) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
    }

    public final d<T> b() {
        return this.s;
    }

    public final void a(d<T> r1) {
        this.s = r1;
    }

    public final void b(T r3, List<? extends Object> r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        a(r5);
        return;
    L14:
        a(r5, r6);
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }

    public void a(T r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "item");
        a(r4, d.a.p.b());
    }
}
