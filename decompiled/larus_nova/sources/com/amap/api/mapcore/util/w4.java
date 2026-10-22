package com.amap.api.mapcore.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes28.dex */
public class w4 extends x4 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OfflineMapManager f28281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f28282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f28283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f28284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f28285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f28286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f28287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28288h;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ w4 f28289a;

        public a(w4 r100) {
            this.f28289a = r100;
        }

        public static void INVOKEVIRTUAL_com_amap_api_mapcore_util_w4$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            INVOKEVIRTUAL_com_amap_api_mapcore_util_w4$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f28289a);
        }
    }

    @Override // com.amap.api.mapcore.util.x4
    public void b() {
        View r100 = b5.a(getContext(), R.array.assume_strong_biometrics_models, null);
        this.f28282b = r100;
        setContentView(r100);
        this.f28282b.setOnClickListener(new a(this));
        TextView r101 = (TextView) this.f28282b.findViewById(2147479562);
        this.f28283c = r101;
        r101.setText(p0.a(2131034195));
        TextView r102 = (TextView) this.f28282b.findViewById(2147479563);
        this.f28284d = r102;
        r102.setText(p0.a(2131034142));
        TextView r103 = (TextView) this.f28282b.findViewById(2147479564);
        this.f28285e = r103;
        r103.setText(p0.a(2131034136));
        TextView r104 = (TextView) this.f28282b.findViewById(2147479565);
        this.f28286f = r104;
        r104.setText(p0.a(2131034134));
        this.f28284d.setOnClickListener(this);
        this.f28285e.setOnClickListener(this);
        this.f28286f.setOnClickListener(this);
    }

    public static void INVOKEVIRTUAL_com_amap_api_mapcore_util_w4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        int r101 = r100.getId();     // Catch: Exception -> L28
        if (r101 != 2147479563) goto L20;
        int r102 = this.f28287g;     // Catch: Exception -> L28
        if (r102 != 0) goto L8;
        this.f28284d.setText(p0.a(2131034139));     // Catch: Exception -> L28
        this.f28281a.pauseByName(this.f28288h);     // Catch: Exception -> L28
    L18:
        INVOKEVIRTUAL_com_amap_api_mapcore_util_w4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);     // Catch: Exception -> L28
        return;
    L8:
        if (r102 != 3) goto L10;
    L17:
        this.f28284d.setText(p0.a(2131034137));     // Catch: Exception -> L28
        this.f28281a.downloadByCityName(this.f28288h);     // Catch: Exception -> L28
        goto L18
    L10:
        if (r102 == (-1)) goto L17;
        if (r102 == 101) goto L17;
        if (r102 == 102) goto L17;
        if (r102 != 103) goto L18;
    L20:
        if (r101 != 2147479564) goto L25;
        if (TextUtils.isEmpty(this.f28288h) == true) goto L33;
        this.f28281a.remove(this.f28288h);     // Catch: Exception -> L28
        INVOKEVIRTUAL_com_amap_api_mapcore_util_w4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);     // Catch: Exception -> L28
        return;
    L33:
        return;
    L25:
        if (r101 != 2147479565) goto L35;
        INVOKEVIRTUAL_com_amap_api_mapcore_util_w4_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);     // Catch: Exception -> L28
        return;
    L35:
        return;
    L28:
        e = move-exception;
        e.printStackTrace();
    }

    public w4(Context r100, OfflineMapManager r101) {
        super(r100);
        this.f28281a = r101;
    }

    public void a(int r100, String r101) {
        this.f28283c.setText(r101);
        if (r100 != 0) goto L6;
        this.f28284d.setText(p0.a(2131034137));
        this.f28284d.setVisibility(0);
        this.f28285e.setText(p0.a(2131034136));
    L6:
        if (r100 != 2) goto L9;
        this.f28284d.setVisibility(8);
        this.f28285e.setText(p0.a(2131034136));
    L24:
        this.f28287g = r100;
        this.f28288h = r101;
        return;
    L9:
        if (r100 != (-1)) goto L11;
    L23:
        this.f28284d.setText(p0.a(2131034139));
        this.f28284d.setVisibility(0);
        goto L24
    L11:
        if (r100 == 101) goto L23;
        if (r100 == 102) goto L23;
        if (r100 == 103) goto L23;
        if (r100 != 3) goto L21;
        this.f28284d.setVisibility(0);
        this.f28284d.setText(p0.a(2131034139));
        this.f28285e.setText(p0.a(2131034136));
        goto L24
    L21:
        if (r100 != 4) goto L24;
        this.f28285e.setText(p0.a(2131034135));
        this.f28284d.setVisibility(8);
        goto L24
    }
}
