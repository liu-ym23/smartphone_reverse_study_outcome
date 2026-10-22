package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements ak6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f138673a;

    public f(TextView r100) {
        this.f138673a = r100;
    }

    @Override // ak6.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // ak6.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        TextView r101 = this.f138673a;
        if (r101 == null) goto L6;
        r101.setText(r100.f4074a);
        return;
    }
}
