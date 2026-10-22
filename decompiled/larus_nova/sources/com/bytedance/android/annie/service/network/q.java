package com.bytedance.android.annie.service.network;

import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class q extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f39919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f39920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<InputStream> f39921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f39922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f39923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f39924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<WeakReference<Call<TypedInput>>> f39925g;

    public final void a() {
        InputStream r100 = this.f39921c.element;     // Catch: Throwable -> L7
        if (r100 == null) goto L20;
        r100.close();     // Catch: Throwable -> L7
    L20:
        WeakReference<Call<TypedInput>> r101 = this.f39925g.element;     // Catch: Throwable -> L17
        if (r101 == null) goto L24;
        Call<TypedInput> r102 = r101.get();     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isCanceled() == true) goto L26;
        r102.cancel();     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L24:
        return;
    L17:
        th = move-exception;
        b8.a r103 = b8.a.f17992a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, "close call failed"), true);
        return;
    L7:
        th = move-exception;
        b8.a r104 = b8.a.f17992a;
        b8.a.a(new b8.b("HostNetworkDependImpl", LogLevel.ERROR, th, "close inputStream failed"), true);
        goto L20
    }

    public final Integer b() {
        return Integer.valueOf(this.f39924f.element);
    }

    public final String c() {
        return this.f39922d.element;
    }

    public final Throwable d() {
        return this.f39923e.element;
    }

    public final InputStream e() {
        return this.f39921c.element;
    }

    public q(LinkedHashMap<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<InputStream> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105, Ref.ObjectRef<WeakReference<Call<TypedInput>>> r106) {
        this.f39919a = r100;
        this.f39920b = r101;
        this.f39921c = r102;
        this.f39922d = r103;
        this.f39923e = r104;
        this.f39924f = r105;
        this.f39925g = r106;
    }
}
