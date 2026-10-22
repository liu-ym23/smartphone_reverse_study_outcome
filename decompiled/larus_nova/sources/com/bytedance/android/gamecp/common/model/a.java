package com.bytedance.android.gamecp.common.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetPromotedGamesResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/a;", "", "", "status", "Ljava/lang/String;", "", "hasPropPermission", "Z", "hasAgreePropProtocol", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("is_agree_prop_protocol")
    public boolean hasAgreePropProtocol;

    @SerializedName("has_prop_permission")
    public boolean hasPropPermission;

    @SerializedName("status")
    public String status;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.model.a$a, reason: collision with other inner class name */
    public static final class C0909a {
    }

    static {
    }

    public a() {
        this.status = "-1";
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.status = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 6) goto L10;
        this.hasPropPermission = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 7) goto L11;
        this.hasAgreePropProtocol = am3.h.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.status != null) goto L31;
        this.status = "-1";
        return;
    }
}
