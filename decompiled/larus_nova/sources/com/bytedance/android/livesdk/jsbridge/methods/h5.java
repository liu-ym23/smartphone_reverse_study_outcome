package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "vcdAuthorize")
public final class h5 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f142133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f142134c;

    public static final class a implements IMiddlewareHostBusiness.AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h5 f142135a;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onAuthorized() {
            h5 r100 = this.f142135a;
            if (r100.f142133b == true) goto L6;
            JSONObject r101 = new JSONObject();
            r101.put("status_code", 1);
            Unit r102 = Unit.INSTANCE;
            r100.finishWithResult(r101);
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onDisauthorized() {
            h5 r100 = this.f142135a;
            if (r100.f142133b == true) goto L6;
            r100.finishWithFailure();
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onInterrupted() {
            h5 r100 = this.f142135a;
            if (r100.f142133b == true) goto L6;
            r100.finishWithFailure();
            return;
        }

        public a(h5 r100) {
            this.f142135a = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f142132a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f142133b = true;
    }

    public h5() {
        this.f142134c = new a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("type", "content");
        String r104 = r102.optString("content", "");
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        finishWithFailure();
        return;
    L8:
        Disposable r106 = null;
        if (UserSetting.b() == false) goto L14;
        IUserServiceV2 r107 = (IUserServiceV2) jc1.k.f(IUserServiceV2.class);
        if (r107 == null) goto L13;
        Single<? extends IBaseUser> r108 = r107.updateCurrentUser(null, "VcdAuthorizeMethod");
    L15:
        if (r108 == null) goto L19;
        Single<? extends IBaseUser> r109 = r108.observeOn(AndroidSchedulers.mainThread());
        if (r109 == null) goto L19;
        r106 = r109.subscribe(new i5(this, r103, r101, r104), new j5(this));
    L19:
        this.f142132a = r106;
        return;
    L13:
        r108 = null;
        goto L15
    L14:
        r108 = ((IUserService) jc1.k.n(IUserService.class)).user().j();
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
