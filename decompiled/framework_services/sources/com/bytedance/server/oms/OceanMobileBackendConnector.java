package com.bytedance.server.oms;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.bytedance.internal.oms.connector.InstrumentedServiceConnector;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OceanMobileBackendConnector<I extends IInterface> extends InstrumentedServiceConnector<I> {
    private final String mServiceName;

    protected OceanMobileBackendConnector(Context context, Intent intent, int flags, Function<IBinder, I> binderAsInterface, String serviceName) {
        super(context, intent, flags, 0, binderAsInterface);
        this.mServiceName = serviceName;
    }

    public final String getServiceName() {
        return this.mServiceName;
    }
}
