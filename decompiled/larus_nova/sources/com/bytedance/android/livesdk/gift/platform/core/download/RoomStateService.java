package com.bytedance.android.livesdk.gift.platform.core.download;

import android.content.Context;
import ca0.v;
import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v12.e;
import v12.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/download/RoomStateService;", "Lcom/bytedance/android/live/gift/IRoomStateService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "onEnterRoom", "onExitRoom", "Lca0/v;", "listener", "registRoomStateListner", "unregistRoomStateListner", "", "roomId", "I", "getRoomId", "()I", "setRoomId", "(I)V", "", "mListeners", "Ljava/util/List;", "getMListeners", "()Ljava/util/List;", "setMListeners", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomStateService implements IRoomStateService {
    private List<v> mListeners;
    private int roomId;

    @Override // com.bytedance.android.live.gift.IRoomStateService
    public void onExitRoom() {
        this.roomId = -1;
        Iterator<v> r100 = this.mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        r100.next().onExitRoom();
        goto L4
    L10:
        d0.h();     // Catch: Exception -> L9
    L7:
        f.f552413c.clear();
        e.f552410a.clear();
    }

    public RoomStateService() {
        this.roomId = -1;
        this.mListeners = new ArrayList();
    }

    public final List<v> getMListeners() {
        return this.mListeners;
    }

    public final int getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.live.gift.IRoomStateService
    public void onEnterRoom(Context r100) {
        this.roomId = this.roomId;
        Iterator<v> r101 = this.mListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onEnterRoom();
        goto L4
    }

    @Override // com.bytedance.android.live.gift.IRoomStateService
    public void registRoomStateListner(v r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.mListeners.contains(r100) == true) goto L6;
        this.mListeners.add(r100);
        return;
    }

    public final void setMListeners(List<v> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mListeners = r100;
    }

    public final void setRoomId(int r100) {
        this.roomId = r100;
    }

    @Override // com.bytedance.android.live.gift.IRoomStateService
    public void unregistRoomStateListner(v r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Iterator<v> r101 = this.mListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r100, r101.next()) == false) goto L4;
        r101.remove();
        goto L4
    }
}
