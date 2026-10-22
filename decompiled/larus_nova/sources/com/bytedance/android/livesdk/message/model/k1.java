package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k1;", "", "", "type", "Ljava/lang/Integer;", "priority", "Lcom/bytedance/android/livesdk/message/model/l1;", "cardDisplayInfo", "Lcom/bytedance/android/livesdk/message/model/l1;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class k1 implements vh7.h {

    @SerializedName("biz_area_display_info")
    public l1 cardDisplayInfo;

    @SerializedName("priority")
    public Integer priority;

    @SerializedName("type")
    public Integer type;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("BizPinArea(type=");
        r100.append(this.type);
        r100.append(", priority=");
        r100.append(this.priority);
        r100.append(", content=");
        l1 r101 = this.cardDisplayInfo;
        if (r101 == null) goto L5;
        String r102 = r101.containerPayload;
    L6:
        r100.append(String.valueOf(r102));
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public k1() {
        this.type = 0;
    }

    public k1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.type = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.priority = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.cardDisplayInfo = new l1(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.type != null) goto L31;
        this.type = 0;
        return;
    }
}
