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
import androidx.appcompat.R$attr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import stepos.support.v7.app.StepOSAlertController;
import stepos.support.v7.appcompat.R$styleable;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: A, reason: collision with root package name */
    public Handler f40400A;

    /* renamed from: a, reason: collision with root package name */
    public final Context f40403a;

    /* renamed from: b, reason: collision with root package name */
    public final k f40404b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f40405c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40406d;

    /* renamed from: e, reason: collision with root package name */
    public ListView f40407e;

    /* renamed from: g, reason: collision with root package name */
    public Button f40409g;

    /* renamed from: h, reason: collision with root package name */
    public Message f40410h;

    /* renamed from: i, reason: collision with root package name */
    public Button f40411i;

    /* renamed from: j, reason: collision with root package name */
    public Message f40412j;

    /* renamed from: k, reason: collision with root package name */
    public Button f40413k;

    /* renamed from: l, reason: collision with root package name */
    public Message f40414l;

    /* renamed from: n, reason: collision with root package name */
    public ListAdapter f40416n;

    /* renamed from: p, reason: collision with root package name */
    public int f40418p;

    /* renamed from: q, reason: collision with root package name */
    public int f40419q;

    /* renamed from: r, reason: collision with root package name */
    public int f40420r;

    /* renamed from: s, reason: collision with root package name */
    public int f40421s;

    /* renamed from: t, reason: collision with root package name */
    public int f40422t;

    /* renamed from: u, reason: collision with root package name */
    public int f40423u;

    /* renamed from: v, reason: collision with root package name */
    public int f40424v;

    /* renamed from: w, reason: collision with root package name */
    public int f40425w;

    /* renamed from: x, reason: collision with root package name */
    public int f40426x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f40427y;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40408f = false;

    /* renamed from: m, reason: collision with root package name */
    public int f40415m = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f40417o = -1;

    /* renamed from: z, reason: collision with root package name */
    public int f40428z = 0;

    /* renamed from: C, reason: collision with root package name */
    public final View.OnClickListener f40402C = new a();

    /* renamed from: B, reason: collision with root package name */
    public com.stepos.common.animator.f f40401B = new com.stepos.common.animator.f();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            b bVar = b.this;
            Message messageObtain = (view != bVar.f40409g || (message3 = bVar.f40410h) == null) ? (view != bVar.f40411i || (message2 = bVar.f40412j) == null) ? (view != bVar.f40413k || (message = bVar.f40414l) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            b bVar2 = b.this;
            bVar2.f40400A.obtainMessage(1, bVar2.f40404b).sendToTarget();
        }
    }

    /* renamed from: stepos.support.v7.app.b$b, reason: collision with other inner class name */
    public static class C0523b {

        /* renamed from: A, reason: collision with root package name */
        public int f40430A;

        /* renamed from: B, reason: collision with root package name */
        public int f40431B;

        /* renamed from: C, reason: collision with root package name */
        public int f40432C;

        /* renamed from: D, reason: collision with root package name */
        public int f40433D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f40435F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f40436G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f40437H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f40439J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f40440K;

        /* renamed from: L, reason: collision with root package name */
        public String f40441L;

        /* renamed from: M, reason: collision with root package name */
        public String f40442M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f40443N;

        /* renamed from: P, reason: collision with root package name */
        public boolean f40445P;

        /* renamed from: Q, reason: collision with root package name */
        public ColorStateList[] f40446Q;

        /* renamed from: R, reason: collision with root package name */
        public ColorStateList f40447R;

        /* renamed from: S, reason: collision with root package name */
        public int f40448S;

        /* renamed from: T, reason: collision with root package name */
        public int f40449T;

        /* renamed from: U, reason: collision with root package name */
        public int f40450U;

        /* renamed from: W, reason: collision with root package name */
        public ArrayList<Pair<String, String>> f40452W;

        /* renamed from: X, reason: collision with root package name */
        public boolean f40453X;

        /* renamed from: a, reason: collision with root package name */
        public final Context f40454a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f40455b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f40457d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f40459f;

        /* renamed from: g, reason: collision with root package name */
        public View f40460g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f40461h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f40462i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f40463j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f40464k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f40465l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f40466m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f40467n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f40468o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f40469p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f40470q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f40472s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f40473t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f40474u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f40475v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f40476w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f40477x;

        /* renamed from: y, reason: collision with root package name */
        public int f40478y;

        /* renamed from: z, reason: collision with root package name */
        public View f40479z;

        /* renamed from: c, reason: collision with root package name */
        public int f40456c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f40458e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f40434E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f40438I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f40444O = true;

        /* renamed from: V, reason: collision with root package name */
        public int f40451V = 1;

        /* renamed from: r, reason: collision with root package name */
        public boolean f40471r = true;

        /* renamed from: stepos.support.v7.app.b$b$a */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f40480a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, e eVar) {
                super(context, i10, i11, charSequenceArr);
                this.f40480a = eVar;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = C0523b.this.f40435F;
                if (zArr != null && zArr[i10]) {
                    this.f40480a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$b, reason: collision with other inner class name */
        public class C0524b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f40482a;

            /* renamed from: b, reason: collision with root package name */
            public final int f40483b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f40484c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ b f40485d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0524b(Context context, Cursor cursor, boolean z10, e eVar, b bVar) {
                super(context, cursor, z10);
                this.f40484c = eVar;
                this.f40485d = bVar;
                Cursor cursor2 = getCursor();
                this.f40482a = cursor2.getColumnIndexOrThrow(C0523b.this.f40441L);
                this.f40483b = cursor2.getColumnIndexOrThrow(C0523b.this.f40442M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f40482a));
                this.f40484c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f40483b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return C0523b.this.f40455b.inflate(this.f40485d.f40421s, viewGroup, false);
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$c */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f40487a;

            public c(b bVar) {
                this.f40487a = bVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                C0523b.this.f40477x.onClick(this.f40487a.f40404b, i10);
                if (C0523b.this.f40437H) {
                    return;
                }
                this.f40487a.f40404b.dismiss();
            }
        }

        /* renamed from: stepos.support.v7.app.b$b$d */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f40489a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f40490b;

            public d(e eVar, b bVar) {
                this.f40489a = eVar;
                this.f40490b = bVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = C0523b.this.f40435F;
                if (zArr != null) {
                    zArr[i10] = this.f40489a.isItemChecked(i10);
                }
                C0523b.this.f40439J.onClick(this.f40490b.f40404b, i10, this.f40489a.isItemChecked(i10));
            }
        }

        public C0523b(Context context) {
            this.f40454a = context;
            this.f40455b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(b bVar) throws Resources.NotFoundException {
            b bVar2;
            if (bVar instanceof StepOSAlertController) {
                new StepOSAlertController.g(this).b((StepOSAlertController) bVar);
                return;
            }
            View view = this.f40460g;
            if (view != null) {
                bVar.l(view);
            } else {
                CharSequence charSequence = this.f40459f;
                if (charSequence != null) {
                    bVar.s(charSequence);
                }
                Drawable drawable = this.f40457d;
                if (drawable != null) {
                    bVar.o(drawable);
                }
                int i10 = this.f40456c;
                if (i10 != 0) {
                    bVar.n(i10);
                }
                int i11 = this.f40458e;
                if (i11 != 0) {
                    bVar.n(bVar.b(i11));
                }
            }
            CharSequence charSequence2 = this.f40461h;
            if (charSequence2 != null) {
                bVar.q(charSequence2);
            }
            CharSequence charSequence3 = this.f40462i;
            if (charSequence3 == null && this.f40463j == null) {
                bVar2 = bVar;
            } else {
                bVar.h(-1, charSequence3, this.f40464k, null, this.f40463j);
                bVar2 = bVar;
            }
            CharSequence charSequence4 = this.f40465l;
            if (charSequence4 != null || this.f40466m != null) {
                bVar2.h(-2, charSequence4, this.f40467n, null, this.f40466m);
            }
            CharSequence charSequence5 = this.f40468o;
            if (charSequence5 != null || this.f40469p != null) {
                bVar2.h(-3, charSequence5, this.f40470q, null, this.f40469p);
            }
            if (this.f40475v != null || this.f40440K != null || this.f40476w != null) {
                b(bVar2);
            }
            View view2 = this.f40479z;
            if (view2 != null) {
                if (this.f40434E) {
                    bVar2.v(view2, this.f40430A, this.f40431B, this.f40432C, this.f40433D);
                    return;
                } else {
                    bVar2.u(view2);
                    return;
                }
            }
            int i12 = this.f40478y;
            if (i12 != 0) {
                bVar2.t(i12);
            }
        }

        public final void b(b bVar) {
            C0523b c0523b;
            b bVar2;
            ListAdapter dVar;
            e eVar = (e) this.f40455b.inflate(bVar.f40420r, (ViewGroup) null);
            if (!this.f40436G) {
                c0523b = this;
                bVar2 = bVar;
                int i10 = c0523b.f40437H ? bVar2.f40422t : bVar2.f40426x;
                if (c0523b.f40440K != null) {
                    dVar = new SimpleCursorAdapter(c0523b.f40454a, i10, c0523b.f40440K, new String[]{c0523b.f40441L}, new int[]{R.id.text1});
                } else {
                    dVar = c0523b.f40476w;
                    if (dVar == null) {
                        dVar = new d(c0523b.f40454a, i10, R.id.text1, c0523b.f40475v);
                    }
                }
            } else if (this.f40440K == null) {
                c0523b = this;
                dVar = c0523b.new a(this.f40454a, bVar.f40421s, R.id.text1, this.f40475v, eVar);
                eVar = eVar;
                bVar2 = bVar;
            } else {
                c0523b = this;
                bVar2 = bVar;
                dVar = c0523b.new C0524b(c0523b.f40454a, c0523b.f40440K, false, eVar, bVar2);
            }
            bVar2.f40416n = dVar;
            bVar2.f40417o = c0523b.f40438I;
            if (c0523b.f40477x != null) {
                eVar.setOnItemClickListener(c0523b.new c(bVar2));
            } else if (c0523b.f40439J != null) {
                eVar.setOnItemClickListener(c0523b.new d(eVar, bVar2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = c0523b.f40443N;
            if (onItemSelectedListener != null) {
                eVar.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (c0523b.f40437H) {
                eVar.setChoiceMode(1);
            } else if (c0523b.f40436G) {
                eVar.setChoiceMode(2);
            }
            bVar2.f40407e = eVar;
        }
    }

    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f40492a;

        public c(DialogInterface dialogInterface) {
            this.f40492a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f40492a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
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

    public static class e extends ListView {
    }

    public b(Context context, k kVar, Window window) {
        this.f40403a = context;
        this.f40404b = kVar;
        this.f40405c = window;
        this.f40400A = new c(kVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f40418p = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_android_layout, 0);
        this.f40419q = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f40420r = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_listLayout, 0);
        this.f40421s = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f40422t = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f40426x = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R$styleable.AlertDialog_listItemLayout, 0);
        this.f40423u = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiLinesChoiceItemLayout, 0);
        this.f40424v = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_recyclerViewMultiLinesLayout, 0);
        this.f40425w = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_recyclerViewMultiLinesSingleLayout, 0);
        this.f40427y = true;
        this.f40406d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_steposButtonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        kVar.supportRequestWindowFeature(1);
    }

    public Button a(int i10) {
        throw null;
    }

    public int b(int i10) {
        throw null;
    }

    public ListView c() {
        throw null;
    }

    public void d() {
        throw null;
    }

    public boolean e(int i10, KeyEvent keyEvent) {
        throw null;
    }

    public boolean f(int i10, KeyEvent keyEvent) {
        throw null;
    }

    public void g(boolean z10) {
        throw null;
    }

    public void h(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        throw null;
    }

    public void i(int i10) {
        throw null;
    }

    public void j(int i10, int i11) {
        throw null;
    }

    public void k(int i10, int i11, int i12, int i13) {
        throw null;
    }

    public void l(View view) {
        throw null;
    }

    public void m(int i10, int i11) {
        throw null;
    }

    public void n(int i10) {
        throw null;
    }

    public void o(Drawable drawable) {
        throw null;
    }

    public void p(int i10) {
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

    public void t(int i10) {
        throw null;
    }

    public void u(View view) {
        throw null;
    }

    public void v(View view, int i10, int i11, int i12, int i13) {
        throw null;
    }
}
