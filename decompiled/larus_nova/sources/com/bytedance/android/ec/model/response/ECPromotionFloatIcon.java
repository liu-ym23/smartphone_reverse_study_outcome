package com.bytedance.android.ec.model.response;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionFloatIcon;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "jumpUrl", "Ljava/lang/String;", "getJumpUrl", "()Ljava/lang/String;", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "Ljava/lang/Long;", "getPos", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/live/t;", "trackInfo", "Lcom/bytedance/android/ec/model/live/t;", "getTrackInfo", "()Lcom/bytedance/android/ec/model/live/t;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionFloatIcon implements Serializable {
    public static final a Companion = null;
    public static final long POS_LEFT_BOTTOM = 1;
    public static final long POS_RIGHT_BOTTOM = 2;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    private final Long pos;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final com.bytedance.android.ec.model.live.t trackInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECPromotionFloatIcon() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Long getPos() {
        return this.pos;
    }

    public final com.bytedance.android.ec.model.live.t getTrackInfo() {
        return this.trackInfo;
    }
}
