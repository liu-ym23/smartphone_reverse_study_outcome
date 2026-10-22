package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f169302a;

    public b(c r100) {
        this.f169302a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        dm.a.a("JsEventHandler").i("handlePlayerEvent: PDPGalleryChangeVideoListFoldStatus, params: " + r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.areEqual(r100.optString("status"), "show");     // Catch: Throwable -> L9
        d r102 = this.f169302a.f169305c;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.b();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        dm.a.a("JsEventHandler").b("handlePlayerEvent failed: PDPPlayerControl", r105);
        return;
    L17:
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
