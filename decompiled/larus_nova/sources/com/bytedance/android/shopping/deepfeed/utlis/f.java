package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f173979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static VolumeBroadcastReceiver f173980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f173981d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f173982a;

    public static final class a {
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f173983a;

        public b(Function1 r100) {
            this.f173983a = r100;
        }

        @Override // com.bytedance.android.shopping.deepfeed.utlis.i
        public final void a(int r100) {
            this.f173983a.invoke(Integer.valueOf(r100));
        }
    }

    static {
        f173979b = true;
    }

    public final void b() {
        VolumeBroadcastReceiver r100 = f173980c;
        if (r100 == null) goto L6;
        final b r101 = this.f173982a;
        Intrinsics.checkNotNullParameter(r101, "listener");
        r100.a(new VolumeBroadcastReceiver$removeListener$1(r101));
        return;
    }

    public f(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f173982a = new b(r100);
    }

    public final void a(Context r110) {
        if (f173980c == null) goto L5;
    L44:
        VolumeBroadcastReceiver r111 = f173980c;
        if (r111 == null) goto L51;
        final b r100 = this.f173982a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        r111.a(new VolumeBroadcastReceiver$addListener$1(r100));
        r111.f173966a.add(new WeakReference(r100));
        return;
    L51:
        return;
    L5:
        if (r110 == null) goto L7;
        Context r101 = r110.getApplicationContext();
    L8:
        VolumeBroadcastReceiver r102 = new VolumeBroadcastReceiver(r101);
        if (r110 == null) goto L43;
        Context r112 = r110.getApplicationContext();
        if (r112 == null) goto L43;
        IntentFilter r103 = new IntentFilter();
        r103.addAction("android.media.VOLUME_CHANGED_ACTION");
        Unit r104 = Unit.INSTANCE;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L49:
    L38:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r103);
        goto L43
    L42:
        throw e;
    L16:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L29;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r103) == false) goto L29;
        int r105 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r103, 0, null, null, 2, r112).result;     // Catch: Exception -> L38
        if (r105 != 1) goto L22;
        r112.registerReceiver(r102, r103);     // Catch: Exception -> L38
    L48:
        goto L43
    L22:
        if (r105 != 2) goto L24;
        new Intent();     // Catch: Exception -> L38
        goto L48
    L24:
        if (r105 == 3) goto L48;
        r112.registerReceiver(r102, r103);     // Catch: Exception -> L38
    L29:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L32;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L38
        r112.registerReceiver(r102, r103, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L38
        goto L48
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L34;
    L36:
        r112.registerReceiver(r102, r103);     // Catch: Exception -> L38
        goto L48
    L34:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r103) == false) goto L36;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L38
        ContextCompat.registerReceiver(r112, r102, r103, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L38
    L43:
        f173980c = r102;
        goto L44
    L7:
        r101 = null;
        goto L8
    }
}
