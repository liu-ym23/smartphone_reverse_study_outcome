package io.ktor.http;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDate$$serializer;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import mb.C4931a;
import pb.C5100i;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/http/Cookie.$serializer", "Lpb/M;", "Lio/ktor/http/Cookie;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/http/Cookie;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/http/Cookie;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class Cookie$$serializer implements M<Cookie> {
    public static final Cookie$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        Cookie$$serializer cookie$$serializer = new Cookie$$serializer();
        INSTANCE = cookie$$serializer;
        I0 i02 = new I0("io.ktor.http.Cookie", cookie$$serializer, 10);
        i02.n("name", false);
        i02.n(UxipConstants.f30680s, false);
        i02.n("encoding", true);
        i02.n("maxAge", true);
        i02.n("expires", true);
        i02.n("domain", true);
        i02.n("path", true);
        i02.n("secure", true);
        i02.n("httpOnly", true);
        i02.n("extensions", true);
        descriptor = i02;
    }

    private Cookie$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        Y8.h[] hVarArr = Cookie.$childSerializers;
        Y0 y02 = Y0.f38329a;
        C5100i c5100i = C5100i.f38363a;
        return new KSerializer[]{y02, y02, hVarArr[2].getValue(), C4931a.t(X.f38325a), C4931a.t(GMTDate$$serializer.INSTANCE), C4931a.t(y02), C4931a.t(y02), c5100i, c5100i, hVarArr[9].getValue()};
    }

    @Override // lb.InterfaceC4883a
    public final Cookie deserialize(Decoder decoder) {
        boolean z10;
        Map map;
        String str;
        String str2;
        GMTDate gMTDate;
        Integer num;
        CookieEncoding cookieEncoding;
        boolean z11;
        int i10;
        String str3;
        String str4;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = Cookie.$childSerializers;
        int i11 = 7;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
            CookieEncoding cookieEncoding2 = (CookieEncoding) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, (InterfaceC4883a) hVarArr[2].getValue(), null);
            Integer num2 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, X.f38325a, null);
            GMTDate gMTDate2 = (GMTDate) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$$serializer.INSTANCE, null);
            Y0 y02 = Y0.f38329a;
            String str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, y02, null);
            String str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, y02, null);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(serialDescriptor, 8);
            map = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 9, (InterfaceC4883a) hVarArr[9].getValue(), null);
            str3 = strDecodeStringElement;
            z10 = zDecodeBooleanElement;
            str2 = str6;
            str = str5;
            num = num2;
            z11 = zDecodeBooleanElement2;
            gMTDate = gMTDate2;
            i10 = 1023;
            cookieEncoding = cookieEncoding2;
            str4 = strDecodeStringElement2;
        } else {
            int i12 = 2;
            boolean z12 = true;
            boolean zDecodeBooleanElement3 = false;
            int i13 = 0;
            Map map2 = null;
            String str7 = null;
            String str8 = null;
            GMTDate gMTDate3 = null;
            Integer num3 = null;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            boolean zDecodeBooleanElement4 = false;
            CookieEncoding cookieEncoding3 = null;
            while (z12) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z12 = false;
                        i11 = 7;
                        i12 = 2;
                    case 0:
                        strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i13 |= 1;
                        i11 = 7;
                        i12 = 2;
                    case 1:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i13 |= 2;
                        i11 = 7;
                    case 2:
                        cookieEncoding3 = (CookieEncoding) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i12, (InterfaceC4883a) hVarArr[i12].getValue(), cookieEncoding3);
                        i13 |= 4;
                        i11 = 7;
                    case 3:
                        num3 = (Integer) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, X.f38325a, num3);
                        i13 |= 8;
                        i11 = 7;
                    case 4:
                        gMTDate3 = (GMTDate) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$$serializer.INSTANCE, gMTDate3);
                        i13 |= 16;
                        i11 = 7;
                    case 5:
                        str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, Y0.f38329a, str7);
                        i13 |= 32;
                        i11 = 7;
                    case 6:
                        str8 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Y0.f38329a, str8);
                        i13 |= 64;
                        i11 = 7;
                    case 7:
                        zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(serialDescriptor, i11);
                        i13 |= 128;
                    case 8:
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(serialDescriptor, 8);
                        i13 |= 256;
                    case 9:
                        map2 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 9, (InterfaceC4883a) hVarArr[9].getValue(), map2);
                        i13 |= 512;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            z10 = zDecodeBooleanElement3;
            map = map2;
            str = str7;
            str2 = str8;
            gMTDate = gMTDate3;
            num = num3;
            cookieEncoding = cookieEncoding3;
            z11 = zDecodeBooleanElement4;
            i10 = i13;
            str3 = strDecodeStringElement3;
            str4 = strDecodeStringElement4;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new Cookie(i10, str3, str4, cookieEncoding, num, gMTDate, str, str2, z10, z11, map, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, Cookie value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        Cookie.write$Self$ktor_http(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
