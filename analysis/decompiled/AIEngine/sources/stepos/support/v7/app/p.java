package stepos.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stepos.aiengine.R;
import fe.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class p extends Dialog implements g {
    private h mDelegate;

    public p(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i10) {
        if (i10 != 0) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ((ViewGroup) appCompatDelegateImplV7.z.findViewById(android.R.id.content)).addView(view, layoutParams);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    @Override // android.app.Dialog
    public View findViewById(int i10) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        return appCompatDelegateImplV7.f12126b.findViewById(i10);
    }

    public h getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new l(getContext(), getWindow(), this);
        }
        return this.mDelegate;
    }

    public a getSupportActionBar() {
        i iVar = (i) getDelegate();
        iVar.l();
        return iVar.f12130f;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().d();
    }

    @Override // stepos.support.v7.app.g
    public boolean onBottomItemSelected(ge.g gVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().getClass();
        super.onCreate(bundle);
        getDelegate().e(bundle);
    }

    @Override // stepos.support.v7.app.g
    public boolean onCreateBottomMenu(ge.f fVar) {
        return false;
    }

    @Override // stepos.support.v7.app.g
    public boolean onMenuItemSelected(int i10, ge.g gVar) {
        return false;
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.l();
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.n(false);
        }
    }

    @Override // stepos.support.v7.app.g
    public fe.b onWindowStartingSupportActionMode(b.InterfaceC0082b interfaceC0082b) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        getDelegate().h(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        i iVar = (i) getDelegate();
        iVar.f12137n = charSequence;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) iVar;
        stepos.support.v7.widget.j jVar = appCompatDelegateImplV7.f11990q;
        if (jVar != null) {
            jVar.setWindowTitle(charSequence);
            return;
        }
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.q(charSequence);
            return;
        }
        TextView textView = appCompatDelegateImplV7.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().g(i10);
    }

    public p(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        getDelegate().e(null);
        getDelegate().c();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ViewGroup viewGroup = (ViewGroup) appCompatDelegateImplV7.z.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    public p(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ViewGroup viewGroup = (ViewGroup) appCompatDelegateImplV7.z.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        h delegate = getDelegate();
        String string = getContext().getString(i10);
        i iVar = (i) delegate;
        iVar.f12137n = string;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) iVar;
        stepos.support.v7.widget.j jVar = appCompatDelegateImplV7.f11990q;
        if (jVar != null) {
            jVar.setWindowTitle(string);
            return;
        }
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.q(string);
            return;
        }
        TextView textView = appCompatDelegateImplV7.A;
        if (textView != null) {
            textView.setText(string);
        }
    }

    @Override // stepos.support.v7.app.g
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.g
    public void onOptionsMenuCreated(ge.f fVar) {
    }

    @Override // stepos.support.v7.app.g
    public void onSupportActionModeFinished(fe.b bVar) {
    }

    @Override // stepos.support.v7.app.g
    public void onSupportActionModeStarted(fe.b bVar) {
    }
}
