package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: BaseSystemDownloadAppIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class BaseSystemDownloadAppIntent implements IntentFunction<SystemDownloadAppParams, AppInfoEntity[]> {
    private final String name;

    public BaseSystemDownloadAppIntent() {
        this.name = "System_DownloadApp";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r1) {
        return IntentFunction.a.a(this, r1);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<AppInfoEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<AppInfoEntity[]>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemDownloadAppParams) ZeusTransformUtils.preCheckCast(r6, SystemDownloadAppParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    public Object doAction(SystemDownloadAppParams r3, DispatchContext r4, d<? super IntentResult<AppInfoEntity[]>> r5) {
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
