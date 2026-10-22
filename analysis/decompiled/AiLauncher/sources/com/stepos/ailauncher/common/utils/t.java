package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/common/utils/t;", "", "<init>", "()V", "", "", "taskPackages", "selfPackage", Const.INTENT_KEY_UMID, "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;", "pkg", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "activityForeground", "pageForeground", "overlayVisible", "inRecents", Const.INTENT_KEY_APIKEY, "(ZZLjava/lang/Boolean;Z)Z", "homePackage", "c", "(Ljava/lang/String;Ljava/lang/String;)Z", "top", AuthSessionDto.STATUS_PENDING, "", "pendingAtElapsed", "nowElapsed", "e", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)Z", "PKG_LAUNCHER3", "Ljava/lang/String;", "PKG_SYSTEM_UI", "TRANSIENT_STABLE_MS", "J", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    public static final t INSTANCE = new t();
    public static final String PKG_LAUNCHER3 = "com.android.launcher3";
    public static final String PKG_SYSTEM_UI = "com.android.systemui";
    public static final long TRANSIENT_STABLE_MS = 1200;

    public final boolean a(boolean activityForeground, boolean pageForeground, Boolean overlayVisible, boolean inRecents) {
        if (inRecents) {
            return false;
        }
        if (activityForeground) {
            return true;
        }
        if (overlayVisible != null) {
            pageForeground = overlayVisible.booleanValue();
        }
        return pageForeground;
    }

    public final boolean b(String pkg) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        return kotlin.jvm.internal.p.d(pkg, "com.android.systemui") || La.D.X(pkg, "com.android.systemui.", false, 2, null);
    }

    public final boolean c(String pkg, String homePackage) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        if (kotlin.jvm.internal.p.d(pkg, "com.android.launcher3")) {
            return true;
        }
        return !(homePackage == null || homePackage.length() == 0 || !kotlin.jvm.internal.p.d(pkg, homePackage)) || b(pkg);
    }

    public final String d(List<String> taskPackages, String selfPackage) {
        kotlin.jvm.internal.p.i(taskPackages, "taskPackages");
        kotlin.jvm.internal.p.i(selfPackage, "selfPackage");
        String str = (String) Z8.F.s0(taskPackages);
        if (str == null || La.H.x0(str) || kotlin.jvm.internal.p.d(str, selfPackage)) {
            return null;
        }
        return str;
    }

    public final boolean e(String top, String pending, long pendingAtElapsed, long nowElapsed, String homePackage) {
        kotlin.jvm.internal.p.i(top, "top");
        if (!kotlin.jvm.internal.p.d(top, pending) || b(top)) {
            return false;
        }
        return !c(top, homePackage) || nowElapsed - pendingAtElapsed >= 1200;
    }
}
