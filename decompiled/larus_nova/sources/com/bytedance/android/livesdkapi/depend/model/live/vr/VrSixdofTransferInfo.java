package com.bytedance.android.livesdkapi.depend.model.live.vr;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@IgnoreProtoFieldCheck
@ProtoMessage("webcast.data.VrInfo.VrSixdofTransferInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/vr/VrSixdofTransferInfo;", "", "()V", "layerStatus", "", "", "", "getLayerStatus", "()Ljava/util/Map;", "setLayerStatus", "(Ljava/util/Map;)V", "materialId", "getMaterialId", "()J", "setMaterialId", "(J)V", "materialUrl", "getMaterialUrl", "()Ljava/lang/String;", "setMaterialUrl", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrSixdofTransferInfo implements h {

    @SerializedName("layer_status")
    protected Map<String, Long> layerStatus;

    @SerializedName("material_id")
    protected long materialId;

    @SerializedName("material_url")
    protected String materialUrl;

    public VrSixdofTransferInfo() {
        this.materialUrl = "";
    }

    public final Map<String, Long> getLayerStatus() {
        return this.layerStatus;
    }

    public final long getMaterialId() {
        return this.materialId;
    }

    public final String getMaterialUrl() {
        return this.materialUrl;
    }

    public VrSixdofTransferInfo(g r110) {
        this.layerStatus = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.materialId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.materialUrl = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        String r103 = null;
        Long r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = Long.valueOf(r110.j());
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<String, Long> r106 = this.layerStatus;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
        if (this.materialUrl != null) goto L57;
        this.materialUrl = "";
        return;
    }

    public final void setLayerStatus(Map<String, Long> r100) {
        this.layerStatus = r100;
    }

    public final void setMaterialId(long r100) {
        this.materialId = r100;
    }

    public final void setMaterialUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.materialUrl = r100;
    }
}
