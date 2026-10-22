package com.bytedance.android.livesdk.chatroom.replay_api.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastSourceUIDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.ReplayCastService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay_api/api/IReplayCastService;", "Lcom/bytedance/android/live/base/IService;", "addGlobalPlayListener", "", "getReplayCastUIDepend", "Lcom/bytedance/android/livehostapi/business/castscreen/interfaces/ILiveCastSourceUIDepend;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "vs-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReplayCastService extends IService {
    void addGlobalPlayListener();

    ILiveCastSourceUIDepend getReplayCastUIDepend(Context r100);
}
