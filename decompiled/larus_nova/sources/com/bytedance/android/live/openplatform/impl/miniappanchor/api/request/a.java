package com.bytedance.android.live.openplatform.impl.miniappanchor.api.request;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.GetMicroAppOpenInfoRequest")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/request/a;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "", InvRouter.SCENES, "Ljava/util/List;", "getScenes", "()Ljava/util/List;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("app_id")
    protected String appId;

    @SerializedName(InvRouter.SCENES)
    protected List<String> scenes;

    public a(String r100, List<String> r101) {
        this.appId = r100;
        this.scenes = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scenes, r101.scenes) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.scenes;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetMicroAppOpenInfoRequest(appId=" + this.appId + ", scenes=" + this.scenes + ")";
    }

    public a() {
        this.appId = null;
        this.scenes = null;
    }

    public a(g r100) {
        this.scenes = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.appId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.scenes.add(am3.h.c(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.appId != null) goto L16;
        this.appId = null;
    L16:
        if (this.scenes.isEmpty() == false) goto L28;
        this.scenes = null;
        return;
    }
}
