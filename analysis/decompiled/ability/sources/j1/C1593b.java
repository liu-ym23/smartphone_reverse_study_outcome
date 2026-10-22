package j1;

import com.bytedance.services.slardar.config.IConfigManager;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: j1.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1593b {
    public static volatile C1593b e;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4753a;
    public CopyOnWriteArrayList b;
    public JSONObject c;
    public volatile boolean d;

    public static C1593b a() {
        if (e == null) {
            synchronized (C1593b.class) {
                try {
                    if (e == null) {
                        C1593b c1593b = new C1593b();
                        c1593b.f4753a = false;
                        e = c1593b;
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public final void b(c cVar) {
        if (this.b == null) {
            this.b = new CopyOnWriteArrayList();
        }
        if (!this.b.contains(cVar)) {
            this.b.add(cVar);
        }
        if (this.d) {
            cVar.c(this.c);
        }
    }

    public final synchronized void c() {
        if (this.f4753a) {
            return;
        }
        this.f4753a = true;
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerConfigListener(new C1592a(this, 0));
    }
}
