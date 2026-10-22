package com.stepos.ability.task.executor;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ability/task/executor/ExecutorInit;", "Lcom/stepos/ability/api/init/IInit;", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "executor_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExecutorInit implements IInit {
    @Inject
    public ExecutorInit() {
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        k.f(context, "context");
        e.v((Application) context, null);
    }
}
