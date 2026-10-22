package com.bytedance.android.livesdk.interactivity.service.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class MonitorEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f140914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, h> f140915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c> f140916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, com.bytedance.android.livesdk.interactivity.service.monitor.a> f140917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f140918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<g> f140919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EventName f140920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UploadMode f140921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f140922i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f140923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f140924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f140925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f140926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f140927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<g> f140928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final EventName f140929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final UploadMode f140930h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f140931i;

        public final MonitorEvent f() {
            MonitorEvent r100 = new MonitorEvent(this.f140929g, this.f140930h, this.f140931i);
            List<String> r101 = r100.f140914a;
            ArrayList r102 = (ArrayList) r101;
            r102.addAll(this.f140923a);
            List<g> r103 = r100.f140919f;
            ArrayList r104 = (ArrayList) r103;
            r104.addAll(this.f140928f);
            Iterator r105 = ((LinkedHashMap) this.f140925c).entrySet().iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            Map.Entry r106 = (Map.Entry) r105.next();
            String r107 = (String) r106.getValue();
            if (r107 == null) goto L4;
            Map<String, c> r108 = r100.f140916c;
            Object r109 = r106.getKey();
            String r110 = (String) r109;
            r108.put(r110, new c((String) r106.getKey(), r107));
            goto L4
        L8:
            return r100;
        }

        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "alarm");
            ((ArrayList) this.f140928f).add(r100);
        }

        public /* synthetic */ b(EventName r100, UploadMode r101) {
            this(r100, r101, 0);
        }

        public final void b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "nodeName");
            if (((ArrayList) this.f140927e).contains(r100) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.f140927e).add(r100);
            if (r101 == false) goto L9;
            ((ArrayList) this.f140923a).add(r100);
            return;
        }

        public final void d(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "indiName");
            if (((ArrayList) this.f140926d).contains(r100) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.f140926d).add(r100);
            if (r101 == false) goto L9;
            ((ArrayList) this.f140923a).add(r100);
            return;
        }

        public final void e(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "itemName");
            if (((ArrayList) this.f140924b).contains(r100) == false) goto L5;
            return;
        L5:
            ((ArrayList) this.f140924b).add(r100);
            if (r101 == false) goto L9;
            ((ArrayList) this.f140923a).add(r100);
            return;
        }

        public b(EventName r100, UploadMode r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "uploadMode");
            this.f140929g = r100;
            this.f140930h = r101;
            this.f140931i = r102;
            this.f140923a = new ArrayList();
            this.f140924b = new ArrayList();
            this.f140925c = new LinkedHashMap();
            this.f140926d = new ArrayList();
            this.f140927e = new ArrayList();
            this.f140928f = new ArrayList();
        }

        public final void c(String r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "descName");
            if (this.f140925c.containsKey(r100) == false) goto L5;
            return;
        L5:
            this.f140925c.put(r100, r102);
            if (r101 == false) goto L9;
            ((ArrayList) this.f140923a).add(r100);
            return;
        }
    }

    static {
    }

    public final Map<String, com.bytedance.android.livesdk.interactivity.service.monitor.b> b() {
        return (Map) this.f140918e.getValue();
    }

    public final void d() {
        ((LinkedHashMap) this.f140915b).clear();
        ((LinkedHashMap) this.f140916c).clear();
        ((LinkedHashMap) this.f140917d).clear();
        b().clear();
    }

    public final Map<String, String> a(boolean r110) {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator r101 = ((LinkedHashMap) this.f140915b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (((ArrayList) this.f140914a).contains(r102.getKey()) == false) goto L4;
        r100.put(((h) r102.getValue()).f140940a, String.valueOf(((h) r102.getValue()).f140941b));
        goto L4
    L8:
        Iterator r103 = ((LinkedHashMap) this.f140916c).entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (((ArrayList) this.f140914a).contains(r104.getKey()) == false) goto L10;
        r100.put(((c) r104.getValue()).f140938a, ((c) r104.getValue()).f140939b);
        goto L10
    L14:
        Iterator r105 = ((LinkedHashMap) this.f140917d).entrySet().iterator();
    L16:
        if (r105.hasNext() == false) goto L29;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (((ArrayList) this.f140914a).contains(r106.getKey()) == false) goto L16;
        Object r107 = r106.getValue();
        if (((com.bytedance.android.livesdk.interactivity.service.monitor.a) r107).f140935c <= 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L26;
        r107 = null;
    L26:
        com.bytedance.android.livesdk.interactivity.service.monitor.a r109 = (com.bytedance.android.livesdk.interactivity.service.monitor.a) r107;
        if (r109 == null) goto L16;
        r100.put(((com.bytedance.android.livesdk.interactivity.service.monitor.a) r106.getValue()).f140933a, String.valueOf(r109.f140934b / r109.f140935c));
        goto L16
    L22:
        r108 = false;
        goto L23
    L29:
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.monitor.b>> r111 = b().entrySet().iterator();
    L31:
        if (r111.hasNext() == false) goto L35;
        Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.monitor.b> r112 = r111.next();
        if (((ArrayList) this.f140914a).contains(r112.getKey()) == false) goto L31;
        r100.put(r112.getValue().f140936a, r112.getValue().f140937b);
        goto L31
    L35:
        if (r110 == false) goto L40;
        Iterator r113 = ((ArrayList) this.f140919f).iterator();
    L38:
        if (r113.hasNext() == false) goto L40;
        ((g) r113.next()).a(this);
    L40:
        return r100;
    }

    public final Long c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        h r101 = (h) ((LinkedHashMap) this.f140915b).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return Long.valueOf(r101.f140941b);
    }

    public MonitorEvent(EventName r100, UploadMode r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "uploadMode");
        this.f140920g = r100;
        this.f140921h = r101;
        this.f140922i = r102;
        this.f140914a = new ArrayList();
        this.f140915b = new LinkedHashMap();
        this.f140916c = new LinkedHashMap();
        this.f140917d = new LinkedHashMap();
        this.f140918e = LazyKt.lazy(MonitorEvent$constantNodeStore$2.INSTANCE);
        this.f140919f = new ArrayList();
    }
}
