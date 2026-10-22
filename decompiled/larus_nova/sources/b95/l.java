package b95;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Integer, Dialog> f18284a;

    public interface a {
        void cancel();

        void confirm();
    }

    public final void a() {
        Iterator<Dialog> r100 = this.f18284a.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L26;
        Dialog r101 = r100.next();
        if (r101 == null) goto L4;
        if (r101.isShowing() == false) goto L4;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 == null) goto L14;
        if (Looper.myLooper() == r102.getLooper()) goto L14;
        r102.post(DialogLancet.createDismissRunnable(r101));
    L14:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r101);
        goto L4
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r103 == null) goto L23;
        com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    }

    public l() {
        this.f18284a = new WeakHashMap();
    }

    public final UDDialog b(FragmentActivity r100, String r101, String r102, String r103, final a r104) {
        tt5.a.h("DriveDialogManager", "getSimpleMessageConfirmDialog" + r101 + r102);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r105 = new UDDialogBuilder(r100);
        r105.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r101, "value");
        r105.title(r101);
        Intrinsics.checkNotNullParameter(r102, "value");
        r105.message(r102);
        r105.messageTextSize(16);
        DialogInterface.OnClickListener r106 = new h(r104);
        Intrinsics.checkNotNullParameter(r103, "text");
        r105.addActionButton(R.id.ud_dialog_btn_primary, r103, r106);
        r105.cancelable(false);
        r105.width(303.0f);
        r105.marginInDp(0);
        final UDDialog r107 = r105.build();
        r107.setOnShowListener(new i(this, r107));
        r107.setOnDismissListener(new j(this, r107));
        return r107;
    }
}
