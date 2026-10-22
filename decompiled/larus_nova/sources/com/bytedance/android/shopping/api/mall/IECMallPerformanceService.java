package com.bytedance.android.shopping.api.mall;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallPerformanceService;", "", "SceneContext", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallPerformanceService {

    public static final class SceneContext {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f170202f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f170203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<String, Object> f170204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f170205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Object> f170206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<Map<String, Object>> f170207e;

        public static final class a {
        }

        static {
        }

        public SceneContext() {
            throw null;
        }

        public final void a(final Function1<? super SceneContext, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            if (this.f170203a == false) goto L5;
            return;
        L5:
            this.f170203a = true;
            kk.d.c(new IECMallPerformanceService$SceneContext$initialize$1(this, r100));
        }

        public final Map<String, Object> b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "timing");
            LinkedHashMap r101 = new LinkedHashMap();
            r101.put("scene", this.f170205c);
            r101.put("timing", r100);
            r101.putAll(this.f170206d);
            r101.putAll(this.f170204b);
            Function0<Map<String, Object>> r102 = this.f170207e;
            if (r102 == null) goto L12;
            Map<String, Object> r103 = r102.invoke();
            if (r103 == null) goto L12;
            if ((!r103.isEmpty()) == true) goto L10;
            r103 = null;
        L10:
            if (r103 == null) goto L12;
            r101.putAll(r103);
        L12:
            return r101;
        }

        public SceneContext(String r100, Map r101, Function0 r102) {
            this.f170205c = r100;
            this.f170206d = r101;
            this.f170207e = r102;
            this.f170204b = new ConcurrentHashMap();
        }
    }

    void a(SceneContext r100, String r101, Boolean r102);
}
