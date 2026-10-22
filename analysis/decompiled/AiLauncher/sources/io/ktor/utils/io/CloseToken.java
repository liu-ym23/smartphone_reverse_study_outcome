package io.ktor.utils.io;

import Ua.C;
import Ua.C1063j0;
import Y8.t;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/CloseToken;", "", "", "origin", "<init>", "(Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "wrap", "wrapCause", "(Lp9/l;)Ljava/lang/Throwable;", "LY8/t;", "throwOrNull", "(Lp9/l;)LY8/t;", "Ljava/lang/Throwable;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CloseToken {
    private final Throwable origin;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.utils.io.CloseToken$wrapCause$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<Throwable, ClosedByteChannelException> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1, ClosedByteChannelException.class, "<init>", "<init>(Ljava/lang/Throwable;)V", 0);
        }

        @Override // p9.InterfaceC5074l
        public final ClosedByteChannelException invoke(Throwable th) {
            return new ClosedByteChannelException(th);
        }
    }

    public CloseToken(Throwable th) {
        this.origin = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Throwable wrapCause$default(CloseToken closeToken, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = AnonymousClass1.INSTANCE;
        }
        return closeToken.wrapCause(interfaceC5074l);
    }

    public final t throwOrNull(InterfaceC5074l<? super Throwable, ? extends Throwable> wrap) throws Throwable {
        p.i(wrap, "wrap");
        Throwable thWrapCause = wrapCause(wrap);
        if (thWrapCause == null) {
            return null;
        }
        throw thWrapCause;
    }

    public final Throwable wrapCause(InterfaceC5074l<? super Throwable, ? extends Throwable> wrap) {
        p.i(wrap, "wrap");
        Object obj = this.origin;
        if (obj == null) {
            return null;
        }
        return obj instanceof C ? ((C) obj).createCopy() : obj instanceof CancellationException ? C1063j0.a(((CancellationException) obj).getMessage(), this.origin) : wrap.invoke(obj);
    }
}
