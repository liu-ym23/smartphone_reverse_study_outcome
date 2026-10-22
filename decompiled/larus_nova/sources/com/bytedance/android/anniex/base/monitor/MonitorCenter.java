package com.bytedance.android.anniex.base.monitor;

import bolts.Task;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class MonitorCenter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MonitorCenter f40289c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f40290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f40291b;

    public static final class a {
    }

    public static final class b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "MonitorBindData(container=null, listener=null, dataMap=null, extraMap=null)";
        }
    }

    public static final class c<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonitorCenter f40292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f40293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f40294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f40295d;

        public c(MonitorCenter r100, String r101, Map<String, String> r102, Map<String, String> r103) {
            this.f40292a = r100;
            this.f40293b = r101;
            this.f40294c = r102;
            this.f40295d = r103;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            if (this.f40292a.f40291b.get(this.f40293b) == null) goto L5;
            this.f40292a.getClass();
            throw null;
        L5:
            return Unit.INSTANCE;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    static {
        f40289c = new MonitorCenter();
    }

    public MonitorCenter() {
        this.f40290a = LazyKt.lazy(MonitorCenter$gson$2.INSTANCE);
        this.f40291b = new ConcurrentHashMap();
    }

    public final void a(String r100, Map<String, String> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r100 != null) goto L5;
        return;
    L5:
        Task.callInBackground(new c(this, r100, r101, r102));
    }
}
