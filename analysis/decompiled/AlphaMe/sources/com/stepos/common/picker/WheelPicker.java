package com.stepos.common.picker;

import Z2.I;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Binder;
import android.os.Handler;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import h.RunnableC0583a;
import i2.AbstractC0620a;
import java.util.ArrayList;
import java.util.List;
import m2.AbstractC0770a;
import n1.AbstractC0776b;

/* loaded from: classes.dex */
public class WheelPicker extends RecyclerView {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f11342z = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f11343a;

    /* renamed from: b, reason: collision with root package name */
    public int f11344b;

    /* renamed from: c, reason: collision with root package name */
    public int f11345c;

    /* renamed from: d, reason: collision with root package name */
    public int f11346d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11347e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11348f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayoutManager f11349g;

    /* renamed from: h, reason: collision with root package name */
    public final LinearSnapHelper f11350h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView.Adapter f11351i;

    /* renamed from: j, reason: collision with root package name */
    public int f11352j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f11353k;

    /* renamed from: l, reason: collision with root package name */
    public final k f11354l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f11355m;

    /* renamed from: n, reason: collision with root package name */
    public View f11356n;

    /* renamed from: o, reason: collision with root package name */
    public int f11357o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11358p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11359q;

    /* renamed from: r, reason: collision with root package name */
    public String f11360r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f11361s;

    /* renamed from: t, reason: collision with root package name */
    public float f11362t;

    /* renamed from: u, reason: collision with root package name */
    public float f11363u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f11364v;

    /* renamed from: w, reason: collision with root package name */
    public int f11365w;

    /* renamed from: x, reason: collision with root package name */
    public List f11366x;

    /* renamed from: y, reason: collision with root package name */
    public final r f11367y;

