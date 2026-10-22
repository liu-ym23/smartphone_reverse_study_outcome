package com.bytedance.android.gamecp.business.download.ai;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/ai/AiIntroStatus;", "", "gameStatus", "", "propStatus", "reserveStatus", "(III)V", "getGameStatus", "()I", "getPropStatus", "getReserveStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiIntroStatus {

    @SerializedName("game")
    private final int gameStatus;

    @SerializedName("prop")
    private final int propStatus;

    @SerializedName("reserve")
    private final int reserveStatus;

    public AiIntroStatus() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ AiIntroStatus copy$default(AiIntroStatus r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.gameStatus;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.propStatus;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.reserveStatus;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.gameStatus;
    }

    public final int component2() {
        return this.propStatus;
    }

    public final int component3() {
        return this.reserveStatus;
    }

    public final AiIntroStatus copy(int r100, int r101, int r102) {
        return new AiIntroStatus(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AiIntroStatus) == false) goto L12;
        AiIntroStatus r101 = (AiIntroStatus) r100;
        if (this.gameStatus == r101.gameStatus) goto L8;
        return false;
    L8:
        if (this.propStatus == r101.propStatus) goto L10;
        return false;
    L10:
        if (this.reserveStatus == r101.reserveStatus) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.gameStatus * 31) + this.propStatus) * 31) + this.reserveStatus;
    }

    public String toString() {
        return "AiIntroStatus(gameStatus=" + this.gameStatus + ", propStatus=" + this.propStatus + ", reserveStatus=" + this.reserveStatus + ")";
    }

    public final int getGameStatus() {
        return this.gameStatus;
    }

    public final int getPropStatus() {
        return this.propStatus;
    }

    public final int getReserveStatus() {
        return this.reserveStatus;
    }

    public AiIntroStatus(int r100, int r101, int r102) {
        this.gameStatus = r100;
        this.propStatus = r101;
        this.reserveStatus = r102;
    }

    public /* synthetic */ AiIntroStatus(int r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
