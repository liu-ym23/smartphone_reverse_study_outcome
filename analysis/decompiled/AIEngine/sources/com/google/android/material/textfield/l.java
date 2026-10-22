package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5286a;

    /* renamed from: b, reason: collision with root package name */
    public final k f5287b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f5288c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f5289d;

    public l(k kVar) {
        this.f5286a = kVar.f5259a;
        this.f5287b = kVar;
        this.f5288c = kVar.getContext();
        this.f5289d = kVar.f5264j;
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
        return this instanceof j;
    }

    public boolean k() {
        return false;
    }

    public final void p() {
        this.f5287b.f(false);
    }

    public void a() {
    }

    public void b() {
    }

    public void q() {
    }

    public void r() {
    }

    public void l(EditText editText) {
    }

    public void m(w0.b bVar) {
    }

    public void n(AccessibilityEvent accessibilityEvent) {
    }

    public void o(boolean z) {
    }
}
