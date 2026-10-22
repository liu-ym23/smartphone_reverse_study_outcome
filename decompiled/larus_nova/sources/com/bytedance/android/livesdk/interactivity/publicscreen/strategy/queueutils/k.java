package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> f139583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.m f139584b;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f139585a = null;

        static {
            f139585a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return (int) (((com.bytedance.android.livesdk.interactivity.api.entity.f) r100).p().longValue() - ((com.bytedance.android.livesdk.interactivity.api.entity.f) r101).p().longValue());
        }
    }

    public abstract void a(Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r100, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r101, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r102, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r103);

    public k(com.bytedance.android.livesdk.interactivity.api.settings.config.m r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f139584b = r100;
        this.f139583a = new PriorityQueue(5, a.f139585a);
    }
}
