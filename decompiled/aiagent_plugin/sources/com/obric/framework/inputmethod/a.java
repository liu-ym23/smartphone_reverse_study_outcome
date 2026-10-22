package com.obric.framework.inputmethod;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.framework.inputmethod.api.IObricInputmethodManager;
import com.obric.framework.inputmethod.api.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricInputmethodManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "ObricInputmethodManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0903a f33232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IObricInputmethodManager f33233b;

    /* JADX INFO: renamed from: com.obric.framework.inputmethod.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricInputmethodManager.kt */
    public static final class C0903a implements IObricInputmethodManager {
        public /* synthetic */ C0903a(h r1) {
            this();
        }

        private C0903a() {
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public void updateSelection(InputMethodManager r8, View r9, int r10, int r11, int r12, int r13) {
            o.e(r8, "imm");
            o.e(r9, "view");
            IObricInputmethodManager r0 = a.a();
            if (r0 == null) goto L6;
            r0.updateSelection(r8, r9, r10, r11, r12, r13);
            return;
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public boolean injectText(CharSequence r2, boolean r3) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r1, "text");
            IObricInputmethodManager r4 = a.a();
            if (r4 != null) goto L7;
            return false;
        L7:
            return r4.injectText(r1, r3);
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public void clearInputMethodState() {
            IObricInputmethodManager r0 = a.a();
            if (r0 == null) goto L6;
            r0.clearInputMethodState();
            return;
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public boolean registerObricInjectEventCallback(com.obric.framework.inputmethod.api.a r1) {
            o.e(r1, "listener");
            IObricInputmethodManager r0 = a.a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerObricInjectEventCallback(r1);
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public boolean unregisterObricInjectEventCallback(com.obric.framework.inputmethod.api.a r1) {
            o.e(r1, "listener");
            IObricInputmethodManager r0 = a.a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterObricInjectEventCallback(r1);
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public boolean registerInjectTextResponseCallback(b r1) {
            o.e(r1, "listener");
            IObricInputmethodManager r0 = a.a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.registerInjectTextResponseCallback(r1);
        }

        @Override // com.obric.framework.inputmethod.api.IObricInputmethodManager
        public boolean unregisterInjectTextResponseCallback(b r1) {
            o.e(r1, "listener");
            IObricInputmethodManager r0 = a.a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.unregisterInjectTextResponseCallback(r1);
        }
    }

    public static /* synthetic */ Object lambda$J9JAcU_cSt2ykaV5Z30la1ssI4E() {
        return b();
    }

    public static /* synthetic */ Object lambda$PT2EBfq32CYo7XbHWzzSXOa_Lmg() {
        return c();
    }

    public static final /* synthetic */ IObricInputmethodManager a() {
        return f33233b;
    }

    static {
        f33232a = new C0903a(null);
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind ObricInputmethodManager failed", th);
    L11:
        f33233b = (IObricInputmethodManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricInputmethodManager.class, false), IObricInputmethodManager.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "ObricInputmethodManager instance: " + f33233b);
        return;
    L4:
        if (com.obric.aiagent.product.a.b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricInputmethodManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$a$J9JAcU_cSt2ykaV5Z30la1ssI4E.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
    L7:
        ILogDepend.Companion.i(TAG, "bind InputmethodManager assistantApi=" + com.obric.aiagent.product.a.b.f18770a.a());     // Catch: Throwable -> L9
        goto L11
    L6:
        ServiceManager.get().bind(IObricInputmethodManager.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$a$PT2EBfq32CYo7XbHWzzSXOa_Lmg.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L7
    }

    private static final Object b() {
        return new com.obric.aiagent.product.platform.impl.b.a();
    }

    private static final Object c() {
        return new com.obric.aiagent.product.platform.impl.b.b();
    }
}
