package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import ak6.g;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelWidgetV2 f134474a;

    public d(ChatChannelWidgetV2 r100) {
        this.f134474a = r100;
    }

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f134474a.f134457k;
        if (r101 == null) goto L6;
        r101.setText(r100.f4074a);
        return;
    }
}
