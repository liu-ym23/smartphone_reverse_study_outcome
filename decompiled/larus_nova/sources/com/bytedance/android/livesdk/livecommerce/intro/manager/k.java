package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.util.SparseArray;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements com.bytedance.android.livesdk.livecommerce.intro.controller.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f148413a;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void b() {
        i.a r100 = new i.a();
        if (Intrinsics.areEqual(this.f148413a.f148401f, r100) == false) goto L6;
        this.f148413a.f148401f = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void c() {
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[onOpenPriceAnimationFinished] request latest intro card");
        i r100 = this.f148413a;
        r100.f148401f = null;
        c.a.a(r100, IntroCardScene.ACTION, 126);
    }

    public k(i r100) {
        this.f148413a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void a(boolean r100) {
        SparseArray<com.bytedance.android.livesdk.livecommerce.intro.controller.b> r101 = this.f148413a.f148399d;
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.keyAt(r103);
        r101.valueAt(r103).k(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.a
    public final void d(r0 r100) {
        int r101 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        StringBuilder r102 = new StringBuilder("[onCardFinishedAction] action=");
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.a();
    L6:
        r102.append(r104);
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(r102.toString());
        if (r100 == null) goto L9;
        r103 = r100.a();
    L9:
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.hashCode() == (-1689642695)) goto L15;
        return;
    L15:
        if (r103.equals("LIVE_INTRO") == false) goto L18;
        c.a.a(this.f148413a, IntroCardScene.ACTION, 126);
        return;
    L18:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
