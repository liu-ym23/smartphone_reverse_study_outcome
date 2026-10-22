package com.mdisdk.gles;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/mdisdk/gles/TextureRender30;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "drawFrame", "Landroid/graphics/SurfaceTexture;", "createSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "close", "", "program", "I", "textureId", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextureRender30 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float[] TEXCOORDS;
    private static final FloatBuffer TEXCOORD_BUF;
    private static final FloatBuffer VERTEX_BUF;
    private static final float[] VERTICES;
    private final int program;
    private final int textureId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mdisdk/gles/TextureRender30$Companion;", "", AppAgent.CONSTRUCT, "()V", "VERTICES", "", "TEXCOORDS", "VERTEX_BUF", "Ljava/nio/FloatBuffer;", "TEXCOORD_BUF", "createExternalTexture", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int createExternalTexture() {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10241, 9729);
            GLES20.glTexParameteri(36197, 10240, 9729);
            return iArr[0];
        }

        private Companion() {
        }
    }

    static {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        VERTICES = fArr;
        float[] fArr2 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        TEXCOORDS = fArr2;
        GL30Tools gL30Tools = GL30Tools.INSTANCE;
        VERTEX_BUF = gL30Tools.createFloatBuffer(fArr);
        TEXCOORD_BUF = gL30Tools.createFloatBuffer(fArr2);
    }

    public TextureRender30() {
        GL30Tools gL30Tools = GL30Tools.INSTANCE;
        this.program = gL30Tools.linkProgram(gL30Tools.loadShader(35633, "#version 300 es\nlayout(location = 0) in vec3 aPosition;\nlayout(location = 1) in vec2 aTexCoord;\nout vec2 vTexCoord;\nvoid main() {\n    gl_Position = vec4(aPosition, 1.0);\n    vTexCoord = aTexCoord;\n}"), gL30Tools.loadShader(35632, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nin vec2 vTexCoord;\nout vec4 fragColor;\nuniform samplerExternalOES uTexture;\nvoid main() {\n    fragColor = texture(uTexture, vTexCoord);\n}"));
        this.textureId = INSTANCE.createExternalTexture();
    }

    public final void close() {
        GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
        GLES20.glDeleteProgram(this.program);
    }

    public final SurfaceTexture createSurfaceTexture() {
        return new SurfaceTexture(this.textureId);
    }

    public final void drawFrame() {
        GLES20.glUseProgram(this.program);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.textureId);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.program, "uTexture"), 0);
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, (Buffer) VERTEX_BUF);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) TEXCOORD_BUF);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(0);
        GLES20.glDisableVertexAttribArray(1);
        GLES20.glUseProgram(0);
    }
}
