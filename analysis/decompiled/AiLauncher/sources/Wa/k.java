package Wa;

import Za.z;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u0012J!\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u0010J+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b \u0010!J)\u0010&\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010)\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u001c¢\u0006\u0004\b)\u0010*J!\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0001\u0010\u0010R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0013\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00168\u0002X\u0082\u0004¨\u00064"}, d2 = {"LWa/k;", ExifInterface.LONGITUDE_EAST, "LZa/z;", "", "id", "prev", "Lkotlinx/coroutines/channels/BufferedChannel;", "channel", "", "pointers", "<init>", "(JLWa/k;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "index", "element", "LY8/t;", "G", "(ILjava/lang/Object;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)Ljava/lang/Object;", "D", "w", "(I)V", "", "B", UxipConstants.f30680s, "F", "from", "to", "", "v", "(ILjava/lang/Object;Ljava/lang/Object;)Z", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "x", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "cause", "Lkotlin/coroutines/d;", "context", "s", "(ILjava/lang/Throwable;Lkotlin/coroutines/d;)V", "receiver", "C", "(IZ)V", "e", "Lkotlinx/coroutines/channels/BufferedChannel;", "_channel", "y", "()Lkotlinx/coroutines/channels/BufferedChannel;", "r", "()I", "numberOfSlots", "data", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k<E> extends z<k<E>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final BufferedChannel<E> _channel;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f6795f;

    public k(long j10, k<E> kVar, BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, kVar, i10);
        this._channel = bufferedChannel;
        this.f6795f = new AtomicReferenceArray(BufferedChannelKt.f36318b * 2);
    }

    public final E A(int index) {
        return (E) getF6795f().get(index * 2);
    }

    public final Object B(int index) {
        return getF6795f().get((index * 2) + 1);
    }

    public final void C(int index, boolean receiver) {
        if (receiver) {
            y().r1((this.id * BufferedChannelKt.f36318b) + index);
        }
        t();
    }

    public final E D(int index) {
        E eA = A(index);
        w(index);
        return eA;
    }

    public final void E(int index, Object value) {
        getF6795f().set(index * 2, value);
    }

    public final void F(int index, Object value) {
        getF6795f().set((index * 2) + 1, value);
    }

    public final void G(int index, E element) {
        E(index, element);
    }

    @Override // Za.z
    public int r() {
        return BufferedChannelKt.f36318b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r3 = y().onUndeliveredElement;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r3 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006f, code lost:
    
        Za.v.a(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // Za.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, kotlin.coroutines.d r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f36318b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof Ua.U0
            if (r2 != 0) goto L73
            boolean r2 = r1 instanceof Wa.WaiterEB
            if (r2 == 0) goto L1b
            goto L73
        L1b:
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L62
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L62
        L28:
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            Za.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r3) goto L99
            Za.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.f36320d
            if (r1 != r3) goto L40
            goto L99
        L40:
            Za.C r3 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r3) goto L47
            goto L99
        L47:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unexpected state: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L62:
            r3.w(r4)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.y()
            p9.l<E, Y8.t> r3 = r3.onUndeliveredElement
            if (r3 == 0) goto L99
            Za.v.a(r3, r5, r6)
            return
        L73:
            if (r0 == 0) goto L7a
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7e
        L7a:
            Za.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7e:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L99
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.y()
            p9.l<E, Y8.t> r3 = r3.onUndeliveredElement
            if (r3 == 0) goto L99
            Za.v.a(r3, r5, r6)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Wa.k.s(int, java.lang.Throwable, kotlin.coroutines.d):void");
    }

    public final boolean v(int index, Object from, Object to) {
        return getF6795f().compareAndSet((index * 2) + 1, from, to);
    }

    public final void w(int index) {
        E(index, null);
    }

    public final Object x(int index, Object update) {
        return getF6795f().getAndSet((index * 2) + 1, update);
    }

    public final BufferedChannel<E> y() {
        BufferedChannel<E> bufferedChannel = this._channel;
        kotlin.jvm.internal.p.f(bufferedChannel);
        return bufferedChannel;
    }

    /* renamed from: z, reason: from getter */
    public final /* synthetic */ AtomicReferenceArray getF6795f() {
        return this.f6795f;
    }
}
