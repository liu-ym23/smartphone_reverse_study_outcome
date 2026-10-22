package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudLoginService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class i1 extends BaseOpenMethod<JSONObject> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CloudExecutor f60496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f60497i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i1 f60498a;

        public b(i1 r100) {
            this.f60498a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            i1 r102 = this.f60498a;
            r102.getClass();
            ALogger.i("UserLoginMethod_callLogin", "login start");
            int r103 = CloudLoginService.f59804a;
            CloudLoginService.a(r102.f60496h, new UserLoginMethod$callLogin$1(r102), new UserLoginMethod$callLogin$2(r102));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i1 f60499a;

        public c(i1 r100) {
            this.f60499a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.i("UserLoginMethod_call", "user not login host");
            this.f60499a.n(OpenApiErrorInfo.NOT_LOGIN, null);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "login";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = r100.optBoolean("force", true);
        if (((IUserService) jc1.k.n(IUserService.class)).user().isLogin() == false) goto L5;
        ALogger.i("UserLoginMethod_callLogin", "login start");
        int r103 = CloudLoginService.f59804a;
        CloudLoginService.a(this.f60496h, new UserLoginMethod$callLogin$1(this), new UserLoginMethod$callLogin$2(this));
        return;
    L5:
        if (r102 == false) goto L7;
        com.bytedance.android.livesdk.user.f r104 = ((IUserService) jc1.k.n(IUserService.class)).user();
        Context r105 = this.f60497i;
        com.bytedance.android.livesdk.user.l.a r106 = new com.bytedance.android.livesdk.user.l.a();
        r106.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);
        r106.f158688d = "live_open_platform";
        r106.f158687c = -1;
        j(r104.login(r105, new com.bytedance.android.livesdk.user.l(r106)).subscribe(new b(this), new c(this)));
        return;
    L7:
        n(OpenApiErrorInfo.NOT_LOGIN, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public i1(PluginContext r100, CloudExecutor r101, Context r102, Queue<Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "cloudExecutor");
        Intrinsics.checkNotNullParameter(r102, "_context");
        super(r100, r103);
        this.f60496h = r101;
        this.f60497i = r102;
    }
}
