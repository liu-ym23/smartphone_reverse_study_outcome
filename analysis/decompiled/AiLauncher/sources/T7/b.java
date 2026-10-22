package T7;

/* loaded from: classes4.dex */
public class b implements a {
    @Override // T7.a
    public String a(S7.a aVar) {
        if (aVar == null) {
            return null;
        }
        String strA = aVar.a();
        String strB = aVar.b();
        Long lC = aVar.c();
        b(strA, strB, lC);
        return U7.a.a(strA + strB + lC);
    }

    public final void b(String str, String str2, Long l10) {
        if (str == null || str.trim().equals("")) {
            throw new RuntimeException("appId不能为空！");
        }
        if (str2 == null || str2.trim().equals("")) {
            throw new RuntimeException("appSecret不能为空！");
        }
        if (l10 == null) {
            throw new RuntimeException("reqTime不能为空！");
        }
    }
}
