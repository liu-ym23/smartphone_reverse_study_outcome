package com.bytedance.android.live.core.utils;

import android.os.Handler;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class AnchorMainPostOptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f66046a = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f66047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f66048b;

        public a(String r100, Runnable r101) {
            this.f66047a = r100;
            this.f66048b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnchorMainPostOptUtils.b(this.f66047a, this.f66048b);
        }
    }

    @JvmStatic
    public static final void a() {
        com.bytedance.android.livesdk.config.b0.f119832a = false;
        ((Handler) f66046a.getValue()).removeCallbacksAndMessages(null);
    }

    static {
        f66046a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AnchorMainPostOptUtils$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final void b(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L10;
        if (r100 != null) goto L7;
        r100 = "UnKnown";
    L7:
        if (v.a() == false) goto L9;
        r101 = new c(r101, r100);
    L9:
        ((Handler) f66046a.getValue()).post(r101);
        return;
    L10:
        r101.run();
    }

    @JvmStatic
    public static final void d(DataCenter r100, LifecycleOwner r101, Runnable r102) {
        Intrinsics.checkNotNullParameter("showCountDownView", "methodName");
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r102, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L16;
        if (r100 == null) goto L18;
        Observable r103 = RxUtilKt.b(r100, "cmd_p0_widget_loaded", true);
        if (r103 == null) goto L19;
        Observable r104 = r103.take(1);
        if (r104 == null) goto L20;
        Observable r105 = r104.delay(300, TimeUnit.MILLISECONDS);
        if (r105 == null) goto L21;
        Observable r106 = r105.observeOn(AndroidSchedulers.mainThread());
        if (r106 == null) goto L22;
        ObservableSubscribeProxy r107 = (ObservableSubscribeProxy) r106.as(AutoDispose.bind(r101));
        if (r107 == null) goto L23;
        r107.subscribe(new b(r102));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L16:
        r102.run();
    }

    @JvmStatic
    public static final void c(String r100, DataCenter r101, LifecycleOwner r102, Runnable r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r103, "runnable");
        if (com.bytedance.android.livesdk.config.b0.a() == false) goto L16;
        if (r101 == null) goto L18;
        Observable r104 = RxUtilKt.b(r101, "cmd_widget_loaded", true);
        if (r104 == null) goto L19;
        Observable r105 = r104.take(1);
        if (r105 == null) goto L20;
        Observable r106 = r105.delay(200, TimeUnit.MILLISECONDS);
        if (r106 == null) goto L21;
        Observable r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L22;
        ObservableSubscribeProxy r108 = (ObservableSubscribeProxy) r107.as(AutoDispose.bind(r102));
        if (r108 == null) goto L23;
        r108.subscribe(new a(r100, r103));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L16:
        r103.run();
    }
}
