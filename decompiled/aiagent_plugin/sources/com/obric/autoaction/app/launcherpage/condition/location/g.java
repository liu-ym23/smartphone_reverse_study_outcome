package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FrequentLocationManageAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ConditionLocationItemData> f23186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.h.a.b<? super ConditionLocationItemData, x> f23187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, Integer> f23189e;

    /* JADX INFO: compiled from: FrequentLocationManageAdapter.kt */
    public final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f23190a;
        private final OCardListItem s;

        public a(g r2, OCardListItem r3) {
            d.h.b.o.e(r3, "rootView");
            this.f23190a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            this.s = r3;
        }

        public final OCardListItem a() {
            return this.s;
        }

        public final void a(ConditionLocationItemData r5, boolean r6) {
            d.h.b.o.e(r5, "item");
            this.s.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r5.getName(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.getTitleView().setMaxLines(1);
            if (r6 == false) goto L5;
            b(r5);
        L6:
            b();
            return;
        L5:
            a(r5);
            goto L6
        }

        private final void a(ConditionLocationItemData r7) {
            this.s.showSubTitle(false);
            if (r7.isSet() == false) goto L5;
            String r8 = r7.getAddress();
        L6:
            this.s.showCustomEnd(true);
            this.s.setDefaultCustomEndView(3);
            OCardListItem.setEndDetailText$default(this.s, (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            this.s.showTailIcon(true);
            this.s.setDefaultTailIcon(0);
            return;
        L5:
            r8 = p.a(ZeusTransformUtils.mapRes(R.string.condition_location_go_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_go_settings"), null, 1, null);
            goto L6
        }

        private final void b(ConditionLocationItemData r8) {
            if (g.a(this.f23190a, r8) == false) goto L5;
            int r0 = ZeusTransformUtils.mapRes(R.string.condition_location_auto_learned, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_auto_learned");
        L6:
            this.s.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(p.a(r0, null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.showSubTitle(true);
            OTextView r1 = this.s.getSubTitleView();
            r1.setMaxLines(1);
            r1.setEllipsize(TextUtils.TruncateAt.END);
            this.s.showCustomEnd(true);
            this.s.setDefaultCustomEndView(3);
            if (g.a(this.f23190a, r8) == false) goto L10;
            OCardListItem.setEndDetailText$default(this.s, (CharSequence) ZeusTransformUtils.preCheckCast(r8.getAddress(), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            this.s.showTailIcon(false);
            return;
        L10:
            if (r8.isSet() == false) goto L12;
            String r9 = r8.getAddress();
        L13:
            OCardListItem.setEndDetailText$default(this.s, (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            this.s.showTailIcon(true);
            this.s.setDefaultTailIcon(0);
            return;
        L12:
            r9 = p.a(ZeusTransformUtils.mapRes(R.string.condition_location_go_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_go_settings"), null, 1, null);
            goto L13
        L5:
            r0 = ZeusTransformUtils.mapRes(R.string.condition_location_auto_learning, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_auto_learning");
            goto L6
        }

        private final void b() {
            RecyclerView.a<? extends RecyclerView.v> r0 = l();
            if (r0 != null) goto L6;
            return;
        L6:
            if (h() != 0) goto L11;
            if (r0.a() != 1) goto L11;
            OCardListItem.setCardPosition$default(this.s, 0, false, 2, null);
            return;
        L11:
            if (h() != 0) goto L16;
            if (r0.a() < 1) goto L16;
            OCardListItem.setCardPosition$default(this.s, 1, false, 2, null);
            return;
        L16:
            if (h() != (r0.a() - 1)) goto L18;
            OCardListItem.setCardPosition$default(this.s, 3, false, 2, null);
            return;
        L18:
            OCardListItem.setCardPosition$default(this.s, 2, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: lambda$iow8-8Ydd6AKrgo-NJf___BDXPE, reason: not valid java name */
    public static /* synthetic */ void m462lambda$iow88Ydd6AKrgoNJf___BDXPE(g r0, ConditionLocationItemData r1, View r2) {
        a(r0, r1, r2);
    }

    public static final /* synthetic */ boolean a(g r0, ConditionLocationItemData r1) {
        return r0.a(r1);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    public g(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f23185a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f23186b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f23189e = ao.b();
    }

    public final void a(d.h.a.b<? super ConditionLocationItemData, x> r3) {
        d.h.a.b<? super ConditionLocationItemData, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.f23187c = r4;
    }

    public final void a(List<ConditionLocationItemData> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "items");
        this.f23186b.clear();
        this.f23186b.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
        g();
    }

    public final void a(boolean r2) {
        if (this.f23188d != r2) goto L5;
        return;
    L5:
        this.f23188d = r2;
        g();
    }

    public final void a(Map<Integer, Integer> r3) {
        Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "learningStatus");
        if (d.h.b.o.a(this.f23189e, r4) == false) goto L5;
        return;
    L5:
        this.f23189e = r4;
        g();
    }

    private final boolean a(ConditionLocationItemData r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f23189e.get(Integer.valueOf(r2.getType())), Integer.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r1.intValue() != 2) goto L8;
        return true;
    }

    public a a(ViewGroup r7, int r8) {
        d.h.b.o.e(r7, "parent");
        OCardListItem r9 = new OCardListItem(this.f23185a, null, 0, 6, null);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return new a(this, r9);
    }

    public void a(a r3, int r4) {
        d.h.b.o.e(r3, "holder");
        final ConditionLocationItemData r5 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(this.f23186b.get(r4), ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        r3.a(r5, this.f23188d);
        if (this.f23188d == true) goto L5;
    L7:
        r3.a().setOnContentClickListener(new $$Lambda$g$iow88Ydd6AKrgoNJf___BDXPE(this, r5));
        return;
    L5:
        if (a(r5) == false) goto L7;
        r3.a().setOnContentClickListener(null);
    }

    private static final void a(g r0, ConditionLocationItemData r1, View r2) {
        d.h.a.b<? super ConditionLocationItemData, x> r3 = r0.f23187c;
        if (r3 == null) goto L6;
        r3.invoke(r1);
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23186b.size();
    }
}
