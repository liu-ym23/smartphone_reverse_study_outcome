package com.bytedance.android.ec.model.response;

import android.graphics.Rect;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/android/ec/model/response/u;", "", "", "Lcom/bytedance/android/ec/model/response/t;", "items", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "jumpUrl", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/ECSpannableText;", AppletNaviType.POI, "f", "background", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "leftIcon", "d", "rightIcon", ce.f26391f, "", "originMinPrice", "J", "e", "()J", "combinationMinPrice", "b", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super View, ? super Integer, Unit> f47956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f47957b;

    @SerializedName("background")
    private final String background;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f47958c;

    @SerializedName("min_price")
    private final long combinationMinPrice;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f47959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f47960e;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f47961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f47962g;

    @SerializedName("items")
    private final List<t> items;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("left_icon")
    private final String leftIcon;

    @SerializedName("origin_min_price")
    private final long originMinPrice;

    @SerializedName(AppletNaviType.POI)
    private final List<ECSpannableText> poi;

    @SerializedName("right_icon")
    private final String rightIcon;

    public u() {
        this(null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, 32767);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L36;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.poi, r101.poi) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.rightIcon, r101.rightIcon) == true) goto L18;
        return false;
    L18:
        if (this.originMinPrice == r101.originMinPrice) goto L20;
        return false;
    L20:
        if (this.combinationMinPrice == r101.combinationMinPrice) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.eventParams, r101.eventParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f47957b, r101.f47957b) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f47958c, r101.f47958c) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f47959d, r101.f47959d) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f47960e, r101.f47960e) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f47961f, r101.f47961f) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f47962g, r101.f47962g) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        List<t> r100 = this.items;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.jumpUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<ECSpannableText> r107 = this.poi;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.background;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.leftIcon;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.rightIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.originMinPrice;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.combinationMinPrice;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        Map<String, String> r123 = this.eventParams;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (r122 + r124) * 31;
        Integer r126 = this.f47957b;
        if (r126 == null) goto L33;
        int r127 = r126.hashCode();
    L34:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f47958c;
        if (r129 == null) goto L37;
        int r130 = r129.hashCode();
    L38:
        int r131 = (r128 + r130) * 31;
        Integer r132 = this.f47959d;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        Integer r135 = this.f47960e;
        if (r135 == null) goto L45;
        int r136 = r135.hashCode();
    L46:
        int r137 = (r134 + r136) * 31;
        Rect r138 = this.f47961f;
        if (r138 == null) goto L49;
        int r139 = r138.hashCode();
    L50:
        int r140 = (r137 + r139) * 31;
        Rect r141 = this.f47962g;
        if (r141 == null) goto L54;
        r101 = r141.hashCode();
    L54:
        return r140 + r101;
    L49:
        r139 = 0;
        goto L50
    L45:
        r136 = 0;
        goto L46
    L41:
        r133 = 0;
        goto L42
    L37:
        r130 = 0;
        goto L38
    L33:
        r127 = 0;
        goto L34
    L29:
        r124 = 0;
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
        return "ECProductBottomStruct(items=" + this.items + ", jumpUrl=" + this.jumpUrl + ", poi=" + this.poi + ", background=" + this.background + ", leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", originMinPrice=" + this.originMinPrice + ", combinationMinPrice=" + this.combinationMinPrice + ", eventParams=" + this.eventParams + ", backgroundRes=" + this.f47957b + ", leftRes=" + this.f47958c + ", rightRes=" + this.f47959d + ", arrowRes=" + this.f47960e + ", backgroundMargin=" + this.f47961f + ", arrowMargin=" + this.f47962g + ")";
    }

    public final String a() {
        return this.background;
    }

    public final long b() {
        return this.combinationMinPrice;
    }

    public final List<t> c() {
        return this.items;
    }

    public final String d() {
        return this.leftIcon;
    }

    public final long e() {
        return this.originMinPrice;
    }

    public final List<ECSpannableText> f() {
        return this.poi;
    }

    public final String g() {
        return this.rightIcon;
    }

    public u(List r110, String r111, List r112, String r210, String r211, String r212, long r213, long r214, Map r215, Integer r216, Integer r217, Integer r310, Integer r311, Rect r312, Rect r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = null;
    L26:
        long r113 = 0;
        if ((r314 & 64) == 0) goto L29;
        long r114 = 0;
    L31:
        if ((r314 & 128) != 0) goto L35;
        r113 = r214;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Map r106 = null;
    L39:
        if ((r314 & 512) == 0) goto L41;
        Integer r115 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        Integer r116 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        Integer r107 = null;
    L50:
        Integer r117 = r107;
        if ((r314 & 4096) == 0) goto L53;
        Integer r108 = null;
    L54:
        Integer r118 = r108;
        if ((r314 & 8192) == 0) goto L57;
        Rect r109 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        Rect r119 = null;
    L62:
        this.items = r100;
        this.jumpUrl = r101;
        this.poi = r102;
        this.background = r103;
        this.leftIcon = r104;
        this.rightIcon = r105;
        this.originMinPrice = r114;
        this.combinationMinPrice = r113;
        this.eventParams = r106;
        this.f47957b = r115;
        this.f47958c = r116;
        this.f47959d = r117;
        this.f47960e = r118;
        this.f47961f = r109;
        this.f47962g = r119;
        return;
    L61:
        r119 = r313;
        goto L62
    L57:
        r109 = r312;
        goto L59
    L53:
        r108 = r311;
        goto L54
    L49:
        r107 = r310;
        goto L50
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r106 = r215;
        goto L39
    L29:
        r114 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L26
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
