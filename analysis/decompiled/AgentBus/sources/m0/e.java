package m0;

import d7.h0;
import java.util.List;
import q7.k;

/* loaded from: classes.dex */
public final class e extends RuntimeException {

    /* renamed from: f, reason: collision with root package name */
    public final List f6126f;

    public e(List list) {
        this.f6126f = list;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb2 = new StringBuilder("Composition stack when thrown:\n");
        e7.c cVarM = a.a.m();
        List list = this.f6126f;
        k.e(list, "<this>");
        h0 h0Var = new h0(list);
        if (h0Var.a() > 0) {
            ((b) h0Var.get(0)).getClass();
            throw null;
        }
        e7.c cVarE = a.a.e(cVarM);
        k.e(cVarE, "<this>");
        h0 h0Var2 = new h0(cVarE);
        int iA = h0Var2.a();
        for (int i2 = 0; i2 < iA; i2++) {
            sb2.append("\tat " + ((String) h0Var2.get(i2)));
            sb2.append('\n');
        }
        String string = sb2.toString();
        k.d(string, "toString(...)");
        return string;
    }
}
