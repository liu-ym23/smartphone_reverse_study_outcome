package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbsTracer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.bytedance.apm.block.a implements c {
    private static final String TAG = "Matrix.AbsTracer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f4398a;

    @Override // com.bytedance.services.apm.api.d
    public void onActivityCreated(Activity r1, Bundle r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityPause(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityResume(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onActivityStarted(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onBackground(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onChange(Activity r1, Fragment r2) {
        Activity r0 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.services.apm.api.d
    public void onFront(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
    }

    public a() {
        this.f4398a = false;
    }
}
