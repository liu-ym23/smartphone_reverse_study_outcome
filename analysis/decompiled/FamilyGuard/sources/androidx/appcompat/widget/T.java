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
import androidx.appcompat.app.a;
import androidx.appcompat.widget.LinearLayoutCompat;
import g.C0728a;

/* loaded from: classes.dex */
public class T extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j, reason: collision with root package name */
    private static final Interpolator f8350j = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    Runnable f8351a;

    /* renamed from: b, reason: collision with root package name */
    private c f8352b;

    /* renamed from: c, reason: collision with root package name */
    LinearLayoutCompat f8353c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f8354d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8355e;

    /* renamed from: f, reason: collision with root package name */
    int f8356f;

    /* renamed from: g, reason: collision with root package name */
    int f8357g;

    /* renamed from: h, reason: collision with root package name */
    private int f8358h;

    /* renamed from: i, reason: collision with root package name */
    private int f8359i;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8360a;

        a(View view) {
            this.f8360a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            T.this.smoothScrollTo(this.f8360a.getLeft() - ((T.this.getWidth() - this.f8360a.getWidth()) / 2), 0);
            T.this.f8351a = null;
        }
    }

    private class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return T.this.f8353c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i5) {
            return ((d) T.this.f8353c.getChildAt(i5)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                return T.this.c((a.c) getItem(i5), true);
            }
            ((d) view).a((a.c) getItem(i5));
            return view;
        }
    }

    private class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = T.this.f8353c.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = T.this.f8353c.getChildAt(i5);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class d extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f8364a;

        /* renamed from: b, reason: collision with root package name */
        private a.c f8365b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f8366c;

        /* renamed from: d, reason: collision with root package name */
        private ImageView f8367d;

        /* renamed from: e, reason: collision with root package name */
        private View f8368e;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, a.c cVar, boolean z5) {
            int i5 = C0728a.f16828e;
            super(context, null, i5);
            int[] iArr = {R.attr.background};
            this.f8364a = iArr;
            this.f8365b = cVar;
            a0 a0VarV = a0.v(context, null, iArr, i5, 0);
            if (a0VarV.s(0)) {
                setBackgroundDrawable(a0VarV.g(0));
            }
            a0VarV.x();
            if (z5) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.c cVar) {
            this.f8365b = cVar;
            c();
        }

        public a.c b() {
            return this.f8365b;
        }

        public void c() {
            a.c cVar = this.f8365b;
            View viewB = cVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f8368e = viewB;
                TextView textView = this.f8366c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f8367d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f8367d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f8368e;
            if (view != null) {
                removeView(view);
                this.f8368e = null;
            }
            Drawable drawableC = cVar.c();
            CharSequence charSequenceD = cVar.d();
            if (drawableC != null) {
                if (this.f8367d == null) {
                    r rVar = new r(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    rVar.setLayoutParams(layoutParams);
                    addView(rVar, 0);
                    this.f8367d = rVar;
                }
                this.f8367d.setImageDrawable(drawableC);
                this.f8367d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f8367d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f8367d.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceD);
            if (zIsEmpty) {
                TextView textView2 = this.f8366c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f8366c.setText((CharSequence) null);
                }
            } else {
                if (this.f8366c == null) {
                    D d6 = new D(getContext(), null, C0728a.f16829f);
                    d6.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    d6.setLayoutParams(layoutParams2);
                    addView(d6);
                    this.f8366c = d6;
                }
                this.f8366c.setText(charSequenceD);
                this.f8366c.setVisibility(0);
            }
            ImageView imageView3 = this.f8367d;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            f0.a(this, zIsEmpty ? cVar.a() : null);
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
        public void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            if (T.this.f8356f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i7 = T.this.f8356f;
                if (measuredWidth > i7) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), i6);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z5) {
            boolean z6 = isSelected() != z5;
            super.setSelected(z5);
            if (z6 && z5) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        A a6 = new A(getContext(), null, C0728a.f16832i);
        a6.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        a6.setOnItemSelectedListener(this);
        return a6;
    }

    private boolean d() {
        Spinner spinner = this.f8354d;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f8354d == null) {
            this.f8354d = b();
        }
        removeView(this.f8353c);
        addView(this.f8354d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f8354d.getAdapter() == null) {
            this.f8354d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f8351a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f8351a = null;
        }
        this.f8354d.setSelection(this.f8359i);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f8354d);
        addView(this.f8353c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f8354d.getSelectedItemPosition());
        return false;
    }

    public void a(int i5) {
        View childAt = this.f8353c.getChildAt(i5);
        Runnable runnable = this.f8351a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f8351a = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z5) {
        d dVar = new d(getContext(), cVar, z5);
        if (z5) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f8358h));
            return dVar;
        }
        dVar.setFocusable(true);
        if (this.f8352b == null) {
            this.f8352b = new c();
        }
        dVar.setOnClickListener(this.f8352b);
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f8351a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a aVarB = androidx.appcompat.view.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f8357g = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f8351a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        boolean z5 = mode == 1073741824;
        setFillViewport(z5);
        int childCount = this.f8353c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f8356f = -1;
        } else {
            if (childCount > 2) {
                this.f8356f = (int) (View.MeasureSpec.getSize(i5) * 0.4f);
            } else {
                this.f8356f = View.MeasureSpec.getSize(i5) / 2;
            }
            this.f8356f = Math.min(this.f8356f, this.f8357g);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f8358h, 1073741824);
        if (z5 || !this.f8355e) {
            f();
        } else {
            this.f8353c.measure(0, iMakeMeasureSpec);
            if (this.f8353c.getMeasuredWidth() > View.MeasureSpec.getSize(i5)) {
                e();
            } else {
                f();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i5, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z5 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f8359i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z5) {
        this.f8355e = z5;
    }

    public void setContentHeight(int i5) {
        this.f8358h = i5;
        requestLayout();
    }

    public void setTabSelected(int i5) {
        this.f8359i = i5;
        int childCount = this.f8353c.getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = this.f8353c.getChildAt(i6);
            boolean z5 = i6 == i5;
            childAt.setSelected(z5);
            if (z5) {
                a(i5);
            }
            i6++;
        }
        Spinner spinner = this.f8354d;
        if (spinner == null || i5 < 0) {
            return;
        }
        spinner.setSelection(i5);
    }
}
