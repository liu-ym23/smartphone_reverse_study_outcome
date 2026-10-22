package com.bytedance.android.gamecp.business.download.ai;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class q implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f52498k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f52499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f52500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHandler f52502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f52503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f52504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f52505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f52506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f52507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f52508j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f52509a;

        public b(q r100) {
            this.f52509a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f52509a;     // Catch: Throwable -> L6
            if (r100.f52501c == false) goto L9;
            q.b(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public final void d() {
        this.f52502d.removeCallbacks(this.f52503e);
        this.f52501c = false;
        ((ArrayList) this.f52504f).clear();
        com.bytedance.android.gamecp.host_api.a.b().getAiService().stopGamePredict();
    }

    public final Room c() {
        bw.i r100 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        CastLongProtector.parseLong(this.f52506h);
        r100.p2(this.f52507i, this.f52508j);
        return null;
    }

    public final Context getContext() {
        return this.f52505g;
    }

    public static final void b(q r100) {
        r100.getClass();
        LocalTestManager.a(new Class[]{uv.a.class});
        new ArrayList();
        new LinkedHashMap();
        r100.c();
        Observable.create(new r(r100, r100.f52505g)).subscribeOn(Schedulers.io());
    }

    public static final JSONObject a(q r100, List r101) {
        r100.getClass();
        JSONObject r102 = new JSONObject();
        JSONArray r103 = new JSONArray();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L12;
        com.bytedance.android.gamecp.host_api.model.j r105 = (com.bytedance.android.gamecp.host_api.model.j) r104.next();
        JSONArray r106 = new JSONArray();
        List<String> r107 = r105.tags;
        if (r107 == null) goto L11;
        Iterator<T> r108 = r107.iterator();
    L9:
        if (r108.hasNext() == false) goto L11;
        r106.put((String) r108.next());
    L11:
        JSONObject r109 = new JSONObject();
        r109.putOpt("id", r105.gameId);
        r109.putOpt("type", "preview");
        r109.putOpt("name", r105.a());
        r109.putOpt("android_package_size", r105.androidPackageSize);
        r109.putOpt(PromotionProductPrivilegesStruct.TAGS, r106);
        r109.putOpt("game_category_id", Long.valueOf(r105.gameCategoryId));
        r109.putOpt("game_tag_id", Long.valueOf(r105.gameTagId));
        r109.putOpt("download_status", r105.f57397b);
        JSONObject r110 = new JSONObject();
        r110.putOpt("game_info", r109);
        Unit r111 = Unit.INSTANCE;
        r103.put(r110);
        goto L4
    L12:
        r102.putOpt("games", r103);
        r102.putOpt("type", "preview");
        return r102;
    }

    public q(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        Intrinsics.checkNotNullParameter(r103, "source");
        this.f52505g = r100;
        this.f52506h = r101;
        this.f52507i = r102;
        this.f52508j = r103;
        this.f52499a = new CompositeDisposable();
        this.f52501c = true;
        this.f52502d = new WeakHandler(Looper.getMainLooper(), this);
        this.f52503e = new b(this);
        this.f52504f = new ArrayList();
    }
}
