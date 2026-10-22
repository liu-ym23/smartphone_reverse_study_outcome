package com.obric.capabilitykit.common.intent;

import android.graphics.Bitmap;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: BaseSystemScreenshotIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public class BaseSystemScreenshotIntent implements IntentFunction<SystemScreenshotParams, Bitmap> {
    private final String name;

    public BaseSystemScreenshotIntent() {
        this.name = "System_Screenshot";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r1) {
        return IntentFunction.a.a(this, r1);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Bitmap>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Bitmap>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemScreenshotParams) ZeusTransformUtils.preCheckCast(r6, SystemScreenshotParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    public Object doAction(SystemScreenshotParams r3, DispatchContext r4, d<? super IntentResult<Bitmap>> r5) {
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
