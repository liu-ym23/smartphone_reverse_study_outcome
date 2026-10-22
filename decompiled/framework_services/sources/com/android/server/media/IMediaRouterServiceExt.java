package com.android.server.media;

import android.prometheus.ext.core.ExtLoader;

/* JADX INFO: loaded from: classes2.dex */
public class IMediaRouterServiceExt {
    public static final String ERROR_BIND_FAILED = "BIND_FAILED";
    public static final String ERROR_INVALID_BINDER = "INVALID_BINDER";
    public static final String ERROR_INVALID_ROUTE_ID = "INVALID_ROUTE_ID";
    public static final String ERROR_INVALID_SESSION_ID = "INVALID_SESSION_ID";
    public static final String ERROR_MANAGER_RECORD_NOT_FOUND = "MANAGER_RECORD_NOT_FOUND";
    public static final String ERROR_PERMISSION_DENIED = "PERMISSION_DENIED";
    public static final String ERROR_ROUTER_RECORD_NOT_FOUND = "ROUTER_RECORD_NOT_FOUND";
    public static final String ERROR_SECURITY_EXCEPTION = "SECURITY_EXCEPTION";
    public static final String NODE_CREATE_SESSION = "mr2_create_session";
    public static final String NODE_DESELECT_ROUTE = "mr2_deselect_route";
    public static final String NODE_PROVIDER_BIND = "mr2_provider_bind";
    public static final String NODE_PROVIDER_BINDING_DIED = "mr2_provider_binding_died";
    public static final String NODE_PROVIDER_SERVICE_CONNECTED = "mr2_provider_service_connected";
    public static final String NODE_PROVIDER_SERVICE_DISCONNECTED = "mr2_provider_service_disconnected";
    public static final String NODE_PROVIDER_START = "mr2_provider_start";
    public static final String NODE_PROVIDER_STOP = "mr2_provider_stop";
    public static final String NODE_PROVIDER_UNBIND = "mr2_provider_unbind";
    public static final String NODE_RELEASE_SESSION = "mr2_release_session";
    public static final String NODE_SELECT_ROUTE = "mr2_select_route";
    public static final String NODE_TRANSFER_TO_ROUTE = "mr2_transfer_to_route";
    public static final int STATE_NONE = 0;
    public static final int STATE_PROVIDER_BOUND = 2;
    public static final int STATE_PROVIDER_CONNECTED = 3;
    public static final int STATE_PROVIDER_STARTED = 1;
    public static final int STATE_PROVIDER_STOPPED = 4;
    public static final int STATE_SESSION_CREATED = 2;
    public static final int STATE_SESSION_CREATING = 1;
    public static final int STATE_SESSION_NONE = 0;
    public static final int STATE_SESSION_RELEASED = 3;

    public static IMediaRouterServiceExt get(Object base) {
        return (IMediaRouterServiceExt) ExtLoader.get(IMediaRouterServiceExt.class, base);
    }

    public IMediaRouterServiceExt() {
    }

    public IMediaRouterServiceExt(Object base) {
    }

    public void start_onEnd(String component) {
    }

    public void stop_onEnd(String component) {
    }

    public void bind_onEnd(boolean bound, String component, Throwable ex) {
    }

    public void unbind_onEnd(String component) {
    }

    public void onServiceConnectedInternal_onEnd(boolean connected, String component, String errorType) {
    }

    public void onServiceDisconnectedInternal_onStart(String component) {
    }

    public void onBindingDiedInternal_onStart(String component) {
    }

    public void requestCreateSessionWithRouter2Locked_onStart(int state, int uid, int userId, String pkg, int routerId, String routeId, int requestId, long uniqueRequestId, long managerRequestId, boolean success, String errorType) {
    }

    public void selectRouteWithRouter2Locked_onStart(int state, int uid, int userId, String pkg, String uniqueSessionId, String routeId, int routerId, boolean success, String errorType) {
    }

    public void deselectRouteWithRouter2Locked_onStart(int state, int uid, int userId, String pkg, String uniqueSessionId, String routeId, int routerId, boolean success, String errorType) {
    }

    public void transferToRouteWithRouter2Locked_onStart(int state, int uid, int userId, String pkg, String uniqueSessionId, String routeId, int routerId, boolean success, String errorType) {
    }

    public void releaseSessionWithRouter2Locked_onStart(int state, int uid, int userId, String pkg, String uniqueSessionId, int routerId, boolean success, String errorType) {
    }
}
