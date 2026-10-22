package tc;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class y extends r0 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f13068l;

    public y(String str, z zVar) {
        super(str, zVar, 1);
        this.f13068l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, lb.d] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object, lb.d] */
    @Override // tc.r0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            rc.e eVar = (rc.e) obj;
            if (this.f13038a.equals(eVar.i())) {
                y yVar = (y) obj;
                if (yVar.f13068l && Arrays.equals((rc.e[]) this.f13046j.getValue(), (rc.e[]) yVar.f13046j.getValue())) {
                    int iE = eVar.e();
                    int i10 = this.f13040c;
                    if (i10 == iE) {
                        for (int i11 = 0; i11 < i10; i11++) {
                            if (kotlin.jvm.internal.g.b(h(i11).i(), eVar.h(i11).i()) && kotlin.jvm.internal.g.b(h(i11).d(), eVar.h(i11).d())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // tc.r0
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // tc.r0, rc.e
    public final boolean isInline() {
        return this.f13068l;
    }
}
