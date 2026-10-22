package com.android.server.appfunctions;

import android.provider.DeviceConfig;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConfigImpl implements ServiceConfig {
    static final long DEFAULT_EXECUTE_APP_FUNCTION_CANCELLATION_TIMEOUT_MS = 5000;
    static final String DEVICE_CONFIG_PROPERTY_EXECUTION_CANCELLATION_TIMEOUT = "execute_app_function_cancellation_timeout_millis";

    public ServiceConfigImpl() {
    }

    @Override // com.android.server.appfunctions.ServiceConfig
    public long getExecuteAppFunctionCancellationTimeoutMillis() {
        return DeviceConfig.getLong(ServiceConfig.NAMESPACE_APP_FUNCTIONS, DEVICE_CONFIG_PROPERTY_EXECUTION_CANCELLATION_TIMEOUT, DEFAULT_EXECUTE_APP_FUNCTION_CANCELLATION_TIMEOUT_MS);
    }
}
