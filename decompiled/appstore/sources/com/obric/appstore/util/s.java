package com.obric.appstore.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseFragment;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.status.OPageStatus;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sa.c f11088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f11089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f11090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OPageStatus f11091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OPageStatus f11092e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OPageStatus f11093f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public KeyboardHeightWatcher f11094g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11095h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11096i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11097j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f11098k;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f11099a;

        public a(s r10) {
            this.f11099a = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            kotlin.jvm.internal.q.g(r10, "animation");
            if (s.b(this.f11099a) != r10) goto L6;
            s.d(this.f11099a, null);
            return;
        }
    }

    public static final class b implements KeyboardHeightWatcher.OnKeyboardHeightChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f11100a;

        public b(s r10) {
            this.f11100a = r10;
        }

        @Override // com.obric.appstore.util.KeyboardHeightWatcher.OnKeyboardHeightChangedListener
        public void onKeyboardHeightChanged(int r10, boolean r11) {
            s.c(this.f11100a, r10, r11);
        }
    }

    public s(BaseFragment r10, sa.c r11, View r12) {
        kotlin.jvm.internal.q.g(r10, "fragment");
        kotlin.jvm.internal.q.g(r11, "binding");
        this.f11088a = r11;
        this.f11089b = r12;
        this.f11090c = new WeakReference(r10);
    }

    public static /* synthetic */ void a(s r10, ValueAnimator r11) {
        g(r10, r11);
    }

    public static final /* synthetic */ ValueAnimator b(s r10) {
        return r10.f11098k;
    }

    public static final /* synthetic */ void c(s r10, int r11, boolean r12) {
        r10.l(r11, r12);
    }

    public static final /* synthetic */ void d(s r10, ValueAnimator r11) {
        r10.f11098k = r11;
    }

    public static final void g(s r10, ValueAnimator r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlin.Int");
        int r13 = ((Integer) r12).intValue();
        r10.f11088a.b().setPadding(r10.f11088a.b().getPaddingLeft(), r10.f11088a.b().getPaddingTop(), r10.f11088a.b().getPaddingRight(), r13);
    }

    public final void e(int r10, boolean r11) {
        if (r11 == true) goto L6;
        r10 = this.f11096i;
    L6:
        if (this.f11097j == r11) goto L9;
        f(r10);
        this.f11097j = r11;
        return;
    }

    public final void f(int r10) {
        i();
        int r11 = this.f11088a.b().getPaddingBottom();
        if (r11 != r10) goto L5;
        return;
    L5:
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r11, r10});
        r12.setDuration(200);
        r12.addUpdateListener(new r(this));
        r12.addListener(new a(this));
        r12.start();
        this.f11098k = r12;
    }

    public final void h(View r10) {
        kotlin.jvm.internal.q.g(r10, "rootView");
        BaseFragment r11 = (BaseFragment) this.f11090c.get();
        if (r11 != null) goto L5;
        return;
    L5:
        KeyboardHeightWatcher r12 = new KeyboardHeightWatcher(r10, r11.getViewLifecycleOwner().getLifecycle());
        r12.setOnKeyboardHeightChangedListener(new b(this));
        this.f11094g = r12;
        this.f11096i = this.f11088a.b().getPaddingBottom();
    }

    public final void i() {
        ValueAnimator r10 = this.f11098k;
        if (r10 == null) goto L5;
        r10.removeAllListeners();
        r10.cancel();
    L5:
        this.f11098k = null;
    }

    public final void j() {
        i();
        KeyboardHeightWatcher r10 = this.f11094g;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        this.f11094g = null;
    }

    public final sa.c k() {
        return this.f11088a;
    }

    public final void l(int r10, boolean r11) {
        this.f11095h = r10;
        OPageStatus r12 = this.f11091d;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.getVisibility() != 0) goto L9;
        e(r10, r11);
        return;
    }

    public final void m() {
        i();
        if (this.f11088a.b().getVisibility() == 8) goto L5;
        this.f11088a.b().setVisibility(8);
    L5:
        View r10 = this.f11089b;
        if (r10 != null) goto L8;
    L10:
        View r11 = this.f11089b;
        if (r11 == null) goto L16;
        r11.setVisibility(0);
        return;
    L16:
        return;
    L8:
        if (r10.getVisibility() != 0) goto L10;
    }

    public final void n() {
        if (this.f11097j == false) goto L6;
        f(this.f11096i);
        this.f11097j = false;
        return;
    }

    public final void o() {
        BaseFragment r10 = (BaseFragment) this.f11090c.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f11093f != null) goto L14;
        View r11 = this.f11088a.f24568b.inflate();
        OPageStatus r12 = null;
        if ((r11 instanceof OPageStatus) == false) goto L10;
        OPageStatus r13 = (OPageStatus) r11;
    L11:
        if (r13 == null) goto L13;
        r10.Q(r13);
        r12 = r13;
    L13:
        this.f11093f = r12;
        goto L14
    L10:
        r13 = null;
    L14:
        OPageStatus r14 = this.f11091d;
        if (r14 != null) goto L17;
    L19:
        OPageStatus r15 = this.f11091d;
        if (r15 == null) goto L23;
        r15.setVisibility(8);
    L23:
        OPageStatus r16 = this.f11092e;
        if (r16 != null) goto L26;
    L28:
        OPageStatus r17 = this.f11092e;
        if (r17 == null) goto L32;
        r17.setVisibility(8);
    L32:
        OPageStatus r18 = this.f11093f;
        if (r18 != null) goto L35;
    L37:
        OPageStatus r19 = this.f11093f;
        if (r19 == null) goto L42;
        r19.setVisibility(0);
    L42:
        if (this.f11088a.b().getVisibility() == 0) goto L44;
        this.f11088a.b().setVisibility(0);
    L44:
        View r20 = this.f11089b;
        if (r20 != null) goto L47;
    L49:
        View r21 = this.f11089b;
        if (r21 == null) goto L55;
        r21.setVisibility(8);
        return;
    L55:
        return;
    L47:
        if (r20.getVisibility() != 8) goto L49;
        return;
    L35:
        if (r18.getVisibility() != 0) goto L37;
    L26:
        if (r16.getVisibility() != 8) goto L28;
    L17:
        if (r14.getVisibility() != 8) goto L19;
        goto L19
    }

    public final void p() {
        BaseFragment r10 = (BaseFragment) this.f11090c.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f11091d != null) goto L16;
        OPageStatus r11 = null;
        View r12 = this.f11088a.f24569c.inflate();     // Catch: Exception -> L66
        if ((r12 instanceof OPageStatus) == false) goto L11;
        OPageStatus r13 = (OPageStatus) r12;     // Catch: Exception -> L66
    L12:
        if (r13 == null) goto L15;
        r10.R(r13);     // Catch: Exception -> L66
        r11 = r13;
        goto L15
    L11:
        r13 = null;
    L15:
        this.f11091d = r11;
    L16:
        OPageStatus r14 = this.f11091d;
        if (r14 != null) goto L19;
    L21:
        OPageStatus r15 = this.f11091d;
        if (r15 == null) goto L25;
        r15.setVisibility(0);
    L25:
        OPageStatus r16 = this.f11092e;
        if (r16 != null) goto L28;
    L30:
        OPageStatus r17 = this.f11092e;
        if (r17 == null) goto L34;
        r17.setVisibility(8);
    L34:
        OPageStatus r18 = this.f11093f;
        if (r18 != null) goto L37;
    L39:
        OPageStatus r19 = this.f11093f;
        if (r19 == null) goto L44;
        r19.setVisibility(8);
    L44:
        if (this.f11088a.b().getVisibility() == 0) goto L46;
        this.f11088a.b().setVisibility(0);
    L46:
        View r20 = this.f11089b;
        if (r20 != null) goto L49;
    L51:
        View r21 = this.f11089b;
        if (r21 == null) goto L55;
        r21.setVisibility(8);
    L55:
        Context r22 = r10.getContext();
        if (r22 == null) goto L62;
        OPageStatus r23 = this.f11091d;
        if (r23 == null) goto L62;
        ODownloadProgressView r24 = r23.getLoadingView();
        if (r24 == null) goto L62;
        r24.setProcessingColor(ContextCompat.b(r22, R.color.oui_basic_text_3));
    L62:
        int r25 = this.f11095h;
        if (r25 <= 0) goto L69;
        e(r25, true);
        return;
    L69:
        return;
    L49:
        if (r20.getVisibility() != 8) goto L51;
    L37:
        if (r18.getVisibility() != 8) goto L39;
    L28:
        if (r16.getVisibility() != 8) goto L30;
    L19:
        if (r14.getVisibility() != 0) goto L21;
        goto L21
    }

    public final void q() {
        BaseFragment r10 = (BaseFragment) this.f11090c.get();
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f11092e != null) goto L14;
        View r11 = this.f11088a.f24570d.inflate();
        OPageStatus r12 = null;
        if ((r11 instanceof OPageStatus) == false) goto L10;
        OPageStatus r13 = (OPageStatus) r11;
    L11:
        if (r13 == null) goto L13;
        r10.S(r13);
        r12 = r13;
    L13:
        this.f11092e = r12;
        goto L14
    L10:
        r13 = null;
    L14:
        OPageStatus r14 = this.f11091d;
        if (r14 != null) goto L17;
    L19:
        OPageStatus r15 = this.f11091d;
        if (r15 == null) goto L23;
        r15.setVisibility(8);
    L23:
        OPageStatus r16 = this.f11092e;
        if (r16 != null) goto L26;
    L28:
        OPageStatus r17 = this.f11092e;
        if (r17 == null) goto L32;
        r17.setVisibility(0);
    L32:
        OPageStatus r18 = this.f11093f;
        if (r18 != null) goto L35;
    L37:
        OPageStatus r19 = this.f11093f;
        if (r19 == null) goto L42;
        r19.setVisibility(8);
    L42:
        if (this.f11088a.b().getVisibility() == 0) goto L44;
        this.f11088a.b().setVisibility(0);
    L44:
        View r20 = this.f11089b;
        if (r20 != null) goto L47;
    L49:
        View r21 = this.f11089b;
        if (r21 == null) goto L55;
        r21.setVisibility(8);
        return;
    L55:
        return;
    L47:
        if (r20.getVisibility() != 8) goto L49;
        return;
    L35:
        if (r18.getVisibility() != 8) goto L37;
    L26:
        if (r16.getVisibility() != 0) goto L28;
    L17:
        if (r14.getVisibility() != 8) goto L19;
        goto L19
    }
}
