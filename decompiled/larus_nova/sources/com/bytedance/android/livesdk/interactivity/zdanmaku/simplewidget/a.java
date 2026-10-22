package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements qb2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f141741b;

    @Override // qb2.e
    public final void a(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        SpannableString r101 = r100.f4074a;
        this.f141741b.setRenderSpan(r101);
        p0 r102 = this.f141741b;
        if ((r102 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.d) == false) goto L6;
        this.f141740a.f141711e.a(r102);
        return;
    }

    public a(PortraitSimpleZDanmakuPresenter r100, p0 r101) {
        this.f141740a = r100;
        this.f141741b = r101;
    }
}
