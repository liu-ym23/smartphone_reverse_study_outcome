package h2;

import h2.s;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q extends s {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends s.a<a, q> {
        @Override // h2.s.a
        public final s b() {
            q2.p pVar = this.f9287b;
            if (pVar.f11520q) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new q(this.f9286a, pVar, this.f9288c);
        }
    }
}
