package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J)\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/K;", "", "<init>", "()V", "", "percent", "LY8/t;", "c", "(I)V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "context", "", "backendState", "pkg", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "installState", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "progress", "Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    public static final K INSTANCE = new K();
    private static volatile Integer progress;

    public final void a() {
        progress = null;
    }

    public final String b(String installState, String pkg) {
        kotlin.jvm.internal.p.i(pkg, "pkg");
        if (kotlin.jvm.internal.p.d(installState, "installed")) {
            return pkg;
        }
        return null;
    }

    public final void c(int percent) {
        if (1 > percent || percent >= 101) {
            return;
        }
        progress = Integer.valueOf(percent);
    }

    public final String d(Context context, String backendState, String pkg) {
        Object objB;
        Boolean bool;
        kotlin.jvm.internal.p.i(pkg, "pkg");
        String lowerCase = null;
        if (context == null) {
            bool = null;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Boolean.valueOf(C3312i.INSTANCE.a(context, pkg)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            bool = (Boolean) objB;
        }
        if (kotlin.jvm.internal.p.d(bool, Boolean.TRUE)) {
            return "installed";
        }
        if (progress != null) {
            return "installing";
        }
        String strD = N5.j.INSTANCE.d(backendState);
        if (strD != null) {
            lowerCase = strD.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 3227604) {
                if (iHashCode != 29046650) {
                    if (iHashCode == 900450407 && lowerCase.equals("installing")) {
                        return lowerCase;
                    }
                } else if (lowerCase.equals("installed") && !kotlin.jvm.internal.p.d(bool, Boolean.FALSE)) {
                    return lowerCase;
                }
            } else if (lowerCase.equals("idle")) {
                return lowerCase;
            }
        }
        return "idle";
    }
}
