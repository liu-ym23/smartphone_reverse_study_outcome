package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0016\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\rj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveMoreEntranceFloatWindowModel;", "", "currentLiveHashCode", "", "enterFromMerge", "", "enterMethod", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "addTime", "", "defaultHeight", "mobParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "businessLine", "Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/live/Room;JILjava/util/HashMap;Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;)V", "getAddTime", "()J", "getBusinessLine", "()Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;", "consumed", "", "getConsumed", "()Z", "setConsumed", "(Z)V", "getCurrentLiveHashCode", "()I", "getDefaultHeight", "getEnterFromMerge", "()Ljava/lang/String;", "getEnterMethod", "getMobParams", "()Ljava/util/HashMap;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "roomIdList", "", "getRoomIdList", "()[J", "setRoomIdList", "([J)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMoreEntranceFloatWindowModel {
    private final long addTime;
    private final FloatWindowBusinessLine businessLine;
    private boolean consumed;
    private final int currentLiveHashCode;
    private final int defaultHeight;
    private final String enterFromMerge;
    private final String enterMethod;
    private final HashMap<String, String> mobParams;
    private final Room room;
    private long[] roomIdList;

    public final long getAddTime() {
        return this.addTime;
    }

    public final FloatWindowBusinessLine getBusinessLine() {
        return this.businessLine;
    }

    public final boolean getConsumed() {
        return this.consumed;
    }

    public final int getCurrentLiveHashCode() {
        return this.currentLiveHashCode;
    }

    public final int getDefaultHeight() {
        return this.defaultHeight;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final HashMap<String, String> getMobParams() {
        return this.mobParams;
    }

    public final Room getRoom() {
        return this.room;
    }

    public final long[] getRoomIdList() {
        return this.roomIdList;
    }

    public final void setConsumed(boolean r100) {
        this.consumed = r100;
    }

    public final void setRoomIdList(long[] r100) {
        this.roomIdList = r100;
    }

    public LiveMoreEntranceFloatWindowModel(int r100, String r101, String r102, Room r103, long r104, int r105, HashMap<String, String> r106, FloatWindowBusinessLine r110) {
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r103, "room");
        Intrinsics.checkNotNullParameter(r106, "mobParams");
        Intrinsics.checkNotNullParameter(r110, "businessLine");
        this.currentLiveHashCode = r100;
        this.enterFromMerge = r101;
        this.enterMethod = r102;
        this.room = r103;
        this.addTime = r104;
        this.defaultHeight = r105;
        this.mobParams = r106;
        this.businessLine = r110;
    }

    public /* synthetic */ LiveMoreEntranceFloatWindowModel(int r110, String r111, String r112, Room r113, long r114, int r115, HashMap r210, FloatWindowBusinessLine r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 32) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r212 & 64) == 0) goto L9;
        HashMap r116 = new HashMap();
    L11:
        if ((r212 & 128) == 0) goto L13;
        FloatWindowBusinessLine r117 = FloatWindowBusinessLine.MoreAnchor;
    L14:
        this(r110, r111, r112, r113, r114, r100, r116, r117);
        return;
    L13:
        r117 = r211;
        goto L14
    L9:
        r116 = r210;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }
}
