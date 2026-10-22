package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.message.TokenParser;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
@GwtCompatible
public final class MediaType {
    public static final MediaType AAC_AUDIO = null;
    public static final MediaType ANY_APPLICATION_TYPE = null;
    public static final MediaType ANY_AUDIO_TYPE = null;
    public static final MediaType ANY_IMAGE_TYPE = null;
    public static final MediaType ANY_TEXT_TYPE = null;
    public static final MediaType ANY_TYPE = null;
    public static final MediaType ANY_VIDEO_TYPE = null;
    public static final MediaType APPLE_MOBILE_CONFIG = null;
    public static final MediaType APPLE_PASSBOOK = null;
    public static final MediaType APPLICATION_BINARY = null;
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType APPLICATION_XML_UTF_8 = null;
    public static final MediaType ATOM_UTF_8 = null;
    private static final String AUDIO_TYPE = "audio";
    public static final MediaType BASIC_AUDIO = null;
    public static final MediaType BMP = null;
    public static final MediaType BZIP2 = null;
    public static final MediaType CACHE_MANIFEST_UTF_8 = null;
    private static final String CHARSET_ATTRIBUTE = "charset";
    public static final MediaType CRW = null;
    public static final MediaType CSS_UTF_8 = null;
    public static final MediaType CSV_UTF_8 = null;
    public static final MediaType DART_UTF_8 = null;
    public static final MediaType EOT = null;
    public static final MediaType EPUB = null;
    public static final MediaType FLV_VIDEO = null;
    public static final MediaType FORM_DATA = null;
    public static final MediaType GEO_JSON = null;
    public static final MediaType GIF = null;
    public static final MediaType GZIP = null;
    public static final MediaType HAL_JSON = null;
    public static final MediaType HTML_UTF_8 = null;
    public static final MediaType ICO = null;
    private static final String IMAGE_TYPE = "image";
    public static final MediaType I_CALENDAR_UTF_8 = null;
    public static final MediaType JAVASCRIPT_UTF_8 = null;
    public static final MediaType JOSE = null;
    public static final MediaType JOSE_JSON = null;
    public static final MediaType JPEG = null;
    public static final MediaType JSON_UTF_8 = null;
    public static final MediaType KEY_ARCHIVE = null;
    public static final MediaType KML = null;
    public static final MediaType KMZ = null;
    private static final Map<MediaType, MediaType> KNOWN_TYPES = null;
    public static final MediaType L16_AUDIO = null;
    public static final MediaType L24_AUDIO = null;
    private static final CharMatcher LINEAR_WHITE_SPACE = null;
    public static final MediaType MANIFEST_JSON_UTF_8 = null;
    public static final MediaType MBOX = null;
    public static final MediaType MICROSOFT_EXCEL = null;
    public static final MediaType MICROSOFT_OUTLOOK = null;
    public static final MediaType MICROSOFT_POWERPOINT = null;
    public static final MediaType MICROSOFT_WORD = null;
    public static final MediaType MP4_AUDIO = null;
    public static final MediaType MP4_VIDEO = null;
    public static final MediaType MPEG_AUDIO = null;
    public static final MediaType MPEG_VIDEO = null;
    public static final MediaType NACL_APPLICATION = null;
    public static final MediaType NACL_PORTABLE_APPLICATION = null;
    public static final MediaType OCTET_STREAM = null;
    public static final MediaType OGG_AUDIO = null;
    public static final MediaType OGG_CONTAINER = null;
    public static final MediaType OGG_VIDEO = null;
    public static final MediaType OOXML_DOCUMENT = null;
    public static final MediaType OOXML_PRESENTATION = null;
    public static final MediaType OOXML_SHEET = null;
    public static final MediaType OPENDOCUMENT_GRAPHICS = null;
    public static final MediaType OPENDOCUMENT_PRESENTATION = null;
    public static final MediaType OPENDOCUMENT_SPREADSHEET = null;
    public static final MediaType OPENDOCUMENT_TEXT = null;
    private static final Joiner.MapJoiner PARAMETER_JOINER = null;
    public static final MediaType PDF = null;
    public static final MediaType PLAIN_TEXT_UTF_8 = null;
    public static final MediaType PNG = null;
    public static final MediaType POSTSCRIPT = null;
    public static final MediaType PROTOBUF = null;
    public static final MediaType PSD = null;
    public static final MediaType QUICKTIME = null;
    private static final CharMatcher QUOTED_TEXT_MATCHER = null;
    public static final MediaType RDF_XML_UTF_8 = null;
    public static final MediaType RTF_UTF_8 = null;
    public static final MediaType SFNT = null;
    public static final MediaType SHOCKWAVE_FLASH = null;
    public static final MediaType SKETCHUP = null;
    public static final MediaType SOAP_XML_UTF_8 = null;
    public static final MediaType SVG_UTF_8 = null;
    public static final MediaType TAR = null;
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = null;
    private static final String TEXT_TYPE = "text";
    public static final MediaType THREE_GPP2_VIDEO = null;
    public static final MediaType THREE_GPP_VIDEO = null;
    public static final MediaType TIFF = null;
    private static final CharMatcher TOKEN_MATCHER = null;
    public static final MediaType TSV_UTF_8 = null;
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = null;
    public static final MediaType VCARD_UTF_8 = null;
    private static final String VIDEO_TYPE = "video";
    public static final MediaType VND_REAL_AUDIO = null;
    public static final MediaType VND_WAVE_AUDIO = null;
    public static final MediaType VORBIS_AUDIO = null;
    public static final MediaType VTT_UTF_8 = null;
    public static final MediaType WASM_APPLICATION = null;
    public static final MediaType WAX_AUDIO = null;
    public static final MediaType WEBM_AUDIO = null;
    public static final MediaType WEBM_VIDEO = null;
    public static final MediaType WEBP = null;
    private static final String WILDCARD = "*";
    public static final MediaType WMA_AUDIO = null;
    public static final MediaType WML_UTF_8 = null;
    public static final MediaType WMV = null;
    public static final MediaType WOFF = null;
    public static final MediaType WOFF2 = null;
    public static final MediaType XHTML_UTF_8 = null;
    public static final MediaType XML_UTF_8 = null;
    public static final MediaType XRD_UTF_8 = null;
    public static final MediaType ZIP = null;

