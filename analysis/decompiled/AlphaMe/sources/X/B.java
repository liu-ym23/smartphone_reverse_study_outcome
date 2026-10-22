package X;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f2033d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f2034a;

    /* renamed from: b, reason: collision with root package name */
    public final t.d f2035b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2036c = 0;

    public B(t.d dVar, int i4) {
        this.f2035b = dVar;
        this.f2034a = i4;
    }

    public final int a(int i4) {
        Y.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        Object obj = aVarC.f2114d;
        int i5 = iA + aVarC.f2111a;
        return ((ByteBuffer) obj).getInt((i4 * 4) + ((ByteBuffer) obj).getInt(i5) + i5 + 4);
    }

    public final int b() {
        Y.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        int i4 = iA + aVarC.f2111a;
        return ((ByteBuffer) aVarC.f2114d).getInt(((ByteBuffer) aVarC.f2114d).getInt(i4) + i4);
    }

    public final Y.a c() {
        ThreadLocal threadLocal = f2033d;
        Y.a aVar = (Y.a) threadLocal.get();
        if (aVar == null) {
            aVar = new Y.a();
            threadLocal.set(aVar);
        }
        Y.b bVar = (Y.b) this.f2035b.f15273a;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i4 = iA + bVar.f2111a;
            int i5 = (this.f2034a * 4) + ((ByteBuffer) bVar.f2114d).getInt(i4) + i4 + 4;
            aVar.b((ByteBuffer) bVar.f2114d, ((ByteBuffer) bVar.f2114d).getInt(i5) + i5);
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        Y.a aVarC = c();
        int iA = aVarC.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarC.f2114d).getInt(iA + aVarC.f2111a) : 0));
        sb.append(", codepoints:");
        int iB = b();
        for (int i4 = 0; i4 < iB; i4++) {
            sb.append(Integer.toHexString(a(i4)));
            sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        }
        return sb.toString();
    }
}
