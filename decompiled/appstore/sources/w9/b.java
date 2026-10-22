package w9;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f25394c;

    public b(boolean r10, String r11, HashMap r12) {
        this.f25392a = r10;
        this.f25393b = r11;
        this.f25394c = r12;
    }

    public static b a(boolean r10, String r11, HashMap r12) {
        return new b(r10, r11, r12);
    }

    public String b() {
        return this.f25393b;
    }

    public HashMap c() {
        return this.f25394c;
    }

    public boolean d() {
        return this.f25392a;
    }
}
