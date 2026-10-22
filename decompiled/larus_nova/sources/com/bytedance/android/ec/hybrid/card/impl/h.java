package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz6.IKitView;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IKitView f46534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnnieXLynxView f46535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f46536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xj.b f46537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xj.a f46538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f46539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f46540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f46541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f46542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECLynxLoadParam f46543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f46544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.card.event.e f46545l;

    public h(ECLynxCard r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxCard");
        this.f46536c = String.valueOf(hashCode());
        this.f46539f = true;
    }

    public final void a(ECLynxLoadParam r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f46313d;
    L5:
        this.f46544k = r101;
        this.f46543j = r100;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void b(IKitView r100) {
        if (r100 == null) goto L4;
        int r101 = bk.b.f19282a;
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Unit r102 = Unit.INSTANCE;
        IKitView r103 = r100;
    L5:
        this.f46534a = r103;
        if (r100 != null) goto L11;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.f() != null) goto L15;
        return;
    L15:
        return;
    L11:
        r100.f().getClass();
        return;
    L4:
        r103 = null;
        goto L5
    }
}
