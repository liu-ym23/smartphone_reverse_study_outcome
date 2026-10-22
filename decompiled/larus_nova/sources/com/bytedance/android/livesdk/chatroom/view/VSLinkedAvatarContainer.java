package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001b\u0010\u001a\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/VSLinkedAvatarContainer;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Paint;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "", "b", FaceService.girlLabel, "getCenterX", "()F", "setCenterX", "(F)V", "centerX", "c", "getCenterY", "setCenterY", "centerY", "d", "getRadius", "setRadius", "radius", "e", "getMCirclePaint", "mCirclePaint", "", "f", "Z", "getEnableCircle", "()Z", "setEnableCircle", "(Z)V", "enableCircle", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLinkedAvatarContainer extends FrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f114733g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f114734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f114735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f114736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f114737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f114738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f114739f;

    public VSLinkedAvatarContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSLinkedAvatarContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getMCirclePaint() {
        return (Paint) this.f114738e.getValue();
    }

    private final Paint getMPaint() {
        return (Paint) this.f114734a.getValue();
    }

    public static float a() {
        Resources r100 = s1.getContext().getApplicationContext().getResources();
        return (WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density * 1) + 0.5f;
    }

    public final float getCenterX() {
        return this.f114735b;
    }

    public final float getCenterY() {
        return this.f114736c;
    }

    public final boolean getEnableCircle() {
        return this.f114739f;
    }

    public final float getRadius() {
        return this.f114737d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.dispatchDraw(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.f114739f == false) goto L6;
        r100.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - a(), getMCirclePaint());
        return;
    }

    public final void setCenterX(float r100) {
        this.f114735b = r100;
    }

    public final void setCenterY(float r100) {
        this.f114736c = r100;
    }

    public final void setEnableCircle(boolean r100) {
        this.f114739f = r100;
    }

    public final void setRadius(float r100) {
        this.f114737d = r100;
    }

    public VSLinkedAvatarContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f114734a = LazyKt.lazy(r103, VSLinkedAvatarContainer$mPaint$2.INSTANCE);
        this.f114738e = LazyKt.lazy(r103, new VSLinkedAvatarContainer$mCirclePaint$2(this));
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (r101 == null) goto L5;
        Object r103 = r101.getTag();
    L7:
        if (Intrinsics.areEqual(r103, "living_view") == false) goto L13;
        float r104 = this.f114737d;
        if (r104 <= 0) goto L14;
        r100.drawCircle(this.f114735b, this.f114736c, r104, getMPaint());
    L14:
        return super.drawChild(r100, r101, r102);
    L13:
        return super.drawChild(r100, r101, r102);
    L5:
        r103 = null;
        goto L7
    }

    public /* synthetic */ VSLinkedAvatarContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
