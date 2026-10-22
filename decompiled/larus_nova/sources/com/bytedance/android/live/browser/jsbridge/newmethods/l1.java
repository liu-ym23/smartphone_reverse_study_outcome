package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.gson.ILiveGsonService;
import com.bytedance.android.livesdk.config.kt;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l1 extends com.bytedance.ies.web.jsbridge2.f<JsonObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f63537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICalendarManager f63538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f63539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ICalendarManager.IPermissionHandler f63540d;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f63537a.clear();
    }

    public final boolean j(Disposable r100) {
        return this.f63537a.add(r100);
    }

    public l1(final Context r100, com.bytedance.android.live.browser.r.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permissionHandler");
        this.f63540d = r101;
        this.f63537a = new CompositeDisposable();
        IMiddlewareLiveService r102 = TTLiveServiceMiddleware.getLiveService();
        Intrinsics.checkNotNull(r102);
        this.f63538b = r102.getCalendarManager(r100);
        this.f63539c = LazyKt.lazy(new CalendarMethod$timonCalendarManager$2(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JsonObject r110, CallContext r111) {
        JsonObject r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Gson r101 = ((ILiveGsonService) jc1.k.n(ILiveGsonService.class)).get();
        JsonObject r102 = r100.get("params").getAsJsonObject();
        String r103 = r100.get("action").getAsString();
        String r104 = "";
        if (kt.f120627a.getValue().booleanValue() == false) goto L48;
        if (r103 == null) goto L47;
        int r105 = r103.hashCode();
        boolean r112 = true;
        if (r105 == (-934610812)) goto L25;
        if (r105 == 96417) goto L15;
        if (r105 != 102230) goto L47;
        if (r103.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L47;
        j(Single.fromCallable(new g1(this, r102.get("event_id").getAsString())).subscribeOn(Schedulers.io()).subscribe(new h1(this, r101), new i1(this)));
        return;
    L15:
        if (r103.equals("add") == false) goto L47;
        final i7 r106 = (i7) this.f63539c.getValue();
        final ICalendarManager.EventParams r107 = (ICalendarManager.EventParams) GsonProtectorUtils.fromJson(r101, r102, ICalendarManager.EventParams.class);
        ICalendarManager.IPermissionHandler r108 = this.f63540d;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "event");
        Intrinsics.checkNotNullParameter(r108, "handler");
        Function0<Single<ICalendarManager.ErrorCode>> r109 = new LiveTimonCalendarManager$requestPermissionAndAdd$proceed$1(r106, r107);
        if (r106.a() == false) goto L20;
        Single r113 = r109.invoke();
    L23:
        j(r113.subscribe(new c1(this), new d1(this)));
        return;
    L20:
        if (j40.f4.B.getValue().booleanValue() == false) goto L22;
        r113 = Single.error(new Exception("user had denied calendar permission before"));
        goto L23
    L22:
        r113 = r108.requestWriteCalendarPermission().onErrorReturnItem(new int[]{-1}).observeOn(AndroidSchedulers.mainThread()).flatMap(new u7(r109));
        goto L23
    L25:
        if (r103.equals("remove") == false) goto L47;
        String r114 = r102.get("event_id").getAsString();
        JsonElement r115 = r102.get("anchor_id");
        if (r115 == null) goto L32;
        String r116 = r115.getAsString();
        if (r116 == null) goto L32;
        r104 = r116;
    L32:
        i7 r117 = (i7) this.f63539c.getValue();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r114, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r104, "anchorId");
    L44:
        th = move-exception;
        ALogger.throwable(5, "CalendarManager", "failed to add calendar event", th);
        Single r118 = Single.fromCallable(t7.f63677a);
    L46:
        j(r118.subscribeOn(Schedulers.io()).subscribe(new e1(this), new f1(this)));
        return;
    L34:
        if (r114.length() == 0) goto L37;
        r112 = false;
    L37:
        if (r112 == false) goto L40;
        r118 = Single.fromCallable(q7.f63613a);     // Catch: Throwable -> L44
    L72:
        goto L46
    L40:
        if (r117.a() == true) goto L42;
        r118 = Single.fromCallable(r7.f63629a);     // Catch: Throwable -> L44
        goto L72
    L42:
        r118 = Single.create(new s7(r117, r114, r104));     // Catch: Throwable -> L44
    L47:
        finishWithFailure(new IllegalArgumentException("unknown action " + r103));
        return;
    L48:
        if (r103 == null) goto L70;
        int r119 = r103.hashCode();
        if (r119 == (-934610812)) goto L62;
        if (r119 == 96417) goto L59;
        if (r119 != 102230) goto L70;
        if (r103.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L70;
        j(Single.fromCallable(new z0(this, r102.get("event_id").getAsString())).subscribeOn(Schedulers.io()).subscribe(new a1(this, r101), new b1(this)));
        return;
    L59:
        if (r103.equals("add") == false) goto L70;
        ICalendarManager r120 = this.f63538b;
        Intrinsics.checkNotNull(r120);
        j(r120.requestPermissionAndAdd((ICalendarManager.EventParams) GsonProtectorUtils.fromJson(r101, r102, ICalendarManager.EventParams.class), this.f63540d).subscribe(new j1(this), new k1(this)));
        return;
    L62:
        if (r103.equals("remove") == false) goto L70;
        String r121 = r102.get("event_id").getAsString();
        JsonElement r122 = r102.get("anchor_id");
        if (r122 == null) goto L69;
        String r123 = r122.getAsString();
        if (r123 == null) goto L69;
        r104 = r123;
    L69:
        j(Single.fromCallable(new w0(this, r121, r104)).subscribeOn(Schedulers.io()).subscribe(new x0(this), new y0(this)));
        return;
    L70:
        finishWithFailure(new IllegalArgumentException("unknown action " + r103));
    }

    public final void k(ICalendarManager.ErrorCode r100, JsonElement r101) {
        JsonObject r102 = new JsonObject();
        r102.addProperty("status_code", Integer.valueOf(r100.getValue()));
        if (r101 == null) goto L5;
        r102.add("data", r101);
    L5:
        finishWithResult(r102);
    }
}
