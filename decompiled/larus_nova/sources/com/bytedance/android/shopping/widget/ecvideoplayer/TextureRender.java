package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/TextureRender;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/PlayerDebugView;", "ecDebugView", "", "setDebugView", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "videoPlayer", "setPlayer", "", "value", ce.f26391f, "I", "getScaleType", "()I", "setScaleType", "(I)V", "scaleType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextureRender extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f187387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECVideoPlayer f187388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SurfaceTexture f187389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f187390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlayerDebugView f187391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f187392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f187393g;

    public TextureRender(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TextureRender(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
    }

    public final int getScaleType() {
        return this.f187393g;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        PlayerDebugView r101 = this.f187391e;
        if (r101 == null) goto L7;
        TextView r102 = r101.f187384e;
        if (r102 == null) goto L7;
        r102.setText("surface:none");
    L7:
        this.f187387a = false;
        ECVideoPlayer r103 = this.f187388b;
        if (r103 == null) goto L10;
        r103.i();
    L10:
        Surface r104 = this.f187390d;
        if (r104 == null) goto L13;
        r104.release();
    L13:
        SurfaceTexture r105 = this.f187389c;
        if (r105 == null) goto L16;
        r105.release();
    L16:
        this.f187389c = null;
        this.f187390d = null;
        return false;
    }

    public final void setDebugView(PlayerDebugView r100) {
        Intrinsics.checkNotNullParameter(r100, "ecDebugView");
        this.f187391e = r100;
        if (this.f187387a == false) goto L6;
        Surface r101 = this.f187390d;
        Intrinsics.checkNotNull(r101);
        r100.a(r101);
        return;
    }

    public final void setPlayer(ECVideoPlayer r100) {
        Intrinsics.checkNotNullParameter(r100, "videoPlayer");
        this.f187388b = r100;
        l r101 = this.f187392f;
        int r102 = r100.f187344h;
        int r103 = r100.f187345i;
        if (r101.f187419b == r103) goto L5;
    L6:
        r101.f187419b = r103;
        r101.f187418a = r102;
        r101.f187420c.requestLayout();
    L8:
        if (this.f187387a == false) goto L11;
        Surface r104 = this.f187390d;
        Intrinsics.checkNotNull(r104);
        r100.h(r104);
        return;
    L11:
        return;
    L5:
        if (r101.f187418a == r102) goto L8;
        goto L6
    }

    public final void setScaleType(int r100) {
        this.f187393g = r100;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r110) {
        l r101 = this.f187392f;
        int r102 = this.f187393g;
        r101.getClass();
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getSize(r110);
        float r105 = r101.f187418a / r101.f187419b;
        float r106 = r103;
        float r107 = r104;
        float r108 = r106 / r107;
        if (r102 == 1) goto L5;
        if (r102 == 0) goto L9;
    L12:
        Pair r109 = new Pair(Integer.valueOf(r103), Integer.valueOf(r104));
        if (((Number) r109.getFirst()).intValue() != 0) goto L15;
    L18:
        super.onMeasure(r100, r110);
        return;
    L15:
        if (((Number) r109.getSecond()).intValue() == 0) goto L18;
        setMeasuredDimension(((Number) r109.getFirst()).intValue(), ((Number) r109.getSecond()).intValue());
        return;
    L9:
        if (r105 <= r108) goto L11;
    L10:
        r104 = (int) (r106 / r105);
    L11:
        r103 = (int) (r107 * r105);
        goto L12
    L5:
        if (r105 <= r108) goto L10;
        goto L10
    }

    public TextureRender(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f187392f = new l(this);
        this.f187393g = 1;
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surfaceTexture");
        if (this.f187387a == true) goto L11;
        this.f187389c = r100;
        Surface r103 = new Surface(this.f187389c);
        this.f187390d = r103;
        this.f187387a = true;
        ECVideoPlayer r104 = this.f187388b;
        if (r104 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        r104.h(r103);
    L7:
        PlayerDebugView r105 = this.f187391e;
        if (r105 == null) goto L12;
        Surface r106 = this.f187390d;
        Intrinsics.checkNotNull(r106);
        r105.a(r106);
        return;
    L12:
        return;
    }

    public /* synthetic */ TextureRender(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
