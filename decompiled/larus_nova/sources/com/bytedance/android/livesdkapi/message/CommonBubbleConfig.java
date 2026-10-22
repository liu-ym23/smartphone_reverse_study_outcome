package com.bytedance.android.livesdkapi.message;

import android.content.Context;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.common.utility.UIUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import py.i;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
public class CommonBubbleConfig {
    public static final int DEFAULT_DISPLAY_TIME = 3;
    public static final int MESSAGE_TYPE_EXHIBITION = 1;
    public static final int POSITION_ANCHOR_AVATAR = 1;
    public static final int POSITION_ROOM_FAN_TICKET_COUNT = 2;

    @SerializedName("arrow_image")
    public k arrowImage;

    @SerializedName(CJUnifyPayEventUtils.PARAM_KEY_ARROW_POSITION)
    public int arrowPosition;

    @SerializedName("background_image")
    public i backgroundImage;

    @SerializedName("content")
    public String content;

    @SerializedName("duration")
    public int duration;
    public String eventName;
    public Map<String, String> extra;

    @SerializedName("message_type")
    public int messageType;

    @SerializedName("rich_text")
    public a5 richText;

    @SerializedName("scheme_url")
    public String schemeUrl;

    public k getBackgroundImageModel() {
        if (this.backgroundImage == null) goto L6;
        k r100 = (k) f.c(k.class);
        r100.setUri(this.backgroundImage.getUri());
        r100.setUrls(this.backgroundImage.getUrlList());
        return r100;
    L6:
        return null;
    }

    public CommonBubbleConfig() {
        this.content = "";
        this.richText = (a5) f.c(a5.class);
        this.schemeUrl = "";
        this.duration = 3;
        this.eventName = "";
    }

    public static int getPositionDip(int r100, Context r101) {
        if (r100 != 1) goto L5;
        float r102 = UIUtils.dip2Px(r101, 17.0f);
    L8:
        return (int) r102;
    L5:
        if (r100 == 2) goto L9;
        r102 = UIUtils.dip2Px(r101, 50.0f);
        goto L8
    L9:
        r102 = UIUtils.dip2Px(r101, 50.0f);
        goto L8
    }

    public CommonBubbleConfig(a5 r100, String r101, int r102, String r103) {
        this.content = "";
        a5 r104 = (a5) f.c(a5.class);
        this.richText = r100;
        this.schemeUrl = r101;
        this.duration = r102;
        this.eventName = r103;
    }
}
