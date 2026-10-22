package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/AuthorReputationVO;", "Ljava/io/Serializable;", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "Ljava/lang/Double;", "getScore", "()Ljava/lang/Double;", "setScore", "(Ljava/lang/Double;)V", "", SalesInfoStruct.SALES, "Ljava/lang/String;", "getSales", "()Ljava/lang/String;", "setSales", "(Ljava/lang/String;)V", "", "isStore", "Z", "()Z", "setStore", "(Z)V", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "brandImgList", "Ljava/util/List;", "getBrandImgList", "()Ljava/util/List;", "setBrandImgList", "(Ljava/util/List;)V", "showSales", "getShowSales", "setShowSales", "scoreNormalText", "getScoreNormalText", "setScoreNormalText", "shopTypeDescription", "getShopTypeDescription", "setShopTypeDescription", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuthorReputationVO implements Serializable {
    public static final a Companion = null;
    private List<? extends ECUrlModel> brandImgList;
    private boolean isStore;
    private String sales;
    private Double score;
    private String scoreNormalText;
    private String shopTypeDescription;
    private boolean showSales;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AuthorReputationVO() {
        this.isStore = true;
        this.showSales = true;
    }

    public final List<ECUrlModel> getBrandImgList() {
        return this.brandImgList;
    }

    public final String getSales() {
        return this.sales;
    }

    public final Double getScore() {
        return this.score;
    }

    public final String getScoreNormalText() {
        return this.scoreNormalText;
    }

    public final String getShopTypeDescription() {
        return this.shopTypeDescription;
    }

    public final boolean getShowSales() {
        return this.showSales;
    }

    public final boolean isStore() {
        return this.isStore;
    }

    public final void setBrandImgList(List<? extends ECUrlModel> r100) {
        this.brandImgList = r100;
    }

    public final void setSales(String r100) {
        this.sales = r100;
    }

    public final void setScore(Double r100) {
        this.score = r100;
    }

    public final void setScoreNormalText(String r100) {
        this.scoreNormalText = r100;
    }

    public final void setShopTypeDescription(String r100) {
        this.shopTypeDescription = r100;
    }

    public final void setShowSales(boolean r100) {
        this.showSales = r100;
    }

    public final void setStore(boolean r100) {
        this.isStore = r100;
    }
}
