package com.stepos.aiengine.algorithm.privacyclassify;

import Ua.InterfaceC1066l;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.error.AIEngineError;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.f;
import java.util.concurrent.CancellationException;
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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a0\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a;\u0010\f\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/IPrivacyClassify;", "", "text", "", "threshold", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "classify", "(Lcom/stepos/aiengine/algorithm/privacyclassify/IPrivacyClassify;Ljava/lang/String;FLandroid/os/Bundle;Le9/c;)Ljava/lang/Object;", "", "timeoutMs", "classifyBlocking", "(Lcom/stepos/aiengine/algorithm/privacyclassify/IPrivacyClassify;Ljava/lang/String;FJLandroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyResult;", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrivacyClassifyExtKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IPrivacyClassify f23659a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AlgorithmToken f23660b;

        public a(IPrivacyClassify iPrivacyClassify, AlgorithmToken algorithmToken) {
            this.f23659a = iPrivacyClassify;
            this.f23660b = algorithmToken;
        }

        public final void a(Throwable th) {
            IPrivacyClassify iPrivacyClassify = this.f23659a;
            AlgorithmToken algorithmToken = this.f23660b;
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.b(Boolean.valueOf(iPrivacyClassify.cancel(algorithmToken.getIdentity())));
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

    public static final Object classify(IPrivacyClassify iPrivacyClassify, String str, float f10, Bundle bundle, InterfaceC4014c<? super PrivacyClassifyResult> interfaceC4014c) {
        final c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        AlgorithmToken algorithmTokenSubmit = AlgorithmToken.INSTANCE.submit();
        cVar.q(new a(iPrivacyClassify, algorithmTokenSubmit));
        iPrivacyClassify.classify(algorithmTokenSubmit, str, f10, bundle, new PrivacyClassifyCallback() { // from class: com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyExtKt$classify$2$2
            @Override // com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyCallback
            public void onCancelled() {
                if (cVar.b()) {
                    InterfaceC1066l<PrivacyClassifyResult> interfaceC1066l = cVar;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066l.resumeWith(Result.b(C4849c.a(new CancellationException("privacy classify cancelled"))));
                }
            }

            @Override // com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyCallback
            public void onError(int code, String message) {
                p.i(message, "message");
                if (cVar.b()) {
                    InterfaceC1066l<PrivacyClassifyResult> interfaceC1066l = cVar;
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC1066l.resumeWith(Result.b(C4849c.a(new PrivacyClassifyInvocationException(code, message))));
                }
            }

            @Override // com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyCallback
            public void onResult(PrivacyClassifyResult result) {
                p.i(result, "result");
                if (cVar.b()) {
                    cVar.resumeWith(Result.b(result));
                }
            }
        });
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            f.c(interfaceC4014c);
        }
        return objC;
    }

    public static /* synthetic */ Object classify$default(IPrivacyClassify iPrivacyClassify, String str, float f10, Bundle bundle, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bundle = null;
        }
        return classify(iPrivacyClassify, str, f10, bundle, interfaceC4014c);
    }

    public static final PrivacyClassifyResult classifyBlocking(IPrivacyClassify iPrivacyClassify, String text) throws PrivacyClassifyInvocationException, CancellationException {
        p.i(iPrivacyClassify, "<this>");
        p.i(text, "text");
        return classifyBlocking$default(iPrivacyClassify, text, 0.0f, 0L, null, 14, null);
    }

    public static /* synthetic */ PrivacyClassifyResult classifyBlocking$default(IPrivacyClassify iPrivacyClassify, String str, float f10, long j10, Bundle bundle, int i10, Object obj) throws PrivacyClassifyInvocationException, CancellationException {
        if ((i10 & 2) != 0) {
            f10 = 0.8f;
        }
        float f11 = f10;
        if ((i10 & 4) != 0) {
            j10 = 3000;
        }
        long j11 = j10;
        if ((i10 & 8) != 0) {
            bundle = null;
        }
        return classifyBlocking(iPrivacyClassify, str, f11, j11, bundle);
    }

    public static final PrivacyClassifyResult classifyBlocking(IPrivacyClassify iPrivacyClassify, String text, float f10) throws PrivacyClassifyInvocationException, CancellationException {
        p.i(iPrivacyClassify, "<this>");
        p.i(text, "text");
        return classifyBlocking$default(iPrivacyClassify, text, f10, 0L, null, 12, null);
    }

    public static final PrivacyClassifyResult classifyBlocking(IPrivacyClassify iPrivacyClassify, String text, float f10, long j10) throws PrivacyClassifyInvocationException, CancellationException {
        p.i(iPrivacyClassify, "<this>");
        p.i(text, "text");
        return classifyBlocking$default(iPrivacyClassify, text, f10, j10, null, 8, null);
    }

    public static final PrivacyClassifyResult classifyBlocking(IPrivacyClassify iPrivacyClassify, String text, float f10, long j10, Bundle bundle) throws Throwable {
        String message;
        p.i(iPrivacyClassify, "<this>");
        p.i(text, "text");
        AlgorithmToken algorithmTokenSubmit = AlgorithmToken.INSTANCE.submit();
        PrivacyClassifyCallback privacyClassifyCallback = new PrivacyClassifyCallback() { // from class: com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyExtKt$classifyBlocking$callback$1
            @Override // com.stepos.aiengine.algorithm.privacyclassify.PrivacyClassifyCallback
            public void onResult(PrivacyClassifyResult result) {
                p.i(result, "result");
            }
        };
        iPrivacyClassify.classify(algorithmTokenSubmit, text, f10, bundle, privacyClassifyCallback);
        try {
            try {
                return privacyClassifyCallback.resultFuture().get(j10, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                Result.Companion companion = Result.INSTANCE;
                Result.b(C4849c.a(th));
                throw new CancellationException("privacy classify timeout after " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
            }
        } catch (ExecutionException e10) {
            Throwable cause = e10.getCause();
            if (!(cause instanceof PrivacyClassifyInvocationException) && !(cause instanceof CancellationException)) {
                if ((cause == null || (message = cause.getMessage()) == null) && (message = e10.getMessage()) == null) {
                    message = "unknown";
                }
                throw new PrivacyClassifyInvocationException(AIEngineError.UNKNOWN, message);
            }
            throw cause;
        } catch (TimeoutException unused) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(Boolean.valueOf(iPrivacyClassify.cancel(algorithmTokenSubmit.getIdentity())));
            throw new CancellationException("privacy classify timeout after " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        }
    }
}
