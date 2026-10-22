package com.bytedance.android.annie.card.web;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f39199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<AlertDialog> f39200c;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f39201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f39202b;

        public a(GeolocationPermissions.Callback r100, String r101) {
            this.f39201a = r100;
            this.f39202b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            if (r101 != (-2)) goto L5;
            GeolocationPermissions.Callback r102 = this.f39201a;
            if (r102 == null) goto L14;
            r102.invoke(this.f39202b, false, false);
        L14:
            r100.dismiss();
            return;
        L5:
            if (r101 != (-1)) goto L17;
            GeolocationPermissions.Callback r103 = this.f39201a;
            if (r103 == null) goto L10;
            r103.invoke(this.f39202b, true, true);
        L10:
            r100.dismiss();
            return;
        }
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void o() {
        WeakReference<AlertDialog> r100 = this.f39200c;
        if (r100 == null) goto L13;
        AlertDialog r101 = r100.get();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isShowing() == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L15;
        D(r101);
        return;
    L15:
        return;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(null);
        this.f39199b = r100;
    }

    public static void D(AlertDialog r100) {
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

    @Override // com.bytedance.android.annie.card.web.e
    public final void p(String r100, GeolocationPermissions.Callback r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        WeakReference<AlertDialog> r102 = this.f39200c;
        if (r102 == null) goto L15;
        AlertDialog r103 = r102.get();
        if (r103 == null) goto L15;
        if (r103.isShowing() == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        D(r103);
    L15:
        AlertDialog.Builder r104 = new AlertDialog.Builder(this.f39199b);
        r104.setTitle(R.string.annie_geo_dlg_title);
        r104.setMessage(r104.getContext().getString(R.string.annie_geo_dlg_message, new Object[]{r100}));
        a r105 = new a(r101, r100);
        r104.setNegativeButton(R.string.annie_geo_dlg_disallow, r105);
        r104.setPositiveButton(R.string.annie_geo_dlg_allow, r105);
        r104.setCancelable(false);
        this.f39200c = new WeakReference(r104.show());
    }
}
