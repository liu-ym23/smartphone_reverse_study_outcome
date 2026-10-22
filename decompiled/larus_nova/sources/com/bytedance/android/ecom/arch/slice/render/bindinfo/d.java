package com.bytedance.android.ecom.arch.slice.render.bindinfo;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f50129m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f50130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f50131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f50132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f50133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f50134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f50135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f50136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f50137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f50138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f50139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f50140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, String> f50141l;

    public static final class a {
    }

    static {
    }

    public d() {
        Map r100 = null;
        this(r100, r100, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L30;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f50130a, r101.f50130a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f50131b, r101.f50131b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f50132c, r101.f50132c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f50133d, r101.f50133d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f50134e, r101.f50134e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f50135f, r101.f50135f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f50136g, r101.f50136g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f50137h, r101.f50137h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f50138i, r101.f50138i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f50139j, r101.f50139j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f50140k, r101.f50140k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f50141l, r101.f50141l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f50130a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f50131b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f50132c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f50133d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f50134e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f50135f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.f50136g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f50137h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f50138i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f50139j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f50140k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, String> r134 = this.f50141l;
        if (r134 == null) goto L50;
        r101 = r134.hashCode();
    L50:
        return r133 + r101;
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
        return "SlcBindInfo(attr=" + this.f50130a + ", style=" + this.f50131b + ", activeStyle=" + this.f50132c + ", forConfig=" + this.f50133d + ", clickAction=" + this.f50134e + ", longClickAction=" + this.f50135f + ", action=" + this.f50136g + ", storage=" + this.f50137h + ", display=" + this.f50138i + ", staticDisplay=" + this.f50139j + ", ifCondition=" + this.f50140k + ", ariaAttr=" + this.f50141l + ")";
    }

    public final boolean a(SlcTemplateContext r100, Map<String, ? extends Object> r101) {
        String r102 = this.f50138i;
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        Object r105 = r100.f50235w.f50187m0.a(this.f50138i, r101, r100.f50230r);
    L12:
        if (r105 == null) goto L17;
        if ("none".equals(r105) == false) goto L17;
        r103 = true;
    L17:
        return !r103;
    L11:
        r105 = this.f50139j;
        goto L12
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public final boolean b(SlcTemplateContext r100, Map<String, ? extends Object> r101) {
        String r102 = this.f50140k;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        String r104 = this.f50140k;
        if (aq.a.c(r100.f50235w.f50187m0.a(r104, r101, r100.f50230r)) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public /* synthetic */ d(Map r110, Map r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Map r101 = null;
    L10:
        this(r100, r101, null, null, null, null, null, null, null, null, null, null);
        return;
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }

    public d(Map<String, String> r100, Map<String, String> r101, Map<String, String> r102, c r103, String r104, String r105, Map<String, String> r106, Map<String, String> r107, String r108, String r110, String r111, Map<String, String> r112) {
        this.f50130a = r100;
        this.f50131b = r101;
        this.f50132c = r102;
        this.f50133d = r103;
        this.f50134e = r104;
        this.f50135f = r105;
        this.f50136g = r106;
        this.f50137h = r107;
        this.f50138i = r108;
        this.f50139j = r110;
        this.f50140k = r111;
        this.f50141l = r112;
    }
}
