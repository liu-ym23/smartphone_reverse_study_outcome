package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.SelectMediaResultModel;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.model.SimpleMediaInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.t5;
import w20.wd;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "selectMedia")
public final class e extends t5<wd, SelectMediaResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142195a;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f142195a = Disposables.disposed();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        this.f142195a.dispose();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        wd r112 = (wd) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r113 = r111.getContext();
        if ((r113 instanceof Activity) == true) goto L5;
        r113 = null;
    L5:
        Activity r100 = (Activity) r113;
        if (r100 != null) goto L8;
        finishWithFailure(new Throwable("activity error"));
        return;
    L8:
        IHostAction r101 = (IHostAction) jc1.k.n(IHostAction.class);
        String r102 = r112.e();
        Integer r114 = r112.c();
        if (r114 == null) goto L11;
        int r115 = r114.intValue();
    L12:
        Integer r103 = r112.d();
        if (r103 == null) goto L15;
        int r104 = r103.intValue();
    L16:
        Integer r105 = r112.a();
        if (r105 == null) goto L19;
        int r106 = r105.intValue();
    L20:
        String r107 = r112.b();
        Integer r108 = r112.g();
        if (r108 == null) goto L23;
        int r109 = r108.intValue();
    L24:
        List<String> r116 = r112.f();
        if (r116 == null) goto L28;
        ArrayList<String> r117 = (ArrayList) CollectionsKt.toCollection(r116, new ArrayList());
        if (r117 == null) goto L28;
    L29:
        ArrayList<String> r118 = r117;
        boolean r119 = Intrinsics.areEqual(r112.i(), Boolean.TRUE);
        Single<List<SimpleMediaInfo>> r120 = r101.selectMedia(r100, r102, r115, r104, r106, r107, r109, r118, r119);
        if (r120 != null) goto L32;
        finishWithFailure(new Throwable("activity is not FragmentActivity"));
        return;
    L32:
        this.f142195a = r120.observeOn(Schedulers.computation()).map(new f(r112)).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        return;
    L28:
        r117 = new ArrayList();
        goto L29
    L23:
        r109 = 1;
        goto L24
    L19:
        r106 = 60000;
        goto L20
    L15:
        r104 = 10240;
        goto L16
    L11:
        r115 = 1;
        goto L12
    }
}
