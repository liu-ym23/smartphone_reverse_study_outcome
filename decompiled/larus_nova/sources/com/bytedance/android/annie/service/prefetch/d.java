package com.bytedance.android.annie.service.prefetch;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.param.ReadonlyJSONObjectMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnniePrefetchProcessor f39947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f39948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f39949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f39950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r9.d f39951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ies.tools.prefetch.w f39952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FetchTimingSession f39953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f39954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f39955i;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f39956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f39957b;

        public a(d r100, JSONObject r101) {
            this.f39956a = r100;
            this.f39957b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            this.f39956a.k();
            d r102 = this.f39956a;
            JSONObject r103 = this.f39957b;
            FetchTimingSession r104 = r102.f39953g;
            if (r104 == null) goto L5;
            r104.recordJsbEndTiming(r103);
        L5:
            int r105 = com.bytedance.android.annie.bridge.g.f38457a;
            com.bytedance.android.annie.bridge.g.b(r102.f39948b, r103);
            r102.finishWithResult(r103);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f39958a;

        public b(d r100) {
            this.f39958a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f39958a.k();
            d r101 = this.f39958a;
            r101.finishWithFailure((Throwable) r100);
        }
    }

    public static final class c extends com.bytedance.ies.tools.prefetch.m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f39959a;

        public c(d r100) {
            this.f39959a = r100;
        }

        @Override // com.bytedance.ies.tools.prefetch.m.a
        public final void b(com.bytedance.ies.tools.prefetch.i.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            FetchTimingSession r101 = this.f39959a.f39953g;
            if (r101 == null) goto L5;
            r101.recordNetEndTiming();
        L5:
            boolean r102 = true;
            if ((r100 instanceof PrefetchNetworkExecutorImpl.MultiFormatResponse.a) == false) goto L29;
            JSONObject r103 = (JSONObject) ((PrefetchNetworkExecutorImpl.MultiFormatResponse.a) r100).f39938h.getValue();
            JSONObject r104 = this.f39959a.f39948b;
            if (r104 != null) goto L11;
            r102 = false;
        L11:
            if (r102 == false) goto L28;
            JSONObject r105 = r104.optJSONObject("_filter_keys");
            String r106 = r104.optString("process_name", null);
            if (r105 != null) goto L25;
            d r107 = this.f39959a;
            View r108 = r107.f39949c;
            if (r106 == null) goto L24;
            if (r108 == null) goto L24;
            r9.d r109 = r107.f39951e;
            if (r109 == null) goto L24;
            Lazy r110 = UtilsKt.f39692a;
            Intrinsics.checkNotNullParameter(r103, "<this>");
            Object r111 = r109.L(new ReadonlyJSONObjectMap(r103), r106);
            if (r111 == null) goto L24;
            r9.d r112 = r107.f39951e;
            if (r112 == null) goto L24;
            r112.updateData(r108, r111, false);
        L24:
            this.f39959a.j(r103);
            return;
        L25:
            d r113 = this.f39959a;
            CompositeDisposable r114 = r113.f39950d;
            Observable r115 = Observable.fromCallable(new e(r103, r105, r106, r113)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            d r116 = this.f39959a;
            r114.add(r115.subscribe(new f(r116), new g(r116)));
            return;
        L28:
            throw new IllegalStateException("params shouldn't be null".toString());
        L29:
            PrefetchNetworkExecutorImpl.MultiFormatResponse.b r117 = (PrefetchNetworkExecutorImpl.MultiFormatResponse.b) r100;
            JSONObject r118 = this.f39959a.f39948b;
            if (r118 != null) goto L33;
            r102 = false;
        L33:
            if (r102 == false) goto L47;
            String r119 = r118.optString("process_name", null);
            d r120 = this.f39959a;
            View r121 = r120.f39949c;
            if (r119 == null) goto L44;
            if (r121 == null) goto L44;
            r9.d r122 = r120.f39951e;
            if (r122 == null) goto L44;
            JSONObject r123 = (JSONObject) r117.f39938h.getValue();
            Lazy r124 = UtilsKt.f39692a;
            Intrinsics.checkNotNullParameter(r123, "<this>");
            Object r125 = r122.L(new ReadonlyJSONObjectMap(r123), r119);
            if (r125 == null) goto L44;
            r9.d r126 = r120.f39951e;
            if (r126 == null) goto L44;
            r126.updateData(r121, r125, false);
        L44:
            this.f39959a.j((JSONObject) r117.f39938h.getValue());
            return;
        L47:
            throw new IllegalStateException("params shouldn't be null".toString());
        }

        @Override // com.bytedance.ies.tools.prefetch.m.a, com.bytedance.ies.tools.prefetch.m
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f39959a.k();
            this.f39959a.finishWithFailure(r100);
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        FetchTimingSession r100 = this.f39953g;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        com.bytedance.ies.tools.prefetch.w r101 = this.f39952f;
        if (r101 == null) goto L10;
        PrefetchProcess r102 = r101.f248838a;
        if (r102 == null) goto L10;
        r102.f248735a.remove(r101);
    L10:
        this.f39950d.clear();
    }

    public final Unit k() {
        CallContext r100 = getCallContext();
        if (r100 == null) goto L8;
        String r101 = r100.f249267b;
        if (r101 == null) goto L9;
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).Q0(r101);
        return Unit.INSTANCE;
    L9:
        return null;
    L8:
        return null;
    }

    public d(AnniePrefetchProcessor r100) {
        Intrinsics.checkNotNullParameter(r100, "processor");
        this.f39947a = r100;
        this.f39950d = new CompositeDisposable();
        this.f39955i = new c(this);
    }

    public final void j(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        if (AnnieConfigSettingKeys.LIVE_PREFETCH_SUPPORT_ASYNC_CALLBACK.a().booleanValue() == false) goto L11;
        JSONObject r101 = this.f39948b;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L9:
        if (r102 == false) goto L11;
        this.f39950d.add(Observable.just(r100).subscribeOn(Schedulers.io()).subscribe(new a(this, r100), new b(this)));
        return;
    L7:
        if (r101.optInt("async_callback", 0) != 1) goto L9;
        r102 = true;
    L11:
        k();
        FetchTimingSession r103 = this.f39953g;
        if (r103 == null) goto L14;
        r103.recordJsbEndTiming(r100);
    L14:
        int r104 = com.bytedance.android.annie.bridge.g.f38457a;
        com.bytedance.android.annie.bridge.g.b(this.f39948b, r100);
        finishWithResult(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f39948b = r112;
        if (this.f39954h != null) goto L5;
        this.f39954h = r111.a();
    L5:
        Object r100 = null;
        if (this.f39951e != null) goto L8;
        this.f39951e = (r9.d) Annie.getService$default(r9.d.class, null, 2, null);
    L8:
        FetchTimingSession.Companion.getClass();
        Intrinsics.checkNotNullParameter(r112, "params");
        boolean r101 = r112.optBoolean("enable_timing", false);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        if (r101 == false) goto L15;
        FetchTimingSession r103 = new FetchTimingSession();     // Catch: Throwable -> L13
        r103.recordJsbStartTiming();     // Catch: Throwable -> L13
    L16:
        this.f39953g = r103;
        View r104 = r111.f249269d;
        this.f39949c = r104;
        if ((r104 instanceof WebView) == false) goto L19;
        x46.a r105 = this.f39947a.d(((WebView) r104).getUrl());
    L25:
        if (r105 == null) goto L53;
        this.f39952f = new com.bytedance.ies.tools.prefetch.w(r105, this.f39955i);
        FetchTimingSession r106 = this.f39953g;
        if (r106 == null) goto L29;
        r106.recordNetStartTiming();
    L29:
        Set<String> r107 = SecurityContextUtils.f269807a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        String r113 = SecurityContextUtils.b(r111);
        JSONObject r108 = r112.optJSONObject("headers");
        if (r108 != null) goto L32;
        JSONObject r109 = new JSONObject();
        r109.put("x-security-argus", r113);
        Unit r114 = Unit.INSTANCE;
        r112.put("headers", r109);
    L42:
        r112.put("headers", r108);
        com.bytedance.ies.tools.prefetch.w r115 = this.f39952f;
        if (r115 != null) goto L45;
        return;
    L45:
        if (r112.optInt("force_fetch", 0) != 1) goto L47;
    L50:
        r115.c(r112);
        return;
    L47:
        if (AnnieConfigSettingKeys.HYBRID_PREFETCH_ENABLED.a().booleanValue() == false) goto L50;
        r115.b(r112);
        return;
    L32:
        Iterator r116 = SequencesKt.asSequence(r108.keys()).iterator();
    L34:
        if (r116.hasNext() == false) goto L38;
        Object r117 = r116.next();
        if (StringsKt.equals((String) r117, "x-security-argus", true) == false) goto L34;
        r100 = r117;
    L38:
        String r118 = (String) r100;
        if (r118 == null) goto L41;
        r108.remove(r118);
    L41:
        r108.put("x-security-argus", r113);
        goto L42
    L53:
        throw new IllegalStateException("Failed to create method stub.".toString());
    L19:
        String r119 = ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).R0(r104);
        if (r119 == null) goto L23;
        r105 = this.f39947a.d(r119);
        goto L25
    L23:
        if (((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).c(r104) == false) goto L54;
        r105 = this.f39947a.d(((r9.c) Annie.getService$default(r9.c.class, null, 2, null)).Q(r104));
        goto L25
    L54:
        StringBuilder r120 = new StringBuilder("Unknown hybrid view class: ");
        if (r104 == null) goto L57;
        r100 = r104.getClass();
    L57:
        r120.append(r100);
        r120.append(". Failed to obtain url.");
        throw new IllegalStateException(r120.toString().toString());
    L15:
        r103 = null;
    L13:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
