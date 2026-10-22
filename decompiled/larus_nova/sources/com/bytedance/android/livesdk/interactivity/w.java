package com.bytedance.android.livesdk.interactivity;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w extends com.bytedance.android.livesdk.interactivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<v> f141431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f141432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f141433c;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f141434a = null;

        static {
            f141434a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            v r102 = (v) r100;
            v r103 = (v) r101;
            Intrinsics.checkNotNullParameter(r102, "widget1");
            Intrinsics.checkNotNullParameter(r103, "widget2");
            return (r103.f141429f > r102.f141429f ? 1 : (r103.f141429f == r102.f141429f ? 0 : -1));
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f141435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f141436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f141437c;

        public b(Function2 r100, v r101, ViewGroup r102) {
            this.f141435a = r100;
            this.f141436b = r101;
            this.f141437c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f141435a.invoke(this.f141436b, this.f141437c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void c() {
        MainThreadPostUtils.d(this.f141433c);
        this.f141432b = false;
        this.f141431a.clear();
    }

    public w() {
        this.f141431a = new PriorityQueue(10, a.f141434a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void a(v r100) {
        Intrinsics.checkNotNullParameter(r100, "wrapWidget");
        this.f141431a.add(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void b(v r100) {
        Intrinsics.checkNotNullParameter(r100, "wrapWidget");
        this.f141431a.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.a
    public final void d(v r100, ViewGroup r101, Function2<? super v, ? super ViewGroup, Unit> r102, Function2<? super v, ? super ViewGroup, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "wrapWidget");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "startAction");
        Intrinsics.checkNotNullParameter(r103, "endAction");
        v r104 = (v) CollectionsKt.firstOrNull(this.f141431a);
        if (r104 != null) goto L5;
        return;
    L5:
        if (this.f141432b == false) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(r104, r100)) == true) goto L13;
        r102.invoke(r100, r101);
        this.f141432b = true;
        b r105 = new b(r103, r100, r101);
        this.f141433c = r105;
        MainThreadPostUtils.c(r105, r100.f141430g);
        return;
    }
}
