package com.bytedance.ai.applet.base.log;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements u1<Map<String, ? extends String>>, CoroutineContext.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f34523b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f34524c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f34525d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f34526a;

    public static final class a implements CoroutineContext.Key<e> {
        public a() {
        }
    }

    static {
        f34523b = new a();
        f34524c = Long.toString(System.currentTimeMillis(), CharsKt.checkRadix(36));
        f34525d = new AtomicLong();
        new e(MapsKt.emptyMap());
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<e> getKey() {
        return f34523b;
    }

    public e(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.f34526a = r100;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r100) {
        return CoroutineContext.Element.DefaultImpls.plus(this, r100);
    }

    @Override // kotlinx.coroutines.u1
    public final Map<String, ? extends String> updateThreadContext(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Map<String, String> r101 = f.f34527a.get();
        f.b(this.f34526a);
        return r101;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) CoroutineContext.Element.DefaultImpls.fold(this, r100, r101);
    }

    @Override // kotlinx.coroutines.u1
    public final void restoreThreadContext(CoroutineContext r100, Map<String, ? extends String> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        f.b(r101);
    }
}
