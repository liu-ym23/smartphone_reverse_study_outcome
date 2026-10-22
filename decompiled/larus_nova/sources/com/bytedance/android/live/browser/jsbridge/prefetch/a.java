package com.bytedance.android.live.browser.jsbridge.prefetch;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.livesdk.config.hj0;
import com.bytedance.android.livesdk.config.l7;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.tools.prefetch.w;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f63782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f63783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f63784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f63785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w f63786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePrefetchProcessor f63787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.browser.w f63788g;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.prefetch.a$a, reason: collision with other inner class name */
    public static final class C1045a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f63789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f63790b;

        public C1045a(a r100, JSONObject r101) {
            this.f63789a = r100;
            this.f63790b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            this.f63789a.finishWithResult(this.f63790b);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f63791a;

        public b(a r100) {
            this.f63791a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a r101 = this.f63791a;
            r101.finishWithFailure((Throwable) r100);
        }
    }

    public static final class c extends com.bytedance.ies.tools.prefetch.m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f63792a;

        public c(a r100) {
            this.f63792a = r100;
        }

        @Override // com.bytedance.ies.tools.prefetch.m.a
        public final void b(com.bytedance.ies.tools.prefetch.i.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            boolean r101 = false;
            if ((r100 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == false) goto L21;
            JSONObject r102 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r100).f63777g.getValue();
            JSONObject r103 = this.f63792a.f63782a;
            if (r103 == null) goto L7;
            r101 = true;
        L7:
            if (r101 == false) goto L20;
            JSONObject r104 = r103.optJSONObject("_filter_keys");
            String r105 = r103.optString("process_name", null);
            if (r104 != null) goto L17;
            a r106 = this.f63792a;
            View r107 = r106.f63783b;
            if (r105 == null) goto L16;
            if (r107 == null) goto L16;
            Object r108 = r106.f63788g.map2TemplateData(UtilsKt.g(r102), r105);
            if (r108 == null) goto L16;
            this.f63792a.f63788g.updateData(r107, r108, true);
        L16:
            this.f63792a.j(r102);
            return;
        L17:
            this.f63792a.f63784c.add(Observable.fromCallable(new com.bytedance.android.live.browser.jsbridge.prefetch.b(this, r102, r104, r105)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.browser.jsbridge.prefetch.c(this), new d(this)));
            return;
        L20:
            throw new IllegalStateException("params shouldn't be null".toString());
        L21:
            PrefetchNetworkExecutorImpl.MultiFormatResponse.b r109 = (PrefetchNetworkExecutorImpl.MultiFormatResponse.b) r100;
            JSONObject r110 = this.f63792a.f63782a;
            if (r110 == null) goto L24;
            r101 = true;
        L24:
            if (r101 == false) goto L34;
            String r111 = r110.optString("process_name", null);
            a r112 = this.f63792a;
            View r113 = r112.f63783b;
            if (r111 == null) goto L31;
            if (r113 == null) goto L31;
            Object r114 = r112.f63788g.map2TemplateData(UtilsKt.g((JSONObject) r109.f63777g.getValue()), r111);
            if (r114 == null) goto L31;
            this.f63792a.f63788g.updateData(r113, r114, true);
        L31:
            this.f63792a.j((JSONObject) r109.f63777g.getValue());
            return;
        L34:
            throw new IllegalStateException("params shouldn't be null".toString());
        }

        @Override // com.bytedance.ies.tools.prefetch.m.a, com.bytedance.ies.tools.prefetch.m
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f63792a.finishWithFailure(r100);
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        w r100 = this.f63786e;
        if (r100 == null) goto L7;
        PrefetchProcess r101 = r100.f248838a;
        if (r101 == null) goto L7;
        r101.f248735a.remove(r100);
    L7:
        this.f63784c.clear();
    }

    public final void j(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        if (hj0.f120381a.getValue().booleanValue() == false) goto L9;
        JSONObject r101 = this.f63782a;
        if (r101 == null) goto L9;
        if (r101.optInt("async_callback", 0) != 1) goto L9;
        this.f63784c.add(Observable.just(r100).subscribeOn(Schedulers.io()).subscribe(new C1045a(this, r100), new b(this)));
        return;
    L9:
        finishWithResult(r100);
    }

    public a(LivePrefetchProcessor r100, com.bytedance.android.live.browser.w r101) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        Intrinsics.checkNotNullParameter(r101, "lynxService");
        this.f63787f = r100;
        this.f63788g = r101;
        this.f63784c = new CompositeDisposable();
        this.f63785d = new c(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f63782a = r102;
        View r103 = r101.f249269d;
        this.f63783b = r103;
        if ((r103 instanceof WebView) == false) goto L6;
        x46.a r104 = this.f63787f.c(((WebView) r103).getUrl());
    L8:
        if (r104 == null) goto L18;
        w r105 = new w(r104, this.f63785d);
        this.f63786e = r105;
        if (r102.optInt("force_fetch", 0) != 1) goto L12;
    L15:
        r105.c(r102);
        return;
    L12:
        if (l7.f120656a.getValue().booleanValue() == false) goto L15;
        r105.b(r102);
        return;
    L18:
        throw new IllegalStateException("Failed to create method stub.".toString());
    L6:
        if ((r103 instanceof LynxView) == false) goto L19;
        r104 = this.f63787f.c(((LynxView) r103).getTemplateUrl());
        goto L8
    L19:
        StringBuilder r106 = new StringBuilder("Unknown hybrid view class: ");
        if (r103 == null) goto L22;
        Class<?> r107 = r103.getClass();
    L23:
        r106.append(r107);
        r106.append(". Failed to obtain url.");
        throw new IllegalStateException(r106.toString().toString());
    L22:
        r107 = null;
        goto L23
    }
}
