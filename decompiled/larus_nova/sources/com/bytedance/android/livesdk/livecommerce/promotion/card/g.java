package com.bytedance.android.livesdk.livecommerce.promotion.card;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes10.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f150037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ILivePromotionCardContainerHandler f150038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jf.c f150039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f150040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final il.a f150041e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f150042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f150043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f150044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f150045d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f150046e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f150047f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f150048g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f150049h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f150050i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f150051j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f150052k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f150053l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f150054m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f150055n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L34;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f150042a, r101.f150042a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f150043b, r101.f150043b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f150044c, r101.f150044c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f150045d, r101.f150045d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f150046e, r101.f150046e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f150047f, r101.f150047f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f150048g, r101.f150048g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f150049h, r101.f150049h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.f150050i, r101.f150050i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f150051j, r101.f150051j) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.f150052k, r101.f150052k) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.f150053l, r101.f150053l) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f150054m, r101.f150054m) == true) goto L32;
            return false;
        L32:
            if (this.f150055n == r101.f150055n) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            String r100 = this.f150042a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f150043b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f150044c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f150045d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f150046e;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f150047f;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f150048g;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.f150049h;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.f150050i;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.f150051j;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.f150052k;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.f150053l;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            String r137 = this.f150054m;
            if (r137 == null) goto L53;
            r101 = r137.hashCode();
        L53:
            int r138 = (r136 + r101) * 31;
            boolean r139 = this.f150055n;
            ?? r140 = r139;
            if (r139 == false) goto L57;
            r140 = 1;
        L57:
            return r138 + r140;
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
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
            return "BtmInfo(itemBtm=" + this.f150042a + ", addCartBtm=" + this.f150043b + ", stepperBtm=" + this.f150044c + ", buttonBtm=" + this.f150045d + ", matchingBtm=" + this.f150046e + ", simpleSkuBtm=" + this.f150047f + ", givenProductBtm=" + this.f150048g + ", playbackBtm=" + this.f150049h + ", aiTryonBtm=" + this.f150050i + ", floatIconBtm=" + this.f150051j + ", guideModuleBtm=" + this.f150052k + ", hotAtmosphereBtm=" + this.f150053l + ", salePointBtm=" + this.f150054m + ", inList=" + this.f150055n + ")";
        }

        public final String a(KProperty1<a, String> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "prop");
            if (this.f150055n == false) goto L6;
            return r100.get(this) + "_i" + r101;
        L6:
            return r100.get(this);
        }

        public a(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, boolean r218, int r219) {
            if ((r219 & 1024) == 0) goto L5;
            String r113 = "c9204.d31984";
        L6:
            String r114 = null;
            if ((r219 & 2048) == 0) goto L9;
            String r115 = "c9204.d4334";
        L11:
            if ((r219 & 4096) == 0) goto L14;
            r114 = "c9204.d39378";
        L14:
            if ((r219 & 8192) == 0) goto L16;
            boolean r116 = false;
        L17:
            Intrinsics.checkNotNullParameter(r110, "itemBtm");
            Intrinsics.checkNotNullParameter(r111, "addCartBtm");
            Intrinsics.checkNotNullParameter(r112, "stepperBtm");
            Intrinsics.checkNotNullParameter(r210, "buttonBtm");
            Intrinsics.checkNotNullParameter(r211, "matchingBtm");
            Intrinsics.checkNotNullParameter(r212, "simpleSkuBtm");
            Intrinsics.checkNotNullParameter(r213, "givenProductBtm");
            Intrinsics.checkNotNullParameter(r214, "playbackBtm");
            Intrinsics.checkNotNullParameter(r215, "aiTryonBtm");
            Intrinsics.checkNotNullParameter(r216, "floatIconBtm");
            Intrinsics.checkNotNullParameter(r113, "guideModuleBtm");
            Intrinsics.checkNotNullParameter(r115, "hotAtmosphereBtm");
            Intrinsics.checkNotNullParameter(r114, "salePointBtm");
            this.f150042a = r110;
            this.f150043b = r111;
            this.f150044c = r112;
            this.f150045d = r210;
            this.f150046e = r211;
            this.f150047f = r212;
            this.f150048g = r213;
            this.f150049h = r214;
            this.f150050i = r215;
            this.f150051j = r216;
            this.f150052k = r113;
            this.f150053l = r115;
            this.f150054m = r114;
            this.f150055n = r116;
            return;
        L16:
            r116 = r218;
            goto L17
        L9:
            r115 = null;
            goto L11
        L5:
            r113 = r217;
            goto L6
        }
    }

    public g(a r100, ILivePromotionCardContainerHandler r101, jf.c r102, e r103, il.a r104) {
        Intrinsics.checkNotNullParameter(r101, "containerHandler");
        Intrinsics.checkNotNullParameter(r104, "historyMap");
        this.f150037a = r100;
        this.f150038b = r101;
        this.f150039c = r102;
        this.f150040d = r103;
        this.f150041e = r104;
    }
}
