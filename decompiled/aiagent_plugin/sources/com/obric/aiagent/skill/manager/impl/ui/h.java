package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.obric.oui.orecyclerview.widget.p<m, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f20784a = null;
    private static final Set<j> j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> f20785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> f20786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<d.x> f20787e;
    private final boolean f;
    private final f g;
    private List<com.obric.aiagent.skill.manager.api.e> h;
    private String i;

    /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: InstalledSkillListAdapter.kt */
    public final class b extends RecyclerView.v {
        private final View A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f20788a;
        private final OCardListItem s;
        private final SimpleDraweeView t;
        private final TextView u;
        private final TextView v;
        private final View w;
        private final SimpleDraweeView x;
        private final TextView y;
        private final OSwitch z;

        /* JADX INFO: renamed from: lambda$NVwVckFNO2w57oL9f8iMcWK-Cdk, reason: not valid java name */
        public static /* synthetic */ void m345lambda$NVwVckFNO2w57oL9f8iMcWKCdk(b r0, h r1, View r2) {
            a(r0, r1, r2);
        }

        /* JADX INFO: renamed from: lambda$QArO2l03Dzb-XU5w_QXuYM0KPSU, reason: not valid java name */
        public static /* synthetic */ void m346lambda$QArO2l03DzbXU5w_QXuYM0KPSU(b r0, h r1, View r2) {
            b(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$eu_9LCyonhn6BLdwwGctGgtGO4g(h r0, View r1) {
            a(r0, r1);
        }

        public b(h r8, View r9) {
            d.h.b.o.e(r9, "itemView");
            this.f20788a = r8;
            super(r9);
            this.s = (OCardListItem) ZeusTransformUtils.preCheckCast(r9, OCardListItem.class, "com.obric.aiagent.plugin");
            View r10 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_icon, DbHelper.COL_ID, "skill_icon"));
            d.h.b.o.c(r10, "findViewById(...)");
            this.t = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r10, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r11 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_name, DbHelper.COL_ID, "skill_name"));
            d.h.b.o.c(r11, "findViewById(...)");
            this.u = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.aiagent.plugin");
            View r12 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_description, DbHelper.COL_ID, "skill_description"));
            d.h.b.o.c(r12, "findViewById(...)");
            this.v = (TextView) ZeusTransformUtils.preCheckCast(r12, TextView.class, "com.obric.aiagent.plugin");
            View r13 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source_row, DbHelper.COL_ID, "skill_source_row"));
            d.h.b.o.c(r13, "findViewById(...)");
            this.w = r13;
            View r14 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source_avatar, DbHelper.COL_ID, "skill_source_avatar"));
            d.h.b.o.c(r14, "findViewById(...)");
            this.x = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r14, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r15 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source, DbHelper.COL_ID, "skill_source"));
            d.h.b.o.c(r15, "findViewById(...)");
            this.y = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.aiagent.plugin");
            View r16 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_switch, DbHelper.COL_ID, "skill_switch"));
            d.h.b.o.c(r16, "findViewById(...)");
            this.z = (OSwitch) ZeusTransformUtils.preCheckCast(r16, OSwitch.class, "com.obric.aiagent.plugin");
            View r17 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.skill_switch_guard, DbHelper.COL_ID, "skill_switch_guard"));
            d.h.b.o.c(r17, "findViewById(...)");
            this.A = r17;
            int[] r2 = {ZeusTransformUtils.mapRes(R.id.skill_item_content, DbHelper.COL_ID, "skill_item_content"), ZeusTransformUtils.mapRes(R.id.skill_icon_box, DbHelper.COL_ID, "skill_icon_box"), ZeusTransformUtils.mapRes(R.id.skill_texts, DbHelper.COL_ID, "skill_texts"), ZeusTransformUtils.mapRes(R.id.skill_source_row, DbHelper.COL_ID, "skill_source_row"), ZeusTransformUtils.mapRes(R.id.skill_source_avatar_box, DbHelper.COL_ID, "skill_source_avatar_box"), ZeusTransformUtils.mapRes(R.id.skill_switch_container, DbHelper.COL_ID, "skill_switch_container")};
            int r1 = 0;
        L3:
            if (r1 >= 6) goto L11;
            View r3 = r9.findViewById(r2[r1]);
            if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.common.style.a.class) == false) goto L7;
            com.obric.oui.common.style.a r4 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.common.style.a.class, "com.obric.aiagent.plugin");
        L8:
            if (r4 == null) goto L10;
            r4.setChangeAlphaWhenPress(false);
        L10:
            r1 = r1 + 1;
            goto L3
        L7:
            r4 = null;
            goto L8
        L11:
            this.s.setAlpha(1.0f);
            OCardListItem r18 = this.s;
            final h r19 = this.f20788a;
            r18.setOnContentClickListener(new $$Lambda$h$b$NVwVckFNO2w57oL9f8iMcWKCdk(this, r19));
            View r20 = this.A;
            final h r21 = this.f20788a;
            r20.setOnClickListener(new $$Lambda$h$b$eu_9LCyonhn6BLdwwGctGgtGO4g(r21));
            OSwitch r22 = this.z;
            final h r23 = this.f20788a;
            r22.setOnClickListener(new $$Lambda$h$b$QArO2l03DzbXU5w_QXuYM0KPSU(this, r23));
        }

        private static final void a(b r0, h r1, View r2) {
            com.obric.aiagent.skill.manager.api.e r3 = r0.a();
            if (r3 == null) goto L6;
            h.b(r1).invoke(r3);
            return;
        }

        private static final void a(h r0, View r1) {
            h.c(r0).invoke();
        }

        private static final void b(b r0, h r1, View r2) {
            com.obric.aiagent.skill.manager.api.e r3 = r0.a();
            if (r3 == null) goto L6;
            h.d(r1).invoke(r3);
            return;
        }

        public final void a(m r12, Set<? extends j> r13) {
            Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r12, "row");
            d.h.b.o.e(r14, "changedFields");
            if (r14.contains(j.f20789a) == false) goto L6;
            q.a(this.s, r12.b(), r12.c());
        L6:
            if (r14.contains(j.f20790b) == false) goto L16;
            k r0 = r12.d();
            if (ZeusTransformUtils.instanceOf(r0, k.b.class) == false) goto L11;
            s.a(s.f20812a, this.t, ((k.b) ZeusTransformUtils.preCheckCast(r0, k.b.class, "com.obric.aiagent.plugin")).a(), 14.0f, true, null, 16, null);
            goto L16
        L11:
            if (ZeusTransformUtils.instanceOf(r0, k.a.class) == false) goto L14;
            com.obric.aiagent.skill.manager.impl.ui.a.f20482a.a(this.t, ((k.a) ZeusTransformUtils.preCheckCast(r0, k.a.class, "com.obric.aiagent.plugin")).a(), 14.0f);
            goto L16
        L14:
            throw new d.k();
        L16:
            if (r14.contains(j.f20791c) == false) goto L18;
            this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.e(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.f(), CharSequence.class, "com.obric.aiagent.plugin"));
        L18:
            int r2 = 0;
            if (r14.contains(j.f20792d) == false) goto L28;
            View r1 = this.w;
            if (h.a(this.f20788a) == false) goto L23;
            int r4 = 0;
        L24:
            r1.setVisibility(r4);
            if (h.a(this.f20788a) == false) goto L28;
            this.y.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.h(), CharSequence.class, "com.obric.aiagent.plugin"));
            ch.f20743a.a(this.x, this.y, r12.g(), 7.0f);
            goto L28
        L23:
            r4 = 8;
        L28:
            if (r14.contains(j.f20793e) == false) goto L35;
            View r15 = this.A;
            if (r12.j() == true) goto L33;
            r2 = 8;
        L33:
            r15.setVisibility(r2);
            this.z.setCheckedNoAnim(r12.i());
            this.z.setEnabled(!r12.j());
            return;
        }

        private final com.obric.aiagent.skill.manager.api.e a() {
            int r0 = j();
            if (r0 != (-1)) goto L6;
            return null;
        L6:
            return h.a(this.f20788a, r0).a();
        }
    }

    public static final /* synthetic */ m a(h r1, int r2) {
        return (m) ZeusTransformUtils.preCheckCast(r1.c(r2), m.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ boolean a(h r0) {
        return r0.f;
    }

    public static final /* synthetic */ d.h.a.b b(h r0) {
        return r0.f20785c;
    }

    public static final /* synthetic */ d.h.a.a c(h r0) {
        return r0.f20787e;
    }

    public static final /* synthetic */ d.h.a.b d(h r0) {
        return r0.f20786d;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.v r3, int r4, List r5) {
        List<Object> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"), r4, r6);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ h(d.h.a.b r4, d.h.a.b r5, d.h.a.a r6, boolean r7, f r8, int r9, d.h.b.h r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r9 & 8) == 0) goto L5;
        r7 = true;
    L5:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L8;
        r8 = f.f20776a;
    L8:
        this(r11, r12, r0, r1, r8);
    }

    public h(d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, d.x> r4, d.h.a.b<? super com.obric.aiagent.skill.manager.api.e, d.x> r5, d.h.a.a<d.x> r6, boolean r7, f r8) {
        d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a<d.x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "onSkillClick");
        d.h.b.o.e(r10, "onToggleRequested");
        d.h.b.o.e(r11, "onSecurityBlocked");
        d.h.b.o.e(r8, "iconMode");
        super((com.obric.oui.orecyclerview.widget.j.e) ZeusTransformUtils.preCheckCast(new i(), com.obric.oui.orecyclerview.widget.j.e.class, "com.obric.aiagent.plugin"));
        this.f20785c = r9;
        this.f20786d = r10;
        this.f20787e = r11;
        this.f = r7;
        this.g = r8;
        this.h = d.a.p.b();
    }

    public final void a(List<com.obric.aiagent.skill.manager.api.e> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "nextItems");
        this.h = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
        c();
    }

    public final void a(String r4) {
        String r0 = null;
        CharSequence r1 = null;
        r0 = null;
        if (r4 == null) goto L12;
        String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r5 == null) goto L12;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r6) == true) goto L10;
        r1 = r6;
    L10:
        r0 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L12:
        if (d.h.b.o.a(this.i, r0) == false) goto L14;
        return;
    L14:
        this.i = r0;
        c();
    }

    public final void b() {
        if (a() != 0) goto L5;
        return;
    L5:
        a(0, a(), new l(d.a.ax.a(j.f20793e)));
    }

    private final void c() {
        int r0 = this.h.size();
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.h, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r1.iterator();
        int r3 = 0;
    L4:
        if (r9.hasNext() == false) goto L9;
        Object r2 = r9.next();
        int r10 = r3 + 1;
        if (r3 >= 0) goto L8;
        d.a.p.c();
    L8:
        r8.add(m.f20797a.a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r3, r0, this.i, this.g));
        r3 = r10;
        goto L4
    L9:
        super.b((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"));
    }

    public b a(ViewGroup r5, int r6) {
        d.h.b.o.e(r5, "parent");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.item_skill_my, "layout", "item_skill_my"), r5, false, "com.obric.aiagent.plugin");
        d.h.b.o.a(r7);
        return new b(this, r7);
    }

    public void a(b r2, int r3) {
        d.h.b.o.e(r2, "holder");
        m r1 = c(r3);
        d.h.b.o.c(r1, "getItem(...)");
        r2.a((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.aiagent.plugin"), j);
    }

    public void a(b r5, int r6, List<Object> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "holder");
        d.h.b.o.e(r8, "payloads");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Object r2 = r10.next();
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        d.a.p.a(r1, (Iterable) ZeusTransformUtils.preCheckCast(((l) ZeusTransformUtils.preCheckCast(r12.next(), l.class, "com.obric.aiagent.plugin")).a(), Iterable.class, "com.obric.aiagent.plugin"));
        goto L10
    L12:
        Set<? extends j> r13 = (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.aiagent.plugin");
        if (r13.isEmpty() == false) goto L15;
        a(r5, r6);
        return;
    L15:
        m r4 = c(r6);
        d.h.b.o.c(r4, "getItem(...)");
        r5.a((m) ZeusTransformUtils.preCheckCast(r4, m.class, "com.obric.aiagent.plugin"), r13);
    }

    static {
        f20784a = new a(null);
        j = d.a.i.i(j.values());
    }
}
