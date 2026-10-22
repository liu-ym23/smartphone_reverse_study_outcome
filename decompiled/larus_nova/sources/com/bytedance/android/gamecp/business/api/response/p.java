package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gameplay.api.TeamPlayGame")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/p;", "", "", "gameId", "Ljava/lang/String;", "gameName", "packageName", "", "packageNameList", "Ljava/util/List;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements vh7.h {

    @SerializedName("game_id")
    public String gameId;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String gameName;

    @SerializedName("package_name")
    public String packageName;

    @SerializedName("package_name_list")
    public List<String> packageNameList;

    public p() {
    }

    public p(am3.g r100) {
        this.packageNameList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.gameId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.gameName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.packageName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 6) goto L13;
        this.packageNameList.add(am3.h.c(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
