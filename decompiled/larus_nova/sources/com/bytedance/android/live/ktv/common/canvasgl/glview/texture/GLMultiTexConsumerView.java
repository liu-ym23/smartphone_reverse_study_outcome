package com.bytedance.android.live.ktv.common.canvasgl.glview.texture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public abstract class GLMultiTexConsumerView extends BaseGLCanvasTextureView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f69475k;

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void c() {
    }

    public abstract void i();

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public final void f() {
        super.f();
        ((ArrayList) this.f69475k).clear();
    }

    public GLMultiTexConsumerView(Context r100) {
        super(r100);
        this.f69475k = new ArrayList();
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLCanvasTextureView
    public final void h(eb0.c r100) {
        Iterator r101 = ((ArrayList) this.f69475k).iterator();
        if (r101.hasNext() == true) goto L6;
        i();
        return;
    L6:
        ((b) r101.next()).getClass();
        throw null;
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView
    public /* bridge */ /* synthetic */ void setRenderer(c r100) {
        super.setRenderer(r100);
    }

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.texture.BaseGLTextureView, android.view.TextureView
    public /* bridge */ /* synthetic */ void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        super.setSurfaceTextureListener(r100);
    }

    public GLMultiTexConsumerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f69475k = new ArrayList();
    }

    public GLMultiTexConsumerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f69475k = new ArrayList();
    }
}
