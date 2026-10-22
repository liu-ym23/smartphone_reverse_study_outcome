package com.obric.aiagent.product.platform.impl.b;

import android.view.View;
import android.view.inputmethod.AssistantInputMethodManager;
import android.view.inputmethod.InputMethodManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.framework.inputmethod.api.IObricInputmethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantInputmethodManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IObricInputmethodManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0401a f18822a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistantInputmethodManagerImpl.kt */
    public static final class C0401a {
        public /* synthetic */ C0401a(h r1) {
            this();
        }

        private C0401a() {
        }
    }

    static {
        f18822a = new C0401a(null);
    }

    public a() {
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public void updateSelection(InputMethodManager r1, View r2, int r3, int r4, int r5, int r6) {
        o.e(r1, "imm");
        o.e(r2, "view");
        AssistantInputMethodManager.updateSelection(r1, r2, r3, r4, r5, r6);
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean injectText(CharSequence r2, boolean r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r1, "text");
        return AssistantInputMethodManager.injectText(r1, r3);
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public void clearInputMethodState() {
        AssistantInputMethodManager.clearInputMethodState();
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean registerObricInjectEventCallback(com.obric.framework.inputmethod.api.a r3) {
        o.e(r3, "listener");
        return c.f18824a.c(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantInputmethodManagerImpl", "registerObricInjectEventCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean unregisterObricInjectEventCallback(com.obric.framework.inputmethod.api.a r3) {
        o.e(r3, "listener");
        return c.f18824a.d(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantInputmethodManagerImpl", "unregisterObricInjectEventCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean registerInjectTextResponseCallback(com.obric.framework.inputmethod.api.b r3) {
        o.e(r3, "listener");
        return d.f18825a.a(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantInputmethodManagerImpl", "registerInjectTextResponseCallback failed", th);
        return false;
    }

    @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
    public boolean unregisterInjectTextResponseCallback(com.obric.framework.inputmethod.api.b r3) {
        o.e(r3, "listener");
        return d.f18825a.b(r3);
    L5:
        th = move-exception;
        ILogDepend.Companion.e("AssistantInputmethodManagerImpl", "unregisterInjectTextResponseCallback failed", th);
        return false;
    }
}
