package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.model.GameUserGiftStatusItem;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.gamecp.api.GetUserRoomMetaResponse.Data")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k5;", "", "Lcom/bytedance/android/livesdk/message/model/um;", "mUserIntroCardConfig", "Lcom/bytedance/android/livesdk/message/model/um;", "", "Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItem;", "userGiftStatusList", "Ljava/util/List;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k5 implements vh7.h {

    @SerializedName("user_introduce_card_status")
    public um mUserIntroCardConfig;

    @SerializedName("user_gift_status")
    public List<? extends GameUserGiftStatusItem> userGiftStatusList;

    public k5() {
        this.mUserIntroCardConfig = new um();
        this.userGiftStatusList = new ArrayList();
    }

    public k5(am3.g r100) {
        this.userGiftStatusList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.mUserIntroCardConfig = new um(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.userGiftStatusList.add(new GameUserGiftStatusItem(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.mUserIntroCardConfig != null) goto L16;
        this.mUserIntroCardConfig = new um();
    L16:
        if (this.userGiftStatusList.isEmpty() == false) goto L28;
        this.userGiftStatusList = new ArrayList();
        return;
    }
}
