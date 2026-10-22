package com.bytedance.android.livesdk.chatroom.dsl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import yt1.k;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lyt1/k;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyt1/k;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DSLContainerDynamicProxy$loadDSLDynamicView$2 extends FunctionReferenceImpl implements Function1<k, Unit> {
    public DSLContainerDynamicProxy$loadDSLDynamicView$2(DSLContainerDynamicProxy r100) {
        super(1, r100, DSLContainerDynamicProxy.class, "setAsyncFinished", "setAsyncFinished(Lcom/bytedance/android/livesdk/dsl/api/IDSLComponent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(k r100) {
        ((DSLContainerDynamicProxy) this.receiver).f105884e.h(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(k r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
