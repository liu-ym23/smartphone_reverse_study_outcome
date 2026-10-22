package com.bytedance.android.gamecp.business.gamedetail.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f55937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f55938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f55939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f55940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f55941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DialogInterface.OnDismissListener f55942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DialogInterface.OnShowListener f55943g;

    public static final class a {
    }

    public final class b implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f55944a;

        public b(n r100) {
            this.f55944a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            HashMap<String, String> r101 = GamecpTracker.f56755a;
            GamecpTracker.o(this.f55944a);
            DialogInterface.OnDismissListener r102 = this.f55944a.f55942f;
            if (r102 == null) goto L6;
            r102.onDismiss(r100);
            return;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r110) {
            n r100 = this.f55944a;
            View r101 = r100.f55941e;
            if (r101 == null) goto L10;
            r100.getClass();
            HashMap<String, String> r102 = GamecpTracker.f56755a;
            GamecpTracker.w(r100, r101, "confirm_cancel_page", MapsKt.emptyMap(), MapsKt.emptyMap(), new o());
            TextView r103 = r100.f55939c;
            if (r103 == null) goto L7;
            GamecpTracker.r(r103, "confirm_cancel_button", MapsKt.emptyMap(), new p(), false, 112);
        L7:
            TextView r104 = r100.f55940d;
            if (r104 == null) goto L10;
            GamecpTracker.r(r104, "think_again", MapsKt.emptyMap(), new q(), false, 112);
        L10:
            HashMap<String, String> r105 = GamecpTracker.f56755a;
            GamecpTracker.p(this.f55944a);
            DialogInterface.OnShowListener r106 = this.f55944a.f55943g;
            if (r106 == null) goto L14;
            r106.onShow(r110);
            return;
        }
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L26;
        Window r100 = getWindow();
        if (r100 == null) goto L12;
        WindowManager.LayoutParams r101 = r100.getAttributes();
    L13:
        if (r101 == null) goto L15;
        Resources r102 = getContext().getResources();
        r101.width = (int) ((280.0f * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    L15:
        if (r101 == null) goto L17;
        r101.height = -2;
    L17:
        if (r101 == null) goto L19;
        r101.gravity = 17;
    L19:
        Window r103 = getWindow();
        if (r103 == null) goto L27;
        r103.setAttributes(r101);
        return;
    L27:
        return;
    L12:
        r101 = null;
        goto L13
    L26:
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_live_dialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.gamecp_game_order_cancel_tips_dialog, null);
        this.f55941e = r101;
        Intrinsics.checkNotNull(r101);
        setContentView(r101);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View r102 = this.f55941e;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "view");
        TextView r103 = (TextView) r102.findViewById(R.id.id_gamecp_order_cancel_tips_ok);
        this.f55939c = r103;
        if (r103 == null) goto L5;
        r103.setOnClickListener(new r(this));
    L5:
        TextView r104 = (TextView) r102.findViewById(R.id.id_gamecp_order_cancel_tips_cancel);
        this.f55940d = r104;
        if (r104 == null) goto L8;
        r104.setOnClickListener(new s(this));
    L8:
        b r105 = new b(this);
        super.setOnDismissListener(r105);
        super.setOnShowListener(r105);
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        this.f55942f = r100;
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener r100) {
        this.f55943g = r100;
    }
}
