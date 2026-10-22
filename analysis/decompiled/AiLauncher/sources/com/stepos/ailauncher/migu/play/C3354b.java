package com.stepos.ailauncher.migu.play;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ'\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/migu/play/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "traceTag", "LY8/t;", "e", "(Landroid/content/Context;Ljava/lang/String;)V", "f", Const.INTENT_KEY_PKGNAME, "pkg", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "URI_MIGU_MINE", "Ljava/lang/String;", "PKG_APPSTORE", "MARKET_SOURCE", "EXTRA_AUTO_RETURN_TO_CALLER", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3354b {
    private static final String EXTRA_AUTO_RETURN_TO_CALLER = "com.migu.music.ipc.extra.AUTO_RETURN_TO_CALLER";
    public static final C3354b INSTANCE = new C3354b();
    private static final String MARKET_SOURCE = "amoo";
    private static final String PKG_APPSTORE = "com.stepos.appstore";
    private static final String URI_MIGU_MINE = "mgmusic://route-path-main?bPageType=B_MY_PAGE";

    public static final void c(AtomicBoolean atomicBoolean, String str, Context context, String str2, String str3) {
        if (atomicBoolean.compareAndSet(false, true)) {
            R5.b.INSTANCE.h("music.download.fallback", Y8.j.a("from", str), Y8.j.a("reason", str3));
            C3354b c3354b = INSTANCE;
            kotlin.jvm.internal.p.f(context);
            c3354b.g(context, str2, str);
        }
    }

    public static final void d(String str, AtomicBoolean atomicBoolean, Context context, String str2, int i10, String str3) {
        if (i10 < 0) {
            R5.b.INSTANCE.h("music.download.sdkError", Y8.j.a("from", str), Y8.j.a("code", Integer.valueOf(i10)), Y8.j.a("data", str3 != null ? La.K.R1(str3, 120) : null));
            c(atomicBoolean, str, context, str2, "sdk_code_" + i10);
        }
    }

    public final void b(Context context, final String traceTag) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(traceTag, "traceTag");
        final Context applicationContext = context.getApplicationContext();
        C3369q c3369q = C3369q.INSTANCE;
        kotlin.jvm.internal.p.f(applicationContext);
        c3369q.o(applicationContext);
        MiguInstallState.INSTANCE.c();
        final String str = "cmccwm.mobilemusic";
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            AppCenterSdk appCenterSdk = AppCenterSdk.getInstance();
            int installType = appCenterSdk.getInstallType();
            appCenterSdk.setInstallType(2);
            try {
                appCenterSdk.performDownloadClick(new AppCenterSdk.c("cmccwm.mobilemusic"), new AppCenterSdk.Listener() { // from class: com.stepos.ailauncher.migu.play.a
                    @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
                    public final void onCallback(int i10, String str2) {
                        C3354b.d(traceTag, atomicBoolean, applicationContext, str, i10, str2);
                    }
                });
                appCenterSdk.setInstallType(installType);
                objB = Result.b(Boolean.TRUE);
            } catch (Throwable th) {
                appCenterSdk.setInstallType(installType);
                throw th;
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("from", traceTag);
            Pair pairA2 = Y8.j.a("exception", thE.getClass().getSimpleName());
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.download.perform.fail", pairA, pairA2, Y8.j.a("message", message));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (((Boolean) objB).booleanValue()) {
            R5.b.INSTANCE.c("music.download", Y8.j.a("from", traceTag), Y8.j.a("via", "performDownloadClick"));
        } else {
            c(atomicBoolean, traceTag, applicationContext, "cmccwm.mobilemusic", "perform_throw");
        }
    }

    public final void e(Context context, String traceTag) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(traceTag, "traceTag");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("cmccwm.mobilemusic");
        if (launchIntentForPackage == null) {
            R5.b.INSTANCE.h("music.openMigu.fail", Y8.j.a("from", traceTag), Y8.j.a("reason", "no_launch_intent"));
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            launchIntentForPackage.addFlags(335544320);
            context.startActivity(launchIntentForPackage);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("from", traceTag);
            Pair pairA2 = Y8.j.a("reason", "launch_throw");
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.openMigu.fail", pairA, pairA2, Y8.j.a("message", message));
        }
        if (Result.h(objB)) {
            R5.b.INSTANCE.c("music.openMigu", Y8.j.a("from", traceTag), Y8.j.a("via", "home"));
        }
    }

    public final void f(Context context, String traceTag) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(traceTag, "traceTag");
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(URI_MIGU_MINE)).addFlags(335544320));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            R5.b.INSTANCE.c("music.openMigu", Y8.j.a("from", traceTag), Y8.j.a("via", "deeplink"));
            return;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("cmccwm.mobilemusic");
        if (launchIntentForPackage == null) {
            R5.b.INSTANCE.h("music.openMigu.fail", Y8.j.a("from", traceTag), Y8.j.a("reason", "no_launch_intent"));
            return;
        }
        try {
            launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            launchIntentForPackage.putExtra(EXTRA_AUTO_RETURN_TO_CALLER, true);
            context.startActivity(launchIntentForPackage);
            objB2 = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE = Result.e(objB2);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("from", traceTag);
            Pair pairA2 = Y8.j.a("reason", "launch_throw");
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.openMigu.fail", pairA, pairA2, Y8.j.a("message", message));
        }
        if (Result.h(objB2)) {
            R5.b.INSTANCE.c("music.openMigu", Y8.j.a("from", traceTag), Y8.j.a("via", "launcher"));
        }
    }

    public final void g(Context context, String pkg, String traceTag) {
        Object objB;
        Object objB2;
        Object objB3;
        String str = "market://details?id=" + pkg + "&package_name=" + pkg + "&source=amoo";
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage("com.stepos.appstore");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            R5.b.INSTANCE.c("music.download", Y8.j.a("from", traceTag), Y8.j.a("via", "appstore"));
            return;
        }
        try {
            objB2 = Result.b(P3.a.b());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        String str2 = (String) objB2;
        if (str2 == null || str2.length() == 0) {
            R5.b.INSTANCE.h("music.download.fail", Y8.j.a("from", traceTag), Y8.j.a("reason", "empty_url"));
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
            objB3 = Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB3);
        if (thE != null) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("from", traceTag);
            Pair pairA2 = Y8.j.a("reason", "start_throw");
            String message = thE.getMessage();
            if (message == null) {
                message = "";
            }
            bVar.h("music.download.fail", pairA, pairA2, Y8.j.a("message", message));
        }
        if (Result.h(objB3)) {
            R5.b.INSTANCE.c("music.download", Y8.j.a("from", traceTag), Y8.j.a("via", "h5"));
        }
    }
}
