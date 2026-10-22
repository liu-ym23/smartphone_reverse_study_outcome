package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wh;", "", "", "", "roomIds", "Ljava/util/List;", "getRoomIds", "()Ljava/util/List;", "setRoomIds", "(Ljava/util/List;)V", "", "remarkName", "getRemarkName", "setRemarkName", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class wh implements vh7.h {

    @SerializedName("room_ids_str")
    protected List<String> remarkName;

    @SerializedName("room_ids")
    protected List<Long> roomIds;

    public wh() {
        this.roomIds = new ArrayList();
        this.remarkName = new ArrayList();
    }

    public wh(am3.g r100) {
        this.roomIds = new ArrayList();
        this.remarkName = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        List r103 = this.remarkName;
        Comparable r104 = am3.h.c(r100);
    L12:
        r103.add(r104);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L11:
        r103 = this.roomIds;
        r104 = Long.valueOf(r100.j());
        goto L12
    L13:
        r100.d(r101);
        if (this.roomIds.isEmpty() == false) goto L17;
        this.roomIds = new ArrayList();
    L17:
        if (this.remarkName.isEmpty() == false) goto L27;
        this.remarkName = new ArrayList();
        return;
    }
}
