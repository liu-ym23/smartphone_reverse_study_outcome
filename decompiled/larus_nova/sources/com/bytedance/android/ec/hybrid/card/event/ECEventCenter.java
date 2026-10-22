package com.bytedance.android.ec.hybrid.card.event;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.service.IECEventCenterService;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECEventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46471a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f46472b = null;

    public static IECEventCenterService d() {
        return (IECEventCenterService) f46471a.getValue();
    }

    static {
        f46471a = LazyKt.lazy(ECEventCenter$eventCenterService$2.INSTANCE);
        f46472b = LazyKt.lazy(ECEventCenter$clearSubscriberOptEnable$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(Function1<? super f, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        d().c(r100);
    }

    @JvmStatic
    public static final void b(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        a(new ECEventCenter$clearSubscriberWith$1(r100));
        if (((Boolean) f46472b.getValue()).booleanValue() == false) goto L6;
        ECHybridExtensionsKt.c().postDelayed(new ECEventCenter$clearSubscriberWith$2(r100), 5000);
        return;
    }

    @JvmStatic
    public static final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d().a(r100);
    }

    @JvmStatic
    public static final void f(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        d().g(r100, r101);
    }

    public static void e(String r100, e r101, String r102) {
        long r103 = System.currentTimeMillis();
        String r104 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        Intrinsics.checkNotNullParameter(r102, "sceneID");
        Intrinsics.checkNotNullParameter(r104, "containerId");
        d().b(r100, r101, r102, r103, r104);
    }
}
