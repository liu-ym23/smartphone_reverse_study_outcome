package com.bytedance.android.livesdk.livecommerce.opt;

import com.bytedance.android.ec.monitor.duration.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<h> f149774a;

    public c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f149774a = new WeakReference(r100);
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        h r101 = this.f149774a.get();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        h r101 = this.f149774a.get();
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void d(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        h r101 = this.f149774a.get();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void f(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "timestampCache");
        h r101 = this.f149774a.get();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "timestampCache");
        h r102 = this.f149774a.get();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.bytedance.android.ec.monitor.duration.h
    public final void e(Exception r100, Map r101) {
        Intrinsics.checkNotNullParameter("ReportDuration has error", "msg");
        Intrinsics.checkNotNullParameter(r100, "e");
        Intrinsics.checkNotNullParameter(r101, "timestampCache");
        h r102 = this.f149774a.get();
        if (r102 == null) goto L6;
        r102.b("ReportDuration has error", r101);
        return;
    }
}
