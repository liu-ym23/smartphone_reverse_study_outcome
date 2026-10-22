package com.bytedance.android.anniex.scene.handler.idle;

import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c<T> implements Comparable<c<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskType f41199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f41201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f41203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f41204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final T f41205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f41206i;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f41208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f41210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f41211e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f41212f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public T f41213g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Function1<? super T, Unit> f41214h;

        public a() {
        }

        public final b a(TaskType r110) {
            Intrinsics.checkNotNullParameter(r110, "taskType");
            return new b(r110, this, UUID.randomUUID().toString(), this.f41207a, this.f41208b, this.f41209c, this.f41210d, this.f41211e, this.f41212f, this.f41213g);
        }
    }

    public c() {
        throw null;
    }

    public abstract void a(T r100);

    public final T getContext() {
        return this.f41205h;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object r100) {
        c r101 = (c) r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return Intrinsics.compare(r101.f41202e, this.f41202e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, TaskType r101, String r102, String r103, int r104, long r105, long r106, boolean r110, Object r111) {
        this.f41198a = r100;
        this.f41199b = r101;
        this.f41200c = r102;
        this.f41201d = r103;
        this.f41202e = r104;
        this.f41203f = r106;
        this.f41204g = r110;
        this.f41205h = r111;
        if (r105 <= 0) goto L5;
        Long r107 = Long.valueOf(System.currentTimeMillis() + r105);
    L6:
        this.f41206i = r107;
        return;
    L5:
        r107 = null;
        goto L6
    }
}
