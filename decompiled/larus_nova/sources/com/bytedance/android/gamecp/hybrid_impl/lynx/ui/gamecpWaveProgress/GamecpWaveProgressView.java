package com.bytedance.android.gamecp.hybrid_impl.lynx.ui.gamecpWaveProgress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import lw.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/lynx/ui/gamecpWaveProgress/GamecpWaveProgressView;", "Landroid/view/View;", "", "progress", "", "setProgress", "", "colors", "setColors", "Lcom/bytedance/android/gamecp/hybrid_impl/lynx/ui/gamecpWaveProgress/GradientDirection;", "direction", "setGradientDirection", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamecpWaveProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f57713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f57714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f57717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f57718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f57719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f57720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f57721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GradientDirection f57722j;

    public static float[] a(int[] r100) {
        float[] r101 = new float[r100.length];
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r105 = r100[r103];
        r101[r104] = r104 / (r100.length - 1);
        r103 = r103 + 1;
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r310) {
        Intrinsics.checkNotNullParameter(r310, "canvas");
        super.onDraw(r310);
        float r100 = getWidth() / 2.0f;
        float r101 = getHeight() / 2.0f;
        float r102 = Math.min(r100, r101);
        this.f57717e.reset();
        this.f57717e.addCircle(r100, r101, r102, Path.Direction.CW);
        r310.save();
        r310.clipPath(this.f57717e);
        r310.drawColor(0);
        this.f57714b.reset();
        int r103 = a.f510980a[this.f57722j.ordinal()];
        if (r103 != 1) goto L5;
        float r104 = getHeight();
        float r105 = getWidth();
        float r210 = (1.0f - this.f57718f) * getHeight();
        int[] r106 = this.f57721i;
        LinearGradient r107 = new LinearGradient(0.0f, r104, r105, r210, r106, a(r106), Shader.TileMode.CLAMP);
    L16:
        this.f57713a.setShader(r107);
        this.f57714b.moveTo((-this.f57716d) + this.f57719g, (1.0f - this.f57718f) * getHeight());
        int r108 = -this.f57716d;
    L17:
        int r109 = getWidth();
        int r110 = this.f57716d;
        if (r108 > (r109 + r110)) goto L20;
        float r111 = r110;
        this.f57714b.rQuadTo(r111 / 4.0f, -this.f57715c, r111 / 2.0f, 0.0f);
        Path r112 = this.f57714b;
        float r113 = this.f57716d;
        r112.rQuadTo(r113 / 4.0f, this.f57715c, r113 / 2.0f, 0.0f);
        r108 = r108 + this.f57716d;
        goto L17
    L20:
        this.f57714b.lineTo(getWidth(), getHeight());
        this.f57714b.lineTo(0.0f, getHeight());
        this.f57714b.close();
        r310.drawPath(this.f57714b, this.f57713a);
        r310.restore();
        return;
    L5:
        if (r103 != 2) goto L7;
        float r114 = (1.0f - this.f57718f) * getHeight();
        float r115 = getWidth();
        float r116 = getHeight();
        int[] r117 = this.f57721i;
        r107 = new LinearGradient(0.0f, r114, r115, r116, r117, a(r117), Shader.TileMode.CLAMP);
        goto L16
    L7:
        if (r103 != 3) goto L9;
        float r118 = getHeight() * (1.0f - (this.f57718f * 0.5f));
        float r119 = getWidth();
        float r120 = (1.0f - (this.f57718f * 0.5f)) * getHeight();
        int[] r121 = this.f57721i;
        r107 = new LinearGradient(0.0f, r118, r119, r120, r121, a(r121), Shader.TileMode.CLAMP);
        goto L16
    L9:
        if (r103 != 4) goto L12;
        float r122 = 2;
        float r123 = getWidth() / r122;
        float r124 = (1.0f - this.f57718f) * getHeight();
        float r125 = getWidth() / r122;
        float r126 = getHeight();
        int[] r127 = this.f57721i;
        r107 = new LinearGradient(r123, r124, r125, r126, r127, a(r127), Shader.TileMode.CLAMP);
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void setColors(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f57721i = r100;
        invalidate();
    }

    public final void setGradientDirection(GradientDirection r100) {
        Intrinsics.checkNotNullParameter(r100, "direction");
        this.f57722j = r100;
        invalidate();
    }

    public final void setProgress(float r100) {
        this.f57718f = r100 / 100;
        invalidate();
    }

    public GamecpWaveProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public GamecpWaveProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        this.f57713a = r103;
        this.f57714b = new Path();
        this.f57715c = UtilityKotlinExtentionsKt.c(3);
        this.f57716d = UtilityKotlinExtentionsKt.c(30);
        this.f57717e = new Path();
        this.f57721i = new int[]{y0.c(R.color.gamecp_wave_progress1), y0.c(R.color.gamecp_wave_progress2), y0.c(R.color.gamecp_wave_progress3)};
        this.f57722j = GradientDirection.DIAGONAL_BOTTOM_LEFT_TO_TOP_RIGHT;
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
    }
}
