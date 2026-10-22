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

/* renamed from: stepos.support.v7.app.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractDialogC1976z extends Dialog implements InterfaceC1963l {
    private AbstractC1964m mDelegate;

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ((ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content)).addView(view, layoutParams);
        abstractC1975y.c.onContentChanged();
    }

    @Override // android.app.Dialog
    @Nullable
    public View findViewById(@IdRes int i) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        return abstractC1975y.b.findViewById(i);
    }

    public AbstractC1964m getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new C1968q(getContext(), getWindow(), this);
        }
        return this.mDelegate;
    }

    public AbstractC1955d getSupportActionBar() {
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        abstractC1966o.m();
        return abstractC1966o.f;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().b();
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onBottomItemSelected(Va.i iVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().getClass();
        super.onCreate(bundle);
        getDelegate().c(bundle);
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onCreateBottomMenu(Va.h hVar) {
        return false;
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onMenuItemSelected(int i, Va.i iVar) {
        return false;
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onOptionsMenuCreated(Va.h hVar) {
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.m();
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.p(false);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onSupportActionModeFinished(Ua.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onSupportActionModeStarted(Ua.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    @Nullable
    public Ua.c onWindowStartingSupportActionMode(Ua.b bVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(@LayoutRes int i) {
        getDelegate().g(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        abstractC1966o.n = charSequence;
        AbstractC1975y abstractC1975y = (AbstractC1975y) abstractC1966o;
        stepos.support.v7.widget.H h = abstractC1975y.f6362q;
        if (h != null) {
            h.setWindowTitle(charSequence);
            return;
        }
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.s(charSequence);
            return;
        }
        TextView textView = abstractC1975y.f6346A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().f(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ViewGroup viewGroup = (ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        abstractC1975y.c.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ViewGroup viewGroup = (ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        abstractC1975y.c.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        AbstractC1964m delegate = getDelegate();
        String string = getContext().getString(i);
        AbstractC1966o abstractC1966o = (AbstractC1966o) delegate;
        abstractC1966o.n = string;
        AbstractC1975y abstractC1975y = (AbstractC1975y) abstractC1966o;
        stepos.support.v7.widget.H h = abstractC1975y.f6362q;
        if (h != null) {
            h.setWindowTitle(string);
            return;
        }
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.s(string);
            return;
        }
        TextView textView = abstractC1975y.f6346A;
        if (textView != null) {
            textView.setText(string);
        }
    }
}
