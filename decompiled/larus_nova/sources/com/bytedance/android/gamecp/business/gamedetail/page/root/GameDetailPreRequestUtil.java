package com.bytedance.android.gamecp.business.gamedetail.page.root;

import android.util.Log;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
import wu.w2;

/* JADX INFO: loaded from: classes44.dex */
public final class GameDetailPreRequestUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f55453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f55454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.android.gamecp.base.cache.c<String, z> f55455c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f55456d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.bytedance.android.gamecp.base.cache.b f55457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f55458f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f55459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f55460h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f55461i = null;

    static {
        f55454b = new Object();
        f55455c = new com.bytedance.android.gamecp.base.cache.c(10);
        f55456d = new Object();
        f55458f = 5;
        f55460h = 86400000;
        f55461i = LazyKt.lazy(GameDetailPreRequestUtil$diffFilterKeys$2.INSTANCE);
    }

    public static void e() {
        Object r100 = f55456d;
        monitor-enter(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        if (f55457e != null) goto L12;
        PolarisFileWrapper r102 = new PolarisFileWrapper(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getCacheDir(), "gameCPDetailCache");     // Catch: Throwable -> L10
        if (r102.exists() == true) goto L9;
        r102.mkdirs();     // Catch: Throwable -> L10
    L9:
        f55457e = com.bytedance.android.gamecp.base.cache.b.h(r102);     // Catch: Throwable -> L10
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L17
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static z a(z r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 != null) goto L5;
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return null;
    L5:
        if ((System.currentTimeMillis() - r100.f55609b) > f55460h) goto L7;
        return r100;
    L9:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static String c(dt.b r100) {
        int r101 = r100.P;
        String r102 = r100.F;
        String r103 = com.bytedance.android.gamecp.host_api.a.b().getUserService().user().getCurrentUserId();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = String.valueOf(com.bytedance.android.gamecp.host_api.a.b().getHostContext().getVersionCode());
        String r106 = r100.f469973q0;
        if (r106 == null) goto L10;
        r104 = r106;
    L10:
        if (UtilsKt.c(r104) == false) goto L14;
        return r104 + '_' + r101 + '_' + r102 + '_' + r103 + '_' + r105;
    L14:
        return r101 + '_' + r102 + '_' + r103 + '_' + r105;
    }

    public static z d(String r100) {
        Object r101 = f55456d;
        monitor-enter(r101);
        e();     // Catch: Throwable -> L28
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L24
        com.bytedance.android.gamecp.base.cache.b r103 = f55457e;     // Catch: Throwable -> L24
        if (r103 == null) goto L21;
        com.bytedance.android.gamecp.base.cache.b.d r104 = r103.f(r100);     // Catch: Throwable -> L24
        int r105 = 0;
        if (r104 == null) goto L13;
        InputStream r106 = r104.f51397a[0];     // Catch: Throwable -> L24
        if (r106 == null) goto L13;
        byte[] r107 = ByteStreamsKt.readBytes(r106);     // Catch: Throwable -> L24
    L14:
        if (r107 == null) goto L22;
        byte[] r108 = r100.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L24
        int r109 = r107.length;     // Catch: Throwable -> L24
    L16:
        if (r105 >= r109) goto L18;
        r107[r105] = (byte) (r107[r105] ^ r108[r105 % r108.length]);     // Catch: Throwable -> L24
        r105 = r105 + 1;     // Catch: Throwable -> L24
        goto L16
    L18:
        z r110 = a(g(new String(r107, Charsets.UTF_8)));     // Catch: Throwable -> L24
        monitor-exit(r101);
        return r110;
    L22:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L24
    L26:
        monitor-exit(r101);
        return null;
    L13:
        r107 = null;
        goto L14
    L21:
        r103 = null;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L28
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public static void f(String r100) {
        yr.c.e("GameDetailPreRequest", String.valueOf(r100));
    }

    public static z g(String r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        if (UtilsKt.c(r110) == false) goto L6;
        JSONObject r101 = new JSONObject(r110);     // Catch: Throwable -> L8
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r101, "data");     // Catch: Throwable -> L8
        long r103 = JSONObjectProtectorUtils.getLong(r101, "time");     // Catch: Throwable -> L8
        String r104 = r101.optString("video_id");     // Catch: Throwable -> L8
        String r105 = r101.optString("room_id");     // Catch: Throwable -> L8
        String r106 = r101.optString("data_from");     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L8
        return new z(r110, r103, r104, r105, r102, r106);
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static void i(dt.b r100, GameDetailPreRequestTriggerFrom r101) {
        f("preRequestNow not support preRequest and enableCache");
    }

    public static void j(String r100, String r110) {
        if (r110 == null) goto L52;
        Object r101 = f55456d;
        monitor-enter(r101);
        e();     // Catch: Throwable -> L49
        f("缓存数据到磁盘 " + r100);     // Catch: Throwable -> L49
        Unit r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L38
        com.bytedance.android.gamecp.base.cache.b r104 = f55457e;     // Catch: Throwable -> L38
        if (r104 == null) goto L29;
        com.bytedance.android.gamecp.base.cache.b.C0872b r105 = r104.e(r100);     // Catch: Throwable -> L38
        if (r105 != null) goto L53;
        com.bytedance.android.gamecp.base.cache.b.C0872b.a r106 = null;
    L15:
        if (r106 == null) goto L20;
        Charset r107 = Charsets.UTF_8;     // Catch: Throwable -> L36
        byte[] r111 = r110.getBytes(r107);     // Catch: Throwable -> L36
        byte[] r108 = r100.getBytes(r107);     // Catch: Throwable -> L36
        int r109 = r111.length;     // Catch: Throwable -> L36
        int r112 = 0;
    L17:
        if (r112 >= r109) goto L19;
        r111[r112] = (byte) (r111[r112] ^ r108[r112 % r108.length]);     // Catch: Throwable -> L36
        r112 = r112 + 1;     // Catch: Throwable -> L36
        goto L17
    L19:
        r106.write(r111);     // Catch: Throwable -> L36
    L20:
        if (r106 == null) goto L22;
        r106.flush();     // Catch: Throwable -> L36
    L22:
        if (r106 == null) goto L24;
        r106.close();     // Catch: Throwable -> L36
    L24:
        if (r105 != null) goto L26;
    L30:
        com.bytedance.android.gamecp.base.cache.b r113 = f55457e;     // Catch: Throwable -> L36
        if (r113 == null) goto L33;
        r113.flush();     // Catch: Throwable -> L36
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L34:
        Result.m9449constructorimpl(r114);     // Catch: Throwable -> L36
    L41:
        if (r105 != null) goto L58;
    L43:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L45
    L47:
        monitor-exit(r101);
        return;
    L45:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L49
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L49
        goto L47
    L58:
        r105.a();     // Catch: Throwable -> L45
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L45
    L36:
        th = th;
    L40:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L49
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L49
        goto L41
    L33:
        r114 = null;
        goto L34
    L26:
        if (r105.f51389b == false) goto L28;
        com.bytedance.android.gamecp.base.cache.b.a(r105.f51390c, r105, false);     // Catch: Throwable -> L36
        r105.f51390c.n(r105.f51388a.f51392a);     // Catch: Throwable -> L36
        goto L30
    L28:
        com.bytedance.android.gamecp.base.cache.b.a(r105.f51390c, r105, true);     // Catch: Throwable -> L36
        goto L30
    L53:
        r106 = r105.b();     // Catch: Throwable -> L36
        goto L15
    L29:
        r105 = null;
    L38:
        th = th;
        r105 = null;
    L49:
        th = move-exception;
        throw th;
    }

    public static void k(String r100, z r101) {
        Object r102 = f55454b;
        monitor-enter(r102);
        f("缓存数据到内存 " + r100);     // Catch: Throwable -> L7
        f55455c.b(r100, r101);     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void l(final Runnable r100, final int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r101 <= 0) goto L6;
        com.bytedance.android.gamecp.host_api.a.b().getFeatureServiceApi().a();     // Catch: Throwable -> L9
        f("init getFactor value null");     // Catch: Throwable -> L9
        UtilityKotlinExtentionsKt.g(1000, false, false, new GameDetailPreRequestUtil$startInitGameCrowd$$inlined$runCatching$lambda$1(r101, r100), 6);     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        f("init error " + Log.getStackTraceString(r104));
        return;
    L17:
        return;
    L6:
        f55459g = false;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static void m(String r100, Map r101) {
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3(r100, r101);
    }

    public static z b(dt.b r100, JSONObject r110, String r111) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L4
        String r103 = r100.R;     // Catch: Throwable -> L4
        String r104 = r100.f469939J;     // Catch: Throwable -> L4
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L4
        r105.put("data", r110);     // Catch: Throwable -> L4
        r105.put("time", r102);     // Catch: Throwable -> L4
        r105.put("video_id", r103);     // Catch: Throwable -> L4
        r105.put("room_id", r104);     // Catch: Throwable -> L4
        r105.put("data_from", r111);     // Catch: Throwable -> L4
        return new z(r105.toString(), r102, r103, r104, r110, r111);
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static z h(dt.b r100, JSONObject r101, GameDetailPreRequestTriggerFrom r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L42
        if (w2.f561410a.getValue().booleanValue() == true) goto L40;
        JSONObject r104 = r101.optJSONObject("structure");     // Catch: Throwable -> L42
        if (r104 == null) goto L9;
        JSONArray r105 = r104.optJSONArray("children");     // Catch: Throwable -> L42
    L10:
        if (r105 == null) goto L12;
        List<JSONObject> r106 = com.bytedance.android.gamecp.business.gamedetail.component.g.d(r105);     // Catch: Throwable -> L42
    L13:
        if (r106 == null) goto L22;
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L42
    L16:
        if (r107.hasNext() == false) goto L20;
        Object r108 = r107.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(((JSONObject) r108).optString("id"), "game_detail_page") == false) goto L16;
    L21:
        JSONObject r109 = (JSONObject) r108;     // Catch: Throwable -> L42
    L24:
        if (r105 != null) goto L26;
    L29:
        if (r109 == null) goto L31;
        JSONArray r110 = r109.optJSONArray("children");     // Catch: Throwable -> L42
    L32:
        if (r110 == null) goto L34;
        JSONObject r111 = r110.optJSONObject(0);     // Catch: Throwable -> L42
    L35:
        if (r110 == null) goto L40;
    L37:
        if (r110.length() <= 0) goto L39;
        r110.remove(0);     // Catch: Throwable -> L42
        goto L37
    L39:
        r110.put(0, r111);     // Catch: Throwable -> L42
        goto L40
    L34:
        r111 = null;
        goto L35
    L31:
        r110 = null;
    L26:
        if (r105.length() <= 0) goto L28;
        r105.remove(0);     // Catch: Throwable -> L42
        goto L26
    L28:
        r105.put(0, r109);     // Catch: Throwable -> L42
        goto L29
    L20:
        r108 = null;
        goto L21
    L22:
        r109 = null;
        goto L24
    L12:
        r106 = null;
        goto L13
    L9:
        r105 = null;
    L40:
        return b(r100, r101, r102.getKey());
    L42:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Throwable r113 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r113 == null) goto L46;
        f("网络预请求，数据解析失败 " + Log.getStackTraceString(r113));
    L46:
        return null;
    }
}
