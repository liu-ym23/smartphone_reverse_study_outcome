package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionAskExplainInfo;", "Ljava/io/Serializable;", "status", "", "userCount", "", "rank", "rankIconUrl", "", "canAskExplain", "", "(IJILjava/lang/String;Z)V", "getCanAskExplain", "()Z", "getRank", "()I", "getRankIconUrl", "()Ljava/lang/String;", "getStatus", "getUserCount", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionAskExplainInfo implements Serializable {

    @SerializedName("can_ask_explain")
    private final boolean canAskExplain;

    @SerializedName("rank")
    private final int rank;

    @SerializedName("rank_icon_url")
    private final String rankIconUrl;

    @SerializedName("status")
    private final int status;

    @SerializedName("user_count")
    private final long userCount;

    public ECPromotionAskExplainInfo() {
        this(0, 0, 0, null, false, 31, null);
    }

    public static /* synthetic */ ECPromotionAskExplainInfo copy$default(ECPromotionAskExplainInfo r100, int r101, long r102, int r103, String r104, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.userCount;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.rank;
    L11:
        int r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.rankIconUrl;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.canAskExplain;
    L17:
        int r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final int component1() {
        return this.status;
    }

    public final long component2() {
        return this.userCount;
    }

    public final int component3() {
        return this.rank;
    }

    public final String component4() {
        return this.rankIconUrl;
    }

    public final boolean component5() {
        return this.canAskExplain;
    }

    public final ECPromotionAskExplainInfo copy(int r100, long r110, int r111, String r112, boolean r113) {
        return new ECPromotionAskExplainInfo(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionAskExplainInfo) == false) goto L16;
        ECPromotionAskExplainInfo r101 = (ECPromotionAskExplainInfo) r100;
        if (this.status == r101.status) goto L8;
        return false;
    L8:
        if (this.userCount == r101.userCount) goto L10;
        return false;
    L10:
        if (this.rank == r101.rank) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankIconUrl, r101.rankIconUrl) == true) goto L14;
        return false;
    L14:
        if (this.canAskExplain == r101.canAskExplain) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int r100 = this.status * 31;
        long r101 = this.userCount;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.rank) * 31;
        String r103 = this.rankIconUrl;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L6:
        int r105 = (r102 + r104) * 31;
        boolean r106 = this.canAskExplain;
        ?? r107 = r106;
        if (r106 == false) goto L10;
        r107 = 1;
    L10:
        return r105 + r107;
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionAskExplainInfo(status=" + this.status + ", userCount=" + this.userCount + ", rank=" + this.rank + ", rankIconUrl=" + this.rankIconUrl + ", canAskExplain=" + this.canAskExplain + ")";
    }

    public final boolean getCanAskExplain() {
        return this.canAskExplain;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getRankIconUrl() {
        return this.rankIconUrl;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getUserCount() {
        return this.userCount;
    }

    public ECPromotionAskExplainInfo(int r100, long r101, int r102, String r103, boolean r104) {
        this.status = r100;
        this.userCount = r101;
        this.rank = r102;
        this.rankIconUrl = r103;
        this.canAskExplain = r104;
    }

    public /* synthetic */ ECPromotionAskExplainInfo(int r100, long r101, int r102, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r114 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r103 = r101;
        if ((r112 & 4) == 0) goto L12;
        int r104 = 0;
    L14:
        if ((r112 & 8) == 0) goto L16;
        r110 = null;
    L16:
        String r105 = r110;
        if ((r112 & 16) == 0) goto L19;
        boolean r115 = false;
    L20:
        this(r114, r103, r104, r105, r115);
        return;
    L19:
        r115 = r111;
        goto L20
    L12:
        r104 = r102;
        goto L14
    L5:
        r114 = r100;
        goto L7
    }
}
