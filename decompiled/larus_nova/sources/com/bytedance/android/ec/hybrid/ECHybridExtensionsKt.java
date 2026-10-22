package com.bytedance.android.ec.hybrid;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.SoftReference;
import java.util.Map;
import kk.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridExtensionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f46241a;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f46242a;

        public a(Function0 r100) {
            this.f46242a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f46242a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final Handler c() {
        SoftReference<Handler> r100 = f46241a;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f46241a = new SoftReference(r102);
        return r102;
    }

    public static final Activity a(Context r100) {
        Context r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L8;
        return null;
    L8:
        if ((r100 instanceof Activity) == false) goto L11;
        r101 = r100;
    L11:
        Activity r102 = (Activity) r101;
        if (r102 == null) goto L14;
        return r102;
    L14:
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static final void b(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        d.c(new ECHybridExtensionsKt$forceTriggerLayout$1(r100));
    }

    public static final void f(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        c().post(new a(r100));
    }

    public static final void g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        c().postAtFrontOfQueue(new a(r100));
    }

    public static final void h(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        c().postAtFrontOfQueue(new a(r100));
    }

    public static final Integer i(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toInt");
        if ((r100 instanceof Integer) == false) goto L6;
        return (Integer) r100;
    L6:
        if ((r100 instanceof Number) == false) goto L9;
        return Integer.valueOf(((Number) r100).intValue());
    L9:
        if ((r100 instanceof String) == true) goto L15;
        return null;
    L15:
        return StringsKt.toIntOrNull((String) r100);
    }

    public static final Long j(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLong");
        if ((r100 instanceof Long) == false) goto L6;
        return (Long) r100;
    L6:
        if ((r100 instanceof Number) == false) goto L9;
        return Long.valueOf(((Number) r100).longValue());
    L9:
        if ((r100 instanceof String) == true) goto L15;
        return null;
    L15:
        return StringsKt.toLongOrNull((String) r100);
    }

    public static final void d(final JSONObject r100, final Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putAll");
        d.c(new ECHybridExtensionsKt$putAll$1(r100, r101));
    }

    public static final void e(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (r100 > 0) goto L6;
        CommonUtilKt.g(r101);
        return;
    L6:
        final ECHybridExtensionsKt$runAfterDoFrame$countRunnable$1 r102 = new ECHybridExtensionsKt$runAfterDoFrame$countRunnable$1(r101, r100);
        CommonUtilKt.g(new ECHybridExtensionsKt$runAfterDoFrame$1(r102));
    }
}
