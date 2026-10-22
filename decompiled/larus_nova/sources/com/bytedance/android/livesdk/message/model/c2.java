package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CeremonyMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/c2;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/vm;", "items", "Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "", "maxPushDelayTime", "J", "getMaxPushDelayTime", "()J", "setMaxPushDelayTime", "(J)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c2 extends o0 implements vh7.h {

    @SerializedName("items")
    protected List<vm> items;

    @SerializedName("max_push_delay_time")
    protected long maxPushDelayTime;

    public final String toString() {
        return "CeremonyMessage{items=" + this.items + ", maxPushDelayTime=" + this.maxPushDelayTime + ", isLocalInsertMsg=" + this.isLocalInsertMsg2 + ", type=" + this.type + ", timestamp=" + this.timestamp + ", localTimestamp=" + this.localTimestamp + ", baseMessage=" + getBaseMessage() + '}';
    }

    public c2() {
        this.type = MessageType.CEREMONY_MESSAGE;
    }

    public final List<vm> E() {
        return this.items;
    }

    public c2(am3.g r100) {
        this.items = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.items.add(new vm(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.maxPushDelayTime = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.CEREMONY_MESSAGE;
    }
}
