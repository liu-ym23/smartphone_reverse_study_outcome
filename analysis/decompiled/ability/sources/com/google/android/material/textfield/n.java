package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes3.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2682a;
    public final m b;
    public final Context c;
    public final CheckableImageButton d;

    public n(m mVar) {
        this.f2682a = mVar.f2675a;
        this.b = mVar;
        this.c = mVar.getContext();
        this.d = mVar.g;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return null;
    }

    public boolean i(int i) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof j;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z10) {
    }

    public final void q() {
        this.b.f(false);
    }

    public void r() {
    }

    public void s() {
    }
}
