package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.ChorusAccompanimentInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/t;", "", "", "accompanimentType", "I", "getAccompanimentType", "()I", "setAccompanimentType", "(I)V", "Lcom/bytedance/android/livesdk/chatroom/model/u;", "chorusAccompanist", "Lcom/bytedance/android/livesdk/chatroom/model/u;", "getChorusAccompanist", "()Lcom/bytedance/android/livesdk/chatroom/model/u;", "setChorusAccompanist", "(Lcom/bytedance/android/livesdk/chatroom/model/u;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t implements vh7.h {

    @SerializedName("accompaniment_type")
    protected int accompanimentType;

    @SerializedName("chorus_accompanist")
    protected u chorusAccompanist;

    public t() {
        this.accompanimentType = AccompanimentMode.UNKNOWN.getValue();
    }

    public t(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.accompanimentType = r100.i();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.chorusAccompanist = new u(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & true) == true) goto L24;
        this.accompanimentType = AccompanimentMode.UNKNOWN.getValue();
        return;
    }
}
