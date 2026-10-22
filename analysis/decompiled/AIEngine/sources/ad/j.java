package ad;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends s {

    /* renamed from: c, reason: collision with root package name */
    public static final l f95c = bd.d.a("application/x-www-form-urlencoded");

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f96a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f97b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f98a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f99b = new ArrayList();

        public a(int i10) {
        }

        public final void a(String name, String value) {
            kotlin.jvm.internal.g.f(name, "name");
            kotlin.jvm.internal.g.f(value, "value");
            this.f98a.add(pd.a.b(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, 91));
            this.f99b.add(pd.a.b(value, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, 91));
        }
    }

    public j(ArrayList encodedNames, ArrayList encodedValues) {
        kotlin.jvm.internal.g.f(encodedNames, "encodedNames");
        kotlin.jvm.internal.g.f(encodedValues, "encodedValues");
        this.f96a = bd.l.l(encodedNames);
        this.f97b = bd.l.l(encodedValues);
    }

    public final long a(sd.g gVar, boolean z) throws EOFException {
        sd.e eVarC;
        if (z) {
            eVarC = new sd.e();
        } else {
            kotlin.jvm.internal.g.c(gVar);
            eVarC = gVar.c();
        }
        List<String> list = this.f96a;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                eVarC.O0(38);
            }
            eVarC.U0(list.get(i10));
            eVarC.O0(61);
            eVarC.U0(this.f97b.get(i10));
        }
        if (!z) {
            return 0L;
        }
        long j10 = eVarC.f11926b;
        eVarC.o();
        return j10;
    }

    @Override // ad.s
    public final long contentLength() {
        return a(null, true);
    }

    @Override // ad.s
    public final l contentType() {
        return f95c;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) throws EOFException {
        kotlin.jvm.internal.g.f(sink, "sink");
        a(sink, false);
    }
}
