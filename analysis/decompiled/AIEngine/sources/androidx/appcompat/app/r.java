package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.k;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class r extends b.n implements j {

    /* renamed from: d, reason: collision with root package name */
    public AppCompatDelegateImpl f350d;

    /* renamed from: e, reason: collision with root package name */
    public final q f351e;

    public r(Context context, int i10) {
        int i11;
        if (i10 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i11 = typedValue.resourceId;
        } else {
            i11 = i10;
        }
        super(context, i11);
        this.f351e = new q(this);
        k kVarC = c();
        if (i10 == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            i10 = typedValue2.resourceId;
        }
        ((AppCompatDelegateImpl) kVarC).X = i10;
        kVarC.j();
    }

    @Override // b.n, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        c().c(view, layoutParams);
    }

    public final k c() {
        if (this.f350d == null) {
            k.c cVar = k.f328a;
            this.f350d = new AppCompatDelegateImpl(getContext(), getWindow(), this, this);
        }
        return this.f350d;
    }

    public final boolean d(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        c().k();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        q qVar = this.f351e;
        if (qVar == null) {
            return false;
        }
        return qVar.f349a.d(keyEvent);
    }

    @Override // android.app.Dialog
    public final <T extends View> T findViewById(int i10) {
        return (T) c().d(i10);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        c().h();
    }

    @Override // b.n, android.app.Dialog
    public void onCreate(Bundle bundle) {
        c().g();
        super.onCreate(bundle);
        c().j();
    }

    @Override // b.n, android.app.Dialog
    public final void onStop() {
        super.onStop();
        c().l();
    }

    @Override // b.n, android.app.Dialog
    public void setContentView(int i10) {
        b();
        c().o(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        c().r(charSequence);
    }

    @Override // b.n, android.app.Dialog
    public void setContentView(View view) {
        b();
        c().p(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i10) {
        super.setTitle(i10);
        c().r(getContext().getString(i10));
    }

    @Override // b.n, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b();
        c().q(view, layoutParams);
    }
}
