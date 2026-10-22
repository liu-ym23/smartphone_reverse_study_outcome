package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u00158\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "Ljava/io/Serializable;", "", "useButtonTips", "Ljava/lang/Boolean;", "getUseButtonTips", "()Ljava/lang/Boolean;", "", "tips", "Ljava/lang/String;", "getTips", "()Ljava/lang/String;", "isCentered", "bgColor", "getBgColor", "tipsColor", "getTipsColor", "arrowColor", "getArrowColor", "tipsUrl", "getTipsUrl", "", "tipsContentType", "Ljava/lang/Integer;", "getTipsContentType", "()Ljava/lang/Integer;", "textType", "getTextType", "buttonTipsType", "I", "getButtonTipsType", "()I", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ButtonTipsStruct implements Serializable {
    public static final int ADDRESS_TIP = 0;
    public static final int CROSS_SHOP_TIP = 1;
    public static final a Companion = null;
    public static final int HAINAN_TIP = 2;

    @SerializedName("arrow_color")
    private final String arrowColor;

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName("button_tips_type")
    private final int buttonTipsType;

    @SerializedName("is_centered")
    private final Boolean isCentered;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE)
    private final Integer textType;

    @SerializedName("tips")
    private final String tips;

    @SerializedName("tips_color")
    private final String tipsColor;

    @SerializedName("tips_content_type")
    private final Integer tipsContentType;

    @SerializedName("tips_url")
    private final String tipsUrl;

    @SerializedName("use_button_tips")
    private final Boolean useButtonTips;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ButtonTipsStruct() {
    }

    public final String getArrowColor() {
        return this.arrowColor;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final int getButtonTipsType() {
        return this.buttonTipsType;
    }

    public final Integer getTextType() {
        return this.textType;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getTipsColor() {
        return this.tipsColor;
    }

    public final Integer getTipsContentType() {
        return this.tipsContentType;
    }

    public final String getTipsUrl() {
        return this.tipsUrl;
    }

    public final Boolean getUseButtonTips() {
        return this.useButtonTips;
    }

    public final Boolean isCentered() {
        return this.isCentered;
    }
}
