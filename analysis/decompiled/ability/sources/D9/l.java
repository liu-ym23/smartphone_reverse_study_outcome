package D9;

import D7.N;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.Protocol;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f442a;
    public int b;
    public Serializable c;
    public Object d;

    public /* synthetic */ l(int i, byte b) {
        this.f442a = i;
    }

    public void a(Object obj) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.c;
        concurrentLinkedQueue.add(obj);
        if (concurrentLinkedQueue.size() > this.b) {
            Object objPoll = concurrentLinkedQueue.poll();
            if (((F.i) this.d) != null) {
                N0.b bVar = (N0.b) objPoll;
                if (P0.a.b) {
                    H4.o.n("APM-CommonEvent", "evicted Monitorable " + bVar);
                }
            }
        }
    }

    public String b() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.b + 1;
        for (int i6 = 0; i6 < i; i6++) {
            Object obj = ((Object[]) this.c)[i6];
            if (obj instanceof z9.g) {
                z9.g gVar = (z9.g) obj;
                if (!kotlin.jvm.internal.k.b(gVar.getKind(), z9.k.d)) {
                    int i10 = ((int[]) this.d)[i6];
                    if (i10 >= 0) {
                        sb.append(".");
                        sb.append(gVar.e(i10));
                    }
                } else if (((int[]) this.d)[i6] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.d)[i6]);
                    sb.append("]");
                }
            } else if (obj != k.f441a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Object[]] */
    public void c(Object obj, Object obj2) {
        int i = (this.b + 1) * 2;
        Object[] objArr = (Object[]) this.c;
        if (i > objArr.length) {
            int length = objArr.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = length + (length >> 1) + 1;
            if (iHighestOneBit < i) {
                iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                iHighestOneBit = Integer.MAX_VALUE;
            }
            this.c = Arrays.copyOf(objArr, iHighestOneBit);
        }
        N.r(obj, obj2);
        Object[] objArr2 = (Object[]) this.c;
        int i6 = this.b;
        int i10 = i6 * 2;
        objArr2[i10] = obj;
        objArr2[i10 + 1] = obj2;
        this.b = i6 + 1;
    }

    public String toString() {
        switch (this.f442a) {
            case 0:
                return b();
            case 1:
                StringBuilder sb = new StringBuilder();
                if (((Protocol) this.c) == Protocol.HTTP_1_0) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.b);
                sb.append(' ');
                sb.append((String) this.d);
                String string = sb.toString();
                kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    public l(int i) {
        this.f442a = 3;
        this.c = new ConcurrentLinkedQueue();
        this.b = i;
    }

    public l(Protocol protocol, int i, String str) {
        this.f442a = 1;
        this.c = protocol;
        this.b = i;
        this.d = str;
    }
}
