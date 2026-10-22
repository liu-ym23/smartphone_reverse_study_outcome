package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.VrTransferMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/VrTransferMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", VideoSurfaceTexture.KEY_TIME, "J", "materailId", "", "materialUrl", "Ljava/lang/String;", "", "layerStatus", "Ljava/util/Map;", "vrTransferType", "Ljava/lang/Long;", "", "", "getLayerStatusList", "()Ljava/util/List;", "layerStatusList", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VrTransferMessage extends o0 implements vh7.h {

    @SerializedName("layer_status")
    public Map<Long, Long> layerStatus;

    @SerializedName("materail_id")
    public long materailId;

    @SerializedName("material_url")
    public String materialUrl;

    @SerializedName("time_stamp")
    public long timeStamp;

    @SerializedName("vr_transfer_type")
    public Long vrTransferType;

    public final List<Integer> getLayerStatusList() {
        Map<Long, Long> r100 = this.layerStatus;
        if (r100 == null) goto L10;
        Collection<Long> r101 = r100.values();
        if (r101 == null) goto L10;
        Collection<Long> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        r103.add(Integer.valueOf((int) ((Number) r104.next()).longValue()));
        goto L8
    L13:
        return r103;
    L10:
        return null;
    }

    public VrTransferMessage() {
        this.materialUrl = "";
        this.type = MessageType.VR_TRANSFER_MESSAGE;
    }

    public VrTransferMessage(am3.g r110) {
        this.layerStatus = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L39;
        if (r101 != 1) goto L8;
        this.timeStamp = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.materailId = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.materialUrl = am3.h.c(r110);
        goto L3
    L12:
        if (r101 != 4) goto L14;
        long r102 = r110.c();
        Long r103 = null;
        Long r104 = null;
    L21:
        int r105 = r110.f();
        if (r105 == (-1)) goto L28;
        if (r105 != 1) goto L24;
        r103 = Long.valueOf(r110.j());
        goto L21
    L24:
        if (r105 != 2) goto L25;
        r104 = Long.valueOf(r110.j());
        goto L21
    L25:
        am3.h.e(r110);
        goto L21
    L28:
        r110.d(r102);
        Map<Long, Long> r106 = this.layerStatus;
        if (r103 == null) goto L35;
        if (r104 == null) goto L33;
        r106.put(r103, r104);
        goto L3
    L33:
        throw new IllegalStateException("Value must not be null");
    L35:
        throw new IllegalStateException("Key must not be null");
    L14:
        if (r101 != 5) goto L16;
        this.vrTransferType = Long.valueOf(r110.j());
        goto L3
    L16:
        if (r101 != 100) goto L17;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L17:
        am3.h.e(r110);
        goto L3
    L39:
        r110.d(r100);
        if (this.materialUrl != null) goto L42;
        this.materialUrl = "";
    L42:
        this.type = MessageType.VR_TRANSFER_MESSAGE;
    }
}
