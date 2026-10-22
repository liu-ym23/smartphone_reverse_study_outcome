package com.alibaba.gaiax.render.view.basic.richtext;

import androidx.camera.video.AudioStats;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBq\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/ImageInfo;", "", "url", "", "start", "", "width", "", "height", "align", "offset", "left_offset", "right_offset", "corner_radius", "(Ljava/lang/String;ILjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getAlign", "()Ljava/lang/String;", "getCorner_radius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeight", "getLeft_offset", "getOffset", "getRight_offset", "getStart", "()I", "setStart", "(I)V", "getUrl", "getWidth", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageInfo {
    public static final Companion Companion = null;
    private final String align;
    private final Float corner_radius;
    private final Float height;
    private final Float left_offset;
    private final Float offset;
    private final Float right_offset;
    private int start;
    private final String url;
    private final Float width;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/richtext/ImageInfo$Companion;", "", "()V", "createByExtend", "Lcom/alibaba/gaiax/render/view/basic/richtext/ImageInfo;", "textModel", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ImageInfo createByExtend(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "textModel");
            String r100 = r110.optString("url", null);
            int r101 = r110.optInt("start", 0);
            if (r101 >= 0) goto L5;
            int r102 = 0;
        L7:
            return new ImageInfo(r100, r102, Float.valueOf((float) r110.optDouble("width", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("height", AudioStats.AUDIO_AMPLITUDE_NONE)), r110.optString("align", null), Float.valueOf((float) r110.optDouble("offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("left_offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("right_offset", AudioStats.AUDIO_AMPLITUDE_NONE)), Float.valueOf((float) r110.optDouble("corner_radius", AudioStats.AUDIO_AMPLITUDE_NONE)));
        L5:
            r102 = r101;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ImageInfo() {
        this(null, 0, null, null, null, null, null, null, null, 511, null);
    }

    public ImageInfo(String r110) {
        this(r110, 0, null, null, null, null, null, null, null, 510, null);
    }

    public ImageInfo(String r110, int r111) {
        this(r110, r111, null, null, null, null, null, null, null, 508, null);
    }

    public ImageInfo(String r110, int r111, Float r112) {
        this(r110, r111, r112, null, null, null, null, null, null, 504, null);
    }

    public ImageInfo(String r110, int r111, Float r112, Float r113) {
        this(r110, r111, r112, r113, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT, null);
    }

    public ImageInfo(String r110, int r111, Float r112, Float r113, String r114) {
        this(r110, r111, r112, r113, r114, null, null, null, null, 480, null);
    }

    public ImageInfo(String r110, int r111, Float r112, Float r113, String r114, Float r115) {
        this(r110, r111, r112, r113, r114, r115, null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    }

    public ImageInfo(String r110, int r111, Float r112, Float r113, String r114, Float r115, Float r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null, null, 384, null);
    }

    public ImageInfo(String r110, int r111, Float r112, Float r113, String r114, Float r115, Float r116, Float r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, null, 256, null);
    }

    public final String getAlign() {
        return this.align;
    }

    public final Float getCorner_radius() {
        return this.corner_radius;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getLeft_offset() {
        return this.left_offset;
    }

    public final Float getOffset() {
        return this.offset;
    }

    public final Float getRight_offset() {
        return this.right_offset;
    }

    public final int getStart() {
        return this.start;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setStart(int r100) {
        this.start = r100;
    }

    public ImageInfo(String r100, int r101, Float r102, Float r103, String r104, Float r105, Float r106, Float r107, Float r108) {
        this.url = r100;
        this.start = r101;
        this.width = r102;
        this.height = r103;
        this.align = r104;
        this.offset = r105;
        this.left_offset = r106;
        this.right_offset = r107;
        this.corner_radius = r108;
    }

    public /* synthetic */ ImageInfo(String r110, int r111, Float r112, Float r113, String r114, Float r115, Float r116, Float r117, Float r118, int r210, DefaultConstructorMarker r211) {
        String r100 = "";
        if ((r210 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Float r103 = Float.valueOf(0.0f);
    L15:
        if ((r210 & 8) == 0) goto L17;
        Float r104 = Float.valueOf(0.0f);
    L19:
        if ((r210 & 16) != 0) goto L23;
        r100 = r114;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Float r105 = Float.valueOf(0.0f);
    L27:
        if ((r210 & 64) == 0) goto L29;
        Float r106 = Float.valueOf(0.0f);
    L31:
        if ((r210 & 128) == 0) goto L33;
        Float r107 = Float.valueOf(0.0f);
    L35:
        if ((r210 & 256) == 0) goto L37;
        Float r108 = Float.valueOf(0.0f);
    L38:
        this(r101, r102, r103, r104, r100, r105, r106, r107, r108);
        return;
    L37:
        r108 = r118;
        goto L38
    L33:
        r107 = r117;
        goto L35
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
