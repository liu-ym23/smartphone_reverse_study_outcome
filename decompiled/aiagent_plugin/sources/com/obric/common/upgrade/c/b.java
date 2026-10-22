package com.obric.common.upgrade.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.system.Os;
import android.widget.Toast;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: AppInstaller.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32608a = null;

    /* JADX INFO: compiled from: AppInstaller.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            if (Build.VERSION.SDK_INT < 26) goto L6;
            return b(r4);
        L6:
            return d(r4);
        }

        public final void a(Activity r4, int r5) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
            o.e(r3, "activity");
            if (Build.VERSION.SDK_INT < 26) goto L6;
            Intent r6 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            r6.setData(Uri.parse("package:" + r3.getPackageName()));
            r6.addFlags(268435456);
            ZeusTransformUtils.startActivityForResult(r3, r6, r5, "com.obric.aiagent.plugin");
            return;
        }

        public final void a(Context r3, File r4, com.obric.common.upgrade.c.a r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            com.obric.common.upgrade.c.a r7 = (com.obric.common.upgrade.c.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.common.upgrade.c.a.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            o.e(r4, "apkFile");
            o.e(r7, "installCallback");
            if (Build.VERSION.SDK_INT < 26) goto L9;
            if (b(r6) == false) goto L7;
            a(r6, r4);
            r7.a();
            return;
        L7:
            e(r6);
            c(r6);
            r7.b();
            return;
        L9:
            if (d(r6) == false) goto L11;
            a(r6, r4);
            r7.a();
            return;
        L11:
            r7.b();
            e(r6);
        }

        private final boolean b(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 26) goto L7;
            return true;
        L7:
            return r1.getPackageManager().canRequestPackageInstalls();
        }

        private final void c(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT < 26) goto L6;
            Intent r5 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
            r5.setData(Uri.parse("package:" + r3.getPackageName()));
            r5.addFlags(268435456);
            ZeusTransformUtils.startActivity(r3, r5, "com.obric.aiagent.plugin");
            return;
        }

        private final boolean d(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 26) goto L7;
            if (Settings.Secure.getInt(r3.getContentResolver(), "install_non_market_apps", 0) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private final void e(Context r3) {
            Toast.makeText((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("请在系统设置中开启允许安装未知来源应用的权限", CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        }

        public final void a(Context r5, File r6) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            o.e(r6, "apkFile");
            Intent r7 = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT < 24) goto L18;
            r7.addFlags(1);
            Uri r8 = ZeusTransformUtils.getUriForFile(r4, r4.getPackageName() + ".appupgrade.FileProvider", r6, "com.obric.aiagent.plugin");
            o.c(r8, "{\n                intent…y, apkFile)\n            }");
        L10:
            r7.putExtra("android.intent.extra.RETURN_RESULT", true);
            r7.addFlags(268435456);
            r7.setDataAndType(r8, "application/vnd.android.package-archive");
            ZeusTransformUtils.startActivity(r4, r7, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            Os.chmod(r6.getAbsolutePath(), 493);     // Catch: Throwable -> L6
        L8:
            r8 = Uri.fromFile(r6);
            o.c(r8, "{\n                try {\n…le(apkFile)\n            }");
        L6:
            th = move-exception;
            th.printStackTrace();
            goto L8
        }
    }

    static {
        f32608a = new a(null);
    }
}
