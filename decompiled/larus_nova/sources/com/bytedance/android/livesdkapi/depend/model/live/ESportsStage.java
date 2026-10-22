package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ESportsStage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IESportsStage;", "()V", "currentStage", "", "getCurrentStage", "()I", "setCurrentStage", "(I)V", "finalStage", "getFinalStage", "setFinalStage", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ESportsStage extends FlexModelBase<IESportsStage> implements IESportsStage, h {

    @SerializedName("current_stage")
    protected int currentStage;

    @SerializedName("final_stage")
    protected int finalStage;

    public ESportsStage() {
        super(IESportsStage.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage
    public int getCurrentStage() {
        return this.currentStage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage
    public int getFinalStage() {
        return this.finalStage;
    }

    public ESportsStage(g r100) {
        super(IESportsStage.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.currentStage = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.finalStage = r100.i();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage
    public void setCurrentStage(int r100) {
        this.currentStage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IESportsStage
    public void setFinalStage(int r100) {
        this.finalStage = r100;
    }
}
