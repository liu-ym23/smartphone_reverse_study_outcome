package com.bytedance.android.shopping.store.repository.vo;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/vo/ShopHeaderVideoVO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/shopping/store/repository/vo/ShopHeaderVideoInfoVO;", "feedData", "Ljava/util/List;", "getFeedData", "()Ljava/util/List;", "setFeedData", "(Ljava/util/List;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderVideoVO implements Serializable {
    public static final a Companion = null;
    private List<ShopHeaderVideoInfoVO> feedData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopHeaderVideoVO() {
    }

    public final List<ShopHeaderVideoInfoVO> getFeedData() {
        return this.feedData;
    }

    public final void setFeedData(List<ShopHeaderVideoInfoVO> r100) {
        this.feedData = r100;
    }
}
