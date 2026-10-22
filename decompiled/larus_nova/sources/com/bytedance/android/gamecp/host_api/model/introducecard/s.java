package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.IntroduceCardDisplayInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/s;", "", "", "displayDuration", "J", "", "timerCardSwitchOpen", "Z", "timerSpan", "timerLoopCnt", "isOpenAiIntroduceCard", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class s implements vh7.h {

    @SerializedName("display_duration")
    public long displayDuration;

    @IgnoreProtoFieldCheck
    @SerializedName("is_open_ai_introduce_card")
    public boolean isOpenAiIntroduceCard;

    @SerializedName("is_open_timer_introduce_card")
    public boolean timerCardSwitchOpen;

    @SerializedName("display_timer_loop_cnt")
    public long timerLoopCnt;

    @SerializedName("display_timer_span")
    public long timerSpan;

    public s() {
    }

    public s(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.displayDuration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.timerCardSwitchOpen = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.timerSpan = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.timerLoopCnt = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.isOpenAiIntroduceCard = am3.h.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
