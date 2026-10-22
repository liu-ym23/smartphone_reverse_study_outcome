package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class SmartBindService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceConnection f31812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f31813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f31814d;

    public SmartBindService(Context r3, ServiceConnection r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        this.f31811a = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f31812b = r8;
        this.f31813c = r5;
        this.f31814d = r6;
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public void smartBindToService() {
        Context r0 = this.f31811a;
        List<ResolveInfo> r1 = r0.getPackageManager().queryIntentServices(new Intent(this.f31813c), 0);
        if (r1 == null) goto L10;
        Iterator<ResolveInfo> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r2.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo.packageName;
        if (r3.equals(r0.getPackageName()) == true) goto L6;
    L11:
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("SmartBindService", "findExternalHostPackage: " + r3);
        if (r3 == null) goto L20;
        Intent r5 = new Intent(this.f31813c);
        r5.setPackage(r3);
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("SmartBindService", "bindToRemoteService: pkg=" + r3 + ", bound=" + ZeusTransformUtils.bindService(this.f31811a, r5, this.f31812b, 1, "com.obric.aiagent.plugin"));     // Catch: Exception -> L16 SecurityException -> L18
    L42:
        return;
    L18:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SmartBindService", "bindToRemoteService: Permission denied", e);
        return;
    L16:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SmartBindService", "bindToRemoteService: Failed to bind", e);
        return;
    L20:
        String r4 = this.f31814d;
        if (r4 != null) goto L23;
    L30:
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SmartBindService", "Local Service Class Name is null or empty, cannot start.");
        return;
    L23:
        if (r4.isEmpty() == true) goto L30;
        ComponentName r6 = new ComponentName(this.f31811a.getPackageName(), this.f31814d);
        Intent r7 = new Intent();
        r7.setComponent(r6);
        r7.setAction(this.f31813c);
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("SmartBindService", "startAndBindLocalService: bindService called, bound=" + ZeusTransformUtils.bindService(this.f31811a, r7, this.f31812b, 1, "com.obric.aiagent.plugin"));     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SmartBindService", "Failed to start/bind local service: " + this.f31814d, e);
        return;
    L10:
        r3 = null;
        goto L11
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_cae_libs_utils_SmartBindService_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
