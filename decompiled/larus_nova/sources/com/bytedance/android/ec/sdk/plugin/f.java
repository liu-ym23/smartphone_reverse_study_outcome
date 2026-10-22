package com.bytedance.android.ec.sdk.plugin;

import com.bytedance.android.ec.base.service.ECServiceManager;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48154a = 0;

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Boolean, Unit> f48155a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "res");
            this.f48155a = r100;
        }

        @Override // com.bytedance.android.ec.sdk.plugin.g
        public final void a(boolean r100) {
            this.f48155a.invoke(Boolean.valueOf(r100));
        }
    }

    static {
    }

    public static void a(pl.a r100, Function1 r101) {
        PluginLoader.f48148e.getClass();
        Lazy r102 = PluginLoader.f48147d;
        boolean r103 = true;
        boolean r104 = false;
        if (((PluginLoader) r102.getValue()).f48149a != 2) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L45;
        if (r101 == null) goto L9;
        PluginLoader r106 = (PluginLoader) r102.getValue();
        a r107 = new a(r101);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f48150b.add(r107);
    L9:
        PluginLoader r108 = (PluginLoader) r102.getValue();
        if (r108.f48149a < 0) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == true) goto L29;
        monitor-enter(r108);
    L42:
        th = move-exception;
        throw th;
    L17:
        if (r108.f48149a < 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L23;
        monitor-exit(r108);
        goto L29
    L23:
        r108.f48149a = 0;     // Catch: Throwable -> L42
        boolean r111 = ECServiceManager.f42805a;     // Catch: Throwable -> L42
        hj.c r112 = (hj.c) ECServiceManager.b(hj.c.class);     // Catch: Throwable -> L42
        if (r112 == null) goto L26;
        r112.init();     // Catch: Throwable -> L42
    L26:
        System.out.println("Django ==> plugin start init...");     // Catch: Throwable -> L42
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r108);
        goto L29
    L19:
        r110 = false;
    L29:
        if (r108.f48149a == 2) goto L32;
        r103 = false;
    L32:
        if (r103 == false) goto L34;
        r108.c();
        return;
    L34:
        boolean r114 = ECServiceManager.f42805a;
        hj.c r115 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r115 == null) goto L37;
        r104 = r115.a();
    L37:
        if (r104 == false) goto L39;
        r108.b();
        return;
    L39:
        hj.c r116 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r116 == null) goto L52;
        r116.d();
        return;
    L52:
        return;
    L12:
        r109 = false;
        goto L13
    L45:
        if (r101 == null) goto L54;
        Unit r117 = (Unit) r101.invoke(Boolean.TRUE);
        return;
    L54:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
