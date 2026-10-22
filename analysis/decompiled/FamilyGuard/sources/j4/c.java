package j4;

import java.io.Serializable;
import p4.InterfaceC0928a;
import p4.InterfaceC0930c;

/* loaded from: classes.dex */
public abstract class c implements InterfaceC0928a, Serializable {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f17816g = a.f17823a;

    /* renamed from: a, reason: collision with root package name */
    private transient InterfaceC0928a f17817a;

    /* renamed from: b, reason: collision with root package name */
    protected final Object f17818b;

    /* renamed from: c, reason: collision with root package name */
    private final Class f17819c;

    /* renamed from: d, reason: collision with root package name */
    private final String f17820d;

    /* renamed from: e, reason: collision with root package name */
    private final String f17821e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f17822f;

    private static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f17823a = new a();

        private a() {
        }
    }

    public c() {
        this(f17816g);
    }

    public InterfaceC0928a b() {
        InterfaceC0928a interfaceC0928a = this.f17817a;
        if (interfaceC0928a != null) {
            return interfaceC0928a;
        }
        InterfaceC0928a interfaceC0928aD = d();
        this.f17817a = interfaceC0928aD;
        return interfaceC0928aD;
    }

    protected abstract InterfaceC0928a d();

    public Object e() {
        return this.f17818b;
    }

    public String f() {
        return this.f17820d;
    }

    public InterfaceC0930c g() {
        Class cls = this.f17819c;
        if (cls == null) {
            return null;
        }
        return this.f17822f ? w.c(cls) : w.b(cls);
    }

    protected InterfaceC0928a h() {
        InterfaceC0928a interfaceC0928aB = b();
        if (interfaceC0928aB != this) {
            return interfaceC0928aB;
        }
        throw new h4.b();
    }

    public String i() {
        return this.f17821e;
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z5) {
        this.f17818b = obj;
        this.f17819c = cls;
        this.f17820d = str;
        this.f17821e = str2;
        this.f17822f = z5;
    }
}
