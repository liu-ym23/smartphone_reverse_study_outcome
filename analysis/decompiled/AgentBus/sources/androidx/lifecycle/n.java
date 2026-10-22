package androidx.lifecycle;

/* loaded from: classes.dex */
public final class n {
    public static p a(q qVar) {
        q7.k.e(qVar, "state");
        int i2 = m.$EnumSwitchMapping$0[qVar.ordinal()];
        if (i2 == 1) {
            return p.ON_START;
        }
        if (i2 == 2) {
            return p.ON_RESUME;
        }
        if (i2 != 5) {
            return null;
        }
        return p.ON_CREATE;
    }
}
