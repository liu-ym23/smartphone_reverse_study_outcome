package y5;

import d6.d;
import d6.h;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends w5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w5.c f26129b;

    public c(String r10, w5.c r11) {
        this.f26128a = r10;
        this.f26129b = r11;
    }

    public void a() {
        Class<?> r10 = Class.forName("android.os.ServiceManager");     // Catch: Exception -> L10
        Object r11 = d.c(r10, "getService", new Object[]{this.f26128a});     // Catch: Exception -> L10
        if (r11 == null) goto L13;
        Object r12 = d6.a.d(r10, "sCache");     // Catch: Exception -> L10
        if (r12 != null) goto L7;
        return;
    L7:
        if ((r12 instanceof Map) == false) goto L15;
        this.f26129b.h(r11);     // Catch: Exception -> L10
        ((Map) r12).put(this.f26128a, h.a(r11, this.f26129b));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    }
}
