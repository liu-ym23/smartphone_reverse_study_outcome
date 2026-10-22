package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class GalleryJsEventHandler$register$2 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f169300a;

    public GalleryJsEventHandler$register$2(c r100) {
        this.f169300a = r100;
    }

    @Override // ti.j
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        dm.a.a("JsEventHandler").i("handlePlayerEvent: PDPPlayerControl, params: " + r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Function0<Unit> r102 = new GalleryJsEventHandler$register$2$onReceiveJsEvent$$inlined$runCatching$lambda$1(this, r100);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r102, "block");     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(r100.optString("scene"), "pdp_gallery") == false) goto L6;
        r102.invoke();     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        dm.a.a("JsEventHandler").b("handlePlayerEvent failed: PDPPlayerControl", r104);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
