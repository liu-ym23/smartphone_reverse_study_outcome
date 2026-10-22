package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.Arrays;
import java.util.UUID;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UUIDDeserializer extends FromStringDeserializer<UUID> {
    static final int[] HEX_DIGITS;
    private static final long serialVersionUID = 1;

    static {
        int[] iArr = new int[127];
        HEX_DIGITS = iArr;
        Arrays.fill(iArr, -1);
        for (int i = 0; i < 10; i++) {
            HEX_DIGITS[i + 48] = i;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            int[] iArr2 = HEX_DIGITS;
            int i10 = i3 + 10;
            iArr2[i3 + 97] = i10;
            iArr2[i3 + 65] = i10;
        }
    }

    public UUIDDeserializer() {
        super(UUID.class);
    }

    private UUID _badFormat(String str, DeserializationContext deserializationContext) {
        return (UUID) deserializationContext.handleWeirdStringValue(handledType(), str, "UUID has to be represented by standard 36-char representation", new Object[0]);
    }

    private UUID _fromBytes(byte[] bArr, DeserializationContext deserializationContext) throws InvalidFormatException {
        if (bArr.length == 16) {
            return new UUID(_long(bArr, 0), _long(bArr, 8));
        }
        throw InvalidFormatException.from(deserializationContext.getParser(), a.r(new StringBuilder("Can only construct UUIDs from byte[16]; got "), bArr.length, " bytes"), bArr, handledType());
    }

    private static int _int(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    private static long _long(byte[] bArr, int i) {
        return ((_int(bArr, i + 4) << 32) >>> 32) | (_int(bArr, i) << 32);
    }

    private String convertFromUrlSafe(String str) {
        return str.replace('-', '+').replace('_', JsonPointer.SEPARATOR);
    }

    private String convertToUrlSafe(String str) {
        return str.replace('+', '-').replace(JsonPointer.SEPARATOR, '_');
    }

    public int _badChar(String str, int i, DeserializationContext deserializationContext, char c9) throws JsonMappingException {
        throw deserializationContext.weirdStringException(str, handledType(), String.format("Non-hex character '%c' (value 0x%s), not valid for UUID String", Character.valueOf(c9), Integer.toHexString(c9)));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public UUID _deserialize(String str, DeserializationContext deserializationContext) {
        if (str.length() != 36) {
            if (str.length() == 24) {
                return _fromBytes(Base64Variants.getDefaultVariant().decode(convertFromUrlSafe(str)), deserializationContext);
            }
            if (str.length() != 22) {
                return _badFormat(str, deserializationContext);
            }
            return _fromBytes(Base64Variants.MODIFIED_FOR_URL.decode(convertToUrlSafe(str)), deserializationContext);
        }
        if (str.charAt(8) != '-' || str.charAt(13) != '-' || str.charAt(18) != '-' || str.charAt(23) != '-') {
            _badFormat(str, deserializationContext);
        }
        return new UUID((intFromChars(str, 0, deserializationContext) << 32) + ((shortFromChars(str, 9, deserializationContext) << 16) | shortFromChars(str, 14, deserializationContext)), ((intFromChars(str, 28, deserializationContext) << 32) >>> 32) | ((shortFromChars(str, 24, deserializationContext) | (shortFromChars(str, 19, deserializationContext) << 16)) << 32));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
    public UUID _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) {
        return obj instanceof byte[] ? _fromBytes((byte[]) obj, deserializationContext) : (UUID) super._deserializeEmbedded(obj, deserializationContext);
    }

    public int byteFromChars(String str, int i, DeserializationContext deserializationContext) {
        char cCharAt = str.charAt(i);
        int i3 = i + 1;
        char cCharAt2 = str.charAt(i3);
        if (cCharAt <= 127 && cCharAt2 <= 127) {
            int[] iArr = HEX_DIGITS;
            int i10 = iArr[cCharAt2] | (iArr[cCharAt] << 4);
            if (i10 >= 0) {
                return i10;
            }
        }
        return (cCharAt > 127 || HEX_DIGITS[cCharAt] < 0) ? _badChar(str, i, deserializationContext, cCharAt) : _badChar(str, i3, deserializationContext, cCharAt2);
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object getEmptyValue(DeserializationContext deserializationContext) {
        return new UUID(0L, 0L);
    }

    public int intFromChars(String str, int i, DeserializationContext deserializationContext) {
        return byteFromChars(str, i + 6, deserializationContext) + (byteFromChars(str, i, deserializationContext) << 24) + (byteFromChars(str, i + 2, deserializationContext) << 16) + (byteFromChars(str, i + 4, deserializationContext) << 8);
    }

    public int shortFromChars(String str, int i, DeserializationContext deserializationContext) {
        return byteFromChars(str, i + 2, deserializationContext) + (byteFromChars(str, i, deserializationContext) << 8);
    }
}
