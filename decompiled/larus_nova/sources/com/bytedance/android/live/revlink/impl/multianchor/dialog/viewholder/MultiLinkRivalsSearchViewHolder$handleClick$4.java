package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.link.model.x8;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiLinkRivalsSearchViewHolder$handleClick$4 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiLinkRivalsSearchViewHolder f93806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x8 f93807b;

    public MultiLinkRivalsSearchViewHolder$handleClick$4(MultiLinkRivalsSearchViewHolder r100, x8 r101) {
        this.f93806a = r100;
        this.f93807b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Function0<Unit> r102 = new MultiLinkRivalsSearchViewHolder$handleClick$4$applyRunnable$1(this);
        this.f93806a.f93800q.finishMultiAnchor(7, r102, false, "leave_for_apply", true);
        r100.dismiss();
    }
}
