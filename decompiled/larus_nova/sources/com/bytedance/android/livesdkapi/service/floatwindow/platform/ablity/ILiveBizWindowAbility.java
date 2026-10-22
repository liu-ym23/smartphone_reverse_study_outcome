package com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity;

import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/ILiveBizWindowAbility;", "", "abilityEnv", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "getAbilityEnv", "()Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "setAbilityEnv", "(Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;)V", "enable", "", "getBizTag", "", "getPriority", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveBizWindowAbility {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static int getPriority(ILiveBizWindowAbility r100) {
            return 10;
        }
    }

    boolean enable();

    LiveBizWindowAbilityEnv getAbilityEnv();

    String getBizTag();

    int getPriority();

    void setAbilityEnv(LiveBizWindowAbilityEnv r100);
}
