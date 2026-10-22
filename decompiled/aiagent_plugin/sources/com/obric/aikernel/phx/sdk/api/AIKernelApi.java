package com.obric.aikernel.phx.sdk.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.AIKListener;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.core.api.CloudBizApi;
import com.obric.aikernel.phx.core.api.ScriptBizApi;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.core.conn.ChildProcessLifecycleBinding;
import com.obric.aikernel.phx.core.conn.ProcessLifecycleHandle;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.phx.BuildConfig;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.n;
import d.x;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AIKernelApi implements IAIKernelManager {
    public static final Companion Companion = null;
    private static final long FIRST_CONNECT_TIMEOUT = 15000;
    public static final String TAG = "AIKernelApi";
    private ServiceConnector connector;
    private final w<ServiceConnector> connectorReady;
    private volatile boolean hasConnectedOnce;
    private boolean legacyArch;
    private final q<Context, AIKernelConfig, ComponentName, ServiceConnector> serviceConnectorFactory;
    private volatile String servicePackageName;
    private final am transactScope;

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    static final class AnonymousClass1 extends p implements q<Context, AIKernelConfig, ComponentName, ServiceConnector> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ ServiceConnector invoke(Context r3, AIKernelConfig r4, ComponentName r5) {
            return invoke2((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), (AIKernelConfig) ZeusTransformUtils.preCheckCast(r4, AIKernelConfig.class, "com.obric.aiagent.plugin"), (ComponentName) ZeusTransformUtils.preCheckCast(r5, ComponentName.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ServiceConnector invoke2(Context r2, AIKernelConfig r3, ComponentName r4) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r3, "config");
            o.e(r4, "component");
            return new ServiceConnector(r1, r3, r4);
        }
    }

    /* JADX INFO: compiled from: AIKernelApi.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: AIKernelApi.kt */
        public static final class LoadedPackage {
            private final AIKBinder binder;
            private final String targetProcess;

            public static /* synthetic */ LoadedPackage copy$default(LoadedPackage r1, AIKBinder r2, String r3, int r4, Object r5) {
                AIKBinder r6 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r2, AIKBinder.class, "com.obric.aiagent.plugin");
                if ((r4 & 1) == 0) goto L6;
                r6 = r1.binder;
            L6:
                if ((r4 & 2) == 0) goto L9;
                r3 = r1.targetProcess;
            L9:
                return r1.copy(r6, r3);
            }

            public final AIKBinder component1() {
                return this.binder;
            }

            public final String component2() {
                return this.targetProcess;
            }

            public final LoadedPackage copy(AIKBinder r2, String r3) {
                AIKBinder r1 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r2, AIKBinder.class, "com.obric.aiagent.plugin");
                o.e(r1, "binder");
                return new LoadedPackage(r1, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, LoadedPackage.class) == true) goto L8;
                return false;
            L8:
                LoadedPackage r6 = (LoadedPackage) ZeusTransformUtils.preCheckCast(r5, LoadedPackage.class, "com.obric.aiagent.plugin");
                if (o.a(this.binder, r6.binder) == true) goto L12;
                return false;
            L12:
                if (o.a(this.targetProcess, r6.targetProcess) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                int r0 = this.binder.hashCode() * 31;
                String r1 = this.targetProcess;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public String toString() {
                return "LoadedPackage(binder=" + this.binder + ", targetProcess=" + this.targetProcess + ')';
            }

            public LoadedPackage(AIKBinder r3, String r4) {
                AIKBinder r5 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin");
                o.e(r5, "binder");
                this.binder = r5;
                this.targetProcess = r4;
            }

            public final AIKBinder getBinder() {
                return this.binder;
            }

            public final String getTargetProcess() {
                return this.targetProcess;
            }
        }

        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v12, types: [T, kotlinx.coroutines.ca] */
        /* JADX INFO: renamed from: getPackageInfos-BWLJW6A, reason: not valid java name */
        public final Object m405getPackageInfosBWLJW6A(AIKBinder r26, List<String> r27, RequestParams r28, d<? super n<? extends List<PackageResource>>> r29) {
            AIKBinder r0 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r26, AIKBinder.class, "com.obric.aiagent.plugin");
            ?? r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r29, d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$getPackageInfos$1.class) == false) goto L7;
            AIKernelApi$Companion$getPackageInfos$1 r4 = (AIKernelApi$Companion$getPackageInfos$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$getPackageInfos$1.class, "com.obric.aiagent.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = b.a();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$4, Bundle.class, "com.obric.aiagent.plugin");
            z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$3, z.f.class, "com.obric.aiagent.plugin");
            g r9 = (g) ZeusTransformUtils.preCheckCast(r4.L$2, g.class, "com.obric.aiagent.plugin");
            List r10 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.aiagent.plugin");
            AIKBinder r11 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            r2 = r8;
        L32:
            Object r12 = ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L20
            ca r13 = (ca) ZeusTransformUtils.preCheckCast(r2.f38504a, ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            if (r13 == null) goto L35;
            ca.a.a(r13, null, 1, null);     // Catch: Throwable -> L20
        L35:
            AIKLog r14 = AIKLog.INSTANCE;     // Catch: Throwable -> L20
            StringBuilder r15 = new StringBuilder().append("[SDK] end getPackageInfos: ");     // Catch: Throwable -> L20
            if (n.b(r12) == false) goto L38;
            Object r16 = null;
        L39:
            r14.i(AIKernelApi.TAG, r15.append(r16).append(' ').append(n.c(r12)).toString());     // Catch: Throwable -> L20
            return ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a();
        L38:
            r16 = r12;
            goto L39
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            z.f r17 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$3, z.f.class, "com.obric.aiagent.plugin");
            g r18 = (g) ZeusTransformUtils.preCheckCast(r4.L$2, g.class, "com.obric.aiagent.plugin");
            List r19 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.aiagent.plugin");
            AIKBinder r110 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            g r20 = r18;
            r0 = r110;
            Object r111 = r5;
            z.f r21 = r17;
            final ?? r22 = r19;
        L26:
            Bundle r112 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r111, Bundle.class, "com.obric.aiagent.plugin"), null, IdlKeys.Method_GetPackageRes, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "getPackageInfos", null, false, 201, null);     // Catch: Throwable -> L41
            r112.putStringArray(IdlKeys.Args_Pkgs, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r22;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.L$4 = r112;     // Catch: Throwable -> L41
            r4.label = 2;     // Catch: Throwable -> L41
            kotlinx.coroutines.o r113 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L41
            r113.e();     // Catch: Throwable -> L41
            final kotlinx.coroutines.n r23 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r113, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
            r21.f38504a = BinderMonitor.INSTANCE.monitorTransact(r20, r0, (a) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$getPackageInfos$2$1(r23), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r0.callModel(r112, (AIKListener) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$getPackageInfos$2$2(r23, r22), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r5 = r113.h();     // Catch: Throwable -> L41
            if (r5 != b.a()) goto L29;
            d.c.b.a.h.c((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            Throwable r114 = th;
            ?? r24 = r21;
        L43:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] getPackageInfos error: " + r114);
            ca r25 = (ca) ZeusTransformUtils.preCheckCast(r24.f38504a, ca.class, "com.obric.aiagent.plugin");
            if (r25 == null) goto L46;
            ca.a.a(r25, null, 1, null);
        L46:
            n.a r30 = n.f38560a;
            return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Got remote error.", r114, 0, 8, null), Throwable.class, "com.obric.aiagent.plugin")));
        L29:
            if (r5 != r6) goto L31;
            return r6;
        L31:
            r2 = r21;
            goto L32
        L22:
            d.o.a(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start getPackageInfos count:" + r2.size());
            r20 = r4.getContext();
            r21 = new z.f();
            ParamsCompat r115 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r2;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.label = 1;     // Catch: Throwable -> L41
            r111 = r115.startCompat(r28, r4);     // Catch: Throwable -> L41
            r22 = r2;
            if (r111 != r6) goto L26;
            return r6;
        L20:
            th = move-exception;
            r114 = th;
            r24 = r2;
        L7:
            r4 = new AIKernelApi$Companion$getPackageInfos$1(this, r3);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v12, types: [T, kotlinx.coroutines.ca] */
        /* JADX INFO: renamed from: updatePackages-BWLJW6A, reason: not valid java name */
        public final Object m406updatePackagesBWLJW6A(AIKBinder r26, List<PackageResource> r27, RequestParams r28, d<? super n<? extends List<PackageResource>>> r29) {
            AIKBinder r0 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r26, AIKBinder.class, "com.obric.aiagent.plugin");
            ?? r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.aiagent.plugin");
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r29, d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$updatePackages$1.class) == false) goto L7;
            AIKernelApi$Companion$updatePackages$1 r4 = (AIKernelApi$Companion$updatePackages$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$updatePackages$1.class, "com.obric.aiagent.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = b.a();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$3, Bundle.class, "com.obric.aiagent.plugin");
            z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$2, z.f.class, "com.obric.aiagent.plugin");
            g r9 = (g) ZeusTransformUtils.preCheckCast(r4.L$1, g.class, "com.obric.aiagent.plugin");
            AIKBinder r10 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            r2 = r8;
        L32:
            Object r11 = ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L20
            ca r12 = (ca) ZeusTransformUtils.preCheckCast(r2.f38504a, ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            if (r12 == null) goto L35;
            ca.a.a(r12, null, 1, null);     // Catch: Throwable -> L20
        L35:
            AIKLog r13 = AIKLog.INSTANCE;     // Catch: Throwable -> L20
            StringBuilder r14 = new StringBuilder().append("[SDK] end updatePackages: ");     // Catch: Throwable -> L20
            if (n.b(r11) == false) goto L38;
            Object r15 = null;
        L39:
            r13.i(AIKernelApi.TAG, r14.append(r15).append(' ').append(n.c(r11)).toString());     // Catch: Throwable -> L20
            return ((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).a();
        L38:
            r15 = r11;
            goto L39
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            z.f r16 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$3, z.f.class, "com.obric.aiagent.plugin");
            g r17 = (g) ZeusTransformUtils.preCheckCast(r4.L$2, g.class, "com.obric.aiagent.plugin");
            List r18 = (List) ZeusTransformUtils.preCheckCast(r4.L$1, List.class, "com.obric.aiagent.plugin");
            AIKBinder r19 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            g r20 = r17;
            r0 = r19;
            Object r110 = r5;
            z.f r21 = r16;
            ?? r22 = r18;
        L26:
            Bundle r111 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r110, Bundle.class, "com.obric.aiagent.plugin"), null, IdlKeys.Method_UpdatePackages, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "updatePackages", null, false, 201, null);     // Catch: Throwable -> L41
            r111.putParcelableArray(IdlKeys.Args_Pkgs, (Parcelable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.aiagent.plugin")).toArray(new PackageResource[0]), Parcelable[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r20;     // Catch: Throwable -> L41
            r4.L$2 = r21;     // Catch: Throwable -> L41
            r4.L$3 = r111;     // Catch: Throwable -> L41
            r4.label = 2;     // Catch: Throwable -> L41
            kotlinx.coroutines.o r23 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L41
            r23.e();     // Catch: Throwable -> L41
            final kotlinx.coroutines.n r24 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r23, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
            r21.f38504a = BinderMonitor.INSTANCE.monitorTransact(r20, r0, (a) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$updatePackages$2$1(r24), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r0.callModel(r111, (AIKListener) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$updatePackages$2$2(r24), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
            r5 = r23.h();     // Catch: Throwable -> L41
            if (r5 != b.a()) goto L29;
            d.c.b.a.h.c((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            Throwable r112 = th;
            ?? r25 = r21;
        L43:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] updatePackages error: " + r112);
            ca r30 = (ca) ZeusTransformUtils.preCheckCast(r25.f38504a, ca.class, "com.obric.aiagent.plugin");
            if (r30 == null) goto L46;
            ca.a.a(r30, null, 1, null);
        L46:
            n.a r31 = n.f38560a;
            return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Got remote error.", r112, 0, 8, null), Throwable.class, "com.obric.aiagent.plugin")));
        L29:
            if (r5 != r6) goto L31;
            return r6;
        L31:
            r2 = r21;
            goto L32
        L22:
            d.o.a(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start updatePackages count:" + r2.size());
            r20 = r4.getContext();
            r21 = new z.f();
            ParamsCompat r113 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L41
            r4.L$0 = r0;     // Catch: Throwable -> L41
            r4.L$1 = r2;     // Catch: Throwable -> L41
            r4.L$2 = r20;     // Catch: Throwable -> L41
            r4.L$3 = r21;     // Catch: Throwable -> L41
            r4.label = 1;     // Catch: Throwable -> L41
            r110 = r113.startCompat(r28, r4);     // Catch: Throwable -> L41
            r22 = r2;
            if (r110 != r6) goto L26;
            return r6;
        L20:
            th = move-exception;
            r112 = th;
            r25 = r2;
        L7:
            r4 = new AIKernelApi$Companion$updatePackages$1(this, r3);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, kotlinx.coroutines.ca] */
        /* JADX WARN: Type inference failed for: r12v3, types: [com.obric.aikernel.phx.core.conn.BinderMonitor] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.aikernel.AIKBinder, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.aikernel.AIKBinder, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9, types: [d.h.b.z$f] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final Object loadPackage$sdk_release(AIKBinder r24, String r25, RequestParams r26, d<? super LoadedPackage> r27) {
            ?? r1 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r24, AIKBinder.class, "com.obric.aiagent.plugin");
            d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r27, d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, AIKernelApi$Companion$loadPackage$1.class) == false) goto L7;
            AIKernelApi$Companion$loadPackage$1 r4 = (AIKernelApi$Companion$loadPackage$1) ZeusTransformUtils.preCheckCast(r3, AIKernelApi$Companion$loadPackage$1.class, "com.obric.aiagent.plugin");
            if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
            r4.label -= Integer.MIN_VALUE;
        L8:
            Object r5 = r4.result;
            Object r6 = b.a();
            int r7 = r4.label;
            if (r7 == 0) goto L22;
            if (r7 == 1) goto L17;
            if (r7 != 2) goto L16;
            Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(r4.L$3, Bundle.class, "com.obric.aiagent.plugin");
            z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$2, z.f.class, "com.obric.aiagent.plugin");
            g r8 = (g) ZeusTransformUtils.preCheckCast(r4.L$1, g.class, "com.obric.aiagent.plugin");
            AIKBinder r9 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            r1 = r2;
        L33:
            LoadedPackage r10 = (LoadedPackage) ZeusTransformUtils.preCheckCast(r5, LoadedPackage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            ca r11 = (ca) ZeusTransformUtils.preCheckCast(r1.f38504a, ca.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
            if (r11 == null) goto L36;
            ca.a.a(r11, null, 1, null);     // Catch: Throwable -> L20
        L36:
            return r5;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            z.f r12 = (z.f) ZeusTransformUtils.preCheckCast(r4.L$3, z.f.class, "com.obric.aiagent.plugin");
            g r13 = (g) ZeusTransformUtils.preCheckCast(r4.L$2, g.class, "com.obric.aiagent.plugin");
            String r14 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.aiagent.plugin");
            AIKBinder r15 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
            d.o.a(r5);     // Catch: Throwable -> L20
            String r16 = r14;
            z.f r17 = r12;
            ?? r18 = r15;
        L27:
            Bundle r19 = BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.aiagent.plugin"), r16, IdlKeys.Method_LoadPackage, IdlKeys.Call_Type_CallBiz, null, AIKernelApi.TAG, "loadPackage", null, false, 200, null);     // Catch: Throwable -> L37
            r4.L$0 = r18;     // Catch: Throwable -> L37
            r4.L$1 = r13;     // Catch: Throwable -> L37
            r4.L$2 = r17;     // Catch: Throwable -> L37
            r4.L$3 = r19;     // Catch: Throwable -> L37
            r4.label = 2;     // Catch: Throwable -> L37
            kotlinx.coroutines.o r110 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L37
            r110.e();     // Catch: Throwable -> L37
            final kotlinx.coroutines.n r20 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r110, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            r17.f38504a = BinderMonitor.INSTANCE.monitorTransact(r13, r18, (a) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$loadPackage$2$1(r20), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
            r18.callModel(r19, (AIKListener) ZeusTransformUtils.preCheckCast(new AIKernelApi$Companion$loadPackage$2$2(r20), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
            r5 = r110.h();     // Catch: Throwable -> L37
            if (r5 != b.a()) goto L30;
            d.c.b.a.h.c((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        L37:
            th = th;
            r1 = r17;
        L39:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] loadPackage error: " + th);
            ca r21 = (ca) ZeusTransformUtils.preCheckCast(r1.f38504a, ca.class, "com.obric.aiagent.plugin");
            if (r21 == null) goto L42;
            ca.a.a(r21, null, 1, null);
        L42:
            return null;
        L30:
            if (r5 != r6) goto L32;
            return r6;
        L32:
            r1 = r17;
            goto L33
        L22:
            d.o.a(r5);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start loadPackage " + r25);
            g r22 = r4.getContext();
            r17 = new z.f();
            ParamsCompat r111 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L37
            r4.L$0 = r1;     // Catch: Throwable -> L37
            r4.L$1 = r25;     // Catch: Throwable -> L37
            r4.L$2 = r22;     // Catch: Throwable -> L37
            r4.L$3 = r17;     // Catch: Throwable -> L37
            r4.label = 1;     // Catch: Throwable -> L37
            Object r112 = r111.startCompat(r26, r4);     // Catch: Throwable -> L37
            if (r112 != r6) goto L26;
            return r6;
        L26:
            r16 = r25;
            r13 = r22;
            r5 = r112;
            r18 = r1;
        L20:
            th = th;
        L7:
            r4 = new AIKernelApi$Companion$loadPackage$1(this, r3);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$clearAIKernelData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {299}, d = "clearAIKernelData", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi")
    static final class C11281 extends d.c.b.a.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C11281(AIKernelApi r3, d<? super C11281> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clearAIKernelData(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$getBinder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {155, 160, 169}, d = "getBinder", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi")
    static final class C11291 extends d.c.b.a.d {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C11291(AIKernelApi r3, d<? super C11291> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getBinder(0, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {134}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5")
    static final class AnonymousClass5 extends l implements m<am, d<? super x>, Object> {
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass5(AIKernelApi r3, d<? super AnonymousClass5> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass5.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            ServiceConnector r8 = AIKernelApi.access$getConnector$p(this.this$0);
            if (r8 != null) goto L11;
            o.c("connector");
            r8 = null;
        L11:
            d<? super AIKBinder> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r8.getService(AIKernelApi.FIRST_CONNECT_TIMEOUT, r2) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {270, 275}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2")
    static final class C11302 extends l implements d.h.a.b<d<? super AbsApi>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ boolean $useCloud;
        int label;
        final /* synthetic */ AIKernelApi this$0;

        C11302(boolean r3, String r4, AIKernelApi r5, RequestParams r6, d<? super C11302> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.$useCloud = r3;
            this.$name = r4;
            this.this$0 = r5;
            this.$params = r6;
            super(1, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r9) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11302(this.$useCloud, this.$name, this.this$0, this.$params, r7), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super AbsApi> r3) {
            return ((C11302) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11302.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super AbsApi> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = b.a();
            int r1 = this.label;
            Context r4 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r14);
        L25:
            Companion.LoadedPackage r2 = (Companion.LoadedPackage) ZeusTransformUtils.preCheckCast(r14, Companion.LoadedPackage.class, "com.obric.aiagent.plugin");
        L27:
            if (r2 != null) goto L29;
            return null;
        L29:
            ChildProcessLifecycleBinding r6 = ChildProcessLifecycleBinding.INSTANCE;
            AIKernelConfig r15 = com.obric.aikernel.core.a.f22349a.a();
            if (r15 == null) goto L32;
            r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        L32:
            ProcessLifecycleHandle r16 = ChildProcessLifecycleBinding.bind$default(r6, r4, AIKernelApi.access$getServicePackageName$p(this.this$0), r2.getTargetProcess(), false, 8, null);
            ScriptBizApi r7 = new ScriptBizApi(this.$name, this.$params, r2.getBinder(), AIKernelApi.access$getServicePackageName$p(this.this$0), r2.getTargetProcess());     // Catch: Throwable -> L36
            r16.close();
            return r7;
        L36:
            th = move-exception;
            r16.close();
            throw th;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r14);
        L17:
            AIKBinder r17 = (AIKBinder) ZeusTransformUtils.preCheckCast(r14, AIKBinder.class, "com.obric.aiagent.plugin");
            if (this.this$0.getLegacyArch() == false) goto L21;
            if (r17 == null) goto L26;
            r2 = new Companion.LoadedPackage(r17, null);
        L26:
            r2 = null;
            goto L27
        L21:
            if (r17 == null) goto L26;
            String r3 = this.$name;
            RequestParams r5 = this.$params;
            Companion r8 = AIKernelApi.Companion;
            this.label = 2;
            r14 = r8.loadPackage$sdk_release(r17, r3, r5, this);
            if (r14 != r0) goto L25;
            return r0;
        L10:
            d.o.a(r14);
            if (this.$useCloud == true) goto L13;
            AIKernelApi r9 = this.this$0;
            d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r14 = AIKernelApi.getBinder$default(r9, 0, r10, 1, null);
            if (r14 != r0) goto L17;
            return r0;
        L13:
            return new CloudBizApi(this.$name);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$waitForConnector$3, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {176}, d = "invokeSuspend", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi$waitForConnector$3")
    static final class AnonymousClass3 extends l implements m<am, d<? super ServiceConnector>, Object> {
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass3(AIKernelApi r3, d<? super AnonymousClass3> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super ServiceConnector> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super ServiceConnector> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass3.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w r6 = AIKernelApi.access$getConnectorReady$p(this.this$0);
            d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @f(b = "AIKernelApi.kt", c = {343, 370, 372}, d = "wrapApiCall", e = "com.obric.aikernel.phx.sdk.api.AIKernelApi")
    static final class C11311<T> extends d.c.b.a.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C11311(AIKernelApi r3, d<? super C11311> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.wrapApiCall(null, null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    static final class C11322 extends p implements d.h.a.b<Throwable, x> {
        final /* synthetic */ AIKBinder $binder;
        final /* synthetic */ au<T> $ipcJob;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ AIKernelApi this$0;

        C11322(AIKBinder r3, au<? extends T> r4, AIKernelApi r5, RequestParams r6) {
            AIKBinder r7 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin");
            au<T> r8 = (au) ZeusTransformUtils.wrapperContextForParams(r4, au.class, "com.obric.aiagent.plugin");
            this.$binder = r7;
            this.$ipcJob = r8;
            this.this$0 = r5;
            this.$params = r6;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            invoke2((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r13) {
            if (r13 != null) goto L6;
            int r0 = 2;
        L4:
            int r3 = r0;
            AIKBinder r5 = this.$binder;
            if (r5 == null) goto L12;
            AIKernelApi r1 = this.this$0;
            RequestParams r2 = this.$params;
            i.a(AIKernelApi.access$getTransactScope$p(r1), null, null, (m) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$2$1$1(r2, r3, r13, r5, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        L12:
            ca r12 = this.$ipcJob;
            if (r12.b() == true) goto L16;
            r12 = null;
        L16:
            if (r12 == null) goto L19;
            r12.a(bo.a("parent task completed", r13));
            return;
        L19:
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r13, CancellationException.class) == false) goto L8;
            r0 = 1;
            goto L4
        L8:
            r0 = 3;
            goto L4
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ ServiceConnector access$getConnector$p(AIKernelApi r0) {
        return r0.connector;
    }

    public static final /* synthetic */ w access$getConnectorReady$p(AIKernelApi r0) {
        return r0.connectorReady;
    }

    /* JADX INFO: renamed from: access$getPackageInfos-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m397access$getPackageInfos0E7RQCE(AIKernelApi r2, List r3, RequestParams r4, d r5) {
        return r2.m401getPackageInfos0E7RQCE((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: access$getPackageResource-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m398access$getPackageResource0E7RQCE(AIKernelApi r2, String r3, RequestParams r4, d r5) {
        return r2.m402getPackageResource0E7RQCE(r3, r4, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$getServicePackageName$p(AIKernelApi r0) {
        return r0.servicePackageName;
    }

    public static final /* synthetic */ am access$getTransactScope$p(AIKernelApi r0) {
        return r0.transactScope;
    }

    /* JADX INFO: renamed from: access$updatePackageInner-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m399access$updatePackageInner0E7RQCE(AIKernelApi r2, PackageResource r3, RequestParams r4, d r5) {
        return r2.m403updatePackageInner0E7RQCE(r3, r4, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: access$updatePackages-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m400access$updatePackages0E7RQCE(AIKernelApi r2, List r3, RequestParams r4, d r5) {
        return r2.m404updatePackages0E7RQCE((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$waitForConnector(AIKernelApi r2, long r3, d r5) {
        return r2.waitForConnector(r3, (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public AIKernelApi() {
        this((q) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, q.class, "com.obric.aiagent.plugin"));
    }

    public AIKernelApi(q<? super Context, ? super AIKernelConfig, ? super ComponentName, ServiceConnector> r6) {
        q<Context, AIKernelConfig, ComponentName, ServiceConnector> r7 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        o.e(r7, "serviceConnectorFactory");
        this.connectorReady = y.a(null, 1, null);
        this.transactScope = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")).plus((g) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new AIKernelApi$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.f38768a), CoroutineExceptionHandler.class, "com.obric.aiagent.plugin"), g.class, "com.obric.aiagent.plugin")));
        this.legacyArch = true;
        this.servicePackageName = "com.obric.aikernel";
        this.serviceConnectorFactory = r7;
    }

    public final boolean getLegacyArch() {
        return this.legacyArch;
    }

    public final void setLegacyArch(boolean r1) {
        this.legacyArch = r1;
    }

    public static /* synthetic */ void init$default(AIKernelApi r1, AIKernelConfig r2, ILog r3, int r4, Object r5) {
        ILog r6 = (ILog) ZeusTransformUtils.wrapperContextForParams(r3, ILog.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.init(r2, r6);
    }

    public final synchronized void init(AIKernelConfig r9, ILog r10) {
        monitor-enter(this);
        ILog r11 = (ILog) ZeusTransformUtils.wrapperContextForParams(r10, ILog.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        o.e(r9, "config");     // Catch: Throwable -> L53
        if (this.connector == null) goto L8;
        AIKLog.INSTANCE.d(TAG, "sdk is already inited!");     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L8:
        com.obric.aikernel.core.a.f22349a.a(r9);     // Catch: Throwable -> L53
        com.obric.aikernel.core.a.f22349a.a(BuildConfig.SDK_VERSION);     // Catch: Throwable -> L53
        com.obric.aikernel.core.a.f22349a.a(r9.getAuthBySign());     // Catch: Throwable -> L53
        if (r11 == null) goto L11;
        AIKLog.INSTANCE.registerLog(r11);     // Catch: Throwable -> L53
    L11:
        ComponentName r12 = new ComponentName("com.obric.aikernel", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L53
        String r0 = "com.obric.aikernel";
        n.a r2 = n.f38560a;     // Catch: Throwable -> L35
        AIKernelApi r3 = (AIKernelApi) ZeusTransformUtils.preCheckCast(this, AIKernelApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        ComponentName r4 = new ComponentName("com.larus.nova", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L35
        PackageManager r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager();     // Catch: Throwable -> L35
        Intent r6 = new Intent();     // Catch: Throwable -> L35
        r6.setComponent(r4);     // Catch: Throwable -> L35
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r5.queryIntentServices(r6, UiType.FLAG_PHONE_CARD), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r7 != null) goto L16;
    L19:
        boolean r8 = true;
    L20:
        if (r8 == false) goto L59;
        PackageInfo r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo("com.obric.aikernel", 0);     // Catch: Throwable -> L35
        if (r13 == null) goto L28;
        o.c(r13, "getPackageInfo(IAIKernel…ager.PACKAGE_NAME_AIK, 0)");     // Catch: Throwable -> L35
        if (r13.getLongVersionCode() < 200000999) goto L26;
        r3.legacyArch = false;     // Catch: Throwable -> L35
    L26:
        x r14 = x.f38692a;     // Catch: Throwable -> L35
    L31:
        Object r15 = n.f(r14);     // Catch: Throwable -> L35
    L37:
        Throwable r16 = n.c(r15);     // Catch: Throwable -> L53
        if (r16 == null) goto L40;
        AIKLog.INSTANCE.e(TAG, "getServicePackageInfo failed: " + d.a.a(r16));     // Catch: Throwable -> L53
    L40:
        this.connector = (ServiceConnector) ZeusTransformUtils.preCheckCast(this.serviceConnectorFactory.invoke((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, r12), ServiceConnector.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        this.servicePackageName = r0;     // Catch: Throwable -> L53
        if (this.connectorReady.i() == true) goto L47;
        w<ServiceConnector> r17 = this.connectorReady;     // Catch: Throwable -> L53
        ServiceConnector r1 = this.connector;     // Catch: Throwable -> L53
        if (r1 != null) goto L45;
        o.c("connector");     // Catch: Throwable -> L53
        r1 = null;
    L45:
        r17.a(r1);     // Catch: Throwable -> L53
    L47:
        if (r9.getBindRemoteOnInit() == false) goto L49;
        i.a(this.transactScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L53
    L50:
        AIKLog.INSTANCE.i(TAG, "initialize success.");     // Catch: Throwable -> L53
        monitor-exit(this);
        return;
    L49:
        AIKLog.INSTANCE.d(TAG, "skip remote bind on init by config.");     // Catch: Throwable -> L53
        goto L50
    L28:
        r14 = null;
        goto L31
    L59:
        r0 = "com.larus.nova";
        r3.legacyArch = false;     // Catch: Throwable -> L33
        r14 = x.f38692a;     // Catch: Throwable -> L33
        r12 = r4;
    L33:
        th = th;
        r12 = r4;
    L36:
        n.a r18 = n.f38560a;     // Catch: Throwable -> L53
        r15 = n.f(d.o.a(th));     // Catch: Throwable -> L53
        goto L37
    L16:
        if (r7.isEmpty() == true) goto L19;
        r8 = false;
    L35:
        th = th;
    L53:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Object getBinder$default(AIKernelApi r1, long r2, d r4, int r5, Object r6) {
        d<? super AIKBinder> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 5000;
    L6:
        return r1.getBinder(r2, r7);
    }

    public final Object getBinder(long r19, d<? super AIKBinder> r21) {
        AIKernelApi r0 = this;
        long r1 = r19;
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r21, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, C11291.class) == false) goto L7;
        C11291 r6 = (C11291) ZeusTransformUtils.preCheckCast(r4, C11291.class, "com.obric.aiagent.plugin");
        if ((r6.label & Integer.MIN_VALUE) == 0) goto L7;
        r6.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r7 = b.a();
        int r8 = r6.label;
        if (r8 == 0) goto L18;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        r0 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L43:
        AIKBinder r2 = (AIKBinder) ZeusTransformUtils.preCheckCast(r5, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L49;
        r0.hasConnectedOnce = true;
        return r2;
    L49:
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r3 = r6.J$1;
        long r14 = r6.J$0;
        ServiceConnector r9 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r6.L$1, ServiceConnector.class, "com.obric.aiagent.plugin");
        AIKernelApi r10 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        long r11 = r3;
        r0 = r10;
        Object r12 = r5;
        String r13 = TAG;
    L29:
        AIKBinder r15 = (AIKBinder) ZeusTransformUtils.preCheckCast(r12, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L34;
        r0.hasConnectedOnce = true;
        return r15;
    L34:
        if (r14 != 5000) goto L36;
        boolean r16 = true;
    L38:
        if (r0.hasConnectedOnce == true) goto L47;
        if (r16 == false) goto L48;
        AIKLog.INSTANCE.w(r13, "binder not ready in " + r11 + "ms, retry with first-connect timeout.");
        r6.L$0 = r0;
        r6.L$1 = null;
        r6.label = 3;
        r5 = r9.getService(FIRST_CONNECT_TIMEOUT, r6);
        if (r5 != r7) goto L43;
        return r7;
    L48:
        return null;
    L47:
        return null;
    L36:
        r16 = false;
        goto L38
    L17:
        long r17 = r6.J$2;
        long r18 = r6.J$1;
        long r110 = r6.J$0;
        AIKernelApi r20 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r6.L$0, AIKernelApi.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        Object r22 = r5;
        r0 = r20;
        r1 = r110;
        r11 = r18;
        long r111 = r17;
    L21:
        ServiceConnector r23 = (ServiceConnector) ZeusTransformUtils.preCheckCast(r22, ServiceConnector.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L25;
        AIKernelApi r24 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r0, AIKernelApi.class, "com.obric.aiagent.plugin");
        AIKLog.INSTANCE.w(TAG, "connector not initialized within " + r11 + "ms");
        return null;
    L25:
        long r112 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.L$1 = r23;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.label = 2;
        r12 = r23.getService(r112, r6);
        if (r12 != r7) goto L28;
        return r7;
    L28:
        r14 = r1;
        r9 = r23;
        goto L29
    L18:
        d.o.a(r5);
        r11 = Math.max(r1, 0);
        r111 = System.currentTimeMillis() + r11;
        long r25 = r0.remainMs(r111);
        r6.L$0 = r0;
        r6.J$0 = r1;
        r6.J$1 = r11;
        r6.J$2 = r111;
        r6.label = 1;
        r22 = r0.waitForConnector(r25, r6);
        if (r22 != r7) goto L21;
        return r7;
    L7:
        r6 = new C11291(r0, r4);
        goto L8
    }

    private final Object waitForConnector(long r4, d<? super ServiceConnector> r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        ServiceConnector r0 = this.connector;
        if (r0 == null) goto L8;
        if (r0 != null) goto L9;
        o.c("connector");
        return null;
    L9:
        return r0;
    L8:
        return dg.b(r4, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final long remainMs(long r3) {
        return Math.max(r3 - System.currentTimeMillis(), 0);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    public Object mo393getPackage0E7RQCE(String r10, RequestParams r11, d<? super n<PackageResource>> r12) {
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$getPackage$1.class) == false) goto L7;
        AIKernelApi$getPackage$1 r0 = (AIKernelApi$getPackage$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$getPackage$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackage$1 r6 = r0;
        Object r14 = r6.result;
        Object r1 = b.a();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r14);
    L17:
        n r9 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L22;
        n.a r15 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L22:
        return r9.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AIKernelApi$getPackage$2(this, r10, r11, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r6.label = 1;
        r14 = wrapApiCall$default(this, r11, null, r5, r6, 2, null);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$getPackage$1(this, r13);
        goto L8
    }

    /* JADX INFO: renamed from: getPackageResource-0E7RQCE, reason: not valid java name */
    private final Object m402getPackageResource0E7RQCE(String r10, RequestParams r11, d<? super n<PackageResource>> r12) {
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$getPackageResource$1.class) == false) goto L7;
        AIKernelApi$getPackageResource$1 r0 = (AIKernelApi$getPackageResource$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$getPackageResource$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r14);
        Object r9 = ((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin")).a();
    L20:
        if (n.a(r9) == false) goto L33;
        n.a r15 = n.f38560a;
        if (n.b(r9) == true) goto L25;
        r4 = r9;
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L31;
        PackageResource r17 = (PackageResource) ZeusTransformUtils.preCheckCast(d.a.p.k(r16), PackageResource.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L31;
        return n.f(r17);
    L31:
        n.a r18 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "call success but got null!", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L33:
        n.a r19 = n.f38560a;
        return n.f(d.o.a(AIKernelException.Companion.getException(r9)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        if (r11.getUseLocalPapaya() == true) goto L36;
        List<String> r110 = d.a.p.a(r10);
        r0.label = 1;
        r9 = m401getPackageInfos0E7RQCE(r110, r11, r0);
        if (r9 != r2) goto L20;
        return r2;
    L36:
        throw new d.l(null, 1, null);
    L7:
        r0 = new AIKernelApi$getPackageResource$1(this, r13);
        goto L8
    }

    /* JADX INFO: renamed from: getPackageInfos-0E7RQCE, reason: not valid java name */
    private final Object m401getPackageInfos0E7RQCE(List<String> r17, RequestParams r18, d<? super n<? extends List<PackageResource>>> r19) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AIKernelApi$getPackageInfos$1.class) == false) goto L7;
        AIKernelApi$getPackageInfos$1 r1 = (AIKernelApi$getPackageInfos$1) ZeusTransformUtils.preCheckCast(r0, AIKernelApi$getPackageInfos$1.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackageInfos$1 r9 = r1;
        Object r2 = r9.result;
        Object r10 = b.a();
        int r3 = r9.label;
        boolean r14 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        RequestParams r4 = (RequestParams) ZeusTransformUtils.preCheckCast(r9.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(r9.L$0, List.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        Object r6 = ((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.aiagent.plugin")).a();
    L33:
        if (n.b(r6) == false) goto L35;
        AIKLog.INSTANCE.w(TAG, "[SDK] getPackageInfos binder ready but rpc failed, names=" + r5 + ", traceId=" + r4.getTraceIdStr() + ", error=" + n.c(r6));
    L35:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        RequestParams r7 = (RequestParams) ZeusTransformUtils.preCheckCast(r9.L$2, RequestParams.class, "com.obric.aiagent.plugin");
        r8 = (List) ZeusTransformUtils.preCheckCast(r9.L$1, List.class, "com.obric.aiagent.plugin");
        AIKernelApi r11 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r9.L$0, AIKernelApi.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        RequestParams r15 = r7;
    L20:
        AIKBinder r12 = (AIKBinder) ZeusTransformUtils.preCheckCast(r2, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L28;
        AIKLog r13 = AIKLog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("[SDK] getPackageInfos binder is null, names=").append(r8).append(", traceId=").append(r15.getTraceIdStr()).append(", connectorInited=");
        if (r11.connector != null) goto L26;
        r14 = false;
    L26:
        r13.e(TAG, r16.append(r14).append(", hasConnectedOnce=").append(r11.hasConnectedOnce).toString());
        n.a r20 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Binder not ready.", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L28:
        Companion r21 = Companion;
        r9.L$0 = r8;
        r9.L$1 = r15;
        r9.L$2 = null;
        r9.label = 2;
        r6 = r21.m405getPackageInfosBWLJW6A(r12, r8, r15, r9);
        if (r6 != r10) goto L31;
        return r10;
    L31:
        r5 = r8;
        r4 = r15;
        goto L33
    L16:
        d.o.a(r2);
        r9.L$0 = this;
        r9.L$1 = r8;
        r15 = r18;
        r9.L$2 = r15;
        r9.label = 1;
        r2 = getBinder$default(this, 0, r9, 1, null);
        if (r2 != r10) goto L19;
        return r10;
    L19:
        r11 = this;
    L7:
        r1 = new AIKernelApi$getPackageInfos$1(this, r0);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    public Object mo394updatePackage0E7RQCE(PackageResource r10, RequestParams r11, d<? super n<PackageResource>> r12) {
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$updatePackage$1.class) == false) goto L7;
        AIKernelApi$updatePackage$1 r0 = (AIKernelApi$updatePackage$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$updatePackage$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$updatePackage$1 r6 = r0;
        Object r14 = r6.result;
        Object r1 = b.a();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r14);
    L17:
        n r9 = (n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L22;
        n.a r15 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L22:
        return r9.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AIKernelApi$updatePackage$2(this, r10, r11, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r6.label = 1;
        r14 = wrapApiCall$default(this, r11, null, r5, r6, 2, null);
        if (r14 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$updatePackage$1(this, r13);
        goto L8
    }

    /* JADX INFO: renamed from: updatePackageInner-0E7RQCE, reason: not valid java name */
    private final Object m403updatePackageInner0E7RQCE(PackageResource r10, RequestParams r11, d<? super n<PackageResource>> r12) {
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r12, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AIKernelApi$updatePackageInner$1.class) == false) goto L7;
        AIKernelApi$updatePackageInner$1 r0 = (AIKernelApi$updatePackageInner$1) ZeusTransformUtils.preCheckCast(r13, AIKernelApi$updatePackageInner$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        Object r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r14);
        Object r9 = ((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin")).a();
    L20:
        if (n.a(r9) == false) goto L33;
        n.a r15 = n.f38560a;
        if (n.b(r9) == true) goto L25;
        r4 = r9;
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L31;
        PackageResource r17 = (PackageResource) ZeusTransformUtils.preCheckCast(d.a.p.k(r16), PackageResource.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L31;
        return n.f(r17);
    L31:
        n.a r18 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(108, "call success but got null!", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L33:
        n.a r19 = n.f38560a;
        return n.f(d.o.a(AIKernelException.Companion.getException(r9)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        if (r11.getUseLocalPapaya() == true) goto L36;
        List<PackageResource> r110 = d.a.p.a(r10);
        r0.label = 1;
        r9 = m404updatePackages0E7RQCE(r110, r11, r0);
        if (r9 != r2) goto L20;
        return r2;
    L36:
        throw new d.l(null, 1, null);
    L7:
        r0 = new AIKernelApi$updatePackageInner$1(this, r13);
        goto L8
    }

    /* JADX INFO: renamed from: updatePackages-0E7RQCE, reason: not valid java name */
    private final Object m404updatePackages0E7RQCE(List<PackageResource> r11, RequestParams r12, d<? super n<? extends List<PackageResource>>> r13) {
        List<PackageResource> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d r15 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AIKernelApi$updatePackages$1.class) == false) goto L7;
        AIKernelApi$updatePackages$1 r0 = (AIKernelApi$updatePackages$1) ZeusTransformUtils.preCheckCast(r15, AIKernelApi$updatePackages$1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r8 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        d.o.a(r16);
        return ((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")).a();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        r14 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L19:
        AIKBinder r10 = (AIKBinder) ZeusTransformUtils.preCheckCast(r16, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L24;
        Companion r17 = Companion;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        Object r18 = r17.m406updatePackagesBWLJW6A(r10, r14, r12, r0);
        if (r18 != r8) goto L27;
        return r8;
    L27:
        return r18;
    L24:
        n.a r19 = n.f38560a;
        return n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new AIKernelException(102, "Binder is null.", null, 0, 12, null), Throwable.class, "com.obric.aiagent.plugin")));
    L16:
        d.o.a(r16);
        AIKLog.INSTANCE.i(TAG, "[SDK] updatePackages count:" + r14.size());
        r0.L$0 = r14;
        r0.L$1 = r12;
        r0.label = 1;
        r16 = getBinder$default(this, 0, r0, 1, null);
        if (r16 != r8) goto L19;
        return r8;
    L7:
        r0 = new AIKernelApi$updatePackages$1(this, r15);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r14, boolean r15, RequestParams r16, d<? super IBaseModel> r17) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
        return wrapApiCall$default(this, r16, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new C11302(r15, r14, this, r16, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r6, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r14, d<? super x> r15) {
        d r16 = (d) ZeusTransformUtils.wrapperContextForParams(r15, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C11281.class) == false) goto L7;
        C11281 r0 = (C11281) ZeusTransformUtils.preCheckCast(r16, C11281.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r14 = (RequestParams) ZeusTransformUtils.preCheckCast(r0.L$0, RequestParams.class, "com.obric.aiagent.plugin");
        d.o.a(r17);
    L17:
        AIKBinder r13 = (AIKBinder) ZeusTransformUtils.preCheckCast(r17, AIKBinder.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L27;
        AIKLog.INSTANCE.d(TAG, "binder is not ready.");
        return x.f38692a;
    L27:
        Bundle r18 = BundleExtKt.commonParams$default(r14.start(), "", IdlKeys.Method_ClearData, IdlKeys.Call_Type_CallBiz, "", TAG, "clearAIKernelData", null, false, 192, null);     // Catch: RemoteException -> L23
        AIKLog.INSTANCE.i(TAG, "[SDK] clearAIKernelData formatBundle:" + r18);     // Catch: RemoteException -> L23
        r13.callModel(r18, (AIKListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: RemoteException -> L23
    L26:
        return x.f38692a;
    L23:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "clearAIKernelData error: " + e);
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r17);
        r0.L$0 = r14;
        r0.label = 1;
        r17 = getBinder(60000, r0);
        if (r17 != r2) goto L17;
        return r2;
    L7:
        r0 = new C11281(this, r16);
        goto L8
    }

    public static /* synthetic */ Object wrapApiCall$default(AIKernelApi r1, RequestParams r2, AIKBinder r3, d.h.a.b r4, d r5, int r6, Object r7) {
        AIKBinder r8 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r3, AIKBinder.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r8 = null;
    L6:
        return r1.wrapApiCall(r2, r8, r9, r10);
    }

    public final <T> Object wrapApiCall(RequestParams r24, AIKBinder r25, d.h.a.b<? super d<? super T>, ? extends Object> r26, d<? super T> r27) {
        AIKBinder r0 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r25, AIKBinder.class, "com.obric.aiagent.plugin");
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.b.class, "com.obric.aiagent.plugin");
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r27, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11311.class) == false) goto L7;
        C11311 r3 = (C11311) ZeusTransformUtils.preCheckCast(r2, C11311.class, "com.obric.aiagent.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        C11311 r10 = r3;
        Object r4 = r10.result;
        Object r11 = b.a();
        int r5 = r10.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r4);
    L37:
        return r4;
    L17:
        long r6 = r10.J$0;
        au r7 = (au) ZeusTransformUtils.preCheckCast(r10.L$2, au.class, "com.obric.aiagent.plugin");
        RequestParams r8 = (RequestParams) ZeusTransformUtils.preCheckCast(r10.L$1, RequestParams.class, "com.obric.aiagent.plugin");
        AIKernelApi r9 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r10.L$0, AIKernelApi.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L24:
        au r15 = r7;
        long r21 = r6;
        r0 = (AIKBinder) ZeusTransformUtils.preCheckCast(r4, AIKBinder.class, "com.obric.aiagent.plugin");
        long r12 = r21;
    L26:
        ca r13 = (ca) ZeusTransformUtils.preCheckCast(r10.getContext().get((g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L29;
        r13.a_((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11322(r0, r15, r9, r8), d.h.a.b.class, "com.obric.aiagent.plugin"));
    L29:
        AIKernelApi r14 = (AIKernelApi) ZeusTransformUtils.preCheckCast(r9, AIKernelApi.class, "com.obric.aiagent.plugin");
        if (r12 <= 0) goto L34;
        m r16 = (m) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$3$1(r15, null), m.class, "com.obric.aiagent.plugin");
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 2;
        r4 = dg.b(r12, r16, r10);
        if (r4 != r11) goto L37;
        return r11;
    L34:
        r10.L$0 = null;
        r10.L$1 = null;
        r10.L$2 = null;
        r10.label = 3;
        r4 = r15.a(r10);
        if (r4 != r11) goto L37;
        return r11;
    L18:
        d.o.a(r4);
        r12 = r24.getTimeout();
        r15 = i.b(this.transactScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AIKernelApi$wrapApiCall$ipcJob$1(r24, r1, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        if (r0 != null) goto L25;
        r10.L$0 = this;
        r10.L$1 = r24;
        r10.L$2 = r15;
        r10.J$0 = r12;
        r10.label = 1;
        r4 = getBinder$default(this, 0, r10, 1, null);
        if (r4 != r11) goto L23;
        return r11;
    L23:
        r9 = this;
        r8 = r24;
        r7 = r15;
        r6 = r12;
        goto L24
    L25:
        r9 = this;
        r8 = r24;
    L7:
        r3 = new C11311(this, r2);
        goto L8
    }
}
