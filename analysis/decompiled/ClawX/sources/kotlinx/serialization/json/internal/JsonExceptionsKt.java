package kotlinx.serialization.json.internal;

import a6.w;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\u0080\u0004\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0080\u0080\u0004\u001a\u0016\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0080\u0080\u0004\u001a\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u0080\u0080\u0004\u001a\u0012\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0080\u0080\u0004\u001a\"\u0010\u0017\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0080\u0080\u0004\u001a\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0082\u0080\u0004\u001a\u0018\u0010\u0019\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004¨\u0006\u001a"}, d2 = {"JsonDecodingException", "Lkotlinx/serialization/json/internal/JsonDecodingException;", "offset", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "input", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "output", "throwInvalidFloatingPointDecoded", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "result", "invalidTrailingComma", "entity", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "InvalidFloatingPointDecoded", "unexpectedFpErrorMessage", "minify", "kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonExceptionsKt {
    public static final JsonDecodingException InvalidFloatingPointDecoded(Number value, String key, String output) {
        p.e(value, "value");
        p.e(key, "key");
        p.e(output, "output");
        return JsonDecodingException(-1, unexpectedFpErrorMessage(value, key, output));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String output) {
        p.e(value, "value");
        p.e(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify$default(output, 0, 1, null)));
    }

    public static final JsonEncodingException InvalidKeyKindException(SerialDescriptor keyDescriptor) {
        p.e(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException JsonDecodingException(int i8, String message) {
        p.e(message, "message");
        if (i8 >= 0) {
            message = "Unexpected JSON token at offset " + i8 + ": " + message;
        }
        return new JsonDecodingException(message);
    }

    public static final Void invalidTrailingComma(AbstractJsonLexer abstractJsonLexer, String entity) {
        p.e(abstractJsonLexer, "<this>");
        p.e(entity, "entity");
        abstractJsonLexer.fail("Trailing comma before the end of JSON ".concat(entity), abstractJsonLexer.currentPosition - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw new w();
    }

    public static /* synthetic */ Void invalidTrailingComma$default(AbstractJsonLexer abstractJsonLexer, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = "object";
        }
        return invalidTrailingComma(abstractJsonLexer, str);
    }

    public static final CharSequence minify(CharSequence charSequence, int i8) {
        p.e(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i8 != -1) {
                int i9 = i8 - 30;
                int i10 = i8 + 30;
                String str = i9 <= 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : ".....";
                String str2 = i10 >= charSequence.length() ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : ".....";
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (i9 < 0) {
                    i9 = 0;
                }
                int length = charSequence.length();
                if (i10 > length) {
                    i10 = length;
                }
                sb.append(charSequence.subSequence(i9, i10).toString());
                sb.append(str2);
                return sb.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static /* synthetic */ CharSequence minify$default(CharSequence charSequence, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = -1;
        }
        return minify(charSequence, i8);
    }

    public static final Void throwInvalidFloatingPointDecoded(AbstractJsonLexer abstractJsonLexer, Number result) {
        p.e(abstractJsonLexer, "<this>");
        p.e(result, "result");
        AbstractJsonLexer.fail$default(abstractJsonLexer, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, AbstractJsonLexerKt.specialFlowingValuesHint, 2, null);
        throw new w();
    }

    private static final String unexpectedFpErrorMessage(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify$default(str2, 0, 1, null));
    }

    public static final JsonDecodingException JsonDecodingException(int i8, String message, CharSequence input) {
        p.e(message, "message");
        p.e(input, "input");
        return JsonDecodingException(i8, message + "\nJSON input: " + ((Object) minify(input, i8)));
    }

    public static final JsonEncodingException InvalidFloatingPointEncoded(Number value, String key, String output) {
        p.e(value, "value");
        p.e(key, "key");
        p.e(output, "output");
        return new JsonEncodingException(unexpectedFpErrorMessage(value, key, output));
    }
}
