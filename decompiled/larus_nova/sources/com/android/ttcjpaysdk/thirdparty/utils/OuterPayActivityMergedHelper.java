package com.android.ttcjpaysdk.thirdparty.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.android.ttcjpaysdk.base.settings.bean.CJPayPerformanceOptConfig;
import com.android.ttcjpaysdk.thirdparty.base.CJBaseBusinessWrapper;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/OuterPayActivityMergedHelper;", "", "()V", "TAG", "", "activityWrapperStackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/Stack;", "Lcom/android/ttcjpaysdk/thirdparty/base/CJBaseBusinessWrapper;", "addWrapper", "", "activity", "Landroid/app/Activity;", "wrapper", "getKey", "isDisableBack", "", "isMergeActivity", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onActivityBackPressed", "onActivityConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onActivityDestroy", "removeWrapper", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OuterPayActivityMergedHelper {
    public static final OuterPayActivityMergedHelper INSTANCE = null;
    private static final String TAG = "OuterPayActivityMergedHelper";
    private static final ConcurrentHashMap<String, Stack<CJBaseBusinessWrapper>> activityWrapperStackMap = null;

    private OuterPayActivityMergedHelper() {
    }

    static {
        INSTANCE = new OuterPayActivityMergedHelper();
        activityWrapperStackMap = new ConcurrentHashMap();
    }

    private final String getKey(Activity r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getTaskId());
        r101.append(System.identityHashCode(r100));
        return r101.toString();
    }

    public final boolean isDisableBack(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Stack<CJBaseBusinessWrapper> r101 = activityWrapperStackMap.get(getKey(r100));
        if (r101 == null) goto L15;
        Boolean r102 = null;
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L16;
        CJBaseBusinessWrapper r103 = r101.peek();
        if (r103 == null) goto L12;
        r102 = Boolean.valueOf(r103.isDisableBack());
    L12:
        if (r102 != null) goto L14;
        return true;
    L14:
        return r102.booleanValue();
    L16:
        return true;
    L15:
        return true;
    }

    public final boolean isMergeActivity(Context r100) {
        return CJPayPerformanceOptConfig.Companion.get().mergeActivity;
    }

    public final void onActivityBackPressed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (isMergeActivity(r100) == false) goto L15;
        Stack<CJBaseBusinessWrapper> r101 = activityWrapperStackMap.get(getKey(r100));
        if (r101 != null) goto L7;
        return;
    L7:
        if ((!r101.isEmpty()) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L17;
        CJBaseBusinessWrapper r102 = r101.peek();
        if (r102 == null) goto L18;
        r102.onBackPressed();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void onActivityDestroy(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (isMergeActivity(r100) == false) goto L19;
        String r101 = getKey(r100);
        Stack<CJBaseBusinessWrapper> r102 = activityWrapperStackMap.get(r101);
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        CJBaseBusinessWrapper r104 = (CJBaseBusinessWrapper) r103.next();
        if (r104 == null) goto L8;
        r104.onDestroy();
    L12:
        activityWrapperStackMap.remove(r101);
        return;
    }

    public final void addWrapper(Activity r100, CJBaseBusinessWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r101 == null) goto L12;
        ConcurrentHashMap<String, Stack<CJBaseBusinessWrapper>> r102 = activityWrapperStackMap;
        String r103 = INSTANCE.getKey(r100);
        Stack<CJBaseBusinessWrapper> r104 = r102.get(r103);
        if (r104 != null) goto L10;
        r104 = new Stack();
        Stack<CJBaseBusinessWrapper> r105 = r102.putIfAbsent(r103, r104);
        if (r105 == null) goto L10;
        r104 = r105;
    L10:
        CJBaseBusinessWrapper r106 = r104.push(r101);
        return;
    }

    public final void onActivityConfigurationChanged(Activity r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "newConfig");
        Stack<CJBaseBusinessWrapper> r102 = activityWrapperStackMap.get(getKey(r100));
        if (r102 != null) goto L5;
    L13:
        CJLogger.d(TAG, "skip configuration changed, wrapper stack is empty");
        return;
    L5:
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L13;
        CJLogger.d(TAG, "dispatch configuration changed, stackSize=" + r102.size() + ", orientation=" + r101.orientation + ", screenWidthDp=" + r101.screenWidthDp);
        CJBaseBusinessWrapper r103 = r102.peek();
        if (r103 == null) goto L15;
        r103.onConfigurationChanged(r101);
        return;
    }

    public final void removeWrapper(Activity r100, CJBaseBusinessWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Stack<CJBaseBusinessWrapper> r102 = activityWrapperStackMap.get(getKey(r100));
        if (r102 != null) goto L5;
        return;
    L5:
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L16;
        CJBaseBusinessWrapper r103 = r102.peek();
        if (Intrinsics.areEqual(r103, r101) == false) goto L17;
        r102.pop();
        if (r103 == null) goto L18;
        r103.onDestroy();
        return;
    L18:
        return;
    L17:
        return;
    }
}
