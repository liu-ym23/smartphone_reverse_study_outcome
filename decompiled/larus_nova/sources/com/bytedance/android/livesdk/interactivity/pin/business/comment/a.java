package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PinCommentHighlightPageItemView f138665a;

    public a(PinCommentHighlightPageItemView r100) {
        this.f138665a = r100;
    }

    @Override // qb2.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f138665a.f138637c.setText(r100.f4074a);
        UtilityKotlinExtentionsKt.t(this.f138665a.f138636b);
        UtilityKotlinExtentionsKt.w(this.f138665a.f138637c);
    }
}
