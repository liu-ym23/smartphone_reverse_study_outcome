package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h6 implements IStatusBarAdapterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h6 f158978a = null;

    public h6() {
    }

    static {
        f158978a = new h6();
    }

    @Override // com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper
    public final boolean isFlodScreen() {
        return FoldScreenUtils.f();
    }

    @Override // com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper
    public final boolean isStatusBarTransparent() {
        return StatusBarUtil.isStatusBarTransparent();
    }

    @Override // com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper
    public final boolean isStatusBarAdapterEnable() {
        return StatusBarUtil.STATUS_BAR_ADAPT_ENABLE;
    }

    @Override // com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper
    public final boolean isDigHole(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return DigHoleScreenUtil.isDigHole(r100);
    }

    @Override // com.bytedance.android.livesdkapi.util.IStatusBarAdapterHelper
    public final void setJumpFromLivePlayerActivity(boolean r100) {
        StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY = r100;
    }
}
