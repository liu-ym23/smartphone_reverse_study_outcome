package z3;

import java.util.function.Predicate;
import v3.C2057a;

/* loaded from: classes3.dex */
public final /* synthetic */ class H implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6943a;
    public final /* synthetic */ u3.f b;

    public /* synthetic */ H(u3.f fVar, int i) {
        this.f6943a = i;
        this.b = fVar;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        C2057a c2057a = (C2057a) obj;
        switch (this.f6943a) {
        }
        return c2057a.d.c(this.b.f.b);
    }
}
