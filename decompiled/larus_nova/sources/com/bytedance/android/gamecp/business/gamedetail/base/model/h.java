package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/h;", "Lcom/bytedance/ies/sve_core/e;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/c;", "gameInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/c;", "e", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/c;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/b;", "downloadInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/b;", "d", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/b;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/e;", "metaData", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/e;", "f", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/e;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/s;", "userGameStats", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/s;", ce.f26391f, "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/s;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/j;", "commonStyleInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/j;", "c", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/j;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements com.bytedance.ies.sve_core.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f53486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f53487b;

    @SerializedName("common_style_info")
    private final j commonStyleInfo;

    @SerializedName("common_download_info")
    private final b downloadInfo;

    @SerializedName("common_game_info")
    private final c gameInfo;

    @SerializedName("common_meta_data")
    private final e metaData;

    @SerializedName("user_game_stats")
    private final s userGameStats;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.gameInfo, r101.gameInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.downloadInfo, r101.downloadInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.metaData, r101.metaData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userGameStats, r101.userGameStats) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.commonStyleInfo, r101.commonStyleInfo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        c r100 = this.gameInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.downloadInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.metaData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        s r110 = this.userGameStats;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.commonStyleInfo;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailCommonParams(gameInfo=" + this.gameInfo + ", downloadInfo=" + this.downloadInfo + ", metaData=" + this.metaData + ", userGameStats=" + this.userGameStats + ", commonStyleInfo=" + this.commonStyleInfo + ")";
    }

    public final boolean h() {
        j r100 = this.commonStyleInfo;
        String r101 = null;
        if (r100 == null) goto L5;
        i r102 = r100.b();
    L6:
        e r103 = this.metaData;
        if (r103 == null) goto L12;
        l r104 = r103.c();
        if (r104 == null) goto L12;
        r101 = r104.a();
    L12:
        if (Intrinsics.areEqual(r101, "v3") == true) goto L21;
        if (r102 != null) goto L15;
    L19:
        return false;
    L15:
        if (r102.c() == 1) goto L19;
        if (r102.c() == 0) goto L19;
        return true;
    L21:
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public h() {
        this.gameInfo = null;
        this.downloadInfo = null;
        this.metaData = null;
        this.userGameStats = null;
        this.commonStyleInfo = null;
    }

    public final j c() {
        return this.commonStyleInfo;
    }

    public final b d() {
        return this.downloadInfo;
    }

    public final c e() {
        return this.gameInfo;
    }

    public final e f() {
        return this.metaData;
    }

    public final s g() {
        return this.userGameStats;
    }
}
