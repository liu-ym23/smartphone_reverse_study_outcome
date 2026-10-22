package com.bytedance.android.live.ktv.common.canvasgl.glview;

import android.content.Context;
import android.util.AttributeSet;
import eb0.c;

/* JADX INFO: loaded from: classes45.dex */
public abstract class GLContinuousView extends GLView {
    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView
    public abstract void onGLDraw(c r100);

    @Override // com.bytedance.android.live.ktv.common.canvasgl.glview.GLView
    public void init() {
        super.init();
        setRenderMode(0);
    }

    public GLContinuousView(Context r100) {
        super(r100);
    }

    public GLContinuousView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
