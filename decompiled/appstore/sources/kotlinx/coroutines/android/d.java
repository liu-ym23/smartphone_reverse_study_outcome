package kotlinx.coroutines.android;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.o1;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends o1 implements Delay {
    public /* synthetic */ d(DefaultConstructorMarker r10) {
        this();
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long r10, Continuation r11) {
        return Delay.a.a(this, r10, r11);
    }

    public d() {
    }
}
