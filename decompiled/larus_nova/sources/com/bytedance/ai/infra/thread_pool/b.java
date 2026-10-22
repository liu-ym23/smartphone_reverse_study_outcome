package com.bytedance.ai.infra.thread_pool;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f36601b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f36602c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f36603d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HandlerDispatcher f36604e = null;

    static {
        f36600a = new a(f.f36611a);
        f36601b = new a(f.f36612b);
        new a(f.f36613c);
        f36602c = new a(f.f36614d);
        f36603d = new a(f.f36615e);
        Looper r100 = Looper.getMainLooper();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT < 28) goto L10;
        Handler r101 = Handler.createAsync(r100);
    L8:
        f36604e = HandlerDispatcherKt.from(r101, "fast-main");
        return;
    L10:
        Constructor r102 = Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L7
        r101 = (Handler) r102.newInstance(new Object[]{r100, null, Boolean.TRUE});
    L7:
        r101 = new Handler(r100);
        goto L8
    }
}
