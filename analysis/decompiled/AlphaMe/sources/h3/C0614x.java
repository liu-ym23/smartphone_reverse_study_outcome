package h3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealCall;

/* renamed from: h3.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0614x {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f12988a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f12989b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f12990c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f12991d = new ArrayDeque();

    public final void a(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            synchronized (this) {
            }
            c();
        }
        Unit unit = Unit.INSTANCE;
        c();
    }

    public final void b(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.getCallsPerHost().decrementAndGet();
        a(this.f12990c, call);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
    
        if (r3 < 5) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        r1.remove();
        r2.getCallsPerHost().incrementAndGet();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "asyncCall");
        r0.add(r2);
        r14.f12990c.add(r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.C0614x.c():void");
    }

    public final synchronized List d() {
        List listUnmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f12989b;
            ArrayList arrayList = new ArrayList(CollectionsKt.e(arrayDeque));
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getThis$0());
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(readyAsyncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }

    public final synchronized List e() {
        List listUnmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f12991d;
            ArrayDeque arrayDeque2 = this.f12990c;
            ArrayList arrayList = new ArrayList(CollectionsKt.e(arrayDeque2));
            Iterator it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).getThis$0());
            }
            listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.plus((Collection) arrayDeque, (Iterable) arrayList));
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(running…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }
}
