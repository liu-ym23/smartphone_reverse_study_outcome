package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public class v1 extends a {
    public v1(CoroutineContext r10, boolean r11) {
        super(r10, true, r11);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean F(Throwable r10) {
        a0.a(getContext(), r10);
        return true;
    }
}
