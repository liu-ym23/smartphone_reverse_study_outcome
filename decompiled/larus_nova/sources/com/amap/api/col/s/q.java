package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static br f26605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q f26606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Context f26607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f26608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HandlerThread f26609e;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f26613b;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.what != 3) goto L17;
            r r101 = (r) r100.obj;     // Catch: Throwable -> L12
            if (r101 != null) goto L10;
            r101 = new r(false, false);     // Catch: Throwable -> L12
        L10:
            cg.a(q.a(), h.a(r101.a()));     // Catch: Throwable -> L12
            q.f26605a = h.a(r101.a());     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            i.a(th, "ManifestConfig", this.f26612a);
            return;
        }

        public a(q r100, Looper r101) {
            this.f26613b = r100;
            super(r101);
            this.f26612a = "handleMessage";
        }
    }

    public static /* synthetic */ Context a() {
        return f26607c;
    }

    private q(Context r100) {
        final String r101 = "manifestThread";
        this.f26609e = new AnonymousClass1(this, r101);
        f26607c = r100;
        f26605a = h.a(false);
        ac.a();     // Catch: Throwable -> L5
        this.f26608d = new a(this, Looper.getMainLooper());     // Catch: Throwable -> L5
        ThreadMethodProxy.start(this.f26609e);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        i.a(th, "ManifestConfig", "ManifestConfig");
    }

    public static q a(Context r100) {
        if (f26606b != null) goto L6;
        f26606b = new q(r100);
    L6:
        return f26606b;
    }

    public static /* synthetic */ void b(Context r100) {
        String r101 = (String) al.b(r100, "amap_search", "cache_control", "");     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r101) == true) goto L6;
        d(new JSONObject(r101));     // Catch: Throwable -> L10
    L6:
        String r102 = (String) al.b(r100, "amap_search", "parm_control", "");     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r102) == true) goto L15;
        c(new JSONObject(r102));     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
    }

    private static void c(JSONObject r110) {
        if (r110 == null) goto L11;
        boolean r100 = bj.a(r110.optString("passAreaAble"), true);     // Catch: Throwable -> L6
        boolean r101 = bj.a(r110.optString("truckAble"), true);     // Catch: Throwable -> L6
        boolean r102 = bj.a(r110.optString("poiPageAble"), true);     // Catch: Throwable -> L6
        boolean r103 = bj.a(r110.optString("rideAble"), true);     // Catch: Throwable -> L6
        boolean r104 = bj.a(r110.optString("walkAble"), true);     // Catch: Throwable -> L6
        boolean r105 = bj.a(r110.optString("passPointAble"), true);     // Catch: Throwable -> L6
        boolean r106 = bj.a(r110.optString("keyWordLenAble"), true);     // Catch: Throwable -> L6
        int r107 = r110.optInt("poiPageMaxSize", 25);     // Catch: Throwable -> L6
        int r108 = r110.optInt("passAreaMaxCount", 100);     // Catch: Throwable -> L6
        int r111 = r110.optInt("walkMaxLength", 100);     // Catch: Throwable -> L6
        int r112 = r110.optInt("passPointMaxCount", 6);     // Catch: Throwable -> L6
        int r113 = r110.optInt("poiPageMaxNum", 100);     // Catch: Throwable -> L6
        int r114 = r110.optInt("truckMaxLength", 5000);     // Catch: Throwable -> L6
        int r115 = r110.optInt("rideMaxLength", 1200);     // Catch: Throwable -> L6
        int r116 = r110.optInt("passAreaMaxArea", 100000000);     // Catch: Throwable -> L6
        int r109 = r110.optInt("passAreaPointCount", 16);     // Catch: Throwable -> L6
        int r117 = r110.optInt("keyWordLenMaxNum", 100);     // Catch: Throwable -> L6
        ag.a().f26025a = r100;     // Catch: Throwable -> L6
        ag.a().f26034j = r108;     // Catch: Throwable -> L6
        ag.a().f26040p = r116;     // Catch: Throwable -> L6
        ag.a().f26041q = r109;     // Catch: Throwable -> L6
        ag.a().f26027c = r101;     // Catch: Throwable -> L6
        ag.a().f26038n = r114;     // Catch: Throwable -> L6
        ag.a().f26028d = r102;     // Catch: Throwable -> L6
        ag.a().f26037m = r113;     // Catch: Throwable -> L6
        ag.a().f26032h = r107;     // Catch: Throwable -> L6
        ag.a().f26033i = r117;     // Catch: Throwable -> L6
        ag.a().f26026b = r106;     // Catch: Throwable -> L6
        ag.a().f26029e = r103;     // Catch: Throwable -> L6
        ag.a().f26039o = r115;     // Catch: Throwable -> L6
        ag.a().f26030f = r104;     // Catch: Throwable -> L6
        ag.a().f26035k = r111;     // Catch: Throwable -> L6
        ag.a().f26031g = r105;     // Catch: Throwable -> L6
        ag.a().f26036l = r112;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private static void d(JSONObject r100) {
        if (r100 == null) goto L15;
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (r100.has("able") == false) goto L16;
        ad.a r101 = a(r100, true, null);     // Catch: Throwable -> L10
        ad.a().a(r101);     // Catch: Throwable -> L10
        if (r101.a() == true) goto L8;
        return;
    L8:
        a("regeo", r100, r101);     // Catch: Throwable -> L10
        a(MapBundleKey.MapObjKey.OBJ_GEO, r100, r101);     // Catch: Throwable -> L10
        a("placeText", r100, r101);     // Catch: Throwable -> L10
        a("placeAround", r100, r101);     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    public static /* synthetic */ void a(JSONObject r100) {
        d(r100);
    }

    public static /* synthetic */ void b(JSONObject r100) {
        c(r100);
    }

    public static /* synthetic */ a a(q r100) {
        return r100.f26608d;
    }

    private static ad.a a(JSONObject r100, boolean r101, ad.a r102) {
        ad.a r103 = null;
        if (r100 == null) goto L41;
        ad.a r104 = new ad.a();     // Catch: Throwable -> L34
        boolean r105 = false;
        if (r101 == false) goto L15;
        String r106 = r100.optString("able");     // Catch: Throwable -> L13
        if (r102 != null) goto L10;
    L11:
        r105 = true;
    L12:
        boolean r107 = bj.a(r106, r105);     // Catch: Throwable -> L13
    L21:
        if (r102 == null) goto L23;
        int r108 = (int) r102.b();     // Catch: Throwable -> L13
    L24:
        int r109 = r100.optInt("timeoffset", r108);     // Catch: Throwable -> L13
        if (r102 == null) goto L27;
        int r110 = r102.c();     // Catch: Throwable -> L13
    L28:
        int r111 = r100.optInt("num", r110);     // Catch: Throwable -> L13
        if (r102 == null) goto L31;
        double r112 = r102.d();     // Catch: Throwable -> L13
    L32:
        double r113 = r100.optDouble("limitDistance", r112);     // Catch: Throwable -> L13
        r104.a(r107);     // Catch: Throwable -> L13
        r104.a(r109);     // Catch: Throwable -> L13
        r104.a(r111);     // Catch: Throwable -> L13
        r104.a(r113);     // Catch: Throwable -> L13
        return r104;
    L31:
        r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L32
    L27:
        r110 = 10;
        goto L28
    L23:
        r108 = 86400;
        goto L24
    L10:
        if (r102.a() == false) goto L12;
    L15:
        if (r102 != null) goto L17;
    L18:
        r105 = true;
    L19:
        r107 = r100.optBoolean("able", r105);     // Catch: Throwable -> L13
        goto L21
    L17:
        if (r102.a() == false) goto L19;
    L13:
        th = th;
        r103 = r104;
    L35:
        th.printStackTrace();
        return r103;
    L34:
        th = th;
        goto L35
    L41:
        return null;
    }

    private static void a(String r100, JSONObject r101, ad.a r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.has(r100) == false) goto L8;
        ad.a r103 = a(r101.optJSONObject(r100), false, r102);
        ad.a().a(r100, r103);
        return;
    }
}
