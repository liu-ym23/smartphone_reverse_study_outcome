package ai6;

import ey0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import vh6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements vh6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<d<?>, C0071a<?>> f3783a;

    /* JADX INFO: renamed from: ai6.a$a, reason: collision with other inner class name */
    public static final class C0071a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f3784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Continuation<T>> f3785b;

        public C0071a() {
            this.f3785b = new ArrayList();
        }
    }

    public a() {
        this.f3783a = new LinkedHashMap();
    }

    @Override // vh6.a
    public final <T> T b(d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return d(r100).f3784a;
    }

    public final <T> C0071a<T> d(d<T> r100) {
        LinkedHashMap r101 = (LinkedHashMap) this.f3783a;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new C0071a();
        r101.put(r100, r102);
    L6:
        return (C0071a) r102;
    }

    @Override // vh6.a
    public final Object a(d r100, ContinuationImpl r101) {
        C0071a r102 = d(r100);
        T r103 = r102.f3784a;
        if (r103 == 0) goto L5;
        return r103;
    L5:
        SafeContinuation r104 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
        ((ArrayList) r102.f3785b).add(r104);
        Object r105 = r104.getOrThrow();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L8:
        return r105;
    }

    @Override // vh6.a
    public final <T> void c(d<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        C0071a<T> r102 = d(r100);
        r102.f3784a = r101;
        if ((!r102.f3785b.isEmpty()) == false) goto L11;
        Iterator<T> r103 = r102.f3785b.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        b.a((Continuation) r103.next(), r101);
        goto L6
    L8:
        ((ArrayList) r102.f3785b).clear();
        return;
    }
}
