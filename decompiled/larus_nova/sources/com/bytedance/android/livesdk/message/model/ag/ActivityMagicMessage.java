package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ActivityMagicMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/ActivityMagicMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "push_id", "Ljava/lang/String;", "getPush_id", "()Ljava/lang/String;", "setPush_id", "(Ljava/lang/String;)V", ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT, "getPush_content", "setPush_content", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ActivityMagicMessage extends o0 implements h {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PUSH_CONTENT)
    protected String push_content;

    @SerializedName("push_id")
    protected String push_id;

    public ActivityMagicMessage() {
        this.type = MessageType.ACTIVITY_MAGIC_ASIAN_GAMES_MESSAGE;
    }

    public final String getPush_content() {
        return this.push_content;
    }

    public final String getPush_id() {
        return this.push_id;
    }

    public ActivityMagicMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.push_id = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.push_content = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        this.type = MessageType.ACTIVITY_MAGIC_ASIAN_GAMES_MESSAGE;
    }

    public final void setPush_content(String r100) {
        this.push_content = r100;
    }

    public final void setPush_id(String r100) {
        this.push_id = r100;
    }
}
