package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: BaseRecorderDeleteIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class BaseRecorderDeleteIntent implements IntentFunction<RecorderDeleteParams, RecordingEntity[]> {
    private final String name;

    public BaseRecorderDeleteIntent() {
        this.name = "Recorder_Delete";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r1) {
        return IntentFunction.a.a(this, r1);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<RecordingEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<RecordingEntity[]>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((RecorderDeleteParams) ZeusTransformUtils.preCheckCast(r6, RecorderDeleteParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    public Object doAction(RecorderDeleteParams r3, DispatchContext r4, d<? super IntentResult<RecordingEntity[]>> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return IntentFunction.a.a(this, (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.aiagent.plugin"), r4, r6);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return IntentFunction.a.a(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public Boolean isTaskOnGoing(DispatchContext r1) {
        return IntentFunction.a.a(this, r1);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public final String getName() {
        return this.name;
    }
}
