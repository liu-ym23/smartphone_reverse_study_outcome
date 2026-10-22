package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinAnswerHighlightPageItemView f138746a;

    public a(PinAnswerHighlightPageItemView r100) {
        this.f138746a = r100;
    }

    @Override // qb2.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f138746a.f138733c.setText(r100.f4074a);
        UtilityKotlinExtentionsKt.t(this.f138746a.f138732b);
        UtilityKotlinExtentionsKt.w(this.f138746a.f138733c);
    }
}
