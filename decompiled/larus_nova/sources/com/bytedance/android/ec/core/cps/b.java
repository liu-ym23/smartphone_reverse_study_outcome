package com.bytedance.android.ec.core.cps;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static final Context m() {
        return ECAppInfoService.f48114e.getApplicationContext();
    }

    public static final String n() {
        Class r100 = a();     // Catch: Throwable -> L9
        Object r101 = r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r100, new Object[]{"wifi.interface", "wlan0"});     // Catch: Throwable -> L9
        if (r101 == null) goto L8;
        return (String) r101;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L9
    L9:
        return "wlan0";
    }

    public static final Object b(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$firstInstallTime$1) == false) goto L7;
        CyberProtectionCollectorKt$firstInstallTime$1 r101 = (CyberProtectionCollectorKt$firstInstallTime$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$firstInstallTime$2 r107 = new CyberProtectionCollectorKt$firstInstallTime$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$firstInstallTime$1(r100);
        goto L8
    }

    public static final Object c(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getAvailableStorageTotal$1) == false) goto L7;
        CyberProtectionCollectorKt$getAvailableStorageTotal$1 r101 = (CyberProtectionCollectorKt$getAvailableStorageTotal$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getAvailableStorageTotal$2 r107 = new CyberProtectionCollectorKt$getAvailableStorageTotal$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getAvailableStorageTotal$1(r100);
        goto L8
    }

    public static final Object d(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getBatteryCapacity$1) == false) goto L7;
        CyberProtectionCollectorKt$getBatteryCapacity$1 r101 = (CyberProtectionCollectorKt$getBatteryCapacity$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getBatteryCapacity$2 r107 = new CyberProtectionCollectorKt$getBatteryCapacity$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getBatteryCapacity$1(r100);
        goto L8
    }

    public static final Object e(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getBatteryRemaining$1) == false) goto L7;
        CyberProtectionCollectorKt$getBatteryRemaining$1 r101 = (CyberProtectionCollectorKt$getBatteryRemaining$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getBatteryRemaining$2 r107 = new CyberProtectionCollectorKt$getBatteryRemaining$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getBatteryRemaining$1(r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object f(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getBootId$1) == false) goto L7;
        CyberProtectionCollectorKt$getBootId$1 r101 = (CyberProtectionCollectorKt$getBootId$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L23
    L22:
        return (String) r106.element;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r107 = new Ref.ObjectRef();
        r107.element = null;
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Throwable -> L24
        CyberProtectionCollectorKt$getBootId$2 r109 = new CyberProtectionCollectorKt$getBootId$2("/proc/sys/kernel/random/boot_id", r107, null);     // Catch: Throwable -> L24
        r101.L$0 = r107;     // Catch: Throwable -> L24
        r101.label = 1;     // Catch: Throwable -> L24
        if (BuildersKt.withContext(r108, r109, r101) != r104) goto L20;
        return r104;
    L20:
        r106 = r107;
    L7:
        r101 = new CyberProtectionCollectorKt$getBootId$1(r100);
        goto L8
    }

    public static final Object g(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getLibCSoHash$1) == false) goto L7;
        CyberProtectionCollectorKt$getLibCSoHash$1 r101 = (CyberProtectionCollectorKt$getLibCSoHash$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getLibCSoHash$2 r107 = new CyberProtectionCollectorKt$getLibCSoHash$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getLibCSoHash$1(r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.lang.String] */
    public static final Object h(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getMac$1) == false) goto L7;
        CyberProtectionCollectorKt$getMac$1 r101 = (CyberProtectionCollectorKt$getMac$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L33:
        r107.element = (String) r103;
        Ref.ObjectRef r108 = r107;
    L35:
        return (String) r108.element;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r109 = (Ref.ObjectRef) r101.L$1;
        Ref.ObjectRef r110 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r111 = r109;
        r108 = r110;
    L20:
        r111.element = (String) r103;
        String r112 = (String) r108.element;
        if (r112 != null) goto L23;
    L26:
        if (r106 == false) goto L28;
    L29:
        CoroutineDispatcher r113 = Dispatchers.getIO();
        CyberProtectionCollectorKt$getMac$2 r114 = new CyberProtectionCollectorKt$getMac$2(null);
        r101.L$0 = r108;
        r101.L$1 = null;
        r101.label = 2;
        r103 = BuildersKt.withContext(r113, r114, r101);
        if (r103 == r104) goto L37;
        r107 = r108;
        goto L33
    L37:
        return r104;
    L28:
        if (Intrinsics.areEqual((String) r108.element, "02:00:00:00:00:00") == false) goto L35;
    L23:
        if (StringsKt.isBlank(r112) == true) goto L26;
        r106 = false;
        goto L26
    L16:
        ResultKt.throwOnFailure(r103);
        r108 = new Ref.ObjectRef();
        CoroutineDispatcher r115 = Dispatchers.getIO();
        CyberProtectionCollectorKt$getMac$macAddress$1 r116 = new CyberProtectionCollectorKt$getMac$macAddress$1(null);
        r101.L$0 = r108;
        r101.L$1 = r108;
        r101.label = 1;
        r103 = BuildersKt.withContext(r115, r116, r101);
        if (r103 == r104) goto L36;
        r111 = r108;
        goto L20
    L36:
        return r104;
    L7:
        r101 = new CyberProtectionCollectorKt$getMac$1(r100);
        goto L8
    }

    public static final Object i(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getSignHash$1) == false) goto L7;
        CyberProtectionCollectorKt$getSignHash$1 r101 = (CyberProtectionCollectorKt$getSignHash$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getSignHash$2 r107 = new CyberProtectionCollectorKt$getSignHash$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getSignHash$1(r100);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0197 -> B:74:0x019b). Please report as a decompilation issue!!! */
    public static final Object j(Continuation r210) {
        if ((r210 instanceof CyberProtectionCollectorKt$getStatData$1) == false) goto L7;
        CyberProtectionCollectorKt$getStatData$1 r100 = (CyberProtectionCollectorKt$getStatData$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 4;
        if (r104 == 0) goto L24;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L18;
        if (r104 != 3) goto L17;
        int r106 = r100.I$2;
        int r110 = r100.I$1;
        int r111 = r100.I$0;
        String[] r112 = (String[]) r100.L$4;
        String[] r107 = (String[]) r100.L$3;
        ArrayList r108 = (ArrayList) r100.L$2;
        String[] r109 = (String[]) r100.L$1;
        ArrayList r113 = (ArrayList) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L60
        String[] r114 = r107;
        int r115 = r110;
        String[] r116 = r112;
        Object r117 = null;
        String[] r118 = r109;
        ArrayList r119 = r108;
    L74:
        String r120 = (String) r102;     // Catch: Throwable -> L67
        if (r120 != null) goto L59;
        r120 = "none";
    L59:
        r116[r106] = r120;     // Catch: Throwable -> L67
        r119.add(ArraysKt.joinToString$default(r114, ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L67
        int r121 = r111 + 1;     // Catch: Throwable -> L67
        r105 = 4;
    L26:
        if (r121 >= r115) goto L63;
        String r122 = r118[r121];     // Catch: Throwable -> L60
        String[] r123 = new String[3];     // Catch: Throwable -> L60
        String[] r124 = new String[r105];     // Catch: Throwable -> L60
        r124[0] = CloudControlInf.STAT;     // Catch: Throwable -> L60
        r124[1] = "-c";     // Catch: Throwable -> L60
        r124[2] = "%X";     // Catch: Throwable -> L60
        r124[3] = r122;     // Catch: Throwable -> L60
        r100.L$0 = r113;     // Catch: Throwable -> L60
        r100.L$1 = r122;     // Catch: Throwable -> L60
        r100.L$2 = r118;     // Catch: Throwable -> L60
        r100.L$3 = r113;     // Catch: Throwable -> L60
        r100.L$4 = r123;     // Catch: Throwable -> L60
        r100.L$5 = r123;     // Catch: Throwable -> L60
        r100.I$0 = r121;     // Catch: Throwable -> L60
        r100.I$1 = r115;     // Catch: Throwable -> L60
        r100.I$2 = 0;     // Catch: Throwable -> L60
        r100.label = 1;     // Catch: Throwable -> L60
        Object r125 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r124, null), r100);     // Catch: Throwable -> L60
        if (r125 == r103) goto L76;
        String r126 = r122;
        ArrayList r127 = r113;
        r119 = r127;
        int r128 = 0;
        int r129 = r121;
        r102 = r125;
        String[] r130 = r123;
    L34:
        String r131 = (String) r102;     // Catch: Throwable -> L60
        if (r131 != null) goto L37;
        r131 = "none";
    L37:
        r130[r128] = r131;     // Catch: Throwable -> L60
        String[] r132 = new String[r105];     // Catch: Throwable -> L60
        r132[0] = CloudControlInf.STAT;     // Catch: Throwable -> L60
        r132[1] = "-c";     // Catch: Throwable -> L60
        r132[2] = "%Y";     // Catch: Throwable -> L60
        r132[3] = r126;     // Catch: Throwable -> L60
        r100.L$0 = r127;     // Catch: Throwable -> L60
        r100.L$1 = r126;     // Catch: Throwable -> L60
        r100.L$2 = r118;     // Catch: Throwable -> L60
        r100.L$3 = r119;     // Catch: Throwable -> L60
        r100.L$4 = r123;     // Catch: Throwable -> L60
        r100.L$5 = r123;     // Catch: Throwable -> L60
        r100.I$0 = r129;     // Catch: Throwable -> L60
        r100.I$1 = r115;     // Catch: Throwable -> L60
        r100.I$2 = 1;     // Catch: Throwable -> L60
        r100.label = 2;     // Catch: Throwable -> L60
        r102 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r132, null), r100);     // Catch: Throwable -> L60
        if (r102 == r103) goto L76;
        r111 = r129;
        int r133 = 1;
        r113 = r127;
        String[] r134 = r123;
    L44:
        String r135 = (String) r102;     // Catch: Throwable -> L60
        if (r135 != null) goto L47;
        r135 = "none";
    L47:
        r123[r133] = r135;     // Catch: Throwable -> L60
        String[] r136 = {CloudControlInf.STAT, "-c", "%i", r126};     // Catch: Throwable -> L60
        r100.L$0 = r113;     // Catch: Throwable -> L60
        r100.L$1 = r118;     // Catch: Throwable -> L60
        r100.L$2 = r119;     // Catch: Throwable -> L60
        r100.L$3 = r134;     // Catch: Throwable -> L60
        r100.L$4 = r134;     // Catch: Throwable -> L60
        r100.L$5 = null;     // Catch: Throwable -> L61
        r100.I$0 = r111;     // Catch: Throwable -> L60
        r100.I$1 = r115;     // Catch: Throwable -> L60
        r100.I$2 = 2;     // Catch: Throwable -> L60
        r100.label = 3;     // Catch: Throwable -> L60
        r117 = null;
        r102 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollectorKt$runShell$2(r136, null), r100);     // Catch: Throwable -> L67
        if (r102 == r103) goto L76;
        r116 = r134;
        r114 = r116;
        r106 = 2;
    L61:
        r117 = null;
    L62:
        r117 = null;
    L76:
        return r103;
    L63:
        r117 = null;
        return CollectionsKt.joinToString$default(r113, com.alipay.sdk.m.u.i.f25853b, null, null, 0, null, null, 62, null);
    L66:
        return r117;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r137 = r100.I$2;
        r115 = r100.I$1;
        int r138 = r100.I$0;
        r123 = (String[]) r100.L$5;
        String[] r139 = (String[]) r100.L$4;
        ArrayList r140 = (ArrayList) r100.L$3;
        String[] r141 = (String[]) r100.L$2;
        r126 = (String) r100.L$1;
        ArrayList r142 = (ArrayList) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L60
        r133 = r137;
        r134 = r139;
        r119 = r140;
        r118 = r141;
        r111 = r138;
        r113 = r142;
        goto L44
    L21:
        int r143 = r100.I$2;
        r115 = r100.I$1;
        r129 = r100.I$0;
        r130 = (String[]) r100.L$5;
        r123 = (String[]) r100.L$4;
        r119 = (ArrayList) r100.L$3;
        r118 = (String[]) r100.L$2;
        String r144 = (String) r100.L$1;
        ArrayList r145 = (ArrayList) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L60
        r128 = r143;
        r127 = r145;
        r126 = r144;
        goto L34
    L24:
        ResultKt.throwOnFailure(r102);
        r118 = new String[]{"/data/local/tmp", "/sdcard/Download", "/sdcard/Android", "/sdcard/DCIM"};
        r113 = new ArrayList(4);     // Catch: Throwable -> L60
        r121 = 0;
        r115 = 4;
    L60:
        r117 = null;
    L7:
        r100 = new CyberProtectionCollectorKt$getStatData$1(r210);
        goto L8
    }

    public static final Object k(Continuation r100) {
        if ((r100 instanceof CyberProtectionCollectorKt$getStorageTotal$1) == false) goto L7;
        CyberProtectionCollectorKt$getStorageTotal$1 r101 = (CyberProtectionCollectorKt$getStorageTotal$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L20
    L19:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        CoroutineDispatcher r106 = Dispatchers.getIO();     // Catch: Throwable -> L20
        CyberProtectionCollectorKt$getStorageTotal$2 r107 = new CyberProtectionCollectorKt$getStorageTotal$2(null);     // Catch: Throwable -> L20
        r101.label = 1;     // Catch: Throwable -> L20
        r103 = BuildersKt.withContext(r106, r107, r101);     // Catch: Throwable -> L20
        if (r103 != r104) goto L19;
        return r104;
    L21:
        return null;
    L7:
        r101 = new CyberProtectionCollectorKt$getStorageTotal$1(r100);
        goto L8
    }

    public static byte[] l(NetworkInterface r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, "byte[]", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, null, r111, false);
        return (byte[]) r112.f474983b;
    L6:
        byte[] r113 = r110.getHardwareAddress();
        r100.a(101701, "java/net/NetworkInterface", "getHardwareAddress", r110, r101, r113, r111, true);
        return r113;
    }
}
