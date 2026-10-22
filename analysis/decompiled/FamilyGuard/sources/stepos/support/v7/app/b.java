package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import g.C0728a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.app.StepOSAlertController;

/* loaded from: classes.dex */
class b {

    /* renamed from: A, reason: collision with root package name */
    Handler f20664A;

    /* renamed from: a, reason: collision with root package name */
    private final Context f20667a;

    /* renamed from: b, reason: collision with root package name */
    final l f20668b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f20669c;

    /* renamed from: d, reason: collision with root package name */
    private final int f20670d;

    /* renamed from: e, reason: collision with root package name */
    ListView f20671e;

    /* renamed from: g, reason: collision with root package name */
    Button f20673g;

    /* renamed from: h, reason: collision with root package name */
    Message f20674h;

    /* renamed from: i, reason: collision with root package name */
    Button f20675i;

    /* renamed from: j, reason: collision with root package name */
    Message f20676j;

    /* renamed from: k, reason: collision with root package name */
    Button f20677k;

    /* renamed from: l, reason: collision with root package name */
    Message f20678l;

    /* renamed from: n, reason: collision with root package name */
    ListAdapter f20680n;

    /* renamed from: p, reason: collision with root package name */
    private int f20682p;

    /* renamed from: q, reason: collision with root package name */
    private int f20683q;

    /* renamed from: r, reason: collision with root package name */
    int f20684r;

    /* renamed from: s, reason: collision with root package name */
    int f20685s;

    /* renamed from: t, reason: collision with root package name */
    int f20686t;

    /* renamed from: u, reason: collision with root package name */
    int f20687u;

    /* renamed from: v, reason: collision with root package name */
    int f20688v;

    /* renamed from: w, reason: collision with root package name */
    int f20689w;

    /* renamed from: x, reason: collision with root package name */
    int f20690x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f20691y;

    /* renamed from: f, reason: collision with root package name */
    private boolean f20672f = false;

    /* renamed from: m, reason: collision with root package name */
    private int f20679m = 0;

    /* renamed from: o, reason: collision with root package name */
    int f20681o = -1;

    /* renamed from: z, reason: collision with root package name */
    private int f20692z = 0;

    /* renamed from: C, reason: collision with root package name */
    private final View.OnClickListener f20666C = new a();

