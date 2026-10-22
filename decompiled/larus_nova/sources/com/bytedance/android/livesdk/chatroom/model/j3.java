package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.SetDecorationV2ResponseData")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/j3;", "", "", "isSuccess", "Z", "()Z", "setSuccess", "(Z)V", "contentIsEqual", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContentIsEqual", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j3 implements vh7.h {

    @SerializedName("content_is_equal")
    protected boolean contentIsEqual;

    @SerializedName("is_success")
    protected boolean isSuccess;

    public j3() {
    }

    public j3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.isSuccess = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.contentIsEqual = am3.h.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final boolean a() {
        return this.contentIsEqual;
    }
}
