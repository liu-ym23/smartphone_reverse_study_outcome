package com.bytedance.android.gamecp.common.track;

import android.app.Application;
import com.bytedance.android.gamecp.base.core.service.depend.t;
import com.bytedance.android.gamecp.common.utils.u;
import com.bytedance.android.gamecp.host_api.model.Room;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56775a = 0;

    public static final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f56776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f56777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f56778c;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.t
        public final void onResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "status");
            this.f56776a.put("download_status", r100);
            this.f56778c.invoke(this.f56776a);
        }

        public a(Map r100, Map r101, Function1 r102) {
            this.f56776a = r100;
            this.f56777b = r101;
            this.f56778c = r102;
        }
    }

    static {
    }

    public static Map b(String r100) {
        return com.bytedance.android.gamecp.host_api.a.b().getLogService().getFilterParamsByName(r100);
    }

    public static Map d(String... r100) {
        Intrinsics.checkNotNullParameter(r100, "filterList");
        HashMap r101 = new HashMap();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        Map r104 = b(r100[r103]);
        if (r104 == null) goto L9;
        if ((!r104.isEmpty()) != true) goto L9;
        r101.putAll(r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        com.bytedance.android.gamecp.host_api.a.b().getLogService().y1();
        if (com.bytedance.android.gamecp.host_api.a.b().getLiveService().e() == false) goto L24;
        Room r105 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        String r106 = "";
        if (r105 == null) goto L16;
        String r107 = r105.getOwnerUserId();
        if (r107 == null) goto L16;
    L17:
        Room r108 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r108 == null) goto L23;
        String r109 = String.valueOf(r108.getId());
        if (r109 == null) goto L23;
        r106 = r109;
    L23:
        r101.put("room_id", r106);
        r101.put("anchor_id", r107);
    L16:
        r107 = "";
    L24:
        int r110 = wr.a.f560784a;
        r101.put("sdk_version", String.valueOf(4210));
        return r101;
    }

    public static Map e(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keys();
    L7:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        String r104 = "";
        String r105 = r100.optString(r103, "");
        if (r105 == null) goto L12;
        r104 = r105;
    L12:
        r101.put(r103, r104);
        goto L7
    L13:
        return r101;
    }

    public static Map c(Map r100, String... r101) {
        Intrinsics.checkNotNullParameter(r101, "args");
        HashMap r102 = new HashMap();
        boolean r103 = false;
        if (r101.length != 0) goto L5;
        boolean r104 = true;
    L7:
        if ((!r104) == false) goto L9;
        r102.putAll(d((String[]) Arrays.copyOf(r101, r101.length)));
    L9:
        if (r100 != null) goto L11;
    L12:
        r103 = true;
    L13:
        if (r103 == true) goto L15;
        r102.putAll(r100);
    L15:
        int r105 = wr.a.f560784a;
        r102.put("sdk_version", String.valueOf(4210));
        return r102;
    L11:
        if (r100.isEmpty() == false) goto L13;
    L5:
        r104 = false;
        goto L7
    }

    public static void a(String r100, Map r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        Intrinsics.checkNotNullParameter(r102, "logAction");
        Application r103 = u.f57306a;
        if (r103 == null) goto L16;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L10
        r105.putAll(r101);     // Catch: Throwable -> L10
        xr.f r106 = (xr.f) s.a(xr.f.class);     // Catch: Throwable -> L10
        if (r106 == null) goto L7;
        r106.g2(r103, r100, new a(r105, r101, r102));     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L10
    L12:
        Result.m9448boximpl(r108);
        return;
    L7:
        r107 = null;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static void g(String r100, Map r101, String... r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "args");
        h(r100, true, r101, (String[]) Arrays.copyOf(r102, r102.length));
    }

    public static void h(String r100, boolean r110, Map r111, String... r112) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r112, "args");
        String r101 = com.bytedance.android.gamecp.host_api.a.b().getLogService().J0();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        r101 = "livesdk_";
    L10:
        if (StringsKt.startsWith$default(r100, "noLivePrefix", false, 2, null) == false) goto L16;
        Object[] r103 = new Regex("noLivePrefix").split(r100, 0).toArray(new String[0]);
        if (r103 == null) goto L15;
        r100 = ((String[]) r103)[1];
        r110 = false;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        if (r110 == true) goto L18;
    L27:
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r100, c(r111, (String[]) Arrays.copyOf(r112, r112.length)));
        return;
    L18:
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == true) goto L27;
        if (StringsKt.startsWith$default(r100, "livesdk_", false, 2, null) == false) goto L26;
        Object[] r104 = new Regex("livesdk_").split(r100, 0).toArray(new String[0]);
        if (r104 == null) goto L25;
        r100 = ((String[]) r104)[1];
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L26:
        r100 = r101 + r100;
        goto L27
    L5:
        r102 = false;
        goto L7
    }

    public static void f(String r100, String r101, Long r102, JSONObject r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "refer");
        Intrinsics.checkNotNullParameter(r110, "adExtraData");
        com.bytedance.android.gamecp.host_api.a.b().getLogService().sendLiveAdLog(r100, r101, r102, r110, r111);
    }
}
