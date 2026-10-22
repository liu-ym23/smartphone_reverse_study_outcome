package a2a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes31.dex */
public final class l implements yhc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f1464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1465b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<Dialog> f1466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<Dialog> f1467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f1468e = false;

    public l() {
    }

    @Override // yhc.l
    public final void b(boolean r100) {
    }

    static {
        f1464a = new l();
        f1465b = l.class.getSimpleName();
        f1468e = true;
    }

    public static void e() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L18;
        q r101 = new q(r100, f1468e);
        r101.setOnDismissListener(new k());
        f1467d = new WeakReference(r101);
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        return;
    }

    @Override // yhc.l
    public final boolean d() {
        WeakReference<Dialog> r100 = f1466c;
        if (r100 == null) goto L7;
        Dialog r101 = r100.get();
        if (r101 == null) goto L7;
        boolean r102 = r101.isShowing();
    L8:
        if (r102 == true) goto L15;
        WeakReference<Dialog> r103 = f1467d;
        if (r103 == null) goto L16;
        Dialog r104 = r103.get();
        if (r104 != null) goto L14;
        return r102;
    L14:
        return r104.isShowing();
    L16:
        return r102;
    L15:
        return r102;
    L7:
        r102 = false;
        goto L8
    }

    public static void c(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // yhc.l
    public final void a(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        String r102 = f1465b;
        StringBuilder r103 = new StringBuilder("showMainDialog, ");
        r103.append(r100);
        r103.append(", ");
        r103.append(f1466c);
        r103.append(", ");
        WeakReference<Dialog> r104 = f1466c;
        Boolean r105 = null;
        if (r104 == null) goto L7;
        Dialog r106 = r104.get();
        if (r106 == null) goto L7;
        Boolean r107 = Boolean.valueOf(r106.isShowing());
    L8:
        r103.append(r107);
        r103.append(", ");
        r103.append(f1467d);
        r103.append(", ");
        WeakReference<Dialog> r108 = f1467d;
        if (r108 == null) goto L13;
        Dialog r109 = r108.get();
        if (r109 == null) goto L13;
        r105 = Boolean.valueOf(r109.isShowing());
    L13:
        r103.append(r105);
        r101.d(r102, r103.toString());
        Activity r110 = AppHost.f326268a.a().getCurrentActivity();
        if (r110 != null) goto L16;
        return;
    L16:
        if (r110.isFinishing() == true) goto L39;
        WeakReference<Dialog> r111 = f1466c;
        if (r111 == null) goto L23;
        Dialog r112 = r111.get();
        if (r112 == null) goto L23;
        c(r112);
    L23:
        WeakReference<Dialog> r113 = f1467d;
        if (r113 == null) goto L28;
        Dialog r114 = r113.get();
        if (r114 == null) goto L28;
        c(r114);
    L28:
        i r115 = new i(r110, r100, f1468e);
        r115.setOnDismissListener(new j());
        f1466c = new WeakReference(r115);
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L35;
        DialogLancet.handleBlockedDialogShow(r115);
        return;
    L35:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L32:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        return;
    L39:
        return;
    L7:
        r107 = null;
        goto L8
    }
}
