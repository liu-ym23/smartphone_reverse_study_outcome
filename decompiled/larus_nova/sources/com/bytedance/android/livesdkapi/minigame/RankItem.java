package com.bytedance.android.livesdkapi.minigame;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/RankItem;", "Ljava/io/Serializable;", "user", "Lcom/bytedance/android/livesdkapi/minigame/User;", "fanTicketCount", "", "rank", "", "(Lcom/bytedance/android/livesdkapi/minigame/User;Ljava/lang/String;I)V", "getFanTicketCount", "()Ljava/lang/String;", "setFanTicketCount", "(Ljava/lang/String;)V", "getRank", "()I", "setRank", "(I)V", "getUser", "()Lcom/bytedance/android/livesdkapi/minigame/User;", "setUser", "(Lcom/bytedance/android/livesdkapi/minigame/User;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankItem implements Serializable {

    @SerializedName(a.KEY_SCORE)
    private String fanTicketCount;

    @SerializedName("rank")
    private int rank;

    @SerializedName("user")
    private User user;

    public RankItem() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ RankItem copy$default(RankItem r100, User r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.user;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.fanTicketCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.rank;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final User component1() {
        return this.user;
    }

    public final String component2() {
        return this.fanTicketCount;
    }

    public final int component3() {
        return this.rank;
    }

    public final RankItem copy(User r100, String r101, int r102) {
        return new RankItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RankItem) == false) goto L12;
        RankItem r101 = (RankItem) r100;
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fanTicketCount, r101.fanTicketCount) == true) goto L10;
        return false;
    L10:
        if (this.rank == r101.rank) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        User r100 = this.user;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.fanTicketCount;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.rank;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RankItem(user=" + this.user + ", fanTicketCount=" + this.fanTicketCount + ", rank=" + this.rank + ")";
    }

    public final String getFanTicketCount() {
        return this.fanTicketCount;
    }

    public final int getRank() {
        return this.rank;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setFanTicketCount(String r100) {
        this.fanTicketCount = r100;
    }

    public final void setRank(int r100) {
        this.rank = r100;
    }

    public final void setUser(User r100) {
        this.user = r100;
    }

    public RankItem(User r100, String r101, int r102) {
        this.user = r100;
        this.fanTicketCount = r101;
        this.rank = r102;
    }

    public /* synthetic */ RankItem(User r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
