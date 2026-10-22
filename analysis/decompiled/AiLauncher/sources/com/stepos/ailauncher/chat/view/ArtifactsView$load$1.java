package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import android.view.LifecycleOwner;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ArtifactsView$load$1", f = "ArtifactsView.kt", l = {127}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ArtifactsView$load$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ LifecycleOwner $owner;
    int label;
    final /* synthetic */ ArtifactsView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsView$load$1(ArtifactsView artifactsView, LifecycleOwner lifecycleOwner, String str, InterfaceC4014c<? super ArtifactsView$load$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = artifactsView;
        this.$owner = lifecycleOwner;
        this.$key = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ArtifactsView$load$1(this.this$0, this.$owner, this.$key, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ArtifactsView$load$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            ArtifactsView$load$1$products$1 artifactsView$load$1$products$1 = new ArtifactsView$load$1$products$1(this.$key, this.this$0, null);
            this.label = 1;
            obj = C1056g.j(iB, artifactsView$load$1$products$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.m(this.$owner, (List) obj);
        return Y8.t.f7040a;
    }
}
