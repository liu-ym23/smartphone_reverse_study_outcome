package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.StampMessage")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/StampMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/StampMessageInfo;", "stamps", "Ljava/util/List;", "getStamps", "()Ljava/util/List;", "setStamps", "(Ljava/util/List;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampMessage extends o0 implements vh7.h {

    @SerializedName("stamps")
    protected List<StampMessageInfo> stamps;

    public StampMessage() {
        this.type = MessageType.STAMP_MESSAGE;
    }

    public final List<StampMessageInfo> getStamps() {
        return this.stamps;
    }

    public StampMessage(am3.g r100) {
        this.stamps = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.stamps.add(new StampMessageInfo(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.STAMP_MESSAGE;
    }

    public final void setStamps(List<StampMessageInfo> r100) {
        this.stamps = r100;
    }
}
