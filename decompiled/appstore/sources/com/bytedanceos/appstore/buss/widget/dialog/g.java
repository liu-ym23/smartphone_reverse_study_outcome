package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.obric.appstore.R;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f9260a = null;

    static {
        f9260a = new g();
    }

    public g() {
    }

    public static /* synthetic */ void a(Function1 r10, CheckBox r11, DialogInterface r12, int r13) {
        d(r10, r11, r12, r13);
    }

    public static /* synthetic */ void b(Function1 r10, CheckBox r11, DialogInterface r12, int r13) {
        e(r10, r11, r12, r13);
    }

    public static final void d(Function1 r10, CheckBox r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$negativeListener");
        kotlin.jvm.internal.q.g(r11, "$checkView");
        r10.invoke(Boolean.valueOf(r11.isChecked()));
    }

    public static final void e(Function1 r10, CheckBox r11, DialogInterface r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "$positiveListener");
        kotlin.jvm.internal.q.g(r11, "$checkView");
        r10.invoke(Boolean.valueOf(r11.isChecked()));
    }

    public final void c(Activity r10, long r11, final Function1 r12, final Function1 r13) {
        kotlin.jvm.internal.q.g(r10, "activity");
        kotlin.jvm.internal.q.g(r12, "negativeListener");
        kotlin.jvm.internal.q.g(r13, "positiveListener");
        View r14 = LayoutInflater.from(r10).inflate(R.layout.dialog_mobile_tip, null);
        View r15 = r14.findViewById(R.id.total_flow);
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) r15).setText(r10.getString(R.string.alert_dataflow_message, new Object[]{SizeConverter.BTrim.convert(r11)}));
        View r16 = r14.findViewById(R.id.check_record);
        kotlin.jvm.internal.q.e(r16, "null cannot be cast to non-null type android.widget.CheckBox");
        final CheckBox r17 = (CheckBox) r16;
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R.style.AppStoreDialogTheme)).setTitle(R.string.alert_dataflow_title).setView(r14).setNegativeButton(R.string.alert_wifi_continue, new e(r12, r17)).setPositiveButton(R.string.alert_dataflow_continue, new f(r13, r17)).setCancelable(true).show();
    }
}
