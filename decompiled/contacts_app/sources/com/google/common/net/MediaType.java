package com.google.common.net;

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
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.obric.oui.material.MaterialConfigBuilder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaType {
    public static final MediaType ANY_APPLICATION_TYPE = null;
    public static final MediaType ANY_AUDIO_TYPE = null;
    public static final MediaType ANY_IMAGE_TYPE = null;
    public static final MediaType ANY_TEXT_TYPE = null;
    public static final MediaType ANY_TYPE = null;
    public static final MediaType ANY_VIDEO_TYPE = null;
    public static final MediaType APPLE_MOBILE_CONFIG = null;
    public static final MediaType APPLICATION_BINARY = null;
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType APPLICATION_XML_UTF_8 = null;
    public static final MediaType ATOM_UTF_8 = null;
    private static final String AUDIO_TYPE = "audio";
    public static final MediaType BMP = null;
    public static final MediaType BZIP2 = null;
    public static final MediaType CACHE_MANIFEST_UTF_8 = null;
    private static final String CHARSET_ATTRIBUTE = "charset";
    public static final MediaType CRW = null;
    public static final MediaType CSS_UTF_8 = null;
    public static final MediaType CSV_UTF_8 = null;
    public static final MediaType EOT = null;
    public static final MediaType EPUB = null;
    public static final MediaType FORM_DATA = null;
    public static final MediaType GIF = null;
    public static final MediaType GZIP = null;
    public static final MediaType HTML_UTF_8 = null;
    public static final MediaType ICO = null;
    private static final String IMAGE_TYPE = "image";
    public static final MediaType I_CALENDAR_UTF_8 = null;
    public static final MediaType JAVASCRIPT_UTF_8 = null;
    public static final MediaType JPEG = null;
    public static final MediaType JSON_UTF_8 = null;
    public static final MediaType KEY_ARCHIVE = null;
    public static final MediaType KML = null;
    public static final MediaType KMZ = null;
    private static final Map<MediaType, MediaType> KNOWN_TYPES = null;
    private static final CharMatcher LINEAR_WHITE_SPACE = null;
    public static final MediaType MBOX = null;
    public static final MediaType MICROSOFT_EXCEL = null;
    public static final MediaType MICROSOFT_POWERPOINT = null;
    public static final MediaType MICROSOFT_WORD = null;
    public static final MediaType MP4_AUDIO = null;
    public static final MediaType MP4_VIDEO = null;
    public static final MediaType MPEG_AUDIO = null;
    public static final MediaType MPEG_VIDEO = null;
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
    public static final MediaType SVG_UTF_8 = null;
    public static final MediaType TAR = null;
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = null;
    private static final String TEXT_TYPE = "text";
    public static final MediaType TIFF = null;
    private static final CharMatcher TOKEN_MATCHER = null;
    public static final MediaType TSV_UTF_8 = null;
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = null;
    public static final MediaType VCARD_UTF_8 = null;
    private static final String VIDEO_TYPE = "video";
    public static final MediaType WEBM_AUDIO = null;
    public static final MediaType WEBM_VIDEO = null;
    public static final MediaType WEBP = null;
    private static final String WILDCARD = "*";
    public static final MediaType WML_UTF_8 = null;
    public static final MediaType WMV = null;
    public static final MediaType WOFF = null;
    public static final MediaType XHTML_UTF_8 = null;
    public static final MediaType XML_UTF_8 = null;
    public static final MediaType XRD_UTF_8 = null;
    public static final MediaType ZIP = null;
    private final ImmutableListMultimap<String, String> parameters;
    private final String subtype;
    private final String type;

    private static final class Tokenizer {
        final String input;
        int position;

        Tokenizer(String r2) {
            this.position = 0;
            this.input = r2;
        }

        String consumeTokenIfPresent(CharMatcher r3) {
            Preconditions.checkState(hasMore());
            int r0 = this.position;
            this.position = r3.negate().indexIn(this.input, r0);
            if (hasMore() == false) goto L6;
            return this.input.substring(r0, this.position);
        L6:
            return this.input.substring(r0);
        }

        String consumeToken(CharMatcher r2) {
            int r0 = this.position;
            String r3 = consumeTokenIfPresent(r2);
            if (this.position == r0) goto L5;
            boolean r1 = true;
        L6:
            Preconditions.checkState(r1);
            return r3;
        L5:
            r1 = false;
            goto L6
        }

        char consumeCharacter(CharMatcher r2) {
            Preconditions.checkState(hasMore());
            char r0 = previewChar();
            Preconditions.checkState(r2.matches(r0));
            this.position++;
            return r0;
        }

        char consumeCharacter(char r3) {
            Preconditions.checkState(hasMore());
            if (previewChar() != r3) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            this.position++;
            return r3;
        L5:
            r0 = false;
            goto L6
        }

        char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        boolean hasMore() {
            int r0 = this.position;
            if (r0 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r0 >= this.input.length()) goto L7;
            return true;
        }
    }

    static /* synthetic */ CharMatcher access$000() {
        return TOKEN_MATCHER;
    }

    static /* synthetic */ String access$100(String r0) {
        return escapeAndQuote(r0);
    }

    static {
        UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of(CHARSET_ATTRIBUTE, Ascii.toLowerCase(Charsets.UTF_8.name()));
        TOKEN_MATCHER = CharMatcher.ASCII.and(CharMatcher.JAVA_ISO_CONTROL.negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
        QUOTED_TEXT_MATCHER = CharMatcher.ASCII.and(CharMatcher.noneOf("\"\\\r"));
        LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
        KNOWN_TYPES = Maps.newHashMap();
        ANY_TYPE = createConstant("*", "*");
        ANY_TEXT_TYPE = createConstant(TEXT_TYPE, "*");
        ANY_IMAGE_TYPE = createConstant("image", "*");
        ANY_AUDIO_TYPE = createConstant(AUDIO_TYPE, "*");
        ANY_VIDEO_TYPE = createConstant(VIDEO_TYPE, "*");
        ANY_APPLICATION_TYPE = createConstant(APPLICATION_TYPE, "*");
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
        XML_UTF_8 = createConstantUtf8(TEXT_TYPE, MaterialConfigBuilder.SERIALIZATION_FORMAT_XML);
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
        MP4_VIDEO = createConstant(VIDEO_TYPE, "mp4");
        MPEG_VIDEO = createConstant(VIDEO_TYPE, "mpeg");
        OGG_VIDEO = createConstant(VIDEO_TYPE, "ogg");
        QUICKTIME = createConstant(VIDEO_TYPE, "quicktime");
        WEBM_VIDEO = createConstant(VIDEO_TYPE, "webm");
        WMV = createConstant(VIDEO_TYPE, "x-ms-wmv");
        APPLICATION_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, MaterialConfigBuilder.SERIALIZATION_FORMAT_XML);
        ATOM_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "atom+xml");
        BZIP2 = createConstant(APPLICATION_TYPE, "x-bzip2");
        EOT = createConstant(APPLICATION_TYPE, "vnd.ms-fontobject");
        EPUB = createConstant(APPLICATION_TYPE, "epub+zip");
        FORM_DATA = createConstant(APPLICATION_TYPE, "x-www-form-urlencoded");
        KEY_ARCHIVE = createConstant(APPLICATION_TYPE, "pkcs12");
        APPLICATION_BINARY = createConstant(APPLICATION_TYPE, "binary");
        GZIP = createConstant(APPLICATION_TYPE, "x-gzip");
        JAVASCRIPT_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "javascript");
        JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON);
        KML = createConstant(APPLICATION_TYPE, "vnd.google-earth.kml+xml");
        KMZ = createConstant(APPLICATION_TYPE, "vnd.google-earth.kmz");
        MBOX = createConstant(APPLICATION_TYPE, "mbox");
        APPLE_MOBILE_CONFIG = createConstant(APPLICATION_TYPE, "x-apple-aspen-config");
        MICROSOFT_EXCEL = createConstant(APPLICATION_TYPE, "vnd.ms-excel");
        MICROSOFT_POWERPOINT = createConstant(APPLICATION_TYPE, "vnd.ms-powerpoint");
        MICROSOFT_WORD = createConstant(APPLICATION_TYPE, "msword");
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
        TAR = createConstant(APPLICATION_TYPE, "x-tar");
        WOFF = createConstant(APPLICATION_TYPE, "font-woff");
        XHTML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xhtml+xml");
        XRD_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xrd+xml");
        ZIP = createConstant(APPLICATION_TYPE, "zip");
        PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    }

    private static MediaType createConstant(String r2, String r3) {
        return addKnownType(new MediaType(r2, r3, ImmutableListMultimap.of()));
    }

    private static MediaType createConstantUtf8(String r2, String r3) {
        return addKnownType(new MediaType(r2, r3, UTF_8_CONSTANT_PARAMETERS));
    }

    private static MediaType addKnownType(MediaType r1) {
        KNOWN_TYPES.put(r1, r1);
        return r1;
    }

    private MediaType(String r1, String r2, ImmutableListMultimap<String, String> r3) {
        this.type = r1;
        this.subtype = r2;
        this.parameters = r3;
    }

    public String type() {
        return this.type;
    }

    public String subtype() {
        return this.subtype;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new AnonymousClass1(this));
    }

    public Optional<Charset> charset() {
        ImmutableSet r3 = ImmutableSet.copyOf(this.parameters.get(CHARSET_ATTRIBUTE));
        int r0 = r3.size();
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L9;
        return Optional.of(Charset.forName((String) Iterables.getOnlyElement(r3)));
    L9:
        throw new IllegalStateException("Multiple charset values defined: " + r3);
    L11:
        return Optional.absent();
    }

    public MediaType withoutParameters() {
        if (this.parameters.isEmpty() == false) goto L6;
        return this;
    L6:
        return create(this.type, this.subtype);
    }

    public MediaType withParameters(Multimap<String, String> r2) {
        return create(this.type, this.subtype, r2);
    }

    public MediaType withParameter(String r6, String r7) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r7);
        String r8 = normalizeToken(r6);
        ImmutableListMultimap.Builder r0 = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> r1 = this.parameters.entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, String> r2 = r1.next();
        String r3 = r2.getKey();
        if (r8.equals(r3) == true) goto L4;
        r0.put(r3, r2.getValue());
        goto L4
    L8:
        r0.put(r8, normalizeParameterValue(r8, r7));
        MediaType r9 = new MediaType(this.type, this.subtype, r0.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(r9), r9);
    }

    public MediaType withCharset(Charset r2) {
        Preconditions.checkNotNull(r2);
        return withParameter(CHARSET_ATTRIBUTE, r2.name());
    }

    public boolean hasWildcard() {
        if ("*".equals(this.type) == false) goto L5;
    L8:
        return true;
    L5:
        if ("*".equals(this.subtype) == true) goto L8;
        return false;
    }

    public boolean is(MediaType r4) {
        if (r4.type.equals("*") == true) goto L7;
        if (r4.type.equals(this.type) == true) goto L7;
    L13:
        return false;
    L7:
        if (r4.subtype.equals("*") == true) goto L11;
        if (r4.subtype.equals(this.subtype) == false) goto L13;
    L11:
        if (this.parameters.entries().containsAll(r4.parameters.entries()) == false) goto L13;
        return true;
    }

    public static MediaType create(String r1, String r2) {
        return create(r1, r2, ImmutableListMultimap.of());
    }

    static MediaType createApplicationType(String r1) {
        return create(APPLICATION_TYPE, r1);
    }

    static MediaType createAudioType(String r1) {
        return create(AUDIO_TYPE, r1);
    }

    static MediaType createImageType(String r1) {
        return create("image", r1);
    }

    static MediaType createTextType(String r1) {
        return create(TEXT_TYPE, r1);
    }

    static MediaType createVideoType(String r1) {
        return create(VIDEO_TYPE, r1);
    }

    private static MediaType create(String r3, String r4, Multimap<String, String> r5) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r5);
        String r6 = normalizeToken(r3);
        String r7 = normalizeToken(r4);
        if ("*".equals(r6) == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0, "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder r1 = ImmutableListMultimap.builder();
        Iterator<Map.Entry<String, String>> r8 = r5.entries().iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r8.next();
        String r9 = normalizeToken(r2.getKey());
        r1.put(r9, normalizeParameterValue(r9, r2.getValue()));
        goto L11
    L13:
        MediaType r10 = new MediaType(r6, r7, r1.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(r10), r10);
    L5:
        if ("*".equals(r7) == true) goto L8;
        r0 = false;
        goto L9
    }

    private static String normalizeToken(String r1) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(r1));
        return Ascii.toLowerCase(r1);
    }

    private static String normalizeParameterValue(String r1, String r2) {
        if (CHARSET_ATTRIBUTE.equals(r1) == true) goto L5;
        return r2;
    L5:
        return Ascii.toLowerCase(r2);
    }

    public static MediaType parse(String r9) {
        Preconditions.checkNotNull(r9);
        Tokenizer r0 = new Tokenizer(r9);
        CharMatcher r1 = TOKEN_MATCHER;     // Catch: IllegalStateException -> L20
        String r2 = r0.consumeToken(r1);     // Catch: IllegalStateException -> L20
        r0.consumeCharacter('/');     // Catch: IllegalStateException -> L20
        String r3 = r0.consumeToken(r1);     // Catch: IllegalStateException -> L20
        ImmutableListMultimap.Builder r4 = ImmutableListMultimap.builder();     // Catch: IllegalStateException -> L20
    L5:
        if (r0.hasMore() == false) goto L18;
        r0.consumeCharacter(';');     // Catch: IllegalStateException -> L20
        r0.consumeTokenIfPresent(LINEAR_WHITE_SPACE);     // Catch: IllegalStateException -> L20
        CharMatcher r5 = TOKEN_MATCHER;     // Catch: IllegalStateException -> L20
        String r6 = r0.consumeToken(r5);     // Catch: IllegalStateException -> L20
        r0.consumeCharacter('=');     // Catch: IllegalStateException -> L20
        if ('\"' != r0.previewChar()) goto L16;
        r0.consumeCharacter(Typography.quote);     // Catch: IllegalStateException -> L20
        StringBuilder r7 = new StringBuilder();     // Catch: IllegalStateException -> L20
    L10:
        if ('\"' == r0.previewChar()) goto L15;
        if ('\\' == r0.previewChar()) goto L13;
        r7.append(r0.consumeToken(QUOTED_TEXT_MATCHER));     // Catch: IllegalStateException -> L20
        goto L10
    L13:
        r0.consumeCharacter('\\');     // Catch: IllegalStateException -> L20
        r7.append(r0.consumeCharacter(CharMatcher.ASCII));     // Catch: IllegalStateException -> L20
        goto L10
    L15:
        String r8 = r7.toString();     // Catch: IllegalStateException -> L20
        r0.consumeCharacter(Typography.quote);     // Catch: IllegalStateException -> L20
    L17:
        r4.put(r6, r8);     // Catch: IllegalStateException -> L20
        goto L5
    L16:
        r8 = r0.consumeToken(r5);     // Catch: IllegalStateException -> L20
        goto L17
    L18:
        return create(r2, r3, r4.build());
    L20:
        e = move-exception;
        throw new IllegalArgumentException("Could not parse '" + r9 + "'", e);
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaType) == false) goto L16;
        MediaType r6 = (MediaType) r5;
        if (this.type.equals(r6.type) == false) goto L15;
        if (this.subtype.equals(r6.subtype) == false) goto L15;
        if (parametersAsMap().equals(r6.parametersAsMap()) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.type, this.subtype, parametersAsMap()});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.type).append('/').append(this.subtype);
        if (this.parameters.isEmpty() == true) goto L6;
        r0.append("; ");
        ListMultimap r3 = Multimaps.transformValues(this.parameters, new AnonymousClass2(this));
        PARAMETER_JOINER.appendTo(r0, r3.entries());
    L6:
        return r0.toString();
    }

    private static String escapeAndQuote(String r7) {
        StringBuilder r0 = new StringBuilder(r7.length() + 16).append(Typography.quote);
        char[] r8 = r7.toCharArray();
        int r2 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        char r4 = r8[r3];
        if (r4 == '\r') goto L8;
        if (r4 == '\\') goto L8;
        if (r4 == '\"') goto L8;
    L9:
        r0.append(r4);
        r3 = r3 + 1;
    L8:
        r0.append('\\');
        goto L9
    L11:
        return r0.append(Typography.quote).toString();
    }
}
