package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001$BM\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0003JO\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECCarouselData;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "", "component5", "before", "type", "content", "color", "eventParam", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getBefore", "()Ljava/lang/String;", "I", "getType", "()I", "getContent", "getColor", "Ljava/util/Map;", "getEventParam", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECCarouselData implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_BEST_BOARD = 4;
    public static final int TYPE_COMMENT_WORDS = 2;
    public static final int TYPE_RECOMMEND_REASON = 5;
    public static final int TYPE_SHELF_BOARD = 6;
    public static final int TYPE_SHOP_INFO = 3;
    public static final int TYPE_SUB_TITLE = 1;
    public static final int TYPE_UNKNOWN = 0;

    @SerializedName("before")
    private final String before;

    @SerializedName("color")
    private final String color;

    @SerializedName("content")
    private final String content;

    @SerializedName("event_param")
    private final Map<String, String> eventParam;

    @SerializedName("type")
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECCarouselData() {
        this(null, 0, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECCarouselData copy$default(ECCarouselData r100, String r101, int r102, String r103, String r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.before;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.color;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.eventParam;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.before;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.color;
    }

    public final Map<String, String> component5() {
        return this.eventParam;
    }

    public final ECCarouselData copy(String r100, int r101, String r110, String r111, Map<String, String> r112) {
        return new ECCarouselData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCarouselData) == false) goto L16;
        ECCarouselData r101 = (ECCarouselData) r100;
        if (Intrinsics.areEqual(this.before, r101.before) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParam, r101.eventParam) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.before;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        String r104 = this.content;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.color;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.eventParam;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public String toString() {
        return "ECCarouselData(before=" + this.before + ", type=" + this.type + ", content=" + this.content + ", color=" + this.color + ", eventParam=" + this.eventParam + ")";
    }

    public final String getBefore() {
        return this.before;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getEventParam() {
        return this.eventParam;
    }

    public final int getType() {
        return this.type;
    }

    public ECCarouselData(String r100, int r101, String r102, String r103, Map<String, String> r104) {
        this.before = r100;
        this.type = r101;
        this.content = r102;
        this.color = r103;
        this.eventParam = r104;
    }

    public /* synthetic */ ECCarouselData(String r100, int r101, String r102, String r103, Map r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Map r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
