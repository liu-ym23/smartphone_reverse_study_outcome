package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ProfileViewMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0000¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ii;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/message/Text;", "title", "Lcom/bytedance/android/livesdkapi/message/Text;", "G", "()Lcom/bytedance/android/livesdkapi/message/Text;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "subTitle", ExifInterface.LONGITUDE_EAST, "setSubTitle", "", "duration", "Ljava/lang/Long;", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "", "source", "I", "getSource", "()I", "setSource", "(I)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ii extends o0 implements vh7.h {

    @SerializedName("show_duration")
    protected Long duration;

    @SerializedName("source")
    protected int source;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected Text subTitle;

    @SerializedName("title")
    protected Text title;

    public static final class a {
    }

    static {
    }

    public ii() {
        setType(MessageType.PROFILE_VIEW_MESSAGE);
    }

    public final Text E() {
        return this.subTitle;
    }

    public final Text G() {
        return this.title;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getSource() {
        return this.source;
    }

    public ii(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.subTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.duration = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.source = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        setType(MessageType.PROFILE_VIEW_MESSAGE);
    }
}
