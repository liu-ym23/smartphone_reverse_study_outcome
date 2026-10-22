package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.contactsdk.loader.ContractKt;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes2.dex */
public class HttpCookie implements Cloneable {
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMATS = null;
    private static final Set<String> RESERVED_NAMES = null;
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = null;
    private static Pattern VALID_IPV4_PATTERN = null;
    private static Pattern VALID_IPV6_PATTERN = null;
    private static final String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
    private static final String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
    private String comment;
    private String commentURL;
    private boolean discard;
    private String domain;
    private boolean httpOnly;
    private long maxAge;
    private final String name;
    private String path;
    private String portList;
    private boolean secure;
    private String value;
    private int version;

    static class CookieParser {
        private static final String ATTRIBUTE_NAME_TERMINATORS = ",;= \t";
        private static final String WHITESPACE = " \t";
        boolean hasExpires;
        boolean hasMaxAge;
        boolean hasVersion;
        private final String input;
        private final String inputLowerCase;
        private int pos;

        CookieParser(String r2) {
            this.pos = 0;
            this.hasExpires = false;
            this.hasMaxAge = false;
            this.hasVersion = false;
            this.input = r2;
            this.inputLowerCase = r2.toLowerCase(Locale.US);
        }

        public List<HttpCookie> parse() {
            ArrayList r0 = new ArrayList(2);
            if (this.inputLowerCase.startsWith("set-cookie2:") == false) goto L6;
            this.pos += 12;
            this.hasVersion = true;
            int r1 = 0;
        L9:
            String r4 = readAttributeName(false);
            if (r4 == null) goto L12;
            if (readEqualsSign() == false) goto L49;
            if (r1 == 0) goto L21;
            String r6 = ";";
        L22:
            HttpCookie r7 = new HttpCookie(r4, readAttributeValue(r6));
            HttpCookie.access$002(r7, r1 ^ 1);
            r0.add(r7);
        L23:
            skipWhitespace();
            if (this.pos == this.input.length()) goto L9;
            if (this.input.charAt(this.pos) == ',') goto L28;
            if (this.input.charAt(this.pos) != ';') goto L32;
            this.pos++;
        L32:
            String r5 = readAttributeName(true);
            if (r5 == null) goto L23;
            if (r1 == 0) goto L37;
        L42:
            String r8 = ";";
        L44:
            if (readEqualsSign() == false) goto L46;
            String r9 = readAttributeValue(r8);
        L47:
            setAttribute(r7, r5, r9);
            goto L23
        L46:
            r9 = null;
            goto L47
        L37:
            if ("expires".equals(r5) == true) goto L42;
            if ("port".equals(r5) == true) goto L42;
            r8 = ";,";
            goto L44
        L28:
            this.pos++;
            goto L9
        L21:
            r6 = ",;";
            goto L22
        L49:
            throw new IllegalArgumentException("Expected '=' after " + r4 + " in " + this.input);
        L12:
            if (r0.isEmpty() == true) goto L15;
            return r0;
        L15:
            throw new IllegalArgumentException("No cookies in " + this.input);
        L6:
            if (this.inputLowerCase.startsWith("set-cookie:") == false) goto L8;
            this.pos += 11;
        L8:
            r1 = 1;
            goto L9
        }

