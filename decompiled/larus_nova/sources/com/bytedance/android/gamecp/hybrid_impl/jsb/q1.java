package com.bytedance.android.gamecp.hybrid_impl.jsb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class q1 implements com.bytedance.android.gamecp.base.core.service.depend.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f57529a;

    public q1(p1 r100) {
        this.f57529a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.i
    public final void onSuccess(List<? extends JSONObject> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        JSONObject r103 = (JSONObject) r102.next();
        this.f57529a.getClass();
        if (r103 != null) goto L8;
        OpenGameCPPhotoAlbumResultModel.b r104 = null;
    L14:
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L8:
        OpenGameCPPhotoAlbumResultModel.b r105 = new OpenGameCPPhotoAlbumResultModel.b();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        r105.b(r103.optString("uri"));     // Catch: Throwable -> L11
        r105.a(Integer.valueOf(r103.optInt("height")));     // Catch: Throwable -> L11
        r105.c(Integer.valueOf(r103.optInt("width")));     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        r104 = r105;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L16:
        OpenGameCPPhotoAlbumResultModel.a r108 = new OpenGameCPPhotoAlbumResultModel.a();
        r108.a(r101);
        p1 r109 = this.f57529a;
        OpenGameCPPhotoAlbumResultModel r110 = new OpenGameCPPhotoAlbumResultModel();
        r110.a(OpenGameCPPhotoAlbumResultModel.Code.Success);
        r110.b(r108);
        Unit r111 = Unit.INSTANCE;
        r109.finishWithResult(r110);
    }
}
