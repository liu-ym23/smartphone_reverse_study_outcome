package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.message.model.ed;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RoomSongInfo;", "", "", "songId", "J", "getSongId", "()J", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "mvBaseInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "getMvBaseInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVBaseInfo;", "", "Lcom/bytedance/android/livesdk/message/model/ed;", "mvColorList", "Ljava/util/List;", "getMvColorList", "()Ljava/util/List;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomSongInfo implements h {

    @SerializedName("mv_base_info")
    protected IMVBaseInfo mvBaseInfo;

    @SerializedName("mv_color_list")
    protected List<ed> mvColorList;

    @SerializedName("song_id")
    protected long songId;

    public RoomSongInfo() {
    }

    public final IMVBaseInfo getMvBaseInfo() {
        return this.mvBaseInfo;
    }

    public final List<ed> getMvColorList() {
        return this.mvColorList;
    }

    public final long getSongId() {
        return this.songId;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo, java.lang.Object] */
    public RoomSongInfo(g r100) {
        this.mvColorList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.songId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mvBaseInfo = f.a(r100, IMVBaseInfo.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.mvColorList.add(new ed(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
