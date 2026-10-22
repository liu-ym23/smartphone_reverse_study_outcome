package com.stepos.policy.sdk.widget;

import android.view.View;
import jb.v;
import kc.t;
import kc.w;
import nb.c;
import od.f;
import pb.e;
import pb.i;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@e(c = "com.stepos.policy.sdk.widget.PolicySDKLoadDataView$setDebounceClickListener$1$1", f = "PolicySDKLoadDataView.kt", l = {157}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PolicySDKLoadDataView$setDebounceClickListener$1$1 extends i implements p {
    final /* synthetic */ View $it;
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ long $time;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PolicySDKLoadDataView$setDebounceClickListener$1$1(long j10, View.OnClickListener onClickListener, View view, c cVar) {
        super(2, cVar);
        this.$time = j10;
        this.$listener = onClickListener;
        this.$it = view;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new PolicySDKLoadDataView$setDebounceClickListener$1$1(this.$time, this.$listener, this.$it, cVar);
    }

    @Override // xb.p
    public final Object invoke(t tVar, c cVar) {
        return ((PolicySDKLoadDataView$setDebounceClickListener$1$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        ob.a aVar = ob.a.f9351c;
        int i = this.label;
        if (i == 0) {
            id.c.I(obj);
            long j10 = this.$time;
            this.label = 1;
            if (w.g(j10, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        this.$listener.onClick(this.$it);
        return v.f6774a;
    }
}
