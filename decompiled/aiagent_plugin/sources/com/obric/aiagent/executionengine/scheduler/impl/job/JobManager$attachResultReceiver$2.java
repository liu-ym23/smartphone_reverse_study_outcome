package com.obric.aiagent.executionengine.scheduler.impl.job;

import android.os.IBinder;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import java.util.List;

/* JADX INFO: compiled from: JobManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JobManager$attachResultReceiver$2 implements IBinder.DeathRecipient {
    final /* synthetic */ ICapabilityFeedbackReceiver $newReceiver;
    final /* synthetic */ String $packageName;

    public static /* synthetic */ boolean lambda$DbHdpuav6GqSJUXKRqkYKY8cMpI(ICapabilityFeedbackReceiver r0, m r1) {
        return binderDied$lambda$1$lambda$0(r0, r1);
    }

    JobManager$attachResultReceiver$2(ICapabilityFeedbackReceiver r3, String r4) {
        this.$newReceiver = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        this.$packageName = r4;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        IBinder r0 = this.$newReceiver.asBinder();
        if (r0 == null) goto L5;
        r0.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);
    L5:
        d r1 = d.f18489a;
        String r2 = this.$packageName;
        final ICapabilityFeedbackReceiver r6 = this.$newReceiver;
        monitor-enter(r1);
        ILogDepend.Companion.i("JobManager", "resultReceiver binderDied:" + r2);     // Catch: Throwable -> L10
        p.a((List) ZeusTransformUtils.preCheckCast(d.g(), List.class, "com.obric.aiagent.plugin"), new $$Lambda$JobManager$attachResultReceiver$2$DbHdpuav6GqSJUXKRqkYKY8cMpI(r6));     // Catch: Throwable -> L10
        monitor-exit(r1);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static final boolean binderDied$lambda$1$lambda$0(ICapabilityFeedbackReceiver r2, m r3) {
        ICapabilityFeedbackReceiver r4 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r2, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        return o.a(r3.b(), r4);
    }
}
