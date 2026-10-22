package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelDataExtra;", "", "pageDataFrom", "", "pageDataUpdateTime", "", "pageDataForRoomId", "logId", "", "(IJJLjava/lang/String;)V", "getLogId", "()Ljava/lang/String;", "getPageDataForRoomId", "()J", "getPageDataFrom", "()I", "getPageDataUpdateTime", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPanelDataExtra {
    private final String logId;
    private final long pageDataForRoomId;
    private final int pageDataFrom;
    private final long pageDataUpdateTime;

    public GiftPanelDataExtra() {
        this(0, 0, 0, null, 15, null);
    }

    public final String getLogId() {
        return this.logId;
    }

    public final long getPageDataForRoomId() {
        return this.pageDataForRoomId;
    }

    public final int getPageDataFrom() {
        return this.pageDataFrom;
    }

    public final long getPageDataUpdateTime() {
        return this.pageDataUpdateTime;
    }

    public GiftPanelDataExtra(int r100, long r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "logId");
        this.pageDataFrom = r100;
        this.pageDataUpdateTime = r101;
        this.pageDataForRoomId = r102;
        this.logId = r103;
    }

    public /* synthetic */ GiftPanelDataExtra(int r100, long r101, long r102, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        long r103 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = -1;
    L11:
        long r104 = r102;
        if ((r111 & 8) == 0) goto L14;
        r110 = "";
    L14:
        int r105 = r100;
        this(r105, r103, r104, r110);
    }
}
