package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes4.dex */
public class i extends BufferedChannel {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f21366m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final BufferOverflow f21367n;

    public i(int r10, BufferOverflow r11, Function1 r12) {
        super(r10, r12);
        this.f21366m = r10;
        this.f21367n = r11;
        if (r11 == BufferOverflow.SUSPEND) goto L10;
        if (r10 < 1) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r10 + " was specified").toString());
    L10:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + u.b(BufferedChannel.class).getSimpleName() + " instead").toString());
    }

    public static /* synthetic */ Object Q0(i r10, Object r11, Continuation r12) {
        Object r13 = r10.T0(r11, true);
        if ((r13 instanceof f.a) == false) goto L13;
        f.e(r13);
        Function1 r14 = r10.f21331b;
        if (r14 == null) goto L11;
        UndeliveredElementException r15 = OnUndeliveredElementKt.d(r14, r11, null, 2, null);
        if (r15 == null) goto L11;
        kotlin.a.a(r15, r10.M());
        throw r15;
    L11:
        throw r10.M();
    L13:
        return Unit.f21064a;
    }

    public final Object R0(Object r10, boolean r11) {
        Object r12 = super.mo53trySendJP2dKIU(r10);
        if (f.j(r12) == false) goto L5;
    L16:
        return r12;
    L5:
        if (f.i(r12) == true) goto L16;
        if (r11 == false) goto L15;
        Function1 r13 = this.f21331b;
        if (r13 == null) goto L15;
        UndeliveredElementException r14 = OnUndeliveredElementKt.d(r13, r10, null, 2, null);
        if (r14 == null) goto L15;
        throw r14;
    L15:
        return f.f21360b.c(Unit.f21064a);
    }

    public final Object S0(Object r17) {
        Object r10 = BufferedChannelKt.f21339d;
        g r11 = (g) BufferedChannel.f().get(this);
    L3:
        long r12 = BufferedChannel.g().getAndIncrement(this);
        long r13 = r12 & 1152921504606846975L;
        boolean r14 = BufferedChannel.h(this, r12);
        int r15 = BufferedChannelKt.f21337b;
        long r16 = r13 / ((long) r15);
        int r18 = (int) (r13 % ((long) r15));
        if (r11.f21630c == r16) goto L11;
        g r19 = BufferedChannel.b(this, r16, r11);
        if (r19 == null) goto L7;
        g r110 = r19;
    L12:
        int r20 = BufferedChannel.u(this, r110, r18, r17, r13, r10, r14);
        if (r20 == 0) goto L47;
        if (r20 == 1) goto L46;
        if (r20 == 2) goto L34;
        if (r20 == 3) goto L33;
        if (r20 == 4) goto L28;
        if (r20 != 5) goto L26;
        r110.b();
    L26:
        r11 = r110;
        goto L3
    L28:
        if (r13 >= L()) goto L31;
        r110.b();
    L31:
        return f.f21360b.a(M());
    L33:
        throw new IllegalStateException("unexpected");
    L34:
        if (r14 == false) goto L38;
        r110.p();
        return f.f21360b.a(M());
    L38:
        if ((r10 instanceof Waiter) == false) goto L40;
        Waiter r21 = (Waiter) r10;
    L41:
        if (r21 == null) goto L43;
        BufferedChannel.m(this, r21, r110, r18);
    L43:
        D((r110.f21630c * ((long) r15)) + ((long) r18));
        return f.f21360b.c(Unit.f21064a);
    L40:
        r21 = null;
        goto L41
    L46:
        return f.f21360b.c(Unit.f21064a);
    L47:
        r110.b();
        return f.f21360b.c(Unit.f21064a);
    L7:
        if (r14 == false) goto L3;
        return f.f21360b.a(M());
    L11:
        r110 = r11;
        goto L12
    }

    public final Object T0(Object r10, boolean r11) {
        if (this.f21367n != BufferOverflow.DROP_LATEST) goto L6;
        return R0(r10, r11);
    L6:
        return S0(r10);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean W() {
        if (this.f21367n != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(Object r10, Continuation r11) {
        return Q0(this, r10, r11);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo53trySendJP2dKIU(Object r10) {
        return T0(r10, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void x0(SelectInstance r10, Object r11) {
        Object r12 = mo53trySendJP2dKIU(r11);
        if ((r12 instanceof f.c) == true) goto L7;
        Unit r13 = (Unit) r12;
        r10.selectInRegistrationPhase(Unit.f21064a);
        return;
    L7:
        if ((r12 instanceof f.a) == false) goto L11;
        f.e(r12);
        r10.selectInRegistrationPhase(BufferedChannelKt.z());
        return;
    L11:
        throw new IllegalStateException("unreachable");
    }
}
