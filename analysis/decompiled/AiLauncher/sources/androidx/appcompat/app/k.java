package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.core.view.C1322j;
import b.v;
import i.AbstractC4156b;

/* loaded from: classes.dex */
public class k extends v implements e {
    private g mDelegate;
    private final C1322j.a mKeyDispatcher;

    public k(Context context, int i10) {
        super(context, f(context, i10));
        this.mKeyDispatcher = new C1322j.a() { // from class: androidx.appcompat.app.j
            @Override // androidx.core.view.C1322j.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.f8439a.g(keyEvent);
            }
        };
        g gVarE = e();
        gVarE.Q(f(context, i10));
        gVarE.y(null);
    }

    private static int f(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // b.v, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        e().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C1322j.b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public g e() {
        if (this.mDelegate == null) {
            this.mDelegate = g.k(this, this);
        }
        return this.mDelegate;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) e().l(i10);
    }

    public boolean g(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean h(int i10) {
        return e().H(i10);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().v();
    }

    @Override // b.v, android.app.Dialog
    public void onCreate(Bundle bundle) {
        e().u();
        super.onCreate(bundle);
        e().y(bundle);
    }

    @Override // b.v, android.app.Dialog
    public void onStop() {
        super.onStop();
        e().E();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(AbstractC4156b abstractC4156b) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(AbstractC4156b abstractC4156b) {
    }

    @Override // androidx.appcompat.app.e
    public AbstractC4156b onWindowStartingSupportActionMode(AbstractC4156b.a aVar) {
        return null;
    }

    @Override // b.v, android.app.Dialog
    public void setContentView(int i10) {
        c();
        e().J(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().R(charSequence);
    }

    @Override // b.v, android.app.Dialog
    public void setContentView(View view) {
        c();
        e().K(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        e().R(getContext().getString(i10));
    }

    @Override // b.v, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        e().L(view, layoutParams);
    }
}
