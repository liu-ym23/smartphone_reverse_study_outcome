package Fa;

import Fa.f;

/* loaded from: classes5.dex */
public abstract class k implements f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2652a;

    public static final class a extends k {

        /* renamed from: b, reason: collision with root package name */
        public static final a f2653b = new a();

        public a() {
            super("must be a member function", null);
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return functionDescriptor.H() != null;
        }
    }

    public static final class b extends k {

        /* renamed from: b, reason: collision with root package name */
        public static final b f2654b = new b();

        public b() {
            super("must be a member or an extension function", null);
        }

        @Override // Fa.f
        public boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.H() == null && functionDescriptor.K() == null) ? false : true;
        }
    }

    public /* synthetic */ k(String str, kotlin.jvm.internal.i iVar) {
        this(str);
    }

    @Override // Fa.f
    public /* bridge */ String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return f.a.a(this, eVar);
    }

    @Override // Fa.f
    public String getDescription() {
        return this.f2652a;
    }

    public k(String str) {
        this.f2652a = str;
    }
}
