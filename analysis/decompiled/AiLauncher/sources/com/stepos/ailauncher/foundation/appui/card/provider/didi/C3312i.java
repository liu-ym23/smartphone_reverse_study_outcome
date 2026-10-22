package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.content.Context;
import android.content.pm.PackageManager;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/i;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "pkg", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Z", "Landroid/content/pm/PackageManager;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3312i {
    public static final C3312i INSTANCE = new C3312i();

    public final boolean a(Context context, String pkg) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(pkg, "pkg");
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.p.h(packageManager, "getPackageManager(...)");
        return b(packageManager, pkg);
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
