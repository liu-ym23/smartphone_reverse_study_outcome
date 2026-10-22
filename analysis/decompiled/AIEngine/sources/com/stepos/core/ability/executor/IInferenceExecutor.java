package com.stepos.core.ability.executor;

import com.stepos.core.ability.handler.IResultHandler;
import com.stepos.core.data.base.Content;
import com.stepos.core.model.task.AITaskRecord;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.Job;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IInferenceExecutor {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static boolean cancel(IInferenceExecutor iInferenceExecutor, String requestId) {
            g.f(requestId, "requestId");
            return false;
        }
    }

    boolean cancel(String str);

    Job execute(String str, Content content, IResultHandler iResultHandler, AITaskRecord aITaskRecord);

    Job execute(String str, Content content, IResultHandler iResultHandler, AITaskRecord aITaskRecord, zb.a<n> aVar);

    void execute(String str, Content content, IResultHandler iResultHandler);

    void release();
}
