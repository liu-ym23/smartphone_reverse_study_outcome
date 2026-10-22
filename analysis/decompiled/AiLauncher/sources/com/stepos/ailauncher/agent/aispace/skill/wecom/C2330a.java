package com.stepos.ailauncher.agent.aispace.skill.wecom;

import android.content.Context;
import android.content.pm.PackageManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Z", "Landroid/content/pm/PackageManager;", "", "pkg", Const.INTENT_KEY_APIKEY, "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "PKG_WECOM", "Ljava/lang/String;", "DEBUG_INVERT_RESULT", "Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2330a {
    public static boolean DEBUG_INVERT_RESULT = false;
    public static final C2330a INSTANCE = new C2330a();
    public static final String PKG_WECOM = "com.tencent.wework";

    public final boolean a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean b(Context context) throws PackageManager.NameNotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.p.h(packageManager, "getPackageManager(...)");
        boolean zA = a(packageManager, PKG_WECOM);
        return DEBUG_INVERT_RESULT ? !zA : zA;
    }
}
