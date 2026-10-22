package com.bytedance.android.live.soloktv.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/c;", "", "", "sungSongCount", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "", "favoriteSongName", "Ljava/lang/String;", "getFavoriteSongName", "()Ljava/lang/String;", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements vh7.h {

    @SerializedName("favorite_song_name")
    protected String favoriteSongName;

    @SerializedName("sung_song_count")
    protected int sungSongCount;

    public c() {
        this.favoriteSongName = "";
    }

    public final int a() {
        return this.sungSongCount;
    }

    public c(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.sungSongCount = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.favoriteSongName = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.favoriteSongName != null) goto L25;
        this.favoriteSongName = "";
        return;
    }
}
