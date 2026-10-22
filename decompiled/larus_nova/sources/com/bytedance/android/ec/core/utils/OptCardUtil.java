package com.bytedance.android.ec.core.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class OptCardUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f45543a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f45544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f45545c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f45546d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f45547e;

    public static final class a extends HandlerExecutorServiceImpl {
        public a(Handler r100) {
            super(r100);
        }

        @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (isHandlerThread() == false) goto L6;
            r100.run();
            return;
        L6:
            boolean r101 = OptCardUtil.f45543a;
            OptCardUtil.f45544b.postAtFrontOfQueue(r100);
        }
    }

    static {
        f45543a = ECAppInfoService.f48114e.isLocalTest();
        Handler r100 = new Handler(Looper.getMainLooper());
        f45544b = r100;
        f45545c = new a(r100);
        f45546d = LazyKt.lazy(OptCardUtil$fieldUIExecutor$2.INSTANCE);
    }

    public static void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        Lazy r101 = f45546d;     // Catch: Exception -> L6
        Field r102 = (Field) r101.getValue();     // Catch: Exception -> L6
        if (r102 == null) goto L9;
        r102.set(r100, f45545c);     // Catch: Exception -> L6
    L9:
        if (((Field) r101.getValue()) == null) goto L11;
        b("image", "change executor success");     // Catch: Exception -> L6
        return;
    L11:
        b("image", "change executor fail: field is null");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b("image", "change executor fail " + e);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f45543a == false) goto L10;
        dm.a.b r102 = dm.a.f469202a;
        if (r100 != null) goto L7;
        String r103 = "ec-opt-card";
    L8:
        dm.a.a(r103).i(r101);
        return;
    L7:
        r103 = "ec-opt-card_".concat(r100);
        goto L8
    }
}
