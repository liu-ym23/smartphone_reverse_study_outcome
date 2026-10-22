package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UploadCoverMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_msgType", "J", "get_msgType", "()J", "set_msgType", "(J)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "_title", "Lcom/bytedance/android/livesdkapi/message/Text;", "get_title", "()Lcom/bytedance/android/livesdkapi/message/Text;", "set_title", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "_content", "get_content", "set_content", "_tipsTitle", "get_tipsTitle", "set_tipsTitle", "", "_tipsUrl", "Ljava/lang/String;", "get_tipsUrl", "()Ljava/lang/String;", "set_tipsUrl", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sk extends o0 implements vh7.h {

    @SerializedName("content")
    protected Text _content;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    protected long _msgType;

    @SerializedName("tips_title")
    protected Text _tipsTitle;

    @SerializedName("tips_url")
    protected String _tipsUrl;

    @SerializedName("title")
    protected Text _title;

    public static final class a {
    }

    static {
    }

    public sk() {
        this.type = MessageType.COVER_MESSAGE;
    }

    public final Text E() {
        return this._content;
    }

    public final Text G() {
        return this._tipsTitle;
    }

    public final String H() {
        return this._tipsUrl;
    }

    public final Text P() {
        return this._title;
    }

    public sk(am3.g r100) {
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
        this._tipsUrl = am3.h.c(r100);
        goto L3
    L8:
        this._tipsTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L9:
        this._content = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        this._title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L11:
        this._msgType = r100.j();
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.COVER_MESSAGE;
    }
}
