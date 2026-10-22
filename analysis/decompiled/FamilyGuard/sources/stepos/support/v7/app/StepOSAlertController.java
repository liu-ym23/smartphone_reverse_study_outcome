package stepos.support.v7.app;

import a1.C0409b;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import g.C0728a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stepos.support.v7.app.b;
import stepos.support.v7.widget.StepOSAlertDialogLayout;
import stepos.support.v7.widget.StepOSMultiLinesCheckLayout;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
class StepOSAlertController extends stepos.support.v7.app.b {

    /* renamed from: U0, reason: collision with root package name */
    private static List<k> f20513U0 = new ArrayList();

    /* renamed from: V0, reason: collision with root package name */
    private static List<k> f20514V0 = new ArrayList();

    /* renamed from: W0, reason: collision with root package name */
    private static List<k> f20515W0 = new ArrayList();

    /* renamed from: X0, reason: collision with root package name */
    private static List<k> f20516X0 = new ArrayList();

    /* renamed from: Y0, reason: collision with root package name */
    private static List<k> f20517Y0 = new ArrayList();

    /* renamed from: Z0, reason: collision with root package name */
    private static List<k> f20518Z0 = new ArrayList();

    /* renamed from: A0, reason: collision with root package name */
    private boolean f20519A0;

    /* renamed from: B0, reason: collision with root package name */
    private int f20520B0;

    /* renamed from: C0, reason: collision with root package name */
    private boolean f20521C0;

    /* renamed from: D, reason: collision with root package name */
    private final Context f20522D;

    /* renamed from: D0, reason: collision with root package name */
    private int f20523D0;

    /* renamed from: E, reason: collision with root package name */
    final stepos.support.v7.app.l f20524E;

    /* renamed from: E0, reason: collision with root package name */
    private int f20525E0;

    /* renamed from: F, reason: collision with root package name */
    private final Window f20526F;

    /* renamed from: F0, reason: collision with root package name */
    private int f20527F0;

    /* renamed from: G, reason: collision with root package name */
    private final int f20528G;

    /* renamed from: G0, reason: collision with root package name */
    private int f20529G0;

    /* renamed from: H, reason: collision with root package name */
    private CharSequence f20530H;

    /* renamed from: H0, reason: collision with root package name */
    private int f20531H0;

    /* renamed from: I, reason: collision with root package name */
    private CharSequence f20532I;

    /* renamed from: I0, reason: collision with root package name */
    private int f20533I0;

    /* renamed from: J, reason: collision with root package name */
    ListView f20534J;

    /* renamed from: J0, reason: collision with root package name */
    private boolean f20535J0;

    /* renamed from: K, reason: collision with root package name */
    private View f20536K;

    /* renamed from: K0, reason: collision with root package name */
    private int f20537K0;

    /* renamed from: L, reason: collision with root package name */
    private int f20538L;

    /* renamed from: L0, reason: collision with root package name */
    private int f20539L0;

    /* renamed from: M, reason: collision with root package name */
    private int f20540M;

    /* renamed from: M0, reason: collision with root package name */
    private int f20541M0;

    /* renamed from: N, reason: collision with root package name */
    private int f20542N;

    /* renamed from: N0, reason: collision with root package name */
    private boolean f20543N0;

    /* renamed from: O, reason: collision with root package name */
    private int f20544O;

    /* renamed from: O0, reason: collision with root package name */
    private int f20545O0;

    /* renamed from: P, reason: collision with root package name */
    private int f20546P;

    /* renamed from: P0, reason: collision with root package name */
    private boolean f20547P0;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f20548Q;

    /* renamed from: Q0, reason: collision with root package name */
    private boolean f20549Q0;

    /* renamed from: R, reason: collision with root package name */
    Button f20550R;

    /* renamed from: R0, reason: collision with root package name */
    I1.f f20551R0;

    /* renamed from: S, reason: collision with root package name */
    private CharSequence f20552S;

    /* renamed from: S0, reason: collision with root package name */
    private float f20553S0;

    /* renamed from: T, reason: collision with root package name */
    Message f20554T;

    /* renamed from: T0, reason: collision with root package name */
    private final View.OnClickListener f20555T0;

    /* renamed from: U, reason: collision with root package name */
    private Drawable f20556U;

    /* renamed from: V, reason: collision with root package name */
    Button f20557V;

    /* renamed from: W, reason: collision with root package name */
    private CharSequence f20558W;

    /* renamed from: X, reason: collision with root package name */
    Message f20559X;

    /* renamed from: Y, reason: collision with root package name */
    private Drawable f20560Y;

    /* renamed from: Z, reason: collision with root package name */
    Button f20561Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence f20562a0;

    /* renamed from: b0, reason: collision with root package name */
    Message f20563b0;

    /* renamed from: c0, reason: collision with root package name */
    private Drawable f20564c0;

    /* renamed from: d0, reason: collision with root package name */
    NestedScrollView f20565d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f20566e0;

    /* renamed from: f0, reason: collision with root package name */
    private Drawable f20567f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f20568g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f20569h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f20570i0;

    /* renamed from: j0, reason: collision with root package name */
    private MovementMethod f20571j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f20572k0;

    /* renamed from: l0, reason: collision with root package name */
    ListAdapter f20573l0;

    /* renamed from: m0, reason: collision with root package name */
    int f20574m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f20575n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f20576o0;

    /* renamed from: p0, reason: collision with root package name */
    int f20577p0;

    /* renamed from: q0, reason: collision with root package name */
    int f20578q0;

    /* renamed from: r0, reason: collision with root package name */
    int f20579r0;

    /* renamed from: s0, reason: collision with root package name */
    int f20580s0;

    /* renamed from: t0, reason: collision with root package name */
    int f20581t0;

    /* renamed from: u0, reason: collision with root package name */
    int f20582u0;

    /* renamed from: v0, reason: collision with root package name */
    int f20583v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f20584w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f20585x0;

