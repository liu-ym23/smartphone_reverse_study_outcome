package com.bytedance.android.annie.ng;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.h f39643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.f f39644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.e f39645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o8.g f39646d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.ng.a$a, reason: collision with other inner class name */
    public static final class C0738a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o8.h f39648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o8.f f39649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o8.e f39650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final o8.g f39651e;

        public final void a() {
            ConcurrentHashMap<String, b> r100 = g.f39672d;
            if (r100.get(this.f39647a) == null) goto L6;
            Intrinsics.checkNotNull(r100.get(this.f39647a));
            return;
        L6:
            List<String> r101 = g.f39674f;
            if (r101.contains(this.f39647a) == true) goto L9;
            r101.add(this.f39647a);
        L9:
            String r102 = this.f39647a;
            a r103 = new a(this.f39648b, this.f39649c, this.f39650d, this.f39651e);
            Intrinsics.checkNotNullParameter(r102, "bizKey");
            g.f39671c.put(this.f39647a, r103);
            Map<String, Map<String, h>> r104 = i.f39676a;
            monitor-enter(r104);
            LinkedHashMap r105 = (LinkedHashMap) r104;     // Catch: Throwable -> L22
            Map r106 = (Map) r105.get(this.f39647a);     // Catch: Throwable -> L22
            if (r106 == null) goto L14;
            Iterator r107 = r106.entrySet().iterator();     // Catch: Throwable -> L22
        L15:
            if (r107 != null) goto L17;
        L19:
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r104);
            return;
        L17:
            if (r107.hasNext() == false) goto L19;
            ((h) ((Map.Entry) r107.next()).getValue()).onCallback();     // Catch: Throwable -> L22
            goto L17
        L14:
            r107 = null;
        L22:
            th = move-exception;
            throw th;
        }

        public C0738a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bizKey");
            this.f39647a = r100;
            this.f39648b = new o8.h();
            this.f39649c = new o8.f(0);
            this.f39650d = new o8.e(0);
            this.f39651e = new o8.g();
        }
    }

    public a(o8.h r100, o8.f r101, o8.e r102, o8.g r103) {
        this.f39643a = r100;
        this.f39644b = r101;
        this.f39645c = r102;
        this.f39646d = r103;
    }
}
