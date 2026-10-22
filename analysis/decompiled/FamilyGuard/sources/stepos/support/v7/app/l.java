package stepos.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import b5.b;
import g.C0728a;

/* loaded from: classes.dex */
public class l extends Dialog implements e {
    private f mDelegate;

    public l(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i5) {
        if (i5 != 0) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16807D, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public View findViewById(int i5) {
        return getDelegate().h(i5);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.f(this, this);
        }
        return this.mDelegate;
    }

    public a getSupportActionBar() {
        return getDelegate().l();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().o();
    }

    @Override // stepos.support.v7.app.e
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.e
    public boolean onBottomItemSelected(c5.f fVar) {
        return false;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getDelegate().n();
        super.onCreate(bundle);
        getDelegate().q(bundle);
    }

    @Override // stepos.support.v7.app.e
    public boolean onCreateBottomMenu(c5.e eVar) {
        return false;
    }

    @Override // stepos.support.v7.app.e
    public boolean onMenuItemSelected(int i5, c5.f fVar) {
        return false;
    }

    @Override // stepos.support.v7.app.e
    public void onOptionsMenuCreated(c5.e eVar) {
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().v();
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeFinished(b5.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeStarted(b5.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public b5.b onWindowStartingSupportActionMode(b.InterfaceC0154b interfaceC0154b) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i5) {
        getDelegate().z(i5);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().D(charSequence);
    }

    public boolean supportRequestWindowFeature(int i5) {
        return getDelegate().w(i5);
    }

    public l(Context context, int i5) {
        super(context, getThemeResId(context, i5));
        getDelegate().q(null);
        getDelegate().b();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().A(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().B(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i5) {
        super.setTitle(i5);
        getDelegate().D(getContext().getString(i5));
    }

    protected l(Context context, boolean z5, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z5, onCancelListener);
    }
}
