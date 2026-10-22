package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.GameCPUserRoomMetaMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/d;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "", "updateOper", "J", "Lcom/bytedance/android/gamecp/live_impl/message/t;", "mUserIntroCardConfig", "Lcom/bytedance/android/gamecp/live_impl/message/t;", "", "Lcom/bytedance/android/gamecp/live_impl/message/e;", "userGiftStatusList", "Ljava/util/List;", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends ExternalBaseMessage implements vh7.h {

    @SerializedName("user_introduce_card_status")
    public t mUserIntroCardConfig;

    @SerializedName("oper")
    public long updateOper;

    @SerializedName("user_gift_status")
    public List<e> userGiftStatusList;

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 6003;
    }

    public final Map<String, com.bytedance.android.gamecp.host_api.model.introducecard.n> E() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = this.userGiftStatusList.size() - 1;
    L3:
        if (r101 < 0) goto L8;
        e r102 = (e) ListProtector.get(this.userGiftStatusList, r101);
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

    public d() {
        this.mUserIntroCardConfig = new t();
        this.userGiftStatusList = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }

    public d(am3.g r100) {
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
        this.mUserIntroCardConfig = new t(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.userGiftStatusList.add(new e(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.mUserIntroCardConfig != null) goto L22;
        this.mUserIntroCardConfig = new t();
    L22:
        if (this.userGiftStatusList.isEmpty() == false) goto L40;
        this.userGiftStatusList = new ArrayList();
        return;
    }
}
