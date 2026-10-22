package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InteractControlMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sc;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "roomId", "Ljava/lang/String;", VideoSurfaceTexture.KEY_TIME, "", "Lcom/bytedance/android/livesdk/wrds/interact/a$a;", "anchorOperationList", "Ljava/util/List;", "audienceOperationList", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sc extends o0 implements vh7.h {

    @SerializedName("anchor_operation")
    public List<com.bytedance.android.livesdk.wrds.interact.a.C2484a> anchorOperationList;

    @SerializedName("audience_operation")
    public List<com.bytedance.android.livesdk.wrds.interact.a.C2484a> audienceOperationList;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("time_stamp")
    public String timeStamp;

    public sc() {
        this.type = MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE;
    }

    public sc(am3.g r100) {
        this.anchorOperationList = new ArrayList();
        this.audienceOperationList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.roomId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.timeStamp = am3.h.c(r100);
        goto L3
    L12:
        if (r102 == 4) goto L17;
        if (r102 != 5) goto L15;
        List<com.bytedance.android.livesdk.wrds.interact.a.C2484a> r103 = this.audienceOperationList;
        com.bytedance.android.livesdk.wrds.interact.a.C2484a r104 = new com.bytedance.android.livesdk.wrds.interact.a.C2484a(r100);
    L18:
        r103.add(r104);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L17:
        r103 = this.anchorOperationList;
        r104 = new com.bytedance.android.livesdk.wrds.interact.a.C2484a(r100);
        goto L18
    L22:
        r100.d(r101);
        this.type = MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE;
    }
}
