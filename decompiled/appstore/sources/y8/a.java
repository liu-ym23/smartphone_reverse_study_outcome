package y8;

import com.android.volley.VolleyError;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: y8.a$a, reason: collision with other inner class name */
    public static class C0414a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f26134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f26135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final VolleyError f26136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f26137e;

        public C0414a(int r10, Map r11, String r12) {
            this(r10, r11, r12, null);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("Response{StatusCode=" + this.f26133a + "\t");
            r10.append("Headers=" + this.f26134b + "\t");
            r10.append("Body=" + this.f26135c + "\t");
            r10.append("Error=" + this.f26136d + "}");
            return r10.toString();
        }

        public C0414a(int r10, Map r11, String r12, String r13) {
            this.f26133a = r10;
            this.f26134b = r11;
            this.f26135c = r12;
            this.f26136d = null;
            this.f26137e = r13;
        }

        public C0414a(int r10, Map r11, VolleyError r12) {
            this.f26133a = r10;
            this.f26134b = r11;
            this.f26135c = null;
            this.f26136d = r12;
            this.f26137e = null;
        }

        public C0414a(VolleyError r10) {
            this.f26133a = 0;
            this.f26134b = null;
            this.f26135c = null;
            this.f26136d = r10;
            this.f26137e = null;
        }
    }

    public a() {
    }

    public abstract void a(C0414a r10);

    public abstract void b(C0414a r10);

    public abstract void c(C0414a r10);
}
