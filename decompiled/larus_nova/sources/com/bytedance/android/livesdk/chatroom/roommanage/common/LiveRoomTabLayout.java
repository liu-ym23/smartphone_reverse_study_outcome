package com.bytedance.android.livesdk.chatroom.roommanage.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes7.dex */
public class LiveRoomTabLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f111347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager f111348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutInflater f111349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f111350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f111351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f111352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f111353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f111354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f111355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f111356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f111357k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Rect f111358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f111359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f111360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ac1.a[] f111361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinearLayout.LayoutParams f111362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinearLayout.LayoutParams f111363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f111364r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f111365s;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f111366a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f111366a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f111366a);
        }
    }

    public interface a {
        void a(int r100);

        void b();
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomTabLayout f111367a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
        }

        public b(LiveRoomTabLayout r100) {
            this.f111367a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L11;
            LiveRoomTabLayout r101 = this.f111367a;
            r101.f111351e = false;
            if (r101.f111348b.getCurrentItem() != 0) goto L6;
            this.f111367a.scrollTo(0, 0);
            return;
        L6:
            int r102 = this.f111367a.f111348b.getCurrentItem();
            LiveRoomTabLayout r103 = this.f111367a;
            if (r102 != (r103.f111350d - 1)) goto L9;
            r103.scrollTo(r103.getScrollRange(), 0);
            return;
        L9:
            r103.b(r103.f111348b.getCurrentItem());
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            LiveRoomTabLayout r103 = this.f111367a;
            r103.f111354h = r100;
            r103.f111355i = r101;
            LinearLayout r104 = r103.f111347a;
            if (r104 != null) goto L5;
            return;
        L5:
            if (r104.getChildCount() <= r100) goto L10;
            this.f111367a.b(r100);
            this.f111367a.invalidate();
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f111368a;

        public c() {
        }
    }

    public final void c() {
        int r100 = 0;
    L4:
        if (r100 >= this.f111350d) goto L13;
        View r101 = this.f111347a.getChildAt(r100);
        if (r101 == null) goto L12;
        c r102 = (c) r101.getTag();
        if (r102 == null) goto L12;
        r102.f111368a.setTextColor(getResources().getColor(R.color.ttlive_white_70));
    L12:
        r100 = r100 + 1;
        goto L4
    }

    public int getScrollRange() {
        if (getChildCount() > 0) goto L5;
        return 0;
    L5:
        return Math.max(0, getChildAt(0).getWidth() - (((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f111347a.getPaddingRight()));
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f111366a = this.f111354h;
        return r100;
    }

    public LiveRoomTabLayout(Context r100) {
        this(r100, null);
    }

    public static TextView a(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100.getTag() instanceof c) == false) goto L8;
        c r101 = (c) r100.getTag();
    L9:
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.f111368a;
    L8:
        r101 = null;
        goto L9
    }

    public final void b(int r100) {
        if (this.f111350d != 0) goto L6;
        return;
    L6:
        if (this.f111351e == true) goto L8;
    L10:
        Rect r101 = this.f111358l;
        View r102 = this.f111347a.getChildAt(this.f111354h);
        TextView r103 = a(r102);
        if (r103 == null) goto L22;
        float r104 = r102.getLeft() + r103.getLeft();
        float r105 = r103.getWidth() + r104;
        if (this.f111355i <= 0.0f) goto L21;
        int r106 = this.f111354h;
        if (r106 >= (this.f111350d - 1)) goto L21;
        View r107 = this.f111347a.getChildAt(r106 + 1);
        TextView r108 = a(r107);
        if (r108 == null) goto L22;
        float r109 = r107.getLeft() + r108.getLeft();
        float r110 = r108.getWidth() + r109;
        float r111 = this.f111355i;
        float r112 = 1.0f - r111;
        r104 = (r104 * r112) + (r109 * r111);
        r105 = (r110 * r111) + (r112 * r105);
    L21:
        r101.set(((int) r104) + getPaddingLeft(), (getPaddingTop() + r102.getTop()) + r103.getTop(), ((int) r105) + getPaddingLeft(), ((getPaddingTop() + r102.getTop()) + r103.getTop()) + r103.getHeight());
    L22:
        int r113 = this.f111352f;
        if (this.f111358l.left >= (getScrollX() + this.f111356j)) goto L26;
        r113 = this.f111358l.left;
    L29:
        if (r113 == this.f111352f) goto L32;
        scrollTo(r113, 0);
        this.f111352f = r113;
        return;
    L32:
        return;
    L26:
        if (this.f111358l.right <= ((getScrollX() + (getWidth() - this.f111347a.getPaddingRight())) - this.f111356j)) goto L29;
        r113 = this.f111358l.right - (getWidth() - this.f111347a.getPaddingRight());
        goto L29
    L8:
        if (r100 == this.f111348b.getCurrentItem()) goto L10;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        super.draw(r110);
        int r100 = 0;
    L4:
        if (r100 >= this.f111347a.getChildCount()) goto L23;
        int r101 = this.f111354h;
        if (r100 < (r101 - 1)) goto L22;
        if (r100 > (r101 + 1)) goto L22;
        View r102 = this.f111347a.getChildAt(r100);
        TextView r103 = a(r102);
        if (r103 == null) goto L22;
        ac1.a r104 = this.f111361o[(r100 - this.f111354h) + 1];
        int r105 = r110.save();
        r110.clipRect(this.f111358l);
        float r106 = r103.getTextSize();
        Resources r107 = r104.f2552a;
        float r108 = TypedValue.applyDimension(0, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()));
        if (r108 == r104.f2553b.getTextSize()) goto L15;
        r104.f2553b.setTextSize(r108);
        r104.a();
    L15:
        r104.b(r103.getTypeface());
        CharSequence r109 = r103.getText();
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        r104.f2558g = r109;
        r104.a();
        r104.f2556e = ColorStateList.valueOf(getResources().getColor(R.color.ttlive_white_70));
        int r111 = r104.f2556e.getColorForState(r104.getState(), -1);
        if (r104.f2553b.getColor() == r111) goto L21;
        r104.f2553b.setColor(r111);
    L21:
        int r112 = ((r102.getLeft() + r103.getLeft()) + ((r103.getWidth() - r104.getIntrinsicWidth()) / 2)) + getPaddingLeft();
        int r113 = ((r102.getTop() + r103.getTop()) + ((r103.getHeight() - r104.getIntrinsicHeight()) / 2)) + getPaddingTop();
        this.f111359m.set(r112, r113, r104.getIntrinsicWidth() + r112, r104.getIntrinsicHeight() + r113);
        r104.setBounds(this.f111359m);
        r104.draw(r110);
        r110.restoreToCount(r105);
    L22:
        r100 = r100 + 1;
        goto L4
    L23:
        int r114 = r110.save();
        r110.translate(getScrollX(), 0.0f);
        r110.restoreToCount(r114);
        LinearLayout r115 = this.f111347a;
        if (r115 != null) goto L26;
        return;
    L26:
        if (r115.getChildCount() > 0) goto L28;
        return;
    L28:
        if (this.f111347a.getChildAt(this.f111354h) == null) goto L43;
        View r116 = this.f111347a.getChildAt(this.f111354h);
        float r117 = r116.getLeft();
        float r118 = r116.getRight();
        if (this.f111355i <= 0.0f) goto L34;
        int r119 = this.f111354h;
        if (r119 >= (this.f111350d - 1)) goto L34;
        View r120 = this.f111347a.getChildAt(r119 + 1);
        float r121 = r120.getLeft();
        float r122 = r120.getRight();
        float r123 = this.f111355i;
        float r124 = 1.0f - r123;
        r117 = (r117 * r124) + (r121 * r123);
        r118 = (r122 * r123) + (r124 * r118);
    L34:
        float r125 = ((r118 - r117) - this.f111359m.width()) / 2.0f;
        this.f111360n.set(r117 + r125, getHeight(), r118 - r125, getHeight() - UIUtils.dip2Px(getContext(), 2.0f));
        r110.drawRoundRect(this.f111360n, UIUtils.dip2Px(getContext(), 1.0f), UIUtils.dip2Px(getContext(), 1.0f), this.f111357k);
        return;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f111354h = r101.f111366a;
        requestLayout();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.f111353g = (int) r100.getX();
    L6:
        if (2 != r100.getAction()) goto L11;
        if (this.f111353g != 0) goto L11;
        this.f111353g = (int) r100.getX();
    L11:
        if (1 != r100.getAction()) goto L14;
        r100.getX();
        this.f111353g = 0;
    L14:
        return super.onTouchEvent(r100);
    }

    public void setOnTabClickListener(a r100) {
        this.f111365s = r100;
    }

    public void setViewPager(ViewPager r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f111348b = r100;
        if (r100.getAdapter() == null) goto L28;
        r100.setOnPageChangeListener(this.f111364r);
        this.f111347a.removeAllViews();
        ViewPager r101 = this.f111348b;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getAdapter() == null) goto L33;
        int r102 = this.f111348b.getAdapter().getCount();
        this.f111350d = r102;
        if (r102 != 2) goto L15;
        this.f111347a.setWeightSum(1.0f);
    L17:
        PagerAdapter r103 = this.f111348b.getAdapter();
        int r104 = 0;
    L19:
        if (r104 >= this.f111350d) goto L25;
        CharSequence r105 = r103.getPageTitle(r104);
        View r106 = this.f111349c.inflate(R.layout.ttlive_live_room_tab_layout, this, false);
        c r107 = new c();
        r107.f111368a = (TextView) r106.findViewById(R.id.title_text);
        r106.setTag(r107);
        TextView r108 = r107.f111368a;
        r108.setText(r105);
        r108.setGravity(17);
        r108.setSingleLine();
        r106.setFocusable(true);
        r106.setOnClickListener(new com.bytedance.android.livesdk.chatroom.roommanage.common.b(this, r104));
        if (r104 != 0) goto L23;
        this.f111347a.addView(r106, r104, this.f111362p);
    L24:
        r104 = r104 + 1;
        goto L19
    L23:
        this.f111347a.addView(r106, r104, this.f111363q);
        goto L24
    L25:
        c();
        getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.chatroom.roommanage.common.a(this));
        return;
    L15:
        if (r102 != 3) goto L17;
        this.f111347a.setWeightSum(1.5f);
        goto L17
    L33:
        return;
    L28:
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public LiveRoomTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        long r102 = System.currentTimeMillis();
        super.onMeasure(r100, r101);
        if (Logger.debug() == false) goto L6;
        Logger.d("CommonTabLayout", "onMeasure: " + (System.currentTimeMillis() - r102));
        return;
    }

    public LiveRoomTabLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        int r103 = 0;
        this.f111352f = 0;
        this.f111354h = 0;
        this.f111355i = 0.0f;
        this.f111356j = 10;
        this.f111358l = new Rect();
        this.f111359m = new Rect();
        this.f111360n = new RectF();
        this.f111361o = new ac1.a[3];
        this.f111364r = new b(this);
        this.f111349c = LayoutInflater.from(r100);
        setWillNotDraw(false);
        LinearLayout r104 = new LinearLayout(r100);
        this.f111347a = r104;
        r104.setOrientation(0);
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(r104);
        Resources r105 = getResources();
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());
        this.f111356j = (int) TypedValue.applyDimension(1, 10, r106);
        TypedValue.applyDimension(1, 0, r106);
        Paint r107 = new Paint();
        this.f111357k = r107;
        r107.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(0, -1);
        this.f111362p = r108;
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(0, -1);
        this.f111363q = r109;
        r108.weight = 0.5f;
        r109.weight = 0.5f;
    L3:
        ac1.a[] r110 = this.f111361o;
        if (r103 >= r110.length) goto L6;
        r110[r103] = new ac1.a(getContext());
        r103 = r103 + 1;
        goto L3
    L6:
        this.f111357k.setColor(getResources().getColor(R.color.ttlive_white_70));
        c();
        invalidate();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        long r105 = System.currentTimeMillis();
        super.onLayout(r100, r101, r102, r103, r104);
        if (Logger.debug() == false) goto L6;
        Logger.d("CommonTabLayout", "onLayout: " + (System.currentTimeMillis() - r105));
        return;
    }
}
