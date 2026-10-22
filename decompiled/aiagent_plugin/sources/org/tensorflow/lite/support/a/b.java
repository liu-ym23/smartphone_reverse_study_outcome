package org.tensorflow.lite.support.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SequentialProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final List<org.tensorflow.lite.support.a.a<T>> f40593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Map<String, List<Integer>> f40594b;

    /* JADX INFO: compiled from: SequentialProcessor.java */
    protected static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<org.tensorflow.lite.support.a.a<T>> f40595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, List<Integer>> f40596b;

        static /* synthetic */ List a(a r0) {
            return r0.f40595a;
        }

        static /* synthetic */ Map b(a r0) {
            return r0.f40596b;
        }

        public a() {
            this.f40595a = new ArrayList();
            this.f40596b = new HashMap();
        }
    }

    public b(a<T> r2) {
        this.f40593a = a.a(r2);
        this.f40594b = Collections.unmodifiableMap(a.b(r2));
    }

    public T a(T r4) {
        Iterator<org.tensorflow.lite.support.a.a<T>> r3 = this.f40593a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r4 = (T) ((org.tensorflow.lite.support.a.a) ZeusTransformUtils.preCheckCast(r3.next(), org.tensorflow.lite.support.a.a.class, "com.obric.aiagent.plugin")).a(r4);
        goto L4
    L6:
        return r4;
    }
}
