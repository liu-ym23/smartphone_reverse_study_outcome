package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.livesdk.chatroom.model.interact.v0;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.LinkmicTeamfightBonusInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/LinkmicTeamfightBonusInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/v0;", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "setStartTime", "(J)V", "duration", "getDuration", "setDuration", "", "coefficient", "D", "getCoefficient", "()D", "setCoefficient", "(D)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicTeamfightBonusInfo extends FlexModelBase<v0> implements v0, vh7.h {

    @SerializedName("coefficient")
    protected double coefficient;

    @SerializedName("duration")
    protected long duration;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    public LinkmicTeamfightBonusInfo() {
        super(v0.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.v0
    public double getCoefficient() {
        return this.coefficient;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.v0
    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.v0
    public long getStartTime() {
        return this.startTime;
    }

    public LinkmicTeamfightBonusInfo(am3.g r100) {
        super(v0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.startTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.duration = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.coefficient = Double.longBitsToDouble(r100.h());
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setCoefficient(double r100) {
        this.coefficient = r100;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setStartTime(long r100) {
        this.startTime = r100;
    }
}
