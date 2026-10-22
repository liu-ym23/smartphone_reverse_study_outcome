package com.bytedance.android.livesdk.recommend;

import com.bytedance.android.livesdkapi.recommend.IRecommendController;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/recommend/RecommendController;", "Lcom/bytedance/android/livesdkapi/recommend/IRecommendController;", "()V", "needPersonalRecommend", "", "getNeedPersonalRecommend", "setNeedPersonalRecommend", "", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class RecommendController implements IRecommendController {
    private boolean needPersonalRecommend;

    public RecommendController() {
        k.l(IRecommendController.class, this);
        this.needPersonalRecommend = true;
    }

    @Override // com.bytedance.android.livesdkapi.recommend.IRecommendController
    public boolean getNeedPersonalRecommend() {
        return this.needPersonalRecommend;
    }

    @Override // com.bytedance.android.livesdkapi.recommend.IRecommendController
    public void setNeedPersonalRecommend(boolean r100) {
        this.needPersonalRecommend = r100;
    }
}
