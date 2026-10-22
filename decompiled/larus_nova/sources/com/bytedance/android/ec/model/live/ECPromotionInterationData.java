package com.bytedance.android.ec.model.live;

import com.bytedance.android.ec.model.response.j0;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003J\u008f\u0001\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b'\u0010&R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010-R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b2\u00103R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b4\u0010*R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u00107R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010(\u001a\u0004\b8\u0010*¨\u0006;"}, d2 = {"Lcom/bytedance/android/ec/model/live/ECPromotionInterationData;", "Ljava/io/Serializable;", "", "toString", "", "component1", "component2", "", "Lcom/bytedance/android/ec/model/live/b;", "component3", "Lcom/bytedance/android/ec/model/live/m;", "component4", "", "component5", "Lcom/bytedance/android/ec/model/live/n;", "component6", "Lcom/bytedance/android/ec/model/live/o;", "component7", "Lcom/bytedance/android/ec/model/response/j0;", "component8", "component9", "priority", "loopCount", "content", "checkParam", "trackParams", "product", "rows", "action", "bgColors", "copy", "hashCode", "", "other", "", "equals", "I", "getPriority", "()I", "getLoopCount", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "Lcom/bytedance/android/ec/model/live/m;", "getCheckParam", "()Lcom/bytedance/android/ec/model/live/m;", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/live/n;", "getProduct", "()Lcom/bytedance/android/ec/model/live/n;", "getRows", "Lcom/bytedance/android/ec/model/response/j0;", "getAction", "()Lcom/bytedance/android/ec/model/response/j0;", "getBgColors", "<init>", "(IILjava/util/List;Lcom/bytedance/android/ec/model/live/m;Ljava/util/Map;Lcom/bytedance/android/ec/model/live/n;Ljava/util/List;Lcom/bytedance/android/ec/model/response/j0;Ljava/util/List;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionInterationData implements Serializable {

    @SerializedName("action")
    private final j0 action;

    @SerializedName("bg_colors")
    private final List<String> bgColors;

    @SerializedName("check")
    private final m checkParam;

    @SerializedName("content")
    private final List<b> content;

    @SerializedName("loop_count")
    private final int loopCount;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("product")
    private final n product;

    @SerializedName("rows")
    private final List<o> rows;

    @SerializedName("event_param")
    private final Map<String, String> trackParams;

    public ECPromotionInterationData() {
        this(0, 0, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPromotionInterationData copy$default(ECPromotionInterationData r110, int r111, int r112, List r113, m r114, Map r115, n r116, List r117, j0 r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.priority;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.loopCount;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r102 = r110.content;
    L15:
        if ((r210 & 8) == 0) goto L17;
        m r103 = r110.checkParam;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r104 = r110.trackParams;
    L23:
        if ((r210 & 32) == 0) goto L25;
        n r105 = r110.product;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.rows;
    L31:
        if ((r210 & 128) == 0) goto L33;
        j0 r107 = r110.action;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.bgColors;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.priority;
    }

    public final int component2() {
        return this.loopCount;
    }

    public final List<b> component3() {
        return this.content;
    }

    public final m component4() {
        return this.checkParam;
    }

    public final Map<String, String> component5() {
        return this.trackParams;
    }

    public final n component6() {
        return this.product;
    }

    public final List<o> component7() {
        return this.rows;
    }

    public final j0 component8() {
        return this.action;
    }

    public final List<String> component9() {
        return this.bgColors;
    }

    public final ECPromotionInterationData copy(int r110, int r111, List<b> r112, m r113, Map<String, String> r114, n r115, List<o> r116, j0 r117, List<String> r210) {
        return new ECPromotionInterationData(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionInterationData) == false) goto L24;
        ECPromotionInterationData r101 = (ECPromotionInterationData) r100;
        if (this.priority == r101.priority) goto L8;
        return false;
    L8:
        if (this.loopCount == r101.loopCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.checkParam, r101.checkParam) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rows, r101.rows) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bgColors, r101.bgColors) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.priority * 31) + this.loopCount) * 31;
        List<b> r101 = this.content;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        m r105 = this.checkParam;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, String> r108 = this.trackParams;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        n r111 = this.product;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        List<o> r114 = this.rows;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        j0 r117 = this.action;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        List<String> r120 = this.bgColors;
        if (r120 == null) goto L30;
        r102 = r120.hashCode();
    L30:
        return r119 + r102;
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("[");
        List<b> r101 = this.content;
        if (r101 == null) goto L17;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((b) r104).o() != 2) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        r105 = false;
        goto L11
    L13:
        Iterator r106 = r102.iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        r100.append(((b) r106.next()).s());
    L17:
        r100.append(']');
        return r100.toString();
    }

    public final j0 getAction() {
        return this.action;
    }

    public final List<String> getBgColors() {
        return this.bgColors;
    }

    public final m getCheckParam() {
        return this.checkParam;
    }

    public final List<b> getContent() {
        return this.content;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final n getProduct() {
        return this.product;
    }

    public final List<o> getRows() {
        return this.rows;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public ECPromotionInterationData(int r100, int r101, List<b> r102, m r103, Map<String, String> r104, n r105, List<o> r106, j0 r107, List<String> r108) {
        this.priority = r100;
        this.loopCount = r101;
        this.content = r102;
        this.checkParam = r103;
        this.trackParams = r104;
        this.product = r105;
        this.rows = r106;
        this.action = r107;
        this.bgColors = r108;
    }

    public /* synthetic */ ECPromotionInterationData(int r110, int r111, List r112, m r113, Map r114, n r115, List r116, j0 r117, List r118, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = 1;
    L10:
        List r102 = null;
        if ((r210 & 4) == 0) goto L13;
        List r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        m r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        n r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        j0 r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r102 = r118;
    L38:
        this(r100, r101, r103, r104, r105, r106, r107, r108, r102);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
