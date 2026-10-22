package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BroadcastPanelDotInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CommonDotMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/n1;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BroadcastPanelDotInfo;", "dotInfoMap", "Ljava/util/Map;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/Map;", "setDotInfoMap", "(Ljava/util/Map;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n1 extends o0 implements vh7.h {

    @SerializedName("panel_dots")
    protected Map<String, BroadcastPanelDotInfo> dotInfoMap;

    public n1() {
        this.dotInfoMap = MapsKt.emptyMap();
        this.type = MessageType.BROADCAST_COMMON_DOT_MESSAGE;
    }

    public final Map<String, BroadcastPanelDotInfo> E() {
        return this.dotInfoMap;
    }

    public n1(am3.g r110) {
        this.dotInfoMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L27;
        if (r101 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L8:
        if (r101 != 2) goto L9;
        long r102 = r110.c();
        String r103 = null;
        BroadcastPanelDotInfo r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = new BroadcastPanelDotInfo(r110);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r102);
        Map<String, BroadcastPanelDotInfo> r106 = this.dotInfoMap;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.e(r110);
        goto L3
    L27:
        r110.d(r100);
        if (this.dotInfoMap != null) goto L30;
        this.dotInfoMap = MapsKt.emptyMap();
    L30:
        this.type = MessageType.BROADCAST_COMMON_DOT_MESSAGE;
    }
}
