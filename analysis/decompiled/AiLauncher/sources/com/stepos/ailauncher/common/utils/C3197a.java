package com.stepos.ailauncher.common.utils;

import android.app.Application;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048\u0006@BX\u0086.¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/common/utils/a;", "", "<init>", "()V", "Landroid/app/Application;", "app", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Application;)V", UxipConstants.f30680s, "appContext", "Landroid/app/Application;", Const.INTENT_KEY_APIKEY, "()Landroid/app/Application;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.common.utils.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3197a {
    public static final C3197a INSTANCE = new C3197a();
    private static Application appContext;

    public final Application a() {
        Application application = appContext;
        if (application != null) {
            return application;
        }
        kotlin.jvm.internal.p.A("appContext");
        return null;
    }

    public final void b(Application app) {
        kotlin.jvm.internal.p.i(app, "app");
        appContext = app;
    }
}
