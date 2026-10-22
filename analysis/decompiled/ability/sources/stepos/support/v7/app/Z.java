package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class Z extends AbstractC1958g {

    /* renamed from: j0, reason: collision with root package name */
    public static final ArrayList f6242j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final ArrayList f6243k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final ArrayList f6244l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final ArrayList f6245m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final ArrayList f6246n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final ArrayList f6247o0;

    /* renamed from: A, reason: collision with root package name */
    public Drawable f6248A;

    /* renamed from: B, reason: collision with root package name */
    public NestedScrollView f6249B;

    /* renamed from: C, reason: collision with root package name */
    public int f6250C;

    /* renamed from: D, reason: collision with root package name */
    public Drawable f6251D;
    public ImageView E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f6252F;

    /* renamed from: G, reason: collision with root package name */
    public TextView f6253G;

    /* renamed from: H, reason: collision with root package name */
    public MovementMethod f6254H;

    /* renamed from: I, reason: collision with root package name */
    public View f6255I;

    /* renamed from: J, reason: collision with root package name */
    public ListAdapter f6256J;

    /* renamed from: K, reason: collision with root package name */
    public int f6257K;

    /* renamed from: L, reason: collision with root package name */
    public final int f6258L;

    /* renamed from: M, reason: collision with root package name */
    public final int f6259M;

    /* renamed from: N, reason: collision with root package name */
    public final int f6260N;

    /* renamed from: O, reason: collision with root package name */
    public final int f6261O;

    /* renamed from: P, reason: collision with root package name */
    public final boolean f6262P;

    /* renamed from: Q, reason: collision with root package name */
    public int f6263Q;

    /* renamed from: R, reason: collision with root package name */
    public final A6.c f6264R;

    /* renamed from: S, reason: collision with root package name */
    public final boolean f6265S;

    /* renamed from: T, reason: collision with root package name */
    public final int f6266T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f6267U;

    /* renamed from: V, reason: collision with root package name */
    public int f6268V;

    /* renamed from: W, reason: collision with root package name */
    public int f6269W;

    /* renamed from: X, reason: collision with root package name */
    public int f6270X;

    /* renamed from: Y, reason: collision with root package name */
    public int f6271Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f6272Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f6273a0;
    public int b0;
    public final Context c;

    /* renamed from: c0, reason: collision with root package name */
    public int f6274c0;
    public final AbstractDialogC1976z d;

    /* renamed from: d0, reason: collision with root package name */
    public final int f6275d0;
    public final Window e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f6276e0;
    public final int f;

    /* renamed from: f0, reason: collision with root package name */
    public final boolean f6277f0;
    public CharSequence g;

    /* renamed from: g0, reason: collision with root package name */
    public final com.stepos.common.animator.m f6278g0;
    public CharSequence h;

    /* renamed from: h0, reason: collision with root package name */
    public final float f6279h0;
    public StepOSAlertController$RecycleListView i;

    /* renamed from: i0, reason: collision with root package name */
    public final ViewOnClickListenerC1971u f6280i0;

    /* renamed from: j, reason: collision with root package name */
    public View f6281j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public Button p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f6282q;

    /* renamed from: r, reason: collision with root package name */
    public Message f6283r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f6284s;

    /* renamed from: t, reason: collision with root package name */
    public Button f6285t;
    public CharSequence u;

    /* renamed from: v, reason: collision with root package name */
    public Message f6286v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f6287w;

    /* renamed from: x, reason: collision with root package name */
    public Button f6288x;
    public CharSequence y;

    /* renamed from: z, reason: collision with root package name */
    public Message f6289z;

    static {
        ArrayList arrayList = new ArrayList();
        f6242j0 = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f6243k0 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f6244l0 = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f6245m0 = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        f6246n0 = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        f6247o0 = arrayList6;
        arrayList.add(new Y(7, 38, 24, 38, 24));
        arrayList.add(new Y(3, 38, 22, 0, 24));
        arrayList.add(new Y(5, 38, 0, 38, 24));
        arrayList.add(new Y(1, 38, 0, 0, 24));
        arrayList.add(new Y(6, 0, 26, 38, 24));
        arrayList.add(new Y(2, 0, 0, 0, 0));
        arrayList.add(new Y(4, 0, 0, 10, 24));
        arrayList.add(new Y(0, 10, 0, 0, 24));
        arrayList2.add(new Y(7, 38, 22, 38, 24));
        arrayList2.add(new Y(3, 38, 6, 0, 24));
        arrayList2.add(new Y(5, 38, 0, 38, 24));
        arrayList2.add(new Y(1, 38, 0, 0, 24));
        arrayList2.add(new Y(6, 0, 26, 38, 24));
        arrayList2.add(new Y(2, 0, 0, 0, 0));
        arrayList2.add(new Y(4, 0, 0, 10, 24));
        arrayList2.add(new Y(0, 10, 0, 0, 24));
        arrayList3.add(new Y(7, 38, 38, 38, 24));
        arrayList3.add(new Y(3, 38, 22, 0, 24));
        arrayList3.add(new Y(5, 38, 0, 38, 24));
        arrayList3.add(new Y(1, 38, 0, 0, 24));
        arrayList3.add(new Y(6, 0, 0, 38, 24));
        arrayList3.add(new Y(2, 0, 0, 0, 0));
        arrayList3.add(new Y(4, 0, 0, 10, 24));
        arrayList3.add(new Y(0, 10, 0, 0, 24));
        arrayList6.add(new Y(7, 38, 22, 12, 0));
        arrayList6.add(new Y(3, 38, 26, 0, 0));
        arrayList6.add(new Y(5, 38, 0, 12, 0));
        arrayList6.add(new Y(1, 38, 24, 0, 0));
        arrayList6.add(new Y(6, 0, 26, 12, 0));
        arrayList6.add(new Y(2, 0, 0, 0, 0));
        arrayList6.add(new Y(4, 0, 0, 0, 0));
        arrayList6.add(new Y(0, 10, 0, 0, 24));
        arrayList4.add(new Y(7, 24, 12, 12, 0));
        arrayList4.add(new Y(3, 38, 26, 0, 0));
        arrayList4.add(new Y(5, 38, 0, 12, 0));
        arrayList4.add(new Y(1, 38, 24, 0, 0));
        arrayList4.add(new Y(6, 0, 26, 12, 0));
        arrayList4.add(new Y(2, 0, 0, 0, 0));
        arrayList4.add(new Y(4, 0, 0, 0, 0));
        arrayList4.add(new Y(0, 10, 0, 0, 24));
        arrayList5.add(new Y(7, 24, 12, 0, 0));
        arrayList5.add(new Y(3, 24, 12, 0, 0));
        arrayList5.add(new Y(5, 24, 0, 0, 0));
        arrayList5.add(new Y(1, 24, 0, 0, 24));
        arrayList5.add(new Y(6, 0, 0, 0, 0));
        arrayList5.add(new Y(2, 0, 0, 0, 0));
        arrayList5.add(new Y(4, 0, 0, 0, 0));
        arrayList5.add(new Y(0, 10, 0, 0, 24));
    }

    public Z(Context context, AbstractDialogC1976z abstractDialogC1976z, Window window) {
        int i;
        new A6.c(2).b = new WeakReference(abstractDialogC1976z);
        new ArrayList();
        int i6 = R.attr.alertDialogStyle;
        int[] iArr = Ra.a.b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i6, 0);
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f6313a = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.b = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        typedArrayObtainStyledAttributes.recycle();
        abstractDialogC1976z.supportRequestWindowFeature(1);
        this.o = false;
        this.f6250C = 0;
        this.f6257K = -1;
        this.f6263Q = 0;
        this.f6273a0 = true;
        this.f6274c0 = 1;
        this.f6277f0 = true;
        this.f6280i0 = new ViewOnClickListenerC1971u(this, 1);
        this.c = context;
        this.d = abstractDialogC1976z;
        this.e = window;
        A6.c cVar = new A6.c(3);
        cVar.b = new WeakReference(abstractDialogC1976z);
        this.f6264R = cVar;
        this.f6278g0 = new com.stepos.common.animator.m();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, 0);
        this.f6258L = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.f6259M = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f6260N = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f6261O = typedArrayObtainStyledAttributes2.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        typedArrayObtainStyledAttributes2.getResourceId(7, 0);
        typedArrayObtainStyledAttributes2.getResourceId(8, 0);
        typedArrayObtainStyledAttributes2.getResourceId(9, 0);
        this.f6262P = true;
        this.f = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, a5.l.b(context, 48.0f));
        typedArrayObtainStyledAttributes2.getResourceId(3, 0);
        this.f6265S = typedArrayObtainStyledAttributes2.getBoolean(12, false);
        this.f6267U = typedArrayObtainStyledAttributes2.getBoolean(15, false);
        this.f6268V = typedArrayObtainStyledAttributes2.getDimensionPixelSize(16, 0);
        this.f6269W = typedArrayObtainStyledAttributes2.getDimensionPixelSize(17, 0);
        this.f6270X = typedArrayObtainStyledAttributes2.getDimensionPixelSize(18, 0);
        this.f6271Y = typedArrayObtainStyledAttributes2.getDimensionPixelSize(19, 0);
        typedArrayObtainStyledAttributes2.recycle();
        abstractDialogC1976z.supportRequestWindowFeature(1);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            i = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        }
        this.f6266T = Math.min(i, l()) - (context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_margin_bottom_to_screen) * 2);
        this.f6279h0 = 1.0f;
        this.f6275d0 = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_divider_height);
    }

    public static boolean i(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (i(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void j(TextView textView) {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", Boolean.TYPE).invoke(textView, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static View k(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View viewK = k(viewGroup.getChildAt(i));
            if (viewK != null) {
                return viewK;
            }
        }
        return null;
    }

    public static int m(TextView textView, CharSequence charSequence) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, textView);
        }
        int iMax = 0;
        for (String str : charSequence.toString().split("\n")) {
            iMax = Math.max(iMax, (int) textView.getPaint().measureText(str));
        }
        return iMax;
    }

    public static boolean o(View view) {
        if (!(view instanceof EditText) && view.getPaddingLeft() != 0) {
            return true;
        }
        if (view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin != 0) {
            return true;
        }
        if (view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getId() != com.stepos.ability.R.id.customPanel) {
            return o(viewGroup);
        }
        return false;
    }

    public static boolean p(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && p((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public static void q(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup r(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    @Override // stepos.support.v7.app.AbstractC1958g
    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f6264R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.y = charSequence;
            this.f6289z = message;
            this.f6248A = drawable;
        } else if (i == -2) {
            this.u = charSequence;
            this.f6286v = message;
            this.f6287w = drawable;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f6282q = charSequence;
            this.f6283r = message;
            this.f6284s = drawable;
        }
    }

    @Override // stepos.support.v7.app.AbstractC1958g
    public final void b(int i) {
        this.f6251D = null;
        this.f6250C = i;
        ImageView imageView = this.E;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.E.setImageResource(this.f6250C);
            }
        }
    }

    @Override // stepos.support.v7.app.AbstractC1958g
    public final void c(Drawable drawable) {
        this.f6251D = drawable;
        this.f6250C = 0;
        ImageView imageView = this.E;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.E.setImageDrawable(drawable);
            }
        }
    }

    public final void d(View view) {
        com.stepos.common.animator.m mVar = this.f6278g0;
        if (mVar == null || this.f6265S || this.i != null || !this.f6277f0) {
            return;
        }
        mVar.a(view, false);
    }

    public final void e(Button button, int i, int i6, boolean z10) {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = h(i6);
        Context context = this.c;
        layoutParams.height = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_horizontal_button_height);
        button.setGravity(17);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i == 4) {
            if ((i6 & 2) != 0) {
                layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_margin_start));
            }
        } else if (i == 1 && ((i6 & 2) != 0 || (i6 & 4) != 0)) {
            layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_margin_start));
        }
        if (!z10) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i10 = this.f6274c0;
        if (i10 == 2) {
            button.setTextColor(context.getResources().getColor(com.stepos.ability.R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i10 == 1) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i10 == 3) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final void f(Button button, int i, int i6, boolean z10) {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        Context context = this.c;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.f6265S || this.i != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_vertical_action_button_height);
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_rectange);
            this.f6278g0.b(button, 2, false);
            return;
        }
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_margin_start);
        int i10 = this.f6266T - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i10;
        layoutParams2.height = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_vertical_button_height);
        if (i == 4) {
            if ((i6 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i == 2 && ((i6 & 4) != 0 || (i6 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z10) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i11 = this.f6274c0;
        if (i11 == 2) {
            button.setTextColor(context.getResources().getColor(com.stepos.ability.R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i11 == 1) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i11 == 3) {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(com.stepos.ability.R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final int g(int i) {
        int i6 = this.b0;
        if (i6 == -1 && (i & 1) != 0) {
            return 1;
        }
        if (i6 == -2 && (i & 2) != 0) {
            return 2;
        }
        if (i6 == -3 && (i & 4) != 0) {
            return 4;
        }
        if ((i & 1) != 0) {
            return 1;
        }
        if ((i & 4) != 0) {
            return 4;
        }
        return (i & 2) != 0 ? 2 : 0;
    }

    public final int h(int i) throws Resources.NotFoundException {
        Context context = this.c;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.stepos_alert_dialog_button_margin_start);
        int i6 = (i & 4) != 0 ? 1 : 0;
        if ((i & 2) != 0) {
            i6++;
        }
        if ((i & 1) != 0) {
            i6++;
        }
        int i10 = this.f6266T;
        if (i6 == 0) {
            return i10 - (dimensionPixelOffset * 2);
        }
        return ((i10 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (i6 > 0 ? i6 - 1 : 0))) / i6;
    }

    public final int l() {
        Context context = this.c;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int n() {
        int i;
        int i6;
        ImageView imageView;
        int i10 = 0;
        if (TextUtils.isEmpty(this.g)) {
            i = 0;
            i6 = 0;
        } else {
            View viewFindViewById = this.e.findViewById(com.stepos.ability.R.id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i11 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f6252F.getLayoutParams();
            i6 = layoutParams2.leftMargin + layoutParams2.rightMargin + i11;
            int paddingRight = viewFindViewById.getPaddingRight() + viewFindViewById.getPaddingLeft() + this.f6252F.getPaddingRight() + this.f6252F.getPaddingLeft();
            if ((this.f6250C != 0 || this.f6251D != null) && (imageView = this.E) != null && imageView.getVisibility() == 0) {
                int paddingRight2 = this.E.getPaddingRight() + this.E.getPaddingLeft() + this.c.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.stepos_alert_dialog_title_icon_width);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                i10 = layoutParams3.leftMargin + layoutParams3.rightMargin + paddingRight2;
            }
            int i12 = i10;
            i10 = paddingRight;
            i = i12;
        }
        return this.f6266T - ((i10 + i6) + i);
    }
}
