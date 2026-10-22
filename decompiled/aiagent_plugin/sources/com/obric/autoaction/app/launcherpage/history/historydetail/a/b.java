package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.autoaction.app.launcherpage.a.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: HistoryDetailItemContentCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autoaction.app.launcherpage.ui.f<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private v f23857a;

    public b() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        o.e(r4, "parent");
        v r5 = v.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        o.c(r5, "inflate(...)");
        this.f23857a = r5;
        if (r5 != null) goto L5;
        o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(c r3, List<? extends Object> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "item");
        o.e(r5, "payloads");
        v r2 = this.f23857a;
        if (r2 != null) goto L5;
        o.c("binding");
        r2 = null;
    L5:
        r2.f22867a.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
