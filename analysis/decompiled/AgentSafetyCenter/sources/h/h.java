package h;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.stepos.agentsafetycenter.R;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends androidx.activity.q implements DialogInterface, l {

    /* renamed from: h, reason: collision with root package name */
    public e0 f4834h;
    public f0 i;

    /* renamed from: j, reason: collision with root package name */
    public g f4835j;

    public static int f(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        c();
        e0 e0Var = (e0) d();
        e0Var.u();
        ((ViewGroup) e0Var.C.findViewById(android.R.id.content)).addView(view, layoutParams);
        e0Var.f4796n.a(e0Var.f4795m.getCallback());
    }

    public final q d() {
        if (this.f4834h == null) {
            androidx.room.b0 b0Var = q.f4885c;
            this.f4834h = new e0(getContext(), getWindow(), this, this);
        }
        return this.f4834h;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        d().d();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        f0 f0Var = this.i;
        if (f0Var == null) {
            return false;
        }
        return f0Var.f4810c.h(keyEvent);
    }

    public final void e(Bundle bundle) {
        d().a();
        super.onCreate(bundle);
        d().c();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e0 e0Var = (e0) d();
        e0Var.u();
        return e0Var.f4795m.findViewById(i);
    }

    public final void g(CharSequence charSequence) {
        super.setTitle(charSequence);
        d().l(charSequence);
    }

    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e0 e0Var = (e0) d();
        if (e0Var.f4798p != null) {
            e0Var.y();
            e0Var.f4798p.getClass();
            e0Var.z(0);
        }
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        e(bundle);
        g gVar = this.f4835j;
        gVar.f4812b.setContentView(gVar.f4826q);
        Context context = gVar.f4811a;
        Window window = gVar.f4813c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        window.setFlags(131072, 131072);
        viewGroup.setVisibility(8);
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupA = g.a(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupA2 = g.a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupA3 = g.a(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        gVar.i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        gVar.i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupA2.findViewById(android.R.id.message);
        gVar.f4822m = textView;
        if (textView != null) {
            textView.setVisibility(8);
            gVar.i.removeView(gVar.f4822m);
            if (gVar.f4815e != null) {
                ViewGroup viewGroup2 = (ViewGroup) gVar.i.getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(gVar.i);
                viewGroup2.removeViewAt(iIndexOfChild);
                viewGroup2.addView(gVar.f4815e, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroupA2.setVisibility(8);
            }
        }
        Button button = (Button) viewGroupA3.findViewById(android.R.id.button1);
        gVar.f4816f = button;
        b bVar = gVar.f4829t;
        button.setOnClickListener(bVar);
        boolean zIsEmpty = TextUtils.isEmpty(null);
        Button button2 = gVar.f4816f;
        if (zIsEmpty) {
            button2.setVisibility(8);
            i = 0;
        } else {
            button2.setText((CharSequence) null);
            gVar.f4816f.setVisibility(0);
            i = 1;
        }
        Button button3 = (Button) viewGroupA3.findViewById(android.R.id.button2);
        gVar.f4817g = button3;
        button3.setOnClickListener(bVar);
        boolean zIsEmpty2 = TextUtils.isEmpty(null);
        Button button4 = gVar.f4817g;
        if (zIsEmpty2) {
            button4.setVisibility(8);
        } else {
            button4.setText((CharSequence) null);
            gVar.f4817g.setVisibility(0);
            i |= 2;
        }
        Button button5 = (Button) viewGroupA3.findViewById(android.R.id.button3);
        gVar.f4818h = button5;
        button5.setOnClickListener(bVar);
        boolean zIsEmpty3 = TextUtils.isEmpty(null);
        Button button6 = gVar.f4818h;
        if (zIsEmpty3) {
            button6.setVisibility(8);
        } else {
            button6.setText((CharSequence) null);
            gVar.f4818h.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button7 = gVar.f4816f;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button7.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button7.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button8 = gVar.f4817g;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button8.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button8.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button9 = gVar.f4818h;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button9.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button9.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupA3.setVisibility(8);
        }
        if (gVar.f4823n != null) {
            viewGroupA.addView(gVar.f4823n, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            gVar.f4820k = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(gVar.f4814d) || !gVar.f4827r) {
                window.findViewById(R.id.title_template).setVisibility(8);
                gVar.f4820k.setVisibility(8);
                viewGroupA.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                gVar.f4821l = textView2;
                textView2.setText(gVar.f4814d);
                Drawable drawable = gVar.f4819j;
                if (drawable != null) {
                    gVar.f4820k.setImageDrawable(drawable);
                } else {
                    gVar.f4821l.setPadding(gVar.f4820k.getPaddingLeft(), gVar.f4820k.getPaddingTop(), gVar.f4820k.getPaddingRight(), gVar.f4820k.getPaddingBottom());
                    gVar.f4820k.setVisibility(8);
                }
            }
        }
        boolean z10 = viewGroup.getVisibility() != 8;
        int i3 = (viewGroupA == null || viewGroupA.getVisibility() == 8) ? 0 : 1;
        boolean z11 = viewGroupA3.getVisibility() != 8;
        if (!z11 && (viewFindViewById = viewGroupA2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i3 != 0) {
            NestedScrollView nestedScrollView2 = gVar.i;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = gVar.f4815e != null ? viewGroupA.findViewById(R.id.titleDividerNoCustom) : null;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupA2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = gVar.f4815e;
        if (alertController$RecycleListView != null && (!z11 || i3 == 0)) {
            alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i3 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f713c, alertController$RecycleListView.getPaddingRight(), z11 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f714f);
        }
        if (!z10) {
            View view = gVar.f4815e;
            if (view == null) {
                view = gVar.i;
            }
            if (view != null) {
                int i10 = z11 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = n3.k0.f8724a;
                view.setScrollIndicators(i3 | i10, 3);
                if (viewFindViewById11 != null) {
                    viewGroupA2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupA2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = gVar.f4815e;
        if (alertController$RecycleListView2 == null || (listAdapter = gVar.f4824o) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i11 = gVar.f4825p;
        if (i11 > -1) {
            alertController$RecycleListView2.setItemChecked(i11, true);
            alertController$RecycleListView2.setSelection(i11);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4835j.i;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4835j.i;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onStop();
        e0 e0Var = (e0) d();
        e0Var.y();
        o0 o0Var = e0Var.f4798p;
        if (o0Var != null) {
            o0Var.f4880t = false;
            k.k kVar = o0Var.f4879s;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void setContentView(int i) {
        c();
        d().h(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        d().l(getContext().getString(i));
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void setContentView(View view) {
        c();
        d().i(view);
    }

    @Override // androidx.activity.q, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        c();
        d().k(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        g(charSequence);
        g gVar = this.f4835j;
        gVar.f4814d = charSequence;
        TextView textView = gVar.f4821l;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
