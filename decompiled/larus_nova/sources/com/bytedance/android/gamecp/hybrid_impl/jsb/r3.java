package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.view.View;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.bytedance.android.gamecp.common.utils.GsonMap;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.live.photoviewer.photoviewer.PVMediaModel;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpPreviewImages")
public final class r3 extends y<s3, GamecpPreviewImagesResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57532a = 0;

    public static final class a {
    }

    public static final class b extends TrackRegisterStrategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f57533a;

        @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
        public final int getAutoReportStrategy() {
            return this.f57533a;
        }

        public b(int r100) {
            this.f57533a = r100;
        }
    }

    static {
    }

    public r3() {
    }

    public static Map j(JsonObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L10;
        Lazy r102 = UtilsKt.f57195a;
        Intrinsics.checkNotNullParameter(r100, "$this$toMap");
        Iterator<Map.Entry<String, Object>> r103 = new GsonMap(r100).entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Object> r104 = r103.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L6;
        r101.put(r105, r106);
    L10:
        return r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        s3 r112 = (s3) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r100 = r112.b();
        List<String> r101 = r100;
        final boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L44;
        yr.b.b(4, "GamecpPreviewImagesMethod", "fail to preview images,imageList is empty");
        GamecpPreviewImagesResultModel r113 = new GamecpPreviewImagesResultModel();
        r113.a(GamecpPreviewImagesResultModel.Code.Failed);
        r113.b("fail to preview images,imageList is empty");
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r113);
        return;
    L44:
        Boolean r104 = r112.a();     // Catch: Throwable -> L41
        if (r104 == null) goto L15;
        boolean r105 = r104.booleanValue();     // Catch: Throwable -> L41
    L16:
        Integer r106 = r112.c();     // Catch: Throwable -> L41
        if (r106 == null) goto L19;
        int r107 = r106.intValue();     // Catch: Throwable -> L41
    L20:
        final s3.a r108 = r112.e();     // Catch: Throwable -> L41
        if (r108 == null) goto L30;
        String r109 = r108.c();     // Catch: Throwable -> L41
        if (r109 == null) goto L30;
        if (r109.length() <= 0) goto L27;
        boolean r115 = true;
    L28:
        if (r115 != true) goto L30;
        r102 = true;
        goto L30
    L27:
        r115 = false;
    L30:
        if (r105 == false) goto L36;
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L41
        Iterator<T> r117 = r100.iterator();     // Catch: Throwable -> L41
    L33:
        if (r117.hasNext() == false) goto L35;
        r116.add(new PVMediaModel((String) r117.next(), 1));     // Catch: Throwable -> L41
        goto L33
    L35:
        int r118 = xj6.a.f564102a;     // Catch: Throwable -> L41
        xj6.a.a(r111.getContext(), r116, r107, null, null, new GamecpPreviewImagesMethod$invoke$3(this, r102, r108), 24);     // Catch: Throwable -> L41
    L39:
        GamecpPreviewImagesResultModel r119 = new GamecpPreviewImagesResultModel();     // Catch: Throwable -> L41
        r119.a(GamecpPreviewImagesResultModel.Code.Success);     // Catch: Throwable -> L41
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L41
        finishWithResult(r119);     // Catch: Throwable -> L41
        return;
    L36:
        xr.f r121 = (xr.f) xr.s.a(xr.f.class);     // Catch: Throwable -> L41
        if (r121 == null) goto L39;
        Context r122 = r111.getContext();     // Catch: Throwable -> L41
        r100.size();     // Catch: Throwable -> L41
        r121.w1(r122, r107, r100, r112.d(), new GamecpPreviewImagesMethod$invoke$4(this, r102, r108));     // Catch: Throwable -> L41
        goto L39
    L19:
        r107 = 0;
        goto L20
    L15:
        r105 = false;
    L41:
        th = move-exception;
        yr.b.b(4, "GamecpPreviewImagesMethod", "fail to preview images, error: " + th.getMessage());
        GamecpPreviewImagesResultModel r123 = new GamecpPreviewImagesResultModel();
        r123.a(GamecpPreviewImagesResultModel.Code.Failed);
        r123.b("fail to preview images, error: " + th.getMessage());
        Unit r124 = Unit.INSTANCE;
        finishWithResult(r123);
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    public static void k(Object r100, View r101, s3.a r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        String r104 = r102.c();     // Catch: Throwable -> L11
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r105 = r104;
        Map r106 = j(r102.b());     // Catch: Throwable -> L11
        Integer r107 = r102.a();     // Catch: Throwable -> L11
        if (r107 == null) goto L8;
        int r108 = r107.intValue();     // Catch: Throwable -> L11
    L9:
        Map r109 = j(r102.d());     // Catch: Throwable -> L11
        HashMap<String, String> r110 = GamecpTracker.f56755a;     // Catch: Throwable -> L11
        GamecpTracker.w(r100, r101, r105, r106, r109, new b(r108));     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L8:
        r108 = 3;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