    /* renamed from: y0, reason: collision with root package name */
    Handler f20586y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f20587z0;

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z5, boolean z6) {
            if (z6 && z5) {
                return;
            }
            setPadding(getPaddingLeft(), z5 ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z6 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            StepOSAlertController stepOSAlertController = StepOSAlertController.this;
            Message messageObtain = (view != stepOSAlertController.f20550R || (message3 = stepOSAlertController.f20554T) == null) ? (view != stepOSAlertController.f20557V || (message2 = stepOSAlertController.f20559X) == null) ? (view != stepOSAlertController.f20561Z || (message = stepOSAlertController.f20563b0) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            StepOSAlertController stepOSAlertController2 = StepOSAlertController.this;
            stepOSAlertController2.f20586y0.obtainMessage(1, stepOSAlertController2.f20524E).sendToTarget();
        }
    }

    class b implements NestedScrollView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f20589a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20590b;

        b(View view, View view2) {
            this.f20589a = view;
            this.f20590b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
            StepOSAlertController.b0(nestedScrollView, this.f20589a, this.f20590b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f20592a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20593b;

        c(View view, View view2) {
            this.f20592a = view;
            this.f20593b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSAlertController.b0(StepOSAlertController.this.f20565d0, this.f20592a, this.f20593b);
        }
    }

    class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f20595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20596b;

        d(View view, View view2) {
            this.f20595a = view;
            this.f20596b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
            StepOSAlertController.b0(absListView, this.f20595a, this.f20596b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i5) {
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f20598a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f20599b;

        e(View view, View view2) {
            this.f20598a = view;
            this.f20599b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSAlertController.b0(StepOSAlertController.this.f20534J, this.f20598a, this.f20599b);
        }
    }

    class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f20601a;

        f(TextView textView) {
            this.f20601a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f20601a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f20601a.setGravity(this.f20601a.getLineCount() > 1 ? 8388611 : 17);
        }
    }

    private static final class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f20640a;

        public h(DialogInterface dialogInterface) {
            this.f20640a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == -3 || i5 == -2 || i5 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f20640a.get(), message.what);
            } else {
                if (i5 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class i extends ArrayAdapter<CharSequence> {
        public i(Context context, int i5, int i6, CharSequence[] charSequenceArr) {
            super(context, i5, i6, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    private static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f20647a;

        /* renamed from: b, reason: collision with root package name */
        private int f20648b;

        /* renamed from: c, reason: collision with root package name */
        private int f20649c;

        /* renamed from: d, reason: collision with root package name */
        private int f20650d;

        /* renamed from: e, reason: collision with root package name */
        private int f20651e;

        public k(int i5, int i6, int i7, int i8, int i9) {
            this.f20647a = i5;
            this.f20648b = i6;
            this.f20649c = i7;
            this.f20650d = i8;
            this.f20651e = i9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Context context, View view, View view2, View view3, View view4) {
            if (view != null) {
                view.getLayoutParams().height = StepOSAlertController.O(context, this.f20648b);
            }
            if (view2 != null) {
                view2.getLayoutParams().height = StepOSAlertController.O(context, this.f20649c);
            }
            if (view3 != null) {
                view3.getLayoutParams().height = StepOSAlertController.O(context, this.f20650d);
            }
            if (view4 != null) {
                view4.getLayoutParams().height = StepOSAlertController.O(context, this.f20651e);
            }
        }
    }

    private static class l {

        /* renamed from: a, reason: collision with root package name */
        public TextView f20652a;

        private l() {
        }

        /* synthetic */ l(a aVar) {
            this();
        }
    }

    static {
        f20513U0.add(new k(7, 38, 24, 38, 24));
        f20513U0.add(new k(3, 38, 22, 0, 24));
        f20513U0.add(new k(5, 38, 0, 38, 24));
        f20513U0.add(new k(1, 38, 0, 0, 24));
        f20513U0.add(new k(6, 0, 26, 38, 24));
        f20513U0.add(new k(2, 0, 0, 0, 0));
        f20513U0.add(new k(4, 0, 0, 10, 24));
        f20513U0.add(new k(0, 10, 0, 0, 24));
        f20514V0.add(new k(7, 38, 22, 38, 24));
        f20514V0.add(new k(3, 38, 6, 0, 24));
        f20514V0.add(new k(5, 38, 0, 38, 24));
        f20514V0.add(new k(1, 38, 0, 0, 24));
        f20514V0.add(new k(6, 0, 26, 38, 24));
        f20514V0.add(new k(2, 0, 0, 0, 0));
        f20514V0.add(new k(4, 0, 0, 10, 24));
        f20514V0.add(new k(0, 10, 0, 0, 24));
        f20515W0.add(new k(7, 38, 38, 38, 24));
        f20515W0.add(new k(3, 38, 22, 0, 24));
        f20515W0.add(new k(5, 38, 0, 38, 24));
        f20515W0.add(new k(1, 38, 0, 0, 24));
        f20515W0.add(new k(6, 0, 0, 38, 24));
        f20515W0.add(new k(2, 0, 0, 0, 0));
        f20515W0.add(new k(4, 0, 0, 10, 24));
        f20515W0.add(new k(0, 10, 0, 0, 24));
        f20518Z0.add(new k(7, 38, 22, 12, 0));
        f20518Z0.add(new k(3, 38, 26, 0, 0));
        f20518Z0.add(new k(5, 38, 0, 12, 0));
        f20518Z0.add(new k(1, 38, 24, 0, 0));
        f20518Z0.add(new k(6, 0, 26, 12, 0));
        f20518Z0.add(new k(2, 0, 0, 0, 0));
        f20518Z0.add(new k(4, 0, 0, 0, 0));
        f20518Z0.add(new k(0, 10, 0, 0, 24));
        f20516X0.add(new k(7, 24, 12, 12, 0));
        f20516X0.add(new k(3, 38, 26, 0, 0));
        f20516X0.add(new k(5, 38, 0, 12, 0));
        f20516X0.add(new k(1, 38, 24, 0, 0));
        f20516X0.add(new k(6, 0, 26, 12, 0));
        f20516X0.add(new k(2, 0, 0, 0, 0));
        f20516X0.add(new k(4, 0, 0, 0, 0));
        f20516X0.add(new k(0, 10, 0, 0, 24));
        f20517Y0.add(new k(7, 24, 12, 0, 0));
        f20517Y0.add(new k(3, 24, 12, 0, 0));
        f20517Y0.add(new k(5, 24, 0, 0, 0));
        f20517Y0.add(new k(1, 24, 0, 0, 24));
        f20517Y0.add(new k(6, 0, 0, 0, 0));
        f20517Y0.add(new k(2, 0, 0, 0, 0));
        f20517Y0.add(new k(4, 0, 0, 0, 0));
        f20517Y0.add(new k(0, 10, 0, 0, 24));
    }

    public StepOSAlertController(Context context, stepos.support.v7.app.l lVar, Window window) {
        super(context, lVar, window);
        this.f20548Q = false;
        this.f20566e0 = 0;
        this.f20574m0 = -1;
        this.f20585x0 = 0;
        this.f20535J0 = true;
        this.f20539L0 = 1;
        this.f20549Q0 = true;
        this.f20555T0 = new a();
        this.f20522D = context;
        this.f20524E = lVar;
        this.f20526F = window;
        this.f20586y0 = new h(lVar);
        this.f20551R0 = new I1.f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, X4.l.f6304l, C0728a.f16839p, 0);
        this.f20575n0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17012G, 0);
        this.f20576o0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17022I, 0);
        this.f20577p0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17030K, 0);
        this.f20578q0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17034L, 0);
        this.f20579r0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17042N, 0);
        this.f20583v0 = typedArrayObtainStyledAttributes.getResourceId(g.j.f17026J, 0);
        this.f20580s0 = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6316n, 0);
        this.f20581t0 = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6322o, 0);
        this.f20582u0 = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6328p, 0);
        this.f20584w0 = true;
        this.f20528G = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6340r, O(context, 48.0f));
        this.f20587z0 = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6310m, 0);
        this.f20519A0 = typedArrayObtainStyledAttributes.getBoolean(X4.l.f6334q, false);
        this.f20521C0 = typedArrayObtainStyledAttributes.getBoolean(X4.l.f6346s, false);
        this.f20523D0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6352t, 0);
        this.f20525E0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6358u, 0);
        this.f20527F0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6364v, 0);
        this.f20529G0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6370w, 0);
        typedArrayObtainStyledAttributes.recycle();
        lVar.supportRequestWindowFeature(1);
        this.f20520B0 = Math.min(S(), R()) - (context.getResources().getDimensionPixelOffset(X4.d.f5872I) * 2);
        this.f20553S0 = 1.0f;
        this.f20541M0 = context.getResources().getDimensionPixelOffset(X4.d.f5869F);
    }

    private void A(View view, boolean z5) {
        I1.f fVar = this.f20551R0;
        if (fVar == null || this.f20519A0 || this.f20534J != null || this.f20547P0 || !this.f20549Q0) {
            return;
        }
        fVar.e(view, z5);
    }

    private int[] B() {
        int i5 = -1;
        Button buttonA = a(-1);
        Button buttonA2 = a(-2);
        Button buttonA3 = a(-3);
        int i6 = 0;
        if (buttonA != null && !TextUtils.isEmpty(buttonA.getText())) {
            i5 = 0;
        }
        if (buttonA2 != null && !TextUtils.isEmpty(buttonA2.getText())) {
            i5++;
        }
        if (buttonA3 != null && !TextUtils.isEmpty(buttonA3.getText())) {
            i5++;
        }
        if (i5 > 0) {
            if (buttonA == null || TextUtils.isEmpty(buttonA.getText())) {
                buttonA = (buttonA2 == null || TextUtils.isEmpty(buttonA2.getText())) ? buttonA3 : buttonA2;
            }
            ViewGroup viewGroup = (ViewGroup) buttonA.getParent();
            if ((viewGroup instanceof LinearLayout) && ((LinearLayout) viewGroup).getOrientation() == 1) {
                i6 = 1;
            }
        }
        return new int[]{i5, i6};
    }

    private void C(Button button, int i5, int i6, boolean z5) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = J(i6);
        layoutParams.height = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5870G);
        button.setGravity(17);
        int dimensionPixelOffset = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5868E);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i5 == 4) {
            if ((i6 & 2) != 0) {
                layoutParams.setMarginStart(this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5867D));
            }
        } else if (i5 == 1 && ((i6 & 2) != 0 || (i6 & 4) != 0)) {
            layoutParams.setMarginStart(this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5867D));
        }
        if (!z5) {
            button.setBackgroundResource(X4.e.f5931e);
            return;
        }
        int i7 = this.f20539L0;
        if (i7 == 2) {
            button.setTextColor(this.f20522D.getResources().getColor(X4.c.f5858d));
            button.setBackgroundResource(X4.e.f5934h);
        } else if (i7 == 1) {
            button.setBackgroundResource(X4.e.f5932f);
        } else if (i7 == 3) {
            button.setBackgroundResource(X4.e.f5933g);
        } else {
            button.setBackgroundResource(X4.e.f5931e);
        }
    }

    private void D(TextView textView) {
        TypedArray typedArrayObtainStyledAttributes = this.f20522D.obtainStyledAttributes(null, new int[]{R.attr.textAppearance}, H1.c.f2068o, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, H1.l.f2374f);
        typedArrayObtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f20522D, resourceId);
    }

    private void F(TextView textView) {
        TypedArray typedArrayObtainStyledAttributes = this.f20522D.obtainStyledAttributes(null, new int[]{R.attr.textAppearance}, R.attr.windowTitleStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, H1.l.f2375g);
        typedArrayObtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f20522D, resourceId);
    }

    private void G(Button button, int i5, int i6, boolean z5) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        int dimensionPixelOffset = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5868E);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.f20519A0 || this.f20534J != null || this.f20547P0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5876M);
            button.setBackgroundResource(X4.e.f5935i);
            this.f20551R0.f(button, false, I1.f.f2930f);
            return;
        }
        int dimensionPixelOffset2 = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5873J);
        int dimensionPixelOffset3 = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5867D);
        int i7 = this.f20520B0 - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i7;
        layoutParams2.height = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5877N);
        if (i5 == 4) {
            if ((i6 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i5 == 2 && ((i6 & 4) != 0 || (i6 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z5) {
            button.setBackgroundResource(X4.e.f5931e);
            return;
        }
        int i8 = this.f20539L0;
        if (i8 == 2) {
            button.setTextColor(this.f20522D.getResources().getColor(X4.c.f5858d));
            button.setBackgroundResource(X4.e.f5934h);
        } else if (i8 == 1) {
            button.setBackgroundResource(X4.e.f5932f);
        } else if (i8 == 3) {
            button.setBackgroundResource(X4.e.f5933g);
        } else {
            button.setBackgroundResource(X4.e.f5931e);
        }
    }

    private int H(int i5) {
        int i6 = (i5 & 4) != 0 ? 1 : 0;
        if ((i5 & 2) != 0) {
            i6++;
        }
        return (i5 & 1) != 0 ? i6 + 1 : i6;
    }

    private int I(int i5) {
        int i6 = this.f20537K0;
        if (i6 == -1 && (i5 & 1) != 0) {
            return 1;
        }
        if (i6 == -2 && (i5 & 2) != 0) {
            return 2;
        }
        if (i6 == -3 && (i5 & 4) != 0) {
            return 4;
        }
        if ((i5 & 1) != 0) {
            return 1;
        }
        if ((i5 & 4) != 0) {
            return 4;
        }
        return (i5 & 2) != 0 ? 2 : 0;
    }

    private int J(int i5) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5873J);
        int dimensionPixelOffset2 = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5867D);
        int iH = H(i5);
        if (iH == 0) {
            return this.f20520B0 - (dimensionPixelOffset * 2);
        }
        return ((this.f20520B0 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (iH > 0 ? iH - 1 : 0))) / iH;
    }

    static boolean K(View view) {
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
            if (K(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void L(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", Boolean.TYPE).invoke(textView, Boolean.FALSE);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private double M() {
        int i5;
        ListAdapter adapter;
        double dCeil = this.f20530H != null ? 0.106d + (((int) Math.ceil(r0.length() / 15.0d)) * 0.03d) : 0.106d;
        if (this.f20532I != null) {
            dCeil += ((int) Math.ceil(r0.length() / 19.0d)) * 0.023d;
        }
        if (this.f20543N0) {
            dCeil += 0.3d;
        }
        if (this.f20572k0 != null) {
            dCeil += 0.1d;
        }
        ListView listViewC = c();
        if (listViewC != null && (adapter = listViewC.getAdapter()) != null) {
            dCeil += adapter.getCount() * 0.063d;
        }
        int i6 = this.f20545O0;
        if (i6 > 0) {
            dCeil = (dCeil + (i6 * 0.11d)) - 0.3d;
        }
        int[] iArrB = B();
        int i7 = iArrB[1];
        return ((i7 != 0 || iArrB[0] <= 0) && i7 == 1 && (i5 = iArrB[0]) > 0) ? dCeil + (i5 * 0.063d) : dCeil;
    }

    private ColorStateList N(int i5) throws Resources.NotFoundException {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[0]}, new int[]{this.f20522D.getResources().getColor(i5), Color.argb(77, 0, 0, 0)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int O(Context context, float f5) {
        return N1.j.a(context, f5);
    }

    private View P(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                View viewP = P(viewGroup.getChildAt(i5));
                if (viewP != null) {
                    return viewP;
                }
            }
        }
        return null;
    }

    private int Q(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            return ((ViewGroup) childAt).getChildCount();
        }
        return 0;
    }

    private int R() {
        WindowManager windowManager = (WindowManager) this.f20522D.getSystemService("window");
        if (windowManager == null) {
            return this.f20522D.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int S() {
        WindowManager windowManager = (WindowManager) this.f20522D.getSystemService("window");
        if (windowManager == null) {
            return this.f20522D.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    private int T(TextView textView, CharSequence charSequence) {
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

    private int U() {
        int i5;
        int i6;
        ImageView imageView;
        int i7 = 0;
        if (TextUtils.isEmpty(this.f20530H)) {
            i5 = 0;
            i6 = 0;
        } else {
            View viewFindViewById = this.f20526F.findViewById(X4.f.f6020u0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i8 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20569h0.getLayoutParams();
            i6 = i8 + layoutParams2.leftMargin + layoutParams2.rightMargin;
            int paddingLeft = this.f20569h0.getPaddingLeft() + this.f20569h0.getPaddingRight() + viewFindViewById.getPaddingLeft() + viewFindViewById.getPaddingRight();
            if ((this.f20566e0 != 0 || this.f20567f0 != null) && (imageView = this.f20568g0) != null && imageView.getVisibility() == 0) {
                int dimensionPixelSize = this.f20522D.getResources().getDimensionPixelSize(X4.d.f5874K) + this.f20568g0.getPaddingLeft() + this.f20568g0.getPaddingRight();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f20568g0.getLayoutParams();
                i7 = dimensionPixelSize + layoutParams3.leftMargin + layoutParams3.rightMargin;
            }
            i5 = i7;
            i7 = paddingLeft;
        }
        return this.f20520B0 - ((i7 + i6) + i5);
    }

    private boolean V() {
        View view = this.f20536K;
        if (view instanceof EditText) {
            return true;
        }
        if (view instanceof ViewGroup) {
            return Y((ViewGroup) view);
        }
        return false;
    }

    private boolean W(int i5) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5868E);
        if (H(i5) < 1) {
            return false;
        }
        int iJ = J(i5) - (dimensionPixelOffset * 2);
        Button button = this.f20550R;
        if (button != null && button.getVisibility() == 0 && T(this.f20550R, this.f20552S) > iJ) {
            return true;
        }
        Button button2 = this.f20557V;
        if (button2 != null && button2.getVisibility() == 0 && T(this.f20557V, this.f20558W) > iJ) {
            return true;
        }
        Button button3 = this.f20561Z;
        return (button3 != null && button3.getVisibility() == 0 && T(this.f20561Z, this.f20562a0) > iJ) || this.f20519A0 || this.f20534J != null || this.f20547P0;
    }

    private boolean X(View view) {
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
        if (viewGroup.getId() != X4.f.f6019u) {
            return X(viewGroup);
        }
        return false;
    }

    private boolean Y(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && Y((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    private boolean Z() {
        if (this.f20570i0 == null || TextUtils.isEmpty(this.f20532I)) {
            return true;
        }
        return this.f20532I.toString().split("\n").length <= 1 && (T(this.f20570i0, this.f20532I) + this.f20570i0.getPaddingLeft()) + this.f20570i0.getPaddingRight() <= this.f20520B0;
    }

    private boolean a0() {
        int iT;
        if (TextUtils.isEmpty(this.f20530H)) {
            iT = 0;
        } else {
            if (this.f20530H.toString().split("\n").length > 1) {
                return false;
            }
            iT = T(this.f20569h0, this.f20530H);
        }
        return iT <= U();
    }

    static void b0(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup c0(View view, View view2) {
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

    private int d0() {
        int i5 = this.f20576o0;
        return (i5 != 0 && this.f20585x0 == 1) ? i5 : this.f20575n0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(int i5) {
        this.f20545O0 = i5;
    }

    private void g0(ViewGroup viewGroup, View view, int i5, int i6) {
        View viewFindViewById = this.f20526F.findViewById(X4.f.f5962J);
        View viewFindViewById2 = this.f20526F.findViewById(X4.f.f5961I);
        if (viewFindViewById != null && (i5 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i5 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f20532I != null) {
            this.f20565d0.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.f20565d0.postDelayed(new c(viewFindViewById, viewFindViewById2), 100L);
            return;
        }
        ListView listView = this.f20534J;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f20534J.postDelayed(new e(viewFindViewById, viewFindViewById2), 100L);
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void i0(ViewGroup viewGroup) throws Resources.NotFoundException {
        int i5;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f20550R = button;
        button.setOnClickListener(this.f20555T0);
        A(this.f20550R, false);
        if (TextUtils.isEmpty(this.f20552S) && this.f20556U == null) {
            this.f20550R.setVisibility(8);
            i5 = 0;
        } else {
            this.f20550R.setText(this.f20552S);
            Drawable drawable = this.f20556U;
            if (drawable != null) {
                int i6 = this.f20528G;
                drawable.setBounds(0, 0, i6, i6);
                this.f20550R.setCompoundDrawables(this.f20556U, null, null, null);
            }
            this.f20550R.setVisibility(0);
            i5 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f20557V = button2;
        button2.setOnClickListener(this.f20555T0);
        A(this.f20557V, false);
        if (TextUtils.isEmpty(this.f20558W) && this.f20560Y == null) {
            this.f20557V.setVisibility(8);
        } else {
            this.f20557V.setText(this.f20558W);
            Drawable drawable2 = this.f20560Y;
            if (drawable2 != null) {
                int i7 = this.f20528G;
                drawable2.setBounds(0, 0, i7, i7);
                this.f20557V.setCompoundDrawables(this.f20560Y, null, null, null);
            }
            this.f20557V.setVisibility(0);
            i5 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f20561Z = button3;
        button3.setOnClickListener(this.f20555T0);
        A(this.f20561Z, false);
        if (TextUtils.isEmpty(this.f20562a0) && this.f20564c0 == null) {
            this.f20561Z.setVisibility(8);
        } else {
            this.f20561Z.setText(this.f20562a0);
            Drawable drawable3 = this.f20556U;
            if (drawable3 != null) {
                int i8 = this.f20528G;
                drawable3.setBounds(0, 0, i8, i8);
                this.f20550R.setCompoundDrawables(this.f20556U, null, null, null);
            }
            this.f20561Z.setVisibility(0);
            i5 |= 4;
        }
        if (i5 == 0) {
            viewGroup.setVisibility(8);
            return;
        }
        if (this.f20561Z.getParent() instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) this.f20561Z.getParent();
            if (!W(i5)) {
                linearLayout.setOrientation(0);
                linearLayout.setGravity(1);
                int I5 = I(i5);
                C(this.f20550R, 1, i5, 1 == I5);
                C(this.f20557V, 2, i5, 2 == I5);
                C(this.f20561Z, 4, i5, 4 == I5);
                return;
            }
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.removeAllViews();
            if (this.f20519A0 || this.f20534J != null || this.f20547P0) {
                View view = new View(this.f20522D);
                view.setBackgroundColor(this.f20522D.getResources().getColor(H1.e.f2083e));
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, this.f20541M0);
                int dimensionPixelOffset = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5873J);
                marginLayoutParams.setMargins(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                linearLayout.addView(view, marginLayoutParams);
            }
            linearLayout.addView(this.f20550R);
            linearLayout.addView(this.f20561Z);
            linearLayout.addView(this.f20557V);
            int I6 = I(i5);
            G(this.f20550R, 1, i5, 1 == I6);
            G(this.f20557V, 2, i5, 2 == I6);
            G(this.f20561Z, 4, i5, 4 == I6);
        }
    }

    private void j0(ViewGroup viewGroup) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f20526F.findViewById(X4.f.f5963K);
        this.f20565d0 = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f20565d0.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f20570i0 = textView;
        if (textView == null) {
            return;
        }
        L(textView);
        CharSequence charSequence = this.f20532I;
        if (charSequence != null) {
            this.f20570i0.setText(charSequence);
            this.f20570i0.setVisibility(0);
            MovementMethod movementMethod = this.f20571j0;
            if (movementMethod != null) {
                this.f20570i0.setMovementMethod(movementMethod);
                return;
            }
            return;
        }
        this.f20570i0.setVisibility(8);
        this.f20565d0.removeView(this.f20570i0);
        if (this.f20534J == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f20565d0.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f20565d0);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f20534J, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void k0(ViewGroup viewGroup) {
        View viewInflate = this.f20536K;
        if (viewInflate == null) {
            viewInflate = this.f20538L != 0 ? LayoutInflater.from(this.f20522D).inflate(this.f20538L, viewGroup, false) : null;
        }
        boolean z5 = viewInflate != null;
        this.f20543N0 = z5;
        if (!z5 || !K(viewInflate)) {
            this.f20526F.setFlags(131072, 131072);
        }
        if (!this.f20543N0) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f20526F.findViewById(X4.f.f6017t);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f20548Q) {
            frameLayout.setPadding(this.f20540M, this.f20542N, this.f20544O, this.f20546P);
        }
        if (this.f20534J != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void l0(View view, View view2, View view3, View view4) {
        List<k> list;
        k kVar;
        int i5 = (view == null || view.getVisibility() != 0) ? 0 : 1;
        boolean z5 = view2 != null && view2.getVisibility() == 0;
        boolean z6 = view3 != null && view3.getVisibility() == 0;
        boolean z7 = view4 != null && view4.getVisibility() == 0;
        Space space = (Space) this.f20526F.findViewById(X4.f.f6023w);
        Space space2 = (Space) this.f20526F.findViewById(X4.f.f6025x);
        Space space3 = (Space) this.f20526F.findViewById(X4.f.f6026y);
        Space space4 = (Space) this.f20526F.findViewById(X4.f.f6027z);
        int i6 = i5 | ((z5 || z6) ? 2 : 0) | (z7 ? 4 : 0);
        if (!this.f20521C0 || this.f20547P0) {
            ListView listView = this.f20534J;
            if (listView != null) {
                list = this.f20519A0 ? (listView.getAdapter() == null || this.f20534J.getAdapter().getCount() != 1) ? f20516X0 : f20517Y0 : f20518Z0;
            } else if (this.f20547P0) {
                list = f20518Z0;
            } else if (z6) {
                list = (!V() || Q((ViewGroup) this.f20526F.findViewById(X4.f.f6017t)) > 1) ? f20513U0 : f20515W0;
            } else {
                list = Z() ? f20514V0 : f20513U0;
            }
            Iterator<k> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                k next = it.next();
                if (i6 == next.f20647a) {
                    kVar = next;
                    break;
                }
            }
            if (kVar == null) {
                kVar = f20513U0.get(0);
            }
        } else {
            kVar = new k(0, this.f20523D0, this.f20525E0, this.f20527F0, this.f20529G0);
        }
        kVar.c(this.f20522D, space, space2, space3, space4);
    }

    private void m0(ViewGroup viewGroup) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f20572k0 != null) {
            viewGroup.addView(this.f20572k0, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f20526F.findViewById(X4.f.f6020u0).setVisibility(8);
            return;
        }
        this.f20568g0 = (ImageView) this.f20526F.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f20530H) || !this.f20584w0) {
            this.f20526F.findViewById(X4.f.f6020u0).setVisibility(8);
            this.f20568g0.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f20526F.findViewById(X4.f.f5993h);
        this.f20569h0 = textView;
        textView.setText(this.f20530H);
        L(this.f20569h0);
        int i5 = this.f20566e0;
        if (i5 != 0) {
            this.f20568g0.setImageResource(i5);
            return;
        }
        Drawable drawable = this.f20567f0;
        if (drawable != null) {
            this.f20568g0.setImageDrawable(drawable);
        } else {
            this.f20569h0.setPadding(this.f20568g0.getPaddingLeft(), this.f20568g0.getPaddingTop(), this.f20568g0.getPaddingRight(), this.f20568g0.getPaddingBottom());
            this.f20568g0.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n0() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        View viewFindViewById;
        ListAdapter listAdapter;
        View view;
        View viewFindViewById2;
        View viewFindViewById3 = this.f20526F.findViewById(X4.f.f5958F);
        int i5 = X4.f.f6022v0;
        View viewFindViewById4 = viewFindViewById3.findViewById(i5);
        int i6 = X4.f.f6011q;
        View viewFindViewById5 = viewFindViewById3.findViewById(i6);
        int i7 = X4.f.f6007o;
        View viewFindViewById6 = viewFindViewById3.findViewById(i7);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(X4.f.f6019u);
        k0(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i5);
        View viewFindViewById8 = viewGroup.findViewById(i6);
        View viewFindViewById9 = viewGroup.findViewById(i7);
        ViewGroup viewGroupC0 = c0(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupC02 = c0(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupC03 = c0(viewFindViewById9, viewFindViewById6);
        j0(viewGroupC02);
        i0(viewGroupC03);
        m0(viewGroupC0);
        boolean z5 = viewGroup.getVisibility() != 8;
        boolean z6 = (viewGroupC0 == null || viewGroupC0.getVisibility() == 8) ? 0 : 1;
        boolean z7 = (viewGroupC03 == null || viewGroupC03.getVisibility() == 8) ? false : true;
        if (!z7 && viewGroupC02 != null && (viewFindViewById2 = viewGroupC02.findViewById(g.f.f16913A)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z6 != 0) {
            NestedScrollView nestedScrollView = this.f20565d0;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f20532I == null && this.f20534J == null) ? null : viewGroupC0.findViewById(X4.f.f6016s0);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupC02 != null && (viewFindViewById = viewGroupC02.findViewById(X4.f.f6012q0)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f20534J;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z6, z7);
        }
        if (!z5 && !this.f20519A0 && (view = this.f20534J) == null) {
            if (view == null) {
                view = this.f20565d0;
            }
            if (view != null) {
                g0(viewGroupC02, view, (z7 ? 2 : 0) | z6, 3);
            }
        }
        ListView listView2 = this.f20534J;
        if (listView2 != null && (listAdapter = this.f20573l0) != null) {
            listView2.setAdapter(listAdapter);
            int i8 = this.f20574m0;
            if (i8 > -1) {
                listView2.setItemChecked(i8, true);
                listView2.setSelection(i8);
            }
        }
        l0(viewGroupC0, viewGroupC02, viewGroup, viewGroupC03);
    }

    private void o0(TextView textView) {
        if (textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new f(textView));
    }

    public void E() {
        View viewP;
        TextView textView = this.f20569h0;
        boolean z5 = false;
        boolean z6 = textView != null && textView.getVisibility() == 0;
        ImageView imageView = this.f20568g0;
        boolean z7 = imageView != null && imageView.getVisibility() == 0;
        if (this.f20534J != null && this.f20519A0 && z6) {
            D(this.f20569h0);
        }
        if (z6 && !z7 && a0()) {
            this.f20569h0.setGravity(17);
        }
        TextView textView2 = this.f20569h0;
        if (textView2 != null) {
            N1.l.a(textView2, U());
        }
        TextView textView3 = this.f20570i0;
        if (textView3 != null && textView3.getVisibility() == 0) {
            z5 = true;
        }
        o0(this.f20570i0);
        if (!z6 && z5) {
            F(this.f20570i0);
        }
        ListView listView = this.f20534J;
        if (listView != null && this.f20519A0) {
            listView.setDivider(null);
        }
        ViewGroup viewGroup = (ViewGroup) this.f20526F.findViewById(X4.f.f6019u);
        if (viewGroup != null && viewGroup.getVisibility() != 8 && !this.f20548Q && (viewP = P(viewGroup)) != null) {
            if (this.f20522D.getApplicationInfo().targetSdkVersion >= 28) {
                viewP.requestFocus();
            }
            if (!X(viewP)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) this.f20526F.findViewById(X4.f.f6017t)).getLayoutParams();
                layoutParams.leftMargin = this.f20522D.getResources().getDimensionPixelOffset(H1.f.f2126V);
                layoutParams.rightMargin = this.f20522D.getResources().getDimensionPixelOffset(H1.f.f2127W);
            }
        }
        WindowManager.LayoutParams attributes = this.f20526F.getAttributes();
        attributes.width = this.f20520B0;
        if (this.f20531H0 == 0) {
            this.f20531H0 = (R() - N1.i.e(this.f20522D)) - this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5872I);
        }
        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.f20526F.findViewById(X4.f.f5958F);
        if (stepOSAlertDialogLayout != null) {
            stepOSAlertDialogLayout.setMaxHeight(this.f20531H0);
        }
        int i5 = this.f20533I0;
        if (i5 != 0) {
            attributes.gravity = i5;
        } else {
            attributes.gravity = 80;
        }
        int i6 = attributes.gravity;
        if (i6 == 80) {
            attributes.y = this.f20522D.getResources().getDimensionPixelOffset(X4.d.f5872I);
        } else if (i6 == 17 && this.f20522D.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-this.f20522D.getResources().getDimensionPixelSize(N1.d.a(1, "status_bar_height"))) / 2;
        }
        if (this.f20535J0) {
            this.f20526F.setSoftInputMode(53);
        }
        this.f20526F.setElevation(0.0f);
    }

    @Override // stepos.support.v7.app.b
    public Button a(int i5) {
        if (i5 == -3) {
            return this.f20561Z;
        }
        if (i5 == -2) {
            return this.f20557V;
        }
        if (i5 != -1) {
            return null;
        }
        return this.f20550R;
    }

    @Override // stepos.support.v7.app.b
    public int b(int i5) {
        TypedValue typedValue = new TypedValue();
        this.f20522D.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // stepos.support.v7.app.b
    public ListView c() {
        return this.f20534J;
    }

    @Override // stepos.support.v7.app.b
    public void d() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f20524E.setContentView(d0());
        n0();
        E();
    }

    @Override // stepos.support.v7.app.b
    public boolean e(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f20565d0;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void e0(int i5) {
        this.f20533I0 = i5;
    }

    @Override // stepos.support.v7.app.b
    public boolean f(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f20565d0;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    @Override // stepos.support.v7.app.b
    public void g(boolean z5) {
        this.f20535J0 = z5;
    }

    @Override // stepos.support.v7.app.b
    public void h(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f20586y0.obtainMessage(i5, onClickListener);
        }
        if (i5 == -3) {
            this.f20562a0 = charSequence;
            this.f20563b0 = message;
            this.f20564c0 = drawable;
        } else if (i5 == -2) {
            this.f20558W = charSequence;
            this.f20559X = message;
            this.f20560Y = drawable;
        } else {
            if (i5 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f20552S = charSequence;
            this.f20554T = message;
            this.f20556U = drawable;
        }
    }

    public void h0() {
        Window window = this.f20524E.getWindow();
        double dM = M();
        boolean zV = V();
        StringBuilder sb = new StringBuilder();
        sb.append("setUpAnimation, hasEditText:");
        sb.append(zV);
        sb.append(",dialog type:");
        sb.append(dM < 0.33000001311302185d ? "small" : dM < 0.6499999761581421d ? "medium" : "large");
        sb.append(" heightRatio ");
        sb.append(dM);
        sb.append(" hasEditText ");
        sb.append(zV);
        Log.i("StepOSAlertController", sb.toString());
        int i5 = dM < 0.33000001311302185d ? zV ? H1.l.f2370b : H1.l.f2372d : dM < 0.6499999761581421d ? zV ? H1.l.f2369a : H1.l.f2371c : H1.l.f2373e;
        if (window != null) {
            window.setWindowAnimations(i5);
        }
    }

    @Override // stepos.support.v7.app.b
    public void i(int i5) {
        this.f20585x0 = i5;
    }

    @Override // stepos.support.v7.app.b
    public void j(int i5, int i6) {
        Button button;
        stepos.support.v7.app.l lVar = this.f20524E;
        if (!(lVar instanceof stepos.support.v7.app.c) || (button = ((stepos.support.v7.app.c) lVar).getButton(i5)) == null) {
            return;
        }
        button.setTextColor(N(i6));
    }

    @Override // stepos.support.v7.app.b
    public void k(int i5, int i6, int i7, int i8) {
        this.f20521C0 = true;
        this.f20523D0 = i5;
        this.f20525E0 = i6;
        this.f20527F0 = i7;
        this.f20529G0 = i8;
    }

    @Override // stepos.support.v7.app.b
    public void l(View view) {
        this.f20572k0 = view;
    }

    @Override // stepos.support.v7.app.b
    public void m(int i5, int i6) {
        this.f20537K0 = i5;
        this.f20539L0 = i6;
    }

    @Override // stepos.support.v7.app.b
    public void n(int i5) {
        this.f20567f0 = null;
        this.f20566e0 = i5;
        ImageView imageView = this.f20568g0;
        if (imageView != null) {
            if (i5 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f20568g0.setImageResource(this.f20566e0);
            }
        }
    }

    @Override // stepos.support.v7.app.b
    public void o(Drawable drawable) {
        this.f20567f0 = drawable;
        this.f20566e0 = 0;
        ImageView imageView = this.f20568g0;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f20568g0.setImageDrawable(drawable);
            }
        }
    }

    @Override // stepos.support.v7.app.b
    public void p(int i5) {
        this.f20531H0 = (int) (i5 * this.f20553S0);
    }

    @Override // stepos.support.v7.app.b
    public void q(CharSequence charSequence) {
        this.f20532I = charSequence;
        TextView textView = this.f20570i0;
        if (textView != null) {
            textView.setText(charSequence);
            this.f20570i0.setVisibility(0);
        }
    }

    @Override // stepos.support.v7.app.b
    public void r(MovementMethod movementMethod) {
        this.f20571j0 = movementMethod;
        TextView textView = this.f20570i0;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.b
    public void s(CharSequence charSequence) {
        this.f20530H = charSequence;
        TextView textView = this.f20569h0;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.b
    public void t(int i5) {
        this.f20536K = null;
        this.f20538L = i5;
        this.f20548Q = false;
    }

    @Override // stepos.support.v7.app.b
    public void u(View view) {
        this.f20536K = view;
        this.f20538L = 0;
        this.f20548Q = false;
    }

    @Override // stepos.support.v7.app.b
    public void v(View view, int i5, int i6, int i7, int i8) {
        this.f20536K = view;
        this.f20538L = 0;
        this.f20548Q = true;
        this.f20540M = i5;
        this.f20542N = i6;
        this.f20544O = i7;
        this.f20546P = i8;
    }

    private static class j extends ArrayAdapter {

        /* renamed from: a, reason: collision with root package name */
        Context f20641a;

        /* renamed from: b, reason: collision with root package name */
        private int f20642b;

        /* renamed from: c, reason: collision with root package name */
        private int f20643c;

        /* renamed from: d, reason: collision with root package name */
        CharSequence[] f20644d;

        /* renamed from: e, reason: collision with root package name */
        ColorStateList[] f20645e;

        /* renamed from: f, reason: collision with root package name */
        ColorStateList f20646f;

        public j(Context context, int i5, int i6, CharSequence[] charSequenceArr, ColorStateList colorStateList) {
            super(context, i5, i6, charSequenceArr);
            this.f20641a = context;
            this.f20642b = i5;
            this.f20643c = i6;
            this.f20644d = charSequenceArr;
            this.f20646f = colorStateList;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            l lVar;
            if (view == null) {
                view = ((LayoutInflater) this.f20641a.getSystemService("layout_inflater")).inflate(this.f20642b, (ViewGroup) null);
                lVar = new l(null);
                lVar.f20652a = (TextView) view.findViewById(this.f20643c);
                view.setTag(lVar);
            } else {
                lVar = (l) view.getTag();
            }
            lVar.f20652a.setText(this.f20644d[i5]);
            ColorStateList[] colorStateListArr = this.f20645e;
            if (colorStateListArr != null) {
                lVar.f20652a.setTextColor(colorStateListArr[i5]);
                return view;
            }
            ColorStateList colorStateList = this.f20646f;
            if (colorStateList != null) {
                lVar.f20652a.setTextColor(colorStateList);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public j(Context context, int i5, int i6, CharSequence[] charSequenceArr, ColorStateList[] colorStateListArr) {
            super(context, i5, i6, charSequenceArr);
            this.f20641a = context;
            this.f20642b = i5;
            this.f20643c = i6;
            this.f20644d = charSequenceArr;
            this.f20645e = colorStateListArr;
        }

        public j(Context context, int i5, int i6, CharSequence[] charSequenceArr) {
            super(context, i5, i6, charSequenceArr);
            this.f20641a = context;
            this.f20642b = i5;
            this.f20643c = i6;
            this.f20644d = charSequenceArr;
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        private b.C0241b f20603a;

        class a extends StepOSRecyclerView.g {

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ StepOSRecyclerView f20604c;

            a(StepOSRecyclerView stepOSRecyclerView) {
                this.f20604c = stepOSRecyclerView;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) != 0) {
                    rect.top = (int) N1.i.a(4.0f, this.f20604c.getContext());
                }
            }
        }

        class b extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f20606a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, int i5, int i6, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i5, i6, charSequenceArr);
                this.f20606a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i5, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i5, view, viewGroup);
                if (g.this.f20603a.f20699F != null && g.this.f20603a.f20699F[i5]) {
                    this.f20606a.setItemChecked(i5, true);
                }
                return view2;
            }
        }

        class c extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f20608a;

            /* renamed from: b, reason: collision with root package name */
            private final int f20609b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f20610c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ StepOSAlertController f20611d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(Context context, Cursor cursor, boolean z5, RecycleListView recycleListView, StepOSAlertController stepOSAlertController) {
                super(context, cursor, z5);
                this.f20610c = recycleListView;
                this.f20611d = stepOSAlertController;
                Cursor cursor2 = getCursor();
                this.f20608a = cursor2.getColumnIndexOrThrow(g.this.f20603a.f20705L);
                this.f20609b = cursor2.getColumnIndexOrThrow(g.this.f20603a.f20706M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f20608a));
                this.f20610c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f20609b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return g.this.f20603a.f20719b.inflate(this.f20611d.f20578q0, viewGroup, false);
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ StepOSAlertController f20613a;

            d(StepOSAlertController stepOSAlertController) {
                this.f20613a = stepOSAlertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                g.this.f20603a.f20741x.onClick(this.f20613a.f20524E, i5);
                if (g.this.f20603a.f20701H) {
                    return;
                }
                this.f20613a.f20524E.dismiss();
            }
        }

        class e implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f20615a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ StepOSAlertController f20616b;

            e(RecycleListView recycleListView, StepOSAlertController stepOSAlertController) {
                this.f20615a = recycleListView;
                this.f20616b = stepOSAlertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                if (g.this.f20603a.f20699F != null) {
                    g.this.f20603a.f20699F[i5] = this.f20615a.isItemChecked(i5);
                }
                g.this.f20603a.f20703J.onClick(this.f20616b.f20524E, i5, this.f20615a.isItemChecked(i5));
            }
        }

        /* renamed from: stepos.support.v7.app.StepOSAlertController$g$g, reason: collision with other inner class name */
        private static class DialogInterfaceOnClickListenerC0239g implements DialogInterface.OnClickListener {
            private DialogInterfaceOnClickListenerC0239g() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }

            /* synthetic */ DialogInterfaceOnClickListenerC0239g(a aVar) {
                this();
            }
        }

        public g(b.C0241b c0241b) {
            this.f20603a = c0241b;
        }

        private void c(StepOSAlertController stepOSAlertController) throws Resources.NotFoundException {
            StepOSAlertController stepOSAlertController2;
            ListAdapter iVar;
            int i5;
            ListAdapter simpleCursorAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f20603a.f20719b.inflate(stepOSAlertController.f20577p0, (ViewGroup) null);
            b.C0241b c0241b = this.f20603a;
            if (c0241b.f20700G) {
                i5 = stepOSAlertController.f20578q0;
                if (c0241b.f20704K == null) {
                    b.C0241b c0241b2 = this.f20603a;
                    iVar = new b(c0241b2.f20718a, stepOSAlertController.f20578q0, R.id.text1, c0241b2.f20739v, recycleListView);
                    recycleListView = recycleListView;
                    stepOSAlertController2 = stepOSAlertController;
                } else {
                    b.C0241b c0241b3 = this.f20603a;
                    stepOSAlertController2 = stepOSAlertController;
                    iVar = new c(c0241b3.f20718a, c0241b3.f20704K, false, recycleListView, stepOSAlertController2);
                }
            } else {
                stepOSAlertController2 = stepOSAlertController;
                if (c0241b.f20709P) {
                    i5 = stepOSAlertController2.f20587z0;
                    b.C0241b c0241b4 = this.f20603a;
                    if (c0241b4.f20704K == null) {
                        ListAdapter listAdapter = c0241b4.f20740w;
                        if (listAdapter != null) {
                            iVar = listAdapter;
                            i5 = 0;
                        } else if (c0241b4.f20710Q != null) {
                            Context context = this.f20603a.f20718a;
                            int i6 = stepOSAlertController2.f20587z0;
                            b.C0241b c0241b5 = this.f20603a;
                            simpleCursorAdapter = new j(context, i6, R.id.text1, c0241b5.f20739v, c0241b5.f20710Q);
                        } else if (c0241b4.f20711R != null) {
                            Context context2 = this.f20603a.f20718a;
                            int i7 = stepOSAlertController2.f20587z0;
                            b.C0241b c0241b6 = this.f20603a;
                            simpleCursorAdapter = new j(context2, i7, R.id.text1, c0241b6.f20739v, c0241b6.f20711R);
                        } else {
                            iVar = new j(this.f20603a.f20718a, stepOSAlertController2.f20587z0, R.id.text1, this.f20603a.f20739v);
                        }
                    } else {
                        Context context3 = this.f20603a.f20718a;
                        int i8 = stepOSAlertController2.f20587z0;
                        b.C0241b c0241b7 = this.f20603a;
                        simpleCursorAdapter = new SimpleCursorAdapter(context3, i8, c0241b7.f20704K, new String[]{c0241b7.f20705L}, new int[]{R.id.text1});
                    }
                    iVar = simpleCursorAdapter;
                } else {
                    int i9 = c0241b.f20701H ? stepOSAlertController2.f20579r0 : stepOSAlertController2.f20583v0;
                    if (c0241b.f20704K != null) {
                        b.C0241b c0241b8 = this.f20603a;
                        iVar = new SimpleCursorAdapter(c0241b8.f20718a, i9, c0241b8.f20704K, new String[]{c0241b8.f20705L}, new int[]{R.id.text1});
                    } else {
                        iVar = c0241b.f20740w;
                        if (iVar == null) {
                            b.C0241b c0241b9 = this.f20603a;
                            iVar = new i(c0241b9.f20718a, i9, R.id.text1, c0241b9.f20739v);
                        }
                        i5 = 0;
                    }
                    i5 = i9;
                }
            }
            this.f20603a.getClass();
            stepOSAlertController2.f20573l0 = iVar;
            b.C0241b c0241b10 = this.f20603a;
            stepOSAlertController2.f20574m0 = c0241b10.f20702I;
            if (c0241b10.f20741x != null) {
                recycleListView.setOnItemClickListener(new d(stepOSAlertController2));
            } else if (c0241b10.f20703J != null) {
                recycleListView.setOnItemClickListener(new e(recycleListView, stepOSAlertController2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f20603a.f20707N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            int dimensionPixelOffset = this.f20603a.f20718a.getResources().getDimensionPixelOffset(X4.d.f5871H);
            if (i5 > 0 && (i5 == H1.i.f2308V || i5 == H1.i.f2307U)) {
                recycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                recycleListView.setSelector(R.color.transparent);
            }
            b.C0241b c0241b11 = this.f20603a;
            if (c0241b11.f20701H) {
                recycleListView.setChoiceMode(1);
                recycleListView.setDividerHeight((int) N1.i.a(4.0f, recycleListView.getContext()));
            } else if (c0241b11.f20700G) {
                recycleListView.setChoiceMode(2);
                recycleListView.setDividerHeight((int) N1.i.a(4.0f, recycleListView.getContext()));
            }
            stepOSAlertController2.f20534J = recycleListView;
        }

        private void d(StepOSAlertController stepOSAlertController) {
            View viewInflate;
            StepOSRecyclerView stepOSRecyclerView;
            b.C0241b c0241b = this.f20603a;
            if (c0241b.f20699F == null) {
                viewInflate = LayoutInflater.from(c0241b.f20718a).inflate(stepOSAlertController.f20580s0, (ViewGroup) null);
                stepOSRecyclerView = (StepOSRecyclerView) viewInflate.findViewById(X4.f.f5964L);
                b.C0241b c0241b2 = this.f20603a;
                if (c0241b2.f20702I > c0241b2.f20716W.size()) {
                    return;
                }
                stepos.support.v7.app.l lVar = stepOSAlertController.f20524E;
                b.C0241b c0241b3 = this.f20603a;
                stepOSRecyclerView.setAdapter(new f(lVar, c0241b3.f20718a, stepOSAlertController.f20582u0, c0241b3.f20716W, c0241b3.f20702I));
            } else {
                viewInflate = LayoutInflater.from(c0241b.f20718a).inflate(stepOSAlertController.f20580s0, (ViewGroup) null);
                stepOSRecyclerView = (StepOSRecyclerView) viewInflate.findViewById(X4.f.f5964L);
                stepos.support.v7.app.l lVar2 = stepOSAlertController.f20524E;
                b.C0241b c0241b4 = this.f20603a;
                stepOSRecyclerView.setAdapter(new f(lVar2, c0241b4.f20718a, stepOSAlertController.f20581t0, c0241b4.f20716W, c0241b4.f20699F));
            }
            stepOSRecyclerView.addItemDecoration(new a(stepOSRecyclerView));
            stepOSRecyclerView.setLayoutManager(new LinearLayoutManager(this.f20603a.f20718a));
            stepOSRecyclerView.setOverScrollEnable(false);
            this.f20603a.f20743z = viewInflate;
        }

        public void b(StepOSAlertController stepOSAlertController) throws Resources.NotFoundException {
            StepOSAlertController stepOSAlertController2;
            b.C0241b c0241b = this.f20603a;
            View view = c0241b.f20724g;
            if (view != null) {
                stepOSAlertController.l(view);
            } else {
                CharSequence charSequence = c0241b.f20723f;
                if (charSequence != null) {
                    stepOSAlertController.s(charSequence);
                }
                Drawable drawable = this.f20603a.f20721d;
                if (drawable != null) {
                    stepOSAlertController.o(drawable);
                }
                int i5 = this.f20603a.f20720c;
                if (i5 != 0) {
                    stepOSAlertController.n(i5);
                }
                int i6 = this.f20603a.f20722e;
                if (i6 != 0) {
                    stepOSAlertController.n(stepOSAlertController.b(i6));
                }
            }
            CharSequence charSequence2 = this.f20603a.f20725h;
            if (charSequence2 != null) {
                stepOSAlertController.q(charSequence2);
            }
            b.C0241b c0241b2 = this.f20603a;
            CharSequence charSequence3 = c0241b2.f20726i;
            if (charSequence3 == null && c0241b2.f20727j == null) {
                stepOSAlertController2 = stepOSAlertController;
            } else {
                stepOSAlertController.h(-1, charSequence3, c0241b2.f20728k, null, c0241b2.f20727j);
                stepOSAlertController2 = stepOSAlertController;
            }
            b.C0241b c0241b3 = this.f20603a;
            CharSequence charSequence4 = c0241b3.f20729l;
            if (charSequence4 != null || c0241b3.f20730m != null) {
                stepOSAlertController2.h(-2, charSequence4, c0241b3.f20731n, null, c0241b3.f20730m);
            }
            b.C0241b c0241b4 = this.f20603a;
            CharSequence charSequence5 = c0241b4.f20732o;
            if (charSequence5 != null || c0241b4.f20733p != null) {
                stepOSAlertController2.h(-3, charSequence5, c0241b4.f20734q, null, c0241b4.f20733p);
            }
            b.C0241b c0241b5 = this.f20603a;
            a aVar = null;
            if (c0241b5.f20739v != null || c0241b5.f20704K != null || c0241b5.f20740w != null) {
                c(stepOSAlertController2);
                b.C0241b c0241b6 = this.f20603a;
                if (c0241b6.f20729l == null && c0241b6.f20730m == null && c0241b6.f20726i == null && c0241b6.f20727j == null && c0241b6.f20732o == null && c0241b6.f20733p == null) {
                    stepOSAlertController2.h(-2, c0241b6.f20718a.getText(H1.k.f2345c), new DialogInterfaceOnClickListenerC0239g(aVar), null, this.f20603a.f20730m);
                }
            }
            if (this.f20603a.f20717X) {
                stepOSAlertController2.f20547P0 = true;
                d(stepOSAlertController2);
                stepOSAlertController2.f0(this.f20603a.f20716W.size());
                stepOSAlertController2.h(-2, this.f20603a.f20718a.getText(H1.k.f2345c), new DialogInterfaceOnClickListenerC0239g(aVar), null, this.f20603a.f20730m);
            }
            b.C0241b c0241b7 = this.f20603a;
            View view2 = c0241b7.f20743z;
            if (view2 == null) {
                int i7 = c0241b7.f20742y;
                if (i7 != 0) {
                    stepOSAlertController2.t(i7);
                }
            } else if (c0241b7.f20698E) {
                stepOSAlertController2.v(view2, c0241b7.f20694A, c0241b7.f20695B, c0241b7.f20696C, c0241b7.f20697D);
            } else {
                stepOSAlertController2.u(view2);
            }
            stepOSAlertController2.e0(this.f20603a.f20712S);
            stepOSAlertController2.p(this.f20603a.f20713T);
            b.C0241b c0241b8 = this.f20603a;
            stepOSAlertController2.m(c0241b8.f20714U, c0241b8.f20715V);
        }

        private class f extends RecyclerView.Adapter {

            /* renamed from: a, reason: collision with root package name */
            private DialogInterface f20618a;

            /* renamed from: b, reason: collision with root package name */
            private final int f20619b;

            /* renamed from: c, reason: collision with root package name */
            private final LayoutInflater f20620c;

            /* renamed from: d, reason: collision with root package name */
            private final ArrayList<Pair<String, String>> f20621d;

            /* renamed from: e, reason: collision with root package name */
            private int f20622e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f20623f;

            /* renamed from: g, reason: collision with root package name */
            private boolean[] f20624g;

            class a implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ c f20626a;

                a(c cVar) {
                    this.f20626a = cVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f20626a.f20632c.setChecked(!r4.isChecked());
                    c cVar = this.f20626a;
                    cVar.f20633d.setChecked(cVar.f20632c.isChecked());
                    f fVar = f.this;
                    c cVar2 = this.f20626a;
                    fVar.n(cVar2.f20630a, cVar2.f20631b, cVar2.f20632c.isChecked());
                    if (g.this.f20603a.f20703J != null) {
                        g.this.f20603a.f20703J.onClick(f.this.f20618a, this.f20626a.getLayoutPosition(), this.f20626a.f20632c.isChecked());
                    }
                }
            }

            class b implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ d f20628a;

                b(d dVar) {
                    this.f20628a = dVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.f20622e = this.f20628a.getLayoutPosition();
                    this.f20628a.f20638d.setChecked(true);
                    if (g.this.f20603a.f20741x != null) {
                        g.this.f20603a.f20741x.onClick(f.this.f20618a, this.f20628a.getLayoutPosition());
                    }
                    f.this.notifyDataSetChanged();
                }
            }

            class c extends RecyclerView.ViewHolder {

                /* renamed from: a, reason: collision with root package name */
                TextView f20630a;

                /* renamed from: b, reason: collision with root package name */
                TextView f20631b;

                /* renamed from: c, reason: collision with root package name */
                CheckBox f20632c;

                /* renamed from: d, reason: collision with root package name */
                StepOSMultiLinesCheckLayout f20633d;

                public c(StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout) {
                    super(stepOSMultiLinesCheckLayout);
                    this.f20633d = stepOSMultiLinesCheckLayout;
                    this.f20630a = (TextView) stepOSMultiLinesCheckLayout.findViewById(X4.f.f6001l);
                    this.f20631b = (TextView) stepOSMultiLinesCheckLayout.findViewById(X4.f.f5995i);
                    this.f20632c = (CheckBox) stepOSMultiLinesCheckLayout.findViewById(X4.f.f5997j);
                }
            }

            class d extends RecyclerView.ViewHolder {

                /* renamed from: a, reason: collision with root package name */
                TextView f20635a;

                /* renamed from: b, reason: collision with root package name */
                TextView f20636b;

                /* renamed from: c, reason: collision with root package name */
                ImageView f20637c;

                /* renamed from: d, reason: collision with root package name */
                StepOSMultiLinesCheckLayout f20638d;

                public d(StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout) {
                    super(stepOSMultiLinesCheckLayout);
                    this.f20638d = stepOSMultiLinesCheckLayout;
                    this.f20635a = (TextView) stepOSMultiLinesCheckLayout.findViewById(X4.f.f6001l);
                    this.f20636b = (TextView) stepOSMultiLinesCheckLayout.findViewById(X4.f.f5995i);
                    this.f20637c = (ImageView) stepOSMultiLinesCheckLayout.findViewById(X4.f.f5999k);
                }
            }

            public f(DialogInterface dialogInterface, Context context, int i5, ArrayList<Pair<String, String>> arrayList, int i6) {
                this.f20622e = -1;
                this.f20618a = dialogInterface;
                this.f20620c = LayoutInflater.from(context);
                this.f20619b = i5;
                this.f20621d = arrayList;
                this.f20622e = i6;
                this.f20623f = false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n(TextView textView, TextView textView2, boolean z5) {
                if (z5) {
                    int iD = N1.i.d(H1.c.f2064k, g.this.f20603a.f20718a);
                    textView.setTextColor(g.this.f20603a.f20718a.getResources().getColor(iD));
                    textView2.setTextColor(g.this.f20603a.f20718a.getResources().getColor(iD));
                } else {
                    textView.setTextColor(g.this.f20603a.f20718a.getResources().getColor(N1.i.d(C0409b.f6717d, g.this.f20603a.f20718a)));
                    textView2.setTextColor(g.this.f20603a.f20718a.getResources().getColor(N1.i.d(C0409b.f6718e, g.this.f20603a.f20718a)));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f20621d.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) {
                Pair<String, String> pair = this.f20621d.get(i5);
                if (this.f20623f) {
                    c cVar = (c) viewHolder;
                    cVar.itemView.setTag(Integer.valueOf(i5));
                    cVar.itemView.setOnClickListener(new a(cVar));
                    if (this.f20624g[i5]) {
                        cVar.f20633d.setChecked(true);
                        cVar.f20632c.setChecked(!r7.isChecked());
                    }
                    n(cVar.f20630a, cVar.f20631b, cVar.f20632c.isChecked());
                    cVar.f20630a.setText((CharSequence) pair.first);
                    cVar.f20631b.setText((CharSequence) pair.second);
                    return;
                }
                d dVar = (d) viewHolder;
                dVar.itemView.setTag(Integer.valueOf(i5));
                viewHolder.itemView.setOnClickListener(new b(dVar));
                if (i5 == this.f20622e) {
                    dVar.f20637c.setVisibility(0);
                    dVar.f20638d.setChecked(true);
                } else {
                    dVar.f20637c.setVisibility(4);
                    dVar.f20638d.setChecked(false);
                }
                n(dVar.f20635a, dVar.f20636b, dVar.f20638d.a());
                dVar.f20635a.setText((CharSequence) pair.first);
                dVar.f20636b.setText((CharSequence) pair.second);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
                StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout = (StepOSMultiLinesCheckLayout) this.f20620c.inflate(this.f20619b, viewGroup, false);
                return this.f20623f ? new c(stepOSMultiLinesCheckLayout) : new d(stepOSMultiLinesCheckLayout);
            }

            public f(DialogInterface dialogInterface, Context context, int i5, ArrayList<Pair<String, String>> arrayList, boolean[] zArr) {
                this.f20622e = -1;
                this.f20618a = dialogInterface;
                this.f20620c = LayoutInflater.from(context);
                this.f20619b = i5;
                this.f20621d = arrayList;
                this.f20624g = zArr;
                this.f20623f = true;
            }
        }
    }
}
