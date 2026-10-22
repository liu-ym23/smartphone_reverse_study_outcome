package com.obric.aiagent.apm;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.apm.impl.b;
import com.obric.aiagent.apm.impl.c;
import com.obric.aiagent.apm.impl.e;
import com.obric.aiagent.apm.impl.g;
import com.obric.aiagent.apm.log.ALogCommonInst;
import com.obric.aiagent.apm.log.ALogSecureInst;
import com.obric.aiagent.apm.log.AndroidLogcatInst;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ApmImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApmImpl implements IApm {
    public static final a Companion = null;
    private static final String TAG = "ApmImpl";
    private long observeId;

    /* JADX INFO: compiled from: ApmImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ void lambda$DDC68fPaP6tGE129sXAlI5H4wPQ(ApmImpl r0, com.obric.aiagent.apm.a r1, String r2, SharedValue r3) {
        initLog$lambda$0(r0, r1, r2, r3);
    }

    public ApmImpl() {
    }

    @Override // com.obric.aiagent.apm.IApm
    public void initLog(final com.obric.aiagent.apm.a r6) {
        o.e(r6, "config");
        ILogDepend.Companion.i(TAG, "initLog " + r6);
        String r0 = SharedState.INSTANCE.getString("doubao_channel", "");
        INVOKESTATIC_com_obric_aiagent_apm_ApmImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "initLog " + r6 + ", channel = " + r0);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        initLogInternal(r6, r0);
        return;
    L8:
        this.observeId = SharedState.INSTANCE.registerObserver(p.a("doubao_channel"), new $$Lambda$ApmImpl$DDC68fPaP6tGE129sXAlI5H4wPQ(this, r6));
        return;
    L5:
        r2 = false;
        goto L6
    }

    private static final void initLog$lambda$0(ApmImpl r5, com.obric.aiagent.apm.a r6, String r7, SharedValue r8) {
        SharedValue r9 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r8, SharedValue.class, "com.obric.aiagent.plugin");
        o.e(r7, "key");
        o.e(r9, "value");
        if (o.a(r7, "doubao_channel") == false) goto L8;
        boolean r10 = p.a((Iterable) ZeusTransformUtils.preCheckCast(ax.a(new String[]{"debug", "local_test", "auto_test"}), Iterable.class, "com.obric.aiagent.plugin"), r9.getValue());
        ILogDepend.Companion.i(TAG, "initLog obtained channel = " + r9 + ", isTestChannel = " + r10);
        INVOKESTATIC_com_obric_aiagent_apm_ApmImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "initLog obtained channel = " + r9 + ", isTestChannel = " + r10);
        r5.initLogInternal(r6, r9.toString());
        if (r5.observeId == 0) goto L9;
        ILogDepend.Companion.i(TAG, "unregisterObserver " + r5.observeId);
        SharedState.INSTANCE.unregisterObserver(r5.observeId);
        return;
    L9:
        return;
    }

    private final void initLogInternal(com.obric.aiagent.apm.a r3, String r4) {
        boolean r2 = ax.a(new String[]{"debug", "local_test", "auto_test"}).contains(r4);
        INVOKESTATIC_com_obric_aiagent_apm_ApmImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "initLogInternal " + r3 + ", channel = " + r4 + ", isTestChannel = " + r2);
        new com.obric.aiagent.apm.a(r2, r3.b(), r3.c());
        ALogSecureInst.INSTANCE.init(r3);
        ALogCommonInst.INSTANCE.init(r3);
        AndroidLogcatInst.INSTANCE.init(r3.a());
    }

    @Override // com.obric.aiagent.apm.IApm
    public void initRepato() {
        g.f16116a.a();
    }

    @Override // com.obric.aiagent.apm.IApm
    public void initApm() {
        b.f16107a.a();
    }

    @Override // com.obric.aiagent.apm.IApm
    public void initCloudMessage() {
        c.f16110a.a();
    }

    @Override // com.obric.aiagent.apm.IApm
    public void initNpth() {
        e.f16113a.a();
    }

    @Override // com.obric.aiagent.apm.IApm
    public void putExtra(String r1, String r2) {
        o.e(r1, "key");
        o.e(r2, "value");
        e.f16113a.a(r1, r2);
        b.f16107a.a(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_apm_ApmImpl_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
