package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GradeBuffAnchorShareMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s5;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "schemeUrl", "Ljava/lang/String;", "getSchemeUrl", "()Ljava/lang/String;", "setSchemeUrl", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "content", "Lcom/bytedance/android/livesdkapi/message/Text;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/livesdkapi/message/Text;", "setContent", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "I", "getScore", "()I", "setScore", "(I)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s5 extends o0 implements vh7.h {

    @SerializedName("content")
    protected Text content;

    @SerializedName("scheme_url")
    protected String schemeUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected int score;

    public s5() {
        setType(MessageType.GRADE_BUFF_ANCHOR_SHARE_MESSAGE);
    }

    public final Text E() {
        return this.content;
    }

    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    public final int getScore() {
        return this.score;
    }

    public s5(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.schemeUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.content = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.score = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        setType(MessageType.GRADE_BUFF_ANCHOR_SHARE_MESSAGE);
    }
}
