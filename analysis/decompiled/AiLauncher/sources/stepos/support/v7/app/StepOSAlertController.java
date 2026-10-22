package stepos.support.v7.app;

import O6.v;
import android.R;
import android.annotation.SuppressLint;
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
import androidx.annotation.Keep;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.R$style;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import stepos.support.v7.app.b;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$drawable;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$styleable;
import stepos.support.v7.widget.StepOSAlertDialogLayout;
import stepos.support.v7.widget.StepOSMultiLinesCheckLayout;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes5.dex */
public class StepOSAlertController extends stepos.support.v7.app.b {

    /* renamed from: U0, reason: collision with root package name */
    public static List<k> f40251U0 = new ArrayList();

    /* renamed from: V0, reason: collision with root package name */
    public static List<k> f40252V0 = new ArrayList();

    /* renamed from: W0, reason: collision with root package name */
    public static List<k> f40253W0 = new ArrayList();

    /* renamed from: X0, reason: collision with root package name */
    public static List<k> f40254X0 = new ArrayList();

    /* renamed from: Y0, reason: collision with root package name */
    public static List<k> f40255Y0 = new ArrayList();

    /* renamed from: Z0, reason: collision with root package name */
    public static List<k> f40256Z0 = new ArrayList();

    /* renamed from: A0, reason: collision with root package name */
    public boolean f40257A0;

    /* renamed from: B0, reason: collision with root package name */
    public int f40258B0;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f40259C0;

    /* renamed from: D, reason: collision with root package name */
    public final Context f40260D;

    /* renamed from: D0, reason: collision with root package name */
    public int f40261D0;

    /* renamed from: E, reason: collision with root package name */
    public final stepos.support.v7.app.k f40262E;

    /* renamed from: E0, reason: collision with root package name */
    public int f40263E0;

    /* renamed from: F, reason: collision with root package name */
    public final Window f40264F;

    /* renamed from: F0, reason: collision with root package name */
    public int f40265F0;

    /* renamed from: G, reason: collision with root package name */
    public final int f40266G;

    /* renamed from: G0, reason: collision with root package name */
    public int f40267G0;

    /* renamed from: H, reason: collision with root package name */
    public CharSequence f40268H;

    /* renamed from: H0, reason: collision with root package name */
    public int f40269H0;

    /* renamed from: I, reason: collision with root package name */
    public CharSequence f40270I;

    /* renamed from: I0, reason: collision with root package name */
    public int f40271I0;

    /* renamed from: J, reason: collision with root package name */
    public ListView f40272J;

    /* renamed from: J0, reason: collision with root package name */
    public boolean f40273J0;

    /* renamed from: K, reason: collision with root package name */
    public View f40274K;

    /* renamed from: K0, reason: collision with root package name */
    public int f40275K0;

    /* renamed from: L, reason: collision with root package name */
    public int f40276L;

    /* renamed from: L0, reason: collision with root package name */
    public int f40277L0;

    /* renamed from: M, reason: collision with root package name */
    public int f40278M;

    /* renamed from: M0, reason: collision with root package name */
    public int f40279M0;

    /* renamed from: N, reason: collision with root package name */
    public int f40280N;

    /* renamed from: N0, reason: collision with root package name */
    public boolean f40281N0;

    /* renamed from: O, reason: collision with root package name */
    public int f40282O;

    /* renamed from: O0, reason: collision with root package name */
    public int f40283O0;

    /* renamed from: P, reason: collision with root package name */
    public int f40284P;

    /* renamed from: P0, reason: collision with root package name */
    public boolean f40285P0;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f40286Q;

    /* renamed from: Q0, reason: collision with root package name */
    public boolean f40287Q0;

    /* renamed from: R, reason: collision with root package name */
    public Button f40288R;

    /* renamed from: R0, reason: collision with root package name */
    public com.stepos.common.animator.f f40289R0;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f40290S;

    /* renamed from: S0, reason: collision with root package name */
    public float f40291S0;

    /* renamed from: T, reason: collision with root package name */
    public Message f40292T;

    /* renamed from: T0, reason: collision with root package name */
    public final View.OnClickListener f40293T0;

    /* renamed from: U, reason: collision with root package name */
    public Drawable f40294U;

    /* renamed from: V, reason: collision with root package name */
    public Button f40295V;

    /* renamed from: W, reason: collision with root package name */
    public CharSequence f40296W;

    /* renamed from: X, reason: collision with root package name */
    public Message f40297X;

    /* renamed from: Y, reason: collision with root package name */
    public Drawable f40298Y;

    /* renamed from: Z, reason: collision with root package name */
    public Button f40299Z;

    /* renamed from: a0, reason: collision with root package name */
    public CharSequence f40300a0;

    /* renamed from: b0, reason: collision with root package name */
    public Message f40301b0;

    /* renamed from: c0, reason: collision with root package name */
    public Drawable f40302c0;

    /* renamed from: d0, reason: collision with root package name */
    public NestedScrollView f40303d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f40304e0;

    /* renamed from: f0, reason: collision with root package name */
    public Drawable f40305f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageView f40306g0;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f40307h0;

    /* renamed from: i0, reason: collision with root package name */
    public TextView f40308i0;

    /* renamed from: j0, reason: collision with root package name */
    public MovementMethod f40309j0;

    /* renamed from: k0, reason: collision with root package name */
    public View f40310k0;

    /* renamed from: l0, reason: collision with root package name */
    public ListAdapter f40311l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f40312m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f40313n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f40314o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f40315p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f40316q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f40317r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f40318s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f40319t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f40320u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f40321v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f40322w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f40323x0;

    /* renamed from: y0, reason: collision with root package name */
    public Handler f40324y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f40325z0;

