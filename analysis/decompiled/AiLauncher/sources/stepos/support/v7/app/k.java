package stepos.support.v7.app;

import Ic.b;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;

/* loaded from: classes5.dex */
public class k extends Dialog implements e {
    private f mDelegate;

    public k(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    @Override // android.app.Dialog
    public View findViewById(int i10) {
        return getDelegate().h(i10);
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
    public boolean onBottomItemSelected(Jc.g gVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().n();
        super.onCreate(bundle);
        getDelegate().q(bundle);
    }

    @Override // stepos.support.v7.app.e
    public boolean onCreateBottomMenu(Jc.f fVar) {
        return false;
    }

    @Override // stepos.support.v7.app.e
    public boolean onMenuItemSelected(int i10, Jc.g gVar) {
        return false;
    }

    @Override // stepos.support.v7.app.e
    public void onOptionsMenuCreated(Jc.f fVar) {
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().v();
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeFinished(Ic.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeStarted(Ic.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public Ic.b onWindowStartingSupportActionMode(b.InterfaceC0060b interfaceC0060b) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        getDelegate().z(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().D(charSequence);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().w(i10);
    }

    public k(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        getDelegate().q(null);
        getDelegate().d();
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
    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().D(getContext().getString(i10));
    }

    public k(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
    }
}
