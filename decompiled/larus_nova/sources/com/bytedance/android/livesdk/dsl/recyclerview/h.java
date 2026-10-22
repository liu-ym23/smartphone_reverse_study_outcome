package com.bytedance.android.livesdk.dsl.recyclerview;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleDSLViewHolder f122801a;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public h(SingleDSLViewHolder r100) {
        this.f122801a = r100;
    }

    @Override // yt1.m
    public final void a(final com.bytedance.android.livesdk.dslservice.a r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        this.f122801a.f122775b.a(1);
        Function1<? super Function0<Unit>, Unit> r103 = this.f122801a.f122778e.f122793b;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(new SingleDSLViewHolder$2$onLoadSuccess$1(this, r100));
        return;
    }

    @Override // yt1.m
    public final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reason");
        m.a.a(r100, r101);
    }
}
