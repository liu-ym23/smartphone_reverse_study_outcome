package com.android.server.devicestate;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Dumpable;
import com.android.server.policy.DeviceStatePolicyImpl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceStatePolicy implements Dumpable {
    protected final Context mContext;

    static final class DefaultProvider implements Provider {
        DefaultProvider() {
        }

        @Override // com.android.server.devicestate.DeviceStatePolicy.Provider
        public DeviceStatePolicy instantiate(Context context) {
            return new DeviceStatePolicyImpl(context);
        }
    }

    public interface Provider {
        DeviceStatePolicy instantiate(Context r1);

        static Provider fromResources(Resources res) {
            String name = res.getString(R.string.config_misprovisionedBrandValue);
            if (TextUtils.isEmpty(name) == true) goto L5;
            return (Provider) Class.forName(name).newInstance();
        L8:
            e = move-exception;
            throw new IllegalStateException("Couldn't instantiate class " + name + " for config_deviceSpecificDeviceStatePolicyProvider: make sure it has a public zero-argument constructor and implements DeviceStatePolicy.Provider", e);
        L5:
            return new DefaultProvider();
        }
    }

    public abstract void configureDeviceForState(int r1, Runnable r2);

    public abstract DeviceStateProvider getDeviceStateProvider();

    protected DeviceStatePolicy(Context context) {
        this.mContext = context;
    }
}