    public WheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static TextView d(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                return d(childAt);
            }
        }
        return null;
    }

    private int getInitialPosition() {
        RecyclerView.Adapter adapter = this.f11351i;
        if (!(adapter instanceof f)) {
            return 0;
        }
        f fVar = (f) adapter;
        if (!fVar.f11373c) {
            return 0;
        }
        RecyclerView.Adapter adapter2 = fVar.f11371a;
        return (Integer.MAX_VALUE / (adapter2.getItemCount() * 2)) * adapter2.getItemCount();
    }

    public final void a(s sVar) {
        if (this.f11364v == null) {
            this.f11364v = new ArrayList();
        }
        this.f11364v.add(sVar);
    }

    public final void b() {
        float f4;
        k kVar;
        Handler handler;
        LinearLayoutManager linearLayoutManager = this.f11349g;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = this.f11349g.getChildAt(i4);
                if (childAt == null) {
                    Log.w("WheelPicker", "wtf! child was null.");
                } else {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    int height = (childAt.getHeight() / 2) + childAt.getTop();
                    int i5 = this.f11343a / 2;
                    int i6 = height - i5;
                    int[] iArr = this.f11355m;
                    if (i6 > iArr[0] && i5 + height < iArr[1] && this.f11357o != childAdapterPosition) {
                        if (this.f11358p && (handler = (kVar = this.f11354l).f11379a) != null) {
                            handler.post(new RunnableC0583a(16, kVar));
                        }
                        this.f11357o = childAdapterPosition;
                        this.f11356n = childAt;
                        if (this.f11358p) {
                            if (AbstractC0770a.b()) {
                                performHapticFeedback(21000);
                            } else {
                                Context context = getContext();
                                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                                if (I.f(context, "android.permission.VIBRATE", Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null) == 0) {
                                    vibrator.vibrate(VibrationEffect.createOneShot(50L, 2));
                                }
                            }
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        if (viewGroup.getChildCount() > 0) {
                            View childAt2 = viewGroup.getChildAt(0);
                            int i7 = this.f11352j;
                            if (i7 == 0 || this.f11343a == 0) {
                                Log.w("WheelPicker", "mLocYCenter nor itemHeight init, mLocYCenter:" + this.f11352j + ",itemHeight:" + this.f11343a);
                                f4 = 1.0f;
                            } else {
                                int iAbs = Math.abs(height - i7);
                                f4 = (1.0f - ((iAbs / r5) * 0.15f)) - (((iAbs % r5) / this.f11343a) * 0.15f);
                            }
                            float fMax = Math.max(Property.DEFAULT_FLOAT_VALUE, f4);
                            childAt2.setScaleX(fMax);
                            childAt2.setScaleY(fMax);
                            if (childAt2 instanceof ViewGroup) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                if (viewGroup2.getChildCount() > 0) {
                                    View childAt3 = viewGroup2.getChildAt(0);
                                    if (childAt3 instanceof TextView) {
                                        int iAbs2 = Math.abs(this.f11352j - height);
                                        int i8 = this.f11343a;
                                        ((TextView) childAt3).setTextColor(AbstractC0776b.a(iAbs2 < i8 ? iAbs2 / i8 : 1.0f, Integer.valueOf(this.f11347e), Integer.valueOf(this.f11348f)).intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        float fMeasureText;
        TextView textViewD = d(this.f11356n);
        if (textViewD != null) {
            int baseline = textViewD.getBaseline();
            TextView textViewD2 = d(this.f11356n);
            if (textViewD2 != null) {
                fMeasureText = textViewD2.getPaint().measureText(this.f11365w == 2 ? "00" : "0000");
            } else {
                fMeasureText = Property.DEFAULT_FLOAT_VALUE;
            }
            this.f11363u = ((getWidth() + fMeasureText) / 2.0f) + m2.o.c(getContext(), 4.0f);
            this.f11362t = ((this.f11344b - this.f11343a) / 2.0f) + baseline;
            invalidate();
        }
    }

    public final void e(int i4, List list, boolean z4) {
        if (list == null) {
            return;
        }
        if (list.equals(this.f11366x)) {
            Log.i("WheelPicker", "data is the same.");
            return;
        }
        stopScroll();
        if (list.size() > 0) {
            this.f11365w = ((String) list.get(0)).length();
        }
        h hVar = new h();
        hVar.f11375a = list;
        setAdapter(new f(hVar, z4));
        this.f11358p = false;
        this.f11349g.scrollToPositionWithOffset((getInitialPosition() + i4) - this.f11346d, 0);
        b();
        this.f11366x = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i4, int i5) {
        this.f11358p = true;
        return super.fling(i4, i5);
    }

    public int getCurrentItem() {
        return this.f11357o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        k kVar = this.f11354l;
        if (kVar == null || kVar.f11382d) {
            return;
        }
        kVar.f11384f = this.f11353k.getApplicationContext();
        kVar.f11382d = false;
        new Thread(new j(kVar)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f11354l;
        if (kVar != null) {
            synchronized (kVar) {
                try {
                    kVar.f11385g = true;
                    Handler handler = kVar.f11379a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (kVar.f11382d) {
                            kVar.f11381c.unload(kVar.f11383e);
                        }
                        kVar.f11381c.release();
                        kVar.f11380b.quit();
                        kVar.f11382d = false;
                        kVar.f11384f = null;
                        kVar.f11379a = null;
                    }
                } finally {
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f11359q || TextUtils.isEmpty(this.f11360r)) {
            return;
        }
        canvas.drawText(this.f11360r, this.f11363u, this.f11362t, this.f11361s);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = (i7 - i5) / 2;
        this.f11352j = i8;
        int i9 = this.f11343a / 2;
        int[] iArr = this.f11355m;
        iArr[0] = (i8 - i9) - 20;
        iArr[1] = i9 + i8 + 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6 = this.f11344b;
        if (i6 != 0) {
            super.onMeasure(i4, i6);
        } else {
            super.onMeasure(i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.f11358p = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.f11351i = adapter;
        if (adapter instanceof f) {
            ((f) adapter).f11372b = new q(this);
        }
    }

    public void setCurrentItem(int i4) {
        this.f11358p = false;
        this.f11349g.scrollToPositionWithOffset((getInitialPosition() + i4) - this.f11346d, 0);
        b();
    }

    public void setDrawFlagEnable(boolean z4) {
        this.f11359q = z4;
    }

    public void setFlagText(String str) {
        this.f11360r = str;
    }

    public void setFlagTextColor(int i4) {
        this.f11361s.setColor(i4);
    }

    public void setFlagTextSize(float f4) {
        this.f11361s.setTextSize(f4);
    }

    public void setInfinityLoop(boolean z4) {
    }

    public void setItemCount(@IntRange(from = 1, to = 10) int i4) {
        if (this.f11345c != i4) {
            this.f11345c = i4;
            this.f11346d = i4 / 2;
            this.f11344b = i4 * this.f11343a;
            requestLayout();
        }
    }

    public void setItemHeight(int i4) {
        this.f11343a = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f11349g = (LinearLayoutManager) layoutManager;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        if (i4 == 0) {
            post(new RunnableC0583a(17, this));
        }
    }

    public WheelPicker(Context context, AttributeSet attributeSet, int i4) throws IllegalStateException {
        super(context, attributeSet, R.attr.StepOSWheelPickerStyle);
        this.f11355m = new int[2];
        this.f11359q = false;
        this.f11365w = 2;
        this.f11367y = new r(this);
        setOverScrollMode(2);
        this.f11353k = context;
        int[] iArr = AbstractC0620a.f13042x;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.StepOSWheelPickerStyle, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.StepOSWheelPickerStyle, 0);
        this.f11343a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_select_item_height));
        this.f11347e = typedArrayObtainStyledAttributes.getColor(5, context.getResources().getColor(R.color.fd_sys_color_on_surface_default));
        this.f11348f = typedArrayObtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default));
        int i5 = typedArrayObtainStyledAttributes.getInt(2, 5);
        int color = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_text_size));
        setItemCount(i5);
        Paint paint = new Paint(1);
        this.f11361s = paint;
        paint.setColor(color);
        paint.setTextSize(dimensionPixelSize);
        paint.setFakeBoldText(true);
        getViewTreeObserver().addOnGlobalLayoutListener(new p(this));
        k kVar = new k();
        kVar.f11379a = null;
        kVar.f11380b = null;
        kVar.f11387i = 0L;
        this.f11354l = kVar;
        setLayoutManager(new LinearLayoutManager(context));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.f11350h = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f11343a);
        post(new androidx.activity.d(21, this));
    }
}