    /* renamed from: B, reason: collision with root package name */
    I1.f f20665B = new I1.f();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            b bVar = b.this;
            Message messageObtain = (view != bVar.f20673g || (message3 = bVar.f20674h) == null) ? (view != bVar.f20675i || (message2 = bVar.f20676j) == null) ? (view != bVar.f20677k || (message = bVar.f20678l) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            b bVar2 = b.this;
            bVar2.f20664A.obtainMessage(1, bVar2.f20668b).sendToTarget();
        }
    }

    /* renamed from: stepos.support.v7.app.b$b, reason: collision with other inner class name */
    public static class C0241b {

        /* renamed from: A, reason: collision with root package name */
        public int f20694A;

        /* renamed from: B, reason: collision with root package name */
        public int f20695B;

        /* renamed from: C, reason: collision with root package name */
        public int f20696C;

        /* renamed from: D, reason: collision with root package name */
        public int f20697D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f20699F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f20700G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f20701H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f20703J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f20704K;

        /* renamed from: L, reason: collision with root package name */
        public String f20705L;

        /* renamed from: M, reason: collision with root package name */
        public String f20706M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f20707N;

        /* renamed from: P, reason: collision with root package name */
        public boolean f20709P;

        /* renamed from: Q, reason: collision with root package name */
        public ColorStateList[] f20710Q;

        /* renamed from: R, reason: collision with root package name */
        public ColorStateList f20711R;

        /* renamed from: S, reason: collision with root package name */
        public int f20712S;

        /* renamed from: T, reason: collision with root package name */
        public int f20713T;

        /* renamed from: U, reason: collision with root package name */
        public int f20714U;

        /* renamed from: W, reason: collision with root package name */
        public ArrayList<Pair<String, String>> f20716W;

        /* renamed from: X, reason: collision with root package name */
        public boolean f20717X;

        /* renamed from: a, reason: collision with root package name */
        public final Context f20718a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f20719b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f20721d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f20723f;

        /* renamed from: g, reason: collision with root package name */
        public View f20724g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f20725h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f20726i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f20727j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f20728k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f20729l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f20730m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f20731n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f20732o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f20733p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f20734q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f20736s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f20737t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f20738u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f20739v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f20740w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f20741x;

        /* renamed from: y, reason: collision with root package name */
        public int f20742y;

        /* renamed from: z, reason: collision with root package name */
        public View f20743z;

        /* renamed from: c, reason: collision with root package name */
        public int f20720c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f20722e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f20698E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f20702I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f20708O = true;

        /* renamed from: V, reason: collision with root package name */
        public int f20715V = 1;

        /* renamed from: r, reason: collision with root package name */
        public boolean f20735r = true;

        /* renamed from: stepos.support.v7.app.b$b$a */
        class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f20744a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i5, int i6, CharSequence[] charSequenceArr, e eVar) {
                super(context, i5, i6, charSequenceArr);
                this.f20744a = eVar;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i5, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i5, view, viewGroup);
                boolean[] zArr = C0241b.this.f20699F;
                if (zArr != null && zArr[i5]) {
                    this.f20744a.setItemChecked(i5, true);
                }
                return view2;
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$b, reason: collision with other inner class name */
        class C0242b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f20746a;

            /* renamed from: b, reason: collision with root package name */
            private final int f20747b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ e f20748c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f20749d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0242b(Context context, Cursor cursor, boolean z5, e eVar, b bVar) {
                super(context, cursor, z5);
                this.f20748c = eVar;
                this.f20749d = bVar;
                Cursor cursor2 = getCursor();
                this.f20746a = cursor2.getColumnIndexOrThrow(C0241b.this.f20705L);
                this.f20747b = cursor2.getColumnIndexOrThrow(C0241b.this.f20706M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f20746a));
                this.f20748c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f20747b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return C0241b.this.f20719b.inflate(this.f20749d.f20685s, viewGroup, false);
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$c */
        class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f20751a;

            c(b bVar) {
                this.f20751a = bVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                C0241b.this.f20741x.onClick(this.f20751a.f20668b, i5);
                if (C0241b.this.f20701H) {
                    return;
                }
                this.f20751a.f20668b.dismiss();
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$d */
        class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f20753a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f20754b;

            d(e eVar, b bVar) {
                this.f20753a = eVar;
                this.f20754b = bVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                boolean[] zArr = C0241b.this.f20699F;
                if (zArr != null) {
                    zArr[i5] = this.f20753a.isItemChecked(i5);
                }
                C0241b.this.f20703J.onClick(this.f20754b.f20668b, i5, this.f20753a.isItemChecked(i5));
            }
        }

        public C0241b(Context context) {
            this.f20718a = context;
            this.f20719b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(b bVar) {
            C0241b c0241b;
            b bVar2;
            ListAdapter dVar;
            e eVar = (e) this.f20719b.inflate(bVar.f20684r, (ViewGroup) null);
            if (!this.f20700G) {
                c0241b = this;
                bVar2 = bVar;
                int i5 = c0241b.f20701H ? bVar2.f20686t : bVar2.f20690x;
                if (c0241b.f20704K != null) {
                    dVar = new SimpleCursorAdapter(c0241b.f20718a, i5, c0241b.f20704K, new String[]{c0241b.f20705L}, new int[]{R.id.text1});
                } else {
                    dVar = c0241b.f20740w;
                    if (dVar == null) {
                        dVar = new d(c0241b.f20718a, i5, R.id.text1, c0241b.f20739v);
                    }
                }
            } else if (this.f20704K == null) {
                c0241b = this;
                dVar = c0241b.new a(this.f20718a, bVar.f20685s, R.id.text1, this.f20739v, eVar);
                eVar = eVar;
                bVar2 = bVar;
            } else {
                c0241b = this;
                bVar2 = bVar;
                dVar = c0241b.new C0242b(c0241b.f20718a, c0241b.f20704K, false, eVar, bVar2);
            }
            bVar2.f20680n = dVar;
            bVar2.f20681o = c0241b.f20702I;
            if (c0241b.f20741x != null) {
                eVar.setOnItemClickListener(c0241b.new c(bVar2));
            } else if (c0241b.f20703J != null) {
                eVar.setOnItemClickListener(c0241b.new d(eVar, bVar2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = c0241b.f20707N;
            if (onItemSelectedListener != null) {
                eVar.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (c0241b.f20701H) {
                eVar.setChoiceMode(1);
            } else if (c0241b.f20700G) {
                eVar.setChoiceMode(2);
            }
            bVar2.f20671e = eVar;
        }

        public void a(b bVar) throws Resources.NotFoundException {
            b bVar2;
            if (bVar instanceof StepOSAlertController) {
                new StepOSAlertController.g(this).b((StepOSAlertController) bVar);
                return;
            }
            View view = this.f20724g;
            if (view != null) {
                bVar.l(view);
            } else {
                CharSequence charSequence = this.f20723f;
                if (charSequence != null) {
                    bVar.s(charSequence);
                }
                Drawable drawable = this.f20721d;
                if (drawable != null) {
                    bVar.o(drawable);
                }
                int i5 = this.f20720c;
                if (i5 != 0) {
                    bVar.n(i5);
                }
                int i6 = this.f20722e;
                if (i6 != 0) {
                    bVar.n(bVar.b(i6));
                }
            }
            CharSequence charSequence2 = this.f20725h;
            if (charSequence2 != null) {
                bVar.q(charSequence2);
            }
            CharSequence charSequence3 = this.f20726i;
            if (charSequence3 == null && this.f20727j == null) {
                bVar2 = bVar;
            } else {
                bVar.h(-1, charSequence3, this.f20728k, null, this.f20727j);
                bVar2 = bVar;
            }
            CharSequence charSequence4 = this.f20729l;
            if (charSequence4 != null || this.f20730m != null) {
                bVar2.h(-2, charSequence4, this.f20731n, null, this.f20730m);
            }
            CharSequence charSequence5 = this.f20732o;
            if (charSequence5 != null || this.f20733p != null) {
                bVar2.h(-3, charSequence5, this.f20734q, null, this.f20733p);
            }
            if (this.f20739v != null || this.f20704K != null || this.f20740w != null) {
                b(bVar2);
            }
            View view2 = this.f20743z;
            if (view2 != null) {
                if (this.f20698E) {
                    bVar2.v(view2, this.f20694A, this.f20695B, this.f20696C, this.f20697D);
                    return;
                } else {
                    bVar2.u(view2);
                    return;
                }
            }
            int i7 = this.f20742y;
            if (i7 != 0) {
                bVar2.t(i7);
            }
        }
    }

    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f20756a;

        public c(DialogInterface dialogInterface) {
            this.f20756a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == -3 || i5 == -2 || i5 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f20756a.get(), message.what);
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

    public static class e extends ListView {
    }

    public b(Context context, l lVar, Window window) {
        this.f20667a = context;
        this.f20668b = lVar;
        this.f20669c = window;
        this.f20664A = new c(lVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, X4.l.f6304l, C0728a.f16839p, 0);
        this.f20682p = typedArrayObtainStyledAttributes.getResourceId(g.j.f17012G, 0);
        this.f20683q = typedArrayObtainStyledAttributes.getResourceId(g.j.f17022I, 0);
        this.f20684r = typedArrayObtainStyledAttributes.getResourceId(g.j.f17030K, 0);
        this.f20685s = typedArrayObtainStyledAttributes.getResourceId(g.j.f17034L, 0);
        this.f20686t = typedArrayObtainStyledAttributes.getResourceId(g.j.f17042N, 0);
        this.f20690x = typedArrayObtainStyledAttributes.getResourceId(g.j.f17026J, 0);
        this.f20687u = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6316n, 0);
        this.f20688v = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6322o, 0);
        this.f20689w = typedArrayObtainStyledAttributes.getResourceId(X4.l.f6328p, 0);
        this.f20691y = true;
        this.f20670d = typedArrayObtainStyledAttributes.getDimensionPixelSize(X4.l.f6340r, 0);
        typedArrayObtainStyledAttributes.recycle();
        lVar.supportRequestWindowFeature(1);
    }

    public Button a(int i5) {
        throw null;
    }

    public int b(int i5) {
        throw null;
    }

    public ListView c() {
        throw null;
    }

    public void d() {
        throw null;
    }

    public boolean e(int i5, KeyEvent keyEvent) {
        throw null;
    }

    public boolean f(int i5, KeyEvent keyEvent) {
        throw null;
    }

    public void g(boolean z5) {
        throw null;
    }

    public void h(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        throw null;
    }

    public void i(int i5) {
        throw null;
    }

    public void j(int i5, int i6) {
        throw null;
    }

    public void k(int i5, int i6, int i7, int i8) {
        throw null;
    }

    public void l(View view) {
        throw null;
    }

    public void m(int i5, int i6) {
        throw null;
    }

    public void n(int i5) {
        throw null;
    }

    public void o(Drawable drawable) {
        throw null;
    }

    public void p(int i5) {
        throw null;
    }

    public void q(CharSequence charSequence) {
        throw null;
    }

    public void r(MovementMethod movementMethod) {
        throw null;
    }

    public void s(CharSequence charSequence) {
        throw null;
    }

    public void t(int i5) {
        throw null;
    }

    public void u(View view) {
        throw null;
    }

    public void v(View view, int i5, int i6, int i7, int i8) {
        throw null;
    }
}
