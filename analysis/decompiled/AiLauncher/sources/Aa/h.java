package Aa;

import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1173v;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import ya.S;
import ya.v0;

/* loaded from: classes5.dex */
public final class h implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final ErrorTypeKind f1348a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f1349b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1350c;

    public h(ErrorTypeKind kind, String... formatParams) {
        p.i(kind, "kind");
        p.i(formatParams, "formatParams");
        this.f1348a = kind;
        this.f1349b = formatParams;
        String debugText = ErrorEntity.ERROR_TYPE.getDebugText();
        String debugMessage = kind.getDebugMessage();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(debugMessage, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        p.h(str, "format(...)");
        String str2 = String.format(debugText, Arrays.copyOf(new Object[]{str}, 1));
        p.h(str2, "format(...)");
        this.f1350c = str2;
    }

    @Override // ya.v0
    public v0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.v0
    public InterfaceC0799d d() {
        return i.f1351a.h();
    }

    @Override // ya.v0
    public Collection<S> e() {
        return C1173v.m();
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public C9.j g() {
        return C9.g.f1776h.a();
    }

    @Override // ya.v0
    public List<b0> getParameters() {
        return C1173v.m();
    }

    public final ErrorTypeKind h() {
        return this.f1348a;
    }

    public final String i(int i10) {
        return this.f1349b[i10];
    }

    public String toString() {
        return this.f1350c;
    }
}
