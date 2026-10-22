package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.MicrophoneTaskDataV2")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/MicrophoneTaskDataV2;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/x0;", "", "currentScore", "J", "getCurrentScore", "()J", "setCurrentScore", "(J)V", "needScoreToNext", "getNeedScoreToNext", "setNeedScoreToNext", "", "orderSingStage", "I", "getOrderSingStage", "()I", "setOrderSingStage", "(I)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicrophoneTaskDataV2 extends FlexModelBase<x0> implements x0, vh7.h {

    @SerializedName("current_score")
    protected long currentScore;

    @SerializedName("need_score_to_next")
    protected long needScoreToNext;

    @SerializedName("order_sing_stage")
    protected int orderSingStage;

    public MicrophoneTaskDataV2() {
        super(x0.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.x0
    public long getCurrentScore() {
        return this.currentScore;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.x0
    public long getNeedScoreToNext() {
        return this.needScoreToNext;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.x0
    public int getOrderSingStage() {
        return this.orderSingStage;
    }

    public MicrophoneTaskDataV2(am3.g r100) {
        super(x0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.currentScore = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.needScoreToNext = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.orderSingStage = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setCurrentScore(long r100) {
        this.currentScore = r100;
    }

    public void setNeedScoreToNext(long r100) {
        this.needScoreToNext = r100;
    }

    public void setOrderSingStage(int r100) {
        this.orderSingStage = r100;
    }
}
