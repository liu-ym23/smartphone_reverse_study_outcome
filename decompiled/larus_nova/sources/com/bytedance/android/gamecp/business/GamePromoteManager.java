package com.bytedance.android.gamecp.business;

import android.text.TextUtils;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.common.setting.config.p1;
import com.bytedance.android.gamecp.common.utils.LiveBroadcastBaseClient;
import com.bytedance.android.gamecp.host_api.model.Room;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import wu.c4;
import wu.u4;
import wu.v4;

/* JADX INFO: loaded from: classes44.dex */
public final class GamePromoteManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Lambda f51751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, qs.f> f51752b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final xr.f f51753c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Disposable f51754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Disposable f51755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f51756f = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wr.b f51757a;

        public a(wr.b r100) {
            this.f51757a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
            wr.b r102 = this.f51757a;
            if (r101 == null) goto L11;
            com.bytedance.android.gamecp.business.download.ai.a0 r103 = (com.bytedance.android.gamecp.business.download.ai.a0) r101.data;
            if (r103 == null) goto L11;
            List<com.bytedance.android.gamecp.business.download.ai.y> r104 = r103.mPromoteList;
            if (r104 == null) goto L11;
            com.bytedance.android.gamecp.business.download.ai.y r105 = (com.bytedance.android.gamecp.business.download.ai.y) CollectionsKt.firstOrNull(r104);
            if (r105 == null) goto L11;
            String r106 = r105.f52530id;
        L12:
            r102.onResult(r106);
            return;
        L11:
            r106 = null;
            goto L12
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f51758a = null;

        static {
            f51758a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            StringBuilder r102 = new StringBuilder("getPromoteGameId error: ");
            if (r101 == null) goto L5;
            String r103 = r101.getMessage();
        L6:
            r102.append(r103);
            yr.c.b("GamePromoteManager", r102.toString());
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        f51752b = new LinkedHashMap();
        f51753c = (xr.f) xr.s.a(xr.f.class);
        f51756f = LazyKt.lazy(GamePromoteManager$keva$2.INSTANCE);
    }

    public static void c(wr.b r100) {
        Lazy r101 = LiveBroadcastBaseClient.f57176a;
        GamePromoteApi r102 = (GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class);
        Room r103 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        Disposable r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getOwnerUserId();
    L6:
        Observable<com.bytedance.android.gamecp.base.network.response.i<com.bytedance.android.gamecp.business.download.ai.a0>> r106 = r102.getSimpleAnchorPromoteList(String.valueOf(r105));
        if (r106 == null) goto L11;
        Observable<com.bytedance.android.gamecp.base.network.response.i<com.bytedance.android.gamecp.business.download.ai.a0>> r107 = r106.observeOn(AndroidSchedulers.mainThread());
        if (r107 == null) goto L11;
        r104 = r107.subscribe(new a(r100), b.f51758a);
    L11:
        f51755e = r104;
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void b(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        yr.c.e("GamePromoteManager", "executeContinue result=" + r100 + " ,roomID=" + r101);
        Map<Long, qs.f> r102 = f51752b;
        Long r103 = Long.valueOf(r101);
        qs.a r104 = new qs.a();
        p1 r105 = c4.f561292a.getValue();
        r104.f534634a = Observable.interval(r105.a(), r105.b(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new qs.b(r104), qs.c.f534637a);
        Unit r106 = Unit.INSTANCE;
        r102.put(r103, r104);
        return;
    }

    public static void a(String r110, long r111, String r112, String r113, long r114, String r115) {
        Ref.IntRef r100 = new Ref.IntRef();
        r100.element = 0;
        if (v4.f561406a.getValue().booleanValue() == false) goto L12;
        if (u4.f561400a.getValue().contains(r110) == false) goto L12;
        xr.g r101 = (xr.g) xr.s.a(xr.g.class);
        if (r101 == null) goto L12;
        if (r101.hasLogin() != true) goto L12;
        r100.element = 2;
    L12:
        String r102 = "push请求，pushType:" + r100.element;
        if (com.bytedance.android.gamecp.host_api.a.b().getHostContext().isLocalTest() == false) goto L15;
        yr.c.e("push", r102);
    L15:
        Observable<com.bytedance.android.gamecp.base.network.response.i<Object>> r103 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).reportInstallFailStatus(r110, r111, r112, r113, r114, r100.element, r115);
        if (r103 == null) goto L21;
        Observable<com.bytedance.android.gamecp.base.network.response.i<Object>> r104 = r103.observeOn(AndroidSchedulers.mainThread());
        if (r104 == null) goto L22;
        r104.subscribe(y.f56507a, new z(r100));
        return;
    L22:
        return;
    }
}
