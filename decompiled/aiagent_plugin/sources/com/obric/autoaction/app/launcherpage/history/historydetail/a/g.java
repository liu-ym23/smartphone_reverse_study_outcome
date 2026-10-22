package com.obric.autoaction.app.launcherpage.history.historydetail.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.y;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.AOPackagesTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: HistoryDetailThoughtEndCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.obric.autoaction.app.launcherpage.ui.f<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y f23862a;

    public g() {
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public /* synthetic */ void a(com.obric.autoaction.app.launcherpage.ui.h r3, List r4) {
        com.obric.autoaction.app.launcherpage.ui.h r5 = (com.obric.autoaction.app.launcherpage.ui.h) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autoaction.app.launcherpage.ui.h.class, "com.obric.aiagent.plugin");
        List<? extends Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.f
    public View a(ViewGroup r4) {
        o.e(r4, "parent");
        y r5 = y.a(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), r4, false);
        o.c(r5, "inflate(...)");
        this.f23862a = r5;
        if (r5 != null) goto L5;
        o.c("viewBinding");
        r5 = null;
    L5:
        LinearLayout r3 = r5.b();
        o.c(r3, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    }

    public void a(h r14, List<? extends Object> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        o.e(r14, "item");
        o.e(r16, "payloads");
        y r17 = this.f23862a;
        y r2 = null;
        if (r17 != null) goto L5;
        o.c("viewBinding");
        r17 = null;
    L5:
        LinearLayout r18 = r17.f22876b;
        int r3 = r14.getType();
        if (r3 != 1) goto L8;
        r18.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.history_detail_thought_top_bg, "drawable", "history_detail_thought_top_bg"));
        y r19 = this.f23862a;
        if (r19 != null) goto L29;
        o.c("viewBinding");
        r19 = null;
    L29:
        float r4 = 12;
        r19.b().setPadding(d.i.a.a(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        y r110 = this.f23862a;
        if (r110 != null) goto L32;
        o.c("viewBinding");
        r110 = null;
    L32:
        r110.f22875a.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.history_detail_icon_border, "drawable", "history_detail_icon_border"));
    L33:
        String r111 = r14.b();
        if (r111 == null) goto L39;
        AOPackagesTools r5 = AOPackagesTools.INSTANCE;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "getContext(...)");
        Drawable r112 = r5.getAppIconDrawable(r6, r111);
        y r7 = this.f23862a;
        if (r7 != null) goto L38;
        o.c("viewBinding");
        r7 = null;
    L38:
        r7.f22875a.setImageDrawable(r112);
    L39:
        Integer r113 = r14.a();
        if (r113 == null) goto L45;
        int r114 = ((Number) ZeusTransformUtils.preCheckCast(r113, Number.class, "com.obric.aiagent.plugin")).intValue();
        y r8 = this.f23862a;
        if (r8 != null) goto L44;
        o.c("viewBinding");
        r8 = null;
    L44:
        ImageView r9 = r8.f22875a;
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f35660b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r10, "getContext(...)");
        r9.setImageDrawable(p.a(r114, r10, null, 2, null));
    L45:
        y r13 = this.f23862a;
        if (r13 != null) goto L48;
        o.c("viewBinding");
    L49:
        r2.f22877c.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14.c(), CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L48:
        r2 = r13;
        goto L49
    L8:
        if (r3 != 2) goto L10;
        r18.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card"));
        y r115 = this.f23862a;
        if (r115 != null) goto L22;
        o.c("viewBinding");
        r115 = null;
    L22:
        float r11 = 12;
        r115.b().setPadding(d.i.a.a(TypedValue.applyDimension(1, r11, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r11, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        y r116 = this.f23862a;
        if (r116 != null) goto L25;
        o.c("viewBinding");
        r116 = null;
    L25:
        r116.f22875a.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.history_detail_icon_border, "drawable", "history_detail_icon_border"));
        goto L33
    L10:
        if (r3 != 3) goto L33;
        r18.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.history_detail_thought_bottom_bg, "drawable", "history_detail_thought_bottom_bg"));
        y r117 = this.f23862a;
        if (r117 != null) goto L15;
        o.c("viewBinding");
        r117 = null;
    L15:
        float r12 = 12;
        r117.b().setPadding(d.i.a.a(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())), d.i.a.a(TypedValue.applyDimension(1, r12, Resources.getSystem().getDisplayMetrics())));
        y r118 = this.f23862a;
        if (r118 != null) goto L18;
        o.c("viewBinding");
        r118 = null;
    L18:
        r118.f22875a.setBackgroundResource(0);
        goto L33
    }
}
