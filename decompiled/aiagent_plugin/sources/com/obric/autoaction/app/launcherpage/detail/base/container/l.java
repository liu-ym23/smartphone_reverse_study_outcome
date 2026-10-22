package com.obric.autoaction.app.launcherpage.detail.base.container;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.at;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.eventkit.task.model.EventTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailKnowledgeViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends z<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private at f23329a;

    /* JADX INFO: renamed from: lambda$xQXRjzwYCLb-wJY64KhTFH7oCLE, reason: not valid java name */
    public static /* synthetic */ void m481lambda$xQXRjzwYCLbwJY64KhTFH7oCLE(l r0, View r1) {
        a(r0, r1);
    }

    public l() {
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public /* synthetic */ com.obric.autoaction.app.launcherpage.detail.base.f b(com.obric.autoaction.app.launcherpage.detail.base.a r2) {
        return (com.obric.autoaction.app.launcherpage.detail.base.f) ZeusTransformUtils.preCheckCast(a(r2), com.obric.autoaction.app.launcherpage.detail.base.f.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public View a(ViewGroup r4) {
        d.h.b.o.e(r4, "parent");
        at r5 = at.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        d.h.b.o.c(r5, "inflate(...)");
        this.f23329a = r5;
        if (r5 != null) goto L5;
        d.h.b.o.c("binding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        d.h.b.o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public k a(com.obric.autoaction.app.launcherpage.detail.base.a r5) {
        d.h.b.o.e(r5, "context");
        EventTask r4 = r5.c().a();
        int r6 = 0;
        String r0 = null;
        if (r4 == null) goto L13;
        String r1 = r4.getId();
        if (r1 == null) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        r0 = r1;
        goto L13
    L9:
        r2 = false;
    L13:
        if (r4 == null) goto L16;
        r6 = r4.getType();
    L16:
        return new k(r0, r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void a() {
        at r0 = this.f23329a;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22777a.setOnContentClickListener(new $$Lambda$l$xQXRjzwYCLbwJY64KhTFH7oCLE(this));
    }

    private static final void a(l r4, View r5) {
        String r6 = ((k) ZeusTransformUtils.preCheckCast(r4.f(), k.class, "com.obric.aiagent.plugin")).a();
        if (r6 != null) goto L5;
        return;
    L5:
        KnowledgeActivity.a r0 = KnowledgeActivity.Companion;
        at r2 = r4.f23329a;
        if (r2 != null) goto L8;
        d.h.b.o.c("binding");
        r2 = null;
    L8:
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.b().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r3, "getContext(...)");
        r0.a(r3, r6, ((k) ZeusTransformUtils.preCheckCast(r4.f(), k.class, "com.obric.aiagent.plugin")).b());
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.container.z
    public void b() {
        at r0 = this.f23329a;
        at r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("binding");
        r0 = null;
    L5:
        r0.f22777a.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.autoaction.app.launcherpage.utils.p.a(ZeusTransformUtils.mapRes(R.string.detail_knowledge_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "detail_knowledge_desc"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        at r1 = this.f23329a;
        if (r1 != null) goto L8;
        d.h.b.o.c("binding");
        r1 = null;
    L8:
        r1.f22777a.showSubTitle(true);
        at r3 = this.f23329a;
        if (r3 != null) goto L11;
        d.h.b.o.c("binding");
        r3 = null;
    L11:
        com.obric.autoaction.app.launcherpage.utils.p.a((View) ZeusTransformUtils.preCheckCast(r3.f22777a.getSubTitleView(), View.class, "com.obric.aiagent.plugin"), 0, d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())), 0, 0, 13, null);
        at r12 = this.f23329a;
        if (r12 != null) goto L14;
        d.h.b.o.c("binding");
    L15:
        r2.f22777a.setDefaultTailIcon(0);
        return;
    L14:
        r2 = r12;
        goto L15
    }
}
