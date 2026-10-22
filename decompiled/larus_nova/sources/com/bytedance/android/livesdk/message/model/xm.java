package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs._BusinessConfigure_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.VsBusinessConfigureMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/xm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessConfigure;", "businessConfigure", "Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessConfigure;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessConfigure;", "setBusinessConfigure", "(Lcom/bytedance/android/livesdkapi/depend/model/live/vs/BusinessConfigure;)V", "", "allInfo", "Z", "getAllInfo", "()Z", "setAllInfo", "(Z)V", "", "scatterTime", "J", "getScatterTime", "()J", "setScatterTime", "(J)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xm extends o0 implements vh7.h {

    @SerializedName("all_info")
    protected boolean allInfo;

    @SerializedName("business_configure")
    protected BusinessConfigure businessConfigure;

    @SerializedName("scatter_time")
    protected long scatterTime;

    public xm() {
        this.type = MessageType.VS_BUSINESS_CONFIGURE_MESSAGE;
    }

    public final BusinessConfigure E() {
        return this.businessConfigure;
    }

    public xm(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.businessConfigure = _BusinessConfigure_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.allInfo = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.scatterTime = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.VS_BUSINESS_CONFIGURE_MESSAGE;
    }
}
