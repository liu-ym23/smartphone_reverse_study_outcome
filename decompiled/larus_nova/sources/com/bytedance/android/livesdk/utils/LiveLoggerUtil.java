package com.bytedance.android.livesdk.utils;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveLoggerUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158752a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LiveLoggerUtil f158753b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f158754a;

        public a(String r100) {
            this.f158754a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            qm0.a r100 = om0.c.d();     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L6
            r101.put("toast_message", this.f158754a);     // Catch: Throwable -> L6
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
            r100.logV3("livesdk_live_toast_observe", r101);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public LiveLoggerUtil() {
    }

    static {
        f158753b = new LiveLoggerUtil();
        f158752a = LazyKt.lazy(LiveLoggerUtil$enableToastLog$2.INSTANCE);
    }

    public static void a(String r100) {
        if (((Boolean) f158752a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        TTExecutors.getNormalExecutor().submit(new a(r100));
        return;
    }
}
