package ma;

import E9.InterfaceC0819y;
import java.util.Arrays;
import ya.AbstractC5990d0;

/* renamed from: ma.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4925e extends q<Character> {
    public C4925e(char c10) {
        super(Character.valueOf(c10));
    }

    public final String c(char c10) {
        switch (c10) {
            case '\b':
                return "\\b";
            case '\t':
                return "\\t";
            case '\n':
                return "\\n";
            case 11:
            default:
                return e(c10) ? String.valueOf(c10) : "?";
            case '\f':
                return "\\f";
            case '\r':
                return "\\r";
        }
    }

    @Override // ma.AbstractC4927g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 a(InterfaceC0819y module) {
        kotlin.jvm.internal.p.i(module, "module");
        AbstractC5990d0 abstractC5990d0V = module.g().v();
        kotlin.jvm.internal.p.h(abstractC5990d0V, "getCharType(...)");
        return abstractC5990d0V;
    }

    public final boolean e(char c10) {
        byte type = (byte) Character.getType(c10);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // ma.AbstractC4927g
    public String toString() {
        String str = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(b().charValue()), c(b().charValue())}, 2));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }
}
