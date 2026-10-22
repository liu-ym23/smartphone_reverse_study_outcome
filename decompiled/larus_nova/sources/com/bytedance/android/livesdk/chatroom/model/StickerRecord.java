package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.gamelive.StickerRecord")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/StickerRecord;", "", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerRecord implements vh7.h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("record_id")
    protected String f106908id;

    @SerializedName("sticker_type")
    protected int type;

    public StickerRecord() {
        this.f106908id = "";
    }

    public final String getId() {
        return this.f106908id;
    }

    public final int getType() {
        return this.type;
    }

    public StickerRecord(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.type = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.f106908id = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.f106908id != null) goto L25;
        this.f106908id = "";
        return;
    }

    public final void setId(String r100) {
        this.f106908id = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
