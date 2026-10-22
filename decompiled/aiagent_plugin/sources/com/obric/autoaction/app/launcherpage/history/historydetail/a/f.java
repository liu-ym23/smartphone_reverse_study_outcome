package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: HistoryDetailBottomTipCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autoaction.app.launcherpage.ui.f<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OTextView f23861a;

    public f() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r10) {
        o.e(r10, "parent");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getContext(...)");
        OTextView r0 = new OTextView(r2, null, 0, null, 14, null);
        r0.setPadding(d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())));
        r0.setTextColor(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
        this.f23861a = r0;
        if (r0 != null) goto L6;
        o.c("titleTv");
        r0 = null;
    L6:
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
    }

    public void a(a r3, List<? extends Object> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "item");
        o.e(r5, "payloads");
        OTextView r2 = this.f23861a;
        if (r2 != null) goto L5;
        o.c("titleTv");
        r2 = null;
    L5:
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3.a(), CharSequence.class, "com.obric.aiagent.plugin"));
    }
}
