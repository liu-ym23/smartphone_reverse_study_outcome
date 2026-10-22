package com.bytedance.android.gamecp.business.download.ai;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.model.toolbar.LiveToolbarData;
import com.bytedance.android.gamecp.host_api.model.toolbar.ToolbarComponentData;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import wu.d2;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f52462q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f52463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.gamecp.business.download.ai.b f52464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f52465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f52466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f52467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f52468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f52469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f52470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakHandler f52471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f52472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<com.bytedance.android.gamecp.host_api.model.j> f52473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f52474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f52475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f52476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f52477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f52478p;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f52479a;

        public b(c r100) {
            this.f52479a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (d2.f561296a.getValue().l() == true) goto L5;
            c r100 = this.f52479a;     // Catch: Throwable -> L11
            if (r100.f52467e == false) goto L16;
            c.c(r100);     // Catch: Throwable -> L11
        L16:
            return;
        L5:
            if (c.b(this.f52479a) == false) goto L16;
            c.c(this.f52479a);     // Catch: Throwable -> L11
            goto L16
        }
    }

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public final boolean g() {
        if (d2.f561296a.getValue().l() == false) goto L7;
        mw.a r100 = (mw.a) xr.s.a(mw.a.class);
        if (r100 != null) goto L14;
        return false;
    L14:
        return r100.isGameCPRoom(String.valueOf(this.f52476n), this.f52477o, this.f52478p);
    L7:
        Room r101 = f();
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.isGameCPRoom() != true) goto L16;
        return true;
    L16:
        return false;
    }

    public final void h() {
        this.f52471i.removeCallbacks(this.f52472j);
        this.f52468f = true;
        this.f52467e = false;
        ((ArrayList) this.f52474l).clear();
        com.bytedance.android.gamecp.host_api.a.b().getAiService().stopGamePredict();
        if (d2.f561296a.getValue().l() == false) goto L9;
        Disposable r100 = this.f52470h;
        if (r100 == null) goto L7;
        r100.dispose();
    L7:
        this.f52470h = null;
        this.f52469g = false;
        return;
    }

    public final Room f() {
        return com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
    }

    public static final boolean b(c r100) {
        if (r100.g() == true) goto L6;
        yr.c.b("AiDownloadPredictor", "非联运直播间，跳过 " + r100.f52477o + '-' + r100.f52478p);
        return false;
    L6:
        if (r100.f52467e == true) goto L8;
        yr.c.b("AiDownloadPredictor", "延迟期间，轮询算法包功能被关闭，不再触发智能讲解 " + r100.f52477o + '-' + r100.f52478p);
        return false;
    L8:
        r100.e(r100.f());
        return true;
    }

    public static final void c(c r100) {
        r100.getClass();
        LocalTestManager.a(new Class[]{uv.a.class});
        ArrayList r101 = new ArrayList();
        LinkedHashMap r102 = new LinkedHashMap();
        if (d2.f561296a.getValue().l() == false) goto L19;
        mw.a r103 = (mw.a) xr.s.a(mw.a.class);
        if (r103 == null) goto L24;
        ArrayList<com.bytedance.android.gamecp.host_api.model.j> r104 = r103.getSimpleGameInfoList(String.valueOf(r100.f52476n), r100.f52477o, r100.f52478p);
        if (r104 == null) goto L24;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L14;
        Object r107 = r106.next();
        if (r100.d((com.bytedance.android.gamecp.host_api.model.j) r107) == false) goto L10;
        r105.add(r107);
        goto L10
    L14:
        Iterator r108 = r105.iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        com.bytedance.android.gamecp.host_api.model.j r109 = (com.bytedance.android.gamecp.host_api.model.j) r108.next();
        r109.getClass();
        Intrinsics.checkNotNullParameter(com.alipay.sdk.m.k.b.f25406k, "<set-?>");
        r109.f57396a = com.alipay.sdk.m.k.b.f25406k;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r109.f57397b = "";
        goto L16
    L18:
        Observable r110 = Observable.just(r105);
    L25:
        Observable r111 = Observable.create(new e(r100, r100.f52475m)).subscribeOn(Schedulers.io()).doOnSubscribe(new f(r100));
        if (r110 == null) goto L37;
        if (r111 == null) goto L38;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(Observable.concat(r110, r111).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new j(r101, r102)).doOnComplete(new k(r100, r101, r102)).subscribe(l.f52494a, new m(r100), n.f52496a), r100.f52463a);
        return;
    L38:
        return;
    L37:
        return;
    L24:
        r110 = null;
        goto L25
    L19:
        Room r112 = r100.f();
        if (r112 == null) goto L24;
        List<com.bytedance.android.gamecp.host_api.model.toolbar.a> r113 = r112.getGameInfoList();
        if (r113 == null) goto L24;
        r110 = Observable.just(r113).map(new d(r100));
        goto L25
    }

    public final boolean d(com.bytedance.android.gamecp.host_api.model.j r100) {
        if (e(f()) == true) goto L6;
        return false;
    L6:
        if (com.bytedance.android.gamecp.business.download.ai.a.a(false) == true) goto L13;
        Context r101 = this.f52475m;
        String r102 = r100.androidPackageName;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "packageName");
        r101.getPackageManager().getPackageInfo(r102, 1);     // Catch: PackageManager.NameNotFoundException -> L10
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return false;
    L10:
        r103 = false;
    L13:
        return true;
    }

    public final boolean e(Room r100) {
        String r101 = null;
        boolean r102 = false;
        if (d2.f561296a.getValue().l() == false) goto L8;
        mw.a r103 = (mw.a) xr.s.a(mw.a.class);
        if (r103 == null) goto L7;
        r102 = r103.canAutoIntro(String.valueOf(this.f52476n), this.f52477o, this.f52478p);
    L7:
        this.f52466d = r102;
    L32:
        this.f52466d = r102;
        if (r102 == false) goto L46;
        JSONObject r104 = new JSONObject();
        if (r100 == null) goto L38;
        String r105 = r100.getOwnerUserId();
        if (r105 == null) goto L38;
    L39:
        r104.put("anchor_id", r105);
        if (r100 == null) goto L44;
        Long r106 = r100.getRoomId();
        if (r106 == null) goto L44;
        r101 = String.valueOf(r106.longValue());
    L44:
        r104.put("room_id", r101);
        Unit r107 = Unit.INSTANCE;
        yr.c.e("explain_card_anchor_enable_auto", r104.toString());
    L38:
        r105 = "";
    L46:
        return this.f52466d;
    L8:
        if (r100 == null) goto L31;
        LiveToolbarData r108 = r100.getToolbarData();
        if (r108 == null) goto L31;
        List<ToolbarComponentData> r109 = r108.getToolbarDataList();
        if (r109 == null) goto L31;
        Iterator<T> r110 = r109.iterator();
    L15:
        if (r110.hasNext() == false) goto L22;
        Object r111 = r110.next();
        if (((ToolbarComponentData) r111).getId() != 5) goto L19;
        boolean r112 = true;
    L20:
        if (r112 == false) goto L15;
    L23:
        ToolbarComponentData r113 = (ToolbarComponentData) r111;
        if (r113 == null) goto L31;
        AiIntroStatus r114 = ((GamePromotionExtra) GsonProtectorUtils.fromJson(GsonHelper.get(), r113.getExtraData(), GamePromotionExtra.class)).getStatusList();
        if (r114 != null) goto L28;
    L30:
        this.f52466d = r102;
        Unit r115 = Unit.INSTANCE;
        goto L31
    L28:
        if (r114.getGameStatus() != Status.ENABLE.getCode()) goto L30;
        r102 = true;
        goto L30
    L19:
        r112 = false;
        goto L20
    L22:
        r111 = null;
    L31:
        r102 = this.f52466d;
        goto L32
    }

    public static final JSONObject a(c r100, List r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        JSONArray r103 = new JSONArray();
        boolean r104 = d2.f561296a.getValue().m();
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L16;
        com.bytedance.android.gamecp.host_api.model.j r106 = (com.bytedance.android.gamecp.host_api.model.j) r105.next();
        JSONArray r107 = new JSONArray();
        List<String> r108 = r106.tags;
        if (r108 == null) goto L11;
        Iterator<T> r109 = r108.iterator();
    L9:
        if (r109.hasNext() == false) goto L11;
        r107.put((String) r109.next());
    L11:
        if (r104 == false) goto L15;
        if (UtilsKt.c(r106.gameId) == false) goto L15;
        r102.putOpt("game_id", r106.gameId);
    L15:
        JSONObject r110 = new JSONObject();
        r110.putOpt("id", r106.gameId);
        r110.putOpt("name", r106.a());
        r110.putOpt("android_package_size", r106.androidPackageSize);
        r110.putOpt(PromotionProductPrivilegesStruct.TAGS, r107);
        r110.putOpt("game_category_id", Long.valueOf(r106.gameCategoryId));
        r110.putOpt("game_tag_id", Long.valueOf(r106.gameTagId));
        r110.putOpt("download_status", r106.f57397b);
        JSONObject r111 = new JSONObject();
        r111.putOpt("game_info", r110);
        Unit r112 = Unit.INSTANCE;
        r103.put(r111);
        goto L4
    L16:
        r102.putOpt("games", r103);
        if (d2.f561296a.getValue().j() == false) goto L19;
        Object r113 = "1";
    L20:
        r102.putOpt("trans_target", r113);
        if (r104 == false) goto L23;
        r102.putOpt("user_id", com.bytedance.android.gamecp.host_api.a.b().getUserService().getCurUserId());
    L23:
        return r102;
    L19:
        r113 = "0";
        goto L20
    }

    public c(Context r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f52475m = r100;
        this.f52476n = r101;
        this.f52477o = r102;
        this.f52478p = r103;
        this.f52463a = new CompositeDisposable();
        this.f52467e = true;
        this.f52468f = true;
        this.f52471i = new WeakHandler(Looper.getMainLooper(), this);
        this.f52472j = new b(this);
        this.f52473k = new ArrayList();
        this.f52474l = new ArrayList();
    }
}
