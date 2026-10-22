package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/f;", "", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "songs", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "nextWantListenCursor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "nextRecommendListCursor", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "queryId", "c", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f implements vh7.h {

    @SerializedName("next_recommend_list_cursor")
    protected long nextRecommendListCursor;

    @SerializedName("next_want_listen_cursor")
    protected String nextWantListenCursor;

    @SerializedName("query_id")
    protected String queryId;

    @SerializedName("songs")
    protected List<KtvMusic> songs;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.songs, r101.songs) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nextWantListenCursor, r101.nextWantListenCursor) == true) goto L10;
        return false;
    L10:
        if (this.nextRecommendListCursor == r101.nextRecommendListCursor) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryId, r101.queryId) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<KtvMusic> r100 = this.songs;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.nextWantListenCursor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.nextRecommendListCursor;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.queryId;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetListenSongListResponse(songs=" + this.songs + ", nextWantListenCursor=" + this.nextWantListenCursor + ", nextRecommendListCursor=" + this.nextRecommendListCursor + ", queryId=" + this.queryId + ")";
    }

    public f() {
        this.songs = null;
        this.nextWantListenCursor = null;
        this.nextRecommendListCursor = 0;
        this.queryId = "";
    }

    public final long a() {
        return this.nextRecommendListCursor;
    }

    public final String b() {
        return this.nextWantListenCursor;
    }

    public final String c() {
        return this.queryId;
    }

    public final List<KtvMusic> d() {
        return this.songs;
    }

    public f(am3.g r100) {
        this.songs = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.songs.add(new KtvMusic(r100));
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.nextWantListenCursor = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.nextRecommendListCursor = r100.j();
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.queryId = am3.h.c(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.songs.isEmpty() == false) goto L21;
        this.songs = null;
    L21:
        if (this.nextWantListenCursor != null) goto L24;
        this.nextWantListenCursor = null;
    L24:
        if ((r102 & true) == true) goto L27;
        this.nextRecommendListCursor = 0;
    L27:
        if (this.queryId != null) goto L45;
        this.queryId = "";
        return;
    }
}
