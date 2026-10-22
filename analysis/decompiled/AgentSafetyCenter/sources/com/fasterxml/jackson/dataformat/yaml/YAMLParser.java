package com.fasterxml.jackson.dataformat.yaml;

import ce.f;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.MarkedYAMLException;
import de.b;
import ee.a;
import ge.i;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.invoke.VarHandle;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import vd.c;
import vd.e;
import zd.g;
import zd.j;
import zd.k;
import zd.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class YAMLParser extends ParserBase {
    protected boolean _cfgEmptyStringsToNull;
    protected String _cleanedTextValue;
    protected String _currentAnchor;
    protected String _currentFieldName;
    protected boolean _currentIsAlias;
    protected int _formatFeatures;
    protected g _lastEvent;
    protected g _lastTagEvent;
    protected ObjectCodec _objectCodec;
    protected final Reader _reader;
    protected String _textValue;
    protected final f _yamlParser;
    protected final a _yamlResolver;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public enum Feature implements FormatFeature {
        EMPTY_STRING_AS_NULL(true),
        PARSE_BOOLEAN_LIKE_WORDS_AS_STRINGS(false);

        final boolean _defaultState;
        final int _mask = 1 << ordinal();

        Feature(boolean z10) {
            this._defaultState = z10;
        }

        public static int collectDefaults() {
            int mask = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    mask |= feature.getMask();
                }
            }
            return mask;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledByDefault() {
            return this._defaultState;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public boolean enabledIn(int i) {
            return (this._mask & i) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return this._mask;
        }
    }

    public YAMLParser(IOContext iOContext, int i, int i3, e eVar, ObjectCodec objectCodec, Reader reader) {
        e eVar2 = eVar;
        b bVar = new b();
        bVar.f3325d = 0;
        bVar.f3327f = 0;
        bVar.f3328g = 0;
        bVar.f3329h = 0;
        bVar.i = 0;
        if (reader == null) {
            g5.f.g("Reader must be provided.");
            throw null;
        }
        bVar.f3323b = new int[0];
        bVar.f3324c = 0;
        bVar.f3322a = reader;
        bVar.f3326e = false;
        bVar.f3330j = new char[1024];
        VarHandle.storeStoreFence();
        eVar2 = eVar2 == null ? new e() : eVar2;
        fe.b bVar2 = new fe.b();
        bVar2.f4083b = false;
        bVar2.f4084c = 0;
        bVar2.f4087f = 0;
        bVar2.f4088g = -1;
        bVar2.f4090j = true;
        bVar2.f4082a = bVar;
        bVar2.f4085d = new ArrayList(100);
        bVar2.f4089h = new ne.b(10);
        bVar2.f4091k = new LinkedHashMap();
        bVar2.i = eVar2;
        yd.a aVarC = bVar.c();
        bVar2.b(new i(aVarC, aVarC));
        VarHandle.storeStoreFence();
        f fVar = new f();
        fVar.f2275a = bVar2;
        fVar.f2276b = null;
        fVar.f2280f = new p5.e((c) null, new HashMap(f.f2274g));
        fVar.f2277c = new ne.b(100);
        fVar.f2278d = new ne.b(10);
        ce.b bVar3 = new ce.b(19);
        bVar3.f2264b = fVar;
        VarHandle.storeStoreFence();
        fVar.f2279e = bVar3;
        VarHandle.storeStoreFence();
        this(iOContext, i, i3, objectCodec, reader, fVar);
    }

    private String _cleanUnderscores(String str, int i, int i3) {
        StringBuilder sb2 = new StringBuilder(i3);
        while (i < i3) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
            i++;
        }
        return sb2.length() == i3 ? str : sb2.toString();
    }

    private JsonToken _cleanYamlFloat(String str) {
        int length = str.length();
        if (str.indexOf(95) < 0 || length == 0) {
            this._cleanedTextValue = str;
            return JsonToken.VALUE_NUMBER_FLOAT;
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i = str.charAt(0) == '+' ? 1 : 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
        }
        this._cleanedTextValue = sb2.toString();
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    private JsonToken _cleanYamlInt(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i = str.charAt(0) == '+' ? 1 : 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        this._cleanedTextValue = string;
        if (string.isEmpty() || "-".equals(this._cleanedTextValue)) {
            _reportError("Invalid number ('" + str + "')");
        }
        return JsonToken.VALUE_NUMBER_INT;
    }

    private BigInteger _decodeBigInt(String str, int i) throws StreamConstraintsException {
        streamReadConstraints().validateIntegerLength(str.length());
        try {
            return i == 10 ? NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER)) : NumberInput.parseBigIntegerWithRadix(str, i, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e10) {
            return (BigInteger) _reportInvalidNumber(str, i, e10);
        }
    }

    private JsonToken _decodeFromBigInteger(BigInteger bigInteger, boolean z10) {
        if (z10) {
            this._numberBigInt = bigInteger.negate();
        } else {
            this._numberBigInt = bigInteger;
        }
        this._numTypesValid = 4;
        return JsonToken.VALUE_NUMBER_INT;
    }

    private JsonToken _decodeFromLong(long j10, boolean z10, boolean z11) {
        if (z10) {
            j10 = -j10;
            if (z11 && j10 >= -2147483648L) {
                this._numberInt = (int) j10;
                this._numTypesValid = 1;
                return JsonToken.VALUE_NUMBER_INT;
            }
        } else if (z11 && j10 < 2147483647L) {
            this._numberInt = (int) j10;
            this._numTypesValid = 1;
            return JsonToken.VALUE_NUMBER_INT;
        }
        this._numberLong = j10;
        this._numTypesValid = 2;
        return JsonToken.VALUE_NUMBER_INT;
    }

    private int _decodeInt(String str, int i) {
        try {
            return Integer.parseInt(str, i);
        } catch (NumberFormatException e10) {
            return ((Integer) this._reportInvalidNumber(str, i, e10)).intValue();
        }
    }

    private long _decodeLong(String str, int i) {
        try {
            return Long.parseLong(str, i);
        } catch (NumberFormatException e10) {
            return ((Long) this._reportInvalidNumber(str, i, e10)).longValue();
        }
    }

    private <T> T _reportInvalidNumber(String str, int i, Exception exc) {
        _reportError(String.format("Invalid base-%d number ('%s'), problem: %s", Integer.valueOf(i), str, exc.getMessage()));
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
        }
    }

    public JsonToken _decodeNumberIntBinary(String str, int i, int i3, boolean z10) {
        String str_cleanUnderscores = _cleanUnderscores(str, i, i3);
        int length = str_cleanUnderscores.length();
        if (length > 31) {
            if (length <= 63) {
                return _decodeFromLong(_decodeLong(str_cleanUnderscores, 2), z10, length == 32);
            }
            return _decodeFromBigInteger(_decodeBigInt(str_cleanUnderscores, 2), z10);
        }
        int i_decodeInt = _decodeInt(str_cleanUnderscores, 2);
        if (z10) {
            i_decodeInt = -i_decodeInt;
        }
        this._numberInt = i_decodeInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    public JsonToken _decodeNumberIntHex(String str, int i, int i3, boolean z10) {
        String str_cleanUnderscores = _cleanUnderscores(str, i, i3);
        int length = str_cleanUnderscores.length();
        if (length > 7) {
            if (length <= 15) {
                return _decodeFromLong(_decodeLong(str_cleanUnderscores, 16), z10, length == 8);
            }
            return _decodeFromBigInteger(_decodeBigInt(str_cleanUnderscores, 16), z10);
        }
        int i_decodeInt = _decodeInt(str_cleanUnderscores, 16);
        if (z10) {
            i_decodeInt = -i_decodeInt;
        }
        this._numberInt = i_decodeInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    public JsonToken _decodeNumberIntOctal(String str, int i, int i3, boolean z10) {
        String str_cleanUnderscores = _cleanUnderscores(str, i, i3);
        int length = str_cleanUnderscores.length();
        if (length > 10) {
            return length <= 21 ? _decodeFromLong(_decodeLong(str_cleanUnderscores, 8), z10, false) : _decodeFromBigInteger(_decodeBigInt(str_cleanUnderscores, 8), z10);
        }
        int i_decodeInt = _decodeInt(str_cleanUnderscores, 8);
        if (z10) {
            i_decodeInt = -i_decodeInt;
        }
        this._numberInt = i_decodeInt;
        this._numTypesValid = 1;
        return JsonToken.VALUE_NUMBER_INT;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d A[ADDED_TO_REGION, REMOVE, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _decodeNumberScalar(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            char r1 = r9.charAt(r0)
            r2 = 45
            r3 = 0
            r4 = 1
            if (r1 != r2) goto Lf
            r8._numberNegative = r4
        Ld:
            r1 = r4
            goto L1b
        Lf:
            r2 = 43
            if (r1 != r2) goto L18
            r8._numberNegative = r0
            if (r10 != r4) goto Ld
            return r3
        L18:
            r8._numberNegative = r0
            r1 = r0
        L1b:
            if (r10 != r1) goto L1e
            return r3
        L1e:
            char r2 = r9.charAt(r1)
            r3 = 95
            r5 = 48
            if (r2 != r5) goto L68
            int r2 = r1 + 1
            if (r2 != r10) goto L33
            r8._numberInt = r0
            r8._numTypesValid = r4
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            return r8
        L33:
            char r0 = r9.charAt(r2)
            r4 = 66
            if (r0 == r4) goto L5f
            r4 = 88
            if (r0 == r4) goto L56
            if (r0 == r3) goto L4f
            r3 = 98
            if (r0 == r3) goto L5f
            r3 = 120(0x78, float:1.68E-43)
            if (r0 == r3) goto L56
            switch(r0) {
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L4f;
                case 51: goto L4f;
                case 52: goto L4f;
                case 53: goto L4f;
                case 54: goto L4f;
                case 55: goto L4f;
                case 56: goto L4f;
                case 57: goto L4f;
                default: goto L4c;
            }
        L4c:
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r8
        L4f:
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r8 = r8._decodeNumberIntOctal(r9, r2, r10, r0)
            return r8
        L56:
            int r1 = r1 + 2
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r8 = r8._decodeNumberIntHex(r9, r1, r10, r0)
            return r8
        L5f:
            int r1 = r1 + 2
            boolean r0 = r8._numberNegative
            com.fasterxml.jackson.core.JsonToken r8 = r8._decodeNumberIntBinary(r9, r1, r10, r0)
            return r8
        L68:
            r2 = r0
        L69:
            char r6 = r9.charAt(r1)
            r7 = 57
            if (r6 > r7) goto L73
            if (r6 >= r5) goto L76
        L73:
            if (r6 != r3) goto L8a
            r2 = r4
        L76:
            int r1 = r1 + 1
            if (r1 != r10) goto L69
            r8._numTypesValid = r0
            if (r2 == 0) goto L83
            com.fasterxml.jackson.core.JsonToken r8 = r8._cleanYamlInt(r9)
            return r8
        L83:
            java.lang.String r9 = r8._textValue
            r8._cleanedTextValue = r9
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            return r8
        L8a:
            com.fasterxml.jackson.core.JsonToken r8 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.YAMLParser._decodeNumberScalar(java.lang.String, int):com.fasterxml.jackson.core.JsonToken");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.fasterxml.jackson.core.JsonToken _decodeScalar(zd.l r10) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.YAMLParser._decodeScalar(zd.l):com.fasterxml.jackson.core.JsonToken");
    }

    public JsonLocation _locationFor(yd.a aVar) {
        return aVar == null ? new JsonLocation(this._ioContext.contentReference(), -1L, -1, -1) : new JsonLocation(this._ioContext.contentReference(), aVar.f16119c, aVar.f16120f + 1, aVar.f16121g + 1);
    }

    public Boolean _matchYAMLBoolean(String str, int i) {
        if (isEnabled(Feature.PARSE_BOOLEAN_LIKE_WORDS_AS_STRINGS)) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (i == 1) {
            char cCharAt = str.charAt(0);
            if (cCharAt != 'N') {
                if (cCharAt != 'Y') {
                    if (cCharAt != 'n') {
                        if (cCharAt != 'y') {
                            return null;
                        }
                    }
                }
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        if (i == 2) {
            if ("no".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if ("on".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i == 3) {
            if ("yes".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("off".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (i == 4) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i == 5 && "false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public int _parseIntValue() throws NumberFormatException, JsonParseException, StreamConstraintsException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int length = this._cleanedTextValue.length();
            if (this._numberNegative) {
                length--;
            }
            if (length <= 9) {
                int i_decodeInt = _decodeInt(this._cleanedTextValue, 10);
                this._numberInt = i_decodeInt;
                this._numTypesValid = 1;
                return i_decodeInt;
            }
        }
        _parseNumericValue(1);
        if ((this._numTypesValid & 1) == 0) {
            convertNumberToInt();
        }
        return this._numberInt;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _parseNumericValue(int i) throws NumberFormatException, JsonParseException, StreamConstraintsException {
        if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
            int length = this._cleanedTextValue.length();
            if (this._numberNegative) {
                length--;
            }
            if (length <= 9) {
                this._numberInt = _decodeInt(this._cleanedTextValue, 10);
                this._numTypesValid = 1;
                return;
            }
            String str = this._cleanedTextValue;
            if (length <= 18) {
                long j10 = Long.parseLong(str);
                if (length == 10) {
                    if (this._numberNegative) {
                        if (j10 >= -2147483648L) {
                            this._numberInt = (int) j10;
                            this._numTypesValid = 1;
                            return;
                        }
                    } else if (j10 <= 2147483647L) {
                        this._numberInt = (int) j10;
                        this._numTypesValid = 1;
                        return;
                    }
                }
                this._numberLong = j10;
                this._numTypesValid = 2;
                return;
            }
            try {
                streamReadConstraints().validateIntegerLength(str.length());
                BigInteger bigInteger = NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
                if (length != 19 || bigInteger.bitLength() > 63) {
                    this._numberBigInt = bigInteger;
                    this._numTypesValid = 4;
                    return;
                } else {
                    this._numberLong = bigInteger.longValue();
                    this._numTypesValid = 2;
                    return;
                }
            } catch (NumberFormatException e10) {
                _wrapError("Malformed numeric value '" + this._textValue + "'", e10);
            }
        }
        if (this._currToken != JsonToken.VALUE_NUMBER_FLOAT) {
            _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            return;
        }
        String str2 = this._cleanedTextValue;
        try {
            if (i == 16) {
                streamReadConstraints().validateFPLength(str2.length());
                this._numberBigDecimal = NumberInput.parseBigDecimal(str2, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
                this._numTypesValid = 16;
            } else {
                streamReadConstraints().validateFPLength(str2.length());
                this._numberDouble = NumberInput.parseDouble(str2, isEnabled(StreamReadFeature.USE_FAST_DOUBLE_PARSER));
                this._numTypesValid = 8;
            }
        } catch (NumberFormatException e11) {
            _wrapError("Malformed numeric value '" + this._textValue + "'", e11);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canReadObjectId() {
        return true;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean canReadTypeId() {
        return true;
    }

    public JsonParser configure(Feature feature, boolean z10) {
        if (z10) {
            enable(feature);
            return this;
        }
        disable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentLocation() {
        g gVar = this._lastEvent;
        return gVar == null ? JsonLocation.NA : _locationFor(gVar.f16588b);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String currentName() {
        return this._currToken == JsonToken.FIELD_NAME ? this._currentFieldName : super.currentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        g gVar = this._lastEvent;
        return gVar == null ? JsonLocation.NA : _locationFor(gVar.f16587a);
    }

    public JsonParser disable(Feature feature) {
        int i = (~feature.getMask()) & this._formatFeatures;
        this._formatFeatures = i;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i);
        return this;
    }

    public JsonParser enable(Feature feature) {
        int mask = feature.getMask() | this._formatFeatures;
        this._formatFeatures = mask;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(mask);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Deprecated
    public String getCurrentAnchor() {
        return this._currentAnchor;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonLocation getCurrentLocation() {
        return currentLocation();
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public String getCurrentName() {
        return this._currToken == JsonToken.FIELD_NAME ? this._currentFieldName : super.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this._binaryValue;
        }
        return null;
    }

    public g getEvent() {
        ce.g gVar;
        f fVar = this._yamlParser;
        if (fVar.f2276b == null && (gVar = fVar.f2279e) != null) {
            fVar.f2276b = gVar.a();
        }
        g gVar2 = fVar.f2276b;
        fVar.f2276b = null;
        return gVar2;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberTypeFP getNumberTypeFP() {
        return JsonParser.NumberTypeFP.UNKNOWN;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public Object getNumberValueDeferred() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT) {
            if (jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
                _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            }
            int i = this._numTypesValid;
            return (i & 16) != 0 ? _getBigDecimal() : (i & 8) != 0 ? Double.valueOf(_getNumberDouble()) : (i & 32) != 0 ? Float.valueOf(_getNumberFloat()) : this._cleanedTextValue;
        }
        int i3 = this._numTypesValid;
        if ((i3 & 1) != 0) {
            return Integer.valueOf(this._numberInt);
        }
        if ((i3 & 2) != 0) {
            return Long.valueOf(this._numberLong);
        }
        if ((i3 & 4) != 0) {
            return _getBigInteger();
        }
        if (this._cleanedTextValue == null) {
            _reportError("Internal number decoding error: `_cleanedTextValue` null when nothing decoded for `JsonToken.VALUE_NUMBER_INT`");
        }
        return this._cleanedTextValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JacksonFeatureSet<StreamReadCapability> getReadCapabilities() {
        return JsonParser.DEFAULT_READ_CAPABILITIES;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public String getText() {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            return this._textValue;
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return this._currentFieldName;
        }
        if (jsonToken != null) {
            return jsonToken.isScalarValue() ? this._textValue : this._currToken.asString();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public char[] getTextCharacters() {
        String text = getText();
        if (text == null) {
            return null;
        }
        return text.toCharArray();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() {
        String text = getText();
        if (text == null) {
            return 0;
        }
        return text.length();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonLocation getTokenLocation() {
        return currentTokenLocation();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getTypeId() {
        String strSubstring;
        g gVar = this._lastTagEvent;
        if (!(gVar instanceof zd.c)) {
            if (gVar instanceof l) {
                strSubstring = ((l) gVar).f16592d;
            }
            return null;
        }
        strSubstring = ((zd.c) gVar).f16578d;
        if (strSubstring != null) {
            while (strSubstring.startsWith("!")) {
                strSubstring = strSubstring.substring(1);
            }
            return strSubstring;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public boolean hasTextCharacters() {
        return false;
    }

    public boolean isCurrentAlias() {
        return this._currentIsAlias;
    }

    public boolean isEnabled(Feature feature) {
        return (this._formatFeatures & feature.getMask()) != 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public JsonToken nextToken() throws JsonParseException {
        this._currentIsAlias = false;
        this._binaryValue = null;
        if (this._closed) {
            return null;
        }
        while (true) {
            try {
                g event = getEvent();
                if (event == null) {
                    this._currentAnchor = null;
                    this._lastTagEvent = null;
                    return _updateTokenToNull();
                }
                yd.a aVar = event.f16587a;
                this._lastEvent = event;
                if (this._parsingContext.inObject()) {
                    JsonToken jsonToken = this._currToken;
                    JsonToken jsonToken2 = JsonToken.FIELD_NAME;
                    if (jsonToken != jsonToken2) {
                        if (!event.c(7)) {
                            this._currentAnchor = null;
                            this._lastTagEvent = null;
                            if (event.c(5)) {
                                if (!this._parsingContext.inObject()) {
                                    _reportMismatchedEndMarker(125, ']');
                                }
                                this._parsingContext = this._parsingContext.getParent();
                                return _updateToken(JsonToken.END_OBJECT);
                            }
                            _reportError("Expected a field name (Scalar value in YAML), got this instead: " + event);
                        }
                        l lVar = (l) event;
                        String str = lVar.f16591c;
                        boolean z10 = this._currToken == JsonToken.START_OBJECT;
                        if (str != null || !z10) {
                            this._currentAnchor = str;
                        }
                        if (!z10) {
                            this._lastTagEvent = event;
                        }
                        String str2 = lVar.f16594f;
                        this._currentFieldName = str2;
                        this._parsingContext.setCurrentName(str2);
                        return _updateToken(jsonToken2);
                    }
                } else if (this._parsingContext.inArray()) {
                    this._parsingContext.expectComma();
                }
                this._currentAnchor = null;
                this._lastTagEvent = event;
                if (event.c(7)) {
                    return _updateToken(_decodeScalar((l) event));
                }
                if (event.c(6)) {
                    this._currentAnchor = ((j) event).f16591c;
                    createChildObjectContext(aVar.f16120f, aVar.f16121g);
                    return _updateToken(JsonToken.START_OBJECT);
                }
                if (event.c(5)) {
                    _reportError("Not expecting END_OBJECT but a value");
                }
                if (event.c(9)) {
                    this._currentAnchor = ((k) event).f16591c;
                    createChildArrayContext(aVar.f16120f, aVar.f16121g);
                    return _updateToken(JsonToken.START_ARRAY);
                }
                if (event.c(8)) {
                    if (!this._parsingContext.inArray()) {
                        _reportMismatchedEndMarker(93, '}');
                    }
                    this._parsingContext = this._parsingContext.getParent();
                    return _updateToken(JsonToken.END_ARRAY);
                }
                if (!event.c(3) && !event.c(4)) {
                    if (event.c(1)) {
                        this._currentIsAlias = true;
                        this._textValue = ((zd.a) event).f16591c;
                        this._cleanedTextValue = null;
                        return _updateToken(JsonToken.VALUE_STRING);
                    }
                    if (event.c(10)) {
                        close();
                        return _updateTokenToNull();
                    }
                }
            } catch (NumberFormatException e10) {
                throw _constructError(androidx.activity.b.j("Malformed Number token: failed to tokenize due to (", e10.getClass().getName(), "): ", e10.getMessage()), e10);
            } catch (yd.c e11) {
                if (e11 instanceof yd.b) {
                    throw MarkedYAMLException.from((JsonParser) this, (yd.b) e11);
                }
                throw new JacksonYAMLParseException(this, e11.getMessage(), e11);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideFormatFeatures(int i, int i3) {
        int i10 = (i & i3) | (this._formatFeatures & (~i3));
        this._formatFeatures = i10;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i10);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        byte[] binaryValue = getBinaryValue(base64Variant);
        outputStream.write(binaryValue);
        return binaryValue.length;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean requiresCustomCodec() {
        return false;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return PackageVersion.VERSION;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getObjectId() {
        return this._currentAnchor;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        String text = getText();
        if (text == null) {
            return 0;
        }
        writer.write(text);
        return text.length();
    }

    @Deprecated
    public YAMLParser(IOContext iOContext, BufferRecycler bufferRecycler, int i, int i3, ObjectCodec objectCodec, Reader reader) {
        this(iOContext, i, i3, (e) null, objectCodec, reader);
    }

    public YAMLParser(IOContext iOContext, int i, int i3, ObjectCodec objectCodec, Reader reader, f fVar) {
        super(iOContext, i);
        a aVar = new a();
        aVar.f3850a = new HashMap();
        aVar.a(be.a.f2087h, a.f3843b, "yYnNtTfFoO", 10);
        aVar.a(be.a.f2084e, a.f3845d, "-+0123456789", 1024);
        aVar.a(be.a.f2085f, a.f3844c, "-+0123456789.", 1024);
        aVar.a(be.a.f2082c, a.f3846e, "<", 10);
        be.a aVar2 = be.a.i;
        aVar.a(aVar2, a.f3847f, "~nN\u0000", 10);
        aVar.a(aVar2, a.f3848g, null, 10);
        aVar.a(be.a.f2086g, a.f3849h, "0123456789", 50);
        aVar.a(be.a.f2081b, a.i, "!&*", 10);
        this._yamlResolver = aVar;
        this._objectCodec = objectCodec;
        this._formatFeatures = i3;
        this._reader = reader;
        this._yamlParser = fVar;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i3);
    }
}
