package Ua;

import Za.C1192l;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0005¢\u0006\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"LUa/A0;", "LUa/I;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "parallelism", "name", "s1", "(ILjava/lang/String;)LUa/I;", "v1", "u1", "()LUa/A0;", "immediate", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class A0 extends I {
    @Override // Ua.I
    public I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return C1192l.b(this, name);
    }

    @Override // Ua.I
    public String toString() {
        String strV1 = v1();
        if (strV1 != null) {
            return strV1;
        }
        return N.a(this) + '@' + N.b(this);
    }

    public abstract A0 u1();

    public final String v1() {
        A0 a0U1;
        A0 a0C = Y.c();
        if (this == a0C) {
            return "Dispatchers.Main";
        }
        try {
            a0U1 = a0C.u1();
        } catch (UnsupportedOperationException unused) {
            a0U1 = null;
        }
        if (this == a0U1) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
