package com.bytedance.android.live.profit.taskcenter.preload;

import android.os.Build;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.scope.o;
import com.bytedance.live.kmp.core.KmpEnv;
import com.tencent.open.SocialConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import org.json.JSONObject;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements com.bytedance.android.live.profit.taskcenter.preload.a, o, m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f89055g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f89056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.profit.taskcenter.preload.b f89057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f89058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f89059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f89060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yz0.k f89061f;

    public static final class a {
    }

    public static final class b implements wp2.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<d> f89062a;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // wp2.i
        public final void a(wp2.d r100) {
            if (this.f89062a.get() == null) goto L9;
            boolean r101 = r100 instanceof wp2.h;
            if (r101 == true) goto L7;
            int r102 = r100.f560561b;
            int r103 = d.f89055g;
            Map<? extends String, ? extends String> r104 = MapsKt.mapOf(new Pair[]{TuplesKt.to("success", String.valueOf(r101)), TuplesKt.to(SocialConstants.PARAM_APP_DESC, String.valueOf(false)), TuplesKt.to("code", String.valueOf(r102))});
            n r105 = new n();
            Map<String, String> r106 = r105.f516447a;
            Intrinsics.checkNotNullParameter(r106, "map");
            Intrinsics.checkNotNullParameter(r104, "map");
            r106.putAll(r104);
            mz0.m r107 = new mz0.m();
            r107.b(LogCommon.ROOM);
            r107.b(LogCommon.PAGE_SOURCE_LOG);
            ((ArrayList) r105.f516448b).addAll(r107.f516446a);
            cy0.e.f465759a.getClass();
            cy0.j r108 = cy0.e.a.f465760a;
            com.bytedance.android.scope.m.f163449e.getClass();
            Object r109 = com.bytedance.android.scope.m.b(r108).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r109);
            ((mz0.i) ((f80.a) r109)).w3("livesdk_excitation_panel_preload_clientAI", r105.f516447a, r105.f516448b);
            return;
        L7:
            wp2.h r110 = (wp2.h) r100;
            throw null;
        L9:
            TaskApiPreloadService$InnerCallBack$onCompleted$2 r111 = TaskApiPreloadService$InnerCallBack$onCompleted$2.INSTANCE;
        }

        public b(WeakReference<d> r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "serviceRef");
            Intrinsics.checkNotNullParameter(r102, "anchorId");
            this.f89062a = r100;
        }
    }

    static {
    }

    @Override // yz0.m
    public final void i() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        KmpEnv r100 = KmpEnv.f255139a;
        if (KmpEnv.b() == true) goto L5;
        return;
    L5:
        if (this.f89057b.getType() != 1) goto L8;
        RxUtilKt.c(Observable.timer(this.f89057b.a(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(this, this.f89061f.getRoom().getRoomId(), this.f89061f.getRoom().getOwnerUserIdString()), j.f89073a), this.f89056a);
    L17:
        this.f89060e = System.currentTimeMillis();
        RxUtilKt.c(((com.bytedance.android.livesdk.revenue.service.hybrid.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.hybrid.d.class)).registerJsEventSubscriber("webcast.coin_box_pendant.on_click").observeOn(AndroidSchedulers.mainThread()).take(1).subscribe(new k(this)), this.f89056a);
        return;
    L8:
        if (this.f89057b.getType() != 2) goto L17;
        if (this.f89057b.b() > 0) goto L12;
        ALogger.e("TaskCenterService", "interval config invalid: " + this.f89057b.b());
        goto L17
    L12:
        long r101 = this.f89061f.getRoom().getRoomId();
        String r102 = this.f89061f.getRoom().getOwnerUserIdString();
        JSONObject r103 = new JSONObject();
        IBaseUser r104 = this.f89061f.getRoom().getOwner();
        if (r104 == null) goto L15;
        boolean r105 = r104.isFollowing();
    L16:
        d60.b.a(r103, ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS, Boolean.valueOf(r105));
        d60.b.a(r103, "age_range", Integer.valueOf(this.f89061f.getUser().getAgeRange()));
        d60.b.a(r103, "gender", Integer.valueOf(this.f89061f.getUser().getGender()));
        d60.b.a(r103, "device_type", Build.MODEL);
        d60.b.a(r103, "city", this.f89061f.getUser().getCity());
        d60.b.a(r103, "city_level", "");
        d60.b.a(r103, "edu_level", "");
        d60.b.a(r103, "consume_level", com.bytedance.android.livesdk.sharedpref.b.f158116J.getValue());
        Disposable r106 = Observable.interval(this.f89057b.a(), this.f89057b.b(), TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r103, r101, r102), h.f89069a);
        RxUtilKt.c(r106, this.f89056a);
        this.f89058c = r106;
        goto L17
    L15:
        r105 = false;
        goto L16
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f89056a.clear();
        this.f89059d = true;
    }

    public d(yz0.k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f89061f = r100;
        this.f89056a = new CompositeDisposable();
        this.f89057b = (com.bytedance.android.live.profit.taskcenter.preload.b) com.bytedance.android.live.profit.taskcenter.k.f89034d.getValue(null, com.bytedance.android.live.profit.taskcenter.k.f89031a[2]);
        this.f89058c = Disposables.disposed();
        this.f89059d = true;
    }

    public static String a(String r100) {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r101 = ((mz0.c) com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class)).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r101 == null) goto L5;
        Map<String, String> r102 = r101.getMap();
    L6:
        if (r102 == null) goto L9;
        String r103 = r102.get(r100);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return "";
    L5:
        r102 = null;
        goto L6
    }
}
