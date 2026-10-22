package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v implements IRoomRecordService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILiveRecordService.RecordStatus f108085a;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IRoomRecordService
    public final boolean isPreview() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L7;
        return com.bytedance.android.livesdk.service.l.d().e().isPreview();
    L7:
        if (this.f108085a != ILiveRecordService.RecordStatus.PREVIEW) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IRoomRecordService
    public final boolean isRecording() {
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L5;
        ALogger.i("LiveMutleRecordService", "isRecording: " + this.f108085a);
        if (this.f108085a != ILiveRecordService.RecordStatus.RECORDING) goto L9;
        return true;
    L9:
        return false;
    L5:
        return com.bytedance.android.livesdk.service.l.d().e().isRecording();
    }

    public v() {
        this.f108085a = ILiveRecordService.RecordStatus.UNKONW;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IRoomRecordService
    public final void setRecordStatus(ILiveRecordService.RecordStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "recording");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L6;
        com.bytedance.android.livesdk.service.l.d().e().setRecordStatus(r100);
        return;
    L6:
        this.f108085a = r100;
    }
}
