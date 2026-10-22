package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R6\u0010\u0007\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0003j\b\u0012\u0004\u0012\u00020\u000b`\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/service/AnchorLayoutDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/link/core/service/i;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "Lcom/bytedance/android/live/revlink/link/core/service/q;", "Lcom/bytedance/android/live/revenue/common/NextLiveData;", "layoutStates", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getLayoutStates", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lcom/bytedance/android/live/revlink/link/core/service/p;", "layoutFrame", "getLayoutFrame", "Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Lcom/bytedance/android/live/revlink/link/infra/lifecontrol/context/a;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLayoutDataContext extends DataContext implements i {
    private final NextLiveData<p> layoutFrame;
    private final NextLiveData<List<q>> layoutStates;

    @Override // com.bytedance.android.live.revlink.link.core.service.i
    public NextLiveData<p> getLayoutFrame() {
        return this.layoutFrame;
    }

    public NextLiveData<List<q>> getLayoutStates() {
        return this.layoutStates;
    }

    public AnchorLayoutDataContext(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.layoutStates = new NextLiveData();
        this.layoutFrame = new NextLiveData();
    }
}
