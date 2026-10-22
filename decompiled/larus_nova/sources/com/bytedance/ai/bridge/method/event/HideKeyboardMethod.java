package com.bytedance.ai.bridge.method.event;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.keyboard.AbsHideKeyboardMethodIDL;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import e3.d;
import e3.e;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/HideKeyboardMethod;", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL$HideKeyboardParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideKeyboardMethod extends AbsHideKeyboardMethodIDL {
    public HideKeyboardMethod() {
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsHideKeyboardMethodIDL.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r103 = r100.getEngineView();
        Activity r104 = e.a(r100);
        InputMethodManager r105 = null;
        if (r104 == null) goto L6;
        View r106 = r104.getCurrentFocus();
        if (r106 == null) goto L6;
    L15:
        if (r106 != null) goto L31;
        r106 = r100.getEngineView();
        if (r106 != null) goto L31;
        Activity r107 = r100.getOwnerActivity();
        if (r107 == null) goto L23;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L23;
        r106 = b(r108);
    L24:
        if (r106 != null) goto L31;
        Activity r109 = k.b();
        if (r109 == null) goto L30;
        Window r110 = r109.getWindow();
        if (r110 == null) goto L30;
        r106 = b(r110);
    L30:
        r106 = null;
    L23:
        r106 = null;
    L31:
        if (r106 == null) goto L35;
        Context r111 = r106.getContext();
        if (r111 == null) goto L35;
        Object r112 = r111.getSystemService("input_method");
    L37:
        if ((r112 instanceof InputMethodManager) == false) goto L39;
        r105 = (InputMethodManager) r112;
    L39:
        if (r106 == null) goto L41;
        r106.clearFocus();
    L41:
        if (r106 == null) goto L46;
        IBinder r113 = r106.getWindowToken();
        if (r113 == null) goto L46;
        if (r105 == null) goto L46;
        r105.hideSoftInputFromWindow(r113, 0);
    L46:
        Intrinsics.checkNotNullParameter(AbsHideKeyboardMethodIDL.a.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsHideKeyboardMethodIDL.a.class), "");
        return;
    L35:
        r112 = null;
    L6:
        if (r103 == null) goto L8;
        r106 = r103.findFocus();
    L9:
        if (r106 != null) goto L15;
        if (r103 == null) goto L14;
        View r114 = r103.getRootView();
        if (r114 == null) goto L14;
        r106 = r114.findFocus();
    L14:
        r106 = null;
        goto L15
    L8:
        r106 = null;
        goto L9
    }
}
