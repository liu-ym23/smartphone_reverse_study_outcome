package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCustomButtonStruct;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "links", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "getLinks", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "icon", "getIcon", "background", "getBackground", "textColor", "getTextColor", "style", "getStyle", "", "isShowCommentCounts", "Z", "()Z", "setShowCommentCounts", "(Z)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionCustomButtonStruct implements Serializable {
    public static final a Companion = null;
    public static final int INFLOW_FEED_COMMENT_BUTTON = 101;
    public static final int INFLOW_FEED_COMMENT_NEW_STYLE = 1;

    @SerializedName("background")
    private final String background;

    @SerializedName("icon")
    private final String icon;
    private boolean isShowCommentCounts;

    @SerializedName("links")
    private final PromotionProductLink links;

    @SerializedName("style")
    private final Integer style;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("type")
    private final Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionCustomButtonStruct() {
    }

    public final String getBackground() {
        return this.background;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final PromotionProductLink getLinks() {
        return this.links;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getType() {
        return this.type;
    }

    public final boolean isShowCommentCounts() {
        return this.isShowCommentCounts;
    }

    public final void setShowCommentCounts(boolean r100) {
        this.isShowCommentCounts = r100;
    }
}
