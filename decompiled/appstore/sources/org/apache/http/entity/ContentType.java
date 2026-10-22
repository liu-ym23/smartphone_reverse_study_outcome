package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML = null;
    public static final ContentType APPLICATION_FORM_URLENCODED = null;
    public static final ContentType APPLICATION_JSON = null;
    public static final ContentType APPLICATION_OCTET_STREAM = null;
    public static final ContentType APPLICATION_SVG_XML = null;
    public static final ContentType APPLICATION_XHTML_XML = null;
    public static final ContentType APPLICATION_XML = null;
    private static final Map<String, ContentType> CONTENT_TYPE_MAP = null;
    public static final ContentType DEFAULT_BINARY = null;
    public static final ContentType DEFAULT_TEXT = null;
    public static final ContentType IMAGE_BMP = null;
    public static final ContentType IMAGE_GIF = null;
    public static final ContentType IMAGE_JPEG = null;
    public static final ContentType IMAGE_PNG = null;
    public static final ContentType IMAGE_SVG = null;
    public static final ContentType IMAGE_TIFF = null;
    public static final ContentType IMAGE_WEBP = null;
    public static final ContentType MULTIPART_FORM_DATA = null;
    public static final ContentType TEXT_HTML = null;
    public static final ContentType TEXT_PLAIN = null;
    public static final ContentType TEXT_XML = null;
    public static final ContentType WILDCARD = null;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        Charset r10 = Consts.ISO_8859_1;
        ContentType r11 = create("application/atom+xml", r10);
        APPLICATION_ATOM_XML = r11;
        ContentType r12 = create("application/x-www-form-urlencoded", r10);
        APPLICATION_FORM_URLENCODED = r12;
        ContentType r13 = create("application/json", Consts.UTF_8);
        APPLICATION_JSON = r13;
        APPLICATION_OCTET_STREAM = create("application/octet-stream", null);
        ContentType r14 = create("application/svg+xml", r10);
        APPLICATION_SVG_XML = r14;
        ContentType r15 = create("application/xhtml+xml", r10);
        APPLICATION_XHTML_XML = r15;
        ContentType r16 = create("application/xml", r10);
        APPLICATION_XML = r16;
        ContentType r17 = create("image/bmp");
        IMAGE_BMP = r17;
        ContentType r18 = create("image/gif");
        IMAGE_GIF = r18;
        ContentType r19 = create("image/jpeg");
        IMAGE_JPEG = r19;
        ContentType r20 = create("image/png");
        IMAGE_PNG = r20;
        ContentType r21 = create("image/svg+xml");
        IMAGE_SVG = r21;
        ContentType r22 = create("image/tiff");
        IMAGE_TIFF = r22;
        ContentType r23 = create("image/webp");
        IMAGE_WEBP = r23;
        ContentType r24 = create("multipart/form-data", r10);
        MULTIPART_FORM_DATA = r24;
        ContentType r25 = create("text/html", r10);
        TEXT_HTML = r25;
        ContentType r26 = create(HTTP.PLAIN_TEXT_TYPE, r10);
        TEXT_PLAIN = r26;
        ContentType r27 = create("text/xml", r10);
        TEXT_XML = r27;
        WILDCARD = create("*/*", null);
        ContentType[] r28 = {r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
        HashMap r29 = new HashMap();
        int r30 = 0;
    L4:
        if (r30 >= 17) goto L6;
        ContentType r31 = r28[r30];
        r29.put(r31.getMimeType(), r31);
        r30 = r30 + 1;
        goto L4
    L6:
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(r29);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    public ContentType(String r10, Charset r11) {
        this.mimeType = r10;
        this.charset = r11;
        this.params = null;
    }

    public static ContentType create(String r10, Charset r11) {
        String r12 = ((String) Args.notBlank(r10, "MIME type")).toLowerCase(Locale.ROOT);
        Args.check(valid(r12), "MIME type may not contain reserved characters");
        return new ContentType(r12, r11);
    }

    public static ContentType get(HttpEntity r10) throws ParseException, UnsupportedCharsetException {
        if (r10 != null) goto L5;
        return null;
    L5:
        Header r11 = r10.getContentType();
        if (r11 == null) goto L11;
        HeaderElement[] r12 = r11.getElements();
        if (r12.length <= 0) goto L11;
        return create(r12[0], true);
    L11:
        return null;
    }

    public static ContentType getByMimeType(String r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return CONTENT_TYPE_MAP.get(r10);
    }

    public static ContentType getLenient(HttpEntity r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Header r11 = r10.getContentType();
        if (r11 != null) goto L13;
    L11:
        return null;
    L13:
        HeaderElement[] r12 = r11.getElements();     // Catch: ParseException -> L12
        if (r12.length <= 0) goto L11;
        return create(r12[0], false);
    }

    public static ContentType getLenientOrDefault(HttpEntity r10) throws ParseException, UnsupportedCharsetException {
        ContentType r11 = get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return DEFAULT_TEXT;
    }

    public static ContentType getOrDefault(HttpEntity r10) throws ParseException, UnsupportedCharsetException {
        ContentType r11 = get(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return DEFAULT_TEXT;
    }

    public static ContentType parse(String r10) throws ParseException, UnsupportedCharsetException {
        Args.notNull(r10, "Content type");
        CharArrayBuffer r11 = new CharArrayBuffer(r10.length());
        r11.append(r10);
        HeaderElement[] r12 = BasicHeaderValueParser.INSTANCE.parseElements(r11, new ParserCursor(0, r10.length()));
        if (r12.length <= 0) goto L7;
        return create(r12[0], true);
    L7:
        throw new ParseException("Invalid content type: " + r10);
    }

    private static boolean valid(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L14;
        char r12 = r10.charAt(r11);
        if (r12 == '\"') goto L13;
        if (r12 == ',') goto L13;
        if (r12 == ';') goto L13;
        r11 = r11 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getParameter(String r10) {
        Args.notEmpty(r10, "Parameter name");
        NameValuePair[] r11 = this.params;
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = r11.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L12;
        NameValuePair r14 = r11[r13];
        if (r14.getName().equalsIgnoreCase(r10) == true) goto L10;
        r13 = r13 + 1;
        goto L6
    L10:
        return r14.getValue();
    L12:
        return null;
    }

    public String toString() {
        CharArrayBuffer r10 = new CharArrayBuffer(64);
        r10.append(this.mimeType);
        if (this.params == null) goto L6;
        r10.append("; ");
        BasicHeaderValueFormatter.INSTANCE.formatParameters(r10, this.params, false);
    L9:
        return r10.toString();
    L6:
        if (this.charset == null) goto L9;
        r10.append(HTTP.CHARSET_PARAM);
        r10.append(this.charset.name());
        goto L9
    }

    public ContentType withCharset(Charset r10) {
        return create(getMimeType(), r10);
    }

    public ContentType withParameters(NameValuePair... r10) throws UnsupportedCharsetException {
        if (r10.length != 0) goto L5;
        return this;
    L5:
        LinkedHashMap r11 = new LinkedHashMap();
        NameValuePair[] r12 = this.params;
        int r13 = 0;
        if (r12 == null) goto L10;
        int r14 = r12.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L10;
        NameValuePair r16 = r12[r15];
        r11.put(r16.getName(), r16.getValue());
        r15 = r15 + 1;
    L10:
        int r17 = r10.length;
    L11:
        if (r13 >= r17) goto L13;
        NameValuePair r18 = r10[r13];
        r11.put(r18.getName(), r18.getValue());
        r13 = r13 + 1;
        goto L11
    L13:
        ArrayList r19 = new ArrayList(r11.size() + 1);
        if (this.charset != null) goto L16;
    L18:
        Iterator r20 = r11.entrySet().iterator();
    L20:
        if (r20.hasNext() == false) goto L23;
        Map.Entry r21 = (Map.Entry) r20.next();
        r19.add(new BasicNameValuePair((String) r21.getKey(), (String) r21.getValue()));
        goto L20
    L23:
        return create(getMimeType(), (NameValuePair[]) r19.toArray(new NameValuePair[r19.size()]), true);
    L16:
        if (r11.containsKey("charset") == true) goto L18;
        r19.add(new BasicNameValuePair("charset", this.charset.name()));
        goto L18
    }

    public ContentType withCharset(String r10) {
        return create(getMimeType(), r10);
    }

    public static ContentType create(String r10) {
        return create(r10, null);
    }

    public ContentType(String r10, Charset r11, NameValuePair[] r12) {
        this.mimeType = r10;
        this.charset = r11;
        this.params = r12;
    }

    public static ContentType create(String r10, String r11) throws UnsupportedCharsetException {
        if (TextUtils.isBlank(r11) == true) goto L5;
        Charset r12 = Charset.forName(r11);
    L7:
        return create(r10, r12);
    L5:
        r12 = null;
        goto L7
    }

    private static ContentType create(HeaderElement r10, boolean r11) {
        return create(r10.getName(), r10.getParameters(), r11);
    }

    private static ContentType create(String r10, NameValuePair[] r11, boolean r12) {
        int r13 = r11.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L16;
        NameValuePair r15 = r11[r14];
        if (r15.getName().equalsIgnoreCase("charset") == true) goto L7;
        r14 = r14 + 1;
        goto L4
    L7:
        String r16 = r15.getValue();
        if (TextUtils.isBlank(r16) == true) goto L16;
        Charset r17 = Charset.forName(r16);     // Catch: UnsupportedCharsetException -> L11
    L18:
        if (r11.length > 0) goto L22;
        r11 = null;
    L22:
        return new ContentType(r10, r17, r11);
    L11:
        e = move-exception;
        if (r12 == false) goto L16;
        throw e;
    L16:
        r17 = null;
        goto L18
    }

    public static ContentType create(String r10, NameValuePair... r11) throws UnsupportedCharsetException {
        Args.check(valid(((String) Args.notBlank(r10, "MIME type")).toLowerCase(Locale.ROOT)), "MIME type may not contain reserved characters");
        return create(r10, r11, true);
    }
}
