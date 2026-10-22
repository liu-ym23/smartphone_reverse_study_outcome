package com.bytedance.android.live.xplay.basic;

import com.bytedance.android.live.broadcastgame.api.xplay.basic.IMiddlewareXplayBasicGlobalService;
import com.bytedance.android.live.xplay.basic.api.IXplayBasicService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/XplayBasicService;", "Lcom/bytedance/android/live/xplay/basic/api/IXplayBasicService;", "Lcom/bytedance/android/live/broadcastgame/api/xplay/basic/a;", "getXplayGlobalService", "<init>", "()V", "livexplaygamebasic-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class XplayBasicService implements IXplayBasicService {
    public XplayBasicService() {
        jc1.k.l(IXplayBasicService.class, this);
        jc1.k.l(IMiddlewareXplayBasicGlobalService.class, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.basic.IMiddlewareXplayBasicGlobalService
    public com.bytedance.android.live.broadcastgame.api.xplay.basic.a getXplayGlobalService() {
        return b.f102776c;
    }
}
