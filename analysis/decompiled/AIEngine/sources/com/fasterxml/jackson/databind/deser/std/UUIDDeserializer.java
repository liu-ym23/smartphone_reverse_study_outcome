package com.fasterxml.jackson.databind.deser.std;

import a3.c;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.util.Arrays;
import java.util.UUID;
import v2.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class UUIDDeserializer extends FromStringDeserializer<UUID> {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f4093e;

    static {
        int[] iArr = new int[127];
        f4093e = iArr;
        Arrays.fill(iArr, -1);
        for (int i10 = 0; i10 < 10; i10++) {
            f4093e[i10 + 48] = i10;
        }
        for (int i11 = 0; i11 < 6; i11++) {
            int[] iArr2 = f4093e;
            int i12 = i11 + 10;
            iArr2[i11 + 97] = i12;
            iArr2[i11 + 65] = i12;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    public static int o0(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | (bArr[i10] << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    @Override // b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return new UUID(0L, 0L);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public final Object j0(DeserializationContext deserializationContext, String str) throws InvalidFormatException {
        int length = str.length();
        Class<?> cls = this.f4054a;
        if (length != 36) {
            if (str.length() != 24) {
                deserializationContext.G(cls, str, "UUID has to be represented by standard 36-char representation", new Object[0]);
                throw null;
            }
            Base64Variant base64Variant = a.f13372b;
            base64Variant.getClass();
            c cVar = new c(null);
            base64Variant.b(str, cVar);
            return n0(cVar.P(), deserializationContext);
        }
        if (str.charAt(8) != '-' || str.charAt(13) != '-' || str.charAt(18) != '-' || str.charAt(23) != '-') {
            deserializationContext.G(cls, str, "UUID has to be represented by standard 36-char representation", new Object[0]);
            throw null;
        }
        return new UUID((q0(str, 0, deserializationContext) << 32) + ((r0(str, 9, deserializationContext) << 16) | r0(str, 14, deserializationContext)), ((q0(str, 28, deserializationContext) << 32) >>> 32) | (((r0(str, 19, deserializationContext) << 16) | r0(str, 24, deserializationContext)) << 32));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public final Object k0(DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
        if (obj instanceof byte[]) {
            return n0((byte[]) obj, deserializationContext);
        }
        super.k0(deserializationContext, obj);
        throw null;
    }

    public final UUID n0(byte[] bArr, DeserializationContext deserializationContext) throws InvalidFormatException {
        if (bArr.length == 16) {
            return new UUID((o0(bArr, 0) << 32) | ((o0(bArr, 4) << 32) >>> 32), ((o0(bArr, 12) << 32) >>> 32) | (o0(bArr, 8) << 32));
        }
        throw new InvalidFormatException(deserializationContext.h, ai.onnxruntime.a.j(" bytes", bArr.length, new StringBuilder("Can only construct UUIDs from byte[16]; got ")), bArr);
    }

    public final int p0(String str, int i10, DeserializationContext deserializationContext) throws InvalidFormatException {
        int i11;
        char cCharAt = str.charAt(i10);
        char cCharAt2 = str.charAt(i10 + 1);
        int[] iArr = f4093e;
        if (cCharAt <= 127 && cCharAt2 <= 127 && (i11 = (iArr[cCharAt] << 4) | iArr[cCharAt2]) >= 0) {
            return i11;
        }
        Class<?> cls = this.f4054a;
        if (cCharAt > 127 || iArr[cCharAt] < 0) {
            throw deserializationContext.W(str, cls, String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(cCharAt), Integer.toHexString(cCharAt)));
        }
        throw deserializationContext.W(str, cls, String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(cCharAt2), Integer.toHexString(cCharAt2)));
    }

    public final int q0(String str, int i10, DeserializationContext deserializationContext) {
        return p0(str, i10 + 6, deserializationContext) + (p0(str, i10, deserializationContext) << 24) + (p0(str, i10 + 2, deserializationContext) << 16) + (p0(str, i10 + 4, deserializationContext) << 8);
    }

    public final int r0(String str, int i10, DeserializationContext deserializationContext) {
        return p0(str, i10 + 2, deserializationContext) + (p0(str, i10, deserializationContext) << 8);
    }
}
