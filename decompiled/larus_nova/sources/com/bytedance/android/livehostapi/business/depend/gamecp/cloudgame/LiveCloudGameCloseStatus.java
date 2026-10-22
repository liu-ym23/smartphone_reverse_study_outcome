package com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "FAIL", "SUCCESS", "TRIAL_TIME_OUT", "USER_STOP", "FORCE_STOP", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveCloudGameCloseStatus extends Enum<LiveCloudGameCloseStatus> {
    private static final /* synthetic */ LiveCloudGameCloseStatus[] $VALUES = null;
    public static final Companion Companion = null;
    public static final LiveCloudGameCloseStatus FAIL = null;
    public static final LiveCloudGameCloseStatus FORCE_STOP = null;
    public static final LiveCloudGameCloseStatus SUCCESS = null;
    public static final LiveCloudGameCloseStatus TRIAL_TIME_OUT = null;
    public static final LiveCloudGameCloseStatus USER_STOP = null;
    private final int status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus$Companion;", "", "()V", "from", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;", "findValue", "", "(Ljava/lang/Integer;)Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/LiveCloudGameCloseStatus;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final LiveCloudGameCloseStatus from(Integer r100) {
            LiveCloudGameCloseStatus[] r101 = LiveCloudGameCloseStatus.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            LiveCloudGameCloseStatus r104 = r101[r103];
            int r105 = r104.getStatus();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 == null) goto L17;
            return r104;
        L17:
            return LiveCloudGameCloseStatus.SUCCESS;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    static {
        LiveCloudGameCloseStatus r100 = new LiveCloudGameCloseStatus("FAIL", 0, 0);
        FAIL = r100;
        LiveCloudGameCloseStatus r101 = new LiveCloudGameCloseStatus("SUCCESS", 1, 1);
        SUCCESS = r101;
        LiveCloudGameCloseStatus r102 = new LiveCloudGameCloseStatus("TRIAL_TIME_OUT", 2, 2);
        TRIAL_TIME_OUT = r102;
        LiveCloudGameCloseStatus r103 = new LiveCloudGameCloseStatus("USER_STOP", 3, 3);
        USER_STOP = r103;
        LiveCloudGameCloseStatus r104 = new LiveCloudGameCloseStatus("FORCE_STOP", 4, 4);
        FORCE_STOP = r104;
        $VALUES = new LiveCloudGameCloseStatus[]{r100, r101, r102, r103, r104};
        Companion = new Companion(null);
    }

    public static LiveCloudGameCloseStatus valueOf(String r100) {
        return (LiveCloudGameCloseStatus) a.a(LiveCloudGameCloseStatus.class, r100);
    }

    public static LiveCloudGameCloseStatus[] values() {
        return (LiveCloudGameCloseStatus[]) $VALUES.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    private LiveCloudGameCloseStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
