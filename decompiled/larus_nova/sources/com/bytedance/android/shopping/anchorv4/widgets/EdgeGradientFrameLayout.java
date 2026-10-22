package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/EdgeGradientFrameLayout;", "Landroid/widget/FrameLayout;", "", "value", "c", "Z", "isEnableGradient", "()Z", "setEnableGradient", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EdgeGradientFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f170164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f170165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f170166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearGradient[] f170167d;

    public EdgeGradientFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public EdgeGradientFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        ArraysKt.fill$default(this.f170167d, null, 0, 0, 6, null);
        if (getWidth() != 0) goto L5;
    L29:
        invalidate();
        return;
    L5:
        if (getHeight() == 0) goto L29;
        Rect r100 = this.f170165b;
        int r101 = r100.left;
        if (r101 != 0) goto L16;
        if (r100.right != 0) goto L16;
        if (r100.top != 0) goto L16;
        if (r100.bottom == 0) goto L29;
    L16:
        if (r101 <= 0) goto L19;
        this.f170167d[0] = new LinearGradient(0.0f, 0.0f, this.f170165b.left, 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L19:
        if (this.f170165b.right <= 0) goto L22;
        this.f170167d[1] = new LinearGradient(getWidth() - this.f170165b.right, 0.0f, getWidth(), 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L22:
        if (this.f170165b.top <= 0) goto L25;
        this.f170167d[2] = new LinearGradient(0.0f, 0.0f, 0.0f, this.f170165b.top, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L25:
        if (this.f170165b.bottom <= 0) goto L27;
        this.f170167d[3] = new LinearGradient(0.0f, getHeight() - this.f170165b.bottom, 0.0f, getHeight(), new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
    L27:
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f170166c == true) goto L6;
        super.dispatchDraw(r110);
        return;
    L6:
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.dispatchDraw(r110);
        LinearGradient[] r101 = this.f170167d;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        LinearGradient r104 = r101[r103];
        if (r104 == null) goto L11;
        this.f170164a.setShader(r104);
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f170164a);
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        r110.restoreToCount(r100);
    }

    public final void setEnableGradient(boolean r100) {
        this.f170166c = r100;
        invalidate();
    }

    public EdgeGradientFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        Unit r104 = Unit.INSTANCE;
        this.f170164a = r103;
        this.f170165b = new Rect();
        this.f170166c = true;
        LinearGradient[] r105 = new LinearGradient[4];
        int r106 = 0;
    L3:
        if (r106 >= 4) goto L5;
        r105[r106] = null;
        r106 = r106 + 1;
        goto L3
    L5:
        this.f170167d = r105;
    }

    public /* synthetic */ EdgeGradientFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(int r100, int r101, int r102, int r103) {
        Rect r104 = this.f170165b;
        if (r104.left == r100) goto L5;
    L11:
        r104.left = r100;
        r104.top = r101;
        r104.right = r102;
        r104.bottom = r103;
        a();
        return;
    L5:
        if (r104.top != r101) goto L11;
        if (r104.right != r102) goto L11;
        if (r104.bottom != r103) goto L11;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        a();
    }
}
