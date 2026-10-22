package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionEventLocationAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f23124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<ConditionLocationItemData> f23126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> f23127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.h.a.b<? super ConditionLocationItemData, x> f23128e;
    private Map<Integer, Integer> f;
    private ConditionLocationItemData g;
    private ConditionLocationItemData h;
    private d.h.a.b<? super ConditionLocationItemData, x> i;

    /* JADX INFO: compiled from: ConditionEventLocationAdapter.kt */
    public final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f23129a;
        private final OCardListItem s;

        public a(b r2, OCardListItem r3) {
            d.h.b.o.e(r3, "rootView");
            this.f23129a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
            this.s = r3;
        }

        public final OCardListItem a() {
            return this.s;
        }

        public final void a(ConditionLocationItemData r4) {
            d.h.b.o.e(r4, "item");
            if (r4.isSet() == false) goto L5;
            b(r4);
        L6:
            this.s.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r4.getTitle(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.getTitleView().setMaxLines(1);
            b();
            return;
        L5:
            c(r4);
            goto L6
        }

        private final void b(ConditionLocationItemData r10) {
            this.s.showCustomEnd(false);
            if (r10.isStrictlySame(b.a(this.f23129a)) == false) goto L10;
            this.s.showTailIcon(true);
            int r0 = ZeusTransformUtils.mapRes(R.drawable.oic_check, "drawable", "oic_check");
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r1, "getContext(...)");
            Drawable r5 = null;
            Drawable r2 = p.a(r0, r1, null, 2, null);
            if (r2 == null) goto L9;
            Drawable r3 = r2.mutate();
            if (r3 == null) goto L9;
            int r4 = ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg");
            Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r7, "getContext(...)");
            r3.setTint(p.b(r4, r7, null, 2, null));
            r5 = r3;
        L9:
            this.s.setTailIcon(r5);
        L11:
            this.s.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r10.getAddress(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.showSubTitle(true);
            return;
        L10:
            this.s.showTailIcon(false);
            goto L11
        }

        private final void c(ConditionLocationItemData r8) {
            this.s.showTailIcon(true);
            if (b.a(this.f23129a, r8) == false) goto L5;
            this.s.setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.condition_location_auto_learning, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_auto_learning"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.showSubTitle(true);
        L6:
            this.s.showCustomEnd(true);
            this.s.setDefaultTailIcon(0);
            this.s.setDefaultCustomEndView(3);
            OCardListItem.setEndDetailText$default(this.s, (CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.condition_location_go_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "condition_location_go_settings"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"), 0, 2, null);
            return;
        L5:
            this.s.showSubTitle(false);
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

    /* JADX INFO: renamed from: lambda$bs-Ypy2e2a1OGqNRw0WmPFVPe3Q, reason: not valid java name */
    public static /* synthetic */ x m459lambda$bsYpy2e2a1OGqNRw0WmPFVPe3Q(ConditionLocationItemData r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$mSoYSIELwOL1XrcHEjTlkEBYcAw(ConditionLocationItemData r0, b r1, int r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static final /* synthetic */ ConditionLocationItemData a(b r0) {
        return r0.h;
    }

    public static final /* synthetic */ boolean a(b r0, ConditionLocationItemData r1) {
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

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this.f23124a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f23125b = "from";
        this.f23126c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f = ao.b();
        this.i = $$Lambda$b$bsYpy2e2a1OGqNRw0WmPFVPe3Q.INSTANCE;
    }

    private static final x b(ConditionLocationItemData r0) {
        return x.f38692a;
    }

    public final void a(d.h.a.b<? super ConditionLocationItemData, x> r3) {
        d.h.a.b<? super ConditionLocationItemData, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        this.i = r4;
    }

    public final void a(List<ConditionLocationItemData> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "items");
        this.f23126c.clear();
        this.f23126c.addAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin"));
        ConditionLocationItemData r0 = this.g;
        ConditionLocationItemData r2 = null;
        Object r3 = null;
        Object r4 = null;
        if (r0 == null) goto L34;
        int r5 = r0.getType();
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L24;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        if (((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r7, ConditionLocationItemData.class, "com.obric.aiagent.plugin")).isStrictlySame(r0) == false) goto L9;
    L14:
        ConditionLocationItemData r10 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r7, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L23;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L18:
        if (r11.hasNext() == false) goto L22;
        Object r12 = r11.next();
        if (((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r12, ConditionLocationItemData.class, "com.obric.aiagent.plugin")).isSame(r0) == false) goto L18;
        r3 = r12;
    L22:
        r2 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r3, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        goto L34
    L23:
        r2 = r10;
        goto L34
    L13:
        r7 = null;
    L24:
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L26:
        if (r13.hasNext() == false) goto L33;
        Object r14 = r13.next();
        if (((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r14, ConditionLocationItemData.class, "com.obric.aiagent.plugin")).getType() != r0.getType()) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == false) goto L26;
        r4 = r14;
        goto L33
    L30:
        r15 = false;
    L33:
        r2 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r4, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
    L34:
        this.h = r2;
        this.i.invoke(r2);
        g();
    }

    public final ConditionLocationItemData b() {
        return this.h;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "type");
        this.f23125b = r2;
    }

    public final void a(Map<Integer, Integer> r3) {
        Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "learningStatus");
        if (d.h.b.o.a(this.f, r4) == false) goto L5;
        return;
    L5:
        this.f = r4;
        g();
    }

    private final boolean a(ConditionLocationItemData r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r2.getType())), Integer.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (r1.intValue() != 1) goto L8;
        return true;
    }

    public final void a(com.obric.autoaction.app.launcherpage.condition.config.condition.g r14) {
        com.obric.autoaction.app.launcherpage.condition.config.condition.g r15 = (com.obric.autoaction.app.launcherpage.condition.config.condition.g) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.autoaction.app.launcherpage.condition.config.condition.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r15, "location");
        this.g = null;
        Integer r0 = r15.getLocationType();
        if (r0 == null) goto L17;
        int r2 = r0.intValue();
        if (r2 != 0) goto L7;
    L14:
        this.g = new ConditionLocationItemData(r2, "", "", 0.0d, 0.0d, false, null, 96, null);
        return;
    L7:
        if (r2 == 1) goto L14;
        Double r1 = r15.getLongitude();
        if (r1 == null) goto L13;
        double r5 = r1.doubleValue();
        Double r16 = r15.getLatitude();
        if (r16 == null) goto L16;
        this.g = new ConditionLocationItemData(r2, "", "", r5, r16.doubleValue(), false, null, 96, null);
        return;
    L16:
        return;
    L13:
        return;
    }

    public final void a(d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> r3) {
        d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> r4 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.f23127d = r4;
    }

    public final void b(d.h.a.b<? super ConditionLocationItemData, x> r3) {
        d.h.a.b<? super ConditionLocationItemData, x> r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "listener");
        this.f23128e = r4;
    }

    public a a(ViewGroup r7, int r8) {
        d.h.b.o.e(r7, "parent");
        OCardListItem r9 = new OCardListItem(this.f23124a, null, 0, 6, null);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return new a(this, r9);
    }

    public void a(a r4, final int r5) {
        d.h.b.o.e(r4, "holder");
        final ConditionLocationItemData r0 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(this.f23126c.get(r5), ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        r4.a(r0);
        r4.a().setOnContentClickListener(new $$Lambda$b$mSoYSIELwOL1XrcHEjTlkEBYcAw(r0, this, r5));
    }

    private static final void a(ConditionLocationItemData r2, b r3, int r4, View r5) {
        if (r2.isSet() == true) goto L8;
        d.h.a.b<? super ConditionLocationItemData, x> r6 = r3.f23128e;
        if (r6 == null) goto L17;
        r6.invoke(r2);
        return;
    L17:
        return;
    L8:
        ConditionLocationItemData r7 = r3.h;
        r3.g = r2;
        r3.h = r2;
        r3.i.invoke(r2);
        d.h.a.m<? super ConditionLocationItemData, ? super Integer, x> r0 = r3.f23127d;
        if (r0 == null) goto L11;
        r0.invoke(r2, Integer.valueOf(r4));
    L11:
        if (r7 == null) goto L15;
        int r8 = r3.f23126c.indexOf(r7);
        if (r8 < 0) goto L15;
        r3.d(r8);
    L15:
        r3.d(r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a() {
        return this.f23126c.size();
    }
}
