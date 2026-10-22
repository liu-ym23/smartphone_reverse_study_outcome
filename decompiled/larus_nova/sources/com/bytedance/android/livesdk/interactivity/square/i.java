package com.bytedance.android.livesdk.interactivity.square;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements l52.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f141169a;

    public i(j r100) {
        this.f141169a = r100;
    }

    @Override // l52.c.b
    public final void a(h52.d r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r101 = this.f141169a.f141172j;
        Intrinsics.checkNotNullParameter(r101, "$this$getReceiver");
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        h52.a<h52.d, ? extends h52.c> r102 = r101.getMessagePluginByType(r100.b());
        if (r102 != null) goto L5;
    L7:
        r102 = null;
    L8:
        if (r102 == null) goto L18;
        gc2.a r103 = r102.d(r100);
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.f488278a == false) goto L14;
        this.f141169a.f141171i.a(r103, false, false);
        return;
    L14:
        Function1<? super List<? extends h52.c>, Unit> r104 = this.f141169a.f507490b;
        if (r104 == null) goto L21;
        Unit r105 = r104.invoke(CollectionsKt.listOf(r103));
        return;
    L21:
        return;
    L18:
        return;
    L5:
        if (r102.a(r100) == false) goto L7;
        goto L7
    }
}
