package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChoreographerTaskRunner.java */
/* JADX INFO: loaded from: classes4.dex */
final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Choreographer f37748a;

    c(Choreographer r1) {
        this.f37748a = r1;
    }

    @Override // com.ttnet.org.chromium.base.task.k
    public void a(Runnable r3, long r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f37748a.postFrameCallbackDelayed(new ChoreographerTaskRunner$2(this, r5), r4);
    }
}
