package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ExhibitionTopLeftMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/j4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/message/Text;", "displayText", "Lcom/bytedance/android/livesdkapi/message/Text;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", "topTitle", "Ljava/lang/String;", "P", "()Ljava/lang/String;", "setTopTitle", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "giftIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", FaceService.neutralLabel, "()Lcom/bytedance/android/live/base/model/ImageModel;", "setGiftIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "exhibitionUrl", "G", "setExhibitionUrl", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j4 extends o0 implements vh7.h {

    @SerializedName("display_text")
    protected Text displayText;

    @SerializedName("exhibition_entrance_url")
    protected String exhibitionUrl;

    @SerializedName("gift_icon")
    protected ImageModel giftIcon;

    @SerializedName("top_title")
    protected String topTitle;

    public j4() {
        this.type = MessageType.EXHIBITION_TOP_LEFT;
    }

    public final Text E() {
        return this.displayText;
    }

    public final String G() {
        return this.exhibitionUrl;
    }

    public final ImageModel H() {
        return this.giftIcon;
    }

    public final String P() {
        return this.topTitle;
    }

    public j4(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.displayText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.topTitle = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.giftIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.exhibitionUrl = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.EXHIBITION_TOP_LEFT;
    }
}
