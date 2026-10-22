package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ScreenShotUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f66075a;

    public interface a {
        ILivePlayerClient currentClient();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f66076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f66077b;

        public b(Bitmap r100, Function1 r101) {
            this.f66076a = r100;
            this.f66077b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f66077b.invoke(this.f66076a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @JvmStatic
    public static final void b(Activity r100, final Function1<? super Bitmap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100 == null) goto L13;
        final Window r102 = r100.getWindow();
        if (r102 == null) goto L13;
        final Bitmap r103 = Bitmap.createBitmap(a(r102).getWidth(), a(r102).getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas r104 = new Canvas(r103);
        a r105 = f66075a;
        if (r105 == null) goto L9;
        ILivePlayerClient r106 = r105.currentClient();
    L10:
        if (r106 == null) goto L12;
        final ILivePlayerClient r107 = r106;
        r106.saveFrame(new ScreenShotUtils$shot$$inlined$run$lambda$1(r102, r107, r104, r103, r101));
        return;
    L12:
        a(r102).draw(r104);
        a(r102).post(new b(r103, r101));
        return;
    L9:
        r106 = null;
    L13:
        ALogger.w("ScreenShotUtils", "window为空，截屏失败");
    }
}
