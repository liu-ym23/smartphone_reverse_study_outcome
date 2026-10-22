package com.obric.aiagent.product.platform.impl.b;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.ObricInputMethodManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.framework.inputmethod.api.IObricInputmethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CommonObricInputmethodManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements IObricInputmethodManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18823a = null;

    /* JADX INFO: compiled from: CommonObricInputmethodManager.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f18823a = new a(null);
    }

    public b() {
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public void updateSelection(InputMethodManager r1, View r2, int r3, int r4, int r5, int r6) {
        o.e(r1, "imm");
        o.e(r2, "view");
        ObricInputMethodManager.updateSelection(r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean injectText(CharSequence r2, boolean r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r1, "text");
        return ObricInputMethodManager.injectText(r1, r3);
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public void clearInputMethodState() {
        ObricInputMethodManager.clearInputMethodState();
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean registerObricInjectEventCallback(com.obric.framework.inputmethod.api.a r3) {
        o.e(r3, "listener");
        return c.f18824a.a(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricInputmethodManager", "registerObricInjectEventCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean unregisterObricInjectEventCallback(com.obric.framework.inputmethod.api.a r3) {
        o.e(r3, "listener");
        return c.f18824a.b(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricInputmethodManager", "unregisterObricInjectEventCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean registerInjectTextResponseCallback(com.obric.framework.inputmethod.api.b r3) {
        o.e(r3, "listener");
        return d.f18825a.a(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricInputmethodManager", "registerInjectTextResponseCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean unregisterInjectTextResponseCallback(com.obric.framework.inputmethod.api.b r3) {
        o.e(r3, "listener");
        return d.f18825a.b(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("CommonObricInputmethodManager", "unregisterInjectTextResponseCallback failed", th);
        return false;
    }
}
