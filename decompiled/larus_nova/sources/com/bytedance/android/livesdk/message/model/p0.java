package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.ss.ugc.live.sdk.message.stream.IStreamMessage;

/* JADX INFO: loaded from: classes11.dex */
public abstract class p0 extends o0 implements IStreamMessage {
    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public long getProcessAtSeiTs() {
        return 0;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public long getTargetSei() {
        return 0;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public boolean ignoreCondition() {
        return false;
    }

    @Override // com.ss.ugc.live.sdk.message.stream.IStreamMessage
    public long getServerDelay() {
        CommonMessageData r100 = this.baseMessage;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return this.timestamp - r100.createTime;
    }

    public p0() {
    }
}
