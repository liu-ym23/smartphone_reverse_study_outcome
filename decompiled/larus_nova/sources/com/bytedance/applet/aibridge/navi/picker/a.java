package com.bytedance.applet.aibridge.navi.picker;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.larus.navigation.api.c;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WeakReference<Dialog> f191270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Function2<? super String, ? super Integer, Unit> f191271b;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.navi.picker.a$a, reason: collision with other inner class name */
    public static final class C2776a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f191272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f191273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f191274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final NavigationMapAppLauncher.InstallState f191275d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C2776a) == true) goto L8;
            return false;
        L8:
            C2776a r101 = (C2776a) r100;
            if (Intrinsics.areEqual(this.f191272a, r101.f191272a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f191273b, r101.f191273b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f191274c, r101.f191274c) == true) goto L18;
            return false;
        L18:
            if (this.f191275d == r101.f191275d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f191272a.hashCode() * 31;
            String r101 = this.f191273b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (((r100 + r103) * 31) + this.f191274c.hashCode()) * 31;
            NavigationMapAppLauncher.InstallState r105 = this.f191275d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Row(text=" + this.f191272a + ", desc=" + this.f191273b + ", selectionKey=" + this.f191274c + ", installState=" + this.f191275d + ')';
        }

        public C2776a(CharSequence r100, String r101, String r102, NavigationMapAppLauncher.InstallState r103) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r102, "selectionKey");
            this.f191272a = r100;
            this.f191273b = r101;
            this.f191274c = r102;
            this.f191275d = r103;
        }
    }

    static {
    }

    public static void a(Dialog r100) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(Function2 r100, String r101, Integer r102) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, r102);     // Catch: RuntimeException -> L6
        return;
    L6:
        e = move-exception;
        int r103 = c.f359656a;
        c.c("nav_map_popup_mgr", "pending callback threw [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
    }
}
