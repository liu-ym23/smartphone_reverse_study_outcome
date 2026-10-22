package com.bytedance.android.livesdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f161762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f161763b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f161764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DialogInterface.OnClickListener f161765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f161766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DialogInterface.OnClickListener f161767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f161768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f161769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Context f161770g;

        public final j0 c() {
            j0 r100 = new j0(this.f161770g, this);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r100);
        L7:
            return r100;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
            goto L7
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f161770g = r100;
            this.f161769f = true;
        }

        public final void a(String r100, DialogInterface.OnClickListener r101) {
            Intrinsics.checkNotNullParameter(r100, "leftText");
            this.f161765b = r101;
            this.f161766c = r100;
        }

        public final void b(String r100, DialogInterface.OnClickListener r101) {
            Intrinsics.checkNotNullParameter(r100, "rightText");
            this.f161767d = r101;
            this.f161768e = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f161771a;

        public b(j0 r100) {
            this.f161771a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            j0 r101 = this.f161771a;
            DialogInterface.OnClickListener r102 = r101.f161763b.f161765b;
            if (r102 == null) goto L6;
            r102.onClick(r101, 0);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f161772a;

        public c(j0 r100) {
            this.f161772a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            j0 r101 = this.f161772a;
            DialogInterface.OnClickListener r102 = r101.f161763b.f161767d;
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
        r101.width = (int) UIUtils.dip2Px(getContext(), this.f161762a);
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
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_alert, null);
        setContentView(r101);
        setCancelable(false);
        setCanceledOnTouchOutside(this.f161763b.f161769f);
        ((TextView) r101.findViewById(R.id.title)).setText(this.f161763b.f161764a);
        ((TextView) r101.findViewById(R.id.btn_left)).setText(this.f161763b.f161766c);
        ((TextView) r101.findViewById(R.id.btn_right)).setText(this.f161763b.f161768e);
        ((TextView) r101.findViewById(R.id.btn_left)).setOnClickListener(new b(this));
        ((TextView) r101.findViewById(R.id.btn_right)).setOnClickListener(new c(this));
    }

    public j0(Context r100, a r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f161763b = r101;
        this.f161762a = 280;
    }
}
