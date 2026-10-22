package com.stepos.common.picker;

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
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class WheelPicker extends RecyclerView {
    public static final /* synthetic */ int D = 0;
    public int A;
    public List<String> B;
    public final d C;

    /* renamed from: a, reason: collision with root package name */
    public int f6507a;

    /* renamed from: b, reason: collision with root package name */
    public int f6508b;

    /* renamed from: c, reason: collision with root package name */
    public int f6509c;

    /* renamed from: d, reason: collision with root package name */
    public int f6510d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6511e;
    public final int h;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayoutManager f6512j;

    /* renamed from: k, reason: collision with root package name */
    public final LinearSnapHelper f6513k;

    /* renamed from: l, reason: collision with root package name */
    public RecyclerView.Adapter<RecyclerView.ViewHolder> f6514l;

    /* renamed from: m, reason: collision with root package name */
    public int f6515m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f6516n;

    /* renamed from: o, reason: collision with root package name */
    public final h f6517o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f6518p;

    /* renamed from: q, reason: collision with root package name */
    public View f6519q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6520s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6521t;

    /* renamed from: u, reason: collision with root package name */
    public String f6522u;

    /* renamed from: v, reason: collision with root package name */
    public final Paint f6523v;

    /* renamed from: w, reason: collision with root package name */
    public float f6524w;

    /* renamed from: x, reason: collision with root package name */
    public float f6525x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f6526y;
    public ArrayList z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            WheelPicker wheelPicker = WheelPicker.this;
            wheelPicker.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            wheelPicker.addOnScrollListener(wheelPicker.C);
            wheelPicker.b();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WheelPicker wheelPicker = WheelPicker.this;
            wheelPicker.requestLayout();
            int i10 = WheelPicker.D;
            wheelPicker.b();
            wheelPicker.d();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c {
        public c() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0) {
                WheelPicker wheelPicker = WheelPicker.this;
                TextView textViewE = WheelPicker.e(wheelPicker.f6519q);
                String str = (textViewE == null || TextUtils.isEmpty(textViewE.getText())) ? null : (String) textViewE.getText();
                if (wheelPicker.z != null) {
                    for (int i11 = 0; i11 < wheelPicker.z.size(); i11++) {
                        ((e) wheelPicker.z.get(i11)).a(str);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            int i12 = WheelPicker.D;
            WheelPicker.this.b();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface e {
        void a(String str);
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSWheelPickerStyle);
        this.f6518p = new int[2];
        this.f6521t = false;
        this.A = 2;
        this.C = new d();
        setOverScrollMode(2);
        super.setVerticalScrollBarEnabled(false);
        super.setHorizontalScrollBarEnabled(false);
        this.f6516n = context;
        int[] iArr = g8.a.f9096x;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.StepOSWheelPickerStyle, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.StepOSWheelPickerStyle, 0);
        this.f6507a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_select_item_height));
        this.f6511e = typedArrayObtainStyledAttributes.getColor(5, context.getResources().getColor(R.color.fd_sys_color_on_surface_default));
        this.h = typedArrayObtainStyledAttributes.getColor(4, context.getResources().getColor(R.color.fd_sys_color_on_surface_variant_default));
        int i10 = typedArrayObtainStyledAttributes.getInt(2, 5);
        int color = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context.getResources().getDimensionPixelSize(R.dimen.mc_picker_text_size));
        setItemCount(i10);
        Paint paint = new Paint(1);
        this.f6523v = paint;
        paint.setColor(color);
        paint.setTextSize(dimensionPixelSize);
        paint.setFakeBoldText(true);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        h hVar = new h();
        hVar.f6544a = null;
        hVar.f6545b = null;
        hVar.f6551i = 0L;
        this.f6517o = hVar;
        setLayoutManager(new LinearLayoutManager(context));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.f6513k = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.f6507a);
        post(new y0(this, 7));
    }

    public static TextView e(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                return e(childAt);
            }
        }
        return null;
    }

    private int getInitialPosition() {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.f6514l;
        if (!(adapter instanceof com.stepos.common.picker.d)) {
            return 0;
        }
        com.stepos.common.picker.d dVar = (com.stepos.common.picker.d) adapter;
        com.stepos.common.picker.e eVar = dVar.f6534a;
        if (!dVar.f6536c) {
            return 0;
        }
        return eVar.getItemCount() * (Integer.MAX_VALUE / (eVar.getItemCount() * 2));
    }

    public final void a(e eVar) {
        if (this.z == null) {
            this.z = new ArrayList();
        }
        this.z.add(eVar);
    }

    public final void b() {
        float f8;
        h hVar;
        Handler handler;
        LinearLayoutManager linearLayoutManager = this.f6512j;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f6512j.getChildAt(i10);
                if (childAt == null) {
                    Log.w("WheelPicker", "wtf! child was null.");
                } else {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    int height = (childAt.getHeight() / 2) + childAt.getTop();
                    int i11 = this.f6507a / 2;
                    int i12 = height - i11;
                    int[] iArr = this.f6518p;
                    if (i12 > iArr[0] && i11 + height < iArr[1] && this.r != childAdapterPosition) {
                        if (this.f6520s && (handler = (hVar = this.f6517o).f6544a) != null) {
                            handler.post(new g(hVar, 0));
                        }
                        this.r = childAdapterPosition;
                        this.f6519q = childAt;
                        if (this.f6520s) {
                            if (l8.a.b()) {
                                performHapticFeedback(21000);
                            } else {
                                Context context = getContext();
                                if (l8.a.c(context)) {
                                    Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                                    if (a4.a.f(context, "android.permission.VIBRATE", Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null) == 0 && vibrator != null && vibrator.hasVibrator()) {
                                        vibrator.vibrate(VibrationEffect.createOneShot(50L, 2));
                                    }
                                }
                            }
                        }
                    }
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        if (viewGroup.getChildCount() > 0) {
                            View childAt2 = viewGroup.getChildAt(0);
                            int i13 = this.f6515m;
                            if (i13 == 0 || this.f6507a == 0) {
                                Log.w("WheelPicker", "mLocYCenter nor itemHeight init, mLocYCenter:" + this.f6515m + ",itemHeight:" + this.f6507a);
                                f8 = 1.0f;
                            } else {
                                int iAbs = Math.abs(height - i13);
                                f8 = (1.0f - ((iAbs / r5) * 0.15f)) - (((iAbs % r5) / this.f6507a) * 0.15f);
                            }
                            float fMax = Math.max(0.0f, f8);
                            childAt2.setScaleX(fMax);
                            childAt2.setScaleY(fMax);
                            if (childAt2 instanceof ViewGroup) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt2;
                                if (viewGroup2.getChildCount() > 0) {
                                    View childAt3 = viewGroup2.getChildAt(0);
                                    if (childAt3 instanceof TextView) {
                                        int iAbs2 = Math.abs(this.f6515m - height);
                                        int i14 = this.f6507a;
                                        ((TextView) childAt3).setTextColor(l4.b.a(iAbs2 < i14 ? iAbs2 / i14 : 1.0f, Integer.valueOf(this.f6511e), Integer.valueOf(this.h)).intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void d() {
        float fMeasureText;
        TextView textViewE = e(this.f6519q);
        if (textViewE == null) {
            this.f6526y = false;
            return;
        }
        int baseline = textViewE.getBaseline();
        TextView textViewE2 = e(this.f6519q);
        if (textViewE2 != null) {
            fMeasureText = textViewE2.getPaint().measureText(this.A == 2 ? "00" : "0000");
        } else {
            fMeasureText = 0.0f;
        }
        this.f6525x = ((getWidth() + fMeasureText) / 2.0f) + l8.f.a(4.0f, getContext());
        this.f6524w = ((this.f6508b - this.f6507a) / 2.0f) + baseline;
        this.f6526y = true;
        invalidate();
    }

    public final void f(int i10, List list, boolean z) {
        if (list == null) {
            return;
        }
        if (list.equals(this.B)) {
            Log.i("WheelPicker", "data is the same.");
            return;
        }
        stopScroll();
        if (list.size() > 0) {
            this.A = ((String) list.get(0)).length();
        }
        this.f6526y = false;
        com.stepos.common.picker.e eVar = new com.stepos.common.picker.e();
        eVar.f6538a = list;
        setAdapter(new com.stepos.common.picker.d(eVar, z));
        this.f6520s = false;
        this.f6512j.scrollToPositionWithOffset((getInitialPosition() + i10) - this.f6510d, 0);
        b();
        this.B = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final boolean fling(int i10, int i11) {
        this.f6520s = true;
        return super.fling(i10, i11);
    }

    public int getCurrentItem() {
        return this.r;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h hVar = this.f6517o;
        if (hVar == null || hVar.f6547d) {
            return;
        }
        hVar.f6549f = this.f6516n.getApplicationContext();
        hVar.f6547d = false;
        new Thread(new f(hVar)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f6517o;
        if (hVar != null) {
            synchronized (hVar) {
                try {
                    hVar.f6550g = true;
                    Handler handler = hVar.f6544a;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (hVar.f6547d) {
                            hVar.f6546c.unload(hVar.f6548e);
                        }
                        hVar.f6546c.release();
                        hVar.f6545b.quit();
                        hVar.f6547d = false;
                        hVar.f6549f = null;
                        hVar.f6544a = null;
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
        if (this.f6521t && this.f6526y && !TextUtils.isEmpty(this.f6522u)) {
            canvas.drawText(this.f6522u, this.f6525x, this.f6524w, this.f6523v);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        int i14 = (i13 - i11) / 2;
        this.f6515m = i14;
        int i15 = this.f6507a / 2;
        int[] iArr = this.f6518p;
        iArr[0] = (i14 - i15) - 20;
        iArr[1] = i15 + i14 + 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12 = this.f6508b;
        if (i12 != 0) {
            super.onMeasure(i10, i12);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.f6520s = true;
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.f6514l = adapter;
        if (adapter instanceof com.stepos.common.picker.d) {
            ((com.stepos.common.picker.d) adapter).f6535b = new c();
        }
    }

    public void setCurrentItem(int i10) {
        this.f6520s = false;
        this.f6512j.scrollToPositionWithOffset((getInitialPosition() + i10) - this.f6510d, 0);
        b();
    }

    public void setDrawFlagEnable(boolean z) {
        this.f6521t = z;
    }

    public void setFlagText(String str) {
        this.f6522u = str;
    }

    public void setFlagTextColor(int i10) {
        this.f6523v.setColor(i10);
    }

    public void setFlagTextSize(float f8) {
        this.f6523v.setTextSize(f8);
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        super.setHorizontalScrollBarEnabled(false);
    }

    public void setItemCount(int i10) {
        if (this.f6509c != i10) {
            this.f6509c = i10;
            this.f6510d = i10 / 2;
            this.f6508b = i10 * this.f6507a;
            requestLayout();
        }
    }

    public void setItemHeight(int i10) {
        this.f6507a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.f6512j = (LinearLayoutManager) layoutManager;
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        super.setVerticalScrollBarEnabled(false);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 0) {
            post(new b());
        }
    }

    public void setInfinityLoop(boolean z) {
    }
}
