package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/k;", "", "", "hasMore", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setHasMore", "(Z)V", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "musicList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setMusicList", "(Ljava/util/List;)V", "", "queryId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setQueryId", "(Ljava/lang/String;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("music_list")
    protected List<KtvMusic> musicList;

    @SerializedName("query_id")
    protected String queryId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L12;
        k r101 = (k) r100;
        if (this.hasMore == r101.hasMore) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicList, r101.musicList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.queryId, r101.queryId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.hasMore;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<KtvMusic> r103 = this.musicList;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.queryId;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GetSongListResponse(hasMore=" + this.hasMore + ", musicList=" + this.musicList + ", queryId=" + this.queryId + ")";
    }

    public k() {
        this.hasMore = false;
        this.musicList = null;
        this.queryId = null;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final List<KtvMusic> b() {
        return this.musicList;
    }

    public final String c() {
        return this.queryId;
    }

    public k(am3.g r100) {
        this.musicList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.musicList.add(new KtvMusic(r100));
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.hasMore = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.queryId = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L18;
        this.hasMore = false;
    L18:
        if (this.musicList.isEmpty() == false) goto L21;
        this.musicList = null;
    L21:
        if (this.queryId != null) goto L36;
        this.queryId = null;
        return;
    }
}
