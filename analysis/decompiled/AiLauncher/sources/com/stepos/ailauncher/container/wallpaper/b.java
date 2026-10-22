package com.stepos.ailauncher.container.wallpaper;

import android.content.Context;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/container/wallpaper/b;", "", "<init>", "()V", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(I)I", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)I", "", "KEY", "Ljava/lang/String;", "CUSTOM", "I", "MOLTEN_ORANGE", "DEEP_BLUE", "PRISM_YELLOW", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final int CUSTOM = 0;
    public static final int DEEP_BLUE = 2;
    public static final b INSTANCE = new b();
    public static final String KEY = "settings_amoo_theme_color";
    public static final int MOLTEN_ORANGE = 1;
    public static final int PRISM_YELLOW = 3;

    public final int a(int value) {
        if (value == 1 || value == 2 || value == 3) {
            return value;
        }
        return 0;
    }

    public final int b(Context context) {
        Object objB;
        p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(Settings.System.getInt(context.getContentResolver(), KEY, 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        return a(((Number) objB).intValue());
    }
}
