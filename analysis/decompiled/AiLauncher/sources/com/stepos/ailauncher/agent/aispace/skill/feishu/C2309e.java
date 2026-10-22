package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.content.Context;
import android.content.pm.PackageManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/e;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "Landroid/content/pm/PackageManager;", "", "pkg", Const.INTENT_KEY_PKGNAME, "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "PKG_FEISHU", "Ljava/lang/String;", "PKG_LARK", "FORCE_NOT_INSTALLED", "Z", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2309e {
    public static boolean FORCE_NOT_INSTALLED = false;
    public static final C2309e INSTANCE = new C2309e();
    public static final String PKG_FEISHU = "com.ss.android.lark";
    public static final String PKG_LARK = "com.larksuite.suite";

    public final boolean a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (FORCE_NOT_INSTALLED) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.p.f(packageManager);
        return b(packageManager, PKG_FEISHU) || b(packageManager, PKG_LARK);
    }

    public final boolean b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
