package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u00010B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008f\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO;", "", "title", "", "name", "darkIcon", "link", IAllianceService.CONTENT_TYPE_BADGE, "corner", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "moduleId", "componentId", "resourceId", "cornerExtra", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBadge", "()Ljava/lang/String;", "getComponentId", "getCorner", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "setCorner", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;)V", "getCornerExtra", "()Ljava/util/Map;", "getDarkIcon", "getLink", "getModuleId", "getName", "getResourceId", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Corner", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolVO {

    @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
    private final String badge;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("corner")
    private Corner corner;

    @SerializedName("corner_extra")
    private final Map<String, String> cornerExtra;

    @SerializedName("dark_icon")
    private final String darkIcon;

    @SerializedName("link")
    private final String link;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("title")
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/ToolVO$Corner;", "", "type", "", "text", "skipUrl", "skipCartId", "freq", "canShow", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCanShow", "()Z", "setCanShow", "(Z)V", "getFreq", "()Ljava/lang/String;", "setFreq", "(Ljava/lang/String;)V", "getSkipCartId", "getSkipUrl", "getText", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Corner {
        private boolean canShow;

        @SerializedName("freq")
        private String freq;

        @SerializedName("skip_cart_id")
        private final String skipCartId;

        @SerializedName("skip_url")
        private final String skipUrl;

        @SerializedName("text")
        private final String text;

        @SerializedName("type")
        private final String type;

        public Corner() {
            this(null, null, null, null, null, false, 63, null);
        }

        public static /* synthetic */ Corner copy$default(Corner r100, String r101, String r102, String r103, String r104, String r105, boolean r110, int r111, Object r112) {
            if ((r111 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            if ((r111 & 2) == 0) goto L8;
            r102 = r100.text;
        L8:
            String r113 = r102;
            if ((r111 & 4) == 0) goto L11;
            r103 = r100.skipUrl;
        L11:
            String r106 = r103;
            if ((r111 & 8) == 0) goto L14;
            r104 = r100.skipCartId;
        L14:
            String r107 = r104;
            if ((r111 & 16) == 0) goto L17;
            r105 = r100.freq;
        L17:
            String r108 = r105;
            if ((r111 & 32) == 0) goto L20;
            r110 = r100.canShow;
        L20:
            String r109 = r101;
            return r100.copy(r109, r113, r106, r107, r108, r110);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.text;
        }

        public final String component3() {
            return this.skipUrl;
        }

        public final String component4() {
            return this.skipCartId;
        }

        public final String component5() {
            return this.freq;
        }

        public final boolean component6() {
            return this.canShow;
        }

        public final Corner copy(String r100, String r110, String r111, String r112, String r113, boolean r114) {
            return new Corner(r100, r110, r111, r112, r113, r114);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Corner) == false) goto L18;
            Corner r101 = (Corner) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.skipUrl, r101.skipUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.skipCartId, r101.skipCartId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.freq, r101.freq) == true) goto L16;
            return false;
        L16:
            if (this.canShow == r101.canShow) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.text;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.skipUrl;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.skipCartId;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.freq;
            if (r113 == null) goto L21;
            r101 = r113.hashCode();
        L21:
            int r114 = (r112 + r101) * 31;
            boolean r115 = this.canShow;
            ?? r116 = r115;
            if (r115 == false) goto L25;
            r116 = 1;
        L25:
            return r114 + r116;
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
            return "Corner(type=" + this.type + ", text=" + this.text + ", skipUrl=" + this.skipUrl + ", skipCartId=" + this.skipCartId + ", freq=" + this.freq + ", canShow=" + this.canShow + ")";
        }

        public final boolean getCanShow() {
            return this.canShow;
        }

        public final String getFreq() {
            return this.freq;
        }

        public final String getSkipCartId() {
            return this.skipCartId;
        }

        public final String getSkipUrl() {
            return this.skipUrl;
        }

        public final String getText() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public final void setCanShow(boolean r100) {
            this.canShow = r100;
        }

        public final void setFreq(String r100) {
            this.freq = r100;
        }

        public Corner(String r100, String r101, String r102, String r103, String r104, boolean r105) {
            this.type = r100;
            this.text = r101;
            this.skipUrl = r102;
            this.skipCartId = r103;
            this.freq = r104;
            this.canShow = r105;
        }

        public /* synthetic */ Corner(String r100, String r101, String r102, String r103, String r104, boolean r110, int r111, DefaultConstructorMarker r112) {
            String r105 = null;
            if ((r111 & 1) == 0) goto L5;
            String r113 = null;
        L7:
            if ((r111 & 2) == 0) goto L9;
            String r106 = null;
        L11:
            if ((r111 & 4) == 0) goto L13;
            String r107 = null;
        L15:
            if ((r111 & 8) == 0) goto L17;
            String r108 = null;
        L19:
            if ((r111 & 16) != 0) goto L23;
            r105 = r104;
        L23:
            if ((r111 & 32) == 0) goto L25;
            boolean r114 = true;
        L26:
            this(r113, r106, r107, r108, r105, r114);
            return;
        L25:
            r114 = r110;
            goto L26
        L17:
            r108 = r103;
            goto L19
        L13:
            r107 = r102;
            goto L15
        L9:
            r106 = r101;
            goto L11
        L5:
            r113 = r100;
            goto L7
        }
    }

    public ToolVO() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolVO copy$default(ToolVO r110, String r111, String r112, String r113, String r114, String r115, Corner r116, String r117, String r118, String r210, Map r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.darkIcon;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.link;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.badge;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Corner r105 = r110.corner;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.moduleId;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.componentId;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.resourceId;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Map r108 = r110.cornerExtra;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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
        return this.title;
    }

    public final Map<String, String> component10() {
        return this.cornerExtra;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.darkIcon;
    }

    public final String component4() {
        return this.link;
    }

    public final String component5() {
        return this.badge;
    }

    public final Corner component6() {
        return this.corner;
    }

    public final String component7() {
        return this.moduleId;
    }

    public final String component8() {
        return this.componentId;
    }

    public final String component9() {
        return this.resourceId;
    }

    public final ToolVO copy(String r110, String r111, String r112, String r113, String r114, Corner r115, String r116, String r210, String r211, Map<String, String> r212) {
        return new ToolVO(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ToolVO) == false) goto L26;
        ToolVO r101 = (ToolVO) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.darkIcon, r101.darkIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.badge, r101.badge) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.corner, r101.corner) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moduleId, r101.moduleId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cornerExtra, r101.cornerExtra) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.darkIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.link;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.badge;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Corner r116 = this.corner;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.moduleId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.componentId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.resourceId;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.cornerExtra;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "ToolVO(title=" + this.title + ", name=" + this.name + ", darkIcon=" + this.darkIcon + ", link=" + this.link + ", badge=" + this.badge + ", corner=" + this.corner + ", moduleId=" + this.moduleId + ", componentId=" + this.componentId + ", resourceId=" + this.resourceId + ", cornerExtra=" + this.cornerExtra + ")";
    }

    public final String getBadge() {
        return this.badge;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final Corner getCorner() {
        return this.corner;
    }

    public final Map<String, String> getCornerExtra() {
        return this.cornerExtra;
    }

    public final String getDarkIcon() {
        return this.darkIcon;
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

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setCorner(Corner r100) {
        this.corner = r100;
    }

    public ToolVO(String r100, String r101, String r102, String r103, String r104, Corner r105, String r106, String r107, String r108, Map<String, String> r110) {
        this.title = r100;
        this.name = r101;
        this.darkIcon = r102;
        this.link = r103;
        this.badge = r104;
        this.corner = r105;
        this.moduleId = r106;
        this.componentId = r107;
        this.resourceId = r108;
        this.cornerExtra = r110;
    }

    public /* synthetic */ ToolVO(String r110, String r111, String r112, String r113, String r114, Corner r115, String r116, String r117, String r210, Map r211, int r212, DefaultConstructorMarker r213) {
        Map r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Corner r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
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
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
