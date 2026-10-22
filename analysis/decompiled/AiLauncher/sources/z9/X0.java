package z9;

import C9.o;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.KCallables;
import o9.C5013a;
import w9.C5757p;
import w9.InterfaceC5744c;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5748g;
import w9.InterfaceC5749h;
import w9.InterfaceC5752k;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;
import y9.C5965b;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00060\u0017j\u0002`\u0018*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001f\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002¢\u0006\u0004\b!\u0010 J\u001f\u0010#\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00062\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002¢\u0006\u0004\b%\u0010&J%\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0014\u001a\u00020'2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010.JA\u00105\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010/\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J-\u00108\u001a\u00020\u001e*\u00060\u0017j\u0002`\u00182\f\u00107\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lz9/X0;", "", "<init>", "()V", "Lw9/k;", "property", "", "w", "(Lw9/k;)Ljava/lang/String;", "Lw9/g;", "function", "q", "(Lw9/g;)Ljava/lang/String;", "lambda", "t", "Lkotlin/reflect/KParameter;", "parameter", "v", "(Lkotlin/reflect/KParameter;)Ljava/lang/String;", "Lw9/n;", "type", "y", "(Lw9/n;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/StringBuilder;Lkotlin/reflect/KParameter;)Ljava/lang/StringBuilder;", "Lw9/c;", "callable", "LY8/t;", "k", "(Ljava/lang/StringBuilder;Lw9/c;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "name", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "m", "(Lw9/c;)Ljava/lang/String;", "Lz9/a;", "Lw9/d;", "klass", "Lga/d;", "l", "(Lz9/a;Lw9/d;)Lga/d;", "s", "(Ljava/lang/StringBuilder;Lw9/n;)V", "classFqName", "", "Lw9/p;", "allArguments", "", "isMarkedNullable", "x", "(Ljava/lang/StringBuilder;Lw9/d;Lga/d;Ljava/util/List;Z)V", "typeArguments", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/StringBuilder;Ljava/util/List;Z)V", "lowerRendered", "upperRendered", "n", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class X0 {

    /* renamed from: a, reason: collision with root package name */
    public static final X0 f45332a = new X0();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45333a;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            try {
                iArr[KParameter.Kind.INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KParameter.Kind.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KParameter.Kind.VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f45333a = iArr;
        }
    }

    public static final CharSequence h(KParameter parameter) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        StringBuilder sb2 = new StringBuilder();
        String name = parameter.getName();
        if (name == null) {
            name = "_";
        }
        sb2.append(name);
        sb2.append(": ");
        sb2.append(parameter.getType());
        return sb2.toString();
    }

    public static final String o(String str) {
        String str2 = C9.o.f1812D.a() + '.';
        if (!La.D.X(str, str2, false, 2, null)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    public static final String p(String str) {
        String str2 = C9.o.f1810B.a() + '.';
        if (!La.D.X(str, str2, false, 2, null)) {
            str2 = null;
        }
        return str2 == null ? "" : str2;
    }

    public static final CharSequence r(KParameter it) {
        kotlin.jvm.internal.p.i(it, "it");
        return f45332a.y(it.getType());
    }

    public static final CharSequence u(KParameter it) {
        kotlin.jvm.internal.p.i(it, "it");
        return f45332a.y(it.getType());
    }

    public static final CharSequence z(ga.e it) {
        kotlin.jvm.internal.p.i(it, "it");
        return ja.y.c(it);
    }

    public final void A(StringBuilder sb2, List<C5757p> list, boolean z10) throws IOException {
        StringBuilder sb3;
        if (list.isEmpty()) {
            sb3 = sb2;
        } else {
            sb3 = sb2;
            Z8.F.x0(list, sb3, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "<", (124 & 8) == 0 ? ">" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        if (z10) {
            sb3.append("?");
        }
    }

    public final void g(StringBuilder sb2, InterfaceC5744c<?> interfaceC5744c) throws IOException {
        List<KParameter> listB = KCallables.b(interfaceC5744c);
        if (listB.isEmpty()) {
            return;
        }
        Z8.F.x0(listB, sb2, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "context(", (124 & 8) == 0 ? ") " : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : R0.f45317a);
    }

    public final void i(StringBuilder sb2, String str) {
        ga.e eVarJ = ga.e.j(str);
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        sb2.append(ja.y.c(eVarJ));
    }

    public final StringBuilder j(StringBuilder sb2, KParameter kParameter) {
        sb2.append(y(kParameter.getType()));
        sb2.append(".");
        kotlin.jvm.internal.p.h(sb2, "append(...)");
        return sb2;
    }

    public final void k(StringBuilder sb2, InterfaceC5744c<?> interfaceC5744c) {
        kotlin.jvm.internal.p.g(interfaceC5744c, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KCallableImpl<*>");
        List<KParameter> listB0 = ((kotlin.reflect.jvm.internal.d) interfaceC5744c).b0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB0) {
            KParameter kParameter = (KParameter) obj;
            if (kParameter.getKind() == KParameter.Kind.INSTANCE || kParameter.getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                arrayList.add(obj);
            }
        }
        KParameter kParameter2 = (KParameter) Z8.F.t0(arrayList, 0);
        if (kParameter2 != null) {
            f45332a.j(sb2, kParameter2);
        }
        KParameter kParameter3 = (KParameter) Z8.F.t0(arrayList, 1);
        if (kParameter3 != null) {
            X0 x02 = f45332a;
            sb2.append("(");
            kotlin.jvm.internal.p.h(sb2, "append(...)");
            x02.j(sb2, kParameter3).append(")");
        }
    }

    public final ga.d l(AbstractC6403a type, InterfaceC5745d<?> klass) {
        if (type.p()) {
            return o.a.f1898c;
        }
        String strN = klass.n();
        if (strN == null) {
            return null;
        }
        ga.d dVar = new ga.d(strN);
        if (!type.o()) {
            return dVar;
        }
        ga.c cVarP = D9.a.f2270a.p(dVar);
        if (cVarP != null) {
            return cVarP.i();
        }
        return null;
    }

    public final String m(InterfaceC5744c<?> callable) {
        if (callable instanceof InterfaceC5752k) {
            return w((InterfaceC5752k) callable);
        }
        if (callable instanceof InterfaceC5748g) {
            return q((InterfaceC5748g) callable);
        }
        throw new IllegalStateException(("Illegal callable: " + callable).toString());
    }

    public final String n(String lowerRendered, String upperRendered) {
        if (kotlin.jvm.internal.p.d(lowerRendered, La.D.T(upperRendered, "?", "", false, 4, null))) {
            return La.D.T(upperRendered, "?", "!", false, 4, null);
        }
        if (La.D.K(upperRendered, "?", false, 2, null)) {
            if (kotlin.jvm.internal.p.d(lowerRendered + '?', upperRendered)) {
                return lowerRendered + '!';
            }
        }
        if (kotlin.jvm.internal.p.d('(' + lowerRendered + ")?", upperRendered)) {
            return '(' + lowerRendered + ")!";
        }
        String strE = ja.y.e(lowerRendered, upperRendered, new V0(lowerRendered), new W0(lowerRendered), null, 16, null);
        if (strE != null) {
            return strE;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    public final String q(InterfaceC5748g<?> function) throws IOException {
        kotlin.jvm.internal.p.i(function, "function");
        StringBuilder sb2 = new StringBuilder();
        X0 x02 = f45332a;
        x02.g(sb2, function);
        sb2.append("fun ");
        x02.k(sb2, function);
        x02.i(sb2, function.getName());
        Z8.F.x0(KCallables.d(function), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : S0.f45319a);
        sb2.append(": ");
        sb2.append(x02.y(function.getReturnType()));
        return sb2.toString();
    }

    public final void s(StringBuilder sb2, InterfaceC5755n interfaceC5755n) throws IOException {
        if (interfaceC5755n.e()) {
            sb2.append("(");
        }
        Z8.F.x0(Z8.F.i0(interfaceC5755n.g(), 1), sb2, (124 & 2) != 0 ? ", " : null, (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ") -> " : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        sb2.append(Z8.F.C0(interfaceC5755n.g()));
        if (interfaceC5755n.e()) {
            sb2.append(")?");
        }
    }

    public final String t(InterfaceC5748g<?> lambda) throws IOException {
        kotlin.jvm.internal.p.i(lambda, "lambda");
        StringBuilder sb2 = new StringBuilder();
        KParameter kParameterC = KCallables.c(lambda);
        if (kParameterC != null) {
            sb2.append(f45332a.y(kParameterC.getType()));
            sb2.append(".");
        }
        Z8.F.x0(KCallables.d(lambda), sb2, (124 & 2) != 0 ? ", " : ", ", (124 & 4) != 0 ? "" : "(", (124 & 8) == 0 ? ")" : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : T0.f45322a);
        sb2.append(" -> ");
        sb2.append(f45332a.y(lambda.getReturnType()));
        return sb2.toString();
    }

    public final String v(KParameter parameter) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        StringBuilder sb2 = new StringBuilder();
        int i10 = a.f45333a[parameter.getKind().ordinal()];
        if (i10 == 1) {
            sb2.append("instance parameter");
        } else if (i10 == 2) {
            sb2.append("context parameter " + parameter.getName());
        } else if (i10 == 3) {
            sb2.append("extension receiver parameter");
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            sb2.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb2.append(" of ");
        sb2.append(f45332a.m(((kotlin.reflect.jvm.internal.l) parameter).s()));
        return sb2.toString();
    }

    public final String w(InterfaceC5752k<?> property) throws IOException {
        kotlin.jvm.internal.p.i(property, "property");
        StringBuilder sb2 = new StringBuilder();
        X0 x02 = f45332a;
        x02.g(sb2, property);
        sb2.append(property instanceof InterfaceC5749h ? "var " : "val ");
        x02.k(sb2, property);
        x02.i(sb2, property.getName());
        sb2.append(": ");
        sb2.append(x02.y(property.getReturnType()));
        return sb2.toString();
    }

    public final void x(StringBuilder sb2, InterfaceC5745d<?> interfaceC5745d, ga.d dVar, List<C5757p> list, boolean z10) throws IOException {
        X0 x02;
        StringBuilder sb3;
        if (interfaceC5745d.getTypeParameters().size() >= list.size() || C5013a.b(interfaceC5745d).getDeclaringClass() == null) {
            x02 = this;
            sb3 = sb2;
            sb3.append(ja.y.b(dVar));
        } else {
            Class<?> declaringClass = C5013a.b(interfaceC5745d).getDeclaringClass();
            kotlin.jvm.internal.p.h(declaringClass, "getDeclaringClass(...)");
            x02 = this;
            sb3 = sb2;
            x02.x(sb3, C5013a.e(declaringClass), dVar.g(), Z8.F.h0(list, interfaceC5745d.getTypeParameters().size()), false);
            sb3.append(".");
            sb3.append(ja.y.c(dVar.j()));
        }
        x02.A(sb3, Z8.F.f1(list, interfaceC5745d.getTypeParameters().size()), z10);
    }

    public final String y(InterfaceC5755n type) throws IOException {
        kotlin.jvm.internal.p.i(type, "type");
        AbstractC6403a abstractC6403a = (AbstractC6403a) type;
        AbstractC6403a abstractC6403aR = abstractC6403a.r();
        AbstractC6403a abstractC6403aS = abstractC6403a.s();
        if (abstractC6403aR != null && abstractC6403aS != null) {
            return n(y(abstractC6403aR), y(abstractC6403aS));
        }
        StringBuilder sb2 = new StringBuilder();
        InterfaceC5755n interfaceC5755nL = abstractC6403a.l();
        if (interfaceC5755nL != null) {
            sb2.append(interfaceC5755nL);
            sb2.append(" /* = ");
        }
        InterfaceC5746e interfaceC5746eC = type.c();
        if (interfaceC5746eC instanceof InterfaceC5756o) {
            f45332a.i(sb2, ((InterfaceC5756o) interfaceC5746eC).getName());
            if (type.e()) {
                sb2.append("?");
            } else if (((AbstractC6403a) type).m()) {
                sb2.append(" & Any");
            }
        } else if (interfaceC5746eC instanceof InterfaceC5745d) {
            X0 x02 = f45332a;
            InterfaceC5745d<?> interfaceC5745d = (InterfaceC5745d) interfaceC5746eC;
            ga.d dVarL = x02.l((AbstractC6403a) type, interfaceC5745d);
            if (dVarL == null) {
                dVarL = new ga.d(C5965b.a(interfaceC5745d));
            }
            ga.d dVar = dVarL;
            if (!C9.i.r(dVar) || type.g().contains(C5757p.INSTANCE.c())) {
                x02.x(sb2, interfaceC5745d, dVar, type.g(), type.e());
            } else {
                x02.s(sb2, type);
            }
        } else if (interfaceC5746eC instanceof G0) {
            Z8.F.x0(((G0) interfaceC5746eC).getFqName().e(), sb2, (124 & 2) != 0 ? ", " : ".", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : U0.f45325a);
            f45332a.A(sb2, type.g(), type.e());
        } else {
            sb2.append("???");
        }
        if (((AbstractC6403a) type).l() != null) {
            sb2.append(" */");
        }
        return sb2.toString();
    }
}
