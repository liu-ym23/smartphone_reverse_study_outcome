package c8a;

import b8a.m;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.s1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Long> f22749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f22750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WeakReference<y7a.a> f22754h;

    public final y7a.a b() {
        WeakReference<y7a.a> r100 = this.f22754h;
        if (r100 != null) goto L5;
        y7a.a r101 = null;
    L7:
        if ((r101 instanceof s1) == true) goto L9;
    L11:
        return r101;
    L9:
        if ((!((s1) r101).f383734a.isEmpty()) == true) goto L11;
        return null;
    L5:
        r101 = r100.get();
        goto L7
    }

    public final void d() {
        if (this.f22752f == true) goto L13;
        final long r100 = this.f22747a;
        if (r100 < 0) goto L14;
        final long r101 = this.f22748b;
        if (r101 < r100) goto L15;
        final long r102 = this.f22750d;
        if (r102 < r101) goto L16;
        this.f22752f = true;
        LynxEventReporter.onEvent("lynxsdk_performance_entry_pipeline", this.f22753g, new a(r102, r100, r101));
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    public b() {
        this.f22747a = -1;
        this.f22748b = -1;
        this.f22749c = new ArrayList();
        this.f22750d = -1;
        this.f22751e = false;
        this.f22752f = false;
        this.f22753g = -1;
    }

    public final void a(y7a.a r100) {
        if (this.f22751e == false) goto L5;
        return;
    L5:
        long r101 = this.f22747a;
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (this.f22750d < r101) goto L16;
        this.f22751e = true;
        if (r100 != null) goto L13;
        return;
    L13:
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.put("entryType", "pipeline");
        r102.put("name", "loadBundle");
        r102.put("loadBundleStart", Double.valueOf(this.f22747a / 1000.0d));
        r102.put("paintEnd", Double.valueOf(this.f22750d / 1000.0d));
        r100.onPerformanceEvent(m.e(r102));
        return;
    }

    public final void c(String r100, long r101) {
        r100.getClass();
        byte r102 = -1;
        switch(r100.hashCode()) {
            case -1930716102: goto L18;
            case -337217869: goto L14;
            case 831051791: goto L10;
            case 925946781: goto L6;
            default: goto L21;
        };
    L21:
        switch(r102) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L23;
            default: goto L39;
        };
    L23:
        this.f22750d = r101;
        y7a.a r103 = b();
        a(r103);
        if (r103 != null) goto L26;
        this.f22749c.clear();
    L30:
        d();
        return;
    L26:
        ArrayList r104 = new ArrayList(this.f22749c);
        this.f22749c.clear();
        Iterator r105 = r104.iterator();
    L28:
        if (r105.hasNext() == false) goto L30;
        Long r106 = (Long) r105.next();
        JavaOnlyMap r107 = new JavaOnlyMap();
        r107.put("entryType", "pipeline");
        r107.put("name", "updateTriggeredByNative");
        r107.put("pipelineStart", Double.valueOf(r106.longValue() / 1000.0d));
        r107.put("paintEnd", Double.valueOf(this.f22750d / 1000.0d));
        r103.onPerformanceEvent(m.e(r107));
        goto L28
    L31:
        this.f22749c.add(Long.valueOf(r101));
        return;
    L32:
        this.f22748b = r101;
        a(b());
        d();
        return;
    L33:
        this.f22747a = r101;
        return;
    L39:
        return;
    L6:
        if (r100.equals("paintEnd") == false) goto L21;
        r102 = 3;
        goto L21
    L10:
        if (r100.equals("updateDataStart") == false) goto L21;
        r102 = 2;
        goto L21
    L14:
        if (r100.equals("loadBundleEnd") == false) goto L21;
        r102 = 1;
        goto L21
    L18:
        if (r100.equals("loadBundleStart") == false) goto L21;
        r102 = 0;
        goto L21
    }
}
