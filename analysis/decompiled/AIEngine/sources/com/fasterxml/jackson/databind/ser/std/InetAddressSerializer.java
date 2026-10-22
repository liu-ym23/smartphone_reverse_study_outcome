package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import java.net.InetAddress;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4365c;

    public InetAddressSerializer() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r2, com.fasterxml.jackson.databind.BeanProperty r3) {
        /*
            r1 = this;
            java.lang.Class<T> r0 = r1.f4417a
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r2, r3, r0)
            if (r2 == 0) goto L16
            com.fasterxml.jackson.annotation.JsonFormat$Shape r2 = r2.f3451b
            boolean r3 = r2.a()
            if (r3 != 0) goto L14
            com.fasterxml.jackson.annotation.JsonFormat$Shape r3 = com.fasterxml.jackson.annotation.JsonFormat.Shape.f3442d
            if (r2 != r3) goto L16
        L14:
            r2 = 1
            goto L17
        L16:
            r2 = 0
        L17:
            boolean r3 = r1.f4365c
            if (r2 == r3) goto L20
            com.fasterxml.jackson.databind.ser.std.InetAddressSerializer r1 = new com.fasterxml.jackson.databind.ser.std.InetAddressSerializer
            r1.<init>(r2)
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.InetAddressSerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final /* bridge */ /* synthetic */ void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        o((InetAddress) obj, jsonGenerator);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        InetAddress inetAddress = (InetAddress) obj;
        WritableTypeId writableTypeIdD = eVar.d(JsonToken.VALUE_STRING, inetAddress);
        writableTypeIdD.f3620b = InetAddress.class;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, writableTypeIdD);
        o(inetAddress, jsonGenerator);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    public final void o(InetAddress inetAddress, JsonGenerator jsonGenerator) {
        String strTrim;
        if (this.f4365c) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        jsonGenerator.f1(strTrim);
    }

    public InetAddressSerializer(boolean z) {
        super(InetAddress.class);
        this.f4365c = z;
    }
}
