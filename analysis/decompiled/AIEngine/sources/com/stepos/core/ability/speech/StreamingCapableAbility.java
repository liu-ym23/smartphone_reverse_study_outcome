package com.stepos.core.ability.speech;

import com.stepos.core.callback.IInferenceCallback;
import com.stepos.core.common.telemetry.PowerPerfTracker;
import com.stepos.core.data.ContentParams;
import com.stepos.core.model.task.AITaskRecord;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface StreamingCapableAbility {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ AsrCloudWsSession createCloudWsSession$default(StreamingCapableAbility streamingCapableAbility, String str, String str2, ContentParams contentParams, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createCloudWsSession");
            }
            if ((i10 & 1) != 0) {
                str = null;
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                contentParams = null;
            }
            return streamingCapableAbility.createCloudWsSession(str, str2, contentParams);
        }

        public static /* synthetic */ void registerLocalStreamingSession$default(StreamingCapableAbility streamingCapableAbility, String str, IInferenceCallback iInferenceCallback, int i10, zb.a aVar, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerLocalStreamingSession");
            }
            if ((i11 & 16) != 0) {
                powerPerfTracker = null;
            }
            if ((i11 & 32) != 0) {
                aITaskRecord = null;
            }
            streamingCapableAbility.registerLocalStreamingSession(str, iInferenceCallback, i10, aVar, powerPerfTracker, aITaskRecord);
        }
    }

    long cloudCloseAckTimeoutMs();

    AsrCloudWsSession createCloudWsSession(String str, String str2, ContentParams contentParams);

    Object ensureLocalReady(qb.b<? super Boolean> bVar);

    void registerLocalStreamingSession(String str, IInferenceCallback iInferenceCallback, int i10, zb.a<lb.n> aVar, PowerPerfTracker powerPerfTracker, AITaskRecord aITaskRecord);

    String requireCloudSceneType(String str);

    Object resolveStreamingDecision(ContentParams contentParams, qb.b<? super h7.e> bVar);

    p6.i segmentationConfig();
}
