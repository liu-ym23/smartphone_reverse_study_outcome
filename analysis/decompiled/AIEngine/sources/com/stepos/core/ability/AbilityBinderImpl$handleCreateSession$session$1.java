package com.stepos.core.ability;

import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.data.base.Content;
import kotlin.jvm.internal.FunctionReferenceImpl;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class AbilityBinderImpl$handleCreateSession$session$1 extends FunctionReferenceImpl implements q<String, Content, IInferenceCallback, n> {
    public AbilityBinderImpl$handleCreateSession$session$1(Object obj) {
        super(3, obj, AbilityBinderImpl.class, "handleInfer", "handleInfer(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/callback/IInferenceCallback;)V", 0);
    }

    @Override // zb.q
    public /* bridge */ /* synthetic */ n invoke(String str, Content content, IInferenceCallback iInferenceCallback) throws Throwable {
        invoke2(str, content, iInferenceCallback);
        return n.f10413a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p02, Content p12, IInferenceCallback iInferenceCallback) throws Throwable {
        kotlin.jvm.internal.g.f(p02, "p0");
        kotlin.jvm.internal.g.f(p12, "p1");
        ((AbilityBinderImpl) this.receiver).handleInfer(p02, p12, iInferenceCallback);
    }
}
