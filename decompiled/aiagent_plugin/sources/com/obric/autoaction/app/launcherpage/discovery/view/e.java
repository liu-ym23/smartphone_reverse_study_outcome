package com.obric.autoaction.app.launcherpage.discovery.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.obric.autoaction.app.launcherpage.a.s;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: TitleCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f<com.obric.autoaction.app.launcherpage.discovery.a.b.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f23670a;

    public e() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(h r3, List r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((com.obric.autoaction.app.launcherpage.discovery.a.b.d) ZeusTransformUtils.preCheckCast(r5, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        o.e(r4, "parent");
        s r5 = s.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        o.c(r5, "inflate(...)");
        this.f23670a = r5;
        if (r5 != null) goto L5;
        o.c("binding");
        r5 = null;
    L5:
        RelativeLayout r3 = r5.b();
        o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(com.obric.autoaction.app.launcherpage.discovery.a.b.d r3, List<? extends Object> r4) {
        List<? extends Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "item");
        o.e(r5, "payloads");
        super.a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"), r5);
        s r2 = this.f23670a;
        if (r2 != null) goto L5;
        o.c("binding");
        r2 = null;
    L5:
        r2.f22857a.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
