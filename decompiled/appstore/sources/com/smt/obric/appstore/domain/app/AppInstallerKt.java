package com.smt.obric.appstore.domain.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.view.ContextThemeWrapper;
import android.view.Window;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.utils.PerformanceMonitor;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AppInstallerKt {

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f17950a;

        public a(CancellableContinuation r10) {
            this.f17950a = r10;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r10) {
            if (this.f17950a.isActive() == false) goto L6;
            CancellableContinuation r11 = this.f17950a;
            Result.a r12 = Result.Companion;
            r11.resumeWith(Result.m35constructorimpl(Boolean.FALSE));
            return;
        }
    }

    public static final class b extends IPackageDeleteObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f17951a;

        public b(CancellableContinuation r10) {
            this.f17951a = r10;
        }

        public void packageDeleted(String r10, int r11) {
            if (this.f17951a.isActive() == false) goto L6;
            Integer r12 = Integer.valueOf(r11);
            this.f17951a.resumeWith(Result.m35constructorimpl(r12));
            return;
        }
    }

    public static final /* synthetic */ Object a(Context r10, com.smt.obric.appstore.domain.app.entity.a r11, Continuation r12) {
        return c(r10, r11, r12);
    }

    public static final /* synthetic */ void b(PackageInstaller.Session r10, String r11, String r12) {
        g(r10, r11, r12);
    }

    public static final Object c(Context r10, com.smt.obric.appstore.domain.app.entity.a r11, Continuation r12) {
        final kotlinx.coroutines.n r13 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r12), 1);
        r13.initCancellability();
        OAlertDialogBuilder r14 = new OAlertDialogBuilder(new ContextThemeWrapper(r10, R$style.AppStoreDialogTheme));
        r14.N(R$string.auto_install_title);
        r14.t(r10.getString(R$string.auto_install_msg, new Object[]{r11.f()}));
        r14.I(R$string.auto_update_immediately, new AppInstallerKt$awaitInstallSysAppUserConfirm$2$1(r13));
        r14.w(R$string.cancel, new AppInstallerKt$awaitInstallSysAppUserConfirm$2$2(r13));
        r14.h(new a(r13));
        final OAlertDialog r15 = (OAlertDialog) r14.a();
        r13.invokeOnCancellation(new AppInstallerKt$awaitInstallSysAppUserConfirm$2$4(r15));
        Window r16 = r15.getWindow();     // Catch: Throwable -> L6
        if (r16 == null) goto L8;
        r16.setType(2038);     // Catch: Throwable -> L6
    L8:
        r15.setCanceledOnTouchOutside(false);     // Catch: Throwable -> L6
        r15.show();     // Catch: Throwable -> L6
    L18:
        Object r17 = r13.q();
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L21;
        tf.d.c(r12);
    L21:
        return r17;
    L6:
        th = move-exception;
        com.bytedanceos.common.toolbox.j.n("showInstallSysAppDialog error " + th.getMessage());
        Result.a r18 = Result.Companion;     // Catch: Throwable -> L13
        r15.dismiss();     // Catch: Throwable -> L13
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L13
    L16:
        if (r13.isActive() == false) goto L18;
        r13.resumeWith(Result.m35constructorimpl(tf.a.a(false)));
    L13:
        th = move-exception;
        Result.a r19 = Result.Companion;
        Result.m35constructorimpl(kotlin.c.a(th));
        goto L16
    }

    public static final Object d(PackageManager r10, String r11, int r12, Continuation r13) {
        kotlinx.coroutines.n r14 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r13), 1);
        r14.initCancellability();
        r10.deletePackage(r11, new b(r14), r12);     // Catch: Exception -> L5
    L9:
        Object r15 = r14.q();
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L12;
        tf.d.c(r13);
    L12:
        return r15;
    L5:
        e = move-exception;
        e.printStackTrace();
        if (r14.isActive() == false) goto L9;
        Result.a r16 = Result.Companion;
        r14.resumeWith(Result.m35constructorimpl(kotlin.c.a(e)));
        goto L9
    }

    public static /* synthetic */ Object e(PackageManager r10, String r11, int r12, Continuation r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        return d(r10, r11, r12, r13);
    }

    public static final Object f(Context r10, String r11, String r12, int r13, Continuation r14) {
        PerformanceMonitor.b(r11);
        return kotlinx.coroutines.h.g(l0.b(), new AppInstallerKt$installApk$2(r11, r12, r10, r13, null), r14);
    }

    public static final void g(PackageInstaller.Session r10, String r11, String r12) {
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] writeSplitToInstallSession inPath: " + r11 + " splitName: " + r12);
        File r13 = new File(r11);
        if (r13.isFile() == false) goto L46;
        long r14 = r13.length();
        FileInputStream r15 = null;
        OutputStream r16 = null;
        r16 = null;
        r15 = null;
        FileInputStream r17 = new FileInputStream(r11);     // Catch: Throwable -> L29 Exception -> L31
    L56:
        r16 = r10.openWrite(r12, 0, r14);     // Catch: Throwable -> L15 Exception -> L17
        byte[] r18 = new byte[65536];     // Catch: Throwable -> L15 Exception -> L17
        float r19 = 0.0f;
        int r20 = 0;
    L8:
        int r21 = r17.read(r18);     // Catch: Throwable -> L15 Exception -> L17
        if (r21 == (-1)) goto L19;
        r20 = r20 + r21;     // Catch: Throwable -> L15 Exception -> L17
        r16.write(r18, 0, r21);     // Catch: Throwable -> L15 Exception -> L17
        if (r14 == 0) goto L8;
        float r22 = r20 / r14;     // Catch: Throwable -> L15 Exception -> L17
        if ((r22 - r19) < 0.05f) goto L8;
        r10.setStagingProgress(r22);     // Catch: Throwable -> L15 Exception -> L17
        r19 = r22;
        goto L8
    L19:
        r10.fsync(r16);     // Catch: Throwable -> L15 Exception -> L17
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] writeSplitToInstallSession Success: streamed " + r20 + " inPath " + r11);     // Catch: Throwable -> L15 Exception -> L17
        r17.close();     // Catch: IOException -> L23
        if (r16 == null) goto L25;
        r16.close();     // Catch: IOException -> L23
    L25:
        r10.close();     // Catch: IOException -> L23
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        e = e;
        OutputStream r110 = r16;
        r15 = r17;
    L50:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] writeSplitToInstallSession Error: failed to write; " + e.getMessage());     // Catch: Throwable -> L35
        throw new AppInstallException("app install fail", e);     // Catch: Throwable -> L35
    L35:
        th = th;
    L36:
        if (r15 != null) goto L48;
    L40:
        if (r110 == null) goto L42;
        r110.close();     // Catch: IOException -> L38
    L42:
        r10.close();     // Catch: IOException -> L38
    L45:
        throw th;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L48:
        r15.close();     // Catch: IOException -> L38
    L15:
        th = th;
        r110 = r16;
        r15 = r17;
    L31:
        e = e;
        r110 = null;
    L29:
        th = th;
        r110 = null;
        goto L36
    L46:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][AppInstaller][InstallStage] is not file: ");
    }
}
