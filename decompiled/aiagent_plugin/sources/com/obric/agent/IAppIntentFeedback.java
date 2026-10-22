package com.obric.agent;

import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.funcall_api.bean.IntentAppAction;

/* JADX INFO: compiled from: IAppIntentFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IAppIntentFeedback {
    void addActionFinishedListener(f r1);

    void addActionProcessedResultListener(b r1);

    void addLocalActionFinishedListener(f r1);

    void notifyActionFinished(IntentAppAction r1, JobResult r2);

    void notifyActionProcessedResult(IntentAppAction r1, IntentAppAction r2, boolean r3);

    void removeActionFinishedListener(f r1);

    void removeActionProcessedResultListener(b r1);
}
