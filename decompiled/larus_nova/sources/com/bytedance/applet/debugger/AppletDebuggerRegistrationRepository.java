package com.bytedance.applet.debugger;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletDebuggerRegistrationRepository {
    public AppletDebuggerRegistrationRepository() {
    }

    public final Object a(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AppletDebuggerRegistrationRepository$isRegistered$1) == false) goto L7;
        AppletDebuggerRegistrationRepository$isRegistered$1 r101 = (AppletDebuggerRegistrationRepository$isRegistered$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        Boolean r106 = (Boolean) r103;
        if (r106 != null) goto L20;
        com.bytedance.ai.utils.g.f37637a.w("AppletDebuggerRegistration", "[isRegistered] request timeout");
    L20:
        if (r106 == null) goto L22;
        boolean r107 = r106.booleanValue();
    L24:
        return Boxing.boxBoolean(r107);
    L22:
        r107 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        com.bytedance.ai.utils.g.f37637a.i("AppletDebuggerRegistration", "[isRegistered] request start");
        AppletDebuggerRegistrationRepository$isRegistered$registered$1 r108 = new AppletDebuggerRegistrationRepository$isRegistered$registered$1(null);
        r101.label = 1;
        r103 = TimeoutKt.c(10000, r108, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new AppletDebuggerRegistrationRepository$isRegistered$1(this, r100);
        goto L8
    }
}
