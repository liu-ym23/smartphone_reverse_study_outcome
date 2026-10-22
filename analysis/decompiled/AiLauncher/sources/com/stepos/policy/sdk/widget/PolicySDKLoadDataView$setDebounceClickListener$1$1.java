package com.stepos.policy.sdk.widget;

import Ua.M;
import Ua.U;
import Y8.t;
import android.view.View;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {1, 8, 0})
@InterfaceC4112d(c = "com.stepos.policy.sdk.widget.PolicySDKLoadDataView$setDebounceClickListener$1$1", f = "PolicySDKLoadDataView.kt", l = {157}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView$setDebounceClickListener$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView$setDebounceClickListener$1$1(long j10, View.OnClickListener onClickListener, View view, InterfaceC4014c<? super PolicySDKLoadDataView$setDebounceClickListener$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$time = j10;
        this.$listener = onClickListener;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new PolicySDKLoadDataView$setDebounceClickListener$1$1(this.$time, this.$listener, this.$it, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((PolicySDKLoadDataView$setDebounceClickListener$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long j10 = this.$time;
            this.label = 1;
            if (U.a(j10, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.$listener.onClick(this.$it);
        return t.f7040a;
    }
}
