package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.im.PreviewPromotionSyncData.LuckyBag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/LuckyBag;", "", "()V", "drawAt", "", "getDrawAt", "()Ljava/lang/Long;", "setDrawAt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "lotteryId", "getLotteryId", "setLotteryId", "startAt", "getStartAt", "setStartAt", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LuckyBag implements h {

    @SerializedName("draw_at")
    protected Long drawAt;

    @SerializedName("lottery_id")
    protected Long lotteryId;

    @SerializedName("start_at")
    protected Long startAt;

    public LuckyBag() {
        this.lotteryId = 0L;
        this.startAt = 0L;
        this.drawAt = 0L;
    }

    public final Long getDrawAt() {
        return this.drawAt;
    }

    public final Long getLotteryId() {
        return this.lotteryId;
    }

    public final Long getStartAt() {
        return this.startAt;
    }

    public LuckyBag(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.lotteryId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.startAt = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.drawAt = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.lotteryId != null) goto L19;
        this.lotteryId = 0L;
    L19:
        if (this.startAt != null) goto L22;
        this.startAt = 0L;
    L22:
        if (this.drawAt != null) goto L37;
        this.drawAt = 0L;
        return;
    }

    public final void setDrawAt(Long r100) {
        this.drawAt = r100;
    }

    public final void setLotteryId(Long r100) {
        this.lotteryId = r100;
    }

    public final void setStartAt(Long r100) {
        this.startAt = r100;
    }
}
