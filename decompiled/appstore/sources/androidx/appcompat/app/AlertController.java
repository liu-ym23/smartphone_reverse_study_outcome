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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.obric.capabilitykit.common.UiType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AlertController {
    public NestedScrollView A;
    public int B;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f212J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public int Q;
    public Handler R;
    public final View.OnClickListener S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Window f215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ListView f219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f225m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f226n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f227o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f228p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f229q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CharSequence f232t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Message f233u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f234v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Button f235w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f236x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Message f237y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f238z;

    public static class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f239J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;
        public OnPrepareListViewListener P;
        public boolean Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f243d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f244e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f245f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f246g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f247h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f248i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f249j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f250k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f251l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f252m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f253n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f254o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f255p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f256q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f257r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f258s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f259t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f260u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f261v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f262w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f263x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f264y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f265z;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView r10);
        }

        public class a extends ArrayAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f266a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertParams f267b;

            public a(AlertParams r10, Context r11, int r12, int r13, CharSequence[] r14, RecycleListView r15) {
                this.f267b = r10;
                this.f266a = r15;
                super(r11, r12, r13, r14);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int r10, View r11, ViewGroup r12) {
                View r13 = super.getView(r10, r11, r12);
                boolean[] r14 = this.f267b.F;
                if (r14 != null) goto L5;
            L7:
                return r13;
            L5:
                if (r14[r10] == false) goto L7;
                this.f266a.setItemChecked(r10, true);
                goto L7
            }
        }

        public class b extends CursorAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f268a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f269b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f270c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f271d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ AlertParams f272e;

            public b(AlertParams r10, Context r11, Cursor r12, boolean r13, RecycleListView r14, AlertController r15) {
                this.f272e = r10;
                this.f270c = r14;
                this.f271d = r15;
                super(r11, r12, r13);
                Cursor r16 = getCursor();
                this.f268a = r16.getColumnIndexOrThrow(r10.L);
                this.f269b = r16.getColumnIndexOrThrow(r10.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View r10, Context r11, Cursor r12) {
                ((CheckedTextView) r10.findViewById(R.id.text1)).setText(r12.getString(this.f268a));
                RecycleListView r13 = this.f270c;
                int r14 = r12.getPosition();
                int r15 = r12.getInt(this.f269b);
                boolean r16 = true;
                if (r15 == 1) goto L6;
                r16 = false;
            L6:
                r13.setItemChecked(r14, r16);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context r10, Cursor r11, ViewGroup r12) {
                return this.f272e.f241b.inflate(this.f271d.M, r12, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f273a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertParams f274b;

            public c(AlertParams r10, AlertController r11) {
                this.f274b = r10;
                this.f273a = r11;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
                this.f274b.f263x.onClick(this.f273a.f214b, r12);
                if (this.f274b.H == true) goto L6;
                this.f273a.f214b.dismiss();
                return;
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f275a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f276b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ AlertParams f277c;

            public d(AlertParams r10, RecycleListView r11, AlertController r12) {
                this.f277c = r10;
                this.f275a = r11;
                this.f276b = r12;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
                boolean[] r14 = this.f277c.F;
                if (r14 == null) goto L5;
                r14[r12] = this.f275a.isItemChecked(r12);
            L5:
                this.f277c.f239J.onClick(this.f276b.f214b, r12, this.f275a.isItemChecked(r12));
            }
        }

        public AlertParams(Context r10) {
            this.f242c = 0;
            this.f244e = 0;
            this.E = false;
            this.I = -1;
            this.Q = true;
            this.f240a = r10;
            this.f257r = true;
            this.f241b = (LayoutInflater) r10.getSystemService("layout_inflater");
        }

        public void a(AlertController r14) {
            View r10 = this.f246g;
            if (r10 == null) goto L5;
            r14.k(r10);
        L17:
            CharSequence r11 = this.f247h;
            if (r11 == null) goto L20;
            r14.n(r11);
        L20:
            CharSequence r12 = this.f248i;
            if (r12 == null) goto L23;
        L24:
            r14.j(-1, r12, this.f250k, null, this.f249j);
        L25:
            CharSequence r13 = this.f251l;
            if (r13 == null) goto L28;
        L29:
            r14.j(-2, r13, this.f253n, null, this.f252m);
        L30:
            CharSequence r15 = this.f254o;
            if (r15 == null) goto L33;
        L34:
            r14.j(-3, r15, this.f256q, null, this.f255p);
        L36:
            if (this.f261v == null) goto L38;
        L41:
            b(r14);
        L42:
            View r16 = this.f265z;
            if (r16 != null) goto L45;
            int r17 = this.f264y;
            if (r17 == 0) goto L54;
            r14.q(r17);
            return;
        L54:
            return;
        L45:
            if (this.E == false) goto L47;
            r14.s(r16, this.A, this.B, this.C, this.D);
            return;
        L47:
            r14.r(r16);
            return;
        L38:
            if (this.K != null) goto L41;
            if (this.f262w == null) goto L42;
        L33:
            if (this.f255p == null) goto L36;
        L28:
            if (this.f252m == null) goto L30;
        L23:
            if (this.f249j == null) goto L25;
        L5:
            CharSequence r18 = this.f245f;
            if (r18 == null) goto L8;
            r14.p(r18);
        L8:
            Drawable r19 = this.f243d;
            if (r19 == null) goto L11;
            r14.m(r19);
        L11:
            int r20 = this.f242c;
            if (r20 == 0) goto L14;
            r14.l(r20);
        L14:
            int r21 = this.f244e;
            if (r21 == 0) goto L17;
            r14.l(r14.c(r21));
            goto L17
        }

        public final void b(AlertController r10) {
            RecycleListView r11 = (RecycleListView) this.f241b.inflate(r10.L, null);
            if (this.G == false) goto L9;
            if (this.K != null) goto L7;
            ListAdapter r12 = new a(this, this.f240a, r10.M, R.id.text1, this.f261v, r11);
        L20:
            OnPrepareListViewListener r13 = this.P;
            if (r13 == null) goto L23;
            r13.onPrepareListView(r11);
        L23:
            r10.H = r12;
            r10.I = this.I;
            if (this.f263x == null) goto L27;
            r11.setOnItemClickListener(new c(this, r10));
        L29:
            AdapterView.OnItemSelectedListener r14 = this.O;
            if (r14 == null) goto L33;
            r11.setOnItemSelectedListener(r14);
        L33:
            if (this.H == false) goto L36;
            r11.setChoiceMode(1);
        L38:
            r10.f219g = r11;
            return;
        L36:
            if (this.G == false) goto L38;
            r11.setChoiceMode(2);
            goto L38
        L27:
            if (this.f239J == null) goto L29;
            r11.setOnItemClickListener(new d(this, r11, r10));
            goto L29
        L7:
            r12 = new b(this, this.f240a, this.K, false, r11, r10);
            goto L20
        L9:
            if (this.H == false) goto L12;
            int r15 = r10.N;
        L11:
            int r16 = r15;
            if (this.K == null) goto L16;
            r12 = new SimpleCursorAdapter(this.f240a, r16, this.K, new String[]{this.L}, new int[]{R.id.text1});
            goto L20
        L16:
            r12 = this.f262w;
            if (r12 != null) goto L20;
            r12 = new c(this.f240a, r16, R.id.text1, this.f261v);
            goto L20
        L12:
            r15 = r10.O;
            goto L11
        }
    }

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f279b;

        public RecycleListView(Context r10) {
            this(r10, null);
        }

        public void a(boolean r10, boolean r11) {
            if (r11 == false) goto L4;
            if (r10 == false) goto L4;
            return;
        L4:
            int r12 = getPaddingLeft();
            if (r10 == false) goto L7;
            int r13 = getPaddingTop();
        L8:
            int r14 = getPaddingRight();
            if (r11 == false) goto L11;
            int r15 = getPaddingBottom();
        L12:
            setPadding(r12, r13, r14, r15);
            return;
        L11:
            r15 = this.f279b;
            goto L12
        L7:
            r13 = this.f278a;
            goto L8
        }

        public RecycleListView(Context r10, AttributeSet r11) {
            super(r10, r11);
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.RecycleListView);
            this.f279b = r12.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f278a = r12.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlertController f280a;

        public a(AlertController r10) {
            this.f280a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            AlertController r11 = this.f280a;
            if (r10 != r11.f227o) goto L8;
            Message r12 = r11.f229q;
            if (r12 == null) goto L8;
            Message r13 = Message.obtain(r12);
        L18:
            if (r13 == null) goto L20;
            r13.sendToTarget();
        L20:
            AlertController r14 = this.f280a;
            r14.R.obtainMessage(1, r14.f214b).sendToTarget();
            return;
        L8:
            if (r10 != r11.f231s) goto L13;
            Message r15 = r11.f233u;
            if (r15 == null) goto L13;
            r13 = Message.obtain(r15);
        L13:
            if (r10 != r11.f235w) goto L17;
            Message r16 = r11.f237y;
            if (r16 == null) goto L17;
            r13 = Message.obtain(r16);
        L17:
            r13 = null;
            goto L18
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f281a;

        public b(DialogInterface r10) {
            this.f281a = new WeakReference(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) r10.obj).onClick((DialogInterface) this.f281a.get(), r10.what);
            return;
        L5:
            if (r11 == (-2)) goto L12;
            if (r11 == (-1)) goto L12;
            if (r11 != 1) goto L15;
            ((DialogInterface) r10.obj).dismiss();
            return;
        }
    }

    public static class c extends ArrayAdapter {
        public c(Context r10, int r11, int r12, CharSequence[] r13) {
            super(r10, r11, r12, r13);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context r10, e r11, Window r12) {
        this.f226n = false;
        this.B = 0;
        this.I = -1;
        this.Q = 0;
        this.S = new a(this);
        this.f213a = r10;
        this.f214b = r11;
        this.f215c = r12;
        this.R = new b(r11);
        TypedArray r13 = r10.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f212J = r13.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = r13.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = r13.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = r13.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = r13.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = r13.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = r13.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f216d = r13.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        r13.recycle();
        r11.supportRequestWindowFeature(1);
    }

    public static boolean a(View r10) {
        if (r10.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewGroup) == true) goto L8;
        return false;
    L8:
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
    L9:
        if (r12 <= 0) goto L13;
        r12 = r12 - 1;
        if (a(r11.getChildAt(r12)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    public static boolean y(Context r10) {
        TypedValue r11 = new TypedValue();
        r10.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, r11, true);
        if (r11.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b(Button r10) {
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10.getLayoutParams();
        r11.gravity = 1;
        r11.weight = 0.5f;
        r10.setLayoutParams(r11);
    }

    public int c(int r10) {
        TypedValue r11 = new TypedValue();
        this.f213a.getTheme().resolveAttribute(r10, r11, true);
        return r11.resourceId;
    }

    public ListView d() {
        return this.f219g;
    }

    public void e() {
        int r10 = i();
        this.f214b.setContentView(r10);
        x();
    }

    public boolean f(int r10, KeyEvent r11) {
        NestedScrollView r12 = this.A;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.executeKeyEvent(r11) == false) goto L7;
        return true;
    }

    public boolean g(int r10, KeyEvent r11) {
        NestedScrollView r12 = this.A;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.executeKeyEvent(r11) == false) goto L7;
        return true;
    }

    public final ViewGroup h(View r10, View r11) {
        if (r10 == null) goto L4;
        if (r11 == null) goto L13;
        ViewParent r12 = r11.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L13;
        ((ViewGroup) r12).removeView(r11);
    L13:
        if ((r10 instanceof ViewStub) == false) goto L16;
        r10 = ((ViewStub) r10).inflate();
    L16:
        return (ViewGroup) r10;
    L4:
        if ((r11 instanceof ViewStub) == false) goto L7;
        r11 = ((ViewStub) r11).inflate();
    L7:
        return (ViewGroup) r11;
    }

    public final int i() {
        int r10 = this.K;
        if (r10 != 0) goto L7;
        return this.f212J;
    L7:
        if (this.Q != 1) goto L10;
        return r10;
    L10:
        return this.f212J;
    }

    public void j(int r10, CharSequence r11, DialogInterface.OnClickListener r12, Message r13, Drawable r14) {
        if (r13 != null) goto L6;
        if (r12 == null) goto L6;
        r13 = this.R.obtainMessage(r10, r12);
    L6:
        if (r10 != (-3)) goto L8;
        this.f236x = r11;
        this.f237y = r13;
        this.f238z = r14;
        return;
    L8:
        if (r10 != (-2)) goto L10;
        this.f232t = r11;
        this.f233u = r13;
        this.f234v = r14;
        return;
    L10:
        if (r10 != (-1)) goto L13;
        this.f228p = r11;
        this.f229q = r13;
        this.f230r = r14;
        return;
    L13:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void k(View r10) {
        this.G = r10;
    }

    public void l(int r10) {
        this.C = null;
        this.B = r10;
        ImageView r11 = this.D;
        if (r11 == null) goto L8;
        if (r10 == 0) goto L6;
        r11.setVisibility(0);
        this.D.setImageResource(this.B);
        return;
    L6:
        r11.setVisibility(8);
        return;
    }

    public void m(Drawable r10) {
        this.C = r10;
        this.B = 0;
        ImageView r11 = this.D;
        if (r11 == null) goto L8;
        if (r10 == null) goto L6;
        r11.setVisibility(0);
        this.D.setImageDrawable(r10);
        return;
    L6:
        r11.setVisibility(8);
        return;
    }

    public void n(CharSequence r10) {
        this.f218f = r10;
        TextView r11 = this.F;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public final void o(ViewGroup r10, View r11, int r12, int r13) {
        View r14 = this.f215c.findViewById(R$id.scrollIndicatorUp);
        View r15 = this.f215c.findViewById(R$id.scrollIndicatorDown);
        ViewCompat.F0(r11, r12, r13);
        if (r14 == null) goto L5;
        r10.removeView(r14);
    L5:
        if (r15 == null) goto L8;
        r10.removeView(r15);
        return;
    }

    public void p(CharSequence r10) {
        this.f217e = r10;
        TextView r11 = this.E;
        if (r11 == null) goto L6;
        r11.setText(r10);
        return;
    }

    public void q(int r10) {
        this.f220h = null;
        this.f221i = r10;
        this.f226n = false;
    }

    public void r(View r10) {
        this.f220h = r10;
        this.f221i = 0;
        this.f226n = false;
    }

    public void s(View r10, int r11, int r12, int r13, int r14) {
        this.f220h = r10;
        this.f221i = 0;
        this.f226n = true;
        this.f222j = r11;
        this.f223k = r12;
        this.f224l = r13;
        this.f225m = r14;
    }

    public final void t(ViewGroup r10) {
        Button r11 = (Button) r10.findViewById(R.id.button1);
        this.f227o = r11;
        r11.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f228p) == true) goto L5;
    L7:
        this.f227o.setText(this.f228p);
        Drawable r12 = this.f230r;
        if (r12 == null) goto L10;
        int r13 = this.f216d;
        r12.setBounds(0, 0, r13, r13);
        this.f227o.setCompoundDrawables(this.f230r, null, null, null);
    L10:
        this.f227o.setVisibility(0);
        int r14 = 1;
    L11:
        Button r15 = (Button) r10.findViewById(R.id.button2);
        this.f231s = r15;
        r15.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f232t) == true) goto L14;
    L16:
        this.f231s.setText(this.f232t);
        Drawable r16 = this.f234v;
        if (r16 == null) goto L19;
        int r17 = this.f216d;
        r16.setBounds(0, 0, r17, r17);
        this.f231s.setCompoundDrawables(this.f234v, null, null, null);
    L19:
        this.f231s.setVisibility(0);
        r14 = r14 | 2;
    L20:
        Button r18 = (Button) r10.findViewById(R.id.button3);
        this.f235w = r18;
        r18.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f236x) == true) goto L23;
    L25:
        this.f235w.setText(this.f236x);
        Drawable r19 = this.f238z;
        if (r19 == null) goto L28;
        int r20 = this.f216d;
        r19.setBounds(0, 0, r20, r20);
        this.f235w.setCompoundDrawables(this.f238z, null, null, null);
    L28:
        this.f235w.setVisibility(0);
        r14 = r14 | 4;
    L30:
        if (y(this.f213a) == false) goto L39;
        if (r14 != 1) goto L34;
        b(this.f227o);
        goto L39
    L34:
        if (r14 != 2) goto L37;
        b(this.f231s);
        goto L39
    L37:
        if (r14 != 4) goto L39;
        b(this.f235w);
    L39:
        if (r14 != 0) goto L43;
        r10.setVisibility(8);
        return;
    L43:
        return;
    L23:
        if (this.f238z != null) goto L25;
        this.f235w.setVisibility(8);
        goto L30
    L14:
        if (this.f234v != null) goto L16;
        this.f231s.setVisibility(8);
        goto L20
    L5:
        if (this.f230r != null) goto L7;
        this.f227o.setVisibility(8);
        r14 = 0;
        goto L11
    }

    public final void u(ViewGroup r10) {
        NestedScrollView r11 = (NestedScrollView) this.f215c.findViewById(R$id.scrollView);
        this.A = r11;
        r11.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView r12 = (TextView) r10.findViewById(R.id.message);
        this.F = r12;
        if (r12 != null) goto L5;
        return;
    L5:
        CharSequence r13 = this.f218f;
        if (r13 == null) goto L8;
        r12.setText(r13);
        return;
    L8:
        r12.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f219g == null) goto L11;
        ViewGroup r14 = (ViewGroup) this.A.getParent();
        int r15 = r14.indexOfChild(this.A);
        r14.removeViewAt(r15);
        r14.addView(this.f219g, r15, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r10.setVisibility(8);
    }

    public final void v(ViewGroup r10) {
        View r11 = this.f220h;
        boolean r12 = false;
        if (r11 == null) goto L6;
    L9:
        if (r11 == null) goto L11;
        r12 = true;
    L11:
        if (r12 == true) goto L13;
    L14:
        this.f215c.setFlags(UiType.FLAG_PHONE_CARD, UiType.FLAG_PHONE_CARD);
    L15:
        if (r12 == false) goto L22;
        FrameLayout r13 = (FrameLayout) this.f215c.findViewById(R$id.custom);
        r13.addView(r11, new ViewGroup.LayoutParams(-1, -1));
        if (this.f226n == false) goto L20;
        r13.setPadding(this.f222j, this.f223k, this.f224l, this.f225m);
    L20:
        if (this.f219g == null) goto L24;
        ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) r10.getLayoutParams())).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r10.setVisibility(8);
        return;
    L13:
        if (a(r11) == true) goto L15;
    L6:
        if (this.f221i == 0) goto L8;
        r11 = LayoutInflater.from(this.f213a).inflate(this.f221i, r10, false);
        goto L9
    L8:
        r11 = null;
        goto L9
    }

    public final void w(ViewGroup r10) {
        if (this.G == null) goto L5;
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -2);
        r10.addView(this.G, 0, r11);
        this.f215c.findViewById(R$id.title_template).setVisibility(8);
        return;
    L5:
        this.D = (ImageView) this.f215c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f217e) == false) goto L8;
    L16:
        this.f215c.findViewById(R$id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        r10.setVisibility(8);
        return;
    L8:
        if (this.P == false) goto L16;
        TextView r12 = (TextView) this.f215c.findViewById(R$id.alertTitle);
        this.E = r12;
        r12.setText(this.f217e);
        int r13 = this.B;
        if (r13 == 0) goto L12;
        this.D.setImageResource(r13);
        return;
    L12:
        Drawable r14 = this.C;
        if (r14 == null) goto L15;
        this.D.setImageDrawable(r14);
        return;
    L15:
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        View r10 = this.f215c.findViewById(R$id.parentPanel);
        int r11 = R$id.topPanel;
        View r12 = r10.findViewById(r11);
        int r13 = R$id.contentPanel;
        View r14 = r10.findViewById(r13);
        int r15 = R$id.buttonPanel;
        View r16 = r10.findViewById(r15);
        ViewGroup r17 = (ViewGroup) r10.findViewById(R$id.customPanel);
        v(r17);
        View r18 = r17.findViewById(r11);
        View r19 = r17.findViewById(r13);
        View r20 = r17.findViewById(r15);
        ViewGroup r21 = h(r18, r12);
        ViewGroup r22 = h(r19, r14);
        ViewGroup r23 = h(r20, r16);
        u(r22);
        t(r23);
        w(r21);
        int r24 = 0;
        if (r17.getVisibility() == 8) goto L5;
        boolean r25 = true;
    L6:
        if (r21 != null) goto L8;
    L10:
        boolean r26 = 0;
    L11:
        if (r23 != null) goto L13;
    L15:
        boolean r27 = false;
    L16:
        if (r27 == true) goto L21;
        if (r22 == null) goto L21;
        View r28 = r22.findViewById(R$id.textSpacerNoButtons);
        if (r28 == null) goto L21;
        r28.setVisibility(0);
    L21:
        if (r26 == 0) goto L34;
        NestedScrollView r29 = this.A;
        if (r29 == null) goto L26;
        r29.setClipToPadding(true);
    L26:
        if (this.f218f == null) goto L28;
    L31:
        View r30 = r21.findViewById(R$id.titleDividerNoCustom);
    L32:
        if (r30 == null) goto L38;
        r30.setVisibility(0);
    L38:
        ListView r31 = this.f219g;
        if ((r31 instanceof RecycleListView) == false) goto L41;
        ((RecycleListView) r31).a(r26, r27);
    L41:
        if (r25 == true) goto L50;
        View r32 = this.f219g;
        if (r32 != null) goto L46;
        r32 = this.A;
    L46:
        if (r32 == null) goto L50;
        if (r27 == false) goto L49;
        r24 = 2;
    L49:
        o(r22, r32, r26 | r24, 3);
    L50:
        ListView r33 = this.f219g;
        if (r33 == null) goto L58;
        ListAdapter r34 = this.H;
        if (r34 == null) goto L59;
        r33.setAdapter(r34);
        int r35 = this.I;
        if (r35 <= (-1)) goto L60;
        r33.setItemChecked(r35, true);
        r33.setSelection(r35);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L28:
        if (this.f219g != null) goto L31;
        r30 = null;
        goto L32
    L34:
        if (r22 == null) goto L38;
        View r36 = r22.findViewById(R$id.textSpacerNoTitle);
        if (r36 == null) goto L38;
        r36.setVisibility(0);
        goto L38
    L13:
        if (r23.getVisibility() == 8) goto L15;
        r27 = true;
        goto L16
    L8:
        if (r21.getVisibility() == 8) goto L10;
        r26 = 1;
        goto L11
    L5:
        r25 = false;
        goto L6
    }
}
