package ua;

import ea.C4018b;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* renamed from: ua.N, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5604N {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4020d f42554a;

    /* renamed from: b, reason: collision with root package name */
    public final ea.h f42555b;

    /* renamed from: c, reason: collision with root package name */
    public final E9.W f42556c;

    /* renamed from: ua.N$a */
    public static final class a extends AbstractC5604N {

        /* renamed from: d, reason: collision with root package name */
        public final ProtoBuf$Class f42557d;

        /* renamed from: e, reason: collision with root package name */
        public final a f42558e;

        /* renamed from: f, reason: collision with root package name */
        public final ga.b f42559f;

        /* renamed from: g, reason: collision with root package name */
        public final ProtoBuf$Class.Kind f42560g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f42561h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f42562i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ProtoBuf$Class classProto, InterfaceC4020d nameResolver, ea.h typeTable, E9.W w10, a aVar) {
            super(nameResolver, typeTable, w10, null);
            kotlin.jvm.internal.p.i(classProto, "classProto");
            kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
            kotlin.jvm.internal.p.i(typeTable, "typeTable");
            this.f42557d = classProto;
            this.f42558e = aVar;
            this.f42559f = C5602L.a(nameResolver, classProto.H0());
            ProtoBuf$Class.Kind kindD = C4018b.f32379f.d(classProto.G0());
            this.f42560g = kindD == null ? ProtoBuf$Class.Kind.CLASS : kindD;
            Boolean boolD = C4018b.f32380g.d(classProto.G0());
            kotlin.jvm.internal.p.h(boolD, "get(...)");
            this.f42561h = boolD.booleanValue();
            Boolean boolD2 = C4018b.f32381h.d(classProto.G0());
            kotlin.jvm.internal.p.h(boolD2, "get(...)");
            this.f42562i = boolD2.booleanValue();
        }

        @Override // ua.AbstractC5604N
        public ga.c a() {
            return this.f42559f.a();
        }

        public final ga.b e() {
            return this.f42559f;
        }

        public final ProtoBuf$Class f() {
            return this.f42557d;
        }

        public final ProtoBuf$Class.Kind g() {
            return this.f42560g;
        }

        public final a h() {
            return this.f42558e;
        }

        public final boolean i() {
            return this.f42561h;
        }
    }

    /* renamed from: ua.N$b */
    public static final class b extends AbstractC5604N {

        /* renamed from: d, reason: collision with root package name */
        public final ga.c f42563d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ga.c fqName, InterfaceC4020d nameResolver, ea.h typeTable, E9.W w10) {
            super(nameResolver, typeTable, w10, null);
            kotlin.jvm.internal.p.i(fqName, "fqName");
            kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
            kotlin.jvm.internal.p.i(typeTable, "typeTable");
            this.f42563d = fqName;
        }

        @Override // ua.AbstractC5604N
        public ga.c a() {
            return this.f42563d;
        }
    }

    public /* synthetic */ AbstractC5604N(InterfaceC4020d interfaceC4020d, ea.h hVar, E9.W w10, kotlin.jvm.internal.i iVar) {
        this(interfaceC4020d, hVar, w10);
    }

    public abstract ga.c a();

    public final InterfaceC4020d b() {
        return this.f42554a;
    }

    public final E9.W c() {
        return this.f42556c;
    }

    public final ea.h d() {
        return this.f42555b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }

    public AbstractC5604N(InterfaceC4020d interfaceC4020d, ea.h hVar, E9.W w10) {
        this.f42554a = interfaceC4020d;
        this.f42555b = hVar;
        this.f42556c = w10;
    }
}
