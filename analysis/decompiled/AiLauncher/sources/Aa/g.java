package Aa;

import Z8.C1173v;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ra.InterfaceC5238k;
import ya.AbstractC5990d0;
import ya.B0;
import ya.s0;
import ya.v0;

/* loaded from: classes5.dex */
public final class g extends AbstractC5990d0 {

    /* renamed from: b, reason: collision with root package name */
    public final v0 f1341b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5238k f1342c;

    /* renamed from: d, reason: collision with root package name */
    public final ErrorTypeKind f1343d;

    /* renamed from: e, reason: collision with root package name */
    public final List<B0> f1344e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1345f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f1346g;

    /* renamed from: h, reason: collision with root package name */
    public final String f1347h;

    /* JADX WARN: Multi-variable type inference failed */
    public g(v0 constructor, InterfaceC5238k memberScope, ErrorTypeKind kind, List<? extends B0> arguments, boolean z10, String... formatParams) {
        p.i(constructor, "constructor");
        p.i(memberScope, "memberScope");
        p.i(kind, "kind");
        p.i(arguments, "arguments");
        p.i(formatParams, "formatParams");
        this.f1341b = constructor;
        this.f1342c = memberScope;
        this.f1343d = kind;
        this.f1344e = arguments;
        this.f1345f = z10;
        this.f1346g = formatParams;
        y yVar = y.f34840a;
        String debugMessage = kind.getDebugMessage();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(debugMessage, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        p.h(str, "format(...)");
        this.f1347h = str;
    }

    @Override // ya.S
    public List<B0> F0() {
        return this.f1344e;
    }

    @Override // ya.S
    public s0 G0() {
        return s0.f44124b.k();
    }

    @Override // ya.S
    public v0 H0() {
        return this.f1341b;
    }

    @Override // ya.S
    public boolean I0() {
        return this.f1345f;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        v0 v0VarH0 = H0();
        InterfaceC5238k interfaceC5238kM = m();
        ErrorTypeKind errorTypeKind = this.f1343d;
        List<B0> listF0 = F0();
        String[] strArr = this.f1346g;
        return new g(v0VarH0, interfaceC5238kM, errorTypeKind, listF0, z10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        p.i(newAttributes, "newAttributes");
        return this;
    }

    public final String Q0() {
        return this.f1347h;
    }

    public final ErrorTypeKind R0() {
        return this.f1343d;
    }

    @Override // ya.K0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public g R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public final g T0(List<? extends B0> newArguments) {
        p.i(newArguments, "newArguments");
        v0 v0VarH0 = H0();
        InterfaceC5238k interfaceC5238kM = m();
        ErrorTypeKind errorTypeKind = this.f1343d;
        boolean zI0 = I0();
        String[] strArr = this.f1346g;
        return new g(v0VarH0, interfaceC5238kM, errorTypeKind, newArguments, zI0, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return this.f1342c;
    }

    public /* synthetic */ g(v0 v0Var, InterfaceC5238k interfaceC5238k, ErrorTypeKind errorTypeKind, List list, boolean z10, String[] strArr, int i10, kotlin.jvm.internal.i iVar) {
        this(v0Var, interfaceC5238k, errorTypeKind, (i10 & 8) != 0 ? C1173v.m() : list, (i10 & 16) != 0 ? false : z10, strArr);
    }
}
