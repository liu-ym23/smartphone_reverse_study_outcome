package com.bytedance.ai.lynx;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletLynxViewApi$createLynxView$4$createUI$1$3 implements com.bytedance.ai.applet.render.core.camera.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnlineAppletApplication f36631a;

    public AppletLynxViewApi$createLynxView$4$createUI$1$3(OnlineAppletApplication r100) {
        this.f36631a = r100;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.a
    public final Object a(Continuation<? super Boolean> r110) {
        if ((r110 instanceof AppletLynxViewApi$createLynxView$4$createUI$1$3$authorizeCamera$1) == false) goto L7;
        AppletLynxViewApi$createLynxView$4$createUI$1$3$authorizeCamera$1 r100 = (AppletLynxViewApi$createLynxView$4$createUI$1$3$authorizeCamera$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AppletLynxViewApi$createLynxView$4$createUI$1$3$authorizeCamera$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L18:
        return Boxing.boxBoolean(((com.bytedance.ai.applet.permission.f) r111).f34946a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        AppletAuthorizeHelper r105 = this.f36631a.h().a();
        r102.label = 1;
        r111 = AppletAuthorizeHelper.e(r105, "scope.camera", false, null, null, null, r102, 30);
        if (r111 != r103) goto L18;
        return r103;
    L7:
        r100 = new AppletLynxViewApi$createLynxView$4$createUI$1$3$authorizeCamera$1(this, r110);
        goto L8
    }
}
