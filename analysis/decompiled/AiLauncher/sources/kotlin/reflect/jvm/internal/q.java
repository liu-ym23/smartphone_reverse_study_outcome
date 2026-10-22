package kotlin.reflect.jvm.internal;

import A9.h;
import E9.InterfaceC0803h;
import E9.O;
import com.autonavi.aps.amapapi.config.Const;
import fa.C4071h;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import ka.C4828h;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.p;
import wa.C5770L;
import ya.H0;
import z9.c1;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\"\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/p$a;", "", "isGetter", "LA9/g;", Const.INTENT_KEY_PKGNAME, "(Lkotlin/reflect/jvm/internal/p$a;Z)LA9/g;", "LE9/O;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LE9/O;)Z", "", "f", "(Lkotlin/reflect/jvm/internal/p$a;)Ljava/lang/Object;", "boundReceiver", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class q {
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final A9.g<?> b(kotlin.reflect.jvm.internal.p.a<?, ?> r7, boolean r8) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.q.b(kotlin.reflect.jvm.internal.p$a, boolean):A9.g");
    }

    public static final A9.h<Field> c(p.a<?, ?> aVar, boolean z10, Field field) {
        return (g(aVar.l().f0()) || !Modifier.isStatic(field.getModifiers())) ? z10 ? aVar.d0() ? new h.f.a(field, f(aVar)) : new h.f.c(field) : aVar.d0() ? new h.g.a(field, e(aVar), f(aVar)) : new h.g.c(field, e(aVar)) : d(aVar) ? z10 ? aVar.d0() ? new h.f.b(field) : new h.f.d(field) : aVar.d0() ? new h.g.b(field, e(aVar)) : new h.g.d(field, e(aVar)) : z10 ? new h.f.e(field) : new h.g.e(field, e(aVar));
    }

    public static final boolean d(p.a<?, ?> aVar) {
        return aVar.l().f0().getAnnotations().E(c1.k());
    }

    public static final boolean e(p.a<?, ?> aVar) {
        return !H0.l(aVar.l().f0().getType());
    }

    public static final Object f(p.a<?, ?> aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        return aVar.l().k0();
    }

    public static final boolean g(O o10) {
        InterfaceC0803h interfaceC0803hB = o10.b();
        kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
        if (!C4828h.x(interfaceC0803hB)) {
            return false;
        }
        InterfaceC0803h interfaceC0803hB2 = interfaceC0803hB.b();
        if (C4828h.C(interfaceC0803hB2) || C4828h.t(interfaceC0803hB2)) {
            return (o10 instanceof C5770L) && C4071h.f(((C5770L) o10).a0());
        }
        return true;
    }
}
