package com.bytedance.android.livesdk.drawer.drawerlynx;

import com.bytedance.android.live.browser.jsbridge.base.CommunityDrawerUnfollowResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdk.user.n;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import w20.c0;
import w20.j8;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends c0<j8, CommunityDrawerUnfollowResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f122427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveDrawerLynxCard f122428b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f122427a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public d(LiveDrawerLynxCard r100) {
        this.f122428b = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.bytedance.android.livesdk.log.model.LiveVSLog] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        j8 r112 = (j8) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "cxt");
        n.c r113 = new n.c();
        ContextUtil.contextToActivity(this.f122428b.getContext());
        Integer r100 = r112.d();
        if (r100 == null) goto L5;
        r100.intValue();
    L5:
        String r101 = r112.e();
        if (r101 == null) goto L8;
        long r102 = CastLongProtector.parseLong(r101);
    L9:
        n.c r114 = (n.c) ((n.c) ((n.c) r113.f(r102)).c(r112.f())).e(j.b(LiveFollowScene.LIVE_DRAWER));
        r114.getClass();
        n r103 = new n(r114);
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        Disposable r104 = null;
        r115.element = null;
        j8.a r105 = r112.a();
        if (r105 == null) goto L22;
        String r106 = r105.a();
        if (r106 == null) goto L22;
        JSONObject r107 = new JSONObject(r106);
        String r108 = r107.optString("item_id", "");
        String r109 = r112.e();
        if (r109 != null) goto L16;
        String r116 = "";
    L17:
        String r117 = String.valueOf(r107.optLong("episode_id", 0));
        String r118 = r107.optString("season_id", "");
        JSONObject r119 = r107.optJSONObject("mod");
        if (r119 == null) goto L20;
        int r120 = r119.optInt("episode_stage");
    L21:
        r115.element = new LiveVSLog(r108, r116, r117, r118, r120, 8112);
        goto L22
    L20:
        r120 = 0;
        goto L21
    L16:
        r116 = r109;
    L22:
        IUserService r121 = (IUserService) k.f(IUserService.class);
        if (r121 == null) goto L33;
        f r122 = r121.user();
        if (r122 == null) goto L33;
        Observable<FollowPair> r123 = r122.G(r103);
        if (r123 == null) goto L33;
        Observable<FollowPair> r124 = r123.subscribeOn(Schedulers.io());
        if (r124 == null) goto L33;
        Observable<FollowPair> r125 = r124.observeOn(AndroidSchedulers.mainThread());
        if (r125 == null) goto L33;
        r104 = r125.subscribe(new b(this, r112, r115), new c(this));
    L33:
        this.f122427a = r104;
        return;
    L8:
        r102 = 0;
        goto L9
    }
}
