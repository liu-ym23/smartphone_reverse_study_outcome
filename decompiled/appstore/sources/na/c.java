package na;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    public static class a extends StringWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22435b;

        public a() {
            this.f22434a = 0;
            this.f22435b = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public void write(String r10, int r11, int r12) {
            if (this.f22435b == false) goto L5;
            return;
        L5:
            int r13 = this.f22434a;
            if ((r13 + r12) <= 4000) goto L9;
            this.f22435b = true;
            return;
        L9:
            this.f22434a = r13 + r12;
            super.write(r10, r11, r12);
        }
    }

    public static String a(Throwable r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        Throwable r11 = r10;
    L6:
        if (r11 == null) goto L12;
        if ((r11 instanceof UnknownHostException) == true) goto L9;
        r11 = r11.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r12 = new a();
        PrintWriter r13 = new PrintWriter(r12);
        r10.printStackTrace(r13);     // Catch: Throwable -> L16
    L14:
        r13.flush();
        return r12.toString();
    }
}
