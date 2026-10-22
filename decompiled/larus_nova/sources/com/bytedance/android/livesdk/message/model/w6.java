package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/w6;", "", "", "Lcom/bytedance/android/livesdk/message/model/x6;", "winningUsers", "Ljava/util/List;", "getWinningUsers", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/v6;", "thanksCardResource", "Lcom/bytedance/android/livesdk/message/model/v6;", "getThanksCardResource", "()Lcom/bytedance/android/livesdk/message/model/v6;", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class w6 implements vh7.h {

    @SerializedName("extra")
    protected String extra;

    @SerializedName("thanks_card_resource")
    protected v6 thanksCardResource;

    @SerializedName("winning_users")
    protected List<x6> winningUsers;

    public w6() {
        this.extra = "";
    }

    public w6(am3.g r100) {
        this.winningUsers = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.winningUsers.add(new x6(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.thanksCardResource = new v6(r100);
        goto L3
    L10:
        if (r102 != 100) goto L11;
        this.extra = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.extra != null) goto L31;
        this.extra = "";
        return;
    }
}
