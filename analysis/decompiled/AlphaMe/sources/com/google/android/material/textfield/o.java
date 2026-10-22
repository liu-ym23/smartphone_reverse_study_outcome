package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f11057a;

    /* renamed from: b, reason: collision with root package name */
    public final n f11058b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11059c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f11060d;

    public o(n nVar) {
        this.f11057a = nVar.f11035a;
        this.f11058b = nVar;
        this.f11059c = nVar.getContext();
        this.f11060d = nVar.f11041g;
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

    public boolean i(int i4) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof k;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText) {
    }

    public void n(L.g gVar) {
    }

    public void o(AccessibilityEvent accessibilityEvent) {
    }

    public void p(boolean z4) {
    }

    public final void q() {
        this.f11058b.f(false);
    }

    public abstract void r();

    public void s() {
    }
}
