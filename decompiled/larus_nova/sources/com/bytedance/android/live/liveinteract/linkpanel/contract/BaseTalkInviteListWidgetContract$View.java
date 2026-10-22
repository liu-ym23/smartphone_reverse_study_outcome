package com.bytedance.android.live.liveinteract.linkpanel.contract;

import com.bytedance.android.live.liveinteract.linkpanel.model.a;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import java.util.List;
import kotlin.Metadata;
import yf0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkInviteListWidgetContract$View", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/InteractDialogWidgetBaseContract$View;", "Lyf0/c;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkInviteListWidgetContract$View extends InteractDialogWidgetBaseContract$View<c> {
    public abstract void Aq(a1 r100);

    public abstract void wq(Throwable r100);

    public abstract void xq(List<? extends ILinkPlayerInfoBridge> r100);

    public abstract void yq(a r100);

    public abstract void zq(List<? extends IMiddlewareHostSocial.InviteFriendsConfig.Friend> r100, List<? extends e1> r101);

    public BaseTalkInviteListWidgetContract$View() {
    }
}
