package com.bytedance.android.livesdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a1 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f161403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f161404b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f161405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f161406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f161407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f161408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Context f161409e;

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f161409e = r100;
            this.f161408d = true;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a1 f161410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f161411b;

        public b(a1 r100, View r101) {
            this.f161410a = r100;
            this.f161411b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f161410a.f161404b.getClass();
            a1 r101 = this.f161410a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
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
        r101.width = (int) t6.a(getContext(), this.f161403a);
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
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_enhance_dialog_alert, null);
        setContentView(r101);
        setCancelable(false);
        setCanceledOnTouchOutside(this.f161404b.f161408d);
        TextView r102 = (TextView) r101.findViewById(R.id.title);
        boolean r103 = true;
        if (r102 == null) goto L14;
        String r104 = this.f161404b.f161405a;
        if (r104 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        r102.setText(this.f161404b.f161405a);
        r102.setVisibility(0);
        goto L14
    L13:
        r102.setVisibility(8);
        goto L14
    L7:
        if (r104.length() == 0) goto L10;
        r105 = false;
    L14:
        TextView r106 = (TextView) r101.findViewById(R.id.content);
        if (r106 == null) goto L26;
        String r107 = this.f161404b.f161406b;
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L25;
        r106.setText(this.f161404b.f161406b);
        r106.setVisibility(0);
        goto L26
    L25:
        r106.setVisibility(8);
        goto L26
    L19:
        if (r107.length() == 0) goto L22;
        r108 = false;
    L26:
        TextView r109 = (TextView) r101.findViewById(R.id.btn_left);
        if (r109 == null) goto L31;
        this.f161404b.getClass();
        r109.setVisibility(8);
        View r110 = r101.findViewById(R.id.divider);
        if (r110 == null) goto L31;
        r110.setVisibility(8);
    L31:
        TextView r111 = (TextView) r101.findViewById(R.id.btn_right);
        if (r111 == null) goto L45;
        String r112 = this.f161404b.f161407c;
        if (r112 != null) goto L36;
    L39:
        if (r103 == true) goto L41;
        r111.setText(this.f161404b.f161407c);
        r111.setVisibility(0);
        r111.setOnClickListener(new b(this, r101));
        return;
    L41:
        r111.setVisibility(8);
        View r113 = r101.findViewById(R.id.divider);
        if (r113 == null) goto L47;
        r113.setVisibility(8);
        return;
    L47:
        return;
    L36:
        if (r112.length() == 0) goto L39;
        r103 = false;
        goto L39
    }

    public a1(Context r100, a r101) {
        super(r100, R.style.ttlive_live_dialog);
        this.f161404b = r101;
        this.f161403a = 280;
    }
}
