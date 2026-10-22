package com.bytedance.android.live.profit.lottery;

import android.content.Context;
import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes47.dex */
public final class c3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f88055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f88056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f88057c;

    public c3(i1 r100, Context r101, Ref.ObjectRef r102) {
        this.f88055a = r100;
        this.f88056b = r101;
        this.f88057c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((Function0) this.f88057c.element).invoke();
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(this.f88056b, this.f88055a.f88112a);
    }
}
