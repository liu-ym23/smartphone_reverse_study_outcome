package com.bytedance.android.livesdkapi.service;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdk.floatview.FloatWindowService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IFloatWindowService;", "Lcom/bytedance/android/live/base/IService;", "hideFloatWindow", "", "isAppBackground", "", "isFloatWindowOpen", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isInnerFloatPlay", "isPipModeOpen", "useSharePlayer", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFloatWindowService extends IService {
    void hideFloatWindow();

    boolean isAppBackground();

    boolean isFloatWindowOpen(Context r100);

    boolean isInnerFloatPlay();

    boolean isPipModeOpen();

    boolean useSharePlayer();
}
