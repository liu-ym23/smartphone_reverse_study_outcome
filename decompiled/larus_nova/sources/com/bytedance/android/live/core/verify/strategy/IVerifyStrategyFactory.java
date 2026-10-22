package com.bytedance.android.live.core.verify.strategy;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import y80.b;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/verify/strategy/IVerifyStrategyFactory;", "Lcom/bytedance/android/live/base/IService;", "", "verifyType", "Lx80/b;", "createVerifyStrategy", "Ly80/b;", "createRechargeVerifyStrategy", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVerifyStrategyFactory extends IService {
    b createRechargeVerifyStrategy(int r100);

    x80.b createVerifyStrategy(int r100);
}
