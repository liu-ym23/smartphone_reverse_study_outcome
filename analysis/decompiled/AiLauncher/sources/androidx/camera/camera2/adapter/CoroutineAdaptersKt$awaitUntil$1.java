package androidx.camera.camera2.adapter;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.camera.camera2.adapter.CoroutineAdaptersKt", f = "CoroutineAdapters.kt", l = {199}, m = "awaitUntil", v = 1)
/* loaded from: classes.dex */
public final class CoroutineAdaptersKt$awaitUntil$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9320a;

    /* renamed from: b, reason: collision with root package name */
    public int f9321b;

    public CoroutineAdaptersKt$awaitUntil$1(InterfaceC4014c<? super CoroutineAdaptersKt$awaitUntil$1> interfaceC4014c) {
        super(interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9320a = obj;
        this.f9321b |= Integer.MIN_VALUE;
        return CoroutineAdaptersKt.o(null, 0L, this);
    }
}
