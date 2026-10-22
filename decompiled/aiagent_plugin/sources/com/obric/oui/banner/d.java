package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: BannerViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends RecyclerView.u {
    private boolean r;
    protected am s;
    private boolean t;
    private com.obric.oui.banner.b.a u;
    private int v;
    private final w<Integer> w;

    public static /* synthetic */ void lambda$hNuS4F3mSrNC1QRP5OumuroXcZ4(d r0, Integer r1) {
        a(r0, r1);
    }

    public void J() {
    }

    public abstract void a(b r1);

    public d(View r2) {
        o.e(r2, "view");
        super(r2);
        this.v = -1;
        this.w = new $$Lambda$d$hNuS4F3mSrNC1QRP5OumuroXcZ4(this);
    }

    public final void a(com.obric.oui.banner.b.a r3) {
        this.u = (com.obric.oui.banner.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.a.class, "com.obric.aiagent.plugin");
    }

    public final am E() {
        am r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("selectScope");
        return null;
    }

    public final void a(am r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.s = r4;
    }

    private static final void a(d r2, Integer r3) {
        o.e(r2, "this$0");
        a(r2, false, 1, null);
    }

    public final void a(int r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "data");
        this.v = r3;
        a(r5);
        b(true);
    }

    public void F() {
        com.obric.oui.banner.b.a r0 = this.u;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.a(this.w);
    L9:
        this.t = true;
    }

    public void G() {
        com.obric.oui.banner.b.a r0 = this.u;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.b(this.w);
    L9:
        this.t = false;
        I();
    }

    static /* synthetic */ void a(d r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.b(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSelectStatus");
    }

    private final void b(boolean r6) {
        com.obric.oui.banner.b.a r0 = this.u;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L4:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L19;
        if (r6 == false) goto L17;
    L18:
        H();
        goto L19
    L17:
        if (this.r == false) goto L18;
    L19:
        com.obric.oui.banner.b.a r3 = this.u;
        if (r3 != null) goto L22;
    L21:
        r1 = false;
    L30:
        if (r1 == true) goto L36;
        if (r6 == false) goto L33;
    L34:
        I();
        return;
    L33:
        if (this.r == true) goto L34;
        return;
    L36:
        return;
    L22:
        LiveData<Integer> r4 = r3.getSelectedPosition();
        if (r4 == null) goto L21;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.a(), Integer.class, "com.obric.aiagent.plugin");
        int r7 = this.v;
        if (r5 == null) goto L21;
        if (r5.intValue() != r7) goto L21;
    L5:
        LiveData<Integer> r8 = r0.getSelectedPosition();
        if (r8 == null) goto L4;
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8.a(), Integer.class, "com.obric.aiagent.plugin");
        int r10 = this.v;
        if (r9 == null) goto L4;
        if (r9.intValue() != r10) goto L4;
        r2 = true;
        goto L14
    }

    public void H() {
        a(an.a(bd.b().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin"))));
        this.r = true;
    }

    public void I() {
        if (this.s == null) goto L5;
        an.a(E(), null, 1, null);
    L5:
        this.r = false;
    }
}
