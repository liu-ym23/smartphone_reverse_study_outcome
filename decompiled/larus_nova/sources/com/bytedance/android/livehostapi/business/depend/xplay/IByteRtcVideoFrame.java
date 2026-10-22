package com.bytedance.android.livehostapi.business.depend.xplay;

import android.opengl.EGLContext;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001.J\u0012\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020\u0013H&J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H&J\b\u0010+\u001a\u00020,H&J\b\u0010-\u001a\u00020,H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0012\u0010\u0018\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0012\u0010\u001c\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0015¨\u0006/À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IByteRtcVideoFrame;", "", "SEIInfo", "", "getSEIInfo", "()Ljava/lang/String;", "colorSpace", "getColorSpace", "delayCalculationInfo", "getDelayCalculationInfo", "eglContext", "Landroid/opengl/EGLContext;", "getEglContext", "()Landroid/opengl/EGLContext;", "externalDataInfo", "Ljava/nio/ByteBuffer;", "getExternalDataInfo", "()Ljava/nio/ByteBuffer;", "height", "", "getHeight", "()I", "i420ByteBuffer", "getI420ByteBuffer", "pixelFormat", "getPixelFormat", "rotation", "getRotation", "textureId", "getTextureId", "textureMatrix", "", "getTextureMatrix", "()[F", "timestampUs", "", "getTimestampUs", "()J", "width", "getWidth", "getPlaneData", "planeIndex", "getPlaneStride", "release", "", "retain", "PixelFormat", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IByteRtcVideoFrame {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IByteRtcVideoFrame$PixelFormat;", "", "intValue", "", "stringValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getIntValue", "()I", "getStringValue", "()Ljava/lang/String;", "UNKNOWN", "I420", "NV12", "NV21", "RGBA", "TEXTURE_2D", "TEXTURE_OES", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PixelFormat extends Enum<PixelFormat> {
        private static final /* synthetic */ PixelFormat[] $VALUES = null;
        public static final PixelFormat I420 = null;
        public static final PixelFormat NV12 = null;
        public static final PixelFormat NV21 = null;
        public static final PixelFormat RGBA = null;
        public static final PixelFormat TEXTURE_2D = null;
        public static final PixelFormat TEXTURE_OES = null;
        public static final PixelFormat UNKNOWN = null;
        private final int intValue;
        private final String stringValue;

        static {
            PixelFormat r100 = new PixelFormat("UNKNOWN", 0, 0, "kVideoPixelFormatUnknown");
            UNKNOWN = r100;
            PixelFormat r101 = new PixelFormat("I420", 1, 1, "kVideoPixelFormatI420");
            I420 = r101;
            PixelFormat r102 = new PixelFormat("NV12", 2, 2, "kVideoPixelFormatNV12");
            NV12 = r102;
            PixelFormat r103 = new PixelFormat("NV21", 3, 3, "kVideoPixelFormatNV21");
            NV21 = r103;
            PixelFormat r104 = new PixelFormat("RGBA", 4, 5, "kVideoPixelFormatRGBA");
            RGBA = r104;
            PixelFormat r105 = new PixelFormat("TEXTURE_2D", 5, 3553, "kVideoPixelFormatTexture2D");
            TEXTURE_2D = r105;
            PixelFormat r106 = new PixelFormat("TEXTURE_OES", 6, 36197, "kVideoPixelFormatTextureOES");
            TEXTURE_OES = r106;
            $VALUES = new PixelFormat[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static PixelFormat valueOf(String r100) {
            return (PixelFormat) a.a(PixelFormat.class, r100);
        }

        public static PixelFormat[] values() {
            return (PixelFormat[]) $VALUES.clone();
        }

        public final int getIntValue() {
            return this.intValue;
        }

        public final String getStringValue() {
            return this.stringValue;
        }

        private PixelFormat(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.intValue = r102;
            this.stringValue = r103;
        }
    }

    String getColorSpace();

    String getDelayCalculationInfo();

    EGLContext getEglContext();

    ByteBuffer getExternalDataInfo();

    int getHeight();

    ByteBuffer getI420ByteBuffer();

    String getPixelFormat();

    ByteBuffer getPlaneData(int r100);

    int getPlaneStride(int r100);

    int getRotation();

    String getSEIInfo();

    int getTextureId();

    float[] getTextureMatrix();

    long getTimestampUs();

    int getWidth();

    void release();

    void retain();
}
