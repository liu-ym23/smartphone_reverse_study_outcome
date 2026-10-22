package p7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class h0 extends m7.n {
    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() == u7.b.f14169m) {
            aVar.U();
            return null;
        }
        String strW = aVar.W();
        if (strW.length() == 1) {
            return Character.valueOf(strW.charAt(0));
        }
        StringBuilder sbO = androidx.activity.b.o("Expecting character, got: ", strW, "; at ");
        sbO.append(aVar.F());
        throw new m7.h(sbO.toString());
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        Character ch = (Character) obj;
        cVar.S(ch == null ? null : String.valueOf(ch));
    }
}
