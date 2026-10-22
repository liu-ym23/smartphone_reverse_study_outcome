package com.bytedance.android.live.room.api.panel;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ServiceLookup("com.bytedance.android.live.panel.PanelService")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&J \u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/panel/IPanelService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "createPanelManager", "roomContext", "Lcom/bytedance/android/live/room/api/panel/c;", "getPanelManager", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "roomId", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPanelService extends IService {
    DataContext createPanelManager(DataContext r100);

    c getPanelManager(DataCenter r100, long r101);

    c getPanelManager(DataContext r100);
}
