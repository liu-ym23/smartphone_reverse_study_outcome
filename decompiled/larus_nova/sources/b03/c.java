package b03;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static final int b(int r100) {
        return i.b(r100);
    }

    public static final float c(int r100) {
        int r101 = i.f90837a;
        Resources r102 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        return (r100 / WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f;
    }

    public static final int a(Context r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(a.f16857a, "$this$getAppContentHeight");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = s1.w();
        int r104 = StatusBarUtil.getStatusBarHeight(r100);
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L5;
        if (r100 == null) goto L14;
        Activity r105 = ContextUtil.contextToActivity(r100);
        if (r105 == null) goto L14;
        if ((r105.getWindow().getAttributes().flags & 1024) != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L17;
        return r103;
    L17:
        if (r101 == true) goto L19;
        return r103;
    L19:
        if (r102 != 0) goto L25;
        if (PadConfigUtils.c() == true) goto L23;
        return r103;
    L23:
        return r103 - r104;
    L25:
        return r103 - r104;
    L14:
        r106 = false;
        goto L15
    L5:
        return r103 - r104;
    }
}