    @Keep
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z11 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mPaddingTopNoTitle = 0;
            this.mPaddingBottomNoButtons = 0;
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            StepOSAlertController stepOSAlertController = StepOSAlertController.this;
            Message messageObtain = (view != stepOSAlertController.f40288R || (message3 = stepOSAlertController.f40292T) == null) ? (view != stepOSAlertController.f40295V || (message2 = stepOSAlertController.f40297X) == null) ? (view != stepOSAlertController.f40299Z || (message = stepOSAlertController.f40301b0) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            StepOSAlertController stepOSAlertController2 = StepOSAlertController.this;
            stepOSAlertController2.f40324y0.obtainMessage(1, stepOSAlertController2.f40262E).sendToTarget();
        }
    }

    public class b implements NestedScrollView.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40327a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f40328b;

        public b(View view, View view2) {
            this.f40327a = view;
            this.f40328b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            StepOSAlertController.b0(nestedScrollView, this.f40327a, this.f40328b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40330a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f40331b;

        public c(View view, View view2) {
            this.f40330a = view;
            this.f40331b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSAlertController.b0(StepOSAlertController.this.f40303d0, this.f40330a, this.f40331b);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40333a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f40334b;

        public d(View view, View view2) {
            this.f40333a = view;
            this.f40334b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            StepOSAlertController.b0(absListView, this.f40333a, this.f40334b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f40336a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f40337b;

        public e(View view, View view2) {
            this.f40336a = view;
            this.f40337b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StepOSAlertController.b0(StepOSAlertController.this.f40272J, this.f40336a, this.f40337b);
        }
    }

    public class f implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f40339a;

        public f(TextView textView) {
            this.f40339a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f40339a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f40339a.setGravity(this.f40339a.getLineCount() > 1 ? 8388611 : 17);
        }
    }

    public static final class h extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f40378a;

        public h(DialogInterface dialogInterface) {
            this.f40378a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f40378a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class i extends ArrayAdapter<CharSequence> {
        public i(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public int f40385a;

        /* renamed from: b, reason: collision with root package name */
        public int f40386b;

        /* renamed from: c, reason: collision with root package name */
        public int f40387c;

        /* renamed from: d, reason: collision with root package name */
        public int f40388d;

        /* renamed from: e, reason: collision with root package name */
        public int f40389e;

        public k(int i10, int i11, int i12, int i13, int i14) {
            this.f40385a = i10;
            this.f40386b = i11;
            this.f40387c = i12;
            this.f40388d = i13;
            this.f40389e = i14;
        }

        public final void c(Context context, View view, View view2, View view3, View view4) {
            if (view != null) {
                view.getLayoutParams().height = StepOSAlertController.O(context, this.f40386b);
            }
            if (view2 != null) {
                view2.getLayoutParams().height = StepOSAlertController.O(context, this.f40387c);
            }
            if (view3 != null) {
                view3.getLayoutParams().height = StepOSAlertController.O(context, this.f40388d);
            }
            if (view4 != null) {
                view4.getLayoutParams().height = StepOSAlertController.O(context, this.f40389e);
            }
        }
    }

    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public TextView f40390a;

        public l() {
        }

        public /* synthetic */ l(a aVar) {
            this();
        }
    }

    static {
        f40251U0.add(new k(7, 38, 24, 38, 24));
        f40251U0.add(new k(3, 38, 22, 0, 24));
        f40251U0.add(new k(5, 38, 0, 38, 24));
        f40251U0.add(new k(1, 38, 0, 0, 24));
        f40251U0.add(new k(6, 0, 26, 38, 24));
        f40251U0.add(new k(2, 0, 0, 0, 0));
        f40251U0.add(new k(4, 0, 0, 10, 24));
        f40251U0.add(new k(0, 10, 0, 0, 24));
        f40252V0.add(new k(7, 38, 22, 38, 24));
        f40252V0.add(new k(3, 38, 6, 0, 24));
        f40252V0.add(new k(5, 38, 0, 38, 24));
        f40252V0.add(new k(1, 38, 0, 0, 24));
        f40252V0.add(new k(6, 0, 26, 38, 24));
        f40252V0.add(new k(2, 0, 0, 0, 0));
        f40252V0.add(new k(4, 0, 0, 10, 24));
        f40252V0.add(new k(0, 10, 0, 0, 24));
        f40253W0.add(new k(7, 38, 38, 38, 24));
        f40253W0.add(new k(3, 38, 22, 0, 24));
        f40253W0.add(new k(5, 38, 0, 38, 24));
        f40253W0.add(new k(1, 38, 0, 0, 24));
        f40253W0.add(new k(6, 0, 0, 38, 24));
        f40253W0.add(new k(2, 0, 0, 0, 0));
        f40253W0.add(new k(4, 0, 0, 10, 24));
        f40253W0.add(new k(0, 10, 0, 0, 24));
        f40256Z0.add(new k(7, 38, 22, 12, 0));
        f40256Z0.add(new k(3, 38, 26, 0, 0));
        f40256Z0.add(new k(5, 38, 0, 12, 0));
        f40256Z0.add(new k(1, 38, 24, 0, 0));
        f40256Z0.add(new k(6, 0, 26, 12, 0));
        f40256Z0.add(new k(2, 0, 0, 0, 0));
        f40256Z0.add(new k(4, 0, 0, 0, 0));
        f40256Z0.add(new k(0, 10, 0, 0, 24));
        f40254X0.add(new k(7, 24, 12, 12, 0));
        f40254X0.add(new k(3, 38, 26, 0, 0));
        f40254X0.add(new k(5, 38, 0, 12, 0));
        f40254X0.add(new k(1, 38, 24, 0, 0));
        f40254X0.add(new k(6, 0, 26, 12, 0));
        f40254X0.add(new k(2, 0, 0, 0, 0));
        f40254X0.add(new k(4, 0, 0, 0, 0));
        f40254X0.add(new k(0, 10, 0, 0, 24));
        f40255Y0.add(new k(7, 24, 12, 0, 0));
        f40255Y0.add(new k(3, 24, 12, 0, 0));
        f40255Y0.add(new k(5, 24, 0, 0, 0));
        f40255Y0.add(new k(1, 24, 0, 0, 24));
        f40255Y0.add(new k(6, 0, 0, 0, 0));
        f40255Y0.add(new k(2, 0, 0, 0, 0));
        f40255Y0.add(new k(4, 0, 0, 0, 0));
        f40255Y0.add(new k(0, 10, 0, 0, 24));
    }

    public StepOSAlertController(Context context, stepos.support.v7.app.k kVar, Window window) {
        super(context, kVar, window);
        this.f40286Q = false;
        this.f40304e0 = 0;
        this.f40312m0 = -1;
        this.f40323x0 = 0;
        this.f40273J0 = true;
        this.f40277L0 = 1;
        this.f40287Q0 = true;
        this.f40293T0 = new a();
        this.f40260D = context;
        this.f40262E = kVar;
        this.f40264F = window;
        this.f40324y0 = new h(kVar);
        this.f40289R0 = new com.stepos.common.animator.f();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f40313n0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_android_layout, 0);
        this.f40314o0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f40315p0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_listLayout, 0);
        this.f40316q0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f40317r0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f40321v0 = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_listItemLayout, 0);
        this.f40318s0 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiLinesChoiceItemLayout, 0);
        this.f40319t0 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_recyclerViewMultiLinesLayout, 0);
        this.f40320u0 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_recyclerViewMultiLinesSingleLayout, 0);
        this.f40322w0 = true;
        this.f40266G = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposButtonIconDimen, O(context, 48.0f));
        this.f40325z0 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_centerListItemLayout, 0);
        this.f40257A0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_steposActionDialog, false);
        this.f40259C0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_steposDialogCustomPadding, false);
        this.f40261D0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposDialogSpace1, 0);
        this.f40263E0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposDialogSpace2, 0);
        this.f40265F0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposDialogSpace3, 0);
        this.f40267G0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposDialogSpace4, 0);
        typedArrayObtainStyledAttributes.recycle();
        kVar.supportRequestWindowFeature(1);
        this.f40258B0 = Math.min(S(), R()) - (context.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_margin_bottom_to_screen) * 2);
        this.f40291S0 = 1.0f;
        this.f40279M0 = context.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_divider_height);
    }

    public static boolean K(View view) {
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

    public static int O(Context context, float f10) {
        return O6.t.a(context, f10);
    }

    public static void b0(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void A(View view, boolean z10) {
        com.stepos.common.animator.f fVar = this.f40289R0;
        if (fVar == null || this.f40257A0 || this.f40272J != null || this.f40285P0 || !this.f40287Q0) {
            return;
        }
        fVar.e(view, z10);
    }

    public final int[] B() {
        int i10 = -1;
        Button buttonA = a(-1);
        Button buttonA2 = a(-2);
        Button buttonA3 = a(-3);
        int i11 = 0;
        if (buttonA != null && !TextUtils.isEmpty(buttonA.getText())) {
            i10 = 0;
        }
        if (buttonA2 != null && !TextUtils.isEmpty(buttonA2.getText())) {
            i10++;
        }
        if (buttonA3 != null && !TextUtils.isEmpty(buttonA3.getText())) {
            i10++;
        }
        if (i10 > 0) {
            if (buttonA == null || TextUtils.isEmpty(buttonA.getText())) {
                buttonA = (buttonA2 == null || TextUtils.isEmpty(buttonA2.getText())) ? buttonA3 : buttonA2;
            }
            ViewGroup viewGroup = (ViewGroup) buttonA.getParent();
            if ((viewGroup instanceof LinearLayout) && ((LinearLayout) viewGroup).getOrientation() == 1) {
                i11 = 1;
            }
        }
        return new int[]{i10, i11};
    }

    public final void C(Button button, int i10, int i11, boolean z10) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = J(i11);
        layoutParams.height = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_horizontal_button_height);
        button.setGravity(17);
        int dimensionPixelOffset = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (i10 == 4) {
            if ((i11 & 2) != 0) {
                layoutParams.setMarginStart(this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_margin_start));
            }
        } else if (i10 == 1 && ((i11 & 2) != 0 || (i11 & 4) != 0)) {
            layoutParams.setMarginStart(this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_margin_start));
        }
        if (!z10) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i12 = this.f40277L0;
        if (i12 == 2) {
            button.setTextColor(this.f40260D.getResources().getColor(R$color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i12 == 1) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i12 == 3) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final void D(TextView textView) {
        TypedArray typedArrayObtainStyledAttributes = this.f40260D.obtainStyledAttributes(null, new int[]{R.attr.textAppearance}, com.stepos.common.R$attr.steposDialogMessageStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R$style.DialogWindowContent_StepOS_Light);
        typedArrayObtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f40260D, resourceId);
    }

    public void E() {
        View viewP;
        TextView textView = this.f40307h0;
        boolean z10 = false;
        boolean z11 = textView != null && textView.getVisibility() == 0;
        ImageView imageView = this.f40306g0;
        boolean z12 = imageView != null && imageView.getVisibility() == 0;
        if (this.f40272J != null && this.f40257A0 && z11) {
            D(this.f40307h0);
        }
        if (z11 && !z12 && a0()) {
            this.f40307h0.setGravity(17);
        }
        TextView textView2 = this.f40307h0;
        if (textView2 != null) {
            v.a(textView2, U());
        }
        TextView textView3 = this.f40308i0;
        if (textView3 != null && textView3.getVisibility() == 0) {
            z10 = true;
        }
        o0(this.f40308i0);
        if (!z11 && z10) {
            F(this.f40308i0);
        }
        ListView listView = this.f40272J;
        if (listView != null && this.f40257A0) {
            listView.setDivider(null);
        }
        ViewGroup viewGroup = (ViewGroup) this.f40264F.findViewById(R$id.customPanel);
        if (viewGroup != null && viewGroup.getVisibility() != 8 && !this.f40286Q && (viewP = P(viewGroup)) != null) {
            if (this.f40260D.getApplicationInfo().targetSdkVersion >= 28) {
                viewP.requestFocus();
            }
            if (!X(viewP)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((FrameLayout) this.f40264F.findViewById(R$id.custom)).getLayoutParams();
                layoutParams.leftMargin = this.f40260D.getResources().getDimensionPixelOffset(com.stepos.common.R$dimen.stepos_alert_dialog_edittext_padding_left);
                layoutParams.rightMargin = this.f40260D.getResources().getDimensionPixelOffset(com.stepos.common.R$dimen.stepos_alert_dialog_edittext_padding_right);
            }
        }
        WindowManager.LayoutParams attributes = this.f40264F.getAttributes();
        attributes.width = this.f40258B0;
        if (this.f40269H0 == 0) {
            this.f40269H0 = (R() - O6.s.d(this.f40260D)) - this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_margin_bottom_to_screen);
        }
        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.f40264F.findViewById(R$id.parentPanel);
        if (stepOSAlertDialogLayout != null) {
            stepOSAlertDialogLayout.setMaxHeight(this.f40269H0);
        }
        int i10 = this.f40271I0;
        if (i10 != 0) {
            attributes.gravity = i10;
        } else {
            attributes.gravity = 80;
        }
        int i11 = attributes.gravity;
        if (i11 == 80) {
            attributes.y = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_margin_bottom_to_screen);
        } else if (i11 == 17 && this.f40260D.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-this.f40260D.getResources().getDimensionPixelSize(O6.k.a(1, "status_bar_height"))) / 2;
        }
        if (this.f40273J0) {
            this.f40264F.setSoftInputMode(53);
        }
        this.f40264F.setElevation(0.0f);
    }

    public final void F(TextView textView) {
        TypedArray typedArrayObtainStyledAttributes = this.f40260D.obtainStyledAttributes(null, new int[]{R.attr.textAppearance}, R.attr.windowTitleStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R$style.DialogWindowTitle_StepOS_Light);
        typedArrayObtainStyledAttributes.recycle();
        textView.setTextAppearance(this.f40260D, resourceId);
    }

    public final void G(Button button, int i10, int i11, boolean z10) throws Resources.NotFoundException {
        if (button == null || button.getVisibility() != 0) {
            return;
        }
        int dimensionPixelOffset = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_padding);
        button.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        if (this.f40257A0 || this.f40272J != null || this.f40285P0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_vertical_action_button_height);
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_rectange);
            this.f40289R0.f(button, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_MASK);
            return;
        }
        int dimensionPixelOffset2 = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset3 = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_margin_start);
        int i12 = this.f40258B0 - (dimensionPixelOffset2 * 2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams2.width = i12;
        layoutParams2.height = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_vertical_button_height);
        if (i10 == 4) {
            if ((i11 & 1) != 0) {
                layoutParams2.topMargin = dimensionPixelOffset3;
            }
        } else if (i10 == 2 && ((i11 & 4) != 0 || (i11 & 1) != 0)) {
            layoutParams2.topMargin = dimensionPixelOffset3;
        }
        if (!z10) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius);
            return;
        }
        int i13 = this.f40277L0;
        if (i13 == 2) {
            button.setTextColor(this.f40260D.getResources().getColor(R$color.stepos_alert_dialog_delete_button_color));
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_red);
        } else if (i13 == 1) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_blue);
        } else if (i13 == 3) {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius_polestar);
        } else {
            button.setBackgroundResource(R$drawable.stepos_alert_dialog_button_bg_radius);
        }
    }

    public final int H(int i10) {
        int i11 = (i10 & 4) != 0 ? 1 : 0;
        if ((i10 & 2) != 0) {
            i11++;
        }
        return (i10 & 1) != 0 ? i11 + 1 : i11;
    }

    public final int I(int i10) {
        int i11 = this.f40275K0;
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

    public final int J(int i10) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_normal_margin_start);
        int dimensionPixelOffset2 = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_margin_start);
        int iH = H(i10);
        if (iH == 0) {
            return this.f40258B0 - (dimensionPixelOffset * 2);
        }
        return ((this.f40258B0 - (dimensionPixelOffset * 2)) - (dimensionPixelOffset2 * (iH > 0 ? iH - 1 : 0))) / iH;
    }

    public final void L(TextView textView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            TextView.class.getDeclaredMethod("setFallbackLineSpacing", Boolean.TYPE).invoke(textView, Boolean.FALSE);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final double M() {
        int i10;
        ListAdapter adapter;
        double dCeil = this.f40268H != null ? 0.106d + (((int) Math.ceil(r0.length() / 15.0d)) * 0.03d) : 0.106d;
        if (this.f40270I != null) {
            dCeil += ((int) Math.ceil(r0.length() / 19.0d)) * 0.023d;
        }
        if (this.f40281N0) {
            dCeil += 0.3d;
        }
        if (this.f40310k0 != null) {
            dCeil += 0.1d;
        }
        ListView listViewC = c();
        if (listViewC != null && (adapter = listViewC.getAdapter()) != null) {
            dCeil += adapter.getCount() * 0.063d;
        }
        int i11 = this.f40283O0;
        if (i11 > 0) {
            dCeil = (dCeil + (i11 * 0.11d)) - 0.3d;
        }
        int[] iArrB = B();
        int i12 = iArrB[1];
        return ((i12 != 0 || iArrB[0] <= 0) && i12 == 1 && (i10 = iArrB[0]) > 0) ? dCeil + (i10 * 0.063d) : dCeil;
    }

    public final ColorStateList N(int i10) throws Resources.NotFoundException {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[0]}, new int[]{this.f40260D.getResources().getColor(i10), Color.argb(77, 0, 0, 0)});
    }

    public final View P(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                View viewP = P(viewGroup.getChildAt(i10));
                if (viewP != null) {
                    return viewP;
                }
            }
        }
        return null;
    }

    public final int Q(ViewGroup viewGroup) {
        View childAt = viewGroup.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            return ((ViewGroup) childAt).getChildCount();
        }
        return 0;
    }

    public final int R() {
        WindowManager windowManager = (WindowManager) this.f40260D.getSystemService("window");
        if (windowManager == null) {
            return this.f40260D.getResources().getDisplayMetrics().heightPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public final int S() {
        WindowManager windowManager = (WindowManager) this.f40260D.getSystemService("window");
        if (windowManager == null) {
            return this.f40260D.getResources().getDisplayMetrics().widthPixels;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int T(TextView textView, CharSequence charSequence) {
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

    public final int U() {
        int i10;
        int i11;
        ImageView imageView;
        int i12 = 0;
        if (TextUtils.isEmpty(this.f40268H)) {
            i10 = 0;
            i11 = 0;
        } else {
            View viewFindViewById = this.f40264F.findViewById(R$id.title_template);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewFindViewById.getLayoutParams();
            int i13 = layoutParams.leftMargin + layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f40307h0.getLayoutParams();
            i11 = i13 + layoutParams2.leftMargin + layoutParams2.rightMargin;
            int paddingLeft = this.f40307h0.getPaddingLeft() + this.f40307h0.getPaddingRight() + viewFindViewById.getPaddingLeft() + viewFindViewById.getPaddingRight();
            if ((this.f40304e0 != 0 || this.f40305f0 != null) && (imageView = this.f40306g0) != null && imageView.getVisibility() == 0) {
                int dimensionPixelSize = this.f40260D.getResources().getDimensionPixelSize(R$dimen.stepos_alert_dialog_title_icon_width) + this.f40306g0.getPaddingLeft() + this.f40306g0.getPaddingRight();
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f40306g0.getLayoutParams();
                i12 = dimensionPixelSize + layoutParams3.leftMargin + layoutParams3.rightMargin;
            }
            i10 = i12;
            i12 = paddingLeft;
        }
        return this.f40258B0 - ((i12 + i11) + i10);
    }

    public final boolean V() {
        View view = this.f40274K;
        if (view instanceof EditText) {
            return true;
        }
        if (view instanceof ViewGroup) {
            return Y((ViewGroup) view);
        }
        return false;
    }

    public final boolean W(int i10) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_button_padding);
        if (H(i10) < 1) {
            return false;
        }
        int iJ = J(i10) - (dimensionPixelOffset * 2);
        Button button = this.f40288R;
        if (button != null && button.getVisibility() == 0 && T(this.f40288R, this.f40290S) > iJ) {
            return true;
        }
        Button button2 = this.f40295V;
        if (button2 != null && button2.getVisibility() == 0 && T(this.f40295V, this.f40296W) > iJ) {
            return true;
        }
        Button button3 = this.f40299Z;
        return (button3 != null && button3.getVisibility() == 0 && T(this.f40299Z, this.f40300a0) > iJ) || this.f40257A0 || this.f40272J != null || this.f40285P0;
    }

    public final boolean X(View view) {
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
        if (viewGroup.getId() != R$id.customPanel) {
            return X(viewGroup);
        }
        return false;
    }

    public final boolean Y(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof EditText) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && Y((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final boolean Z() {
        if (this.f40308i0 == null || TextUtils.isEmpty(this.f40270I)) {
            return true;
        }
        return this.f40270I.toString().split("\n").length <= 1 && (T(this.f40308i0, this.f40270I) + this.f40308i0.getPaddingLeft()) + this.f40308i0.getPaddingRight() <= this.f40258B0;
    }

    @Override // stepos.support.v7.app.b
    public Button a(int i10) {
        if (i10 == -3) {
            return this.f40299Z;
        }
        if (i10 == -2) {
            return this.f40295V;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f40288R;
    }

    public final boolean a0() {
        int iT;
        if (TextUtils.isEmpty(this.f40268H)) {
            iT = 0;
        } else {
            if (this.f40268H.toString().split("\n").length > 1) {
                return false;
            }
            iT = T(this.f40307h0, this.f40268H);
        }
        return iT <= U();
    }

    @Override // stepos.support.v7.app.b
    public int b(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f40260D.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // stepos.support.v7.app.b
    public ListView c() {
        return this.f40272J;
    }

    public final ViewGroup c0(View view, View view2) {
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

    @Override // stepos.support.v7.app.b
    public void d() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f40262E.setContentView(d0());
        n0();
        E();
    }

    public final int d0() {
        int i10 = this.f40314o0;
        return (i10 != 0 && this.f40323x0 == 1) ? i10 : this.f40313n0;
    }

    @Override // stepos.support.v7.app.b
    public boolean e(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f40303d0;
        return nestedScrollView != null && nestedScrollView.n(keyEvent);
    }

    public void e0(int i10) {
        this.f40271I0 = i10;
    }

    @Override // stepos.support.v7.app.b
    public boolean f(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f40303d0;
        return nestedScrollView != null && nestedScrollView.n(keyEvent);
    }

    public final void f0(int i10) {
        this.f40283O0 = i10;
    }

    @Override // stepos.support.v7.app.b
    public void g(boolean z10) {
        this.f40273J0 = z10;
    }

    public final void g0(ViewGroup viewGroup, View view, int i10, int i11) {
        View viewFindViewById = this.f40264F.findViewById(R$id.scrollIndicatorUp);
        View viewFindViewById2 = this.f40264F.findViewById(R$id.scrollIndicatorDown);
        if (viewFindViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f40270I != null) {
            this.f40303d0.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.f40303d0.postDelayed(new c(viewFindViewById, viewFindViewById2), 100L);
            return;
        }
        ListView listView = this.f40272J;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f40272J.postDelayed(new e(viewFindViewById, viewFindViewById2), 100L);
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    @Override // stepos.support.v7.app.b
    public void h(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f40324y0.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f40300a0 = charSequence;
            this.f40301b0 = message;
            this.f40302c0 = drawable;
        } else if (i10 == -2) {
            this.f40296W = charSequence;
            this.f40297X = message;
            this.f40298Y = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f40290S = charSequence;
            this.f40292T = message;
            this.f40294U = drawable;
        }
    }

    public void h0() {
        Window window = this.f40262E.getWindow();
        double dM = M();
        boolean zV = V();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setUpAnimation, hasEditText:");
        sb2.append(zV);
        sb2.append(",dialog type:");
        sb2.append(dM < 0.33000001311302185d ? "small" : dM < 0.6499999761581421d ? "medium" : "large");
        sb2.append(" heightRatio ");
        sb2.append(dM);
        sb2.append(" hasEditText ");
        sb2.append(zV);
        Log.i("StepOSAlertController", sb2.toString());
        int i10 = dM < 0.33000001311302185d ? zV ? R$style.Animation_StepOS_Dialog_Alert_Input_Short : R$style.Animation_StepOS_Dialog_Alert_Short : dM < 0.6499999761581421d ? zV ? R$style.Animation_StepOS_Dialog_Alert_Input_Medium : R$style.Animation_StepOS_Dialog_Alert_Medium : R$style.Animation_StepOS_Dialog_Alert_Tall;
        if (window != null) {
            window.setWindowAnimations(i10);
        }
    }

    @Override // stepos.support.v7.app.b
    public void i(int i10) {
        this.f40323x0 = i10;
    }

    public final void i0(ViewGroup viewGroup) throws Resources.NotFoundException {
        int i10;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f40288R = button;
        button.setOnClickListener(this.f40293T0);
        A(this.f40288R, false);
        if (TextUtils.isEmpty(this.f40290S) && this.f40294U == null) {
            this.f40288R.setVisibility(8);
            i10 = 0;
        } else {
            this.f40288R.setText(this.f40290S);
            Drawable drawable = this.f40294U;
            if (drawable != null) {
                int i11 = this.f40266G;
                drawable.setBounds(0, 0, i11, i11);
                this.f40288R.setCompoundDrawables(this.f40294U, null, null, null);
            }
            this.f40288R.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f40295V = button2;
        button2.setOnClickListener(this.f40293T0);
        A(this.f40295V, false);
        if (TextUtils.isEmpty(this.f40296W) && this.f40298Y == null) {
            this.f40295V.setVisibility(8);
        } else {
            this.f40295V.setText(this.f40296W);
            Drawable drawable2 = this.f40298Y;
            if (drawable2 != null) {
                int i12 = this.f40266G;
                drawable2.setBounds(0, 0, i12, i12);
                this.f40295V.setCompoundDrawables(this.f40298Y, null, null, null);
            }
            this.f40295V.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f40299Z = button3;
        button3.setOnClickListener(this.f40293T0);
        A(this.f40299Z, false);
        if (TextUtils.isEmpty(this.f40300a0) && this.f40302c0 == null) {
            this.f40299Z.setVisibility(8);
        } else {
            this.f40299Z.setText(this.f40300a0);
            Drawable drawable3 = this.f40294U;
            if (drawable3 != null) {
                int i13 = this.f40266G;
                drawable3.setBounds(0, 0, i13, i13);
                this.f40288R.setCompoundDrawables(this.f40294U, null, null, null);
            }
            this.f40299Z.setVisibility(0);
            i10 |= 4;
        }
        if (i10 == 0) {
            viewGroup.setVisibility(8);
            return;
        }
        if (this.f40299Z.getParent() instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) this.f40299Z.getParent();
            if (!W(i10)) {
                linearLayout.setOrientation(0);
                linearLayout.setGravity(1);
                int I10 = I(i10);
                C(this.f40288R, 1, i10, 1 == I10);
                C(this.f40295V, 2, i10, 2 == I10);
                C(this.f40299Z, 4, i10, 4 == I10);
                return;
            }
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            linearLayout.removeAllViews();
            if (this.f40257A0 || this.f40272J != null || this.f40285P0) {
                View view = new View(this.f40260D);
                view.setBackgroundColor(this.f40260D.getResources().getColor(com.stepos.common.R$color.fd_sys_color_outline_variant_default));
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, this.f40279M0);
                int dimensionPixelOffset = this.f40260D.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_normal_margin_start);
                marginLayoutParams.setMargins(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                linearLayout.addView(view, marginLayoutParams);
            }
            linearLayout.addView(this.f40288R);
            linearLayout.addView(this.f40299Z);
            linearLayout.addView(this.f40295V);
            int I11 = I(i10);
            G(this.f40288R, 1, i10, 1 == I11);
            G(this.f40295V, 2, i10, 2 == I11);
            G(this.f40299Z, 4, i10, 4 == I11);
        }
    }

    @Override // stepos.support.v7.app.b
    public void j(int i10, int i11) {
        Button button;
        stepos.support.v7.app.k kVar = this.f40262E;
        if (!(kVar instanceof stepos.support.v7.app.c) || (button = ((stepos.support.v7.app.c) kVar).getButton(i10)) == null) {
            return;
        }
        button.setTextColor(N(i11));
    }

    public final void j0(ViewGroup viewGroup) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f40264F.findViewById(R$id.scrollView);
        this.f40303d0 = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f40303d0.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f40308i0 = textView;
        if (textView == null) {
            return;
        }
        L(textView);
        CharSequence charSequence = this.f40270I;
        if (charSequence != null) {
            this.f40308i0.setText(charSequence);
            this.f40308i0.setVisibility(0);
            MovementMethod movementMethod = this.f40309j0;
            if (movementMethod != null) {
                this.f40308i0.setMovementMethod(movementMethod);
                return;
            }
            return;
        }
        this.f40308i0.setVisibility(8);
        this.f40303d0.removeView(this.f40308i0);
        if (this.f40272J == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f40303d0.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f40303d0);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f40272J, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // stepos.support.v7.app.b
    public void k(int i10, int i11, int i12, int i13) {
        this.f40259C0 = true;
        this.f40261D0 = i10;
        this.f40263E0 = i11;
        this.f40265F0 = i12;
        this.f40267G0 = i13;
    }

    public final void k0(ViewGroup viewGroup) {
        View viewInflate = this.f40274K;
        if (viewInflate == null) {
            viewInflate = this.f40276L != 0 ? LayoutInflater.from(this.f40260D).inflate(this.f40276L, viewGroup, false) : null;
        }
        boolean z10 = viewInflate != null;
        this.f40281N0 = z10;
        if (!z10 || !K(viewInflate)) {
            this.f40264F.setFlags(SQLiteDatabase.OPEN_SHAREDCACHE, SQLiteDatabase.OPEN_SHAREDCACHE);
        }
        if (!this.f40281N0) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f40264F.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f40286Q) {
            frameLayout.setPadding(this.f40278M, this.f40280N, this.f40282O, this.f40284P);
        }
        if (this.f40272J != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    @Override // stepos.support.v7.app.b
    public void l(View view) {
        this.f40310k0 = view;
    }

    public final void l0(View view, View view2, View view3, View view4) {
        List<k> list;
        k kVar;
        int i10 = (view == null || view.getVisibility() != 0) ? 0 : 1;
        boolean z10 = view2 != null && view2.getVisibility() == 0;
        boolean z11 = view3 != null && view3.getVisibility() == 0;
        boolean z12 = view4 != null && view4.getVisibility() == 0;
        Space space = (Space) this.f40264F.findViewById(R$id.dialogSpace1);
        Space space2 = (Space) this.f40264F.findViewById(R$id.dialogSpace2);
        Space space3 = (Space) this.f40264F.findViewById(R$id.dialogSpace3);
        Space space4 = (Space) this.f40264F.findViewById(R$id.dialogSpace4);
        int i11 = i10 | ((z10 || z11) ? 2 : 0) | (z12 ? 4 : 0);
        if (!this.f40259C0 || this.f40285P0) {
            ListView listView = this.f40272J;
            if (listView != null) {
                list = this.f40257A0 ? (listView.getAdapter() == null || this.f40272J.getAdapter().getCount() != 1) ? f40254X0 : f40255Y0 : f40256Z0;
            } else if (this.f40285P0) {
                list = f40256Z0;
            } else if (z11) {
                list = (!V() || Q((ViewGroup) this.f40264F.findViewById(R$id.custom)) > 1) ? f40251U0 : f40253W0;
            } else {
                list = Z() ? f40252V0 : f40251U0;
            }
            Iterator<k> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                k next = it.next();
                if (i11 == next.f40385a) {
                    kVar = next;
                    break;
                }
            }
            if (kVar == null) {
                kVar = f40251U0.get(0);
            }
        } else {
            kVar = new k(0, this.f40261D0, this.f40263E0, this.f40265F0, this.f40267G0);
        }
        kVar.c(this.f40260D, space, space2, space3, space4);
    }

    @Override // stepos.support.v7.app.b
    public void m(int i10, int i11) {
        this.f40275K0 = i10;
        this.f40277L0 = i11;
    }

    public final void m0(ViewGroup viewGroup) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f40310k0 != null) {
            viewGroup.addView(this.f40310k0, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f40264F.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.f40306g0 = (ImageView) this.f40264F.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f40268H) || !this.f40322w0) {
            this.f40264F.findViewById(R$id.title_template).setVisibility(8);
            this.f40306g0.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f40264F.findViewById(R$id.alertTitle);
        this.f40307h0 = textView;
        textView.setText(this.f40268H);
        L(this.f40307h0);
        int i10 = this.f40304e0;
        if (i10 != 0) {
            this.f40306g0.setImageResource(i10);
            return;
        }
        Drawable drawable = this.f40305f0;
        if (drawable != null) {
            this.f40306g0.setImageDrawable(drawable);
        } else {
            this.f40307h0.setPadding(this.f40306g0.getPaddingLeft(), this.f40306g0.getPaddingTop(), this.f40306g0.getPaddingRight(), this.f40306g0.getPaddingBottom());
            this.f40306g0.setVisibility(8);
        }
    }

    @Override // stepos.support.v7.app.b
    public void n(int i10) {
        this.f40305f0 = null;
        this.f40304e0 = i10;
        ImageView imageView = this.f40306g0;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f40306g0.setImageResource(this.f40304e0);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        View viewFindViewById;
        ListAdapter listAdapter;
        View view;
        View viewFindViewById2;
        View viewFindViewById3 = this.f40264F.findViewById(R$id.parentPanel);
        int i10 = R$id.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i10);
        int i11 = R$id.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i11);
        int i12 = R$id.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R$id.customPanel);
        k0(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i10);
        View viewFindViewById8 = viewGroup.findViewById(i11);
        View viewFindViewById9 = viewGroup.findViewById(i12);
        ViewGroup viewGroupC0 = c0(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupC02 = c0(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupC03 = c0(viewFindViewById9, viewFindViewById6);
        j0(viewGroupC02);
        i0(viewGroupC03);
        m0(viewGroupC0);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (viewGroupC0 == null || viewGroupC0.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (viewGroupC03 == null || viewGroupC03.getVisibility() == 8) ? false : true;
        if (!z12 && viewGroupC02 != null && (viewFindViewById2 = viewGroupC02.findViewById(androidx.appcompat.R$id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.f40303d0;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f40270I == null && this.f40272J == null) ? null : viewGroupC0.findViewById(R$id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupC02 != null && (viewFindViewById = viewGroupC02.findViewById(R$id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f40272J;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z11, z12);
        }
        if (!z10 && !this.f40257A0 && (view = this.f40272J) == null) {
            if (view == null) {
                view = this.f40303d0;
            }
            if (view != null) {
                g0(viewGroupC02, view, (z12 ? 2 : 0) | z11, 3);
            }
        }
        ListView listView2 = this.f40272J;
        if (listView2 != null && (listAdapter = this.f40311l0) != null) {
            listView2.setAdapter(listAdapter);
            int i13 = this.f40312m0;
            if (i13 > -1) {
                listView2.setItemChecked(i13, true);
                listView2.setSelection(i13);
            }
        }
        l0(viewGroupC0, viewGroupC02, viewGroup, viewGroupC03);
    }

    @Override // stepos.support.v7.app.b
    public void o(Drawable drawable) {
        this.f40305f0 = drawable;
        this.f40304e0 = 0;
        ImageView imageView = this.f40306g0;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f40306g0.setImageDrawable(drawable);
            }
        }
    }

    public final void o0(TextView textView) {
        if (textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(textView.getText())) {
            return;
        }
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new f(textView));
    }

    @Override // stepos.support.v7.app.b
    public void p(int i10) {
        this.f40269H0 = (int) (i10 * this.f40291S0);
    }

    @Override // stepos.support.v7.app.b
    public void q(CharSequence charSequence) {
        this.f40270I = charSequence;
        TextView textView = this.f40308i0;
        if (textView != null) {
            textView.setText(charSequence);
            this.f40308i0.setVisibility(0);
        }
    }

    @Override // stepos.support.v7.app.b
    public void r(MovementMethod movementMethod) {
        this.f40309j0 = movementMethod;
        TextView textView = this.f40308i0;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.b
    public void s(CharSequence charSequence) {
        this.f40268H = charSequence;
        TextView textView = this.f40307h0;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.b
    public void t(int i10) {
        this.f40274K = null;
        this.f40276L = i10;
        this.f40286Q = false;
    }

    @Override // stepos.support.v7.app.b
    public void u(View view) {
        this.f40274K = view;
        this.f40276L = 0;
        this.f40286Q = false;
    }

    @Override // stepos.support.v7.app.b
    public void v(View view, int i10, int i11, int i12, int i13) {
        this.f40274K = view;
        this.f40276L = 0;
        this.f40286Q = true;
        this.f40278M = i10;
        this.f40280N = i11;
        this.f40282O = i12;
        this.f40284P = i13;
    }

    public static class j extends ArrayAdapter {

        /* renamed from: a, reason: collision with root package name */
        public Context f40379a;

        /* renamed from: b, reason: collision with root package name */
        public int f40380b;

        /* renamed from: c, reason: collision with root package name */
        public int f40381c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence[] f40382d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList[] f40383e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f40384f;

        public j(Context context, int i10, int i11, CharSequence[] charSequenceArr, ColorStateList colorStateList) {
            super(context, i10, i11, charSequenceArr);
            this.f40379a = context;
            this.f40380b = i10;
            this.f40381c = i11;
            this.f40382d = charSequenceArr;
            this.f40384f = colorStateList;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            l lVar;
            if (view == null) {
                view = ((LayoutInflater) this.f40379a.getSystemService("layout_inflater")).inflate(this.f40380b, (ViewGroup) null);
                lVar = new l(null);
                lVar.f40390a = (TextView) view.findViewById(this.f40381c);
                view.setTag(lVar);
            } else {
                lVar = (l) view.getTag();
            }
            lVar.f40390a.setText(this.f40382d[i10]);
            ColorStateList[] colorStateListArr = this.f40383e;
            if (colorStateListArr != null) {
                lVar.f40390a.setTextColor(colorStateListArr[i10]);
                return view;
            }
            ColorStateList colorStateList = this.f40384f;
            if (colorStateList != null) {
                lVar.f40390a.setTextColor(colorStateList);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public j(Context context, int i10, int i11, CharSequence[] charSequenceArr, ColorStateList[] colorStateListArr) {
            super(context, i10, i11, charSequenceArr);
            this.f40379a = context;
            this.f40380b = i10;
            this.f40381c = i11;
            this.f40382d = charSequenceArr;
            this.f40383e = colorStateListArr;
        }

        public j(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
            this.f40379a = context;
            this.f40380b = i10;
            this.f40381c = i11;
            this.f40382d = charSequenceArr;
        }
    }

    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public b.C0523b f40341a;

        public class a extends StepOSRecyclerView.g {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ StepOSRecyclerView f40342c;

            public a(StepOSRecyclerView stepOSRecyclerView) {
                this.f40342c = stepOSRecyclerView;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildAdapterPosition(view) != 0) {
                    rect.top = (int) O6.s.a(4.0f, this.f40342c.getContext());
                }
            }
        }

        public class b extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f40344a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f40344a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                if (g.this.f40341a.f40435F != null && g.this.f40341a.f40435F[i10]) {
                    this.f40344a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        public class c extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f40346a;

            /* renamed from: b, reason: collision with root package name */
            public final int f40347b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f40348c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ StepOSAlertController f40349d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, StepOSAlertController stepOSAlertController) {
                super(context, cursor, z10);
                this.f40348c = recycleListView;
                this.f40349d = stepOSAlertController;
                Cursor cursor2 = getCursor();
                this.f40346a = cursor2.getColumnIndexOrThrow(g.this.f40341a.f40441L);
                this.f40347b = cursor2.getColumnIndexOrThrow(g.this.f40341a.f40442M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f40346a));
                this.f40348c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f40347b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return g.this.f40341a.f40455b.inflate(this.f40349d.f40316q0, viewGroup, false);
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ StepOSAlertController f40351a;

            public d(StepOSAlertController stepOSAlertController) {
                this.f40351a = stepOSAlertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                g.this.f40341a.f40477x.onClick(this.f40351a.f40262E, i10);
                if (g.this.f40341a.f40437H) {
                    return;
                }
                this.f40351a.f40262E.dismiss();
            }
        }

        public class e implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f40353a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ StepOSAlertController f40354b;

            public e(RecycleListView recycleListView, StepOSAlertController stepOSAlertController) {
                this.f40353a = recycleListView;
                this.f40354b = stepOSAlertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                if (g.this.f40341a.f40435F != null) {
                    g.this.f40341a.f40435F[i10] = this.f40353a.isItemChecked(i10);
                }
                g.this.f40341a.f40439J.onClick(this.f40354b.f40262E, i10, this.f40353a.isItemChecked(i10));
            }
        }

        /* renamed from: stepos.support.v7.app.StepOSAlertController$g$g, reason: collision with other inner class name */
        public static class DialogInterfaceOnClickListenerC0521g implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0521g() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }

            public /* synthetic */ DialogInterfaceOnClickListenerC0521g(a aVar) {
                this();
            }
        }

        public g(b.C0523b c0523b) {
            this.f40341a = c0523b;
        }

        public void b(StepOSAlertController stepOSAlertController) throws Resources.NotFoundException {
            StepOSAlertController stepOSAlertController2;
            b.C0523b c0523b = this.f40341a;
            View view = c0523b.f40460g;
            if (view != null) {
                stepOSAlertController.l(view);
            } else {
                CharSequence charSequence = c0523b.f40459f;
                if (charSequence != null) {
                    stepOSAlertController.s(charSequence);
                }
                Drawable drawable = this.f40341a.f40457d;
                if (drawable != null) {
                    stepOSAlertController.o(drawable);
                }
                int i10 = this.f40341a.f40456c;
                if (i10 != 0) {
                    stepOSAlertController.n(i10);
                }
                int i11 = this.f40341a.f40458e;
                if (i11 != 0) {
                    stepOSAlertController.n(stepOSAlertController.b(i11));
                }
            }
            CharSequence charSequence2 = this.f40341a.f40461h;
            if (charSequence2 != null) {
                stepOSAlertController.q(charSequence2);
            }
            b.C0523b c0523b2 = this.f40341a;
            CharSequence charSequence3 = c0523b2.f40462i;
            if (charSequence3 == null && c0523b2.f40463j == null) {
                stepOSAlertController2 = stepOSAlertController;
            } else {
                stepOSAlertController.h(-1, charSequence3, c0523b2.f40464k, null, c0523b2.f40463j);
                stepOSAlertController2 = stepOSAlertController;
            }
            b.C0523b c0523b3 = this.f40341a;
            CharSequence charSequence4 = c0523b3.f40465l;
            if (charSequence4 != null || c0523b3.f40466m != null) {
                stepOSAlertController2.h(-2, charSequence4, c0523b3.f40467n, null, c0523b3.f40466m);
            }
            b.C0523b c0523b4 = this.f40341a;
            CharSequence charSequence5 = c0523b4.f40468o;
            if (charSequence5 != null || c0523b4.f40469p != null) {
                stepOSAlertController2.h(-3, charSequence5, c0523b4.f40470q, null, c0523b4.f40469p);
            }
            b.C0523b c0523b5 = this.f40341a;
            a aVar = null;
            if (c0523b5.f40475v != null || c0523b5.f40440K != null || c0523b5.f40476w != null) {
                c(stepOSAlertController2);
                b.C0523b c0523b6 = this.f40341a;
                if (c0523b6.f40465l == null && c0523b6.f40466m == null && c0523b6.f40462i == null && c0523b6.f40463j == null && c0523b6.f40468o == null && c0523b6.f40469p == null) {
                    stepOSAlertController2.h(-2, c0523b6.f40454a.getText(R$string.mc_cancel), new DialogInterfaceOnClickListenerC0521g(aVar), null, this.f40341a.f40466m);
                }
            }
            if (this.f40341a.f40453X) {
                stepOSAlertController2.f40285P0 = true;
                d(stepOSAlertController2);
                stepOSAlertController2.f0(this.f40341a.f40452W.size());
                stepOSAlertController2.h(-2, this.f40341a.f40454a.getText(R$string.mc_cancel), new DialogInterfaceOnClickListenerC0521g(aVar), null, this.f40341a.f40466m);
            }
            b.C0523b c0523b7 = this.f40341a;
            View view2 = c0523b7.f40479z;
            if (view2 == null) {
                int i12 = c0523b7.f40478y;
                if (i12 != 0) {
                    stepOSAlertController2.t(i12);
                }
            } else if (c0523b7.f40434E) {
                stepOSAlertController2.v(view2, c0523b7.f40430A, c0523b7.f40431B, c0523b7.f40432C, c0523b7.f40433D);
            } else {
                stepOSAlertController2.u(view2);
            }
            stepOSAlertController2.e0(this.f40341a.f40448S);
            stepOSAlertController2.p(this.f40341a.f40449T);
            b.C0523b c0523b8 = this.f40341a;
            stepOSAlertController2.m(c0523b8.f40450U, c0523b8.f40451V);
        }

        public final void c(StepOSAlertController stepOSAlertController) throws Resources.NotFoundException {
            StepOSAlertController stepOSAlertController2;
            ListAdapter iVar;
            int i10;
            ListAdapter simpleCursorAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f40341a.f40455b.inflate(stepOSAlertController.f40315p0, (ViewGroup) null);
            b.C0523b c0523b = this.f40341a;
            if (c0523b.f40436G) {
                i10 = stepOSAlertController.f40316q0;
                if (c0523b.f40440K == null) {
                    b.C0523b c0523b2 = this.f40341a;
                    iVar = new b(c0523b2.f40454a, stepOSAlertController.f40316q0, R.id.text1, c0523b2.f40475v, recycleListView);
                    recycleListView = recycleListView;
                    stepOSAlertController2 = stepOSAlertController;
                } else {
                    b.C0523b c0523b3 = this.f40341a;
                    stepOSAlertController2 = stepOSAlertController;
                    iVar = new c(c0523b3.f40454a, c0523b3.f40440K, false, recycleListView, stepOSAlertController2);
                }
            } else {
                stepOSAlertController2 = stepOSAlertController;
                if (c0523b.f40445P) {
                    i10 = stepOSAlertController2.f40325z0;
                    b.C0523b c0523b4 = this.f40341a;
                    if (c0523b4.f40440K == null) {
                        ListAdapter listAdapter = c0523b4.f40476w;
                        if (listAdapter != null) {
                            iVar = listAdapter;
                            i10 = 0;
                        } else if (c0523b4.f40446Q != null) {
                            Context context = this.f40341a.f40454a;
                            int i11 = stepOSAlertController2.f40325z0;
                            b.C0523b c0523b5 = this.f40341a;
                            simpleCursorAdapter = new j(context, i11, R.id.text1, c0523b5.f40475v, c0523b5.f40446Q);
                        } else if (c0523b4.f40447R != null) {
                            Context context2 = this.f40341a.f40454a;
                            int i12 = stepOSAlertController2.f40325z0;
                            b.C0523b c0523b6 = this.f40341a;
                            simpleCursorAdapter = new j(context2, i12, R.id.text1, c0523b6.f40475v, c0523b6.f40447R);
                        } else {
                            iVar = new j(this.f40341a.f40454a, stepOSAlertController2.f40325z0, R.id.text1, this.f40341a.f40475v);
                        }
                    } else {
                        Context context3 = this.f40341a.f40454a;
                        int i13 = stepOSAlertController2.f40325z0;
                        b.C0523b c0523b7 = this.f40341a;
                        simpleCursorAdapter = new SimpleCursorAdapter(context3, i13, c0523b7.f40440K, new String[]{c0523b7.f40441L}, new int[]{R.id.text1});
                    }
                    iVar = simpleCursorAdapter;
                } else {
                    int i14 = c0523b.f40437H ? stepOSAlertController2.f40317r0 : stepOSAlertController2.f40321v0;
                    if (c0523b.f40440K != null) {
                        b.C0523b c0523b8 = this.f40341a;
                        iVar = new SimpleCursorAdapter(c0523b8.f40454a, i14, c0523b8.f40440K, new String[]{c0523b8.f40441L}, new int[]{R.id.text1});
                    } else {
                        iVar = c0523b.f40476w;
                        if (iVar == null) {
                            b.C0523b c0523b9 = this.f40341a;
                            iVar = new i(c0523b9.f40454a, i14, R.id.text1, c0523b9.f40475v);
                        }
                        i10 = 0;
                    }
                    i10 = i14;
                }
            }
            this.f40341a.getClass();
            stepOSAlertController2.f40311l0 = iVar;
            b.C0523b c0523b10 = this.f40341a;
            stepOSAlertController2.f40312m0 = c0523b10.f40438I;
            if (c0523b10.f40477x != null) {
                recycleListView.setOnItemClickListener(new d(stepOSAlertController2));
            } else if (c0523b10.f40439J != null) {
                recycleListView.setOnItemClickListener(new e(recycleListView, stepOSAlertController2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f40341a.f40443N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            int dimensionPixelOffset = this.f40341a.f40454a.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_listview_choice_padding);
            if (i10 > 0 && (i10 == R$layout.stepos_select_dialog_singlechoice || i10 == R$layout.stepos_select_dialog_multichoice)) {
                recycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                recycleListView.setSelector(R.color.transparent);
            }
            b.C0523b c0523b11 = this.f40341a;
            if (c0523b11.f40437H) {
                recycleListView.setChoiceMode(1);
                recycleListView.setDividerHeight((int) O6.s.a(4.0f, recycleListView.getContext()));
            } else if (c0523b11.f40436G) {
                recycleListView.setChoiceMode(2);
                recycleListView.setDividerHeight((int) O6.s.a(4.0f, recycleListView.getContext()));
            }
            stepOSAlertController2.f40272J = recycleListView;
        }

        public final void d(StepOSAlertController stepOSAlertController) {
            View viewInflate;
            StepOSRecyclerView stepOSRecyclerView;
            b.C0523b c0523b = this.f40341a;
            if (c0523b.f40435F == null) {
                viewInflate = LayoutInflater.from(c0523b.f40454a).inflate(stepOSAlertController.f40318s0, (ViewGroup) null);
                stepOSRecyclerView = (StepOSRecyclerView) viewInflate.findViewById(R$id.select_dialog_recycler_view);
                b.C0523b c0523b2 = this.f40341a;
                if (c0523b2.f40438I > c0523b2.f40452W.size()) {
                    return;
                }
                stepos.support.v7.app.k kVar = stepOSAlertController.f40262E;
                b.C0523b c0523b3 = this.f40341a;
                stepOSRecyclerView.setAdapter(new f(kVar, c0523b3.f40454a, stepOSAlertController.f40320u0, c0523b3.f40452W, c0523b3.f40438I));
            } else {
                viewInflate = LayoutInflater.from(c0523b.f40454a).inflate(stepOSAlertController.f40318s0, (ViewGroup) null);
                stepOSRecyclerView = (StepOSRecyclerView) viewInflate.findViewById(R$id.select_dialog_recycler_view);
                stepos.support.v7.app.k kVar2 = stepOSAlertController.f40262E;
                b.C0523b c0523b4 = this.f40341a;
                stepOSRecyclerView.setAdapter(new f(kVar2, c0523b4.f40454a, stepOSAlertController.f40319t0, c0523b4.f40452W, c0523b4.f40435F));
            }
            stepOSRecyclerView.addItemDecoration(new a(stepOSRecyclerView));
            stepOSRecyclerView.setLayoutManager(new LinearLayoutManager(this.f40341a.f40454a));
            stepOSRecyclerView.setOverScrollEnable(false);
            this.f40341a.f40479z = viewInflate;
        }

        public class f extends RecyclerView.Adapter {

            /* renamed from: a, reason: collision with root package name */
            public DialogInterface f40356a;

            /* renamed from: b, reason: collision with root package name */
            public final int f40357b;

            /* renamed from: c, reason: collision with root package name */
            public final LayoutInflater f40358c;

            /* renamed from: d, reason: collision with root package name */
            public final ArrayList<Pair<String, String>> f40359d;

            /* renamed from: e, reason: collision with root package name */
            public int f40360e;

            /* renamed from: f, reason: collision with root package name */
            public boolean f40361f;

            /* renamed from: g, reason: collision with root package name */
            public boolean[] f40362g;

            public class a implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ c f40364a;

                public a(c cVar) {
                    this.f40364a = cVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f40364a.f40370d.setChecked(!r4.isChecked());
                    c cVar = this.f40364a;
                    cVar.f40371e.setChecked(cVar.f40370d.isChecked());
                    f fVar = f.this;
                    c cVar2 = this.f40364a;
                    fVar.f(cVar2.f40368a, cVar2.f40369c, cVar2.f40370d.isChecked());
                    if (g.this.f40341a.f40439J != null) {
                        g.this.f40341a.f40439J.onClick(f.this.f40356a, this.f40364a.getLayoutPosition(), this.f40364a.f40370d.isChecked());
                    }
                }
            }

            public class b implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ d f40366a;

                public b(d dVar) {
                    this.f40366a = dVar;
                }

                @Override // android.view.View.OnClickListener
                @SuppressLint({"NotifyDataSetChanged"})
                public void onClick(View view) {
                    f.this.f40360e = this.f40366a.getLayoutPosition();
                    this.f40366a.f40376e.setChecked(true);
                    if (g.this.f40341a.f40477x != null) {
                        g.this.f40341a.f40477x.onClick(f.this.f40356a, this.f40366a.getLayoutPosition());
                    }
                    f.this.notifyDataSetChanged();
                }
            }

            public class c extends RecyclerView.ViewHolder {

                /* renamed from: a, reason: collision with root package name */
                public TextView f40368a;

                /* renamed from: c, reason: collision with root package name */
                public TextView f40369c;

                /* renamed from: d, reason: collision with root package name */
                public CheckBox f40370d;

                /* renamed from: e, reason: collision with root package name */
                public StepOSMultiLinesCheckLayout f40371e;

                public c(StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout) {
                    super(stepOSMultiLinesCheckLayout);
                    this.f40371e = stepOSMultiLinesCheckLayout;
                    this.f40368a = (TextView) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_title_multi_line_text_view);
                    this.f40369c = (TextView) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_detail_multi_line_text_view);
                    this.f40370d = (CheckBox) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_title_multi_line_check_box);
                }
            }

            public class d extends RecyclerView.ViewHolder {

                /* renamed from: a, reason: collision with root package name */
                public TextView f40373a;

                /* renamed from: c, reason: collision with root package name */
                public TextView f40374c;

                /* renamed from: d, reason: collision with root package name */
                public ImageView f40375d;

                /* renamed from: e, reason: collision with root package name */
                public StepOSMultiLinesCheckLayout f40376e;

                public d(StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout) {
                    super(stepOSMultiLinesCheckLayout);
                    this.f40376e = stepOSMultiLinesCheckLayout;
                    this.f40373a = (TextView) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_title_multi_line_text_view);
                    this.f40374c = (TextView) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_detail_multi_line_text_view);
                    this.f40375d = (ImageView) stepOSMultiLinesCheckLayout.findViewById(R$id.alert_title_multi_line_check_box_single);
                }
            }

            public f(DialogInterface dialogInterface, Context context, int i10, ArrayList<Pair<String, String>> arrayList, int i11) {
                this.f40360e = -1;
                this.f40356a = dialogInterface;
                this.f40358c = LayoutInflater.from(context);
                this.f40357b = i10;
                this.f40359d = arrayList;
                this.f40360e = i11;
                this.f40361f = false;
            }

            public final void f(TextView textView, TextView textView2, boolean z10) {
                if (z10) {
                    int iC = O6.s.c(com.stepos.common.R$attr.colorBrand, g.this.f40341a.f40454a);
                    textView.setTextColor(g.this.f40341a.f40454a.getResources().getColor(iC));
                    textView2.setTextColor(g.this.f40341a.f40454a.getResources().getColor(iC));
                } else {
                    textView.setTextColor(g.this.f40341a.f40454a.getResources().getColor(O6.s.c(com.google.android.material.R$attr.colorOnSurface, g.this.f40341a.f40454a)));
                    textView2.setTextColor(g.this.f40341a.f40454a.getResources().getColor(O6.s.c(com.google.android.material.R$attr.colorOnSurfaceVariant, g.this.f40341a.f40454a)));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f40359d.size();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) int i10) {
                Pair<String, String> pair = this.f40359d.get(i10);
                if (this.f40361f) {
                    c cVar = (c) viewHolder;
                    cVar.itemView.setTag(Integer.valueOf(i10));
                    cVar.itemView.setOnClickListener(new a(cVar));
                    if (this.f40362g[i10]) {
                        cVar.f40371e.setChecked(true);
                        cVar.f40370d.setChecked(!r7.isChecked());
                    }
                    f(cVar.f40368a, cVar.f40369c, cVar.f40370d.isChecked());
                    cVar.f40368a.setText((CharSequence) pair.first);
                    cVar.f40369c.setText((CharSequence) pair.second);
                    return;
                }
                d dVar = (d) viewHolder;
                dVar.itemView.setTag(Integer.valueOf(i10));
                viewHolder.itemView.setOnClickListener(new b(dVar));
                if (i10 == this.f40360e) {
                    dVar.f40375d.setVisibility(0);
                    dVar.f40376e.setChecked(true);
                } else {
                    dVar.f40375d.setVisibility(4);
                    dVar.f40376e.setChecked(false);
                }
                f(dVar.f40373a, dVar.f40374c, dVar.f40376e.a());
                dVar.f40373a.setText((CharSequence) pair.first);
                dVar.f40374c.setText((CharSequence) pair.second);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
                StepOSMultiLinesCheckLayout stepOSMultiLinesCheckLayout = (StepOSMultiLinesCheckLayout) this.f40358c.inflate(this.f40357b, viewGroup, false);
                return this.f40361f ? new c(stepOSMultiLinesCheckLayout) : new d(stepOSMultiLinesCheckLayout);
            }

            public f(DialogInterface dialogInterface, Context context, int i10, ArrayList<Pair<String, String>> arrayList, boolean[] zArr) {
                this.f40360e = -1;
                this.f40356a = dialogInterface;
                this.f40358c = LayoutInflater.from(context);
                this.f40357b = i10;
                this.f40359d = arrayList;
                this.f40362g = zArr;
                this.f40361f = true;
            }
        }
    }
}
