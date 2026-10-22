package com.bytedance.ai.widget.contianer;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f38019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f38020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f38021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f38022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f38023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f38024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f38025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f38026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f38027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f38028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f38029o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f38030p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f38031q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function1<? super Boolean, Unit> f38032r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f38033s;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f38015a, r101.f38015a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38016b, r101.f38016b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f38017c, r101.f38017c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f38018d, r101.f38018d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f38019e, r101.f38019e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f38020f, r101.f38020f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f38021g, r101.f38021g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f38022h, r101.f38022h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f38023i, r101.f38023i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f38024j, r101.f38024j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f38025k, r101.f38025k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f38026l, r101.f38026l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f38027m, r101.f38027m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f38028n, r101.f38028n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f38029o, r101.f38029o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f38030p, r101.f38030p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f38031q, r101.f38031q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f38032r, r101.f38032r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f38033s, r101.f38033s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f38015a.hashCode() * 31) + this.f38016b.hashCode()) * 31;
        String r101 = this.f38017c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f38018d.hashCode()) * 31) + this.f38019e.hashCode()) * 31;
        String r105 = this.f38020f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f38021g;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f38022h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, Object> r114 = this.f38023i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f38024j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f38025k;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f38026l;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Map<String, Object> r126 = this.f38027m;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        Map<String, Object> r129 = this.f38028n;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f38029o;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f38030p;
        if (r135 != null) goto L49;
        int r136 = 0;
    L50:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f38031q;
        if (r138 != null) goto L53;
        int r139 = 0;
    L54:
        int r140 = (r137 + r139) * 31;
        Function1<? super Boolean, Unit> r141 = this.f38032r;
        if (r141 != null) goto L57;
        int r142 = 0;
    L58:
        int r143 = (r140 + r142) * 31;
        String r144 = this.f38033s;
        if (r144 == null) goto L63;
        r102 = r144.hashCode();
    L63:
        return r143 + r102;
    L57:
        r142 = r141.hashCode();
        goto L58
    L53:
        r139 = r138.hashCode();
        goto L54
    L49:
        r136 = r135.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetContainerData(packageName=" + this.f38015a + ", widgetId=" + this.f38016b + ", widgetData=" + this.f38017c + ", botId=" + this.f38018d + ", messageId=" + this.f38019e + ", sectionId=" + this.f38020f + ", replyId=" + this.f38021g + ", ext=" + this.f38022h + ", params=" + this.f38023i + ", mixtureCardId=" + this.f38024j + ", conversationId=" + this.f38025k + ", liteTemplateUrl=" + this.f38026l + ", globalProps=" + this.f38027m + ", extra=" + this.f38028n + ", mcpName=" + this.f38029o + ", fullScreenRefresh=" + this.f38030p + ", entityId=" + this.f38031q + ", isLongClickable=" + this.f38032r + ", versionTag=" + this.f38033s + ')';
    }

    public final String a() {
        String r100 = this.f38024j;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return this.f38019e;
    L13:
        return this.f38024j;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public /* synthetic */ m(String r210, String r211, String r212, String r213, String r214, String r215, String r310, Map r311, Map r312, String r313, String r314, String r315, Map r316, Map r317, String r318, String r319, String r410, String r411, int r412) {
        if ((r412 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r412 & 32) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r412 & 64) == 0) goto L13;
        String r110 = null;
    L15:
        if ((r412 & 128) == 0) goto L17;
        Map r111 = null;
    L19:
        if ((r412 & 256) == 0) goto L21;
        Map r112 = null;
    L23:
        if ((r412 & 512) == 0) goto L25;
        String r113 = null;
    L27:
        if ((r412 & 1024) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r412 & 2048) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r412 & 4096) == 0) goto L37;
        Map r116 = null;
    L39:
        if ((r412 & 8192) == 0) goto L41;
        Map r117 = null;
    L43:
        if ((r412 & 16384) == 0) goto L45;
        String r118 = null;
    L47:
        if ((32768 & r412) == 0) goto L49;
        String r119 = null;
    L51:
        if ((65536 & r412) == 0) goto L53;
        String r216 = null;
    L55:
        if ((r412 & 262144) == 0) goto L57;
        String r217 = null;
    L58:
        this(r210, r211, r100, r213, r214, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, null, r217);
        return;
    L57:
        r217 = r411;
        goto L58
    L53:
        r216 = r410;
        goto L55
    L49:
        r119 = r319;
        goto L51
    L45:
        r118 = r318;
        goto L47
    L41:
        r117 = r317;
        goto L43
    L37:
        r116 = r316;
        goto L39
    L33:
        r115 = r315;
        goto L35
    L29:
        r114 = r314;
        goto L31
    L25:
        r113 = r313;
        goto L27
    L21:
        r112 = r312;
        goto L23
    L17:
        r111 = r311;
        goto L19
    L13:
        r110 = r310;
        goto L15
    L9:
        r101 = r215;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public m(String r100, String r101, String r102, String r110, String r111, String r112, String r113, Map<String, String> r114, Map<String, ? extends Object> r115, String r116, String r117, String r118, Map<String, ? extends Object> r119, Map<String, ? extends Object> r210, String r211, String r212, String r213, Function1<? super Boolean, Unit> r214, String r215) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "widgetId");
        Intrinsics.checkNotNullParameter(r110, "botId");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        this.f38015a = r100;
        this.f38016b = r101;
        this.f38017c = r102;
        this.f38018d = r110;
        this.f38019e = r111;
        this.f38020f = r112;
        this.f38021g = r113;
        this.f38022h = r114;
        this.f38023i = r115;
        this.f38024j = r116;
        this.f38025k = r117;
        this.f38026l = r118;
        this.f38027m = r119;
        this.f38028n = r210;
        this.f38029o = r211;
        this.f38030p = r212;
        this.f38031q = r213;
        this.f38032r = r214;
        this.f38033s = r215;
    }
}
