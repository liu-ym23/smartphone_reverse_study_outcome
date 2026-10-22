package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public interface c {
    void finishMultiAnchor(int r100, Function0<Unit> r101, boolean r102, String r103, boolean r104);

    com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService();

    i11.b getAnchorLinkUserCenter();

    t getConnectMonitor();

    f21.a getConnectionContext();

    MultiLinkAnchorControlContext getControlContext();

    f41.a getJsbInvitePkCallback();

    u getLaunchParameters();

    u.a getLaunchRecord();

    com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService();

    ld.a getLinkInternalDataSet();

    n getLinkOutManager();

    i11.b getMLinkUserCenter();

    IRoom getMRoom();

    MutableLiveData<q11.c> getPkLinkState();

    x11.a getRevInternalLinkService();

    wq2.f getRoomDataCenterService();

    AnchorRtcConnectManager getRtcConnectManager();

    AnchorRtcConnectModel getRtcConnectModel();

    Function0<v51.b> getStreamInteractScopeFn();

    UnexpectedFrameMonitor getUnexpectedFrameMonitor();

    boolean isLinkWithAudience();

    void reset(String r100);

    void setConnectionContext(f21.a r100);

    void setJsbInvitePkCallback(f41.a r100);

    void setLaunchParameters(u r100);

    void setRtcConnectModel(AnchorRtcConnectModel r100);
}
