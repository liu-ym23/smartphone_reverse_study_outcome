package com.android.server.pm.resolution;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedProvider;
import com.android.internal.pm.pkg.component.ParsedService;
import com.android.server.pm.Computer;
import com.android.server.pm.DumpState;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ComponentResolverApi {
    boolean componentExists(ComponentName r1);

    void dumpActivityResolvers(PrintWriter r1, DumpState r2, String r3);

    void dumpContentProviders(Computer r1, PrintWriter r2, DumpState r3, String r4);

    void dumpProviderResolvers(PrintWriter r1, DumpState r2, String r3);

    void dumpReceiverResolvers(PrintWriter r1, DumpState r2, String r3);

    void dumpServicePermissions(PrintWriter r1, DumpState r2);

    void dumpServiceResolvers(PrintWriter r1, DumpState r2, String r3);

    ParsedActivity getActivity(ComponentName r1);

    ParsedProvider getProvider(ComponentName r1);

    ParsedActivity getReceiver(ComponentName r1);

    ParsedService getService(ComponentName r1);

    boolean isActivityDefined(ComponentName r1);

    List<ResolveInfo> queryActivities(Computer r1, Intent r2, String r3, long r4, int r6);

    List<ResolveInfo> queryActivities(Computer r1, Intent r2, String r3, long r4, List<ParsedActivity> r6, int r7);

    ProviderInfo queryProvider(Computer r1, String r2, long r3, int r5);

    List<ResolveInfo> queryProviders(Computer r1, Intent r2, String r3, long r4, int r6);

    List<ResolveInfo> queryProviders(Computer r1, Intent r2, String r3, long r4, List<ParsedProvider> r6, int r7);

    List<ProviderInfo> queryProviders(Computer r1, String r2, String r3, int r4, long r5, int r7);

    List<ResolveInfo> queryReceivers(Computer r1, Intent r2, String r3, long r4, int r6);

    List<ResolveInfo> queryReceivers(Computer r1, Intent r2, String r3, long r4, List<ParsedActivity> r6, int r7);

    List<ResolveInfo> queryServices(Computer r1, Intent r2, String r3, long r4, int r6);

    List<ResolveInfo> queryServices(Computer r1, Intent r2, String r3, long r4, List<ParsedService> r6, int r7);

    void querySyncProviders(Computer r1, List<String> r2, List<ProviderInfo> r3, boolean r4, int r5);
}
