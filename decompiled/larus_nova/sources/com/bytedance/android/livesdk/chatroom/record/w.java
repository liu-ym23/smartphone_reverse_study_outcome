package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.ISessionRecordService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements ISessionRecordService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ILiveRecordService.RecordStatusChangeListener> f108086a;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ISessionRecordService
    public final void release() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L6;
        com.bytedance.android.livesdk.service.l.d().e().release();
        return;
    L6:
        ((ArrayList) this.f108086a).clear();
    }

    public w() {
        this.f108086a = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ISessionRecordService
    public final void addRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L7;
        com.bytedance.android.livesdk.service.l.d().e().addRecordStatsChangeListener(r100);
        return;
    L7:
        if (((ArrayList) this.f108086a).contains(r100) == true) goto L10;
        ((ArrayList) this.f108086a).add(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ISessionRecordService
    public final void callRecordStatsChangeListener(ILiveRecordService.RecordStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "recording");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L5;
        return;
    L5:
        ALogger.d("LiveSessionRecordService", "callRecordStatsChangeListener recording: " + r100);
        Iterator<T> r101 = this.f108086a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((ILiveRecordService.RecordStatusChangeListener) r101.next()).onChange(r100);
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ISessionRecordService
    public final void removeRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L7;
        com.bytedance.android.livesdk.service.l.d().e().removeRecordStatsChangeListener(r100);
        return;
    L7:
        if (((ArrayList) this.f108086a).contains(r100) == false) goto L10;
        ((ArrayList) this.f108086a).remove(r100);
        return;
    }
}
