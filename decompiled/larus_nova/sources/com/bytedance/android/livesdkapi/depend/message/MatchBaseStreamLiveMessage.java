package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.livesdk.message.model.p0;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MatchBaseStreamLiveMessage;", "Lcom/bytedance/android/livesdk/message/model/p0;", "Lcom/ss/ugc/live/sdk/message/stream/IStreamMessage$DelayMode;", "getDelayMode", "", "getTargetSei", "", "ignoreCondition", "", "getMessageMethod", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MatchBaseStreamLiveMessage extends p0 {
    public abstract /* synthetic */ boolean isStreamMessage();

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d
    public String getMessageMethod() {
        String r100 = this.type.getWsMethod();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.p0, com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public long getTargetSei() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return (r100.createTime + r100.diffSei2absSecond) * ((long) 1000);
    }

    @Override // com.bytedance.android.livesdk.message.model.p0, com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean ignoreCondition() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.diffSei2absSecond < 0) goto L8;
        return false;
    }

    public MatchBaseStreamLiveMessage() {
    }

    public IStreamMessage.DelayMode getDelayMode() {
        return IStreamMessage.DelayMode.SEI_DIFF;
    }
}
