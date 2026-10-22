package com.bytedance.android.livesdk.chatroom.end.vip.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/end/vip/view/CountDownProgressView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f106163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f106164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f106165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f106166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f106167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f106168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint.FontMetrics f106169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f106170h;

    public static final class a {
    }

    static {
    }

    public CountDownProgressView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountDownProgressView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setContentDescription("会员直播开启中");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = getWidth() - this.f106164b.width();
        float r102 = 2;
        float r103 = (getHeight() - this.f106164b.height()) / r102;
        this.f106164b.offsetTo(r101 / r102, r103);
        RectF r104 = this.f106164b;
        float r105 = this.f106165c;
        r100.drawRoundRect(r104, r105, r105, this.f106163a);
        r100.save();
        r100.clipRect(0, 0, (int) (this.f106170h * getWidth()), getHeight());
        RectF r106 = this.f106164b;
        float r107 = this.f106165c;
        r100.drawRoundRect(r106, r107, r107, this.f106166d);
        RectF r108 = this.f106164b;
        float r109 = this.f106165c;
        r100.drawRoundRect(r108, r109, r109, this.f106167e);
        r100.restore();
        float r110 = this.f106164b.centerX();
        float r111 = this.f106164b.centerY();
        Paint.FontMetrics r112 = this.f106169g;
        r100.drawText("会员直播开启中", r110, r111 - ((r112.ascent + r112.descent) / r102), this.f106168f);
    }

    public CountDownProgressView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        Resources r113 = getResources();
        float r114 = WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).density;
        Paint r115 = new Paint();
        r115.setStyle(Paint.Style.STROKE);
        r115.setAntiAlias(true);
        r115.setColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r115.setStrokeWidth(0.5f * r114);
        r115.setAlpha(102);
        Unit r100 = Unit.INSTANCE;
        this.f106163a = r115;
        RectF r101 = new RectF(0.0f, 0.0f, 106 * r114, 32 * r114);
        this.f106164b = r101;
        this.f106165c = 16 * r114;
        int[] r102 = {ColorProtector.parseColor("#29FFFFFF"), ColorProtector.parseColor("#7FFFFFFF"), ColorProtector.parseColor("#80FFFFFF")};
        float r103 = r101.left;
        float r104 = r101.top;
        LinearGradient r105 = new LinearGradient(r103, r104, r101.right, r104, r102, new float[]{0.0721f, 0.9984f, 1.0f}, Shader.TileMode.CLAMP);
        Paint r106 = new Paint();
        r106.setColor(-1);
        r106.setStyle(Paint.Style.FILL);
        r106.setShader(r105);
        this.f106166d = r106;
        Paint r107 = new Paint();
        r107.setColor(-1);
        r107.setStrokeWidth(1 * r114);
        r107.setStyle(Paint.Style.STROKE);
        r107.setAntiAlias(true);
        this.f106167e = r107;
        Paint r116 = new Paint();
        r116.setColor(-1);
        r116.setStyle(Paint.Style.FILL);
        r116.setTextSize(13 * r114);
        r116.setTextAlign(Paint.Align.CENTER);
        r116.setFakeBoldText(true);
        r116.setAlpha(230);
        r116.setAntiAlias(true);
        this.f106168f = r116;
        this.f106169g = r116.getFontMetrics();
    }

    public /* synthetic */ CountDownProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
