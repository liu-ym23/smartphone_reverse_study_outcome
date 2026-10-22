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
import androidx.core.view.N;
import androidx.core.widget.NestedScrollView;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A, reason: collision with root package name */
    public NestedScrollView f8214A;

    /* renamed from: C, reason: collision with root package name */
    public Drawable f8216C;

    /* renamed from: D, reason: collision with root package name */
    public ImageView f8217D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f8218E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f8219F;

    /* renamed from: G, reason: collision with root package name */
    public View f8220G;

    /* renamed from: H, reason: collision with root package name */
    public ListAdapter f8221H;

    /* renamed from: J, reason: collision with root package name */
    public int f8223J;

    /* renamed from: K, reason: collision with root package name */
    public int f8224K;

    /* renamed from: L, reason: collision with root package name */
    public int f8225L;

    /* renamed from: M, reason: collision with root package name */
    public int f8226M;

    /* renamed from: N, reason: collision with root package name */
    public int f8227N;

    /* renamed from: O, reason: collision with root package name */
    public int f8228O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f8229P;

    /* renamed from: R, reason: collision with root package name */
    public Handler f8231R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f8233a;

    /* renamed from: b, reason: collision with root package name */
    public final k f8234b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f8235c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8236d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f8237e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f8238f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f8239g;

    /* renamed from: h, reason: collision with root package name */
    public View f8240h;

    /* renamed from: i, reason: collision with root package name */
    public int f8241i;

    /* renamed from: j, reason: collision with root package name */
    public int f8242j;

    /* renamed from: k, reason: collision with root package name */
    public int f8243k;

    /* renamed from: l, reason: collision with root package name */
    public int f8244l;

    /* renamed from: m, reason: collision with root package name */
    public int f8245m;

    /* renamed from: o, reason: collision with root package name */
    public Button f8247o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f8248p;

    /* renamed from: q, reason: collision with root package name */
    public Message f8249q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f8250r;

    /* renamed from: s, reason: collision with root package name */
    public Button f8251s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f8252t;

    /* renamed from: u, reason: collision with root package name */
    public Message f8253u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f8254v;

    /* renamed from: w, reason: collision with root package name */
    public Button f8255w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f8256x;

    /* renamed from: y, reason: collision with root package name */
    public Message f8257y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f8258z;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8246n = false;

    /* renamed from: B, reason: collision with root package name */
    public int f8215B = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f8222I = -1;

    /* renamed from: Q, reason: collision with root package name */
    public int f8230Q = 0;

    /* renamed from: S, reason: collision with root package name */
    public final View.OnClickListener f8232S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f8259a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8260b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f8260b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f8259a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f8259a, getPaddingRight(), z11 ? getPaddingBottom() : this.f8260b);
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
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f8247o || (message3 = alertController.f8249q) == null) ? (view != alertController.f8251s || (message2 = alertController.f8253u) == null) ? (view != alertController.f8255w || (message = alertController.f8257y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f8231R.obtainMessage(1, alertController2.f8234b).sendToTarget();
        }
    }

    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public int f8262A;

        /* renamed from: B, reason: collision with root package name */
        public int f8263B;

        /* renamed from: C, reason: collision with root package name */
        public int f8264C;

        /* renamed from: D, reason: collision with root package name */
        public int f8265D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f8267F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f8268G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f8269H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f8271J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f8272K;

        /* renamed from: L, reason: collision with root package name */
        public String f8273L;

        /* renamed from: M, reason: collision with root package name */
        public String f8274M;

        /* renamed from: N, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f8275N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f8277a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f8278b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f8280d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f8282f;

        /* renamed from: g, reason: collision with root package name */
        public View f8283g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f8284h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f8285i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f8286j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f8287k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f8288l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f8289m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f8290n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f8291o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f8292p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f8293q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f8295s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f8296t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f8297u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f8298v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f8299w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f8300x;

        /* renamed from: y, reason: collision with root package name */
        public int f8301y;

        /* renamed from: z, reason: collision with root package name */
        public View f8302z;

        /* renamed from: c, reason: collision with root package name */
        public int f8279c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f8281e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f8266E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f8270I = -1;

        /* renamed from: O, reason: collision with root package name */
        public boolean f8276O = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f8294r = true;

        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f8303a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f8303a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = b.this.f8267F;
                if (zArr != null && zArr[i10]) {
                    this.f8303a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        public class C0126b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f8305a;

            /* renamed from: b, reason: collision with root package name */
            public final int f8306b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f8307c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f8308d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0126b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f8307c = recycleListView;
                this.f8308d = alertController;
                Cursor cursor2 = getCursor();
                this.f8305a = cursor2.getColumnIndexOrThrow(b.this.f8273L);
                this.f8306b = cursor2.getColumnIndexOrThrow(b.this.f8274M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f8305a));
                this.f8307c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f8306b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f8278b.inflate(this.f8308d.f8226M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f8310a;

            public c(AlertController alertController) {
                this.f8310a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                b.this.f8300x.onClick(this.f8310a.f8234b, i10);
                if (b.this.f8269H) {
                    return;
                }
                this.f8310a.f8234b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f8312a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f8313b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f8312a = recycleListView;
                this.f8313b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = b.this.f8267F;
                if (zArr != null) {
                    zArr[i10] = this.f8312a.isItemChecked(i10);
                }
                b.this.f8271J.onClick(this.f8313b.f8234b, i10, this.f8312a.isItemChecked(i10));
            }
        }

        public b(Context context) {
            this.f8277a = context;
            this.f8278b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            AlertController alertController2;
            View view = this.f8283g;
            if (view != null) {
                alertController.k(view);
            } else {
                CharSequence charSequence = this.f8282f;
                if (charSequence != null) {
                    alertController.p(charSequence);
                }
                Drawable drawable = this.f8280d;
                if (drawable != null) {
                    alertController.m(drawable);
                }
                int i10 = this.f8279c;
                if (i10 != 0) {
                    alertController.l(i10);
                }
                int i11 = this.f8281e;
                if (i11 != 0) {
                    alertController.l(alertController.c(i11));
                }
            }
            CharSequence charSequence2 = this.f8284h;
            if (charSequence2 != null) {
                alertController.n(charSequence2);
            }
            CharSequence charSequence3 = this.f8285i;
            if (charSequence3 == null && this.f8286j == null) {
                alertController2 = alertController;
            } else {
                alertController.j(-1, charSequence3, this.f8287k, null, this.f8286j);
                alertController2 = alertController;
            }
            CharSequence charSequence4 = this.f8288l;
            if (charSequence4 != null || this.f8289m != null) {
                alertController2.j(-2, charSequence4, this.f8290n, null, this.f8289m);
            }
            CharSequence charSequence5 = this.f8291o;
            if (charSequence5 != null || this.f8292p != null) {
                alertController2.j(-3, charSequence5, this.f8293q, null, this.f8292p);
            }
            if (this.f8298v != null || this.f8272K != null || this.f8299w != null) {
                b(alertController2);
            }
            View view2 = this.f8302z;
            if (view2 != null) {
                if (this.f8266E) {
                    alertController2.s(view2, this.f8262A, this.f8263B, this.f8264C, this.f8265D);
                    return;
                } else {
                    alertController2.r(view2);
                    return;
                }
            }
            int i12 = this.f8301y;
            if (i12 != 0) {
                alertController2.q(i12);
            }
        }

        public final void b(AlertController alertController) {
            b bVar;
            AlertController alertController2;
            ListAdapter dVar;
            RecycleListView recycleListView = (RecycleListView) this.f8278b.inflate(alertController.f8225L, (ViewGroup) null);
            if (!this.f8268G) {
                bVar = this;
                alertController2 = alertController;
                int i10 = bVar.f8269H ? alertController2.f8227N : alertController2.f8228O;
                if (bVar.f8272K != null) {
                    dVar = new SimpleCursorAdapter(bVar.f8277a, i10, bVar.f8272K, new String[]{bVar.f8273L}, new int[]{R.id.text1});
                } else {
                    dVar = bVar.f8299w;
                    if (dVar == null) {
                        dVar = new d(bVar.f8277a, i10, R.id.text1, bVar.f8298v);
                    }
                }
            } else if (this.f8272K == null) {
                bVar = this;
                dVar = bVar.new a(this.f8277a, alertController.f8226M, R.id.text1, this.f8298v, recycleListView);
                recycleListView = recycleListView;
                alertController2 = alertController;
            } else {
                bVar = this;
                alertController2 = alertController;
                dVar = bVar.new C0126b(bVar.f8277a, bVar.f8272K, false, recycleListView, alertController2);
            }
            alertController2.f8221H = dVar;
            alertController2.f8222I = bVar.f8270I;
            if (bVar.f8300x != null) {
                recycleListView.setOnItemClickListener(bVar.new c(alertController2));
            } else if (bVar.f8271J != null) {
                recycleListView.setOnItemClickListener(bVar.new d(recycleListView, alertController2));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = bVar.f8275N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (bVar.f8269H) {
                recycleListView.setChoiceMode(1);
            } else if (bVar.f8268G) {
                recycleListView.setChoiceMode(2);
            }
            alertController2.f8239g = recycleListView;
        }
    }

    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f8315a;

        public c(DialogInterface dialogInterface) {
            this.f8315a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f8315a.get(), message.what);
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

    public AlertController(Context context, k kVar, Window window) {
        this.f8233a = context;
        this.f8234b = kVar;
        this.f8235c = window;
        this.f8231R = new c(kVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f8223J = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.f8224K = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f8225L = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.f8226M = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.f8227N = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.f8228O = typedArrayObtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.f8229P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f8236d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        kVar.h(1);
    }

    public static boolean a(View view) {
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

    public static boolean y(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public int c(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f8233a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f8239g;
    }

    public void e() {
        this.f8234b.setContentView(i());
        x();
    }

    public boolean f(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f8214A;
        return nestedScrollView != null && nestedScrollView.n(keyEvent);
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f8214A;
        return nestedScrollView != null && nestedScrollView.n(keyEvent);
    }

    public final ViewGroup h(View view, View view2) {
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

    public final int i() {
        int i10 = this.f8224K;
        return (i10 != 0 && this.f8230Q == 1) ? i10 : this.f8223J;
    }

    public void j(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f8231R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f8256x = charSequence;
            this.f8257y = message;
            this.f8258z = drawable;
        } else if (i10 == -2) {
            this.f8252t = charSequence;
            this.f8253u = message;
            this.f8254v = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f8248p = charSequence;
            this.f8249q = message;
            this.f8250r = drawable;
        }
    }

    public void k(View view) {
        this.f8220G = view;
    }

    public void l(int i10) {
        this.f8216C = null;
        this.f8215B = i10;
        ImageView imageView = this.f8217D;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f8217D.setImageResource(this.f8215B);
            }
        }
    }

    public void m(Drawable drawable) {
        this.f8216C = drawable;
        this.f8215B = 0;
        ImageView imageView = this.f8217D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.f8217D.setImageDrawable(drawable);
            }
        }
    }

    public void n(CharSequence charSequence) {
        this.f8238f = charSequence;
        TextView textView = this.f8219F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void o(ViewGroup viewGroup, View view, int i10, int i11) {
        View viewFindViewById = this.f8235c.findViewById(R$id.scrollIndicatorUp);
        View viewFindViewById2 = this.f8235c.findViewById(R$id.scrollIndicatorDown);
        N.z0(view, i10, i11);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    public void p(CharSequence charSequence) {
        this.f8237e = charSequence;
        TextView textView = this.f8218E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(int i10) {
        this.f8240h = null;
        this.f8241i = i10;
        this.f8246n = false;
    }

    public void r(View view) {
        this.f8240h = view;
        this.f8241i = 0;
        this.f8246n = false;
    }

    public void s(View view, int i10, int i11, int i12, int i13) {
        this.f8240h = view;
        this.f8241i = 0;
        this.f8246n = true;
        this.f8242j = i10;
        this.f8243k = i11;
        this.f8244l = i12;
        this.f8245m = i13;
    }

    public final void t(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f8247o = button;
        button.setOnClickListener(this.f8232S);
        if (TextUtils.isEmpty(this.f8248p) && this.f8250r == null) {
            this.f8247o.setVisibility(8);
            i10 = 0;
        } else {
            this.f8247o.setText(this.f8248p);
            Drawable drawable = this.f8250r;
            if (drawable != null) {
                int i11 = this.f8236d;
                drawable.setBounds(0, 0, i11, i11);
                this.f8247o.setCompoundDrawables(this.f8250r, null, null, null);
            }
            this.f8247o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f8251s = button2;
        button2.setOnClickListener(this.f8232S);
        if (TextUtils.isEmpty(this.f8252t) && this.f8254v == null) {
            this.f8251s.setVisibility(8);
        } else {
            this.f8251s.setText(this.f8252t);
            Drawable drawable2 = this.f8254v;
            if (drawable2 != null) {
                int i12 = this.f8236d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f8251s.setCompoundDrawables(this.f8254v, null, null, null);
            }
            this.f8251s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f8255w = button3;
        button3.setOnClickListener(this.f8232S);
        if (TextUtils.isEmpty(this.f8256x) && this.f8258z == null) {
            this.f8255w.setVisibility(8);
        } else {
            this.f8255w.setText(this.f8256x);
            Drawable drawable3 = this.f8258z;
            if (drawable3 != null) {
                int i13 = this.f8236d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f8255w.setCompoundDrawables(this.f8258z, null, null, null);
            }
            this.f8255w.setVisibility(0);
            i10 |= 4;
        }
        if (y(this.f8233a)) {
            if (i10 == 1) {
                b(this.f8247o);
            } else if (i10 == 2) {
                b(this.f8251s);
            } else if (i10 == 4) {
                b(this.f8255w);
            }
        }
        if (i10 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void u(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f8235c.findViewById(R$id.scrollView);
        this.f8214A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f8214A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f8219F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f8238f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f8214A.removeView(this.f8219F);
        if (this.f8239g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f8214A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f8214A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f8239g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void v(ViewGroup viewGroup) {
        View viewInflate = this.f8240h;
        if (viewInflate == null) {
            viewInflate = this.f8241i != 0 ? LayoutInflater.from(this.f8233a).inflate(this.f8241i, viewGroup, false) : null;
        }
        boolean z10 = viewInflate != null;
        if (!z10 || !a(viewInflate)) {
            this.f8235c.setFlags(SQLiteDatabase.OPEN_SHAREDCACHE, SQLiteDatabase.OPEN_SHAREDCACHE);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f8235c.findViewById(R$id.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f8246n) {
            frameLayout.setPadding(this.f8242j, this.f8243k, this.f8244l, this.f8245m);
        }
        if (this.f8239g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    public final void w(ViewGroup viewGroup) {
        if (this.f8220G != null) {
            viewGroup.addView(this.f8220G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f8235c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.f8217D = (ImageView) this.f8235c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f8237e) || !this.f8229P) {
            this.f8235c.findViewById(R$id.title_template).setVisibility(8);
            this.f8217D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f8235c.findViewById(R$id.alertTitle);
        this.f8218E = textView;
        textView.setText(this.f8237e);
        int i10 = this.f8215B;
        if (i10 != 0) {
            this.f8217D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.f8216C;
        if (drawable != null) {
            this.f8217D.setImageDrawable(drawable);
        } else {
            this.f8218E.setPadding(this.f8217D.getPaddingLeft(), this.f8217D.getPaddingTop(), this.f8217D.getPaddingRight(), this.f8217D.getPaddingBottom());
            this.f8217D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f8235c.findViewById(R$id.parentPanel);
        int i10 = R$id.topPanel;
        View viewFindViewById4 = viewFindViewById3.findViewById(i10);
        int i11 = R$id.contentPanel;
        View viewFindViewById5 = viewFindViewById3.findViewById(i11);
        int i12 = R$id.buttonPanel;
        View viewFindViewById6 = viewFindViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R$id.customPanel);
        v(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i10);
        View viewFindViewById8 = viewGroup.findViewById(i11);
        View viewFindViewById9 = viewGroup.findViewById(i12);
        ViewGroup viewGroupH = h(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupH2 = h(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupH3 = h(viewFindViewById9, viewFindViewById6);
        u(viewGroupH2);
        t(viewGroupH3);
        w(viewGroupH);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (viewGroupH == null || viewGroupH.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (viewGroupH3 == null || viewGroupH3.getVisibility() == 8) ? false : true;
        if (!z12 && viewGroupH2 != null && (viewFindViewById2 = viewGroupH2.findViewById(R$id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.f8214A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f8238f == null && this.f8239g == null) ? null : viewGroupH.findViewById(R$id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupH2 != null && (viewFindViewById = viewGroupH2.findViewById(R$id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f8239g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f8239g;
            if (view == null) {
                view = this.f8214A;
            }
            if (view != null) {
                o(viewGroupH2, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f8239g;
        if (listView2 == null || (listAdapter = this.f8221H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i13 = this.f8222I;
        if (i13 > -1) {
            listView2.setItemChecked(i13, true);
            listView2.setSelection(i13);
        }
    }
}
