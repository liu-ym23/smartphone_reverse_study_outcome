package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomRevenueData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomRevenueData;", "", "()V", "openGame", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomRevenueData$OpenGame;", "getOpenGame", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomRevenueData$OpenGame;", "setOpenGame", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomRevenueData$OpenGame;)V", "OpenGame", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomRevenueData implements h {

    @SerializedName("open_game")
    protected OpenGame openGame;

    @ProtoMessage("webcast.data.OpenGame")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomRevenueData$OpenGame;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "streamId", "getStreamId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OpenGame implements h {

        @SerializedName("app_id")
        protected String appId;

        @SerializedName("stream_id")
        protected String streamId;

        public OpenGame() {
        }

        public OpenGame(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.streamId = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.appId = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getStreamId() {
            return this.streamId;
        }
    }

    public RoomRevenueData() {
    }

    public RoomRevenueData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.openGame = new OpenGame(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final OpenGame getOpenGame() {
        return this.openGame;
    }

    public final void setOpenGame(OpenGame r100) {
        this.openGame = r100;
    }
}
