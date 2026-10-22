package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.C0180f;
import androidx.appcompat.app.C0184j;
import com.stepos.alphame.R;
import s.AbstractC0831a;

/* renamed from: stepos.support.v7.app.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0864i {

    /* renamed from: a, reason: collision with root package name */
    public final C0861f f14506a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14507b;

    public C0864i(Context context) {
        this(context, DialogInterfaceC0865j.resolveDialogTheme(context, 0));
    }

    public final DialogInterfaceC0865j a(InterfaceC0863h interfaceC0863h) throws Resources.NotFoundException {
        C0861f c0861f = this.f14506a;
        DialogInterfaceC0865j dialogInterfaceC0865jNewDialog = interfaceC0863h.newDialog(c0861f.f14449a, this.f14507b);
        AbstractC0862g abstractC0862g = dialogInterfaceC0865jNewDialog.mAlert;
        boolean z4 = abstractC0862g instanceof Z;
        Context context = c0861f.f14449a;
        LayoutInflater layoutInflater = c0861f.f14450b;
        if (z4) {
            X x4 = new X();
            x4.f14361a = c0861f;
            Z z5 = (Z) abstractC0862g;
            View view = c0861f.f14453e;
            if (view != null) {
                z5.f14383K = view;
            } else {
                CharSequence charSequence = c0861f.f14452d;
                if (charSequence != null) {
                    z5.f14409h = charSequence;
                    TextView textView = z5.f14380H;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = c0861f.f14451c;
                if (drawable != null) {
                    z5.d(drawable);
                }
            }
            CharSequence charSequence2 = c0861f.f14454f;
            if (charSequence2 != null) {
                z5.f14411i = charSequence2;
                TextView textView2 = z5.f14381I;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                    z5.f14381I.setVisibility(0);
                }
            }
            CharSequence charSequence3 = c0861f.f14455g;
            if (charSequence3 != null) {
                z5.b(-1, charSequence3, c0861f.f14456h, null, null);
            }
            CharSequence charSequence4 = c0861f.f14457i;
            if (charSequence4 != null) {
                z5.b(-2, charSequence4, c0861f.f14458j, null, null);
            }
            if (c0861f.f14463o != null || c0861f.f14464p != null) {
                StepOSAlertController$RecycleListView stepOSAlertController$RecycleListView = (StepOSAlertController$RecycleListView) layoutInflater.inflate(z5.f14388P, (ViewGroup) null);
                int i4 = c0861f.f14467s ? z5.f14389Q : z5.f14390R;
                ListAdapter c0184j = c0861f.f14464p;
                if (c0184j != null) {
                    i4 = 0;
                } else {
                    c0184j = new C0184j(context, i4, c0861f.f14463o, 2);
                }
                z5.f14384L = c0184j;
                z5.f14385M = c0861f.f14468t;
                if (c0861f.f14465q != null) {
                    stepOSAlertController$RecycleListView.setOnItemClickListener(new C0180f(3, x4, z5));
                }
                int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_listview_choice_padding);
                if (i4 > 0 && (i4 == R.layout.stepos_select_dialog_singlechoice || i4 == R.layout.stepos_select_dialog_multichoice)) {
                    stepOSAlertController$RecycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    stepOSAlertController$RecycleListView.setSelector(android.R.color.transparent);
                }
                if (c0861f.f14467s) {
                    stepOSAlertController$RecycleListView.setChoiceMode(1);
                    stepOSAlertController$RecycleListView.setDividerHeight((int) m2.o.c(stepOSAlertController$RecycleListView.getContext(), 4.0f));
                }
                z5.f14413j = stepOSAlertController$RecycleListView;
                if (c0861f.f14457i == null && c0861f.f14455g == null) {
                    z5.b(-2, context.getText(R.string.mc_cancel), new W(), null, null);
                }
            }
            View view2 = c0861f.f14466r;
            if (view2 != null) {
                z5.f14415k = view2;
                z5.f14417l = 0;
                z5.f14424q = false;
            }
            z5.f14402d0 = 0;
            z5.f14400c0 = (int) (0 * z5.f14418l0);
            int i5 = c0861f.f14469u;
            int i6 = c0861f.f14470v;
            z5.f14406f0 = i5;
            z5.f14408g0 = i6;
        } else {
            View view3 = c0861f.f14453e;
            if (view3 != null) {
                ((Z) abstractC0862g).f14383K = view3;
            } else {
                CharSequence charSequence5 = c0861f.f14452d;
                if (charSequence5 != null) {
                    Z z6 = (Z) abstractC0862g;
                    z6.f14409h = charSequence5;
                    TextView textView3 = z6.f14380H;
                    if (textView3 != null) {
                        textView3.setText(charSequence5);
                    }
                }
                Drawable drawable2 = c0861f.f14451c;
                if (drawable2 != null) {
                    abstractC0862g.d(drawable2);
                }
            }
            CharSequence charSequence6 = c0861f.f14454f;
            if (charSequence6 != null) {
                Z z7 = (Z) abstractC0862g;
                z7.f14411i = charSequence6;
                TextView textView4 = z7.f14381I;
                if (textView4 != null) {
                    textView4.setText(charSequence6);
                    z7.f14381I.setVisibility(0);
                }
            }
            CharSequence charSequence7 = c0861f.f14455g;
            if (charSequence7 != null) {
                abstractC0862g.b(-1, charSequence7, c0861f.f14456h, null, null);
            }
            CharSequence charSequence8 = c0861f.f14457i;
            if (charSequence8 != null) {
                abstractC0862g.b(-2, charSequence8, c0861f.f14458j, null, null);
            }
            if (c0861f.f14463o != null || c0861f.f14464p != null) {
                AbstractC0831a.g(layoutInflater.inflate(abstractC0862g.f14472a, (ViewGroup) null));
                int i7 = c0861f.f14467s ? abstractC0862g.f14473b : abstractC0862g.f14474c;
                if (c0861f.f14464p == null) {
                    new C0184j(context, i7, c0861f.f14463o, 1);
                }
                if (c0861f.f14465q != null || c0861f.f14467s) {
                    throw null;
                }
            }
            View view4 = c0861f.f14466r;
            if (view4 != null) {
                Z z8 = (Z) abstractC0862g;
                z8.f14415k = view4;
                z8.f14417l = 0;
                z8.f14424q = false;
            }
        }
        dialogInterfaceC0865jNewDialog.setCancelable(c0861f.f14459k);
        if (c0861f.f14459k) {
            dialogInterfaceC0865jNewDialog.setCanceledOnTouchOutside(true);
        }
        dialogInterfaceC0865jNewDialog.setOnCancelListener(c0861f.f14460l);
        dialogInterfaceC0865jNewDialog.setOnDismissListener(c0861f.f14461m);
        DialogInterface.OnKeyListener onKeyListener = c0861f.f14462n;
        if (onKeyListener != null) {
            dialogInterfaceC0865jNewDialog.setOnKeyListener(onKeyListener);
        }
        return dialogInterfaceC0865jNewDialog;
    }

    public C0864i(Context context, int i4) {
        this.f14506a = new C0861f(new ContextThemeWrapper(context, DialogInterfaceC0865j.resolveDialogTheme(context, i4)));
        this.f14507b = i4;
    }
}
