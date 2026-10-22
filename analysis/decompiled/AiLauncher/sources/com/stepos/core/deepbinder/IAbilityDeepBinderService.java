package com.stepos.core.deepbinder;

import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.data.base.Content;
import com.stepos.deepbinder.annotation.method.Oneway;
import com.stepos.deepbinder.annotation.type.AutoRecover;
import com.stepos.deepbinder.annotation.type.ServiceName;
import com.stepos.deepbinder.annotation.type.ValidityCheck;
import kotlin.Metadata;

@AutoRecover
@ServiceName("com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\tH&¢\u0006\u0004\b&\u0010 J\u001f\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\t2\u0006\u0010#\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\tH&¢\u0006\u0004\b*\u0010 ¨\u0006+"}, d2 = {"Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "", "", "acquire", "()Z", "LY8/t;", "release", "()V", "cancel", "", "inferId", "cancelInfer", "(Ljava/lang/String;)Z", "Lcom/stepos/core/ability/AbilityInfo;", "getInfo", "()Lcom/stepos/core/ability/AbilityInfo;", "Lcom/stepos/core/data/base/Content;", "input", "Lcom/stepos/core/deepbinder/IInferenceStreamCallback;", "callback", "infer", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/deepbinder/IInferenceStreamCallback;)V", "", "inferSync", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;Lcom/stepos/core/deepbinder/IInferenceStreamCallback;)I", "action", "params", "execute", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)Lcom/stepos/core/data/base/Content;", "feedInput", "(Ljava/lang/String;Lcom/stepos/core/data/base/Content;)V", "completeInput", "(Ljava/lang/String;)V", "listenerId", "Lcom/stepos/core/deepbinder/IModelChangeListener;", "listener", "registerModelChangeListener", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IModelChangeListener;)V", "unregisterModelChangeListener", "Lcom/stepos/core/deepbinder/IReleaseListener;", "registerReleaseListener", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IReleaseListener;)V", "unregisterReleaseListener", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ValidityCheck
/* loaded from: classes3.dex */
public interface IAbilityDeepBinderService {
    boolean acquire();

    boolean cancel();

    boolean cancelInfer(String inferId);

    void completeInput(String inferId);

    Content execute(String action, Content params);

    @Oneway
    void feedInput(String inferId, Content input);

    AbilityInfo getInfo();

    @Oneway
    void infer(String inferId, Content input, IInferenceStreamCallback callback);

    int inferSync(String inferId, Content input, IInferenceStreamCallback callback);

    void registerModelChangeListener(String listenerId, IModelChangeListener listener);

    void registerReleaseListener(String listenerId, IReleaseListener listener);

    void release();

    void unregisterModelChangeListener(String listenerId);

    void unregisterReleaseListener(String listenerId);
}
