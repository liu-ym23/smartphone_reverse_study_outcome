package com.stepos.ailauncher.chat.view;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.MainInputView$wake$1", f = "MainInputView.kt", l = {57}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class MainInputView$wake$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ MainInputView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainInputView$wake$1(MainInputView mainInputView, String str, InterfaceC4014c<? super MainInputView$wake$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = mainInputView;
        this.$source = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new MainInputView$wake$1(this.this$0, this.$source, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((MainInputView$wake$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            InterfaceC5074l<InterfaceC4014c<? super Boolean>, Object> onWaked = this.this$0.getOnWaked();
            if (onWaked != null) {
                this.label = 1;
                obj = onWaked.invoke(this);
                if (obj == objG) {
                    return objG;
                }
            }
            this.this$0.sd(this.$source);
            return Y8.t.f7040a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.sd(this.$source);
        return Y8.t.f7040a;
    }
}
