package com.bytedance.android.livesdkapi.service.gamecp;

import kotlin.Metadata;
import vlc.l;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveIMService;", "", "", "roomId", "", "messageType", "Lvlc/l;", "listener", "", "addMessageListener", "removeMessageListener", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveIMService {
    void addMessageListener(long r100, String r101, l r102);

    void removeMessageListener(long r100, l r101);
}
