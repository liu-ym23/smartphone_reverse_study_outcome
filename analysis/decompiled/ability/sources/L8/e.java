package L8;

import h8.InterfaceC1540w;
import java.util.Arrays;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* loaded from: classes4.dex */
public final class e extends o {
    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        kotlin.jvm.internal.k.f(module, "module");
        e8.i iVarC = module.c();
        iVarC.getClass();
        return iVarC.s(PrimitiveType.g);
    }

    @Override // L8.g
    public final String toString() {
        String strValueOf;
        Object obj = this.f939a;
        Integer numValueOf = Integer.valueOf(((Character) obj).charValue());
        char cCharValue = ((Character) obj).charValue();
        switch (cCharValue) {
            case '\b':
                strValueOf = "\\b";
                break;
            case '\t':
                strValueOf = "\\t";
                break;
            case '\n':
                strValueOf = "\\n";
                break;
            case 11:
            default:
                byte type = (byte) Character.getType(cCharValue);
                if (type != 0 && type != 13 && type != 14 && type != 15 && type != 16 && type != 18 && type != 19) {
                    strValueOf = String.valueOf(cCharValue);
                    break;
                } else {
                    strValueOf = "?";
                    break;
                }
            case '\f':
                strValueOf = "\\f";
                break;
            case '\r':
                strValueOf = "\\r";
                break;
        }
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{numValueOf, strValueOf}, 2));
    }
}
