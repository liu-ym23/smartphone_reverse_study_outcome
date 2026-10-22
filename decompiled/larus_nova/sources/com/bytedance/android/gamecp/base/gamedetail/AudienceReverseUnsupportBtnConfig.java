package com.bytedance.android.gamecp.base.gamedetail;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class AudienceReverseUnsupportBtnConfig implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Location f51495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f51496b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/AudienceReverseUnsupportBtnConfig$Location;", "", "CARD", "AUDIENCE_DETAIL_TITLE_BAR", "AUDIENCE_DETAIL_BTN", "ANCHOR_DETAIL", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Location extends Enum<Location> {
        public static final Location ANCHOR_DETAIL = null;
        public static final Location AUDIENCE_DETAIL_BTN = null;
        public static final Location AUDIENCE_DETAIL_TITLE_BAR = null;
        public static final Location CARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Location[] f51497a = null;

        static {
            Location r100 = new Location("CARD", 0);
            CARD = r100;
            Location r101 = new Location("AUDIENCE_DETAIL_TITLE_BAR", 1);
            AUDIENCE_DETAIL_TITLE_BAR = r101;
            Location r102 = new Location("AUDIENCE_DETAIL_BTN", 2);
            AUDIENCE_DETAIL_BTN = r102;
            Location r103 = new Location("ANCHOR_DETAIL", 3);
            ANCHOR_DETAIL = r103;
            f51497a = new Location[]{r100, r101, r102, r103};
        }

        public static Location valueOf(String r100) {
            return (Location) r27.a.a(Location.class, r100);
        }

        public static Location[] values() {
            return (Location[]) f51497a.clone();
        }

        public Location(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Location, Integer> f51498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Location, Integer> f51499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Integer> f51500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<Location, Integer> f51501d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<Location, Integer> f51502e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<Location, Pair<Integer, Integer>> f51503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<Location, Pair<Integer, Integer>> f51504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<Location, Float> f51505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<Location, Pair<Integer, Integer>> f51506i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function1<Location, Integer> f51507j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function1<Location, Pair<Integer, Integer>> f51508k;

        public Function1<Location, Integer> a() {
            return this.f51498a;
        }

        public Function1<Location, Integer> b() {
            return this.f51499b;
        }

        public Function1<Location, Pair<Integer, Integer>> c() {
            return this.f51506i;
        }

        public Function1<Location, Pair<Integer, Integer>> d() {
            return this.f51504g;
        }

        public Function1<Location, Float> e() {
            return this.f51505h;
        }

        public Function1<Location, Integer> f() {
            return this.f51507j;
        }

        public Function1<Location, Pair<Integer, Integer>> g() {
            return this.f51508k;
        }

        public Function1<Location, Integer> h() {
            return this.f51501d;
        }

        public Function1<Location, Integer> i() {
            return this.f51502e;
        }

        public a(Object r110) {
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$1 r111 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$1.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$2 r100 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$2.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$3 r101 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$3.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$4 r102 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$4.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$5 r103 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$5.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$6 r104 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$6.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$7 r105 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$7.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$8 r106 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$8.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$9 r107 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$9.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$10 r108 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$10.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyle$11 r109 = AudienceReverseUnsupportBtnConfig$BtnUIStyle$11.INSTANCE;
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
            this.f51498a = r111;
            this.f51499b = r100;
            this.f51500c = r101;
            this.f51501d = r102;
            this.f51502e = r103;
            this.f51503f = r104;
            this.f51504g = r105;
            this.f51505h = r106;
            this.f51506i = r107;
            this.f51507j = r108;
            this.f51508k = r109;
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<Location, Integer> f51509l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<Location, Integer> f51510m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<Location, Integer> f51511n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<Location, Integer> f51512o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Function1<Location, Integer> f51513p;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> a() {
            return this.f51509l;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> b() {
            return this.f51510m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> f() {
            return this.f51511n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> h() {
            return this.f51512o;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> i() {
            return this.f51513p;
        }

        public b(int r100) {
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$1 r101 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$1.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$2 r102 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$2.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$3 r103 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$3.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$4 r104 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$4.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$5 r105 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV2$5.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            Intrinsics.checkNotNullParameter(r104, "getTextSizeDp");
            Intrinsics.checkNotNullParameter(r105, "getTextWeight");
            super(null);
            this.f51509l = r101;
            this.f51510m = r102;
            this.f51511n = r103;
            this.f51512o = r104;
            this.f51513p = r105;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<Location, Integer> f51514l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function1<Location, Integer> f51515m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<Location, Integer> f51516n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function1<Location, Integer> f51517o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Function1<Location, Integer> f51518p;

        public c() {
            this(null);
        }

        public final int hashCode() {
            Function1<Location, Integer> r100 = this.f51514l;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Function1<Location, Integer> r104 = this.f51515m;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Function1<Location, Integer> r107 = this.f51516n;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Function1<Location, Integer> r110 = this.f51517o;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Function1<Location, Integer> r113 = this.f51518p;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "BtnUIStyleV3(getBackground=" + this.f51514l + ", getColor=" + this.f51515m + ", getSubColor=" + this.f51516n + ", getTextSizeDp=" + this.f51517o + ", getTextWeight=" + this.f51518p + ")";
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> a() {
            return this.f51514l;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> b() {
            return this.f51515m;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> f() {
            return this.f51516n;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> h() {
            return this.f51517o;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReverseUnsupportBtnConfig.a
        public final Function1<Location, Integer> i() {
            return this.f51518p;
        }

        public c(Object r100) {
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$1 r101 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$1.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$2 r102 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$2.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$3 r103 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$3.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$4 r104 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$4.INSTANCE;
            AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$5 r105 = AudienceReverseUnsupportBtnConfig$BtnUIStyleV3$5.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            Intrinsics.checkNotNullParameter(r104, "getTextSizeDp");
            Intrinsics.checkNotNullParameter(r105, "getTextWeight");
            super(null);
            this.f51514l = r101;
            this.f51515m = r102;
            this.f51516n = r103;
            this.f51517o = r104;
            this.f51518p = r105;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L16;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f51514l, r101.f51514l) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f51515m, r101.f51515m) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f51516n, r101.f51516n) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f51517o, r101.f51517o) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f51518p, r101.f51518p) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Drawable getIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return null;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return y0.f51681a.b(this.f51496b.a().invoke(this.f51495a).intValue());
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Location r101 = this.f51495a;
        int r102 = r.f51656a[r101.ordinal()];
        if (r102 != 1) goto L5;
        return "查看";
    L5:
        if (r102 != 2) goto L7;
        return "暂不支持";
    L7:
        if (r102 != 3) goto L9;
    L13:
        return "安卓暂不支持预约";
    L9:
        if (r102 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.b().invoke(this.f51495a).intValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.f51500c.invoke().intValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.f().invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final float f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.e().invoke(this.f51495a).floatValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.i().invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.c().invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.f51503f.invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.h().invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.d().invoke(this.f51495a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51496b.g().invoke(this.f51495a);
    }

    public AudienceReverseUnsupportBtnConfig(Location r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f51495a = r100;
        this.f51496b = r101;
    }
}
