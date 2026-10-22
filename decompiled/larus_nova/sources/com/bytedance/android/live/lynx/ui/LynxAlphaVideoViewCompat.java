package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0007\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LynxAlphaVideoViewCompat;", "Lcom/lynx/tasm/behavior/ui/view/a;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getMAutoPlay", "()Z", "setMAutoPlay", "(Z)V", "mAutoPlay", "Landroidx/lifecycle/LifecycleRegistry;", "b", "Landroidx/lifecycle/LifecycleRegistry;", "getMLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setMLifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "mLifecycleRegistry", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "getMPoster", "()Landroid/graphics/Bitmap;", "setMPoster", "(Landroid/graphics/Bitmap;)V", "mPoster", "d", "getMLastFrame", "setMLastFrame", "mLastFrame", "e", "getMIsShowLastFrame", "setMIsShowLastFrame", "mIsShowLastFrame", "f", "getMIsShowPoster", "setMIsShowPoster", "mIsShowPoster", "Landroid/graphics/Paint;", ce.f26391f, "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mPaint", "Landroid/graphics/RectF;", "h", "Landroid/graphics/RectF;", "getMRectF", "()Landroid/graphics/RectF;", "setMRectF", "(Landroid/graphics/RectF;)V", "mRectF", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAlphaVideoViewCompat extends com.lynx.tasm.behavior.ui.view.a implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f82703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LifecycleRegistry f82704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap f82705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f82706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f82707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f82708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f82709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f82710h;

    @Override // androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f82703a == false) goto L6;
        this.f82704b.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f82704b.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f82704b;
    }

    public final boolean getMAutoPlay() {
        return this.f82703a;
    }

    public final boolean getMIsShowLastFrame() {
        return this.f82707e;
    }

    public final boolean getMIsShowPoster() {
        return this.f82708f;
    }

    public final Bitmap getMLastFrame() {
        return this.f82706d;
    }

    public final LifecycleRegistry getMLifecycleRegistry() {
        return this.f82704b;
    }

    public final Paint getMPaint() {
        return this.f82709g;
    }

    public final Bitmap getMPoster() {
        return this.f82705c;
    }

    public final RectF getMRectF() {
        return this.f82710h;
    }

    public LynxAlphaVideoViewCompat(Context r100) {
        super(r100);
        setWillNotDraw(false);
        this.f82704b = new LifecycleRegistry(this);
        this.f82709g = new Paint();
        this.f82710h = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f82705c == null) goto L12;
        if (this.f82706d == null) goto L12;
        if (this.f82708f == false) goto L12;
        this.f82710h.set(0.0f, 0.0f, getWidth(), getHeight());
        Bitmap r101 = this.f82706d;
        if (r101 == null) goto L19;
        r100.drawBitmap(r101, null, this.f82710h, this.f82709g);
        return;
    L19:
        return;
    L12:
        if (this.f82706d != null) goto L14;
        return;
    L14:
        if (this.f82707e == false) goto L22;
        this.f82710h.set(0.0f, 0.0f, getWidth(), getHeight());
        Bitmap r102 = this.f82706d;
        if (r102 == null) goto L23;
        r100.drawBitmap(r102, null, this.f82710h, this.f82709g);
        return;
    L23:
        return;
    }

    public final void setMAutoPlay(boolean r100) {
        this.f82703a = r100;
    }

    public final void setMIsShowLastFrame(boolean r100) {
        this.f82707e = r100;
    }

    public final void setMIsShowPoster(boolean r100) {
        this.f82708f = r100;
    }

    public final void setMLastFrame(Bitmap r100) {
        this.f82706d = r100;
    }

    public final void setMLifecycleRegistry(LifecycleRegistry r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f82704b = r100;
    }

    public final void setMPaint(Paint r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f82709g = r100;
    }

    public final void setMPoster(Bitmap r100) {
        this.f82705c = r100;
    }

    public final void setMRectF(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f82710h = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Iterator<View> r102 = UtilityKotlinExtentionsKt.g(this).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().measure(r100, r101);
        goto L4
    }
}
