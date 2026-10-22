package com.bytedance.android.live.openplatform.impl.base.utils;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f84080d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b> f84081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f84082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f84083c;

    public static final class a {
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f84084a;

        public abstract void a();

        public b() {
            this("");
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f84084a = r100;
        }
    }

    static {
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f84083c = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        b r100 = this.f84081a.poll();     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        boolean r101 = true;
    L7:
        this.f84082b = r101;     // Catch: Throwable -> L12
        com.bytedance.android.live.core.utils.v.a();     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        r100.a();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L6:
        r101 = false;
    L12:
        th = move-exception;
        throw th;
    }

    public w() {
        this.f84081a = new LinkedList();
    }

    public final synchronized void a(String r100, Function1 r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "taskName");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r101, "block");     // Catch: Throwable -> L12
        x r102 = new x(this, r101, r100);     // Catch: Throwable -> L12
        this.f84081a.offer(r102);     // Catch: Throwable -> L12
        com.bytedance.android.live.core.utils.v.a();     // Catch: Throwable -> L12
        this.f84081a.size();     // Catch: Throwable -> L12
        LinkedList<b> r103 = this.f84081a;     // Catch: Throwable -> L12
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));     // Catch: Throwable -> L12
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L12
    L5:
        if (r105.hasNext() == false) goto L7;
        r104.add(((b) r105.next()).f84084a);     // Catch: Throwable -> L12
        goto L5
    L7:
        r104.toString();     // Catch: Throwable -> L12
        com.bytedance.android.live.core.utils.v.a();     // Catch: Throwable -> L12
        if (this.f84082b == true) goto L10;
        b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
