package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/b0;", "", "", "permissionStatus", "I", "getPermissionStatus", "()I", "setPermissionStatus", "(I)V", "", "schemaUrl", "Ljava/lang/String;", "getSchemaUrl", "()Ljava/lang/String;", "setSchemaUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 implements vh7.h {

    @SerializedName(LocationMonitorConst.PERMISSION_STATUS)
    protected int permissionStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    protected String schemaUrl;

    public b0() {
        this.schemaUrl = "";
    }

    public b0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.permissionStatus = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.schemaUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.schemaUrl != null) goto L25;
        this.schemaUrl = "";
        return;
    }
}
