package J9;

import K9.C0925f;
import La.D;
import com.fasterxml.jackson.core.JsonPointer;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* loaded from: classes5.dex */
public final class f implements kotlin.reflect.jvm.internal.impl.load.kotlin.f {

    /* renamed from: c, reason: collision with root package name */
    public static final a f3793c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f3794a;

    /* renamed from: b, reason: collision with root package name */
    public final KotlinClassHeader f3795b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final f a(Class<?> klass) {
            p.i(klass, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            c.f3791a.b(klass, aVar);
            KotlinClassHeader kotlinClassHeaderN = aVar.n();
            kotlin.jvm.internal.i iVar = null;
            if (kotlinClassHeaderN == null) {
                return null;
            }
            return new f(klass, kotlinClassHeaderN, iVar);
        }

        public a() {
        }
    }

    public /* synthetic */ f(Class cls, KotlinClassHeader kotlinClassHeader, kotlin.jvm.internal.i iVar) {
        this(cls, kotlinClassHeader);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public void a(f.d visitor, byte[] bArr) {
        p.i(visitor, "visitor");
        c.f3791a.i(this.f3794a, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public KotlinClassHeader b() {
        return this.f3795b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public void c(f.c visitor, byte[] bArr) {
        p.i(visitor, "visitor");
        c.f3791a.b(this.f3794a, visitor);
    }

    public final Class<?> d() {
        return this.f3794a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && p.d(this.f3794a, ((f) obj).f3794a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public String getLocation() {
        StringBuilder sb2 = new StringBuilder();
        String name = this.f3794a.getName();
        p.h(name, "getName(...)");
        sb2.append(D.S(name, '.', JsonPointer.SEPARATOR, false, 4, null));
        sb2.append(".class");
        return sb2.toString();
    }

    public int hashCode() {
        return this.f3794a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.f
    public ga.b j() {
        return C0925f.e(this.f3794a);
    }

    public String toString() {
        return f.class.getName() + ": " + this.f3794a;
    }

    public f(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.f3794a = cls;
        this.f3795b = kotlinClassHeader;
    }
}
