package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f38192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f38193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f38194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SelectMode f38195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f38196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LabelMode f38197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConfigType f38198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f38199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h[] f38200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f38201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h f38202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f38203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<b> f38204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f38205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f38206p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ClassType f38207q;

    public final int hashCode() {
        int r100 = this.f38192b.hashCode() * 31;
        int r101 = 1231;
        if (this.f38193c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        SelectMode r104 = this.f38195e;
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.hashCode();
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.f38194d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.f38196f == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        ConfigType r112 = this.f38198h;
        if (r112 == null) goto L21;
        int r113 = r112.hashCode();
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f38199i;
        if (r115 == null) goto L25;
        int r116 = r115.hashCode();
    L26:
        int r117 = (r114 + r116) * 31;
        h[] r118 = this.f38200j;
        if (r118 == null) goto L29;
        int r119 = Arrays.hashCode(r118);
    L30:
        int r120 = (r117 + r119) * 31;
        d r121 = this.f38201k;
        if (r121 == null) goto L33;
        int r122 = r121.hashCode();
    L34:
        int r123 = (r120 + r122) * 31;
        h r124 = this.f38202l;
        if (r124 == null) goto L37;
        int r125 = r124.hashCode();
    L38:
        int r126 = (r123 + r125) * 31;
        h r127 = this.f38203m;
        if (r127 == null) goto L41;
        int r128 = r127.hashCode();
    L42:
        int r129 = (r126 + r128) * 31;
        List<b> r130 = this.f38204n;
        if (r130 == null) goto L45;
        r105 = r130.hashCode();
    L45:
        int r131 = (r129 + r105) * 31;
        if (this.f38205o == true) goto L50;
        r101 = 1237;
    L50:
        return ((((r131 + r101) * 31) + this.f38206p.hashCode()) * 31) + this.f38207q.hashCode();
    L41:
        r128 = 0;
        goto L42
    L37:
        r125 = 0;
        goto L38
    L33:
        r122 = 0;
        goto L34
    L29:
        r119 = 0;
        goto L30
    L25:
        r116 = 0;
        goto L26
    L21:
        r113 = 0;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("ViewConfigDsl(viewIdentifyDsl=");
        r100.append(this.f38192b);
        r100.append(", needFocus=");
        r100.append(this.f38193c);
        r100.append(", overWrite=");
        r100.append(this.f38194d);
        r100.append(", select=");
        SelectMode r101 = this.f38195e;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.name();
    L6:
        r100.append(r103);
        r100.append(", disableClick=");
        r100.append(this.f38196f);
        r100.append(",labelMode=");
        r100.append(this.f38197g);
        r100.append(",\nconfigType=");
        r100.append(this.f38198h);
        r100.append(",panelTitle=");
        r100.append(this.f38199i);
        r100.append(",hideExcludeFocus=");
        h[] r104 = this.f38200j;
        if (r104 == null) goto L9;
        r102 = Arrays.toString(r104);
    L9:
        r100.append(r102);
        r100.append(", label=");
        r100.append(this.f38201k);
        r100.append(",before=");
        r100.append(this.f38202l);
        r100.append(",after=");
        r100.append(this.f38203m);
        r100.append(", \nverify=");
        r100.append(this.f38205o);
        r100.append(",appMode=");
        r100.append(this.f38206p);
        r100.append(",classType=");
        r100.append(this.f38207q.getValue());
        r100.append(")");
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(g.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L68;
        g r102 = (g) r100;
        if ((!Intrinsics.areEqual(this.f38192b, r102.f38192b)) == false) goto L17;
        return false;
    L17:
        if (this.f38193c == r102.f38193c) goto L20;
        return false;
    L20:
        if (this.f38194d == r102.f38194d) goto L23;
        return false;
    L23:
        if (this.f38196f == r102.f38196f) goto L26;
        return false;
    L26:
        if (this.f38195e == r102.f38195e) goto L29;
        return false;
    L29:
        if (this.f38198h == r102.f38198h) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.f38199i, r102.f38199i)) == false) goto L34;
        return false;
    L34:
        h[] r103 = this.f38200j;
        if (r103 == null) goto L43;
        h[] r104 = r102.f38200j;
        if (r104 != null) goto L40;
        return false;
    L40:
        if (Arrays.equals(r103, r104) == true) goto L46;
        return false;
    L46:
        if ((!Intrinsics.areEqual(this.f38201k, r102.f38201k)) == false) goto L49;
        return false;
    L49:
        if ((!Intrinsics.areEqual(this.f38202l, r102.f38202l)) == false) goto L52;
        return false;
    L52:
        if ((!Intrinsics.areEqual(this.f38203m, r102.f38203m)) == false) goto L55;
        return false;
    L55:
        if ((!Intrinsics.areEqual(this.f38204n, r102.f38204n)) == false) goto L58;
        return false;
    L58:
        if (this.f38205o == r102.f38205o) goto L61;
        return false;
    L61:
        if ((!Intrinsics.areEqual(this.f38206p, r102.f38206p)) == false) goto L64;
        return false;
    L64:
        if (this.f38207q == r102.f38207q) goto L66;
        return false;
    L66:
        return true;
    L43:
        if (r102.f38200j == null) goto L46;
        return false;
    L68:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.accessibilityLib_Core.config.remote.dsl.ViewConfigDsl");
    L8:
        r101 = null;
        goto L10
    }

    public g(String r100, h r101, boolean r102, boolean r103, SelectMode r104, boolean r105, LabelMode r106, ConfigType r110, String r111, h[] r112, d r113, h r114, h r115, List<b> r116, boolean r117, String r118, ClassType r119) {
        this.f38191a = r100;
        this.f38192b = r101;
        this.f38193c = r102;
        this.f38194d = r103;
        this.f38195e = r104;
        this.f38196f = r105;
        this.f38197g = r106;
        this.f38198h = r110;
        this.f38199i = r111;
        this.f38200j = r112;
        this.f38201k = r113;
        this.f38202l = r114;
        this.f38203m = r115;
        this.f38204n = r116;
        this.f38205o = r117;
        this.f38206p = r118;
        this.f38207q = r119;
    }
}
