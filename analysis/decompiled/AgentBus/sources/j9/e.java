package j9;

import f8.z;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e extends o {
    @Override // j9.g
    public final v9.v a(z zVar) {
        q7.k.e(zVar, "module");
        c8.h hVarN = zVar.n();
        hVarN.getClass();
        return hVarN.s(c8.j.CHAR);
    }

    @Override // j9.g
    public final String toString() {
        String strValueOf;
        Object obj = this.f5408a;
        Integer numValueOf = Integer.valueOf(((Character) obj).charValue());
        char cCharValue = ((Character) obj).charValue();
        if (cCharValue == '\b') {
            strValueOf = "\\b";
        } else if (cCharValue == '\t') {
            strValueOf = "\\t";
        } else if (cCharValue == '\n') {
            strValueOf = "\\n";
        } else if (cCharValue == '\f') {
            strValueOf = "\\f";
        } else if (cCharValue == '\r') {
            strValueOf = "\\r";
        } else {
            byte type = (byte) Character.getType(cCharValue);
            strValueOf = (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? "?" : String.valueOf(cCharValue);
        }
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{numValueOf, strValueOf}, 2));
    }
}
