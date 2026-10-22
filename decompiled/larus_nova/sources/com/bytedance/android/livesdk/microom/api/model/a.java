package com.bytedance.android.livesdk.microom.api.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.official_channel.GrabMicShowResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/microom/api/model/a;", "", "", "status", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("status")
    protected long status;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.status == ((a) r100).status) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.status;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "GrabMicShowData(status=" + this.status + ")";
    }

    public a() {
        this.status = 0;
    }

    public final long a() {
        return this.status;
    }

    public a(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L8;
        if (r103 != 1) goto L6;
        this.status = r100.j();
        r102 = r102 | true;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L8:
        r100.d(r101);
        if ((r102 & true) == true) goto L18;
        this.status = 0;
        return;
    }
}
