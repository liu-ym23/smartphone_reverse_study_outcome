package stepai.android.mindx.client.inner;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import stepai.android.llm.base.LLMRequest;
import stepai.android.mindx.client.config.ChatData;
import stepai.android.mindx.client.config.StepChatResult;

@J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient$stream$1", f = "StepInnerClient.kt", l = {211, 251, 257}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lp9/d;", "Lstepai/android/mindx/client/config/StepChatResult;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class StepInnerClient$stream$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public String f6205a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ e d;
    public final /* synthetic */ stepai.android.mindx.base.d e;
    public final /* synthetic */ LLMRequest f;

    @J7.c(c = "stepai.android.mindx.client.inner.StepInnerClient$stream$1$1", f = "StepInnerClient.kt", l = {235}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "chatData", "Lstepai/android/mindx/client/config/ChatData;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: stepai.android.mindx.client.inner.StepInnerClient$stream$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f6206a;
        public /* synthetic */ Object b;
        public final /* synthetic */ p9.d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p9.d dVar, H7.c cVar) {
            super(2, cVar);
            this.c = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.c, cVar);
            anonymousClass1.b = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((ChatData) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f6206a;
            boolean z10 = true;
            if (i == 0) {
                kotlin.b.b(obj);
                ChatData chatData = (ChatData) this.b;
                if (chatData.getCode() != 0) {
                    StepChatResult.Error error = chatData.getResponse() != null ? new StepChatResult.Error(androidx.constraintlayout.core.dsl.a.c(chatData.getCode(), "code:", ",message:", chatData.getResponse()), chatData.getResponseId()) : new StepChatResult.Error(B7.a.h(chatData.getCode(), "Stream ended with code:"), chatData.getResponseId());
                    this.f6206a = 1;
                    if (this.c.emit(error, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return Boolean.valueOf(z10);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            z10 = false;
            return Boolean.valueOf(z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepInnerClient$stream$1(e eVar, stepai.android.mindx.base.d dVar, LLMRequest lLMRequest, H7.c cVar) {
        super(2, cVar);
        this.d = eVar;
        this.e = dVar;
        this.f = lLMRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        StepInnerClient$stream$1 stepInnerClient$stream$1 = new StepInnerClient$stream$1(this.d, this.e, this.f, cVar);
        stepInnerClient$stream$1.c = obj;
        return stepInnerClient$stream$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((StepInnerClient$stream$1) create((p9.d) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00f5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.android.mindx.client.inner.StepInnerClient$stream$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
