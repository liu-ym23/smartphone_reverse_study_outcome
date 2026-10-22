package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class CloudExecutor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f59797d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f59798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59800c;

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor$a$a, reason: collision with other inner class name */
        public static final class C0985a {
            public static void a(CloudResultType$ClientResultType r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "clientResultType");
                Intrinsics.checkNotNullParameter(r101, "errMsg");
                ALogger.d("CloudExecutor_CloudRequestListener", "onFail, clientResultType:" + r100 + ", errNo:" + r100.getErrNo() + ", message:" + r101);
            }
        }

        void a(CloudResultType$ClientResultType r100, String r101);

        void onSuccess();
    }

    public static final class b {
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CloudExecutor f59801a;

        public c(CloudExecutor r100) {
            this.f59801a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            Lazy r101 = CloudSPHelper.f59807a;
            if (CloudSPHelper.c(this.f59801a.f59800c) == true) goto L6;
            ALogger.i("CloudExecutor_refreshSid", "not login");
            this.f59801a.a(CloudResultType$ClientResultType.NotLogin, null, null);
        L10:
            return Unit.INSTANCE;
        L6:
            if (CloudSPHelper.b(this.f59801a.f59800c) <= (System.currentTimeMillis() / ((long) 1000))) goto L8;
            ALogger.i("CloudExecutor_refreshSid", "not expired");
            this.f59801a.b(null);
            goto L10
        L8:
            ALogger.i("CloudExecutor_refreshSid", "sid expired, do request");
            f.d(this.f59801a.d(), "https://dycloud.volces.com", CloudConstant$Method.GET, "/api/gateway/refresh_session/", MapsKt.mapOf(TuplesKt.to("X-TT-APPID", this.f59801a.f59800c)), MapsKt.mapOf(TuplesKt.to(WsConstants.KEY_SESSION_ID, CloudSPHelper.a(this.f59801a.f59800c))), new CloudExecutor$refreshSid$2$1(this), new CloudExecutor$refreshSid$2$2(this));
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f59802a = null;

        static {
            f59802a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Unit r101 = (Unit) r100;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CloudExecutor f59803a;

        public e(CloudExecutor r100) {
            this.f59803a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.d("CloudExecutor_refreshSid", r101.getMessage());
            if ((r101 instanceof TimeoutException) == false) goto L5;
            CloudResultType$ClientResultType r102 = CloudResultType$ClientResultType.NetworkTimeOut;
        L6:
            CloudExecutor r103 = this.f59803a;
            StringCompanionObject r104 = StringCompanionObject.INSTANCE;
            r103.a(r102, String.format(r102.getErrMsg(), Arrays.copyOf(new Object[]{o1.a(r101), Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r101))}, 2)), null);
            return;
        L5:
            r102 = CloudResultType$ClientResultType.NetworkError;
            goto L6
        }
    }

    public final f d() {
        return (f) this.f59799b.getValue();
    }

    static {
        new CloudExecutor("");
    }

    public CloudExecutor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        this.f59800c = r100;
        this.f59798a = new ConcurrentLinkedQueue();
        this.f59799b = LazyKt.lazy(CloudExecutor$cloudNetworkExecutor$2.INSTANCE);
    }

    public final void b(a r100) {
        if (r100 == null) goto L4;
        r100.onSuccess();
    L4:
        if (r100 != null) goto L12;
        Iterator<T> r101 = this.f59798a.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((a) r101.next()).onSuccess();
        goto L7
    L9:
        this.f59798a.clear();
        return;
    }

    public final void e(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ALogger.i("CloudExecutor_refreshSid", "refreshSid start");
        if (this.f59798a.isEmpty() == false) goto L5;
        this.f59798a.add(r100);
        Single.just(this.f59800c).subscribeOn(Schedulers.io()).map(new c(this)).subscribe(d.f59802a, new e(this));
        return;
    L5:
        ALogger.i("CloudExecutor_refreshSid", "refresh task already exist");
        this.f59798a.add(r100);
    }

    public final void a(CloudResultType$ClientResultType r100, String r101, a r102) {
        if (r102 == null) goto L7;
        if (r101 != null) goto L5;
        String r103 = r100.getErrMsg();
    L6:
        r102.a(r100, r103);
        goto L7
    L5:
        r103 = r101;
    L7:
        if (r102 != null) goto L21;
        Iterator<T> r104 = this.f59798a.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        a r105 = (a) r104.next();
        if (r101 != null) goto L14;
        String r106 = r100.getErrMsg();
    L15:
        r105.a(r100, r106);
        goto L10
    L14:
        r106 = r101;
        goto L15
    L16:
        this.f59798a.clear();
        return;
    }

    public final void c(int r110, String r111, String r112, final a r113, boolean r114) {
        ALogger.i("CloudExecutor_dealWithSidResponse", "statusCode:" + r110 + ", reason:" + r111);
        if (r110 != 200) goto L31;
        int r115 = j.f59831d;
        JSONObject r116 = new JSONObject(r112);
        Intrinsics.checkNotNullParameter(r116, "json");
        Long r100 = null;
        j r101 = new j(JSONObjectProtectorUtils.getInt(r116, "status_code"), r116.optString("status_message", null));
        JSONObject r117 = r116.optJSONObject("data");
        if (r117 == null) goto L7;
        int r102 = j.b.f59835c;
        Intrinsics.checkNotNullParameter(r117, "json");
        j.b r118 = new j.b();
        String r103 = r117.optString(WsConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r118.f59836a = r103;
        r118.f59837b = r117.optLong("expire_in");
        r101.f59832a = r118;
    L7:
        ALogger.i("CloudExecutor_dealWithSidResponse", "response: " + r101);
        if (r101.f59833b != CloudResultType$OpenPlatformServerResultType.Success.getErrNo()) goto L21;
        Lazy r119 = CloudSPHelper.f59807a;
        String r120 = this.f59800c;
        j.b r121 = r101.f59832a;
        if (r121 == null) goto L12;
        String r122 = r121.f59836a;
    L13:
        if (r121 == null) goto L15;
        r100 = Long.valueOf(r121.f59837b);
    L15:
        Intrinsics.checkNotNullParameter(r120, "appId");
        JSONObject r123 = new JSONObject();
        r123.put(WsConstants.KEY_SESSION_ID, r122);     // Catch: JSONException -> L18
        r123.put("expiredTime", r100);     // Catch: JSONException -> L18
    L20:
        ((SharedPrefHelper) CloudSPHelper.f59807a.getValue()).m(r120, r123.toString());
        ALogger.d("CloudSPHelper_saveSId", "appId:" + r120 + ", sid:" + r122 + ", expiredTime:" + r100);
        b(r113);
        return;
    L18:
        e = move-exception;
        ALogger.e("CloudSPHelper_saveSid", e);
        goto L20
    L12:
        r122 = null;
        goto L13
    L21:
        ALogger.i("CloudExecutor_dealWithSidResponse", "server error: errNo = " + r101.f59833b + ", errMsg = " + r101.f59834c);
        if (r101.f59833b != CloudResultType$OpenPlatformServerResultType.NotFaasFunction.getErrNo()) goto L24;
        boolean r124 = true;
    L25:
        if (r124 == false) goto L27;
        ALogger.i("CloudExecutor_dealWithSidResponse", "not available faas function");
    L27:
        if (r114 == false) goto L30;
        if (r124 == true) goto L30;
        int r125 = CloudLoginService.f59804a;
        CloudLoginService.a(this, new CloudExecutor$dealWithSidResponse$1(this, r113), new CloudExecutor$dealWithSidResponse$2(this, r113));
        return;
    L30:
        CloudResultType$ClientResultType r126 = CloudResultType$ClientResultType.ServerError;
        StringCompanionObject r127 = StringCompanionObject.INSTANCE;
        a(r126, String.format(r126.getErrMsg(), Arrays.copyOf(new Object[]{r101.f59834c, Integer.valueOf(r101.f59833b)}, 2)), r113);
        return;
    L24:
        r124 = false;
        goto L25
    L31:
        CloudResultType$ClientResultType r128 = CloudResultType$ClientResultType.NetworkUnavailable;
        StringCompanionObject r129 = StringCompanionObject.INSTANCE;
        a(r128, String.format(r128.getErrMsg(), Arrays.copyOf(new Object[]{r111, Integer.valueOf(r110)}, 2)), r113);
    }
}
