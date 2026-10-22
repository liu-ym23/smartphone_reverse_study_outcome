package com.bytedance.android.livesdkapi.util;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/util/IStatusBarAdapterHelper;", "", "isDigHole", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isFlodScreen", "isStatusBarAdapterEnable", "isStatusBarTransparent", "setJumpFromLivePlayerActivity", "", "isFromPlay", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IStatusBarAdapterHelper {
    boolean isDigHole(Context r100);

    boolean isFlodScreen();

    boolean isStatusBarAdapterEnable();

    boolean isStatusBarTransparent();

    void setJumpFromLivePlayerActivity(boolean r100);
}
