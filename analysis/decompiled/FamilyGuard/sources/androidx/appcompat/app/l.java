package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.u;
import androidx.appcompat.view.b;
import androidx.core.view.C0465j;
import androidx.lifecycle.Y;
import c0.C0577g;
import g.C0728a;

/* loaded from: classes.dex */
public class l extends androidx.activity.k implements e {

    /* renamed from: d, reason: collision with root package name */
    private g f7641d;

    /* renamed from: e, reason: collision with root package name */
    private final C0465j.a f7642e;

    public l(Context context, int i5) {
        super(context, i(context, i5));
        this.f7642e = new C0465j.a() { // from class: androidx.appcompat.app.k
            @Override // androidx.core.view.C0465j.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f7640a.k(keyEvent);
            }
        };
        g gVarH = h();
        gVarH.J(i(context, i5));
        gVarH.v(null);
    }

    private static int i(Context context, int i5) {
        if (i5 != 0) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16807D, typedValue, true);
        return typedValue.resourceId;
    }

    private void j() {
        Y.a(getWindow().getDecorView(), this);
        C0577g.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.appcompat.app.e
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        h().e(view, layoutParams);
    }

    @Override // androidx.appcompat.app.e
    public void b(androidx.appcompat.view.b bVar) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        h().w();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0465j.b(this.f7642e, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.view.b f(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i5) {
        return (T) h().j(i5);
    }

    public g h() {
        if (this.f7641d == null) {
            this.f7641d = g.i(this, this);
        }
        return this.f7641d;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        h().s();
    }

    boolean k(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean l(int i5) {
        return h().E(i5);
    }

    @Override // androidx.activity.k, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        h().r();
        super.onCreate(bundle);
        h().v(bundle);
    }

    @Override // androidx.activity.k, android.app.Dialog
    protected void onStop() {
        super.onStop();
        h().B();
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(int i5) {
        j();
        h().F(i5);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        h().K(charSequence);
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(View view) {
        j();
        h().G(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i5) {
        super.setTitle(i5);
        h().K(getContext().getString(i5));
    }

    @Override // androidx.activity.k, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j();
        h().H(view, layoutParams);
    }
}
