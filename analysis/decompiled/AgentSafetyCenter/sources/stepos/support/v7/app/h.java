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
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final d f12317a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12318b;

    public h(Context context, int i) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i.resolveDialogTheme(context, i));
        d dVar = new d();
        dVar.f12308q = 1;
        dVar.f12293a = contextThemeWrapper;
        dVar.f12301j = true;
        dVar.f12294b = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        VarHandle.storeStoreFence();
        this.f12317a = dVar;
        this.f12318b = i;
    }

    public final i a(g gVar) {
        boolean z10;
        boolean z11;
        n0 n0Var;
        d dVar = this.f12317a;
        i iVarNewDialog = gVar.newDialog(dVar.f12293a, this.f12318b);
        e eVar = iVarNewDialog.mAlert;
        LayoutInflater layoutInflater = dVar.f12294b;
        ContextThemeWrapper contextThemeWrapper = dVar.f12293a;
        int i = 1;
        if (eVar instanceof n0) {
            l0 l0Var = new l0();
            l0Var.f12341a = dVar;
            n0 n0Var2 = (n0) eVar;
            View view = dVar.f12297e;
            if (view != null) {
                n0Var2.I = view;
            } else {
                CharSequence charSequence = dVar.f12296d;
                if (charSequence != null) {
                    n0Var2.f12365g = charSequence;
                    TextView textView = n0Var2.F;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = dVar.f12295c;
                if (drawable != null) {
                    n0Var2.c(drawable);
                }
            }
            CharSequence charSequence2 = dVar.f12298f;
            if (charSequence2 == null) {
                n0Var = n0Var2;
            } else {
                n0Var = n0Var2;
                n0Var.a(-1, charSequence2, dVar.f12299g, null, null);
            }
            CharSequence charSequence3 = dVar.f12300h;
            if (charSequence3 != null) {
                n0Var.a(-2, charSequence3, dVar.i, null, null);
            }
            n0 n0Var3 = n0Var;
            if (dVar.f12304m != null) {
                StepOSAlertController$RecycleListView stepOSAlertController$RecycleListView = (StepOSAlertController$RecycleListView) layoutInflater.inflate(n0Var3.N, (ViewGroup) null);
                int i3 = n0Var3.O;
                BaseAdapter fVar = dVar.f12304m;
                if (fVar != null) {
                    i3 = 0;
                } else {
                    fVar = new h.f(contextThemeWrapper, i3, R.id.text1, null, 2);
                }
                n0Var3.J = fVar;
                n0Var3.K = -1;
                if (dVar.f12305n != null) {
                    h.c cVar = new h.c(i);
                    cVar.f4754g = l0Var;
                    cVar.f4753f = n0Var3;
                    VarHandle.storeStoreFence();
                    stepOSAlertController$RecycleListView.setOnItemClickListener(cVar);
                }
                int dimensionPixelOffset = contextThemeWrapper.getResources().getDimensionPixelOffset(com.stepos.agentsafetycenter.R.dimen.stepos_alert_dialog_listview_choice_padding);
                if (i3 > 0 && (i3 == com.stepos.agentsafetycenter.R.layout.stepos_select_dialog_singlechoice || i3 == com.stepos.agentsafetycenter.R.layout.stepos_select_dialog_multichoice)) {
                    stepOSAlertController$RecycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    stepOSAlertController$RecycleListView.setSelector(R.color.transparent);
                }
                n0Var3.i = stepOSAlertController$RecycleListView;
                if (dVar.f12300h == null && dVar.f12298f == null) {
                    n0Var3.a(-2, contextThemeWrapper.getText(com.stepos.agentsafetycenter.R.string.mc_cancel), new k0(), null, null);
                }
            }
            View view2 = dVar.f12306o;
            if (view2 != null) {
                n0Var3.f12370j = view2;
                n0Var3.f12375o = false;
            }
            n0Var3.Z = (int) (0 * n0Var3.f12368h0);
            int i10 = dVar.f12307p;
            int i11 = dVar.f12308q;
            n0Var3.f12358b0 = i10;
            n0Var3.f12360c0 = i11;
        } else {
            View view3 = dVar.f12297e;
            if (view3 != null) {
                ((n0) eVar).I = view3;
            } else {
                CharSequence charSequence4 = dVar.f12296d;
                if (charSequence4 != null) {
                    n0 n0Var4 = (n0) eVar;
                    n0Var4.f12365g = charSequence4;
                    TextView textView2 = n0Var4.F;
                    if (textView2 != null) {
                        textView2.setText(charSequence4);
                    }
                }
                Drawable drawable2 = dVar.f12295c;
                if (drawable2 != null) {
                    eVar.c(drawable2);
                }
            }
            CharSequence charSequence5 = dVar.f12298f;
            if (charSequence5 == null) {
                z10 = false;
            } else {
                z10 = false;
                eVar.a(-1, charSequence5, dVar.f12299g, null, null);
            }
            CharSequence charSequence6 = dVar.f12300h;
            if (charSequence6 != null) {
                eVar.a(-2, charSequence6, dVar.i, null, null);
            }
            if (dVar.f12304m == null) {
                z11 = z10;
            } else {
                if (layoutInflater.inflate(eVar.f12310a, (ViewGroup) null) != null) {
                    od.f.j();
                    return null;
                }
                int i12 = eVar.f12311b;
                if (dVar.f12304m != null) {
                    z11 = z10;
                } else {
                    z11 = z10;
                    new h.f(contextThemeWrapper, i12, R.id.text1, null, 1);
                }
                if (dVar.f12305n != null) {
                    throw null;
                }
            }
            View view4 = dVar.f12306o;
            if (view4 != null) {
                n0 n0Var5 = (n0) eVar;
                n0Var5.f12370j = view4;
                n0Var5.f12375o = z11;
            }
        }
        iVarNewDialog.setCancelable(dVar.f12301j);
        if (dVar.f12301j) {
            iVarNewDialog.setCanceledOnTouchOutside(true);
        }
        iVarNewDialog.setOnCancelListener(dVar.f12302k);
        iVarNewDialog.setOnDismissListener(null);
        l.m mVar = dVar.f12303l;
        if (mVar != null) {
            iVarNewDialog.setOnKeyListener(mVar);
        }
        return iVarNewDialog;
    }
}
