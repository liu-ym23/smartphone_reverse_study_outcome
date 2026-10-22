package stepos.support.v7.app;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class A extends Dialog implements InterfaceC0867l {
    private AbstractC0868m mDelegate;

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ((ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content)).addView(view, layoutParams);
        abstractC0880z.f14511c.onContentChanged();
    }

    @Override // android.app.Dialog
    @Nullable
    public View findViewById(@IdRes int i4) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        return abstractC0880z.f14510b.findViewById(i4);
    }

    public AbstractC0868m getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new C0875u(getContext(), getWindow(), this);
        }
        return this.mDelegate;
    }

    public AbstractC0860e getSupportActionBar() {
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        abstractC0870o.l();
        return abstractC0870o.f14514f;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().d();
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onBottomItemSelected(L3.g gVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().getClass();
        super.onCreate(bundle);
        getDelegate().e(bundle);
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onCreateBottomMenu(L3.f fVar) {
        return false;
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onMenuItemSelected(int i4, L3.g gVar) {
        return false;
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onOptionsMenuCreated(L3.f fVar) {
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.l();
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.p(false);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onSupportActionModeFinished(K3.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onSupportActionModeStarted(K3.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    @Nullable
    public K3.c onWindowStartingSupportActionMode(K3.b bVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(@LayoutRes int i4) {
        getDelegate().h(i4);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        abstractC0870o.f14522n = charSequence;
        AbstractC0880z abstractC0880z = (AbstractC0880z) abstractC0870o;
        stepos.support.v7.widget.C c4 = abstractC0880z.f14628q;
        if (c4 != null) {
            c4.setWindowTitle(charSequence);
            return;
        }
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.t(charSequence);
            return;
        }
        TextView textView = abstractC0880z.f14612A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean supportRequestWindowFeature(int i4) {
        return getDelegate().g(i4);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ViewGroup viewGroup = (ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        abstractC0880z.f14511c.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ViewGroup viewGroup = (ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        abstractC0880z.f14511c.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setTitle(int i4) {
        super.setTitle(i4);
        AbstractC0868m delegate = getDelegate();
        String string = getContext().getString(i4);
        AbstractC0870o abstractC0870o = (AbstractC0870o) delegate;
        abstractC0870o.f14522n = string;
        AbstractC0880z abstractC0880z = (AbstractC0880z) abstractC0870o;
        stepos.support.v7.widget.C c4 = abstractC0880z.f14628q;
        if (c4 != null) {
            c4.setWindowTitle(string);
            return;
        }
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.t(string);
            return;
        }
        TextView textView = abstractC0880z.f14612A;
        if (textView != null) {
            textView.setText(string);
        }
    }
}
