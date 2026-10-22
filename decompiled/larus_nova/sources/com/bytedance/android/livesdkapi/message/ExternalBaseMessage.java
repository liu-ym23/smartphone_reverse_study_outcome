package com.bytedance.android.livesdkapi.message;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Metadata;
import wy.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "Lcom/bytedance/android/livesdkapi/message/BaseMessage;", "Lcom/bytedance/android/livesdkapi/message/IExternalLiveMessage;", "()V", "checkValid", "", "isFirstHistoryMessage", "", "isTooMuchMsg", "setIsFirstHistoryMessage", "setLocalInsertMsg", "localInsertMsg", "setTooMuchMsg", "tooMuchMsg", "supportDisplayText", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ExternalBaseMessage extends BaseMessage implements IExternalLiveMessage {
    @Override // com.bytedance.android.livesdkapi.message.BaseMessage
    public void checkValid() {
        LocalTestManager.a(new Class[]{a.class});
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public abstract /* synthetic */ int getIntType();

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean isFirstHistoryMessage() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean isTooMuchMsg() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public void setIsFirstHistoryMessage(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.livesdk.message.model.o7
    public void setLocalInsertMsg(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public void setTooMuchMsg(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public boolean supportDisplayText() {
        return false;
    }

    public ExternalBaseMessage() {
    }
}
