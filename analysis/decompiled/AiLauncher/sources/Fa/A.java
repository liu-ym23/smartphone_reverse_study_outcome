package Fa;

import Fa.f;

/* loaded from: classes5.dex */
public abstract class A implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2625a;

    public static final class a extends A {

        /* renamed from: b, reason: collision with root package name */
        public final int f2626b;

        public a(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("must have at least ");
            sb2.append(i10);
            sb2.append(" value parameter");
            sb2.append(i10 > 1 ? "s" : "");
            super(sb2.toString(), null);
            this.f2626b = i10;
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() >= this.f2626b;
        }
    }

    public static final class b extends A {

        /* renamed from: b, reason: collision with root package name */
        public final int f2627b;

        public b(int i10) {
            super("must have exactly " + i10 + " value parameters", null);
            this.f2627b = i10;
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() == this.f2627b;
        }
    }

    public static final class c extends A {

        /* renamed from: b, reason: collision with root package name */
        public static final c f2628b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().isEmpty();
        }
    }

    public static final class d extends A {

        /* renamed from: b, reason: collision with root package name */
        public static final d f2629b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() == 1;
        }
    }

    public /* synthetic */ A(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    @Override // Fa.f
    public /* bridge */ String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return f.a.a(this, eVar);
    }

    @Override // Fa.f
    public String getDescription() {
        return this.f2625a;
    }

    public A(String str) {
        this.f2625a = str;
    }
}
