package com.bytedance.android.live.profit.fansclub.transfer;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/transfer/p;", "", "", "clubName", "Ljava/lang/String;", "getClubName", "()Ljava/lang/String;", "setClubName", "(Ljava/lang/String;)V", "", "level", "I", "getLevel", "()I", "setLevel", "(I)V", "status", "getStatus", "setStatus", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements vh7.h {

    @SerializedName("club_name")
    protected String clubName;

    @SerializedName("level")
    protected int level;

    @SerializedName("status")
    protected int status;

    public p() {
    }

    public p(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 2) goto L8;
        this.level = (int) r100.j();
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.status = r100.i();
        goto L3
    L10:
        if (r102 != 7) goto L11;
        this.clubName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
