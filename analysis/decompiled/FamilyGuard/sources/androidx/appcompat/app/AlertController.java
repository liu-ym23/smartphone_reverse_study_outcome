package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import androidx.core.view.H;
import androidx.core.widget.NestedScrollView;
import g.C0728a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AlertController {

    /* renamed from: A, reason: collision with root package name */
    NestedScrollView f7415A;

    /* renamed from: C, reason: collision with root package name */
    private Drawable f7417C;

    /* renamed from: D, reason: collision with root package name */
    private ImageView f7418D;

    /* renamed from: E, reason: collision with root package name */
    private TextView f7419E;

    /* renamed from: F, reason: collision with root package name */
    private TextView f7420F;

    /* renamed from: G, reason: collision with root package name */
    private View f7421G;

    /* renamed from: H, reason: collision with root package name */
    ListAdapter f7422H;

    /* renamed from: J, reason: collision with root package name */
    private int f7424J;

    /* renamed from: K, reason: collision with root package name */
    private int f7425K;

    /* renamed from: L, reason: collision with root package name */
    int f7426L;

    /* renamed from: M, reason: collision with root package name */
    int f7427M;

    /* renamed from: N, reason: collision with root package name */
    int f7428N;

    /* renamed from: O, reason: collision with root package name */
    int f7429O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f7430P;

    /* renamed from: R, reason: collision with root package name */
    Handler f7432R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7434a;

    /* renamed from: b, reason: collision with root package name */
    final l f7435b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f7436c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7437d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f7438e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f7439f;

    /* renamed from: g, reason: collision with root package name */
    ListView f7440g;

    /* renamed from: h, reason: collision with root package name */
    private View f7441h;

    /* renamed from: i, reason: collision with root package name */
    private int f7442i;

    /* renamed from: j, reason: collision with root package name */
    private int f7443j;

    /* renamed from: k, reason: collision with root package name */
    private int f7444k;

    /* renamed from: l, reason: collision with root package name */
    private int f7445l;

    /* renamed from: m, reason: collision with root package name */
    private int f7446m;

    /* renamed from: o, reason: collision with root package name */
    Button f7448o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f7449p;

    /* renamed from: q, reason: collision with root package name */
    Message f7450q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f7451r;

    /* renamed from: s, reason: collision with root package name */
    Button f7452s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f7453t;

    /* renamed from: u, reason: collision with root package name */
    Message f7454u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f7455v;

    /* renamed from: w, reason: collision with root package name */
    Button f7456w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f7457x;

    /* renamed from: y, reason: collision with root package name */
    Message f7458y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f7459z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f7447n = false;

    /* renamed from: B, reason: collision with root package name */
    private int f7416B = 0;

    /* renamed from: I, reason: collision with root package name */
    int f7423I = -1;

    /* renamed from: Q, reason: collision with root package name */
    private int f7431Q = 0;

    /* renamed from: S, reason: collision with root package name */
    private final View.OnClickListener f7433S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        private final int f7460a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7461b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17112d2);
            this.f7461b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.f17117e2, -1);
            this.f7460a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.f17122f2, -1);
        }

        public void a(boolean z5, boolean z6) {
            if (z6 && z5) {
                return;
            }
            setPadding(getPaddingLeft(), z5 ? getPaddingTop() : this.f7460a, getPaddingRight(), z6 ? getPaddingBottom() : this.f7461b);
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
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f7448o || (message3 = alertController.f7450q) == null) ? (view != alertController.f7452s || (message2 = alertController.f7454u) == null) ? (view != alertController.f7456w || (message = alertController.f7458y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f7432R.obtainMessage(1, alertController2.f7435b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public int f7463A;

        /* renamed from: B, reason: collision with root package name */
        public int f7464B;

        /* renamed from: C, reason: collision with root package name */
        public int f7465C;

        /* renamed from: D, reason: collision with root package name */
        public int f7466D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f7468F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f7469G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f7470H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f7472J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f7473K;

        /* renamed from: L, reason: collision with root package name */
        public String f7474L;

        /* renamed from: M, reason: collision with root package name */
        public String f7475M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f7476N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f7478a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f7479b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f7481d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f7483f;

        /* renamed from: g, reason: collision with root package name */
        public View f7484g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f7485h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f7486i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f7487j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f7488k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f7489l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f7490m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f7491n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f7492o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f7493p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f7494q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f7496s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f7497t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f7498u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f7499v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f7500w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f7501x;

        /* renamed from: y, reason: collision with root package name */
        public int f7502y;

        /* renamed from: z, reason: collision with root package name */
        public View f7503z;

        /* renamed from: c, reason: collision with root package name */
        public int f7480c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f7482e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f7467E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f7471I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f7477O = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f7495r = true;

        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f7504a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i5, int i6, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i5, i6, charSequenceArr);
                this.f7504a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i5, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i5, view, viewGroup);
                boolean[] zArr = b.this.f7468F;
                if (zArr != null && zArr[i5]) {
                    this.f7504a.setItemChecked(i5, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        class C0103b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f7506a;

            /* renamed from: b, reason: collision with root package name */
            private final int f7507b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f7508c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f7509d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0103b(Context context, Cursor cursor, boolean z5, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z5);
                this.f7508c = recycleListView;
                this.f7509d = alertController;
                Cursor cursor2 = getCursor();
                this.f7506a = cursor2.getColumnIndexOrThrow(b.this.f7474L);
                this.f7507b = cursor2.getColumnIndexOrThrow(b.this.f7475M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f7506a));
                this.f7508c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f7507b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f7479b.inflate(this.f7509d.f7427M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f7511a;

            c(AlertController alertController) {
                this.f7511a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                b.this.f7501x.onClick(this.f7511a.f7435b, i5);
                if (b.this.f7470H) {
                    return;
                }
                this.f7511a.f7435b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f7513a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f7514b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f7513a = recycleListView;
                this.f7514b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                boolean[] zArr = b.this.f7468F;
                if (zArr != null) {
                    zArr[i5] = this.f7513a.isItemChecked(i5);
                }
                b.this.f7472J.onClick(this.f7514b.f7435b, i5, this.f7513a.isItemChecked(i5));
            }
        }

        public b(Context context) {
            this.f7478a = context;
            this.f7479b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            b bVar;
            AlertController alertController2;
            ListAdapter dVar;
            RecycleListView recycleListView = (RecycleListView) this.f7479b.inflate(alertController.f7426L, (ViewGroup) null);
            if (!this.f7469G) {
                bVar = this;
                alertController2 = alertController;
                int i5 = bVar.f7470H ? alertController2.f7428N : alertController2.f7429O;
                if (bVar.f7473K != null) {
                    dVar = new SimpleCursorAdapter(bVar.f7478a, i5, bVar.f7473K, new String[]{bVar.f7474L}, new int[]{R.id.text1});
                } else {
                    dVar = bVar.f7500w;
                    if (dVar == null) {
                        dVar = new d(bVar.f7478a, i5, R.id.text1, bVar.f7499v);
                    }
                }
            } else if (this.f7473K == null) {
                bVar = this;
                dVar = bVar.new a(this.f7478a, alertController.f7427M, R.id.text1, this.f7499v, recycleListView);
                recycleListView = recycleListView;
                alertController2 = alertController;
            } else {
                bVar = this;
                alertController2 = alertController;
                dVar = bVar.new C0103b(bVar.f7478a, bVar.f7473K, false, recycleListView, alertController2);
            }
            alertController2.f7422H = dVar;
            alertController2.f7423I = bVar.f7471I;
            if (bVar.f7501x != null) {
                recycleListView.setOnItemClickListener(bVar.new c(alertController2));
            } else if (bVar.f7472J != null) {
                recycleListView.setOnItemClickListener(bVar.new d(recycleListView, alertController2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = bVar.f7476N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (bVar.f7470H) {
                recycleListView.setChoiceMode(1);
            } else if (bVar.f7469G) {
                recycleListView.setChoiceMode(2);
            }
            alertController2.f7440g = recycleListView;
        }

        public void a(AlertController alertController) {
            AlertController alertController2;
            View view = this.f7484g;
            if (view != null) {
                alertController.k(view);
            } else {
                CharSequence charSequence = this.f7483f;
                if (charSequence != null) {
                    alertController.p(charSequence);
                }
                Drawable drawable = this.f7481d;
                if (drawable != null) {
                    alertController.m(drawable);
                }
                int i5 = this.f7480c;
                if (i5 != 0) {
                    alertController.l(i5);
                }
                int i6 = this.f7482e;
                if (i6 != 0) {
                    alertController.l(alertController.c(i6));
                }
            }
            CharSequence charSequence2 = this.f7485h;
            if (charSequence2 != null) {
                alertController.n(charSequence2);
            }
            CharSequence charSequence3 = this.f7486i;
            if (charSequence3 == null && this.f7487j == null) {
                alertController2 = alertController;
            } else {
                alertController.j(-1, charSequence3, this.f7488k, null, this.f7487j);
                alertController2 = alertController;
            }
            CharSequence charSequence4 = this.f7489l;
            if (charSequence4 != null || this.f7490m != null) {
                alertController2.j(-2, charSequence4, this.f7491n, null, this.f7490m);
            }
            CharSequence charSequence5 = this.f7492o;
            if (charSequence5 != null || this.f7493p != null) {
                alertController2.j(-3, charSequence5, this.f7494q, null, this.f7493p);
            }
            if (this.f7499v != null || this.f7473K != null || this.f7500w != null) {
                b(alertController2);
            }
            View view2 = this.f7503z;
            if (view2 != null) {
                if (this.f7467E) {
                    alertController2.s(view2, this.f7463A, this.f7464B, this.f7465C, this.f7466D);
                    return;
                } else {
                    alertController2.r(view2);
                    return;
                }
            }
            int i7 = this.f7502y;
            if (i7 != 0) {
                alertController2.q(i7);
            }
        }
    }

    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f7516a;

        public c(DialogInterface dialogInterface) {
            this.f7516a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == -3 || i5 == -2 || i5 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f7516a.get(), message.what);
            } else {
                if (i5 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i5, int i6, CharSequence[] charSequenceArr) {
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

    public AlertController(Context context, l lVar, Window window) {
        this.f7434a = context;
        this.f7435b = lVar;
        this.f7436c = window;
        this.f7432R = new c(lVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, g.j.f17007F, C0728a.f16839p, 0);
        this.f7424J = typedArrayObtainStyledAttributes.getResourceId(g.j.f17012G, 0);
        this.f7425K = typedArrayObtainStyledAttributes.getResourceId(g.j.f17022I, 0);
        this.f7426L = typedArrayObtainStyledAttributes.getResourceId(g.j.f17030K, 0);
        this.f7427M = typedArrayObtainStyledAttributes.getResourceId(g.j.f17034L, 0);
        this.f7428N = typedArrayObtainStyledAttributes.getResourceId(g.j.f17042N, 0);
        this.f7429O = typedArrayObtainStyledAttributes.getResourceId(g.j.f17026J, 0);
        this.f7430P = typedArrayObtainStyledAttributes.getBoolean(g.j.f17038M, true);
        this.f7437d = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17017H, 0);
        typedArrayObtainStyledAttributes.recycle();
        lVar.l(1);
    }

    static boolean a(View view) {
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
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup h(View view, View view2) {
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

    private int i() {
        int i5 = this.f7425K;
        return (i5 != 0 && this.f7431Q == 1) ? i5 : this.f7424J;
    }

    private void o(ViewGroup viewGroup, View view, int i5, int i6) {
        View viewFindViewById = this.f7436c.findViewById(g.f.f16939u);
        View viewFindViewById2 = this.f7436c.findViewById(g.f.f16938t);
        H.B0(view, i5, i6);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void t(ViewGroup viewGroup) {
        int i5;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f7448o = button;
        button.setOnClickListener(this.f7433S);
        if (TextUtils.isEmpty(this.f7449p) && this.f7451r == null) {
            this.f7448o.setVisibility(8);
            i5 = 0;
        } else {
            this.f7448o.setText(this.f7449p);
            Drawable drawable = this.f7451r;
            if (drawable != null) {
                int i6 = this.f7437d;
                drawable.setBounds(0, 0, i6, i6);
                this.f7448o.setCompoundDrawables(this.f7451r, null, null, null);
            }
            this.f7448o.setVisibility(0);
            i5 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f7452s = button2;
        button2.setOnClickListener(this.f7433S);
        if (TextUtils.isEmpty(this.f7453t) && this.f7455v == null) {
            this.f7452s.setVisibility(8);
        } else {
            this.f7452s.setText(this.f7453t);
            Drawable drawable2 = this.f7455v;
            if (drawable2 != null) {
                int i7 = this.f7437d;
                drawable2.setBounds(0, 0, i7, i7);
                this.f7452s.setCompoundDrawables(this.f7455v, null, null, null);
            }
            this.f7452s.setVisibility(0);
            i5 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f7456w = button3;
        button3.setOnClickListener(this.f7433S);
        if (TextUtils.isEmpty(this.f7457x) && this.f7459z == null) {
            this.f7456w.setVisibility(8);
        } else {
            this.f7456w.setText(this.f7457x);
            Drawable drawable3 = this.f7459z;
            if (drawable3 != null) {
                int i8 = this.f7437d;
                drawable3.setBounds(0, 0, i8, i8);
                this.f7456w.setCompoundDrawables(this.f7459z, null, null, null);
            }
            this.f7456w.setVisibility(0);
            i5 |= 4;
        }
        if (y(this.f7434a)) {
            if (i5 == 1) {
                b(this.f7448o);
            } else if (i5 == 2) {
                b(this.f7452s);
            } else if (i5 == 4) {
                b(this.f7456w);
            }
        }
        if (i5 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void u(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f7436c.findViewById(g.f.f16940v);
        this.f7415A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f7415A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f7420F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f7439f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f7415A.removeView(this.f7420F);
        if (this.f7440g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f7415A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f7415A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f7440g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void v(ViewGroup viewGroup) {
        View viewInflate = this.f7441h;
        if (viewInflate == null) {
            viewInflate = this.f7442i != 0 ? LayoutInflater.from(this.f7434a).inflate(this.f7442i, viewGroup, false) : null;
        }
        boolean z5 = viewInflate != null;
        if (!z5 || !a(viewInflate)) {
            this.f7436c.setFlags(131072, 131072);
        }
        if (!z5) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f7436c.findViewById(g.f.f16932n);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f7447n) {
            frameLayout.setPadding(this.f7443j, this.f7444k, this.f7445l, this.f7446m);
        }
        if (this.f7440g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void w(ViewGroup viewGroup) {
        if (this.f7421G != null) {
            viewGroup.addView(this.f7421G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f7436c.findViewById(g.f.f16917E).setVisibility(8);
            return;
        }
        this.f7418D = (ImageView) this.f7436c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f7438e) || !this.f7430P) {
            this.f7436c.findViewById(g.f.f16917E).setVisibility(8);
            this.f7418D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f7436c.findViewById(g.f.f16928j);
        this.f7419E = textView;
        textView.setText(this.f7438e);
        int i5 = this.f7416B;
        if (i5 != 0) {
            this.f7418D.setImageResource(i5);
            return;
        }
        Drawable drawable = this.f7417C;
        if (drawable != null) {
            this.f7418D.setImageDrawable(drawable);
        } else {
            this.f7419E.setPadding(this.f7418D.getPaddingLeft(), this.f7418D.getPaddingTop(), this.f7418D.getPaddingRight(), this.f7418D.getPaddingBottom());
            this.f7418D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f7436c.findViewById(g.f.f16937s);
        int i5 = g.f.f16918F;
        View viewFindViewById4 = viewFindViewById3.findViewById(i5);
        int i6 = g.f.f16931m;
        View viewFindViewById5 = viewFindViewById3.findViewById(i6);
        int i7 = g.f.f16929k;
        View viewFindViewById6 = viewFindViewById3.findViewById(i7);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(g.f.f16933o);
        v(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i5);
        View viewFindViewById8 = viewGroup.findViewById(i6);
        View viewFindViewById9 = viewGroup.findViewById(i7);
        ViewGroup viewGroupH = h(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupH2 = h(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupH3 = h(viewFindViewById9, viewFindViewById6);
        u(viewGroupH2);
        t(viewGroupH3);
        w(viewGroupH);
        boolean z5 = viewGroup.getVisibility() != 8;
        boolean z6 = (viewGroupH == null || viewGroupH.getVisibility() == 8) ? 0 : 1;
        boolean z7 = (viewGroupH3 == null || viewGroupH3.getVisibility() == 8) ? false : true;
        if (!z7 && viewGroupH2 != null && (viewFindViewById2 = viewGroupH2.findViewById(g.f.f16913A)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z6 != 0) {
            NestedScrollView nestedScrollView = this.f7415A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f7439f == null && this.f7440g == null) ? null : viewGroupH.findViewById(g.f.f16916D);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupH2 != null && (viewFindViewById = viewGroupH2.findViewById(g.f.f16914B)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f7440g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z6, z7);
        }
        if (!z5) {
            View view = this.f7440g;
            if (view == null) {
                view = this.f7415A;
            }
            if (view != null) {
                o(viewGroupH2, view, z6 | (z7 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f7440g;
        if (listView2 == null || (listAdapter = this.f7422H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i8 = this.f7423I;
        if (i8 > -1) {
            listView2.setItemChecked(i8, true);
            listView2.setSelection(i8);
        }
    }

    private static boolean y(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16838o, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i5) {
        TypedValue typedValue = new TypedValue();
        this.f7434a.getTheme().resolveAttribute(i5, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f7440g;
    }

    public void e() {
        this.f7435b.setContentView(i());
        x();
    }

    public boolean f(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f7415A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean g(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f7415A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void j(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f7432R.obtainMessage(i5, onClickListener);
        }
        if (i5 == -3) {
            this.f7457x = charSequence;
            this.f7458y = message;
            this.f7459z = drawable;
        } else if (i5 == -2) {
            this.f7453t = charSequence;
            this.f7454u = message;
            this.f7455v = drawable;
        } else {
            if (i5 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f7449p = charSequence;
            this.f7450q = message;
            this.f7451r = drawable;
        }
    }

    public void k(View view) {
        this.f7421G = view;
    }

    public void l(int i5) {
        this.f7417C = null;
        this.f7416B = i5;
        ImageView imageView = this.f7418D;
        if (imageView != null) {
            if (i5 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f7418D.setImageResource(this.f7416B);
            }
        }
    }

    public void m(Drawable drawable) {
        this.f7417C = drawable;
        this.f7416B = 0;
        ImageView imageView = this.f7418D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f7418D.setImageDrawable(drawable);
            }
        }
    }

    public void n(CharSequence charSequence) {
        this.f7439f = charSequence;
        TextView textView = this.f7420F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void p(CharSequence charSequence) {
        this.f7438e = charSequence;
        TextView textView = this.f7419E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(int i5) {
        this.f7441h = null;
        this.f7442i = i5;
        this.f7447n = false;
    }

    public void r(View view) {
        this.f7441h = view;
        this.f7442i = 0;
        this.f7447n = false;
    }

    public void s(View view, int i5, int i6, int i7, int i8) {
        this.f7441h = view;
        this.f7442i = 0;
        this.f7447n = true;
        this.f7443j = i5;
        this.f7444k = i6;
        this.f7445l = i7;
        this.f7446m = i8;
    }
}