        private void setAttribute(HttpCookie r5, String r6, String r7) {
            if (r6.equals("comment") == false) goto L8;
            if (HttpCookie.access$100(r5) != null) goto L8;
            HttpCookie.access$102(r5, r7);
            return;
        L8:
            if (r6.equals("commenturl") == false) goto L13;
            if (HttpCookie.access$200(r5) != null) goto L13;
            HttpCookie.access$202(r5, r7);
            return;
        L13:
            if (r6.equals("discard") == false) goto L16;
            HttpCookie.access$302(r5, true);
            return;
        L16:
            if (r6.equals(ContractKt.PARAM_ACTION_DOMAIN) == false) goto L26;
            if (HttpCookie.access$400(r5) != null) goto L26;
            if (TextUtils.isEmpty(r7) == false) goto L22;
        L24:
            HttpCookie.access$402(r5, r7);
            return;
        L22:
            if (r7.charAt(0) != '.') goto L24;
            r7 = r7.substring(1);
        L26:
            if (r6.equals("expires") == false) goto L34;
            this.hasExpires = true;
            if (HttpCookie.access$500(r5) != (-1)) goto L70;
            Date r4 = HttpCookie.parseDate(r7);
            if (r4 == null) goto L32;
            HttpCookie.access$600(r5, r4);
            return;
        L32:
            HttpCookie.access$502(r5, 0);
            return;
        L70:
            return;
        L34:
            if (r6.equals("max-age") == false) goto L40;
            long r2 = Long.parseLong(r7);     // Catch: NumberFormatException -> L37
            this.hasMaxAge = true;     // Catch: NumberFormatException -> L37
            HttpCookie.access$502(r5, r2);     // Catch: NumberFormatException -> L37
            return;
        L38:
            throw new IllegalArgumentException("Invalid max-age: " + r7);
        L40:
            if (r6.equals("path") == false) goto L45;
            if (HttpCookie.access$700(r5) != null) goto L45;
            HttpCookie.access$702(r5, r7);
            return;
        L45:
            if (r6.equals("port") == false) goto L53;
            if (HttpCookie.access$800(r5) != null) goto L53;
            if (r7 != null) goto L51;
            r7 = "";
        L51:
            HttpCookie.access$802(r5, r7);
            return;
        L53:
            if (r6.equals("secure") == false) goto L56;
            HttpCookie.access$902(r5, true);
            return;
        L56:
            if (r6.equals("httponly") == false) goto L59;
            HttpCookie.access$1002(r5, true);
            return;
        L59:
            if (r6.equals(GloableSearchConfig.KEY_VERSION) == true) goto L61;
            return;
        L61:
            if (this.hasVersion == true) goto L78;
            HttpCookie.access$002(r5, Integer.parseInt(r7));
            return;
        }

        private String readAttributeName(boolean r3) {
            skipWhitespace();
            int r0 = find(ATTRIBUTE_NAME_TERMINATORS);
            if (r3 == false) goto L5;
            String r4 = this.inputLowerCase;
        L6:
            int r1 = this.pos;
            if (r1 >= r0) goto L9;
            String r5 = r4.substring(r1, r0);
        L10:
            this.pos = r0;
            return r5;
        L9:
            r5 = null;
            goto L10
        L5:
            r4 = this.input;
            goto L6
        }

        private boolean readEqualsSign() {
            skipWhitespace();
            if (this.pos < this.input.length()) goto L5;
            return false;
        L5:
            if (this.input.charAt(this.pos) != '=') goto L10;
            this.pos++;
            return true;
        L10:
            return false;
        }

        private String readAttributeValue(String r3) {
            skipWhitespace();
            int r4 = find(r3);
            String r0 = this.input.substring(this.pos, r4);
            this.pos = r4;
            return r0;
        }

        private int find(String r4) {
            int r0 = this.pos;
        L4:
            if (r0 >= this.input.length()) goto L10;
            if (r4.indexOf(this.input.charAt(r0)) != (-1)) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L10:
            return this.input.length();
        }

        private void skipWhitespace() {
        L3:
            if (this.pos >= this.input.length()) goto L8;
            if (WHITESPACE.indexOf(this.input.charAt(this.pos)) == (-1)) goto L11;
            this.pos++;
            goto L3
        L11:
            return;
        }
    }

    static /* synthetic */ int access$002(HttpCookie r0, int r1) {
        r0.version = r1;
        return r1;
    }

    static /* synthetic */ String access$100(HttpCookie r0) {
        return r0.comment;
    }

    static /* synthetic */ boolean access$1002(HttpCookie r0, boolean r1) {
        r0.httpOnly = r1;
        return r1;
    }

    static /* synthetic */ String access$102(HttpCookie r0, String r1) {
        r0.comment = r1;
        return r1;
    }

    static /* synthetic */ String access$200(HttpCookie r0) {
        return r0.commentURL;
    }

    static /* synthetic */ String access$202(HttpCookie r0, String r1) {
        r0.commentURL = r1;
        return r1;
    }

    static /* synthetic */ boolean access$302(HttpCookie r0, boolean r1) {
        r0.discard = r1;
        return r1;
    }

    static /* synthetic */ String access$400(HttpCookie r0) {
        return r0.domain;
    }

    static /* synthetic */ String access$402(HttpCookie r0, String r1) {
        r0.domain = r1;
        return r1;
    }

    static /* synthetic */ long access$500(HttpCookie r2) {
        return r2.maxAge;
    }

    static /* synthetic */ long access$502(HttpCookie r0, long r1) {
        r0.maxAge = r1;
        return r1;
    }

    static /* synthetic */ void access$600(HttpCookie r0, Date r1) {
        r0.setExpires(r1);
    }

