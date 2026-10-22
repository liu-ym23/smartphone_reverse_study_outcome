package com.obric.capabilitykit.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/ComponentEnabledChecker;", "", "()V", "TAG", "", "isAppDisabled", "", "pm", "Landroid/content/pm/PackageManager;", "packageName", "isComponentEnabled", "context", "Landroid/content/Context;", "componentName", "Landroid/content/ComponentName;", "isManifestEnabled", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11256a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f11257b = "ComponentEnabledChecker";

    static {
        f11256a = new a();
    }

    private a() {
    }

    public final boolean a(@NotNull Context r10, @NotNull ComponentName r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "componentName");
        PackageManager r12 = r10.getPackageManager();
        kotlin.jvm.internal.q.f(r12, "pm");
        String r13 = r11.getPackageName();
        kotlin.jvm.internal.q.f(r13, "componentName.packageName");
        if (a(r12, r13) == false) goto L5;
        return false;
    L5:
        int r14 = r12.getComponentEnabledSetting(r11);
        if (r14 == 0) goto L12;
        if (r14 == 1) goto L13;
        return false;
    L13:
        return true;
    L12:
        return a(r12, r11);
    }

    private final boolean a(PackageManager r10, ComponentName r11) {
        boolean r12 = false;
        r12 = r10.getActivityInfo(r11, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L5 Exception -> L11
    L14:
    L5:
        r12 = r10.getServiceInfo(r11, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L7 Exception -> L11
    L7:
        r12 = r10.getReceiverInfo(r11, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L9 Exception -> L11
    L9:
        r12 = r10.getProviderInfo(r11, 0).enabled;     // Catch: Exception -> L11
    L10:
        return r12;
    }

    private final boolean a(PackageManager r10, String r11) {
        ApplicationInfo r12 = r10.getApplicationInfo(r11, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        kotlin.jvm.internal.q.f(r12, "pm.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L6
        return true ^ r12.enabled;
    L9:
        return true;
    }
}
