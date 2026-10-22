package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PullStreamUpdateMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/PullStreamUpdateMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "pushStreamLevel", "I", "getPushStreamLevel", "()I", "setPushStreamLevel", "(I)V", "recommendSeconds", "getRecommendSeconds", "setRecommendSeconds", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PullStreamUpdateMessage extends o0 implements vh7.h {

    @SerializedName("push_stream_level")
    protected int pushStreamLevel;

    @SerializedName("random_seconds")
    protected int recommendSeconds;

    public PullStreamUpdateMessage() {
        this.type = MessageType.PULL_STREAM_UPDATE;
    }

    public final int getPushStreamLevel() {
        return this.pushStreamLevel;
    }

    public final int getRecommendSeconds() {
        return this.recommendSeconds;
    }

    public PullStreamUpdateMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pushStreamLevel = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.recommendSeconds = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.PULL_STREAM_UPDATE;
    }

    public final void setPushStreamLevel(int r100) {
        this.pushStreamLevel = r100;
    }

    public final void setRecommendSeconds(int r100) {
        this.recommendSeconds = r100;
    }
}
