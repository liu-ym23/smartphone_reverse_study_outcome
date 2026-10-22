package D9;

import B9.AbstractC0175b;
import B9.I;
import C9.AbstractC0200b;
import C9.B;
import C9.x;
import D7.v;
import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ca.AbstractC0897f;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlinx.serialization.SerializationException;
import x9.InterfaceC2123a;
import z9.AbstractC2202d;

/* loaded from: classes4.dex */
public abstract class a implements C9.j, A9.e, A9.c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f435a = new ArrayList();
    public boolean b;
    public final AbstractC0200b c;
    public final String d;
    public final C9.i e;

    public a(AbstractC0200b abstractC0200b, String str) {
        this.c = abstractC0200b;
        this.d = str;
        this.e = abstractC0200b.f321a;
    }

    @Override // C9.j
    public final C9.l a() {
        return c();
    }

    public abstract C9.l b(String str);

    @Override // A9.e
    public A9.c beginStructure(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        C9.l lVarC = c();
        H4.o kind = descriptor.getKind();
        boolean zB = kotlin.jvm.internal.k.b(kind, z9.k.d);
        AbstractC0200b abstractC0200b = this.c;
        if (zB || (kind instanceof AbstractC2202d)) {
            String strH = descriptor.h();
            if (lVarC instanceof C9.d) {
                return new p(abstractC0200b, (C9.d) lVarC);
            }
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(C9.d.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarC.getClass()).m());
            sb.append(" as the serialized body of ");
            sb.append(strH);
            sb.append(" at element: ");
            sb.append(s());
            throw j.d(sb.toString(), lVarC.toString(), -1);
        }
        if (!kotlin.jvm.internal.k.b(kind, z9.k.e)) {
            String strH2 = descriptor.h();
            if (lVarC instanceof x) {
                return new o(abstractC0200b, (x) lVarC, this.d, 8);
            }
            StringBuilder sb2 = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar2 = kotlin.jvm.internal.m.f4928a;
            sb2.append(nVar2.b(x.class).m());
            sb2.append(", but had ");
            sb2.append(nVar2.b(lVarC.getClass()).m());
            sb2.append(" as the serialized body of ");
            sb2.append(strH2);
            sb2.append(" at element: ");
            sb2.append(s());
            throw j.d(sb2.toString(), lVarC.toString(), -1);
        }
        z9.g gVarE = j.e(descriptor.g(0), abstractC0200b.b);
        H4.o kind2 = gVarE.getKind();
        if (!(kind2 instanceof z9.f) && !kotlin.jvm.internal.k.b(kind2, z9.j.c)) {
            throw j.b(gVarE);
        }
        String strH3 = descriptor.h();
        if (lVarC instanceof x) {
            return new q(abstractC0200b, (x) lVarC);
        }
        StringBuilder sb3 = new StringBuilder("Expected ");
        kotlin.jvm.internal.n nVar3 = kotlin.jvm.internal.m.f4928a;
        sb3.append(nVar3.b(x.class).m());
        sb3.append(", but had ");
        sb3.append(nVar3.b(lVarC.getClass()).m());
        sb3.append(" as the serialized body of ");
        sb3.append(strH3);
        sb3.append(" at element: ");
        sb3.append(s());
        throw j.d(sb3.toString(), lVarC.toString(), -1);
    }

    public final C9.l c() {
        C9.l lVarB;
        String str = (String) v.L0(this.f435a);
        return (str == null || (lVarB = b(str)) == null) ? q() : lVarB;
    }

    public final Object d(InterfaceC2123a deserializer, Object obj) {
        kotlin.jvm.internal.k.f(deserializer, "deserializer");
        return decodeSerializableValue(deserializer);
    }

    @Override // A9.e
    public final boolean decodeBoolean() {
        return e(r());
    }

    @Override // A9.c
    public final boolean decodeBooleanElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return e(p(descriptor, i));
    }

    @Override // A9.e
    public final byte decodeByte() {
        return f(r());
    }

    @Override // A9.c
    public final byte decodeByteElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return f(p(descriptor, i));
    }

    @Override // A9.e
    public final char decodeChar() {
        return g(r());
    }

    @Override // A9.c
    public final char decodeCharElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return g(p(descriptor, i));
    }

    @Override // A9.e
    public final double decodeDouble() {
        return h(r());
    }

    @Override // A9.c
    public final double decodeDoubleElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return h(p(descriptor, i));
    }

    @Override // A9.e
    public final int decodeEnum(z9.g enumDescriptor) {
        kotlin.jvm.internal.k.f(enumDescriptor, "enumDescriptor");
        String tag = (String) r();
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        String strH = enumDescriptor.h();
        if (lVarB instanceof B) {
            return j.j(enumDescriptor, this.c, ((B) lVarB).b(), "");
        }
        StringBuilder sb = new StringBuilder("Expected ");
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        sb.append(nVar.b(B.class).m());
        sb.append(", but had ");
        sb.append(nVar.b(lVarB.getClass()).m());
        androidx.compose.foundation.b.C(sb, " as the serialized body of ", strH, " at element: ");
        sb.append(t(tag));
        throw j.d(sb.toString(), lVarB.toString(), -1);
    }

    @Override // A9.e
    public final float decodeFloat() {
        return i(r());
    }

    @Override // A9.c
    public final float decodeFloatElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return i(p(descriptor, i));
    }

    @Override // A9.e
    public final A9.e decodeInline(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        if (v.L0(this.f435a) != null) {
            return j(r(), descriptor);
        }
        return new m(this.c, q(), this.d).decodeInline(descriptor);
    }

    @Override // A9.c
    public final A9.e decodeInlineElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return j(p(descriptor, i), ((I) descriptor).g(i));
    }

    @Override // A9.e
    public final int decodeInt() {
        return k(r());
    }

    @Override // A9.c
    public final int decodeIntElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return k(p(descriptor, i));
    }

    @Override // A9.e
    public final long decodeLong() {
        return l(r());
    }

    @Override // A9.c
    public final long decodeLongElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return l(p(descriptor, i));
    }

    @Override // A9.e
    public boolean decodeNotNullMark() {
        return !(c() instanceof C9.u);
    }

    @Override // A9.e
    public final Void decodeNull() {
        return null;
    }

    @Override // A9.c
    public final Object decodeNullableSerializableElement(z9.g descriptor, int i, InterfaceC2123a deserializer, Object obj) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        kotlin.jvm.internal.k.f(deserializer, "deserializer");
        this.f435a.add(p(descriptor, i));
        Object objD = (deserializer.getDescriptor().b() || decodeNotNullMark()) ? d(deserializer, obj) : null;
        if (!this.b) {
            r();
        }
        this.b = false;
        return objD;
    }

    @Override // A9.c
    public final Object decodeSerializableElement(z9.g descriptor, int i, InterfaceC2123a deserializer, Object obj) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        kotlin.jvm.internal.k.f(deserializer, "deserializer");
        this.f435a.add(p(descriptor, i));
        Object objD = d(deserializer, obj);
        if (!this.b) {
            r();
        }
        this.b = false;
        return objD;
    }

    @Override // A9.e
    public final Object decodeSerializableValue(InterfaceC2123a deserializer) {
        kotlin.jvm.internal.k.f(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractC0175b)) {
            return deserializer.deserialize(this);
        }
        AbstractC0200b abstractC0200b = this.c;
        C9.i iVar = abstractC0200b.f321a;
        AbstractC0175b abstractC0175b = (AbstractC0175b) deserializer;
        String strG = j.g(abstractC0200b, abstractC0175b.getDescriptor());
        C9.l lVarC = c();
        String strH = abstractC0175b.getDescriptor().h();
        if (!(lVarC instanceof x)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(x.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarC.getClass()).m());
            sb.append(" as the serialized body of ");
            sb.append(strH);
            sb.append(" at element: ");
            sb.append(s());
            throw j.d(sb.toString(), lVarC.toString(), -1);
        }
        x xVar = (x) lVarC;
        C9.l lVar = (C9.l) xVar.get(strG);
        String strB = null;
        if (lVar != null) {
            B9.B b = C9.m.f329a;
            B b5 = lVar instanceof B ? (B) lVar : null;
            if (b5 == null) {
                throw new IllegalArgumentException("Element " + kotlin.jvm.internal.m.f4928a.b(lVar.getClass()) + " is not a JsonPrimitive");
            }
            if (!(b5 instanceof C9.u)) {
                strB = b5.b();
            }
        }
        try {
            return j.o(abstractC0200b, strG, xVar, AbstractC0897f.x((AbstractC0175b) deserializer, this, strB));
        } catch (SerializationException e) {
            String message = e.getMessage();
            kotlin.jvm.internal.k.c(message);
            throw j.d(message, xVar.toString(), -1);
        }
    }

    @Override // A9.e
    public final short decodeShort() {
        return m(r());
    }

    @Override // A9.c
    public final short decodeShortElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return m(p(descriptor, i));
    }

    @Override // A9.e
    public final String decodeString() {
        return n(r());
    }

    @Override // A9.c
    public final String decodeStringElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return n(p(descriptor, i));
    }

    public final boolean e(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of boolean at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            B9.B b5 = C9.m.f329a;
            kotlin.jvm.internal.k.f(b, "<this>");
            String strB = b.b();
            String[] strArr = u.f448a;
            kotlin.jvm.internal.k.f(strB, "<this>");
            Boolean bool = strB.equalsIgnoreCase("true") ? Boolean.TRUE : strB.equalsIgnoreCase("false") ? Boolean.FALSE : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            u(b, TypedValues.Custom.S_BOOLEAN, tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b, TypedValues.Custom.S_BOOLEAN, tag);
            throw null;
        }
    }

    @Override // A9.c
    public void endStructure(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
    }

    public final byte f(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of byte at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            long jC = C9.m.c(b);
            Byte bValueOf = (-128 > jC || jC > 127) ? null : Byte.valueOf((byte) jC);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            u(b, "byte", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b, "byte", tag);
            throw null;
        }
    }

    public final char g(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of char at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            String strB = b.b();
            kotlin.jvm.internal.k.f(strB, "<this>");
            int length = strB.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return strB.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            u(b, "char", tag);
            throw null;
        }
    }

    @Override // A9.c
    public final E9.e getSerializersModule() {
        return this.c.b;
    }

    public final double h(Object obj) throws NumberFormatException {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of double at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            B9.B b5 = C9.m.f329a;
            kotlin.jvm.internal.k.f(b, "<this>");
            double d = Double.parseDouble(b.b());
            C9.i iVar = this.c.f321a;
            if (!Double.isInfinite(d) && !Double.isNaN(d)) {
                return d;
            }
            Double dValueOf = Double.valueOf(d);
            String output = c().toString();
            kotlin.jvm.internal.k.f(output, "output");
            throw j.c(-1, j.s(dValueOf, tag, output));
        } catch (IllegalArgumentException unused) {
            u(b, "double", tag);
            throw null;
        }
    }

    public final float i(Object obj) throws NumberFormatException {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of float at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            B9.B b5 = C9.m.f329a;
            kotlin.jvm.internal.k.f(b, "<this>");
            float f = Float.parseFloat(b.b());
            C9.i iVar = this.c.f321a;
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                return f;
            }
            Float fValueOf = Float.valueOf(f);
            String output = c().toString();
            kotlin.jvm.internal.k.f(output, "output");
            throw j.c(-1, j.s(fValueOf, tag, output));
        } catch (IllegalArgumentException unused) {
            u(b, TypedValues.Custom.S_FLOAT, tag);
            throw null;
        }
    }

    public final A9.e j(Object obj, z9.g inlineDescriptor) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        kotlin.jvm.internal.k.f(inlineDescriptor, "inlineDescriptor");
        if (!s.a(inlineDescriptor)) {
            this.f435a.add(tag);
            return this;
        }
        C9.l lVarB = b(tag);
        String strH = inlineDescriptor.h();
        if (lVarB instanceof B) {
            String source = ((B) lVarB).b();
            AbstractC0200b json = this.c;
            kotlin.jvm.internal.k.f(json, "json");
            kotlin.jvm.internal.k.f(source, "source");
            return new i(new t(source), json);
        }
        StringBuilder sb = new StringBuilder("Expected ");
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        sb.append(nVar.b(B.class).m());
        sb.append(", but had ");
        sb.append(nVar.b(lVarB.getClass()).m());
        androidx.compose.foundation.b.C(sb, " as the serialized body of ", strH, " at element: ");
        sb.append(t(tag));
        throw j.d(sb.toString(), lVarB.toString(), -1);
    }

    public final int k(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of int at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            long jC = C9.m.c(b);
            Integer numValueOf = (SieveCacheKt.NodeMetaAndPreviousMask > jC || jC > SieveCacheKt.NodeLinkMask) ? null : Integer.valueOf((int) jC);
            if (numValueOf != null) {
                return numValueOf.intValue();
            }
            u(b, "int", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b, "int", tag);
            throw null;
        }
    }

    public final long l(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (lVarB instanceof B) {
            B b = (B) lVarB;
            try {
                return C9.m.c(b);
            } catch (IllegalArgumentException unused) {
                this.u(b, "long", tag);
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder("Expected ");
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        sb.append(nVar.b(B.class).m());
        sb.append(", but had ");
        sb.append(nVar.b(lVarB.getClass()).m());
        sb.append(" as the serialized body of long at element: ");
        sb.append(t(tag));
        throw j.d(sb.toString(), lVarB.toString(), -1);
    }

    public final short m(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of short at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        try {
            long jC = C9.m.c(b);
            Short shValueOf = (-32768 > jC || jC > 32767) ? null : Short.valueOf((short) jC);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            u(b, "short", tag);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(b, "short", tag);
            throw null;
        }
    }

    public final String n(Object obj) {
        String tag = (String) obj;
        kotlin.jvm.internal.k.f(tag, "tag");
        C9.l lVarB = b(tag);
        if (!(lVarB instanceof B)) {
            StringBuilder sb = new StringBuilder("Expected ");
            kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
            sb.append(nVar.b(B.class).m());
            sb.append(", but had ");
            sb.append(nVar.b(lVarB.getClass()).m());
            sb.append(" as the serialized body of string at element: ");
            sb.append(t(tag));
            throw j.d(sb.toString(), lVarB.toString(), -1);
        }
        B b = (B) lVarB;
        if (!(b instanceof C9.r)) {
            StringBuilder sbV = B7.a.v("Expected string value for a non-null key '", tag, "', got null literal instead at element: ");
            sbV.append(t(tag));
            throw j.d(sbV.toString(), c().toString(), -1);
        }
        C9.r rVar = (C9.r) b;
        if (rVar.f332a || this.c.f321a.c) {
            return rVar.c;
        }
        StringBuilder sbV2 = B7.a.v("String literal for key '", tag, "' should be quoted at element: ");
        sbV2.append(t(tag));
        sbV2.append(".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.");
        throw j.d(sbV2.toString(), c().toString(), -1);
    }

    public String o(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return descriptor.e(i);
    }

    public final String p(z9.g gVar, int i) {
        kotlin.jvm.internal.k.f(gVar, "<this>");
        String nestedName = o(gVar, i);
        kotlin.jvm.internal.k.f(nestedName, "nestedName");
        return nestedName;
    }

    public abstract C9.l q();

    public final Object r() {
        ArrayList arrayList = this.f435a;
        Object objRemove = arrayList.remove(H4.o.H(arrayList));
        this.b = true;
        return objRemove;
    }

    public final String s() {
        ArrayList arrayList = this.f435a;
        return arrayList.isEmpty() ? "$" : v.I0(arrayList, ".", "$.", null, null, 60);
    }

    public final String t(String currentTag) {
        kotlin.jvm.internal.k.f(currentTag, "currentTag");
        return s() + '.' + currentTag;
    }

    public final void u(B b, String str, String str2) {
        throw j.d("Failed to parse literal '" + b + "' as " + (j9.t.e0(str, "i", false) ? "an " : "a ").concat(str) + " value at element: " + t(str2), c().toString(), -1);
    }
}
