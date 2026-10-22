package com.obric.aiagent.product.platform.impl.app;

import android.app.IObricAutoVirtualDisplayRecordSetListener;
import android.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ObricAutoVirtualDisplayRecordSetOfficialApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricAutoVirtualDisplayRecordSetOfficialApi implements e {
    public static final ObricAutoVirtualDisplayRecordSetOfficialApi INSTANCE = null;
    private static volatile IObricAutoVirtualDisplayRecordSetListener retainedAdapter;
    private static volatile ObricAutoVirtualDisplayRecordSetListener retainedListener;

    static {
        INSTANCE = new ObricAutoVirtualDisplayRecordSetOfficialApi();
    }

    private ObricAutoVirtualDisplayRecordSetOfficialApi() {
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public long begin(int r2, int r3, ObricAutoVirtualDisplayRecordSetListener r4) {
        o.e(r4, "listener");
        return ObricActivityManager.beginAutoVirtualDisplayRecordSet(r2, r3, getOrCreateAdapter(r4));
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public boolean add(long r1, String[] r3) {
        o.e(r3, "packageNames");
        return ObricActivityManager.addAutoVirtualDisplayRecordPackages(r1, r3);
    }

    @Override // com.obric.aiagent.product.platform.impl.app.e
    public void end(long r1) {
        ObricActivityManager.endAutoVirtualDisplayRecordSet(r1);
    }

    private final IObricAutoVirtualDisplayRecordSetListener getOrCreateAdapter(final ObricAutoVirtualDisplayRecordSetListener r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (retainedListener != r3) goto L8;
        IObricAutoVirtualDisplayRecordSetListener r0 = retainedAdapter;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        IObricAutoVirtualDisplayRecordSetListener.Stub r1 = new ObricAutoVirtualDisplayRecordSetOfficialApi$getOrCreateAdapter$1$2(r3);     // Catch: Throwable -> L11
        retainedListener = r3;     // Catch: Throwable -> L11
        retainedAdapter = (IObricAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IObricAutoVirtualDisplayRecordSetListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r0 = (IObricAutoVirtualDisplayRecordSetListener) ZeusTransformUtils.preCheckCast(r1, IObricAutoVirtualDisplayRecordSetListener.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        goto L9
    }
}
