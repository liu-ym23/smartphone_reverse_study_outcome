package com.android.ttcjpaysdk.base.prelod.layout;

import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\t\u001a\u00020\nJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/base/prelod/layout/CJLayoutPreloadHelper;", "", "()V", "layoutPreloadService", "Lcom/android/ttcjpaysdk/base/prelod/layout/CJLayoutPreloadService;", "asyncPreloadLayout", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroidx/appcompat/view/ContextThemeWrapper;", "resId", "", "clear", "getView", "Landroid/view/View;", "hasView", "", "(Landroidx/appcompat/view/ContextThemeWrapper;I)Ljava/lang/Boolean;", "initLayoutPreloadService", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJLayoutPreloadHelper {
    public static final CJLayoutPreloadHelper INSTANCE = null;
    private static volatile CJLayoutPreloadService layoutPreloadService;

    static {
        INSTANCE = new CJLayoutPreloadHelper();
    }

    private CJLayoutPreloadHelper() {
    }

    public final void clear() {
        CJLayoutPreloadService r100 = layoutPreloadService;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        layoutPreloadService = null;
    }

    private final void initLayoutPreloadService(ContextThemeWrapper r100) {
        if (layoutPreloadService != null) goto L6;
        layoutPreloadService = new CJLayoutPreloadService(r100);
        return;
    }

    public final View getView(int r100) {
        CJLayoutPreloadService r101 = layoutPreloadService;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.obtain(r100);
    }

    public final void asyncPreloadLayout(ContextThemeWrapper r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CJLayoutPreloadService r102 = layoutPreloadService;
        if (r102 == null) goto L5;
        r102.asyncInflateLayout(r101);
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 != null) goto L11;
        initLayoutPreloadService(r100);
        CJLayoutPreloadService r104 = layoutPreloadService;
        if (r104 == null) goto L12;
        r104.asyncInflateLayout(r101);
        Unit r105 = Unit.INSTANCE;
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final Boolean hasView(ContextThemeWrapper r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (layoutPreloadService != null) goto L5;
        initLayoutPreloadService(r100);
    L5:
        CJLayoutPreloadService r102 = layoutPreloadService;
        if (r102 != null) goto L10;
        return null;
    L10:
        return Boolean.valueOf(r102.has(r101));
    }
}
