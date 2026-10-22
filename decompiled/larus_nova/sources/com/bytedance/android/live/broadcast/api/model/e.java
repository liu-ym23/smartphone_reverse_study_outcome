package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.anchor.AnchorPermissionStatusResponse.ApplyDetail")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/e;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/f;", "rules", "Ljava/util/List;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("rules")
    protected List<f> rules;

    public e() {
    }

    public e(am3.g r100) {
        this.rules = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.rules.add(new f(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
