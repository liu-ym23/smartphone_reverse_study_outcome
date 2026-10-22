package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ChorusConcertSong;", "", "()V", "artistName", "", "getArtistName", "()Ljava/lang/String;", "orderUser", "Lcom/bytedance/android/livesdk/message/model/OrderSongUser;", "getOrderUser", "()Lcom/bytedance/android/livesdk/message/model/OrderSongUser;", "songName", "getSongName", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusConcertSong implements vh7.h {

    @SerializedName("artist_name")
    protected String artistName;

    @SerializedName("order_user")
    protected OrderSongUser orderUser;

    @SerializedName("song_name")
    protected String songName;

    public ChorusConcertSong() {
    }

    public ChorusConcertSong(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.artistName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.songName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.orderUser = new OrderSongUser(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getArtistName() {
        return this.artistName;
    }

    public final OrderSongUser getOrderUser() {
        return this.orderUser;
    }

    public final String getSongName() {
        return this.songName;
    }
}
