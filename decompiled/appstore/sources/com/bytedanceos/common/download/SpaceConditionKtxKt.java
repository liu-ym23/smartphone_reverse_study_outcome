package com.bytedanceos.common.download;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.utils.ReflectTool;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpaceConditionKtxKt {

    public static final class a implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f9813a;

        public a(CancellableContinuation r10) {
            this.f9813a = r10;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r10) {
            if (this.f9813a.isActive() == false) goto L6;
            CancellableContinuation r11 = this.f9813a;
            Result.a r12 = Result.Companion;
            r11.resumeWith(Result.m35constructorimpl(Unit.f21064a));
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f9814a;

        public b(Activity r10) {
            this.f9814a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            ReflectTool.goToCleanerSafely(this.f9814a, true);
        }
    }

    public static final Object a(Activity r13, Continuation r14) {
        n r10 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r14), 1);
        r10.initCancellability();
        OAlertDialogBuilder r11 = OAlertDialogBuilder.u(OAlertDialogBuilder.P(new OAlertDialogBuilder(r13), r13.getString(R$string.dialog_short_of_storage_title), false, 2, null), false, 1, null);
        String r12 = r13.getString(R$string.dialog_short_of_storage_content);
        q.f(r12, "getString(...)");
        OAlertDialogBuilder r15 = OAlertDialogBuilder.L(r11, r12, new b(r13), null, 4, null);
        r15.b(true);
        r15.h(new a(r10));
        final OAlertDialog r16 = (OAlertDialog) r15.a();
        if (r13.isFinishing() == true) goto L5;
        r10.invokeOnCancellation(new SpaceConditionKtxKt$showCleanUpDialog$2$2(r16));
        c.a(r13, r16);
        r16.show();
    L8:
        Object r17 = r10.q();
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L12;
        tf.d.c(r14);
    L12:
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L15;
        return r17;
    L15:
        return Unit.f21064a;
    L5:
        if (r10.isActive() == false) goto L8;
        Result.a r18 = Result.Companion;
        r10.resumeWith(Result.m35constructorimpl(Unit.f21064a));
        goto L8
    }
}
