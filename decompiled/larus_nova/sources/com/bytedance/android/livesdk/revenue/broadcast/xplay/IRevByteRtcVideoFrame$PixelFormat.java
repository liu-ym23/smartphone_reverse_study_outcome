package com.bytedance.android.livesdk.revenue.broadcast.xplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"com/bytedance/android/livesdk/revenue/broadcast/xplay/IRevByteRtcVideoFrame$PixelFormat", "", "Lcom/bytedance/android/livesdk/revenue/broadcast/xplay/IRevByteRtcVideoFrame$PixelFormat;", "", "intValue", "I", "getIntValue", "()I", "", "stringValue", "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "UNKNOWN", "I420", "NV12", "NV21", "RGBA", "TEXTURE_2D", "TEXTURE_OES", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IRevByteRtcVideoFrame$PixelFormat extends Enum<IRevByteRtcVideoFrame$PixelFormat> {
    public static final IRevByteRtcVideoFrame$PixelFormat I420 = null;
    public static final IRevByteRtcVideoFrame$PixelFormat NV12 = null;
    public static final IRevByteRtcVideoFrame$PixelFormat NV21 = null;
    public static final IRevByteRtcVideoFrame$PixelFormat RGBA = null;
    public static final IRevByteRtcVideoFrame$PixelFormat TEXTURE_2D = null;
    public static final IRevByteRtcVideoFrame$PixelFormat TEXTURE_OES = null;
    public static final IRevByteRtcVideoFrame$PixelFormat UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IRevByteRtcVideoFrame$PixelFormat[] f157095a = null;
    private final int intValue;
    private final String stringValue;

    static {
        IRevByteRtcVideoFrame$PixelFormat r100 = new IRevByteRtcVideoFrame$PixelFormat("UNKNOWN", 0, 0, "kVideoPixelFormatUnknown");
        UNKNOWN = r100;
        IRevByteRtcVideoFrame$PixelFormat r101 = new IRevByteRtcVideoFrame$PixelFormat("I420", 1, 1, "kVideoPixelFormatI420");
        I420 = r101;
        IRevByteRtcVideoFrame$PixelFormat r102 = new IRevByteRtcVideoFrame$PixelFormat("NV12", 2, 2, "kVideoPixelFormatNV12");
        NV12 = r102;
        IRevByteRtcVideoFrame$PixelFormat r103 = new IRevByteRtcVideoFrame$PixelFormat("NV21", 3, 3, "kVideoPixelFormatNV21");
        NV21 = r103;
        IRevByteRtcVideoFrame$PixelFormat r104 = new IRevByteRtcVideoFrame$PixelFormat("RGBA", 4, 5, "kVideoPixelFormatRGBA");
        RGBA = r104;
        IRevByteRtcVideoFrame$PixelFormat r105 = new IRevByteRtcVideoFrame$PixelFormat("TEXTURE_2D", 5, 3553, "kVideoPixelFormatTexture2D");
        TEXTURE_2D = r105;
        IRevByteRtcVideoFrame$PixelFormat r106 = new IRevByteRtcVideoFrame$PixelFormat("TEXTURE_OES", 6, 36197, "kVideoPixelFormatTextureOES");
        TEXTURE_OES = r106;
        f157095a = new IRevByteRtcVideoFrame$PixelFormat[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static IRevByteRtcVideoFrame$PixelFormat valueOf(String r100) {
        return (IRevByteRtcVideoFrame$PixelFormat) a.a(IRevByteRtcVideoFrame$PixelFormat.class, r100);
    }

    public static IRevByteRtcVideoFrame$PixelFormat[] values() {
        return (IRevByteRtcVideoFrame$PixelFormat[]) f157095a.clone();
    }

    public final int getIntValue() {
        return this.intValue;
    }

    public final String getStringValue() {
        return this.stringValue;
    }

    public IRevByteRtcVideoFrame$PixelFormat(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.intValue = r102;
        this.stringValue = r103;
    }
}