    @LazyInit
    private int hashCode;
    private final ImmutableListMultimap<String, String> parameters;

    @LazyInit
    private Optional<Charset> parsedCharset;
    private final String subtype;

    @LazyInit
    private String toString;
    private final String type;

    public static final class Tokenizer {
        final String input;
        int position;

        public Tokenizer(String r10) {
            this.position = 0;
            this.input = r10;
        }

        public char consumeCharacter(CharMatcher r10) {
            Preconditions.checkState(hasMore());
            char r11 = previewChar();
            Preconditions.checkState(r10.matches(r11));
            this.position++;
            return r11;
        }

        public String consumeToken(CharMatcher r10) {
            int r11 = this.position;
            String r12 = consumeTokenIfPresent(r10);
            if (this.position == r11) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkState(r13);
            return r12;
        L5:
            r13 = false;
            goto L6
        }

        public String consumeTokenIfPresent(CharMatcher r10) {
            Preconditions.checkState(hasMore());
            int r11 = this.position;
            this.position = r10.negate().indexIn(this.input, r11);
            if (hasMore() == false) goto L6;
            return this.input.substring(r11, this.position);
        L6:
            return this.input.substring(r11);
        }

        public boolean hasMore() {
            int r10 = this.position;
            if (r10 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r10 >= this.input.length()) goto L7;
            return true;
        }

