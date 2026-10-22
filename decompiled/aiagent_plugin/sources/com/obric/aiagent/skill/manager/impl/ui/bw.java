package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
final class bw extends com.obric.oui.orecyclerview.widget.p<by, RecyclerView.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20688a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final cb f20689c;

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    private final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bw f20690a;
        private final View s;
        private final SimpleDraweeView t;
        private final TextView u;
        private final TextView v;
        private final View w;

        public static /* synthetic */ void lambda$bNJxRidWzNNoc_nmsDp1_T0YR_A(bw r0, com.obric.aiagent.skill.manager.impl.aj r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$fdvkJPZaniPsE9MKmterBzbRIqI(bw r0, com.obric.aiagent.skill.manager.impl.aj r1, View r2) {
            b(r0, r1, r2);
        }

        public a(bw r5, View r6) {
            d.h.b.o.e(r6, "itemView");
            this.f20690a = r5;
            super(r6);
            View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_shop_banner_content, DbHelper.COL_ID, "skill_shop_banner_content"));
            d.h.b.o.c(r7, "findViewById(...)");
            this.s = r7;
            View r8 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_shop_banner_background, DbHelper.COL_ID, "skill_shop_banner_background"));
            d.h.b.o.c(r8, "findViewById(...)");
            this.t = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r8, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r9 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_shop_banner_title, DbHelper.COL_ID, "skill_shop_banner_title"));
            d.h.b.o.c(r9, "findViewById(...)");
            this.u = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.aiagent.plugin");
            View r10 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_shop_banner_subtitle, DbHelper.COL_ID, "skill_shop_banner_subtitle"));
            d.h.b.o.c(r10, "findViewById(...)");
            this.v = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
            View r11 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.skill_shop_banner_button, DbHelper.COL_ID, "skill_shop_banner_button"));
            d.h.b.o.c(r11, "findViewById(...)");
            this.w = r11;
        }

        public final void a(com.obric.aiagent.skill.manager.impl.aj r11) {
            if (r11 != null) goto L6;
            s.a(s.f20812a, this.t, null, 20.0f, false, "banner image", 8, null);
            this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
            this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.setVisibility(8);
            a();
            this.f35660b.setVisibility(0);
            return;
        L6:
            this.f35660b.setVisibility(0);
            TextView r2 = this.u;
            CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r3) == false) goto L9;
            r3 = r11.d();
        L9:
            r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
            this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11.b(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.s.setVisibility(0);
            b(r11);
            s.a(s.f20812a, this.t, r11.c(), 20.0f, false, "banner image", 8, null);
        }

        private final void b(final com.obric.aiagent.skill.manager.impl.aj r5) {
            this.f35660b.setClickable(true);
            View r0 = this.f35660b;
            final bw r2 = this.f20690a;
            r0.setOnClickListener(new $$Lambda$bw$a$bNJxRidWzNNoc_nmsDp1_T0YR_A(r2, r5));
            this.w.setClickable(true);
            View r1 = this.w;
            final bw r4 = this.f20690a;
            r1.setOnClickListener(new $$Lambda$bw$a$fdvkJPZaniPsE9MKmterBzbRIqI(r4, r5));
        }

        private static final void a(bw r0, com.obric.aiagent.skill.manager.impl.aj r1, View r2) {
            bw.a(r0).a(r1.e());
        }

        private static final void b(bw r0, com.obric.aiagent.skill.manager.impl.aj r1, View r2) {
            bw.a(r0).a(r1.e());
        }

        private final void a() {
            this.f35660b.setOnClickListener(null);
            this.f35660b.setClickable(false);
            this.w.setOnClickListener(null);
            this.w.setClickable(false);
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    private final class c extends RecyclerView.v {
        private final ODownloadProgressView A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bw f20691a;
        private final OCardListItem s;
        private final SimpleDraweeView t;
        private final TextView u;
        private final TextView v;
        private final SimpleDraweeView w;
        private final TextView x;
        private final View y;
        private final OButton z;

        /* JADX INFO: compiled from: SkillShopPageFragment.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20692a = null;

            static {
                int[] r0 = new int[bv.values().length];
                r0[bv.f20683a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[bv.f20686d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[bv.f20687e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[bv.f20684b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[bv.f20685c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f20692a = r0;
            }
        }

        public static /* synthetic */ void lambda$1SOi3PweYbn2_hrU3bUZHgumukM(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$QSAeIkgaYpFd6pscKsrNH7TW5lw(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            d(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$VjSojXwqTJuGwWcVJ69SlG1PwY4(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            c(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$y2dqq4Fbvq5p5fTjM3nR2F3AVWI(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            b(r0, r1, r2);
        }

        public c(bw r6, View r7) {
            d.h.b.o.e(r7, "itemView");
            this.f20691a = r6;
            super(r7);
            OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r7, OCardListItem.class, "com.obric.aiagent.plugin");
            this.s = r8;
            View r1 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_icon, DbHelper.COL_ID, "skill_icon"));
            d.h.b.o.c(r1, "findViewById(...)");
            this.t = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r1, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r2 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_name, DbHelper.COL_ID, "skill_name"));
            d.h.b.o.c(r2, "findViewById(...)");
            this.u = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
            View r3 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_description, DbHelper.COL_ID, "skill_description"));
            d.h.b.o.c(r3, "findViewById(...)");
            this.v = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
            View r4 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source_avatar, DbHelper.COL_ID, "skill_source_avatar"));
            d.h.b.o.c(r4, "findViewById(...)");
            this.w = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r4, SimpleDraweeView.class, "com.obric.aiagent.plugin");
            View r5 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source, DbHelper.COL_ID, "skill_source"));
            d.h.b.o.c(r5, "findViewById(...)");
            this.x = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
            View r9 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action_slot, DbHelper.COL_ID, "skill_action_slot"));
            d.h.b.o.c(r9, "findViewById(...)");
            this.y = r9;
            View r10 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action, DbHelper.COL_ID, "skill_action"));
            d.h.b.o.c(r10, "findViewById(...)");
            this.z = (OButton) ZeusTransformUtils.preCheckCast(r10, OButton.class, "com.obric.aiagent.plugin");
            View r11 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action_progress, DbHelper.COL_ID, "skill_action_progress"));
            d.h.b.o.c(r11, "findViewById(...)");
            ODownloadProgressView r12 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r11, ODownloadProgressView.class, "com.obric.aiagent.plugin");
            this.A = r12;
            q.a(r8);
            Drawable r13 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.oic_checkmark_circle, "drawable", "oic_checkmark_circle"));
            if (r13 == null) goto L8;
            Drawable r14 = r13.mutate();
            if (r14 == null) goto L9;
            r14.setTint(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_green_6, "color", "oui_functional_green_6")));
            r12.setSucceedDrawable(r14);
            return;
        L9:
            return;
        }

        public final void a(by.b r13) {
            d.h.b.o.e(r13, "row");
            final com.obric.aiagent.skill.manager.api.e r0 = r13.a();
            bw.a(this.f20691a, this.s, r13.c());
            s.a(s.f20812a, this.t, r0.f(), 14.0f, false, null, 16, null);
            ch.f20743a.a(this.w, this.x, com.obric.aiagent.skill.manager.impl.az.f(r0), 7.0f);
            this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.d(r0), CharSequence.class, "com.obric.aiagent.plugin"));
            this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13.b(), CharSequence.class, "com.obric.aiagent.plugin"));
            this.x.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.g(r0), CharSequence.class, "com.obric.aiagent.plugin"));
            b(r13);
            OCardListItem r14 = this.s;
            final bw r12 = this.f20691a;
            r14.setOnContentClickListener(new $$Lambda$bw$c$1SOi3PweYbn2_hrU3bUZHgumukM(r12, r0));
        }

        private static final void a(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            bw.a(r0).c(r1);
        }

        public final void b(by.b r6) {
            d.h.b.o.e(r6, "row");
            final com.obric.aiagent.skill.manager.api.e r0 = r6.a();
            this.A.setVisibility(8);
            this.z.setVisibility(8);
            this.y.setEnabled(true);
            this.y.setClickable(false);
            this.y.setOnClickListener(null);
            this.z.setEnabled(true);
            this.z.setClickable(false);
            this.z.setOnClickListener(null);
            bv r7 = r6.d();
            int r8 = a.f20692a[r7.ordinal()];
            if (r8 != 1) goto L5;
            this.z.setVisibility(0);
            bj.a(this.z);
            this.z.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_add, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_add"));
            OButton r9 = this.z;
            final bw r5 = this.f20691a;
            r9.setOnClickListener(new $$Lambda$bw$c$y2dqq4Fbvq5p5fTjM3nR2F3AVWI(r5, r0));
            return;
        L5:
            if (r8 != 2) goto L7;
            this.z.setVisibility(0);
            bj.b(this.z);
            this.z.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_use"));
            OButton r10 = this.z;
            final bw r11 = this.f20691a;
            r10.setOnClickListener(new $$Lambda$bw$c$VjSojXwqTJuGwWcVJ69SlG1PwY4(r11, r0));
            return;
        L7:
            if (r8 != 3) goto L9;
            this.z.setVisibility(0);
            bj.b(this.z);
            this.z.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_use"));
            this.z.setEnabled(false);
            this.z.setClickable(false);
            View r12 = this.y;
            final bw r13 = this.f20691a;
            r12.setOnClickListener(new $$Lambda$bw$c$QSAeIkgaYpFd6pscKsrNH7TW5lw(r13, r0));
            return;
        L9:
            if (r8 != 4) goto L11;
            this.A.setVisibility(0);
            this.A.setCurrentState(0);
            return;
        L11:
            if (r8 != 5) goto L14;
            this.A.setVisibility(0);
            this.A.setCurrentState(4);
            return;
        L14:
            throw new d.k();
        }

        private static final void b(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            bw.a(r0).a(r1);
        }

        private static final void c(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            bw.a(r0).b(r1);
        }

        private static final void d(bw r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
            bw.a(r0).b(r1);
        }
    }

    /* JADX INFO: compiled from: SkillShopPageFragment.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20693a = null;

        static {
            int[] r0 = new int[bt.values().length];
            r0[bt.f20669a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[bt.f20670b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[bt.f20671c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[bt.f20672d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f20693a = r0;
        }
    }

    static {
        f20688a = new b(null);
    }

    public static final /* synthetic */ cb a(bw r0) {
        return r0.f20689c;
    }

    public static final /* synthetic */ void a(bw r0, OCardListItem r1, bt r2) {
        r0.a(r1, r2);
    }

    public bw(cb r4) {
        cb r5 = (cb) ZeusTransformUtils.wrapperContextForParams(r4, cb.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "actionHandler");
        super((com.obric.oui.orecyclerview.widget.j.e) ZeusTransformUtils.preCheckCast(new bz(), com.obric.oui.orecyclerview.widget.j.e.class, "com.obric.aiagent.plugin"));
        this.f20689c = r5;
    }

    public final void a(bu r10, List<com.obric.aiagent.skill.manager.impl.am> r11, bs r12, Map<String, com.obric.aiagent.skill.manager.api.e> r13, Set<String> r14, Set<String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        Map r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        Set r18 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        Set r19 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "channel");
        d.h.b.o.e(r16, "items");
        d.h.b.o.e(r12, "bannerState");
        d.h.b.o.e(r17, "installedSkills");
        d.h.b.o.e(r18, "processingSkillIds");
        d.h.b.o.e(r19, "completedSkillIds");
        ArrayList r0 = new ArrayList(r16.size() + 1);
        if (r10.f() == true) goto L5;
    L15:
        int r110 = 0;
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r111.hasNext() == false) goto L22;
        Object r2 = r111.next();
        int r3 = r110 + 1;
        if (r110 >= 0) goto L21;
        d.a.p.c();
    L21:
        com.obric.aiagent.skill.manager.impl.am r4 = (com.obric.aiagent.skill.manager.impl.am) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.skill.manager.impl.am.class, "com.obric.aiagent.plugin");
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new by.b(r4.a(), r4.b(), cc.a(r110, r16.size()), cc.a(r4.a().a(), r17, r18, r19)));
        r110 = r3;
        goto L17
    L22:
        b((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        if (d.h.b.o.a(r12, bs.b.f20667a) == false) goto L7;
    L14:
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new by.a(null));
        goto L15
    L7:
        if (d.h.b.o.a(r12, bs.c.f20668a) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r12, bs.a.class) == false) goto L13;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(new by.a(((bs.a) ZeusTransformUtils.preCheckCast(r12, bs.a.class, "com.obric.aiagent.plugin")).a()));
        goto L15
    L13:
        throw new d.k();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public int a(int r2) {
        by r1 = (by) ZeusTransformUtils.preCheckCast(c(r2), by.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, by.a.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, by.b.class) == false) goto L10;
        return 1;
    L10:
        throw new d.k();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public RecyclerView.v b(ViewGroup r8, int r9) {
        d.h.b.o.e(r8, "parent");
        LayoutInflater r0 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r9 != 0) goto L5;
        View r10 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_shop_banner, "layout", "item_skill_shop_banner"), r8, false, "com.obric.aiagent.plugin");
        d.h.b.o.c(r10, "inflate(...)");
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new a(this, r10), RecyclerView.v.class, "com.obric.aiagent.plugin");
    L5:
        View r11 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_discovery, "layout", "item_skill_discovery"), r8, false, "com.obric.aiagent.plugin");
        d.h.b.o.c(r11, "inflate(...)");
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(new c(this, r11), RecyclerView.v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView.v r2, int r3) {
        d.h.b.o.e(r2, "holder");
        by r1 = (by) ZeusTransformUtils.preCheckCast(c(r3), by.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, by.a.class) == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin")).a(((by.a) ZeusTransformUtils.preCheckCast(r1, by.a.class, "com.obric.aiagent.plugin")).a());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, by.b.class) == false) goto L10;
        ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin")).a((by.b) ZeusTransformUtils.preCheckCast(r1, by.b.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        throw new d.k();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
    public void a(RecyclerView.v r7, int r8, List<Object> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "holder");
        d.h.b.o.e(r10, "payloads");
        by r0 = (by) ZeusTransformUtils.preCheckCast(c(r8), by.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L5;
    L21:
        a(r7, r8);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, by.b.class) == false) goto L21;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L9;
    L11:
        Iterator r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L10;
        if (r12.next() != bx.f20694a) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L13;
    L19:
        if (r3 == false) goto L21;
        ((c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.aiagent.plugin")).b((by.b) ZeusTransformUtils.preCheckCast(r0, by.b.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        r2 = false;
    L10:
        r3 = false;
        goto L19
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
        goto L10
    }

    private final void a(OCardListItem r3, bt r4) {
        int r2 = d.f20693a[r4.ordinal()];
        if (r2 != 1) goto L5;
        q.a(r3, 0, 1);
        return;
    L5:
        if (r2 != 2) goto L7;
        q.a(r3, 0, 2);
        return;
    L7:
        if (r2 != 3) goto L9;
        q.a(r3, 1, 3);
        return;
    L9:
        if (r2 != 4) goto L12;
        q.a(r3, 1, 2);
        return;
    L12:
        throw new d.k();
    }
}
