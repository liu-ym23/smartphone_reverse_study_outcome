package p3;

import W3.C0396g;
import W3.C0403n;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import com.stepos.widget.dialog.StepOSDialogListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l3.C0844b;
import l3.C0846d;
import l3.C0847e;
import r3.C1010f;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: E0, reason: collision with root package name */
    public static final b f19416E0 = new b(null);

    /* renamed from: A, reason: collision with root package name */
    private int f19417A;

    /* renamed from: A0, reason: collision with root package name */
    private final int f19418A0;

    /* renamed from: B, reason: collision with root package name */
    private int f19419B;

    /* renamed from: B0, reason: collision with root package name */
    private final int f19420B0;

    /* renamed from: C, reason: collision with root package name */
    private boolean f19421C;

    /* renamed from: C0, reason: collision with root package name */
    private final Handler f19422C0;

    /* renamed from: D, reason: collision with root package name */
    private boolean f19423D;

    /* renamed from: D0, reason: collision with root package name */
    private final View.OnClickListener f19424D0;

    /* renamed from: E, reason: collision with root package name */
    private boolean f19425E;

    /* renamed from: F, reason: collision with root package name */
    private View f19426F;

    /* renamed from: G, reason: collision with root package name */
    private int f19427G;

    /* renamed from: H, reason: collision with root package name */
    private Drawable f19428H;

    /* renamed from: I, reason: collision with root package name */
    private Drawable f19429I;

    /* renamed from: J, reason: collision with root package name */
    private ImageView f19430J;

    /* renamed from: K, reason: collision with root package name */
    private TextView f19431K;

    /* renamed from: L, reason: collision with root package name */
    private TextView f19432L;

    /* renamed from: M, reason: collision with root package name */
    private MovementMethod f19433M;

    /* renamed from: N, reason: collision with root package name */
    private NestedScrollView f19434N;

    /* renamed from: O, reason: collision with root package name */
    private ListView f19435O;

    /* renamed from: P, reason: collision with root package name */
    private ListAdapter f19436P;

    /* renamed from: Q, reason: collision with root package name */
    private int f19437Q;

    /* renamed from: R, reason: collision with root package name */
    private boolean f19438R;

    /* renamed from: S, reason: collision with root package name */
    private int f19439S;

    /* renamed from: T, reason: collision with root package name */
    private StepOSButton f19440T;

    /* renamed from: U, reason: collision with root package name */
    private CharSequence f19441U;

    /* renamed from: V, reason: collision with root package name */
    private Message f19442V;

    /* renamed from: W, reason: collision with root package name */
    private Drawable f19443W;

    /* renamed from: X, reason: collision with root package name */
    private StepOSButton f19444X;

    /* renamed from: Y, reason: collision with root package name */
    private CharSequence f19445Y;

    /* renamed from: Z, reason: collision with root package name */
    private Message f19446Z;

    /* renamed from: a, reason: collision with root package name */
    private final Context f19447a;

    /* renamed from: a0, reason: collision with root package name */
    private Drawable f19448a0;

    /* renamed from: b, reason: collision with root package name */
    private final j f19449b;

    /* renamed from: b0, reason: collision with root package name */
    private StepOSButton f19450b0;

    /* renamed from: c, reason: collision with root package name */
    private final Window f19451c;

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence f19452c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f19453d;

    /* renamed from: d0, reason: collision with root package name */
    private Message f19454d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f19455e;

    /* renamed from: e0, reason: collision with root package name */
    private Drawable f19456e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f19457f;

    /* renamed from: f0, reason: collision with root package name */
    private int f19458f0;

    /* renamed from: g, reason: collision with root package name */
    private final int f19459g;

    /* renamed from: g0, reason: collision with root package name */
    private int f19460g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f19461h;

    /* renamed from: h0, reason: collision with root package name */
    private int f19462h0;

    /* renamed from: i, reason: collision with root package name */
    private final int f19463i;

    /* renamed from: i0, reason: collision with root package name */
    private int f19464i0;

    /* renamed from: j, reason: collision with root package name */
    private final int f19465j;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f19466j0;

    /* renamed from: k, reason: collision with root package name */
    private final int f19467k;

    /* renamed from: k0, reason: collision with root package name */
    private int f19468k0;

    /* renamed from: l, reason: collision with root package name */
    private final int f19469l;

    /* renamed from: l0, reason: collision with root package name */
    private int f19470l0;

    /* renamed from: m, reason: collision with root package name */
    private final int f19471m;

    /* renamed from: m0, reason: collision with root package name */
    private int f19472m0;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f19473n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f19474n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f19475o;

    /* renamed from: o0, reason: collision with root package name */
    private K2.o f19476o0;

    /* renamed from: p, reason: collision with root package name */
    private int f19477p;

    /* renamed from: p0, reason: collision with root package name */
    private final int f19478p0;

    /* renamed from: q, reason: collision with root package name */
    private int f19479q;

    /* renamed from: q0, reason: collision with root package name */
    private final int f19480q0;

    /* renamed from: r, reason: collision with root package name */
    private int f19481r;

    /* renamed from: r0, reason: collision with root package name */
    private final int f19482r0;

    /* renamed from: s, reason: collision with root package name */
    private int f19483s;

    /* renamed from: s0, reason: collision with root package name */
    private final int f19484s0;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f19485t;

    /* renamed from: t0, reason: collision with root package name */
    private final int f19486t0;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f19487u;

    /* renamed from: u0, reason: collision with root package name */
    private final int f19488u0;

    /* renamed from: v, reason: collision with root package name */
    private View f19489v;

    /* renamed from: v0, reason: collision with root package name */
    private final int f19490v0;

    /* renamed from: w, reason: collision with root package name */
    private View f19491w;

    /* renamed from: w0, reason: collision with root package name */
    private final int f19492w0;

    /* renamed from: x, reason: collision with root package name */
    private int f19493x;

    /* renamed from: x0, reason: collision with root package name */
    private final int f19494x0;

    /* renamed from: y, reason: collision with root package name */
    private int f19495y;

    /* renamed from: y0, reason: collision with root package name */
    private final int f19496y0;

    /* renamed from: z, reason: collision with root package name */
    private int f19497z;

    /* renamed from: z0, reason: collision with root package name */
    private final int f19498z0;

    private static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<DialogInterface> f19499a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DialogInterface dialogInterface) {
            super(Looper.getMainLooper());
            j4.k.g(dialogInterface, "dialog");
            this.f19499a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j4.k.g(message, "msg");
            int i5 = message.what;
            if (i5 != -3 && i5 != -2 && i5 != -1) {
                if (i5 != 1) {
                    return;
                }
                Object obj = message.obj;
                DialogInterface dialogInterface = obj instanceof DialogInterface ? (DialogInterface) obj : null;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            DialogInterface dialogInterface2 = this.f19499a.get();
            if (dialogInterface2 == null) {
                return;
            }
            Object obj2 = message.obj;
            DialogInterface.OnClickListener onClickListener = obj2 instanceof DialogInterface.OnClickListener ? (DialogInterface.OnClickListener) obj2 : null;
            if (onClickListener == null) {
                return;
            }
            onClickListener.onClick(dialogInterface2, message.what);
        }
    }

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(View view, View view2, View view3) {
            if (view2 != null) {
                view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
            }
            if (view3 != null) {
                view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
            }
        }

        private b() {
        }
    }

    private static final class c extends ArrayAdapter<CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        private final boolean[] f19500a;

        /* renamed from: b, reason: collision with root package name */
        private final ListView f19501b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i5, CharSequence[] charSequenceArr, boolean[] zArr, ListView listView) {
            super(context, i5, l3.h.f18436k, charSequenceArr);
            j4.k.g(context, "context");
            j4.k.g(charSequenceArr, "entries");
            j4.k.g(listView, "listView");
            this.f19500a = zArr;
            this.f19501b = listView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            j4.k.g(viewGroup, "parent");
            View view2 = super.getView(i5, view, viewGroup);
            j4.k.f(view2, "getView(...)");
            boolean[] zArr = this.f19500a;
            if (zArr != null ? j4.k.b(C0396g.p(zArr, i5), Boolean.TRUE) : false) {
                this.f19501b.setItemChecked(i5, true);
            }
            return view2;
        }
    }

    private static final class d extends CursorAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final LayoutInflater f19502a;

        /* renamed from: b, reason: collision with root package name */
        private final int f19503b;

        /* renamed from: c, reason: collision with root package name */
        private final ListView f19504c;

        /* renamed from: d, reason: collision with root package name */
        private final int f19505d;

        /* renamed from: e, reason: collision with root package name */
        private final int f19506e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, Cursor cursor, LayoutInflater layoutInflater, int i5, String str, String str2, ListView listView) {
            super(context, cursor, false);
            j4.k.g(context, "context");
            j4.k.g(cursor, "cursor");
            j4.k.g(layoutInflater, "inflater");
            j4.k.g(str, "labelColumn");
            j4.k.g(str2, "isCheckedColumn");
            j4.k.g(listView, "listView");
            this.f19502a = layoutInflater;
            this.f19503b = i5;
            this.f19504c = listView;
            this.f19505d = cursor.getColumnIndexOrThrow(str);
            this.f19506e = cursor.getColumnIndexOrThrow(str2);
        }

        @Override // android.widget.CursorAdapter
        public void bindView(View view, Context context, Cursor cursor) {
            j4.k.g(view, "view");
            j4.k.g(context, "context");
            j4.k.g(cursor, "cursor");
            ((CheckedTextView) view.findViewById(l3.h.f18436k)).setText(cursor.getString(this.f19505d));
            this.f19504c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f19506e) == 1);
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            j4.k.g(context, "context");
            j4.k.g(cursor, "cursor");
            j4.k.g(viewGroup, "parent");
            View viewInflate = this.f19502a.inflate(this.f19503b, viewGroup, false);
            j4.k.f(viewInflate, "inflate(...)");
            return viewInflate;
        }
    }

    public static final class e extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19507a;

        e(int i5) {
            this.f19507a = i5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            j4.k.g(rect, "outRect");
            j4.k.g(view, "view");
            j4.k.g(recyclerView, "parent");
            j4.k.g(state, "state");
            if (recyclerView.getChildAdapterPosition(view) != 0) {
                rect.top = this.f19507a;
            }
        }
    }

    public static final class f implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19508a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f19509b;

        f(View view, View view2) {
            this.f19508a = view;
            this.f19509b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
            j4.k.g(absListView, "v");
            g.f19416E0.b(absListView, this.f19508a, this.f19509b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i5) {
            j4.k.g(absListView, "view");
        }
    }

    /* renamed from: p3.g$g, reason: collision with other inner class name */
    public static final class C0231g extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f19510a;

        C0231g(float f5) {
            this.f19510a = f5;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            j4.k.g(view, "view");
            j4.k.g(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f19510a);
        }
    }

    public g(Context context, j jVar, Window window) throws Resources.NotFoundException {
        j4.k.g(context, "context");
        j4.k.g(jVar, "dialog");
        j4.k.g(window, "window");
        this.f19447a = context;
        this.f19449b = jVar;
        this.f19451c = window;
        this.f19437Q = -1;
        this.f19464i0 = 1;
        this.f19466j0 = true;
        this.f19468k0 = 2;
        this.f19470l0 = 2;
        this.f19474n0 = true;
        this.f19422C0 = new a(jVar);
        this.f19424D0 = new View.OnClickListener() { // from class: p3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.k(this.f19415a, view);
            }
        };
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, l3.m.f18556K0, C0844b.f18280a, l3.l.f18488k);
        j4.k.f(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.f19453d = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18610T0, l3.j.f18458a);
            this.f19455e = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18621V0, l3.j.f18465h);
            this.f19457f = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18616U0, l3.j.f18461d);
            this.f19459g = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18647a1, l3.j.f18464g);
            this.f19461h = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18626W0, l3.j.f18463f);
            this.f19463i = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18574N0, l3.j.f18462e);
            this.f19465j = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18631X0, l3.j.f18466i);
            this.f19467k = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18636Y0, l3.j.f18459b);
            this.f19469l = typedArrayObtainStyledAttributes.getResourceId(l3.m.f18641Z0, l3.j.f18460c);
            this.f19471m = typedArrayObtainStyledAttributes.getDimensionPixelSize(l3.m.f18568M0, resources.getDimensionPixelSize(C0847e.f18358g));
            this.f19473n = typedArrayObtainStyledAttributes.getBoolean(l3.m.f18562L0, false);
            this.f19475o = typedArrayObtainStyledAttributes.getBoolean(l3.m.f18580O0, false);
            this.f19477p = typedArrayObtainStyledAttributes.getDimensionPixelSize(l3.m.f18604S0, 0);
            this.f19479q = typedArrayObtainStyledAttributes.getDimensionPixelSize(l3.m.f18598R0, 0);
            this.f19481r = typedArrayObtainStyledAttributes.getDimensionPixelSize(l3.m.f18592Q0, 0);
            this.f19483s = typedArrayObtainStyledAttributes.getDimensionPixelSize(l3.m.f18586P0, 0);
            O(C1010f.f20022a.b(typedArrayObtainStyledAttributes, l3.m.f18653b1));
            typedArrayObtainStyledAttributes.recycle();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(C0847e.f18376p);
            this.f19480q0 = dimensionPixelOffset;
            this.f19482r0 = resources.getDimensionPixelOffset(C0847e.f18378q);
            this.f19484s0 = resources.getDimensionPixelOffset(C0847e.f18382s);
            this.f19486t0 = resources.getDimensionPixelOffset(C0847e.f18384t);
            this.f19488u0 = resources.getDimensionPixelOffset(C0847e.f18380r);
            this.f19490v0 = resources.getDimensionPixelOffset(C0847e.f18386u);
            this.f19492w0 = resources.getDimensionPixelOffset(C0847e.f18388v);
            this.f19494x0 = resources.getDimensionPixelOffset(C0847e.f18362i);
            this.f19496y0 = resources.getDimensionPixelOffset(C0847e.f18360h);
            this.f19498z0 = resources.getDimensionPixelOffset(C0847e.f18356f);
            this.f19418A0 = resources.getDimensionPixelOffset(C0847e.f18374o);
            this.f19420B0 = resources.getDimensionPixelOffset(C0847e.f18372n);
            this.f19478p0 = kotlin.ranges.l.b(((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds().width() - (dimensionPixelOffset * 2), 1);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final boolean A() {
        ViewParent parent;
        StepOSButton stepOSButton = this.f19440T;
        if (stepOSButton == null || (parent = stepOSButton.getParent()) == null) {
            StepOSButton stepOSButton2 = this.f19444X;
            parent = stepOSButton2 != null ? stepOSButton2.getParent() : null;
            if (parent == null) {
                StepOSButton stepOSButton3 = this.f19450b0;
                parent = stepOSButton3 != null ? stepOSButton3.getParent() : null;
            }
        }
        LinearLayout linearLayout = parent instanceof LinearLayout ? (LinearLayout) parent : null;
        return linearLayout != null && linearLayout.getOrientation() == 1;
    }

    private final boolean B(int i5) {
        boolean z5;
        int iL = l(i5);
        int iN = n(i5) - (this.f19496y0 * 2);
        List<V3.m> listK = C0403n.k(V3.r.a(this.f19440T, this.f19441U), V3.r.a(this.f19444X, this.f19445Y), V3.r.a(this.f19450b0, this.f19452c0));
        boolean z6 = true;
        if (listK == null || !listK.isEmpty()) {
            for (V3.m mVar : listK) {
                StepOSButton stepOSButton = (StepOSButton) mVar.a();
                CharSequence charSequence = (CharSequence) mVar.b();
                if (stepOSButton != null && stepOSButton.getVisibility() == 0 && r.c(stepOSButton, charSequence) + stepOSButton.getCompoundPaddingStart() + stepOSButton.getCompoundPaddingEnd() > (this.f19496y0 * 2) + iN) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
        } else {
            z5 = false;
        }
        s sVar = s.f19586a;
        int i6 = this.f19472m0;
        if (!this.f19473n && this.f19435O == null && !this.f19438R) {
            z6 = false;
        }
        return sVar.c(iL, i6, z5, z6);
    }

    private final void E() {
        if (this.f19440T == null) {
            return;
        }
        m0((ViewGroup) this.f19451c.findViewById(l3.h.f18428c));
        H();
    }

    private final void F() throws Resources.NotFoundException {
        ViewGroup viewGroup;
        if (this.f19425E && (viewGroup = (ViewGroup) this.f19451c.findViewById(l3.h.f18432g)) != null) {
            FrameLayout frameLayout = (FrameLayout) this.f19451c.findViewById(l3.h.f18431f);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            o0(viewGroup);
            G();
            H();
        }
    }

    private final void G() throws Resources.NotFoundException {
        int dimensionPixelSize;
        CharSequence charSequence;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.f19451c.findViewById(l3.h.f18449x);
        if (constraintLayout == null) {
            return;
        }
        TextView textView = (TextView) constraintLayout.findViewById(l3.h.f18448w);
        TextView textView2 = (TextView) constraintLayout.findViewById(l3.h.f18437l);
        ImageView imageView = (ImageView) constraintLayout.findViewById(l3.h.f18433h);
        FrameLayout frameLayout = (FrameLayout) constraintLayout.findViewById(l3.h.f18435j);
        ImageView imageView2 = (ImageView) constraintLayout.findViewById(l3.h.f18434i);
        this.f19431K = textView;
        this.f19432L = textView2;
        this.f19430J = imageView;
        boolean z5 = this.f19489v != null;
        textView.setText(this.f19485t);
        textView2.setText(this.f19487u);
        textView2.setMovementMethod(this.f19433M);
        textView.setVisibility((z5 || (charSequence = this.f19485t) == null || charSequence.length() == 0) ? 8 : 0);
        CharSequence charSequence2 = this.f19487u;
        textView2.setVisibility((charSequence2 == null || charSequence2.length() == 0) ? 8 : 0);
        imageView.setVisibility((z5 || (this.f19427G == 0 && this.f19428H == null)) ? 8 : 0);
        int i5 = this.f19427G;
        if (i5 != 0) {
            imageView.setImageResource(i5);
        } else {
            imageView.setImageDrawable(this.f19428H);
        }
        frameLayout.setVisibility(imageView.getVisibility());
        imageView2.setImageDrawable(this.f19429I);
        imageView2.setVisibility((imageView.getVisibility() != 0 || this.f19429I == null) ? 8 : 0);
        int dimensionPixelSize2 = imageView2.getVisibility() == 0 ? (this.f19447a.getResources().getDimensionPixelSize(C0847e.f18368l) + this.f19447a.getResources().getDimensionPixelSize(C0847e.f18370m)) - this.f19447a.getResources().getDimensionPixelSize(C0847e.f18393y) : 0;
        androidx.core.widget.i.m(textView2, this.f19423D ? l3.l.f18484g : l3.l.f18483f);
        textView.setMaxLines(this.f19468k0);
        textView2.setMaxLines(this.f19470l0);
        int i6 = 3;
        List listM = C0403n.M(C0403n.l(this.f19489v), C0403n.k(frameLayout, textView, textView2));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((View) obj).getVisibility() == 0) {
                arrayList.add(obj);
            }
        }
        int[] iArrB = s.f19586a.b(imageView.getVisibility() == 0, textView.getVisibility() == 0, textView2.getVisibility() == 0, this.f19447a.getResources().getDimensionPixelSize(C0847e.f18392x), this.f19447a.getResources().getDimensionPixelSize(C0847e.f18390w));
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.g(constraintLayout);
        View view = this.f19489v;
        if (view != null) {
            dVar.i(view.getId(), 6, 0, 6);
            dVar.i(view.getId(), 7, 0, 7);
        }
        int size = arrayList.size();
        int i7 = 0;
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            int i9 = i7 + 1;
            if (i7 < 0) {
                C0403n.q();
            }
            View view2 = (View) obj2;
            dVar.e(view2.getId(), i6);
            View view3 = (View) C0403n.D(arrayList, i7 - 1);
            if (view3 == null) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = view3 == this.f19489v ? this.f19447a.getResources().getDimensionPixelSize(C0847e.f18390w) : iArrB[j4.k.b(view2, frameLayout) ? (char) 0 : j4.k.b(view2, textView) ? (char) 1 : (char) 2] - (view3 == frameLayout ? dimensionPixelSize2 : 0);
            }
            dVar.j(view2.getId(), 3, view3 != null ? view3.getId() : 0, view3 == null ? 3 : 4, dimensionPixelSize);
            i7 = i9;
            i6 = 3;
        }
        dVar.c(constraintLayout);
        constraintLayout.setVisibility(arrayList.isEmpty() ? 8 : 0);
        View viewFindViewById = this.f19451c.findViewById(l3.h.f18450y);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility((z5 || !arrayList.isEmpty()) ? 0 : 8);
        }
        H();
    }

    private final void H() {
        View viewFindViewById = this.f19451c.findViewById(l3.h.f18443r);
        if (viewFindViewById == null) {
            return;
        }
        View viewFindViewById2 = viewFindViewById.findViewById(l3.h.f18438m);
        View viewFindViewById3 = viewFindViewById.findViewById(l3.h.f18430e);
        View viewFindViewById4 = viewFindViewById.findViewById(l3.h.f18432g);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(((viewFindViewById3 == null || viewFindViewById3.getVisibility() != 0) && (viewFindViewById4 == null || viewFindViewById4.getVisibility() != 0)) ? 8 : 0);
        }
        p0(viewFindViewById, viewFindViewById.findViewById(l3.h.f18450y), viewFindViewById2, viewFindViewById3, viewFindViewById4, viewFindViewById.findViewById(l3.h.f18428c));
    }

    private final ViewGroup I(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            if (view2 instanceof ViewGroup) {
                return (ViewGroup) view2;
            }
            return null;
        }
        ViewParent parent = view2 != null ? view2.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view2);
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private final void K(View view, int i5) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.bottomMargin == i5) {
            return;
        }
        marginLayoutParams.bottomMargin = i5;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void b0(ViewGroup viewGroup, int i5) {
        final View viewFindViewById = this.f19451c.findViewById(l3.h.f18446u);
        final View viewFindViewById2 = this.f19451c.findViewById(l3.h.f18445t);
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
        final NestedScrollView nestedScrollView = this.f19434N;
        final ListView listView = this.f19435O;
        if (this.f19487u != null && nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.d() { // from class: p3.a
                @Override // androidx.core.widget.NestedScrollView.d
                public final void a(NestedScrollView nestedScrollView2, int i6, int i7, int i8, int i9) {
                    g.c0(viewFindViewById, viewFindViewById2, nestedScrollView2, i6, i7, i8, i9);
                }
            });
            nestedScrollView.post(new Runnable() { // from class: p3.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.d0(nestedScrollView, viewFindViewById, viewFindViewById2);
                }
            });
        } else {
            if (listView != null) {
                listView.setOnScrollListener(new f(viewFindViewById, viewFindViewById2));
                listView.post(new Runnable() { // from class: p3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.e0(listView, viewFindViewById, viewFindViewById2);
                    }
                });
                return;
            }
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(View view, View view2, NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
        j4.k.g(nestedScrollView, "v");
        f19416E0.b(nestedScrollView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(NestedScrollView nestedScrollView, View view, View view2) {
        f19416E0.b(nestedScrollView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ListView listView, View view, View view2) {
        f19416E0.b(listView, view, view2);
    }

    private final void g(StepOSButton stepOSButton, boolean z5) {
        stepOSButton.setGlassEnabled(false);
        stepOSButton.setSurfaceDrawable(androidx.core.content.a.e(this.f19447a, l3.f.f18396b));
        stepOSButton.setTextColor(androidx.core.content.a.d(this.f19447a, C0846d.f18299f));
        if (z5) {
            int i5 = this.f19464i0;
            if (i5 == 1) {
                stepOSButton.setSurfaceDrawable(androidx.core.content.a.e(this.f19447a, l3.f.f18395a));
                stepOSButton.setTextColor(androidx.core.content.a.d(this.f19447a, C0846d.f18297d));
            } else {
                if (i5 != 2) {
                    return;
                }
                stepOSButton.setTextColor(androidx.core.content.a.d(this.f19447a, C0846d.f18298e));
            }
        }
    }

    private final void h(StepOSButton stepOSButton, Drawable drawable) {
        if (drawable == null) {
            androidx.core.widget.i.g(stepOSButton, null, null, null, null);
            return;
        }
        int i5 = this.f19471m;
        drawable.setBounds(0, 0, i5, i5);
        androidx.core.widget.i.g(stepOSButton, drawable, null, null, null);
    }

    private final void h0(View view, int i5) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.topMargin == i5) {
            return;
        }
        marginLayoutParams.topMargin = i5;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void i() {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        View viewB;
        TextView textView = this.f19431K;
        boolean z5 = textView != null && textView.getVisibility() == 0;
        if (textView != null && z5) {
            textView.setGravity(8388611);
        }
        TextView textView2 = this.f19432L;
        if (textView2 != null && textView2.getVisibility() == 0) {
            textView2.setGravity(8388611);
        }
        ListView listView = this.f19435O;
        if (listView != null && this.f19473n && listView != null) {
            listView.setDivider(null);
        }
        ViewGroup viewGroup = (ViewGroup) this.f19451c.findViewById(l3.h.f18432g);
        if (viewGroup != null && viewGroup.getVisibility() != 8 && !this.f19421C && (viewB = r.b(viewGroup)) != null) {
            viewB.requestFocus();
        }
        if (this.f19460g0 == 0) {
            this.f19460g0 = u();
        }
        if (this.f19460g0 > 0 && (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.f19451c.findViewById(l3.h.f18443r)) != null) {
            stepOSAlertDialogLayout.setMaxHeight(this.f19460g0);
        }
        WindowManager.LayoutParams attributes = this.f19451c.getAttributes();
        attributes.width = this.f19478p0;
        int i5 = this.f19458f0;
        if (i5 == 0) {
            i5 = 80;
        }
        attributes.gravity = i5;
        if ((i5 & 112) == 80) {
            attributes.y = this.f19482r0;
        } else if (i5 == 17 && this.f19447a.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-r.e(this.f19447a)) / 2;
        }
        this.f19451c.setAttributes(attributes);
        j();
        this.f19451c.setElevation(0.0f);
    }

    private final void j() {
        WindowManager.LayoutParams attributes = this.f19451c.getAttributes();
        boolean z5 = (attributes.gravity & 112) == 80;
        View view = this.f19426F;
        boolean z6 = view != null && r.a(view);
        if (z5) {
            attributes.setFitInsetsTypes(WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar() | WindowInsets.Type.displayCutout() | (z6 ? WindowInsets.Type.ime() : 0));
            attributes.setFitInsetsIgnoringVisibility(false);
        }
        attributes.softInputMode = (z5 ? 16 : 48) | ((this.f19466j0 && z6) ? 5 : 3);
        this.f19451c.setAttributes(attributes);
        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.f19451c.findViewById(l3.h.f18443r);
        if (stepOSAlertDialogLayout != null) {
            stepOSAlertDialogLayout.setBottomWindowMargin$StepOSWidget_release(z5 ? this.f19482r0 : 0);
            stepOSAlertDialogLayout.setFitInputMethod$StepOSWidget_release(z5 && z6);
            stepOSAlertDialogLayout.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g gVar, View view) {
        Message message;
        Message message2;
        Message message3;
        Message messageObtain = (view != gVar.f19440T || (message3 = gVar.f19442V) == null) ? (view != gVar.f19444X || (message2 = gVar.f19446Z) == null) ? (view != gVar.f19450b0 || (message = gVar.f19454d0) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        gVar.f19422C0.obtainMessage(1, gVar.f19449b).sendToTarget();
    }

    private final int l(int i5) {
        return Integer.bitCount(i5 & 7);
    }

    private final int m(int i5) {
        int i6 = this.f19462h0;
        int i7 = i6 != -3 ? i6 != -2 ? i6 != -1 ? 0 : 1 : 2 : 4;
        if (i7 != 0 && (i5 & i7) != 0) {
            return i7;
        }
        if ((i5 & 1) != 0) {
            return 1;
        }
        if ((i5 & 4) != 0) {
            return 4;
        }
        return (i5 & 2) != 0 ? 2 : 0;
    }

    private final void m0(ViewGroup viewGroup) {
        int i5;
        if (viewGroup == null) {
            return;
        }
        StepOSButton stepOSButton = (StepOSButton) viewGroup.findViewById(l3.h.f18429d);
        this.f19440T = stepOSButton;
        stepOSButton.setOnClickListener(this.f19424D0);
        if (TextUtils.isEmpty(this.f19441U) && this.f19443W == null) {
            stepOSButton.setVisibility(8);
            i5 = 0;
        } else {
            stepOSButton.setText(this.f19441U);
            j4.k.d(stepOSButton);
            h(stepOSButton, this.f19443W);
            stepOSButton.setVisibility(0);
            i5 = 1;
        }
        StepOSButton stepOSButton2 = (StepOSButton) viewGroup.findViewById(l3.h.f18426a);
        this.f19444X = stepOSButton2;
        stepOSButton2.setOnClickListener(this.f19424D0);
        if (TextUtils.isEmpty(this.f19445Y) && this.f19448a0 == null) {
            stepOSButton2.setVisibility(8);
        } else {
            stepOSButton2.setText(this.f19445Y);
            j4.k.d(stepOSButton2);
            h(stepOSButton2, this.f19448a0);
            stepOSButton2.setVisibility(0);
            i5 |= 2;
        }
        StepOSButton stepOSButton3 = (StepOSButton) viewGroup.findViewById(l3.h.f18427b);
        this.f19450b0 = stepOSButton3;
        stepOSButton3.setOnClickListener(this.f19424D0);
        if (TextUtils.isEmpty(this.f19452c0) && this.f19456e0 == null) {
            stepOSButton3.setVisibility(8);
        } else {
            stepOSButton3.setText(this.f19452c0);
            j4.k.d(stepOSButton3);
            h(stepOSButton3, this.f19456e0);
            stepOSButton3.setVisibility(0);
            i5 |= 4;
        }
        if (i5 == 0) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        ViewParent parent = stepOSButton3.getParent();
        ConstraintLayout constraintLayout = parent instanceof ConstraintLayout ? (ConstraintLayout) parent : null;
        if (constraintLayout == null) {
            return;
        }
        int iM = m(i5);
        boolean zB = B(i5);
        List listK = C0403n.k(stepOSButton, stepOSButton3, stepOSButton2);
        s sVar = s.f19586a;
        StepOSButton stepOSButton4 = stepOSButton.getVisibility() == 0 ? stepOSButton : null;
        if (stepOSButton3.getVisibility() != 0) {
            stepOSButton3 = null;
        }
        List listD = sVar.d(stepOSButton4, stepOSButton3, stepOSButton2.getVisibility() == 0 ? stepOSButton2 : null, zB);
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        Iterator it = listK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StepOSButton stepOSButton5 = (StepOSButton) it.next();
            dVar.m(stepOSButton5.getId(), 0);
            dVar.l(stepOSButton5.getId(), this.f19498z0);
            dVar.B(stepOSButton5.getId(), stepOSButton5.getVisibility());
            stepOSButton5.setMinimumWidth(0);
            stepOSButton5.setMinimumHeight(0);
            stepOSButton5.setGravity(17);
            int i6 = this.f19496y0;
            stepOSButton5.setPaddingRelative(i6, 0, i6, 0);
            int i7 = j4.k.b(stepOSButton5, stepOSButton) ? 1 : j4.k.b(stepOSButton5, stepOSButton2) ? 2 : 4;
            j4.k.d(stepOSButton5);
            g(stepOSButton5, i7 == iM);
        }
        int i8 = 0;
        for (Object obj : listD) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                C0403n.q();
            }
            StepOSButton stepOSButton6 = (StepOSButton) obj;
            StepOSButton stepOSButton7 = (StepOSButton) C0403n.D(listD, i8 - 1);
            dVar.j(stepOSButton6.getId(), 3, (!zB || stepOSButton7 == null) ? 0 : stepOSButton7.getId(), (!zB || stepOSButton7 == null) ? 3 : 4, (!zB || stepOSButton7 == null) ? 0 : this.f19494x0);
            if (zB) {
                dVar.i(stepOSButton6.getId(), 6, 0, 6);
                dVar.i(stepOSButton6.getId(), 7, 0, 7);
            }
            i8 = i9;
        }
        if (!zB) {
            ArrayList arrayList = new ArrayList(C0403n.r(listD, 10));
            Iterator it2 = listD.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((StepOSButton) it2.next()).getId()));
            }
            int[] iArrT = C0403n.T(arrayList);
            int size = listD.size();
            float[] fArr = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                fArr[i10] = 1.0f;
            }
            dVar.p(0, 6, 0, 7, iArrT, fArr, 0);
            Iterator it3 = C0403n.y(listD, 1).iterator();
            while (it3.hasNext()) {
                dVar.A(((StepOSButton) it3.next()).getId(), 6, this.f19494x0);
            }
        }
        dVar.c(constraintLayout);
    }

    private final int n(int i5) {
        int iL = l(i5);
        int i6 = this.f19478p0 - (this.f19484s0 * 2);
        return iL == 0 ? i6 : (i6 - (this.f19494x0 * (iL - 1))) / iL;
    }

    private final void n0(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) this.f19451c.findViewById(l3.h.f18447v);
        this.f19434N = nestedScrollView;
        nestedScrollView.setFocusable(false);
        nestedScrollView.setNestedScrollingEnabled(false);
        ListView listView = this.f19435O;
        if (listView == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewParent parent = nestedScrollView.getParent();
        j4.k.e(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) parent;
        int iIndexOfChild = viewGroup2.indexOfChild(nestedScrollView);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(listView, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void o0(ViewGroup viewGroup) {
        View viewInflate = this.f19491w;
        if (viewInflate == null) {
            Integer numValueOf = Integer.valueOf(this.f19493x);
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            viewInflate = numValueOf != null ? LayoutInflater.from(this.f19447a).inflate(numValueOf.intValue(), viewGroup, false) : null;
        }
        this.f19423D = viewInflate != null;
        this.f19426F = viewInflate;
        if (viewInflate == null || !r.a(viewInflate)) {
            this.f19451c.setFlags(131072, 131072);
        } else {
            this.f19451c.clearFlags(131072);
        }
        if (this.f19425E) {
            j();
        }
        if (viewInflate == null) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f19451c.findViewById(l3.h.f18431f);
        viewGroup.setVisibility(0);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -2));
        if (this.f19421C) {
            frameLayout.setPadding(this.f19495y, this.f19497z, this.f19417A, this.f19419B);
        } else {
            frameLayout.setPaddingRelative(0, 0, 0, 0);
        }
        if (this.f19435O != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            LinearLayoutCompat.a aVar = layoutParams instanceof LinearLayoutCompat.a ? (LinearLayoutCompat.a) layoutParams : null;
            if (aVar != null) {
                ((LinearLayout.LayoutParams) aVar).weight = 0.0f;
            }
        }
    }

    private final double p() {
        ListAdapter adapter;
        double dCeil = this.f19485t != null ? 0.106d + (Math.ceil(r0.length() / 15.0d) * 0.03d) : 0.106d;
        if (this.f19487u != null) {
            dCeil += Math.ceil(r0.length() / 19.0d) * 0.023d;
        }
        if (this.f19423D) {
            dCeil += 0.3d;
        }
        if (this.f19489v != null) {
            dCeil += 0.1d;
        }
        ListView listView = this.f19435O;
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            dCeil += adapter.getCount() * 0.063d;
        }
        int i5 = this.f19439S;
        if (i5 > 0) {
            dCeil = (dCeil + (i5 * 0.11d)) - 0.3d;
        }
        int iL = l(s0()) - 1;
        return (iL <= 0 || !A()) ? dCeil : dCeil + (iL * 0.063d);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0055 A[PHI: r2 r4 r5
      0x0055: PHI (r2v5 int) = (r2v3 int), (r2v3 int), (r2v8 int), (r2v8 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0055: PHI (r4v2 int) = (r4v1 int), (r4v1 int), (r4v5 int), (r4v5 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0055: PHI (r5v1 int) = (r5v0 int), (r5v0 int), (r5v3 int), (r5v3 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void p0(android.view.View r7, android.view.View r8, android.view.View r9, android.view.View r10, android.view.View r11, android.view.View r12) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r8 == 0) goto Lc
            int r2 = r8.getVisibility()
            if (r2 != 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r9 == 0) goto L17
            int r3 = r9.getVisibility()
            if (r3 != 0) goto L17
            r3 = r0
            goto L18
        L17:
            r3 = r1
        L18:
            if (r12 == 0) goto L22
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L22
            r12 = r0
            goto L23
        L22:
            r12 = r1
        L23:
            if (r10 == 0) goto L2d
            int r10 = r10.getVisibility()
            if (r10 != 0) goto L2d
            r10 = r0
            goto L2e
        L2d:
            r10 = r1
        L2e:
            if (r11 == 0) goto L37
            int r4 = r11.getVisibility()
            if (r4 != 0) goto L37
            goto L38
        L37:
            r0 = r1
        L38:
            boolean r4 = r6.f19475o
            if (r4 == 0) goto L57
            boolean r4 = r6.f19438R
            if (r4 != 0) goto L57
            int r4 = r6.f19477p
            int r5 = r6.f19483s
            if (r2 == 0) goto L4d
            if (r3 != 0) goto L4a
            if (r12 == 0) goto L4d
        L4a:
            int r2 = r6.f19479q
            goto L4e
        L4d:
            r2 = r1
        L4e:
            if (r3 == 0) goto L55
            if (r12 == 0) goto L55
            int r12 = r6.f19481r
            goto L6b
        L55:
            r12 = r1
            goto L6b
        L57:
            int r4 = r6.f19486t0
            int r5 = r6.f19488u0
            if (r2 == 0) goto L64
            if (r3 != 0) goto L61
            if (r12 == 0) goto L64
        L61:
            int r2 = r6.f19490v0
            goto L65
        L64:
            r2 = r1
        L65:
            if (r3 == 0) goto L55
            if (r12 == 0) goto L55
            int r12 = r6.f19490v0
        L6b:
            int r3 = r6.f19484s0
            r7.setPaddingRelative(r3, r4, r3, r5)
            r6.K(r8, r2)
            r6.K(r9, r12)
            if (r10 == 0) goto L7c
            if (r0 == 0) goto L7c
            int r1 = r6.f19492w0
        L7c:
            r6.h0(r11, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.g.p0(android.view.View, android.view.View, android.view.View, android.view.View, android.view.View, android.view.View):void");
    }

    private final void q0(ViewGroup viewGroup) throws Resources.NotFoundException {
        ConstraintLayout constraintLayout;
        if (viewGroup == null || (constraintLayout = (ConstraintLayout) viewGroup.findViewById(l3.h.f18449x)) == null) {
            return;
        }
        View view = this.f19489v;
        if (view != null && view.getParent() != constraintLayout) {
            if (view.getId() == -1) {
                view.setId(View.generateViewId());
            }
            constraintLayout.addView(view, 0, new ConstraintLayout.b(0, -2));
        }
        ImageView imageView = (ImageView) this.f19451c.findViewById(l3.h.f18433h);
        this.f19430J = imageView;
        TextView textView = (TextView) this.f19451c.findViewById(l3.h.f18448w);
        this.f19431K = textView;
        textView.setText(this.f19485t);
        ImageView imageView2 = (ImageView) constraintLayout.findViewById(l3.h.f18434i);
        imageView2.setOutlineProvider(new C0231g(this.f19447a.getResources().getDimension(C0847e.f18366k)));
        imageView2.setClipToOutline(true);
        int i5 = this.f19427G;
        if (i5 != 0) {
            imageView.setImageResource(i5);
            imageView.setVisibility(0);
        } else {
            Drawable drawable = this.f19428H;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DialogInterface.OnClickListener onClickListener, g gVar, o oVar, AdapterView adapterView, View view, int i5, long j5) {
        onClickListener.onClick(gVar.f19449b, i5);
        if (oVar.x()) {
            return;
        }
        gVar.f19449b.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0() throws Resources.NotFoundException {
        NestedScrollView nestedScrollView;
        View viewFindViewById = this.f19451c.findViewById(l3.h.f18443r);
        int i5 = l3.h.f18450y;
        View viewFindViewById2 = viewFindViewById.findViewById(i5);
        int i6 = l3.h.f18430e;
        View viewFindViewById3 = viewFindViewById.findViewById(i6);
        int i7 = l3.h.f18428c;
        View viewFindViewById4 = viewFindViewById.findViewById(i7);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById.findViewById(l3.h.f18432g);
        j4.k.d(viewGroup);
        o0(viewGroup);
        ViewGroup viewGroupI = I(viewGroup.findViewById(i5), viewFindViewById2);
        ViewGroup viewGroupI2 = I(viewGroup.findViewById(i6), viewFindViewById3);
        ViewGroup viewGroupI3 = I(viewGroup.findViewById(i7), viewFindViewById4);
        n0(viewGroupI2);
        m0(viewGroupI3);
        q0(viewGroupI);
        boolean z5 = viewGroup.getVisibility() != 8;
        boolean z6 = (viewGroupI2 == null || viewGroupI2.getVisibility() == 8) ? false : true;
        boolean z7 = (viewGroupI == null || viewGroupI.getVisibility() == 8) ? 0 : 1;
        boolean z8 = (viewGroupI3 == null || viewGroupI3.getVisibility() == 8) ? false : true;
        View viewFindViewById5 = viewFindViewById.findViewById(l3.h.f18438m);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setVisibility((z6 || z5) ? 0 : 8);
        }
        if (z7 != 0 && (nestedScrollView = this.f19434N) != null) {
            nestedScrollView.setClipToPadding(true);
        }
        ListView listView = this.f19435O;
        StepOSDialogListView stepOSDialogListView = listView instanceof StepOSDialogListView ? (StepOSDialogListView) listView : null;
        if (stepOSDialogListView != null) {
            stepOSDialogListView.a(z7, z8);
        }
        if (!z5 && !this.f19473n && this.f19435O == null && viewGroupI2 != null && this.f19434N != null) {
            b0(viewGroupI2, z7 | (z8 ? 2 : 0));
        }
        ListView listView2 = this.f19435O;
        ListAdapter listAdapter = this.f19436P;
        if (listView2 != null && listAdapter != null) {
            listView2.setAdapter(listAdapter);
            int i8 = this.f19437Q;
            if (i8 > -1) {
                listView2.setItemChecked(i8, true);
                listView2.setSelection(this.f19437Q);
            }
        }
        j4.k.d(viewFindViewById);
        p0(viewFindViewById, viewGroupI, viewFindViewById5, viewGroupI2, viewGroup, viewGroupI3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(o oVar, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, g gVar, StepOSDialogListView stepOSDialogListView, AdapterView adapterView, View view, int i5, long j5) {
        boolean[] zArrE = oVar.e();
        if (zArrE != null) {
            zArrE[i5] = stepOSDialogListView.isItemChecked(i5);
        }
        onMultiChoiceClickListener.onClick(gVar.f19449b, i5, stepOSDialogListView.isItemChecked(i5));
    }

    private final int s0() {
        int i5 = !TextUtils.isEmpty(this.f19441U) ? 1 : 0;
        if (!TextUtils.isEmpty(this.f19445Y)) {
            i5 |= 2;
        }
        return !TextUtils.isEmpty(this.f19452c0) ? i5 | 4 : i5;
    }

    private final int u() {
        return (int) (r.d(this.f19447a) * 0.6d);
    }

    private final StepOSAlertDialogLayout v() {
        return (StepOSAlertDialogLayout) this.f19451c.findViewById(l3.h.f18443r);
    }

    private final boolean y() {
        View view = this.f19426F;
        return ((view == null && (view = this.f19491w) == null) || r.b(view) == null) ? false : true;
    }

    public final boolean C(KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        NestedScrollView nestedScrollView = this.f19434N;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public final boolean D(KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        NestedScrollView nestedScrollView = this.f19434N;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public final void J(boolean z5) {
        this.f19466j0 = z5;
    }

    public final void L(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null) {
            message = onClickListener != null ? this.f19422C0.obtainMessage(i5, onClickListener) : null;
        }
        if (i5 == -3) {
            this.f19452c0 = charSequence;
            this.f19454d0 = message;
            this.f19456e0 = drawable;
        } else if (i5 == -2) {
            this.f19445Y = charSequence;
            this.f19446Z = message;
            this.f19448a0 = drawable;
        } else {
            if (i5 != -1) {
                throw new IllegalArgumentException("whichButton must be one of DialogInterface.BUTTON_POSITIVE / BUTTON_NEGATIVE / BUTTON_NEUTRAL but was " + i5);
            }
            this.f19441U = charSequence;
            this.f19442V = message;
            this.f19443W = drawable;
        }
        E();
    }

    public final void M(int i5) {
        if (i5 >= 0 && i5 < 3) {
            this.f19472m0 = i5;
            E();
        } else {
            throw new IllegalArgumentException(("buttonLayout must be AUTO, HORIZONTAL or VERTICAL but was " + i5).toString());
        }
    }

    public final void N(View view) throws Resources.NotFoundException {
        View view2 = this.f19489v;
        ViewParent parent = view2 != null ? view2.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f19489v);
        }
        this.f19489v = view;
        if (this.f19425E) {
            q0((ViewGroup) this.f19451c.findViewById(l3.h.f18450y));
        }
    }

    public final void O(K2.o oVar) {
        if (j4.k.b(this.f19476o0, oVar)) {
            return;
        }
        this.f19476o0 = oVar;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutV = v();
        if (stepOSAlertDialogLayoutV != null) {
            stepOSAlertDialogLayoutV.setGlassEffect(oVar);
        }
    }

    public final void P(boolean z5) {
        this.f19474n0 = z5;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutV = v();
        if (stepOSAlertDialogLayoutV != null) {
            stepOSAlertDialogLayoutV.setGlassEnabled(z5);
        }
    }

    public final void Q(int i5) {
        this.f19458f0 = i5;
    }

    public final void R(int i5, int i6) {
        if (i5 != 0 && i5 != -1 && i5 != -2 && i5 != -3) {
            throw new IllegalArgumentException(("whichButton must be 0 or one of DialogInterface.BUTTON_* but was " + i5).toString());
        }
        if (i6 < 0 || i6 >= 4) {
            throw new IllegalArgumentException(("color must be one of StepOSAlertDialog.COLOR_NORMAL / COLOR_BLUE / COLOR_RED / COLOR_POLESTAR but was " + i6).toString());
        }
        this.f19462h0 = i5;
        this.f19464i0 = i6;
        E();
    }

    public final void S(int i5) throws Resources.NotFoundException {
        this.f19428H = null;
        this.f19427G = i5;
        ImageView imageView = this.f19430J;
        if (imageView != null) {
            if (i5 != 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(i5);
            } else {
                imageView.setVisibility(8);
            }
        }
        G();
    }

    public final void T(Drawable drawable) throws Resources.NotFoundException {
        this.f19428H = drawable;
        this.f19427G = 0;
        ImageView imageView = this.f19430J;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                imageView.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
        G();
    }

    public final void U(Drawable drawable) throws Resources.NotFoundException {
        this.f19429I = drawable;
        G();
    }

    public final void V(int i5) {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        if (i5 < 0) {
            throw new IllegalArgumentException(("maxHeight must be >= 0 but was " + i5).toString());
        }
        this.f19460g0 = i5;
        if (!this.f19425E || (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.f19451c.findViewById(l3.h.f18443r)) == null) {
            return;
        }
        if (i5 == 0) {
            i5 = u();
        }
        stepOSAlertDialogLayout.setMaxHeight(i5);
    }

    public final void W(CharSequence charSequence) throws Resources.NotFoundException {
        this.f19487u = charSequence;
        G();
    }

    public final void X(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(("messageMaxLines must be > 0 but was " + i5).toString());
        }
        if (this.f19470l0 == i5) {
            return;
        }
        this.f19470l0 = i5;
        TextView textView = this.f19432L;
        if (textView != null) {
            textView.setMaxLines(i5);
        }
    }

    public final void Y(MovementMethod movementMethod) {
        this.f19433M = movementMethod;
        TextView textView = this.f19432L;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public final void Z(boolean z5) {
        this.f19438R = z5;
    }

    public final void a0(int i5) {
        this.f19439S = i5;
    }

    public final void f0(CharSequence charSequence) throws Resources.NotFoundException {
        this.f19485t = charSequence;
        TextView textView = this.f19431K;
        if (textView != null) {
            textView.setText(charSequence);
        }
        G();
    }

    public final void g0(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(("titleMaxLines must be > 0 but was " + i5).toString());
        }
        if (this.f19468k0 == i5) {
            return;
        }
        this.f19468k0 = i5;
        TextView textView = this.f19431K;
        if (textView != null) {
            textView.setMaxLines(i5);
        }
    }

    public final void i0() {
        double dP = p();
        boolean zY = y();
        int i5 = dP < 0.33d ? zY ? l3.l.f18479b : l3.l.f18481d : dP < 0.65d ? zY ? l3.l.f18478a : l3.l.f18480c : l3.l.f18482e;
        Window window = this.f19449b.getWindow();
        if (window != null) {
            window.setWindowAnimations(i5);
        }
    }

    public final void j0(int i5) throws Resources.NotFoundException {
        this.f19491w = null;
        this.f19493x = i5;
        this.f19421C = false;
        F();
    }

    public final void k0(View view) throws Resources.NotFoundException {
        this.f19491w = view;
        this.f19493x = 0;
        this.f19421C = false;
        F();
    }

    public final void l0(View view, int i5, int i6, int i7, int i8) throws Resources.NotFoundException {
        this.f19491w = view;
        this.f19493x = 0;
        this.f19421C = true;
        this.f19495y = i5;
        this.f19497z = i6;
        this.f19417A = i7;
        this.f19419B = i8;
        F();
    }

    public final void o() {
        this.f19422C0.removeCallbacksAndMessages(null);
    }

    public final void q(final o oVar) {
        ListAdapter listAdapterB;
        int i5;
        ListAdapter pVar;
        j4.k.g(oVar, "params");
        View viewInflate = oVar.h().inflate(this.f19455e, (ViewGroup) null);
        j4.k.e(viewInflate, "null cannot be cast to non-null type com.stepos.widget.dialog.StepOSDialogListView");
        final StepOSDialogListView stepOSDialogListView = (StepOSDialogListView) viewInflate;
        if (oVar.w()) {
            i5 = this.f19461h;
            Cursor cursorG = oVar.g();
            if (cursorG == null) {
                listAdapterB = new c(this.f19447a, this.f19461h, h.b(oVar), oVar.e(), stepOSDialogListView);
            } else {
                Context context = this.f19447a;
                LayoutInflater layoutInflaterH = oVar.h();
                int i6 = this.f19461h;
                String strK = oVar.k();
                if (strK == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                String strU = oVar.u();
                if (strU == null) {
                    throw new IllegalArgumentException("isCheckedColumn is required for a multi-choice cursor");
                }
                listAdapterB = new d(context, cursorG, layoutInflaterH, i6, strK, strU, stepOSDialogListView);
                stepOSDialogListView = stepOSDialogListView;
            }
        } else if (oVar.v()) {
            i5 = this.f19463i;
            Cursor cursorG2 = oVar.g();
            listAdapterB = oVar.b();
            if (cursorG2 != null) {
                Context context2 = this.f19447a;
                int i7 = this.f19463i;
                String strK2 = oVar.k();
                if (strK2 == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                pVar = new SimpleCursorAdapter(context2, i7, cursorG2, new String[]{strK2}, new int[]{l3.h.f18436k}, 0);
            } else {
                if (listAdapterB == null) {
                    pVar = new p(this.f19447a, this.f19463i, l3.h.f18436k, h.b(oVar), oVar.l(), oVar.m());
                }
                i5 = 0;
            }
            listAdapterB = pVar;
        } else {
            int i8 = oVar.x() ? this.f19459g : this.f19457f;
            Cursor cursorG3 = oVar.g();
            listAdapterB = oVar.b();
            if (cursorG3 != null) {
                Context context3 = this.f19447a;
                String strK3 = oVar.k();
                if (strK3 == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                listAdapterB = new SimpleCursorAdapter(context3, i8, cursorG3, new String[]{strK3}, new int[]{l3.h.f18436k}, 0);
            } else {
                if (listAdapterB == null) {
                    listAdapterB = new q(this.f19447a, i8, l3.h.f18436k, h.b(oVar));
                }
                i5 = 0;
            }
            i5 = i8;
        }
        this.f19436P = listAdapterB;
        this.f19437Q = oVar.d();
        final DialogInterface.OnClickListener onClickListenerP = oVar.p();
        final DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListenerO = oVar.o();
        if (onClickListenerP != null) {
            stepOSDialogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: p3.d
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
                    g.r(onClickListenerP, this, oVar, adapterView, view, i9, j5);
                }
            });
        } else if (onMultiChoiceClickListenerO != null) {
            stepOSDialogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: p3.e
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
                    g.s(oVar, onMultiChoiceClickListenerO, this, stepOSDialogListView, adapterView, view, i9, j5);
                }
            });
        }
        AdapterView.OnItemSelectedListener onItemSelectedListenerR = oVar.r();
        if (onItemSelectedListenerR != null) {
            stepOSDialogListView.setOnItemSelectedListener(onItemSelectedListenerR);
        }
        if (i5 == this.f19459g || i5 == this.f19461h) {
            int i9 = this.f19420B0;
            stepOSDialogListView.setPaddingRelative(i9, 0, i9, 0);
            stepOSDialogListView.setSelector(androidx.core.content.a.e(this.f19447a, R.color.transparent));
        }
        if (oVar.x()) {
            stepOSDialogListView.setChoiceMode(1);
        } else if (oVar.w()) {
            stepOSDialogListView.setChoiceMode(2);
        }
        stepOSDialogListView.setDividerHeight(this.f19418A0);
        this.f19435O = stepOSDialogListView;
    }

    public final void t(o oVar) {
        u uVar;
        j4.k.g(oVar, "params");
        ArrayList<Pair<String, String>> arrayListI = oVar.i();
        if (arrayListI == null) {
            return;
        }
        View viewInflate = oVar.h().inflate(this.f19465j, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(l3.h.f18444s);
        boolean[] zArrE = oVar.e();
        if (zArrE != null) {
            uVar = new u(this.f19449b, this.f19447a, this.f19467k, arrayListI, zArrE, oVar.o());
        } else if (oVar.d() > arrayListI.size()) {
            return;
        } else {
            uVar = new u(this.f19449b, this.f19447a, this.f19469l, arrayListI, oVar.d(), oVar.p());
        }
        recyclerView.setAdapter(uVar);
        recyclerView.addItemDecoration(new e(this.f19418A0));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f19447a));
        oVar.D(viewInflate);
    }

    public final StepOSButton w(int i5) {
        if (i5 == -3) {
            return this.f19450b0;
        }
        if (i5 == -2) {
            return this.f19444X;
        }
        if (i5 != -1) {
            return null;
        }
        return this.f19440T;
    }

    public final int x(int i5) {
        TypedValue typedValue = new TypedValue();
        this.f19447a.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId;
    }

    public final void z() throws Resources.NotFoundException {
        this.f19449b.setContentView(this.f19453d);
        r0();
        this.f19425E = true;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutV = v();
        if (stepOSAlertDialogLayoutV != null) {
            stepOSAlertDialogLayoutV.setGlassEnabled(this.f19474n0);
            stepOSAlertDialogLayoutV.setGlassEffect(this.f19476o0);
        }
        i();
    }
}
