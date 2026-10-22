package C8;

/* loaded from: classes4.dex */
public class d {
    public static d a() {
        return new d();
    }

    public String b(f fVar) {
        String strName = fVar.name();
        if ("br".equals(strName)) {
            return "\n";
        }
        if ("img".equals(strName)) {
            String str = fVar.d().get("alt");
            return (str == null || str.length() == 0) ? "￼" : str;
        }
        if ("iframe".equals(strName)) {
            return " ";
        }
        return null;
    }
}
