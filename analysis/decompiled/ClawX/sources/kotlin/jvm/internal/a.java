package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a implements l, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public a(int i8, Class cls, String str) {
        this(i8, e.NO_RECEIVER, cls, "<init>", str, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.isTopLevel == aVar.isTopLevel && this.arity == aVar.arity && this.flags == aVar.flags && p.a(this.receiver, aVar.receiver) && p.a(this.owner, aVar.owner) && this.name.equals(aVar.name) && this.signature.equals(aVar.signature);
    }

    @Override // kotlin.jvm.internal.l
    public int getArity() {
        return this.arity;
    }

    public v5.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return z.a(cls);
        }
        z.f3687a.getClass();
        return new s(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((a8.b.f(a8.b.f((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31, 31, this.name), 31, this.signature) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        z.f3687a.getClass();
        return a0.a(this);
    }

    public a(int i8, Object obj, Class cls, String str, String str2, int i9) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = false;
        this.arity = i8;
        this.flags = i9 >> 1;
    }
}
