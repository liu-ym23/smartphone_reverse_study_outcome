package com.bytedance.android.shopping.base.event;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.injector.Injector$provideIECHostLogService$1;
import com.bytedance.android.shopping.utils.u;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class EventActionImpl implements com.bytedance.android.shopping.base.event.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.a f170695b;

    public static final class a<T> implements Consumer {
        public a(String r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImpl f170696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f170697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f170698c;

        public b(EventActionImpl r100, String r101, Map r102) {
            this.f170696a = r100;
            this.f170697b = r101;
            this.f170698c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f170696a.f170695b.logV3(this.f170697b, new JSONObject(this.f170698c));
            EventActionImpl.a(this.f170696a, this.f170697b, this.f170698c);
        }
    }

    public static final class c implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f170699a = null;

        static {
            f170699a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public static final class d<T> implements Consumer {
        public d(String r100) {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventActionImpl f170700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f170701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f170702c;

        public e(EventActionImpl r100, String r101, Map r102) {
            this.f170700a = r100;
            this.f170701b = r101;
            this.f170702c = r102;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f170700a.f170695b.logV3(this.f170701b, new JSONObject(this.f170702c));
            EventActionImpl.a(this.f170700a, this.f170701b, this.f170702c);
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f170703a = null;

        static {
            f170703a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    public final Map<String, Object> c() {
        return (Map) this.f170694a.getValue();
    }

    public EventActionImpl() {
        int r100 = com.bytedance.android.shopping.injector.a.f176389a;
        xi.a r101 = new Injector$provideIECHostLogService$1();
        Intrinsics.checkNotNullParameter(r101, "hostLogService");
        this.f170695b = r101;
        this.f170694a = LazyKt.lazy(EventActionImpl$contextParams$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void clearEventParams() {
        c().clear();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final Map<String, Object> getEventParams() {
        return c();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        Map<String, Object> r101 = c();
        Set<Map.Entry<String, ? extends Object>> r102 = r100.entrySet();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (((Map.Entry) r105).getValue() == null) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r106 = false;
        goto L9
    L11:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r108 = r103.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r110 = r109.getKey();
        int r111 = ga3.a.f480548a;
        r107.add(TuplesKt.to(r110, ga3.a.a(r109.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r101, r107);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        Map<String, Object> r101 = c();
        Set<Map.Entry<String, ? extends Object>> r102 = r100.entrySet();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (((Map.Entry) r105).getValue() == null) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        r106 = false;
        goto L9
    L11:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r108 = r103.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r110 = r109.getKey();
        int r111 = ga3.a.f480548a;
        r107.add(TuplesKt.to(r110, ga3.a.a(r109.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r101, r107);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(c(), SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r100), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MapsKt.putAll(c(), SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r100), AnonymousClass3.INSTANCE), AnonymousClass4.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(PageFinder r100, Map r101) {
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Object r103 = r102.get("btm");
        Object r104 = null;
        Object[] r105 = 0;
        Object[] r106 = 0;
        if ((r103 instanceof String) == true) goto L5;
        r103 = null;
    L5:
        String r107 = (String) r103;
        if (r107 != null) goto L8;
    L11:
        boolean r108 = true;
    L12:
        if (r108 == true) goto L24;
        if (r100 == null) goto L25;
        BtmItemBuilder r109 = new BtmItemBuilder(r107, r106 == true ? 1 : 0, 2, r105 == true ? 1 : 0).withPageFinder(r100);
        Object r110 = r102.get("bcm_description");
        if ((r110 instanceof Map) == false) goto L19;
        r104 = r110;
    L19:
        Map r111 = (Map) r104;
        if (r111 == null) goto L22;
        BcmParams.Companion.getClass();
        r109.internalSetUnitParams("description", BcmParams.a.c(r111));
    L22:
        r101.put("btm_id", r109.obtainEventBtmParams());
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (StringsKt.isBlank(r107) == true) goto L11;
        r108 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParamToEntranceInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        Object r102 = c().get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        c().put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, u.a((String) r102, r100, r101));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, Pair<String, ? extends Object>... r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        doEventAction(r100, null, MapsKt.toMap(r101));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "params");
        doEventAction(r100, null, r101);
    }

    public static final void a(EventActionImpl r100, String r101, Map r102) {
        r100.getClass();
        if (ECAppInfoService.f48114e.isDebug() == false) goto L11;
        new StringBuilder("<<<=========" + r101 + " start =========>>>\n");
        Iterator r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        Objects.toString(r104.getValue());
        goto L6
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, PageFinder r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r102, "params");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(c());
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r105 = r102.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r106 = r105.next();
        if (r106.getValue() == null) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L4;
        r104.put(r106.getKey(), r106.getValue());
        goto L4
    L8:
        r107 = false;
        goto L9
    L11:
        ArrayList r108 = new ArrayList(r104.size());
        Iterator r109 = r104.entrySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L15;
        Map.Entry r110 = (Map.Entry) r109.next();
        Object r111 = r110.getKey();
        int r112 = ga3.a.f480548a;
        r108.add(TuplesKt.to(r111, ga3.a.a(r110.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r103, r108);
        b(r101, r103);
        fa3.c.b(bg4.b.a(Completable.fromAction(new e(this, r100, r103))).subscribe(f.f170703a, new a(r100)));
        ECEventDumper.f44016h.getClass();
        ECEventDumper.a.b(r100, r103);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r100, PageFinder r101, Pair<String, ? extends Object>... r110) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r110, "params");
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(c());
        ArrayList r103 = new ArrayList();
        int r104 = r110.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L11;
        Pair<String, ? extends Object> r106 = r110[r105];
        if (r106.getSecond() == null) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
        r103.add(r106);
    L10:
        r105 = r105 + 1;
        goto L3
    L7:
        r107 = false;
        goto L8
    L11:
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r108 = r103.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        Pair r109 = (Pair) r108.next();
        Object r112 = r109.getFirst();
        int r113 = ga3.a.f480548a;
        r111.add(TuplesKt.to(r112, ga3.a.a(r109.getSecond())));
        goto L13
    L15:
        MapsKt.putAll(r102, r111);
        b(r101, r102);
        fa3.c.b(bg4.b.a(Completable.fromAction(new b(this, r100, r102))).subscribe(c.f170699a, new d(r100)));
        ECEventDumper.f44016h.getClass();
        ECEventDumper.a.b(r100, r102);
    }
}
