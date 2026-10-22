package com.bytedance.android.shopping.anchorv4.components;

import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/WindowConfigExtra;", "Ljava/io/Serializable;", "liveWindowRoomId", "", "logExtraData", "Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "entranceInfoString", "(Ljava/lang/String;Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;Ljava/lang/String;)V", "getEntranceInfoString", "()Ljava/lang/String;", "getLiveWindowRoomId", "getLogExtraData", "()Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowConfigExtra implements Serializable {
    private final String entranceInfoString;
    private final String liveWindowRoomId;
    private final ECLogExtraData logExtraData;

    public WindowConfigExtra() {
        this(null, null, null, 7, null);
    }

    public final String getEntranceInfoString() {
        return this.entranceInfoString;
    }

    public final String getLiveWindowRoomId() {
        return this.liveWindowRoomId;
    }

    public final ECLogExtraData getLogExtraData() {
        return this.logExtraData;
    }

    public WindowConfigExtra(String r100, ECLogExtraData r101, String r102) {
        this.liveWindowRoomId = r100;
        this.logExtraData = r101;
        this.entranceInfoString = r102;
    }

    public /* synthetic */ WindowConfigExtra(String r100, ECLogExtraData r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
