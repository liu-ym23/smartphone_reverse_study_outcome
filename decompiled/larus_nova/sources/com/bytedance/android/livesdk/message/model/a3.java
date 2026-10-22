package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdk.chatroom.model.AccompanimentMode;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ChorusVolumeChangedContent")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/a3;", "", "", "accompanimentVolume", "Ljava/lang/Long;", "getAccompanimentVolume", "()Ljava/lang/Long;", "setAccompanimentVolume", "(Ljava/lang/Long;)V", "leaderVolume", "getLeaderVolume", "setLeaderVolume", "singerVolume", "getSingerVolume", "setSingerVolume", "", "accompanimentMode", "Ljava/lang/Integer;", "getAccompanimentMode", "()Ljava/lang/Integer;", "setAccompanimentMode", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "chorusAccompanimentInfo", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "setChorusAccompanimentInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t;)V", "", "", "chorusLeaderLinkmicIds", "Ljava/util/List;", "getChorusLeaderLinkmicIds", "()Ljava/util/List;", "setChorusLeaderLinkmicIds", "(Ljava/util/List;)V", "anchorLinkmicId", "Ljava/lang/String;", "getAnchorLinkmicId", "()Ljava/lang/String;", "setAnchorLinkmicId", "(Ljava/lang/String;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a3 implements vh7.h {

    @SerializedName("accompaniment_mode")
    protected Integer accompanimentMode;

    @SerializedName("accompaniment_volume")
    protected Long accompanimentVolume;

    @SerializedName("anchor_linkmic_id")
    protected String anchorLinkmicId;

    @SerializedName("chorus_accompaniment_info")
    protected com.bytedance.android.livesdk.chatroom.model.t chorusAccompanimentInfo;

    @SerializedName("chorus_leader_linkmic_ids")
    protected List<String> chorusLeaderLinkmicIds;

    @SerializedName("leader_volume")
    protected Long leaderVolume;

    @SerializedName("singer_volume")
    protected Long singerVolume;

    public a3() {
        this.accompanimentMode = Integer.valueOf(AccompanimentMode.UNKNOWN.getValue());
    }

    public a3(am3.g r100) {
        this.chorusLeaderLinkmicIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.anchorLinkmicId = am3.h.c(r100);
        goto L3
    L8:
        this.chorusLeaderLinkmicIds.add(am3.h.c(r100));
        goto L3
    L9:
        this.chorusAccompanimentInfo = new com.bytedance.android.livesdk.chatroom.model.t(r100);
        goto L3
    L10:
        this.accompanimentMode = Integer.valueOf(r100.i());
        goto L3
    L11:
        this.singerVolume = Long.valueOf(r100.j());
        goto L3
    L12:
        this.leaderVolume = Long.valueOf(r100.j());
        goto L3
    L13:
        this.accompanimentVolume = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.accompanimentMode != null) goto L36;
        this.accompanimentMode = Integer.valueOf(AccompanimentMode.UNKNOWN.getValue());
        return;
    }
}
