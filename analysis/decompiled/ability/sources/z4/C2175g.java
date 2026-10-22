package z4;

import java.util.concurrent.ConcurrentHashMap;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.c0;

/* renamed from: z4.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2175g {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f6962a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap.KeySetView c = ConcurrentHashMap.newKeySet();
    public final Object d = new Object();

    public final void a(String str) {
        String string = str != null ? j9.m.R0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        synchronized (this.d) {
            c0 c0Var = (InterfaceC1723p) this.f6962a.remove(string);
            if (c0Var != null) {
                ((kotlinx.coroutines.c) c0Var).cancel(null);
            }
            this.b.remove(string);
            this.c.remove(string);
        }
    }

    public final C1724q b(String toolCallId) {
        C1724q c1724q;
        kotlin.jvm.internal.k.f(toolCallId, "toolCallId");
        String string = j9.m.R0(toolCallId).toString();
        synchronized (this.d) {
            try {
                Boolean bool = (Boolean) this.b.remove(string);
                if (bool != null) {
                    this.c.add(string);
                    c1724q = new C1724q();
                    c1724q.U(bool);
                } else {
                    this.c.remove(string);
                    C1724q c1724q2 = new C1724q();
                    InterfaceC1723p interfaceC1723p = (InterfaceC1723p) this.f6962a.put(string, c1724q2);
                    if (interfaceC1723p != null) {
                        ((C1724q) interfaceC1723p).U(Boolean.FALSE);
                    }
                    c1724q = c1724q2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1724q;
    }

    public final boolean c(String str, boolean z10) {
        String string = str != null ? j9.m.R0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        boolean z11 = false;
        if (string.length() == 0) {
            return false;
        }
        synchronized (this.d) {
            try {
                if (!this.c.contains(string)) {
                    InterfaceC1723p interfaceC1723p = (InterfaceC1723p) this.f6962a.remove(string);
                    if (interfaceC1723p != null) {
                        ((C1724q) interfaceC1723p).U(Boolean.valueOf(z10));
                        this.c.add(string);
                    } else if (this.b.putIfAbsent(string, Boolean.valueOf(z10)) == null) {
                    }
                    z11 = true;
                }
            } finally {
            }
        }
        return z11;
    }
}
