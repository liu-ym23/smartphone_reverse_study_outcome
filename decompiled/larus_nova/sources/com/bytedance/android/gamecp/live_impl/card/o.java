package com.bytedance.android.gamecp.live_impl.card;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetUserRoomMetaResponse.Data")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/card/o;", "", "Lcom/bytedance/android/gamecp/live_impl/card/r;", "mUserIntroCardConfig", "Lcom/bytedance/android/gamecp/live_impl/card/r;", "", "Lcom/bytedance/android/gamecp/host_api/model/introducecard/n;", "userGiftStatusList", "Ljava/util/List;", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o implements vh7.h {

    @SerializedName("user_introduce_card_status")
    public r mUserIntroCardConfig;

    @SerializedName("user_gift_status")
    public List<com.bytedance.android.gamecp.host_api.model.introducecard.n> userGiftStatusList;

    public final Map<String, com.bytedance.android.gamecp.host_api.model.introducecard.n> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = this.userGiftStatusList.size() - 1;
    L3:
        if (r101 < 0) goto L8;
        com.bytedance.android.gamecp.host_api.model.introducecard.n r102 = (com.bytedance.android.gamecp.host_api.model.introducecard.n) ListProtector.get(this.userGiftStatusList, r101);
        String r103 = r102.gameId;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r100.put(r103, r102);
        r101 = r101 - 1;
        goto L3
    L8:
        return r100;
    }

    public o() {
        this.mUserIntroCardConfig = new r();
        this.userGiftStatusList = new ArrayList();
    }

    public o(am3.g r100) {
        this.userGiftStatusList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.mUserIntroCardConfig = new r(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.userGiftStatusList.add(new com.bytedance.android.gamecp.host_api.model.introducecard.n(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.mUserIntroCardConfig != null) goto L16;
        this.mUserIntroCardConfig = new r();
    L16:
        if (this.userGiftStatusList.isEmpty() == false) goto L28;
        this.userGiftStatusList = new ArrayList();
        return;
    }
}
