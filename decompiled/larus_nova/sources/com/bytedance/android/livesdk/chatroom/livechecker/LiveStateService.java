package com.bytedance.android.livesdk.chatroom.livechecker;

import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdkapi.livestate.IDataProvider;
import com.bytedance.android.livesdkapi.livestate.ILiveStateService;
import com.bytedance.android.livesdkapi.livestate.LiveStateRequest;
import com.bytedance.android.livesdkapi.model.UserLiveStatusModel;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J!\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/livechecker/LiveStateService;", "Lcom/bytedance/android/livesdkapi/livestate/ILiveStateService;", "()V", "cancelLoop", "", "key", "", "checkRoomStatus", "request", "Lcom/bytedance/android/livesdkapi/livestate/LiveStateRequest;", "getRoomIdFromCache", "", "sceneId", "uid", "(JLjava/lang/String;)Ljava/lang/Long;", "getUserLiveStatusFromCache", "Lcom/bytedance/android/livesdkapi/model/UserLiveStatusModel;", "removeAllCache", "removeCache", "userId", "runInLoop", "owner", "Landroidx/lifecycle/LifecycleRegistry;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/bytedance/android/livesdkapi/livestate/IDataProvider;", "setCachePeriod", "scene", "time", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class LiveStateService implements ILiveStateService {
    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void removeAllCache() {
        LiveStateManager.f106819k.removeAllCache();
    }

    public LiveStateService() {
        k.l(ILiveStateService.class, this);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void cancelLoop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        LiveStateManager.f106819k.cancelLoop(r100);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void checkRoomStatus(LiveStateRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        LiveStateManager.f106819k.checkRoomStatus(r100);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void removeCache(long r100) {
        LiveStateManager.f106819k.removeCache(r100);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public Long getRoomIdFromCache(long r100, String r101) {
        return LiveStateManager.f106819k.getRoomIdFromCache(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public UserLiveStatusModel getUserLiveStatusFromCache(long r100, String r101) {
        return LiveStateManager.f106819k.getUserLiveStatusFromCache(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void removeCache(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        LiveStateManager.f106819k.removeCache(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void setCachePeriod(long r100, long r101) {
        LiveStateManager.f106819k.setCachePeriod(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateManager
    public void runInLoop(String r100, LifecycleRegistry r101, IDataProvider r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        LiveStateManager.f106819k.runInLoop(r100, r101, r102);
    }
}
