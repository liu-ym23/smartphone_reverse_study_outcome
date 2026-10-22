package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.DistributionStatusMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/DistributionStatusMessage;", "", "()V", "anchorUid", "", "Ljava/lang/Long;", "distributionStatus", "", "Ljava/lang/Integer;", "eventTimeMs", "eventType", "", "extra", "", "liveStatus", "notifyType", "roomId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DistributionStatusMessage implements h {

    @SerializedName("anchor_uid")
    public Long anchorUid;

    @SerializedName("distribution_status")
    public Integer distributionStatus;

    @SerializedName("event_time_ms")
    public Long eventTimeMs;

    @SerializedName("event_type")
    public String eventType;

    @SerializedName("extra")
    public Map<String, String> extra;

    @SerializedName("live_status")
    public Integer liveStatus;

    @SerializedName("notify_type")
    public Integer notifyType;

    @SerializedName("room_id")
    public Long roomId;

    public DistributionStatusMessage() {
    }

    public DistributionStatusMessage(g r110) {
        this.extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L32;
        switch(r101) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.eventType = am3.h.c(r110);
        goto L3
    L8:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L9
    L14:
        if (r105 != 2) goto L15;
        r104 = am3.h.c(r110);
        goto L9
    L15:
        am3.h.e(r110);
        goto L9
    L18:
        r110.d(r102);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L26:
        this.eventTimeMs = Long.valueOf(r110.j());
        goto L3
    L27:
        this.liveStatus = Integer.valueOf(r110.i());
        goto L3
    L28:
        this.notifyType = Integer.valueOf(r110.i());
        goto L3
    L29:
        this.distributionStatus = Integer.valueOf(r110.i());
        goto L3
    L30:
        this.roomId = Long.valueOf(r110.j());
        goto L3
    L31:
        this.anchorUid = Long.valueOf(r110.j());
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L32:
        r110.d(r100);
    }
}
