package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.ContentOpenTreasureDetail")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/zg;", "", "", "coinTaskType", "I", "", "contentNew", "Ljava/lang/String;", "contentReceive", "countDownKey", "", "countDown", "J", "contentNewSeconds", "", "contentReceiveRoll", "Ljava/util/List;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class zg implements vh7.h {

    @SerializedName("coin_task_type")
    public int coinTaskType;

    @SerializedName("content_new")
    public String contentNew;

    @SerializedName("content_new_seconds")
    public int contentNewSeconds;

    @SerializedName("content_receive")
    public String contentReceive;

    @SerializedName("content_receive_roll")
    public List<String> contentReceiveRoll;

    @SerializedName("count_down")
    public long countDown;

    @SerializedName("count_down_key")
    public String countDownKey;

    public zg() {
        this.contentNew = "";
        this.contentReceive = "";
        this.countDownKey = "";
    }

    public zg(am3.g r100) {
        this.contentReceiveRoll = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.contentReceiveRoll.add(am3.h.c(r100));
        goto L3
    L8:
        this.contentNewSeconds = r100.i();
        goto L3
    L9:
        this.countDown = r100.j();
        goto L3
    L10:
        this.countDownKey = am3.h.c(r100);
        goto L3
    L11:
        this.contentReceive = am3.h.c(r100);
        goto L3
    L12:
        this.contentNew = am3.h.c(r100);
        goto L3
    L13:
        this.coinTaskType = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.contentNew != null) goto L18;
        this.contentNew = "";
    L18:
        if (this.contentReceive != null) goto L21;
        this.contentReceive = "";
    L21:
        if (this.countDownKey != null) goto L42;
        this.countDownKey = "";
        return;
    }
}
