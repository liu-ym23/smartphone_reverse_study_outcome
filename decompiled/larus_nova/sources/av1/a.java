package av1;

import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.enterprocess.IFeedBizInterceptor;
import com.bytedance.android.live.room.enterprocess.IInteractionBizInterceptor;
import com.bytedance.android.live.room.enterprocess.IRoomBizInterceptor;

/* JADX INFO: loaded from: classes8.dex */
public class a implements IEnterProcessorService {
    public a() {
    }

    @Override // com.bytedance.android.live.room.enterprocess.IEnterProcessorService
    public IFeedBizInterceptor feedBizInterceptor() {
        return b.f16355b;
    }

    @Override // com.bytedance.android.live.room.enterprocess.IEnterProcessorService
    public IInteractionBizInterceptor interactionBizInterceptor() {
        return c.f16357b;
    }

    @Override // com.bytedance.android.live.room.enterprocess.IEnterProcessorService
    public IRoomBizInterceptor roomBizInterceptor() {
        return d.f16359a;
    }
}
