package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlphaVideoGLTextureView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender$SurfaceListener;", "onSurfaceDestroyed", "", "onSurfacePrepared", "surface", "Landroid/view/Surface;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView$mSurfaceListener$1 implements IRender.SurfaceListener {
    final /* synthetic */ AlphaVideoGLTextureView this$0;

    AlphaVideoGLTextureView$mSurfaceListener$1(AlphaVideoGLTextureView r1) {
        this.this$0 = r1;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
    public void onSurfacePrepared(Surface r3) {
        Intrinsics.checkNotNullParameter(r3, "surface");
        Surface r0 = this.this$0.getMSurface();
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.this$0.setMSurface(r3);
        AlphaVideoGLTextureView.access$setSurfaceCreated$p(this.this$0, true);
        IPlayerControllerExt r1 = this.this$0.getMPlayerController();
        if (r1 == null) goto L8;
        r1.surfacePrepared(r3);
    L8:
        IPlayerControllerExt r2 = this.this$0.getMPlayerController();
        if (r2 == null) goto L12;
        r2.resume();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
    public void onSurfaceDestroyed() {
        Surface r0 = this.this$0.getMSurface();
        if (r0 == null) goto L5;
        r0.release();
    L5:
        Surface r2 = (Surface) null;
        this.this$0.setMSurface(null);
        AlphaVideoGLTextureView.access$setSurfaceCreated$p(this.this$0, false);
    }
}
