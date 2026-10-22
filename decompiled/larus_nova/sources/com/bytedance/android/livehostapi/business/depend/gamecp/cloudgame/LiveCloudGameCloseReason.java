package com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseReason;", "", "status", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;", "from", "", "isOpenGameFail", "", "failMsg", "(Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;Ljava/lang/String;ZLjava/lang/String;)V", "getFailMsg", "()Ljava/lang/String;", "getFrom", "()Z", "getStatus", "()Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCloudGameCloseReason {
    public static final Companion Companion = null;
    private final String failMsg;
    private final String from;
    private final boolean isOpenGameFail;
    private final LiveCloudGameCloseStatus status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseReason$Companion;", "", "()V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getFailMsg() {
        return this.failMsg;
    }

    public final String getFrom() {
        return this.from;
    }

    public final LiveCloudGameCloseStatus getStatus() {
        return this.status;
    }

    public final boolean isOpenGameFail() {
        return this.isOpenGameFail;
    }

    public LiveCloudGameCloseReason(LiveCloudGameCloseStatus r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r103, "failMsg");
        this.status = r100;
        this.from = r101;
        this.isOpenGameFail = r102;
        this.failMsg = r103;
    }

    public /* synthetic */ LiveCloudGameCloseReason(LiveCloudGameCloseStatus r100, String r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = "";
    L11:
        this(r100, r101, r102, r103);
    }
}
