package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JN\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/m;", "component1", "", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "component5", "headerTabs", BitableAnalytic.LinkSceneClickType.EXPAND, "maxTabNum", "newStyle", "styleConfig", "copy", "(Ljava/util/List;ZLjava/lang/Integer;ZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderPendantNative;", "", "toString", "hashCode", "", "other", "equals", "Ljava/util/List;", "getHeaderTabs", "()Ljava/util/List;", "Z", "getExpand", "()Z", "Ljava/lang/Integer;", "getMaxTabNum", "getNewStyle", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "getStyleConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;", "<init>", "(Ljava/util/List;ZLjava/lang/Integer;ZLcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantStyleConfigModel;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderPendantNative implements Serializable {

    @SerializedName(BitableAnalytic.LinkSceneClickType.EXPAND)
    private final boolean expand;

    @SerializedName("tabs")
    private final List<m> headerTabs;

    @SerializedName("max_tab_num")
    private final Integer maxTabNum;

    @SerializedName("new_style")
    private final boolean newStyle;

    @SerializedName("style_config")
    private final HeaderNAPendantStyleConfigModel styleConfig;

    public HeaderPendantNative() {
        this(null, false, null, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderPendantNative copy$default(HeaderPendantNative r100, List r101, boolean r102, Integer r103, boolean r104, HeaderNAPendantStyleConfigModel r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.headerTabs;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.expand;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.maxTabNum;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.newStyle;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.styleConfig;
    L17:
        List r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final List<m> component1() {
        return this.headerTabs;
    }

    public final boolean component2() {
        return this.expand;
    }

    public final Integer component3() {
        return this.maxTabNum;
    }

    public final boolean component4() {
        return this.newStyle;
    }

    public final HeaderNAPendantStyleConfigModel component5() {
        return this.styleConfig;
    }

    public final HeaderPendantNative copy(List<m> r100, boolean r101, Integer r110, boolean r111, HeaderNAPendantStyleConfigModel r112) {
        return new HeaderPendantNative(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderPendantNative) == false) goto L16;
        HeaderPendantNative r101 = (HeaderPendantNative) r100;
        if (Intrinsics.areEqual(this.headerTabs, r101.headerTabs) == true) goto L8;
        return false;
    L8:
        if (this.expand == r101.expand) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxTabNum, r101.maxTabNum) == true) goto L12;
        return false;
    L12:
        if (this.newStyle == r101.newStyle) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.styleConfig, r101.styleConfig) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<m> r100 = this.headerTabs;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.expand;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.maxTabNum;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.newStyle;
        if (r111 == true) goto L17;
        r105 = r111;
    L17:
        int r112 = (r110 + r105) * 31;
        HeaderNAPendantStyleConfigModel r113 = this.styleConfig;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderPendantNative(headerTabs=" + this.headerTabs + ", expand=" + this.expand + ", maxTabNum=" + this.maxTabNum + ", newStyle=" + this.newStyle + ", styleConfig=" + this.styleConfig + ")";
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final List<m> getHeaderTabs() {
        return this.headerTabs;
    }

    public final Integer getMaxTabNum() {
        return this.maxTabNum;
    }

    public final boolean getNewStyle() {
        return this.newStyle;
    }

    public final HeaderNAPendantStyleConfigModel getStyleConfig() {
        return this.styleConfig;
    }

    public HeaderPendantNative(List<m> r100, boolean r101, Integer r102, boolean r103, HeaderNAPendantStyleConfigModel r104) {
        this.headerTabs = r100;
        this.expand = r101;
        this.maxTabNum = r102;
        this.newStyle = r103;
        this.styleConfig = r104;
    }

    public /* synthetic */ HeaderPendantNative(List r100, boolean r101, Integer r102, boolean r103, HeaderNAPendantStyleConfigModel r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        List r112 = null;
    L6:
        boolean r105 = false;
        if ((r110 & 2) == 0) goto L9;
        boolean r106 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r107 = null;
    L15:
        if ((r110 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r110 & 16) == 0) goto L21;
        HeaderNAPendantStyleConfigModel r113 = null;
    L22:
        this(r112, r106, r107, r105, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L6
    }
}
