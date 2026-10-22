package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.HighlightDataCommonPictureText")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\rR\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u0014\u0010&\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0006¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/HighlightDataCommonPictureText;", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/a;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "pinId", "J", "getPinId", "()J", "setPinId", "(J)V", "contentId", "getContentId", "setContentId", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "pictureTextStyle", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "getPictureTextStyle", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "setPictureTextStyle", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;)V", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "pinCommon", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "getPinCommon", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "setPinCommon", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;)V", "messageId", "getMessageId", "commentContent", "getCommentContent", "getUniqueKey", "uniqueKey", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightDataCommonPictureText extends a implements h {
    private final String commentContent;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    protected String contentId;
    private final long messageId;

    @SerializedName("picture_text_style")
    protected PictureTextStyle pictureTextStyle;

    @SerializedName("pin_common")
    protected PinCommon pinCommon;

    @SerializedName("pin_id")
    protected long pinId;

    @SerializedName("scene")
    protected String scene;

    public HighlightDataCommonPictureText() {
    }

    public String getUniqueKey() {
        return String.valueOf(this.pinId);
    }

    @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
    public String getCommentContent() {
        return this.commentContent;
    }

    public final String getContentId() {
        return this.contentId;
    }

    @Override // com.bytedance.android.livesdk.wrds.syncdata.highlight.b
    public long getMessageId() {
        return this.messageId;
    }

    public final PictureTextStyle getPictureTextStyle() {
        return this.pictureTextStyle;
    }

    public final PinCommon getPinCommon() {
        return this.pinCommon;
    }

    public final long getPinId() {
        return this.pinId;
    }

    public final String getScene() {
        return this.scene;
    }

    public HighlightDataCommonPictureText(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.scene = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.pinId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.contentId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 10) goto L14;
        this.pictureTextStyle = new PictureTextStyle(r100);
        goto L3
    L14:
        if (r102 != 255) goto L15;
        this.pinCommon = new PinCommon(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setContentId(String r100) {
        this.contentId = r100;
    }

    public final void setPictureTextStyle(PictureTextStyle r100) {
        this.pictureTextStyle = r100;
    }

    public final void setPinCommon(PinCommon r100) {
        this.pinCommon = r100;
    }

    public final void setPinId(long r100) {
        this.pinId = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }
}
