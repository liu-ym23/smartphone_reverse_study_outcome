package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.api;

import am3.g;
import com.bytedance.android.livesdk.multilink.base.model.d0;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/api/PunchInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/multilink/base/model/d0;", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "", "punchStatus", "I", "getPunchStatus", "()I", "setPunchStatus", "(I)V", "punchDurationTarget", "getPunchDurationTarget", "setPunchDurationTarget", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PunchInfo extends FlexModelBase<d0> implements d0, h {

    @IgnoreProtoFieldCheck
    @SerializedName("punch_duration")
    protected long punchDurationTarget;

    @IgnoreProtoFieldCheck
    @SerializedName("punch_status")
    protected int punchStatus;

    @IgnoreProtoFieldCheck
    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    @IgnoreProtoFieldCheck
    @SerializedName("user_id")
    protected long userId;

    public PunchInfo() {
        super(d0.class);
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.d0
    public long getPunchDurationTarget() {
        return this.punchDurationTarget;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.d0
    public int getPunchStatus() {
        return this.punchStatus;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.d0
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.android.livesdk.multilink.base.model.d0
    public long getUserId() {
        return this.userId;
    }

    public PunchInfo(g r100) {
        super(d0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.startTime = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.punchStatus = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.punchDurationTarget = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setPunchDurationTarget(long r100) {
        this.punchDurationTarget = r100;
    }

    public void setPunchStatus(int r100) {
        this.punchStatus = r100;
    }

    public void setStartTime(long r100) {
        this.startTime = r100;
    }

    public void setUserId(long r100) {
        this.userId = r100;
    }
}
