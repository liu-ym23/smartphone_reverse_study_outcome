package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import com.bytedance.android.gamecp.base.core.service.depend.PlatformSupportPkg;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "registerGamePromoteDownload")
public final class s5 extends w0<t5, RegisterGamePromoteDownloadResultModel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f57539c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57541b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.gamecp.base.core.service.depend.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s5 f57542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsonObject f57543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ xr.f f57544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f57545d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f57546e;

        public static final class a implements com.bytedance.android.gamecp.base.core.service.depend.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f57547a;

            @Override // com.bytedance.android.gamecp.base.core.service.depend.b
            public final void onAirCompressFailed() {
                this.f57547a.onProgress(new com.bytedance.android.gamecp.base.core.service.depend.x(0, null, 0, null, 0, 0, 0, 0.0f, null, false, 2047));
                this.f57547a.onError(0);
            }

            public a(b r100) {
                this.f57547a = r100;
            }

            @Override // com.bytedance.android.gamecp.base.core.service.depend.b
            public final void onAirCompressSuccess(int r110) {
                b r111 = this.f57547a;
                s5.l(r111.f57542a, r111.f57545d, r111.f57543b, 3, r111.f57546e.element, 0, 0, null, 112);
            }
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstallFailed(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onJumpInstall(int r100) {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onUpdate() {
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onCancel() {
            s5.l(this.f57542a, this.f57545d, this.f57543b, 4, this.f57546e.element, 0, 0, null, 112);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onReady() {
            JsonElement r100 = this.f57543b.get("gameId");
            if (r100 == null) goto L7;
            String r101 = r100.toString();
            if (r101 == null) goto L7;
            String r102 = StringsKt.replace$default(r101, "\"", "", false, 4, null);
        L8:
            xr.f r103 = this.f57544c;
            if (r103 != null) goto L11;
        L13:
            s5.l(this.f57542a, this.f57545d, this.f57543b, 0, this.f57546e.element, 0, 0, null, 112);
            return;
        L11:
            if (r103.isRestoreFailed(r102) != true) goto L13;
            onProgress(new com.bytedance.android.gamecp.base.core.service.depend.x(0, null, 0, null, 0, 0, 0, 0.0f, null, false, 2047));
            onError(0);
            return;
        L7:
            r102 = null;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onDownloaded(String r210) {
            JsonElement r100 = this.f57543b.get("gameId");
            if (r100 == null) goto L7;
            String r101 = r100.toString();
            if (r101 == null) goto L7;
            String r102 = StringsKt.replace$default(r101, "\"", "", false, 4, null);
        L8:
            xr.f r103 = this.f57544c;
            if (r103 != null) goto L11;
        L13:
            s5.l(this.f57542a, this.f57545d, this.f57543b, 3, this.f57546e.element, 0, 0, null, 112);
            return;
        L11:
            if (r103.isSupportAirCompress(r210) != true) goto L13;
            onProgress(new com.bytedance.android.gamecp.base.core.service.depend.x(99, null, 0, null, 99, 0, 0, 0.0f, null, false, 2030));
            this.f57544c.y2(r102, r210, new a(this));
            return;
        L7:
            r102 = null;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onError(int r110) {
            s5.l(this.f57542a, this.f57545d, this.f57543b, 5, this.f57546e.element, 0, r110, null, 64);
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onInstalled(com.bytedance.android.gamecp.base.core.service.depend.v r110) {
            Intrinsics.checkNotNullParameter(r110, "installedFinishData");
            s5.l(this.f57542a, this.f57545d, this.f57543b, 6, this.f57546e.element, 0, 0, null, 112);
            JsonElement r111 = this.f57543b.get("gameId");
            if (r111 == null) goto L7;
            String r100 = r111.toString();
            if (r100 == null) goto L7;
            String r112 = StringsKt.replace$default(r100, "\"", "", false, 4, null);
        L8:
            xr.f r101 = this.f57544c;
            if (r101 == null) goto L12;
            r101.unregisterAirCompressListener(r112);
            return;
        L12:
            return;
        L7:
            r112 = null;
            goto L8
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onPause(com.bytedance.android.gamecp.base.core.service.depend.x r110) {
            Intrinsics.checkNotNullParameter(r110, "progressData");
            this.f57542a.m(r110.f51445i);
            String r100 = this.f57542a.f57540a;
            r110.toString();
            s5 r101 = this.f57542a;
            Context r102 = this.f57545d;
            JsonObject r103 = this.f57543b;
            int r104 = this.f57546e.element;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r110, "progressData");
            if (wu.c3.f561291a.getValue().booleanValue() == false) goto L5;
            int r111 = r110.f51441e;
        L6:
            s5.l(r101, r102, r103, 2, r104, r111, 0, this.f57542a.f57540a, 32);
            return;
        L5:
            r111 = r110.f51437a;
            goto L6
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void onProgress(com.bytedance.android.gamecp.base.core.service.depend.x r110) {
            Intrinsics.checkNotNullParameter(r110, "progressData");
            s5 r100 = this.f57542a;
            Context r101 = this.f57545d;
            JsonObject r102 = this.f57543b;
            int r103 = this.f57546e.element;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r110, "progressData");
            if (wu.c3.f561291a.getValue().booleanValue() == false) goto L5;
            int r104 = r110.f51441e;
        L6:
            yr.c.a("registerGamePromoteDownload", "onProgress: RegisterGamePromoteDownloadMethod,progressData=" + r110);
            Unit r111 = Unit.INSTANCE;
            s5.l(r100, r101, r102, 1, r103, r104, 0, null, 96);
            return;
        L5:
            r104 = r110.f51437a;
            goto L6
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.n
        public final void passThrough(int r110) {
            if (r110 != 1) goto L5;
            return;
        L5:
            if (r110 != 2) goto L7;
            return;
        L7:
            if (r110 != 3) goto L9;
            return;
        L9:
            if (r110 != 4) goto L11;
            return;
        L11:
            if (r110 != 5) goto L13;
            return;
        L13:
            if (r110 == 6) goto L22;
            s5.l(this.f57542a, this.f57545d, this.f57543b, r110, this.f57546e.element, 0, 0, null, 112);
            return;
        }

        public b(s5 r100, JsonObject r101, xr.f r102, Context r103, Ref.IntRef r104) {
            this.f57542a = r100;
            this.f57543b = r101;
            this.f57544c = r102;
            this.f57545d = r103;
            this.f57546e = r104;
        }
    }

    static {
    }

    public s5() {
        this.f57540a = "";
    }

    public final String k(JsonElement r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        String r103 = r100.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L15;
        r101 = r104;
    L15:
        String r105 = (String) r101;
        if (r105 != null) goto L21;
        return "";
    L21:
        return r105;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f57541b == 2) goto L5;
    L11:
        this.f57540a = r100;
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        if ((!Intrinsics.areEqual(this.f57540a, r100)) == true) goto L11;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static Pair j(Context r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);     // Catch: Throwable -> L27
        if (r103 == null) goto L6;
        List<PlatformSupportPkg> r104 = r103.I(r101);     // Catch: Throwable -> L27
    L7:
        if (r103 == null) goto L9;
        List<PlatformSupportPkg> r105 = r103.w2(r100, r104);     // Catch: Throwable -> L27
    L10:
        List<PlatformSupportPkg> r106 = r105;     // Catch: Throwable -> L27
        if (r106 != null) goto L13;
    L16:
        boolean r107 = true;
    L17:
        boolean r108 = !r107;     // Catch: Throwable -> L27
        if (r105 == null) goto L25;
        List<PlatformSupportPkg> r109 = r105;     // Catch: Throwable -> L27
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Throwable -> L27
        Iterator<T> r111 = r109.iterator();     // Catch: Throwable -> L27
    L21:
        if (r111.hasNext() == false) goto L24;
        r110.add(((PlatformSupportPkg) r111.next()).getName());     // Catch: Throwable -> L27
        goto L21
    L24:
        return new Pair(Boolean.valueOf(r108), com.bytedance.android.gamecp.common.utils.e1.a(r110));
    L25:
        Object r112 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L27
    L29:
        Result.m9452exceptionOrNullimpl(r112);
        return null;
    L13:
        if (r106.isEmpty() == true) goto L16;
        r107 = false;
        goto L17
    L9:
        r105 = null;
        goto L10
    L6:
        r104 = null;
    L27:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, final CallContext r111) {
        final t5 r112 = (t5) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("registerGamePromoteDownload", GsonProtectorUtils.toJson(new Gson(), r112));
        if (r112.a() != null) goto L6;
        RegisterGamePromoteDownloadResultModel r113 = new RegisterGamePromoteDownloadResultModel();
        r113.a(RegisterGamePromoteDownloadResultModel.Code.Failed);
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r113);
        return;
    L6:
        if (wu.c.f561287a.getValue().g() == false) goto L8;
        ThreadsKt.thread$default(false, false, null, null, 0, new RegisterGamePromoteDownloadMethod$invoke$2(this, r112, r111), 31, null);
        return;
    L8:
        n(r112, r111);
    }

    public final void n(t5 r110, CallContext r111) {
        JsonObject r112 = r110.a();
        if (r112 != null) goto L5;
        return;
    L5:
        Ref.IntRef r100 = new Ref.IntRef();
        final int r101 = 0;
        r100.element = 0;
        Integer r102 = StringsKt.toIntOrNull(k(r112.get("token")));
        if (r102 != null) goto L11;
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L10;
        r102 = Integer.valueOf(r103.genDownloadToken());
        goto L11
    L10:
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        r112.addProperty("token", r102);
        r100.element = r102.intValue();
    L13:
        xr.f r104 = (xr.f) xr.s.a(xr.f.class);
        Context r105 = r111.getContext();
        xr.f r113 = (xr.f) xr.s.a(xr.f.class);
        if (r113 == null) goto L16;
        r101 = r113.C1(r112, new b(this, r112, r104, r105, r100));
    L16:
        r100.element = r101;
        UtilityKotlinExtentionsKt.g(0, false, false, new RegisterGamePromoteDownloadMethod$sendSubscribeResult$1(this, r101), 7);
    }

    public static void l(s5 r100, Context r101, JsonObject r102, int r103, int r104, int r105, int r106, String r107, int r110) {
        boolean r108 = false;
        if ((r110 & 8) == 0) goto L6;
        r104 = 0;
    L6:
        if ((r110 & 16) == 0) goto L9;
        r105 = 0;
    L9:
        if ((r110 & 32) == 0) goto L12;
        r106 = 0;
    L12:
        if ((r110 & 64) == 0) goto L14;
        r107 = "";
    L14:
        r100.f57541b = r103;
        if (r103 == 2) goto L38;
        r100.m("");
    L38:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L35
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L35
        r112.put("downStatus", r103);     // Catch: Throwable -> L35
        r112.put("token", r104);     // Catch: Throwable -> L35
        r112.put("process", r105);     // Catch: Throwable -> L35
        r112.put("errorCode", r106);     // Catch: Throwable -> L35
        r112.put("downloadRedeemText", r107);     // Catch: Throwable -> L35
        if (r103 == 1) goto L29;
        Pair r109 = j(r101, r100.k(r102.get("downloadExtra")));     // Catch: Throwable -> L35
        if (r109 == null) goto L24;
        Boolean r113 = (Boolean) r109.getFirst();     // Catch: Throwable -> L35
        if (r113 == null) goto L24;
        r108 = r113.booleanValue();     // Catch: Throwable -> L35
    L24:
        if (r109 == null) goto L27;
        String r114 = (String) r109.getSecond();     // Catch: Throwable -> L35
        if (r114 == null) goto L27;
    L28:
        r112.put("isInstallPackage", r108);     // Catch: Throwable -> L35
        r112.put("installedPackageName", r114);     // Catch: Throwable -> L35
    L27:
        r114 = "[]";
    L29:
        jw.c r115 = (jw.c) xr.s.a(jw.c.class);     // Catch: Throwable -> L35
        if (r115 == null) goto L32;
        r115.sendEventToAllJsBridges("gamePromoterDownloadStatusEvent", r112);     // Catch: Throwable -> L35
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L33:
        Result.m9449constructorimpl(r116);     // Catch: Throwable -> L35
        return;
    L32:
        r116 = null;
    L35:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
