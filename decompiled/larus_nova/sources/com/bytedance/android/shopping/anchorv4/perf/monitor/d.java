package com.bytedance.android.shopping.anchorv4.perf.monitor;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements com.bytedance.android.ec.monitor.duration.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f167231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f167232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ V4NativeParams f167233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CommonMeta f167234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f167235e;

    public final void g() {
        if (this.f167231a == true) goto L6;
        this.f167231a = true;
        int r100 = com.bytedance.android.shopping.base.event.c.f170705a;
        com.bytedance.android.shopping.base.event.c.d(this.f167235e, false);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        com.bytedance.android.ec.monitor.duration.h.a.d(r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c.a(this.f167232b, r100, this.f167233c);
        c.b(this.f167232b, this.f167234d, r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void d(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        g();
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void f(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        g();
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "timestampCache");
        g();
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void e(Exception r100, Map r101) {
        Intrinsics.checkNotNullParameter("ReportDuration has error", "msg");
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "timestampCache");
        g();
    }

    public d(c r100, V4NativeParams r101, CommonMeta r102, String r103) {
        this.f167232b = r100;
        this.f167233c = r101;
        this.f167234d = r102;
        this.f167235e = r103;
    }
}
