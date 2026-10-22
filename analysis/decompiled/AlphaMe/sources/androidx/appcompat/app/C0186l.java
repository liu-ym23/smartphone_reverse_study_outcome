package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.RenderNode;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* renamed from: androidx.appcompat.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0186l implements L.r, com.stepos.common.widget.x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2659a;

    /* renamed from: b, reason: collision with root package name */
    public int f2660b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2661c;

    public C0186l() {
        this.f2659a = 7;
    }

    public static C0186l d(String str) {
        C0186l c0186l = new C0186l();
        int iLastIndexOf = str.lastIndexOf(58);
        if (iLastIndexOf < 0) {
            c0186l.f2660b = 0;
            c0186l.f2661c = str;
            return c0186l;
        }
        try {
            c0186l.f2660b = Integer.parseInt(str.substring(iLastIndexOf + 1));
            c0186l.f2661c = str.substring(0, iLastIndexOf);
        } catch (NumberFormatException unused) {
            c0186l.f2660b = 0;
            c0186l.f2661c = str;
        }
        return c0186l;
    }

    @Override // L.r
    public final boolean a(View view) {
        ((BottomSheetBehavior) this.f2661c).m(this.f2660b);
        return true;
    }

    public final DialogInterfaceC0187m b() {
        ListAdapter c0184j;
        DialogInterfaceC0187m dialogInterfaceC0187m = new DialogInterfaceC0187m(((C0182h) this.f2661c).f2597a, this.f2660b);
        C0182h c0182h = (C0182h) this.f2661c;
        View view = c0182h.f2601e;
        int i4 = 0;
        C0185k c0185k = dialogInterfaceC0187m.f2664f;
        if (view != null) {
            c0185k.f2622C = view;
        } else {
            CharSequence charSequence = c0182h.f2600d;
            if (charSequence != null) {
                c0185k.f2637e = charSequence;
                TextView textView = c0185k.f2620A;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0182h.f2599c;
            if (drawable != null) {
                c0185k.f2657y = drawable;
                c0185k.f2656x = 0;
                ImageView imageView = c0185k.f2658z;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0185k.f2658z.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = c0182h.f2602f;
        if (charSequence2 != null) {
            c0185k.f2638f = charSequence2;
            TextView textView2 = c0185k.f2621B;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = c0182h.f2603g;
        if (charSequence3 != null) {
            c0185k.d(-1, charSequence3, c0182h.f2604h);
        }
        CharSequence charSequence4 = c0182h.f2605i;
        if (charSequence4 != null) {
            c0185k.d(-2, charSequence4, c0182h.f2606j);
        }
        if (c0182h.f2608l != null || c0182h.f2609m != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0182h.f2598b.inflate(c0185k.f2626G, (ViewGroup) null);
            if (c0182h.f2613q) {
                c0184j = new C0179e(c0182h, c0182h.f2597a, c0185k.f2627H, c0182h.f2608l, alertController$RecycleListView);
            } else {
                int i5 = c0182h.f2614r ? c0185k.f2628I : c0185k.f2629J;
                c0184j = c0182h.f2609m;
                if (c0184j == null) {
                    c0184j = new C0184j(c0182h.f2597a, i5, c0182h.f2608l, 0);
                }
            }
            c0185k.f2623D = c0184j;
            c0185k.f2624E = c0182h.f2615s;
            if (c0182h.f2610n != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0180f(i4, c0182h, c0185k));
            } else if (c0182h.f2616t != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0181g(c0182h, alertController$RecycleListView, c0185k));
            }
            if (c0182h.f2614r) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (c0182h.f2613q) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            c0185k.f2639g = alertController$RecycleListView;
        }
        View view2 = c0182h.f2611o;
        if (view2 != null) {
            c0185k.f2640h = view2;
            c0185k.f2641i = 0;
            c0185k.f2642j = false;
        }
        ((C0182h) this.f2661c).getClass();
        dialogInterfaceC0187m.setCancelable(true);
        ((C0182h) this.f2661c).getClass();
        dialogInterfaceC0187m.setCanceledOnTouchOutside(true);
        ((C0182h) this.f2661c).getClass();
        dialogInterfaceC0187m.setOnCancelListener(null);
        ((C0182h) this.f2661c).getClass();
        dialogInterfaceC0187m.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = ((C0182h) this.f2661c).f2607k;
        if (onKeyListener != null) {
            dialogInterfaceC0187m.setOnKeyListener(onKeyListener);
        }
        return dialogInterfaceC0187m;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x02fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r15) {
        /*
            Method dump skipped, instructions count: 998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.C0186l.c(int):void");
    }

    public /* synthetic */ C0186l(int i4, int i5, Object obj) {
        this.f2659a = i5;
        this.f2661c = obj;
        this.f2660b = i4;
    }

    public C0186l(String str) {
        this.f2659a = 6;
        this.f2660b = 0;
        RenderNode renderNode = new RenderNode(B0.g.m("RenderNode for ", str));
        this.f2661c = renderNode;
        renderNode.beginRecording().drawColor(0);
        ((RenderNode) this.f2661c).endRecording();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0186l(Context context) {
        this(context, DialogInterfaceC0187m.m(context, 0));
        this.f2659a = 0;
    }

    public C0186l(Context context, int i4) {
        this.f2659a = 0;
        this.f2661c = new C0182h(new ContextThemeWrapper(context, DialogInterfaceC0187m.m(context, i4)));
        this.f2660b = i4;
    }

    public C0186l(int i4, H.i[] iVarArr) {
        this.f2659a = 1;
        this.f2660b = i4;
        this.f2661c = iVarArr;
    }
}
