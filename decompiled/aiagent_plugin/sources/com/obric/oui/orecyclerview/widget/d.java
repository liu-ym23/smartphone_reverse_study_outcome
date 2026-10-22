package com.obric.oui.orecyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AsyncListDiffer.java */
/* JADX INFO: loaded from: classes4.dex */
public class d<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f35714e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final c<T> f35715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Executor f35716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f35717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final q f35718d;
    private final List<a<T>> f;
    private List<T> g;
    private List<T> h;

    /* JADX INFO: compiled from: AsyncListDiffer.java */
    public interface a<T> {
        void a(List<T> r1, List<T> r2);
    }

    /* JADX INFO: compiled from: AsyncListDiffer.java */
    private static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Handler f35727a;

        b() {
            this.f35727a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            this.f35727a.post(r4);
        }
    }

    static {
        f35714e = new b();
    }

    public d(q r3, c<T> r4) {
        q r5 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        this.f = new CopyOnWriteArrayList();
        this.h = Collections.emptyList();
        this.f35718d = r5;
        this.f35715a = r4;
        if (r4.a() == null) goto L5;
        this.f35716b = r4.a();
        return;
    L5:
        this.f35716b = f35714e;
    }

    public List<T> a() {
        return this.h;
    }

    public void a(List<T> r3) {
        a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), null);
    }

    public void a(List<T> r9, Runnable r10) {
        final List<T> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        final Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r10, Runnable.class, "com.obric.aiagent.plugin");
        final int r6 = this.f35717c + 1;
        this.f35717c = r6;
        final List<T> r4 = this.g;
        if (r5 != r4) goto L7;
        if (r7 == null) goto L16;
        r7.run();
        return;
    L16:
        return;
    L7:
        List<T> r11 = this.h;
        if (r5 != null) goto L11;
        int r0 = r4.size();
        this.g = null;
        this.h = Collections.emptyList();
        this.f35718d.b(0, r0);
        b(r11, r7);
        return;
    L11:
        if (r4 != null) goto L14;
        this.g = r5;
        this.h = Collections.unmodifiableList(r5);
        this.f35718d.a(0, r5.size());
        b(r11, r7);
        return;
    L14:
        this.f35715a.b().execute(new AnonymousClass1(this, r4, r5, r6, r7));
    }

    void a(List<T> r3, j.d r4, Runnable r5) {
        List<T> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        List<T> r0 = this.h;
        this.g = r6;
        this.h = Collections.unmodifiableList(r6);
        r4.a(this.f35718d);
        b(r0, r7);
    }

    private void b(List<T> r5, Runnable r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
        Iterator<a<T>> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).a(r7, this.h);
        goto L4
    L6:
        if (r8 == null) goto L10;
        r8.run();
        return;
    }

    public void a(a<T> r3) {
        a<T> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        this.f.add(r4);
    }
}
