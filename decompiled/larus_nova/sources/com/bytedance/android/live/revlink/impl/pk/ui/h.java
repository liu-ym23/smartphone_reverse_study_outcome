package com.bytedance.android.live.revlink.impl.pk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f97038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f97039b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f97040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f97041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public DialogInterface.OnClickListener f97042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f97043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DialogInterface.OnClickListener f97044e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f97045f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Context f97046g;

        public final void a() {
            h r100 = new h(this.f97046g, this);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f97046g = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f97047a;

        public b(h r100) {
            this.f97047a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            h r101 = this.f97047a;
            DialogInterface.OnClickListener r102 = r101.f97039b.f97042c;
            if (r102 == null) goto L6;
            r102.onClick(r101, 0);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f97048a;

        public c(h r100) {
            this.f97048a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            h r101 = this.f97048a;
            DialogInterface.OnClickListener r102 = r101.f97039b.f97044e;
            if (r102 == null) goto L6;
            r102.onClick(r101, 1);
            return;
        }
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
        r101.width = (int) t6.a(getContext(), this.f97038a);
    L15:
        if (r101 == null) goto L17;
        r101.height = -2;
    L17:
        if (r101 == null) goto L19;
        r101.gravity = 17;
    L19:
        Window r102 = getWindow();
        if (r102 == null) goto L27;
        r102.setAttributes(r101);
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

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_pk_alert, null);
        setContentView(r101);
        setCancelable(false);
        ((TextView) r101.findViewById(R.id.title)).setText(this.f97039b.f97040a);
        ((TextView) r101.findViewById(R.id.message)).setText(this.f97039b.f97041b);
        ((TextView) r101.findViewById(R.id.btn_left)).setText(this.f97039b.f97043d);
        ((TextView) r101.findViewById(R.id.btn_right)).setText(this.f97039b.f97045f);
        ((TextView) r101.findViewById(R.id.btn_left)).setOnClickListener(new b(this));
        ((TextView) r101.findViewById(R.id.btn_right)).setOnClickListener(new c(this));
    }

    public h(Context r100, a r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f97039b = r101;
        this.f97038a = 280;
    }
}
