package com.stepos.policy.sdk.widget;

import V3.o;
import V3.v;
import Z3.e;
import a4.C0428b;
import android.view.View;
import i4.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import s4.I;
import s4.S;

@f(c = "com.stepos.policy.sdk.widget.PolicySDKLoadDataView$setDebounceClickListener$1$1", f = "PolicySDKLoadDataView.kt", l = {157}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class PolicySDKLoadDataView$setDebounceClickListener$1$1 extends l implements p<I, e<? super v>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PolicySDKLoadDataView$setDebounceClickListener$1$1(long j5, View.OnClickListener onClickListener, View view, e<? super PolicySDKLoadDataView$setDebounceClickListener$1$1> eVar) {
        super(2, eVar);
        this.$time = j5;
        this.$listener = onClickListener;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final e<v> create(Object obj, e<?> eVar) {
        return new PolicySDKLoadDataView$setDebounceClickListener$1$1(this.$time, this.$listener, this.$it, eVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objE = C0428b.e();
        int i5 = this.label;
        if (i5 == 0) {
            o.b(obj);
            long j5 = this.$time;
            this.label = 1;
            if (S.a(j5, this) == objE) {
                return objE;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        this.$listener.onClick(this.$it);
        return v.f5542a;
    }

    @Override // i4.p
    public final Object invoke(I i5, e<? super v> eVar) {
        return ((PolicySDKLoadDataView$setDebounceClickListener$1$1) create(i5, eVar)).invokeSuspend(v.f5542a);
    }
}
