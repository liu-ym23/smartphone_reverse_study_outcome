package com.bytedance.android.livesdk.paas;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f154204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f154205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Class<?>> f154206c = null;

    static {
        f154206c = new LinkedHashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");
    }

    public static int b() {
        if (f154204a != 0) goto L6;
        Logger.e("LiveBuildInfos", "get liveSdkVersion = 0");
    L6:
        return f154204a;
    }

    public static void c() {
        Map<String, Class<?>> r100 = f154206c;
        if (r100.containsKey("com.bytedance.android.live.uikit.base.ConfigFunctionUtils") == false) goto L29;
    L27:
        Class r101 = (Class) ((LinkedHashMap) f154206c).get("com.bytedance.android.live.uikit.base.ConfigFunctionUtils");     // Catch: Throwable -> L22
        Object r102 = null;
        if (r101 == null) goto L13;
        Field r103 = r101.getDeclaredField("enableDefaultAllowFollowSync");     // Catch: Throwable -> L22
        if (r103 == null) goto L13;
        Object r104 = r103.get(null);     // Catch: Throwable -> L22
    L15:
        if ((r104 instanceof Boolean) == false) goto L18;
        r102 = r104;
    L18:
        Boolean r105 = (Boolean) r102;     // Catch: Throwable -> L22
        if (r105 == null) goto L24;
        boolean r106 = r105.booleanValue();     // Catch: Throwable -> L22
    L25:
        f154205b = r106;
        return;
    L24:
        r106 = false;
    L13:
        r104 = null;
    L22:
        th = move-exception;
        Logger.d("LiveBuildInfos", "get value for enableDefaultAllowFollowSync failed", th);
        goto L24
    L29:
        r100.put("com.bytedance.android.live.uikit.base.ConfigFunctionUtils", a());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Logger.d("LiveBuildInfos", "find class for com.bytedance.android.live.uikit.base.ConfigFunctionUtils failed", th);
        goto L27
    }

    public static void d(Context r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.String r0 = "initSdkVersion="
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            com.bytedance.android.livesdk.paas.b r1 = com.bytedance.android.livesdk.paas.b.f154200d     // Catch: java.lang.Exception -> L4d
            if (r1 != 0) goto L1e
            java.lang.Class<com.bytedance.android.livesdk.paas.b> r1 = com.bytedance.android.livesdk.paas.b.class
            monitor-enter(r1)     // Catch: java.lang.Exception -> L4d
            com.bytedance.android.livesdk.paas.b r2 = com.bytedance.android.livesdk.paas.b.f154200d     // Catch: java.lang.Throwable -> L1b
            if (r2 != 0) goto L19
            com.bytedance.android.livesdk.paas.b r2 = new com.bytedance.android.livesdk.paas.b     // Catch: java.lang.Throwable -> L1b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1b
            com.bytedance.android.livesdk.paas.b.f154200d = r2     // Catch: java.lang.Throwable -> L1b
        L19:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1b
            goto L1e
        L1b:
            r3 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1b
            throw r3     // Catch: java.lang.Exception -> L4d
        L1e:
            com.bytedance.android.livesdk.paas.b r3 = com.bytedance.android.livesdk.paas.b.f154200d     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = r3.a()     // Catch: java.lang.Exception -> L4d
            int r3 = com.bytedance.mt.protector.impl.string2number.CastIntegerProtector.parseInt(r3)     // Catch: java.lang.Exception -> L4d
            com.bytedance.android.livesdk.paas.c.f154204a = r3     // Catch: java.lang.Exception -> L4d
            c()     // Catch: java.lang.Exception -> L4d
            java.lang.String r3 = "LiveBuildInfos"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4d
            r1.<init>(r0)     // Catch: java.lang.Exception -> L4d
            int r0 = b()     // Catch: java.lang.Exception -> L4d
            r1.append(r0)     // Catch: java.lang.Exception -> L4d
            java.lang.String r0 = " enableDefaultAllowFollowSync="
            r1.append(r0)     // Catch: java.lang.Exception -> L4d
            boolean r0 = com.bytedance.android.livesdk.paas.c.f154205b     // Catch: java.lang.Exception -> L4d
            r1.append(r0)     // Catch: java.lang.Exception -> L4d
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L4d
            com.bytedance.common.utility.Logger.d(r3, r0)     // Catch: java.lang.Exception -> L4d
            goto L51
        L4d:
            r3 = move-exception
            r3.printStackTrace()
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.paas.c.d(android.content.Context):void");
    }
}
