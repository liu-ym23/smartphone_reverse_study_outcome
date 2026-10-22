package com.bytedance.android.gamecp.host_api.model.toolbar;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.ToolBarComponentData")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/toolbar/ToolbarComponentData;", "", "", "id", "I", "getId", "()I", "setId", "(I)V", "", ControlRule.KEY_EXTRA_DATA, "Ljava/lang/String;", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarComponentData implements h {
    public static final a Companion = null;

    @SerializedName("extra")
    protected String extraData;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("component_type")
    protected int f57399id;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ToolbarComponentData() {
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final int getId() {
        return this.f57399id;
    }

    public ToolbarComponentData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 2) goto L8;
        this.f57399id = r100.i();
        goto L3
    L8:
        if (r102 != 99) goto L9;
        this.extraData = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setExtraData(String r100) {
        this.extraData = r100;
    }

    public final void setId(int r100) {
        this.f57399id = r100;
    }
}
