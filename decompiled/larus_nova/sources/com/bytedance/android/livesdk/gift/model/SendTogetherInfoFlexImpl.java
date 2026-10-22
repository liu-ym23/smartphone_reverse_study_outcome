package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.SendTogether")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SendTogetherInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/j3;", "", "id$delegate", "Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "id", "", "startTime$delegate", "getStartTime", "()J", DyPayConstant.KEY_START_TIME, "endTime$delegate", "getEndTime", "endTime", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendTogetherInfoFlexImpl extends FlexModelBase<j3> implements j3, vh7.h {

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("id")
    protected String _$$id;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long _$$startTime;

    public SendTogetherInfoFlexImpl() {
        super(j3.class);
        this._$$id = "";
    }

    @Override // com.bytedance.android.livesdk.gift.model.j3
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j3
    public final String getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.j3
    public final long getStartTime() {
        return this._$$startTime;
    }

    public SendTogetherInfoFlexImpl(am3.g r100) {
        super(j3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$id = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$startTime = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$endTime = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$id != null) goto L31;
        this._$$id = "";
        return;
    }
}
