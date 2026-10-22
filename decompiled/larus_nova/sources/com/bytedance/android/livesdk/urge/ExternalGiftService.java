package com.bytedance.android.livesdk.urge;

import android.content.Context;
import com.bytedance.android.livesdkapi.urge.IExternalGiftService;
import com.bytedance.android.livesdkapi.urge.IUrgeGiftPanel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/urge/ExternalGiftService;", "Lcom/bytedance/android/livesdkapi/urge/IExternalGiftService;", "()V", "createLynxUrgeGiftPanel", "Lcom/bytedance/android/livesdkapi/urge/IUrgeGiftPanel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "scheme", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalGiftService implements IExternalGiftService {
    public static final ExternalGiftService INSTANCE = null;

    private ExternalGiftService() {
    }

    static {
        INSTANCE = new ExternalGiftService();
    }

    @Override // com.bytedance.android.livesdkapi.urge.IExternalGiftService
    public IUrgeGiftPanel createLynxUrgeGiftPanel(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scheme");
        LynxUrgeGiftPanel r102 = new LynxUrgeGiftPanel();
        Intrinsics.checkNotNullParameter(r101, "scheme");
        r102.f158618l = r101;
        return r102;
    }
}
