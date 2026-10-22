package com.bytedance.android.live.revlink.impl.pk.dialog.contract;

import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdk.link.model.g2;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import x31.p;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractDialogPkRecordContract$View", "Lcom/bytedance/android/live/revlink/impl/control/dialog/RevInteractDialogFragmentBaseContract$View;", "Lx31/p;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class InteractDialogPkRecordContract$View extends RevInteractDialogFragmentBaseContract$View<p> {
    public abstract void ba0(Throwable r100);

    public abstract void ca0(IRoom r100, v4 r101, int r102);

    public abstract void da0(Throwable r100, int r101);

    public abstract void ea0(g2 r100, int r101);

    public InteractDialogPkRecordContract$View() {
    }
}
