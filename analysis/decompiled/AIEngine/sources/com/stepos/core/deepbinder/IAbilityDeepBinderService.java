package com.stepos.core.deepbinder;

import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@AutoRecover
@ServiceName("com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl")
@ValidityCheck
/* loaded from: classes.dex */
public interface IAbilityDeepBinderService {
    boolean acquire();

    boolean cancel();

    boolean cancelInfer(String str);

    void completeInput(String str);

    Content execute(String str, Content content);

    @Oneway
    void feedInput(String str, Content content);

    AbilityInfo getInfo();

    @Oneway
    void infer(String str, Content content, IInferenceStreamCallback iInferenceStreamCallback);

    int inferSync(String str, Content content, IInferenceStreamCallback iInferenceStreamCallback);

    void registerModelChangeListener(String str, IModelChangeListener iModelChangeListener);

    void registerReleaseListener(String str, IReleaseListener iReleaseListener);

    void release();

    void unregisterModelChangeListener(String str);

    void unregisterReleaseListener(String str);
}
