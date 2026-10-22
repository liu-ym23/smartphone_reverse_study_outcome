package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showDouPlusDialog")
public final class j4 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static final class a {

        @SerializedName("enter_from")
        String entranceType;

        @SerializedName("sec_anchor_id")
        String secAnchorId;

        public a() {
        }
    }

    public j4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r110, final CallContext r111) throws Exception {
        final a r112 = r110;
        final ILiveDouPlusService r100 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        if (r100 == null) goto L10;
        Room r101 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        if (r101 == null) goto L11;
        ((ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class)).showDouPlusLiveEntry(r101.author().getCastSecUid(), r101.getId(), r112.entranceType, new h4(this, r111, r112, r100));
        return null;
    L11:
        return null;
    L10:
        return null;
    }
}
