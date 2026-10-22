package com.bytedance.android.live.profit.scoreboard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/m;", "", "", "index", "I", "getIndex", "()I", "", "roomId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "", "creator", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m {

    @SerializedName("creator")
    private final boolean creator;

    @SerializedName("index")
    private final int index;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final String score;

    public m() {
        String r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (this.index == r101.index) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.score, r101.score) == true) goto L12;
        return false;
    L12:
        if (this.creator == r101.creator) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = this.index * 31;
        String r101 = this.roomId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.score;
        if (r105 == null) goto L9;
        r102 = r105.hashCode();
    L9:
        int r106 = (r104 + r102) * 31;
        boolean r107 = this.creator;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        return r106 + r108;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "Point(index=" + this.index + ", roomId=" + this.roomId + ", score=" + this.score + ", creator=" + this.creator + ")";
    }

    public final boolean a() {
        return this.creator;
    }

    public final String b() {
        return this.roomId;
    }

    public /* synthetic */ m(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = "0";
    L8:
        this(0, r100, r101, false);
    }

    public m(int r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        this.index = r100;
        this.roomId = r101;
        this.score = r102;
        this.creator = r103;
    }
}
