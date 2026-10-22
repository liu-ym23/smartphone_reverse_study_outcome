package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/WtnPlayRequest;", "", "wtnStreamID", "", "triggerType", "(Ljava/lang/String;Ljava/lang/String;)V", "getTriggerType", "()Ljava/lang/String;", "getWtnStreamID", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WtnPlayRequest {
    private final String triggerType;
    private final String wtnStreamID;

    public final String getTriggerType() {
        return this.triggerType;
    }

    public final String getWtnStreamID() {
        return this.wtnStreamID;
    }

    public WtnPlayRequest(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "wtnStreamID");
        this.wtnStreamID = r100;
        this.triggerType = r101;
    }

    public /* synthetic */ WtnPlayRequest(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
