package nb;

import La.H;
import Y8.t;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4960m;
import p9.InterfaceC5074l;
import pb.Q0;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\r\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001aI\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000f2\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u00032\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "serialName", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameters", "Lkotlin/Function1;", "Lnb/a;", "LY8/t;", "builderAction", Const.INTENT_KEY_UMID, "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lp9/l;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lnb/e;", "kind", "c", "(Ljava/lang/String;Lnb/e;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lnb/l;", "builder", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lnb/l;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lp9/l;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: nb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4958k {
    public static final SerialDescriptor c(String serialName, AbstractC4952e kind) {
        p.i(serialName, "serialName");
        p.i(kind, "kind");
        if (H.x0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return Q0.a(serialName, kind);
    }

    public static final SerialDescriptor d(String serialName, SerialDescriptor[] typeParameters, InterfaceC5074l<? super C4948a, t> builderAction) {
        p.i(serialName, "serialName");
        p.i(typeParameters, "typeParameters");
        p.i(builderAction, "builderAction");
        if (H.x0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        C4948a c4948a = new C4948a(serialName);
        builderAction.invoke(c4948a);
        return new C4954g(serialName, AbstractC4960m.a.f37293a, c4948a.f().size(), r.T0(typeParameters), c4948a);
    }

    public static /* synthetic */ SerialDescriptor e(String str, SerialDescriptor[] serialDescriptorArr, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: nb.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return C4958k.f((C4948a) obj2);
                }
            };
        }
        return d(str, serialDescriptorArr, interfaceC5074l);
    }

    public static final t f(C4948a c4948a) {
        p.i(c4948a, "<this>");
        return t.f7040a;
    }

    public static final SerialDescriptor g(String serialName, AbstractC4959l kind, SerialDescriptor[] typeParameters, InterfaceC5074l<? super C4948a, t> builder) {
        p.i(serialName, "serialName");
        p.i(kind, "kind");
        p.i(typeParameters, "typeParameters");
        p.i(builder, "builder");
        if (H.x0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (p.d(kind, AbstractC4960m.a.f37293a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        C4948a c4948a = new C4948a(serialName);
        builder.invoke(c4948a);
        return new C4954g(serialName, kind, c4948a.f().size(), r.T0(typeParameters), c4948a);
    }

    public static /* synthetic */ SerialDescriptor h(String str, AbstractC4959l abstractC4959l, SerialDescriptor[] serialDescriptorArr, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            interfaceC5074l = new InterfaceC5074l() { // from class: nb.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return C4958k.i((C4948a) obj2);
                }
            };
        }
        return g(str, abstractC4959l, serialDescriptorArr, interfaceC5074l);
    }

    public static final t i(C4948a c4948a) {
        p.i(c4948a, "<this>");
        return t.f7040a;
    }
}
