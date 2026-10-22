package com.bytedanceos.appstore.buss.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.appstore.buss.entity.AppDetailGiftEntity;
import com.bytedanceos.appstore.buss.utilities.ImageUtilKt;
import com.obric.appstore.R;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppDetailGiftEntity f9253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2 f9254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x7.i f9255e;

    public d(Context r10, String r11, String r12, AppDetailGiftEntity r13, Function2 r14) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r13, "giftEntity");
        kotlin.jvm.internal.q.g(r14, "appOnClickListener");
        super(r10, R.style.TvAppDialogTheme);
        this.f9251a = r11;
        this.f9252b = r12;
        this.f9253c = r13;
        this.f9254d = r14;
    }

    public final void a() {
        x7.i r10 = this.f9255e;
        x7.i r11 = null;
        if (r10 != null) goto L5;
        kotlin.jvm.internal.q.y("binding");
        r10 = null;
    L5:
        r10.f25595f.setOnClickListener(this);
        AppDetailGiftEntity r12 = this.f9253c;
        x7.i r13 = this.f9255e;
        if (r13 != null) goto L8;
        kotlin.jvm.internal.q.y("binding");
        r13 = null;
    L8:
        r13.f25604o.setText(this.f9252b);
        x7.i r14 = this.f9255e;
        if (r14 != null) goto L11;
        kotlin.jvm.internal.q.y("binding");
        r14 = null;
    L11:
        ImageView r15 = r14.f25596g;
        kotlin.jvm.internal.q.f(r15, "ivLogo");
        ImageUtilKt.d(r15, this.f9251a);
        x7.i r16 = this.f9255e;
        if (r16 != null) goto L14;
        kotlin.jvm.internal.q.y("binding");
        r16 = null;
    L14:
        r16.f25602m.setText(this.f9253c.getName());
        com.bytedanceos.appstore.buss.utilities.e r17 = com.bytedanceos.appstore.buss.utilities.e.f8837a;
        long r18 = 1000;
        String r19 = r17.a(new Date(Long.parseLong(this.f9253c.getStartTime()) * r18), "yyyy-MM-dd HH:mm");
        String r20 = r17.a(new Date(Long.parseLong(this.f9253c.getEndTime()) * r18), "yyyy-MM-dd HH:mm");
        x7.i r21 = this.f9255e;
        if (r21 != null) goto L17;
        kotlin.jvm.internal.q.y("binding");
        r21 = null;
    L17:
        r21.f25603n.setText(getContext().getString(R.string.gift_data, new Object[]{r19, r20}));
        b(r12);
        x7.i r22 = this.f9255e;
        if (r22 != null) goto L20;
        kotlin.jvm.internal.q.y("binding");
        r22 = null;
    L20:
        r22.f25599j.setText(this.f9253c.getContent());
        x7.i r23 = this.f9255e;
        if (r23 != null) goto L23;
        kotlin.jvm.internal.q.y("binding");
    L24:
        r11.f25601l.setText(this.f9253c.getInstruction());
        return;
    L23:
        r11 = r23;
        goto L24
    }

    public final void b(AppDetailGiftEntity r10) {
        x7.i r11 = this.f9255e;
        x7.i r12 = null;
        if (r11 != null) goto L5;
        kotlin.jvm.internal.q.y("binding");
        r11 = null;
    L5:
        TextView r13 = r11.f25600k;
        kotlin.jvm.internal.x r14 = kotlin.jvm.internal.x.f21192a;
        String r15 = getContext().getString(R.string.gift_remain);
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        String r16 = String.format(r15, Arrays.copyOf(new Object[]{r10.getRestCount()}, 1));
        kotlin.jvm.internal.q.f(r16, "format(...)");
        r13.setText(r16);
        if (r10.getIfReceived() != 1) goto L19;
        x7.i r17 = this.f9255e;
        if (r17 != null) goto L10;
        kotlin.jvm.internal.q.y("binding");
        r17 = null;
    L10:
        r17.f25605p.setText(R.string.gift_btn_use);
        x7.i r18 = this.f9255e;
        if (r18 != null) goto L13;
        kotlin.jvm.internal.q.y("binding");
        r18 = null;
    L13:
        r18.f25605p.setAlpha(1.0f);
        x7.i r19 = this.f9255e;
        if (r19 != null) goto L16;
        kotlin.jvm.internal.q.y("binding");
    L17:
        r12.f25605p.setOnClickListener(this);
        return;
    L16:
        r12 = r19;
        goto L17
    L19:
        if (Integer.parseInt(r10.getRestCount()) != 0) goto L31;
        x7.i r20 = this.f9255e;
        if (r20 != null) goto L23;
        kotlin.jvm.internal.q.y("binding");
        r20 = null;
    L23:
        r20.f25605p.setText(R.string.gift_btn_over);
        x7.i r21 = this.f9255e;
        if (r21 != null) goto L26;
        kotlin.jvm.internal.q.y("binding");
        r21 = null;
    L26:
        r21.f25605p.setEnabled(false);
        x7.i r22 = this.f9255e;
        if (r22 != null) goto L29;
        kotlin.jvm.internal.q.y("binding");
    L30:
        r12.f25605p.setAlpha(0.3f);
        return;
    L29:
        r12 = r22;
        goto L30
    L31:
        x7.i r23 = this.f9255e;
        if (r23 != null) goto L34;
        kotlin.jvm.internal.q.y("binding");
        r23 = null;
    L34:
        r23.f25605p.setText(R.string.gift_btn_get);
        x7.i r24 = this.f9255e;
        if (r24 != null) goto L37;
        kotlin.jvm.internal.q.y("binding");
        r24 = null;
    L37:
        r24.f25605p.setAlpha(1.0f);
        x7.i r25 = this.f9255e;
        if (r25 != null) goto L40;
        kotlin.jvm.internal.q.y("binding");
    L41:
        r12.f25605p.setOnClickListener(this);
        return;
    L40:
        r12 = r25;
        goto L41
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        x7.i r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getId());
    L6:
        if (r12 != null) goto L9;
    L11:
        if (r12 != null) goto L14;
        return;
    L14:
        if (r12.intValue() != R.id.tv_use) goto L22;
        dismiss();
        Function2 r13 = this.f9254d;
        x7.i r14 = this.f9255e;
        if (r14 != null) goto L18;
        kotlin.jvm.internal.q.y("binding");
    L19:
        TextView r15 = r11.f25605p;
        kotlin.jvm.internal.q.f(r15, "tvUse");
        r13.mo0invoke(r15, this.f9253c);
        return;
    L18:
        r11 = r14;
        goto L19
    L22:
        return;
    L9:
        if (r12.intValue() != R.id.iv_close) goto L11;
        dismiss();
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        x7.i r11 = x7.i.c(getLayoutInflater());
        kotlin.jvm.internal.q.f(r11, "inflate(...)");
        this.f9255e = r11;
        if (r11 != null) goto L5;
        kotlin.jvm.internal.q.y("binding");
        r11 = null;
    L5:
        setContentView(r11.b());
        setCanceledOnTouchOutside(false);
        a();
    }
}
