package com.obric.framework.inputmethod.api;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: compiled from: IObricInputmethodManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IObricInputmethodManager {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IObricInputmethodManager.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f33234a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f33235b = null;

        private a() {
        }

        static {
            f33234a = new a();
            com.obric.aiagent.product.a.b.f18770a.a();
            f33235b = "AUTO_IME_TAG";
        }
    }

    static {
        Companion = a.f33234a;
    }

    void clearInputMethodState();

    boolean injectText(CharSequence r1, boolean r2);

    boolean registerInjectTextResponseCallback(b r1);

    boolean registerObricInjectEventCallback(com.obric.framework.inputmethod.api.a r1);

    boolean unregisterInjectTextResponseCallback(b r1);

    boolean unregisterObricInjectEventCallback(com.obric.framework.inputmethod.api.a r1);

    void updateSelection(InputMethodManager r1, View r2, int r3, int r4, int r5, int r6);
}