    static /* synthetic */ String access$700(HttpCookie r0) {
        return r0.path;
    }

    static /* synthetic */ String access$702(HttpCookie r0, String r1) {
        r0.path = r1;
        return r1;
    }

    static /* synthetic */ String access$800(HttpCookie r0) {
        return r0.portList;
    }

    static /* synthetic */ String access$802(HttpCookie r0, String r1) {
        r0.portList = r1;
        return r1;
    }

    static /* synthetic */ boolean access$902(HttpCookie r0, boolean r1) {
        r0.secure = r1;
        return r1;
    }

    static {
        HashSet r0 = new HashSet();
        RESERVED_NAMES = r0;
        r0.add("comment");
        r0.add("commenturl");
        r0.add("discard");
        r0.add(ContractKt.PARAM_ACTION_DOMAIN);
        r0.add("expires");
        r0.add("httponly");
        r0.add("max-age");
        r0.add("path");
        r0.add("port");
        r0.add("secure");
        r0.add(GloableSearchConfig.KEY_VERSION);
        VALID_IPV4_PATTERN = null;
        VALID_IPV6_PATTERN = null;
        VALID_IPV4_PATTERN = Pattern.compile(ipv4Pattern, 2);     // Catch: PatternSyntaxException -> L6
        VALID_IPV6_PATTERN = Pattern.compile(ipv6Pattern, 2);     // Catch: PatternSyntaxException -> L6
    L4:
        STANDARD_DATE_FORMAT = new AnonymousClass1();
        BROWSER_COMPATIBLE_DATE_FORMATS = new String[]{"EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
    }

    public static boolean domainMatches(String r6, String r7) {
        if (r6 == null) goto L38;
        if (r7 == null) goto L42;
        String r8 = r7.toLowerCase(Locale.US);
        String r9 = r6.toLowerCase(Locale.US);
        if (r8.equals(r9) == false) goto L14;
        if (isFullyQualifiedDomainName(r8, 0) == false) goto L11;
    L12:
        return true;
    L11:
        if (isIpAddress(r8) == true) goto L12;
    L14:
        if (isFullyQualifiedDomainName(r8, 0) == true) goto L18;
        return r9.equals(".local");
    L18:
        if (r9.length() != (r8.length() + 1)) goto L27;
        if (r9.startsWith(LibrarianImpl.Constants.DOT) == false) goto L27;
        if (r9.endsWith(r8) == false) goto L27;
        if (isFullyQualifiedDomainName(r9, 1) == false) goto L27;
        return true;
    L27:
        if (r8.length() > r9.length()) goto L29;
        return false;
    L29:
        if (r8.endsWith(r9) == true) goto L31;
        return false;
    L31:
        if (r9.startsWith(LibrarianImpl.Constants.DOT) == false) goto L35;
        if (isFullyQualifiedDomainName(r9, 1) == false) goto L35;
    L37:
        return true;
    L35:
        if (r9.equals(".local") == true) goto L37;
        return false;
    L42:
        return false;
    L38:
        return false;
    }

    public static boolean pathMatches(HttpCookie r0, URI r1) {
        return matchablePath(r1.getPath()).startsWith(matchablePath(r0.getPath()));
    }

    public static boolean secureMatches(HttpCookie r0, URI r1) {
        if (r0.getSecure() == true) goto L5;
    L8:
        return true;
    L5:
        if ("https".equalsIgnoreCase(r1.getScheme()) == true) goto L8;
        return false;
    }

    public static boolean portMatches(HttpCookie r1, URI r2) {
        if (r1.getPortlist() != null) goto L7;
        return true;
    L7:
        return Arrays.asList(r1.getPortlist().split(SimContactsConstants.EMAIL_SEP)).contains(Integer.toString(SerializableHttpCookie.getEffectivePort(r2.getScheme(), r2.getPort())));
    }

    private static String matchablePath(String r2) {
        if (r2 != null) goto L6;
        return LibrarianImpl.Constants.SEPARATOR;
    L6:
        if (r2.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L9;
        return r2;
    L9:
        return r2 + LibrarianImpl.Constants.SEPARATOR;
    }

    private static boolean isFullyQualifiedDomainName(String r2, int r3) {
        int r4 = r2.indexOf(46, r3 + 1);
        if (r4 != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (r4 >= (r2.length() - 1)) goto L7;
        return true;
    }

    public static List<HttpCookie> parse(String r1) {
        return new CookieParser(r1).parse();
    }

    public HttpCookie(String r3, String r4) {
        this.maxAge = -1;
        this.version = 0;
        String r0 = r3.trim();
        if (isValidName(r0) == false) goto L7;
        this.name = r0;
        this.value = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid name: " + r3);
    }

    private boolean isValidName(String r5) {
        if (r5.length() != 0) goto L5;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L29;
        int r1 = 0;
    L13:
        if (r1 >= r5.length()) goto L29;
        char r2 = r5.charAt(r1);
        if (r2 < 0) goto L38;
        if (r2 >= 127) goto L39;
        if (r2 == ';') goto L40;
        if (r2 == ',') goto L41;
        if (Character.isWhitespace(r2) == false) goto L27;
        if (r2 == ' ') goto L27;
        return false;
    L27:
        r1 = r1 + 1;
        goto L13
    L41:
        return false;
    L40:
        return false;
    L39:
        return false;
    L38:
        return false;
    L29:
        return r4;
    L5:
        if (r5.startsWith("$") == true) goto L9;
        if (RESERVED_NAMES.contains(r5.toLowerCase(Locale.US)) == true) goto L9;
        r4 = true;
        goto L10
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentURL() {
        return this.commentURL;
    }

    public boolean getDiscard() {
        return this.discard;
    }

    public String getDomain() {
        return this.domain;
    }

    public long getMaxAge() {
        return this.maxAge;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public String getPortlist() {
        return this.portList;
    }

    public boolean getSecure() {
        return this.secure;
    }

    public boolean getHttpOnly() {
        return this.httpOnly;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean hasExpired() {
        long r0 = this.maxAge;
        if (r0 != (-1)) goto L6;
        return false;
    L6:
        if (r0 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void setComment(String r1) {
        this.comment = r1;
    }

    public void setCommentURL(String r1) {
        this.commentURL = r1;
    }

    public void setDiscard(boolean r1) {
        this.discard = r1;
    }

    public void setDomain(String r2) {
        if (r2 != null) goto L4;
        String r3 = null;
    L5:
        this.domain = r3;
        return;
    L4:
        r3 = r2.toLowerCase(Locale.US);
        goto L5
    }

    public void setMaxAge(long r1) {
        this.maxAge = r1;
    }

    private void setExpires(Date r5) {
        this.maxAge = (r5.getTime() - System.currentTimeMillis()) / 1000;
    }

    public void setPath(String r1) {
        this.path = r1;
    }

    public void setPortlist(String r1) {
        this.portList = r1;
    }

    public void setSecure(boolean r1) {
        this.secure = r1;
    }

    public void setHttpOnly(boolean r1) {
        this.httpOnly = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }

    public void setVersion(int r3) {
        if (r3 != 0) goto L4;
    L8:
        this.version = r3;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("Bad version: " + r3);
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new AssertionError();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof HttpCookie) == false) goto L21;
        HttpCookie r6 = (HttpCookie) r5;
        if (this.name.equalsIgnoreCase(r6.getName()) == false) goto L20;
        String r1 = this.domain;
        if (r1 == null) goto L15;
        if (r1.equalsIgnoreCase(r6.domain) == false) goto L20;
    L17:
        if (equals(this.path, r6.path) == false) goto L20;
        return true;
    L15:
        if (r6.domain == null) goto L17;
    L20:
        return false;
    L21:
        return false;
    }

    public int hashCode() {
        int r0 = this.name.toLowerCase(Locale.US).hashCode();
        String r1 = this.domain;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = r0 + r3;
        String r5 = this.path;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.toLowerCase(Locale.US).hashCode();
        goto L6
    }

    public String toString() {
        return this.name + "=" + this.value;
    }

    private void appendAttribute(StringBuilder r1, String r2, String r3) {
        if (r3 == null) goto L6;
        if (r1 == null) goto L7;
        r1.append(";$");
        r1.append(r2);
        r1.append("=\"");
        r1.append(r3);
        r1.append("\"");
        return;
    L7:
        return;
    }

    public static boolean equals(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean isIpAddress(String r2) {
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (VALID_IPV4_PATTERN.matcher(r2).matches() == false) goto L5;
        return true;
    L5:
        if (VALID_IPV6_PATTERN.matcher(r2).matches() == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static Date parseDate(String r6) {
        return STANDARD_DATE_FORMAT.get().parse(r6);
    L4:
        String[] r0 = BROWSER_COMPATIBLE_DATE_FORMATS;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        String r3 = r0[r2];
        return new SimpleDateFormat(r3, Locale.US).parse(r6);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        return null;
    }
}
