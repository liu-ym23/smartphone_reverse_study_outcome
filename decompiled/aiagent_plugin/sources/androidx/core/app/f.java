package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LocaleManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: compiled from: LocaleManagerCompat.java */
    static class a {
        static LocaleList a(Object r2) {
            return ((LocaleManager) ZeusTransformUtils.preCheckCast(r2, LocaleManager.class, "com.obric.aiagent.plugin")).getSystemLocales();
        }

        static LocaleList b(Object r2) {
            return ((LocaleManager) ZeusTransformUtils.preCheckCast(r2, LocaleManager.class, "com.obric.aiagent.plugin")).getApplicationLocales();
        }
    }

    public static androidx.core.os.i a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 33) goto L11;
        Object r4 = b(r3);
        if (r4 == null) goto L9;
        return androidx.core.os.i.a(a.b(r4));
    L9:
        return androidx.core.os.i.e();
    L11:
        return androidx.core.os.i.a(b.a(r3));
    }

    private static Object b(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("locale");
    }
}
