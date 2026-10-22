package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailTopTipViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends z<x> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.m f23371b;

    public y(String r2) {
        d.h.b.o.e(r2, "desc");
        this.f23370a = r2;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        com.obric.autoaction.app.launcherpage.a.m r5 = com.obric.autoaction.app.launcherpage.a.m.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23371b = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        FrameLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public x a(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        d.h.b.o.e(r2, "context");
        return new x(this.f23370a);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        com.obric.autoaction.app.launcherpage.a.m r0 = this.f23371b;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22837a.setText((CharSequence) ZeusTransformUtils.preCheckCast(((x) ZeusTransformUtils.preCheckCast(f(), x.class, "com.obric.aiagent.plugin")).a(), CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
