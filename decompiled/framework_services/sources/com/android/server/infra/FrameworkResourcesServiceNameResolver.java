package com.android.server.infra;

import android.content.Context;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class FrameworkResourcesServiceNameResolver extends ServiceNameBaseResolver {
    private final int mArrayResourceId;
    private final int mStringResourceId;

    public FrameworkResourcesServiceNameResolver(Context context, int resourceId) {
        super(context, false);
        this.mStringResourceId = resourceId;
        this.mArrayResourceId = -1;
    }

    public FrameworkResourcesServiceNameResolver(Context context, int resourceId, boolean isMultiple) {
        super(context, isMultiple);
        if (isMultiple == false) goto L7;
        this.mStringResourceId = -1;
        this.mArrayResourceId = resourceId;
        return;
    L7:
        throw new UnsupportedOperationException("Please use FrameworkResourcesServiceNameResolver(context, @StringRes int) constructor if single service mode is requested.");
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver
    public String[] readServiceNameList(int userId) {
        return this.mContext.getResources().getStringArray(this.mArrayResourceId);
    }

    @Override // com.android.server.infra.ServiceNameBaseResolver
    public String readServiceName(int userId) {
        return this.mContext.getResources().getString(this.mStringResourceId);
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void dumpShort(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print("FrameworkResourcesServiceNamer: resId=");     // Catch: Throwable -> L7
        pw.print(this.mStringResourceId);     // Catch: Throwable -> L7
        pw.print(", numberTemps=");     // Catch: Throwable -> L7
        pw.print(this.mTemporaryServiceNamesList.size());     // Catch: Throwable -> L7
        pw.print(", enabledDefaults=");     // Catch: Throwable -> L7
        pw.print(this.mDefaultServicesDisabled.size());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
