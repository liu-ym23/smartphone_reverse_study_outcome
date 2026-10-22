package l2;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f21813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set f21814b;

    public a(Set r10, Set r11) {
        this.f21813a = r10;
        this.f21814b = r11;
    }

    public boolean a(String r10) {
        Set r11 = this.f21814b;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.contains(r10) == false) goto L7;
        return true;
    }

    public boolean b(String r10) {
        Set r11 = this.f21813a;
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.contains(r10) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.f21813a + ", sampledLogType=" + this.f21814b + '}';
    }
}
