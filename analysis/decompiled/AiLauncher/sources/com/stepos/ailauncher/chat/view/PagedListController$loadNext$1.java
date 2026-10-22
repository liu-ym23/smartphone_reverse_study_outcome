package com.stepos.ailauncher.chat.view;

import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.contract.model.ListPage;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.PagedListController$loadNext$1", f = "PagedListController.kt", l = {129}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class PagedListController$loadNext$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.p<Integer, InterfaceC4014c<? super ListPage<T>>, Object> $loader;
    final /* synthetic */ C2796d7.Request $request;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PagedListController<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PagedListController$loadNext$1(PagedListController<T> pagedListController, C2796d7.Request request, p9.p<? super Integer, ? super InterfaceC4014c<? super ListPage<T>>, ? extends Object> pVar, InterfaceC4014c<? super PagedListController$loadNext$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = pagedListController;
        this.$request = request;
        this.$loader = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PagedListController$loadNext$1(this.this$0, this.$request, this.$loader, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PagedListController$loadNext$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C2796d7 c2796d7P;
        C2796d7.Request request;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                c2796d7P = this.this$0.p();
                C2796d7.Request request2 = this.$request;
                p9.p<Integer, InterfaceC4014c<? super ListPage<T>>, Object> pVar = this.$loader;
                Integer numF = C4109a.f(request2.getKey());
                this.L$0 = c2796d7P;
                this.L$1 = request2;
                this.label = 1;
                Object objInvoke = pVar.invoke(numF, this);
                if (objInvoke == objG) {
                    return objG;
                }
                request = request2;
                obj = objInvoke;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                request = (C2796d7.Request) this.L$1;
                c2796d7P = (C2796d7) this.L$0;
                C4849c.b(obj);
            }
            if (c2796d7P.a(request, (ListPage) obj)) {
                PagedListController.u(this.this$0, false, 1, null);
            }
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            if (this.this$0.p().c(this.$request, e11)) {
                PagedListController.u(this.this$0, false, 1, null);
            }
        }
        return Y8.t.f7040a;
    }
}
