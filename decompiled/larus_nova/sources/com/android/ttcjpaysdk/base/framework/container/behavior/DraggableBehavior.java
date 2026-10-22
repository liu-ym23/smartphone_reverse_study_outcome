package com.android.ttcjpaysdk.base.framework.container.behavior;

import android.content.Context;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/behavior/DraggableBehavior;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "offsetDistance", "", "screenHeight", "getScreenHeight", "()I", "statusBarHeight", "getStatusBarHeight", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DraggableBehavior {
    private final Context context;
    private int offsetDistance;
    private final int screenHeight;
    private final int statusBarHeight;

    public final Context getContext() {
        return this.context;
    }

    public final int getScreenHeight() {
        return this.screenHeight;
    }

    public final int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public DraggableBehavior(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.screenHeight = CJPayBasicUtils.getScreenHeight(r100);
        this.statusBarHeight = CJPayBasicUtils.getStatusBarHeight(r100);
    }
}
