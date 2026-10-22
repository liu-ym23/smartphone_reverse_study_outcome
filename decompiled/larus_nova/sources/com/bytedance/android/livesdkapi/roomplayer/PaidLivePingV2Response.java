package com.bytedance.android.livesdkapi.roomplayer;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PaidLivePingV2Response;", "", "()V", "bizExtra", "Lcom/bytedance/android/livesdkapi/roomplayer/PaidLiveBizExtra;", "delivery", "", "duration", "", "paidLiveType", "parentTicketId", "getParentTicketId", "()J", "setParentTicketId", "(J)V", "refreshId", "", "getRefreshId", "()Ljava/lang/String;", "setRefreshId", "(Ljava/lang/String;)V", "refreshTime", "retType", "rightType", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLivePingV2Response implements h {
    public static final Companion Companion = null;
    public static final int PING_TYPE_AUTHENTICATION = 7;
    public static final int PING_TYPE_CAMERA_CYCLE = 8;
    public static final int PING_TYPE_CAMERA_DELIVERY = 9;
    public static final int PING_TYPE_CYCLE = 2;
    public static final int PING_TYPE_DELIVERY = 6;
    public static final int PING_TYPE_REPLAY_CYCLE = 4;
    public static final int PING_TYPE_REPLAY_DELIVERY = 5;
    public static final int PING_TYPE_START = 1;
    public static final int PING_TYPE_STOP = 3;
    public static final int RET_TYPE_PAID = 2;
    public static final int RET_TYPE_TEMP_WATCH = 1;

    @SerializedName("biz_extra")
    public PaidLiveBizExtra bizExtra;

    @SerializedName("delivery")
    public int delivery;

    @SerializedName("duration")
    public long duration;

    @SerializedName(PaidReplayConstants.KEY_PRIVILEGE_TYPE)
    public int paidLiveType;
    private long parentTicketId;
    private String refreshId;

    @SerializedName("refresh_time")
    public long refreshTime;

    @SerializedName("ret_type")
    public int retType;

    @SerializedName("right_type")
    public int rightType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PaidLivePingV2Response$Companion;", "", "()V", "PING_TYPE_AUTHENTICATION", "", "PING_TYPE_CAMERA_CYCLE", "PING_TYPE_CAMERA_DELIVERY", "PING_TYPE_CYCLE", "PING_TYPE_DELIVERY", "PING_TYPE_REPLAY_CYCLE", "PING_TYPE_REPLAY_DELIVERY", "PING_TYPE_START", "PING_TYPE_STOP", "RET_TYPE_PAID", "RET_TYPE_TEMP_WATCH", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public PaidLivePingV2Response() {
        this.refreshId = "";
    }

    public final long getParentTicketId() {
        return this.parentTicketId;
    }

    public final String getRefreshId() {
        return this.refreshId;
    }

    public PaidLivePingV2Response(g r100) {
        this.refreshId = "";
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 != 9) goto L7;
        this.rightType = r100.i();
        goto L3
    L7:
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this.paidLiveType = r100.i();
        goto L3
    L10:
        this.refreshTime = r100.j();
        goto L3
    L11:
        this.bizExtra = new PaidLiveBizExtra(r100);
        goto L3
    L12:
        this.delivery = r100.i();
        goto L3
    L13:
        this.duration = r100.j();
        goto L3
    L14:
        this.retType = (int) r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setParentTicketId(long r100) {
        this.parentTicketId = r100;
    }

    public final void setRefreshId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.refreshId = r100;
    }
}
