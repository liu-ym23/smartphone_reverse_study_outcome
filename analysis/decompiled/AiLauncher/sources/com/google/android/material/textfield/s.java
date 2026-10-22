package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f21640a;

    /* renamed from: b, reason: collision with root package name */
    public final r f21641b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f21642c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f21643d;

    public s(r rVar) {
        this.f21640a = rVar.f21610a;
        this.f21641b = rVar;
        this.f21642c = rVar.getContext();
        this.f21643d = rVar.r();
    }

    public void a(Editable editable) {
    }

    public void b(CharSequence charSequence, int i10, int i11, int i12) {
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

    public boolean i(int i10) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return false;
    }

    public boolean m() {
        return false;
    }

    public void n(EditText editText) {
    }

    public void o(View view, C0.c cVar) {
    }

    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    public void q(boolean z10) {
    }

    public final void r() {
        this.f21641b.L(false);
    }

    public void s() {
    }

    public boolean t() {
        return false;
    }

    public void u() {
    }
}
