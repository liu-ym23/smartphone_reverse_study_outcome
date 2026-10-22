package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/b0;", "", "", "hasMore", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "musicList", "Ljava/util/List;", "b", "()Ljava/util/List;", "chorusList", "getChorusList", "", "searchId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "querySource", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b0 implements vh7.h {

    @SerializedName("chorusList")
    protected List<KtvMusic> chorusList;

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("musiclist")
    protected List<KtvMusic> musicList;

    @SerializedName("query_source")
    protected Integer querySource;

    @SerializedName("search_id")
    protected String searchId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L16;
        b0 r101 = (b0) r100;
        if (this.hasMore == r101.hasMore) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.musicList, r101.musicList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.chorusList, r101.chorusList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.querySource, r101.querySource) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
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
        List<KtvMusic> r107 = this.chorusList;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.searchId;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.querySource;
        if (r113 == null) goto L21;
        r104 = r113.hashCode();
    L21:
        return r112 + r104;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "KtvSearchSongsResponse(hasMore=" + this.hasMore + ", musicList=" + this.musicList + ", chorusList=" + this.chorusList + ", searchId=" + this.searchId + ", querySource=" + this.querySource + ")";
    }

    public b0() {
        this.hasMore = false;
        this.musicList = null;
        this.chorusList = null;
        this.searchId = null;
        this.querySource = null;
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final List<KtvMusic> b() {
        return this.musicList;
    }

    public final Integer c() {
        return this.querySource;
    }

    public final String d() {
        return this.searchId;
    }

    public b0(am3.g r100) {
        this.musicList = new ArrayList();
        this.chorusList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L9;
        this.hasMore = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        List<KtvMusic> r104 = this.chorusList;
        KtvMusic r105 = new KtvMusic(r100);
    L20:
        r104.add(r105);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.searchId = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.querySource = Integer.valueOf(r100.i());
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L19:
        r104 = this.musicList;
        r105 = new KtvMusic(r100);
        goto L20
    L21:
        r100.d(r101);
        if ((r102 & true) == true) goto L25;
        this.hasMore = false;
    L25:
        if (this.musicList.isEmpty() == false) goto L28;
        this.musicList = null;
    L28:
        if (this.chorusList.isEmpty() == false) goto L31;
        this.chorusList = null;
    L31:
        if (this.searchId != null) goto L34;
        this.searchId = null;
    L34:
        if (this.querySource != null) goto L53;
        this.querySource = null;
        return;
    }
}
