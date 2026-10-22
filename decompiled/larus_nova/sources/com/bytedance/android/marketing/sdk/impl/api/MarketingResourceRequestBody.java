package com.bytedance.android.marketing.sdk.impl.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody;", "", "commonCtx", "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$CommonCtx;", "isSdkRequest", "", "extraInfo", "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$ExtraInfo;", "storage", "", "(Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$CommonCtx;ILcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$ExtraInfo;Ljava/lang/String;)V", "getCommonCtx", "()Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$CommonCtx;", "getExtraInfo", "()Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$ExtraInfo;", "()I", "getStorage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonCtx", "ExtraInfo", "SceneInfo", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingResourceRequestBody {

    @SerializedName("CommonCtx")
    private final CommonCtx commonCtx;

    @SerializedName("extra_info")
    private final ExtraInfo extraInfo;

    @SerializedName("is_sdk_request")
    private final int isSdkRequest;

    @SerializedName("storage")
    private final String storage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$CommonCtx;", "", "sceneInfo", "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$SceneInfo;", "(Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$SceneInfo;)V", "getSceneInfo", "()Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$SceneInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommonCtx {

        @SerializedName("scene_info")
        private final SceneInfo sceneInfo;

        public static /* synthetic */ CommonCtx copy$default(CommonCtx r100, SceneInfo r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.sceneInfo;
        L6:
            return r100.copy(r101);
        }

        public final SceneInfo component1() {
            return this.sceneInfo;
        }

        public final CommonCtx copy(SceneInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "sceneInfo");
            return new CommonCtx(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof CommonCtx) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.sceneInfo, ((CommonCtx) r100).sceneInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            SceneInfo r100 = this.sceneInfo;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "CommonCtx(sceneInfo=" + this.sceneInfo + ")";
        }

        public final SceneInfo getSceneInfo() {
            return this.sceneInfo;
        }

        public CommonCtx(SceneInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "sceneInfo");
            this.sceneInfo = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$ExtraInfo;", "", "ecMarketingOhrInfo", "", "passThroughMarketingInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "getEcMarketingOhrInfo", "()Ljava/lang/String;", "getPassThroughMarketingInfo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ExtraInfo {

        @SerializedName("ec_marketing_ohr_info")
        private final String ecMarketingOhrInfo;

        @SerializedName("pass_through_marketing_info")
        private final String passThroughMarketingInfo;

        public static /* synthetic */ ExtraInfo copy$default(ExtraInfo r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.ecMarketingOhrInfo;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.passThroughMarketingInfo;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.ecMarketingOhrInfo;
        }

        public final String component2() {
            return this.passThroughMarketingInfo;
        }

        public final ExtraInfo copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "ecMarketingOhrInfo");
            Intrinsics.checkNotNullParameter(r101, "passThroughMarketingInfo");
            return new ExtraInfo(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ExtraInfo) == false) goto L10;
            ExtraInfo r101 = (ExtraInfo) r100;
            if (Intrinsics.areEqual(this.ecMarketingOhrInfo, r101.ecMarketingOhrInfo) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.passThroughMarketingInfo, r101.passThroughMarketingInfo) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.ecMarketingOhrInfo;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.passThroughMarketingInfo;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "ExtraInfo(ecMarketingOhrInfo=" + this.ecMarketingOhrInfo + ", passThroughMarketingInfo=" + this.passThroughMarketingInfo + ")";
        }

        public final String getEcMarketingOhrInfo() {
            return this.ecMarketingOhrInfo;
        }

        public final String getPassThroughMarketingInfo() {
            return this.passThroughMarketingInfo;
        }

        public ExtraInfo(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "ecMarketingOhrInfo");
            Intrinsics.checkNotNullParameter(r101, "passThroughMarketingInfo");
            this.ecMarketingOhrInfo = r100;
            this.passThroughMarketingInfo = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody$SceneInfo;", "", "scene", "", "sceneId", "", "resourceSlots", "", "enterFrom", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getEnterFrom", "()Ljava/lang/String;", "getResourceSlots", "()Ljava/util/List;", "getScene", "()I", "getSceneId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SceneInfo {

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("resource_slots")
        private final List<String> resourceSlots;

        @SerializedName("scene")
        private final int scene;

        @SerializedName("scene_id")
        private final String sceneId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SceneInfo copy$default(SceneInfo r100, int r101, String r102, List r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.scene;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.sceneId;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.resourceSlots;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.enterFrom;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.scene;
        }

        public final String component2() {
            return this.sceneId;
        }

        public final List<String> component3() {
            return this.resourceSlots;
        }

        public final String component4() {
            return this.enterFrom;
        }

        public final SceneInfo copy(int r100, String r101, List<String> r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "sceneId");
            Intrinsics.checkNotNullParameter(r102, "resourceSlots");
            Intrinsics.checkNotNullParameter(r103, "enterFrom");
            return new SceneInfo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof SceneInfo) == false) goto L14;
            SceneInfo r101 = (SceneInfo) r100;
            if (this.scene == r101.scene) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.sceneId, r101.sceneId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.resourceSlots, r101.resourceSlots) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r100 = this.scene * 31;
            String r101 = this.sceneId;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.resourceSlots;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.enterFrom;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            return r107 + r102;
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "SceneInfo(scene=" + this.scene + ", sceneId=" + this.sceneId + ", resourceSlots=" + this.resourceSlots + ", enterFrom=" + this.enterFrom + ")";
        }

        public final String getEnterFrom() {
            return this.enterFrom;
        }

        public final List<String> getResourceSlots() {
            return this.resourceSlots;
        }

        public final int getScene() {
            return this.scene;
        }

        public final String getSceneId() {
            return this.sceneId;
        }

        public SceneInfo(int r100, String r101, List<String> r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "sceneId");
            Intrinsics.checkNotNullParameter(r102, "resourceSlots");
            Intrinsics.checkNotNullParameter(r103, "enterFrom");
            this.scene = r100;
            this.sceneId = r101;
            this.resourceSlots = r102;
            this.enterFrom = r103;
        }
    }

    public static /* synthetic */ MarketingResourceRequestBody copy$default(MarketingResourceRequestBody r100, CommonCtx r101, int r102, ExtraInfo r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.commonCtx;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isSdkRequest;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.extraInfo;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.storage;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final CommonCtx component1() {
        return this.commonCtx;
    }

    public final int component2() {
        return this.isSdkRequest;
    }

    public final ExtraInfo component3() {
        return this.extraInfo;
    }

    public final String component4() {
        return this.storage;
    }

    public final MarketingResourceRequestBody copy(CommonCtx r100, int r101, ExtraInfo r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "commonCtx");
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        Intrinsics.checkNotNullParameter(r103, "storage");
        return new MarketingResourceRequestBody(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MarketingResourceRequestBody) == false) goto L14;
        MarketingResourceRequestBody r101 = (MarketingResourceRequestBody) r100;
        if (Intrinsics.areEqual(this.commonCtx, r101.commonCtx) == true) goto L8;
        return false;
    L8:
        if (this.isSdkRequest == r101.isSdkRequest) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storage, r101.storage) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        CommonCtx r100 = this.commonCtx;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.isSdkRequest) * 31;
        ExtraInfo r104 = this.extraInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.storage;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MarketingResourceRequestBody(commonCtx=" + this.commonCtx + ", isSdkRequest=" + this.isSdkRequest + ", extraInfo=" + this.extraInfo + ", storage=" + this.storage + ")";
    }

    public final CommonCtx getCommonCtx() {
        return this.commonCtx;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final String getStorage() {
        return this.storage;
    }

    public final int isSdkRequest() {
        return this.isSdkRequest;
    }

    public MarketingResourceRequestBody(CommonCtx r100, int r101, ExtraInfo r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "commonCtx");
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        Intrinsics.checkNotNullParameter(r103, "storage");
        this.commonCtx = r100;
        this.isSdkRequest = r101;
        this.extraInfo = r102;
        this.storage = r103;
    }
}
