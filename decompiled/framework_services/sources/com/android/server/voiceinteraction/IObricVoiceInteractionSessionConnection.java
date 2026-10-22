package com.android.server.voiceinteraction;

import com.android.server.wm.ActivityAssistInfo;
import com.obric.utils.IObricBase;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricVoiceInteractionSessionConnection extends IObricBase {
    default boolean forceAllowAssistDataRequest() {
        return false;
    }

    default boolean assistantExclude(List<ActivityAssistInfo> topActivities, int i) {
        return false;
    }
}
