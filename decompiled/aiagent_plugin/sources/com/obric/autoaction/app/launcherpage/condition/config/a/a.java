package com.obric.autoaction.app.launcherpage.condition.config.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationManageFragment;
import com.obric.autoaction.app.launcherpage.ui.f;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ConditionGroupTitleCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.obric.autoaction.app.launcherpage.a.c f22943a;

    public static /* synthetic */ void lambda$zbv9zeNHYgNYdUge5LEDQ7lS678(a r0, View r1) {
        a(r0, r1);
    }

    public a() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(h r3, List r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r3) {
        o.e(r3, "parent");
        com.obric.autoaction.app.launcherpage.a.c r4 = com.obric.autoaction.app.launcherpage.a.c.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));
        o.c(r4, "inflate(...)");
        this.f22943a = r4;
        if (r4 != null) goto L5;
        o.c("binding");
        r4 = null;
    L5:
        RelativeLayout r2 = r4.b();
        o.c(r2, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    public void a(b r6, List<? extends Object> r7) {
        List<? extends Object> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r6, "item");
        o.e(r8, "payloads");
        super.a((h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.aiagent.plugin"), r8);
        com.obric.autoaction.app.launcherpage.a.c r9 = this.f22943a;
        com.obric.autoaction.app.launcherpage.a.c r0 = null;
        if (r9 != null) goto L5;
        o.c("binding");
        r9 = null;
    L5:
        r9.f22806d.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r6.a().getGroupTitleRes()), CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.autoaction.app.launcherpage.a.c r10 = this.f22943a;
        if (r10 != null) goto L8;
        o.c("binding");
    L9:
        r0.f22806d.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3")));
        a(r6);
        return;
    L8:
        r0 = r10;
        goto L9
    }

    private final void a(b r7) {
        boolean r8 = o.a(r7.a().getGroupName(), "location");
        com.obric.autoaction.app.launcherpage.a.c r0 = this.f22943a;
        com.obric.autoaction.app.launcherpage.a.c r2 = null;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        LinearLayout r1 = r0.f22804b;
        if (r8 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        if (r8 == false) goto L19;
        com.obric.autoaction.app.launcherpage.a.c r9 = this.f22943a;
        if (r9 != null) goto L14;
        o.c("binding");
        r9 = null;
    L14:
        r9.f22805c.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3")));
        com.obric.autoaction.app.launcherpage.a.c r10 = this.f22943a;
        if (r10 != null) goto L17;
        o.c("binding");
    L18:
        r2.f22804b.setOnClickListener(new $$Lambda$a$zbv9zeNHYgNYdUge5LEDQ7lS678(this));
        return;
    L17:
        r2 = r10;
        goto L18
    L19:
        com.obric.autoaction.app.launcherpage.a.c r6 = this.f22943a;
        if (r6 != null) goto L22;
        o.c("binding");
        r6 = null;
    L22:
        r6.f22804b.setOnClickListener(null);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    private static final void a(a r1, View r2) {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "getContext(...)");
        ComponentActivity r4 = (ComponentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.autoaction.app.launcherpage.ui.e.a(r3), "com.obric.aiagent.plugin"), ComponentActivity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, FragmentActivity.class) == false) goto L5;
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 == null) goto L9;
        FrequentLocationManageFragment.Companion.a(r5);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
