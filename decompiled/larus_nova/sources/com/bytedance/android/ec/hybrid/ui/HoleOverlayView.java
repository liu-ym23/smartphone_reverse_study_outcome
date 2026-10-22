package com.bytedance.android.ec.hybrid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/HoleOverlayView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "c", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HoleOverlayView extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f47681c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f47682d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f47683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f47684b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f47685a = null;

        static {
            f47685a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f47686a = null;

        static {
            f47686a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    public static final class c {
    }

    static {
        f47681c = UIToolsKt.a(13);
        f47682d = UIToolsKt.a(2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = f47681c;
        r100.drawColor(ColorProtector.parseColor("#CCFFFFFF"));
        r100.drawRoundRect(this.f47684b, r101, r101, this.f47683a);
    }

    public HoleOverlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint(1);
        this.f47683a = r102;
        this.f47684b = new RectF();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setLayerType(1, null);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setOnClickListener(a.f47685a);
        setOnTouchListener(b.f47686a);
    }

    public final void a(int r100, int r101, int r102, int r103) {
        int r104 = f47682d;
        float r105 = r100 - r104;
        float r106 = r101 - r104;
        float r107 = (r100 + r102) + r104;
        float r108 = (r101 + r103) + r104;
        RectF r109 = this.f47684b;
        if (r109.left == r105) goto L5;
    L10:
        r109.set(r105, r106, r107, r108);
        invalidate();
        return;
    L5:
        if (r109.top != r106) goto L10;
        if (r109.right != r107) goto L10;
        if (r109.bottom != r108) goto L10;
    }
}
