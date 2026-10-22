package com.bytedance.android.live.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.bytedance.android.live.core.setting.p6;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u001f\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RR\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u00122\u001a\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/ui/ClipImageView;", "Lcom/bytedance/android/live/core/widget/HSImageView;", "", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Boolean;", "getCLIP_PATH_OPT_SETTING", "()Ljava/lang/Boolean;", "CLIP_PATH_OPT_SETTING", "Landroid/graphics/Path;", "value", "c", "Landroid/graphics/Path;", "getMClipPath", "()Landroid/graphics/Path;", "setMClipPath", "(Landroid/graphics/Path;)V", "mClipPath", "", "Lkotlin/Pair;", "", "h", "Ljava/util/List;", "getAlphaMask", "()Ljava/util/List;", "setAlphaMask", "(Ljava/util/List;)V", "alphaMask", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClipImageView extends HSImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f101939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f101940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f101941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f101942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f101943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f101944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearGradient f101945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Pair<Float, Float>> f101946h;

    public ClipImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ClipImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final List<Pair<Float, Float>> getAlphaMask() {
        return this.f101946h;
    }

    public final Boolean getCLIP_PATH_OPT_SETTING() {
        return this.f101939a;
    }

    public final Path getMClipPath() {
        return this.f101941c;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Path r100 = this.f101941c;
        if (r100 == null) goto L5;
        r110.clipPath(r100, Region.Op.DIFFERENCE);
    L5:
        List<Pair<Float, Float>> r101 = this.f101946h;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        int r104 = r110.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    L15:
        super.draw(r110);
        if (r101 != null) goto L18;
    L21:
        if (r102 == true) goto L31;
        int[] r105 = this.f101944f;
        float[] r111 = this.f101943e;
        if (r105 == null) goto L29;
        if (r111 == null) goto L29;
        if (this.f101945g != null) goto L28;
        this.f101945g = new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), r105, r111, Shader.TileMode.CLAMP);
    L28:
        this.f101942d.setShader(this.f101945g);
        this.f101942d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    L29:
        r110.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.f101942d);
        r110.restoreToCount(r104);
        return;
    L31:
        return;
    L18:
        if (r101.isEmpty() == true) goto L21;
        r102 = false;
        goto L21
    L14:
        r104 = 0;
        goto L15
    L8:
        if (r101.isEmpty() == true) goto L11;
        r103 = false;
        goto L12
    }

    public final void setAlphaMask(List<Pair<Float, Float>> r110) {
        this.f101946h = r110;
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
        this.f101943e = r102;
        int[] r104 = new int[r101];
        int r105 = 0;
    L13:
        if (r105 >= r101) goto L15;
        r104[r105] = 0;
        r105 = r105 + 1;
        goto L13
    L15:
        this.f101944f = r104;
    L16:
        if (r100 >= r101) goto L19;
        float[] r106 = this.f101943e;
        Intrinsics.checkNotNull(r106);
        r106[r100] = ((Number) ((Pair) ListProtector.get(r110, r100)).getFirst()).floatValue();
        int[] r107 = this.f101944f;
        Intrinsics.checkNotNull(r107);
        r107[r100] = (((int) (RangesKt.coerceIn(((Number) ((Pair) ListProtector.get(r110, r100)).getSecond()).floatValue(), 0.0f, 1.0f) * 255)) << 24) | ((int) (this.f101940b & 16777215));
        r100 = r100 + 1;
    L19:
        this.f101945g = null;
        invalidate();
        return;
    L18:
        this.f101943e = null;
        this.f101944f = null;
        goto L19
    L5:
        r101 = 0;
        goto L7
    }

    public final void setMClipPath(Path r100) {
        if (this.f101939a.booleanValue() == true) goto L5;
    L15:
        this.f101941c = r100;
        invalidate();
        return;
    L5:
        if (this.f101941c == null) goto L15;
        if (r100 == null) goto L15;
        Path r101 = new Path();
        Path r102 = this.f101941c;
        Intrinsics.checkNotNull(r102);
        r101.op(r102, r100, Path.Op.DIFFERENCE);
        Path r103 = new Path();
        if (r101.isEmpty() == false) goto L10;
        Path r104 = this.f101941c;
        Intrinsics.checkNotNull(r104);
        r103.op(r100, r104, Path.Op.DIFFERENCE);
    L10:
        this.f101941c = r100;
        if (r101.isEmpty() == true) goto L13;
    L14:
        invalidate();
        return;
    L13:
        if (r103.isEmpty() == false) goto L14;
    }

    public ClipImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f101939a = p6.f65385a.getValue();
        this.f101940b = 4278190080L;
        Paint r103 = new Paint(1);
        r103.setDither(true);
        Unit r104 = Unit.INSTANCE;
        this.f101942d = r103;
    }

    public /* synthetic */ ClipImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
