package com.stepos.ailauncher.task.detail.render;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.render.ArtifactContentView$fetchTextWithUrl$1$text$1", f = "ArtifactContentView.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactContentView$fetchTextWithUrl$1$text$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super String>, Object> {
    final /* synthetic */ Ref$ObjectRef<Integer> $httpCode;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactContentView$fetchTextWithUrl$1$text$1(String str, Ref$ObjectRef<Integer> ref$ObjectRef, InterfaceC4014c<? super ArtifactContentView$fetchTextWithUrl$1$text$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$url = str;
        this.$httpCode = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ArtifactContentView$fetchTextWithUrl$1$text$1 artifactContentView$fetchTextWithUrl$1$text$1 = new ArtifactContentView$fetchTextWithUrl$1$text$1(this.$url, this.$httpCode, interfaceC4014c);
        artifactContentView$fetchTextWithUrl$1$text$1.L$0 = obj;
        return artifactContentView$fetchTextWithUrl$1$text$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super String> interfaceC4014c) {
        return ((ArtifactContentView$fetchTextWithUrl$1$text$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.Integer] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        AbstractC5531D body;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String str = this.$url;
        Ref$ObjectRef<Integer> ref$ObjectRef = this.$httpCode;
        try {
            Result.Companion companion = Result.INSTANCE;
            C5530C c5530cExecute = ArtifactContentView.INSTANCE.b().a(new C5528A.a().t(str).b()).execute();
            try {
                ref$ObjectRef.f34820a = C4109a.f(c5530cExecute.getCode());
                String strA = (c5530cExecute.getIsSuccessful() && (body = c5530cExecute.getBody()) != null) ? body.A() : null;
                l9.b.a(c5530cExecute, null);
                objB = Result.b(strA);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str2 = this.$url;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("ArtifactContentView", "fetchTextWithUrl failed url=" + La.K.R1(str2, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME), thE, false, 8, null);
        }
        if (Result.g(objB)) {
            return null;
        }
        return objB;
    }
}
