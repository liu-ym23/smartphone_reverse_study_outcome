package H8;

/* loaded from: classes4.dex */
public abstract class a {

    public static class b extends a {
        public b() {
        }

        @Override // H8.a
        public String b(String str) {
            return str;
        }
    }

    public static a a() {
        return new b();
    }

    public abstract String b(String str);
}
