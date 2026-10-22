package com.bytedance.android.live.revenue.service.profit;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.profit.api.IProfitServiceExternal;
import com.bytedance.android.live.profit.vip.model.b;
import com.bytedance.android.live.revenue.service.base.RevenueExposedWrapperBase;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt0.a;
import zt0.f;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J,\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revenue/service/profit/ProfitServiceWrapper;", "Lcom/bytedance/android/live/revenue/service/base/RevenueExposedWrapperBase;", "Lyt0/a;", "Lcom/bytedance/android/live/profit/api/IProfitServiceExternal;", "", "requestPage", "authorId", "", "showVipEmojiTemplatePanel", "", "ratioType", "Lcom/bytedance/retrofit2/mime/MultipartTypedOutput;", "typedOutput", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/profit/vip/model/b;", "uploadVipCustomEmoji", "", "Lzo2/a;", "getProfitNitaViewList", "Lzt0/f;", "getPrivilegeSlardarMonitor", "()Lzt0/f;", "privilegeSlardarMonitor", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfitServiceWrapper extends RevenueExposedWrapperBase<a> implements IProfitServiceExternal {
    public ProfitServiceWrapper() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.profit.api.IProfitServiceExternal
    public f getPrivilegeSlardarMonitor() {
        return getRealInstance().getPrivilegeSlardarMonitor();
    }

    @Override // com.bytedance.android.live.profit.api.IProfitServiceExternal
    public List<zo2.a> getProfitNitaViewList() {
        return getRealInstance().getProfitNitaViewList();
    }

    @Override // com.bytedance.android.live.profit.api.IProfitServiceExternal
    public void showVipEmojiTemplatePanel(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        Intrinsics.checkNotNullParameter(r101, "authorId");
        getRealInstance().showVipEmojiTemplatePanel(r100, r101);
    }

    @Override // com.bytedance.android.live.profit.api.IProfitServiceExternal
    public Single<e<b>> uploadVipCustomEmoji(int r100, String r101, MultipartTypedOutput r102) {
        Intrinsics.checkNotNullParameter(r101, "authorId");
        Intrinsics.checkNotNullParameter(r102, "typedOutput");
        return getRealInstance().uploadVipCustomEmoji(r100, r101, r102);
    }
}
