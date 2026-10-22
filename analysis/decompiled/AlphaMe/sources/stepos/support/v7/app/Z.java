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
import androidx.appcompat.app.HandlerC0183i;
import androidx.appcompat.app.ViewOnClickListenerC0177c;
import androidx.core.widget.NestedScrollView;
import com.stepos.alphame.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class Z extends AbstractC0862g {

    /* renamed from: n0, reason: collision with root package name */
    public static final ArrayList f14367n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final ArrayList f14368o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final ArrayList f14369p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final ArrayList f14370q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final ArrayList f14371r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final ArrayList f14372s0;

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f14373A;

    /* renamed from: B, reason: collision with root package name */
    public Message f14374B;

    /* renamed from: C, reason: collision with root package name */
    public Drawable f14375C;

    /* renamed from: D, reason: collision with root package name */
    public NestedScrollView f14376D;

    /* renamed from: E, reason: collision with root package name */
    public int f14377E;

    /* renamed from: F, reason: collision with root package name */
    public Drawable f14378F;

    /* renamed from: G, reason: collision with root package name */
    public ImageView f14379G;

    /* renamed from: H, reason: collision with root package name */
    public TextView f14380H;

    /* renamed from: I, reason: collision with root package name */
    public TextView f14381I;

    /* renamed from: J, reason: collision with root package name */
    public MovementMethod f14382J;

    /* renamed from: K, reason: collision with root package name */
    public View f14383K;

    /* renamed from: L, reason: collision with root package name */
    public ListAdapter f14384L;

    /* renamed from: M, reason: collision with root package name */
    public int f14385M;

    /* renamed from: N, reason: collision with root package name */
    public final int f14386N;

    /* renamed from: O, reason: collision with root package name */
    public final int f14387O;

    /* renamed from: P, reason: collision with root package name */
    public final int f14388P;

    /* renamed from: Q, reason: collision with root package name */
    public final int f14389Q;

    /* renamed from: R, reason: collision with root package name */
    public final int f14390R;

    /* renamed from: S, reason: collision with root package name */
    public final boolean f14391S;
    public int T;

    /* renamed from: U, reason: collision with root package name */
    public final HandlerC0183i f14392U;

    /* renamed from: V, reason: collision with root package name */
    public final boolean f14393V;

    /* renamed from: W, reason: collision with root package name */
    public final int f14394W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f14395X;

    /* renamed from: Y, reason: collision with root package name */
    public int f14396Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f14397Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f14398a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f14399b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f14400c0;

    /* renamed from: d, reason: collision with root package name */
    public final Context f14401d;

    /* renamed from: d0, reason: collision with root package name */
    public int f14402d0;

    /* renamed from: e, reason: collision with root package name */
    public final A f14403e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f14404e0;

    /* renamed from: f, reason: collision with root package name */
    public final Window f14405f;

    /* renamed from: f0, reason: collision with root package name */
    public int f14406f0;

    /* renamed from: g, reason: collision with root package name */
    public final int f14407g;

    /* renamed from: g0, reason: collision with root package name */
    public int f14408g0;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f14409h;

    /* renamed from: h0, reason: collision with root package name */
    public final int f14410h0;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f14411i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f14412i0;

    /* renamed from: j, reason: collision with root package name */
    public StepOSAlertController$RecycleListView f14413j;

    /* renamed from: j0, reason: collision with root package name */
    public final boolean f14414j0;

    /* renamed from: k, reason: collision with root package name */
    public View f14415k;

    /* renamed from: k0, reason: collision with root package name */
    public final com.stepos.common.animator.m f14416k0;

    /* renamed from: l, reason: collision with root package name */
    public int f14417l;

    /* renamed from: l0, reason: collision with root package name */
    public final float f14418l0;

    /* renamed from: m, reason: collision with root package name */
    public int f14419m;

    /* renamed from: m0, reason: collision with root package name */
    public final ViewOnClickListenerC0177c f14420m0;

    /* renamed from: n, reason: collision with root package name */
    public int f14421n;

    /* renamed from: o, reason: collision with root package name */
    public int f14422o;

    /* renamed from: p, reason: collision with root package name */
    public int f14423p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14424q;

    /* renamed from: r, reason: collision with root package name */
    public Button f14425r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f14426s;

    /* renamed from: t, reason: collision with root package name */
    public Message f14427t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f14428u;

    /* renamed from: v, reason: collision with root package name */
    public Button f14429v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f14430w;

    /* renamed from: x, reason: collision with root package name */
    public Message f14431x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f14432y;

    /* renamed from: z, reason: collision with root package name */
    public Button f14433z;

    static {
        ArrayList arrayList = new ArrayList();
        f14367n0 = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f14368o0 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f14369p0 = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f14370q0 = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        f14371r0 = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        f14372s0 = arrayList6;
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

    public Z(Context context, A a4, Window window) {
        int i4;
        super(context, a4);
        this.f14424q = false;
        this.f14377E = 0;
        this.f14385M = -1;
        this.T = 0;
        this.f14404e0 = true;
        this.f14408g0 = 1;
        this.f14414j0 = true;
        this.f14420m0 = new ViewOnClickListenerC0177c(5, this);
        this.f14401d = context;
        this.f14403e = a4;
        this.f14405f = window;
        this.f14392U = new HandlerC0183i(a4, 2);
        this.f14416k0 = new com.stepos.common.animator.m();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, I3.a.f842b, R.attr.alertDialogStyle, 0);
        this.f14386N = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f14387O = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f14388P = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        this.f14389Q = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.f14390R = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        this.f14391S = true;
        this.f14407g = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, m2.o.b(context, 48.0f));
        typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f14393V = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.f14395X = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.f14396Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.f14397Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, 0);
        this.f14398a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, 0);
        this.f14399b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, 0);
        typedArrayObtainStyledAttributes.recycle();
        a4.supportRequestWindowFeature(1);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            i4 = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i4 = displayMetrics.widthPixels;
        }
        this.f14394W = Math.min(i4, n()) - (context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_margin_bottom_to_screen) * 2);
        this.f14418l0 = 1.0f;
        this.f14410h0 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_divider_height);
    }

    public static int h(int i4) {
        int i5 = (i4 & 4) != 0 ? 1 : 0;
        if ((i4 & 2) != 0) {
            i5++;
        }
        return (i4 & 1) != 0 ? i5 + 1 : i5;
    }

    public static boolean k(View view) {
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
            if (k(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void l(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", Boolean.TYPE).invoke(textView, Boolean.FALSE);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static View m(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                View viewM = m(viewGroup.getChildAt(i4));
                if (viewM != null) {
                    return viewM;
                }
            }
        }
        return null;
    }

    public static int o(TextView textView, CharSequence charSequence) {
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

    public static boolean q(View view) {
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
        if (viewGroup.getId() != R.id.customPanel) {
            return q(viewGroup);
        }
        return false;
    }

    public static boolean r(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && r((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public static void s(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup t(View view, View view2) {
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

    @Override // stepos.support.v7.app.AbstractC0862g
    public final Button a(int i4) {
        if (i4 == -3) {
            return this.f14433z;
        }
        if (i4 == -2) {
            return this.f14429v;
        }
        if (i4 != -1) {
            return null;
        }
        return this.f14425r;
    }

    @Override // stepos.support.v7.app.AbstractC0862g
    public final void b(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f14392U.obtainMessage(i4, onClickListener);
        }
        if (i4 == -3) {
            this.f14373A = charSequence;
            this.f14374B = message;
            this.f14375C = drawable;
        } else if (i4 == -2) {
            this.f14430w = charSequence;
            this.f14431x = message;
            this.f14432y = drawable;
        } else {
            if (i4 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f14426s = charSequence;
            this.f14427t = message;
            this.f14428u = drawable;
        }
    }

    @Override // stepos.support.v7.app.AbstractC0862g
    public final void c(int i4) {
        this.f14378F = null;
        this.f14377E = i4;
        ImageView imageView = this.f14379G;
        if (imageView != null) {
            if (i4 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f14379G.setImageResource(this.f14377E);
            }
        }
    }

    @Override // stepos.support.v7.app.AbstractC0862g
    public final void d(Drawable drawable) {
        this.f14378F = drawable;
        this.f14377E = 0;
        ImageView imageView = this.f14379G;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f14379G.setImageDrawable(drawable);
            }
        }
    }

    public final void e(Button button) {
        com.stepos.common.animator.m mVar = this.f14416k0;
        if (mVar == null || this.f14393V || this.f14413j != null || !this.f14414j0) {
            return;
        }
        mVar.a(button, false);
    }

    public final void f(Button button, int i4, int i5, boolean z4) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = j(i5);
        Context context = this.f14401d;
        layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_horizontal_button_height);
        button.setGravity(17);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i4 == 4) {
            if ((i5 & 2) != 0) {
                layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
            }
        } else if (i4 == 1 && ((i5 & 2) != 0 || (i5 & 4) != 0)) {
            layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
        }
        if (!z4) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i6 = this.f14408g0;
        if (i6 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i6 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i6 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final void g(Button button, int i4, int i5, boolean z4) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        Context context = this.f14401d;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.f14393V || this.f14413j != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_action_button_height);
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_rectange);
            this.f14416k0.b(button, 2, false);
            return;
        }
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int i6 = this.f14394W - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i6;
        layoutParams2.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_button_height);
        if (i4 == 4) {
            if ((i5 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i4 == 2 && ((i5 & 4) != 0 || (i5 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z4) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i7 = this.f14408g0;
        if (i7 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i7 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i7 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final int i(int i4) {
        int i5 = this.f14406f0;
        if (i5 == -1 && (i4 & 1) != 0) {
            return 1;
        }
        if (i5 != -2 || (i4 & 2) == 0) {
            if (i5 != -3 || (i4 & 4) == 0) {
                if ((i4 & 1) != 0) {
                    return 1;
                }
                if ((i4 & 4) == 0) {
                    if ((i4 & 2) == 0) {
                        return 0;
                    }
                }
            }
            return 4;
        }
        return 2;
    }

    public final int j(int i4) throws Resources.NotFoundException {
        Context context = this.f14401d;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int iH = h(i4);
        int i5 = this.f14394W;
        if (iH == 0) {
            return i5 - (dimensionPixelOffset * 2);
        }
        return ((i5 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (iH > 0 ? iH - 1 : 0))) / iH;
    }

    public final int n() {
        Context context = this.f14401d;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int p() {
        int i4;
        int i5;
        ImageView imageView;
        int i6 = 0;
        if (TextUtils.isEmpty(this.f14409h)) {
            i4 = 0;
            i5 = 0;
        } else {
            View viewFindViewById = this.f14405f.findViewById(R.id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i7 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f14380H.getLayoutParams();
            i5 = layoutParams2.leftMargin + layoutParams2.rightMargin + i7;
            int paddingRight = viewFindViewById.getPaddingRight() + viewFindViewById.getPaddingLeft() + this.f14380H.getPaddingRight() + this.f14380H.getPaddingLeft();
            if ((this.f14377E != 0 || this.f14378F != null) && (imageView = this.f14379G) != null && imageView.getVisibility() == 0) {
                int paddingRight2 = this.f14379G.getPaddingRight() + this.f14379G.getPaddingLeft() + this.f14401d.getResources().getDimensionPixelSize(R.dimen.stepos_alert_dialog_title_icon_width);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f14379G.getLayoutParams();
                i6 = layoutParams3.leftMargin + layoutParams3.rightMargin + paddingRight2;
            }
            int i8 = i6;
            i6 = paddingRight;
            i4 = i8;
        }
        return this.f14394W - ((i6 + i5) + i4);
    }
}
