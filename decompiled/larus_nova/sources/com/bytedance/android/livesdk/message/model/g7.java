package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/g7;", "", "Lcom/bytedance/android/livesdk/message/model/dc;", "fromUser", "Lcom/bytedance/android/livesdk/message/model/dc;", "getFromUser", "()Lcom/bytedance/android/livesdk/message/model/dc;", "", "toUsers", "Ljava/util/List;", "getToUsers", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/u6;", "cardInfo", "Lcom/bytedance/android/livesdk/message/model/u6;", "getCardInfo", "()Lcom/bytedance/android/livesdk/message/model/u6;", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g7 implements vh7.h {

    @SerializedName("card_info")
    protected u6 cardInfo;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("from_user")
    protected dc fromUser;

    @SerializedName("to_users")
    protected List<dc> toUsers;

    public g7() {
        this.extra = "";
    }

    public g7(am3.g r100) {
        this.toUsers = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.fromUser = new dc(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.toUsers.add(new dc(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.cardInfo = new u6(r100);
        goto L3
    L12:
        if (r102 != 100) goto L13;
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.extra != null) goto L37;
        this.extra = "";
        return;
    }
}
