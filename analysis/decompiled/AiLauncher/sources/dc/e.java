package dc;

import java.io.IOException;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Appendable f32174a;

    /* renamed from: b, reason: collision with root package name */
    public char f32175b;

    public e(Appendable appendable) {
        this.f32174a = appendable;
    }

    public final void a(char c10) throws IOException {
        try {
            this.f32174a.append(c10);
            this.f32175b = c10;
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final void b(String str) throws IOException {
        try {
            this.f32174a.append(str);
            int length = str.length();
            if (length != 0) {
                this.f32175b = str.charAt(length - 1);
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void c() throws IOException {
        char c10 = this.f32175b;
        if (c10 == 0 || c10 == ':') {
            return;
        }
        a(':');
    }

    public void d() throws IOException {
        char c10 = this.f32175b;
        if (c10 == 0 || c10 == '\n') {
            return;
        }
        a('\n');
    }

    public void e() throws IOException {
        char c10 = this.f32175b;
        if (c10 == 0 || c10 == ' ') {
            return;
        }
        a(' ');
    }

    public void f(char c10) throws IOException {
        a(c10);
    }

    public void g(String str) throws IOException {
        b(str);
    }

    public void h(String str) throws IOException {
        b(str.replaceAll("[\\r\\n\\s]+", " "));
    }
}
