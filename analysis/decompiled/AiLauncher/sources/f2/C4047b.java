package f2;

import android.content.Context;
import n2.InterfaceC4936a;

/* renamed from: f2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4047b extends AbstractC4051f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32534a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4936a f32535b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4936a f32536c;

    /* renamed from: d, reason: collision with root package name */
    public final String f32537d;

    public C4047b(Context context, InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f32534a = context;
        if (interfaceC4936a == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f32535b = interfaceC4936a;
        if (interfaceC4936a2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f32536c = interfaceC4936a2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f32537d = str;
    }

    @Override // f2.AbstractC4051f
    public Context b() {
        return this.f32534a;
    }

    @Override // f2.AbstractC4051f
    public String c() {
        return this.f32537d;
    }

    @Override // f2.AbstractC4051f
    public InterfaceC4936a d() {
        return this.f32536c;
    }

    @Override // f2.AbstractC4051f
    public InterfaceC4936a e() {
        return this.f32535b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC4051f) {
            AbstractC4051f abstractC4051f = (AbstractC4051f) obj;
            if (this.f32534a.equals(abstractC4051f.b()) && this.f32535b.equals(abstractC4051f.e()) && this.f32536c.equals(abstractC4051f.d()) && this.f32537d.equals(abstractC4051f.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f32537d.hashCode() ^ ((((((this.f32534a.hashCode() ^ 1000003) * 1000003) ^ this.f32535b.hashCode()) * 1000003) ^ this.f32536c.hashCode()) * 1000003);
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f32534a + ", wallClock=" + this.f32535b + ", monotonicClock=" + this.f32536c + ", backendName=" + this.f32537d + "}";
    }
}
