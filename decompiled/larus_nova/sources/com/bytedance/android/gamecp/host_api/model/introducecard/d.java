package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.Content")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/d;", "", "", "contentType", "Ljava/lang/Integer;", "", "content", "Ljava/lang/String;", "", "avatarList", "Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("avatar")
    public List<String> avatarList;

    @SerializedName("content")
    public String content;

    @SerializedName("type")
    public Integer contentType;

    public static final class a {
    }

    static {
    }

    public d() {
        this.contentType = -1;
        this.content = "";
    }

    public d(am3.g r100) {
        this.avatarList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.contentType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.avatarList.add(am3.h.c(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.contentType != null) goto L19;
        this.contentType = -1;
    L19:
        if (this.content != null) goto L34;
        this.content = "";
        return;
    }
}
