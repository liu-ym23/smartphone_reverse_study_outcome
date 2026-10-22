package com.bytedance.android.live.base.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.ShortTouchArea")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/base/model/n;", "", "", "type", "I", "priority", "minSdkVersion", "showType", "", VideoSurfaceTexture.KEY_TIME, "J", "Lcom/bytedance/android/live/base/model/q;", "shortTouchInfo", "Lcom/bytedance/android/live/base/model/q;", "Lcom/bytedance/android/live/base/model/o;", "shortTouchBigCard", "Lcom/bytedance/android/live/base/model/o;", "", WsConstants.KEY_PAYLOAD, "Ljava/lang/String;", "loadType", "Lcom/bytedance/android/live/base/model/p;", "bubbleParams", "Lcom/bytedance/android/live/base/model/p;", "iconDesc", "hideMode", "enhancedTouch", "dynamicPriority", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n implements vh7.h {

    @SerializedName("bubble_params")
    public p bubbleParams;

    @SerializedName("dynamic_priority")
    public long dynamicPriority;

    @SerializedName("enhanced_touch")
    public int enhancedTouch;

    @SerializedName("hide_mode")
    public int hideMode;

    @SerializedName("name")
    public String iconDesc;

    @SerializedName(ChameleonOpenTracker.ParamKey.LOAD_TYPE)
    public int loadType;

    @SerializedName("min_webcast_sdk_version")
    public int minSdkVersion;

    @SerializedName("container_payload")
    public String payload;

    @SerializedName("priority")
    public int priority;

    @SerializedName("short_touch_big_card")
    public o shortTouchBigCard;

    @SerializedName("short_touch_info")
    public q shortTouchInfo;

    @SerializedName("short_touch_type")
    public int showType;

    @IgnoreProtoFieldCheck
    @SerializedName("current_time")
    public long timeStamp;

    @SerializedName("type")
    public int type;

    public static final class a {
    }

    static {
    }

    public n() {
    }

    public n(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        switch(r102) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.dynamicPriority = r100.j();
        goto L3
    L8:
        this.enhancedTouch = r100.i();
        goto L3
    L9:
        this.hideMode = r100.i();
        goto L3
    L10:
        this.iconDesc = am3.h.c(r100);
        goto L3
    L11:
        this.bubbleParams = z.a(r100);
        goto L3
    L12:
        this.loadType = r100.i();
        goto L3
    L13:
        this.payload = am3.h.c(r100);
        goto L3
    L14:
        this.shortTouchBigCard = y.a(r100);
        goto L3
    L15:
        this.shortTouchInfo = a0.a(r100);
        goto L3
    L16:
        this.showType = r100.i();
        goto L3
    L17:
        this.minSdkVersion = (int) r100.j();
        goto L3
    L18:
        this.priority = r100.i();
        goto L3
    L19:
        this.type = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
    }
}
