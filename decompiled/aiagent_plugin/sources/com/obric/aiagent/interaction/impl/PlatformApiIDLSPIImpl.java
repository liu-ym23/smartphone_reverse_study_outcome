package com.obric.aiagent.interaction.impl;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI;
import com.obric.aiagent.interaction.api.IPlatformApi;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PlatformApiIDLSPIImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlatformApiIDLSPIImpl implements IPlatformApiIDLSPI {
    public PlatformApiIDLSPIImpl() {
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IPlatformApiIDLSPI.b.a(this);
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public boolean moveTaskToDisplay(int r3, int r4, boolean r5) {
        ILogDepend.Companion.i("PlatformApiIDLSPIImpl", "moveTaskToDisplay: taskId = " + r3 + ", displayId = " + r4 + ", isTop = " + r5);
        IPlatformApi r2 = (IPlatformApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformApi.class), IPlatformApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.moveTaskToDisplay(r3, r4, r5) != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.obric.aiagent.assistant.idl.IPlatformApiIDL
    public List<String> getTasksPackages(int r3, boolean r4, boolean r5, int r6) {
        ILogDepend.Companion.i("PlatformApiIDLSPIImpl", "getTasksPackageNames: maxNum = " + r3 + ", filterOnlyVisibleRecents = " + r4 + ", keepIntentExtra = " + r5 + ", displayId = " + r6);
        IPlatformApi r2 = (IPlatformApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformApi.class), IPlatformApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        List<ActivityManager.RunningTaskInfo> r7 = r2.getTasks(r3, r4, r5, r6);
    L6:
        if (r7 != null) goto L8;
        r7 = p.b();
    L8:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L20;
        ActivityManager.RunningTaskInfo r11 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.RunningTaskInfo.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L16;
        ComponentName r12 = r11.topActivity;
        if (r12 == null) goto L16;
        String r13 = r12.getPackageName();
    L17:
        if (r13 == null) goto L10;
        r9.add(r13);
    L16:
        r13 = null;
        goto L17
    L20:
        return p.g((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    L5:
        r7 = null;
        goto L6
    }
}
