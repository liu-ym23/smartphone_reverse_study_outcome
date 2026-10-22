package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class BasicHeaderValueFormatter implements HeaderValueFormatter {

    @Deprecated
    public static final BasicHeaderValueFormatter DEFAULT = null;
    public static final BasicHeaderValueFormatter INSTANCE = null;
    public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
    public static final String UNSAFE_CHARS = "\"\\";

    static {
        DEFAULT = new BasicHeaderValueFormatter();
        INSTANCE = new BasicHeaderValueFormatter();
    }

    public BasicHeaderValueFormatter() {
    }

    public static String formatElements(HeaderElement[] r10, boolean r11, HeaderValueFormatter r12) {
        if (r12 != null) goto L6;
        r12 = INSTANCE;
    L6:
        return r12.formatElements(null, r10, r11).toString();
    }

    public static String formatHeaderElement(HeaderElement r10, boolean r11, HeaderValueFormatter r12) {
        if (r12 != null) goto L6;
        r12 = INSTANCE;
    L6:
        return r12.formatHeaderElement(null, r10, r11).toString();
    }

    public static String formatNameValuePair(NameValuePair r10, boolean r11, HeaderValueFormatter r12) {
        if (r12 != null) goto L6;
        r12 = INSTANCE;
    L6:
        return r12.formatNameValuePair(null, r10, r11).toString();
    }

    public static String formatParameters(NameValuePair[] r10, boolean r11, HeaderValueFormatter r12) {
        if (r12 != null) goto L6;
        r12 = INSTANCE;
    L6:
        return r12.formatParameters(null, r10, r11).toString();
    }

    public void doFormatValue(CharArrayBuffer r10, String r11, boolean r12) {
        int r13 = 0;
        if (r12 == true) goto L10;
        int r14 = 0;
    L6:
        if (r14 >= r11.length()) goto L10;
        if (r12 == true) goto L10;
        r12 = isSeparator(r11.charAt(r14));
        r14 = r14 + 1;
    L10:
        if (r12 == false) goto L13;
        r10.append(TokenParser.DQUOTE);
    L13:
        if (r13 >= r11.length()) goto L18;
        char r15 = r11.charAt(r13);
        if (isUnsafe(r15) == false) goto L17;
        r10.append(TokenParser.ESCAPE);
    L17:
        r10.append(r15);
        r13 = r13 + 1;
        goto L13
    L18:
        if (r12 == false) goto L27;
        r10.append(TokenParser.DQUOTE);
        return;
    }

    public int estimateElementsLen(HeaderElement[] r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r10.length < 1) goto L11;
        int r12 = (r10.length - 1) * 2;
        int r13 = r10.length;
    L8:
        if (r11 >= r13) goto L10;
        r12 = r12 + estimateHeaderElementLen(r10[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        return r12;
    }

    public int estimateHeaderElementLen(HeaderElement r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r12 = r10.getName().length();
        String r13 = r10.getValue();
        if (r13 == null) goto L8;
        r12 = r12 + (r13.length() + 3);
    L8:
        int r14 = r10.getParameterCount();
        if (r14 <= 0) goto L12;
    L10:
        if (r11 >= r14) goto L12;
        r12 = r12 + (estimateNameValuePairLen(r10.getParameter(r11)) + 2);
        r11 = r11 + 1;
    L12:
        return r12;
    }

    public int estimateNameValuePairLen(NameValuePair r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getName().length();
        String r12 = r10.getValue();
        if (r12 != null) goto L8;
        return r11;
    L8:
        return r11 + (r12.length() + 3);
    }

    public int estimateParametersLen(NameValuePair[] r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L11:
        return 0;
    L5:
        if (r10.length < 1) goto L11;
        int r12 = (r10.length - 1) * 2;
        int r13 = r10.length;
    L8:
        if (r11 >= r13) goto L10;
        r12 = r12 + estimateNameValuePairLen(r10[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        return r12;
    }

    public boolean isSeparator(char r10) {
        if (SEPARATORS.indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnsafe(char r10) {
        if (UNSAFE_CHARS.indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatElements(CharArrayBuffer r10, HeaderElement[] r11, boolean r12) {
        Args.notNull(r11, "Header element array");
        int r13 = estimateElementsLen(r11);
        if (r10 != null) goto L5;
        r10 = new CharArrayBuffer(r13);
    L6:
        int r14 = 0;
    L8:
        if (r14 >= r11.length) goto L12;
        if (r14 <= 0) goto L11;
        r10.append(", ");
    L11:
        formatHeaderElement(r10, r11[r14], r12);
        r14 = r14 + 1;
        goto L8
    L12:
        return r10;
    L5:
        r10.ensureCapacity(r13);
        goto L6
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer r10, HeaderElement r11, boolean r12) {
        Args.notNull(r11, "Header element");
        int r13 = estimateHeaderElementLen(r11);
        if (r10 != null) goto L5;
        r10 = new CharArrayBuffer(r13);
    L6:
        r10.append(r11.getName());
        String r14 = r11.getValue();
        if (r14 == null) goto L9;
        r10.append('=');
        doFormatValue(r10, r14, r12);
    L9:
        int r15 = r11.getParameterCount();
        if (r15 <= 0) goto L14;
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L14;
        r10.append("; ");
        formatNameValuePair(r10, r11.getParameter(r16), r12);
        r16 = r16 + 1;
    L14:
        return r10;
    L5:
        r10.ensureCapacity(r13);
        goto L6
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer r10, NameValuePair r11, boolean r12) {
        Args.notNull(r11, "Name / value pair");
        int r13 = estimateNameValuePairLen(r11);
        if (r10 != null) goto L5;
        r10 = new CharArrayBuffer(r13);
    L6:
        r10.append(r11.getName());
        String r14 = r11.getValue();
        if (r14 == null) goto L9;
        r10.append('=');
        doFormatValue(r10, r14, r12);
    L9:
        return r10;
    L5:
        r10.ensureCapacity(r13);
        goto L6
    }

    @Override // org.apache.http.message.HeaderValueFormatter
    public CharArrayBuffer formatParameters(CharArrayBuffer r10, NameValuePair[] r11, boolean r12) {
        Args.notNull(r11, "Header parameter array");
        int r13 = estimateParametersLen(r11);
        if (r10 != null) goto L5;
        r10 = new CharArrayBuffer(r13);
    L6:
        int r14 = 0;
    L8:
        if (r14 >= r11.length) goto L12;
        if (r14 <= 0) goto L11;
        r10.append("; ");
    L11:
        formatNameValuePair(r10, r11[r14], r12);
        r14 = r14 + 1;
        goto L8
    L12:
        return r10;
    L5:
        r10.ensureCapacity(r13);
        goto L6
    }
}
