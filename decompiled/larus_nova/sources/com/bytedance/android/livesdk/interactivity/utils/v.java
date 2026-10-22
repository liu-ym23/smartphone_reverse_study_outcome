package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.live.artist.render.RenderEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements tc2.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RenderEntity f141421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f141422b;

    @Override // tc2.k
    public final void a(RenderEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Function1 r101 = this.f141422b;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(this.f141421a);
        return;
    }

    public v(RenderEntity r100, Function1 r101) {
        this.f141421a = r100;
        this.f141422b = r101;
    }
}
