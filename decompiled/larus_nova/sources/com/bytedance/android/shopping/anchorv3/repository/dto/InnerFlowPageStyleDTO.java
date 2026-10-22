package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/InnerFlowPageStyleDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PageStyle;", "pageStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PageStyle;", "getPageStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/PageStyle;", "setPageStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/PageStyle;)V", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/MainCardStyle;", "mainCardStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/MainCardStyle;", "getMainCardStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/MainCardStyle;", "setMainCardStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/MainCardStyle;)V", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/FeedCardStyle;", "feedCardStyle", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/FeedCardStyle;", "getFeedCardStyle", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/FeedCardStyle;", "setFeedCardStyle", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/FeedCardStyle;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerFlowPageStyleDTO implements Serializable {
    public static final a Companion = null;
    public static final int INNER_FLOW_PAGE_NEW_STYLE = 1;

    @SerializedName("feed_card_style")
    private FeedCardStyle feedCardStyle;

    @SerializedName("main_card_style")
    private MainCardStyle mainCardStyle;

    @SerializedName("page_style")
    private PageStyle pageStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public InnerFlowPageStyleDTO() {
    }

    public final FeedCardStyle getFeedCardStyle() {
        return this.feedCardStyle;
    }

    public final MainCardStyle getMainCardStyle() {
        return this.mainCardStyle;
    }

    public final PageStyle getPageStyle() {
        return this.pageStyle;
    }

    public final void setFeedCardStyle(FeedCardStyle r100) {
        this.feedCardStyle = r100;
    }

    public final void setMainCardStyle(MainCardStyle r100) {
        this.mainCardStyle = r100;
    }

    public final void setPageStyle(PageStyle r100) {
        this.pageStyle = r100;
    }
}
