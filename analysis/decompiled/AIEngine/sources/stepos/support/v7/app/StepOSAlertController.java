package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import stepos.support.v7.app.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class StepOSAlertController extends stepos.support.v7.app.c {

    /* renamed from: k0, reason: collision with root package name */
    public static final ArrayList f12023k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final ArrayList f12024l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final ArrayList f12025m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final ArrayList f12026n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final ArrayList f12027o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final ArrayList f12028p0;
    public Message A;
    public Drawable B;
    public NestedScrollView C;
    public int D;
    public Drawable E;
    public ImageView F;
    public TextView G;
    public TextView H;
    public MovementMethod I;
    public View J;
    public ListAdapter K;
    public int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final boolean Q;
    public int R;
    public final c S;
    public final boolean T;
    public final int U;
    public boolean V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f12029a0;
    public boolean b0;
    public int c0;

    /* renamed from: d, reason: collision with root package name */
    public final Context f12030d;

    /* renamed from: d0, reason: collision with root package name */
    public int f12031d0;

    /* renamed from: e, reason: collision with root package name */
    public final p f12032e;

    /* renamed from: e0, reason: collision with root package name */
    public final int f12033e0;

    /* renamed from: f, reason: collision with root package name */
    public final Window f12034f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f12035f0;

    /* renamed from: g, reason: collision with root package name */
    public final int f12036g;

    /* renamed from: g0, reason: collision with root package name */
    public final boolean f12037g0;
    public CharSequence h;

    /* renamed from: h0, reason: collision with root package name */
    public final com.stepos.common.animator.g f12038h0;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f12039i;

    /* renamed from: i0, reason: collision with root package name */
    public final float f12040i0;

    /* renamed from: j, reason: collision with root package name */
    public RecycleListView f12041j;

    /* renamed from: j0, reason: collision with root package name */
    public final a f12042j0;

    /* renamed from: k, reason: collision with root package name */
    public View f12043k;

    /* renamed from: l, reason: collision with root package name */
    public int f12044l;

    /* renamed from: m, reason: collision with root package name */
    public int f12045m;

    /* renamed from: n, reason: collision with root package name */
    public int f12046n;

    /* renamed from: o, reason: collision with root package name */
    public int f12047o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12048p;

    /* renamed from: q, reason: collision with root package name */
    public Button f12049q;
    public CharSequence r;

    /* renamed from: s, reason: collision with root package name */
    public Message f12050s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f12051t;

    /* renamed from: u, reason: collision with root package name */
    public Button f12052u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f12053v;

    /* renamed from: w, reason: collision with root package name */
    public Message f12054w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f12055x;

    /* renamed from: y, reason: collision with root package name */
    public Button f12056y;
    public CharSequence z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @f.a
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z3) {
            if (z3 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z3 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            StepOSAlertController stepOSAlertController = StepOSAlertController.this;
            Message messageObtain = (view != stepOSAlertController.f12049q || (message3 = stepOSAlertController.f12050s) == null) ? (view != stepOSAlertController.f12052u || (message2 = stepOSAlertController.f12054w) == null) ? (view != stepOSAlertController.f12056y || (message = stepOSAlertController.A) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            stepOSAlertController.S.obtainMessage(1, stepOSAlertController.f12032e).sendToTarget();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public c.a f12058a;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class a implements DialogInterface.OnClickListener {
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f12059a;

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f12059a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final int f12060a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12061b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12062c;

        /* renamed from: d, reason: collision with root package name */
        public final int f12063d;

        /* renamed from: e, reason: collision with root package name */
        public final int f12064e;

        public e(int i10, int i11, int i12, int i13, int i14) {
            this.f12060a = i10;
            this.f12061b = i11;
            this.f12062c = i12;
            this.f12063d = i13;
            this.f12064e = i14;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f12023k0 = arrayList;
        ArrayList arrayList2 = new ArrayList();
        f12024l0 = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        f12025m0 = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        f12026n0 = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        f12027o0 = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        f12028p0 = arrayList6;
        arrayList.add(new e(7, 38, 24, 38, 24));
        arrayList.add(new e(3, 38, 22, 0, 24));
        arrayList.add(new e(5, 38, 0, 38, 24));
        arrayList.add(new e(1, 38, 0, 0, 24));
        arrayList.add(new e(6, 0, 26, 38, 24));
        arrayList.add(new e(2, 0, 0, 0, 0));
        arrayList.add(new e(4, 0, 0, 10, 24));
        arrayList.add(new e(0, 10, 0, 0, 24));
        arrayList2.add(new e(7, 38, 22, 38, 24));
        arrayList2.add(new e(3, 38, 6, 0, 24));
        arrayList2.add(new e(5, 38, 0, 38, 24));
        arrayList2.add(new e(1, 38, 0, 0, 24));
        arrayList2.add(new e(6, 0, 26, 38, 24));
        arrayList2.add(new e(2, 0, 0, 0, 0));
        arrayList2.add(new e(4, 0, 0, 10, 24));
        arrayList2.add(new e(0, 10, 0, 0, 24));
        arrayList3.add(new e(7, 38, 38, 38, 24));
        arrayList3.add(new e(3, 38, 22, 0, 24));
        arrayList3.add(new e(5, 38, 0, 38, 24));
        arrayList3.add(new e(1, 38, 0, 0, 24));
        arrayList3.add(new e(6, 0, 0, 38, 24));
        arrayList3.add(new e(2, 0, 0, 0, 0));
        arrayList3.add(new e(4, 0, 0, 10, 24));
        arrayList3.add(new e(0, 10, 0, 0, 24));
        arrayList6.add(new e(7, 38, 22, 12, 0));
        arrayList6.add(new e(3, 38, 26, 0, 0));
        arrayList6.add(new e(5, 38, 0, 12, 0));
        arrayList6.add(new e(1, 38, 24, 0, 0));
        arrayList6.add(new e(6, 0, 26, 12, 0));
        arrayList6.add(new e(2, 0, 0, 0, 0));
        arrayList6.add(new e(4, 0, 0, 0, 0));
        arrayList6.add(new e(0, 10, 0, 0, 24));
        arrayList4.add(new e(7, 24, 12, 12, 0));
        arrayList4.add(new e(3, 38, 26, 0, 0));
        arrayList4.add(new e(5, 38, 0, 12, 0));
        arrayList4.add(new e(1, 38, 24, 0, 0));
        arrayList4.add(new e(6, 0, 26, 12, 0));
        arrayList4.add(new e(2, 0, 0, 0, 0));
        arrayList4.add(new e(4, 0, 0, 0, 0));
        arrayList4.add(new e(0, 10, 0, 0, 24));
        arrayList5.add(new e(7, 24, 12, 0, 0));
        arrayList5.add(new e(3, 24, 12, 0, 0));
        arrayList5.add(new e(5, 24, 0, 0, 0));
        arrayList5.add(new e(1, 24, 0, 0, 24));
        arrayList5.add(new e(6, 0, 0, 0, 0));
        arrayList5.add(new e(2, 0, 0, 0, 0));
        arrayList5.add(new e(4, 0, 0, 0, 0));
        arrayList5.add(new e(0, 10, 0, 0, 24));
    }

    public StepOSAlertController(Context context, p pVar, Window window) {
        int i10;
        super(context, pVar);
        this.f12048p = false;
        this.D = 0;
        this.L = -1;
        this.R = 0;
        this.b0 = true;
        this.f12031d0 = 1;
        this.f12037g0 = true;
        this.f12042j0 = new a();
        this.f12030d = context;
        this.f12032e = pVar;
        this.f12034f = window;
        c cVar = new c();
        cVar.f12059a = new WeakReference<>(pVar);
        this.S = cVar;
        this.f12038h0 = new com.stepos.common.animator.g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, ce.a.f3413b, R.attr.alertDialogStyle, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        typedArrayObtainStyledAttributes.getResourceId(11, 0);
        this.P = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        this.Q = true;
        this.f12036g = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, l8.g.a(context, 48.0f));
        typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.T = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.V = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.W = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, 0);
        this.X = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, 0);
        this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, 0);
        this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, 0);
        typedArrayObtainStyledAttributes.recycle();
        pVar.supportRequestWindowFeature(1);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            i10 = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i10 = displayMetrics.widthPixels;
        }
        this.U = Math.min(i10, l()) - (context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_margin_bottom_to_screen) * 2);
        this.f12040i0 = 1.0f;
        this.f12033e0 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_divider_height);
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
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View viewK = k(viewGroup.getChildAt(i10));
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
        if (viewGroup.getId() != R.id.customPanel) {
            return o(viewGroup);
        }
        return false;
    }

    public static boolean p(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
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

    @Override // stepos.support.v7.app.c
    public final void a(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.S.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.z = charSequence;
            this.A = message;
            this.B = drawable;
        } else if (i10 == -2) {
            this.f12053v = charSequence;
            this.f12054w = message;
            this.f12055x = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.r = charSequence;
            this.f12050s = message;
            this.f12051t = drawable;
        }
    }

    @Override // stepos.support.v7.app.c
    public final void b(int i10) {
        this.E = null;
        this.D = i10;
        ImageView imageView = this.F;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.F.setImageResource(this.D);
            }
        }
    }

    @Override // stepos.support.v7.app.c
    public final void c(Drawable drawable) {
        this.E = drawable;
        this.D = 0;
        ImageView imageView = this.F;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.F.setImageDrawable(drawable);
            }
        }
    }

    public final void d(View view) {
        com.stepos.common.animator.g gVar = this.f12038h0;
        if (gVar == null || this.T || this.f12041j != null || !this.f12037g0) {
            return;
        }
        gVar.a(view, false);
    }

    public final void e(Button button, int i10, int i11, boolean z) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = h(i11);
        Context context = this.f12030d;
        layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_horizontal_button_height);
        button.setGravity(17);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i10 == 4) {
            if ((i11 & 2) != 0) {
                layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
            }
        } else if (i10 == 1 && ((i11 & 2) != 0 || (i11 & 4) != 0)) {
            layoutParams.setMarginStart(context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start));
        }
        if (!z) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i12 = this.f12031d0;
        if (i12 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i12 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i12 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final void f(Button button, int i10, int i11, boolean z) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        Context context = this.f12030d;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.T || this.f12041j != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_action_button_height);
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_rectange);
            this.f12038h0.b(button, 2, false);
            return;
        }
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int i12 = this.U - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i12;
        layoutParams2.height = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_vertical_button_height);
        if (i10 == 4) {
            if ((i11 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i10 == 2 && ((i11 & 4) != 0 || (i11 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i13 = this.f12031d0;
        if (i13 == 2) {
            button.setTextColor(context.getResources().getColor(R.color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i13 == 1) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i13 == 3) {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R.drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final int g(int i10) {
        int i11 = this.c0;
        if (i11 == -1 && (i10 & 1) != 0) {
            return 1;
        }
        if (i11 == -2 && (i10 & 2) != 0) {
            return 2;
        }
        if (i11 == -3 && (i10 & 4) != 0) {
            return 4;
        }
        if ((i10 & 1) != 0) {
            return 1;
        }
        if ((i10 & 4) != 0) {
            return 4;
        }
        return (i10 & 2) != 0 ? 2 : 0;
    }

    public final int h(int i10) throws Resources.NotFoundException {
        Context context = this.f12030d;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_button_margin_start);
        int i11 = (i10 & 4) != 0 ? 1 : 0;
        if ((i10 & 2) != 0) {
            i11++;
        }
        if ((i10 & 1) != 0) {
            i11++;
        }
        int i12 = this.U;
        if (i11 == 0) {
            return i12 - (dimensionPixelOffset * 2);
        }
        return ((i12 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (i11 > 0 ? i11 - 1 : 0))) / i11;
    }

    public final int l() {
        Context context = this.f12030d;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int n() {
        int i10;
        int i11;
        ImageView imageView;
        int i12 = 0;
        if (TextUtils.isEmpty(this.h)) {
            i10 = 0;
            i11 = 0;
        } else {
            View viewFindViewById = this.f12034f.findViewById(R.id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i13 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            i11 = layoutParams2.leftMargin + layoutParams2.rightMargin + i13;
            int paddingRight = viewFindViewById.getPaddingRight() + viewFindViewById.getPaddingLeft() + this.G.getPaddingRight() + this.G.getPaddingLeft();
            if ((this.D != 0 || this.E != null) && (imageView = this.F) != null && imageView.getVisibility() == 0) {
                int paddingRight2 = this.F.getPaddingRight() + this.F.getPaddingLeft() + this.f12030d.getResources().getDimensionPixelSize(R.dimen.stepos_alert_dialog_title_icon_width);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.F.getLayoutParams();
                i12 = layoutParams3.leftMargin + layoutParams3.rightMargin + paddingRight2;
            }
            int i14 = i12;
            i12 = paddingRight;
            i10 = i14;
        }
        return this.U - ((i12 + i11) + i10);
    }
}
