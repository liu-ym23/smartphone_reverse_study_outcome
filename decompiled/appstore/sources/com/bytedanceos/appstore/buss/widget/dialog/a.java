package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.appstore.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2 f9245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x7.g f9246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f9247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9248d;

    public a(Context r10, Function2 r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "listener");
        super(r10, 2131887561);
        this.f9245a = r11;
        this.f9248d = "";
    }

    public final void a(float r10, String r11) {
        kotlin.jvm.internal.q.g(r11, ServerElements.CONTENT);
        this.f9247c = r10;
        this.f9248d = r11;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f9247c = 0.0f;
        this.f9248d = "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        x7.g r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getId());
    L6:
        if (r12 != null) goto L9;
    L11:
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.intValue() != R.id.tv_dialog_confirm) goto L29;
        x7.g r13 = this.f9246b;
        if (r13 != null) goto L18;
        kotlin.jvm.internal.q.y("binding");
        r13 = null;
    L18:
        int r14 = (int) r13.f25567c.getRating();
        if (r14 > 0) goto L22;
        com.bytedanceos.appstore.buss.utilities.s.d(r10, "请打分");
        return;
    L22:
        x7.g r15 = this.f9246b;
        if (r15 != null) goto L25;
        kotlin.jvm.internal.q.y("binding");
    L26:
        this.f9245a.mo0invoke(String.valueOf(r14), r11.f25566b.getText().toString());
        dismiss();
        return;
    L25:
        r11 = r15;
        goto L26
    L29:
        return;
    L9:
        if (r12.intValue() != R.id.tv_dialog_cancel) goto L11;
        dismiss();
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        x7.g r11 = x7.g.c(getLayoutInflater());
        kotlin.jvm.internal.q.f(r11, "inflate(...)");
        this.f9246b = r11;
        x7.g r12 = null;
        if (r11 != null) goto L5;
        kotlin.jvm.internal.q.y("binding");
        r11 = null;
    L5:
        setContentView(r11.b());
        setCanceledOnTouchOutside(false);
        Window r13 = getWindow();
        if (r13 == null) goto L8;
        WindowManager.LayoutParams r14 = r13.getAttributes();
    L9:
        if (r14 == null) goto L12;
        r14.width = -1;
    L12:
        if (r14 == null) goto L15;
        r14.height = -2;
    L15:
        if (r14 == null) goto L18;
        r14.gravity = 48;
    L18:
        Window r15 = getWindow();
        if (r15 == null) goto L22;
        r15.setAttributes(r14);
    L22:
        x7.g r16 = this.f9246b;
        if (r16 != null) goto L25;
        kotlin.jvm.internal.q.y("binding");
        r16 = null;
    L25:
        r16.f25568d.setOnClickListener(this);
        x7.g r17 = this.f9246b;
        if (r17 != null) goto L28;
        kotlin.jvm.internal.q.y("binding");
    L29:
        r12.f25569e.setOnClickListener(this);
        return;
    L28:
        r12 = r17;
        goto L29
    L8:
        r14 = null;
        goto L9
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        float r10 = this.f9247c;
        x7.g r11 = null;
        if (r10 <= 0.0f) goto L11;
        if (r10 > 5.0f) goto L11;
        x7.g r12 = this.f9246b;
        if (r12 != null) goto L9;
        kotlin.jvm.internal.q.y("binding");
        r12 = null;
    L9:
        r12.f25567c.setRating(this.f9247c);
    L11:
        if (kotlin.text.o.r(this.f9248d) == true) goto L21;
        x7.g r13 = this.f9246b;
        if (r13 != null) goto L15;
        kotlin.jvm.internal.q.y("binding");
        r13 = null;
    L15:
        r13.f25566b.setText(this.f9248d);
        x7.g r14 = this.f9246b;
        if (r14 != null) goto L18;
        kotlin.jvm.internal.q.y("binding");
    L19:
        r11.f25566b.setSelection(this.f9248d.length());
        return;
    L18:
        r11 = r14;
        goto L19
    }
}
