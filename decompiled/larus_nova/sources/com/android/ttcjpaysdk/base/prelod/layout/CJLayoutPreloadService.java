package com.android.ttcjpaysdk.base.prelod.layout;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/prelod/layout/CJLayoutPreloadService;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroidx/appcompat/view/ContextThemeWrapper;", "(Landroidx/appcompat/view/ContextThemeWrapper;)V", "asyncInflater", "Lcom/android/ttcjpaysdk/base/prelod/layout/CJAsyncThreadLayoutInflater;", "asyncListener", "Lcom/android/ttcjpaysdk/base/prelod/layout/CJAsyncThreadLayoutInflater$OnThreadInflateFinishedListener;", "cachePool", "Lcom/android/ttcjpaysdk/base/prelod/layout/CJViewCachePool;", "asyncInflateLayout", "", "resId", "", "clear", "has", "", "obtain", "Landroid/view/View;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLayoutPreloadService {
    private final CJAsyncThreadLayoutInflater asyncInflater;
    private final CJAsyncThreadLayoutInflater.OnThreadInflateFinishedListener asyncListener;
    private volatile CJViewCachePool cachePool;
    private final ContextThemeWrapper context;

    public final void clear() {
        this.cachePool.clear();
    }

    public CJLayoutPreloadService(ContextThemeWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        this.cachePool = new CJViewCachePool();
        this.asyncInflater = new CJAsyncThreadLayoutInflater(r100);
        this.asyncListener = new CJLayoutPreloadService$asyncListener$1(this);
        CJAsyncThreadLayoutInflater.setIgnoreInflateAfterContextDestroy(true);
        Context r101 = r100.getApplicationContext();
        if ((r101 instanceof Application) == false) goto L5;
        Application r102 = (Application) r101;
    L6:
        CJAsyncThreadLayoutInflater.setClearRelatedInflateRequestAfterActivityDestroy(r102, true);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final /* synthetic */ CJViewCachePool access$getCachePool$p(CJLayoutPreloadService r100) {
        return r100.cachePool;
    }

    public final void asyncInflateLayout(int r100) {
        FrameLayout r101 = new FrameLayout(this.context);
        this.asyncInflater.inflate(r100, r101, this.asyncListener);
    }

    public final boolean has(int r100) {
        return this.cachePool.hasView(r100);
    }

    public final View obtain(int r100) {
        return this.cachePool.popView(r100);
    }
}
