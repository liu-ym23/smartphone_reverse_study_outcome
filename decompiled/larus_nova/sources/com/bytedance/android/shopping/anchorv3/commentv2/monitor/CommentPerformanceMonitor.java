package com.bytedance.android.shopping.anchorv3.commentv2.monitor;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class CommentPerformanceMonitor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f164733h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f164734i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f164735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f164736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f164737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f164738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f164739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f164740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f164741g;

    public static final class a {
        public a() {
        }

        public static CommentPerformanceMonitor a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Lazy r101 = CommentPerformanceMonitor.f164733h;
            if (((Map) r101.getValue()).containsKey(r100) == false) goto L7;
            CommentPerformanceMonitor r102 = (CommentPerformanceMonitor) ((Map) r101.getValue()).get(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            CommentPerformanceMonitor r103 = new CommentPerformanceMonitor();
            ((Map) r101.getValue()).put(r100, r103);
            return r103;
        }
    }

    static {
        f164734i = new a();
        f164733h = LazyKt.lazy(CommentPerformanceMonitor$Companion$monitors$2.INSTANCE);
    }

    public CommentPerformanceMonitor() {
        this.f164735a = "";
        this.f164736b = "";
    }
}
