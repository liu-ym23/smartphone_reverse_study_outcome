package com.stepos.aiengine.algorithm.sla;

import Ua.InterfaceC1066l;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.sla.SlaExecution;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.error.AIEngineError;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.c;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0087@¢\u0006\u0004\b\u0006\u0010\u000e\u001a%\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/ISla;", "Lcom/stepos/aiengine/algorithm/sla/SlaInput;", "input", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "recognizeSuspend", "(Lcom/stepos/aiengine/algorithm/sla/ISla;Lcom/stepos/aiengine/algorithm/sla/SlaInput;Landroid/os/Bundle;Le9/c;)Ljava/lang/Object;", "", "timeoutMs", "recognizeBlocking", "(Lcom/stepos/aiengine/algorithm/sla/ISla;Lcom/stepos/aiengine/algorithm/sla/SlaInput;JLandroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;", "audio", "(Lcom/stepos/aiengine/algorithm/sla/ISla;Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;Le9/c;)Ljava/lang/Object;", "(Lcom/stepos/aiengine/algorithm/sla/ISla;Lcom/stepos/aiengine/algorithm/sla/SlaAudioInput;J)Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SlaExtKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ISla f23680a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AlgorithmToken f23681b;

        public a(ISla iSla, AlgorithmToken algorithmToken) {
            this.f23680a = iSla;
            this.f23681b = algorithmToken;
        }

        public final void a(Throwable th) {
            ISla iSla = this.f23680a;
            AlgorithmToken algorithmToken = this.f23681b;
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(iSla.cancel(algorithmToken.getIdentity())));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    public static final SlaResult recognizeBlocking(ISla iSla, SlaAudioInput audio) throws CancellationException, SlaInvocationException {
        p.i(iSla, "<this>");
        p.i(audio, "audio");
        return recognizeBlocking$default(iSla, audio, 0L, 2, null);
    }

    public static /* synthetic */ SlaResult recognizeBlocking$default(ISla iSla, SlaInput slaInput, long j10, Bundle bundle, int i10, Object obj) throws CancellationException, SlaInvocationException {
        if ((i10 & 2) != 0) {
            j10 = 10000;
        }
        if ((i10 & 4) != 0) {
            bundle = null;
        }
        return recognizeBlocking(iSla, slaInput, j10, bundle);
    }

    public static final Object recognizeSuspend(ISla iSla, SlaAudioInput slaAudioInput, InterfaceC4014c<? super SlaResult> interfaceC4014c) {
        return recognizeSuspend$default(iSla, slaAudioInput.toSlaInput(), null, interfaceC4014c, 2, null);
    }

    public static /* synthetic */ Object recognizeSuspend$default(ISla iSla, SlaInput slaInput, Bundle bundle, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        return recognizeSuspend(iSla, slaInput, bundle, interfaceC4014c);
    }

    public static final SlaResult recognizeBlocking(ISla iSla, SlaInput input) throws CancellationException, SlaInvocationException {
        p.i(iSla, "<this>");
        p.i(input, "input");
        return recognizeBlocking$default(iSla, input, 0L, null, 6, null);
    }

    public static /* synthetic */ SlaResult recognizeBlocking$default(ISla iSla, SlaAudioInput slaAudioInput, long j10, int i10, Object obj) throws CancellationException, SlaInvocationException {
        if ((i10 & 2) != 0) {
            j10 = 10000;
        }
        return recognizeBlocking(iSla, slaAudioInput, j10);
    }

    public static final Object recognizeSuspend(ISla iSla, SlaInput slaInput, Bundle bundle, InterfaceC4014c<? super SlaResult> interfaceC4014c) {
        final c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        AlgorithmToken algorithmTokenSubmit = AlgorithmToken.INSTANCE.submit();
        cVar.q(new a(iSla, algorithmTokenSubmit));
        iSla.recognize(algorithmTokenSubmit, slaInput, bundle, new SlaListener() { // from class: com.stepos.aiengine.algorithm.sla.SlaExtKt$recognizeSuspend$2$2
            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onCancelled() {
                if (cVar.b()) {
                    InterfaceC1066l<SlaResult> interfaceC1066l = cVar;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066l.resumeWith(Result.b(C4849c.a(new CancellationException("SLA recognition cancelled"))));
                }
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onDecision(SlaDecision decision, SlaExecutability executability) {
                p.i(decision, "decision");
                p.i(executability, "executability");
                if (executability.getCanExecute() || !cVar.b()) {
                    return;
                }
                InterfaceC1066l<SlaResult> interfaceC1066l = cVar;
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066l.resumeWith(Result.b(new SlaResult(decision, new SlaExecution(false, "none", SlaExecution.Status.NOT_DISPATCHED, executability.getErrorCode(), null, null, 0L, 112, null), null, 0L, 0L, null, 60, null)));
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onError(int errorCode, String message) {
                p.i(message, "message");
                if (cVar.b()) {
                    InterfaceC1066l<SlaResult> interfaceC1066l = cVar;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066l.resumeWith(Result.b(C4849c.a(new SlaInvocationException(errorCode, message))));
                }
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onResult(SlaResult result) {
                p.i(result, "result");
                if (cVar.b()) {
                    cVar.resumeWith(Result.b(result));
                }
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onRoutingDecision(String str, String str2) {
                SlaListener.DefaultImpls.onRoutingDecision(this, str, str2);
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onSlaOutput(String str) {
                SlaListener.DefaultImpls.onSlaOutput(this, str);
            }
        });
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC;
    }

    public static final SlaResult recognizeBlocking(ISla iSla, SlaInput input, long j10) throws CancellationException, SlaInvocationException {
        p.i(iSla, "<this>");
        p.i(input, "input");
        return recognizeBlocking$default(iSla, input, j10, null, 4, null);
    }

    public static final SlaResult recognizeBlocking(ISla iSla, SlaInput input, long j10, Bundle bundle) throws Throwable {
        String message;
        p.i(iSla, "<this>");
        p.i(input, "input");
        final CompletableFuture completableFuture = new CompletableFuture();
        AlgorithmToken algorithmTokenSubmit = AlgorithmToken.INSTANCE.submit();
        iSla.recognize(algorithmTokenSubmit, input, bundle, new SlaListener() { // from class: com.stepos.aiengine.algorithm.sla.SlaExtKt.recognizeBlocking.1
            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onCancelled() {
                completableFuture.completeExceptionally(new CancellationException("SLA recognition cancelled"));
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onDecision(SlaDecision decision, SlaExecutability executability) {
                p.i(decision, "decision");
                p.i(executability, "executability");
                if (executability.getCanExecute()) {
                    return;
                }
                completableFuture.complete(new SlaResult(decision, new SlaExecution(false, "none", SlaExecution.Status.NOT_DISPATCHED, executability.getErrorCode(), null, null, 0L, 112, null), null, 0L, 0L, null, 60, null));
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onError(int errorCode, String message2) {
                p.i(message2, "message");
                completableFuture.completeExceptionally(new SlaInvocationException(errorCode, message2));
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onResult(SlaResult result) {
                p.i(result, "result");
                completableFuture.complete(result);
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onRoutingDecision(String str, String str2) {
                SlaListener.DefaultImpls.onRoutingDecision(this, str, str2);
            }

            @Override // com.stepos.aiengine.algorithm.sla.SlaListener
            public void onSlaOutput(String str) {
                SlaListener.DefaultImpls.onSlaOutput(this, str);
            }
        });
        try {
            try {
                return (SlaResult) completableFuture.get(j10, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                Result.Companion companion = Result.INSTANCE;
                Result.b(C4849c.a(th));
                throw new CancellationException("SLA recognize timeout after " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            }
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (!(cause instanceof SlaInvocationException) && !(cause instanceof CancellationException)) {
                if ((cause == null || (message = cause.getMessage()) == null) && (message = e10.getMessage()) == null) {
                    message = "unknown";
                }
                throw new SlaInvocationException(AIEngineError.UNKNOWN, message);
            }
            throw cause;
        } catch (TimeoutException unused) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(Boolean.valueOf(iSla.cancel(algorithmTokenSubmit.getIdentity())));
            throw new CancellationException("SLA recognize timeout after " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
    }

    public static final SlaResult recognizeBlocking(ISla iSla, SlaAudioInput audio, long j10) throws CancellationException, SlaInvocationException {
        p.i(iSla, "<this>");
        p.i(audio, "audio");
        return recognizeBlocking$default(iSla, audio.toSlaInput(), j10, null, 4, null);
    }
}
