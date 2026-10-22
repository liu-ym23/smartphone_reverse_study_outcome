package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.android.live.browser.jsbridge.state.StateObserver;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "__getCurrentState")
public final class e4 extends com.bytedance.ies.web.jsbridge2.f<a, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public StateObservingService f63359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f63360b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/e4$a;", "", "", "", "keys", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("keys")
        private List<String> keys;

        public a() {
        }

        public final List<String> a() {
            return this.keys;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f63360b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f63360b = null;
    }

    public e4() {
        BrowserServiceImpl.Companion.getClass();
        s20.a r100 = ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a();
        Gson r101 = r100.f540207a.f540216i.get();
        this.f63359a = r100.f540207a.f540217j.get();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "param");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        StateObserver.a r103 = StateObserver.f63890h;
        StateObservingService r104 = this.f63359a;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stateObservingService");
    L5:
        JSONArray r105 = new JSONArray();
        List<String> r106 = r102.a();
        if (r106 == null) goto L11;
        Iterator<T> r107 = r106.iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        r105.put((String) r107.next());
    L11:
        Unit r108 = Unit.INSTANCE;
        Observable r109 = Observable.just(StateObserver.Companion.a(r104, r105));
        int r110 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        this.f63360b = r109.observeOn(Schedulers.io()).map(f4.f63373a).subscribe(new g4(this), new h4(this));
    }
}
