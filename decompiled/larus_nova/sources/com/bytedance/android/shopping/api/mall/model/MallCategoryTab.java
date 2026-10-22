package com.bytedance.android.shopping.api.mall.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016¢\u0006\u0002\u0010\u001eJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010C\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00107J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010I\u001a\u00020\u0016HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104Jö\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00162\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u000bHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u001d\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010-\"\u0004\b.\u0010/R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b;\u00104R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b=\u00104R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"¨\u0006X"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTab;", "", "moduleId", "", "componentId", "tabId", "dockedId", "name", "title", "link", "tabType", "", "nativeContainerType", "iconConf", "Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", GXTemplateKey.GAIAX_ANIMATION, "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "tabContainerType", "customizedMallBgSkin", "Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "btmCode", "pageDisableRefresh", "", "supportResource", "", "guideIcon", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "guide", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;", "isCacheData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/TabIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;Z)V", "getAnimation", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "getBtmCode", "()Ljava/lang/String;", "getComponentId", "getCustomizedMallBgSkin", "()Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "getDockedId", "getGuide", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;", "getGuideIcon", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "getIconConf", "()Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "()Z", "setCacheData", "(Z)V", "getLink", "getModuleId", "getName", "getNativeContainerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageDisableRefresh", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSupportResource", "()Ljava/util/List;", "getTabContainerType", "getTabId", "getTabType", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/TabIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;Z)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTab;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTab {

    @SerializedName(GXTemplateKey.GAIAX_ANIMATION)
    private final MallCategoryTabAnimation animation;

    @SerializedName("btm_code")
    private final String btmCode;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("customized_mall_bg_skin")
    private final CustomizedMallBgSkin customizedMallBgSkin;

    @SerializedName("docked_id")
    private final String dockedId;

    @SerializedName("bubble")
    private final MallCategoryTabBubble guide;

    @SerializedName("guide_icon")
    private final MallCategoryTabGuideIcon guideIcon;

    @SerializedName("icon_conf")
    private final TabIcon iconConf;
    private boolean isCacheData;

    @SerializedName("link")
    private final String link;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("native_container_type")
    private final Integer nativeContainerType;

    @SerializedName("page_disable_refresh")
    private final Boolean pageDisableRefresh;

    @SerializedName("support_resource")
    private final List<Integer> supportResource;

    @SerializedName("tab_container_type")
    private final Integer tabContainerType;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("tab_type")
    private final Integer tabType;

    @SerializedName("title")
    private final String title;

    public MallCategoryTab() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallCategoryTab copy$default(MallCategoryTab r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, Integer r215, Integer r216, TabIcon r217, MallCategoryTabAnimation r218, Integer r219, CustomizedMallBgSkin r310, String r311, Boolean r312, List r313, MallCategoryTabGuideIcon r314, MallCategoryTabBubble r315, boolean r316, int r317, Object r318) {
        if ((r317 & 1) == 0) goto L5;
        String r100 = r110.moduleId;
    L7:
        if ((r317 & 2) == 0) goto L9;
        String r101 = r110.componentId;
    L11:
        if ((r317 & 4) == 0) goto L13;
        String r102 = r110.tabId;
    L15:
        if ((r317 & 8) == 0) goto L17;
        String r103 = r110.dockedId;
    L19:
        if ((r317 & 16) == 0) goto L21;
        String r104 = r110.name;
    L23:
        if ((r317 & 32) == 0) goto L25;
        String r105 = r110.title;
    L27:
        if ((r317 & 64) == 0) goto L29;
        String r106 = r110.link;
    L31:
        if ((r317 & 128) == 0) goto L33;
        Integer r107 = r110.tabType;
    L35:
        if ((r317 & 256) == 0) goto L37;
        Integer r113 = r110.nativeContainerType;
    L39:
        if ((r317 & 512) == 0) goto L41;
        TabIcon r114 = r110.iconConf;
    L43:
        if ((r317 & 1024) == 0) goto L45;
        MallCategoryTabAnimation r115 = r110.animation;
    L47:
        if ((r317 & 2048) == 0) goto L49;
        Integer r116 = r110.tabContainerType;
    L51:
        if ((r317 & 4096) == 0) goto L53;
        CustomizedMallBgSkin r117 = r110.customizedMallBgSkin;
    L55:
        if ((r317 & 8192) == 0) goto L57;
        String r118 = r110.btmCode;
    L58:
        String r319 = r118;
        if ((r317 & 16384) == 0) goto L61;
        Boolean r119 = r110.pageDisableRefresh;
    L62:
        Boolean r320 = r119;
        if ((r317 & 32768) == 0) goto L65;
        List r120 = r110.supportResource;
    L66:
        List r321 = r120;
        if ((r317 & 65536) == 0) goto L69;
        MallCategoryTabGuideIcon r121 = r110.guideIcon;
    L70:
        MallCategoryTabGuideIcon r322 = r121;
        if ((r317 & 131072) == 0) goto L73;
        MallCategoryTabBubble r122 = r110.guide;
    L75:
        if ((r317 & 262144) == 0) goto L77;
        boolean r108 = r110.isCacheData;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
    L77:
        r108 = r316;
        goto L79
    L73:
        r122 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.moduleId;
    }

    public final TabIcon component10() {
        return this.iconConf;
    }

    public final MallCategoryTabAnimation component11() {
        return this.animation;
    }

    public final Integer component12() {
        return this.tabContainerType;
    }

    public final CustomizedMallBgSkin component13() {
        return this.customizedMallBgSkin;
    }

    public final String component14() {
        return this.btmCode;
    }

    public final Boolean component15() {
        return this.pageDisableRefresh;
    }

    public final List<Integer> component16() {
        return this.supportResource;
    }

    public final MallCategoryTabGuideIcon component17() {
        return this.guideIcon;
    }

    public final MallCategoryTabBubble component18() {
        return this.guide;
    }

    public final boolean component19() {
        return this.isCacheData;
    }

    public final String component2() {
        return this.componentId;
    }

    public final String component3() {
        return this.tabId;
    }

    public final String component4() {
        return this.dockedId;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.link;
    }

    public final Integer component8() {
        return this.tabType;
    }

    public final Integer component9() {
        return this.nativeContainerType;
    }

    public final MallCategoryTab copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, Integer r217, Integer r310, TabIcon r311, MallCategoryTabAnimation r312, Integer r313, CustomizedMallBgSkin r314, String r315, Boolean r316, List<Integer> r317, MallCategoryTabGuideIcon r318, MallCategoryTabBubble r319, boolean r410) {
        return new MallCategoryTab(r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallCategoryTab) == false) goto L44;
        MallCategoryTab r101 = (MallCategoryTab) r100;
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dockedId, r101.dockedId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.nativeContainerType, r101.nativeContainerType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconConf, r101.iconConf) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.animation, r101.animation) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.tabContainerType, r101.tabContainerType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.customizedMallBgSkin, r101.customizedMallBgSkin) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.btmCode, r101.btmCode) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pageDisableRefresh, r101.pageDisableRefresh) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.supportResource, r101.supportResource) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.guideIcon, r101.guideIcon) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.guide, r101.guide) == true) goto L42;
        return false;
    L42:
        if (this.isCacheData == r101.isCacheData) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r100 = this.moduleId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.tabId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.dockedId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.name;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.title;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.link;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.tabType;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.nativeContainerType;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        TabIcon r128 = this.iconConf;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        MallCategoryTabAnimation r131 = this.animation;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.tabContainerType;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        CustomizedMallBgSkin r137 = this.customizedMallBgSkin;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.btmCode;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.pageDisableRefresh;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        List<Integer> r146 = this.supportResource;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        MallCategoryTabGuideIcon r149 = this.guideIcon;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        MallCategoryTabBubble r152 = this.guide;
        if (r152 == null) goto L73;
        r101 = r152.hashCode();
    L73:
        int r153 = (r151 + r101) * 31;
        boolean r154 = this.isCacheData;
        ?? r155 = r154;
        if (r154 == false) goto L77;
        r155 = 1;
    L77:
        return r153 + r155;
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
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

    public String toString() {
        return "MallCategoryTab(moduleId=" + this.moduleId + ", componentId=" + this.componentId + ", tabId=" + this.tabId + ", dockedId=" + this.dockedId + ", name=" + this.name + ", title=" + this.title + ", link=" + this.link + ", tabType=" + this.tabType + ", nativeContainerType=" + this.nativeContainerType + ", iconConf=" + this.iconConf + ", animation=" + this.animation + ", tabContainerType=" + this.tabContainerType + ", customizedMallBgSkin=" + this.customizedMallBgSkin + ", btmCode=" + this.btmCode + ", pageDisableRefresh=" + this.pageDisableRefresh + ", supportResource=" + this.supportResource + ", guideIcon=" + this.guideIcon + ", guide=" + this.guide + ", isCacheData=" + this.isCacheData + ")";
    }

    public final MallCategoryTabAnimation getAnimation() {
        return this.animation;
    }

    public final String getBtmCode() {
        return this.btmCode;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final CustomizedMallBgSkin getCustomizedMallBgSkin() {
        return this.customizedMallBgSkin;
    }

    public final String getDockedId() {
        return this.dockedId;
    }

    public final MallCategoryTabBubble getGuide() {
        return this.guide;
    }

    public final MallCategoryTabGuideIcon getGuideIcon() {
        return this.guideIcon;
    }

    public final TabIcon getIconConf() {
        return this.iconConf;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getNativeContainerType() {
        return this.nativeContainerType;
    }

    public final Boolean getPageDisableRefresh() {
        return this.pageDisableRefresh;
    }

    public final List<Integer> getSupportResource() {
        return this.supportResource;
    }

    public final Integer getTabContainerType() {
        return this.tabContainerType;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }

    public final void setCacheData(boolean r100) {
        this.isCacheData = r100;
    }

    public MallCategoryTab(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r110, Integer r111, TabIcon r112, MallCategoryTabAnimation r113, Integer r114, CustomizedMallBgSkin r115, String r116, Boolean r117, List<Integer> r118, MallCategoryTabGuideIcon r119, MallCategoryTabBubble r210, boolean r211) {
        this.moduleId = r100;
        this.componentId = r101;
        this.tabId = r102;
        this.dockedId = r103;
        this.name = r104;
        this.title = r105;
        this.link = r106;
        this.tabType = r110;
        this.nativeContainerType = r111;
        this.iconConf = r112;
        this.animation = r113;
        this.tabContainerType = r114;
        this.customizedMallBgSkin = r115;
        this.btmCode = r116;
        this.pageDisableRefresh = r117;
        this.supportResource = r118;
        this.guideIcon = r119;
        this.guide = r210;
        this.isCacheData = r211;
    }

    public /* synthetic */ MallCategoryTab(String r210, String r211, String r212, String r213, String r214, String r215, String r216, Integer r217, Integer r218, TabIcon r310, MallCategoryTabAnimation r311, Integer r312, CustomizedMallBgSkin r313, String r314, Boolean r315, List r316, MallCategoryTabGuideIcon r317, MallCategoryTabBubble r318, boolean r319, int r410, DefaultConstructorMarker r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r410 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r410 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Integer r107 = null;
    L35:
        if ((r410 & 256) == 0) goto L37;
        Integer r110 = null;
    L39:
        if ((r410 & 512) == 0) goto L41;
        TabIcon r111 = null;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        MallCategoryTabAnimation r112 = null;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Integer r113 = null;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        CustomizedMallBgSkin r114 = null;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r410 & 16384) == 0) goto L61;
        Boolean r108 = null;
    L63:
        if ((r410 & 32768) == 0) goto L65;
        List r116 = null;
    L67:
        if ((r410 & 65536) == 0) goto L69;
        MallCategoryTabGuideIcon r117 = null;
    L71:
        if ((r410 & 131072) == 0) goto L73;
        MallCategoryTabBubble r118 = null;
    L75:
        if ((r410 & 262144) == 0) goto L77;
        boolean r109 = false;
    L78:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r109);
        return;
    L77:
        r109 = r319;
        goto L78
    L73:
        r118 = r318;
        goto L75
    L69:
        r117 = r317;
        goto L71
    L65:
        r116 = r316;
        goto L67
    L61:
        r108 = r315;
        goto L63
    L57:
        r115 = r314;
        goto L59
    L53:
        r114 = r313;
        goto L55
    L49:
        r113 = r312;
        goto L51
    L45:
        r112 = r311;
        goto L47
    L41:
        r111 = r310;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
