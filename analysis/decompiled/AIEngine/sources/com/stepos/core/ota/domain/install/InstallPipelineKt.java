package com.stepos.core.ota.domain.install;

import com.stepos.core.common.net.CtaNotGrantedException;
import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.port.PayloadDecryptException;
import com.stepos.core.ota.domain.port.PayloadKeyUnavailableException;
import fc.i;
import fc.k;
import fc.l;
import java.util.Iterator;
import javax.crypto.AEADBadTagException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import lb.n;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InstallPipelineKt {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.domain.install.InstallPipelineKt$causeChain$1", f = "InstallPipeline.kt", l = {321}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.domain.install.InstallPipelineKt$causeChain$1, reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements p<k<? super Throwable>, b<? super n>, Object> {
        final /* synthetic */ Throwable $this_causeChain;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Throwable th, b<? super AnonymousClass1> bVar) {
            super(2, bVar);
            this.$this_causeChain = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_causeChain, bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // zb.p
        public final Object invoke(k<? super Throwable> kVar, b<? super n> bVar) {
            return ((AnonymousClass1) create(kVar, bVar)).invokeSuspend(n.f10413a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.Throwable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            k kVar;
            Ref$ObjectRef ref$ObjectRef;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                kVar = (k) this.L$0;
                ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.f10076a = this.$this_causeChain;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                kVar = (k) this.L$0;
                kotlin.c.b(obj);
                Throwable cause = ((Throwable) ref$ObjectRef.f10076a).getCause();
                T t8 = cause;
                if (cause == ref$ObjectRef.f10076a) {
                    t8 = 0;
                }
                ref$ObjectRef.f10076a = t8;
            }
            Object obj2 = ref$ObjectRef.f10076a;
            if (obj2 == null) {
                return n.f10413a;
            }
            this.L$0 = kVar;
            this.L$1 = ref$ObjectRef;
            this.label = 1;
            kVar.a(obj2, this);
            return coroutineSingletons;
        }
    }

    private static final i<Throwable> causeChain(Throwable th) {
        return new l(new AnonymousClass1(th, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OtaError payloadErrorOrNull(Throwable th, String str) {
        Throwable next;
        Iterator<Throwable> it = causeChain(th).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next instanceof CtaNotGrantedException) {
                break;
            }
        }
        Throwable th2 = next;
        if (th2 != null) {
            String message = th2.getMessage();
            if (message == null) {
                message = "cta not granted";
            }
            return new OtaError.CtaNotGranted(str, message);
        }
        for (Throwable th3 : causeChain(th)) {
            if (th3 instanceof PayloadKeyUnavailableException) {
                String message2 = th3.getMessage();
                if (message2 == null) {
                    message2 = "key unavailable";
                }
                return new OtaError.KeyUnavailable(str, message2);
            }
            if (th3 instanceof PayloadDecryptException) {
                String message3 = th3.getMessage();
                if (message3 == null) {
                    message3 = "decrypt failed";
                }
                return new OtaError.DecryptFailed(str, message3, th);
            }
            if (th3 instanceof AEADBadTagException) {
                return new OtaError.DecryptFailed(str, "gcm tag mismatch", th);
            }
        }
        return null;
    }
}
