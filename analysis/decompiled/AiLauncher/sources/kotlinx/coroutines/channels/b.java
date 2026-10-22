package kotlinx.coroutines.channels;

import Ua.U0;
import Wa.k;
import Y8.d;
import Y8.t;
import Za.v;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.UndeliveredElementException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lkotlinx/coroutines/channels/b;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "LY8/t;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lp9/l;)V", "element", "send", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/a;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "isSendOp", "v1", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "t1", "u1", "m", "I", "n", "Lkotlinx/coroutines/channels/BufferOverflow;", "y0", "()Z", "isConflatedDropOldest", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class b<E> extends BufferedChannel<E> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final BufferOverflow onBufferOverflow;

    public b(int i10, BufferOverflow bufferOverflow, InterfaceC5074l<? super E, t> interfaceC5074l) {
        super(i10, interfaceC5074l);
        this.capacity = i10;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.t.b(BufferedChannel.class).t() + " instead").toString());
        }
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    public static /* synthetic */ <E> Object s1(b<E> bVar, E e10, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionC;
        Object objV1 = bVar.v1(e10, true);
        if (!(objV1 instanceof a.Closed)) {
            return t.f7040a;
        }
        a.e(objV1);
        InterfaceC5074l<E, t> interfaceC5074l = bVar.onUndeliveredElement;
        if (interfaceC5074l == null || (undeliveredElementExceptionC = v.c(interfaceC5074l, e10, null, 2, null)) == null) {
            throw bVar.k0();
        }
        d.a(undeliveredElementExceptionC, bVar.k0());
        throw undeliveredElementExceptionC;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, Wa.s
    public Object send(E e10, InterfaceC4014c<? super t> interfaceC4014c) {
        return s1(this, e10, interfaceC4014c);
    }

    public final Object t1(E element, boolean isSendOp) {
        InterfaceC5074l<E, t> interfaceC5074l;
        UndeliveredElementException undeliveredElementExceptionC;
        Object objMo0trySendJP2dKIU = super.mo0trySendJP2dKIU(element);
        if (a.j(objMo0trySendJP2dKIU) || a.i(objMo0trySendJP2dKIU)) {
            return objMo0trySendJP2dKIU;
        }
        if (!isSendOp || (interfaceC5074l = this.onUndeliveredElement) == null || (undeliveredElementExceptionC = v.c(interfaceC5074l, element, null, 2, null)) == null) {
            return a.INSTANCE.c(t.f7040a);
        }
        throw undeliveredElementExceptionC;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, Wa.s
    /* renamed from: trySend-JP2dKIU */
    public Object mo0trySendJP2dKIU(E element) {
        return v1(element, false);
    }

    public final Object u1(E element) {
        k kVarZ;
        int i10;
        b<E> bVar;
        Object obj = BufferedChannelKt.f36320d;
        k kVar = (k) BufferedChannel.l0().get(this);
        while (true) {
            long andIncrement = BufferedChannel.m0().getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zX0 = this.x0(andIncrement);
            int i11 = BufferedChannelKt.f36318b;
            long j11 = j10 / i11;
            int i12 = (int) (j10 % i11);
            if (kVar.id != j11) {
                kVarZ = this.Z(j11, kVar);
                if (kVarZ != null) {
                    bVar = this;
                    i10 = i12;
                } else if (zX0) {
                    return a.INSTANCE.a(this.k0());
                }
            } else {
                kVarZ = kVar;
                i10 = i12;
                bVar = this;
            }
            E e10 = element;
            int iN1 = bVar.n1(kVarZ, i10, e10, j10, obj, zX0);
            b<E> bVar2 = bVar;
            kVar = kVarZ;
            if (iN1 == 0) {
                kVar.b();
                return a.INSTANCE.c(t.f7040a);
            }
            if (iN1 == 1) {
                return a.INSTANCE.c(t.f7040a);
            }
            if (iN1 == 2) {
                if (zX0) {
                    kVar.t();
                    return a.INSTANCE.a(bVar2.k0());
                }
                U0 u02 = obj instanceof U0 ? (U0) obj : null;
                if (u02 != null) {
                    bVar2.S0(u02, kVar, i10);
                }
                bVar2.V((kVar.id * i11) + i10);
                return a.INSTANCE.c(t.f7040a);
            }
            if (iN1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iN1 == 4) {
                if (j10 < bVar2.j0()) {
                    kVar.b();
                }
                return a.INSTANCE.a(bVar2.k0());
            }
            if (iN1 == 5) {
                kVar.b();
            }
            this = bVar2;
            element = e10;
        }
    }

    public final Object v1(E element, boolean isSendOp) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? t1(element, isSendOp) : u1(element);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean y0() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }
}
