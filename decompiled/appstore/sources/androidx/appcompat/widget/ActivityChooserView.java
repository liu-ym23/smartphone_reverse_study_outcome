package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.primitives.Ints;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ActionProvider f750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataSetObserver f751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ListPopupWindow f753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PopupWindow.OnDismissListener f754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f758r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f759a = null;

        static {
            f759a = new int[]{R.attr.background};
        }

        public InnerLayout(Context r10, AttributeSet r11) {
            super(r10, r11);
            b0 r12 = b0.u(r10, r11, f759a);
            setBackgroundDrawable(r12.g(0));
            r12.w();
        }
    }

    public class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f760a;

        public a(ActivityChooserView r10) {
            this.f760a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f760a.f741a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            this.f760a.f741a.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f761a;

        public b(ActivityChooserView r10) {
            this.f761a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f761a.b() == true) goto L5;
            return;
        L5:
            if (this.f761a.isShown() == true) goto L7;
            this.f761a.getListPopupWindow().dismiss();
            return;
        L7:
            this.f761a.getListPopupWindow().show();
            ActionProvider r10 = this.f761a.f750j;
            if (r10 == null) goto L13;
            r10.j(true);
            return;
        }
    }

    public class c extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f762a;

        public c(ActivityChooserView r10) {
            this.f762a = r10;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfo r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            AccessibilityNodeInfoCompat.B0(r11).S(true);
        }
    }

    public class d extends t {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f763j;

        public d(ActivityChooserView r10, View r11) {
            this.f763j = r10;
            super(r11);
        }

        @Override // androidx.appcompat.widget.t
        public ShowableListMenu b() {
            return this.f763j.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.t
        public boolean c() {
            this.f763j.c();
            return true;
        }

        @Override // androidx.appcompat.widget.t
        public boolean d() {
            this.f763j.a();
            return true;
        }
    }

    public class e extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f764a;

        public e(ActivityChooserView r10) {
            this.f764a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f764a.e();
        }
    }

    public class f extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f769e;

        public f(ActivityChooserView r10) {
            this.f769e = r10;
            this.f765a = 4;
        }

        public int a() {
            throw null;
        }

        public ActivityChooserModel b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f766b;
        }

        public void f(ActivityChooserModel r10) {
            this.f769e.f741a.b();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r10) {
            int r11 = getItemViewType(r10);
            if (r11 == 0) goto L10;
            if (r11 != 1) goto L8;
            return null;
        L8:
            throw new IllegalArgumentException();
        L10:
            if (this.f766b == true) goto L12;
            throw null;
        L12:
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r10) {
            return r10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r10) {
            if (this.f768d == true) goto L5;
            return 0;
        L5:
            if (r10 != (getCount() - 1)) goto L9;
            return 1;
        L9:
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            int r13 = getItemViewType(r10);
            if (r13 == 0) goto L12;
            if (r13 != 1) goto L11;
            if (r11 != null) goto L7;
        L8:
            View r14 = LayoutInflater.from(this.f769e.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, r12, false);
            r14.setId(1);
            ((TextView) r14.findViewById(R$id.title)).setText(this.f769e.getContext().getString(R$string.abc_activity_chooser_view_see_all));
            return r14;
        L7:
            if (r11.getId() != 1) goto L8;
            return r11;
        L11:
            throw new IllegalArgumentException();
        L12:
            if (r11 != null) goto L14;
        L15:
            r11 = LayoutInflater.from(this.f769e.getContext()).inflate(R$layout.abc_activity_chooser_view_list_item, r12, false);
        L16:
            PackageManager r15 = this.f769e.getContext().getPackageManager();
            ImageView r16 = (ImageView) r11.findViewById(R$id.icon);
            ResolveInfo r17 = (ResolveInfo) getItem(r10);
            r16.setImageDrawable(r17.loadIcon(r15));
            ((TextView) r11.findViewById(R$id.title)).setText(r17.loadLabel(r15));
            if (this.f766b == false) goto L22;
            if (r10 != 0) goto L22;
            if (this.f767c == false) goto L22;
            r11.setActivated(true);
        L23:
            return r11;
        L22:
            r11.setActivated(false);
            goto L23
        L14:
            if (r11.getId() == R$id.list_item) goto L16;
            goto L15
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityChooserView f770a;

        public g(ActivityChooserView r10) {
            this.f770a = r10;
        }

        public final void a() {
            PopupWindow.OnDismissListener r10 = this.f770a.f754n;
            if (r10 == null) goto L6;
            r10.onDismiss();
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            ActivityChooserView r11 = this.f770a;
            if (r10 != r11.f747g) goto L5;
            r11.a();
            this.f770a.f741a.c();
            this.f770a.f741a.b();
            throw null;
        L5:
            if (r10 != r11.f745e) goto L9;
            r11.f755o = false;
            r11.d(r11.f756p);
            return;
        L9:
            throw new IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            ActionProvider r10 = this.f770a.f750j;
            if (r10 == null) goto L6;
            r10.j(false);
            return;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
            int r14 = ((f) r10.getAdapter()).getItemViewType(r12);
            if (r14 != 0) goto L5;
            this.f770a.a();
            ActivityChooserView r15 = this.f770a;
            if (r15.f755o == false) goto L15;
            if (r12 <= 0) goto L17;
            r15.f741a.b();
            throw null;
        L17:
            return;
        L15:
            r15.f741a.e();
            this.f770a.f741a.b();
            throw null;
        L5:
            if (r14 != 1) goto L8;
            this.f770a.d(Channel.UNLIMITED);
            return;
        L8:
            throw new IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View r10) {
            ActivityChooserView r11 = this.f770a;
            if (r10 != r11.f747g) goto L9;
            if (r11.f741a.getCount() <= 0) goto L7;
            ActivityChooserView r12 = this.f770a;
            r12.f755o = true;
            r12.d(r12.f756p);
        L7:
            return true;
        L9:
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(@NonNull Context r10) {
        this(r10, null);
    }

    public boolean a() {
        if (b() == false) goto L9;
        getListPopupWindow().dismiss();
        ViewTreeObserver r10 = getViewTreeObserver();
        if (r10.isAlive() == false) goto L10;
        r10.removeGlobalOnLayoutListener(this.f752l);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.f757q == false) goto L9;
        this.f755o = false;
        d(this.f756p);
        return true;
    }

    public void d(int r10) {
        this.f741a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public void e() {
        if (this.f741a.getCount() <= 0) goto L5;
        this.f745e.setEnabled(true);
    L6:
        int r10 = this.f741a.a();
        int r11 = this.f741a.d();
        if (r10 == 1) goto L12;
        if (r10 <= 1) goto L11;
        if (r11 > 0) goto L12;
    L11:
        this.f747g.setVisibility(8);
    L16:
        if (this.f747g.getVisibility() != 0) goto L18;
        this.f743c.setBackgroundDrawable(this.f744d);
        return;
    L18:
        this.f743c.setBackgroundDrawable(null);
        return;
    L12:
        this.f747g.setVisibility(0);
        ResolveInfo r12 = this.f741a.c();
        PackageManager r13 = getContext().getPackageManager();
        this.f748h.setImageDrawable(r12.loadIcon(r13));
        if (this.f758r == 0) goto L16;
        CharSequence r14 = r12.loadLabel(r13);
        String r15 = getContext().getString(this.f758r, new Object[]{r14});
        this.f747g.setContentDescription(r15);
        goto L16
    L5:
        this.f745e.setEnabled(false);
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ActivityChooserModel getDataModel() {
        this.f741a.b();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f753m != null) goto L6;
        ListPopupWindow r10 = new ListPopupWindow(getContext());
        this.f753m = r10;
        r10.setAdapter(this.f741a);
        this.f753m.n(this);
        this.f753m.t(true);
        this.f753m.setOnItemClickListener(this.f742b);
        this.f753m.setOnDismissListener(this.f742b);
    L6:
        return this.f753m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f741a.b();
        this.f757q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f741a.b();
        ViewTreeObserver r10 = getViewTreeObserver();
        if (r10.isAlive() == false) goto L6;
        r10.removeGlobalOnLayoutListener(this.f752l);
    L6:
        if (b() == false) goto L8;
        a();
    L8:
        this.f757q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        this.f743c.layout(0, 0, r13 - r11, r14 - r12);
        if (b() == true) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        View r12 = this.f743c;
        if (this.f747g.getVisibility() == 0) goto L5;
        r11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r11), Ints.MAX_POWER_OF_TWO);
    L5:
        measureChild(r12, r10, r11);
        setMeasuredDimension(r12.getMeasuredWidth(), r12.getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel.ActivityChooserModelClient
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel r10) {
        this.f741a.f(r10);
        if (b() == false) goto L6;
        a();
        c();
        return;
    }

    public void setDefaultActionButtonContentDescription(int r10) {
        this.f758r = r10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int r10) {
        String r11 = getContext().getString(r10);
        this.f746f.setContentDescription(r11);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable r10) {
        this.f746f.setImageDrawable(r10);
    }

    public void setInitialActivityCount(int r10) {
        this.f756p = r10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r10) {
        this.f754n = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider r10) {
        this.f750j = r10;
    }

    public ActivityChooserView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ActivityChooserView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f751k = new a(this);
        this.f752l = new b(this);
        this.f756p = 4;
        int[] r13 = R$styleable.ActivityChooserView;
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        ViewCompat.n0(this, r10, r13, r11, r14, r12, 0);
        this.f756p = r14.getInt(R$styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable r15 = r14.getDrawable(R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        r14.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.abc_activity_chooser_view, this, true);
        g r16 = new g(this);
        this.f742b = r16;
        View r17 = findViewById(R$id.activity_chooser_view_content);
        this.f743c = r17;
        this.f744d = r17.getBackground();
        FrameLayout r18 = (FrameLayout) findViewById(R$id.default_activity_button);
        this.f747g = r18;
        r18.setOnClickListener(r16);
        r18.setOnLongClickListener(r16);
        int r19 = R$id.image;
        this.f748h = (ImageView) r18.findViewById(r19);
        FrameLayout r20 = (FrameLayout) findViewById(R$id.expand_activities_button);
        r20.setOnClickListener(r16);
        r20.setAccessibilityDelegate(new c(this));
        r20.setOnTouchListener(new d(this, r20));
        this.f745e = r20;
        ImageView r110 = (ImageView) r20.findViewById(r19);
        this.f746f = r110;
        r110.setImageDrawable(r15);
        f r111 = new f(this);
        this.f741a = r111;
        r111.registerDataSetObserver(new e(this));
        Resources r112 = r10.getResources();
        this.f749i = Math.max(r112.getDisplayMetrics().widthPixels / 2, r112.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
    }
}
