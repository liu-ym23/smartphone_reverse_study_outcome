package com.bytedanceos.appstore.buss.utilities;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import kotlin.jvm.functions.Function0;
import x7.h0;
import x7.i0;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f8861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f8862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f8863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f8864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i0 f8865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f8866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0 f8867g;

    public n(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "view");
        View r11 = View.inflate(r10.getContext(), R.layout.tv_common_state_view, null);
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r12 = (ViewGroup) r11;
        this.f8861a = r12;
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f8861a.setVisibility(8);
        r10.addView(this.f8861a);
    }

    public static /* synthetic */ void a(n r10, View r11) {
        i(r10, r11);
    }

    public static /* synthetic */ void e(n r10, String r11, String r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = BaseApplication.c().getString(R.string.tv_state_empty_default_text);
        kotlin.jvm.internal.q.f(r11, "getString(...)");
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r13 = R.drawable.buy_empty;
    L11:
        r10.d(r11, r12, r13);
    }

    public static /* synthetic */ void h(n r10, int r11, String r12, String r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = R.drawable.tv_ic_status_no_network;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = BaseApplication.c().getString(R.string.tv_state_retry_default_title);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = BaseApplication.c().getString(R.string.tv_state_retry_default_btn_text);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
    L11:
        r10.g(r11, r12, r13, r14);
    }

    public static final void i(n r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        Function0 r12 = r10.f8867g;
        if (r12 == null) goto L6;
        r12.invoke();
        return;
    }

    public final void b() {
        ViewGroup r10 = this.f8862b;
        if (r10 != null) goto L5;
    L7:
        ViewGroup r11 = this.f8862b;
        if (r11 == null) goto L11;
        r11.setVisibility(8);
    L11:
        ViewGroup r12 = this.f8863c;
        if (r12 != null) goto L14;
    L16:
        ViewGroup r13 = this.f8863c;
        if (r13 == null) goto L20;
        r13.setVisibility(8);
    L20:
        ViewGroup r14 = this.f8864d;
        if (r14 != null) goto L23;
    L25:
        ViewGroup r15 = this.f8864d;
        if (r15 == null) goto L30;
        r15.setVisibility(8);
    L30:
        if (this.f8861a.getVisibility() == 8) goto L33;
        this.f8861a.setVisibility(8);
        return;
    L33:
        return;
    L23:
        if (r14.getVisibility() != 8) goto L25;
    L14:
        if (r12.getVisibility() != 8) goto L16;
    L5:
        if (r10.getVisibility() != 8) goto L7;
        goto L7
    }

    public final void c(Function0 r10) {
        this.f8867g = r10;
    }

    public final void d(String r10, String r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "emptyText");
        ViewStub r13 = (ViewStub) this.f8861a.findViewById(R.id.vs_state_empty_view);
        if (r13 == null) goto L5;
        View r14 = r13.inflate();
        kotlin.jvm.internal.q.e(r14, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r15 = (ViewGroup) r14;
        this.f8864d = r15;
        kotlin.jvm.internal.q.d(r15);
        this.f8866f = h0.a(r15);
    L5:
        h0 r16 = this.f8866f;
        if (r16 == null) goto L10;
        ImageView r17 = r16.f25583b;
        if (r17 == null) goto L10;
        r17.setImageResource(r12);
    L10:
        h0 r18 = this.f8866f;
        TextView r19 = null;
        if (r18 == null) goto L13;
        TextView r20 = r18.f25585d;
    L14:
        if (r20 == null) goto L17;
        r20.setText(r10);
    L17:
        if (r11 == null) goto L24;
        h0 r21 = this.f8866f;
        if (r21 == null) goto L21;
        r19 = r21.f25584c;
    L21:
        if (r19 == null) goto L24;
        r19.setText(r11);
    L24:
        ViewGroup r22 = this.f8862b;
        if (r22 != null) goto L27;
    L29:
        ViewGroup r23 = this.f8862b;
        if (r23 == null) goto L33;
        r23.setVisibility(8);
    L33:
        ViewGroup r24 = this.f8863c;
        if (r24 != null) goto L36;
    L38:
        ViewGroup r25 = this.f8863c;
        if (r25 == null) goto L42;
        r25.setVisibility(8);
    L42:
        ViewGroup r26 = this.f8864d;
        if (r26 != null) goto L45;
    L47:
        ViewGroup r27 = this.f8864d;
        if (r27 == null) goto L52;
        r27.setVisibility(0);
    L52:
        if (this.f8861a.getVisibility() == 0) goto L55;
        this.f8861a.setVisibility(0);
        return;
    L55:
        return;
    L45:
        if (r26.getVisibility() != 0) goto L47;
    L36:
        if (r24.getVisibility() != 8) goto L38;
    L27:
        if (r22.getVisibility() != 8) goto L29;
    L13:
        r20 = null;
        goto L14
    }

    public final void f() {
        ViewStub r10 = (ViewStub) this.f8861a.findViewById(R.id.vs_state_loading_view);
        if (r10 == null) goto L5;
        View r11 = r10.inflate();
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f8862b = (ViewGroup) r11;
    L5:
        ViewGroup r12 = this.f8862b;
        if (r12 != null) goto L8;
    L10:
        ViewGroup r13 = this.f8862b;
        if (r13 == null) goto L14;
        r13.setVisibility(0);
    L14:
        ViewGroup r14 = this.f8863c;
        if (r14 != null) goto L17;
    L19:
        ViewGroup r15 = this.f8863c;
        if (r15 == null) goto L23;
        r15.setVisibility(8);
    L23:
        ViewGroup r16 = this.f8864d;
        if (r16 != null) goto L26;
    L28:
        ViewGroup r17 = this.f8864d;
        if (r17 == null) goto L33;
        r17.setVisibility(8);
    L33:
        if (this.f8861a.getVisibility() == 0) goto L36;
        this.f8861a.setVisibility(0);
        return;
    L36:
        return;
    L26:
        if (r16.getVisibility() != 8) goto L28;
    L17:
        if (r14.getVisibility() != 8) goto L19;
    L8:
        if (r12.getVisibility() != 0) goto L10;
        goto L10
    }

    public final void g(int r10, String r11, String r12, String r13) {
        kotlin.jvm.internal.q.g(r11, "retryTitle");
        kotlin.jvm.internal.q.g(r12, "retrySubTitle");
        kotlin.jvm.internal.q.g(r13, "retryBtnText");
        ViewStub r14 = (ViewStub) this.f8861a.findViewById(R.id.vs_state_retry_view);
        if (r14 == null) goto L9;
        View r15 = r14.inflate();
        kotlin.jvm.internal.q.e(r15, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r16 = (ViewGroup) r15;
        this.f8863c = r16;
        kotlin.jvm.internal.q.d(r16);
        i0 r17 = i0.a(r16);
        this.f8865e = r17;
        if (r17 == null) goto L9;
        TextView r18 = r17.f25608c;
        if (r18 == null) goto L9;
        r18.setOnClickListener(new m(this));
    L9:
        i0 r19 = this.f8865e;
        if (r19 == null) goto L12;
        r19.f25607b.setImageResource(r10);
        r19.f25610e.setText(r11);
        r19.f25609d.setText(r12);
        r19.f25608c.setText(r13);
    L12:
        ViewGroup r20 = this.f8862b;
        if (r20 != null) goto L15;
    L17:
        ViewGroup r21 = this.f8862b;
        if (r21 == null) goto L21;
        r21.setVisibility(8);
    L21:
        ViewGroup r22 = this.f8863c;
        if (r22 != null) goto L24;
    L26:
        ViewGroup r23 = this.f8863c;
        if (r23 == null) goto L30;
        r23.setVisibility(0);
    L30:
        ViewGroup r24 = this.f8864d;
        if (r24 != null) goto L33;
    L35:
        ViewGroup r25 = this.f8864d;
        if (r25 == null) goto L40;
        r25.setVisibility(8);
    L40:
        if (this.f8861a.getVisibility() == 0) goto L43;
        this.f8861a.setVisibility(0);
        return;
    L43:
        return;
    L33:
        if (r24.getVisibility() != 8) goto L35;
    L24:
        if (r22.getVisibility() != 0) goto L26;
    L15:
        if (r20.getVisibility() != 8) goto L17;
        goto L17
    }
}
