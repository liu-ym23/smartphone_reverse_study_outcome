package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import l0.C0823b;
import o0.C0888a;

/* renamed from: q0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0960g implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0960g f19850a = new C0960g();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        if (obj instanceof AtomicInteger) {
            e0Var.V(((AtomicInteger) obj).get());
            return;
        }
        if (obj instanceof AtomicLong) {
            e0Var.X(((AtomicLong) obj).get());
            return;
        }
        if (obj instanceof AtomicBoolean) {
            e0Var.append(((AtomicBoolean) obj).get() ? "true" : "false");
            return;
        }
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        if (obj instanceof AtomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            int length = atomicIntegerArray.length();
            e0Var.write(91);
            while (i6 < length) {
                int i7 = atomicIntegerArray.get(i6);
                if (i6 != 0) {
                    e0Var.write(44);
                }
                e0Var.V(i7);
                i6++;
            }
            e0Var.write(93);
            return;
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length2 = atomicLongArray.length();
        e0Var.write(91);
        while (i6 < length2) {
            long j5 = atomicLongArray.get(i6);
            if (i6 != 0) {
                e0Var.write(44);
            }
            e0Var.X(j5);
            i6++;
        }
        e0Var.write(93);
    }

    @Override // p0.t
    public int d() {
        return 14;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.util.concurrent.atomic.AtomicIntegerArray] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        if (c0888a.f18948f.U() == 8) {
            c0888a.f18948f.A(16);
            return null;
        }
        C0823b c0823b = new C0823b();
        c0888a.Y(c0823b);
        int i5 = 0;
        if (type == AtomicIntegerArray.class) {
            ?? r32 = (T) new AtomicIntegerArray(c0823b.size());
            while (i5 < c0823b.size()) {
                r32.set(i5, c0823b.M(i5).intValue());
                i5++;
            }
            return r32;
        }
        ?? r33 = (T) new AtomicLongArray(c0823b.size());
        while (i5 < c0823b.size()) {
            r33.set(i5, c0823b.N(i5).longValue());
            i5++;
        }
        return r33;
    }
}
