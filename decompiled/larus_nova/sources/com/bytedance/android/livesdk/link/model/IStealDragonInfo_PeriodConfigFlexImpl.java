package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.StealDragonInfo.PeriodConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_PeriodConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$b;", "", "stage$delegate", "Ljava/lang/Object;", "getStage", "()I", "stage", "", "start_time_sec$delegate", "getStart_time_sec", "()J", "start_time_sec", "duration_sec$delegate", "getDuration_sec", "duration_sec", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IStealDragonInfo_PeriodConfigFlexImpl extends FlexModelBase<IStealDragonInfo.b> implements IStealDragonInfo.b, vh7.h {

    @SerializedName("duration_sec")
    protected long _$$duration_sec;

    @SerializedName("stage")
    protected int _$$stage;

    @SerializedName("start_time_sec")
    protected long _$$start_time_sec;

    public IStealDragonInfo_PeriodConfigFlexImpl() {
        super(IStealDragonInfo.b.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.b
    public final long getDuration_sec() {
        return this._$$duration_sec;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.b
    public final int getStage() {
        return this._$$stage;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.b
    public final long getStart_time_sec() {
        return this._$$start_time_sec;
    }

    public IStealDragonInfo_PeriodConfigFlexImpl(am3.g r100) {
        super(IStealDragonInfo.b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$stage = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$start_time_sec = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$duration_sec = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}
