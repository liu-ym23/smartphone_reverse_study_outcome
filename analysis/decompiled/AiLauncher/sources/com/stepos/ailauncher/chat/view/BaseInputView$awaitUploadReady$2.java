package com.stepos.ailauncher.chat.view;

import Ua.InterfaceC1066l;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.BaseInputView$awaitUploadReady$2", f = "BaseInputView.kt", l = {9863}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class BaseInputView$awaitUploadReady$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Boolean>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ BaseInputView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, Y8.t> {
        final /* synthetic */ InterfaceC1066l<Y8.t> $cont;
        final /* synthetic */ BaseInputView this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseInputView baseInputView, InterfaceC1066l<? super Y8.t> interfaceC1066l) {
            this.this$0 = baseInputView;
            this.$cont = interfaceC1066l;
        }

        public final void a(Throwable th) {
            this.this$0.uploadReadyWaiters.remove(this.$cont);
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
            a(th);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInputView$awaitUploadReady$2(BaseInputView baseInputView, InterfaceC4014c<? super BaseInputView$awaitUploadReady$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = baseInputView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseInputView$awaitUploadReady$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((BaseInputView$awaitUploadReady$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            BaseInputView baseInputView = this.this$0;
            this.L$0 = baseInputView;
            this.I$0 = 0;
            this.label = 1;
            kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
            cVar.I();
            baseInputView.uploadReadyWaiters.add(cVar);
            cVar.q(new a(baseInputView, cVar));
            if (baseInputView.picAndFileReadyStatus != -1 && cVar.b()) {
                baseInputView.uploadReadyWaiters.remove(cVar);
                Result.Companion companion = Result.INSTANCE;
                cVar.resumeWith(Result.b(Y8.t.f7040a));
            }
            Object objC = cVar.C();
            if (objC == C4063a.g()) {
                g9.f.c(this);
            }
            if (objC == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return C4109a.a(true);
    }
}
