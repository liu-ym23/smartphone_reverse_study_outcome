package com.bytedance.android.livesdkapi.depend.model.live.vr;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.data.VrInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrInfo;", "", "()V", "streamMapping", "", "", "", "getStreamMapping", "()Ljava/util/Map;", "setStreamMapping", "(Ljava/util/Map;)V", "vrSixdofTransferInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;", "getVrSixdofTransferInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;", "setVrSixdofTransferInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;)V", "vrTransferType", "getVrTransferType", "()J", "setVrTransferType", "(J)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrInfo implements h {

    @SerializedName("stream_mapping")
    protected Map<String, Long> streamMapping;

    @SerializedName("vr_sixdof_transfer_info")
    protected VrSixdofTransferInfo vrSixdofTransferInfo;

    @SerializedName("vr_transfer_type")
    protected long vrTransferType;

    public VrInfo() {
    }

    public final Map<String, Long> getStreamMapping() {
        return this.streamMapping;
    }

    public final VrSixdofTransferInfo getVrSixdofTransferInfo() {
        return this.vrSixdofTransferInfo;
    }

    public final long getVrTransferType() {
        return this.vrTransferType;
    }

    public VrInfo(g r110) {
        this.streamMapping = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.vrTransferType = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        long r102 = r110.c();
        String r103 = null;
        Long r104 = null;
    L14:
        int r105 = r110.f();
        if (r105 == (-1)) goto L21;
        if (r105 != 1) goto L17;
        r103 = am3.h.c(r110);
        goto L14
    L17:
        if (r105 != 2) goto L18;
        r104 = Long.valueOf(r110.j());
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r102);
        Map<String, Long> r106 = this.streamMapping;
        if (r103 == null) goto L28;
        if (r104 == null) goto L26;
        r106.put(r103, r104);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r101 != 3) goto L11;
        this.vrSixdofTransferInfo = new VrSixdofTransferInfo(r110);
        goto L3
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
    }

    public final void setStreamMapping(Map<String, Long> r100) {
        this.streamMapping = r100;
    }

    public final void setVrSixdofTransferInfo(VrSixdofTransferInfo r100) {
        this.vrSixdofTransferInfo = r100;
    }

    public final void setVrTransferType(long r100) {
        this.vrTransferType = r100;
    }
}
