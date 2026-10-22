package com.obric.aiagent.product.platform.impl.b;

import android.view.inputmethod.ObricInputMethodManager;
import d.h.b.o;

/* JADX INFO: compiled from: InjectTextResponseBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18825a = null;

    static {
        f18825a = new d();
    }

    private d() {
    }

    public final boolean a(com.obric.framework.inputmethod.api.b r1) {
        o.e(r1, "listener");
        ObricInputMethodManager.registerInjectTextResponseListener(r1.a());
        return true;
    }

    public final boolean b(com.obric.framework.inputmethod.api.b r1) {
        o.e(r1, "listener");
        ObricInputMethodManager.unregisterInjectTextResponseListener(r1.a());
        return true;
    }
}
