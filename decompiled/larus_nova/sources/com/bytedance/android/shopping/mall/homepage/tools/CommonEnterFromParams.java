package com.bytedance.android.shopping.mall.homepage.tools;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0014Jj\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/tools/CommonEnterFromParams;", "", "previousPage", "", "pageName", "moduleId", "componentId", "resourceId", "moduleKey", "componentKey", "resourceKey", "order", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getComponentId", "()Ljava/lang/String;", "getComponentKey", "getModuleId", "getModuleKey", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageName", "getPreviousPage", "getResourceId", "getResourceKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/mall/homepage/tools/CommonEnterFromParams;", "equals", "", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonEnterFromParams {
    private final String componentId;
    private final String componentKey;
    private final String moduleId;
    private final String moduleKey;
    private final Integer order;
    private final String pageName;
    private final String previousPage;
    private final String resourceId;
    private final String resourceKey;

    public CommonEnterFromParams() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ CommonEnterFromParams copy$default(CommonEnterFromParams r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, Integer r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.previousPage;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.pageName;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.moduleId;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.componentId;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.resourceId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.moduleKey;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.componentKey;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.resourceKey;
    L35:
        if ((r210 & 256) == 0) goto L37;
        Integer r108 = r110.order;
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

    public final String component1() {
        return this.previousPage;
    }

    public final String component2() {
        return this.pageName;
    }

    public final String component3() {
        return this.moduleId;
    }

    public final String component4() {
        return this.componentId;
    }

    public final String component5() {
        return this.resourceId;
    }

    public final String component6() {
        return this.moduleKey;
    }

    public final String component7() {
        return this.componentKey;
    }

    public final String component8() {
        return this.resourceKey;
    }

    public final Integer component9() {
        return this.order;
    }

    public final CommonEnterFromParams copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Integer r210) {
        Intrinsics.checkNotNullParameter(r110, "previousPage");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        Intrinsics.checkNotNullParameter(r112, "moduleId");
        Intrinsics.checkNotNullParameter(r113, "componentId");
        Intrinsics.checkNotNullParameter(r114, "resourceId");
        Intrinsics.checkNotNullParameter(r115, "moduleKey");
        Intrinsics.checkNotNullParameter(r116, "componentKey");
        Intrinsics.checkNotNullParameter(r117, "resourceKey");
        return new CommonEnterFromParams(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonEnterFromParams) == false) goto L24;
        CommonEnterFromParams r101 = (CommonEnterFromParams) r100;
        if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.moduleKey, r101.moduleKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.componentKey, r101.componentKey) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.resourceKey, r101.resourceKey) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.order, r101.order) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        String r100 = this.previousPage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.moduleId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.componentId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.resourceId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.moduleKey;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.componentKey;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.resourceKey;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.order;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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

    public String toString() {
        return "CommonEnterFromParams(previousPage=" + this.previousPage + ", pageName=" + this.pageName + ", moduleId=" + this.moduleId + ", componentId=" + this.componentId + ", resourceId=" + this.resourceId + ", moduleKey=" + this.moduleKey + ", componentKey=" + this.componentKey + ", resourceKey=" + this.resourceKey + ", order=" + this.order + ")";
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final String getComponentKey() {
        return this.componentKey;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getModuleKey() {
        return this.moduleKey;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getResourceKey() {
        return this.resourceKey;
    }

    public CommonEnterFromParams(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "previousPage");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "moduleId");
        Intrinsics.checkNotNullParameter(r103, "componentId");
        Intrinsics.checkNotNullParameter(r104, "resourceId");
        Intrinsics.checkNotNullParameter(r105, "moduleKey");
        Intrinsics.checkNotNullParameter(r106, "componentKey");
        Intrinsics.checkNotNullParameter(r107, "resourceKey");
        this.previousPage = r100;
        this.pageName = r101;
        this.moduleId = r102;
        this.componentId = r103;
        this.resourceId = r104;
        this.moduleKey = r105;
        this.componentKey = r106;
        this.resourceKey = r107;
        this.order = r110;
    }

    public /* synthetic */ CommonEnterFromParams(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, Integer r118, int r119, DefaultConstructorMarker r210) {
        String r100 = "null";
        if ((r119 & 1) == 0) goto L5;
        String r101 = "null";
    L7:
        if ((r119 & 2) == 0) goto L9;
        String r102 = "null";
    L11:
        if ((r119 & 4) == 0) goto L13;
        String r103 = "null";
    L15:
        if ((r119 & 8) == 0) goto L17;
        String r104 = "null";
    L19:
        if ((r119 & 16) != 0) goto L23;
        r100 = r114;
    L23:
        if ((r119 & 32) == 0) goto L25;
        String r105 = EventConstant.Key.MODULE;
    L27:
        if ((r119 & 64) == 0) goto L29;
        String r106 = "component";
    L31:
        if ((r119 & 128) == 0) goto L33;
        String r107 = "resource";
    L35:
        if ((r119 & 256) == 0) goto L37;
        Integer r108 = null;
    L38:
        this(r101, r102, r103, r104, r100, r105, r106, r107, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
