package h8;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000f¨\u0006\u0011"}, d2 = {"Lh8/h;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lh8/g;", "config", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Lh8/g;)V", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Ljava/lang/String;", "", "Z", "initialized", "logbox_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f32979a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean initialized;

    public static /* synthetic */ void c(h hVar, Context context, LoggerConfig loggerConfig, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            loggerConfig = new LoggerConfig(null, 0, false, false, 15, null);
        }
        hVar.b(context, loggerConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(android.content.Context r6) {
        /*
            r5 = this;
            android.content.pm.PackageManager r5 = r6.getPackageManager()
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L17
            android.content.pm.ApplicationInfo r0 = r6.getApplicationInfo()     // Catch: java.lang.Throwable -> L17
            java.lang.CharSequence r0 = r5.getApplicationLabel(r0)     // Catch: java.lang.Throwable -> L17
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L17
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L17
            goto L22
        L17:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L22:
            java.lang.String r1 = r6.getPackageName()
            java.lang.String r2 = "getPackageName(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            r2 = 46
            r3 = 2
            r4 = 0
            java.lang.String r1 = La.H.s1(r1, r2, r4, r3, r4)
            boolean r2 = kotlin.Result.g(r0)
            if (r2 == 0) goto L3a
            r0 = r1
        L3a:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "\\s+"
            r1.<init>(r2)
            java.lang.String r2 = ""
            java.lang.String r0 = r1.l(r0, r2)
            int r1 = r0.length()
            if (r1 != 0) goto L51
            java.lang.String r0 = "App"
        L51:
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Throwable -> L66
            r1 = 0
            android.content.pm.PackageManager$PackageInfoFlags r1 = android.content.pm.PackageManager.PackageInfoFlags.of(r1)     // Catch: java.lang.Throwable -> L66
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = r5.versionName     // Catch: java.lang.Throwable -> L66
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L66
            goto L71
        L66:
            r5 = move-exception
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L71:
            boolean r6 = kotlin.Result.g(r5)
            if (r6 == 0) goto L78
            r5 = r4
        L78:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L86
            boolean r6 = La.H.x0(r5)
            if (r6 != 0) goto L83
            r4 = r5
        L83:
            if (r4 == 0) goto L86
            goto L88
        L86:
            java.lang.String r4 = "?"
        L88:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r6 = "/"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h8.h.a(android.content.Context):java.lang.String");
    }

    public final void b(Context context, LoggerConfig config) {
        p.i(context, "context");
        p.i(config, "config");
        if (initialized) {
            return;
        }
        initialized = true;
        f fVar = f.f32973a;
        Context applicationContext = context.getApplicationContext();
        p.h(applicationContext, "getApplicationContext(...)");
        fVar.b(a(applicationContext));
        C4148a.m(!((context.getApplicationInfo().flags & 2) != 0));
    }
}
