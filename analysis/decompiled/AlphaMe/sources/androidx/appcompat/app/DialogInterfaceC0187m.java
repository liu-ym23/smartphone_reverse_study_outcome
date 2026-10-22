package androidx.appcompat.app;

import K.S;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.C0237y0;
import androidx.appcompat.widget.InterfaceC0214m0;
import androidx.core.widget.NestedScrollView;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.appcompat.app.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceC0187m extends androidx.activity.p implements DialogInterface, InterfaceC0188n {

    /* renamed from: d, reason: collision with root package name */
    public F f2662d;

    /* renamed from: e, reason: collision with root package name */
    public final G f2663e;

    /* renamed from: f, reason: collision with root package name */
    public final C0185k f2664f;

    public DialogInterfaceC0187m(Context context, int i4) {
        int i5;
        int iM = m(context, i4);
        if (iM == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i5 = typedValue.resourceId;
        } else {
            i5 = iM;
        }
        super(context, i5);
        this.f2663e = new G(this);
        F fH = h();
        if (iM == 0) {
            TypedValue typedValue2 = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iM = typedValue2.resourceId;
        }
        fH.f2498M = iM;
        fH.s(null);
        this.f2664f = new C0185k(getContext(), this, getWindow());
    }

    public static int m(Context context, int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        F fH = h();
        fH.j();
        ((ViewGroup) fH.f2527t.findViewById(android.R.id.content)).addView(view, layoutParams);
        fH.f2514g.a(fH.f2513f.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // android.app.Dialog, android.content.DialogInterface
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dismiss() {
        /*
            r3 = this;
            super.dismiss()
            androidx.appcompat.app.F r3 = r3.h()
            java.lang.Object r0 = r3.f2511d
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L18
            java.lang.Object r0 = androidx.appcompat.app.q.f2675c
            monitor-enter(r0)
            androidx.appcompat.app.q.a(r3)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            goto L18
        L15:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        L18:
            boolean r0 = r3.f2503R
            if (r0 == 0) goto L27
            android.view.Window r0 = r3.f2513f
            android.view.View r0 = r0.getDecorView()
            androidx.appcompat.app.r r1 = r3.T
            r0.removeCallbacks(r1)
        L27:
            r0 = 1
            r3.f2495J = r0
            int r0 = r3.f2497L
            r1 = -100
            if (r0 == r1) goto L54
            java.lang.Object r0 = r3.f2511d
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L54
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L54
            q.l r0 = androidx.appcompat.app.F.f2483k0
            java.lang.Object r1 = r3.f2511d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f2497L
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L63
        L54:
            q.l r0 = androidx.appcompat.app.F.f2483k0
            java.lang.Object r1 = r3.f2511d
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L63:
            androidx.appcompat.app.z r0 = r3.f2501P
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            androidx.appcompat.app.z r3 = r3.f2502Q
            if (r3 == 0) goto L71
            r3.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.DialogInterfaceC0187m.dismiss():void");
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        G g4 = this.f2663e;
        if (g4 == null) {
            return false;
        }
        return g4.superDispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final View findViewById(int i4) {
        F fH = h();
        fH.j();
        return fH.f2513f.findViewById(i4);
    }

    public final F h() {
        if (this.f2662d == null) {
            int i4 = q.f2673a;
            this.f2662d = new F(this, this);
        }
        return this.f2662d;
    }

    public final void i() {
        B0.f.r0(getWindow().getDecorView(), this);
        com.airbnb.lottie.h.E(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView, "<this>");
        Intrinsics.checkNotNullParameter(this, "onBackPressedDispatcherOwner");
        decorView.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // android.app.Dialog
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void invalidateOptionsMenu() {
        F fH = h();
        if (fH.f2515h != null) {
            fH.p().getClass();
            fH.q(0);
        }
    }

    public final void k(Bundle bundle) {
        F fH = h();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(fH.f2512e);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(fH);
        } else if (!(layoutInflaterFrom.getFactory2() instanceof F)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
        super.onCreate(bundle);
        h().s(bundle);
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void onStop() {
        super.onStop();
        N nP = h().p();
        if (nP != null) {
            nP.f2578u = false;
            j.m mVar = nP.f2577t;
            if (mVar != null) {
                mVar.a();
            }
        }
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void setContentView(int i4) {
        i();
        F fH = h();
        fH.j();
        ViewGroup viewGroup = (ViewGroup) fH.f2527t.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(fH.f2512e).inflate(i4, viewGroup);
        fH.f2514g.a(fH.f2513f.getCallback());
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void setContentView(View view) {
        i();
        F fH = h();
        fH.j();
        ViewGroup viewGroup = (ViewGroup) fH.f2527t.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        fH.f2514g.a(fH.f2513f.getCallback());
    }

    @Override // androidx.activity.p, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i4;
        View view;
        ListAdapter listAdapter;
        View viewFindViewById;
        k(bundle);
        C0185k c0185k = this.f2664f;
        c0185k.f2634b.setContentView(c0185k.f2625F);
        Window window = c0185k.f2635c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View viewInflate = c0185k.f2640h;
        Context context = c0185k.f2633a;
        if (viewInflate == null) {
            viewInflate = c0185k.f2641i != 0 ? LayoutInflater.from(context).inflate(c0185k.f2641i, viewGroup, false) : null;
        }
        boolean z4 = viewInflate != null;
        if (!z4 || !C0185k.a(viewInflate)) {
            window.setFlags(131072, 131072);
        }
        if (z4) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (c0185k.f2642j) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (c0185k.f2639g != null) {
                ((LinearLayout.LayoutParams) ((C0237y0) viewGroup.getLayoutParams())).weight = Property.DEFAULT_FLOAT_VALUE;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupC = C0185k.c(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupC2 = C0185k.c(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupC3 = C0185k.c(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0185k.f2655w = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0185k.f2655w.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupC2.findViewById(android.R.id.message);
        c0185k.f2621B = textView;
        if (textView != null) {
            CharSequence charSequence = c0185k.f2638f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                c0185k.f2655w.removeView(c0185k.f2621B);
                if (c0185k.f2639g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) c0185k.f2655w.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(c0185k.f2655w);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(c0185k.f2639g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupC2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupC3.findViewById(android.R.id.button1);
        c0185k.f2643k = button;
        ViewOnClickListenerC0177c viewOnClickListenerC0177c = c0185k.f2632M;
        button.setOnClickListener(viewOnClickListenerC0177c);
        boolean zIsEmpty = TextUtils.isEmpty(c0185k.f2644l);
        int i5 = c0185k.f2636d;
        if (zIsEmpty && c0185k.f2646n == null) {
            c0185k.f2643k.setVisibility(8);
            i4 = 0;
        } else {
            c0185k.f2643k.setText(c0185k.f2644l);
            Drawable drawable = c0185k.f2646n;
            if (drawable != null) {
                drawable.setBounds(0, 0, i5, i5);
                c0185k.f2643k.setCompoundDrawables(c0185k.f2646n, null, null, null);
            }
            c0185k.f2643k.setVisibility(0);
            i4 = 1;
        }
        Button button2 = (Button) viewGroupC3.findViewById(android.R.id.button2);
        c0185k.f2647o = button2;
        button2.setOnClickListener(viewOnClickListenerC0177c);
        if (TextUtils.isEmpty(c0185k.f2648p) && c0185k.f2650r == null) {
            c0185k.f2647o.setVisibility(8);
        } else {
            c0185k.f2647o.setText(c0185k.f2648p);
            Drawable drawable2 = c0185k.f2650r;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i5, i5);
                c0185k.f2647o.setCompoundDrawables(c0185k.f2650r, null, null, null);
            }
            c0185k.f2647o.setVisibility(0);
            i4 |= 2;
        }
        Button button3 = (Button) viewGroupC3.findViewById(android.R.id.button3);
        c0185k.f2651s = button3;
        button3.setOnClickListener(viewOnClickListenerC0177c);
        if (TextUtils.isEmpty(c0185k.f2652t) && c0185k.f2654v == null) {
            c0185k.f2651s.setVisibility(8);
            view = null;
        } else {
            c0185k.f2651s.setText(c0185k.f2652t);
            Drawable drawable3 = c0185k.f2654v;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, i5, i5);
                view = null;
                c0185k.f2651s.setCompoundDrawables(c0185k.f2654v, null, null, null);
            } else {
                view = null;
            }
            c0185k.f2651s.setVisibility(0);
            i4 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i4 == 1) {
                Button button4 = c0185k.f2643k;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i4 == 2) {
                Button button5 = c0185k.f2647o;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i4 == 4) {
                Button button6 = c0185k.f2651s;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i4 == 0) {
            viewGroupC3.setVisibility(8);
        }
        if (c0185k.f2622C != null) {
            viewGroupC.addView(c0185k.f2622C, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0185k.f2658z = (ImageView) window.findViewById(android.R.id.icon);
            if ((!TextUtils.isEmpty(c0185k.f2637e)) && c0185k.f2630K) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0185k.f2620A = textView2;
                textView2.setText(c0185k.f2637e);
                int i6 = c0185k.f2656x;
                if (i6 != 0) {
                    c0185k.f2658z.setImageResource(i6);
                } else {
                    Drawable drawable4 = c0185k.f2657y;
                    if (drawable4 != null) {
                        c0185k.f2658z.setImageDrawable(drawable4);
                    } else {
                        c0185k.f2620A.setPadding(c0185k.f2658z.getPaddingLeft(), c0185k.f2658z.getPaddingTop(), c0185k.f2658z.getPaddingRight(), c0185k.f2658z.getPaddingBottom());
                        c0185k.f2658z.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0185k.f2658z.setVisibility(8);
                viewGroupC.setVisibility(8);
            }
        }
        boolean z5 = viewGroup.getVisibility() != 8;
        int i7 = (viewGroupC == null || viewGroupC.getVisibility() == 8) ? 0 : 1;
        boolean z6 = viewGroupC3.getVisibility() != 8;
        if (!z6 && (viewFindViewById = viewGroupC2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i7 != 0) {
            NestedScrollView nestedScrollView2 = c0185k.f2655w;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (c0185k.f2638f == null && c0185k.f2639g == null) ? view : viewGroupC.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupC2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0185k.f2639g;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.getClass();
            if (!z6 || i7 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i7 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f2458a, alertController$RecycleListView.getPaddingRight(), z6 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f2459b);
            }
        }
        if (!z5) {
            View view2 = c0185k.f2639g;
            if (view2 == null) {
                view2 = c0185k.f2655w;
            }
            if (view2 != null) {
                int i8 = z6 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = S.f939a;
                K.K.d(view2, i7 | i8, 3);
                if (viewFindViewById11 != null) {
                    viewGroupC2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupC2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c0185k.f2639g;
        if (alertController$RecycleListView2 == null || (listAdapter = c0185k.f2623D) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i9 = c0185k.f2624E;
        if (i9 > -1) {
            alertController$RecycleListView2.setItemChecked(i9, true);
            alertController$RecycleListView2.setSelection(i9);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2664f.f2655w;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyDown(i4, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f2664f.f2655w;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyUp(i4, keyEvent);
        }
        return true;
    }

    @Override // androidx.activity.p, android.app.Dialog
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        i();
        F fH = h();
        fH.j();
        ViewGroup viewGroup = (ViewGroup) fH.f2527t.findViewById(android.R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        fH.f2514g.a(fH.f2513f.getCallback());
    }

    @Override // android.app.Dialog
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void setTitle(int i4) {
        super.setTitle(i4);
        F fH = h();
        String string = getContext().getString(i4);
        fH.f2516i = string;
        InterfaceC0214m0 interfaceC0214m0 = fH.f2517j;
        if (interfaceC0214m0 != null) {
            interfaceC0214m0.setWindowTitle(string);
            return;
        }
        N n4 = fH.f2515h;
        if (n4 != null) {
            n4.g0(string);
            return;
        }
        TextView textView = fH.f2528u;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public final void r(CharSequence charSequence) {
        super.setTitle(charSequence);
        F fH = h();
        fH.f2516i = charSequence;
        InterfaceC0214m0 interfaceC0214m0 = fH.f2517j;
        if (interfaceC0214m0 != null) {
            interfaceC0214m0.setWindowTitle(charSequence);
            return;
        }
        N n4 = fH.f2515h;
        if (n4 != null) {
            n4.g0(charSequence);
            return;
        }
        TextView textView = fH.f2528u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean s(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        r(charSequence);
        C0185k c0185k = this.f2664f;
        c0185k.f2637e = charSequence;
        TextView textView = c0185k.f2620A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
