package com.bytedance.android.gamecp.business.playrank;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetUserGameDataAuthResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/business/playrank/a;", "", "", "auth", "I", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("auth")
    public int auth;

    public a() {
        this.auth = 1;
    }

    public a(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L8;
        if (r103 != 1) goto L6;
        this.auth = r100.i();
        r102 = r102 | true;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L8:
        r100.d(r101);
        if ((r102 & true) == true) goto L18;
        this.auth = 1;
        return;
    }
}
