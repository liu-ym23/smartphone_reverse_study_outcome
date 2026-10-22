package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/* renamed from: stepos.support.v7.app.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1960i {

    /* renamed from: a, reason: collision with root package name */
    public final C1956e f6314a;
    public final int b;

    public C1960i(Context context, int i) {
        this.f6314a = new C1956e(new ContextThemeWrapper(context, DialogInterfaceC1961j.resolveDialogTheme(context, i)));
        this.b = i;
    }

    public final DialogInterfaceC1961j a(InterfaceC1959h interfaceC1959h) {
        Z z10;
        C1956e c1956e = this.f6314a;
        DialogInterfaceC1961j dialogInterfaceC1961jNewDialog = interfaceC1959h.newDialog(c1956e.f6295a, this.b);
        AbstractC1958g abstractC1958g = dialogInterfaceC1961jNewDialog.mAlert;
        LayoutInflater layoutInflater = c1956e.b;
        ContextThemeWrapper contextThemeWrapper = c1956e.f6295a;
        if (abstractC1958g instanceof Z) {
            X x10 = new X();
            x10.f6240a = c1956e;
            Z z11 = (Z) abstractC1958g;
            View view = c1956e.e;
            if (view != null) {
                z11.f6255I = view;
            } else {
                CharSequence charSequence = c1956e.d;
                if (charSequence != null) {
                    z11.g = charSequence;
                    TextView textView = z11.f6252F;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = c1956e.c;
                if (drawable != null) {
                    z11.c(drawable);
                }
            }
            CharSequence charSequence2 = c1956e.f;
            if (charSequence2 == null) {
                z10 = z11;
            } else {
                z10 = z11;
                z10.a(-1, charSequence2, c1956e.g, null, null);
            }
            CharSequence charSequence3 = c1956e.h;
            if (charSequence3 != null) {
                z10.a(-2, charSequence3, c1956e.i, null, null);
            }
            Z z12 = z10;
            if (c1956e.m != null) {
                StepOSAlertController$RecycleListView stepOSAlertController$RecycleListView = (StepOSAlertController$RecycleListView) layoutInflater.inflate(z12.f6260N, (ViewGroup) null);
                int i = z12.f6261O;
                BaseAdapter c1957f = c1956e.m;
                if (c1957f != null) {
                    i = 0;
                } else {
                    c1957f = new C1957f(contextThemeWrapper, i, R.id.text1, null, 1);
                }
                z12.f6256J = c1957f;
                z12.f6257K = -1;
                if (c1956e.n != null) {
                    stepOSAlertController$RecycleListView.setOnItemClickListener(new V(x10, z12));
                }
                int dimensionPixelOffset = contextThemeWrapper.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_listview_choice_padding);
                if (i > 0 && (i == com.stepos.ability.R.layout.stepos_select_dialog_singlechoice || i == com.stepos.ability.R.layout.stepos_select_dialog_multichoice)) {
                    stepOSAlertController$RecycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    stepOSAlertController$RecycleListView.setSelector(R.color.transparent);
                }
                z12.i = stepOSAlertController$RecycleListView;
                if (c1956e.h == null && c1956e.f == null) {
                    z12.a(-2, contextThemeWrapper.getText(com.stepos.ability.R.string.mc_cancel), new W(), null, null);
                }
            }
            View view2 = c1956e.o;
            if (view2 != null) {
                z12.f6281j = view2;
                z12.o = false;
            }
            z12.getClass();
            z12.f6272Z = (int) (0 * z12.f6279h0);
            int i6 = c1956e.p;
            int i10 = c1956e.f6297q;
            z12.b0 = i6;
            z12.f6274c0 = i10;
        } else {
            View view3 = c1956e.e;
            if (view3 != null) {
                ((Z) abstractC1958g).f6255I = view3;
            } else {
                CharSequence charSequence4 = c1956e.d;
                if (charSequence4 != null) {
                    Z z13 = (Z) abstractC1958g;
                    z13.g = charSequence4;
                    TextView textView2 = z13.f6252F;
                    if (textView2 != null) {
                        textView2.setText(charSequence4);
                    }
                }
                Drawable drawable2 = c1956e.c;
                if (drawable2 != null) {
                    abstractC1958g.c(drawable2);
                }
            }
            CharSequence charSequence5 = c1956e.f;
            if (charSequence5 != null) {
                abstractC1958g.a(-1, charSequence5, c1956e.g, null, null);
            }
            CharSequence charSequence6 = c1956e.h;
            if (charSequence6 != null) {
                abstractC1958g.a(-2, charSequence6, c1956e.i, null, null);
            }
            if (c1956e.m != null) {
                if (layoutInflater.inflate(abstractC1958g.f6313a, (ViewGroup) null) != null) {
                    throw new ClassCastException();
                }
                int i11 = abstractC1958g.b;
                if (c1956e.m == null) {
                    new C1957f(contextThemeWrapper, i11, R.id.text1, null, 0);
                }
                if (c1956e.n != null) {
                    throw null;
                }
            }
            View view4 = c1956e.o;
            if (view4 != null) {
                Z z14 = (Z) abstractC1958g;
                z14.f6281j = view4;
                z14.o = false;
            }
        }
        dialogInterfaceC1961jNewDialog.setCancelable(c1956e.f6296j);
        if (c1956e.f6296j) {
            dialogInterfaceC1961jNewDialog.setCanceledOnTouchOutside(true);
        }
        dialogInterfaceC1961jNewDialog.setOnCancelListener(c1956e.k);
        dialogInterfaceC1961jNewDialog.setOnDismissListener(null);
        Va.o oVar = c1956e.l;
        if (oVar != null) {
            dialogInterfaceC1961jNewDialog.setOnKeyListener(oVar);
        }
        return dialogInterfaceC1961jNewDialog;
    }
}
