package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
abstract class s {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f13373a;

    /* renamed from: b, reason: collision with root package name */
    final r f13374b;

    /* renamed from: c, reason: collision with root package name */
    final Context f13375c;

    /* renamed from: d, reason: collision with root package name */
    final CheckableImageButton f13376d;

    s(r rVar) {
        this.f13373a = rVar.f13343a;
        this.f13374b = rVar;
        this.f13375c = rVar.getContext();
        this.f13376d = rVar.r();
    }

    void a(Editable editable) {
    }

    void b(CharSequence charSequence, int i5, int i6, int i7) {
    }

    int c() {
        return 0;
    }

    int d() {
        return 0;
    }

    View.OnFocusChangeListener e() {
        return null;
    }

    View.OnClickListener f() {
        return null;
    }

    View.OnFocusChangeListener g() {
        return null;
    }

    AccessibilityManager.TouchExplorationStateChangeListener h() {
        return null;
    }

    boolean i(int i5) {
        return true;
    }

    boolean j() {
        return false;
    }

    boolean k() {
        return false;
    }

    boolean l() {
        return false;
    }

    boolean m() {
        return false;
    }

    void n(EditText editText) {
    }

    void o(View view, E.c cVar) {
    }

    void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    void q(boolean z5) {
    }

    final void r() {
        this.f13374b.L(false);
    }

    void s() {
    }

    boolean t() {
        return false;
    }

    void u() {
    }
}
