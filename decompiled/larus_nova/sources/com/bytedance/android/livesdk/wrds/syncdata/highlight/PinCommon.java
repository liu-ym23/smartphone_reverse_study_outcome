package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PinCommon")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/PinCommon;", "", "()V", "operateInfo", "Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/OperateInfo;", "getOperateInfo", "()Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/OperateInfo;", "setOperateInfo", "(Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/OperateInfo;)V", "title", "Lcom/bytedance/android/livesdkapi/message/Text;", "getTitle", "()Lcom/bytedance/android/livesdkapi/message/Text;", d.f25925o, "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinCommon implements h {

    @SerializedName("operate_info")
    protected OperateInfo operateInfo;

    @SerializedName("top_title")
    protected Text title;

    public PinCommon() {
    }

    public PinCommon(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.operateInfo = new OperateInfo(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final OperateInfo getOperateInfo() {
        return this.operateInfo;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final void setOperateInfo(OperateInfo r100) {
        this.operateInfo = r100;
    }

    public final void setTitle(Text r100) {
        this.title = r100;
    }
}
