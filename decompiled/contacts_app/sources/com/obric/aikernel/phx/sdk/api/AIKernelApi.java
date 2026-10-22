package com.obric.aikernel.phx.sdk.api;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.DataHolder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.api.AbsApi;
import com.obric.aikernel.phx.core.api.CloudBizApi;
import com.obric.aikernel.phx.core.api.ScriptBizApi;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.AIKernelException;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.phx.BuildConfig;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: AIKernelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ>\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001f0\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J2\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b$\u0010\u001dJ\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J+\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010.J2\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b0\u00101J2\u00102\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u00103\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00101J>\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001f0\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b7\u0010\"JM\u00108\u001a\u0004\u0018\u0001H9\"\u0004\b\u0000\u001092\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00132\u001e\u0010;\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H90=\u0012\u0006\u0012\u0004\u0018\u00010>0<H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010?R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi;", "Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "()V", "connector", "Lcom/obric/aikernel/phx/core/conn/ServiceConnector;", "legacyArch", "", "getLegacyArch", "()Z", "setLegacyArch", "(Z)V", "transactScope", "Lkotlinx/coroutines/CoroutineScope;", "clearAIKernelData", "", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBinder", "Lcom/obric/aikernel/AIKBinder;", "timeoutMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageInfos", "", "names", "getPackageInfos-0E7RQCE", "(Ljava/util/List;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageResource", "getPackageResource-0E7RQCE", "init", "config", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "logger", "Lcom/obric/aikernel/core/log/ILog;", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "name", "useCloud", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackageInner", "bizPackage", "updatePackageInner-0E7RQCE", "updatePackages", "bizs", "updatePackages-0E7RQCE", "wrapApiCall", ExifInterface.GPS_DIRECTION_TRUE, "targetBinder", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lcom/obric/aikernel/AIKBinder;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIKernelApi implements IAIKernelManager {
    public static final Companion Companion = null;
    public static final String TAG = "AIKernelApi";
    private ServiceConnector connector;
    private boolean legacyArch;
    private final CoroutineScope transactScope;

    /* JADX INFO: compiled from: AIKernelApi.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0002¢\u0006\u0002\u0010\u0012JF\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/phx/sdk/api/AIKernelApi$Companion;", "", "()V", "TAG", "", "getPackageInfos", "Lkotlin/Result;", "", "Lcom/obric/aikernel/sdk/data/PackageResource;", "binder", "Lcom/obric/aikernel/AIKBinder;", "names", "params", "Lcom/obric/aikernel/sdk/config/RequestParams;", "getPackageInfos-BWLJW6A", "(Lcom/obric/aikernel/AIKBinder;Ljava/util/List;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPackage", ApmTrafficStats.KEY_BIZ, "(Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackages", "bizs", "updatePackages-BWLJW6A", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.Job] */
        /* JADX INFO: renamed from: getPackageInfos-BWLJW6A, reason: not valid java name */
        public final Object m323getPackageInfosBWLJW6A(AIKBinder r25, List<String> r26, RequestParams r27, Continuation<? super Result<? extends List<PackageResource>>> r28) {
            if ((r28 instanceof AIKernelApi$Companion$getPackageInfos$1) == false) goto L7;
            AIKernelApi$Companion$getPackageInfos$1 r2 = (AIKernelApi$Companion$getPackageInfos$1) r28;
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            Object r0 = r2.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r4 = r2.label;
            if (r4 == 0) goto L22;
            if (r4 == 1) goto L19;
            if (r4 != 2) goto L18;
            Bundle r5 = (Bundle) r2.L$4;
            ?? r6 = (Ref.ObjectRef) r2.L$3;
            CoroutineContext r7 = (CoroutineContext) r2.L$2;
            List r8 = (List) r2.L$1;
            AIKBinder r9 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L15
            r6 = r6;
        L33:
            Object r10 = ((Result) r0).m812unboximpl();     // Catch: Throwable -> L15
            Job r11 = (Job) r6.element;     // Catch: Throwable -> L15
            if (r11 == null) goto L36;
            Job.DefaultImpls.cancel$default(r11, null, 1, null);     // Catch: Throwable -> L15
        L36:
            AIKLog r12 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r13 = new StringBuilder("[SDK] end getPackageInfos: ");     // Catch: Throwable -> L15
            if (Result.m809isFailureimpl(r10) == false) goto L39;
            Object r1 = null;
        L40:
            r12.i(AIKernelApi.TAG, r13.append(r1).append(' ').append(Result.m806exceptionOrNullimpl(r10)).toString());     // Catch: Throwable -> L15
            return ((Result) r0).m812unboximpl();
        L39:
            r1 = r10;
        L15:
            th = move-exception;
            Throwable r14 = th;
            ?? r15 = r6;
        L44:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] getPackageInfos error: " + r14);
            Job r16 = (Job) r15.element;
            if (r16 == null) goto L47;
            Job.DefaultImpls.cancel$default(r16, null, 1, null);
        L47:
            Result.Companion r17 = Result.Companion;
            return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Got remote error.", r14, 0, 8, null)));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r18 = (Ref.ObjectRef) r2.L$3;
            CoroutineContext r19 = (CoroutineContext) r2.L$2;
            final List<String> r110 = (List) r2.L$1;
            AIKBinder r111 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L42
            r4 = r18;
        L27:
            Bundle r20 = BundleExtKt.commonParams$default((Bundle) r0, null, IdlKeys.Method_GetPackageRes, "_CallBiz", null, AIKernelApi.TAG, "getPackageInfos", null, false, 201, null);     // Catch: Throwable -> L42
            r20.putStringArray(IdlKeys.Args_Pkgs, (String[]) r110.toArray(new String[0]));     // Catch: Throwable -> L42
            r2.L$0 = r111;     // Catch: Throwable -> L42
            r2.L$1 = r110;     // Catch: Throwable -> L42
            r2.L$2 = r19;     // Catch: Throwable -> L42
            r2.L$3 = r4;     // Catch: Throwable -> L42
            r2.L$4 = r20;     // Catch: Throwable -> L42
            r2.label = 2;     // Catch: Throwable -> L42
            CancellableContinuationImpl r112 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r2), 1);     // Catch: Throwable -> L42
            r112.initCancellability();     // Catch: Throwable -> L42
            final CancellableContinuationImpl r21 = r112;     // Catch: Throwable -> L42
            r4.element = BinderMonitor.INSTANCE.monitorTransact(r19, r111, new AIKernelApi$Companion$getPackageInfos$2$1(r21));     // Catch: Throwable -> L42
            r111.callModel(r20, new AIKernelApi$Companion$getPackageInfos$2$2(r21, r110));     // Catch: Throwable -> L42
            r0 = r112.getResult();     // Catch: Throwable -> L42
            if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            DebugProbesKt.probeCoroutineSuspended(r2);     // Catch: Throwable -> L42
        L30:
            if (r0 != r3) goto L32;
            return r3;
        L32:
            r6 = r4;
            goto L33
        L22:
            ResultKt.throwOnFailure(r0);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start getPackageInfos count:" + r26.size());
            r19 = r2.getContext();
            Ref.ObjectRef r22 = new Ref.ObjectRef();
            ParamsCompat r23 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L42
            r2.L$0 = r25;     // Catch: Throwable -> L42
            r2.L$1 = r26;     // Catch: Throwable -> L42
            r2.L$2 = r19;     // Catch: Throwable -> L42
            r2.L$3 = r22;     // Catch: Throwable -> L42
            r2.label = 1;     // Catch: Throwable -> L42
            r0 = r23.startCompat(r27, r2);     // Catch: Throwable -> L42
            if (r0 != r3) goto L26;
            return r3;
        L26:
            r111 = r25;
            r110 = r26;
            r4 = r22;
        L42:
            th = move-exception;
            r14 = th;
            r15 = r4;
        L7:
            r2 = new AIKernelApi$Companion$getPackageInfos$1(this, r28);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.Job] */
        /* JADX INFO: renamed from: updatePackages-BWLJW6A, reason: not valid java name */
        public final Object m324updatePackagesBWLJW6A(AIKBinder r25, List<PackageResource> r26, RequestParams r27, Continuation<? super Result<? extends List<PackageResource>>> r28) {
            if ((r28 instanceof AIKernelApi$Companion$updatePackages$1) == false) goto L7;
            AIKernelApi$Companion$updatePackages$1 r2 = (AIKernelApi$Companion$updatePackages$1) r28;
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            Object r0 = r2.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r4 = r2.label;
            if (r4 == 0) goto L22;
            if (r4 == 1) goto L19;
            if (r4 != 2) goto L18;
            Bundle r5 = (Bundle) r2.L$3;
            ?? r6 = (Ref.ObjectRef) r2.L$2;
            CoroutineContext r7 = (CoroutineContext) r2.L$1;
            AIKBinder r8 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L15
            r6 = r6;
        L33:
            Object r9 = ((Result) r0).m812unboximpl();     // Catch: Throwable -> L15
            Job r10 = (Job) r6.element;     // Catch: Throwable -> L15
            if (r10 == null) goto L36;
            Job.DefaultImpls.cancel$default(r10, null, 1, null);     // Catch: Throwable -> L15
        L36:
            AIKLog r11 = AIKLog.INSTANCE;     // Catch: Throwable -> L15
            StringBuilder r12 = new StringBuilder("[SDK] end updatePackages: ");     // Catch: Throwable -> L15
            if (Result.m809isFailureimpl(r9) == false) goto L39;
            Object r1 = null;
        L40:
            r11.i(AIKernelApi.TAG, r12.append(r1).append(' ').append(Result.m806exceptionOrNullimpl(r9)).toString());     // Catch: Throwable -> L15
            return ((Result) r0).m812unboximpl();
        L39:
            r1 = r9;
        L15:
            th = move-exception;
            Throwable r13 = th;
            ?? r14 = r6;
        L44:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] updatePackages error: " + r13);
            Job r15 = (Job) r14.element;
            if (r15 == null) goto L47;
            Job.DefaultImpls.cancel$default(r15, null, 1, null);
        L47:
            Result.Companion r16 = Result.Companion;
            return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Got remote error.", r13, 0, 8, null)));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r17 = (Ref.ObjectRef) r2.L$3;
            CoroutineContext r18 = (CoroutineContext) r2.L$2;
            List<PackageResource> r19 = (List) r2.L$1;
            AIKBinder r110 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L42
            r4 = r17;
        L27:
            Bundle r20 = BundleExtKt.commonParams$default((Bundle) r0, null, IdlKeys.Method_UpdatePackages, "_CallBiz", null, AIKernelApi.TAG, "updatePackages", null, false, 201, null);     // Catch: Throwable -> L42
            r20.putParcelableArray(IdlKeys.Args_Pkgs, (Parcelable[]) r19.toArray(new PackageResource[0]));     // Catch: Throwable -> L42
            r2.L$0 = r110;     // Catch: Throwable -> L42
            r2.L$1 = r18;     // Catch: Throwable -> L42
            r2.L$2 = r4;     // Catch: Throwable -> L42
            r2.L$3 = r20;     // Catch: Throwable -> L42
            r2.label = 2;     // Catch: Throwable -> L42
            CancellableContinuationImpl r111 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r2), 1);     // Catch: Throwable -> L42
            r111.initCancellability();     // Catch: Throwable -> L42
            final CancellableContinuationImpl r21 = r111;     // Catch: Throwable -> L42
            r4.element = BinderMonitor.INSTANCE.monitorTransact(r18, r110, new AIKernelApi$Companion$updatePackages$2$1(r21));     // Catch: Throwable -> L42
            r110.callModel(r20, new AIKernelApi$Companion$updatePackages$2$2(r21));     // Catch: Throwable -> L42
            r0 = r111.getResult();     // Catch: Throwable -> L42
            if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            DebugProbesKt.probeCoroutineSuspended(r2);     // Catch: Throwable -> L42
        L30:
            if (r0 != r3) goto L32;
            return r3;
        L32:
            r6 = r4;
            goto L33
        L22:
            ResultKt.throwOnFailure(r0);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start updatePackages count:" + r26.size());
            r18 = r2.getContext();
            Ref.ObjectRef r22 = new Ref.ObjectRef();
            ParamsCompat r23 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L42
            r2.L$0 = r25;     // Catch: Throwable -> L42
            r2.L$1 = r26;     // Catch: Throwable -> L42
            r2.L$2 = r18;     // Catch: Throwable -> L42
            r2.L$3 = r22;     // Catch: Throwable -> L42
            r2.label = 1;     // Catch: Throwable -> L42
            r0 = r23.startCompat(r27, r2);     // Catch: Throwable -> L42
            if (r0 != r3) goto L26;
            return r3;
        L26:
            r110 = r25;
            r19 = r26;
            r4 = r22;
        L42:
            th = move-exception;
            r13 = th;
            r14 = r4;
        L7:
            r2 = new AIKernelApi$Companion$updatePackages$1(this, r28);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r3v8, types: [kotlin.jvm.internal.Ref$ObjectRef] */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
        public final Object loadPackage(AIKBinder r23, String r24, RequestParams r25, Continuation<? super AIKBinder> r26) {
            if ((r26 instanceof AIKernelApi$Companion$loadPackage$1) == false) goto L7;
            AIKernelApi$Companion$loadPackage$1 r2 = (AIKernelApi$Companion$loadPackage$1) r26;
            if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
            r2.label -= Integer.MIN_VALUE;
        L8:
            Object r1 = r2.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r4 = r2.label;
            if (r4 == 0) goto L22;
            if (r4 == 1) goto L19;
            if (r4 != 2) goto L18;
            Bundle r0 = (Bundle) r2.L$3;
            ?? r5 = (Ref.ObjectRef) r2.L$2;
            CoroutineContext r6 = (CoroutineContext) r2.L$1;
            AIKBinder r7 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L15
            r5 = r5;
        L33:
            AIKBinder r8 = (AIKBinder) r1;     // Catch: Throwable -> L15
            Job r9 = (Job) r5.element;     // Catch: Throwable -> L15
            if (r9 == null) goto L36;
            Job.DefaultImpls.cancel$default(r9, null, 1, null);     // Catch: Throwable -> L15
        L36:
            return r1;
        L15:
            th = th;
        L39:
            AIKLog.INSTANCE.e(AIKernelApi.TAG, "[SDK] loadPackage error: " + th);
            Job r10 = (Job) r5.element;
            if (r10 == null) goto L42;
            Job.DefaultImpls.cancel$default(r10, null, 1, null);
        L42:
            return null;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            Ref.ObjectRef r11 = (Ref.ObjectRef) r2.L$3;
            CoroutineContext r12 = (CoroutineContext) r2.L$2;
            String r13 = (String) r2.L$1;
            AIKBinder r14 = (AIKBinder) r2.L$0;
            ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L37
            String r15 = r13;
            r4 = r11;
        L27:
            Bundle r16 = BundleExtKt.commonParams$default((Bundle) r1, r15, IdlKeys.Method_LoadPackage, "_CallBiz", null, AIKernelApi.TAG, "loadPackage", null, false, 200, null);     // Catch: Throwable -> L37
            r2.L$0 = r14;     // Catch: Throwable -> L37
            r2.L$1 = r12;     // Catch: Throwable -> L37
            r2.L$2 = r4;     // Catch: Throwable -> L37
            r2.L$3 = r16;     // Catch: Throwable -> L37
            r2.label = 2;     // Catch: Throwable -> L37
            CancellableContinuationImpl r17 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r2), 1);     // Catch: Throwable -> L37
            r17.initCancellability();     // Catch: Throwable -> L37
            final CancellableContinuationImpl r18 = r17;     // Catch: Throwable -> L37
            r4.element = BinderMonitor.INSTANCE.monitorTransact(r12, r14, new AIKernelApi$Companion$loadPackage$2$1(r18));     // Catch: Throwable -> L37
            r14.callModel(r16, new AIKernelApi$Companion$loadPackage$2$2(r18));     // Catch: Throwable -> L37
            r1 = r17.getResult();     // Catch: Throwable -> L37
            if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            DebugProbesKt.probeCoroutineSuspended(r2);     // Catch: Throwable -> L37
        L30:
            if (r1 != r3) goto L32;
            return r3;
        L32:
            r5 = r4;
            goto L33
        L22:
            ResultKt.throwOnFailure(r1);
            AIKLog.INSTANCE.i(AIKernelApi.TAG, "[SDK] start loadPackage " + r24);
            CoroutineContext r19 = r2.getContext();
            Ref.ObjectRef r20 = new Ref.ObjectRef();
            ParamsCompat r21 = ParamsCompat.INSTANCE;     // Catch: Throwable -> L37
            r14 = r23;
            r2.L$0 = r14;     // Catch: Throwable -> L37
            r2.L$1 = r24;     // Catch: Throwable -> L37
            r2.L$2 = r19;     // Catch: Throwable -> L37
            r2.L$3 = r20;     // Catch: Throwable -> L37
            r2.label = 1;     // Catch: Throwable -> L37
            Object r22 = r21.startCompat(r25, r2);     // Catch: Throwable -> L37
            if (r22 != r3) goto L26;
            return r3;
        L26:
            r15 = r24;
            r12 = r19;
            r1 = r22;
            r4 = r20;
        L37:
            th = th;
            r5 = r4;
        L7:
            r2 = new AIKernelApi$Companion$loadPackage$1(this, r26);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$clearAIKernelData$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0}, l = {189}, m = "clearAIKernelData", n = {"params"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass1(AIKernelApi r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clearAIKernelData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5, reason: invalid class name */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$init$5", f = "AIKernelApi.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AIKernelApi this$0;

        AnonymousClass5(AIKernelApi r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass5(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass5) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            ServiceConnector r11 = AIKernelApi.access$getConnector$p(this.this$0);
            if (r11 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("connector");
            r11 = null;
        L11:
            this.label = 1;
            if (ServiceConnector.getService$default(r11, 0, this, 1, null) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/phx/core/api/AbsApi;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi$loadPackage$2", f = "AIKernelApi.kt", i = {1}, l = {177, 182}, m = "invokeSuspend", n = {"binder"}, s = {"L$0"})
    static final class C02332 extends SuspendLambda implements Function1<Continuation<? super AbsApi>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ boolean $useCloud;
        Object L$0;
        int label;
        final /* synthetic */ AIKernelApi this$0;

        C02332(boolean r1, String r2, AIKernelApi r3, RequestParams r4, Continuation<? super C02332> r5) {
            this.$useCloud = r1;
            this.$name = r2;
            this.this$0 = r3;
            this.$params = r4;
            super(1, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r8) {
            return new C02332(this.$useCloud, this.$name, this.this$0, this.$params, r8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super AbsApi> r1) {
            return invoke2(r1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super AbsApi> r1) {
            return ((C02332) create(r1)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            AIKBinder r2 = (AIKBinder) this.L$0;
            ResultKt.throwOnFailure(r10);
        L25:
            AIKBinder r11 = (AIKBinder) r10;
            if (r11 != null) goto L28;
            r11 = r2;
        L28:
            if (r11 != null) goto L32;
            return null;
        L32:
            return new ScriptBizApi(this.$name, this.$params, r11);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L17:
            r11 = (AIKBinder) r10;
            if (this.this$0.getLegacyArch() == true) goto L28;
            if (r11 == null) goto L28;
            String r3 = this.$name;
            RequestParams r4 = this.$params;
            Companion r5 = AIKernelApi.Companion;
            this.L$0 = r11;
            this.label = 2;
            Object r6 = r5.loadPackage(r11, r3, r4, this);
            if (r6 != r0) goto L24;
            return r0;
        L24:
            r2 = r11;
            r10 = r6;
            goto L25
        L10:
            ResultKt.throwOnFailure(r10);
            if (this.$useCloud == true) goto L13;
            this.label = 1;
            r10 = AIKernelApi.getBinder$default(this.this$0, 0, this, 1, null);
            if (r10 != r0) goto L17;
            return r0;
        L13:
            return new CloudBizApi(this.$name);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.sdk.api.AIKernelApi$wrapApiCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AIKernelApi.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.sdk.api.AIKernelApi", f = "AIKernelApi.kt", i = {0, 0, 0}, l = {232, 260, 262}, m = "wrapApiCall", n = {"this", "params", "ipcJob"}, s = {"L$0", "L$1", "L$2"})
    static final class C02341<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AIKernelApi this$0;

        C02341(AIKernelApi r1, Continuation<? super C02341> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.wrapApiCall(null, null, null, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIKernelApi() {
        this.transactScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new AIKernelApi$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
        this.legacyArch = true;
    }

    public static final /* synthetic */ ServiceConnector access$getConnector$p(AIKernelApi r0) {
        return r0.connector;
    }

    /* JADX INFO: renamed from: access$getPackageInfos-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m315access$getPackageInfos0E7RQCE(AIKernelApi r0, List r1, RequestParams r2, Continuation r3) {
        return r0.m319getPackageInfos0E7RQCE(r1, r2, r3);
    }

    /* JADX INFO: renamed from: access$getPackageResource-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m316access$getPackageResource0E7RQCE(AIKernelApi r0, String r1, RequestParams r2, Continuation r3) {
        return r0.m320getPackageResource0E7RQCE(r1, r2, r3);
    }

    public static final /* synthetic */ CoroutineScope access$getTransactScope$p(AIKernelApi r0) {
        return r0.transactScope;
    }

    /* JADX INFO: renamed from: access$updatePackageInner-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m317access$updatePackageInner0E7RQCE(AIKernelApi r0, PackageResource r1, RequestParams r2, Continuation r3) {
        return r0.m321updatePackageInner0E7RQCE(r1, r2, r3);
    }

    /* JADX INFO: renamed from: access$updatePackages-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m318access$updatePackages0E7RQCE(AIKernelApi r0, List r1, RequestParams r2, Continuation r3) {
        return r0.m322updatePackages0E7RQCE(r1, r2, r3);
    }

    public final boolean getLegacyArch() {
        return this.legacyArch;
    }

    public final void setLegacyArch(boolean r1) {
        this.legacyArch = r1;
    }

    public static /* synthetic */ void init$default(AIKernelApi r0, AIKernelConfig r1, ILog r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.init(r1, r2);
    }

    public final synchronized void init(AIKernelConfig r11, ILog r12) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, "config");     // Catch: Throwable -> L44
        if (this.connector == null) goto L9;
        AIKLog.INSTANCE.d(TAG, "sdk is already inited!");     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L9:
        DataHolder.INSTANCE.setConfig(r11);     // Catch: Throwable -> L44
        DataHolder.INSTANCE.setSdkVersion(BuildConfig.SDK_VERSION);     // Catch: Throwable -> L44
        DataHolder.INSTANCE.setUseAuthProvider(r11.getAuthBySign());     // Catch: Throwable -> L44
        if (r12 == null) goto L12;
        AIKLog.INSTANCE.registerLog(r12);     // Catch: Throwable -> L44
    L12:
        ComponentName r13 = new ComponentName("com.obric.aikernel", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L44
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L36
        AIKernelApi r3 = this;     // Catch: Throwable -> L36
        ComponentName r4 = new ComponentName("com.larus.nova", "com.obric.aikernel.AIKernelService");     // Catch: Throwable -> L36
        PackageManager r5 = r11.getContext().getPackageManager();     // Catch: Throwable -> L36
        Intent r6 = new Intent();     // Catch: Throwable -> L36
        r6.setComponent(r4);     // Catch: Throwable -> L36
        List<ResolveInfo> r7 = r5.queryIntentServices(r6, 131072);     // Catch: Throwable -> L36
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == false) goto L47;
        PackageInfo r9 = r11.getContext().getPackageManager().getPackageInfo("com.obric.aikernel", 0);     // Catch: Throwable -> L36
        if (r9 == null) goto L29;
        Intrinsics.checkNotNullExpressionValue(r9, "getPackageInfo(IAIKernel…ager.PACKAGE_NAME_AIK, 0)");     // Catch: Throwable -> L36
        if (r9.getLongVersionCode() < 200000999) goto L27;
        this.legacyArch = false;     // Catch: Throwable -> L36
    L27:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L32:
        Object r14 = Result.m803constructorimpl(r10);     // Catch: Throwable -> L36
    L38:
        Throwable r15 = Result.m806exceptionOrNullimpl(r14);     // Catch: Throwable -> L44
        if (r15 == null) goto L41;
        AIKLog.INSTANCE.e(TAG, "getServicePackageInfo failed: " + ExceptionsKt.stackTraceToString(r15));     // Catch: Throwable -> L44
    L41:
        this.connector = new ServiceConnector(r11.getContext(), r11, r13);     // Catch: Throwable -> L44
        BuildersKt.launch$default(this.transactScope, null, null, new AnonymousClass5(this, null), 3, null);     // Catch: Throwable -> L44
        AIKLog.INSTANCE.i(TAG, "initialize success.");     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L29:
        r10 = null;
        goto L32
    L47:
        this.legacyArch = false;     // Catch: Throwable -> L34
        r10 = Unit.INSTANCE;     // Catch: Throwable -> L34
        r13 = r4;
    L34:
        th = move-exception;
        th = th;
        r13 = r4;
    L37:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L44
        r14 = Result.m803constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L44
        goto L38
    L17:
        if (r7.isEmpty() == true) goto L20;
        r8 = false;
    L36:
        th = th;
    L44:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Object getBinder$default(AIKernelApi r0, long r1, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 5000;
    L6:
        return r0.getBinder(r1, r3);
    }

    public final Object getBinder(long r1, Continuation<? super AIKBinder> r3) {
        ServiceConnector r0 = this.connector;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("connector");
        r0 = null;
    L6:
        return r0.getService(r1, r3);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    public Object mo311getPackage0E7RQCE(String r9, RequestParams r10, Continuation<? super Result<PackageResource>> r11) {
        if ((r11 instanceof AIKernelApi$getPackage$1) == false) goto L7;
        AIKernelApi$getPackage$1 r0 = (AIKernelApi$getPackage$1) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$getPackage$1 r5 = r0;
        Object r12 = r5.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r5.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        Result r13 = (Result) r12;
        if (r13 != null) goto L22;
        Result.Companion r8 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null)));
    L22:
        return r13.m812unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        AIKernelApi$getPackage$2 r4 = new AIKernelApi$getPackage$2(this, r9, r10, null);
        r5.label = 1;
        r12 = wrapApiCall$default(this, r10, null, r4, r5, 2, null);
        if (r12 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$getPackage$1(this, r11);
        goto L8
    }

    /* JADX INFO: renamed from: getPackageResource-0E7RQCE, reason: not valid java name */
    private final Object m320getPackageResource0E7RQCE(String r8, RequestParams r9, Continuation<? super Result<PackageResource>> r10) {
        if ((r10 instanceof AIKernelApi$getPackageResource$1) == false) goto L7;
        AIKernelApi$getPackageResource$1 r0 = (AIKernelApi$getPackageResource$1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Object r3 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
        Object r7 = ((Result) r11).m812unboximpl();
    L20:
        if (Result.m810isSuccessimpl(r7) == false) goto L33;
        Result.Companion r12 = Result.Companion;
        if (Result.m809isFailureimpl(r7) == true) goto L25;
        r3 = r7;
    L25:
        List r4 = (List) r3;
        if (r4 == null) goto L31;
        PackageResource r13 = (PackageResource) CollectionsKt.first(r4);
        if (r13 == null) goto L31;
        return Result.m803constructorimpl(r13);
    L31:
        Result.Companion r14 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(108, "call success but got null!", null, 0, 12, null)));
    L33:
        Result.Companion r15 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(AIKernelException.Companion.getException(r7)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (r9.getUseLocalPapaya() == true) goto L36;
        List<String> r16 = CollectionsKt.listOf(r8);
        r0.label = 1;
        r7 = m319getPackageInfos0E7RQCE(r16, r9, r0);
        if (r7 != r1) goto L20;
        return r1;
    L36:
        throw new NotImplementedError(null, 1, null);
    L7:
        r0 = new AIKernelApi$getPackageResource$1(this, r10);
        goto L8
    }

    /* JADX INFO: renamed from: getPackageInfos-0E7RQCE, reason: not valid java name */
    private final Object m319getPackageInfos0E7RQCE(List<String> r10, RequestParams r11, Continuation<? super Result<? extends List<PackageResource>>> r12) {
        if ((r12 instanceof AIKernelApi$getPackageInfos$1) == false) goto L7;
        AIKernelApi$getPackageInfos$1 r0 = (AIKernelApi$getPackageInfos$1) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
        return ((Result) r13).m812unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (RequestParams) r0.L$1;
        r10 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        AIKBinder r14 = (AIKBinder) r13;
        if (r14 == null) goto L24;
        Companion r9 = Companion;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        Object r15 = r9.m323getPackageInfosBWLJW6A(r14, r10, r11, r0);
        if (r15 != r7) goto L27;
        return r7;
    L27:
        return r15;
    L24:
        Result.Companion r16 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Binder not ready.", null, 0, 12, null)));
    L16:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r13 = getBinder$default(this, 0, r0, 1, null);
        if (r13 != r7) goto L19;
        return r7;
    L7:
        r0 = new AIKernelApi$getPackageInfos$1(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    public Object mo312updatePackage0E7RQCE(PackageResource r9, RequestParams r10, Continuation<? super Result<PackageResource>> r11) {
        if ((r11 instanceof AIKernelApi$updatePackage$1) == false) goto L7;
        AIKernelApi$updatePackage$1 r0 = (AIKernelApi$updatePackage$1) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AIKernelApi$updatePackage$1 r5 = r0;
        Object r12 = r5.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r5.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        Result r13 = (Result) r12;
        if (r13 != null) goto L22;
        Result.Companion r8 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(108, "[SDK] expect non-null result.", null, 0, 12, null)));
    L22:
        return r13.m812unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        AIKernelApi$updatePackage$2 r4 = new AIKernelApi$updatePackage$2(this, r9, r10, null);
        r5.label = 1;
        r12 = wrapApiCall$default(this, r10, null, r4, r5, 2, null);
        if (r12 != r1) goto L17;
        return r1;
    L7:
        r0 = new AIKernelApi$updatePackage$1(this, r11);
        goto L8
    }

    /* JADX INFO: renamed from: updatePackageInner-0E7RQCE, reason: not valid java name */
    private final Object m321updatePackageInner0E7RQCE(PackageResource r8, RequestParams r9, Continuation<? super Result<PackageResource>> r10) {
        if ((r10 instanceof AIKernelApi$updatePackageInner$1) == false) goto L7;
        AIKernelApi$updatePackageInner$1 r0 = (AIKernelApi$updatePackageInner$1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        Object r3 = null;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
        Object r7 = ((Result) r11).m812unboximpl();
    L20:
        if (Result.m810isSuccessimpl(r7) == false) goto L33;
        Result.Companion r12 = Result.Companion;
        if (Result.m809isFailureimpl(r7) == true) goto L25;
        r3 = r7;
    L25:
        List r4 = (List) r3;
        if (r4 == null) goto L31;
        PackageResource r13 = (PackageResource) CollectionsKt.first(r4);
        if (r13 == null) goto L31;
        return Result.m803constructorimpl(r13);
    L31:
        Result.Companion r14 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(108, "call success but got null!", null, 0, 12, null)));
    L33:
        Result.Companion r15 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(AIKernelException.Companion.getException(r7)));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (r9.getUseLocalPapaya() == true) goto L36;
        List<PackageResource> r16 = CollectionsKt.listOf(r8);
        r0.label = 1;
        r7 = m322updatePackages0E7RQCE(r16, r9, r0);
        if (r7 != r1) goto L20;
        return r1;
    L36:
        throw new NotImplementedError(null, 1, null);
    L7:
        r0 = new AIKernelApi$updatePackageInner$1(this, r10);
        goto L8
    }

    /* JADX INFO: renamed from: updatePackages-0E7RQCE, reason: not valid java name */
    private final Object m322updatePackages0E7RQCE(List<PackageResource> r10, RequestParams r11, Continuation<? super Result<? extends List<PackageResource>>> r12) {
        if ((r12 instanceof AIKernelApi$updatePackages$1) == false) goto L7;
        AIKernelApi$updatePackages$1 r0 = (AIKernelApi$updatePackages$1) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
        return ((Result) r13).m812unboximpl();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = (RequestParams) r0.L$1;
        r10 = (List) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        AIKBinder r14 = (AIKBinder) r13;
        if (r14 == null) goto L24;
        Companion r9 = Companion;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        Object r15 = r9.m324updatePackagesBWLJW6A(r14, r10, r11, r0);
        if (r15 != r7) goto L27;
        return r7;
    L27:
        return r15;
    L24:
        Result.Companion r16 = Result.Companion;
        return Result.m803constructorimpl(ResultKt.createFailure(new AIKernelException(102, "Binder is null.", null, 0, 12, null)));
    L16:
        ResultKt.throwOnFailure(r13);
        AIKLog.INSTANCE.i(TAG, "[SDK] updatePackages count:" + r10.size());
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        r13 = getBinder$default(this, 0, r0, 1, null);
        if (r13 != r7) goto L19;
        return r7;
    L7:
        r0 = new AIKernelApi$updatePackages$1(this, r12);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object loadPackage(String r10, boolean r11, RequestParams r12, Continuation<? super IBaseModel> r13) {
        return wrapApiCall$default(this, r12, null, new C02332(r11, r10, this, r12, null), r13, 2, null);
    }

    @Override // com.obric.aikernel.phx.sdk.IAIKernelManager
    public Object clearAIKernelData(RequestParams r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r1 = (AnonymousClass1) r14;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r13 = (RequestParams) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        AIKBinder r16 = (AIKBinder) r15;
        if (r16 != null) goto L27;
        AIKLog.INSTANCE.d(TAG, "binder is not ready.");
        return Unit.INSTANCE;
    L27:
        Bundle r17 = BundleExtKt.commonParams$default(r13.start(), "", IdlKeys.Method_ClearData, "_CallBiz", "", TAG, "clearAIKernelData", null, false, 192, null);     // Catch: RemoteException -> L23
        AIKLog.INSTANCE.i(TAG, "[SDK] clearAIKernelData formatBundle:" + r17);     // Catch: RemoteException -> L23
        r16.callModel(r17, new AnonymousClass2());     // Catch: RemoteException -> L23
    L26:
        return Unit.INSTANCE;
    L23:
        e = move-exception;
        AIKLog.INSTANCE.e(TAG, "clearAIKernelData error: " + e);
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r1.L$0 = r13;
        r1.label = 1;
        r15 = getBinder(60000, r1);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r1 = new AnonymousClass1(this, r14);
        goto L8
    }

    public static /* synthetic */ Object wrapApiCall$default(AIKernelApi r0, RequestParams r1, AIKBinder r2, Function1 r3, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.wrapApiCall(r1, r2, r3, r4);
    }

    public final <T> Object wrapApiCall(RequestParams r20, AIKBinder r21, Function1<? super Continuation<? super T>, ? extends Object> r22, Continuation<? super T> r23) {
        if ((r23 instanceof C02341) == false) goto L7;
        C02341 r1 = (C02341) r23;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        C02341 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
    L37:
        return r0;
    L17:
        Deferred r3 = (Deferred) r8.L$2;
        final RequestParams r4 = (RequestParams) r8.L$1;
        final AIKernelApi r5 = (AIKernelApi) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L24:
        final AIKBinder r6 = (AIKBinder) r0;
        final Deferred r13 = r3;
    L26:
        Job r7 = (Job) r8.getContext().get(Job.Key);
        if (r7 == null) goto L29;
        r7.invokeOnCompletion(new C02352(r6, r13, r5, r4));
    L29:
        long r10 = r4.getTimeout();
        if (r10 <= 0) goto L34;
        AIKernelApi$wrapApiCall$3$1 r11 = new AIKernelApi$wrapApiCall$3$1(r13, null);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 2;
        r0 = TimeoutKt.withTimeoutOrNull(r10, r11, r8);
        if (r0 != r9) goto L37;
        return r9;
    L34:
        r8.L$0 = null;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 3;
        r0 = r13.await(r8);
        if (r0 != r9) goto L37;
        return r9;
    L18:
        ResultKt.throwOnFailure(r0);
        r13 = BuildersKt.async$default(this.transactScope, null, null, new AIKernelApi$wrapApiCall$ipcJob$1(r20, r22, null), 3, null);
        if (r21 != null) goto L25;
        r8.L$0 = this;
        r8.L$1 = r20;
        r8.L$2 = r13;
        r8.label = 1;
        r0 = getBinder$default(this, 0, r8, 1, null);
        if (r0 != r9) goto L23;
        return r9;
    L23:
        r5 = this;
        r4 = r20;
        r3 = r13;
        goto L24
    L25:
        r6 = r21;
        r5 = this;
        r4 = r20;
    L7:
        r1 = new C02341(this, r23);
        goto L8
    }
}
