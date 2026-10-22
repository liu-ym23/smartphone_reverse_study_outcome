package com.bytedance.android.ec.store.product;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public class EventActionImplOpt implements com.bytedance.android.ec.core.event.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f48264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.a f48265b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImplOpt f48266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair[] f48267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f48268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f48269d;

        public a(EventActionImplOpt r100, Pair[] r101, Map r102, String r103) {
            this.f48266a = r100;
            this.f48267b = r101;
            this.f48268c = r102;
            this.f48269d = r103;
        }

        public final void a() {
            Map r100 = MapsKt.plus(this.f48266a.b(), this.f48267b);
            Map r101 = this.f48268c;
            if (r101 == null) goto L11;
            r100 = MapsKt.plus(r100, r101);
        L11:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
            this.f48266a.f48265b.logV3(this.f48269d, new JSONObject(r100));     // Catch: Throwable -> L7
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            ECEventDumper.a r103 = ECEventDumper.f44016h;
            String r104 = this.f48269d;
            r103.getClass();
            ECEventDumper.a.b(r104, r100);
            return;
        L7:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImplOpt f48270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair[] f48271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f48272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f48273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f48274e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PageFinder f48275f;

        public b(EventActionImplOpt r100, Pair[] r101, Map r102, String r103, String r104, PageFinder r105) {
            this.f48270a = r100;
            this.f48271b = r101;
            this.f48272c = r102;
            this.f48273d = r103;
            this.f48274e = r104;
            this.f48275f = r105;
        }

        public final void a() {
            Map r100 = MapsKt.plus(this.f48270a.b(), this.f48271b);
            Map r101 = this.f48272c;
            if (r101 == null) goto L11;
            r100 = MapsKt.plus(r100, r101);
        L11:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
            g.f48122a.g(this.f48273d, new JSONObject(r100), this.f48274e, this.f48275f);     // Catch: Throwable -> L7
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            ECEventDumper.a r103 = ECEventDumper.f44016h;
            String r104 = this.f48273d;
            r103.getClass();
            ECEventDumper.a.b(r104, r100);
            return;
        L7:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImplOpt f48276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair[] f48277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f48278c;

        public c(EventActionImplOpt r100, Pair[] r101, String r102) {
            this.f48276a = r100;
            this.f48277b = r101;
            this.f48278c = r102;
        }

        public final void a() {
            Map r100 = MapsKt.plus(this.f48276a.b(), this.f48277b);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            this.f48276a.f48265b.logV3(this.f48278c, new JSONObject(r100));     // Catch: Throwable -> L5
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            EventActionImplOpt.a(this.f48276a, this.f48278c, r100);
            ECEventDumper.a r102 = ECEventDumper.f44016h;
            String r103 = this.f48278c;
            r102.getClass();
            ECEventDumper.a.b(r103, r100);
            return;
        L5:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImplOpt f48279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f48280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f48281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PageFinder f48282d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f48283e;

        public d(EventActionImplOpt r100, Map r101, String r102, PageFinder r103, String r104) {
            this.f48279a = r100;
            this.f48280b = r101;
            this.f48281c = r102;
            this.f48282d = r103;
            this.f48283e = r104;
        }

        public final void a() {
            Map r100 = MapsKt.plus(this.f48279a.b(), this.f48280b);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
            JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L13
            String r103 = this.f48281c;     // Catch: Throwable -> L13
            if (r103 == null) goto L11;
            PageFinder r104 = this.f48282d;     // Catch: Throwable -> L13
            if (r104 == null) goto L11;
            Iterator<Map.Entry<String, Object>> r105 = BtmSDK.INSTANCE.createReportParams(r103, r104).entrySet().iterator();     // Catch: Throwable -> L13
        L9:
            if (r105.hasNext() == false) goto L11;
            Map.Entry<String, Object> r106 = r105.next();     // Catch: Throwable -> L13
            r102.putOpt(r106.getKey(), r106.getValue());     // Catch: Throwable -> L13
        L11:
            this.f48279a.f48265b.logV3(this.f48283e, r102);     // Catch: Throwable -> L13
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        L15:
            EventActionImplOpt.a(this.f48279a, this.f48283e, r100);
            ECEventDumper.a r107 = ECEventDumper.f44016h;
            String r108 = this.f48283e;
            r107.getClass();
            ECEventDumper.a.b(r108, r100);
            return;
        L13:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImplOpt f48284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Pair[] f48285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f48286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f48287d;

        public e(EventActionImplOpt r100, Pair[] r101, Map r102, String r103) {
            this.f48284a = r100;
            this.f48285b = r101;
            this.f48286c = r102;
            this.f48287d = r103;
        }

        public final void a() {
            Map r100 = MapsKt.plus(this.f48284a.b(), this.f48285b);
            Map r101 = this.f48286c;
            if (r101 == null) goto L11;
            r100 = MapsKt.plus(r100, r101);
        L11:
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
            this.f48284a.f48265b.logV3(this.f48287d, new JSONObject(r100));     // Catch: Throwable -> L7
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            EventActionImplOpt.a(this.f48284a, this.f48287d, r100);
            ECEventDumper.a r103 = ECEventDumper.f44016h;
            String r104 = this.f48287d;
            r103.getClass();
            ECEventDumper.a.b(r104, r100);
            return;
        L7:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final Map<String, String> b() {
        return (Map) this.f48264a.getValue();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void bindMonitorId(Long r100) {
    }

    public EventActionImplOpt() {
        int r100 = dh.a.f468577a;
        g r101 = g.f48122a;
        Intrinsics.checkNotNullParameter(r101, "hostLogService");
        this.f48265b = r101;
        this.f48264a = LazyKt.lazy(EventActionImplOpt$contextParams$2.INSTANCE);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final String getBaseParamsJson() {
        JSONObject r100 = new JSONObject();
        Iterator<Map.Entry<String, String>> r101 = b().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, String> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue());
        goto L4
    L7:
        return r100.toString();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void clearEventParams() {
        b().clear();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final Map<String, String> getBaseParams() {
        return b();
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        Map<String, String> r101 = b();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getValue();
        boolean r106 = false;
        if (r105 != null) goto L8;
    L13:
        if (r106 == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        if (r105.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 != true) goto L13;
        r106 = true;
        goto L13
    L10:
        r107 = false;
        goto L11
    L15:
        r101.putAll(r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        Map<String, String> r101 = b();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getValue();
        boolean r106 = false;
        if (r105 != null) goto L8;
    L13:
        if (r106 == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        if (r105.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 != true) goto L13;
        r106 = true;
        goto L13
    L10:
        r107 = false;
        goto L11
    L15:
        r101.putAll(r102);
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void appendEventParams(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(b(), SequencesKt.filter(ArraysKt.asSequence(r100), AnonymousClass1.INSTANCE));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void initEventContext(Pair<String, String>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(b(), SequencesKt.filter(ArraysKt.asSequence(r100), C98551.INSTANCE));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        OneFrameAsyncTask.a(new c(this, r101, r100));
    }

    public static final void a(EventActionImplOpt r100, String r101, Map r102) {
        r100.getClass();
        if (ECAppInfoService.f48114e.isDebug() == false) goto L11;
        new StringBuilder("<<<=========" + r101 + " start =========>>>\n");
        Iterator r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
        goto L6
    L9:
        return;
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doAnyEventAction(String r100, Map<String, ? extends Object> r101, Pair<String, ? extends Object>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        OneFrameAsyncTask.a(new a(this, r102, r101, r100));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public void doEventAction(String r100, Map<String, String> r101, Pair<String, String>... r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        OneFrameAsyncTask.a(new e(this, r102, r101, r100));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r111, "paramMap");
        OneFrameAsyncTask.a(new d(this, r111, r101, r110, r100));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doEventAction(String r100, String r101, PageFinder r102, Pair<String, String>... r103) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r103, "params");
        doEventAction(r100, r101, r102, MapsKt.plus(new LinkedHashMap(), r103));
    }

    @Override // com.bytedance.android.ec.core.event.c
    public final void doAnyEventActionWithBtm(String r100, PageFinder r110, String r111, Map<String, ? extends Object> r112, Pair<String, ? extends Object>... r113) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r110, "pageFinder");
        Intrinsics.checkNotNullParameter(r111, "actionName");
        Intrinsics.checkNotNullParameter(r113, "params");
        OneFrameAsyncTask.a(new b(this, r113, r112, r111, r100, r110));
    }
}
