package com.bytedance.android.livesdk.interactivity.api.asr.model;

import am3.g;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.interaction.AnchorAudioResponse.ResponseData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/asr/model/a;", "", "Lcom/bytedance/android/livesdkapi/message/Text;", "text", "Lcom/bytedance/android/livesdkapi/message/Text;", "", "rtfContent", "Ljava/lang/String;", "content", "", "textType", "I", "", "isToAll", "Z", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("content")
    public String content;

    @SerializedName("is_to_all")
    public boolean isToAll;

    @SerializedName("rtf_content")
    public String rtfContent;

    @SerializedName("text")
    public Text text;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE)
    public int textType;

    public a() {
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.text = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.textType = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.content = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.rtfContent = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.isToAll = am3.h.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
