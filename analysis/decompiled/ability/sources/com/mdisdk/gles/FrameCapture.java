package com.mdisdk.gles;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/mdisdk/gles/FrameCapture;", "", "", "width", "height", AppAgent.CONSTRUCT, "(II)V", "Ljava/nio/ByteBuffer;", "buffer", "Landroid/graphics/Bitmap;", "createBitmapFromBuffer", "(Ljava/nio/ByteBuffer;)Landroid/graphics/Bitmap;", "LC7/r;", "setup", "()V", "Lkotlin/Function0;", "drawCallback", "capture", "(LS7/a;)Landroid/graphics/Bitmap;", "release", "I", "", "fbo", "[I", "fboTexture", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FrameCapture {
    private final int[] fbo = new int[1];
    private final int[] fboTexture = new int[1];
    private final int height;
    private final int width;

    public FrameCapture(int i, int i6) {
        this.width = i;
        this.height = i6;
    }

    private final Bitmap createBitmapFromBuffer(ByteBuffer buffer) {
        buffer.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        k.e(bitmapCreateBitmap, "createBitmap(...)");
        bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, this.width, this.height, matrix, false);
        k.e(bitmapCreateBitmap2, "createBitmap(...)");
        return bitmapCreateBitmap2;
    }

    public final Bitmap capture(S7.a drawCallback) {
        k.f(drawCallback, "drawCallback");
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        drawCallback.invoke();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.width * this.height * 4);
        GLES20.glReadPixels(0, 0, this.width, this.height, 6408, 5121, byteBufferAllocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        k.c(byteBufferAllocateDirect);
        return createBitmapFromBuffer(byteBufferAllocateDirect);
    }

    public final void release() {
        int[] iArr = this.fbo;
        if (iArr[0] != 0) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
        }
        int[] iArr2 = this.fboTexture;
        if (iArr2[0] != 0) {
            GLES20.glDeleteTextures(1, iArr2, 0);
        }
    }

    public final void setup() {
        GLES20.glGenTextures(1, this.fboTexture, 0);
        GLES20.glBindTexture(3553, this.fboTexture[0]);
        GLES20.glTexImage2D(3553, 0, 6408, this.width, this.height, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glGenFramebuffers(1, this.fbo, 0);
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.fboTexture[0], 0);
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus == 36053) {
            GLES20.glBindFramebuffer(36160, 0);
        } else {
            throw new RuntimeException("FBO not complete: 0x" + Integer.toHexString(iGlCheckFramebufferStatus));
        }
    }
}
