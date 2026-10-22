package com.bytedance.ai.applet.app.foundation.performance;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f34283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f34284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppletPerformanceErrorCode f34285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f34286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f34287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f34288i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f34289j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f34290k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Long f34291l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f34292m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34293n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f34294o;

    public abstract void a(Map<String, Object> r100);

    public abstract String b();

    public final Map<String, Object> c() {
        Map<String, Object> r100 = MapsKt.createMapBuilder();
        r100.put("app_id", this.f34280a);
        r100.put("app_name", this.f34281b);
        r100.put(BindCardPayConfirmConstants.Key.TRACE_ID, Long.valueOf(this.f34282c));
        r100.put(ILoadStallMonitor.START_TIME, Long.valueOf(this.f34283d));
        r100.put("total_duration", Long.valueOf(this.f34284e));
        r100.put("error_code", Integer.valueOf(this.f34285f.getCode()));
        String r101 = this.f34286g;
        if (r101 == null) goto L5;
        r100.put("error_message", r101);
    L5:
        Long r102 = this.f34287h;
        if (r102 == null) goto L8;
        r100.put("manifest_resource_load_duration", Long.valueOf(r102.longValue()));
    L8:
        Long r103 = this.f34288i;
        if (r103 == null) goto L11;
        r100.put("package_resource_load_duration", Long.valueOf(r103.longValue()));
    L11:
        Long r104 = this.f34289j;
        if (r104 == null) goto L14;
        r100.put("render_view_create_duration", Long.valueOf(r104.longValue()));
    L14:
        Long r105 = this.f34290k;
        if (r105 == null) goto L17;
        r100.put("render_resource_load_duration", Long.valueOf(r105.longValue()));
    L17:
        Long r106 = this.f34291l;
        if (r106 == null) goto L20;
        r100.put("render_view_load_data_duration", Long.valueOf(r106.longValue()));
    L20:
        Long r107 = this.f34292m;
        if (r107 == null) goto L23;
        r100.put("render_view_draw_duration", Long.valueOf(r107.longValue()));
    L23:
        r100.put("is_reused", Integer.valueOf(this.f34293n ? 1 : 0));
        Long r108 = this.f34294o;
        if (r108 == null) goto L26;
        r100.put("script_evaluation_duration", Long.valueOf(r108.longValue()));
    L26:
        a(r100);
        return MapsKt.build(r100);
    }

    public e(String r100, String r101, long r102, long r103, long r110, AppletPerformanceErrorCode r111, String r112, Long r113, Long r114, Long r115, Long r116, Long r117, Long r118, boolean r210, Long r211) {
        this.f34280a = r100;
        this.f34281b = r101;
        this.f34282c = r102;
        this.f34283d = r103;
        this.f34284e = r110;
        this.f34285f = r111;
        this.f34286g = r112;
        this.f34287h = r113;
        this.f34288i = r114;
        this.f34289j = r115;
        this.f34290k = r116;
        this.f34291l = r117;
        this.f34292m = r118;
        this.f34293n = r210;
        this.f34294o = r211;
    }
}
