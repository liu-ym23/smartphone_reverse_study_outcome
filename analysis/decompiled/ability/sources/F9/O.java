package F9;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class O extends P {
    public final /* synthetic */ int b;
    public final long c;
    public final Object d;
    public final V9.i e;

    public /* synthetic */ O(Object obj, long j5, V9.i iVar, int i) {
        this.b = i;
        this.d = obj;
        this.c = j5;
        this.e = iVar;
    }

    @Override // F9.P
    public final long b() {
        switch (this.b) {
        }
        return this.c;
    }

    @Override // F9.P
    public final B c() {
        int i = this.b;
        Object obj = this.d;
        switch (i) {
            case 0:
                return (B) obj;
            default:
                String str = (String) obj;
                if (str == null) {
                    return null;
                }
                Pattern pattern = B.e;
                return AbstractC0226d.j(str);
        }
    }

    @Override // F9.P
    public final V9.i f() {
        switch (this.b) {
            case 0:
                return (V9.g) this.e;
            default:
                return (V9.r) this.e;
        }
    }
}
