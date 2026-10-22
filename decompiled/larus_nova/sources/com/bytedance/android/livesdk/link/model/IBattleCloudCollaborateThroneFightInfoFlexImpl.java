package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleCloudCollaborateThroneFightInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleCloudCollaborateThroneFightInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/w0;", "Lcom/bytedance/android/livesdk/link/model/w0$b;", "<set-?>", "oddStageInfo$delegate", "Ljava/lang/Object;", "getOddStageInfo", "()Lcom/bytedance/android/livesdk/link/model/w0$b;", "setOddStageInfo", "(Lcom/bytedance/android/livesdk/link/model/w0$b;)V", "oddStageInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleCloudCollaborateThroneFightInfoFlexImpl extends FlexModelBase<w0> implements w0, vh7.h {

    @SerializedName("odd_stage_info")
    protected w0.b _$$oddStageInfo;

    public IBattleCloudCollaborateThroneFightInfoFlexImpl() {
        super(w0.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.link.model.w0$b, java.lang.Object] */
    public IBattleCloudCollaborateThroneFightInfoFlexImpl(am3.g r100) {
        super(w0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 4) goto L7;
        this._$$oddStageInfo = vh7.f.a(r100, w0.b.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.w0
    public final w0.b getOddStageInfo() {
        return this._$$oddStageInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.w0
    public final void setOddStageInfo(w0.b r100) {
        this._$$oddStageInfo = r100;
    }
}
