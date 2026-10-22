package com.stepos.common.picker;

import a5.AbstractC0301a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
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
import androidx.compose.foundation.text.selection.SingleSelectionLayout;
import androidx.core.content.PermissionChecker;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelPicker extends RecyclerView {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f3576z = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f3577a;
    public int b;
    public int c;
    public int d;
    public final int e;
    public final int f;
    public LinearLayoutManager g;
    public final LinearSnapHelper h;
    public RecyclerView.Adapter i;

    /* renamed from: j, reason: collision with root package name */
    public int f3578j;
    public final Context k;
    public final k l;
    public final int[] m;
    public View n;
    public int o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3579q;

    /* renamed from: r, reason: collision with root package name */
    public String f3580r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f3581s;

    /* renamed from: t, reason: collision with root package name */
    public float f3582t;
    public float u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f3583v;

    /* renamed from: w, reason: collision with root package name */
    public int f3584w;

    /* renamed from: x, reason: collision with root package name */
    public List f3585x;
    public final r y;

    public WheelPicker(@NonNull Context context, @Nullable AttributeSet attributeSet) throws IllegalStateException {
        super(context, attributeSet, R.attr.StepOSWheelPickerStyle);
        this.m = new int[2];
        this.f3579q = false;
        this.f3584w = 2;
        this.y = new r(this);
        setOverScrollMode(2);
        this.k = context;
        int[] iArr = V4.s.f1379x;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.StepOSWheelPickerStyle, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.StepOSWheelPickerStyle, 0);
        this.f3577a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_select_item_height));
        this.e = typedArrayObtainStyledAttributes.getColor(5, context.getResources().getColor(R.color.fd_sys_color_on_surface_default));
        this.f = typedArrayObtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default));
        int i = typedArrayObtainStyledAttributes.getInt(2, 5);
        int color = typedArrayObtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_text_size));
        setItemCount(i);
        Paint paint = new Paint(1);
        this.f3581s = paint;
        paint.setColor(color);
        paint.setTextSize(dimensionPixelSize);
        paint.setFakeBoldText(true);
        getViewTreeObserver().addOnGlobalLayoutListener(new p(this));
        k kVar = new k();
        kVar.f3594a = null;
        kVar.b = null;
        kVar.i = 0L;
        this.l = kVar;
        setLayoutManager(new LinearLayoutManager(context));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.h = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f3577a);
        post(new D6.b(this, 23));
    }

    public static TextView d(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
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
        RecyclerView.Adapter adapter = this.i;
        if (!(adapter instanceof f)) {
            return 0;
        }
        f fVar = (f) adapter;
        h hVar = fVar.f3589a;
        if (!fVar.c) {
            return 0;
        }
        return hVar.getItemCount() * (Integer.MAX_VALUE / (hVar.getItemCount() * 2));
    }

    public final void a(s sVar) {
        if (this.f3583v == null) {
            this.f3583v = new ArrayList();
        }
        this.f3583v.add(sVar);
    }

    public final void b() {
        float f;
        k kVar;
        Handler handler;
        LinearLayoutManager linearLayoutManager = this.g;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt == null) {
                    Log.w("WheelPicker", "wtf! child was null.");
                } else {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    int height = (childAt.getHeight() / 2) + childAt.getTop();
                    int i6 = this.f3577a / 2;
                    int i10 = height - i6;
                    int[] iArr = this.m;
                    if (i10 > iArr[0] && i6 + height < iArr[1] && this.o != childAdapterPosition) {
                        if (this.p && (handler = (kVar = this.l).f3594a) != null) {
                            handler.post(new j(kVar, 1));
                        }
                        this.o = childAdapterPosition;
                        this.n = childAt;
                        if (this.p) {
                            if (AbstractC0301a.b()) {
                                performHapticFeedback(21000);
                            } else {
                                Context context = getContext();
                                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                                if (PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.VIBRATE") == 0) {
                                    vibrator.vibrate(VibrationEffect.createOneShot(50L, 2));
                                }
                            }
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        if (viewGroup.getChildCount() > 0) {
                            View childAt2 = viewGroup.getChildAt(0);
                            int i11 = this.f3578j;
                            if (i11 == 0 || this.f3577a == 0) {
                                Log.w("WheelPicker", "mLocYCenter nor itemHeight init, mLocYCenter:" + this.f3578j + ",itemHeight:" + this.f3577a);
                                f = 1.0f;
                            } else {
                                int iAbs = Math.abs(height - i11);
                                f = (1.0f - ((iAbs / r5) * 0.15f)) - (((iAbs % r5) / this.f3577a) * 0.15f);
                            }
                            float fMax = Math.max(0.0f, f);
                            childAt2.setScaleX(fMax);
                            childAt2.setScaleY(fMax);
                            if (childAt2 instanceof ViewGroup) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                if (viewGroup2.getChildCount() > 0) {
                                    View childAt3 = viewGroup2.getChildAt(0);
                                    if (childAt3 instanceof TextView) {
                                        int iAbs2 = Math.abs(this.f3578j - height);
                                        int i12 = this.f3577a;
                                        ((TextView) childAt3).setTextColor(Q2.b.a(iAbs2 < i12 ? iAbs2 / i12 : 1.0f, Integer.valueOf(this.e), Integer.valueOf(this.f)).intValue());
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
        TextView textViewD = d(this.n);
        if (textViewD != null) {
            int baseline = textViewD.getBaseline();
            TextView textViewD2 = d(this.n);
            if (textViewD2 != null) {
                fMeasureText = textViewD2.getPaint().measureText(this.f3584w == 2 ? "00" : "0000");
            } else {
                fMeasureText = 0.0f;
            }
            this.u = ((getWidth() + fMeasureText) / 2.0f) + a5.l.c(4.0f, getContext());
            this.f3582t = ((this.b - this.f3577a) / 2.0f) + baseline;
            invalidate();
        }
    }

    public final void e(List list, int i, boolean z10) {
        if (list == null) {
            return;
        }
        if (list.equals(this.f3585x)) {
            Log.i("WheelPicker", "data is the same.");
            return;
        }
        stopScroll();
        if (list.size() > 0) {
            this.f3584w = ((String) list.get(0)).length();
        }
        h hVar = new h();
        hVar.f3591a = list;
        setAdapter(new f(hVar, z10));
        this.p = false;
        this.g.scrollToPositionWithOffset((getInitialPosition() + i) - this.d, 0);
        b();
        this.f3585x = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i, int i6) {
        this.p = true;
        return super.fling(i, i6);
    }

    public int getCurrentItem() {
        return this.o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        k kVar = this.l;
        if (kVar == null || kVar.d) {
            return;
        }
        kVar.f = this.k.getApplicationContext();
        kVar.d = false;
        new Thread(new j(kVar, 0)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.l;
        if (kVar != null) {
            synchronized (kVar) {
                try {
                    kVar.g = true;
                    Handler handler = kVar.f3594a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (kVar.d) {
                            kVar.c.unload(kVar.e);
                        }
                        kVar.c.release();
                        kVar.b.quit();
                        kVar.d = false;
                        kVar.f = null;
                        kVar.f3594a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3579q || TextUtils.isEmpty(this.f3580r)) {
            return;
        }
        canvas.drawText(this.f3580r, this.u, this.f3582t, this.f3581s);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        int i12 = (i11 - i6) / 2;
        this.f3578j = i12;
        int i13 = this.f3577a / 2;
        int[] iArr = this.m;
        iArr[0] = (i12 - i13) - 20;
        iArr[1] = i13 + i12 + 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10 = this.b;
        if (i10 != 0) {
            super.onMeasure(i, i10);
        } else {
            super.onMeasure(i, i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.p = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.i = adapter;
        if (adapter instanceof f) {
            ((f) adapter).b = new q(this);
        }
    }

    public void setCurrentItem(int i) {
        this.p = false;
        this.g.scrollToPositionWithOffset((getInitialPosition() + i) - this.d, 0);
        b();
    }

    public void setDrawFlagEnable(boolean z10) {
        this.f3579q = z10;
    }

    public void setFlagText(String str) {
        this.f3580r = str;
    }

    public void setFlagTextColor(int i) {
        this.f3581s.setColor(i);
    }

    public void setFlagTextSize(float f) {
        this.f3581s.setTextSize(f);
    }

    public void setInfinityLoop(boolean z10) {
    }

    public void setItemCount(@IntRange(from = SingleSelectionLayout.DEFAULT_SELECTABLE_ID, to = 10) int i) {
        if (this.c != i) {
            this.c = i;
            this.d = i / 2;
            this.b = i * this.f3577a;
            requestLayout();
        }
    }

    public void setItemHeight(int i) {
        this.f3577a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.g = (LinearLayoutManager) layoutManager;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            post(new A6.l(this, 20));
        }
    }
}
