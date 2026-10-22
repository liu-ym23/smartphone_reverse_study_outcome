package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import com.ttnet.org.chromium.net.PrivateKeyType;

/* JADX INFO: loaded from: classes.dex */
public class a extends e implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AlertController f371a;

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0006a {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public C0006a(Context r10) {
            this(r10, a.e(r10, 0));
        }

        public a create() {
            a r10 = new a(this.P.f240a, this.mTheme);
            this.P.a(r10.f371a);
            r10.setCancelable(this.P.f257r);
            if (this.P.f257r == false) goto L5;
            r10.setCanceledOnTouchOutside(true);
        L5:
            r10.setOnCancelListener(this.P.f258s);
            r10.setOnDismissListener(this.P.f259t);
            DialogInterface.OnKeyListener r11 = this.P.f260u;
            if (r11 == null) goto L8;
            r10.setOnKeyListener(r11);
        L8:
            return r10;
        }

        @NonNull
        public Context getContext() {
            return this.P.f240a;
        }

        public C0006a setAdapter(ListAdapter r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f262w = r10;
            r12.f263x = r11;
            return this;
        }

        public C0006a setCancelable(boolean r10) {
            this.P.f257r = r10;
            return this;
        }

        public C0006a setCursor(Cursor r10, DialogInterface.OnClickListener r11, String r12) {
            AlertController.AlertParams r13 = this.P;
            r13.K = r10;
            r13.L = r12;
            r13.f263x = r11;
            return this;
        }

        public C0006a setCustomTitle(View r10) {
            this.P.f246g = r10;
            return this;
        }

        public C0006a setIcon(int r10) {
            this.P.f242c = r10;
            return this;
        }

        public C0006a setIconAttribute(int r10) {
            TypedValue r11 = new TypedValue();
            this.P.f240a.getTheme().resolveAttribute(r10, r11, true);
            AlertController.AlertParams r12 = this.P;
            r12.f242c = r11.resourceId;
            return this;
        }

        @Deprecated
        public C0006a setInverseBackgroundForced(boolean r10) {
            this.P.N = r10;
            return this;
        }

        public C0006a setItems(int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f261v = r12.f240a.getResources().getTextArray(r10);
            this.P.f263x = r11;
            return this;
        }

        public C0006a setMessage(int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.f247h = r11.f240a.getText(r10);
            return this;
        }

        public C0006a setMultiChoiceItems(int r10, boolean[] r11, DialogInterface.OnMultiChoiceClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.f261v = r13.f240a.getResources().getTextArray(r10);
            AlertController.AlertParams r14 = this.P;
            r14.f239J = r12;
            r14.F = r11;
            r14.G = true;
            return this;
        }

        public C0006a setNegativeButton(int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f251l = r12.f240a.getText(r10);
            this.P.f253n = r11;
            return this;
        }

        public C0006a setNegativeButtonIcon(Drawable r10) {
            this.P.f252m = r10;
            return this;
        }

        public C0006a setNeutralButton(int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f254o = r12.f240a.getText(r10);
            this.P.f256q = r11;
            return this;
        }

        public C0006a setNeutralButtonIcon(Drawable r10) {
            this.P.f255p = r10;
            return this;
        }

        public C0006a setOnCancelListener(DialogInterface.OnCancelListener r10) {
            this.P.f258s = r10;
            return this;
        }

        public C0006a setOnDismissListener(DialogInterface.OnDismissListener r10) {
            this.P.f259t = r10;
            return this;
        }

        public C0006a setOnItemSelectedListener(AdapterView.OnItemSelectedListener r10) {
            this.P.O = r10;
            return this;
        }

        public C0006a setOnKeyListener(DialogInterface.OnKeyListener r10) {
            this.P.f260u = r10;
            return this;
        }

        public C0006a setPositiveButton(int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f248i = r12.f240a.getText(r10);
            this.P.f250k = r11;
            return this;
        }

        public C0006a setPositiveButtonIcon(Drawable r10) {
            this.P.f249j = r10;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public C0006a setRecycleOnMeasureEnabled(boolean r10) {
            this.P.Q = r10;
            return this;
        }

        public C0006a setSingleChoiceItems(int r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.f261v = r13.f240a.getResources().getTextArray(r10);
            AlertController.AlertParams r14 = this.P;
            r14.f263x = r12;
            r14.I = r11;
            r14.H = true;
            return this;
        }

        public C0006a setTitle(int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.f245f = r11.f240a.getText(r10);
            return this;
        }

        public C0006a setView(int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.f265z = null;
            r11.f264y = r10;
            r11.E = false;
            return this;
        }

        public a show() {
            a r10 = create();
            r10.show();
            return r10;
        }

        public C0006a(Context r10, int r11) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(r10, a.e(r10, r11)));
            this.mTheme = r11;
        }

        public C0006a setIcon(Drawable r10) {
            this.P.f243d = r10;
            return this;
        }

        public C0006a setMessage(CharSequence r10) {
            this.P.f247h = r10;
            return this;
        }

        public C0006a setTitle(CharSequence r10) {
            this.P.f245f = r10;
            return this;
        }

        public C0006a setItems(CharSequence[] r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f261v = r10;
            r12.f263x = r11;
            return this;
        }

        public C0006a setNegativeButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f251l = r10;
            r12.f253n = r11;
            return this;
        }

        public C0006a setNeutralButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f254o = r10;
            r12.f256q = r11;
            return this;
        }

        public C0006a setPositiveButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.f248i = r10;
            r12.f250k = r11;
            return this;
        }

        public C0006a setView(View r10) {
            AlertController.AlertParams r11 = this.P;
            r11.f265z = r10;
            r11.f264y = 0;
            r11.E = false;
            return this;
        }

        public C0006a setMultiChoiceItems(CharSequence[] r10, boolean[] r11, DialogInterface.OnMultiChoiceClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.f261v = r10;
            r13.f239J = r12;
            r13.F = r11;
            r13.G = true;
            return this;
        }

        public C0006a setSingleChoiceItems(Cursor r10, int r11, String r12, DialogInterface.OnClickListener r13) {
            AlertController.AlertParams r14 = this.P;
            r14.K = r10;
            r14.f263x = r13;
            r14.I = r11;
            r14.L = r12;
            r14.H = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public C0006a setView(View r10, int r11, int r12, int r13, int r14) {
            AlertController.AlertParams r15 = this.P;
            r15.f265z = r10;
            r15.f264y = 0;
            r15.E = true;
            r15.A = r11;
            r15.B = r12;
            r15.C = r13;
            r15.D = r14;
            return this;
        }

        public C0006a setMultiChoiceItems(Cursor r10, String r11, String r12, DialogInterface.OnMultiChoiceClickListener r13) {
            AlertController.AlertParams r14 = this.P;
            r14.K = r10;
            r14.f239J = r13;
            r14.M = r11;
            r14.L = r12;
            r14.G = true;
            return this;
        }

        public C0006a setSingleChoiceItems(CharSequence[] r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.f261v = r10;
            r13.f263x = r12;
            r13.I = r11;
            r13.H = true;
            return this;
        }

        public C0006a setSingleChoiceItems(ListAdapter r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.f262w = r10;
            r13.f263x = r12;
            r13.I = r11;
            r13.H = true;
            return this;
        }
    }

    public a(Context r10, int r11) {
        super(r10, e(r10, r11));
        this.f371a = new AlertController(getContext(), this, getWindow());
    }

    public static int e(Context r10, int r11) {
        if (((r11 >>> 24) & PrivateKeyType.INVALID) < 1) goto L5;
        return r11;
    L5:
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(R$attr.alertDialogTheme, r12, true);
        return r12.resourceId;
    }

    public ListView d() {
        return this.f371a.d();
    }

    @Override // androidx.appcompat.app.e, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.f371a.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (this.f371a.f(r10, r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, KeyEvent r11) {
        if (this.f371a.g(r10, r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r10, r11);
    }

    @Override // androidx.appcompat.app.e, android.app.Dialog
    public void setTitle(CharSequence r10) {
        super.setTitle(r10);
        this.f371a.p(r10);
    }
}
