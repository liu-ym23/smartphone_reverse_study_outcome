package com.obric.aiagent.product.platform.impl.app;

import android.app.AssistantActivityManager;
import android.app.IAssistantAutoVirtualDisplayRecordSetListener;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AssistantAutoVirtualDisplayRecordSetOfficialApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AssistantAutoVirtualDisplayRecordSetOfficialApi implements e {
    public static final AssistantAutoVirtualDisplayRecordSetOfficialApi INSTANCE = null;
    private static volatile IAssistantAutoVirtualDisplayRecordSetListener retainedAdapter;
    private static volatile ObricAutoVirtualDisplayRecordSetListener retainedListener;

    static {
        INSTANCE = new AssistantAutoVirtualDisplayRecordSetOfficialApi();
    }

    private AssistantAutoVirtualDisplayRecordSetOfficialApi() {
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public long begin(int r2, int r3, ObricAutoVirtualDisplayRecordSetListener r4) {
        o.e(r4, "listener");
        return AssistantActivityManager.beginAutoVirtualDisplayRecordSet(r2, r3, getOrCreateAdapter(r4));
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public boolean add(long r1, String[] r3) {
        o.e(r3, "packageNames");
        return AssistantActivityManager.addAutoVirtualDisplayRecordPackages(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public void end(long r1) {
        AssistantActivityManager.endAutoVirtualDisplayRecordSet(r1);
    }

    private final IAssistantAutoVirtualDisplayRecordSetListener getOrCreateAdapter(final ObricAutoVirtualDisplayRecordSetListener r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (retainedListener != r3) goto L8;
        IAssistantAutoVirtualDisplayRecordSetListener r0 = retainedAdapter;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        IAssistantAutoVirtualDisplayRecordSetListener.Stub r1 = new AssistantAutoVirtualDisplayRecordSetOfficialApi$getOrCreateAdapter$1$2(r3);     // Catch: Throwable -> L11
        retainedListener = r3;     // Catch: Throwable -> L11
        retainedAdapter = (IAssistantAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAutoVirtualDisplayRecordSetListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r0 = (IAssistantAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IAssistantAutoVirtualDisplayRecordSetListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        goto L9
    }
}
