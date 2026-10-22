package com.stepos.ailauncher.floatcard;

import E4.d;
import E4.e;
import Ua.M;
import Y8.t;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.floatcard.FloatCardServiceImpl$dispatch$3", f = "FloatCardServiceImpl.kt", l = {196}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class FloatCardServiceImpl$dispatch$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ d $event;
    final /* synthetic */ IFloatCardEventHandler $handler;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FloatCardServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatCardServiceImpl$dispatch$3(FloatCardServiceImpl floatCardServiceImpl, d dVar, IFloatCardEventHandler iFloatCardEventHandler, InterfaceC4014c<? super FloatCardServiceImpl$dispatch$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = floatCardServiceImpl;
        this.$event = dVar;
        this.$handler = iFloatCardEventHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        FloatCardServiceImpl$dispatch$3 floatCardServiceImpl$dispatch$3 = new FloatCardServiceImpl$dispatch$3(this.this$0, this.$event, this.$handler, interfaceC4014c);
        floatCardServiceImpl$dispatch$3.L$0 = obj;
        return floatCardServiceImpl$dispatch$3;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((FloatCardServiceImpl$dispatch$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                IFloatCardEventHandler iFloatCardEventHandler = this.$handler;
                d dVar = this.$event;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = h.a(m10);
                this.L$1 = h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = iFloatCardEventHandler.handle(dVar, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((e) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "操作失败";
            }
            objB = new e.Error(message, false, 2, null);
        }
        this.this$0.f(this.$event.getCardId(), (e) objB);
        return t.f7040a;
    }
}
