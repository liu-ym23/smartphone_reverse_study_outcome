package F9;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class u extends K {
    public static final B c;

    /* renamed from: a, reason: collision with root package name */
    public final List f655a;
    public final List b;

    static {
        Pattern pattern = B.e;
        c = AbstractC0226d.g("application/x-www-form-urlencoded");
    }

    public u(ArrayList encodedNames, ArrayList encodedValues) {
        kotlin.jvm.internal.k.f(encodedNames, "encodedNames");
        kotlin.jvm.internal.k.f(encodedValues, "encodedValues");
        this.f655a = G9.b.w(encodedNames);
        this.b = G9.b.w(encodedValues);
    }

    public final long b(V9.h hVar, boolean z10) throws EOFException {
        V9.g gVarA;
        if (z10) {
            gVarA = new V9.g();
        } else {
            kotlin.jvm.internal.k.c(hVar);
            gVarA = hVar.a();
        }
        List list = this.f655a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                gVarA.L(38);
            }
            gVarA.R((String) list.get(i));
            gVarA.L(61);
            gVarA.R((String) this.b.get(i));
        }
        if (!z10) {
            return 0L;
        }
        long j5 = gVarA.b;
        gVarA.b();
        return j5;
    }

    @Override // F9.K
    public final long contentLength() {
        return b(null, true);
    }

    @Override // F9.K
    public final B contentType() {
        return c;
    }

    @Override // F9.K
    public final void writeTo(V9.h sink) throws EOFException {
        kotlin.jvm.internal.k.f(sink, "sink");
        b(sink, false);
    }
}
