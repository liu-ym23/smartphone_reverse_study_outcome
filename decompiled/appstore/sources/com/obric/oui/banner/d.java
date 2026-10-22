package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.banner.interfaces.BannerOperator;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BannerOperator f12454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoroutineScope f12456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Observer f12457f;

    public d(View r10) {
        q.g(r10, "view");
        super(r10);
        this.f12455d = -1;
        this.f12457f = new c(this);
    }

    public static /* synthetic */ void a(d r10, Integer r11) {
        m(r10, r11);
    }

    public static /* synthetic */ void c(d r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.b(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSelectStatus");
    }

    public static final void m(d r10, Integer r11) {
        q.g(r10, "this$0");
        c(r10, false, 1, null);
    }

    public final void b(boolean r10) {
        BannerOperator r11 = this.f12454c;
        if (r11 == null) goto L17;
        LiveData r12 = r11.getSelectedPosition();
        if (r12 == null) goto L17;
        Integer r13 = (Integer) r12.e();
        int r14 = this.f12455d;
        if (r13 == null) goto L17;
        if (r13.intValue() != r14) goto L17;
        if (r10 == false) goto L15;
    L16:
        i();
        goto L17
    L15:
        if (this.f12452a == false) goto L16;
    L17:
        BannerOperator r15 = this.f12454c;
        if (r15 == null) goto L29;
        LiveData r16 = r15.getSelectedPosition();
        if (r16 == null) goto L29;
        Integer r17 = (Integer) r16.e();
        int r18 = this.f12455d;
        if (r17 == null) goto L29;
        if (r17.intValue() != r18) goto L29;
        return;
    L29:
        if (r10 == false) goto L31;
    L32:
        j();
        return;
    L31:
        if (this.f12452a == true) goto L32;
    }

    public final CoroutineScope d() {
        CoroutineScope r10 = this.f12456e;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("selectScope");
        return null;
    }

    public void e() {
        BannerOperator r10 = this.f12454c;
        if (r10 == null) goto L9;
        LiveData r11 = r10.getSelectedPosition();
        if (r11 == null) goto L9;
        r11.j(this.f12457f);
    L9:
        this.f12453b = true;
    }

    public final void f(int r10, BannerData r11) {
        q.g(r11, "data");
        this.f12455d = r10;
        g(r11);
        b(true);
    }

    public abstract void g(BannerData r10);

    public void h() {
        BannerOperator r10 = this.f12454c;
        if (r10 == null) goto L9;
        LiveData r11 = r10.getSelectedPosition();
        if (r11 == null) goto L9;
        r11.n(this.f12457f);
    L9:
        this.f12453b = false;
        j();
    }

    public void i() {
        o(d0.a(l0.c().plus(x1.b(null, 1, null))));
        this.f12452a = true;
    }

    public void j() {
        if (this.f12456e == null) goto L5;
        d0.d(d(), null, 1, null);
    L5:
        this.f12452a = false;
    }

    public void k() {
    }

    public void l() {
        if (this.f12452a == false) goto L9;
        BannerOperator r10 = this.f12454c;
        if (r10 == null) goto L10;
        r10.currentItemPlayDone();
        return;
    L10:
        return;
    }

    public final void n(BannerOperator r10) {
        this.f12454c = r10;
    }

    public final void o(CoroutineScope r10) {
        q.g(r10, "<set-?>");
        this.f12456e = r10;
    }
}
