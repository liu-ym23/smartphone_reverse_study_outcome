package com.bytedance.android.shopping.api.mall.idl;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f170553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f170554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f170555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Float f170556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f170557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f170558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f170559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f170560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<Integer> f170561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f170562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f170563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f170564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f170565n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f170566o;

    public c() {
        this(null);
    }

    public final String toString() {
        return "MallScreenModel(mallMetricsWidth=" + this.f170553b + ", favoriteFeedMetricsWidth=" + this.f170554c + ", mallPageWidth=" + this.f170555d + ", mallContainerMarginLeft=" + this.f170556e + ", mallContainerMarginRight=" + this.f170557f + ", mallLayoutBreakpoint=" + this.f170558g + ", deviceOrientation=" + this.f170559h + ", feedLayoutColumn=" + this.f170560i + ", tileLayoutInfo=" + this.f170561j + ", deviceScreenType=" + this.f170562k + ", enableBigScreenAdapter=" + this.f170563l + ", inMainSplitScreen=" + this.f170564m + ", enableWidescreenStyle=" + this.f170565n + ", isOpenPageFromMall=" + this.f170566o + ")";
    }

    public final boolean a() {
        if (this.f170565n == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f170563l == true) goto L8;
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f170553b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f170556e;
        if (r104 == null) goto L9;
        int r105 = Float.floatToIntBits(r104.floatValue());
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f170554c;
        if (r107 == null) goto L13;
        int r108 = r107.intValue();
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.f170557f;
        if (r110 == null) goto L17;
        int r111 = Float.floatToIntBits(r110.floatValue());
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f170558g;
        if (r113 == null) goto L21;
        int r114 = r113.intValue();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f170560i;
        if (r116 == null) goto L25;
        int r117 = r116.intValue();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f170562k;
        if (r119 == null) goto L29;
        int r120 = r119.intValue();
    L30:
        int r121 = (r118 + r120) * 31;
        int r122 = 1231;
        if (this.f170563l == false) goto L33;
        int r123 = 1231;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f170555d;
        if (r125 == null) goto L37;
        int r126 = r125.intValue();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f170559h;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        List<Integer> r131 = this.f170561j;
        if (r131 == null) goto L45;
        r101 = r131.hashCode();
    L45:
        int r132 = (r130 + r101) * 31;
        if (this.f170564m == false) goto L48;
        int r133 = 1231;
    L49:
        int r134 = (r132 + r133) * 31;
        if (this.f170565n == true) goto L54;
        r122 = 1237;
    L54:
        return r134 + r122;
    L48:
        r133 = 1237;
        goto L49
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 1237;
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

    public c(Object r100) {
        this.f170553b = null;
        this.f170554c = null;
        this.f170555d = null;
        this.f170556e = null;
        this.f170557f = null;
        this.f170558g = null;
        this.f170559h = null;
        this.f170560i = null;
        this.f170561j = null;
        this.f170562k = null;
        this.f170563l = false;
        this.f170564m = false;
        this.f170565n = false;
        this.f170566o = false;
        this.f170552a = LazyKt.lazy(MallScreenModel$bigScreenConfig$2.INSTANCE);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L32;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f170553b, r101.f170553b) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.f170554c, r101.f170554c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f170556e, r101.f170556e) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f170557f, r101.f170557f) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.f170555d, r101.f170555d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f170558g, r101.f170558g) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.f170559h, r101.f170559h) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f170560i, r101.f170560i) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f170561j, r101.f170561j) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.f170562k, r101.f170562k) == true) goto L25;
        return false;
    L25:
        if (this.f170563l == r101.f170563l) goto L27;
        return false;
    L27:
        if (this.f170564m == r101.f170564m) goto L29;
        return false;
    L29:
        if (this.f170565n != r101.f170565n) goto L45;
        return true;
    L45:
        return false;
    L32:
        return false;
    }

    public final void update(c r100) {
        Intrinsics.checkNotNullParameter(r100, "newModel");
        this.f170553b = r100.f170553b;
        this.f170554c = r100.f170554c;
        this.f170556e = r100.f170556e;
        this.f170557f = r100.f170557f;
        this.f170555d = r100.f170555d;
        this.f170558g = r100.f170558g;
        this.f170559h = r100.f170559h;
        this.f170560i = r100.f170560i;
        this.f170561j = r100.f170561j;
        this.f170562k = r100.f170562k;
        this.f170563l = r100.f170563l;
        this.f170564m = r100.f170564m;
        this.f170565n = r100.f170565n;
    }
}
