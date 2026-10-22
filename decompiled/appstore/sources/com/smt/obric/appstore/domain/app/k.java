package com.smt.obric.appstore.domain.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel f18036c;

    public k(String r10, String r11, Channel r12) {
        q.g(r10, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r11, "action");
        q.g(r12, "outChannel");
        this.f18034a = r10;
        this.f18035b = r11;
        this.f18036c = r12;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        q.g(r10, "context");
        q.g(r11, MemorySourceLinkType.INTENT);
        if (q.b(this.f18035b, r11.getAction()) == false) goto L12;
        int r12 = r11.getIntExtra("android.content.pm.extra.LEGACY_STATUS", -99);
        String r13 = r11.getStringExtra("android.content.pm.extra.PACKAGE_NAME");
        boolean r14 = true;
        if (r12 == 1) goto L8;
        r14 = false;
    L8:
        if (r14 == true) goto L10;
        com.bytedanceos.common.toolbox.j.p("[AppStatus][InstallStatusReceiver][InstallStage] install failed: [" + r13 + "]/[" + this.f18034a + "]returnCode = " + r12);
    L10:
        this.f18036c.mo53trySendJP2dKIU(kotlin.d.a(Boolean.valueOf(r14), Integer.valueOf(r12)));
        return;
    }
}
