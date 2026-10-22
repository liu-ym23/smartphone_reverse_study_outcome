package com.bytedance.android.ec.hybrid.data.utils;

import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.shopping.mall.homepage.chunked.HomepageChunkedCallback;
import java.lang.reflect.Type;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Pair<String, T>> f46827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<InterfaceC0820a<T>> f46828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f46829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Boolean f46830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f46831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile ECHybridNetworkVO f46832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Throwable f46833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Type f46834h;

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.data.utils.a$a, reason: collision with other inner class name */
    public interface InterfaceC0820a<T> {
        void a(String r100, Object r101);

        void b(String r100, ECHybridNetworkVO r101, Throwable r102);

        void c(String r100, ECHybridNetworkVO r101, String r102, T r103);
    }

    public a(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "typeOfT");
        this.f46834h = r100;
        this.f46827a = new CopyOnWriteArrayList();
        this.f46828b = new CopyOnWriteArrayList();
    }

    public final void a(HomepageChunkedCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        CopyOnWriteArrayList<Pair<String, T>> r101 = this.f46827a;
        monitor-enter(r101);
        this.f46828b.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
