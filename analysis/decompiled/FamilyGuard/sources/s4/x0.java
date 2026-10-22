package s4;

/* loaded from: classes.dex */
public abstract class x0 extends AbstractC1056E {
    public abstract x0 h0();

    protected final String j0() {
        x0 x0VarH0;
        x0 x0VarC = W.c();
        if (this == x0VarC) {
            return "Dispatchers.Main";
        }
        try {
            x0VarH0 = x0VarC.h0();
        } catch (UnsupportedOperationException unused) {
            x0VarH0 = null;
        }
        if (this == x0VarH0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // s4.AbstractC1056E
    public String toString() {
        String strJ0 = j0();
        if (strJ0 != null) {
            return strJ0;
        }
        return M.a(this) + '@' + M.b(this);
    }
}
