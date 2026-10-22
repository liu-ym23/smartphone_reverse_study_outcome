package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.content.Context;
import android.content.pm.PackageManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "Landroid/content/pm/PackageManager;", "", "pkg", Const.INTENT_KEY_PKGNAME, "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "PKG_ALIPAY", "Ljava/lang/String;", "PKG_APPSTORE", "", "MIN_STORE_VERSION_FOR_PROGRESS", "J", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3236a {
    public static final C3236a INSTANCE = new C3236a();
    private static final long MIN_STORE_VERSION_FOR_PROGRESS = 6009000;
    public static final String PKG_ALIPAY = "com.eg.android.AlipayGphone";
    public static final String PKG_APPSTORE = "com.stepos.appstore";

    public final boolean a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.p.h(packageManager, "getPackageManager(...)");
        return b(packageManager, PKG_ALIPAY);
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
