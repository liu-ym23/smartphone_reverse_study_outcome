package da;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f19138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f19139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f19144g;

    public b(long r10, boolean r11, String r12, HashMap r13) {
        this.f19141d = 2;
        this.f19142e = "no error";
        this.f19143f = 0;
        this.f19144g = null;
        this.f19138a = r10;
        this.f19139b = r11;
        this.f19140c = r12;
        this.f19143f = System.currentTimeMillis();
        this.f19144g = r13;
    }

    public int a() {
        return this.f19141d;
    }

    public String b() {
        return this.f19140c;
    }

    public String c() {
        return this.f19142e;
    }

    public long d() {
        return this.f19138a;
    }

    public long e() {
        return this.f19143f;
    }

    public HashMap f() {
        return this.f19144g;
    }

    public boolean g() {
        return this.f19139b;
    }

    public void h(int r10) {
        this.f19141d = r10;
    }

    public void i(String r10) {
        this.f19142e = r10;
    }

    public String toString() {
        return "UploadInfo{lastUploadTime=" + this.f19138a + ", isUploading=" + this.f19139b + ", commandId='" + this.f19140c + "', cloudMsgResponseCode=" + this.f19141d + ", errorMsg='" + this.f19142e + "', operateTime=" + this.f19143f + ", specificParams=" + this.f19144g + '}';
    }
}
