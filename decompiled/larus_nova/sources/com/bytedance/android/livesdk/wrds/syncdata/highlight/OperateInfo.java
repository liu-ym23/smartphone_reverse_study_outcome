package com.bytedance.android.livesdk.wrds.syncdata.highlight;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OperateInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/highlight/OperateInfo;", "", "()V", "_creator", "", "get_creator", "()Ljava/lang/Long;", "set_creator", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "_creatorOpenUid", "", "get_creatorOpenUid", "()Ljava/lang/String;", "creator", "getCreator", "creatorText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getCreatorText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setCreatorText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperateInfo implements h {

    @SerializedName("creator_uid")
    protected Long _creator;

    @SerializedName("creator_open_uid")
    protected String _creatorOpenUid;

    @SerializedName("creator_text")
    protected Text creatorText;

    public final String getCreator() {
        o0.a r100 = o0.f58946a;
        Long r101 = this._creator;
        String r102 = this._creatorOpenUid;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public OperateInfo() {
        this._creatorOpenUid = "";
    }

    public final Text getCreatorText() {
        return this.creatorText;
    }

    public final Long get_creator() {
        return this._creator;
    }

    public final String get_creatorOpenUid() {
        return this._creatorOpenUid;
    }

    public OperateInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.creatorText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._creator = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this._creatorOpenUid = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this._creatorOpenUid != null) goto L31;
        this._creatorOpenUid = "";
        return;
    }

    public final void setCreatorText(Text r100) {
        this.creatorText = r100;
    }

    public final void set_creator(Long r100) {
        this._creator = r100;
    }
}
