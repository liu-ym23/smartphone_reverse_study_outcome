package com.bytedance.android.ec.core.event;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventKey;
import com.bytedance.android.ec.core.event.eventdumper.model.DumpedEventParam;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001,B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J%\u0010\u0011\u001a\u00020\u00002\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0013j\b\u0012\u0004\u0012\u00020\u000f`\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015RB\u0010\u0019\u001a.\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u00170\u0016j\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0017`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "Lcom/bytedance/android/ec/core/event/a;", "Ltg/a;", "Ljava/io/Serializable;", "", "buildParams", "addReflectionParams$ec_core_saasRelease", "()V", "addReflectionParams", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "", "btmId", UGCMonitor.TYPE_POST, "", "Lcom/bytedance/android/ec/core/event/BaseEventContext;", "eventContexts", "with", "([Lcom/bytedance/android/ec/core/event/BaseEventContext;)Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "contextMap", "Ljava/util/HashMap;", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventKey;", "Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "getDumpedDumpedEventParams", "()Ljava/util/Map;", "dumpedDumpedEventParams", "", "getEventClassVersion", "()I", "eventClassVersion", "<init>", "(Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMetricsEvent2 extends com.bytedance.android.ec.core.event.a implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Class<?>, HashMap<String, Field>> f43969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Class<?>, ArrayList<String>> f43970b = null;
    private HashMap<String, Class<? extends BaseEventContext>> contextMap;
    private ArrayList<BaseEventContext> eventContexts;
    private final String eventName;

    public static final class a {
        public a() {
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseMetricsEvent2 f43971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PageFinder f43972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f43973c;

        public b(BaseMetricsEvent2 r100, PageFinder r101, String r102) {
            this.f43971a = r100;
            this.f43972b = r101;
            this.f43973c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            Map r100 = null;
            if (this.f43972b != null) goto L5;
        L13:
            g r101 = g.f48122a;     // Catch: Throwable -> L21
            String r102 = this.f43971a.getEventName();     // Catch: Throwable -> L21
            HashMap<String, String> r103 = this.f43971a.getParams();     // Catch: Throwable -> L21
            if ((r103 instanceof Map) == false) goto L17;
            r100 = r103;
        L17:
            if (r100 != null) goto L19;
            r100 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L19:
            r101.logV3(r102, new JSONObject(r100));     // Catch: Throwable -> L21
            return;
        L5:
            if (this.f43973c == null) goto L13;
            g r104 = g.f48122a;     // Catch: Throwable -> L21
            String r105 = this.f43971a.getEventName();     // Catch: Throwable -> L21
            HashMap<String, String> r106 = this.f43971a.getParams();     // Catch: Throwable -> L21
            if ((r106 instanceof Map) == false) goto L10;
            r100 = r106;
        L10:
            if (r100 != null) goto L12;
            r100 = MapsKt.emptyMap();     // Catch: Throwable -> L21
        L12:
            r104.g(r105, new JSONObject(r100), this.f43973c, this.f43972b);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            ECExceptionMonitor.e(th);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.ec.core.event.a
    public void buildParams() {
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public int getEventClassVersion() {
        return 2;
    }

    static {
        Companion = new a();
        f43969a = new HashMap();
        f43970b = new HashMap();
    }

    public final void addReflectionParams$ec_core_saasRelease() {
        this.contextMap.clear();
        HashMap<Class<?>, HashMap<String, Field>> r100 = f43969a;
        HashMap<String, Field> r101 = r100.get(getClass());
        if (r101 != null) goto L5;
        r101 = new HashMap();
        r100.put(getClass(), r101);
        ArrayList<String> r102 = new ArrayList();
        f43970b.put(getClass(), r102);
        a(r101, r102, getClass());
    L5:
        Iterator<Map.Entry<String, Field>> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L27;
        Map.Entry<String, Field> r104 = r103.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue().get(this);
        if (r106 == null) goto L11;
        String r107 = r106.toString();
    L12:
        if (r107 == null) goto L13;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(r105, r107, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        goto L7
    L13:
        Iterator<BaseEventContext> r108 = this.eventContexts.iterator();
        String r109 = null;
    L15:
        if (r108.hasNext() == false) goto L25;
        BaseEventContext r110 = r108.next();
        BaseEventContext.b r111 = r110.getParamsMap().get(r105);
        if (r111 == null) goto L21;
        Object r112 = r111.getValue();
        if (r112 == null) goto L21;
        String r113 = r112.toString();
    L22:
        if (r113 != null) goto L23;
        r109 = r113;
        goto L15
    L23:
        this.contextMap.put(r105, (Class<? extends BaseEventContext>) r110.getClass());
        r109 = r113;
    L21:
        r113 = null;
    L25:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        appendParam(r105, r109, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        goto L7
    L11:
        r107 = null;
        goto L12
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public Map<DumpedEventKey, DumpedEventParam> getDumpedDumpedEventParams() {
        HashMap r100 = new HashMap();
        Iterator<Map.Entry<String, String>> r101 = m8152getParams().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r102 = r101.next();
        String r103 = r102.getKey();
        String r104 = r102.getValue();
        ArrayList<String> r105 = f43970b.get(getClass());
        if (r105 == null) goto L8;
        boolean r106 = r105.contains(r103);
    L10:
        if (this.contextMap.get(r103) == null) goto L12;
        boolean r107 = true;
    L13:
        r100.put(new DumpedEventKey(r103, r106), new DumpedEventParam(r104, r107, null, 4, null));
        goto L4
    L12:
        r107 = false;
        goto L13
    L8:
        r106 = false;
        goto L10
    L14:
        return r100;
    }

    @Override // com.bytedance.android.ec.core.event.a, tg.a
    public String getEventName() {
        return this.eventName;
    }

    public BaseMetricsEvent2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.eventName = r100;
        this.eventContexts = new ArrayList();
        this.contextMap = new HashMap();
    }

    public final BaseMetricsEvent2 with(BaseEventContext... r100) {
        Intrinsics.checkNotNullParameter(r100, "eventContexts");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        BaseEventContext r103 = r100[r102];
        if (r103 == null) goto L7;
        this.eventContexts.add(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return this;
    }

    @Override // com.bytedance.android.ec.core.event.a, com.bytedance.android.ec.core.event.d
    public void post(PageFinder r100, String r101) {
        addReflectionParams$ec_core_saasRelease();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r102 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE, r102);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r102);
        buildParams();
        Iterator<T> r103 = this.eventContexts.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        appendParam(((BaseEventContext) r103.next()).getExtraParams());
        goto L4
    L6:
        getParams().putAll(getExtraParams());
        Single.fromCallable(new b(this, r100, r101)).subscribeOn(Schedulers.io()).subscribe();
        ECEventDumper.f44016h.getClass();
        ECEventDumper.a.c(this);
        this.eventContexts.clear();
    }

    public static void a(HashMap r100, ArrayList r101, Class r110) {
        if ((!Intrinsics.areEqual(r110, BaseMetricsEvent2.class)) == false) goto L23;
        Field[] r102 = r110.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        Field r105 = r102[r104];
        Iterator r106 = ArrayIteratorKt.iterator(r105.getDeclaredAnnotations());
    L8:
        if (r106.hasNext() == false) goto L12;
        Annotation r107 = (Annotation) r106.next();
        if ((r107 instanceof EventKey) == false) goto L8;
        r105.setAccessible(true);
        EventKey r108 = (EventKey) r107;
        r100.put(r108.value(), r105);
        r101.add(r108.value());
        goto L8
    L12:
        r104 = r104 + 1;
        goto L5
    L13:
        Class r111 = r110.getSuperclass();
        if (r111 == null) goto L24;
        a(r100, r101, r111);
        return;
    L24:
        return;
    }
}
