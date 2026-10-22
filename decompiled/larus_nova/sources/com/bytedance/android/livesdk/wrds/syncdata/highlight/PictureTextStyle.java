package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PictureTextStyle")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PictureTextStyle;", "", "()V", "picture", "Lcom/bytedance/android/live/base/model/ImageModel;", "getPicture", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setPicture", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", n.KEY_SUB_TEXT, "Lcom/bytedance/android/livesdkapi/message/Text;", "getSubText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setSubText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "text", "getText", "setText", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PictureTextStyle implements h {

    @SerializedName("picture")
    protected ImageModel picture;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("sub_text")
    protected Text subText;

    @SerializedName("text")
    protected Text text;

    public PictureTextStyle() {
    }

    public PictureTextStyle(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.text = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.subText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.picture = x.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.schema = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final ImageModel getPicture() {
        return this.picture;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Text getSubText() {
        return this.subText;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setPicture(ImageModel r100) {
        this.picture = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setSubText(Text r100) {
        this.subText = r100;
    }

    public final void setText(Text r100) {
        this.text = r100;
    }
}
