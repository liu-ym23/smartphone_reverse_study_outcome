package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.distribution.RecommendSubmitResponse.recommendSubmitExtra")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra;", "", "()V", "insertType", "", "getInsertType", "()Ljava/lang/String;", "setInsertType", "(Ljava/lang/String;)V", "interruptRoomList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getInterruptRoomList", "()Ljava/util/List;", "setInterruptRoomList", "(Ljava/util/List;)V", "nextInsertSwipeThreshold", "", "getNextInsertSwipeThreshold", "()I", "setNextInsertSwipeThreshold", "(I)V", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendSubmitExtra implements h {
    public static final Companion Companion = null;

    @SerializedName("insertType")
    protected String insertType;

    @SerializedName("interruptRoomList")
    protected List<Room> interruptRoomList;

    @SerializedName("nextInsertSwipeThreshold")
    protected int nextInsertSwipeThreshold;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveRecommendSubmitExtra$Companion;", "", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LiveRecommendSubmitExtra() {
        this.nextInsertSwipeThreshold = -1;
    }

    public final String getInsertType() {
        return this.insertType;
    }

    public final List<Room> getInterruptRoomList() {
        return this.interruptRoomList;
    }

    public final int getNextInsertSwipeThreshold() {
        return this.nextInsertSwipeThreshold;
    }

    public LiveRecommendSubmitExtra(g r100) {
        this.interruptRoomList = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.interruptRoomList.add(new Room(r100));
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.nextInsertSwipeThreshold = r100.i();
        r102 = r102 | true;
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.insertType = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L30;
        this.nextInsertSwipeThreshold = -1;
        return;
    }

    public final void setInsertType(String r100) {
        this.insertType = r100;
    }

    public final void setInterruptRoomList(List<Room> r100) {
        this.interruptRoomList = r100;
    }

    public final void setNextInsertSwipeThreshold(int r100) {
        this.nextInsertSwipeThreshold = r100;
    }
}
