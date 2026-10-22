package com.stepos.common.picker;

import H1.f;
import H1.m;
import N1.i;
import N1.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import b1.C0555c;
import com.stepos.common.picker.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class WheelPicker extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    private int f13634a;

    /* renamed from: b, reason: collision with root package name */
    private int f13635b;

    /* renamed from: c, reason: collision with root package name */
    private int f13636c;

    /* renamed from: d, reason: collision with root package name */
    private int f13637d;

    /* renamed from: e, reason: collision with root package name */
    private int f13638e;

    /* renamed from: f, reason: collision with root package name */
    private int f13639f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayoutManager f13640g;

    /* renamed from: h, reason: collision with root package name */
    private final LinearSnapHelper f13641h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView.Adapter<RecyclerView.ViewHolder> f13642i;

    /* renamed from: j, reason: collision with root package name */
    private int f13643j;

    /* renamed from: k, reason: collision with root package name */
    private final Context f13644k;

    /* renamed from: l, reason: collision with root package name */
    private final com.stepos.common.picker.c f13645l;

    /* renamed from: m, reason: collision with root package name */
    int[] f13646m;

    /* renamed from: n, reason: collision with root package name */
    private View f13647n;

    /* renamed from: o, reason: collision with root package name */
    private int f13648o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f13649p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13650q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13651r;

    /* renamed from: s, reason: collision with root package name */
    private String f13652s;

    /* renamed from: t, reason: collision with root package name */
    private final Paint f13653t;

    /* renamed from: u, reason: collision with root package name */
    private float f13654u;

    /* renamed from: v, reason: collision with root package name */
    private float f13655v;

    /* renamed from: w, reason: collision with root package name */
    private List<e> f13656w;

    /* renamed from: x, reason: collision with root package name */
    private int f13657x;

    /* renamed from: y, reason: collision with root package name */
    private List<String> f13658y;

    /* renamed from: z, reason: collision with root package name */
    private final RecyclerView.OnScrollListener f13659z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WheelPicker.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WheelPicker wheelPicker = WheelPicker.this;
            wheelPicker.addOnScrollListener(wheelPicker.f13659z);
            WheelPicker.this.u();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelPicker.this.requestLayout();
            WheelPicker.this.u();
            WheelPicker.this.w();
        }
    }

    class c implements a.b {
        c() {
        }

        @Override // com.stepos.common.picker.a.b
        public void a(View view, int i5, int i6) {
            int[] iArrCalculateDistanceToFinalSnap;
            WheelPicker.this.f13650q = true;
            if (WheelPicker.this.f13640g == null || (iArrCalculateDistanceToFinalSnap = WheelPicker.this.f13641h.calculateDistanceToFinalSnap(WheelPicker.this.f13640g, view)) == null) {
                return;
            }
            WheelPicker.this.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
        }
    }

    class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
            super.onScrollStateChanged(recyclerView, i5);
            if (i5 == 0) {
                WheelPicker wheelPicker = WheelPicker.this;
                TextView textViewX = wheelPicker.x(wheelPicker.f13647n);
                String str = (textViewX == null || TextUtils.isEmpty(textViewX.getText())) ? null : (String) textViewX.getText();
                WheelPicker wheelPicker2 = WheelPicker.this;
                wheelPicker2.p(wheelPicker2.f13648o, WheelPicker.this.f13647n, str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            super.onScrolled(recyclerView, i5, i6);
            WheelPicker.this.u();
        }
    }

    public interface e {
        void a(int i5, View view, String str);
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2063j);
    }

    private void B() {
        if (this.f13650q) {
            if (N1.a.d()) {
                performHapticFeedback(21000);
            } else {
                n.d(getContext(), 2);
            }
        }
    }

    private int getInitialPosition() {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f13642i;
        if (adapter instanceof com.stepos.common.picker.a) {
            return ((com.stepos.common.picker.a) adapter).k();
        }
        return 0;
    }

    private float n(int i5) {
        int iAbs = Math.abs(this.f13643j - i5);
        int i6 = this.f13634a;
        if (iAbs >= i6) {
            return 1.0f;
        }
        return iAbs / i6;
    }

    private float o(int i5) {
        int i6 = this.f13643j;
        if (i6 != 0 && this.f13634a != 0) {
            int iAbs = Math.abs(i5 - i6);
            return (1.0f - ((iAbs / r3) * 0.15f)) - (((iAbs % r3) / this.f13634a) * 0.15f);
        }
        Log.w("WheelPicker", "mLocYCenter nor itemHeight init, mLocYCenter:" + this.f13643j + ",itemHeight:" + this.f13634a);
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i5, View view, String str) {
        if (this.f13656w != null) {
            for (int i6 = 0; i6 < this.f13656w.size(); i6++) {
                this.f13656w.get(i6).a(i5, view, str);
            }
        }
    }

    private boolean q(int i5, int i6) {
        int i7 = this.f13634a;
        int i8 = i5 - (i7 / 2);
        int[] iArr = this.f13646m;
        return i8 > iArr[0] && i5 + (i7 / 2) < iArr[1] && this.f13648o != i6;
    }

    private int r(float f5) {
        return C0555c.b().evaluate(f5, Integer.valueOf(this.f13638e), Integer.valueOf(this.f13639f)).intValue();
    }

    private void s(int i5, View view) {
        if (this.f13650q) {
            this.f13645l.j();
        }
        this.f13648o = i5;
        this.f13647n = view;
    }

    private void t(View view, int i5) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                float fMax = Math.max(0.0f, o(i5));
                childAt.setScaleX(fMax);
                childAt.setScaleY(fMax);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        View childAt2 = viewGroup2.getChildAt(0);
                        if (childAt2 instanceof TextView) {
                            ((TextView) childAt2).setTextColor(r(n(i5)));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        LinearLayoutManager linearLayoutManager = this.f13640g;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.f13640g.getChildAt(i5);
                if (childAt == null) {
                    Log.w("WheelPicker", "wtf! child was null.");
                } else {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    int top = childAt.getTop() + (childAt.getHeight() / 2);
                    if (q(top, childAdapterPosition)) {
                        s(childAdapterPosition, childAt);
                        B();
                    }
                    t(childAt, top);
                }
            }
        }
    }

    private void v(int i5, int i6) {
        int i7 = (i6 - i5) / 2;
        this.f13643j = i7;
        int[] iArr = this.f13646m;
        int i8 = this.f13634a;
        iArr[0] = (i7 - (i8 / 2)) - 20;
        iArr[1] = i7 + (i8 / 2) + 20;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        TextView textViewX = x(this.f13647n);
        if (textViewX != null) {
            int baseline = textViewX.getBaseline();
            this.f13655v = ((getWidth() + y()) / 2.0f) + i.a(4.0f, getContext());
            this.f13654u = ((this.f13635b - this.f13634a) / 2.0f) + baseline;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextView x(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                return x(childAt);
            }
        }
        return null;
    }

    private float y() {
        TextView textViewX = x(this.f13647n);
        if (textViewX != null) {
            return textViewX.getPaint().measureText(this.f13657x == 2 ? "00" : "0000");
        }
        return 0.0f;
    }

    public void A(List<String> list, int i5, boolean z5) {
        if (list == null) {
            return;
        }
        if (list.equals(this.f13658y)) {
            Log.i("WheelPicker", "data is the same.");
            return;
        }
        stopScroll();
        this.f13649p = z5;
        if (list.size() > 0) {
            this.f13657x = list.get(0).length();
        }
        setAdapter(new com.stepos.common.picker.a(new com.stepos.common.picker.b(list), z5));
        z(i5, false);
        this.f13658y = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i5, int i6) {
        this.f13650q = true;
        return super.fling(i5, i6);
    }

    public int getCurrentItem() {
        return this.f13648o;
    }

    public void m(e eVar) {
        if (this.f13656w == null) {
            this.f13656w = new ArrayList();
        }
        this.f13656w.add(eVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.stepos.common.picker.c cVar = this.f13645l;
        if (cVar != null) {
            cVar.i(this.f13644k);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.stepos.common.picker.c cVar = this.f13645l;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f13651r || TextUtils.isEmpty(this.f13652s)) {
            return;
        }
        canvas.drawText(this.f13652s, this.f13655v, this.f13654u, this.f13653t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        v(i6, i8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7 = this.f13635b;
        if (i7 != 0) {
            super.onMeasure(i5, i7);
        } else {
            super.onMeasure(i5, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13650q = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.f13642i = adapter;
        if (adapter instanceof com.stepos.common.picker.a) {
            ((com.stepos.common.picker.a) adapter).n(new c());
        }
    }

    public void setCurrentItem(int i5) {
        z(i5, false);
    }

    public void setDrawFlagEnable(boolean z5) {
        this.f13651r = z5;
    }

    public void setFlagText(String str) {
        this.f13652s = str;
    }

    public void setFlagTextColor(int i5) {
        this.f13653t.setColor(i5);
    }

    public void setFlagTextSize(float f5) {
        this.f13653t.setTextSize(f5);
    }

    public void setInfinityLoop(boolean z5) {
        this.f13649p = z5;
    }

    public void setItemCount(int i5) {
        if (this.f13636c != i5) {
            this.f13636c = i5;
            this.f13637d = i5 / 2;
            this.f13635b = i5 * this.f13634a;
            requestLayout();
        }
    }

    public void setItemHeight(int i5) {
        this.f13634a = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f13640g = (LinearLayoutManager) layoutManager;
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        if (i5 == 0) {
            post(new b());
        }
    }

    public void z(int i5, boolean z5) {
        this.f13650q = false;
        this.f13640g.scrollToPositionWithOffset((getInitialPosition() + i5) - this.f13637d, 0);
        u();
    }

    public WheelPicker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13646m = new int[2];
        this.f13651r = false;
        this.f13657x = 2;
        this.f13659z = new d();
        setOverScrollMode(2);
        this.f13644k = context;
        int[] iArr = m.r7;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i5, 0);
        this.f13634a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(m.v7, context.getResources().getDimensionPixelSize(f.f2114J));
        this.f13638e = typedArrayObtainStyledAttributes.getColor(m.x7, context.getResources().getColor(H1.e.f2081c));
        this.f13639f = typedArrayObtainStyledAttributes.getColor(m.w7, context.getResources().getColor(H1.e.f2082d));
        int i6 = typedArrayObtainStyledAttributes.getInt(m.u7, 5);
        int color = typedArrayObtainStyledAttributes.getColor(m.s7, -16777216);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(m.t7, context.getResources().getDimensionPixelSize(f.f2118N));
        setItemCount(i6);
        Paint paint = new Paint(1);
        this.f13653t = paint;
        paint.setColor(color);
        paint.setTextSize(dimensionPixelSize);
        paint.setFakeBoldText(true);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.f13645l = new com.stepos.common.picker.c();
        setLayoutManager(new LinearLayoutManager(context));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.f13641h = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f13634a);
        post(new Runnable() { // from class: L1.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f3808a.w();
            }
        });
    }
}
