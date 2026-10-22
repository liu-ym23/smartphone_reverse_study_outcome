package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.UserIntroduceCardStatus")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/t;", "", "", "enableTimerCard", "Z", "", "introDuration", "J", "timerSpan", "timerLoopCnt", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class t implements vh7.h {

    @SerializedName("is_show_card")
    public boolean enableTimerCard;

    @SerializedName("introduce_duration")
    public long introDuration;

    @SerializedName("timer_loop_cnt")
    public long timerLoopCnt;

    @SerializedName("timer_span")
    public long timerSpan;

    public t() {
        this.introDuration = 60;
        this.timerSpan = 100;
        this.timerLoopCnt = -1;
    }

    public t(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L8;
        this.enableTimerCard = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.introDuration = r100.j();
        r102 = r102 | 1;
        goto L3
    L10:
        if (r103 != 3) goto L11;
        this.timerSpan = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.timerLoopCnt = r100.j();
        r102 = r102 | 4;
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L21;
        this.introDuration = 60;
    L21:
        if ((r102 & 2) != 0) goto L24;
        this.timerSpan = 100;
    L24:
        if ((r102 & 4) != 0) goto L42;
        this.timerLoopCnt = -1;
        return;
    }
}
