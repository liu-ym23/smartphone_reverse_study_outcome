package com.bytedance.android.live.recharge.platform.service;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class PayService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f90279a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/PayService$PayProgress;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", GXAnimation.STATE_START, "SHOW_CASHIER", "QUERY_ORDER", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PayProgress extends Enum<PayProgress> {
        public static final PayProgress QUERY_ORDER = null;
        public static final PayProgress SHOW_CASHIER = null;
        public static final PayProgress START = null;
        public static final PayProgress UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PayProgress[] f90280a = null;
        private final int value;

        static {
            PayProgress r100 = new PayProgress("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            PayProgress r101 = new PayProgress(GXAnimation.STATE_START, 1, 0);
            START = r101;
            PayProgress r102 = new PayProgress("SHOW_CASHIER", 2, 2);
            SHOW_CASHIER = r102;
            PayProgress r103 = new PayProgress("QUERY_ORDER", 3, 1);
            QUERY_ORDER = r103;
            f90280a = new PayProgress[]{r100, r101, r102, r103};
        }

        public static PayProgress valueOf(String r100) {
            return (PayProgress) r27.a.a(PayProgress.class, r100);
        }

        public static PayProgress[] values() {
            return (PayProgress[]) f90280a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public PayProgress(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void a(b r100);

        void b(PayProgress r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f90281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f90282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f90283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f90284d;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f90285a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f90286b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f90287c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f90288d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Map<String, String> f90289e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final String f90290f;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L18;
                a r101 = (a) r100;
                if (this.f90285a == r101.f90285a) goto L8;
                return false;
            L8:
                if (this.f90286b == r101.f90286b) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f90287c, r101.f90287c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f90288d, r101.f90288d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f90289e, r101.f90289e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f90290f, r101.f90290f) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public final int hashCode() {
                long r100 = this.f90285a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                long r102 = this.f90286b;
                int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
                String r104 = this.f90287c;
                int r105 = 0;
                if (r104 == null) goto L5;
                int r106 = r104.hashCode();
            L6:
                int r107 = (r103 + r106) * 31;
                String r108 = this.f90288d;
                if (r108 == null) goto L9;
                int r109 = r108.hashCode();
            L10:
                int r110 = (r107 + r109) * 31;
                Map<String, String> r111 = this.f90289e;
                if (r111 == null) goto L13;
                int r112 = r111.hashCode();
            L14:
                int r113 = (r110 + r112) * 31;
                String r114 = this.f90290f;
                if (r114 == null) goto L18;
                r105 = r114.hashCode();
            L18:
                return r113 + r105;
            L13:
                r112 = 0;
                goto L14
            L9:
                r109 = 0;
                goto L10
            L5:
                r106 = 0;
                goto L6
            }

            public final String toString() {
                return "Extra(rebateAmount=" + this.f90285a + ", deductAmount=" + this.f90286b + ", rebateMessage=" + this.f90287c + ", cjParams=" + this.f90288d + ", extra=" + this.f90289e + ", oneStepScene=" + this.f90290f + ")";
            }

            public a(long r100, long r101, String r102, String r103, Map<String, String> r104, String r105) {
                Intrinsics.checkNotNullParameter(r102, "rebateMessage");
                Intrinsics.checkNotNullParameter(r103, "cjParams");
                Intrinsics.checkNotNullParameter(r104, "extra");
                Intrinsics.checkNotNullParameter(r105, "oneStepScene");
                this.f90285a = r100;
                this.f90286b = r101;
                this.f90287c = r102;
                this.f90288d = r103;
                this.f90289e = r104;
                this.f90290f = r105;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (this.f90281a == r101.f90281a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f90282b, r101.f90282b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f90283c, r101.f90283c) == true) goto L12;
            return false;
        L12:
            if (this.f90284d == r101.f90284d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r100 = this.f90281a * 31;
            String r101 = this.f90282b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            a r105 = this.f90283c;
            if (r105 == null) goto L9;
            r102 = r105.hashCode();
        L9:
            int r106 = (r104 + r102) * 31;
            boolean r107 = this.f90284d;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            return r106 + r108;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "PayResult(statusCode=" + this.f90281a + ", message=" + this.f90282b + ", extra=" + this.f90283c + ", isNoPasswordPay=" + this.f90284d + ")";
        }

        public /* synthetic */ b(String r100) {
            this(-60001, r100, null, false);
        }

        public b(int r100, String r101, a r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f90281a = r100;
            this.f90282b = r101;
            this.f90283c = r102;
            this.f90284d = r103;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public PayService(y r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.f90279a = r100;
    }

    public static b.a c(com.bytedance.android.live.wallet.e.a r110) {
        long r100 = r110.f102664a;
        long r101 = r110.f102665b;
        String r102 = r110.f102666c;
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        String r104 = r110.f102667d;
        if (r104 != null) goto L9;
        String r105 = "";
    L10:
        HashMap<String, String> r106 = r110.f102669f;
        if (r106 != null) goto L14;
        r106 = new HashMap();
    L14:
        HashMap<String, String> r107 = r106;
        String r111 = r110.f102668e;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        return new b.a(r100, r101, r103, r105, r107, r111);
    L9:
        r105 = r104;
        goto L10
    L5:
        r103 = r102;
        goto L6
    }

    public final void a(com.bytedance.android.live.recharge.deal.f r100, com.bytedance.android.live.recharge.order.k r101, com.bytedance.android.live.recharge.utils.h r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        Intrinsics.checkNotNullParameter(r101, "entranceParams");
        Intrinsics.checkNotNullParameter(r102, "callback");
        DetailChargeDeal.Builder r103 = new DetailChargeDeal.Builder();
        r103.diamondId(r100.b());
        r103.price((int) r100.g());
        if ((r100 instanceof com.bytedance.android.live.recharge.deal.d) == false) goto L5;
    L8:
        r103.customPrice(r100.g());
    L9:
        boolean r104 = false;
        r103.tradeType(0);
        this.f90279a.getClass();
        yz0.k r105 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r105 == null) goto L14;
        IRoom r106 = r105.getRoom();
        if (r106 == null) goto L14;
        long r107 = r106.getRoomId();
    L15:
        r103.roomId(r107);
        r103.totalDiamond(r100.i());
        r103.requestPage(r101.f90118a.b());
        com.bytedance.android.live.recharge.order.j r108 = r101.f90118a;
        r103.chargeScene((String) r108.f90111b.a(r108, com.bytedance.android.live.recharge.order.j.f90109i[1]));
        String r109 = r101.f90118a.a();
        if (r109.length() <= 0) goto L18;
        boolean r111 = true;
    L19:
        if (r111 == true) goto L22;
        r109 = null;
    L22:
        if (r109 == null) goto L24;
        r103.chargeReason(r109);
    L24:
        r103.openCombinePay(r100.c().b());
        r103.selectCombinePay(r101.f90123f);
        r103.showFastPay(r101.f90120c);
        r103.rechargeDialogHeight(r101.f90121d);
        r103.extra(new HashMap(r101.f90118a));
        r103.bizExtra(r101.f90127j);
        com.bytedance.android.livesdk.revenue.service.interact.d r112 = (com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        r103.liveType(r112.getLiveTypeForLog());
        r103.functionType(r112.getFunctionTypeForLog());
        int r113 = r101.f90125h;
        if (r113 != (-1)) goto L28;
        r113 = 0;
    L28:
        r103.chargeOrderSource(r113);
        r103.chargeOrderBusinessScene(r101.f90126i);
        String r114 = r101.f90118a.b();
        if (TextUtils.equals(AppConstants.EVENT_PROFILE_SELF, r114) == false) goto L32;
        r103.chargeOrderSource(1);
    L41:
        if (com.bytedance.android.live.recharge.core.f.f(RechargeServices.b()).h() != true) goto L43;
        boolean r115 = true;
    L44:
        r103.isFirstCharge(r115);
        this.f90279a.getClass();
        r103.ownerUserId(y.E1());
        r103.iapProductId(r100.f());
        if (com.bytedance.android.live.wallet.pay.iap.f.a() == true) goto L47;
    L49:
        r103.isIapPay(r104);
        r103.oneStepScene(r101.f90119b);
        r103.noPasswordOrderType(r101.f90128k.getValue());
        r103.queriesMap(r101.f90129l);
        r103.extraMap(r101.f90130m);
        r103.combineAmount(r110);
        DetailChargeDeal r116 = r103.build();
        com.bytedance.android.live.recharge.core.d r117 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r117, "$this$walletService");
        com.bytedance.android.live.wallet.e r118 = (com.bytedance.android.live.wallet.e) r117.f(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.wallet.e.class));
        Activity r119 = this.f90279a.getActivity();
        if (r119 == null) goto L54;
        r118.Y(r119, r116, new w(this, r102));
        return;
    L54:
        throw new IllegalStateException("activity is null".toString());
    L47:
        if (r2.a(r100.f()) == false) goto L49;
        r104 = true;
        goto L49
    L43:
        r115 = false;
        goto L44
    L32:
        if (TextUtils.equals("fire", r114) == false) goto L35;
        r103.chargeOrderSource(7);
        goto L41
    L35:
        if (TextUtils.equals("renqibao", r114) == false) goto L38;
        r103.chargeOrderSource(16);
        goto L41
    L38:
        if (TextUtils.equals("videopay", r114) == false) goto L41;
        r103.chargeOrderSource(17);
        goto L41
    L18:
        r111 = false;
    L14:
        r107 = 0;
        goto L15
    L5:
        if ((r100 instanceof com.bytedance.android.live.recharge.deal.u) == false) goto L9;
        if (((com.bytedance.android.live.recharge.deal.u) r100).f89770h == false) goto L9;
        goto L8
    }
}
