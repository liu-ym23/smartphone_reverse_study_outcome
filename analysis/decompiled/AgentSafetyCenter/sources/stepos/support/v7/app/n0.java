package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import androidx.core.widget.NestedScrollView;
import com.stepos.agentsafetycenter.R;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class n0 extends e {

    /* renamed from: j0, reason: collision with root package name */
    public static final ArrayList f12351j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final ArrayList f12352k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final ArrayList f12353l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final ArrayList f12354m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final ArrayList f12355n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final ArrayList f12356o0;
    public Drawable A;
    public NestedScrollView B;
    public int C;
    public Drawable D;
    public ImageView E;
    public TextView F;
    public TextView G;
    public MovementMethod H;
    public View I;
    public ListAdapter J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public int Q;
    public h.e R;
    public boolean S;
    public int T;
    public boolean U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f12357a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f12358b0;

    /* renamed from: c, reason: collision with root package name */
    public Context f12359c;

    /* renamed from: c0, reason: collision with root package name */
    public int f12360c0;

    /* renamed from: d, reason: collision with root package name */
    public s f12361d;

    /* renamed from: d0, reason: collision with root package name */
    public int f12362d0;

    /* renamed from: e, reason: collision with root package name */
    public Window f12363e;
    public boolean e0;

    /* renamed from: f, reason: collision with root package name */
    public int f12364f;
    public boolean f0;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f12365g;

    /* renamed from: g0, reason: collision with root package name */
    public r9.l f12366g0;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f12367h;

    /* renamed from: h0, reason: collision with root package name */
    public float f12368h0;
    public StepOSAlertController$RecycleListView i;

    /* renamed from: i0, reason: collision with root package name */
    public h.b f12369i0;

    /* renamed from: j, reason: collision with root package name */
    public View f12370j;

    /* renamed from: k, reason: collision with root package name */
    public int f12371k;

    /* renamed from: l, reason: collision with root package name */
    public int f12372l;

    /* renamed from: m, reason: collision with root package name */
    public int f12373m;

    /* renamed from: n, reason: collision with root package name */
    public int f12374n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12375o;

    /* renamed from: p, reason: collision with root package name */
    public Button f12376p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f12377q;

    /* renamed from: r, reason: collision with root package name */
    public Message f12378r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f12379s;

    /* renamed from: t, reason: collision with root package name */
    public Button f12380t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f12381u;

    /* renamed from: v, reason: collision with root package name */
    public Message f12382v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f12383w;

    /* renamed from: x, reason: collision with root package name */
    public Button f12384x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f12385y;

    /* renamed from: z, reason: collision with root package name */
    public Message f12386z;

    static {
        ArrayList arrayList = new ArrayList();
        f12351j0 = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f12352k0 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f12353l0 = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f12354m0 = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        f12355n0 = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        f12356o0 = arrayList6;
        arrayList.add(new m0(7, 38, 24, 38, 24));
        arrayList.add(new m0(3, 38, 22, 0, 24));
        arrayList.add(new m0(5, 38, 0, 38, 24));
        arrayList.add(new m0(1, 38, 0, 0, 24));
        arrayList.add(new m0(6, 0, 26, 38, 24));
        arrayList.add(new m0(2, 0, 0, 0, 0));
        arrayList.add(new m0(4, 0, 0, 10, 24));
        arrayList.add(new m0(0, 10, 0, 0, 24));
        arrayList2.add(new m0(7, 38, 22, 38, 24));
        arrayList2.add(new m0(3, 38, 6, 0, 24));
        arrayList2.add(new m0(5, 38, 0, 38, 24));
        arrayList2.add(new m0(1, 38, 0, 0, 24));
        arrayList2.add(new m0(6, 0, 26, 38, 24));
        arrayList2.add(new m0(2, 0, 0, 0, 0));
        arrayList2.add(new m0(4, 0, 0, 10, 24));
        arrayList2.add(new m0(0, 10, 0, 0, 24));
        arrayList3.add(new m0(7, 38, 38, 38, 24));
        arrayList3.add(new m0(3, 38, 22, 0, 24));
        arrayList3.add(new m0(5, 38, 0, 38, 24));
        arrayList3.add(new m0(1, 38, 0, 0, 24));
        arrayList3.add(new m0(6, 0, 0, 38, 24));
        arrayList3.add(new m0(2, 0, 0, 0, 0));
        arrayList3.add(new m0(4, 0, 0, 10, 24));
        arrayList3.add(new m0(0, 10, 0, 0, 24));
        arrayList6.add(new m0(7, 38, 22, 12, 0));
        arrayList6.add(new m0(3, 38, 26, 0, 0));
        arrayList6.add(new m0(5, 38, 0, 12, 0));
        arrayList6.add(new m0(1, 38, 24, 0, 0));
        arrayList6.add(new m0(6, 0, 26, 12, 0));
        arrayList6.add(new m0(2, 0, 0, 0, 0));
        arrayList6.add(new m0(4, 0, 0, 0, 0));
        arrayList6.add(new m0(0, 10, 0, 0, 24));
        arrayList4.add(new m0(7, 24, 12, 12, 0));
        arrayList4.add(new m0(3, 38, 26, 0, 0));
        arrayList4.add(new m0(5, 38, 0, 12, 0));
        arrayList4.add(new m0(1, 38, 24, 0, 0));
        arrayList4.add(new m0(6, 0, 26, 12, 0));
        arrayList4.add(new m0(2, 0, 0, 0, 0));
        arrayList4.add(new m0(4, 0, 0, 0, 0));
        arrayList4.add(new m0(0, 10, 0, 0, 24));
        arrayList5.add(new m0(7, 24, 12, 0, 0));
        arrayList5.add(new m0(3, 24, 12, 0, 0));
        arrayList5.add(new m0(5, 24, 0, 0, 0));
        arrayList5.add(new m0(1, 24, 0, 0, 24));
        arrayList5.add(new m0(6, 0, 0, 0, 0));
        arrayList5.add(new m0(2, 0, 0, 0, 0));
        arrayList5.add(new m0(4, 0, 0, 0, 0));
        arrayList5.add(new m0(0, 10, 0, 0, 24));
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

    public static void j(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", Boolean.TYPE).invoke(textView, Boolean.FALSE);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static int k(float f5, Context context) {
        return (int) TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
    }

    public static View l(View view) {
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
            View viewL = l(viewGroup.getChildAt(i));
            if (viewL != null) {
                return viewL;
            }
        }
        return null;
    }

    public static int n(TextView textView, CharSequence charSequence) {
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

    public static boolean p(View view) {
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
            return p(viewGroup);
        }
        return false;
    }

    public static boolean q(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && q((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public static void r(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public static ViewGroup s(View view, View view2) {
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

    @Override // stepos.support.v7.app.e
    public final void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.f12385y = charSequence;
            this.f12386z = message;
            this.A = drawable;
        } else if (i == -2) {
            this.f12381u = charSequence;
            this.f12382v = message;
            this.f12383w = drawable;
        } else {
            if (i != -1) {
                g5.f.s("Button does not exist");
                return;
            }
            this.f12377q = charSequence;
            this.f12378r = message;
            this.f12379s = drawable;
        }
    }

    @Override // stepos.support.v7.app.e
    public final void b(int i) {
        this.D = null;
        this.C = i;
        ImageView imageView = this.E;
        if (imageView != null) {
            if (i == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.E.setImageResource(this.C);
            }
        }
    }

    @Override // stepos.support.v7.app.e
    public final void c(Drawable drawable) {
        this.D = drawable;
        this.C = 0;
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
        r9.l lVar = this.f12366g0;
        if (lVar == null || this.S || this.i != null || !this.f0) {
            return;
        }
        lVar.a(view);
    }

    public final void e(Button button, int i, int i3, boolean z10) throws Resources.NotFoundException {
        Context context = this.f12359c;
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = h(i3);
        layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_horizontal_button_height);
        button.setGravity(17);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i == 4) {
            if ((i3 & 2) != 0) {
                layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
            }
        } else if (i == 1 && ((i3 & 2) != 0 || (i3 & 4) != 0)) {
            layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
        }
        if (!z10) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i10 = this.f12360c0;
        if (i10 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i10 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i10 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final void f(Button button, int i, int i3, boolean z10) throws Resources.NotFoundException {
        Context context = this.f12359c;
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.S || this.i != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_action_button_height);
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_rectange);
            this.f12366g0.b(2, button);
            return;
        }
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int i10 = this.T - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i10;
        layoutParams2.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_button_height);
        if (i == 4) {
            if ((i3 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i == 2 && ((i3 & 4) != 0 || (i3 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z10) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i11 = this.f12360c0;
        if (i11 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i11 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i11 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final int g(int i) {
        int i3 = this.f12358b0;
        if (i3 == -1 && (i & 1) != 0) {
            return 1;
        }
        if (i3 == -2 && (i & 2) != 0) {
            return 2;
        }
        if (i3 == -3 && (i & 4) != 0) {
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
        Context context = this.f12359c;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int i3 = (i & 4) != 0 ? 1 : 0;
        if ((i & 2) != 0) {
            i3++;
        }
        if ((i & 1) != 0) {
            i3++;
        }
        int i10 = this.T;
        if (i3 == 0) {
            return i10 - (dimensionPixelOffset * 2);
        }
        return ((i10 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (i3 > 0 ? i3 - 1 : 0))) / i3;
    }

    public final int m() {
        Context context = this.f12359c;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int o() {
        int i;
        int i3;
        ImageView imageView;
        int i10 = 0;
        if (TextUtils.isEmpty(this.f12365g)) {
            i = 0;
            i3 = 0;
        } else {
            View viewFindViewById = this.f12363e.findViewById(R.id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i11 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.F.getLayoutParams();
            i3 = layoutParams2.leftMargin + layoutParams2.rightMargin + i11;
            int paddingRight = viewFindViewById.getPaddingRight() + viewFindViewById.getPaddingLeft() + this.F.getPaddingRight() + this.F.getPaddingLeft();
            if ((this.C != 0 || this.D != null) && (imageView = this.E) != null && imageView.getVisibility() == 0) {
                int paddingRight2 = this.E.getPaddingRight() + this.E.getPaddingLeft() + this.f12359c.getResources().getDimensionPixelSize(R.dimen.stepos_alert_dialog_title_icon_width);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
                i10 = layoutParams3.leftMargin + layoutParams3.rightMargin + paddingRight2;
            }
            int i12 = i10;
            i10 = paddingRight;
            i = i12;
        }
        return this.T - ((i10 + i3) + i);
    }
}
