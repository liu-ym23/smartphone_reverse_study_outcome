package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InfoBoxMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/InfoBoxMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "scene", "Ljava/lang/Long;", "", "subScene", "Ljava/lang/String;", "action", "delay", "Lcom/bytedance/android/livesdkapi/message/Text;", "title", "Lcom/bytedance/android/livesdkapi/message/Text;", "foldTitle", "content", "dragType", "Lcom/bytedance/android/livesdk/message/model/lc;", "background", "Lcom/bytedance/android/livesdk/message/model/lc;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InfoBoxMessage extends o0 implements vh7.h {

    @SerializedName(SeiMessageConst.MSG_TYPE)
    public Long action;

    @SerializedName("background")
    public lc background;

    @SerializedName("content")
    public Text content;

    @SerializedName("delay")
    public Long delay;

    @SerializedName("drag_type")
    public Long dragType;

    @SerializedName("fold_title")
    public Text foldTitle;

    @SerializedName("scene")
    public Long scene;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    public String subScene;

    @SerializedName("title")
    public Text title;

    public InfoBoxMessage() {
        this.scene = 0L;
        this.subScene = "";
        this.action = 0L;
        this.delay = 0L;
        this.dragType = 0L;
        this.type = MessageType.INFO_BOX_MESSAGE;
    }

    public InfoBoxMessage(am3.g r100) {
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
        this.background = new lc(r100);
        goto L3
    L8:
        this.dragType = Long.valueOf(r100.j());
        goto L3
    L9:
        this.content = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        this.foldTitle = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L11:
        this.title = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        this.delay = Long.valueOf(r100.j());
        goto L3
    L13:
        this.action = Long.valueOf(r100.j());
        goto L3
    L14:
        this.subScene = am3.h.c(r100);
        goto L3
    L15:
        this.scene = Long.valueOf(r100.j());
        goto L3
    L16:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.scene != null) goto L21;
        this.scene = 0L;
    L21:
        if (this.subScene != null) goto L24;
        this.subScene = "";
    L24:
        if (this.action != null) goto L27;
        this.action = 0L;
    L27:
        if (this.delay != null) goto L30;
        this.delay = 0L;
    L30:
        if (this.dragType != null) goto L32;
        this.dragType = 0L;
    L32:
        this.type = MessageType.INFO_BOX_MESSAGE;
    }
}
