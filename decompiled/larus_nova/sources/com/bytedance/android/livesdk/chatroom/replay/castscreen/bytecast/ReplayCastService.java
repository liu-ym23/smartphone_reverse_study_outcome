package com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IMiddlewareHostLiveByteCast;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend;
import com.bytedance.android.livesdk.chatroom.replay_api.api.IReplayCastService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/castscreen/bytecast/ReplayCastService;", "Lcom/bytedance/android/livesdk/chatroom/replay_api/api/IReplayCastService;", "()V", "addGlobalPlayListener", "", "getReplayCastUIDepend", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ReplayCastService implements IReplayCastService {
    public ReplayCastService() {
        k.l(ReplayCastService.class, this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.api.IReplayCastService
    public void addGlobalPlayListener() {
        IMiddlewareHostLiveByteCast r100 = ReplayByteCastManager.d();
        if (r100 == null) goto L5;
        r100.removeGlobalPlayListener(ReplayByteCastManager.f108218i);
    L5:
        IMiddlewareHostLiveByteCast r101 = ReplayByteCastManager.d();
        if (r101 == null) goto L9;
        r101.addGlobalPlayListener(ReplayByteCastManager.f108218i);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay_api.api.IReplayCastService
    public ILiveCastSourceUIDepend getReplayCastUIDepend(Context r100) {
        return new ReplayCastSourceUIDepend(new WeakReference(r100), new WeakReference(null), new WeakReference(null));
    }
}
