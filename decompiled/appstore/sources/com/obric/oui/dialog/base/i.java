package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DialogInterface.OnDismissListener f14430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DialogInterface.OnCancelListener f14431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DialogInterface.OnShowListener f14432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DialogInterface.OnShowListener f14433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f14434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AbstractDialog.CloseIconStyle f14437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pair f14438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f14439k;

    public i(Context r10) {
        q.g(r10, "context");
        this.f14429a = r10;
        this.f14435g = true;
        this.f14437i = AbstractDialog.CloseIconStyle.DARK;
        this.f14438j = kotlin.d.a(null, null);
    }

    public static /* synthetic */ i k(i r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.j(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCloseIcon");
    }

    public final AbstractDialog a() {
        AbstractDialog r10 = c();
        r10.setCompleteShowListener(this.f14433e);
        Integer r11 = this.f14439k;
        if (r11 == null) goto L6;
        r10.r0(r11.intValue());
    L6:
        r10.h0(this.f14436h, this.f14434f);
        r10.setCancelable(this.f14435g);
        r10.D(this.f14437i, (Integer) this.f14438j.getFirst(), (Integer) this.f14438j.getSecond());
        return r10;
    }

    public i b(boolean r10) {
        this.f14435g = r10;
        return this;
    }

    public abstract AbstractDialog c();

    public final DialogInterface.OnCancelListener d() {
        return this.f14431c;
    }

    public final DialogInterface.OnDismissListener e() {
        return this.f14430b;
    }

    public final boolean f() {
        return this.f14436h;
    }

    public final DialogInterface.OnShowListener g() {
        return this.f14432d;
    }

    public final i h(DialogInterface.OnDismissListener r10) {
        q.g(r10, "onDismissListener");
        this.f14430b = r10;
        return this;
    }

    public final void i() {
        a().show();
    }

    public i j(boolean r10, View.OnClickListener r11) {
        this.f14436h = r10;
        this.f14434f = r11;
        return this;
    }

    public final void setCancelListener$OUI_standardRelease(@Nullable DialogInterface.OnCancelListener r10) {
        this.f14431c = r10;
    }

    public final void setCompleteShowListener$OUI_standardRelease(@Nullable DialogInterface.OnShowListener r10) {
        this.f14433e = r10;
    }

    public final void setDismissListener$OUI_standardRelease(@Nullable DialogInterface.OnDismissListener r10) {
        this.f14430b = r10;
    }

    public final void setOnCloseClickListener$OUI_standardRelease(@Nullable View.OnClickListener r10) {
        this.f14434f = r10;
    }

    public final void setShowListener$OUI_standardRelease(@Nullable DialogInterface.OnShowListener r10) {
        this.f14432d = r10;
    }
}
