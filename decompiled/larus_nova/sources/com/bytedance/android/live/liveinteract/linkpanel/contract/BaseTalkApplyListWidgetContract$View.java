package com.bytedance.android.live.liveinteract.linkpanel.contract;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;
import kotlin.Metadata;
import yf0.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/liveinteract/linkpanel/contract/BaseTalkApplyListWidgetContract$View", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/InteractDialogWidgetBaseContract$View;", "Lyf0/a;", "<init>", "()V", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTalkApplyListWidgetContract$View extends InteractDialogWidgetBaseContract$View<a> {
    public abstract void Aq(Throwable r100);

    public abstract void Bq(List<? extends ILinkPlayerInfoBridge> r100, long r101, boolean r102, String r103, String r104, boolean r105, int r106, boolean r107, boolean r110);

    public abstract void Cq(com.bytedance.android.live.liveinteract.linkpanel.model.a r100);

    public abstract void wq(boolean r100);

    public abstract void xq(boolean r100);

    public abstract void yq(List<? extends ILinkPlayerInfoBridge> r100);

    public abstract void zq(List<? extends ILinkPlayerInfoBridge> r100);

    public BaseTalkApplyListWidgetContract$View() {
    }
}
