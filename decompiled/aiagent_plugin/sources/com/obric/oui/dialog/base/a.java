package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.obric.oui.dialog.base.AbstractDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: AbstractDialogBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<D extends AbstractDialog> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f35101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogInterface.OnDismissListener f35102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DialogInterface.OnCancelListener f35103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DialogInterface.OnShowListener f35104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DialogInterface.OnShowListener f35105e;
    private View.OnClickListener f;
    private boolean g;
    private boolean h;
    private AbstractDialog.a i;
    private m<Integer, Integer> j;
    private Integer k;

    public abstract D b();

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f35101a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.g = true;
        this.i = AbstractDialog.a.f35064b;
        this.j = s.a(null, null);
    }

    public final DialogInterface.OnDismissListener c() {
        return this.f35102b;
    }

    public final DialogInterface.OnCancelListener d() {
        return this.f35103c;
    }

    public final DialogInterface.OnShowListener e() {
        return this.f35104d;
    }

    public final boolean f() {
        return this.h;
    }

    public a<D> c(boolean r1) {
        this.g = r1;
        return this;
    }

    public static /* synthetic */ a a(a r2, boolean r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.a(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public a<D> a(boolean r3, View.OnClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        this.h = r3;
        this.f = r5;
        return this;
    }

    public final D g() {
        D r0 = (D) b();
        r0.setCompleteShowListener(this.f35105e);
        Integer r1 = this.k;
        if (r1 == null) goto L6;
        r0.setWindowFixedHeight(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue());
    L6:
        r0.setCloseIconEnabled(this.h, this.f);
        r0.setCancelable(this.g);
        r0.applyCloseIconStyle(this.i, (Integer) ZeusTransformUtils.preCheckCast(this.j.a(), Integer.class, "com.obric.aiagent.plugin"), (Integer) ZeusTransformUtils.preCheckCast(this.j.b(), Integer.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    public final void h() {
        g().show();
    }
}
