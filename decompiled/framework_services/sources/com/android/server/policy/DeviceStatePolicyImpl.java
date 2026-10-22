package com.android.server.policy;

import android.content.Context;
import com.android.server.devicestate.DeviceStatePolicy;
import com.android.server.devicestate.DeviceStateProvider;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStatePolicyImpl extends DeviceStatePolicy {
    private final DeviceStateProvider mProvider;

    public DeviceStatePolicyImpl(Context context) {
        super(context);
        this.mProvider = DeviceStateProviderImpl.create(this.mContext);
    }

    @Override // com.android.server.devicestate.DeviceStatePolicy
    public DeviceStateProvider getDeviceStateProvider() {
        return this.mProvider;
    }

    @Override // com.android.server.devicestate.DeviceStatePolicy
    public void configureDeviceForState(int state, Runnable onComplete) {
        onComplete.run();
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter writer, String[] args) {
        this.mProvider.dump(writer, args);
    }
}
