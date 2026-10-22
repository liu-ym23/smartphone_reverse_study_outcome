package com.obric.autogui.common.api.cocreation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOmniLabelingDataSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IOmniLabelingDataSink {

    /* JADX INFO: compiled from: IOmniLabelingDataSink.kt */
    public static final class DefaultImpls {
        public static void onUserStopped(IOmniLabelingDataSink r2, OmniLabelingUserStopRecord r3) {
            IOmniLabelingDataSink r4 = (IOmniLabelingDataSink) ZeusTransformUtils.wrapperContextForParams(r2, IOmniLabelingDataSink.class, "com.obric.aiagent.plugin");
            o.e(r3, "record");
        }
    }

    void onStepLogged(OmniLabelingStepRecord r1);

    void onUserStopped(OmniLabelingUserStopRecord r1);
}
