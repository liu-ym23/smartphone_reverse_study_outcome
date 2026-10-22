package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.f.k;
import com.bumptech.glide.request.target.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final b<T> preloadDimensionProvider;
    private final a<T> preloadModelProvider;
    private final d preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface a<U> {
        g<?> a(U r1);

        List<U> a(int r1);
    }

    public interface b<T> {
        int[] a(T r1, int r2, int r3);
    }

    private static final class c implements i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.bumptech.glide.request.d f3213c;

        @Override // com.bumptech.glide.request.target.i
        public void a(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.i
        public void a(Object r1, com.bumptech.glide.request.a.b<? super Object> r2) {
            com.bumptech.glide.request.a.b r0 = (com.bumptech.glide.request.a.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.a.b.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.request.target.i
        public void b(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.target.i
        public void b(com.bumptech.glide.request.target.h r2) {
            com.bumptech.glide.request.target.h r1 = (com.bumptech.glide.request.target.h) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.target.h.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.request.target.i
        public void c(Drawable r1) {
        }

        @Override // com.bumptech.glide.manager.i
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.manager.i
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.i
        public void onStop() {
        }

        c() {
        }

        @Override // com.bumptech.glide.request.target.i
        public void a(com.bumptech.glide.request.target.h r3) {
            ((com.bumptech.glide.request.target.h) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.target.h.class, "com.obric.aiagent.plugin")).a(this.f3212b, this.f3211a);
        }

        @Override // com.bumptech.glide.request.target.i
        public void a(com.bumptech.glide.request.d r3) {
            this.f3213c = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
        }

        @Override // com.bumptech.glide.request.target.i
        public com.bumptech.glide.request.d a() {
            return this.f3213c;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<c> f3214a;

        d(int r4) {
            this.f3214a = k.a(r4);
            int r0 = 0;
        L3:
            if (r0 >= r4) goto L5;
            this.f3214a.offer(new c());
            r0 = r0 + 1;
            goto L3
        }

        public c a(int r4, int r5) {
            c r0 = (c) ZeusTransformUtils.preCheckCast(this.f3214a.poll(), c.class, "com.obric.aiagent.plugin");
            this.f3214a.offer(r0);
            r0.f3212b = r4;
            r0.f3211a = r5;
            return r0;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r1, int r2) {
    }

    public ListPreloader(RequestManager r3, a<T> r4, b<T> r5, int r6) {
        a<T> r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        b<T> r8 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = r3;
        this.preloadModelProvider = r7;
        this.preloadDimensionProvider = r8;
        this.maxPreload = r6;
        this.preloadTargetQueue = new d(r6 + 1);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        this.totalItemCount = r4;
        int r5 = this.lastFirstVisible;
        if (r2 <= r5) goto L5;
        preload(r3 + r2, true);
    L7:
        this.lastFirstVisible = r2;
        return;
    L5:
        if (r2 >= r5) goto L7;
        preload(r2, false);
        goto L7
    }

    private void preload(int r2, boolean r3) {
        if (this.isIncreasing == r3) goto L5;
        this.isIncreasing = r3;
        cancelAll();
    L5:
        if (r3 == false) goto L7;
        int r4 = this.maxPreload;
    L8:
        preload(r2, r4 + r2);
        return;
    L7:
        r4 = -this.maxPreload;
        goto L8
    }

    private void preload(int r5, int r6) {
        if (r5 >= r6) goto L4;
        int r1 = Math.max(this.lastEnd, r5);
        int r0 = r6;
    L5:
        int r2 = Math.min(this.totalItemCount, r0);
        int r3 = Math.min(this.totalItemCount, Math.max(0, r1));
        if (r5 >= r6) goto L10;
        int r7 = r3;
    L8:
        if (r7 >= r2) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.a(r7), r7, true);
        r7 = r7 + 1;
    L13:
        this.lastStart = r3;
        this.lastEnd = r2;
        return;
    L10:
        int r8 = r2 - 1;
    L11:
        if (r8 < r3) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.a(r8), r8, false);
        r8 = r8 - 1;
        goto L11
    L4:
        r0 = Math.min(this.lastStart, r5);
        r1 = r6;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void preloadAdapterPosition(List<T> r3, int r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        int r0 = r6.size();
        if (r5 == false) goto L7;
        int r7 = 0;
    L5:
        if (r7 >= r0) goto L10;
        preloadItem(r6.get(r7), r4, r7);
        r7 = r7 + 1;
        goto L5
    L10:
        return;
    L7:
        int r1 = r0 - 1;
    L8:
        if (r1 < 0) goto L13;
        preloadItem(r6.get(r1), r4, r1);
        r1 = r1 - 1;
        goto L8
    }

    private void preloadItem(T r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        int[] r5 = this.preloadDimensionProvider.a(r2, r3, r4);
        if (r5 != null) goto L7;
        return;
    L7:
        g<?> r6 = this.preloadModelProvider.a(r2);
        if (r6 != null) goto L10;
        return;
    L10:
        r6.a(this.preloadTargetQueue.a(r5[0], r5[1]));
    }

    private void cancelAll() {
        int r1 = 0;
    L4:
        if (r1 >= this.preloadTargetQueue.f3214a.size()) goto L6;
        this.requestManager.clear(this.preloadTargetQueue.a(0, 0));
        r1 = r1 + 1;
        goto L4
    }
}
