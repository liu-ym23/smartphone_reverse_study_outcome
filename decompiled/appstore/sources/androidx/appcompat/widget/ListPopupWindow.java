package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.Ints;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public Runnable A;
    public final Handler B;
    public final Rect C;
    public Rect D;
    public boolean E;
    public PopupWindow F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ListAdapter f827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f838m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f839n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Drawable f845t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AdapterView.OnItemClickListener f846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f848w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final h f849x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g f850y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e f851z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f852a;

        public a(ListPopupWindow r10) {
            this.f852a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            View r10 = this.f852a.d();
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.getWindowToken() == null) goto L9;
            this.f852a.show();
            return;
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f853a;

        public b(ListPopupWindow r10) {
            this.f853a = r10;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView r10, View r11, int r12, long r13) {
            if (r12 == (-1)) goto L8;
            s r14 = this.f853a.f828c;
            if (r14 == null) goto L9;
            r14.setListSelectionHidden(false);
            return;
        L9:
            return;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView r10) {
        }
    }

    public static class c {
        @DoNotInline
        public static int a(PopupWindow r10, View r11, int r12, boolean r13) {
            return r10.getMaxAvailableHeight(r11, r12, r13);
        }
    }

    public static class d {
        @DoNotInline
        public static void a(PopupWindow r10, Rect r11) {
            r10.setEpicenterBounds(r11);
        }

        @DoNotInline
        public static void b(PopupWindow r10, boolean r11) {
            r10.setIsClippedToScreen(r11);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f854a;

        public e(ListPopupWindow r10) {
            this.f854a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f854a.b();
        }
    }

    public class f extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f855a;

        public f(ListPopupWindow r10) {
            this.f855a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.f855a.isShowing() == false) goto L6;
            this.f855a.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f855a.dismiss();
        }
    }

    public class g implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f856a;

        public g(ListPopupWindow r10) {
            this.f856a = r10;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r10, int r11) {
            if (r11 == 1) goto L5;
            return;
        L5:
            if (this.f856a.k() == false) goto L7;
            return;
        L7:
            if (this.f856a.F.getContentView() == null) goto L12;
            ListPopupWindow r12 = this.f856a;
            r12.B.removeCallbacks(r12.f848w);
            this.f856a.f848w.run();
            return;
        }
    }

    public class h implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f857a;

        public h(ListPopupWindow r10) {
            this.f857a = r10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            int r12 = r11.getAction();
            int r13 = (int) r11.getX();
            int r14 = (int) r11.getY();
            if (r12 != 0) goto L16;
            PopupWindow r15 = this.f857a.F;
            if (r15 == null) goto L16;
            if (r15.isShowing() == false) goto L16;
            if (r13 < 0) goto L16;
            if (r13 >= this.f857a.F.getWidth()) goto L16;
            if (r14 < 0) goto L16;
            if (r14 >= this.f857a.F.getHeight()) goto L16;
            ListPopupWindow r16 = this.f857a;
            r16.B.postDelayed(r16.f848w, 250);
            return false;
        L16:
            if (r12 != 1) goto L21;
            ListPopupWindow r17 = this.f857a;
            r17.B.removeCallbacks(r17.f848w);
            return false;
        L21:
            return false;
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListPopupWindow f858a;

        public i(ListPopupWindow r10) {
            this.f858a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            s r10 = this.f858a.f828c;
            if (r10 != null) goto L5;
            return;
        L5:
            if (ViewCompat.S(r10) == true) goto L7;
            return;
        L7:
            if (this.f858a.f828c.getCount() <= this.f858a.f828c.getChildCount()) goto L14;
            int r11 = this.f858a.f828c.getChildCount();
            ListPopupWindow r12 = this.f858a;
            if (r11 > r12.f840o) goto L15;
            r12.F.setInputMethodMode(2);
            this.f858a.show();
            return;
        L15:
            return;
        }
    }

    static {
    }

    public ListPopupWindow(Context r10) {
        this(r10, null, R$attr.listPopupWindowStyle);
    }

    public final int a() {
        boolean r10 = true;
        if (this.f828c != null) goto L25;
        Context r11 = this.f826a;
        this.A = new a(this);
        s r12 = c(r11, !this.E);
        this.f828c = r12;
        Drawable r13 = this.f845t;
        if (r13 == null) goto L7;
        r12.setSelector(r13);
    L7:
        this.f828c.setAdapter(this.f827b);
        this.f828c.setOnItemClickListener(this.f846u);
        this.f828c.setFocusable(true);
        this.f828c.setFocusableInTouchMode(true);
        this.f828c.setOnItemSelectedListener(new b(this));
        this.f828c.setOnScrollListener(this.f850y);
        AdapterView.OnItemSelectedListener r14 = this.f847v;
        if (r14 == null) goto L10;
        this.f828c.setOnItemSelectedListener(r14);
    L10:
        s r15 = this.f828c;
        View r16 = this.f841p;
        if (r16 == null) goto L23;
        LinearLayout r17 = new LinearLayout(r11);
        r17.setOrientation(1);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r19 = this.f842q;
        if (r19 == 0) goto L17;
        if (r19 == 1) goto L16;
        Log.e("ListPopupWindow", "Invalid hint position " + this.f842q);
    L18:
        int r20 = this.f830e;
        if (r20 < 0) goto L21;
        int r21 = Integer.MIN_VALUE;
    L22:
        r16.measure(View.MeasureSpec.makeMeasureSpec(r20, r21), 0);
        LinearLayout.LayoutParams r22 = (LinearLayout.LayoutParams) r16.getLayoutParams();
        int r23 = (r16.getMeasuredHeight() + r22.topMargin) + r22.bottomMargin;
        View r24 = r17;
    L24:
        this.F.setContentView(r24);
    L29:
        Drawable r25 = this.F.getBackground();
        if (r25 == null) goto L34;
        r25.getPadding(this.C);
        Rect r26 = this.C;
        int r27 = r26.top;
        int r28 = r26.bottom + r27;
        if (this.f834i == true) goto L36;
        this.f832g = -r27;
    L36:
        if (this.F.getInputMethodMode() == 2) goto L39;
        r10 = false;
    L39:
        int r29 = e(d(), this.f832g, r10);
        if (this.f838m == true) goto L58;
        if (this.f829d == (-1)) goto L58;
        int r30 = this.f830e;
        if (r30 != (-2)) goto L47;
        int r31 = this.f826a.getResources().getDisplayMetrics().widthPixels;
        Rect r32 = this.C;
        int r33 = View.MeasureSpec.makeMeasureSpec(r31 - (r32.left + r32.right), Integer.MIN_VALUE);
    L52:
        int r34 = this.f828c.d(r33, 0, -1, r29 - r23, -1);
        if (r34 <= 0) goto L56;
        r23 = r23 + (r28 + (this.f828c.getPaddingTop() + this.f828c.getPaddingBottom()));
    L56:
        return r34 + r23;
    L47:
        if (r30 == (-1)) goto L50;
        r33 = View.MeasureSpec.makeMeasureSpec(r30, Ints.MAX_POWER_OF_TWO);
        goto L52
    L50:
        int r35 = this.f826a.getResources().getDisplayMetrics().widthPixels;
        Rect r36 = this.C;
        r33 = View.MeasureSpec.makeMeasureSpec(r35 - (r36.left + r36.right), Ints.MAX_POWER_OF_TWO);
    L58:
        return r29 + r28;
    L34:
        this.C.setEmpty();
        r28 = 0;
        goto L36
    L21:
        r20 = 0;
        r21 = 0;
        goto L22
    L16:
        r17.addView(r15, r18);
        r17.addView(r16);
        goto L18
    L17:
        r17.addView(r16);
        r17.addView(r15, r18);
        goto L18
    L23:
        r23 = 0;
        r24 = r15;
        goto L24
    L25:
        ViewGroup r37 = (ViewGroup) this.F.getContentView();
        View r38 = this.f841p;
        if (r38 == null) goto L28;
        LinearLayout.LayoutParams r39 = (LinearLayout.LayoutParams) r38.getLayoutParams();
        r23 = (r38.getMeasuredHeight() + r39.topMargin) + r39.bottomMargin;
        goto L29
    L28:
        r23 = 0;
        goto L29
    }

    public void b() {
        s r10 = this.f828c;
        if (r10 == null) goto L6;
        r10.setListSelectionHidden(true);
        r10.requestLayout();
        return;
    }

    public s c(Context r10, boolean r11) {
        return new s(r10, r11);
    }

    public View d() {
        return this.f844s;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.F.dismiss();
        m();
        this.F.setContentView(null);
        this.f828c = null;
        this.B.removeCallbacks(this.f848w);
    }

    public final int e(View r10, int r11, boolean r12) {
        return c.a(this.F, r10, r11, r12);
    }

    public Object f() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f828c.getSelectedItem();
    }

    public long g() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.f828c.getSelectedItemId();
    }

    public Drawable getBackground() {
        return this.F.getBackground();
    }

    public int getHorizontalOffset() {
        return this.f831f;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f828c;
    }

    public int getVerticalOffset() {
        if (this.f834i == true) goto L7;
        return 0;
    L7:
        return this.f832g;
    }

    public int h() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.f828c.getSelectedItemPosition();
    }

    public View i() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f828c.getSelectedView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.F.isShowing();
    }

    public int j() {
        return this.f830e;
    }

    public boolean k() {
        if (this.F.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        return this.E;
    }

    public final void m() {
        View r10 = this.f841p;
        if (r10 == null) goto L8;
        ViewParent r11 = r10.getParent();
        if ((r11 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r11).removeView(this.f841p);
        return;
    L9:
        return;
    }

    public void n(View r10) {
        this.f844s = r10;
    }

    public void o(int r10) {
        this.F.setAnimationStyle(r10);
    }

    public void p(int r10) {
        Drawable r11 = this.F.getBackground();
        if (r11 == null) goto L5;
        r11.getPadding(this.C);
        Rect r12 = this.C;
        this.f830e = (r12.left + r12.right) + r10;
        return;
    L5:
        y(r10);
    }

    public void q(int r10) {
        this.f837l = r10;
    }

    public void r(Rect r10) {
        if (r10 == null) goto L4;
        Rect r11 = new Rect(r10);
    L5:
        this.D = r11;
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void s(int r10) {
        this.F.setInputMethodMode(r10);
    }

    public void setAdapter(ListAdapter r10) {
        DataSetObserver r11 = this.f843r;
        if (r11 != null) goto L5;
        this.f843r = new f(this);
    L8:
        this.f827b = r10;
        if (r10 == null) goto L11;
        r10.registerDataSetObserver(this.f843r);
    L11:
        s r12 = this.f828c;
        if (r12 == null) goto L15;
        r12.setAdapter(this.f827b);
        return;
    L15:
        return;
    L5:
        ListAdapter r13 = this.f827b;
        if (r13 == null) goto L8;
        r13.unregisterDataSetObserver(r11);
        goto L8
    }

    public void setBackgroundDrawable(Drawable r10) {
        this.F.setBackgroundDrawable(r10);
    }

    public void setHorizontalOffset(int r10) {
        this.f831f = r10;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener r10) {
        this.F.setOnDismissListener(r10);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener r10) {
        this.f846u = r10;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener r10) {
        this.f847v = r10;
    }

    public void setVerticalOffset(int r10) {
        this.f832g = r10;
        this.f834i = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r10 = a();
        boolean r11 = k();
        androidx.core.widget.j.b(this.F, this.f833h);
        boolean r12 = true;
        if (this.F.isShowing() == true) goto L5;
        int r13 = this.f830e;
        if (r13 != (-1)) goto L48;
        r13 = -1;
    L50:
        int r14 = this.f829d;
        if (r14 != (-1)) goto L53;
        r10 = -1;
    L56:
        this.F.setWidth(r13);
        this.F.setHeight(r10);
        v(true);
        PopupWindow r15 = this.F;
        if (this.f839n == false) goto L59;
    L61:
        r12 = false;
    L62:
        r15.setOutsideTouchable(r12);
        this.F.setTouchInterceptor(this.f849x);
        if (this.f836k == false) goto L65;
        androidx.core.widget.j.a(this.F, this.f835j);
    L65:
        d.a(this.F, this.D);
        androidx.core.widget.j.c(this.F, d(), this.f831f, this.f832g, this.f837l);
        this.f828c.setSelection(-1);
        if (this.E == true) goto L68;
    L69:
        b();
    L71:
        if (this.E == true) goto L75;
        this.B.post(this.f851z);
        return;
    L75:
        return;
    L68:
        if (this.f828c.isInTouchMode() == false) goto L71;
    L59:
        if (this.f838m == true) goto L61;
    L53:
        if (r14 == (-2)) goto L56;
        r10 = r14;
        goto L56
    L48:
        if (r13 != (-2)) goto L50;
        r13 = d().getWidth();
        goto L50
    L5:
        if (ViewCompat.S(d()) == true) goto L7;
        return;
    L7:
        int r16 = this.f830e;
        if (r16 != (-1)) goto L10;
        r16 = -1;
    L12:
        int r17 = this.f829d;
        if (r17 != (-1)) goto L28;
        if (r11 == true) goto L17;
        r10 = -1;
    L17:
        if (r11 == false) goto L23;
        PopupWindow r18 = this.F;
        if (this.f830e != (-1)) goto L21;
        int r19 = -1;
    L22:
        r18.setWidth(r19);
        this.F.setHeight(0);
    L31:
        PopupWindow r20 = this.F;
        if (this.f839n == false) goto L34;
    L36:
        r12 = false;
    L37:
        r20.setOutsideTouchable(r12);
        PopupWindow r21 = this.F;
        View r22 = d();
        int r23 = this.f831f;
        int r110 = this.f832g;
        if (r16 >= 0) goto L40;
        int r111 = -1;
    L41:
        if (r10 >= 0) goto L43;
        int r112 = -1;
    L44:
        r21.update(r22, r23, r110, r111, r112);
        return;
    L43:
        r112 = r10;
        goto L44
    L40:
        r111 = r16;
        goto L41
    L34:
        if (this.f838m == true) goto L36;
    L21:
        r19 = 0;
        goto L22
    L23:
        PopupWindow r24 = this.F;
        if (this.f830e != (-1)) goto L26;
        int r25 = -1;
    L27:
        r24.setWidth(r25);
        this.F.setHeight(-1);
        goto L31
    L26:
        r25 = 0;
        goto L27
    L28:
        if (r17 == (-2)) goto L31;
        r10 = r17;
        goto L31
    L10:
        if (r16 != (-2)) goto L12;
        r16 = d().getWidth();
        goto L12
    }

    public void t(boolean r10) {
        this.E = r10;
        this.F.setFocusable(r10);
    }

    public void u(boolean r10) {
        this.f836k = true;
        this.f835j = r10;
    }

    public final void v(boolean r10) {
        d.b(this.F, r10);
    }

    public void w(int r10) {
        this.f842q = r10;
    }

    public void x(int r10) {
        s r11 = this.f828c;
        if (isShowing() == false) goto L9;
        if (r11 == null) goto L10;
        r11.setListSelectionHidden(false);
        r11.setSelection(r10);
        if (r11.getChoiceMode() == 0) goto L11;
        r11.setItemChecked(r10, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void y(int r10) {
        this.f830e = r10;
    }

    public ListPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        this(r10, r11, r12, 0);
    }

    public ListPopupWindow(Context r10, AttributeSet r11, int r12, int r13) {
        this.f829d = -2;
        this.f830e = -2;
        this.f833h = 1002;
        this.f837l = 0;
        this.f838m = false;
        this.f839n = false;
        this.f840o = Channel.UNLIMITED;
        this.f842q = 0;
        this.f848w = new i(this);
        this.f849x = new h(this);
        this.f850y = new g(this);
        this.f851z = new e(this);
        this.C = new Rect();
        this.f826a = r10;
        this.B = new Handler(r10.getMainLooper());
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.ListPopupWindow, r12, r13);
        this.f831f = r14.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int r15 = r14.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f832g = r15;
        if (r15 == 0) goto L5;
        this.f834i = true;
    L5:
        r14.recycle();
        AppCompatPopupWindow r16 = new AppCompatPopupWindow(r10, r11, r12, r13);
        this.F = r16;
        r16.setInputMethodMode(1);
    }
}
