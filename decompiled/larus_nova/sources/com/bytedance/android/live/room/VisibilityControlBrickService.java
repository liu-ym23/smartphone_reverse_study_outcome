package com.bytedance.android.live.room;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/VisibilityControlBrickService;", "Lcom/bytedance/android/live/room/api/IVisibilityControlBrickService;", "()V", "mLiveViewControlServiceMap", "", "", "Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "provideVisibilityControlService", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "releaseService", "", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VisibilityControlBrickService implements IVisibilityControlBrickService {
    private final Map<Integer, IVisibilityControlService> mLiveViewControlServiceMap;

    public VisibilityControlBrickService() {
        this.mLiveViewControlServiceMap = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlBrickService
    public IVisibilityControlService provideVisibilityControlService(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        IVisibilityControlService r101 = this.mLiveViewControlServiceMap.get(Integer.valueOf(r100.hashCode()));
        if (r101 != null) goto L9;
        VisibilityControlService r102 = new VisibilityControlService();
        this.mLiveViewControlServiceMap.put(Integer.valueOf(r100.hashCode()), r102);
        return r102;
    L9:
        return r101;
    }

    @Override // com.bytedance.android.live.room.api.IVisibilityControlBrickService
    public void releaseService(DataCenter r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        VisibilityControlService.Companion.getClass();
        ALogger.w(VisibilityControlService.a.a(), "start do PlayerControlBrickService release for dataCenter:" + r100.hashCode());
        IVisibilityControlService r101 = this.mLiveViewControlServiceMap.get(Integer.valueOf(r100.hashCode()));
        if (r101 == null) goto L7;
        r101.releaseService();
    L7:
        this.mLiveViewControlServiceMap.remove(Integer.valueOf(r100.hashCode()));
    }
}
