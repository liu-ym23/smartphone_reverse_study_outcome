package com.bytedance.android.live.base.model.dynamic;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.api.moment.VideoFragment")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\b¨\u00062"}, d2 = {"Lcom/bytedance/android/live/base/model/dynamic/g;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "vid", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "cover", "Lcom/bytedance/android/live/base/model/ImageModel;", "getCover", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setCover", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "videoFragmentId", "J", "getVideoFragmentId", "()J", "setVideoFragmentId", "(J)V", "playUrl", "getPlayUrl", "setPlayUrl", "itemId", "getItemId", "setItemId", "status", "getStatus", "setStatus", "playNumber", "getPlayNumber", "setPlayNumber", "duration", "getDuration", "setDuration", "paidLiveType", "getPaidLiveType", "setPaidLiveType", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements h {

    @SerializedName("cover")
    protected ImageModel cover;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("item_id")
    protected long itemId;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    protected int paidLiveType;

    @SerializedName("play_number")
    protected long playNumber;

    @SerializedName("play_url")
    private String playUrl;

    @SerializedName("status")
    protected int status;

    @SerializedName("type")
    protected int type;

    @SerializedName("vid")
    protected String vid;

    @SerializedName("fragment_id")
    protected long videoFragmentId;

    public g() {
    }

    public final int getType() {
        return this.type;
    }

    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 13) goto L7;
        this.vid = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        this.paidLiveType = r100.i();
        goto L3
    L10:
        this.duration = r100.j();
        goto L3
    L11:
        this.playNumber = r100.j();
        goto L3
    L12:
        this.status = (int) r100.j();
        goto L3
    L13:
        this.itemId = r100.j();
        goto L3
    L14:
        this.videoFragmentId = r100.j();
        goto L3
    L15:
        this.cover = x.a(r100);
        goto L3
    L16:
        this.type = (int) r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
