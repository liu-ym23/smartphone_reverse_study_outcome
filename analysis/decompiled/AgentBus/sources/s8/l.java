package s8;

/* loaded from: classes.dex */
public final /* synthetic */ class l extends q7.h implements p7.k {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f9580n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i2, int i10, Object obj) {
        super(i2, obj);
        this.f9580n = i10;
    }

    @Override // q7.c
    public final String A() {
        switch (this.f9580n) {
            case 0:
                return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            case 1:
                return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
            default:
                return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }
    }

    @Override // q7.c, w7.c
    public final String getName() {
        switch (this.f9580n) {
            case 0:
                return "searchMethodsByNameWithoutBuiltinMagic";
            case 1:
                return "searchMethodsInSupertypesWithoutBuiltinMagic";
            default:
                return "<init>";
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f9580n) {
            case 0:
                e9.f fVar = (e9.f) obj;
                q7.k.e(fVar, "p0");
                return p.v((p) this.f8801g, fVar);
            case 1:
                e9.f fVar2 = (e9.f) obj;
                q7.k.e(fVar2, "p0");
                return p.w((p) this.f8801g, fVar2);
            default:
                w9.g gVar = (w9.g) obj;
                q7.k.e(gVar, "p0");
                return new t9.f((t9.i) this.f8801g, gVar);
        }
    }

    @Override // q7.c
    public final w7.f y() {
        switch (this.f9580n) {
            case 0:
                return q7.w.f8821a.b(p.class);
            case 1:
                return q7.w.f8821a.b(p.class);
            default:
                return q7.w.f8821a.b(t9.f.class);
        }
    }
}
