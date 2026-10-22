package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/LiveAvatarCircleView;", "Landroid/view/View;", "", "value", "", "setStrokeWidth", "", "fraction", "setFraction", VideoThumbInfo.KEY_INTERVAL, "setInterval", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveAvatarCircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f72393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f72394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f72397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f72398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f72400h;

    public static final class a {
    }

    static {
    }

    public LiveAvatarCircleView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveAvatarCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        float r101 = this.f72395c;
        float r102 = this.f72396d;
        float r103 = this.f72397e;
        Paint r104 = this.f72393a;
        Intrinsics.checkNotNull(r104);
        r100.drawCircle(r101, r102, r103, r104);
        float r105 = this.f72395c;
        float r106 = this.f72396d;
        float r107 = this.f72398f;
        Paint r108 = this.f72400h;
        Intrinsics.checkNotNull(r108);
        r100.drawCircle(r105, r106, r107, r108);
    }

    public final void setFraction(float r100) {
        float r101 = this.f72397e + (this.f72399g * r100);
        float r102 = this.f72394b * (1 - r100);
        this.f72398f = r101;
        Paint r103 = this.f72400h;
        Intrinsics.checkNotNull(r103);
        r103.setStrokeWidth(r102);
        postInvalidate();
    }

    public final void setInterval(int r100) {
        this.f72399g = r100;
    }

    public final void setStrokeWidth(int r100) {
        this.f72394b = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f72395c = getMeasuredWidth() / 2;
        this.f72396d = getMeasuredHeight() / 2;
        float r102 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.f72397e = r102;
        this.f72398f = r102;
        this.f72399g = 9;
    }

    public LiveAvatarCircleView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.live_paintWidth, R.attr.live_strokeWidth});
        this.f72394b = r113.getDimension(1, UIUtils.dip2Px(r110, 1.5f));
        r113.recycle();
        Paint r114 = new Paint();
        this.f72393a = r114;
        LinearGradient r100 = new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR);
        Intrinsics.checkNotNull(r114);
        r114.setShader(r100);
        Intrinsics.checkNotNull(r114);
        r114.setAntiAlias(true);
        Intrinsics.checkNotNull(r114);
        r114.setDither(true);
        Intrinsics.checkNotNull(r114);
        r114.setStyle(Paint.Style.STROKE);
        Intrinsics.checkNotNull(r114);
        r114.setStrokeWidth(UIUtils.dip2Px(r110, 1.5f));
        this.f72400h = new Paint(r114);
    }

    public /* synthetic */ LiveAvatarCircleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
