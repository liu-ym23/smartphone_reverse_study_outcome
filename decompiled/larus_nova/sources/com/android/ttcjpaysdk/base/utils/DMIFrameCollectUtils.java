package com.android.ttcjpaysdk.base.utils;

import android.content.Context;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayCybsService;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/utils/DMIFrameCollectUtils;", "", "()V", "TAG", "", "dmSessionIdForForeignCard", "isHasTriggerDMCollect", "", "getDMSessionIdForForeignCard", "startDMIFrameCollect", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DMIFrameCollectUtils {
    public static final DMIFrameCollectUtils INSTANCE = null;
    private static final String TAG = null;
    private static String dmSessionIdForForeignCard;
    private static boolean isHasTriggerDMCollect;

    private DMIFrameCollectUtils() {
    }

    static {
        INSTANCE = new DMIFrameCollectUtils();
        TAG = "DMIFrameCollectUtils";
        dmSessionIdForForeignCard = "";
    }

    public final String getDMSessionIdForForeignCard() {
        return dmSessionIdForForeignCard;
    }

    public final void startDMIFrameCollect(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CJLogger.d(TAG, "startDMIFrameCollect isHasCollect:" + isHasTriggerDMCollect);
        if (isHasTriggerDMCollect == false) goto L5;
        return;
    L5:
        isHasTriggerDMCollect = true;
        dmSessionIdForForeignCard = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null) + System.currentTimeMillis();
        ICJPayCybsService r101 = (ICJPayCybsService) CJPayServiceManager.getInstance().getIService(ICJPayCybsService.class);
        if (r101 == null) goto L9;
        r101.startDMIFrame(new WebView(r100), dmSessionIdForForeignCard);
        return;
    }
}
