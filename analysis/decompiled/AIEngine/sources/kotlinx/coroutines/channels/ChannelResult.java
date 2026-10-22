package kotlinx.coroutines.channels;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChannelResult<T> {
    public static final Companion Companion = new Companion(null);
    private static final Failed failed = new Failed();
    private final Object holder;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && g.b(this.cause, ((Closed) obj).cause);
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: closed-JP2dKIU, reason: not valid java name */
        public final <E> Object m163closedJP2dKIU(Throwable th) {
            return ChannelResult.m153constructorimpl(new Closed(th));
        }

        /* renamed from: failure-PtdJZtk, reason: not valid java name */
        public final <E> Object m164failurePtdJZtk() {
            return ChannelResult.m153constructorimpl(ChannelResult.failed);
        }

        /* renamed from: success-JP2dKIU, reason: not valid java name */
        public final <E> Object m165successJP2dKIU(E e10) {
            return ChannelResult.m153constructorimpl(e10);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ChannelResult m152boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m154equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && g.b(obj, ((ChannelResult) obj2).m162unboximpl());
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m155exceptionOrNullimpl(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed != null) {
            return closed.cause;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m156getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m157hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m158isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m159isFailureimpl(Object obj) {
        return obj instanceof Failed;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m160isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m161toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m154equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m157hashCodeimpl(this.holder);
    }

    public String toString() {
        return m161toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m162unboximpl() {
        return this.holder;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m153constructorimpl(Object obj) {
        return obj;
    }
}
