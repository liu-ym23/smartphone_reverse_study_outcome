package com.stepos.ability.api.ability.runtime;

import com.stepos.ability.beaninternal.ability.AbilityTask;
import com.stepos.ability.commoninternal.ability.IComponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/ability/runtime/IRuntimeManager;", "Lcom/stepos/ability/commoninternal/ability/IComponent;", "LC7/r;", "saveRuntimeState", "()V", "Lcom/stepos/ability/beaninternal/ability/AbilityTask;", "task", "submit", "(Lcom/stepos/ability/beaninternal/ability/AbilityTask;)V", "cancel", "cleanUp", "pause", "resume", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IRuntimeManager extends IComponent {
    void cancel(AbilityTask task);

    void cleanUp();

    void pause();

    void resume();

    void saveRuntimeState();

    void submit(AbilityTask task);
}
