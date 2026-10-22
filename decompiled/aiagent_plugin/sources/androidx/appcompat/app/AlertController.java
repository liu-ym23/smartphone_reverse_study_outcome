package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    private int A;
    private boolean B;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private Drawable f181J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R;
    private final View.OnClickListener S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AppCompatDialog f182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ListView f183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Button f184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Message f185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Button f186e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;

    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface r3) {
            this.mDialog = new WeakReference((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            int r0 = r4.what;
            if (r0 != (-3)) goto L5;
        L12:
            ((DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(r4.obj, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin")).onClick((DialogInterface) ZeusTransformUtils.preCheckCast(this.mDialog.get(), DialogInterface.class, "com.obric.aiagent.plugin"), r4.what);
            return;
        L5:
            if (r0 == (-2)) goto L12;
            if (r0 == (-1)) goto L12;
            if (r0 != 1) goto L15;
            ((DialogInterface) ZeusTransformUtils.preCheckCast(r4.obj, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
            return;
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context r3, int r4, int r5, CharSequence[] r6) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        }
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context r3) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
        }

        public RecycleListView(Context r4, AttributeSet r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r6, r7);
            TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.RecycleListView_paddingBottomNoButtons, "styleable", "RecycleListView_paddingBottomNoButtons"), -1);
            this.mPaddingTopNoTitle = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.RecycleListView_paddingTopNoTitle, "styleable", "RecycleListView_paddingTopNoTitle"), -1);
        }

        public void setHasDecor(boolean r3, boolean r4) {
            if (r4 == false) goto L4;
            if (r3 == false) goto L4;
            return;
        L4:
            int r0 = getPaddingLeft();
            if (r3 == false) goto L7;
            int r5 = getPaddingTop();
        L8:
            int r1 = getPaddingRight();
            if (r4 == false) goto L11;
            int r6 = getPaddingBottom();
        L12:
            setPadding(r0, r5, r1, r6);
            return;
        L11:
            r6 = this.mPaddingBottomNoButtons;
            goto L12
        L7:
            r5 = this.mPaddingTopNoTitle;
            goto L8
        }
    }

    public static class a {
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
        public DialogInterface.OnMultiChoiceClickListener f196J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0007a O;
        public boolean P;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f201e;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$a$a, reason: collision with other inner class name */
        public interface InterfaceC0007a {
            void a(ListView r1);
        }

        public a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f199c = 0;
            this.f201e = 0;
            this.E = false;
            this.I = -1;
            this.P = true;
            this.f197a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            this.r = true;
            this.f198b = (LayoutInflater) ZeusTransformUtils.preCheckCast(r5.getSystemService("layout_inflater"), LayoutInflater.class, "com.obric.aiagent.plugin");
        }

        public void a(AlertController r14) {
            View r0 = this.g;
            if (r0 == null) goto L5;
            r14.b(r0);
        L17:
            CharSequence r1 = this.h;
            if (r1 == null) goto L20;
            r14.b(r1);
        L20:
            CharSequence r3 = this.i;
            if (r3 == null) goto L23;
        L24:
            r14.a(-1, r3, this.k, null, this.j);
        L25:
            CharSequence r9 = this.l;
            if (r9 == null) goto L28;
        L29:
            r14.a(-2, r9, this.n, null, this.m);
        L30:
            CharSequence r2 = this.o;
            if (r2 == null) goto L33;
        L34:
            r14.a(-3, r2, this.q, null, this.p);
        L36:
            if (this.v == null) goto L38;
        L41:
            b(r14);
        L42:
            View r4 = this.z;
            if (r4 != null) goto L45;
            int r13 = this.y;
            if (r13 == 0) goto L54;
            r14.a(r13);
            return;
        L54:
            return;
        L45:
            if (this.E == false) goto L47;
            r14.a(r4, this.A, this.B, this.C, this.D);
            return;
        L47:
            r14.c(r4);
            return;
        L38:
            if (this.K != null) goto L41;
            if (this.w == null) goto L42;
        L33:
            if (this.p == null) goto L36;
        L28:
            if (this.m == null) goto L30;
        L23:
            if (this.j == null) goto L25;
        L5:
            CharSequence r5 = this.f;
            if (r5 == null) goto L8;
            r14.a(r5);
        L8:
            Drawable r6 = this.f200d;
            if (r6 == null) goto L11;
            r14.a(r6);
        L11:
            int r7 = this.f199c;
            if (r7 == 0) goto L14;
            r14.c(r7);
        L14:
            int r8 = this.f201e;
            if (r8 == 0) goto L17;
            r14.c(r14.d(r8));
            goto L17
        }

        private void b(final AlertController r11) {
            final RecycleListView r0 = (RecycleListView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.f198b, r11.l, null, "com.obric.aiagent.plugin"), RecycleListView.class, "com.obric.aiagent.plugin");
            if (this.G == false) goto L9;
            if (this.K != null) goto L7;
            final Context r3 = this.f197a;
            final int r4 = r11.m;
            final int r5 = android.R.id.text1;
            final CharSequence[] r6 = this.v;
            ListAdapter r9 = new AlertController$AlertParams$1(this, r3, r4, r5, r6, r0);
        L19:
            InterfaceC0007a r1 = this.O;
            if (r1 == null) goto L22;
            r1.a(r0);
        L22:
            r11.j = r9;
            r11.k = this.I;
            if (this.x == null) goto L26;
            r0.setOnItemClickListener(new AlertController$AlertParams$3(this, r11));
        L28:
            AdapterView.OnItemSelectedListener r2 = this.N;
            if (r2 == null) goto L32;
            r0.setOnItemSelectedListener(r2);
        L32:
            if (this.H == false) goto L35;
            r0.setChoiceMode(1);
        L37:
            r11.f183b = r0;
            return;
        L35:
            if (this.G == false) goto L37;
            r0.setChoiceMode(2);
            goto L37
        L26:
            if (this.f196J == null) goto L28;
            r0.setOnItemClickListener(new AlertController$AlertParams$4(this, r0, r11));
            goto L28
        L7:
            final Context r7 = this.f197a;
            final Cursor r8 = this.K;
            final boolean r10 = false;
            r9 = new AlertController$AlertParams$2(this, r7, r8, r10, r0, r11);
            goto L19
        L9:
            if (this.H == false) goto L11;
            int r12 = r11.n;
        L12:
            int r13 = r12;
            if (this.K == null) goto L15;
            r9 = new SimpleCursorAdapter(this.f197a, r13, this.K, new String[]{this.L}, new int[]{android.R.id.text1});
            goto L19
        L15:
            r9 = this.w;
            if (r9 != null) goto L19;
            r9 = new CheckedItemAdapter(this.f197a, r13, android.R.id.text1, this.v);
            goto L19
        L11:
            r12 = r11.o;
            goto L12
        }
    }

    private static boolean a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        TypedValue r0 = new TypedValue();
        r5.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.alertDialogCenterButtons, "attr", "alertDialogCenterButtons"), r0, true);
        if (r0.data != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public AlertController(Context r5, AppCompatDialog r6, Window r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        this.B = false;
        this.I = 0;
        this.k = -1;
        this.R = 0;
        this.S = new AnonymousClass1(this);
        this.q = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f182a = r6;
        this.r = r7;
        this.p = new ButtonHandler(r6);
        TypedArray r9 = r8.obtainStyledAttributes(null, R.styleable.AlertDialog, ZeusTransformUtils.mapRes(R.attr.alertDialogStyle, "attr", "alertDialogStyle"), 0);
        this.O = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_android_layout, "styleable", "AlertDialog_android_layout"), 0);
        this.P = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_buttonPanelSideLayout, "styleable", "AlertDialog_buttonPanelSideLayout"), 0);
        this.l = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_listLayout, "styleable", "AlertDialog_listLayout"), 0);
        this.m = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_multiChoiceItemLayout, "styleable", "AlertDialog_multiChoiceItemLayout"), 0);
        this.n = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_singleChoiceItemLayout, "styleable", "AlertDialog_singleChoiceItemLayout"), 0);
        this.o = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_listItemLayout, "styleable", "AlertDialog_listItemLayout"), 0);
        this.Q = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_showTitle, "styleable", "AlertDialog_showTitle"), true);
        this.s = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.AlertDialog_buttonIconDimen, "styleable", "AlertDialog_buttonIconDimen"), 0);
        r9.recycle();
        r6.supportRequestWindowFeature(1);
    }

    static boolean a(View r4) {
        if (r4.onCheckIsTextEditor() == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L8;
        return false;
    L8:
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        int r0 = r5.getChildCount();
    L9:
        if (r0 <= 0) goto L13;
        r0 = r0 - 1;
        if (a(r5.getChildAt(r0)) == false) goto L9;
        return true;
    L13:
        return false;
    }

    public void a() {
        int r0 = c();
        this.f182a.setContentView(r0);
        d();
    }

    private int c() {
        int r0 = this.P;
        if (r0 != 0) goto L7;
        return this.O;
    L7:
        if (this.R != 1) goto L10;
        return r0;
    L10:
        return this.O;
    }

    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.t = r4;
        TextView r2 = this.L;
        if (r2 == null) goto L6;
        r2.setText(r4);
        return;
    }

    public void b(View r1) {
        this.N = r1;
    }

    public void b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.u = r4;
        TextView r2 = this.M;
        if (r2 == null) goto L6;
        r2.setText(r4);
        return;
    }

    public void a(int r2) {
        this.v = null;
        this.w = r2;
        this.B = false;
    }

    public void c(View r1) {
        this.v = r1;
        this.w = 0;
        this.B = false;
    }

    public void a(View r1, int r2, int r3, int r4, int r5) {
        this.v = r1;
        this.w = 0;
        this.B = true;
        this.x = r2;
        this.y = r3;
        this.z = r4;
        this.A = r5;
    }

    public void b(int r1) {
        this.R = r1;
    }

    public void a(int r3, CharSequence r4, DialogInterface.OnClickListener r5, Message r6, Drawable r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r9 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        if (r9 == null) goto L7;
        r6 = this.p.obtainMessage(r3, r9);
    L7:
        if (r3 != (-3)) goto L9;
        this.G = r8;
        this.h = r6;
        this.H = r7;
        return;
    L9:
        if (r3 != (-2)) goto L11;
        this.E = r8;
        this.f = r6;
        this.F = r7;
        return;
    L11:
        if (r3 != (-1)) goto L14;
        this.C = r8;
        this.f185d = r6;
        this.D = r7;
        return;
    L14:
        throw new IllegalArgumentException("Button does not exist");
    }

    public void c(int r2) {
        this.f181J = null;
        this.I = r2;
        ImageView r0 = this.K;
        if (r0 == null) goto L8;
        if (r2 == 0) goto L6;
        r0.setVisibility(0);
        this.K.setImageResource(this.I);
        return;
    L6:
        r0.setVisibility(8);
        return;
    }

    public void a(Drawable r3) {
        this.f181J = r3;
        this.I = 0;
        ImageView r1 = this.K;
        if (r1 == null) goto L8;
        if (r3 == null) goto L6;
        r1.setVisibility(0);
        this.K.setImageDrawable(r3);
        return;
    L6:
        r1.setVisibility(8);
        return;
    }

    public int d(int r3) {
        TypedValue r0 = new TypedValue();
        this.q.getTheme().resolveAttribute(r3, r0, true);
        return r0.resourceId;
    }

    public ListView b() {
        return this.f183b;
    }

    public Button e(int r2) {
        if (r2 == (-3)) goto L15;
        if (r2 == (-2)) goto L13;
        if (r2 == (-1)) goto L11;
        return null;
    L11:
        return this.f184c;
    L13:
        return this.f186e;
    L15:
        return this.g;
    }

    public boolean a(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    public boolean b(int r1, KeyEvent r2) {
        NestedScrollView r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.executeKeyEvent(r2) == false) goto L7;
        return true;
    }

    private ViewGroup a(View r3, View r4) {
        if (r3 == null) goto L5;
        if (r4 == null) goto L14;
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L14;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r4);
    L14:
        if (ZeusTransformUtils.instanceOf(r3, ViewStub.class) == false) goto L17;
        r3 = ((ViewStub) ZeusTransformUtils.preCheckCast(r3, ViewStub.class, "com.obric.aiagent.plugin")).inflate();
    L17:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ViewStub.class) == false) goto L8;
        r4 = ((ViewStub) ZeusTransformUtils.preCheckCast(r4, ViewStub.class, "com.obric.aiagent.plugin")).inflate();
    L8:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        View r0 = this.r.findViewById(ZeusTransformUtils.mapRes(R.id.parentPanel, DbHelper.COL_ID, "parentPanel"));
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.topPanel, DbHelper.COL_ID, "topPanel"));
        View r4 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.contentPanel, DbHelper.COL_ID, "contentPanel"));
        View r6 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.buttonPanel, DbHelper.COL_ID, "buttonPanel"));
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.customPanel, DbHelper.COL_ID, "customPanel")), ViewGroup.class, "com.obric.aiagent.plugin");
        a(r2);
        View r3 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.topPanel, DbHelper.COL_ID, "topPanel"));
        View r5 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.contentPanel, DbHelper.COL_ID, "contentPanel"));
        View r7 = r2.findViewById(ZeusTransformUtils.mapRes(R.id.buttonPanel, DbHelper.COL_ID, "buttonPanel"));
        ViewGroup r8 = a(r3, r1);
        ViewGroup r9 = a(r5, r4);
        ViewGroup r10 = a(r7, r6);
        c(r9);
        d(r10);
        b(r8);
        int r11 = 0;
        if (r2 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r8 != null) goto L10;
    L12:
        boolean r13 = 0;
    L13:
        if (r10 != null) goto L15;
    L17:
        boolean r14 = false;
    L18:
        if (r14 == true) goto L23;
        if (r9 == null) goto L23;
        View r15 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.textSpacerNoButtons, DbHelper.COL_ID, "textSpacerNoButtons"));
        if (r15 == null) goto L23;
        r15.setVisibility(0);
    L23:
        if (r13 == 0) goto L34;
        NestedScrollView r16 = this.i;
        if (r16 == null) goto L27;
        r16.setClipToPadding(true);
    L27:
        View r17 = null;
        if (this.u == null) goto L30;
    L31:
        r17 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.titleDividerNoCustom, DbHelper.COL_ID, "titleDividerNoCustom"));
    L32:
        if (r17 == null) goto L39;
        r17.setVisibility(0);
    L39:
        if (ZeusTransformUtils.instanceOf(this.f183b, RecycleListView.class) == false) goto L41;
        ((RecycleListView) ZeusTransformUtils.preCheckCast(this.f183b, RecycleListView.class, "com.obric.aiagent.plugin")).setHasDecor(r13, r14);
    L41:
        if (r12 == true) goto L50;
        View r18 = this.f183b;
        if (r18 != null) goto L46;
        r18 = this.i;
    L46:
        if (r18 == null) goto L50;
        if (r14 == false) goto L49;
        r11 = 2;
    L49:
        a(r9, r18, r13 | r11, 3);
    L50:
        ListView r19 = this.f183b;
        if (r19 == null) goto L58;
        ListAdapter r20 = this.j;
        if (r20 == null) goto L59;
        r19.setAdapter(r20);
        int r110 = this.k;
        if (r110 <= (-1)) goto L60;
        r19.setItemChecked(r110, true);
        r19.setSelection(r110);
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L30:
        if (this.f183b == null) goto L32;
    L34:
        if (r9 == null) goto L39;
        View r21 = r9.findViewById(ZeusTransformUtils.mapRes(R.id.textSpacerNoTitle, DbHelper.COL_ID, "textSpacerNoTitle"));
        if (r21 == null) goto L39;
        r21.setVisibility(0);
        goto L39
    L15:
        if (r10.getVisibility() == 8) goto L17;
        r14 = true;
        goto L18
    L10:
        if (r8.getVisibility() == 8) goto L12;
        r13 = 1;
        goto L13
    L5:
        if (r2.getVisibility() == 8) goto L7;
        r12 = true;
        goto L8
    }

    private void a(ViewGroup r6, View r7, int r8, int r9) {
        final View r0 = this.r.findViewById(ZeusTransformUtils.mapRes(R.id.scrollIndicatorUp, DbHelper.COL_ID, "scrollIndicatorUp"));
        final View r1 = this.r.findViewById(ZeusTransformUtils.mapRes(R.id.scrollIndicatorDown, DbHelper.COL_ID, "scrollIndicatorDown"));
        if (Build.VERSION.SDK_INT < 23) goto L10;
        ViewCompat.a(r7, r8, r9);
        if (r0 == null) goto L7;
        r6.removeView(r0);
    L7:
        if (r1 == null) goto L31;
        r6.removeView(r1);
        return;
    L31:
        return;
    L10:
        if (r0 != null) goto L12;
    L14:
        if (r1 != null) goto L16;
    L18:
        if (r0 != null) goto L21;
        if (r1 != null) goto L21;
        return;
    L21:
        if (this.u == null) goto L23;
        this.i.setOnScrollChangeListener(new AnonymousClass2(this, r0, r1));
        this.i.post(new AnonymousClass3(this, r0, r1));
        return;
    L23:
        ListView r10 = this.f183b;
        if (r10 == null) goto L26;
        r10.setOnScrollListener(new AnonymousClass4(this, r0, r1));
        this.f183b.post(new AnonymousClass5(this, r0, r1));
        return;
    L26:
        if (r0 == null) goto L28;
        r6.removeView(r0);
    L28:
        if (r1 == null) goto L36;
        r6.removeView(r1);
        return;
    L36:
        return;
    L16:
        if ((r8 & 2) != 0) goto L18;
        r6.removeView(r1);
        r1 = null;
        goto L18
    L12:
        if ((r8 & 1) != 0) goto L14;
        r6.removeView(r0);
        r0 = null;
        goto L14
    }

    private void a(ViewGroup r7) {
        View r0 = this.v;
        boolean r1 = false;
        if (r0 == null) goto L6;
    L9:
        if (r0 == null) goto L11;
        r1 = true;
    L11:
        if (r1 == true) goto L13;
    L14:
        this.r.setFlags(UiType.FLAG_PHONE_CARD, UiType.FLAG_PHONE_CARD);
    L15:
        if (r1 == false) goto L22;
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(this.r.findViewById(ZeusTransformUtils.mapRes(R.id.custom, DbHelper.COL_ID, MonitorConstants.CUSTOM)), FrameLayout.class, "com.obric.aiagent.plugin");
        r2.addView(r0, new ViewGroup.LayoutParams(-1, -1));
        if (this.B == false) goto L20;
        r2.setPadding(this.x, this.y, this.z, this.A);
    L20:
        if (this.f183b == null) goto L24;
        ((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r7.getLayoutParams(), LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin")).weight = 0.0f;
        return;
    L24:
        return;
    L22:
        r7.setVisibility(8);
        return;
    L13:
        if (a(r0) == true) goto L15;
    L6:
        if (this.w == 0) goto L8;
        r0 = ZeusTransformUtils.inflate(LayoutInflater.from(this.q), this.w, r7, false, "com.obric.aiagent.plugin");
        goto L9
    L8:
        r0 = null;
        goto L9
    }

    private void b(ViewGroup r7) {
        if (this.N == null) goto L5;
        r7.addView(this.N, 0, new ViewGroup.LayoutParams(-1, -2));
        this.r.findViewById(ZeusTransformUtils.mapRes(R.id.title_template, DbHelper.COL_ID, "title_template")).setVisibility(8);
        return;
    L5:
        this.K = (ImageView) ZeusTransformUtils.preCheckCast(this.r.findViewById(android.R.id.icon), ImageView.class, "com.obric.aiagent.plugin");
        if ((!TextUtils.isEmpty(this.t)) == true) goto L8;
    L16:
        this.r.findViewById(ZeusTransformUtils.mapRes(R.id.title_template, DbHelper.COL_ID, "title_template")).setVisibility(8);
        this.K.setVisibility(8);
        r7.setVisibility(8);
        return;
    L8:
        if (this.Q == false) goto L16;
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(this.r.findViewById(ZeusTransformUtils.mapRes(R.id.alertTitle, DbHelper.COL_ID, "alertTitle")), TextView.class, "com.obric.aiagent.plugin");
        this.L = r8;
        r8.setText(this.t);
        int r9 = this.I;
        if (r9 == 0) goto L12;
        this.K.setImageResource(r9);
        return;
    L12:
        Drawable r10 = this.f181J;
        if (r10 == null) goto L15;
        this.K.setImageDrawable(r10);
        return;
    L15:
        this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
        this.K.setVisibility(8);
    }

    private void c(ViewGroup r5) {
        NestedScrollView r0 = (NestedScrollView) ZeusTransformUtils.preCheckCast(this.r.findViewById(ZeusTransformUtils.mapRes(R.id.scrollView, DbHelper.COL_ID, "scrollView")), NestedScrollView.class, "com.obric.aiagent.plugin");
        this.i = r0;
        r0.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(android.R.id.message), TextView.class, "com.obric.aiagent.plugin");
        this.M = r1;
        if (r1 != null) goto L5;
        return;
    L5:
        CharSequence r2 = this.u;
        if (r2 == null) goto L8;
        r1.setText(r2);
        return;
    L8:
        r1.setVisibility(8);
        this.i.removeView(this.M);
        if (this.f183b == null) goto L11;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.i.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        int r3 = r6.indexOfChild(this.i);
        r6.removeViewAt(r3);
        r6.addView(this.f183b, r3, new ViewGroup.LayoutParams(-1, -1));
        return;
    L11:
        r5.setVisibility(8);
    }

    static void a(View r3, View r4, View r5) {
        int r0 = 0;
        if (r4 != null) goto L5;
    L9:
        if (r5 != null) goto L11;
        return;
    L11:
        if (r3.canScrollVertically(1) == true) goto L14;
        r0 = 4;
    L14:
        r5.setVisibility(r0);
        return;
    L5:
        if (r3.canScrollVertically(-1) == false) goto L7;
        int r2 = 0;
    L8:
        r4.setVisibility(r2);
        goto L9
    L7:
        r2 = 4;
        goto L8
    }

    private void d(ViewGroup r9) {
        Button r0 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(android.R.id.button1), Button.class, "com.obric.aiagent.plugin");
        this.f184c = r0;
        r0.setOnClickListener(this.S);
        boolean r1 = true;
        if (TextUtils.isEmpty(this.C) == true) goto L5;
    L7:
        this.f184c.setText(this.C);
        Drawable r2 = this.D;
        if (r2 == null) goto L10;
        int r6 = this.s;
        r2.setBounds(0, 0, r6, r6);
        this.f184c.setCompoundDrawables(this.D, null, null, null);
    L10:
        this.f184c.setVisibility(0);
        int r3 = 1;
    L11:
        Button r7 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(android.R.id.button2), Button.class, "com.obric.aiagent.plugin");
        this.f186e = r7;
        r7.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) == true) goto L14;
    L16:
        this.f186e.setText(this.E);
        Drawable r8 = this.F;
        if (r8 == null) goto L19;
        int r10 = this.s;
        r8.setBounds(0, 0, r10, r10);
        this.f186e.setCompoundDrawables(this.F, null, null, null);
    L19:
        this.f186e.setVisibility(0);
        r3 = r3 | 2;
    L20:
        Button r4 = (Button) ZeusTransformUtils.preCheckCast(r9.findViewById(android.R.id.button3), Button.class, "com.obric.aiagent.plugin");
        this.g = r4;
        r4.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) == true) goto L23;
    L25:
        this.g.setText(this.G);
        Drawable r5 = this.H;
        if (r5 == null) goto L28;
        int r11 = this.s;
        r5.setBounds(0, 0, r11, r11);
        this.g.setCompoundDrawables(this.H, null, null, null);
    L28:
        this.g.setVisibility(0);
        r3 = r3 | 4;
    L30:
        if (a(this.q) == false) goto L39;
        if (r3 != 1) goto L34;
        a(this.f184c);
        goto L39
    L34:
        if (r3 != 2) goto L37;
        a(this.f186e);
        goto L39
    L37:
        if (r3 != 4) goto L39;
        a(this.g);
    L39:
        if (r3 != 0) goto L42;
        r1 = false;
    L42:
        if (r1 == true) goto L45;
        r9.setVisibility(8);
        return;
    L45:
        return;
    L23:
        if (this.H != null) goto L25;
        this.g.setVisibility(8);
        goto L30
    L14:
        if (this.F != null) goto L16;
        this.f186e.setVisibility(8);
        goto L20
    L5:
        if (this.D != null) goto L7;
        this.f184c.setVisibility(8);
        r3 = 0;
        goto L11
    }

    private void a(Button r3) {
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r2.gravity = 1;
        r2.weight = 0.5f;
        r3.setLayoutParams(r2);
    }
}
