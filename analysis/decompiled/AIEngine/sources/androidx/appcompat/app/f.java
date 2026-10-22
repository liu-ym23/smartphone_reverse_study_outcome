package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends r {
    public final AlertController h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.b f323a;

        /* renamed from: b, reason: collision with root package name */
        public final int f324b;

        public a(Context context) {
            int iE = f.e(context, 0);
            this.f323a = new AlertController.b(new ContextThemeWrapper(context, f.e(context, iE)));
            this.f324b = iE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v7, types: [android.widget.ListAdapter] */
        public final f a() {
            ?? dVar;
            AlertController.b bVar = this.f323a;
            ContextThemeWrapper contextThemeWrapper = bVar.f239a;
            ContextThemeWrapper contextThemeWrapper2 = bVar.f239a;
            f fVar = new f(contextThemeWrapper, this.f324b);
            View view = bVar.f243e;
            AlertController alertController = fVar.h;
            if (view != null) {
                alertController.f233w = view;
            } else {
                CharSequence charSequence = bVar.f242d;
                if (charSequence != null) {
                    alertController.f216d = charSequence;
                    TextView textView = alertController.f231u;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.f241c;
                if (drawable != null) {
                    alertController.f229s = drawable;
                    ImageView imageView = alertController.f230t;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.f230t.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = bVar.f244f;
            if (charSequence2 != null) {
                alertController.f217e = charSequence2;
                TextView textView2 = alertController.f232v;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.f245g;
            if (charSequence3 != null) {
                alertController.c(-1, charSequence3, bVar.h);
            }
            CharSequence charSequence4 = bVar.f246i;
            if (charSequence4 != null) {
                alertController.c(-2, charSequence4, bVar.f247j);
            }
            if (bVar.f249l != null || bVar.f250m != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.f240b.inflate(alertController.A, (ViewGroup) null);
                if (bVar.f254q) {
                    dVar = new c(bVar, contextThemeWrapper2, alertController.B, bVar.f249l, recycleListView);
                } else {
                    int i10 = bVar.r ? alertController.C : alertController.D;
                    Object obj = bVar.f250m;
                    dVar = obj;
                    if (obj == null) {
                        dVar = new AlertController.d(contextThemeWrapper2, i10, R.id.text1, bVar.f249l);
                    }
                }
                alertController.f234x = dVar;
                alertController.f235y = bVar.f255s;
                if (bVar.f251n != null) {
                    recycleListView.setOnItemClickListener(new d(bVar, alertController));
                } else if (bVar.f256t != null) {
                    recycleListView.setOnItemClickListener(new e(bVar, recycleListView, alertController));
                }
                if (bVar.r) {
                    recycleListView.setChoiceMode(1);
                } else if (bVar.f254q) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f218f = recycleListView;
            }
            View view2 = bVar.f252o;
            if (view2 != null) {
                alertController.f219g = view2;
                alertController.h = false;
            }
            fVar.setCancelable(true);
            fVar.setCanceledOnTouchOutside(true);
            fVar.setOnCancelListener(null);
            fVar.setOnDismissListener(null);
            androidx.appcompat.view.menu.g gVar = bVar.f248k;
            if (gVar != null) {
                fVar.setOnKeyListener(gVar);
            }
            return fVar;
        }
    }

    public f(ContextThemeWrapper contextThemeWrapper, int i10) {
        super(contextThemeWrapper, e(contextThemeWrapper, i10));
        this.h = new AlertController(getContext(), this, getWindow());
    }

    public static int e(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.r, b.n, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i10;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        AlertController alertController = this.h;
        alertController.f214b.setContentView(alertController.z);
        Context context = alertController.f213a;
        Window window = alertController.f215c;
        View viewFindViewById2 = window.findViewById(com.stepos.aiengine.R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(com.stepos.aiengine.R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(com.stepos.aiengine.R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(com.stepos.aiengine.R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(com.stepos.aiengine.R.id.customPanel);
        View view = alertController.f219g;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !AlertController.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(com.stepos.aiengine.R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (alertController.f218f != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(com.stepos.aiengine.R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(com.stepos.aiengine.R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(com.stepos.aiengine.R.id.buttonPanel);
        ViewGroup viewGroupB = AlertController.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = AlertController.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = AlertController.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(com.stepos.aiengine.R.id.scrollView);
        alertController.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        alertController.f232v = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f217e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.r.removeView(alertController.f232v);
                if (alertController.f218f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(alertController.r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(alertController.f218f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        alertController.f220i = button;
        AlertController.a aVar = alertController.G;
        button.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.f221j)) {
            alertController.f220i.setVisibility(8);
            i10 = 0;
        } else {
            alertController.f220i.setText(alertController.f221j);
            alertController.f220i.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        alertController.f223l = button2;
        button2.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.f224m)) {
            alertController.f223l.setVisibility(8);
        } else {
            alertController.f223l.setText(alertController.f224m);
            alertController.f223l.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        alertController.f226o = button3;
        button3.setOnClickListener(aVar);
        if (TextUtils.isEmpty(alertController.f227p)) {
            alertController.f226o.setVisibility(8);
        } else {
            alertController.f226o.setText(alertController.f227p);
            alertController.f226o.setVisibility(0);
            i10 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i10 == 1) {
                Button button4 = alertController.f220i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i10 == 2) {
                Button button5 = alertController.f223l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i10 == 4) {
                Button button6 = alertController.f226o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i10 == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (alertController.f233w != null) {
            viewGroupB.addView(alertController.f233w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(com.stepos.aiengine.R.id.title_template).setVisibility(8);
        } else {
            alertController.f230t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(alertController.f216d) || !alertController.E) {
                window.findViewById(com.stepos.aiengine.R.id.title_template).setVisibility(8);
                alertController.f230t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(com.stepos.aiengine.R.id.alertTitle);
                alertController.f231u = textView2;
                textView2.setText(alertController.f216d);
                Drawable drawable = alertController.f229s;
                if (drawable != null) {
                    alertController.f230t.setImageDrawable(drawable);
                } else {
                    alertController.f231u.setPadding(alertController.f230t.getPaddingLeft(), alertController.f230t.getPaddingTop(), alertController.f230t.getPaddingRight(), alertController.f230t.getPaddingBottom());
                    alertController.f230t.setVisibility(8);
                }
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        int i11 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z10 = viewGroupB3.getVisibility() != 8;
        if (!z10 && (viewFindViewById = viewGroupB2.findViewById(com.stepos.aiengine.R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = alertController.r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (alertController.f217e == null && alertController.f218f == null) ? null : viewGroupB.findViewById(com.stepos.aiengine.R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(com.stepos.aiengine.R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController.RecycleListView recycleListView = alertController.f218f;
        if (recycleListView != null && (!z10 || i11 == 0)) {
            recycleListView.setPadding(recycleListView.getPaddingLeft(), i11 != 0 ? recycleListView.getPaddingTop() : recycleListView.f236a, recycleListView.getPaddingRight(), z10 ? recycleListView.getPaddingBottom() : recycleListView.f237b);
        }
        if (!z3) {
            View view2 = alertController.f218f;
            if (view2 == null) {
                view2 = alertController.r;
            }
            if (view2 != null) {
                int i12 = z10 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(com.stepos.aiengine.R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(com.stepos.aiengine.R.id.scrollIndicatorDown);
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                e0.e.b(view2, i11 | i12, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController.RecycleListView recycleListView2 = alertController.f218f;
        if (recycleListView2 == null || (listAdapter = alertController.f234x) == null) {
            return;
        }
        recycleListView2.setAdapter(listAdapter);
        int i13 = alertController.f235y;
        if (i13 > -1) {
            recycleListView2.setItemChecked(i13, true);
            recycleListView2.setSelection(i13);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.r;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.r;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.app.r, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.h;
        alertController.f216d = charSequence;
        TextView textView = alertController.f231u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
