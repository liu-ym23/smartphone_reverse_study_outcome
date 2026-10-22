package C7;

import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes3.dex */
public final class b implements H7.c {

    /* renamed from: a, reason: collision with root package name */
    public S7.o f305a;
    public H7.c b;
    public Object c;

    @Override // H7.c
    public final H7.h getContext() {
        return EmptyCoroutineContext.f4908a;
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        this.b = null;
        this.c = obj;
    }
}
