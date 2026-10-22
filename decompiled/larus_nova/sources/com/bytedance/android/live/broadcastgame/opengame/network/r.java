package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.open.api.GetUserCollectionStatusResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/r;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/r$a;", "userCollectionStatus", "Lcom/bytedance/android/live/broadcastgame/opengame/network/r$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/broadcastgame/opengame/network/r$a;", "setUserCollectionStatus", "(Lcom/bytedance/android/live/broadcastgame/opengame/network/r$a;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements vh7.h {

    @SerializedName("user_collection_status")
    protected a userCollectionStatus;

    @ProtoMessage("webcast.open.api.GetUserCollectionStatusResponse.Data.UserCollectionStatus")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/r$a;", "", "", "isCollected", "Z", "b", "()Z", "setCollected", "(Z)V", "", "lastCollectTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setLastCollectTime", "(I)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("is_collected")
        protected boolean isCollected;

        @SerializedName("last_collect_time")
        protected int lastCollectTime;

        public a() {
        }

        public final int a() {
            return this.lastCollectTime;
        }

        public final boolean b() {
            return this.isCollected;
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.isCollected = am3.h.a(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.lastCollectTime = (int) r100.j();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    public r() {
    }

    public r(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.userCollectionStatus = new a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final a a() {
        return this.userCollectionStatus;
    }
}
