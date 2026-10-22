package C8;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class a {
    public static void a(Appendable appendable, char c10) throws IOException {
        try {
            appendable.append(c10);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void b(Appendable appendable, CharSequence charSequence) throws IOException {
        try {
            appendable.append(charSequence);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
