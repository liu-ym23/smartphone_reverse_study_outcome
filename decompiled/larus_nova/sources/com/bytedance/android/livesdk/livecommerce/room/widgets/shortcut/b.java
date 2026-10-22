package com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f152783a = 0;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECAlertDialog f152784a;

        public a(ECAlertDialog r100) {
            this.f152784a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            k.h(4);
            ECAlertDialog r102 = this.f152784a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r104 == null) goto L16;
            d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r103.getLooper()) goto L7;
            r103.post(DialogLancet.createDismissRunnable(r102));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Dialog, com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.CharSequence] */
    public static ECAlertDialog a(Context r110, ECV2PopupInfo r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "popupInfo");
        ?? r100 = new ECAlertDialog(r110);
        r100.setTitle(r111.title);
        List<JumpUrl> r101 = r111.urls;
        ?? r112 = r111.text;
        boolean r102 = false;
        if (r112 != 0) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r112 = "";
    L32:
        r100.setMessage(r112);
        r100.openContentClick();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        Object r114 = Result.m9449constructorimpl(th.a.f(r110).getString(R.string.ec_live_flash_confirm));     // Catch: Throwable -> L35
    L38:
        if (Result.m9455isFailureimpl(r114) == false) goto L40;
        r114 = LineContent.FOUR_SPACE;
    L40:
        r100.setPositiveButton((String) r114, new a(r100));
        r100.hideNegativeButton();
        k.h(1);
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r100);
    L45:
        return r100;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L44:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    L35:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L11:
        List<JumpUrl> r104 = r101;
        if (r104 != null) goto L14;
    L15:
        r102 = true;
    L16:
        if (r102 == true) goto L32;
        SpannableStringBuilder r105 = new SpannableStringBuilder(r112);
        Iterator r116 = r101.iterator();
    L20:
        if (r116.hasNext() == false) goto L31;
        JumpUrl r106 = (JumpUrl) r116.next();
        String r107 = r106.getKey();
        if (r107 == null) goto L20;
        String r117 = r106.getText();
        if (r117 == null) goto L20;
        String r118 = "${" + r107 + '}';
        int r108 = StringsKt.indexOf$default(r105, r118, 0, false, 6, null);
    L29:
        if (r108 == (-1)) goto L20;
        r105.replace(r108, r118.length() + r108, r117);
        r105.setSpan(new com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.a(r106, r110), r108, r117.length() + r108, 33);
        r108 = StringsKt.indexOf$default(r105, r118, r108 + r117.length(), false, 4, null);
        goto L29
    L31:
        r112 = r105;
        goto L32
    L14:
        if (r104.isEmpty() == false) goto L16;
    L5:
        if (r112.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
