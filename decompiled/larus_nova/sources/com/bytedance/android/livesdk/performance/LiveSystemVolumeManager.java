package com.bytedance.android.livesdk.performance;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveSystemVolumeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f154395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f154396b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f154397c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f154398d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f154399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f154400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f154401g;

    static {
        f154395a = LazyKt.lazy(LiveSystemVolumeManager$systemVolumeBroadcast$2.INSTANCE);
        f154396b = LazyKt.lazy(LiveSystemVolumeManager$intentFilter$2.INSTANCE);
        Lazy r100 = LazyKt.lazy(LiveSystemVolumeManager$audioManager$2.INSTANCE);
        f154397c = r100;
        f154398d = -1;
        f154399e = -1;
        f154400f = -1;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        AudioManager r102 = (AudioManager) r100.getValue();     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        Integer r103 = Integer.valueOf(r102.getStreamMaxVolume(3));     // Catch: Throwable -> L9
        f154398d = r103.intValue();     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, LiveSystemVolumeManager$systemVolumeBroadcast$2.AnonymousClass1 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L39:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (r110 == null) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L23;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L34
        if (r102 != 1) goto L13;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L13:
        if (r102 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r102 == 3) goto L41;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
    }
}
