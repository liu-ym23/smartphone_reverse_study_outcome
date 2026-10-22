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
public final class AudienceReserveSmallBtnConfig implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f51448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f51449b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/base/gamedetail/AudienceReserveSmallBtnConfig$State;", "", "RESERVE", "CANCEL_RESERVE", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State CANCEL_RESERVE = null;
        public static final State RESERVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f51450a = null;

        static {
            State r100 = new State("RESERVE", 0);
            RESERVE = r100;
            State r101 = new State("CANCEL_RESERVE", 1);
            CANCEL_RESERVE = r101;
            f51450a = new State[]{r100, r101};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f51450a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<State, Integer> f51451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<State, Integer> f51452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Integer> f51453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function1<State, Float> f51455e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51457g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function1<State, Integer> f51458h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function1<State, Pair<Integer, Integer>> f51459i;

        public Function1<State, Integer> a() {
            return this.f51451a;
        }

        public Function1<State, Pair<Integer, Integer>> b() {
            return this.f51454d;
        }

        public Function1<State, Integer> c() {
            return this.f51452b;
        }

        public Function1<State, Pair<Integer, Integer>> d() {
            return this.f51457g;
        }

        public Function1<State, Integer> e() {
            return this.f51458h;
        }

        public Function1<State, Pair<Integer, Integer>> f() {
            return this.f51459i;
        }

        public a(Object r110) {
            AudienceReserveSmallBtnConfig$BtnUIStyle$1 r111 = AudienceReserveSmallBtnConfig$BtnUIStyle$1.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$2 r100 = AudienceReserveSmallBtnConfig$BtnUIStyle$2.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$3 r101 = AudienceReserveSmallBtnConfig$BtnUIStyle$3.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$4 r102 = AudienceReserveSmallBtnConfig$BtnUIStyle$4.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$5 r103 = AudienceReserveSmallBtnConfig$BtnUIStyle$5.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$6 r104 = AudienceReserveSmallBtnConfig$BtnUIStyle$6.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$7 r105 = AudienceReserveSmallBtnConfig$BtnUIStyle$7.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$8 r106 = AudienceReserveSmallBtnConfig$BtnUIStyle$8.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyle$9 r107 = AudienceReserveSmallBtnConfig$BtnUIStyle$9.INSTANCE;
            Intrinsics.checkNotNullParameter(r111, "getBackground");
            Intrinsics.checkNotNullParameter(r100, "getColor");
            Intrinsics.checkNotNullParameter(r101, "getTypeface");
            Intrinsics.checkNotNullParameter(r102, "getBackgroundAnimColor");
            Intrinsics.checkNotNullParameter(r103, "getStrokeWidth");
            Intrinsics.checkNotNullParameter(r104, "getStrokeAnimColor");
            Intrinsics.checkNotNullParameter(r105, "getMainTextAnimColor");
            Intrinsics.checkNotNullParameter(r106, "getSubColor");
            Intrinsics.checkNotNullParameter(r107, "getSubTextAnimColor");
            this.f51451a = r111;
            this.f51452b = r100;
            this.f51453c = r101;
            this.f51454d = r102;
            this.f51455e = r103;
            this.f51456f = r104;
            this.f51457g = r105;
            this.f51458h = r106;
            this.f51459i = r107;
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function1<State, Integer> f51460j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function1<State, Integer> f51461k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<State, Integer> f51462l;

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51460j;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51461k;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> e() {
            return this.f51462l;
        }

        public b(int r100) {
            AudienceReserveSmallBtnConfig$BtnUIStyleV2$1 r101 = AudienceReserveSmallBtnConfig$BtnUIStyleV2$1.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyleV2$2 r102 = AudienceReserveSmallBtnConfig$BtnUIStyleV2$2.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyleV2$3 r103 = AudienceReserveSmallBtnConfig$BtnUIStyleV2$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            super(null);
            this.f51460j = r101;
            this.f51461k = r102;
            this.f51462l = r103;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function1<State, Integer> f51463j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function1<State, Integer> f51464k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function1<State, Integer> f51465l;

        public c() {
            this(null);
        }

        public final int hashCode() {
            Function1<State, Integer> r100 = this.f51463j;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Function1<State, Integer> r104 = this.f51464k;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Function1<State, Integer> r107 = this.f51465l;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "BtnUIStyleV3(getBackground=" + this.f51463j + ", getColor=" + this.f51464k + ", getSubColor=" + this.f51465l + ")";
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> a() {
            return this.f51463j;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> c() {
            return this.f51464k;
        }

        @Override // com.bytedance.android.gamecp.base.gamedetail.AudienceReserveSmallBtnConfig.a
        public final Function1<State, Integer> e() {
            return this.f51465l;
        }

        public c(Object r100) {
            AudienceReserveSmallBtnConfig$BtnUIStyleV3$1 r101 = AudienceReserveSmallBtnConfig$BtnUIStyleV3$1.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyleV3$2 r102 = AudienceReserveSmallBtnConfig$BtnUIStyleV3$2.INSTANCE;
            AudienceReserveSmallBtnConfig$BtnUIStyleV3$3 r103 = AudienceReserveSmallBtnConfig$BtnUIStyleV3$3.INSTANCE;
            Intrinsics.checkNotNullParameter(r101, "getBackground");
            Intrinsics.checkNotNullParameter(r102, "getColor");
            Intrinsics.checkNotNullParameter(r103, "getSubColor");
            super(null);
            this.f51463j = r101;
            this.f51464k = r102;
            this.f51465l = r103;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f51463j, r101.f51463j) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f51464k, r101.f51464k) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f51465l, r101.f51465l) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
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
        return y0.f51681a.b(this.f51449b.a().invoke(this.f51448a).intValue());
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        State r101 = this.f51448a;
        int r102 = e.f51567a[r101.ordinal()];
        String r103 = null;
        if (r102 != 1) goto L5;
        Context r104 = y0.f51681a.getContext();
        if (r104 == null) goto L16;
        r103 = r104.getString(R.string.gamecp_reserve);
    L16:
        if (r103 != null) goto L19;
    L17:
        return "";
    L19:
        return r103;
    L5:
        if (r102 != 2) goto L12;
        Context r105 = y0.f51681a.getContext();
        if (r105 == null) goto L9;
        r103 = r105.getString(R.string.gamecp_already_reserve);
    L9:
        if (r103 != null) goto L19;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return y0.f51681a.a(this.f51449b.c().invoke(this.f51448a).intValue());
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final int d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.f51453c.invoke().intValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.e().invoke(this.f51448a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final float f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.f51455e.invoke(this.f51448a).floatValue();
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return null;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.d().invoke(this.f51448a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.b().invoke(this.f51448a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Integer j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return null;
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.f51456f.invoke(this.f51448a);
    }

    @Override // com.bytedance.android.gamecp.base.gamedetail.z0
    public final Pair<Integer, Integer> l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        return this.f51449b.f().invoke(this.f51448a);
    }

    public AudienceReserveSmallBtnConfig(State r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f51448a = r100;
        this.f51449b = r101;
    }
}
