package a2a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.UIUtils;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements yhc.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f1450a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Dialog> f1451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference<Dialog> f1452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f1453d = false;

    public f() {
    }

    static {
        f1450a = new f();
        f1453d = true;
    }

    public static void d() {
        Activity r100 = AppHost.f326268a.a().getCurrentActivity();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L18;
        q r101 = new q(r100, f1453d);
        r101.setOnDismissListener(new e());
        f1452c = new WeakReference(r101);
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

    @Override // yhc.h
    public final boolean b() {
        WeakReference<Dialog> r100 = f1451b;
        if (r100 == null) goto L7;
        Dialog r101 = r100.get();
        if (r101 == null) goto L7;
        boolean r102 = r101.isShowing();
    L8:
        if (r102 == true) goto L15;
        WeakReference<Dialog> r103 = f1452c;
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

    @Override // yhc.h
    public final void a(int r100) {
        if (r100 != (-2)) goto L5;
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 != null) goto L38;
        return;
    L38:
        if (r101.isFinishing() == true) goto L54;
        UIUtils.displayToast(r101, R.string.larus_settings_checkupdates_latest);
        return;
    L54:
        return;
    L5:
        if (r100 != (-1)) goto L7;
        Activity r102 = AppHost.f326268a.a().getCurrentActivity();
        if (r102 != null) goto L32;
        return;
    L32:
        if (r102.isFinishing() == true) goto L53;
        UIUtils.displayToast(r102, R.string.larus_network_error);
        return;
    L53:
        return;
    L7:
        if (r100 != 1) goto L51;
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.isFinishing() == true) goto L52;
        WeakReference<Dialog> r104 = f1451b;
        if (r104 == null) goto L19;
        Dialog r105 = r104.get();
        if (r105 == null) goto L19;
        c(r105);
    L19:
        WeakReference<Dialog> r106 = f1452c;
        if (r106 == null) goto L24;
        Dialog r107 = r106.get();
        if (r107 == null) goto L24;
        c(r107);
    L24:
        c r108 = new c(r103, f1453d);
        r108.setOnDismissListener(new d());
        f1451b = new WeakReference(r108);
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r108);
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L28:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        return;
    L52:
        return;
    }
}
