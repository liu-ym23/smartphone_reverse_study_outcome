package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.link.model.m2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PKRivalsRankViewHolder$handleMultiLinkClick$4 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKRivalsRankViewHolder f96244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m2 f96245b;

    public PKRivalsRankViewHolder$handleMultiLinkClick$4(PKRivalsRankViewHolder r100, m2 r101) {
        this.f96244a = r100;
        this.f96245b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Function0<Unit> r102 = new PKRivalsRankViewHolder$handleMultiLinkClick$4$applyRunnable$1(this);
        this.f96244a.f96237p.finishMultiAnchor(7, r102, false, "leave_for_apply", true);
        r100.dismiss();
    }
}
