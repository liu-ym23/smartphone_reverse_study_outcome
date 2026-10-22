package C8;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class n {

    public static class a extends n {
        @Override // C8.n
        public <T extends Appendable & CharSequence> void a(T t10, String str) throws IOException {
            int length;
            T t11 = t10;
            int length2 = t11.length();
            int length3 = str.length();
            boolean z10 = false;
            for (int i10 = 0; i10 < length3; i10++) {
                char cCharAt = str.charAt(i10);
                if (Character.isWhitespace(cCharAt)) {
                    z10 = true;
                } else {
                    if (z10 && (length = t11.length()) > 0 && !Character.isWhitespace(t11.charAt(length - 1))) {
                        C8.a.a(t10, ' ');
                    }
                    C8.a.a(t10, cCharAt);
                    z10 = false;
                }
            }
            if (!z10 || length2 >= t11.length()) {
                return;
            }
            C8.a.a(t10, ' ');
        }
    }

    public static n b() {
        return new a();
    }

    public abstract <T extends Appendable & CharSequence> void a(T t10, String str);
}
