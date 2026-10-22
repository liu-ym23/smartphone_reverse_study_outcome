package com.bytedance.android.livesdk.feed.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppointmentListAdapter.AppointmentItemViewHolder f123616a;

    public a(AppointmentListAdapter.AppointmentItemViewHolder r100) {
        this.f123616a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qm1.a r101 = (qm1.a) r100;
        long r102 = r101.f533837a;
        Appointment r103 = this.f123616a.f123584g;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r102 != r103.appointmentId) goto L28;
        r103.isReserved = Boolean.valueOf(r101.f533838b);
        AppointmentListAdapter.AppointmentItemViewHolder r104 = this.f123616a;
        Appointment r105 = r104.f123584g;
        Drawable r106 = null;
        if (r105 == null) goto L9;
        Boolean r107 = r105.isReserved;
    L11:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L19;
        r104.f123587j = "cancel_reserve";
        r104.f123582e.setText(s1.B(R.string.ttlive_has_reserved));
        Drawable r108 = r104.f123582e.getBackground();
        if ((r108 instanceof GradientDrawable) == false) goto L16;
        r106 = r108;
    L16:
        GradientDrawable r109 = (GradientDrawable) r106;
        if (r109 == null) goto L29;
        r109.setColor(s1.h(R.color.ttlive_std_bg_1));
        return;
    L29:
        return;
    L19:
        r104.f123587j = "reserve";
        r104.f123582e.setText(s1.B(R.string.ttlive_reserve));
        Drawable r110 = r104.f123582e.getBackground();
        if ((r110 instanceof GradientDrawable) == false) goto L23;
        r106 = r110;
    L23:
        GradientDrawable r111 = (GradientDrawable) r106;
        if (r111 == null) goto L31;
        r111.setColor(s1.h(R.color.ttlive_normal_btn_red_bg));
        return;
    L31:
        return;
    L9:
        r107 = null;
        goto L11
    }
}
