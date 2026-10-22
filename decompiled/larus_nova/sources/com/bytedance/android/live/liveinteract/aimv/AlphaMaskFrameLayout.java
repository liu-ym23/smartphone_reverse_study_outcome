package com.bytedance.android.live.liveinteract.aimv;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012RR\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/aimv/AlphaMaskFrameLayout;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Pair;", "", "value", "f", "Ljava/util/List;", "getAlphaMask", "()Ljava/util/List;", "setAlphaMask", "(Ljava/util/List;)V", "alphaMask", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AlphaMaskFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f70902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f70903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f70904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f70905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f70906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Pair<Float, Float>> f70907f;

    public final List<Pair<Float, Float>> getAlphaMask() {
        return this.f70907f;
    }

    public AlphaMaskFrameLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        List<Pair<Float, Float>> r100 = this.f70907f;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        int r103 = r110.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    L12:
        super.dispatchDraw(r110);
        if (r100 != null) goto L15;
    L18:
        if (r101 == true) goto L28;
        int[] r104 = this.f70905d;
        float[] r111 = this.f70904c;
        if (r104 == null) goto L26;
        if (r111 == null) goto L26;
        if (this.f70906e != null) goto L25;
        this.f70906e = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), r104, r111, Shader.TileMode.CLAMP);
    L25:
        this.f70903b.setShader(this.f70906e);
        this.f70903b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    L26:
        r110.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.f70903b);
        r110.restoreToCount(r103);
        return;
    L28:
        return;
    L15:
        if (r100.isEmpty() == true) goto L18;
        r101 = false;
        goto L18
    L11:
        r103 = 0;
        goto L12
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void setAlphaMask(List<Pair<Float, Float>> r110) {
        this.f70907f = r110;
        int r100 = 0;
        if (r110 == null) goto L5;
        int r101 = r110.size();
    L7:
        if (r110 == null) goto L18;
        float[] r102 = new float[r101];
        int r103 = 0;
    L10:
        if (r103 >= r101) goto L12;
        r102[r103] = 0.0f;
        r103 = r103 + 1;
        goto L10
    L12:
        this.f70904c = r102;
        int[] r104 = new int[r101];
        int r105 = 0;
    L13:
        if (r105 >= r101) goto L15;
        r104[r105] = 0;
        r105 = r105 + 1;
        goto L13
    L15:
        this.f70905d = r104;
    L16:
        if (r100 >= r101) goto L19;
        float[] r106 = this.f70904c;
        Intrinsics.checkNotNull(r106);
        r106[r100] = ((Number) ((Pair) ListProtector.get(r110, r100)).getFirst()).floatValue();
        int[] r107 = this.f70905d;
        Intrinsics.checkNotNull(r107);
        r107[r100] = (((int) (RangesKt.coerceIn(((Number) ((Pair) ListProtector.get(r110, r100)).getSecond()).floatValue(), 0.0f, 1.0f) * 255)) << 24) | ((int) (this.f70902a & 16777215));
        r100 = r100 + 1;
    L19:
        this.f70906e = null;
        invalidate();
        return;
    L18:
        this.f70904c = null;
        this.f70905d = null;
        goto L19
    L5:
        r101 = 0;
        goto L7
    }

    public AlphaMaskFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f70902a = 4278190080L;
        Paint r102 = new Paint(1);
        r102.setDither(true);
        Unit r103 = Unit.INSTANCE;
        this.f70903b = r102;
    }
}
