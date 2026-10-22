package com.android.server.infra;

import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ServiceNameResolver {

    public interface NameResolverListener {
        void onNameResolved(int r1, String r2, boolean r3);
    }

    void dumpShort(PrintWriter r1);

    void dumpShort(PrintWriter r1, int r2);

    String getDefaultServiceName(int r1);

    default void setOnTemporaryServiceNameChangedCallback(NameResolverListener callback) {
    }

    default String[] getDefaultServiceNameList(int userId) {
        if (isConfiguredInMultipleMode() == true) goto L7;
        return new String[]{getDefaultServiceName(userId)};
    L7:
        throw new UnsupportedOperationException("getting default service list not supported");
    }

    default void setServiceNameList(List<String> services, int userId) {
    }

    default boolean isConfiguredInMultipleMode() {
        return false;
    }

    default String getServiceName(int userId) {
        return getDefaultServiceName(userId);
    }

    default String[] getServiceNameList(int userId) {
        return getDefaultServiceNameList(userId);
    }

    default boolean isTemporary(int userId) {
        return false;
    }

    default void setTemporaryService(int userId, String componentName, int durationMs) {
        throw new UnsupportedOperationException("temporary user not supported");
    }

    default void setTemporaryServices(int userId, String[] componentNames, int durationMs) {
        throw new UnsupportedOperationException("temporary user not supported");
    }

    default void resetTemporaryService(int userId) {
        throw new UnsupportedOperationException("temporary user not supported");
    }

    default boolean setDefaultServiceEnabled(int userId, boolean enabled) {
        throw new UnsupportedOperationException("changing default service not supported");
    }

    default boolean isDefaultServiceEnabled(int userId) {
        throw new UnsupportedOperationException("checking default service not supported");
    }
}
