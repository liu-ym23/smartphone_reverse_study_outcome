package stepos.support.v7.app;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class s extends Dialog implements k {
    private l mDelegate;

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o oVar = (o) getDelegate();
        oVar.q();
        ((ViewGroup) oVar.D.findViewById(R.id.content)).addView(view, layoutParams);
        oVar.f12389g.onContentChanged();
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        o oVar = (o) getDelegate();
        oVar.q();
        return oVar.f12388f.findViewById(i);
    }

    public l getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = l.b(getContext(), getWindow(), this);
        }
        return this.mDelegate;
    }

    public c getSupportActionBar() {
        o oVar = (o) getDelegate();
        oVar.s();
        return oVar.f12391j;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().e();
    }

    @Override // stepos.support.v7.app.k
    public boolean onBottomItemSelected(te.h hVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().getClass();
        super.onCreate(bundle);
        getDelegate().f(bundle);
    }

    @Override // stepos.support.v7.app.k
    public boolean onCreateBottomMenu(te.g gVar) {
        return false;
    }

    @Override // stepos.support.v7.app.k
    public boolean onMenuItemSelected(int i, te.h hVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        o oVar = (o) getDelegate();
        oVar.s();
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.n(false);
        }
    }

    @Override // stepos.support.v7.app.k
    public se.b onWindowStartingSupportActionMode(se.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        o oVar = (o) getDelegate();
        oVar.q();
        ViewGroup viewGroup = (ViewGroup) oVar.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        oVar.f12389g.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        l delegate = getDelegate();
        String string = getContext().getString(i);
        o oVar = (o) delegate;
        oVar.f12399r = string;
        stepos.support.v7.widget.b0 b0Var = oVar.f12402u;
        if (b0Var != null) {
            b0Var.setWindowTitle(string);
            return;
        }
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.q(string);
            return;
        }
        TextView textView = oVar.E;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().g(i);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        getDelegate().h(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o oVar = (o) getDelegate();
        oVar.q();
        ViewGroup viewGroup = (ViewGroup) oVar.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        oVar.f12389g.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        o oVar = (o) getDelegate();
        oVar.f12399r = charSequence;
        stepos.support.v7.widget.b0 b0Var = oVar.f12402u;
        if (b0Var != null) {
            b0Var.setWindowTitle(charSequence);
            return;
        }
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.q(charSequence);
            return;
        }
        TextView textView = oVar.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.k
    public void onOptionsMenuCreated(te.g gVar) {
    }

    @Override // stepos.support.v7.app.k
    public void onSupportActionModeFinished(se.b bVar) {
    }

    @Override // stepos.support.v7.app.k
    public void onSupportActionModeStarted(se.b bVar) {
    }

    @Override // stepos.support.v7.app.k
    public void onBackTopTouch() {
    }
}
