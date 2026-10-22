package com.bytedance.server.oms;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.android.server.SystemService;
import com.bytedance.internal.oms.connector.MonitoredBinderWrapper;
import com.bytedance.internal.oms.connector.OmsFrameworkMonitor;
import com.bytedance.os.oms.connector.DisconnectStrategy;
import com.bytedance.os.oms.connector.DisconnectStrategyManager;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OceanMobileSystemService<I extends IInterface> extends SystemService {
    private static final String TAG = "OceanMobileService";
    private OceanMobileBackendConnector<I> mBackendConnector;
    private DisconnectStrategyManager mDisconnectStrategies;

    protected abstract OceanMobileBackendConnector<I> createBackendConnector(Context r1);

    protected abstract IBinder createBinderService();

    protected abstract List<DisconnectStrategy> createDisconnectStrategies();

    protected abstract Class<?> getBinderStubClass();

    protected abstract String getOmsServiceName();

    protected OceanMobileSystemService(Context context) {
        super(context);
    }

    @Override // com.android.server.SystemService
    public final void onStart() {
        this.mBackendConnector = createBackendConnector(getContext());
        this.mDisconnectStrategies = new DisconnectStrategyManager(this.mBackendConnector, getContext(), createDisconnectStrategies(), new OceanMobileSystemService$$ExternalSyntheticLambda0(this));
        this.mDisconnectStrategies.install();
        IBinder binder = createBinderService();
        publishBinderService(getOmsServiceName(), MonitoredBinderWrapper.wrap(binder, getOmsServiceName(), getContext(), getBinderStubClass()));
        OmsFrameworkMonitor.log(getOmsServiceName(), 4, TAG, "Published OMS service " + getOmsServiceName(), null);
        onOmsServiceStarted();
    }

    protected void onOmsServiceStarted() {
    }

    protected boolean shouldKeepBackendConnected() {
        return false;
    }

    protected final OceanMobileBackendConnector<I> getBackendConnector() {
        if (this.mBackendConnector == null) goto L7;
        return this.mBackendConnector;
    L7:
        throw new IllegalStateException(getOmsServiceName() + " backend not started");
    }
}
