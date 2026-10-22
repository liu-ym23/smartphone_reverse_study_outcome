package p9;

import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: classes4.dex */
public abstract /* synthetic */ class e {

    /* renamed from: a, reason: collision with root package name */
    public static final com.stepos.core.a f5557a = new com.stepos.core.a(13);
    public static final a5.d b;
    public static final a5.d c;
    public static final a5.d d;

    static {
        int i = 6;
        b = new a5.d("NO_VALUE", i);
        c = new a5.d("NONE", i);
        d = new a5.d("PENDING", i);
    }

    public static final kotlinx.coroutines.flow.h a(int i, int i6, BufferOverflow bufferOverflow) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "replay cannot be negative, but was ").toString());
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "extraBufferCapacity cannot be negative, but was ").toString());
        }
        if (i <= 0 && i6 <= 0 && bufferOverflow != BufferOverflow.f5184a) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow).toString());
        }
        int i10 = i6 + i;
        if (i10 < 0) {
            i10 = Integer.MAX_VALUE;
        }
        return new kotlinx.coroutines.flow.h(i, i10, bufferOverflow);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.h b(int i, int i6, BufferOverflow bufferOverflow, int i10) {
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        if ((i10 & 4) != 0) {
            bufferOverflow = BufferOverflow.f5184a;
        }
        return a(i, i6, bufferOverflow);
    }

    public static final kotlinx.coroutines.flow.i c(Object obj) {
        if (obj == null) {
            obj = q9.b.b;
        }
        return new kotlinx.coroutines.flow.i(obj);
    }

    public static final void d(Object[] objArr, long j5, Object obj) {
        objArr[((int) j5) & (objArr.length - 1)] = obj;
    }

    public static final c e(n nVar, H7.h hVar, int i, BufferOverflow bufferOverflow) {
        return ((i == 0 || i == -3) && bufferOverflow == BufferOverflow.f5184a) ? nVar : new q9.d(nVar, hVar, i, bufferOverflow);
    }
}