        public char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        public char consumeCharacter(char r10) {
            Preconditions.checkState(hasMore());
            if (previewChar() != r10) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkState(r11);
            this.position++;
            return r10;
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of(CHARSET_ATTRIBUTE, Ascii.toLowerCase(Charsets.UTF_8.name()));
        TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(TokenParser.SP)).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
        QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
        LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
        KNOWN_TYPES = Maps.newHashMap();
        ANY_TYPE = createConstant(WILDCARD, WILDCARD);
        ANY_TEXT_TYPE = createConstant(TEXT_TYPE, WILDCARD);
        ANY_IMAGE_TYPE = createConstant("image", WILDCARD);
        ANY_AUDIO_TYPE = createConstant(AUDIO_TYPE, WILDCARD);
        ANY_VIDEO_TYPE = createConstant("video", WILDCARD);
        ANY_APPLICATION_TYPE = createConstant(APPLICATION_TYPE, WILDCARD);
        CACHE_MANIFEST_UTF_8 = createConstantUtf8(TEXT_TYPE, "cache-manifest");
        CSS_UTF_8 = createConstantUtf8(TEXT_TYPE, "css");
        CSV_UTF_8 = createConstantUtf8(TEXT_TYPE, "csv");
        HTML_UTF_8 = createConstantUtf8(TEXT_TYPE, "html");
        I_CALENDAR_UTF_8 = createConstantUtf8(TEXT_TYPE, "calendar");
        PLAIN_TEXT_UTF_8 = createConstantUtf8(TEXT_TYPE, "plain");
        TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8(TEXT_TYPE, "javascript");
        TSV_UTF_8 = createConstantUtf8(TEXT_TYPE, "tab-separated-values");
        VCARD_UTF_8 = createConstantUtf8(TEXT_TYPE, "vcard");
        WML_UTF_8 = createConstantUtf8(TEXT_TYPE, "vnd.wap.wml");
        XML_UTF_8 = createConstantUtf8(TEXT_TYPE, "xml");
        VTT_UTF_8 = createConstantUtf8(TEXT_TYPE, "vtt");
        BMP = createConstant("image", "bmp");
        CRW = createConstant("image", "x-canon-crw");
        GIF = createConstant("image", "gif");
        ICO = createConstant("image", "vnd.microsoft.icon");
        JPEG = createConstant("image", "jpeg");
        PNG = createConstant("image", "png");
        PSD = createConstant("image", "vnd.adobe.photoshop");
        SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
        TIFF = createConstant("image", "tiff");
        WEBP = createConstant("image", "webp");
        MP4_AUDIO = createConstant(AUDIO_TYPE, "mp4");
        MPEG_AUDIO = createConstant(AUDIO_TYPE, "mpeg");
        OGG_AUDIO = createConstant(AUDIO_TYPE, "ogg");
        WEBM_AUDIO = createConstant(AUDIO_TYPE, "webm");
        L16_AUDIO = createConstant(AUDIO_TYPE, "l16");
        L24_AUDIO = createConstant(AUDIO_TYPE, "l24");
        BASIC_AUDIO = createConstant(AUDIO_TYPE, "basic");
        AAC_AUDIO = createConstant(AUDIO_TYPE, "aac");
        VORBIS_AUDIO = createConstant(AUDIO_TYPE, "vorbis");
        WMA_AUDIO = createConstant(AUDIO_TYPE, "x-ms-wma");
        WAX_AUDIO = createConstant(AUDIO_TYPE, "x-ms-wax");
        VND_REAL_AUDIO = createConstant(AUDIO_TYPE, "vnd.rn-realaudio");
        VND_WAVE_AUDIO = createConstant(AUDIO_TYPE, "vnd.wave");
        MP4_VIDEO = createConstant("video", "mp4");
        MPEG_VIDEO = createConstant("video", "mpeg");
        OGG_VIDEO = createConstant("video", "ogg");
        QUICKTIME = createConstant("video", "quicktime");
        WEBM_VIDEO = createConstant("video", "webm");
        WMV = createConstant("video", "x-ms-wmv");
        FLV_VIDEO = createConstant("video", "x-flv");
        THREE_GPP_VIDEO = createConstant("video", "3gpp");
        THREE_GPP2_VIDEO = createConstant("video", "3gpp2");
        APPLICATION_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xml");
        ATOM_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "atom+xml");
        BZIP2 = createConstant(APPLICATION_TYPE, "x-bzip2");
        DART_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "dart");
        APPLE_PASSBOOK = createConstant(APPLICATION_TYPE, "vnd.apple.pkpass");
        EOT = createConstant(APPLICATION_TYPE, "vnd.ms-fontobject");
        EPUB = createConstant(APPLICATION_TYPE, "epub+zip");
        FORM_DATA = createConstant(APPLICATION_TYPE, "x-www-form-urlencoded");
        KEY_ARCHIVE = createConstant(APPLICATION_TYPE, "pkcs12");
        APPLICATION_BINARY = createConstant(APPLICATION_TYPE, "binary");
        GEO_JSON = createConstant(APPLICATION_TYPE, "geo+json");
        GZIP = createConstant(APPLICATION_TYPE, "x-gzip");
        HAL_JSON = createConstant(APPLICATION_TYPE, "hal+json");
        JAVASCRIPT_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "javascript");
        JOSE = createConstant(APPLICATION_TYPE, "jose");
        JOSE_JSON = createConstant(APPLICATION_TYPE, "jose+json");
        JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "json");
        MANIFEST_JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "manifest+json");
        KML = createConstant(APPLICATION_TYPE, "vnd.google-earth.kml+xml");
        KMZ = createConstant(APPLICATION_TYPE, "vnd.google-earth.kmz");
        MBOX = createConstant(APPLICATION_TYPE, "mbox");
        APPLE_MOBILE_CONFIG = createConstant(APPLICATION_TYPE, "x-apple-aspen-config");
        MICROSOFT_EXCEL = createConstant(APPLICATION_TYPE, "vnd.ms-excel");
        MICROSOFT_OUTLOOK = createConstant(APPLICATION_TYPE, "vnd.ms-outlook");
        MICROSOFT_POWERPOINT = createConstant(APPLICATION_TYPE, "vnd.ms-powerpoint");
        MICROSOFT_WORD = createConstant(APPLICATION_TYPE, "msword");
        WASM_APPLICATION = createConstant(APPLICATION_TYPE, "wasm");
        NACL_APPLICATION = createConstant(APPLICATION_TYPE, "x-nacl");
        NACL_PORTABLE_APPLICATION = createConstant(APPLICATION_TYPE, "x-pnacl");
        OCTET_STREAM = createConstant(APPLICATION_TYPE, "octet-stream");
        OGG_CONTAINER = createConstant(APPLICATION_TYPE, "ogg");
        OOXML_DOCUMENT = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.wordprocessingml.document");
        OOXML_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.presentationml.presentation");
        OOXML_SHEET = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        OPENDOCUMENT_GRAPHICS = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.graphics");
        OPENDOCUMENT_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.presentation");
        OPENDOCUMENT_SPREADSHEET = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.spreadsheet");
        OPENDOCUMENT_TEXT = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.text");
        PDF = createConstant(APPLICATION_TYPE, "pdf");
        POSTSCRIPT = createConstant(APPLICATION_TYPE, "postscript");
        PROTOBUF = createConstant(APPLICATION_TYPE, "protobuf");
        RDF_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rdf+xml");
        RTF_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rtf");
        SFNT = createConstant(APPLICATION_TYPE, "font-sfnt");
        SHOCKWAVE_FLASH = createConstant(APPLICATION_TYPE, "x-shockwave-flash");
        SKETCHUP = createConstant(APPLICATION_TYPE, "vnd.sketchup.skp");
        SOAP_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "soap+xml");
        TAR = createConstant(APPLICATION_TYPE, "x-tar");
        WOFF = createConstant(APPLICATION_TYPE, "font-woff");
        WOFF2 = createConstant(APPLICATION_TYPE, "font-woff2");
        XHTML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xhtml+xml");
        XRD_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xrd+xml");
        ZIP = createConstant(APPLICATION_TYPE, "zip");
        PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    }

    private MediaType(String r10, String r11, ImmutableListMultimap<String, String> r12) {
        this.type = r10;
        this.subtype = r11;
        this.parameters = r12;
    }

    public static /* synthetic */ CharMatcher access$000() {
        return TOKEN_MATCHER;
    }

    public static /* synthetic */ String access$100(String r10) {
        return escapeAndQuote(r10);
    }

    private static MediaType addKnownType(MediaType r10) {
        KNOWN_TYPES.put(r10, r10);
        return r10;
    }

    private String computeToString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.type);
        r10.append('/');
        r10.append(this.subtype);
        if (this.parameters.isEmpty() == true) goto L6;
        r10.append("; ");
        ListMultimap r11 = Multimaps.transformValues(this.parameters, new AnonymousClass2(this));
        PARAMETER_JOINER.appendTo(r10, r11.entries());
    L6:
        return r10.toString();
    }

    public static MediaType create(String r10, String r11) {
        MediaType r12 = create(r10, r11, ImmutableListMultimap.of());
        r12.parsedCharset = Optional.absent();
        return r12;
    }

    public static MediaType createApplicationType(String r10) {
        return create(APPLICATION_TYPE, r10);
    }

    public static MediaType createAudioType(String r10) {
        return create(AUDIO_TYPE, r10);
    }

    private static MediaType createConstant(String r10, String r11) {
        MediaType r12 = addKnownType(new MediaType(r10, r11, ImmutableListMultimap.of()));
        r12.parsedCharset = Optional.absent();
        return r12;
    }

    private static MediaType createConstantUtf8(String r10, String r11) {
        MediaType r12 = addKnownType(new MediaType(r10, r11, UTF_8_CONSTANT_PARAMETERS));
        r12.parsedCharset = Optional.of(Charsets.UTF_8);
        return r12;
    }

    public static MediaType createImageType(String r10) {
        return create("image", r10);
    }

    public static MediaType createTextType(String r10) {
        return create(TEXT_TYPE, r10);
    }

    public static MediaType createVideoType(String r10) {
        return create("video", r10);
    }

    private static String escapeAndQuote(String r10) {
        StringBuilder r11 = new StringBuilder(r10.length() + 16);
        r11.append(TokenParser.DQUOTE);
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L11;
        char r13 = r10.charAt(r12);
        if (r13 == '\r') goto L9;
        if (r13 == '\\') goto L9;
        if (r13 == '\"') goto L9;
    L10:
        r11.append(r13);
        r12 = r12 + 1;
    L9:
        r11.append(TokenParser.ESCAPE);
        goto L10
    L11:
        r11.append(TokenParser.DQUOTE);
        return r11.toString();
    }

    private static String normalizeParameterValue(String r10, String r11) {
        if (CHARSET_ATTRIBUTE.equals(r10) == true) goto L5;
        return r11;
    L5:
        return Ascii.toLowerCase(r11);
    }

    private static String normalizeToken(String r10) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(r10));
        return Ascii.toLowerCase(r10);
    }

    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new AnonymousClass1(this));
    }

    public static MediaType parse(String r10) {
        Preconditions.checkNotNull(r10);
        Tokenizer r11 = new Tokenizer(r10);
        CharMatcher r12 = TOKEN_MATCHER;     // Catch: IllegalStateException -> L14
        String r13 = r11.consumeToken(r12);     // Catch: IllegalStateException -> L14
        r11.consumeCharacter('/');     // Catch: IllegalStateException -> L14
        String r14 = r11.consumeToken(r12);     // Catch: IllegalStateException -> L14
        ImmutableListMultimap.Builder r15 = ImmutableListMultimap.builder();     // Catch: IllegalStateException -> L14
    L5:
        if (r11.hasMore() == false) goto L20;
        CharMatcher r16 = LINEAR_WHITE_SPACE;     // Catch: IllegalStateException -> L14
        r11.consumeTokenIfPresent(r16);     // Catch: IllegalStateException -> L14
        r11.consumeCharacter(';');     // Catch: IllegalStateException -> L14
        r11.consumeTokenIfPresent(r16);     // Catch: IllegalStateException -> L14
        CharMatcher r17 = TOKEN_MATCHER;     // Catch: IllegalStateException -> L14
        String r18 = r11.consumeToken(r17);     // Catch: IllegalStateException -> L14
        r11.consumeCharacter('=');     // Catch: IllegalStateException -> L14
        if ('\"' != r11.previewChar()) goto L18;
        r11.consumeCharacter(TokenParser.DQUOTE);     // Catch: IllegalStateException -> L14
        StringBuilder r19 = new StringBuilder();     // Catch: IllegalStateException -> L14
    L10:
        if ('\"' == r11.previewChar()) goto L17;
        if ('\\' == r11.previewChar()) goto L13;
        r19.append(r11.consumeToken(QUOTED_TEXT_MATCHER));     // Catch: IllegalStateException -> L14
        goto L10
    L13:
        r11.consumeCharacter(TokenParser.ESCAPE);     // Catch: IllegalStateException -> L14
        r19.append(r11.consumeCharacter(CharMatcher.ascii()));     // Catch: IllegalStateException -> L14
        goto L10
    L17:
        String r20 = r19.toString();     // Catch: IllegalStateException -> L14
        r11.consumeCharacter(TokenParser.DQUOTE);     // Catch: IllegalStateException -> L14
    L19:
        r15.put(r18, r20);     // Catch: IllegalStateException -> L14
        goto L5
    L18:
        r20 = r11.consumeToken(r17);     // Catch: IllegalStateException -> L14
        goto L19
    L20:
        return create(r13, r14, r15.build());
    L14:
        e = move-exception;
        throw new IllegalArgumentException("Could not parse '" + r10 + "'", e);
    }

    public Optional<Charset> charset() {
        Optional<Charset> r10 = this.parsedCharset;
        if (r10 != null) goto L16;
        r10 = Optional.absent();
        UnmodifiableIterator<String> r11 = this.parameters.get(CHARSET_ATTRIBUTE).iterator();
        String r12 = null;
    L6:
        if (r11.hasNext() == false) goto L15;
        String r13 = r11.next();
        if (r12 == null) goto L9;
        if (r12.equals(r13) == true) goto L6;
        throw new IllegalStateException("Multiple charset values defined: " + r12 + ", " + r13);
    L9:
        r10 = Optional.of(Charset.forName(r13));
        r12 = r13;
        goto L6
    L15:
        this.parsedCharset = r10;
    L16:
        return r10;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof MediaType) == false) goto L16;
        MediaType r11 = (MediaType) r10;
        if (this.type.equals(r11.type) == false) goto L15;
        if (this.subtype.equals(r11.subtype) == false) goto L15;
        if (parametersAsMap().equals(r11.parametersAsMap()) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public boolean hasWildcard() {
        if (WILDCARD.equals(this.type) == false) goto L5;
    L8:
        return true;
    L5:
        if (WILDCARD.equals(this.subtype) == true) goto L8;
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = Objects.hashCode(new Object[]{this.type, this.subtype, parametersAsMap()});
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    public boolean is(MediaType r10) {
        if (r10.type.equals(WILDCARD) == true) goto L7;
        if (r10.type.equals(this.type) == true) goto L7;
    L13:
        return false;
    L7:
        if (r10.subtype.equals(WILDCARD) == true) goto L11;
        if (r10.subtype.equals(this.subtype) == false) goto L13;
    L11:
        if (this.parameters.entries().containsAll(r10.parameters.entries()) == false) goto L13;
        return true;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    public String subtype() {
        return this.subtype;
    }

    public String toString() {
        String r10 = this.toString;
        if (r10 != null) goto L6;
        String r11 = computeToString();
        this.toString = r11;
        return r11;
    L6:
        return r10;
    }

    public String type() {
        return this.type;
    }

    public MediaType withCharset(Charset r10) {
        Preconditions.checkNotNull(r10);
        MediaType r11 = withParameter(CHARSET_ATTRIBUTE, r10.name());
        r11.parsedCharset = Optional.of(r10);
        return r11;
    }

    public MediaType withParameter(String r10, String r11) {
        return withParameters(r10, ImmutableSet.of(r11));
    }

    public MediaType withParameters(Multimap<String, String> r10) {
        return create(this.type, this.subtype, r10);
    }

    public MediaType withoutParameters() {
        if (this.parameters.isEmpty() == false) goto L6;
        return this;
    L6:
        return create(this.type, this.subtype);
    }

    public MediaType withParameters(String r10, Iterable<String> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        String r12 = normalizeToken(r10);
        ImmutableListMultimap.Builder r13 = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> r14 = this.parameters.entries().iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Map.Entry<String, String> r15 = r14.next();
        String r16 = r15.getKey();
        if (r12.equals(r16) == true) goto L4;
        r13.put(r16, r15.getValue());
        goto L4
    L8:
        Iterator<String> r17 = r11.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        r13.put(r12, normalizeParameterValue(r12, r17.next()));
        goto L10
    L12:
        MediaType r18 = new MediaType(this.type, this.subtype, r13.build());
        if (r12.equals(CHARSET_ATTRIBUTE) == true) goto L16;
        r18.parsedCharset = this.parsedCharset;
    L16:
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(r18), r18);
    }

    private static MediaType create(String r10, String r11, Multimap<String, String> r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r12);
        String r13 = normalizeToken(r10);
        String r14 = normalizeToken(r11);
        if (WILDCARD.equals(r13) == true) goto L5;
    L8:
        boolean r15 = true;
    L9:
        Preconditions.checkArgument(r15, "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder r16 = ImmutableListMultimap.builder();
        Iterator<Map.Entry<String, String>> r17 = r12.entries().iterator();
    L11:
        if (r17.hasNext() == false) goto L13;
        Map.Entry<String, String> r18 = r17.next();
        String r19 = normalizeToken(r18.getKey());
        r16.put(r19, normalizeParameterValue(r19, r18.getValue()));
        goto L11
    L13:
        MediaType r20 = new MediaType(r13, r14, r16.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(r20), r20);
    L5:
        if (WILDCARD.equals(r14) == true) goto L8;
        r15 = false;
        goto L9
    }
}
