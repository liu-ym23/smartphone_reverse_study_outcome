package com.fasterxml.jackson.dataformat.yaml;

import O6.l;
import W4.a;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigInteger;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.MarkedYAMLException;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes2.dex */
public class YAMLParser extends ParserBase {
    protected boolean _cfgEmptyStringsToNull;
    protected String _cleanedTextValue;
    protected String _currentAnchor;
    protected String _currentFieldName;
    protected boolean _currentIsAlias;
    protected int _formatFeatures;
    protected Event _lastEvent;
    protected Event _lastTagEvent;
    protected ObjectCodec _objectCodec;
    protected final Reader _reader;
    protected String _textValue;
    protected final ParserImpl _yamlParser;
    protected final Resolver _yamlResolver;

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
        public boolean enabledIn(int i10) {
            return (this._mask & i10) != 0;
        }

        @Override // com.fasterxml.jackson.core.FormatFeature, com.fasterxml.jackson.core.util.JacksonFeature
        public int getMask() {
            return this._mask;
        }
    }

    @Deprecated
    public YAMLParser(IOContext iOContext, BufferRecycler bufferRecycler, int i10, int i11, ObjectCodec objectCodec, Reader reader) {
        this(iOContext, i10, i11, (LoaderOptions) null, objectCodec, reader);
    }

    private String _cleanUnderscores(String str, int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(i11);
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
            i10++;
        }
        return sb2.length() == i11 ? str : sb2.toString();
    }

    private JsonToken _cleanYamlFloat(String str) {
        int length = str.length();
        if (str.indexOf(95) < 0 || length == 0) {
            this._cleanedTextValue = str;
            return JsonToken.VALUE_NUMBER_FLOAT;
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i10 = str.charAt(0) == '+' ? 1 : 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
        }
        this._cleanedTextValue = sb2.toString();
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    private JsonToken _cleanYamlInt(String str) throws IOException {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i10 = str.charAt(0) == '+' ? 1 : 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '_') {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        this._cleanedTextValue = string;
        if (string.isEmpty() || l.DATE_SEPARATOR.equals(this._cleanedTextValue)) {
            _reportError(String.format("Invalid number ('%s')", str));
        }
        return JsonToken.VALUE_NUMBER_INT;
    }

    private BigInteger _decodeBigInt(String str, int i10) throws IOException {
        streamReadConstraints().validateIntegerLength(str.length());
        try {
            return i10 == 10 ? NumberInput.parseBigInteger(str, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER)) : NumberInput.parseBigIntegerWithRadix(str, i10, isEnabled(StreamReadFeature.USE_FAST_BIG_NUMBER_PARSER));
        } catch (NumberFormatException e10) {
            return (BigInteger) _reportInvalidNumber(str, i10, e10);
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

    private int _decodeInt(String str, int i10) throws IOException {
        try {
            return Integer.parseInt(str, i10);
        } catch (NumberFormatException e10) {
            return ((Integer) this._reportInvalidNumber(str, i10, e10)).intValue();
        }
    }

    private long _decodeLong(String str, int i10) throws IOException {
        try {
            return Long.parseLong(str, i10);
        } catch (NumberFormatException e10) {
            return ((Long) this._reportInvalidNumber(str, i10, e10)).longValue();
        }
    }

    private <T> T _reportInvalidNumber(String str, int i10, Exception exc) throws IOException {
        _reportError(String.format("Invalid base-%d number ('%s'), problem: %s", Integer.valueOf(i10), str, exc.getMessage()));
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

    public JsonToken _decodeNumberIntBinary(String str, int i10, int i11, boolean z10) throws IOException {
        String str_cleanUnderscores = _cleanUnderscores(str, i10, i11);
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

    public JsonToken _decodeNumberIntHex(String str, int i10, int i11, boolean z10) throws IOException {
        String str_cleanUnderscores = _cleanUnderscores(str, i10, i11);
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

    public JsonToken _decodeNumberIntOctal(String str, int i10, int i11, boolean z10) throws IOException {
        String str_cleanUnderscores = _cleanUnderscores(str, i10, i11);
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
    public com.fasterxml.jackson.core.JsonToken _decodeNumberScalar(java.lang.String r9, int r10) throws java.io.IOException {
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

    public JsonToken _decodeScalar(ScalarEvent scalarEvent) throws IOException {
        String value = scalarEvent.getValue();
        this._textValue = value;
        this._cleanedTextValue = null;
        if (!this._cfgEmptyStringsToNull && value.isEmpty()) {
            return JsonToken.VALUE_STRING;
        }
        String tag = scalarEvent.getTag();
        int length = value.length();
        if (tag == null || tag.equals("!")) {
            Tag tagResolve = this._yamlResolver.resolve(NodeId.scalar, value, scalarEvent.getImplicit().canOmitTagInPlainScalar());
            if (tagResolve == Tag.STR) {
                return JsonToken.VALUE_STRING;
            }
            if (tagResolve == Tag.INT) {
                return _decodeNumberScalar(value, length);
            }
            if (tagResolve == Tag.FLOAT) {
                this._numTypesValid = 0;
                return _cleanYamlFloat(value);
            }
            if (tagResolve != Tag.BOOL) {
                return tagResolve == Tag.NULL ? JsonToken.VALUE_NULL : JsonToken.VALUE_STRING;
            }
            Boolean bool_matchYAMLBoolean = _matchYAMLBoolean(value, length);
            if (bool_matchYAMLBoolean != null) {
                return bool_matchYAMLBoolean.booleanValue() ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
            }
        } else {
            if (tag.startsWith(Tag.PREFIX)) {
                tag = tag.substring(18);
                if (tag.contains(Const.STR_MART_COMMA)) {
                    String[] strArrSplit = tag.split(Const.STR_MART_COMMA);
                    tag = strArrSplit.length == 0 ? "" : strArrSplit[0];
                }
            }
            if ("binary".equals(tag)) {
                try {
                    this._binaryValue = Base64Variants.MIME.decode(value.trim());
                } catch (IllegalArgumentException e10) {
                    _reportError(e10.getMessage());
                }
                return JsonToken.VALUE_EMBEDDED_OBJECT;
            }
            if ("bool".equals(tag)) {
                Boolean bool_matchYAMLBoolean2 = _matchYAMLBoolean(value, length);
                if (bool_matchYAMLBoolean2 != null) {
                    return bool_matchYAMLBoolean2.booleanValue() ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
                }
            } else if (length > 0) {
                if ("int".equals(tag)) {
                    return _decodeNumberScalar(value, length);
                }
                if ("float".equals(tag)) {
                    this._numTypesValid = 0;
                    return _cleanYamlFloat(value);
                }
                if ("null".equals(tag)) {
                    return JsonToken.VALUE_NULL;
                }
            }
        }
        return JsonToken.VALUE_STRING;
    }

    public JsonLocation _locationFor(Mark mark) {
        return mark == null ? new JsonLocation(this._ioContext.contentReference(), -1L, -1, -1) : new JsonLocation(this._ioContext.contentReference(), mark.getIndex(), mark.getLine() + 1, mark.getColumn() + 1);
    }

    public Boolean _matchYAMLBoolean(String str, int i10) {
        if (isEnabled(Feature.PARSE_BOOLEAN_LIKE_WORDS_AS_STRINGS)) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (i10 == 1) {
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
        if (i10 == 2) {
            if ("no".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if (a.ENABLE_ON.equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i10 == 3) {
            if ("yes".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (a.ENABLE_OFF.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        if (i10 == 4) {
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            return null;
        }
        if (i10 == 5 && "false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public int _parseIntValue() throws IOException, NumberFormatException {
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
    public void _parseNumericValue(int i10) throws NumberFormatException, IOException {
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
            if (length <= 18) {
                long j10 = Long.parseLong(this._cleanedTextValue);
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
            String str = this._cleanedTextValue;
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
            if (i10 == 16) {
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
        Event event = this._lastEvent;
        return event == null ? JsonLocation.NA : _locationFor(event.getEndMark());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String currentName() throws IOException {
        return this._currToken == JsonToken.FIELD_NAME ? this._currentFieldName : super.currentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonLocation currentTokenLocation() {
        Event event = this._lastEvent;
        return event == null ? JsonLocation.NA : _locationFor(event.getStartMark());
    }

    public JsonParser disable(Feature feature) {
        int i10 = (~feature.getMask()) & this._formatFeatures;
        this._formatFeatures = i10;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i10);
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
    public String getCurrentName() throws IOException {
        return this._currToken == JsonToken.FIELD_NAME ? this._currentFieldName : super.getCurrentName();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getEmbeddedObject() throws IOException {
        if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
            return this._binaryValue;
        }
        return null;
    }

    public Event getEvent() throws IOException {
        return this._yamlParser.getEvent();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getFormatFeatures() {
        return this._formatFeatures;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser.NumberTypeFP getNumberTypeFP() throws IOException {
        return JsonParser.NumberTypeFP.UNKNOWN;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public Object getNumberValueDeferred() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_NUMBER_INT) {
            if (jsonToken != JsonToken.VALUE_NUMBER_FLOAT) {
                _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            }
            int i10 = this._numTypesValid;
            return (i10 & 16) != 0 ? _getBigDecimal() : (i10 & 8) != 0 ? Double.valueOf(_getNumberDouble()) : (i10 & 32) != 0 ? Float.valueOf(_getNumberFloat()) : this._cleanedTextValue;
        }
        int i11 = this._numTypesValid;
        if ((i11 & 1) != 0) {
            return Integer.valueOf(this._numberInt);
        }
        if ((i11 & 2) != 0) {
            return Long.valueOf(this._numberLong);
        }
        if ((i11 & 4) != 0) {
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
    public String getText() throws IOException {
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
    public char[] getTextCharacters() throws IOException {
        String text = getText();
        if (text == null) {
            return null;
        }
        return text.toCharArray();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextLength() throws IOException {
        String text = getText();
        if (text == null) {
            return 0;
        }
        return text.length();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public int getTextOffset() throws IOException {
        return 0;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    @Deprecated
    public JsonLocation getTokenLocation() {
        return currentTokenLocation();
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
    public JsonToken nextToken() throws IOException {
        this._currentIsAlias = false;
        this._binaryValue = null;
        if (this._closed) {
            return null;
        }
        while (true) {
            try {
                Event event = getEvent();
                if (event == null) {
                    this._currentAnchor = null;
                    this._lastTagEvent = null;
                    return _updateTokenToNull();
                }
                this._lastEvent = event;
                if (this._parsingContext.inObject()) {
                    JsonToken jsonToken = this._currToken;
                    JsonToken jsonToken2 = JsonToken.FIELD_NAME;
                    if (jsonToken != jsonToken2) {
                        if (!event.is(Event.ID.Scalar)) {
                            this._currentAnchor = null;
                            this._lastTagEvent = null;
                            if (event.is(Event.ID.MappingEnd)) {
                                if (!this._parsingContext.inObject()) {
                                    _reportMismatchedEndMarker(125, ']');
                                }
                                this._parsingContext = this._parsingContext.getParent();
                                return _updateToken(JsonToken.END_OBJECT);
                            }
                            _reportError("Expected a field name (Scalar value in YAML), got this instead: " + event);
                        }
                        ScalarEvent scalarEvent = (ScalarEvent) event;
                        String anchor = scalarEvent.getAnchor();
                        boolean z10 = this._currToken == JsonToken.START_OBJECT;
                        if (anchor != null || !z10) {
                            this._currentAnchor = scalarEvent.getAnchor();
                        }
                        if (!z10) {
                            this._lastTagEvent = event;
                        }
                        String value = scalarEvent.getValue();
                        this._currentFieldName = value;
                        this._parsingContext.setCurrentName(value);
                        return _updateToken(jsonToken2);
                    }
                } else if (this._parsingContext.inArray()) {
                    this._parsingContext.expectComma();
                }
                this._currentAnchor = null;
                this._lastTagEvent = event;
                if (event.is(Event.ID.Scalar)) {
                    return _updateToken(_decodeScalar((ScalarEvent) event));
                }
                if (event.is(Event.ID.MappingStart)) {
                    Mark startMark = event.getStartMark();
                    this._currentAnchor = ((MappingStartEvent) event).getAnchor();
                    createChildObjectContext(startMark.getLine(), startMark.getColumn());
                    return _updateToken(JsonToken.START_OBJECT);
                }
                if (event.is(Event.ID.MappingEnd)) {
                    _reportError("Not expecting END_OBJECT but a value");
                }
                if (event.is(Event.ID.SequenceStart)) {
                    Mark startMark2 = event.getStartMark();
                    this._currentAnchor = ((NodeEvent) event).getAnchor();
                    createChildArrayContext(startMark2.getLine(), startMark2.getColumn());
                    return _updateToken(JsonToken.START_ARRAY);
                }
                if (event.is(Event.ID.SequenceEnd)) {
                    if (!this._parsingContext.inArray()) {
                        _reportMismatchedEndMarker(93, '}');
                    }
                    this._parsingContext = this._parsingContext.getParent();
                    return _updateToken(JsonToken.END_ARRAY);
                }
                if (!event.is(Event.ID.DocumentEnd) && !event.is(Event.ID.DocumentStart)) {
                    if (event.is(Event.ID.Alias)) {
                        this._currentIsAlias = true;
                        this._textValue = ((AliasEvent) event).getAnchor();
                        this._cleanedTextValue = null;
                        return _updateToken(JsonToken.VALUE_STRING);
                    }
                    if (event.is(Event.ID.StreamEnd)) {
                        close();
                        return _updateTokenToNull();
                    }
                }
            } catch (NumberFormatException e10) {
                throw _constructError(String.format("Malformed Number token: failed to tokenize due to (%s): %s", e10.getClass().getName(), e10.getMessage()), e10);
            } catch (YAMLException e11) {
                if (e11 instanceof MarkedYAMLException) {
                    throw com.fasterxml.jackson.dataformat.yaml.snakeyaml.error.MarkedYAMLException.from((JsonParser) this, (MarkedYAMLException) e11);
                }
                throw new JacksonYAMLParseException(this, e11.getMessage(), e11);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public JsonParser overrideFormatFeatures(int i10, int i11) {
        int i12 = (i10 & i11) | (this._formatFeatures & (~i11));
        this._formatFeatures = i12;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i12);
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

    /* JADX WARN: Illegal instructions before constructor call */
    public YAMLParser(IOContext iOContext, int i10, int i11, LoaderOptions loaderOptions, ObjectCodec objectCodec, Reader reader) {
        LoaderOptions loaderOptions2 = loaderOptions;
        this(iOContext, i10, i11, objectCodec, reader, new ParserImpl(new StreamReader(reader), loaderOptions2 == null ? new LoaderOptions() : loaderOptions2));
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getObjectId() throws IOException {
        return this._currentAnchor;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String getTypeId() throws IOException {
        String tag;
        Event event = this._lastTagEvent;
        if (!(event instanceof CollectionStartEvent)) {
            if (event instanceof ScalarEvent) {
                tag = ((ScalarEvent) event).getTag();
            }
            return null;
        }
        tag = ((CollectionStartEvent) event).getTag();
        if (tag != null) {
            while (tag.startsWith("!")) {
                tag = tag.substring(1);
            }
            return tag;
        }
        return null;
    }

    public YAMLParser(IOContext iOContext, int i10, int i11, ObjectCodec objectCodec, Reader reader, ParserImpl parserImpl) {
        super(iOContext, i10);
        this._yamlResolver = new Resolver();
        this._objectCodec = objectCodec;
        this._formatFeatures = i11;
        this._reader = reader;
        this._yamlParser = parserImpl;
        this._cfgEmptyStringsToNull = Feature.EMPTY_STRING_AS_NULL.enabledIn(i11);
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
}
