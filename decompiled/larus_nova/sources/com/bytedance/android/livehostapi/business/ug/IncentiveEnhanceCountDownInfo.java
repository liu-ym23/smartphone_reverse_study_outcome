package com.bytedance.android.livehostapi.business.ug;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/ug/IncentiveEnhanceCountDownInfo;", "", "isEnhancing", "", "goldPendantCountDown", "", "goldPendantCoinNum", "", "goldPendantTreatment", "", "roomId", "(ZJILjava/lang/String;Ljava/lang/String;)V", "getGoldPendantCoinNum", "()I", "getGoldPendantCountDown", "()J", "getGoldPendantTreatment", "()Ljava/lang/String;", "()Z", "getRoomId", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncentiveEnhanceCountDownInfo {
    private final int goldPendantCoinNum;
    private final long goldPendantCountDown;
    private final String goldPendantTreatment;
    private final boolean isEnhancing;
    private final String roomId;

    public IncentiveEnhanceCountDownInfo() {
        this(false, 0, 0, null, null, 31, null);
    }

    public final int getGoldPendantCoinNum() {
        return this.goldPendantCoinNum;
    }

    public final long getGoldPendantCountDown() {
        return this.goldPendantCountDown;
    }

    public final String getGoldPendantTreatment() {
        return this.goldPendantTreatment;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final boolean isEnhancing() {
        return this.isEnhancing;
    }

    public IncentiveEnhanceCountDownInfo(boolean r100, long r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "roomId");
        this.isEnhancing = r100;
        this.goldPendantCountDown = r101;
        this.goldPendantCoinNum = r102;
        this.goldPendantTreatment = r103;
        this.roomId = r104;
    }

    public /* synthetic */ IncentiveEnhanceCountDownInfo(boolean r100, long r101, int r102, String r103, String r110, int r111, DefaultConstructorMarker r112) {
        int r104 = 0;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r105 = r101;
        if ((r111 & 4) != 0) goto L14;
        r104 = r102;
    L14:
        if ((r111 & 8) == 0) goto L16;
        String r106 = "";
    L18:
        if ((r111 & 16) == 0) goto L20;
        String r114 = "";
    L21:
        this(r113, r105, r104, r106, r114);
        return;
    L20:
        r114 = r110;
        goto L21
    L16:
        r106 = r103;
        goto L18
    L5:
        r113 = r100;
        goto L7
    }
}
