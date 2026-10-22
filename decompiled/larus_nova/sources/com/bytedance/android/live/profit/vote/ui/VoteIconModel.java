package com.bytedance.android.live.profit.vote.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.arch.mvvm.StateBuffer;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.model.VoteConfig;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class VoteIconModel extends com.bytedance.android.live.revenue.common.a<com.bytedance.android.live.profit.vote.model.b> implements o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f89276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f89277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f89278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VoteViewModel f89279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VotePanelHandler f89280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c01.a f89281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final yz0.k f89282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.profit.vote.f f89283m;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f89284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f89285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f89286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HSImageView f89287d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HSImageView f89288e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f89289f;

        public b(VoteIconModel r100) {
            View r101 = r100.inflateEntryView(R.layout.ttlive_view_vote_sti_entry).f157513a;
            if (r101 == null) goto L7;
            ViewGroup r102 = (ViewGroup) r101;
            this.f89284a = r102;
            this.f89285b = (TextView) r102.findViewById(R.id.tv_left_text);
            this.f89286c = (TextView) r102.findViewById(R.id.tv_right_text);
            this.f89287d = (HSImageView) r102.findViewById(R.id.iv_left_icon);
            this.f89288e = (HSImageView) r102.findViewById(R.id.iv_right_icon);
            this.f89289f = (TextView) r102.findViewById(R.id.tv_count_down);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteIconModel f89290a;

        public final void a() {
            VoteIconModel r100 = this.f89290a;
            b r101 = r100.f89277g;
            d r102 = r100.f89276f;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.f89307q == true) goto L10;
            r102.f89307q = true;
            AnimatorSet r103 = new AnimatorSet();
            r103.playTogether(new Animator[]{ObjectAnimator.ofFloat(r102.f89293c, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f}), ObjectAnimator.ofFloat(r102.f89294d, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f})});
            r103.setDuration(300);
            r103.setInterpolator(new DecelerateInterpolator());
            r103.start();
            return;
        }

        public c(VoteIconModel r100) {
            this.f89290a = r100;
        }

        public final void b(boolean r100) {
            VoteIconModel r101 = this.f89290a;
            b r102 = r101.f89277g;
            d r103 = r101.f89276f;
            if (r103 == null) goto L8;
            if (r100 == false) goto L6;
            r103.f89299i.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse("asset://com.ss.android.ies.live.sdk/vote_time.webp")).setControllerListener(com.bytedance.android.live.profit.util.c.a()).build());
            r103.f89295e.setVisibility(8);
            r103.a().setText("");
            return;
        L6:
            r103.f89299i.setController(null);
            r103.f89295e.setVisibility(0);
            return;
        }

        public final void c(com.bytedance.android.live.profit.vote.b r100) {
            Intrinsics.checkNotNullParameter(r100, "vote");
            b r101 = this.f89290a.f89277g;
            if (r101 == null) goto L15;
            Intrinsics.checkNotNullParameter(r100, "vote");
            List r102 = CollectionsKt.take((Iterable) r100.getItems().f267520d, 2);
            if (r102.size() != 2) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L11;
            r102 = null;
        L11:
            if (r102 == null) goto L15;
            com.bytedance.android.live.profit.vote.g r104 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r102, 0);
            com.bytedance.android.live.profit.vote.g r105 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r102, 1);
            r101.f89285b.setText(VoteUtilsKt.f(r104));
            r101.f89286c.setText(VoteUtilsKt.f(r105));
            ImageUtil.loadImage(r101.f89287d, r104.f89203e, 0);
            ImageUtil.loadImage(r101.f89288e, r105.f89203e, 0);
            goto L15
        L7:
            r103 = false;
        L15:
            if (this.f89290a.f89276f == null) goto L18;
            Intrinsics.checkNotNullParameter(r100, "vote");
            return;
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xr2.b f89291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Guideline f89292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f89293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f89294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Group f89295e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f89296f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f89297g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Guideline f89298h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final HSImageView f89299i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Guideline f89300j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Group f89301k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final HSImageView f89302l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View f89303m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Group f89304n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final HSImageView f89305o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final View f89306p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f89307q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final CompositeDisposable f89308r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f89309s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f89310t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ VoteIconModel f89311u;

        public final TextView a() {
            if (this.f89310t == false) goto L6;
            return this.f89296f;
        L6:
            return this.f89297g;
        }

        public d(VoteIconModel r100) {
            this.f89311u = r100;
            xr2.b r101 = (xr2.b) r100.createIconTemplate(xr2.b.class);
            this.f89291a = r101;
            this.f89308r = new CompositeDisposable();
            this.f89309s = 0.5f;
            this.f89310t = true;
            View r102 = r101.inflateContentView(R.layout.ttlive_view_vote_sti);
            this.f89292b = (Guideline) r102.findViewById(R.id.vote_bar_divider);
            this.f89293c = r102.findViewById(R.id.left_bar);
            this.f89294d = r102.findViewById(R.id.right_bar);
            Group r103 = (Group) r102.findViewById(R.id.icon_group);
            this.f89295e = r103;
            this.f89296f = (TextView) r102.findViewById(R.id.tv_vote_result_1);
            this.f89297g = (TextView) r102.findViewById(R.id.tv_vote_result_2);
            this.f89298h = (Guideline) r102.findViewById(R.id.vote_text_guide);
            r103.setReferencedIds(new int[]{R.id.tv_vote_result_1, R.id.tv_vote_result_2});
            this.f89299i = (HSImageView) r102.findViewById(R.id.iv_count_down);
            this.f89300j = (Guideline) r102.findViewById(R.id.vote_win_anim_guide);
            Group r104 = (Group) r102.findViewById(R.id.left_win_anim_group);
            this.f89301k = r104;
            this.f89302l = (HSImageView) r102.findViewById(R.id.iv_left_particle);
            this.f89303m = r102.findViewById(R.id.left_shine);
            r104.setReferencedIds(new int[]{R.id.left_shine, R.id.iv_left_particle});
            Group r105 = (Group) r102.findViewById(R.id.right_win_anim_group);
            this.f89304n = r105;
            this.f89305o = (HSImageView) r102.findViewById(R.id.iv_right_particle);
            this.f89306p = r102.findViewById(R.id.right_shine);
            r105.setReferencedIds(new int[]{R.id.right_shine, R.id.iv_right_particle});
            Unit r106 = Unit.INSTANCE;
            r101.setContentView(r102);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteIconModel f89312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.profit.vote.b f89313b;

        public e(VoteIconModel r100, com.bytedance.android.live.profit.vote.b r101) {
            this.f89312a = r100;
            this.f89313b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            this.f89312a.j(this.f89313b);
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        int r100 = StateBuffer.f64755d;
        StateBuffer r101 = StateBuffer.Companion.a(new VoteIconModel$onCreate$stateBuffer$1(this));
        final VoteIconModel$onCreate$1 r102 = new VoteIconModel$onCreate$1(this);
        bindModel(r101.subscribe(new f(r102)));
        PropertyOwnersKt.c(this.f89279i.f89332e).subscribe(r101);
    }

    public final void i() {
        if (this.f89282l.isAnchor() == false) goto L5;
        n r100 = new n();
        m r101 = new m();
        r101.b(LogCommon.ROOM);
        r101.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r102 = r100.f516448b;
        ArrayList r103 = (ArrayList) r102;
        r103.addAll(r101.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r104 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r105 = com.bytedance.android.scope.m.b(r104).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r105);
        ((mz0.i) ((f80.a) r105)).w3("livesdk_anchorcheck_click", r100.f516447a, r100.f516448b);
    L6:
        VotePanelHandler r106 = this.f89280j;
        int r107 = VotePanelHandler.f89317f;
        r106.a(null);
        return;
    L5:
        Map<? extends String, ? extends String> r108 = MapsKt.mapOf(TuplesKt.to("user_id", ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString()));
        n r109 = new n();
        Map<String, String> r110 = r109.f516447a;
        Intrinsics.checkNotNullParameter(r110, "map");
        Intrinsics.checkNotNullParameter(r108, "map");
        r110.putAll(r108);
        m r111 = new m();
        r111.b(LogCommon.ROOM);
        r111.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r112 = r109.f516448b;
        ArrayList r113 = (ArrayList) r112;
        r113.addAll(r111.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r114 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r115 = com.bytedance.android.scope.m.b(r114).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r115);
        ((mz0.i) ((f80.a) r115)).w3("livesdk_audiencecheck_click", r109.f516447a, r109.f516448b);
        goto L6
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f89281k.D9(VoteIconModel.class, new AnonymousClass1(this));
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void onClick() {
        i();
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final xr2.h getViewForState(Object r100) {
        com.bytedance.android.live.profit.vote.model.b r101 = (com.bytedance.android.live.profit.vote.model.b) r100;
        Intrinsics.checkNotNullParameter(r101, "state");
        if (Intrinsics.areEqual(r101, com.bytedance.android.live.profit.vote.model.b.c.f89239a) == false) goto L6;
        this.f89276f = null;
        return null;
    L6:
        if (this.f89276f != null) goto L8;
        this.f89276f = new d(this);
    L8:
        d r102 = this.f89276f;
        if (r102 != null) goto L11;
        return null;
    L11:
        return r102.f89291a;
    }

    public final void h(com.bytedance.android.live.profit.vote.b r100) {
        bindState(PropertyOwnersKt.c(r100.getItems()).subscribe(new e(this, r100)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(com.bytedance.android.live.profit.vote.b r110) {
        Object r100 = r110.getItems().f267520d;
        if (((List) r100).size() < 2) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        List r102 = (List) r100;
        if (r102 == null) goto L134;
        com.bytedance.android.live.profit.vote.g r103 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r102, 0);
        com.bytedance.android.live.profit.vote.g r104 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r102, 1);
        c r105 = this.f89278h;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r110, "vote");
        Intrinsics.checkNotNullParameter(r103, "left");
        Intrinsics.checkNotNullParameter(r104, "right");
        if (r105.f89290a.f89277g == null) goto L15;
        Intrinsics.checkNotNullParameter(r110, "vote");
        Intrinsics.checkNotNullParameter(r103, "left");
        Intrinsics.checkNotNullParameter(r104, "right");
    L15:
        d r106 = r105.f89290a.f89276f;
        if (r106 == null) goto L140;
        Intrinsics.checkNotNullParameter(r110, "vote");
        Intrinsics.checkNotNullParameter(r103, "left");
        Intrinsics.checkNotNullParameter(r104, "right");
        r106.f89308r.clear();
        long r111 = r103.f89199a;
        long r107 = r104.f89199a;
        if (r111 != r107) goto L21;
        float r108 = 0.5f;
    L27:
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{r106.f89309s, RangesKt.coerceIn(r108, 0.2f, 0.8f)});
        r109.setDuration(200);
        r109.addUpdateListener(new com.bytedance.android.live.profit.vote.ui.a(r106));
        CompositeDisposable r112 = r106.f89308r;
        Intrinsics.checkNotNullParameter(r109, "$this$bind");
        Intrinsics.checkNotNullParameter(r112, "cd");
        RxUtilKt.c(RxUtilKt.a(r109, false), r112);
        r109.start();
        if ((r106.f89311u.getCurrentState() instanceof com.bytedance.android.live.profit.vote.model.b.e) == false) goto L30;
        String r113 = r106.f89311u.getContext().getString(R.string.ttlive_vote_result_pending);
    L127:
        if ((!Intrinsics.areEqual(r113, r106.a().getText().toString())) == false) goto L141;
        r106.f89310t = !r106.f89310t;
        r106.a().setText(r113);
        AnimatorSet r114 = new AnimatorSet();
        if (r106.f89310t == true) goto L131;
        TextView r115 = r106.f89296f;
    L132:
        ObjectAnimator r116 = ObjectAnimator.ofFloat(r115, "alpha", new float[]{0.0f}).setDuration(67);
        ObjectAnimator r117 = ObjectAnimator.ofFloat(r106.a(), "alpha", new float[]{1.0f}).setDuration(67);
        r117.setStartDelay(33);
        r114.playTogether(new Animator[]{r116, r117});
        CompositeDisposable r118 = r106.f89308r;
        Intrinsics.checkNotNullParameter(r114, "$this$bind");
        Intrinsics.checkNotNullParameter(r118, "cd");
        RxUtilKt.c(RxUtilKt.a(r114, false), r118);
        r114.start();
        return;
    L131:
        r115 = r106.f89297g;
        goto L132
    L141:
        return;
    L30:
        int r119 = com.bytedance.android.live.profit.vote.ui.e.f89347a;
        Context r120 = r106.f89311u.getContext();
        Intrinsics.checkNotNullParameter(r120, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "vote");
        Object r121 = r110.getItems().f267520d;
        if (((List) r121).size() < 2) goto L33;
        boolean r122 = true;
    L34:
        if (r122 == true) goto L37;
        r121 = null;
    L37:
        List r123 = (List) r121;
        if (r123 != null) goto L40;
        r113 = "";
    L109:
        int r124 = r113.codePointCount(0, r113.length());
        if (r124 != 4) goto L127;
        Sequence r125 = SequencesKt.sequence(new VoteTextMapper$getComposedVoteText$seq$1(r124, r113, null));
        Iterator r126 = r125.iterator();
    L113:
        if (r126.hasNext() == false) goto L123;
        int r127 = ((Number) r126.next()).intValue();
        if (19968 <= r127) goto L118;
    L120:
        boolean r128 = false;
    L121:
        if (r128 == true) goto L113;
        boolean r129 = false;
    L124:
        if (r129 == false) goto L127;
        int[] r130 = CollectionsKt.toIntArray(SequencesKt.toList(SequencesKt.plus(SequencesKt.plus(SequencesKt.take(r125, 2), 10), SequencesKt.drop(r125, 2))));
        r113 = new String(r130, 0, r130.length);
        goto L127
    L118:
        if (40869 < r127) goto L120;
        r128 = true;
        goto L121
    L123:
        r129 = true;
        goto L124
    L40:
        com.bytedance.android.live.profit.vote.g r131 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r123, 0);
        com.bytedance.android.live.profit.vote.g r132 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r123, 1);
        if (((VoteState) r110.getState().f267520d) != VoteState.FINISHED) goto L74;
        if (VoteUtilsKt.h(r110) == true) goto L45;
        int r133 = com.bytedance.android.live.profit.vote.ui.d.f89342c[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r133 == 1) goto L72;
        if (r133 == 2) goto L71;
        if (r133 != 3) goto L70;
        r113 = r120.getString(R.string.ttlive_vote_result_text_draw);
        goto L109
    L70:
        throw new NoWhenBranchMatchedException();
    L71:
        r113 = VoteUtilsKt.f(r132);
        goto L109
    L72:
        r113 = VoteUtilsKt.f(r131);
        goto L109
    L45:
        if (VoteConfig.c() != VoteConfig.Plan.C) goto L55;
        int r134 = com.bytedance.android.live.profit.vote.ui.d.f89340a[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r134 == 1) goto L54;
        if (r134 == 2) goto L53;
        if (r134 != 3) goto L52;
        r113 = r120.getString(R.string.ttlive_vote_result_text_draw);
        goto L109
    L52:
        throw new NoWhenBranchMatchedException();
    L53:
        r113 = r120.getString(R.string.ttlive_vote_result_text_plan_c_right);
        goto L109
    L54:
        r113 = r120.getString(R.string.ttlive_vote_result_text_plan_c_left);
        goto L109
    L55:
        int r135 = com.bytedance.android.live.profit.vote.ui.d.f89341b[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r135 == 1) goto L63;
        if (r135 == 2) goto L62;
        if (r135 != 3) goto L61;
        r113 = r120.getString(R.string.ttlive_vote_result_text_draw);
        goto L109
    L61:
        throw new NoWhenBranchMatchedException();
    L62:
        r113 = r120.getString(R.string.ttlive_vote_result_text_plan_ab_right);
        goto L109
    L63:
        r113 = r120.getString(R.string.ttlive_vote_result_text_plan_ab_left);
        goto L109
    L74:
        if (VoteUtilsKt.h(r110) == false) goto L100;
        int r136 = com.bytedance.android.live.profit.vote.ui.d.f89345f[VoteConfig.c().ordinal()];
        if (r136 == 1) goto L91;
        if (r136 == 2) goto L82;
        if (r136 != 3) goto L81;
        r113 = r120.getString(R.string.ttlive_vote_text_plan_c);
        goto L109
    L81:
        throw new NoWhenBranchMatchedException();
    L82:
        int r137 = com.bytedance.android.live.profit.vote.ui.d.f89344e[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r137 == 1) goto L90;
        if (r137 == 2) goto L89;
        if (r137 != 3) goto L88;
        r113 = r120.getString(R.string.ttlive_vote_text_draw);
        goto L109
    L88:
        throw new NoWhenBranchMatchedException();
    L89:
        r113 = r120.getString(R.string.ttlive_vote_text_plan_b_right);
        goto L109
    L90:
        r113 = r120.getString(R.string.ttlive_vote_text_plan_b_left);
        goto L109
    L91:
        int r138 = com.bytedance.android.live.profit.vote.ui.d.f89343d[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r138 == 1) goto L99;
        if (r138 == 2) goto L98;
        if (r138 != 3) goto L97;
        r113 = r120.getString(R.string.ttlive_vote_text_draw);
        goto L109
    L97:
        throw new NoWhenBranchMatchedException();
    L98:
        r113 = r120.getString(R.string.ttlive_vote_text_plan_a_right);
        goto L109
    L99:
        r113 = r120.getString(R.string.ttlive_vote_text_plan_a_left);
        goto L109
    L100:
        int r139 = com.bytedance.android.live.profit.vote.ui.d.f89346g[VoteUtilsKt.a(r131, r132).ordinal()];
        if (r139 == 1) goto L108;
        if (r139 == 2) goto L107;
        if (r139 != 3) goto L106;
        r113 = r120.getString(R.string.ttlive_vote_text_draw);
        goto L109
    L106:
        throw new NoWhenBranchMatchedException();
    L107:
        r113 = VoteUtilsKt.f(r132);
        goto L109
    L108:
        r113 = VoteUtilsKt.f(r131);
        goto L109
    L33:
        r122 = false;
        goto L34
    L21:
        if (r111 > 0) goto L24;
        r108 = 0.0f;
        goto L27
    L24:
        if (r107 > 0) goto L26;
        r108 = 1.0f;
        goto L27
    L26:
        r108 = r111 / (r111 + r107);
        goto L27
    L140:
        return;
    L134:
        return;
    L5:
        r101 = false;
        goto L7
    }

    @Override // com.bytedance.android.live.revenue.common.a, com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void a(IRevIconModel.a r100, IRevIconModel.EntryEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "entryView");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != IRevIconModel.EntryEvent.End) goto L5;
    L6:
        this.f89278h.a();
        this.f89277g = null;
        return;
    L5:
        if (r101 == IRevIconModel.EntryEvent.Skip) goto L6;
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final IRevIconModel.a getEntryViewForState(Object r100, Object r101) {
        com.bytedance.android.live.profit.vote.model.b r102 = (com.bytedance.android.live.profit.vote.model.b) r100;
        com.bytedance.android.live.profit.vote.model.b r103 = (com.bytedance.android.live.profit.vote.model.b) r101;
        Intrinsics.checkNotNullParameter(r102, "state");
        if ((r102 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L12;
        if (r103 == null) goto L10;
        com.bytedance.android.live.profit.vote.b r104 = r103.a();
        if (r104 == null) goto L10;
        if (r104.getVoteId() == ((com.bytedance.android.live.profit.vote.model.b.d) r102).f89240a.getVoteId()) goto L12;
    L10:
        if (((com.bytedance.android.live.profit.vote.model.b.d) r102).f89240a.a() < 5000) goto L12;
        b r105 = new b(this);
        this.f89277g = r105;
        r105.f89284a.setOnClickListener(new com.bytedance.android.live.profit.vote.ui.c(this));
        return new IRevIconModel.a(r105.f89284a, 5000, 4);
    L12:
        this.f89277g = null;
        return null;
    }

    @Override // com.bytedance.android.livesdk.revenue.sti.IRevIconModel
    public final void c(Object r110, Object r111, xr2.h r210) {
        com.bytedance.android.live.profit.vote.model.b r100 = (com.bytedance.android.live.profit.vote.model.b) r110;
        com.bytedance.android.live.profit.vote.model.b r101 = (com.bytedance.android.live.profit.vote.model.b) r111;
        Intrinsics.checkNotNullParameter(r101, "curState");
        if (r100 == null) goto L7;
        com.bytedance.android.live.profit.vote.b r102 = r100.a();
        if (r102 == null) goto L7;
        Long r103 = Long.valueOf(r102.getVoteId());
    L8:
        com.bytedance.android.live.profit.vote.b r104 = r101.a();
        if (r104 == null) goto L11;
        Long r105 = Long.valueOf(r104.getVoteId());
    L12:
        String r106 = "";
        if ((!Intrinsics.areEqual(r103, r105)) == false) goto L18;
        d r107 = this.f89276f;
        if (r107 == null) goto L18;
        r107.f89292b.setGuidelinePercent(0.5f);
        r107.f89293c.setScaleY(0.0f);
        r107.f89294d.setScaleY(0.0f);
        r107.f89296f.setText("");
        r107.f89296f.setAlpha(0.0f);
        r107.f89297g.setText("");
        r107.f89297g.setAlpha(0.0f);
        r107.f89298h.setGuidelineBegin(MathKt.roundToInt(t6.a(r107.f89311u.getContext(), 13.0f)));
        r107.f89299i.setController(null);
        r107.f89300j.setGuidelinePercent(1.0f);
        r107.f89301k.setVisibility(8);
        r107.f89303m.setAlpha(0.0f);
        r107.f89302l.setController(null);
        VoteIconModel r108 = r107.f89311u;
        HSImageView r112 = r107.f89302l;
        r108.getClass();
        r112.setScaleX(0.0f);
        r112.setScaleY(0.0f);
        r107.f89302l.setAlpha(1.0f);
        r107.f89304n.setVisibility(8);
        r107.f89306p.setAlpha(0.0f);
        r107.f89305o.setController(null);
        VoteIconModel r109 = r107.f89311u;
        HSImageView r113 = r107.f89305o;
        r109.getClass();
        r113.setScaleX(0.0f);
        r113.setScaleY(0.0f);
        r107.f89305o.setAlpha(1.0f);
        r107.f89307q = false;
        r107.f89308r.clear();
        r107.f89309s = 0.5f;
        r107.f89310t = true;
    L18:
        if ((r101 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L22;
        com.bytedance.android.live.profit.vote.model.b.d r114 = (com.bytedance.android.live.profit.vote.model.b.d) r101;
        this.f89278h.c(r114.f89240a);
        h(r114.f89240a);
        bindState(r114.f89241b.subscribe(new com.bytedance.android.live.profit.vote.ui.b(this)));
        this.f89278h.b(false);
    L20:
        String r115 = null;
    L71:
        if (r100 != null) goto L73;
    L76:
        LinkedHashMap r116 = new LinkedHashMap();
        com.bytedance.android.live.profit.vote.b r117 = r101.a();
        if (r117 == null) goto L79;
        VoteUtilsKt.j(r116, r117);
    L79:
        com.bytedance.android.live.profit.vote.f r118 = this.f89283m;
        r118.c(r116);
        r118.a(r116);
        r118.d(r116);
        Intrinsics.checkNotNullParameter(r116, "$this$putToUserInfo");
        iq2.a r119 = VoteUtilsKt.e();
        if (r119 == null) goto L99;
        iq2.g r120 = ((iq2.f) r119).b();
        if (r120 == null) goto L90;
        iq2.c r121 = r120.a();
        if (r121 == null) goto L90;
        String r122 = r121.a();
        if (r122 == null) goto L90;
        r106 = r122;
    L90:
        r116.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r106);
        IBaseUser r123 = r118.f89197b.getRoom().getOwnerKt();
        if (r123 == null) goto L93;
        String r124 = r123.getIdString();
    L95:
        if (Intrinsics.areEqual(r124, r106) == false) goto L97;
        String r125 = "anchor";
    L98:
        r116.put("to_user_type", r125);
        goto L99
    L97:
        r125 = "user";
        goto L98
    L93:
        r124 = r115;
    L99:
        VoteUtilsKt.i(r116);
        n r126 = new n();
        Map<String, String> r127 = r126.f516447a;
        Intrinsics.checkNotNullParameter(r127, "map");
        Intrinsics.checkNotNullParameter(r116, "map");
        r127.putAll(r116);
        m r128 = new m();
        r128.b(LogCommon.ROOM);
        ((ArrayList) r126.f516448b).addAll(r128.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r129 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r130 = com.bytedance.android.scope.m.b(r129).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r130);
        ((mz0.i) ((f80.a) r130)).w3("livesdk_ksong_poll_icon_show", r126.f516447a, r126.f516448b);
        return;
    L73:
        if ((r100 instanceof com.bytedance.android.live.profit.vote.model.b.c) == true) goto L75;
        return;
    L75:
        if ((r101 instanceof com.bytedance.android.live.profit.vote.model.b.c) == false) goto L76;
        return;
    L22:
        if ((r101 instanceof com.bytedance.android.live.profit.vote.model.b.a) == false) goto L29;
        this.f89278h.a();
        com.bytedance.android.live.profit.vote.model.b.a r131 = (com.bytedance.android.live.profit.vote.model.b.a) r101;
        this.f89278h.c(r131.f89237a);
        h(r131.f89237a);
        this.f89278h.b(true);
        d r132 = this.f89276f;
        if (r132 == null) goto L20;
        xr2.b r133 = r132.f89291a;
        if (r133 == null) goto L20;
        r133.setLabel(null);
        goto L20
    L29:
        if ((r101 instanceof com.bytedance.android.live.profit.vote.model.b.e) == false) goto L41;
        this.f89278h.a();
        com.bytedance.android.live.profit.vote.model.b.e r134 = (com.bytedance.android.live.profit.vote.model.b.e) r101;
        this.f89278h.c(r134.f89242a);
        h(r134.f89242a);
        this.f89278h.b(false);
        d r135 = this.f89276f;
        if (r135 == null) goto L35;
        Guideline r136 = r135.f89298h;
        if (r136 == null) goto L35;
        r136.setGuidelinePercent(0.5f);
    L35:
        d r137 = this.f89276f;
        if (r137 == null) goto L20;
        xr2.b r138 = r137.f89291a;
        if (r138 == null) goto L20;
        r138.setLabel(null);
        goto L20
    L41:
        if ((r101 instanceof com.bytedance.android.live.profit.vote.model.b.C1370b) == false) goto L20;
        this.f89278h.a();
        com.bytedance.android.live.profit.vote.model.b.C1370b r139 = (com.bytedance.android.live.profit.vote.model.b.C1370b) r101;
        this.f89278h.c(r139.f89238a);
        j(r139.f89238a);
        this.f89278h.b(false);
        c r140 = this.f89278h;
        com.bytedance.android.live.profit.vote.b r141 = r139.f89238a;
        r140.getClass();
        Intrinsics.checkNotNullParameter(r141, "vote");
        if (r140.f89290a.f89277g == null) goto L45;
        Intrinsics.checkNotNullParameter(r141, "vote");
    L45:
        d r142 = r140.f89290a.f89276f;
        if (r142 == null) goto L65;
        Intrinsics.checkNotNullParameter(r141, "vote");
        List r143 = (List) r141.getItems().f267520d;
        if (r143.size() < 2) goto L50;
        boolean r144 = true;
    L51:
        if (r144 == true) goto L54;
        r143 = null;
    L54:
        if (r143 == null) goto L65;
        Pair r145 = TuplesKt.to(Long.valueOf(((com.bytedance.android.live.profit.vote.g) ListProtector.get(r143, 0)).f89199a), Long.valueOf(((com.bytedance.android.live.profit.vote.g) ListProtector.get(r143, 1)).f89199a));
        long r146 = ((Number) r145.component1()).longValue();
        long r147 = ((Number) r145.component2()).longValue();
        r142.f89291a.setLabel(null);
        r142.f89298h.setGuidelinePercent(0.5f);
        if (r146 != r147) goto L59;
        AnimatorSet r148 = com.bytedance.android.live.revenue.common.e.c(r142.a(), new float[]{0.0f, 1.05f, 1.0f});
        r148.setDuration(333);
    L64:
        r148.start();
        goto L65
    L59:
        ObjectAnimator r149 = ObjectAnimator.ofFloat(r142.f89300j, "guidelinePercent", new float[]{1.0f, 0.0f});
        r149.setDuration(233);
        r149.setStartDelay(200);
        r149.setInterpolator(new DecelerateInterpolator());
        TextView r150 = r142.a();
        if (r146 >= r147) goto L62;
        r142.f89304n.setVisibility(0);
        View r151 = r142.f89306p;
        final HSImageView r152 = r142.f89305o;
    L63:
        r152.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse("asset://com.ss.android.ies.live.sdk/vote_shine.webp")).setAutoPlayAnimations(true).build());
        ObjectAnimator r153 = ObjectAnimator.ofFloat(r151, "alpha", new float[]{0.0f, 1.0f});
        r153.setDuration(200);
        r153.setStartDelay(200);
        AnimatorSet r154 = com.bytedance.android.live.revenue.common.e.c(r152, new float[]{0.0f, 1.0f});
        r154.setDuration(400);
        r154.setStartDelay(433);
        ObjectAnimator r155 = ObjectAnimator.ofFloat(r152, "alpha", new float[]{1.0f, 0.0f});
        r155.setDuration(300);
        r155.setStartDelay(633);
        com.bytedance.android.live.revenue.common.e.b(r155, new VoteIconModel$ViewHolder$showFinishAnim$$inlined$apply$lambda$1(r152));
        AnimatorSet r156 = com.bytedance.android.live.revenue.common.e.c(r150, new float[]{1.0f, 1.05f, 1.0f});
        r156.setDuration(200);
        AnimatorSet r157 = new AnimatorSet();
        r157.playTogether(new Animator[]{r149, r153, r154, r155, r156});
        r148 = r157;
        goto L64
    L62:
        r142.f89301k.setVisibility(0);
        r151 = r142.f89303m;
        r152 = r142.f89302l;
        goto L63
    L50:
        r144 = false;
    L65:
        d r158 = this.f89276f;
        if (r158 == null) goto L70;
        xr2.b r159 = r158.f89291a;
        if (r159 == null) goto L70;
        r115 = null;
        r159.setLabel(null);
    L70:
        r115 = null;
        goto L71
    L11:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    public VoteIconModel(VoteViewModel r100, VotePanelHandler r101, c01.a r102, yz0.k r103, com.bytedance.android.live.profit.vote.f r104) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "panelHandler");
        Intrinsics.checkNotNullParameter(r102, "stiService");
        Intrinsics.checkNotNullParameter(r103, "roomDataService");
        Intrinsics.checkNotNullParameter(r104, "etHelper");
        super(com.bytedance.android.live.profit.vote.model.b.c.f89239a, RevStiElementType.GiftVote.getTypeId());
        this.f89279i = r100;
        this.f89280j = r101;
        this.f89281k = r102;
        this.f89282l = r103;
        this.f89283m = r104;
        this.f89278h = new c(this);
    }
}
