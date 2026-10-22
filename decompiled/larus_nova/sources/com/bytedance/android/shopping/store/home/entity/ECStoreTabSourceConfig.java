package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreTabSourceConfig;", "Ljava/io/Serializable;", "", "sourceProductId", "Ljava/lang/String;", "getSourceProductId", "()Ljava/lang/String;", "setSourceProductId", "(Ljava/lang/String;)V", "", "customIdType", "Ljava/lang/Integer;", "getCustomIdType", "()Ljava/lang/Integer;", "setCustomIdType", "(Ljava/lang/Integer;)V", "customIds", "getCustomIds", "setCustomIds", "activeTabType", "getActiveTabType", "setActiveTabType", "activeSortType", "getActiveSortType", "setActiveSortType", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "activatePickType", "I", "getActivatePickType", "()I", "setActivatePickType", "(I)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreTabSourceConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("activate_pick_type")
    private int activatePickType;

    @SerializedName("activate_sort_type")
    private Integer activeSortType;

    @SerializedName("activate_tab_type")
    private Integer activeTabType;

    @SerializedName("custom_id_type")
    private Integer customIdType;

    @SerializedName("custom_ids")
    private String customIds;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION)
    private String entranceLocation;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PRODUCT_ID)
    private String sourceProductId;

    @SerializedName("pre_store_group_type")
    private String storeGroupType;

    @SerializedName("pre_store_source_page")
    private String storeSourcePage;

    public static final class a {
        public a() {
        }

        public static ECStoreTabSourceConfig a(ECStoreParam r100) {
            Intrinsics.checkNotNullParameter(r100, "storeParam");
            ECStoreTabSourceConfig r101 = new ECStoreTabSourceConfig();
            r101.setSourceProductId(r100.getStoreNaviParam().getSourceProductId());
            r101.setCustomIdType(r100.getProductBasicRequestParam().getCustomIdType());
            r101.setCustomIds(r100.getProductBasicRequestParam().getCustomIds());
            r101.setActiveTabType(r100.getTabId());
            r101.setActiveSortType(r100.getSortType());
            r101.setEntranceLocation(r100.getEntranceLocation());
            r101.setStoreSourcePage(r100.getStoreSourcePage());
            r101.setStoreGroupType(r100.getStoreGroupType());
            Integer r102 = r100.getPickType();
            if (r102 == null) goto L5;
            int r103 = r102.intValue();
        L6:
            r101.setActivatePickType(r103);
            return r101;
        L5:
            r103 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreTabSourceConfig() {
    }

    public final int getActivatePickType() {
        return this.activatePickType;
    }

    public final Integer getActiveSortType() {
        return this.activeSortType;
    }

    public final Integer getActiveTabType() {
        return this.activeTabType;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final String getSourceProductId() {
        return this.sourceProductId;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final void setActivatePickType(int r100) {
        this.activatePickType = r100;
    }

    public final void setActiveSortType(Integer r100) {
        this.activeSortType = r100;
    }

    public final void setActiveTabType(Integer r100) {
        this.activeTabType = r100;
    }

    public final void setCustomIdType(Integer r100) {
        this.customIdType = r100;
    }

    public final void setCustomIds(String r100) {
        this.customIds = r100;
    }

    public final void setEntranceLocation(String r100) {
        this.entranceLocation = r100;
    }

    public final void setSourceProductId(String r100) {
        this.sourceProductId = r100;
    }

    public final void setStoreGroupType(String r100) {
        this.storeGroupType = r100;
    }

    public final void setStoreSourcePage(String r100) {
        this.storeSourcePage = r100;
    }
}
