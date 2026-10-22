package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CommonGuideMessage")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "messageType", "I", "getMessageType", "()I", "setMessageType", "(I)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "mainContent", "Lcom/bytedance/android/livesdkapi/message/Text;", "P", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setMainContent", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", "Lcom/bytedance/android/livesdk/message/model/k3$b;", "secondaryContents", "Ljava/util/List;", "Q", "()Ljava/util/List;", "setSecondaryContents", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "buttonContent", "G", "setButtonContent", "", "buttonActionSchema", "Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "setButtonActionSchema", "(Ljava/lang/String;)V", "buttonIcon", FaceService.neutralLabel, "setButtonIcon", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "", "isRound", "Z", ExifInterface.GPS_DIRECTION_TRUE, "()Z", "setRound", "(Z)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k3 extends o0 implements vh7.h {

    @SerializedName("button_action_schema")
    protected String buttonActionSchema;

    @SerializedName("button_content")
    protected Text buttonContent;

    @SerializedName("button_icon")
    protected ImageModel buttonIcon;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("icon")
    protected ImageModel icon;

    @IgnoreProtoFieldCheck
    @SerializedName("is_rounded_icon")
    protected boolean isRound;

    @SerializedName("main_content")
    protected Text mainContent;

    @SerializedName("message_type")
    protected int messageType;

    @SerializedName("secondary_content")
    protected List<b> secondaryContents;

    public static final class a {
    }

    @ProtoMessage("webcast.im.ComplexContent")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k3$b;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "text", "d", "setText", "fontColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setFontColor", "", "fontSize", "I", "b", "()I", "setFontSize", "(I)V", "weight", "getWeight", "setWeight", "Lcom/bytedance/android/live/base/model/ImageModel;", "img", "Lcom/bytedance/android/live/base/model/ImageModel;", "c", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setImg", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("font_color")
        protected String fontColor;

        @SerializedName("font_size")
        protected int fontSize;

        @SerializedName("img")
        protected ImageModel img;

        @SerializedName("text")
        protected String text;

        @SerializedName("type")
        protected String type;

        @SerializedName("weight")
        protected int weight;

        public static final class a {
        }

        static {
        }

        public b() {
        }

        public final String a() {
            return this.fontColor;
        }

        public final int b() {
            return this.fontSize;
        }

        public final ImageModel c() {
            return this.img;
        }

        public final String d() {
            return this.text;
        }

        public final String getType() {
            return this.type;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L13;
            switch(r102) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.img = com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L8:
            this.weight = (int) r100.j();
            goto L3
        L9:
            this.fontSize = (int) r100.j();
            goto L3
        L10:
            this.fontColor = am3.h.c(r100);
            goto L3
        L11:
            this.text = am3.h.c(r100);
            goto L3
        L12:
            this.type = am3.h.c(r100);
            goto L3
        L6:
            am3.h.e(r100);
            goto L3
        L13:
            r100.d(r101);
        }
    }

    static {
    }

    public k3() {
        this.type = MessageType.COMMON_GUIDE;
    }

    public final String E() {
        return this.buttonActionSchema;
    }

    public final Text G() {
        return this.buttonContent;
    }

    public final ImageModel H() {
        return this.buttonIcon;
    }

    public final Text P() {
        return this.mainContent;
    }

    public final List<b> Q() {
        return this.secondaryContents;
    }

    public final boolean T() {
        return this.isRound;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    public k3(am3.g r100) {
        this.secondaryContents = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.isRound = am3.h.a(r100);
        goto L3
    L8:
        this.duration = r100.j();
        goto L3
    L9:
        this.buttonIcon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        this.buttonActionSchema = am3.h.c(r100);
        goto L3
    L11:
        this.buttonContent = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        this.icon = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L13:
        this.secondaryContents.add(new b(r100));
        goto L3
    L14:
        this.mainContent = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L15:
        this.messageType = (int) r100.j();
        goto L3
    L16:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        this.type = MessageType.COMMON_GUIDE;
    }
}
