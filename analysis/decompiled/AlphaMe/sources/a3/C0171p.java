package a3;

import androidx.fragment.app.A;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* renamed from: a3.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0171p extends C0160e {

    /* renamed from: l, reason: collision with root package name */
    public final int f2318l;

    public C0171p(int i4, int i5, Function1 function1) {
        super(i4, function1);
        this.f2318l = i5;
        if (i5 != 1) {
            if (i4 < 1) {
                throw new IllegalArgumentException(B0.g.j("Buffered channel capacity must be at least 1, but ", i4, " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(C0160e.class).getSimpleName() + " instead").toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.lang.Object r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.C0171p.L(java.lang.Object, boolean):java.lang.Object");
    }

    @Override // a3.C0160e, a3.w
    public final Object f(IndexedValue indexedValue, c3.f fVar) throws Throwable {
        A aI;
        Object objL = L(indexedValue, true);
        boolean z4 = objL instanceof C0166k;
        if (!z4) {
            return Unit.INSTANCE;
        }
        if (z4) {
        }
        Function1 function1 = this.f2288b;
        if (function1 == null || (aI = com.stepos.statsrpk.c.i(function1, indexedValue, null)) == null) {
            throw u();
        }
        ExceptionsKt.addSuppressed(aI, u());
        throw aI;
    }

    @Override // a3.C0160e, a3.w
    public final Object l(Object obj) {
        return L(obj, false);
    }

    @Override // a3.C0160e
    public final boolean z() {
        return this.f2318l == 2;
    }
}
