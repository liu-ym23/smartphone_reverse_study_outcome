package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/x2;", "", "", "chorusId", "Ljava/lang/Long;", "getChorusId", "()Ljava/lang/Long;", "", "Lcom/bytedance/android/live/base/model/user/User;", "userList", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/message/model/aj;", "chorusInfo", "Lcom/bytedance/android/livesdk/message/model/aj;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/aj;", "", "chorusIdStr", "Ljava/lang/String;", "getChorusIdStr", "()Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x2 implements vh7.h {

    @SerializedName("chorus_id")
    protected Long chorusId;

    @SerializedName("chorus_id_str")
    protected String chorusIdStr;

    @SerializedName("chorus_info")
    protected aj chorusInfo;

    @SerializedName("user_list")
    protected List<User> userList;

    public x2() {
    }

    public final aj a() {
        return this.chorusInfo;
    }

    public final List<User> b() {
        return this.userList;
    }

    public x2(am3.g r100) {
        this.userList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.chorusId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userList.add(new User(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.chorusInfo = new aj(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.chorusIdStr = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
