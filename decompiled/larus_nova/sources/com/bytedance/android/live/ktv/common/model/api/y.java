package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/y;", "", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "songs", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setSongs", "(Ljava/util/List;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y implements vh7.h {

    @SerializedName("songs")
    protected List<KtvMusic> songs;

    public y() {
        this.songs = new ArrayList();
    }

    public final List<KtvMusic> a() {
        return this.songs;
    }

    public y(am3.g r100) {
        this.songs = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.songs.add(new KtvMusic(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.songs.isEmpty() == false) goto L19;
        this.songs = new ArrayList();
        return;
    }
}
