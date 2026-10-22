package com.bytedance.android.live.openplatform.api.minigame;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.livesdk.log.filter.v;
import h70.b;
import j70.h;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/OpenPlatformMgAudienceServiceDummy;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAudienceService;", "Lj70/h;", "Lh70/b;", "getAudienceMiniGameWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniGameSource;", "source", "", "uri", "", "openMountedMiniGame", "reportMpClick", "", "isBackground", "notifyRoomOnBackground", "getMicroGameInfo", "reportMpShow", "status", "setMountStatus", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "params", "injectMgParams", "<init>", "()V", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMgAudienceServiceDummy implements IOpenPlatformMgAudienceService {
    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public h<? extends b> getAudienceMiniGameWidgetDescriptor() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public String getMicroGameInfo() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void injectMgParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void notifyRoomOnBackground(boolean r100) {
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void openMountedMiniGame(MountedMiniGameSource r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public Pair<String, v> provideMgParams2LogInjector() {
        return null;
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void reportMpClick(MountedMiniGameSource r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void reportMpShow() {
    }

    @Override // com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService
    public void setMountStatus(boolean r100) {
    }

    public OpenPlatformMgAudienceServiceDummy() {
        k.l(IOpenPlatformMgAudienceService.class, this);
    }
}
