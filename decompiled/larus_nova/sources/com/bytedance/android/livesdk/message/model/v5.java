package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v5;", "", "", "Lcom/bytedance/android/livesdk/gift/model/t2;", "groupMemberList", "Ljava/util/List;", "getGroupMemberList", "()Ljava/util/List;", "setGroupMemberList", "(Ljava/util/List;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v5 implements vh7.h {

    @SerializedName("members")
    protected List<com.bytedance.android.livesdk.gift.model.t2> groupMemberList;

    public v5() {
        this.groupMemberList = new ArrayList();
    }

    public v5(am3.g r100) {
        this.groupMemberList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 2) goto L7;
        this.groupMemberList.add((com.bytedance.android.livesdk.gift.model.t2) vh7.f.a(r100, com.bytedance.android.livesdk.gift.model.t2.class));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.groupMemberList.isEmpty() == false) goto L19;
        this.groupMemberList = new ArrayList();
        return;
    }
}
