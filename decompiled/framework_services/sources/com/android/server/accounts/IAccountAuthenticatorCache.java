package com.android.server.accounts;

import android.accounts.AuthenticatorDescription;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.RegisteredServicesCacheListener;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface IAccountAuthenticatorCache {
    void dump(FileDescriptor r1, PrintWriter r2, String[] r3, int r4);

    Collection<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> getAllServices(int r1);

    boolean getBindInstantServiceAllowed(int r1);

    RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> getServiceInfo(AuthenticatorDescription r1, int r2);

    void invalidateCache(int r1);

    void setBindInstantServiceAllowed(int r1, boolean r2);

    void setListener(RegisteredServicesCacheListener<AuthenticatorDescription> r1, Handler r2);

    void updateServices(int r1);
}
