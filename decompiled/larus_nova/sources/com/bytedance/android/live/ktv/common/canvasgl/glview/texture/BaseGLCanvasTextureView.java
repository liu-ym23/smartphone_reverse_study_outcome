package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;
import android.util.AttributeSet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fb0.e;

/* JADX INFO: loaded from: classes45.dex */
abstract class BaseGLCanvasTextureView extends BaseGLTextureView implements c, lb0.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public eb0.b f69464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f69465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f69466j;

    public abstract void h(eb0.c r100);

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void a() {
        this.f69464h = new eb0.b();
        this.f69466j = ThreadMethodProxy.currentThread().getId();
        gb0.a.d();
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void b() {
        gb0.a r100 = gb0.a.c();
        if (this.f69465i == false) goto L6;
        if (r100 == null) goto L6;
        requestRender();
        gb0.a.b r101 = r100.f480651e;
        long r102 = r100.f480647a;
        r101.postDelayed(new gb0.a.c(r101, this, r102), r102);
        this.f69465i = false;
    L6:
        eb0.b r103 = this.f69464h;
        r103.f471786d[1] = Color.red(0) / 255.0f;
        r103.f471786d[2] = Color.green(0) / 255.0f;
        r103.f471786d[3] = Color.blue(0) / 255.0f;
        r103.f471786d[0] = Color.alpha(0) / 255.0f;
        fb0.c r104 = r103.f471784b;
        float[] r105 = r103.f471786d;
        ((e) r104).getClass();
        GLES20.glClearColor(r105[1], r105[2], r105[3], r105[0]);
        GLES20.glClear(16384);
        h(this.f69464h);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void e() {
        super.e();
        setOpaque(false);
        setRenderer(this);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        long r100 = this.f69466j;
        gb0.a r101 = gb0.a.f480645k.get(Long.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = gb0.a.f480646l.get(Long.valueOf(r100));
    L5:
        if (r101 == null) goto L7;
        r101.e();
    L7:
        this.f69465i = true;
    }

    public BaseGLCanvasTextureView(Context r100) {
        super(r100);
        this.f69465i = true;
    }

    public BaseGLCanvasTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f69465i = true;
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.c
    public final void onSurfaceChanged(int r100, int r101) {
        eb0.b r102 = this.f69464h;
        r102.f471787e = r100;
        r102.f471788f = r101;
        ((e) r102.f471784b).c(r100, r101);
    }

    public BaseGLCanvasTextureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f69465i = true;
    }
}
