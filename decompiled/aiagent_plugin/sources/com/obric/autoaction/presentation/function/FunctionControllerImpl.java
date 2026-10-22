package com.obric.autoaction.presentation.function;

import com.obric.autogui.vdplayer.api.function.IFunctionController;
import d.h.b.o;

/* JADX INFO: compiled from: FunctionControllers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FunctionControllerImpl implements IFunctionController {
    public FunctionControllerImpl() {
    }

    @Override // com.obric.autogui.vdplayer.api.function.IFunctionController
    public String getActiveFunctionType() {
        return b.f24937a.a();
    }

    @Override // com.obric.autogui.vdplayer.api.function.IFunctionController
    public void startFunction(String r1) {
        o.e(r1, "functionName");
        a r0 = b.f24937a.b(r1);
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.obric.autogui.vdplayer.api.function.IFunctionController
    public void stopFunction(String r1) {
        o.e(r1, "functionName");
        a r0 = b.f24937a.b(r1);
        if (r0 == null) goto L6;
        r0.e();
        return;
    }
}
