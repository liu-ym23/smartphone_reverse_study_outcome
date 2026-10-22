package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AutoTestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$responseBundle$1", f = "AutoTestManager.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
final class AutoTestManager$callAutoTestAsResponse$responseBundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ AIKBinder $binder;
    final /* synthetic */ long $timeoutMs;
    Object L$0;
    Object L$1;
    int label;

    AutoTestManager$callAutoTestAsResponse$responseBundle$1(Bundle r1, long r2, AIKBinder r4, Continuation<? super AutoTestManager$callAutoTestAsResponse$responseBundle$1> r5) {
        this.$args = r1;
        this.$timeoutMs = r2;
        this.$binder = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AutoTestManager$callAutoTestAsResponse$responseBundle$1(this.$args, this.$timeoutMs, this.$binder, r8);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Bundle> r2) {
        return ((AutoTestManager$callAutoTestAsResponse$responseBundle$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Bundle r2 = (Bundle) this.L$1;
        AIKBinder r9 = (AIKBinder) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L31
    L38:
        return (Bundle) r10;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        AIKLog.INSTANCE.v("AutoTestManager", "start callAutoTestlAsResponse " + this.$args.getString("_M") + ", timeoutMs = " + this.$timeoutMs + ", traceid=" + this.$args.getString(IdlKeys.Args_TraceId));
        AIKBinder r11 = this.$binder;     // Catch: CancellationException -> L31
        Bundle r3 = this.$args;     // Catch: CancellationException -> L31
        this.L$0 = r11;     // Catch: CancellationException -> L31
        this.L$1 = r3;     // Catch: CancellationException -> L31
        this.label = 1;     // Catch: CancellationException -> L31
        CancellableContinuationImpl r5 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);     // Catch: CancellationException -> L31
        r5.initCancellability();     // Catch: CancellationException -> L31
        final CancellableContinuationImpl r4 = r5;     // Catch: CancellationException -> L31
        final Function0<Unit> r6 = new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1(r4);     // Catch: CancellationException -> L31
        r11.asBinder().linkToDeath(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r6), 0);     // Catch: CancellationException -> L31
        r11.autoTest(r3, new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$1(r4));     // Catch: Throwable -> L16 RemoteException -> L18
        IBinder r12 = r11.asBinder();     // Catch: CancellationException -> L31
        IBinder.DeathRecipient r7 = new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r6);     // Catch: CancellationException -> L31
    L14:
        r12.unlinkToDeath(r7, 0);     // Catch: CancellationException -> L31
        r10 = r5.getResult();     // Catch: CancellationException -> L31
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(this);     // Catch: CancellationException -> L31
    L26:
        if (r10 != r0) goto L38;
        return r0;
    L18:
        e = move-exception;
        if (r4.isActive() == false) goto L22;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L16
        r4.resumeWith(Result.m803constructorimpl(BundleExtKt.setErr(new Bundle(), 102, e.getMessage())));     // Catch: Throwable -> L16
    L22:
        r12 = r11.asBinder();     // Catch: CancellationException -> L31
        r7 = new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r6);     // Catch: CancellationException -> L31
    L16:
        th = move-exception;
        r11.asBinder().unlinkToDeath(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r6), 0);     // Catch: CancellationException -> L31
        throw th;     // Catch: CancellationException -> L31
    L31:
        e = move-exception;
        AIKLog.INSTANCE.d("AutoTestManager", "callAutoTestlAsResponse error: " + e.getMessage());
        Bundle r13 = (Bundle) null;
        return null;
    }
}
