package com.fasterxml.jackson.databind.ser.std;

import a0.a;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class InetSocketAddressSerializer extends StdScalarSerializer<InetSocketAddress> {
    public InetSocketAddressSerializer() {
        super(InetSocketAddress.class);
    }

    public static void o(InetSocketAddress inetSocketAddress, JsonGenerator jsonGenerator) {
        String strSubstring;
        InetAddress address = inetSocketAddress.getAddress();
        String hostName = address == null ? inetSocketAddress.getHostName() : address.toString().trim();
        int iIndexOf = hostName.indexOf(47);
        if (iIndexOf >= 0) {
            if (iIndexOf == 0) {
                if (address instanceof Inet6Address) {
                    strSubstring = "[" + hostName.substring(1) + "]";
                } else {
                    strSubstring = hostName.substring(1);
                }
                hostName = strSubstring;
            } else {
                hostName = hostName.substring(0, iIndexOf);
            }
        }
        StringBuilder sbP = a.p(hostName, ":");
        sbP.append(inetSocketAddress.getPort());
        jsonGenerator.f1(sbP.toString());
    }

    @Override // b3.f
    public final /* bridge */ /* synthetic */ void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        o((InetSocketAddress) obj, jsonGenerator);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        WritableTypeId writableTypeIdD = eVar.d(JsonToken.VALUE_STRING, inetSocketAddress);
        writableTypeIdD.f3620b = InetSocketAddress.class;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, writableTypeIdD);
        o(inetSocketAddress, jsonGenerator);
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
