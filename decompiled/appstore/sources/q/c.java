package q;

import android.util.Base64;
import androidx.core.util.e;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f23473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23475f;

    public c(String r10, String r11, String r12, List r13) {
        this.f23470a = (String) e.g(r10);
        this.f23471b = (String) e.g(r11);
        this.f23472c = (String) e.g(r12);
        this.f23473d = (List) e.g(r13);
        this.f23474e = 0;
        this.f23475f = a(r10, r11, r12);
    }

    public final String a(String r10, String r11, String r12) {
        return r10 + "-" + r11 + "-" + r12;
    }

    public List b() {
        return this.f23473d;
    }

    public int c() {
        return this.f23474e;
    }

    public String d() {
        return this.f23475f;
    }

    public String e() {
        return this.f23470a;
    }

    public String f() {
        return this.f23471b;
    }

    public String g() {
        return this.f23472c;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("FontRequest {mProviderAuthority: " + this.f23470a + ", mProviderPackage: " + this.f23471b + ", mQuery: " + this.f23472c + ", mCertificates:");
        int r11 = 0;
    L4:
        if (r11 >= this.f23473d.size()) goto L10;
        r10.append(" [");
        List r12 = (List) this.f23473d.get(r11);
        int r13 = 0;
    L7:
        if (r13 >= r12.size()) goto L9;
        r10.append(" \"");
        r10.append(Base64.encodeToString((byte[]) r12.get(r13), 0));
        r10.append("\"");
        r13 = r13 + 1;
        goto L7
    L9:
        r10.append(" ]");
        r11 = r11 + 1;
        goto L4
    L10:
        r10.append("}");
        r10.append("mCertificatesArray: " + this.f23474e);
        return r10.toString();
    }
}
