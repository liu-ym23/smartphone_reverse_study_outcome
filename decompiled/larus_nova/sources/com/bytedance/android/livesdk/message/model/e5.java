package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.model.GameUserGiftStatusItemIm;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameCPUserRoomMetaMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/e5;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "updateOper", "J", "Lcom/bytedance/android/livesdk/message/model/tm;", "mUserIntroCardConfig", "Lcom/bytedance/android/livesdk/message/model/tm;", "", "Lcom/bytedance/android/livesdkapi/model/GameUserGiftStatusItemIm;", "userGiftStatusList", "Ljava/util/List;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e5 extends o0 implements vh7.h {

    @SerializedName("user_introduce_card_status")
    public tm mUserIntroCardConfig;

    @SerializedName("oper")
    public long updateOper;

    @SerializedName("user_gift_status")
    public List<GameUserGiftStatusItemIm> userGiftStatusList;

    public e5() {
        this.mUserIntroCardConfig = new tm();
        this.userGiftStatusList = new ArrayList();
    }

    public e5(am3.g r100) {
        this.userGiftStatusList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.updateOper = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.mUserIntroCardConfig = new tm(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.userGiftStatusList.add(new GameUserGiftStatusItemIm(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.mUserIntroCardConfig != null) goto L22;
        this.mUserIntroCardConfig = new tm();
    L22:
        if (this.userGiftStatusList.isEmpty() == false) goto L40;
        this.userGiftStatusList = new ArrayList();
        return;
    }
}
