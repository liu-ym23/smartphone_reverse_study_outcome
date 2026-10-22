package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class AudienceReverseBtnConfig implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f51466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f51467b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/AudienceReverseBtnConfig$State;", "", "IMMEDIATE_RESERVE", "IMMEDIATE_RESERVE_HAS_PACKAGE", "CANCEL_RESERVE", "CANCEL_RESERVE_CARD", "RESERVE", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CANCEL_RESERVE = null;
        public static final State CANCEL_RESERVE_CARD = null;
        public static final State IMMEDIATE_RESERVE = null;
        public static final State IMMEDIATE_RESERVE_HAS_PACKAGE = null;
        public static final State RESERVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f51468a = null;

        static {
            State r100 = new State("IMMEDIATE_RESERVE", 0);
            IMMEDIATE_RESERVE = r100;
            State r101 = new State("IMMEDIATE_RESERVE_HAS_PACKAGE", 1);
            IMMEDIATE_RESERVE_HAS_PACKAGE = r101;
            State r102 = new State("CANCEL_RESERVE", 2);
            CANCEL_RESERVE = r102;
            State r103 = new State("CANCEL_RESERVE_CARD", 3);
            CANCEL_RESERVE_CARD = r103;
            State r104 = new State("RESERVE", 4);
            RESERVE = r104;
            f51468a = new State[]{r100, r101, r102, r103, r104};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f51468a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<State, Integer> f51469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<State, Integer> f51470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Integer> f51471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<State, Integer> f51472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<State, Integer> f51473e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51474f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51475g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<State, Float> f51476h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51477i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function1<State, Integer> f51478j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51479k;

        public Function1<State, Integer> a() {
            return this.f51469a;
        }

        public Function1<State, Pair<Integer, Integer>> b() {
            return this.f51474f;
        }

        public Function1<State, Integer> c() {
            return this.f51470b;
        }

        public Function1<State, Pair<Integer, Integer>> d() {
            return this.f51477i;
        }

        public Function1<State, Integer> e() {
            return this.f51478j;
        }

        public Function1<State, Pair<Integer, Integer>> f() {
            return this.f51479k;
        }

        public Function1<State, Integer> g() {
            return this.f51472d;
        }

        public Function1<State, Integer> h() {
            return this.f51473e;
        }

        public a(Object r110) {
            AudienceReverseBtnConfig$BtnUIStyle$1 r111 = AudienceReverseBtnConfig$BtnUIStyle$1.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$2 r100 = AudienceReverseBtnConfig$BtnUIStyle$2.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$3 r101 = AudienceReverseBtnConfig$BtnUIStyle$3.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$4 r102 = AudienceReverseBtnConfig$BtnUIStyle$4.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$5 r103 = AudienceReverseBtnConfig$BtnUIStyle$5.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$6 r104 = AudienceReverseBtnConfig$BtnUIStyle$6.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$7 r105 = AudienceReverseBtnConfig$BtnUIStyle$7.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$8 r106 = AudienceReverseBtnConfig$BtnUIStyle$8.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$9 r107 = AudienceReverseBtnConfig$BtnUIStyle$9.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$10 r108 = AudienceReverseBtnConfig$BtnUIStyle$10.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyle$11 r109 = AudienceReverseBtnConfig$BtnUIStyle$11.INSTANCE;
            Intrinsics.checkNotNullParameter(r111, "getBackground");
            Intrinsics.checkNotNullParameter(r100, "getColor");
            Intrinsics.checkNotNullParameter(r101, "getTypeface");
            Intrinsics.checkNotNullParameter(r102, "getTextSizeDp");
            Intrinsics.checkNotNullParameter(r103, "getTextWeight");
            Intrinsics.checkNotNullParameter(r104, "getBackgroundAnimColor");
            Intrinsics.checkNotNullParameter(r105, "getStrokeAnimColor");
            Intrinsics.checkNotNullParameter(r106, "getStrokeWidth");
            Intrinsics.checkNotNullParameter(r107, "getMainTextAnimColor");
            Intrinsics.checkNotNullParameter(r108, "getSubColor");
            Intrinsics.checkNotNullParameter(r109, "getSubTextAnimColor");
            this.f51469a = r111;
            this.f51470b = r100;
            this.f51471c = r101;
            this.f51472d = r102;
            this.f51473e = r103;
            this.f51474f = r104;
            this.f51475g = r105;
            this.f51476h = r106;
            this.f51477i = r107;
            this.f51478j = r108;
            this.f51479k = r109;
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<State, Integer> f51480l;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public Function1<State, Integer> a() {
            return this.f51480l;
        }

        public b(Object r100) {
            AudienceReverseBtnConfig$BtnUIStyleCorner8$1 r101 = AudienceReverseBtnConfig$BtnUIStyleCorner8$1.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            super(null);
            this.f51480l = r101;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<State, Integer> f51481m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<State, Integer> f51482n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<State, Integer> f51483o;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.b, com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51481m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51482n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> e() {
            return this.f51483o;
        }

        public c(int r100) {
            AudienceReverseBtnConfig$BtnUIStyleCorner8V2$1 r101 = AudienceReverseBtnConfig$BtnUIStyleCorner8V2$1.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleCorner8V2$2 r102 = AudienceReverseBtnConfig$BtnUIStyleCorner8V2$2.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleCorner8V2$3 r103 = AudienceReverseBtnConfig$BtnUIStyleCorner8V2$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            super(null);
            this.f51481m = r101;
            this.f51482n = r102;
            this.f51483o = r103;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<State, Integer> f51484m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<State, Integer> f51485n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<State, Integer> f51486o;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.b, com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51484m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51485n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> e() {
            return this.f51486o;
        }

        public d(int r100) {
            AudienceReverseBtnConfig$BtnUIStyleCorner8V3$1 r101 = AudienceReverseBtnConfig$BtnUIStyleCorner8V3$1.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleCorner8V3$2 r102 = AudienceReverseBtnConfig$BtnUIStyleCorner8V3$2.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleCorner8V3$3 r103 = AudienceReverseBtnConfig$BtnUIStyleCorner8V3$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            super(null);
            this.f51484m = r101;
            this.f51485n = r102;
            this.f51486o = r103;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<State, Integer> f51487l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<State, Integer> f51488m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<State, Integer> f51489n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<State, Integer> f51490o;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51487l;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51488m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> g() {
            return this.f51489n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> h() {
            return this.f51490o;
        }

        public e(int r100) {
            AudienceReverseBtnConfig$BtnUIStyleV2$1 r101 = AudienceReverseBtnConfig$BtnUIStyleV2$1.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV2$2 r102 = AudienceReverseBtnConfig$BtnUIStyleV2$2.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV2$3 r103 = AudienceReverseBtnConfig$BtnUIStyleV2$3.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV2$4 r104 = AudienceReverseBtnConfig$BtnUIStyleV2$4.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getTextSizeDp");
            Intrinsics.checkNotNullParameter(r104, "getTextWeight");
            super(null);
            this.f51487l = r101;
            this.f51488m = r102;
            this.f51489n = r103;
            this.f51490o = r104;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<State, Integer> f51491l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<State, Integer> f51492m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<State, Integer> f51493n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<State, Integer> f51494o;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51491l;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51492m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> g() {
            return this.f51493n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseBtnConfig.a
        public final Function1<State, Integer> h() {
            return this.f51494o;
        }

        public f(int r100) {
            AudienceReverseBtnConfig$BtnUIStyleV3$1 r101 = AudienceReverseBtnConfig$BtnUIStyleV3$1.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV3$2 r102 = AudienceReverseBtnConfig$BtnUIStyleV3$2.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV3$3 r103 = AudienceReverseBtnConfig$BtnUIStyleV3$3.INSTANCE;
            AudienceReverseBtnConfig$BtnUIStyleV3$4 r104 = AudienceReverseBtnConfig$BtnUIStyleV3$4.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getTextSizeDp");
            Intrinsics.checkNotNullParameter(r104, "getTextWeight");
            super(null);
            this.f51491l = r101;
            this.f51492m = r102;
            this.f51493n = r103;
            this.f51494o = r104;
        }
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return y0.f51681a.b(this.f51467b.a().invoke(this.f51466a).intValue());
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        State r101 = this.f51466a;
        int r102 = m.f51630a[r101.ordinal()];
        if (r102 != 1) goto L5;
    L15:
        return "立即预约";
    L5:
        if (r102 == 2) goto L15;
        if (r102 != 3) goto L9;
        return "已预约";
    L9:
        if (r102 != 4) goto L11;
        return "已预约";
    L11:
        if (r102 != 5) goto L14;
        return "预约";
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return y0.f51681a.a(this.f51467b.c().invoke(this.f51466a).intValue());
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.f51471c.invoke().intValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.e().invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final float f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.f51476h.invoke(this.f51466a).floatValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.h().invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Drawable getIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        State r101 = this.f51466a;
        if (m.f51631b[r101.ordinal()] == 1) goto L6;
        return null;
    L6:
        return y0.f51681a.b(R.drawable.gamecp_ic_game_promote_gift);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.d().invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.b().invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.g().invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.f51475g.invoke(this.f51466a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51467b.f().invoke(this.f51466a);
    }

    public AudienceReverseBtnConfig(State r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f51466a = r100;
        this.f51467b = r101;
    }
}
