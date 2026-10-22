package com.bytedance.android.livesdkapi.urge;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/urge/IExternalGiftService;", "Lcom/bytedance/android/live/base/IService;", "createLynxUrgeGiftPanel", "Lcom/bytedance/android/livesdkapi/urge/IUrgeGiftPanel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "scheme", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalGiftService extends IService {
    IUrgeGiftPanel createLynxUrgeGiftPanel(Context r100, String r101);
}
