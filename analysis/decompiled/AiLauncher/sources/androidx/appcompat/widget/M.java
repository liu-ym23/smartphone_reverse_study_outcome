package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;
import i.C4155a;

/* loaded from: classes.dex */
public class M extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j, reason: collision with root package name */
    public static final Interpolator f8970j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Runnable f8971a;

    /* renamed from: b, reason: collision with root package name */
    public c f8972b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayoutCompat f8973c;

    /* renamed from: d, reason: collision with root package name */
    public Spinner f8974d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8975e;

    /* renamed from: f, reason: collision with root package name */
    public int f8976f;

    /* renamed from: g, reason: collision with root package name */
    public int f8977g;

    /* renamed from: h, reason: collision with root package name */
    public int f8978h;

    /* renamed from: i, reason: collision with root package name */
    public int f8979i;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8980a;

        public a(View view) {
            this.f8980a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            M.this.smoothScrollTo(this.f8980a.getLeft() - ((M.this.getWidth() - this.f8980a.getWidth()) / 2), 0);
            M.this.f8971a = null;
        }
    }

    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return M.this.f8973c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((d) M.this.f8973c.getChildAt(i10)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return M.this.c((a.c) getItem(i10), true);
            }
            ((d) view).a((a.c) getItem(i10));
            return view;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = M.this.f8973c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = M.this.f8973c.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class d extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f8984a;

        /* renamed from: b, reason: collision with root package name */
        public a.c f8985b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f8986c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f8987d;

        /* renamed from: e, reason: collision with root package name */
        public View f8988e;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, a.c cVar, boolean z10) {
            int i10 = R$attr.actionBarTabStyle;
            super(context, null, i10);
            int[] iArr = {R.attr.background};
            this.f8984a = iArr;
            this.f8985b = cVar;
            U uV = U.v(context, null, iArr, i10, 0);
            if (uV.s(0)) {
                setBackgroundDrawable(uV.g(0));
            }
            uV.x();
            if (z10) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.f8985b = cVar;
            c();
        }

        public a.c b() {
            return this.f8985b;
        }

        public void c() {
            a.c cVar = this.f8985b;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f8988e = viewB;
                TextView textView = this.f8986c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f8987d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f8987d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f8988e;
            if (view != null) {
                removeView(view);
                this.f8988e = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f8987d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f8987d = appCompatImageView;
                }
                this.f8987d.setImageDrawable(drawableC);
                this.f8987d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f8987d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f8987d.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceD);
            if (zIsEmpty) {
                TextView textView2 = this.f8986c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f8986c.setText((CharSequence) null);
                }
            } else {
                if (this.f8986c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f8986c = appCompatTextView;
                }
                this.f8986c.setText(charSequenceD);
                this.f8986c.setVisibility(0);
            }
            ImageView imageView3 = this.f8987d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            Z.a(this, zIsEmpty ? cVar.a() : null);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (M.this.f8976f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = M.this.f8976f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public void a(int i10) {
        View childAt = this.f8973c.getChildAt(i10);
        Runnable runnable = this.f8971a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f8971a = aVar;
        post(aVar);
    }

    public final Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public d c(a.c cVar, boolean z10) {
        d dVar = new d(getContext(), cVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f8978h));
            return dVar;
        }
        dVar.setFocusable(true);
        if (this.f8972b == null) {
            this.f8972b = new c();
        }
        dVar.setOnClickListener(this.f8972b);
        return dVar;
    }

    public final boolean d() {
        Spinner spinner = this.f8974d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void e() {
        if (d()) {
            return;
        }
        if (this.f8974d == null) {
            this.f8974d = b();
        }
        removeView(this.f8973c);
        addView(this.f8974d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f8974d.getAdapter() == null) {
            this.f8974d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f8971a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f8971a = null;
        }
        this.f8974d.setSelection(this.f8979i);
    }

    public final boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f8974d);
        addView(this.f8973c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f8974d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f8971a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C4155a c4155aB = C4155a.b(getContext());
        setContentHeight(c4155aB.f());
        this.f8977g = c4155aB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f8971a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = mode == 1073741824;
        setFillViewport(z10);
        int childCount = this.f8973c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f8976f = -1;
        } else {
            if (childCount > 2) {
                this.f8976f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f8976f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f8976f = Math.min(this.f8976f, this.f8977g);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8978h, 1073741824);
        if (z10 || !this.f8975e) {
            f();
        } else {
            this.f8973c.measure(0, iMakeMeasureSpec);
            if (this.f8973c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                e();
            } else {
                f();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z10 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f8979i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f8975e = z10;
    }

    public void setContentHeight(int i10) {
        this.f8978h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f8979i = i10;
        int childCount = this.f8973c.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f8973c.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                a(i10);
            }
            i11++;
        }
        Spinner spinner = this.f8974d;
        if (spinner == null || i10 < 0) {
            return;
        }
        spinner.setSelection(i10);
    }
}
