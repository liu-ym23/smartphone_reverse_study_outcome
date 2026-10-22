package com.bytedance.android.ec.hybrid.card.api;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f46381e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f46382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f46383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f46384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, ? extends Object> f46385d;

    public static final class a {
        public static d a(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "dataMap");
            d r101 = new d();
            r101.f46384c = r100;
            return r101;
        }

        public static d b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "dataString");
            d r101 = new d();
            r101.f46382a = r100;
            return r101;
        }

        public static d c(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "dataString");
            d r102 = new d();
            r102.f46382a = r100;
            r102.f46385d = r101;
            return r102;
        }
    }

    static {
    }

    public d() {
    }
}
