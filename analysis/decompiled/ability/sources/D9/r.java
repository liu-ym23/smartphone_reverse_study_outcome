package D9;

import C9.AbstractC0200b;
import kotlinx.serialization.json.internal.WriteMode;

/* loaded from: classes4.dex */
public final class r extends A9.b implements A9.f, A9.d {

    /* renamed from: a, reason: collision with root package name */
    public final C4.a f445a;
    public final AbstractC0200b b;
    public final WriteMode c;
    public final r[] d;
    public final E9.e e;
    public final C9.i f;
    public boolean g;
    public String h;
    public String i;

    public r(C4.a composer, AbstractC0200b abstractC0200b, WriteMode writeMode, r[] rVarArr) {
        kotlin.jvm.internal.k.f(composer, "composer");
        this.f445a = composer;
        this.b = abstractC0200b;
        this.c = writeMode;
        this.d = rVarArr;
        this.e = abstractC0200b.b;
        this.f = abstractC0200b.f321a;
        int iOrdinal = writeMode.ordinal();
        if (rVarArr != null) {
            r rVar = rVarArr[iOrdinal];
            if (rVar == null && rVar == this) {
                return;
            }
            rVarArr[iOrdinal] = this;
        }
    }

    @Override // A9.b, A9.f
    public final A9.d beginStructure(z9.g descriptor) {
        r rVar;
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        AbstractC0200b abstractC0200b = this.b;
        WriteMode writeModeP = j.p(abstractC0200b, descriptor);
        char c = writeModeP.f5266a;
        C4.a aVar = this.f445a;
        aVar.l(c);
        aVar.h();
        String str = this.h;
        if (str != null) {
            String strH = this.i;
            if (strH == null) {
                strH = descriptor.h();
            }
            aVar.i();
            encodeString(str);
            aVar.l(':');
            aVar.s();
            encodeString(strH);
            this.h = null;
            this.i = null;
        }
        if (this.c == writeModeP) {
            return this;
        }
        r[] rVarArr = this.d;
        return (rVarArr == null || (rVar = rVarArr[writeModeP.ordinal()]) == null) ? new r(aVar, abstractC0200b, writeModeP, rVarArr) : rVar;
    }

    @Override // A9.b, A9.f
    public final void encodeBoolean(boolean z10) {
        if (this.g) {
            encodeString(String.valueOf(z10));
        } else {
            ((B1.b) this.f445a.c).l(String.valueOf(z10));
        }
    }

    @Override // A9.b, A9.f
    public final void encodeByte(byte b) {
        if (this.g) {
            encodeString(String.valueOf((int) b));
        } else {
            this.f445a.k(b);
        }
    }

    @Override // A9.b, A9.f
    public final void encodeChar(char c) {
        encodeString(String.valueOf(c));
    }

    @Override // A9.b, A9.f
    public final void encodeDouble(double d) {
        boolean z10 = this.g;
        C4.a aVar = this.f445a;
        if (z10) {
            encodeString(String.valueOf(d));
        } else {
            ((B1.b) aVar.c).l(String.valueOf(d));
        }
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw j.a(((B1.b) aVar.c).toString(), Double.valueOf(d));
        }
    }

    @Override // A9.b
    public final boolean encodeElement(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        int iOrdinal = this.c.ordinal();
        C4.a aVar = this.f445a;
        if (iOrdinal == 1) {
            if (!aVar.b) {
                aVar.l(',');
            }
            aVar.i();
            return true;
        }
        boolean z10 = false;
        if (iOrdinal == 2) {
            if (aVar.b) {
                this.g = true;
                aVar.i();
                return true;
            }
            if (i % 2 == 0) {
                aVar.l(',');
                aVar.i();
                z10 = true;
            } else {
                aVar.l(':');
                aVar.s();
            }
            this.g = z10;
            return true;
        }
        if (iOrdinal == 3) {
            if (i == 0) {
                this.g = true;
            }
            if (i == 1) {
                aVar.l(',');
                aVar.s();
                this.g = false;
            }
            return true;
        }
        if (!aVar.b) {
            aVar.l(',');
        }
        aVar.i();
        j.n(this.b, descriptor);
        encodeString(descriptor.e(i));
        aVar.l(':');
        aVar.s();
        return true;
    }

    @Override // A9.f
    public final void encodeEnum(z9.g enumDescriptor, int i) {
        kotlin.jvm.internal.k.f(enumDescriptor, "enumDescriptor");
        encodeString(enumDescriptor.e(i));
    }

    @Override // A9.b, A9.f
    public final void encodeFloat(float f) {
        boolean z10 = this.g;
        C4.a aVar = this.f445a;
        if (z10) {
            encodeString(String.valueOf(f));
        } else {
            ((B1.b) aVar.c).l(String.valueOf(f));
        }
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            throw j.a(((B1.b) aVar.c).toString(), Float.valueOf(f));
        }
    }

    @Override // A9.b, A9.f
    public final A9.f encodeInline(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        boolean zA = s.a(descriptor);
        WriteMode writeMode = this.c;
        AbstractC0200b abstractC0200b = this.b;
        C4.a fVar = this.f445a;
        if (zA) {
            if (!(fVar instanceof g)) {
                fVar = new g((B1.b) fVar.c, this.g);
            }
            return new r(fVar, abstractC0200b, writeMode, null);
        }
        if (descriptor.isInline() && descriptor.equals(C9.m.f329a)) {
            if (!(fVar instanceof f)) {
                fVar = new f((B1.b) fVar.c, this.g);
            }
            return new r(fVar, abstractC0200b, writeMode, null);
        }
        if (this.h == null) {
            return super.encodeInline(descriptor);
        }
        this.i = descriptor.h();
        return this;
    }

    @Override // A9.b, A9.f
    public final void encodeInt(int i) {
        if (this.g) {
            encodeString(String.valueOf(i));
        } else {
            this.f445a.m(i);
        }
    }

    @Override // A9.b, A9.f
    public final void encodeLong(long j5) {
        if (this.g) {
            encodeString(String.valueOf(j5));
        } else {
            this.f445a.o(j5);
        }
    }

    @Override // A9.f
    public final void encodeNull() {
        this.f445a.p("null");
    }

    @Override // A9.b, A9.d
    public final void encodeNullableSerializableElement(z9.g descriptor, int i, x9.f serializer, Object obj) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        kotlin.jvm.internal.k.f(serializer, "serializer");
        if (obj != null || this.f.e) {
            super.encodeNullableSerializableElement(descriptor, i, serializer, obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    @Override // A9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void encodeSerializableValue(x9.f r5, java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D9.r.encodeSerializableValue(x9.f, java.lang.Object):void");
    }

    @Override // A9.b, A9.f
    public final void encodeShort(short s5) {
        if (this.g) {
            encodeString(String.valueOf((int) s5));
        } else {
            this.f445a.q(s5);
        }
    }

    @Override // A9.b, A9.f
    public final void encodeString(String value) {
        kotlin.jvm.internal.k.f(value, "value");
        this.f445a.r(value);
    }

    @Override // A9.b, A9.d
    public final void endStructure(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        C4.a aVar = this.f445a;
        aVar.t();
        aVar.j();
        aVar.l(this.c.b);
    }

    @Override // A9.f
    public final E9.e getSerializersModule() {
        return this.e;
    }

    @Override // A9.d
    public final boolean shouldEncodeElementDefault(z9.g descriptor, int i) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        return this.f.f327a;
    }
}
