package com.bytedance.android.live.liveinteract.model;

import am3.g;
import com.bytedance.android.livesdk.d9;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/liveinteract/model/ChorusInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/model/a;", "", "chorusId", "J", "getChorusId", "()J", "setChorusId", "(J)V", "leadSingerId", "getLeadSingerId", "setLeadSingerId", "", "leadSingerOpenId", "Ljava/lang/String;", "getLeadSingerOpenId", "()Ljava/lang/String;", "setLeadSingerOpenId", "(Ljava/lang/String;)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "finishTime", "getFinishTime", "setFinishTime", "value", "getLeadSingerIdString", "setLeadSingerIdString", "leadSingerIdString", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChorusInfo extends FlexModelBase<a> implements a, h {

    @SerializedName("chorus_id")
    protected long chorusId;

    @SerializedName("finish_time")
    protected long finishTime;

    @IgnoreProtoFieldCheck
    @SerializedName("lead_singer_id")
    protected long leadSingerId;

    @IgnoreProtoFieldCheck
    @SerializedName("lead_singer_open_id")
    protected String leadSingerOpenId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    public ChorusInfo() {
        super(a.class);
        this.chorusId = -1;
        this.leadSingerOpenId = "";
    }

    public final String getLeadSingerIdString() {
        return d9.c(Long.valueOf(getLeadSingerId()), this.leadSingerOpenId);
    }

    @Override // com.bytedance.android.live.liveinteract.model.a
    public long getChorusId() {
        return this.chorusId;
    }

    @Override // com.bytedance.android.live.liveinteract.model.a
    public long getFinishTime() {
        return this.finishTime;
    }

    @Override // com.bytedance.android.live.liveinteract.model.a
    public long getLeadSingerId() {
        return this.leadSingerId;
    }

    public final String getLeadSingerOpenId() {
        return this.leadSingerOpenId;
    }

    @Override // com.bytedance.android.live.liveinteract.model.a
    public long getStartTime() {
        return this.startTime;
    }

    public ChorusInfo(g r100) {
        super(a.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.chorusId = r100.j();
        r101 = r101 | true;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.leadSingerId = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.startTime = r100.j();
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.finishTime = r100.j();
        goto L3
    L14:
        if (r103 != 5000) goto L15;
        this.leadSingerOpenId = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L25;
        this.chorusId = -1;
    L25:
        if (this.leadSingerOpenId != null) goto L46;
        this.leadSingerOpenId = "";
        return;
    }

    public void setChorusId(long r100) {
        this.chorusId = r100;
    }

    public void setFinishTime(long r100) {
        this.finishTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.model.a
    public void setLeadSingerId(long r100) {
        this.leadSingerId = r100;
    }

    public final void setLeadSingerIdString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        d9.b(r100, new ChorusInfo$leadSingerIdString$1(this), new ChorusInfo$leadSingerIdString$2(this));
    }

    public final void setLeadSingerOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.leadSingerOpenId = r100;
    }

    public void setStartTime(long r100) {
        this.startTime = r100;
    }
}
