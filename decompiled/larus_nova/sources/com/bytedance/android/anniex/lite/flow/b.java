package com.bytedance.android.anniex.lite.flow;

import android.net.Uri;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.ies.bullet.service.base.h;
import com.lynx.tasm.TemplateData;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import na.c;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends com.bytedance.android.anniex.lite.flow.base.b implements c {
    @Override // na.c
    public final void a() {
        if (h.A() == false) goto L6;
        CoroutineScopeKt.cancel$default(this.f40923d, null, 1, null);
        return;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.b
    public final void e() {
        super.e();
        AnnieXLynxEngineManager.f40721a.a(this.f40921b, this.f40922c);
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.e
    public final void onRelease() {
        e();
    }

    @Override // na.c
    public final ra.a c(String r100, Uri r101, String r102, TemplateData r103) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        com.bytedance.android.anniex.lite.b.f40795a.getClass();
        return com.bytedance.android.anniex.lite.b.b(r100, r101, r102, r103);
    }
}
