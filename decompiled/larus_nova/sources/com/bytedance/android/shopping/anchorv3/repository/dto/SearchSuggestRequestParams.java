package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aBO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/SearchSuggestRequestParams;", "Ljava/io/Serializable;", "", "businessId", "Ljava/lang/String;", "getBusinessId", "()Ljava/lang/String;", "setBusinessId", "(Ljava/lang/String;)V", "pd", "getPd", "setPd", "categoryName", "getCategoryName", "setCategoryName", "wordSource", "getWordSource", "setWordSource", "promotionId", "getPromotionId", "setPromotionId", "penetrateParams", "getPenetrateParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestRequestParams implements Serializable {
    public static final String BUSINESS_ID = "30030";
    public static final String CATEGORY_NAME = "search_product_detail";
    public static final a Companion = null;
    public static final String HALF_BUSINESS_ID = "90118";
    public static final String PD = "search_product_detail";
    public static final String RELATED_CHANNEL_SOURCE = "related_channel_source";
    public static final String WORD_SOURCE = "search_product_detail";
    private String businessId;
    private String categoryName;

    /* JADX INFO: renamed from: pd, reason: collision with root package name */
    private String f165275pd;
    private final String penetrateParams;
    private String promotionId;
    private String wordSource;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SearchSuggestRequestParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getPd() {
        return this.f165275pd;
    }

    public final String getPenetrateParams() {
        return this.penetrateParams;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getWordSource() {
        return this.wordSource;
    }

    public final void setBusinessId(String r100) {
        this.businessId = r100;
    }

    public final void setCategoryName(String r100) {
        this.categoryName = r100;
    }

    public final void setPd(String r100) {
        this.f165275pd = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setWordSource(String r100) {
        this.wordSource = r100;
    }

    public SearchSuggestRequestParams(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.businessId = r100;
        this.f165275pd = r101;
        this.categoryName = r102;
        this.wordSource = r103;
        this.promotionId = r104;
        this.penetrateParams = r105;
    }

    public /* synthetic */ SearchSuggestRequestParams(String r100, String r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
