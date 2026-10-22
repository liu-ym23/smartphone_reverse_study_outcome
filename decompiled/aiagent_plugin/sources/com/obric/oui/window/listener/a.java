package com.obric.oui.window.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.p;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: NextLiveData.java */
/* JADX INFO: loaded from: classes4.dex */
public class a<T> extends v<T> {
    private static final Handler g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36894e;
    private final Map<w<? super T>, a<T>.C1005a<? super T>> f;

    /* JADX INFO: renamed from: com.obric.oui.window.listener.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NextLiveData.java */
    private class C1005a<R> implements w<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f36897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f36898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private w<R> f36899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f36900d;

        C1005a(a r3, int r4, w<R> r5, boolean r6) {
            w<R> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            this.f36897a = r3;
            this.f36898b = r4;
            this.f36899c = r7;
            this.f36900d = r6;
        }

        @Override // androidx.lifecycle.w
        public void onChanged(R r3) {
            if (this.f36900d == false) goto L5;
        L7:
            this.f36899c.onChanged(r3);
            return;
        L5:
            if (this.f36898b < a.a(this.f36897a)) goto L7;
        }
    }

    public a() {
        this.f36894e = -1;
        this.f = new HashMap();
    }

    static /* synthetic */ int a(a r0) {
        return r0.f36894e;
    }

    static {
        g = new Handler(Looper.getMainLooper());
    }

    @Override // androidx.lifecycle.LiveData
    public void a(p r3, w<? super T> r4) {
        a((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin"), (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin"), false);
    }

    public void a(p r3, w<? super T> r4, boolean r5) {
        p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        w<? super T> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
        if (this.f.containsKey(r7) == false) goto L5;
        return;
    L5:
        a<T>.C1005a<? super T> r0 = new C1005a(this, this.f36894e, r7, r5);
        this.f.put(r7, r0);
        super.a(r6, r0);
    }

    @Override // androidx.lifecycle.LiveData
    public void a(w<? super T> r3) {
        a((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin"), false);
    }

    public void a(w<? super T> r3, boolean r4) {
        w<? super T> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
        if (this.f.containsKey(r5) == false) goto L5;
        return;
    L5:
        a<T>.C1005a<? super T> r0 = new C1005a(this, this.f36894e, r5, r4);
        this.f.put(r5, r0);
        super.a(r0);
    }

    @Override // androidx.lifecycle.LiveData
    public void b(w<? super T> r6) {
        w<? super T> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
        C1005a r0 = (C1005a) ZeusTransformUtils.preCheckCast(this.f.remove(r7), C1005a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        super.b(r0);
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, C1005a.class) == false) goto L20;
        w r1 = null;
        Iterator<Map.Entry<w<? super T>, a<T>.C1005a<? super T>>> r2 = this.f.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r7.equals(r3.getValue()) == false) goto L10;
        r1 = (w) ZeusTransformUtils.preCheckCast(r3.getKey(), w.class, "com.obric.aiagent.plugin");
        super.b(r7);
    L14:
        if (r1 == null) goto L21;
        this.f.remove(r1);
        return;
    L21:
        return;
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void b(T r2) {
        this.f36894e++;
        super.b(r2);
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void a(final T r3) {
        g.post(new AnonymousClass1(this, r3));
    }
}
