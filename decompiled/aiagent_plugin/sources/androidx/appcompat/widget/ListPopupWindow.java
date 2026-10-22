package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements androidx.appcompat.view.menu.f {
    private static final String TAG = "ListPopupWindow";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f368b;
    private static Method h;
    private AdapterView.OnItemClickListener A;
    private AdapterView.OnItemSelectedListener B;
    private final PopupTouchInterceptor C;
    private final PopupScrollListener D;
    private final c E;
    private Runnable F;
    private final Rect G;
    private Rect H;
    private boolean I;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    DropDownListView f369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final d f371e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private boolean u;
    private View v;
    private int w;
    private DataSetObserver x;
    private View y;
    private Drawable z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.ListPopupWindow$1, reason: invalid class name */
    class AnonymousClass1 extends ForwardingListener {
        final /* synthetic */ ListPopupWindow this$0;

        AnonymousClass1(ListPopupWindow r1, View r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public /* bridge */ /* synthetic */ androidx.appcompat.view.menu.f getPopup() {
            return getPopup();
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ListPopupWindow getPopup() {
            return this.this$0;
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        PopupDataSetObserver(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.this$0.isShowing() == false) goto L6;
            this.this$0.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dismiss();
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        }

        PopupScrollListener(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r1, int r2) {
            if (r2 == 1) goto L5;
            return;
        L5:
            if (this.this$0.g() == false) goto L7;
            return;
        L7:
            if (this.this$0.g.getContentView() == null) goto L12;
            this.this$0.f.removeCallbacks(this.this$0.f371e);
            this.this$0.f371e.run();
            return;
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        PopupTouchInterceptor(ListPopupWindow r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r3, MotionEvent r4) {
            int r5 = r4.getAction();
            int r0 = (int) r4.getX();
            int r6 = (int) r4.getY();
            if (r5 != 0) goto L16;
            if (this.this$0.g == null) goto L16;
            if (this.this$0.g.isShowing() == false) goto L16;
            if (r0 < 0) goto L16;
            if (r0 >= this.this$0.g.getWidth()) goto L16;
            if (r6 < 0) goto L16;
            if (r6 >= this.this$0.g.getHeight()) goto L16;
            this.this$0.f.postDelayed(this.this$0.f371e, 250);
            return false;
        L16:
            if (r5 != 1) goto L21;
            this.this$0.f.removeCallbacks(this.this$0.f371e);
            return false;
        L21:
            return false;
        }
    }

    static class a {
        static int a(PopupWindow r0, View r1, int r2, boolean r3) {
            return r0.getMaxAvailableHeight(r1, r2, r3);
        }
    }

    static class b {
        static void a(PopupWindow r0, Rect r1) {
            r0.setEpicenterBounds(r1);
        }

        static void a(PopupWindow r0, boolean r1) {
            r0.setIsClippedToScreen(r1);
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListPopupWindow f373a;

        c(ListPopupWindow r1) {
            this.f373a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f373a.f();
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListPopupWindow f374a;

        d(ListPopupWindow r1) {
            this.f374a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f374a.f369c != null) goto L5;
            return;
        L5:
            if (ViewCompat.I(this.f374a.f369c) == true) goto L7;
            return;
        L7:
            if (this.f374a.f369c.getCount() > this.f374a.f369c.getChildCount()) goto L9;
            return;
        L9:
            if (this.f374a.f369c.getChildCount() > this.f374a.f370d) goto L15;
            this.f374a.g.setInputMethodMode(2);
            this.f374a.show();
            return;
        }
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L11;
        f367a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
    L18:
        h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});     // Catch: NoSuchMethodException -> L9
    L9:
        b(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    L6:
        b(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    L11:
        if (Build.VERSION.SDK_INT > 23) goto L22;
        f368b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});     // Catch: NoSuchMethodException -> L14
        return;
    L14:
        b(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        return;
    }

    public ListPopupWindow(Context r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.listPopupWindowStyle, "attr", "listPopupWindowStyle"));
    }

    public ListPopupWindow(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5, 0);
    }

    public ListPopupWindow(Context r6, AttributeSet r7, int r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.s = 0;
        this.t = false;
        this.u = false;
        this.f370d = Integer.MAX_VALUE;
        this.w = 0;
        this.f371e = new d(this);
        this.C = new PopupTouchInterceptor(this);
        this.D = new PopupScrollListener(this);
        this.E = new c(this);
        this.G = new Rect();
        this.i = ZeusTransformUtils.wrapperContext(r10, "com.obric.aiagent.plugin");
        this.f = new Handler(r10.getMainLooper());
        TypedArray r1 = r10.obtainStyledAttributes(r11, R.styleable.ListPopupWindow, r8, r9);
        this.m = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, "styleable", "ListPopupWindow_android_dropDownHorizontalOffset"), 0);
        int r0 = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, "styleable", "ListPopupWindow_android_dropDownVerticalOffset"), 0);
        this.n = r0;
        if (r0 == 0) goto L5;
        this.p = true;
    L5:
        r1.recycle();
        AppCompatPopupWindow r2 = new AppCompatPopupWindow(r10, r11, r8, r9);
        this.g = r2;
        r2.setInputMethodMode(1);
    }

    public void setAdapter(ListAdapter r3) {
        ListAdapter r4 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.aiagent.plugin");
        DataSetObserver r0 = this.x;
        if (r0 != null) goto L5;
        this.x = new PopupDataSetObserver(this);
    L8:
        this.j = r4;
        if (r4 == null) goto L11;
        r4.registerDataSetObserver(this.x);
    L11:
        DropDownListView r5 = this.f369c;
        if (r5 == null) goto L15;
        r5.setAdapter(this.j);
        return;
    L15:
        return;
    L5:
        ListAdapter r1 = this.j;
        if (r1 == null) goto L8;
        r1.unregisterDataSetObserver(r0);
        goto L8
    }

    public void a(int r1) {
        this.w = r1;
    }

    public void a(boolean r1) {
        this.I = r1;
        this.g.setFocusable(r1);
    }

    public boolean c() {
        return this.I;
    }

    public Drawable getBackground() {
        return this.g.getBackground();
    }

    public void setBackgroundDrawable(Drawable r1) {
        this.g.setBackgroundDrawable(r1);
    }

    public void b(int r1) {
        this.g.setAnimationStyle(r1);
    }

    public View d() {
        return this.y;
    }

    public void b(View r1) {
        this.y = r1;
    }

    public int getHorizontalOffset() {
        return this.m;
    }

    public void setHorizontalOffset(int r1) {
        this.m = r1;
    }

    public int getVerticalOffset() {
        if (this.p == true) goto L7;
        return 0;
    L7:
        return this.n;
    }

    public void setVerticalOffset(int r1) {
        this.n = r1;
        this.p = true;
    }

    public void a(Rect r2) {
        if (r2 == null) goto L4;
        Rect r0 = new Rect(r2);
    L5:
        this.H = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void c(int r1) {
        this.s = r1;
    }

    public int e() {
        return this.l;
    }

    public void d(int r1) {
        this.l = r1;
    }

    public void e(int r3) {
        Drawable r0 = this.g.getBackground();
        if (r0 == null) goto L5;
        r0.getPadding(this.G);
        this.l = (this.G.left + this.G.right) + r3;
        return;
    L5:
        d(r3);
    }

    public void a(AdapterView.OnItemClickListener r3) {
        this.A = (AdapterView.OnItemClickListener) ZeusTransformUtils.wrapperContextForParams(r3, AdapterView.OnItemClickListener.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.view.menu.f
    public void show() {
        int r0 = b();
        boolean r1 = g();
        androidx.core.widget.f.a(this.g, this.o);
        boolean r3 = true;
        if (this.g.isShowing() == true) goto L5;
        int r2 = this.l;
        if (r2 != (-1)) goto L48;
        r2 = -1;
    L50:
        int r4 = this.k;
        if (r4 != (-1)) goto L53;
        r0 = -1;
    L56:
        this.g.setWidth(r2);
        this.g.setHeight(r0);
        c(true);
        PopupWindow r5 = this.g;
        if (this.u == false) goto L59;
    L61:
        boolean r6 = false;
    L62:
        r5.setOutsideTouchable(r6);
        this.g.setTouchInterceptor(this.C);
        if (this.r == false) goto L66;
        androidx.core.widget.f.a(this.g, this.q);
    L66:
        if (Build.VERSION.SDK_INT > 28) goto L73;
        Method r7 = h;
        if (r7 != null) goto L83;
    L74:
        androidx.core.widget.f.a(this.g, d(), this.m, this.n, this.s);
        this.f369c.setSelection(-1);
        if (this.I == true) goto L77;
    L78:
        f();
    L80:
        if (this.I == true) goto L86;
        this.f.post(this.E);
        return;
    L86:
        return;
    L77:
        if (this.f369c.isInTouchMode() == false) goto L80;
    L83:
        r7.invoke(this.g, new Object[]{this.H});     // Catch: Exception -> L71
    L71:
        e = move-exception;
        a(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e);
        goto L74
    L73:
        b.a(this.g, this.H);
        goto L74
    L59:
        if (this.t == true) goto L61;
        r6 = true;
        goto L62
    L53:
        if (r4 == (-2)) goto L56;
        r0 = r4;
        goto L56
    L48:
        if (r2 != (-2)) goto L50;
        r2 = d().getWidth();
        goto L50
    L5:
        if (ViewCompat.I(d()) == true) goto L7;
        return;
    L7:
        int r8 = this.l;
        if (r8 != (-1)) goto L10;
        r8 = -1;
    L12:
        int r9 = this.k;
        if (r9 != (-1)) goto L28;
        if (r1 == true) goto L17;
        r0 = -1;
    L17:
        if (r1 == false) goto L23;
        PopupWindow r10 = this.g;
        if (this.l != (-1)) goto L21;
        int r11 = -1;
    L22:
        r10.setWidth(r11);
        this.g.setHeight(0);
    L31:
        PopupWindow r12 = this.g;
        if (this.u == false) goto L34;
    L36:
        r3 = false;
    L37:
        r12.setOutsideTouchable(r3);
        PopupWindow r13 = this.g;
        View r14 = d();
        int r15 = this.m;
        int r16 = this.n;
        if (r8 >= 0) goto L40;
        int r17 = -1;
    L41:
        if (r0 >= 0) goto L43;
        int r18 = -1;
    L44:
        r13.update(r14, r15, r16, r17, r18);
        return;
    L43:
        r18 = r0;
        goto L44
    L40:
        r17 = r8;
        goto L41
    L34:
        if (this.t == true) goto L36;
    L21:
        r11 = 0;
        goto L22
    L23:
        PopupWindow r19 = this.g;
        if (this.l != (-1)) goto L26;
        int r20 = -1;
    L27:
        r19.setWidth(r20);
        this.g.setHeight(-1);
        goto L31
    L26:
        r20 = 0;
        goto L27
    L28:
        if (r9 == (-2)) goto L31;
        r0 = r9;
        goto L31
    L10:
        if (r8 != (-2)) goto L12;
        r8 = d().getWidth();
        goto L12
    }

    @Override // androidx.appcompat.view.menu.f
    public void dismiss() {
        this.g.dismiss();
        a();
        this.g.setContentView(null);
        this.f369c = null;
        this.f.removeCallbacks(this.f371e);
    }

    public void a(PopupWindow.OnDismissListener r3) {
        PopupWindow.OnDismissListener r4 = (PopupWindow.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, PopupWindow.OnDismissListener.class, "com.obric.aiagent.plugin");
        this.g.setOnDismissListener(r4);
    }

    private void a() {
        View r0 = this.v;
        if (r0 == null) goto L8;
        ViewParent r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L9;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.v);
        return;
    L9:
        return;
    }

    public void f(int r1) {
        this.g.setInputMethodMode(r1);
    }

    public void g(int r2) {
        DropDownListView r0 = this.f369c;
        if (isShowing() == false) goto L9;
        if (r0 == null) goto L10;
        r0.setListSelectionHidden(false);
        r0.setSelection(r2);
        if (r0.getChoiceMode() == 0) goto L11;
        r0.setItemChecked(r2, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void f() {
        DropDownListView r1 = this.f369c;
        if (r1 == null) goto L6;
        r1.setListSelectionHidden(true);
        r1.requestLayout();
        return;
    }

    @Override // androidx.appcompat.view.menu.f
    public boolean isShowing() {
        return this.g.isShowing();
    }

    public boolean g() {
        if (this.g.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public Object h() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f369c.getSelectedItem();
    }

    public int i() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.f369c.getSelectedItemPosition();
    }

    public long j() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.f369c.getSelectedItemId();
    }

    public View k() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.f369c.getSelectedView();
    }

    @Override // androidx.appcompat.view.menu.f
    public ListView getListView() {
        return this.f369c;
    }

    DropDownListView a(Context r2, boolean r3) {
        return new DropDownListView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private int b() {
        boolean r4 = true;
        if (this.f369c != null) goto L25;
        Context r0 = this.i;
        this.F = new AnonymousClass2(this);
        DropDownListView r6 = a(r0, !this.I);
        this.f369c = r6;
        Drawable r7 = this.z;
        if (r7 == null) goto L7;
        r6.setSelector(r7);
    L7:
        this.f369c.setAdapter(this.j);
        this.f369c.setOnItemClickListener(this.A);
        this.f369c.setFocusable(true);
        this.f369c.setFocusableInTouchMode(true);
        this.f369c.setOnItemSelectedListener(new AnonymousClass3(this));
        this.f369c.setOnScrollListener(this.D);
        AdapterView.OnItemSelectedListener r8 = this.B;
        if (r8 == null) goto L10;
        this.f369c.setOnItemSelectedListener(r8);
    L10:
        DropDownListView r9 = this.f369c;
        View r10 = this.v;
        if (r10 == null) goto L23;
        LinearLayout r11 = new LinearLayout(r0);
        r11.setOrientation(1);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r12 = this.w;
        if (r12 == 0) goto L17;
        if (r12 == 1) goto L16;
        a(TAG, "Invalid hint position " + this.w);
    L18:
        int r2 = this.l;
        if (r2 < 0) goto L21;
        int r13 = Integer.MIN_VALUE;
    L22:
        r10.measure(View.MeasureSpec.makeMeasureSpec(r2, r13), 0);
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        int r5 = (r10.getMeasuredHeight() + r3.topMargin) + r3.bottomMargin;
        View r14 = r11;
    L24:
        this.g.setContentView(r14);
    L29:
        Drawable r15 = this.g.getBackground();
        if (r15 == null) goto L34;
        r15.getPadding(this.G);
        int r16 = this.G.top + this.G.bottom;
        if (this.p == true) goto L36;
        this.n = -this.G.top;
    L36:
        if (this.g.getInputMethodMode() == 2) goto L39;
        r4 = false;
    L39:
        int r17 = a(d(), this.n, r4);
        if (this.t == true) goto L57;
        if (this.k == (-1)) goto L57;
        int r18 = this.l;
        if (r18 != (-2)) goto L47;
        int r19 = View.MeasureSpec.makeMeasureSpec(ZeusTransformUtils.getResources(this.i, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - (this.G.left + this.G.right), Integer.MIN_VALUE);
    L51:
        int r20 = this.f369c.measureHeightOfChildrenCompat(r19, 0, -1, r17 - r5, -1);
        if (r20 <= 0) goto L55;
        r5 = r5 + (r16 + (this.f369c.getPaddingTop() + this.f369c.getPaddingBottom()));
    L55:
        return r20 + r5;
    L47:
        if (r18 == (-1)) goto L49;
        r19 = View.MeasureSpec.makeMeasureSpec(r18, 1073741824);
        goto L51
    L49:
        r19 = View.MeasureSpec.makeMeasureSpec(ZeusTransformUtils.getResources(this.i, "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - (this.G.left + this.G.right), 1073741824);
    L57:
        return r17 + r16;
    L34:
        this.G.setEmpty();
        r16 = 0;
        goto L36
    L21:
        r2 = 0;
        r13 = 0;
        goto L22
    L16:
        r11.addView(r9, r1);
        r11.addView(r10);
        goto L18
    L17:
        r11.addView(r10);
        r11.addView(r9, r1);
        goto L18
    L23:
        r5 = 0;
        r14 = r9;
        goto L24
    L25:
        ViewGroup r21 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.g.getContentView(), ViewGroup.class, "com.obric.aiagent.plugin");
        View r22 = this.v;
        if (r22 == null) goto L28;
        LinearLayout.LayoutParams r23 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r22.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r5 = (r22.getMeasuredHeight() + r23.topMargin) + r23.bottomMargin;
        goto L29
    L28:
        r5 = 0;
        goto L29
    }

    public void b(boolean r2) {
        this.r = true;
        this.q = r2;
    }

    private void c(boolean r4) {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        Method r0 = f367a;
        if (r0 == null) goto L13;
        r0.invoke(this.g, new Object[]{Boolean.valueOf(r4)});     // Catch: Exception -> L8
        return;
    L8:
        b(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
        return;
    L13:
        return;
    L9:
        b.a(this.g, r4);
    }

    private int a(View r6, int r7, boolean r8) {
        if (Build.VERSION.SDK_INT > 23) goto L12;
        Method r0 = f368b;
        if (r0 == null) goto L10;
        return ((Integer) ZeusTransformUtils.preCheckCast(r0.invoke(this.g, new Object[]{r6, Integer.valueOf(r7), Boolean.valueOf(r8)}), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L8:
        b(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    L10:
        return this.g.getMaxAvailableHeight(r6, r7);
    L12:
        return a.a(this.g, r6, r7, r8);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
