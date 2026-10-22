package com.bytedanceos.appstore.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Binder;
import com.bytedanceos.common.toolbox.j;
import com.smt.obric.appstore.domain.sysapp.SysAppUtilKt;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/appstore/update/AutoUpdateProviderKt;", "", "()V", "checkPermission", "", "context", "Landroid/content/Context;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoUpdateProviderKt {
    public AutoUpdateProviderKt() {
    }

    public final boolean checkPermission(@NotNull Context r10) {
        q.g(r10, "context");
        String[] r11 = r10.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (r11 == null) goto L28;
        String r12 = (String) n.s(r11);
        if (r12 == null) goto L28;
        PackageInfo r13 = r10.getPackageManager().getPackageInfo(r12, 0);     // Catch: Exception -> L10
        q.d(r13);     // Catch: Exception -> L10
        if (SysAppUtilKt.e(r13) == false) goto L12;
        j.a("AutoUpdateProvider checkPermission pass, calling app is system app, calling pkg=" + r12);     // Catch: Exception -> L10
        return true;
    L12:
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 64);     // Catch: Exception -> L10
        Signature[] r15 = r13.signatures;     // Catch: Exception -> L10
        Signature r16 = null;
        if (r15 == null) goto L15;
        Signature r17 = (Signature) n.s(r15);     // Catch: Exception -> L10
    L16:
        Signature[] r18 = r14.signatures;     // Catch: Exception -> L10
        if (r18 == null) goto L19;
        r16 = (Signature) n.s(r18);     // Catch: Exception -> L10
    L19:
        if (r17 == null) goto L25;
        if (r16 == null) goto L25;
        if (q.b(r17.toCharsString(), r16.toCharsString()) == false) goto L25;
        j.a("AutoUpdateProvider checkPermission pass, same signature, calling pkg=" + r12);     // Catch: Exception -> L10
        return true;
    L25:
        j.b("AutoUpdateProvider checkPermission fail, calling pkg=" + r12);     // Catch: Exception -> L10
        goto L28
    L15:
        r17 = null;
    L10:
        e = move-exception;
        j.b("AutoUpdateProvider checkPermission fail, calling pkg=" + r12 + ", exception=" + e.getMessage());
    L28:
        return false;
    }
}
