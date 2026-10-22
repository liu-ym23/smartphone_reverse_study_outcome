package com.mdisdk.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\tJ\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\tJ\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/mdisdk/gles/TextureInput;", "", "", "width", "height", AppAgent.CONSTRUCT, "(II)V", "LC7/r;", "setup", "()V", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "", "hasNewFrame", "()Z", "updateTexture", "draw", "release", "I", "Lcom/mdisdk/gles/TextureRender30;", "textureRender", "Lcom/mdisdk/gles/TextureRender30;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "surface", "Landroid/view/Surface;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextureInput {
    private static final String TAG = "TextureInput";
    private final AtomicBoolean hasNewFrame = new AtomicBoolean(false);
    private final int height;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private TextureRender30 textureRender;
    private final int width;

    public TextureInput(int i, int i6) {
        this.width = i;
        this.height = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setup$lambda$0(TextureInput textureInput, SurfaceTexture surfaceTexture) {
        textureInput.hasNewFrame.set(true);
    }

    public final void draw() {
        TextureRender30 textureRender30 = this.textureRender;
        if (textureRender30 != null) {
            textureRender30.drawFrame();
        }
    }

    public final Surface getSurface() {
        return this.surface;
    }

    public final boolean hasNewFrame() {
        return this.hasNewFrame.get();
    }

    public final void release() {
        TextureRender30 textureRender30 = this.textureRender;
        if (textureRender30 != null) {
            textureRender30.close();
        }
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
    }

    public final void setup() {
        TextureRender30 textureRender30 = new TextureRender30();
        this.textureRender = textureRender30;
        SurfaceTexture surfaceTextureCreateSurfaceTexture = textureRender30.createSurfaceTexture();
        this.surfaceTexture = surfaceTextureCreateSurfaceTexture;
        k.c(surfaceTextureCreateSurfaceTexture);
        surfaceTextureCreateSurfaceTexture.setDefaultBufferSize(this.width, this.height);
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        k.c(surfaceTexture);
        surfaceTexture.setOnFrameAvailableListener(new a(this, 0));
        this.surface = new Surface(this.surfaceTexture);
    }

    public final void updateTexture() {
        SurfaceTexture surfaceTexture;
        if (!this.hasNewFrame.compareAndSet(true, false) || (surfaceTexture = this.surfaceTexture) == null) {
            return;
        }
        surfaceTexture.updateTexImage();
    }
}
