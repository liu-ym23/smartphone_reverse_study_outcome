package com.android.server.credentials.metrics;

import android.util.Slog;
import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum ApiName extends Enum<ApiName> {
    private static final /* synthetic */ ApiName[] $VALUES = null;
    public static final ApiName CLEAR_CREDENTIAL = null;
    public static final ApiName CREATE_CREDENTIAL = null;
    public static final ApiName GET_CREDENTIAL = null;
    public static final ApiName GET_CREDENTIAL_PROVIDER_SERVICES = null;
    public static final ApiName GET_CREDENTIAL_VIA_REGISTRY = null;
    public static final ApiName IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE = null;
    public static final ApiName REGISTER_CREDENTIAL_DESCRIPTION = null;
    public static final ApiName SET_ENABLED_PROVIDERS = null;
    private static final String TAG = "ApiName";
    public static final ApiName UNKNOWN = null;
    public static final ApiName UNREGISTER_CREDENTIAL_DESCRIPTION = null;
    private static final Map<String, Integer> sRequestInfoToMetric = null;
    private final int mInnerMetricCode;

    private static /* synthetic */ ApiName[] $values() {
        return new ApiName[]{UNKNOWN, GET_CREDENTIAL, GET_CREDENTIAL_VIA_REGISTRY, CREATE_CREDENTIAL, CLEAR_CREDENTIAL, IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE, SET_ENABLED_PROVIDERS, GET_CREDENTIAL_PROVIDER_SERVICES, REGISTER_CREDENTIAL_DESCRIPTION, UNREGISTER_CREDENTIAL_DESCRIPTION};
    }

    public static ApiName valueOf(String name) {
        return (ApiName) Enum.valueOf(ApiName.class, name);
    }

    public static ApiName[] values() {
        return (ApiName[]) $VALUES.clone();
    }

    static {
        UNKNOWN = new ApiName("UNKNOWN", 0, 0);
        GET_CREDENTIAL = new ApiName("GET_CREDENTIAL", 1, 1);
        GET_CREDENTIAL_VIA_REGISTRY = new ApiName("GET_CREDENTIAL_VIA_REGISTRY", 2, 9);
        CREATE_CREDENTIAL = new ApiName("CREATE_CREDENTIAL", 3, 2);
        CLEAR_CREDENTIAL = new ApiName("CLEAR_CREDENTIAL", 4, 3);
        IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE = new ApiName("IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE", 5, 4);
        SET_ENABLED_PROVIDERS = new ApiName("SET_ENABLED_PROVIDERS", 6, 5);
        GET_CREDENTIAL_PROVIDER_SERVICES = new ApiName("GET_CREDENTIAL_PROVIDER_SERVICES", 7, 6);
        REGISTER_CREDENTIAL_DESCRIPTION = new ApiName("REGISTER_CREDENTIAL_DESCRIPTION", 8, 7);
        UNREGISTER_CREDENTIAL_DESCRIPTION = new ApiName("UNREGISTER_CREDENTIAL_DESCRIPTION", 9, 8);
        $VALUES = $values();
        sRequestInfoToMetric = Map.ofEntries(new Map.Entry[]{new AbstractMap.SimpleEntry("android.credentials.selection.TYPE_CREATE", Integer.valueOf(CREATE_CREDENTIAL.mInnerMetricCode)), new AbstractMap.SimpleEntry("android.credentials.selection.TYPE_GET", Integer.valueOf(GET_CREDENTIAL.mInnerMetricCode)), new AbstractMap.SimpleEntry("android.credentials.selection.TYPE_GET_VIA_REGISTRY", Integer.valueOf(GET_CREDENTIAL_VIA_REGISTRY.mInnerMetricCode)), new AbstractMap.SimpleEntry("android.credentials.selection.TYPE_UNDEFINED", Integer.valueOf(CLEAR_CREDENTIAL.mInnerMetricCode))});
    }

    private ApiName(String r1, int r2, int innerMetricCode) {
        super(r1, r2);
        this.mInnerMetricCode = innerMetricCode;
    }

    public int getMetricCode() {
        return this.mInnerMetricCode;
    }

    public static int getMetricCodeFromRequestInfo(String stringKey) {
        if (sRequestInfoToMetric.containsKey(stringKey) == true) goto L7;
        Slog.i(TAG, "Attempted to use an unsupported string key request info");
        return UNKNOWN.mInnerMetricCode;
    L7:
        return sRequestInfoToMetric.get(stringKey).intValue();
    }
}
