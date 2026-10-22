package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CommonToastMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\"\u0010-\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u0010\u0012R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/n3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "discardable", "Z", "getDiscardable", "()Z", "setDiscardable", "(Z)V", "immediate", "Q", "setImmediate", "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "", "backgroundColorStart", "Ljava/lang/String;", "G", "()Ljava/lang/String;", "d0", "(Ljava/lang/String;)V", "backgroundColorEnd", ExifInterface.LONGITUDE_EAST, "X", "textColor", "getTextColor", "setTextColor", "position", "getPosition", "setPosition", "Lcom/bytedance/android/live/base/model/ImageModel;", "topImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "V", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setTopImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "imageWidth", "P", "setImageWidth", "imageHeight", FaceService.neutralLabel, "setImageHeight", "showMongoliaLayer", ExifInterface.GPS_DIRECTION_TRUE, "setShowMongoliaLayer", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n3 extends o0 implements vh7.h {

    @SerializedName("background_color_end")
    protected String backgroundColorEnd;

    @SerializedName("background_color_start")
    protected String backgroundColorStart;

    @SerializedName("discardable")
    protected boolean discardable;

    @SerializedName("duration")
    protected int duration;

    @SerializedName("top_img_height")
    protected int imageHeight;

    @SerializedName("top_img_width")
    protected int imageWidth;

    @SerializedName("immediate")
    protected boolean immediate;

    @SerializedName("position")
    protected int position;

    @SerializedName("show_mongolia_layer")
    protected boolean showMongoliaLayer;

    @SerializedName("text_color")
    protected String textColor;

    @SerializedName("top_img")
    protected ImageModel topImage;

    public static final class a {
    }

    static {
    }

    public final void X() {
        Intrinsics.checkNotNullParameter("#ff5c67", "<set-?>");
        this.backgroundColorEnd = "#ff5c67";
    }

    public final void d0() {
        Intrinsics.checkNotNullParameter("#ff9d5c", "<set-?>");
        this.backgroundColorStart = "#ff9d5c";
    }

    public n3() {
        this.backgroundColorStart = "#ff9d5c";
        this.backgroundColorEnd = "#ff9d5c";
        this.textColor = "#ffffff";
        this.position = 1;
        this.type = MessageType.COMMON_TOAST;
    }

    public final String E() {
        return this.backgroundColorEnd;
    }

    public final String G() {
        return this.backgroundColorStart;
    }

    public final int H() {
        return this.imageHeight;
    }

    public final int P() {
        return this.imageWidth;
    }

    public final boolean Q() {
        return this.immediate;
    }

    public final boolean T() {
        return this.showMongoliaLayer;
    }

    public final ImageModel V() {
        return this.topImage;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public n3(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L19;
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.showMongoliaLayer = am3.h.a(r100);
        goto L3
    L8:
        this.imageHeight = (int) r100.j();
        goto L3
    L9:
        this.imageWidth = (int) r100.j();
        goto L3
    L10:
        this.topImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L11:
        this.position = (int) r100.j();
        r102 = r102 | true;
        goto L3
    L12:
        this.backgroundColorEnd = am3.h.c(r100);
        goto L3
    L13:
        this.backgroundColorStart = am3.h.c(r100);
        goto L3
    L14:
        this.textColor = am3.h.c(r100);
        goto L3
    L15:
        this.duration = (int) r100.j();
        goto L3
    L16:
        this.immediate = am3.h.a(r100);
        goto L3
    L17:
        this.discardable = am3.h.a(r100);
        goto L3
    L18:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
        if (this.backgroundColorStart != null) goto L23;
        this.backgroundColorStart = "#ff9d5c";
    L23:
        if (this.backgroundColorEnd != null) goto L26;
        this.backgroundColorEnd = "#ff9d5c";
    L26:
        if (this.textColor != null) goto L29;
        this.textColor = "#ffffff";
    L29:
        if ((r102 & true) == true) goto L31;
        this.position = 1;
    L31:
        this.type = MessageType.COMMON_TOAST;
    }

    public final void setTextColor(String r100) {
        Intrinsics.checkNotNullParameter("#ffffff", "<set-?>");
        this.textColor = "#ffffff";
    }
}
