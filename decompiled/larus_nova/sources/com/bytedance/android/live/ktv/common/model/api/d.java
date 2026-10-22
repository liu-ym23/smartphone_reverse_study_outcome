package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/d;", "", "", "totoalCount", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setTotoalCount", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "songs", "Ljava/util/List;", "getSongs", "()Ljava/util/List;", "setSongs", "(Ljava/util/List;)V", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("has_more")
    protected Boolean hasMore;

    @SerializedName("songs")
    protected List<KtvMusic> songs;

    @SerializedName("totoal_count")
    protected String totoalCount;

    public d() {
        this.totoalCount = "";
        this.songs = new ArrayList();
        this.hasMore = Boolean.FALSE;
    }

    public final String a() {
        return this.totoalCount;
    }

    public d(am3.g r100) {
        this.songs = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.totoalCount = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.songs.add(new KtvMusic(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.hasMore = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.totoalCount != null) goto L19;
        this.totoalCount = "";
    L19:
        if (this.songs.isEmpty() == false) goto L22;
        this.songs = new ArrayList();
    L22:
        if (this.hasMore != null) goto L37;
        this.hasMore = Boolean.FALSE;
        return;
    }
}
