package com.bytedance.android.live.recharge.platform.service;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface IExchangeService extends com.bytedance.android.live.recharge.core.c {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/IExchangeService$ExchangeApiType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "CASH", "GOLD_BALANCE", "HUOSHAN_FLAME", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ExchangeApiType extends Enum<ExchangeApiType> {
        public static final ExchangeApiType CASH = null;
        public static final ExchangeApiType GOLD_BALANCE = null;
        public static final ExchangeApiType HUOSHAN_FLAME = null;
        public static final ExchangeApiType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExchangeApiType[] f90262a = null;
        private final int value;

        static {
            ExchangeApiType r100 = new ExchangeApiType("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            ExchangeApiType r101 = new ExchangeApiType("CASH", 1, 0);
            CASH = r101;
            ExchangeApiType r102 = new ExchangeApiType("GOLD_BALANCE", 2, 1);
            GOLD_BALANCE = r102;
            ExchangeApiType r103 = new ExchangeApiType("HUOSHAN_FLAME", 3, 2);
            HUOSHAN_FLAME = r103;
            f90262a = new ExchangeApiType[]{r100, r101, r102, r103};
        }

        public static ExchangeApiType valueOf(String r100) {
            return (ExchangeApiType) r27.a.a(ExchangeApiType.class, r100);
        }

        public static ExchangeApiType[] values() {
            return (ExchangeApiType[]) f90262a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ExchangeApiType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/service/IExchangeService$ExchangeProgress;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", GXAnimation.STATE_START, "SUCCESS", "FAIL", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ExchangeProgress extends Enum<ExchangeProgress> {
        public static final ExchangeProgress FAIL = null;
        public static final ExchangeProgress START = null;
        public static final ExchangeProgress SUCCESS = null;
        public static final ExchangeProgress UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExchangeProgress[] f90263a = null;
        private final int value;

        static {
            ExchangeProgress r100 = new ExchangeProgress("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            ExchangeProgress r101 = new ExchangeProgress(GXAnimation.STATE_START, 1, 0);
            START = r101;
            ExchangeProgress r102 = new ExchangeProgress("SUCCESS", 2, 1);
            SUCCESS = r102;
            ExchangeProgress r103 = new ExchangeProgress("FAIL", 3, 2);
            FAIL = r103;
            f90263a = new ExchangeProgress[]{r100, r101, r102, r103};
        }

        public static ExchangeProgress valueOf(String r100) {
            return (ExchangeProgress) r27.a.a(ExchangeProgress.class, r100);
        }

        public static ExchangeProgress[] values() {
            return (ExchangeProgress[]) f90263a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ExchangeProgress(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void a(c r100);

        void onFailure(Throwable r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.recharge.deal.f f90264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f90265b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f90266c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f90267d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ExchangeApiType f90268e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f90269f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f90270g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L20;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f90264a, r101.f90264a) == true) goto L8;
            return false;
        L8:
            if (this.f90265b == r101.f90265b) goto L10;
            return false;
        L10:
            if (this.f90266c == r101.f90266c) goto L12;
            return false;
        L12:
            if (this.f90267d == r101.f90267d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f90268e, r101.f90268e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f90269f, r101.f90269f) == true) goto L18;
            return false;
        L18:
            if (this.f90270g == r101.f90270g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            com.bytedance.android.live.recharge.deal.f r100 = this.f90264a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((((((r102 * 31) + this.f90265b) * 31) + this.f90266c) * 31) + this.f90267d) * 31;
            ExchangeApiType r104 = this.f90268e;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f90269f;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            boolean r109 = this.f90270g;
            ?? r110 = r109;
            if (r109 == false) goto L17;
            r110 = 1;
        L17:
            return r108 + r110;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ExchangeParams(deal=" + this.f90264a + ", source=" + this.f90265b + ", currency=" + this.f90266c + ", accountType=" + this.f90267d + ", exchangeType=" + this.f90268e + ", ugExchangeVersion=" + this.f90269f + ", allowEquivalentCash=" + this.f90270g + ")";
        }

        public b(com.bytedance.android.live.recharge.deal.f r100, ExchangeApiType r101, String r102, boolean r103, int r104) {
            if ((r104 & 32) == 0) goto L6;
            r102 = "";
        L6:
            if ((r104 & 64) == 0) goto L8;
            r103 = true;
        L8:
            Intrinsics.checkNotNullParameter(r100, "deal");
            Intrinsics.checkNotNullParameter(r101, "exchangeType");
            Intrinsics.checkNotNullParameter(r102, "ugExchangeVersion");
            this.f90264a = r100;
            this.f90265b = 0;
            this.f90266c = 0;
            this.f90267d = 0;
            this.f90268e = r101;
            this.f90269f = r102;
            this.f90270g = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f90271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f90272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f90273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f90274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f90275e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f90276f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f90277g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.bytedance.android.live.recharge.platform.business.model.exchange.b f90278h;

        public c() {
            this(null, 0, null, null, 0, null, null, null, 255);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L22;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f90271a, r101.f90271a) == true) goto L8;
            return false;
        L8:
            if (this.f90272b == r101.f90272b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f90273c, r101.f90273c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f90274d, r101.f90274d) == true) goto L14;
            return false;
        L14:
            if (this.f90275e == r101.f90275e) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f90276f, r101.f90276f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f90277g, r101.f90277g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f90278h, r101.f90278h) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f90271a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f90272b) * 31;
            String r104 = this.f90273c;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f90274d;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((r106 + r108) * 31) + this.f90275e) * 31;
            String r110 = this.f90276f;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f90277g;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            com.bytedance.android.live.recharge.platform.business.model.exchange.b r116 = this.f90278h;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
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
            return "ExchangeResult(orderId=" + this.f90271a + ", userType=" + this.f90272b + ", prompt=" + this.f90273c + ", promptBody=" + this.f90274d + ", rebateAmount=" + this.f90275e + ", rebateMessage=" + this.f90276f + ", source=" + this.f90277g + ", exchangeMarketData=" + this.f90278h + ")";
        }

        public c(String r100, int r101, String r102, String r103, int r104, String r105, String r110, com.bytedance.android.live.recharge.platform.business.model.exchange.b r111, int r112) {
            if ((r112 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r112 & 2) == 0) goto L9;
            r101 = 0;
        L9:
            if ((r112 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r112 & 8) == 0) goto L15;
            r103 = "";
        L15:
            if ((r112 & 16) == 0) goto L18;
            r104 = 0;
        L18:
            if ((r112 & 32) == 0) goto L21;
            r105 = "";
        L21:
            if ((r112 & 64) == 0) goto L24;
            r110 = "";
        L24:
            if ((r112 & 128) == 0) goto L26;
            r111 = null;
        L26:
            Intrinsics.checkNotNullParameter(r100, "orderId");
            Intrinsics.checkNotNullParameter(r102, EventConstant.Key.RETAIN_PROMPT);
            Intrinsics.checkNotNullParameter(r103, "promptBody");
            Intrinsics.checkNotNullParameter(r105, "rebateMessage");
            Intrinsics.checkNotNullParameter(r110, "source");
            this.f90271a = r100;
            this.f90272b = r101;
            this.f90273c = r102;
            this.f90274d = r103;
            this.f90275e = r104;
            this.f90276f = r105;
            this.f90277g = r110;
            this.f90278h = r111;
        }
    }

    void t1(b r100, com.bytedance.android.live.recharge.order.k r101, a r102);
}
