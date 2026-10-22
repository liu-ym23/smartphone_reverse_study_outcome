package com.bytedance.android.live.panel;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.panel.panelobserver.PanelCoverObserver;
import com.bytedance.android.live.room.api.panel.IPanelService;
import com.bytedance.android.live.room.api.panel.c;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.zi0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/panel/PanelService;", "Lcom/bytedance/android/live/room/api/panel/IPanelService;", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "createPanelManager", "roomContext", "Lcom/bytedance/android/live/room/api/panel/c;", "getPanelManager", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PanelService implements IPanelService {
    public PanelService() {
    }

    @Override // com.bytedance.android.live.room.api.panel.IPanelService
    public DataContext createPanelManager(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "dataContext");
        Lazy r101 = PanelSetting.f85374a;
        zi0 r102 = zi0.f121768a;
        Integer r103 = r102.getValue();
        boolean r104 = true;
        if (r103 != null) goto L6;
    L7:
        Integer r105 = r102.getValue();
        if (r105 != null) goto L11;
    L13:
        r104 = false;
    L14:
        if (r104 == true) goto L16;
    L22:
        ALogger.i(PanelManager.TAG, "disable PanelManager");
        return null;
    L16:
        if (PadConfigUtils.c() == true) goto L22;
        if (FoldScreenUtils.f() == true) goto L22;
        PanelManager r106 = new PanelManager();
        r106.init();
        r106.registerPanelObserver(new PanelCoverObserver());
        return r106;
    L11:
        if (r105.intValue() != 2) goto L13;
    L6:
        if (r103.intValue() == 1) goto L14;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.panel.IPanelService
    public c getPanelManager(DataContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Object r101 = null;
        if ((r100 instanceof RoomContext) == true) goto L5;
        r100 = null;
    L5:
        RoomContext r102 = (RoomContext) r100;
        if (r102 == null) goto L10;
        j<DataContext> r103 = r102.getPanelManager();
        if (r103 == null) goto L10;
        DataContext r104 = r103.getValue();
    L12:
        if ((r104 instanceof c) == false) goto L16;
        r101 = r104;
    L16:
        return (c) r101;
    L10:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.room.api.panel.IPanelService
    public c getPanelManager(DataCenter r100, long r101) {
        RoomContext.Companion.getClass();
        RoomContext r102 = RoomContext.a.a(r100, r101);
        Object r103 = null;
        if (r102 == null) goto L7;
        j<DataContext> r104 = r102.getPanelManager();
        if (r104 == null) goto L7;
        DataContext r105 = r104.getValue();
    L9:
        if ((r105 instanceof c) == false) goto L13;
        r103 = r105;
    L13:
        return (c) r103;
    L7:
        r105 = null;
        goto L9
    }
}
